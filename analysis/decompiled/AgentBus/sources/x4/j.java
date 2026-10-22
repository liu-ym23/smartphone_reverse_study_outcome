package x4;

import ab.e0;
import ab.z;
import k5.s;
import la.u0;

/* loaded from: classes.dex */
public final class j extends s7.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f11204b;

    public j(k kVar) {
        this.f11204b = kVar;
    }

    @Override // s7.a
    public final void K(e0 e0Var, int i2, String str) {
        q7.k.e(e0Var, "webSocket");
        k kVar = this.f11204b;
        kVar.b(null);
        s.info$default(kVar.f11206b, "BffGatewayClient", "WS closed code=" + i2 + " reason=" + str, null, 4, null);
    }

    @Override // s7.a
    public final void L(e0 e0Var, int i2, String str) {
        q7.k.e(e0Var, "webSocket");
        ((nb.g) e0Var).b(i2, str);
    }

    @Override // s7.a
    public final void M(nb.g gVar, Exception exc, z zVar) {
        k kVar = this.f11204b;
        kVar.b(exc);
        s.warn$default(kVar.f11206b, "BffGatewayClient", a1.a.w("WS failure: ", exc.getMessage()), null, 4, null);
    }

    @Override // s7.a
    public final void O(e0 e0Var, ob.k kVar) {
        q7.k.e(e0Var, "webSocket");
        byte[] bArrQ = kVar.q();
        k kVar2 = this.f11204b;
        s.info$default(kVar2.f11206b, "BffGatewayClient", n.f.c(bArrQ.length, "WS recv bytes="), null, 4, null);
        kVar2.f11207c.invoke(bArrQ);
    }

    @Override // s7.a
    public final void P(e0 e0Var, z zVar) {
        k kVar = this.f11204b;
        kVar.f11211g.set(true);
        u0 u0Var = kVar.f11214j;
        Boolean bool = Boolean.TRUE;
        u0Var.getClass();
        u0Var.g(null, bool);
        s.info$default(kVar.f11206b, "BffGatewayClient", "WS open url=".concat(kVar.f11205a), null, 4, null);
        kVar.f11208d.c();
    }
}
