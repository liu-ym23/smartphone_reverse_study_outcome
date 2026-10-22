package com.stepos.backend.qnn;

import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SmsParseQnnJni {
    public static final SmsParseQnnJni INSTANCE = new SmsParseQnnJni();
    public static final String LIB_NAME = "smsparse_qnn";
    private static final String TAG = "SmsParseQnnJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private SmsParseQnnJni() {
    }

    public static final native boolean nativeChatStream(String str, Object obj);

    public static final native int nativeGetLastInitErrorCode();

    public static final native boolean nativeInitWithGenieJson(String str, String str2, String str3);

    public static final native void nativeRelease();

    public final boolean ensureLoaded() {
        boolean z = true;
        if (loadOk) {
            return true;
        }
        synchronized (this) {
            if (loadOk) {
                return true;
            }
            if (loadAttempted) {
                return false;
            }
            loadAttempted = true;
            try {
                System.loadLibrary(LIB_NAME);
                loadOk = true;
            } catch (UnsatisfiedLinkError e10) {
                Log.w(TAG, "loadLibrary(smsparse_qnn) failed: " + e10.getMessage());
                z = false;
            }
            return z;
        }
    }
}
