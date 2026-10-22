package org.libpag;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.util.Pair;
import z2.l;

/* loaded from: classes4.dex */
public class PAGDecoder {
    private long nativeContext;

    static {
        l.j("pag");
        nativeInit();
    }

    private PAGDecoder(long j5) {
        this.nativeContext = j5;
    }

    public static PAGDecoder Make(PAGComposition pAGComposition) {
        return Make(pAGComposition, pAGComposition.frameRate(), 1.0f);
    }

    private static native long MakeFrom(PAGComposition pAGComposition, float f, float f7);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean checkFrameChanged(int i);

    public native boolean copyFrameTo(Bitmap bitmap, int i);

    public void finalize() {
        nativeFinalize();
    }

    public Bitmap frameAtIndex(int i) {
        boolean zCopyFrameTo;
        Pair pairA = a.a(width(), height(), false);
        Object obj = pairA.first;
        if (obj == null) {
            return null;
        }
        Object obj2 = pairA.second;
        if (obj2 != null) {
            zCopyFrameTo = readFrame(i, (HardwareBuffer) obj2);
            ((HardwareBuffer) pairA.second).close();
        } else {
            zCopyFrameTo = copyFrameTo((Bitmap) obj, i);
        }
        if (zCopyFrameTo) {
            return (Bitmap) pairA.first;
        }
        return null;
    }

    public native float frameRate();

    public native int height();

    public native int numFrames();

    public native boolean readFrame(int i, HardwareBuffer hardwareBuffer);

    public void release() {
        nativeRelease();
    }

    public native int width();

    public static PAGDecoder Make(PAGComposition pAGComposition, float f, float f7) {
        long jMakeFrom = MakeFrom(pAGComposition, f, f7);
        if (jMakeFrom == 0) {
            return null;
        }
        return new PAGDecoder(jMakeFrom);
    }
}
