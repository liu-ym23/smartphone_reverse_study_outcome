package com.stepos.backend.qnn;

import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RerankingQnnJni {
    public static final RerankingQnnJni INSTANCE = new RerankingQnnJni();
    public static final String LIB_NAME = "reranking_qnn";
    private static final String TAG = "RerankingQnnJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private RerankingQnnJni() {
    }

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
                Log.w(TAG, "loadLibrary(reranking_qnn) failed: " + e10.getMessage());
                z = false;
            }
            return z;
        }
    }

    public final native int nativeInit(String str, String str2, String str3);

    public final native int nativeRelease();

    public final native float[] nativeRerank(String str, String[] strArr);
}
