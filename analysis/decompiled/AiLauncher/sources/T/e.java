package T;

import D.T;
import K.C0892o;
import K.InterfaceC0891n;
import androidx.camera.core.i;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;

/* loaded from: classes.dex */
public final class e extends a<i> {
    public e(int i10, b<i> bVar) {
        super(i10, bVar);
    }

    public void d(i iVar) {
        if (e(iVar.Z0())) {
            super.b(iVar);
        } else {
            this.f5822d.a(iVar);
        }
    }

    public final boolean e(T t10) {
        InterfaceC0891n interfaceC0891nA = C0892o.a(t10);
        if (interfaceC0891nA == null) {
            return false;
        }
        return (interfaceC0891nA.o() == CameraCaptureMetaData$AfState.LOCKED_FOCUSED || interfaceC0891nA.o() == CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) && interfaceC0891nA.s() == CameraCaptureMetaData$AeState.CONVERGED && interfaceC0891nA.q() == CameraCaptureMetaData$AwbState.CONVERGED;
    }
}
