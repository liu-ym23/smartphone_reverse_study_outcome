package com.android.server.biometrics.sensors.fingerprint;

import android.content.Context;
import android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.RemoteException;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class UdfpsHelper {
    private static final String TAG = "UdfpsHelper";

    public UdfpsHelper() {
    }

    public static void onFingerDown(IBiometricsFingerprint daemon, int x, int y, float minor, float major) {
        android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint extension = android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint.castFrom(daemon);
        if (extension != null) goto L11;
        Slog.v(TAG, "onFingerDown | failed to cast the HIDL to V2_3");
        return;
    L11:
        extension.onFingerDown(x, y, minor, major);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "onFingerDown | RemoteException: ", e);
    }

    public static void onFingerUp(IBiometricsFingerprint daemon) {
        android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint extension = android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint.castFrom(daemon);
        if (extension != null) goto L11;
        Slog.v(TAG, "onFingerUp | failed to cast the HIDL to V2_3");
        return;
    L11:
        extension.onFingerUp();     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "onFingerUp | RemoteException: ", e);
    }

    public static boolean isValidAcquisitionMessage(Context context, int acquireInfo, int vendorCode) {
        if (FingerprintManager.getAcquiredString(context, acquireInfo, vendorCode) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
