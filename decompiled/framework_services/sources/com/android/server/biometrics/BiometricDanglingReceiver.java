package com.android.server.biometrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Slog;
import com.android.server.biometrics.sensors.BiometricNotificationUtils;

/* JADX INFO: loaded from: classes.dex */
public class BiometricDanglingReceiver extends BroadcastReceiver {
    public static final String ACTION_FACE_RE_ENROLL_DISMISS = "action_face_re_enroll_dismiss";
    public static final String ACTION_FACE_RE_ENROLL_LAUNCH = "action_face_re_enroll_launch";
    public static final String ACTION_FINGERPRINT_RE_ENROLL_DISMISS = "action_fingerprint_re_enroll_dismiss";
    public static final String ACTION_FINGERPRINT_RE_ENROLL_LAUNCH = "action_fingerprint_re_enroll_launch";
    public static final String FACE_SETTINGS_ACTION = "android.settings.FACE_SETTINGS";
    private static final String SETTINGS_PACKAGE = "com.android.settings";
    private static final String TAG = "BiometricDanglingReceiver";

    public BiometricDanglingReceiver(Context context, int modality) {
        IntentFilter intentFilter = new IntentFilter();
        if (modality != 1) goto L5;
        intentFilter.addAction(ACTION_FINGERPRINT_RE_ENROLL_LAUNCH);
        intentFilter.addAction(ACTION_FINGERPRINT_RE_ENROLL_DISMISS);
    L7:
        context.registerReceiver(this, intentFilter, 4);
        return;
    L5:
        if (modality != 4) goto L7;
        intentFilter.addAction(ACTION_FACE_RE_ENROLL_LAUNCH);
        intentFilter.addAction(ACTION_FACE_RE_ENROLL_DISMISS);
        goto L7
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Slog.d(TAG, "Received: " + intent.getAction());
        if (ACTION_FINGERPRINT_RE_ENROLL_LAUNCH.equals(intent.getAction()) == false) goto L6;
        launchBiometricEnrollActivity(context, "android.settings.FINGERPRINT_ENROLL");
        BiometricNotificationUtils.cancelFingerprintReEnrollNotification(context);
    L14:
        context.unregisterReceiver(this);
        return;
    L6:
        if (ACTION_FINGERPRINT_RE_ENROLL_DISMISS.equals(intent.getAction()) == false) goto L9;
        BiometricNotificationUtils.cancelFingerprintReEnrollNotification(context);
        goto L14
    L9:
        if (ACTION_FACE_RE_ENROLL_LAUNCH.equals(intent.getAction()) == false) goto L12;
        launchBiometricEnrollActivity(context, FACE_SETTINGS_ACTION);
        BiometricNotificationUtils.cancelFaceReEnrollNotification(context);
        goto L14
    L12:
        if (ACTION_FACE_RE_ENROLL_DISMISS.equals(intent.getAction()) == false) goto L14;
        BiometricNotificationUtils.cancelFaceReEnrollNotification(context);
        goto L14
    }

    private void launchBiometricEnrollActivity(Context context, String action) {
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS").setFlags(268435456));
        Intent intent = new Intent(action);
        intent.setPackage(SETTINGS_PACKAGE);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
