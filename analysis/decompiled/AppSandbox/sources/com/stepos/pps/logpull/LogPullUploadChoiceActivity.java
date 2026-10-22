package com.stepos.pps.logpull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class LogPullUploadChoiceActivity extends Activity {
    public static final String ACTION_UPLOAD_CHOICE = "com.stepos.pps.logpull.UPLOAD_CHOICE";
    public static final String DECISION_IDLE = "idle";
    public static final String DECISION_NOW = "now";
    public static final String EXTRA_CONFIG_ID = "config_id";
    public static final String EXTRA_DECISION = "decision";
    private static final String TAG = "LogPull.Choice";
    private boolean decided = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        final long longExtra = getIntent().getLongExtra("config_id", -1L);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(48, 48, 48, 48);
        linearLayout.setBackgroundColor(-1);
        TextView textView = new TextView(this);
        textView.setText("当前为移动数据网络");
        textView.setTextSize(18.0f);
        textView.setTextColor(-13421773);
        textView.setPadding(0, 0, 0, 24);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText("日志回传尚未完成。当前非 Wi‑Fi 网络，继续上传可能产生流量费用，请选择上传方式。");
        textView2.setTextSize(14.0f);
        textView2.setTextColor(-10066330);
        textView2.setPadding(0, 0, 0, 32);
        linearLayout.addView(textView2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(8388613);
        Button button = new Button(this);
        button.setText("闲时上传");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.pps.logpull.LogPullUploadChoiceActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(longExtra, view);
            }
        });
        linearLayout2.addView(button);
        Button button2 = new Button(this);
        button2.setText("立即上传");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.pps.logpull.LogPullUploadChoiceActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(longExtra, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(16);
        linearLayout2.addView(button2, layoutParams);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setGravity(17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(long j, View view) {
        finishWithDecision(j, "idle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(long j, View view) {
        finishWithDecision(j, "now");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Log.i(TAG, "上传方式弹窗返回关闭，保持等待");
        finish();
    }

    private void finishWithDecision(long j, String str) {
        if (this.decided) {
            return;
        }
        this.decided = true;
        Log.i(TAG, "上传方式选择: configId=" + j + " decision=" + str);
        Intent intent = new Intent(ACTION_UPLOAD_CHOICE);
        intent.setPackage(getPackageName());
        intent.putExtra("config_id", j);
        intent.putExtra("decision", str);
        sendBroadcast(intent);
        finish();
    }
}
