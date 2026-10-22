package com.stepos.alphame.dailyusage.utils;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.alphame.model.event.DailyUsageMzForegroundWindowModeMessage;
import com.stepos.alphame.model.event.DailyUsageMzWindowModeMessage;
import m3.e;

/* loaded from: classes.dex */
public class WindowModeEventMonitor {
    private static final String TAG = "WindowModeEventMonitor";
    private static BroadcastReceiver sReceiver;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private static Boolean pendingMiniState = null;
    private static Boolean pendingFreedomState = null;
    private static final Runnable processTask = new Runnable() { // from class: com.stepos.alphame.dailyusage.utils.WindowModeEventMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            if (WindowModeEventMonitor.pendingMiniState != null) {
                if (!WindowModeEventMonitor.pendingMiniState.booleanValue() && WindowModeEventMonitor.pendingFreedomState == null) {
                    Log.d(WindowModeEventMonitor.TAG, "Processing Mini: false");
                    e.b().e(new DailyUsageMzForegroundWindowModeMessage(System.currentTimeMillis()));
                }
            } else if (WindowModeEventMonitor.pendingFreedomState != null && !WindowModeEventMonitor.pendingFreedomState.booleanValue()) {
                e.b().e(new DailyUsageMzForegroundWindowModeMessage(System.currentTimeMillis()));
            }
            WindowModeEventMonitor.pendingMiniState = null;
            WindowModeEventMonitor.pendingFreedomState = null;
        }
    };

    private static synchronized void ensureReceiver(Context context) {
        if (sReceiver != null) {
            return;
        }
        sReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.dailyusage.utils.WindowModeEventMonitor.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || !"com.stepos.alphame.ACTION_WINDOW_MODE_FORWARD".equals(intent.getAction())) {
                    return;
                }
                String stringExtra = intent.getStringExtra("EXTRA_CALLBACK");
                boolean z4 = false;
                if ("onWindowModeChanged".equals(stringExtra)) {
                    int intExtra = intent.getIntExtra("EXTRA_WINDOWING_MODE", -1);
                    boolean booleanExtra = intent.getBooleanExtra("EXTRA_WINDOW_MODE_STATE", false);
                    if (intExtra == 11) {
                        WindowModeEventMonitor.pendingMiniState = Boolean.valueOf(booleanExtra);
                        z4 = true;
                    }
                    if (intExtra == 1035) {
                        WindowModeEventMonitor.pendingFreedomState = Boolean.valueOf(booleanExtra);
                    } else if (!z4) {
                        return;
                    }
                    WindowModeEventMonitor.mHandler.removeCallbacks(WindowModeEventMonitor.processTask);
                    WindowModeEventMonitor.mHandler.postDelayed(WindowModeEventMonitor.processTask, 100L);
                    return;
                }
                if ("onStateChanged".equals(stringExtra)) {
                    int intExtra2 = intent.getIntExtra(AlphaMeEventIpc.KEY_DISPLAY_ID, 0);
                    int intExtra3 = intent.getIntExtra("EXTRA_WINDOWING_MODE", -1);
                    int intExtra4 = intent.getIntExtra("EXTRA_TASK_ID", -1);
                    int intExtra5 = intent.getIntExtra("EXTRA_WINDOW_MODE_STATE_INT", -1);
                    StringBuilder sbU = g.u("displayId: ", intExtra2, ", windowingMode: ", intExtra3, ", taskId: ");
                    sbU.append(intExtra4);
                    sbU.append(", windowModeState: ");
                    sbU.append(intExtra5);
                    Log.d(WindowModeEventMonitor.TAG, sbU.toString());
                    e.b().e(new DailyUsageMzWindowModeMessage(System.currentTimeMillis(), intExtra5, intExtra3));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.stepos.alphame.ACTION_WINDOW_MODE_FORWARD");
        try {
            context.getApplicationContext().registerReceiver(sReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null, 2);
        } catch (Throwable unused) {
            context.getApplicationContext().registerReceiver(sReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null);
        }
    }

    public static boolean register(Context context) {
        try {
            ensureReceiver(context);
            return AlphaMeEventIpc.enableWindowModeMonitor();
        } catch (Exception e4) {
            Log.e(TAG, "register failed", e4);
            return false;
        }
    }
}
