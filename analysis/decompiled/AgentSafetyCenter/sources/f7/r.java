package f7;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends t {

    /* renamed from: h, reason: collision with root package name */
    public static final RectF f4012h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f4013b;

    /* renamed from: c, reason: collision with root package name */
    public final float f4014c;

    /* renamed from: d, reason: collision with root package name */
    public final float f4015d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4016e;

    /* renamed from: f, reason: collision with root package name */
    public float f4017f;

    /* renamed from: g, reason: collision with root package name */
    public float f4018g;

    public r(float f5, float f10, float f11, float f12) {
        this.f4013b = f5;
        this.f4014c = f10;
        this.f4015d = f11;
        this.f4016e = f12;
    }

    @Override // f7.t
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4021a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f5 = this.f4015d;
        float f10 = this.f4016e;
        RectF rectF = f4012h;
        rectF.set(this.f4013b, this.f4014c, f5, f10);
        path.arcTo(rectF, this.f4017f, this.f4018g, false);
        path.transform(matrix);
    }
}
