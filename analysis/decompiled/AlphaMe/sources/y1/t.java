package y1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class t extends v {

    /* renamed from: h, reason: collision with root package name */
    public static final RectF f16303h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f16304b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16305c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16306d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16307e;

    /* renamed from: f, reason: collision with root package name */
    public float f16308f;

    /* renamed from: g, reason: collision with root package name */
    public float f16309g;

    public t(float f4, float f5, float f6, float f7) {
        this.f16304b = f4;
        this.f16305c = f5;
        this.f16306d = f6;
        this.f16307e = f7;
    }

    @Override // y1.v
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f16312a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f16303h;
        rectF.set(this.f16304b, this.f16305c, this.f16306d, this.f16307e);
        path.arcTo(rectF, this.f16308f, this.f16309g, false);
        path.transform(matrix);
    }
}
