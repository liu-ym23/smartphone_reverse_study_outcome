package com.android.server.inputmethod;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.pm.Settings;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodDrawsNavBarResourceMonitor {
    private static final String SYSTEM_PACKAGE_NAME = "android";
    private static final String TAG = "InputMethodDrawsNavBarResourceMonitor";

    @FunctionalInterface
    interface OnUpdateCallback {
        void onUpdate(int r1);
    }

    private InputMethodDrawsNavBarResourceMonitor() {
    }

    static boolean evaluate(Context context, int userId) {
        if (context.getUserId() != userId) goto L5;
        Context userAwareContext = context;
    L11:
        return userAwareContext.getPackageManager().getResourcesForApplication("android").getBoolean(R.bool.config_isPreApprovalRequestAvailable);
    L8:
        e = move-exception;
        Slog.e(TAG, "getResourcesForApplication(\"android\") failed", e);
        return false;
    L5:
        userAwareContext = context.createContextAsUser(UserHandle.of(userId), 0);
        goto L11
    }

    static void registerCallback(Context context, Handler ioHandler, final OnUpdateCallback callback) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.OVERLAY_CHANGED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        intentFilter.addDataSchemeSpecificPart("android", 0);
        BroadcastReceiver broadcastReceiver = new AnonymousClass1(callback);
        context.registerReceiverAsUser(broadcastReceiver, UserHandle.ALL, intentFilter, null, ioHandler, 4);
    }
}
