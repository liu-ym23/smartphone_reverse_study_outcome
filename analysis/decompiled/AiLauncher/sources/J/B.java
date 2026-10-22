package J;

import K.w0;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class B implements U.z<a, U.A<byte[]>> {

    /* renamed from: a, reason: collision with root package name */
    public final S.d f3526a;

    public static abstract class a {
        public static a c(U.A<androidx.camera.core.i> a10, int i10) {
            return new C0849d(a10, i10);
        }

        public abstract int a();

        public abstract U.A<androidx.camera.core.i> b();
    }

    public B(w0 w0Var) {
        this.f3526a = new S.d(w0Var);
    }

    public static M.f b(byte[] bArr) throws ImageCaptureException {
        try {
            return M.f.k(new ByteArrayInputStream(bArr));
        } catch (IOException e10) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e10);
        }
    }

    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public U.A<byte[]> apply(a aVar) throws ImageCaptureException {
        U.A<byte[]> aD;
        try {
            int iE = aVar.b().e();
            if (iE != 35) {
                if (iE != 256 && iE != 4101) {
                    throw new IllegalArgumentException("Unexpected format: " + iE);
                }
                aD = c(aVar, iE);
            } else {
                aD = d(aVar);
            }
            aVar.b().c().close();
            return aD;
        } catch (Throwable th) {
            aVar.b().c().close();
            throw th;
        }
    }

    public final U.A<byte[]> c(a aVar, int i10) {
        U.A<androidx.camera.core.i> aB = aVar.b();
        byte[] bArrA = this.f3526a.a(aB.c());
        M.f fVarD = aB.d();
        Objects.requireNonNull(fVarD);
        return U.A.m(bArrA, fVarD, i10, aB.h(), aB.b(), aB.f(), aB.g(), aB.a());
    }

    public final U.A<byte[]> d(a aVar) throws ImageCaptureException {
        U.A<androidx.camera.core.i> aB = aVar.b();
        androidx.camera.core.i iVarC = aB.c();
        Rect rectB = aB.b();
        try {
            byte[] bArrL = ImageUtil.l(iVarC, rectB, aVar.a(), aB.f());
            return U.A.m(bArrL, b(bArrL), 256, new Size(rectB.width(), rectB.height()), new Rect(0, 0, rectB.width(), rectB.height()), aB.f(), M.o.t(aB.g(), rectB), aB.a());
        } catch (ImageUtil.CodecFailedException e10) {
            throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e10);
        }
    }
}
