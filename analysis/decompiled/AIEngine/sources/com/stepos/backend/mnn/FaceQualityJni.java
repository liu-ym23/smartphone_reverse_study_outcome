package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FaceQualityJni {
    public static final FaceQualityJni INSTANCE = new FaceQualityJni();
    private static final String TAG = "FaceQualityJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private FaceQualityJni() {
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
                System.loadLibrary("mnn_aiengine");
                System.loadLibrary("face_quality_mnn");
                loadOk = true;
            } catch (UnsatisfiedLinkError e10) {
                String message = e10.getMessage();
                if (message == null) {
                    message = "loadLibrary face_quality_mnn failed";
                }
                Log.w(TAG, message);
                z = false;
            }
            return z;
        }
    }

    public final native long nativeInit(String str);

    public final native float nativeQuality(long j10, Bitmap bitmap);

    public final native void nativeRelease(long j10);
}
