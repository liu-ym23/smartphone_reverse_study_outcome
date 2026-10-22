package u5;

import java.lang.invoke.VarHandle;
import nc.k0;
import nc.t0;
import s1.e0;
import s1.g0;
import u1.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements f6.h, s1.r {

    /* renamed from: c, reason: collision with root package name */
    public t0 f14090c;

    @Override // s1.r
    public final g0 f(o0 o0Var, e0 e0Var, long j10) {
        t0 t0Var = this.f14090c;
        o2.a aVarA = o2.a.a(j10);
        t0Var.getClass();
        t0Var.g(null, aVarA);
        s1.o0 o0VarQ = e0Var.q(j10);
        int i = o0VarQ.f11277c;
        int i3 = o0VarQ.f11278f;
        p pVar = new p(0);
        pVar.f14086f = o0VarQ;
        VarHandle.storeStoreFence();
        return o0Var.Y(i, i3, kb.t.f7405c, pVar);
    }

    @Override // f6.h
    public final Object g(t5.f fVar) {
        t0 t0Var = this.f14090c;
        k kVar = new k(1);
        kVar.f14065f = t0Var;
        VarHandle.storeStoreFence();
        return k0.i(kVar, fVar);
    }
}
