package com.stepos.pps.logpull;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.pps.PPSApplication;

/* loaded from: classes.dex */
public class LogPullPackStopReceiver extends BroadcastReceiver {
    public static final String ACTION_PACK_STOP = "com.stepos.pps.logpull.PACK_STOP";
    private static final String TAG = "LogPull.PackStop";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !ACTION_PACK_STOP.equals(intent.getAction())) {
            return;
        }
        long longExtra = intent.getLongExtra("config_id", -1L);
        if (longExtra <= 0) {
            Log.w(TAG, "PACK_STOP 缺少 configId");
            return;
        }
        Log.i(TAG, "用户点击停止打包: configId=" + longExtra);
        PPSApplication pPSApplication = PPSApplication.getInstance();
        LogPullPoller logPullPoller = pPSApplication != null ? pPSApplication.getLogPullPoller() : null;
        if (logPullPoller == null) {
            Log.w(TAG, "LogPullPoller 未启动，无法停止 configId=" + longExtra);
            return;
        }
        logPullPoller.onPackStop(longExtra);
    }
}
