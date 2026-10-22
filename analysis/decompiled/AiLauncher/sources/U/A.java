package U;

import K.InterfaceC0891n;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.internal.utils.ImageUtil;

/* loaded from: classes.dex */
public abstract class A<T> {
    public static A<Bitmap> j(Bitmap bitmap, M.f fVar, Rect rect, int i10, Matrix matrix, InterfaceC0891n interfaceC0891n) {
        return new C1021b(bitmap, fVar, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i10, matrix, interfaceC0891n);
    }

    public static A<androidx.camera.core.i> k(androidx.camera.core.i iVar, M.f fVar, Rect rect, int i10, Matrix matrix, InterfaceC0891n interfaceC0891n) {
        return l(iVar, fVar, new Size(iVar.getWidth(), iVar.getHeight()), rect, i10, matrix, interfaceC0891n);
    }

    public static A<androidx.camera.core.i> l(androidx.camera.core.i iVar, M.f fVar, Size size, Rect rect, int i10, Matrix matrix, InterfaceC0891n interfaceC0891n) {
        if (ImageUtil.h(iVar.getFormat())) {
            B0.h.g(fVar, "JPEG image must have Exif.");
        }
        return new C1021b(iVar, fVar, iVar.getFormat(), size, rect, i10, matrix, interfaceC0891n);
    }

    public static A<byte[]> m(byte[] bArr, M.f fVar, int i10, Size size, Rect rect, int i11, Matrix matrix, InterfaceC0891n interfaceC0891n) {
        return new C1021b(bArr, fVar, i10, size, rect, i11, matrix, interfaceC0891n);
    }

    public abstract InterfaceC0891n a();

    public abstract Rect b();

    public abstract T c();

    public abstract M.f d();

    public abstract int e();

    public abstract int f();

    public abstract Matrix g();

    public abstract Size h();

    public boolean i() {
        return M.o.g(b(), h());
    }
}
