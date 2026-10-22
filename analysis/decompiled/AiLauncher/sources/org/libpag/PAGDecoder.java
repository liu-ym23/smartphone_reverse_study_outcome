package org.libpag;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.util.Pair;
import gc.AbstractC4115a;

/* loaded from: classes5.dex */
public class PAGDecoder {
    private long nativeContext;

    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    private PAGDecoder(long j10) {
        this.nativeContext = j10;
    }

    public static PAGDecoder Make(PAGComposition pAGComposition) {
        return Make(pAGComposition, pAGComposition.frameRate(), 1.0f);
    }

    private static native long MakeFrom(PAGComposition pAGComposition, float f10, float f11);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean checkFrameChanged(int i10);

    public native boolean copyFrameTo(Bitmap bitmap, int i10);

    public void finalize() {
        nativeFinalize();
    }

    public Bitmap frameAtIndex(int i10) {
        boolean zCopyFrameTo;
        Pair pairA = a.a(width(), height(), false);
        Object obj = pairA.first;
        if (obj == null) {
            return null;
        }
        Object obj2 = pairA.second;
        if (obj2 != null) {
            zCopyFrameTo = readFrame(i10, (HardwareBuffer) obj2);
            ((HardwareBuffer) pairA.second).close();
        } else {
            zCopyFrameTo = copyFrameTo((Bitmap) obj, i10);
        }
        if (zCopyFrameTo) {
            return (Bitmap) pairA.first;
        }
        return null;
    }

    public native float frameRate();

    public native int height();

    public native int numFrames();

    public native boolean readFrame(int i10, HardwareBuffer hardwareBuffer);

    public void release() {
        nativeRelease();
    }

    public native int width();

    public static PAGDecoder Make(PAGComposition pAGComposition, float f10, float f11) {
        long jMakeFrom = MakeFrom(pAGComposition, f10, f11);
        if (jMakeFrom == 0) {
            return null;
        }
        return new PAGDecoder(jMakeFrom);
    }
}
