package J;

import J.W;
import K.InterfaceC0891n;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.IOException;

/* loaded from: classes.dex */
public final class L implements U.z<W.b, U.A<androidx.camera.core.i>> {
    public static U.A<androidx.camera.core.i> b(X x10, M.f fVar, androidx.camera.core.i iVar) {
        return U.A.k(iVar, fVar, x10.b(), x10.f(), x10.h(), d(iVar));
    }

    public static U.A<androidx.camera.core.i> c(X x10, M.f fVar, androidx.camera.core.i iVar) {
        Size size = new Size(iVar.getWidth(), iVar.getHeight());
        int iF = x10.f() - fVar.s();
        Size sizeE = e(iF, size);
        Matrix matrixC = M.o.c(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), new RectF(0.0f, 0.0f, sizeE.getWidth(), sizeE.getHeight()), iF);
        return U.A.l(iVar, fVar, sizeE, f(x10.b(), matrixC), fVar.s(), g(x10.h(), matrixC), d(iVar));
    }

    public static InterfaceC0891n d(androidx.camera.core.i iVar) {
        return iVar.Z0() instanceof P.a ? ((P.a) iVar.Z0()).b() : InterfaceC0891n.a.b();
    }

    public static Size e(int i10, Size size) {
        return M.o.h(M.o.u(i10)) ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    public static Rect f(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    public static Matrix g(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public U.A<androidx.camera.core.i> apply(W.b bVar) throws ImageCaptureException {
        M.f fVarJ;
        androidx.camera.core.i iVarA = bVar.a();
        X xB = bVar.b();
        if (ImageUtil.h(iVarA.getFormat())) {
            try {
                fVarJ = M.f.j(iVarA);
                iVarA.w0()[0].a().rewind();
            } catch (IOException e10) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e10);
            }
        } else {
            fVarJ = null;
        }
        if (!D.f3528g.b(iVarA)) {
            return b(xB, fVarJ, iVarA);
        }
        B0.h.g(fVarJ, "JPEG image must have exif.");
        return c(xB, fVarJ, iVarA);
    }
}
