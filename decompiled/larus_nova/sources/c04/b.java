package c04;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f21909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f21910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f21911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f21912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f21913e;

    public static float[] a() {
        return new float[]{0.66f, 0.0f, 0.34f, 1.0f};
    }

    public b() {
        float r100 = a()[0];
        float r101 = a()[1];
        float r102 = a()[2];
        float r103 = a()[3];
        PointF r104 = new PointF(r100, r101);
        PointF r105 = new PointF(r102, r103);
        this.f21911c = new PointF();
        this.f21912d = new PointF();
        this.f21913e = new PointF();
        float r106 = r104.x;
        if (r106 < 0.0f) goto L15;
        if (r106 > 1.0f) goto L15;
        float r107 = r105.x;
        if (r107 < 0.0f) goto L13;
        if (r107 > 1.0f) goto L13;
        this.f21909a = r104;
        this.f21910b = r105;
        return;
    L13:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        int r100 = 1;
        float r101 = r110;
    L4:
        if (r100 >= 14) goto L9;
        PointF r102 = this.f21913e;
        PointF r103 = this.f21909a;
        float r104 = r103.x * 3.0f;
        r102.x = r104;
        PointF r105 = this.f21912d;
        float r106 = ((this.f21910b.x - r103.x) * 3.0f) - r104;
        r105.x = r106;
        PointF r107 = this.f21911c;
        float r108 = (1.0f - r102.x) - r106;
        r107.x = r108;
        float r109 = ((r102.x + ((r105.x + (r108 * r101)) * r101)) * r101) - r110;
        if (Math.abs(r109) < 0.001d) goto L9;
        r101 = r101 - (r109 / (this.f21913e.x + (((this.f21912d.x * 2.0f) + ((this.f21911c.x * 3.0f) * r101)) * r101)));
        r100 = r100 + 1;
    L9:
        PointF r111 = this.f21913e;
        PointF r112 = this.f21909a;
        float r113 = r112.y * 3.0f;
        r111.y = r113;
        PointF r114 = this.f21912d;
        float r115 = ((this.f21910b.y - r112.y) * 3.0f) - r113;
        r114.y = r115;
        PointF r116 = this.f21911c;
        float r117 = (1.0f - r111.y) - r115;
        r116.y = r117;
        return r101 * (r111.y + ((r114.y + (r117 * r101)) * r101));
    }
}
