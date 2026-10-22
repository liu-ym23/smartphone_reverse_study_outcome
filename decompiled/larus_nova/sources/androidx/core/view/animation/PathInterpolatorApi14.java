package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes17.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path r100) {
        PathMeasure r101 = new PathMeasure(r100, false);
        float r102 = r101.getLength();
        int r103 = ((int) (r102 / 0.002f)) + 1;
        this.mX = new float[r103];
        this.mY = new float[r103];
        float[] r104 = new float[2];
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r101.getPosTan((r105 * r102) / (r103 - 1), r104, null);
        this.mX[r105] = r104[0];
        this.mY[r105] = r104[1];
        r105 = r105 + 1;
        goto L3
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        if (r100 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r101 = this.mX.length - 1;
        int r102 = 0;
    L10:
        if ((r101 - r102) <= 1) goto L15;
        int r103 = (r102 + r101) / 2;
        if (r100 < this.mX[r103]) goto L13;
        r102 = r103;
        goto L10
    L13:
        r101 = r103;
        goto L10
    L15:
        float[] r104 = this.mX;
        float r105 = r104[r101];
        float r106 = r104[r102];
        float r107 = r105 - r106;
        if (r107 == 0.0f) goto L18;
        float r108 = (r100 - r106) / r107;
        float[] r109 = this.mY;
        float r110 = r109[r102];
        return r110 + (r108 * (r109[r101] - r110));
    L18:
        return this.mY[r102];
    }

    public PathInterpolatorApi14(float r100, float r101) {
        this(createQuad(r100, r101));
    }

    private static Path createQuad(float r100, float r101) {
        Path r102 = new Path();
        r102.moveTo(0.0f, 0.0f);
        r102.quadTo(r100, r101, 1.0f, 1.0f);
        return r102;
    }

    public PathInterpolatorApi14(float r100, float r101, float r102, float r103) {
        this(createCubic(r100, r101, r102, r103));
    }

    private static Path createCubic(float r100, float r101, float r110, float r111) {
        Path r102 = new Path();
        r102.moveTo(0.0f, 0.0f);
        r102.cubicTo(r100, r101, r110, r111, 1.0f, 1.0f);
        return r102;
    }
}
