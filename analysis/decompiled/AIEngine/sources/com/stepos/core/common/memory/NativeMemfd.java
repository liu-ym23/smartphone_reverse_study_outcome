package com.stepos.core.common.memory;

import a0.a;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeMemfd {
    public static final NativeMemfd INSTANCE = new NativeMemfd();
    private static final String TAG = "NativeMemfd";
    private static volatile boolean unavailable;

    static {
        try {
            System.loadLibrary("aiengine_crash");
        } catch (UnsatisfiedLinkError e10) {
            unavailable = true;
            a.A("native unavailable: ", e10.getMessage(), TAG);
        }
    }

    private NativeMemfd() {
    }

    private static final native ByteBuffer nativeBufferFor(int i10);

    private static final native void nativeClose(int i10);

    private static final native int nativeCreateWritable(long j10);

    private static final native boolean nativeSeal(int i10);

    public final ByteBuffer bufferFor(int i10) {
        if (unavailable) {
            return null;
        }
        try {
            return nativeBufferFor(i10);
        } catch (UnsatisfiedLinkError unused) {
            unavailable = true;
            return null;
        }
    }

    public final void close(int i10) {
        if (unavailable || i10 < 0) {
            return;
        }
        try {
            nativeClose(i10);
        } catch (UnsatisfiedLinkError unused) {
            unavailable = true;
        }
    }

    public final int createWritable(long j10) {
        if (unavailable) {
            return -1;
        }
        try {
            return nativeCreateWritable(j10);
        } catch (UnsatisfiedLinkError unused) {
            unavailable = true;
            return -1;
        }
    }

    public final boolean isAvailable() {
        if (unavailable) {
            return false;
        }
        try {
            int iNativeCreateWritable = nativeCreateWritable(4096L);
            if (iNativeCreateWritable < 0) {
                return false;
            }
            boolean zNativeSeal = nativeSeal(iNativeCreateWritable);
            nativeClose(iNativeCreateWritable);
            return zNativeSeal;
        } catch (UnsatisfiedLinkError unused) {
            unavailable = true;
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final String pathOf(int i10) {
        return ai.onnxruntime.providers.a.a(i10, "/proc/self/fd/");
    }

    public final boolean seal(int i10) {
        if (unavailable) {
            return false;
        }
        try {
            return nativeSeal(i10);
        } catch (UnsatisfiedLinkError unused) {
            unavailable = true;
            return false;
        }
    }
}
