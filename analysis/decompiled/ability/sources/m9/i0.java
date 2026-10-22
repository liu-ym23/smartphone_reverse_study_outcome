package m9;

import v9.InterfaceC2075d;

/* loaded from: classes4.dex */
public final class i0 extends e0 {
    public final InterfaceC2075d e;
    public final /* synthetic */ kotlinx.coroutines.c f;

    public i0(kotlinx.coroutines.c cVar, InterfaceC2075d interfaceC2075d) {
        this.f = cVar;
        this.e = interfaceC2075d;
    }

    @Override // m9.e0
    public final boolean i() {
        return false;
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        kotlinx.coroutines.c cVar = this.f;
        cVar.getClass();
        Object objU = kotlinx.coroutines.c.f5183a.get(cVar);
        if (!(objU instanceof C1727t)) {
            objU = AbstractC1683A.u(objU);
        }
        this.e.g(cVar, objU);
    }
}
