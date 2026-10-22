package e3;

import android.graphics.Matrix;
import android.graphics.Path;

/* loaded from: classes3.dex */
public final class w extends x {
    public float b;
    public float c;

    @Override // e3.x
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4374a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.b, this.c);
        path.transform(matrix);
    }
}
