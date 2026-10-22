package J;

import D.p0;
import androidx.camera.core.ImageCaptureException;

/* loaded from: classes.dex */
public class H implements U.z<U.A<androidx.camera.core.i>, androidx.camera.core.i> {
    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.camera.core.i apply(U.A<androidx.camera.core.i> a10) throws ImageCaptureException {
        androidx.camera.core.i iVarC = a10.c();
        p0 p0Var = new p0(iVarC, a10.h(), D.Z.b(iVarC.Z0().e(), iVarC.Z0().getTimestamp(), a10.f(), a10.g(), iVarC.Z0().a()));
        p0Var.S(a10.b());
        return p0Var;
    }
}
