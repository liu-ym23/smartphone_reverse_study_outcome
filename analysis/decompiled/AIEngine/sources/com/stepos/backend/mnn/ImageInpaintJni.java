package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import android.util.Log;
import com.stepos.base.data.InpaintNativeResult;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ImageInpaintJni {
    public static final ImageInpaintJni INSTANCE = new ImageInpaintJni();
    private static final String TAG = "ImageInpaintJni";
    private static volatile boolean loadAttempted;
    private static volatile boolean loadOk;

    private ImageInpaintJni() {
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
                System.loadLibrary("imageinpaint_mnn");
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

    public final native long nativeInit(String str);

    public final native InpaintNativeResult nativeInpaint(long j10, Bitmap bitmap, Bitmap bitmap2);

    public final native void nativeRelease(long j10);
}
