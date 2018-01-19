package com.zpj.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.zpj.myapplication2.Main2Activity.this, "选择 www.baidu.com",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.zpj.myapplication2.Main2Activity.this, "获得传进来的值",
                        Toast.LENGTH_SHORT).show();

                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");
                Log.d("Main2Activity", data);

            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.zpj.myapplication2.Main2Activity.this, "返回到上一个活动",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello MainActivity");
                setResult(RESULT_OK, intent);
                finish();

            }
        });


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent= new Intent();
        intent.putExtra("data_return", "Hello aaaaaaaaaaa");
        setResult(RESULT_OK, intent);
        finish();
    }
}
