package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.util.Log;
import com.stepos.base.data.InpaintNativeResult;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ImageInpaintAigcQnnJni {
    public static final ImageInpaintAigcQnnJni INSTANCE = new ImageInpaintAigcQnnJni();
    public static final String LIB_NAME = "image_inpaint_aigc_qnn";
    private static final String TAG = "ImageInpaintAigcQnnJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private ImageInpaintAigcQnnJni() {
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

    public final native int nativeInit(String str, String str2, String str3, boolean z);

    public final native InpaintNativeResult nativeInpaint(Bitmap bitmap, Bitmap bitmap2, long j10, boolean z);

    public final native void nativeRelease(boolean z);
}
