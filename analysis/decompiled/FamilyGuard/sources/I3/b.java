package I3;

import x3.AbstractC1286b;
import x3.InterfaceC1287c;

/* loaded from: classes.dex */
public final class b extends AbstractC1286b {

    /* renamed from: a, reason: collision with root package name */
    final D3.a f2959a;

    public b(D3.a aVar) {
        this.f2959a = aVar;
    }

    @Override // x3.AbstractC1286b
    protected void i(InterfaceC1287c interfaceC1287c) {
        A3.c cVarB = A3.d.b();
        interfaceC1287c.b(cVarB);
        try {
            this.f2959a.run();
            if (cVarB.g()) {
                return;
            }
            interfaceC1287c.a();
        } catch (Throwable th) {
            B3.b.b(th);
            if (cVarB.g()) {
                S3.a.r(th);
            } else {
                interfaceC1287c.onError(th);
            }
        }
    }
}
