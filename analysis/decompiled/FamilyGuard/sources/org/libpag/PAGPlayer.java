package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class PAGPlayer {

    /* renamed from: a, reason: collision with root package name */
    private PAGSurface f19186a = null;
    private long nativeContext = 0;

    static {
        P4.a.a("ffavc");
        P4.a.a("pag");
        nativeInit();
    }

    public PAGPlayer() {
        nativeSetup();
        P4.e.d();
    }

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f5, float f6, float f7, float f8, float f9, float f10);

    private native void nativeSetSurface(long j5);

    private final native void nativeSetup();

    public native boolean cacheEnabled();

    public native float cacheScale();

    public native long currentFrame();

    public native long duration();

    protected void finalize() {
        nativeFinalize();
    }

    public boolean flush() {
        return flushAndFenceSync(null);
    }

    public native boolean flushAndFenceSync(long[] jArr);

    public native RectF getBounds(PAGLayer pAGLayer);

    public native PAGComposition getComposition();

    public native PAGLayer[] getLayersUnderPoint(float f5, float f6);

    public native double getProgress();

    public PAGSurface getSurface() {
        return this.f19186a;
    }

    public native boolean hitTestPoint(PAGLayer pAGLayer, float f5, float f6, boolean z5);

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

    public native void setCacheEnabled(boolean z5);

    public native void setCacheScale(float f5);

    public native void setComposition(PAGComposition pAGComposition);

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setMaxFrameRate(float f5);

    public native void setProgress(double d6);

    public native void setScaleMode(int i5);

    public void setSurface(PAGSurface pAGSurface) {
        this.f19186a = pAGSurface;
        if (pAGSurface == null) {
            nativeSetSurface(0L);
        } else {
            nativeSetSurface(pAGSurface.nativeSurface);
        }
    }

    public native void setVideoEnabled(boolean z5);

    public native boolean videoEnabled();

    public native boolean waitSync(long j5);
}
