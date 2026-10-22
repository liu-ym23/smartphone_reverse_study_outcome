package D;

import android.graphics.Matrix;
import androidx.camera.core.impl.utils.ExifData;

/* loaded from: classes.dex */
public abstract class Z implements T {
    public static T b(K.E0 e02, long j10, int i10, Matrix matrix, int i11) {
        return new C0766e(e02, j10, i10, matrix, i11);
    }

    @Override // D.T
    public abstract int a();

    @Override // D.T
    public void c(ExifData.b bVar) {
        bVar.m(f());
    }

    public abstract Matrix d();

    @Override // D.T
    public abstract K.E0 e();

    @Override // D.T
    public abstract int f();

    @Override // D.T
    public abstract long getTimestamp();
}
