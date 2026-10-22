package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    public MeteringPointFactory() {
        this(null);
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    public abstract PointF convertPoint(float r100, float r101);

    public MeteringPointFactory(Rational r100) {
        this.mSurfaceAspectRatio = r100;
    }

    public void setSurfaceAspectRatio(Rational r100) {
        this.mSurfaceAspectRatio = r100;
    }

    public final MeteringPoint createPoint(float r100, float r101) {
        return createPoint(r100, r101, getDefaultPointSize());
    }

    public final MeteringPoint createPoint(float r100, float r101, float r102) {
        PointF r103 = convertPoint(r100, r101);
        return new MeteringPoint(r103.x, r103.y, r102, this.mSurfaceAspectRatio);
    }
}
