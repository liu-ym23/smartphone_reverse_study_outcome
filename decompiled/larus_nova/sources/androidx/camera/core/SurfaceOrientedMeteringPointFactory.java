package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import android.util.Size;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceOrientedMeteringPointFactory extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    private static Rational getUseCaseAspectRatio(UseCase r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Size r101 = r100.getAttachedSurfaceResolution();
        if (r101 == null) goto L10;
        return new Rational(r101.getWidth(), r101.getHeight());
    L10:
        throw new IllegalStateException("UseCase " + r100 + " is not bound.");
    }

    public SurfaceOrientedMeteringPointFactory(float r100, float r101) {
        this.mWidth = r100;
        this.mHeight = r101;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    public PointF convertPoint(float r100, float r101) {
        return new PointF(r100 / this.mWidth, r101 / this.mHeight);
    }

    public SurfaceOrientedMeteringPointFactory(float r100, float r101, UseCase r102) {
        super(getUseCaseAspectRatio(r102));
        this.mWidth = r100;
        this.mHeight = r101;
    }
}
