package com.stepos.pps.logpull;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.pps.PPSApplication;

/* loaded from: classes.dex */
public class LogPullUserDeleteReceiver extends BroadcastReceiver {
    public static final String ACTION_USER_DELETE = "com.stepos.pps.logpull.USER_DELETE";
    public static final String EXTRA_CONFIG_ID = "config_id";
    public static final String REASON_USER_DELETED_LOGS = "用户删除日志";
    private static final String TAG = "LogPull.UserDelete";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !ACTION_USER_DELETE.equals(intent.getAction())) {
            return;
        }
        long longExtra = intent.getLongExtra("config_id", -1L);
        if (longExtra <= 0) {
            Log.w(TAG, "USER_DELETE 缺少 configId");
            return;
        }
        Log.i(TAG, "收到用户删除: configId=" + longExtra);
        PPSApplication pPSApplication = PPSApplication.getInstance();
        if (pPSApplication == null) {
            Log.w(TAG, "PPSApplication 未就绪");
            return;
        }
        LogPullPoller logPullPoller = pPSApplication.getLogPullPoller();
        if (logPullPoller == null) {
            Log.w(TAG, "LogPullPoller 未启动，仅尽力清理本地目录");
            new LogPullDiskManager().cleanupTask(longExtra);
        } else {
            logPullPoller.onUserDelete(longExtra);
        }
    }
}
