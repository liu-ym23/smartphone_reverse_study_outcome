package e3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes3.dex */
public final class v extends x {
    public static final RectF h = new RectF();
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public float f;
    public float g;

    public v(float f, float f7, float f9, float f10) {
        this.b = f;
        this.c = f7;
        this.d = f9;
        this.e = f10;
    }

    @Override // e3.x
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4374a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f = this.d;
        float f7 = this.e;
        RectF rectF = h;
        rectF.set(this.b, this.c, f, f7);
        path.arcTo(rectF, this.f, this.g, false);
        path.transform(matrix);
    }
}
