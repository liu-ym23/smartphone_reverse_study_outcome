package y1;

import android.graphics.Matrix;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class u extends v {

    /* renamed from: b, reason: collision with root package name */
    public float f16310b;

    /* renamed from: c, reason: collision with root package name */
    public float f16311c;

    @Override // y1.v
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f16312a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f16310b, this.f16311c);
        path.transform(matrix);
    }
}
