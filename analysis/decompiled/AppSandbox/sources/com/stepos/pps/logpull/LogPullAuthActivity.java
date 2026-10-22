package com.stepos.pps.logpull;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stepos.pps.PPSApplication;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public class LogPullAuthActivity extends Activity {
    public static final String ACTION_AUTH_DISMISS = "com.stepos.pps.logpull.AUTH_DISMISS";
    public static final String ACTION_AUTH_RESULT = "com.stepos.pps.logpull.AUTH_RESULT";
    public static final String DECISION_IDLE = "idle";
    public static final String DECISION_NOW = "now";
    public static final String DECISION_REJECT = "reject";
    public static final String EXTRA_CONFIG_ID = "config_id";
    public static final String EXTRA_DEADLINE = "deadline";
    public static final String EXTRA_DECISION = "decision";
    public static final String EXTRA_END_TIME = "end_time";
    public static final String EXTRA_LOG_TYPES = "log_types";
    public static final String EXTRA_MAX_LIMIT = "max_limit";
    public static final String EXTRA_OAID = "oaid";
    public static final String EXTRA_START_TIME = "start_time";
    private static final String TAG = "LogPull.Auth";
    private BroadcastReceiver dismissReceiver;
    private boolean decided = false;
    private long configId = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        final long longExtra = getIntent().getLongExtra("config_id", -1L);
        this.configId = longExtra;
        registerDismissReceiver();
        String stringExtra = getIntent().getStringExtra(EXTRA_LOG_TYPES);
        String stringExtra2 = getIntent().getStringExtra("start_time");
        String stringExtra3 = getIntent().getStringExtra("end_time");
        String stringExtra4 = getIntent().getStringExtra(EXTRA_DEADLINE);
        long longExtra2 = getIntent().getLongExtra(EXTRA_MAX_LIMIT, 0L);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(48, 48, 48, 48);
        linearLayout.setBackgroundColor(-1);
        TextView textView = new TextView(this);
        textView.setText("申请采集并上传日志");
        textView.setTextSize(18.0f);
        textView.setTextColor(-13421773);
        textView.setPadding(0, 0, 0, 24);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText("「PPS 服务」请求执行远程日志拉取。请选择上报方式，或不同意本次任务。");
        textView2.setTextSize(14.0f);
        textView2.setTextColor(-10066330);
        textView2.setPadding(0, 0, 0, 16);
        linearLayout.addView(textView2);
        addInfoRow(linearLayout, "日志类型", stringExtra);
        addInfoRow(linearLayout, "时间区间", formatTimeRange(stringExtra2, stringExtra3));
        addInfoRow(linearLayout, "大小上限", formatSize(longExtra2));
        if (stringExtra4 != null && !stringExtra4.isEmpty()) {
            addInfoRow(linearLayout, "截止时间", stringExtra4);
        }
        TextView textView3 = new TextView(this);
        textView3.setText("用于远程问题诊断，仅本次任务有效。关闭本窗口后可通过通知栏再次打开。「不同意」将终止本次任务。");
        textView3.setTextSize(12.0f);
        textView3.setTextColor(-6710887);
        textView3.setPadding(0, 24, 0, 32);
        linearLayout.addView(textView3);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(8388613);
        Button button = new Button(this);
        button.setText("不同意");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.pps.logpull.LogPullAuthActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(longExtra, view);
            }
        });
        linearLayout2.addView(button);
        Button button2 = new Button(this);
        button2.setText("闲时上报");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.pps.logpull.LogPullAuthActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(longExtra, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(16);
        linearLayout2.addView(button2, layoutParams);
        Button button3 = new Button(this);
        button3.setText("立即上报");
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.pps.logpull.LogPullAuthActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(longExtra, view);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(16);
        linearLayout2.addView(button3, layoutParams2);
        linearLayout.addView(linearLayout2);
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setGravity(17);
            window.addFlags(524288);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(long j, View view) {
        finishWithDecision(j, DECISION_REJECT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(long j, View view) {
        finishWithDecision(j, "idle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(long j, View view) {
        finishWithDecision(j, "now");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Log.i(TAG, "授权窗返回关闭，不改变任务状态");
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.decided || this.configId < 0) {
            return;
        }
        try {
            PPSApplication pPSApplication = PPSApplication.getInstance();
            LogPullPoller logPullPoller = pPSApplication != null ? pPSApplication.getLogPullPoller() : null;
            if (logPullPoller == null || logPullPoller.isAuthPending(this.configId)) {
                return;
            }
            Log.i(TAG, "onResume 校验：任务已不在授权队列，关闭授权窗 configId=" + this.configId);
            finish();
        } catch (Exception e) {
            Log.w(TAG, "onResume 校验授权任务异常，忽略", e);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.dismissReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            this.dismissReceiver = null;
        }
    }

    private void registerDismissReceiver() {
        this.dismissReceiver = new BroadcastReceiver() { // from class: com.stepos.pps.logpull.LogPullAuthActivity.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                long longExtra = intent.getLongExtra("config_id", -1L);
                if (longExtra == -1 || longExtra == LogPullAuthActivity.this.configId) {
                    Log.i(LogPullAuthActivity.TAG, "收到关闭授权窗信号，finish configId=" + LogPullAuthActivity.this.configId);
                    LogPullAuthActivity.this.finish();
                }
            }
        };
        registerReceiver(this.dismissReceiver, new IntentFilter(ACTION_AUTH_DISMISS), 4);
    }

    public static void sendDismiss(Context context, long j) {
        Intent intent = new Intent(ACTION_AUTH_DISMISS);
        intent.setPackage(context.getPackageName());
        intent.putExtra("config_id", j);
        context.sendBroadcast(intent);
    }

    private void finishWithDecision(long j, String str) {
        if (this.decided) {
            return;
        }
        this.decided = true;
        Log.i(TAG, "用户授权决策: configId=" + j + " decision=" + str);
        Intent intent = new Intent(ACTION_AUTH_RESULT);
        intent.setPackage(getPackageName());
        intent.putExtra("config_id", j);
        intent.putExtra("decision", str);
        sendBroadcast(intent);
        finish();
    }

    private void addInfoRow(LinearLayout linearLayout, String str, String str2) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(0, 8, 0, 8);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(13.0f);
        textView.setTextColor(-7829368);
        textView.setWidth(200);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this);
        if (str2 == null) {
            str2 = "—";
        }
        textView2.setText(str2);
        textView2.setTextSize(13.0f);
        textView2.setTextColor(-13421773);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
    }

    private String formatTimeRange(String str, String str2) {
        if (str == null || str2 == null) {
            return "—";
        }
        return str.replace("T", " ") + " ~ " + str2.replace("T", " ");
    }

    private String formatSize(long j) {
        if (j <= 0) {
            return "—";
        }
        long j2 = (j + 1048575) / 1048576;
        if (j2 >= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return String.format("%.1f GB", Double.valueOf(j2 / 1024.0d));
        }
        return j2 + " MB";
    }
}
