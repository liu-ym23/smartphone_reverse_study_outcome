package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChineseClipJni {
    public static final ChineseClipJni INSTANCE = new ChineseClipJni();
    private static final String TAG = "ChineseClipJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private ChineseClipJni() {
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
                System.loadLibrary("chineseclip_mnn");
                loadOk = true;
            } catch (UnsatisfiedLinkError e10) {
                String message = e10.getMessage();
                if (message == null) {
                    message = "loadLibrary failed";
                }
                Log.w(TAG, message);
                z = false;
            }
            return z;
        }
    }

    public final native int nativeExtractImageFeature(long j10, Bitmap bitmap, float[] fArr);

    public final native int nativeExtractTextFeature(long j10, String str, float[] fArr);

    public final native long nativeInit(String str, String str2);

    public final native void nativeRelease(long j10);

    public final native int nativeSelectBestImage(long j10, float[] fArr, float[] fArr2, int i10, float[] fArr3);
}
