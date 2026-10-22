package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ImageExtendQnnJni {
    public static final ImageExtendQnnJni INSTANCE = new ImageExtendQnnJni();
    public static final String LIB_NAME = "image_extend_qnn";
    private static final String TAG = "ImageExtendQnnJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private ImageExtendQnnJni() {
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

    public final native int nativeExtendImage(Bitmap bitmap, long j10, int i10, int i11, int i12, int i13, Bitmap bitmap2, boolean z);

    public final native int nativeInit(String str, String str2, String str3, boolean z);

    public final native void nativeRelease(boolean z);
}
