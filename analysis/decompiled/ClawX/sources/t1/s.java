package t1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends u {

    /* renamed from: h, reason: collision with root package name */
    public static final RectF f5534h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f5535b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5536c;
    public final float d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5537e;

    /* renamed from: f, reason: collision with root package name */
    public float f5538f;

    /* renamed from: g, reason: collision with root package name */
    public float f5539g;

    public s(float f3, float f7, float f9, float f10) {
        this.f5535b = f3;
        this.f5536c = f7;
        this.d = f9;
        this.f5537e = f10;
    }

    @Override // t1.u
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f5542a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f3 = this.d;
        float f7 = this.f5537e;
        RectF rectF = f5534h;
        rectF.set(this.f5535b, this.f5536c, f3, f7);
        path.arcTo(rectF, this.f5538f, this.f5539g, false);
        path.transform(matrix);
    }
}
