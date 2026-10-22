package com.stepos.alphame.userbehavior;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;

/* loaded from: classes.dex */
public final class UserBehaviorTimeReceiver extends BroadcastReceiver {
    private static final long DEBOUNCE_MS = 500;
    public static final String TAG = "UserBehaviorTimeReceiver";
    private static long sLastHandleUptimeMs;

    public static IntentFilter createIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        return intentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceive$0(String str) {
        try {
            ApplicationImpl application = ApplicationImpl.getApplication();
            if (application != null) {
                application.ensureUserBehaviorInitialized();
            } else {
                UserBehaviorDataSource.getInstance().ensureInitialized();
            }
            UserBehaviorDataSource.getInstance().onSystemTimeChanged(System.currentTimeMillis(), str);
            Log.i(TAG, "onSystemTimeChanged done action=" + str);
        } catch (Throwable th) {
            Log.e(TAG, "handle time change failed action=" + str, th);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        final String action = intent.getAction();
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - sLastHandleUptimeMs < DEBOUNCE_MS) {
            Log.i(TAG, "onReceive debounced action=" + action);
        } else {
            sLastHandleUptimeMs = jUptimeMillis;
            Log.i(TAG, "onReceive action=" + action);
            new Handler(ApplicationImpl.getAlphaMeLooper()).post(new Runnable() { // from class: com.stepos.alphame.userbehavior.b
                @Override // java.lang.Runnable
                public final void run() {
                    UserBehaviorTimeReceiver.lambda$onReceive$0(action);
                }
            });
        }
    }
}
