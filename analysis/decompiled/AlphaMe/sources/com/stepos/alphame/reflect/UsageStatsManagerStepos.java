package com.stepos.alphame.reflect;

import android.app.usage.SteposAppStatusListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class UsageStatsManagerStepos {
    private static final String TAG = "UsageStatsManagerStepos";
    private static boolean sEnabled;
    private static final List<SteposAppStatusListener> sListeners = new CopyOnWriteArrayList();
    private static BroadcastReceiver sReceiver;

    public static boolean addAppStatusListener(Context context, SteposAppStatusListener steposAppStatusListener) {
        AlphaMeLogger.debugLog("addAppStatusListener = " + steposAppStatusListener);
        if (steposAppStatusListener != null) {
            List<SteposAppStatusListener> list = sListeners;
            if (!list.contains(steposAppStatusListener)) {
                list.add(steposAppStatusListener);
            }
        }
        ensureReceiver(context);
        if (!sEnabled) {
            sEnabled = PerfBinderHelper.enableAppStatusMonitor();
        }
        return sEnabled;
    }

    public static void clearAppStatusListeners(Context context) {
        sListeners.clear();
    }

    private static synchronized void ensureReceiver(Context context) {
        if (sReceiver != null) {
            return;
        }
        sReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.reflect.UsageStatsManagerStepos.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || !PerfBinderHelper.ACTION_APP_STATUS_FORWARD.equals(intent.getAction())) {
                    return;
                }
                String stringExtra = intent.getStringExtra("PACKAGE_NAME");
                int intExtra = intent.getIntExtra(PerfBinderHelper.EXTRA_EVENT_TYPE, -1);
                Iterator it = UsageStatsManagerStepos.sListeners.iterator();
                while (it.hasNext()) {
                    try {
                        ((SteposAppStatusListener) it.next()).onAppStatusChange(stringExtra, intExtra);
                    } catch (Exception e4) {
                        Log.e(UsageStatsManagerStepos.TAG, "listener failed", e4);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PerfBinderHelper.ACTION_APP_STATUS_FORWARD);
        try {
            context.getApplicationContext().registerReceiver(sReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null, 2);
        } catch (Throwable unused) {
            context.getApplicationContext().registerReceiver(sReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null);
        }
    }

    public static void removeAppStatusListener(Context context, SteposAppStatusListener steposAppStatusListener) {
        AlphaMeLogger.debugLog("removeAppStatusListener = " + steposAppStatusListener);
        sListeners.remove(steposAppStatusListener);
    }
}
