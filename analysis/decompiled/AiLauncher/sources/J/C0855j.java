package J;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* renamed from: J.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0855j implements U.z<b, U.A<byte[]>> {

    /* renamed from: J.j$a */
    public static class a {
        public static boolean a(Bitmap bitmap) {
            return bitmap.hasGainmap();
        }
    }

    /* renamed from: J.j$b */
    public static abstract class b {
        public static b c(U.A<Bitmap> a10, int i10) {
            return new C0846a(a10, i10);
        }

        public abstract int a();

        public abstract U.A<Bitmap> b();
    }

    public static int b(Bitmap bitmap) {
        return a.a(bitmap) ? 4101 : 256;
    }

    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public U.A<byte[]> apply(b bVar) throws ImageCaptureException {
        U.A<Bitmap> aB = bVar.b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        aB.c().compress(Bitmap.CompressFormat.JPEG, bVar.a(), byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        M.f fVarD = aB.d();
        Objects.requireNonNull(fVarD);
        return U.A.m(byteArray, fVarD, b(aB.c()), aB.h(), aB.b(), aB.f(), aB.g(), aB.a());
    }
}
