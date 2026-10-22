package s4;

import x4.C1308h;

/* renamed from: s4.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1058G {
    public static final void a(Z3.i iVar, Throwable th) {
        try {
            InterfaceC1057F interfaceC1057F = (InterfaceC1057F) iVar.a(InterfaceC1057F.f20300O);
            if (interfaceC1057F != null) {
                interfaceC1057F.v(iVar, th);
            } else {
                C1308h.a(iVar, th);
            }
        } catch (Throwable th2) {
            C1308h.a(iVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        V3.a.a(runtimeException, th);
        return runtimeException;
    }
}
