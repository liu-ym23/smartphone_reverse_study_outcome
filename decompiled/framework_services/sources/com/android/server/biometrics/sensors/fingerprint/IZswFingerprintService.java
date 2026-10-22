package com.android.server.biometrics.sensors.fingerprint;

import android.mifavor.MFVUtils;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public interface IZswFingerprintService {
    public static final String TAG = "IZswFingerprintService";

    static int fallbackUserId_DoubleApp(int userId, String tag) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return userId;
    L5:
        if (userId != 999) goto L9;
        Slog.d(TAG, "debug_fingerPrint 999 fallback to 0 , tag:" + tag);
        return 0;
    L9:
        return userId;
    }
}
