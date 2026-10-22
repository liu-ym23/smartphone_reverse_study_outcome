package com.stepos.backend.onnx;

import android.util.Log;
import kotlin.Result;
import kotlin.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TenVadNativeBridge {
    public static final TenVadNativeBridge INSTANCE = new TenVadNativeBridge();
    private static final String TAG = "TenVadNativeBridge";
    private static volatile Throwable loadError;
    private static volatile boolean loaded;

    private TenVadNativeBridge() {
    }

    public static final native long nativeCreate(String str, int i10, float f8);

    public static final native void nativeDestroy(long j10);

    public static final native String nativeGetVersion();

    public static final native float nativeProcess(long j10, short[] sArr, int i10);

    public final boolean ensureLoaded() {
        Object objA;
        if (loaded) {
            return true;
        }
        if (loadError != null) {
            return false;
        }
        synchronized (this) {
            if (loaded) {
                return true;
            }
            if (loadError != null) {
                return false;
            }
            try {
                System.loadLibrary("ten_vad");
                System.loadLibrary("ten_vad_jni");
                try {
                    objA = nativeGetVersion();
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                if (Result.b(objA) != null) {
                    objA = "unknown";
                }
                Log.i(TAG, "ten-vad native libs loaded, version=" + ((String) objA));
                loaded = true;
                return true;
            } catch (Throwable th2) {
                loadError = th2;
                Log.w(TAG, "ten-vad native libs load failed: " + th2.getMessage());
                return false;
            }
        }
    }

    public final Throwable getLastLoadError() {
        return loadError;
    }

    public final boolean isAvailable() {
        return loaded;
    }
}
