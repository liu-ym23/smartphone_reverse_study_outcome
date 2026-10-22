package J;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import java.util.Objects;

/* loaded from: classes.dex */
public class G implements U.z<U.A<byte[]>, U.A<androidx.camera.core.i>> {
    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public U.A<androidx.camera.core.i> apply(U.A<byte[]> a10) throws ImageCaptureException {
        androidx.camera.core.m mVar = new androidx.camera.core.m(D.Y.a(a10.h().getWidth(), a10.h().getHeight(), 256, 2));
        androidx.camera.core.i iVarE = ImageProcessingUtil.e(mVar, a10.c());
        mVar.j();
        Objects.requireNonNull(iVarE);
        M.f fVarD = a10.d();
        Objects.requireNonNull(fVarD);
        return U.A.k(iVarE, fVarD, a10.b(), a10.f(), a10.g(), a10.a());
    }
}
