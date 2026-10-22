package androidx.core.view.animation;

import B7.a;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes2.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = (int) (length / 0.002f);
        int i6 = i + 1;
        this.mX = new float[i6];
        this.mY = new float[i6];
        float[] fArr = new float[2];
        for (int i10 = 0; i10 < i6; i10++) {
            pathMeasure.getPosTan((i10 * length) / i, fArr, null);
            this.mX[i10] = fArr[0];
            this.mY[i10] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f7, float f9, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f7, f9, f10, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f7, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i6 = (i + length) / 2;
            if (f < this.mX[i6]) {
                length = i6;
            } else {
                i = i6;
            }
        }
        float[] fArr = this.mX;
        float f7 = fArr[length];
        float f9 = fArr[i];
        float f10 = f7 - f9;
        if (f10 == 0.0f) {
            return this.mY[i];
        }
        float[] fArr2 = this.mY;
        float f11 = fArr2[i];
        return a.b(fArr2[length], f11, (f - f9) / f10, f11);
    }

    public PathInterpolatorApi14(float f, float f7) {
        this(createQuad(f, f7));
    }

    public PathInterpolatorApi14(float f, float f7, float f9, float f10) {
        this(createCubic(f, f7, f9, f10));
    }
}
