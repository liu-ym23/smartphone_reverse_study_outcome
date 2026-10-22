package androidx.camera.core;

import android.util.Rational;

/* JADX INFO: loaded from: classes2.dex */
public class MeteringPoint {
    private float mNormalizedX;
    private float mNormalizedY;
    private float mSize;
    private Rational mSurfaceAspectRatio;

    public float getSize() {
        return this.mSize;
    }

    public Rational getSurfaceAspectRatio() {
        return this.mSurfaceAspectRatio;
    }

    public float getX() {
        return this.mNormalizedX;
    }

    public float getY() {
        return this.mNormalizedY;
    }

    public MeteringPoint(float r100, float r101, float r102, Rational r103) {
        this.mNormalizedX = r100;
        this.mNormalizedY = r101;
        this.mSize = r102;
        this.mSurfaceAspectRatio = r103;
    }
}
