package J;

import U.C1039u;
import U.C1042x;
import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import java.util.Objects;

/* renamed from: J.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0856k implements U.z<U.A<Bitmap>, U.A<Bitmap>> {

    /* renamed from: a, reason: collision with root package name */
    public final C1042x f3649a;

    public C0856k(C1042x c1042x) {
        this.f3649a = c1042x;
    }

    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public U.A<Bitmap> apply(U.A<Bitmap> a10) throws ImageCaptureException {
        androidx.camera.core.i iVarA = this.f3649a.c(new C1039u(new b0(a10), 1)).a();
        Objects.requireNonNull(iVarA);
        Bitmap bitmapC = ImageUtil.c(iVarA.w0(), iVarA.getWidth(), iVarA.getHeight());
        M.f fVarD = a10.d();
        Objects.requireNonNull(fVarD);
        return U.A.j(bitmapC, fVarD, a10.b(), a10.f(), a10.g(), a10.a());
    }
}
