package f7;

import android.graphics.Matrix;
import android.graphics.Path;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends t {

    /* renamed from: b, reason: collision with root package name */
    public float f4019b;

    /* renamed from: c, reason: collision with root package name */
    public float f4020c;

    @Override // f7.t
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4021a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f4019b, this.f4020c);
        path.transform(matrix);
    }
}
