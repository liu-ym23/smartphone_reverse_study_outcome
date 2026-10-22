package com.stepos.pps.logpull;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.stepos.pps.PPSApplication;

/* loaded from: classes.dex */
public class LogPullDebugReceiver extends BroadcastReceiver {
    public static final String ACTION_FORCE_CHECK = "com.stepos.pps.logpull.FORCE_CHECK";
    private static final String TAG = "LogPull.Debug";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !ACTION_FORCE_CHECK.equals(intent.getAction())) {
            return;
        }
        String str = Build.TYPE != null ? Build.TYPE : "";
        if (!"userdebug".equals(str) && !"eng".equals(str)) {
            Log.w(TAG, "FORCE_CHECK 仅 userdebug/eng 可用, Build.TYPE=" + str);
            return;
        }
        Log.i(TAG, "收到 FORCE_CHECK 广播");
        PPSApplication pPSApplication = PPSApplication.getInstance();
        if (pPSApplication == null) {
            Log.w(TAG, "PPSApplication 未就绪");
            return;
        }
        LogPullPoller logPullPoller = pPSApplication.getLogPullPoller();
        if (logPullPoller == null) {
            Log.w(TAG, "LogPullPoller 未启动（隐私未同意或 OAID 为空）");
        } else {
            logPullPoller.forceCheck();
        }
    }
}
