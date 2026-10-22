package t1;

import android.graphics.Matrix;
import android.graphics.Path;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends u {

    /* renamed from: b, reason: collision with root package name */
    public float f5540b;

    /* renamed from: c, reason: collision with root package name */
    public float f5541c;

    @Override // t1.u
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f5542a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f5540b, this.f5541c);
        path.transform(matrix);
    }
}
