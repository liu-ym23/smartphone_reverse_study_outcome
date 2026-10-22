package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import z2.l;

/* loaded from: classes4.dex */
public class PAGPlayer {

    /* renamed from: a, reason: collision with root package name */
    private PAGSurface f5503a = null;
    private long nativeContext = 0;

    static {
        l.j("ffavc");
        l.j("pag");
        nativeInit();
    }

    public PAGPlayer() {
        nativeSetup();
        org.extra.tools.b.b();
    }

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f, float f7, float f9, float f10, float f11, float f12);

    private native void nativeSetSurface(long j5);

    private final native void nativeSetup();

    public native boolean cacheEnabled();

    public native float cacheScale();

    public native long currentFrame();

    public native long duration();

    public void finalize() {
        nativeFinalize();
    }

    public boolean flush() {
        return flushAndFenceSync(null);
    }

    public native boolean flushAndFenceSync(long[] jArr);

    public native RectF getBounds(PAGLayer pAGLayer);

    public native PAGComposition getComposition();

    public native PAGLayer[] getLayersUnderPoint(float f, float f7);

    public native double getProgress();

    public PAGSurface getSurface() {
        return this.f5503a;
    }

    public native boolean hitTestPoint(PAGLayer pAGLayer, float f, float f7, boolean z10);

    public Matrix matrix() {
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native float maxFrameRate();

    public native void prepare();

    public void release() {
        nativeRelease();
    }

    public native int scaleMode();

    public native void setCacheEnabled(boolean z10);

    public native void setCacheScale(float f);

    public native void setComposition(PAGComposition pAGComposition);

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setMaxFrameRate(float f);

    public native void setProgress(double d);

    public native void setScaleMode(int i);

    public void setSurface(PAGSurface pAGSurface) {
        this.f5503a = pAGSurface;
        if (pAGSurface == null) {
            nativeSetSurface(0L);
        } else {
            nativeSetSurface(pAGSurface.nativeSurface);
        }
    }

    public native void setUseDiskCache(boolean z10);

    public native void setVideoEnabled(boolean z10);

    public native boolean useDiskCache();

    public native boolean videoEnabled();

    public native boolean waitSync(long j5);
}
