package s8;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h3 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f11647c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ j3 f11648f;

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i;
        boolean z10;
        boolean z11 = this.f11647c;
        j3 j3Var = this.f11648f;
        k0.s sVar = (k0.s) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
            w0.j jVar = w0.j.f15113c;
            w0.m mVarF = androidx.compose.foundation.layout.b.f(jVar, 16);
            float f5 = 12;
            w.v vVarA = w.u.a(w.k.e(f5), w0.b.f15100q, sVar, 6);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarF);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(vVarA, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            if (z11) {
                sVar.X(702312465);
                a0.d dVarA = a0.e.a(f5);
                long j10 = i3.f11672f;
                w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
                e9.m mVar = new e9.m(13);
                mVar.f3688f = j3Var;
                VarHandle.storeStoreFence();
                i = 696762845;
                h0.q1.a(mVarB, dVarA, j10, 0L, 0.0f, 0.0f, s0.h.d(904090799, mVar, sVar), sVar, 12583302, 120);
            } else {
                i = 696762845;
                sVar.X(696762845);
            }
            sVar.q(false);
            if (hc.h.g0(j3Var.f11704g)) {
                z10 = true;
                sVar.X(i);
                sVar.q(false);
            } else {
                sVar.X(703009221);
                z10 = true;
                h0.t1.b(j3Var.f11704g, null, i3.f11669c, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar.j(h0.w1.f5235a)).f5221k, sVar, 384, 0, 65530);
                sVar = sVar;
                sVar.q(false);
            }
            sVar.q(z10);
        } else {
            sVar.S();
        }
        return jb.v.f6774a;
    }
}
