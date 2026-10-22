package s8;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q2 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11905c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f11906f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f11907g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ xb.a f11908h;

    public /* synthetic */ q2(int i) {
        this.f11905c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        u1.h hVar;
        u1.h hVar2;
        u1.h hVar3;
        k0.s sVar;
        boolean z10;
        w0.m mVar;
        u1.h hVar4;
        boolean z11;
        int i;
        y2 y2Var;
        switch (this.f11905c) {
            case 0:
                boolean z12 = this.f11907g;
                xb.a aVar = this.f11908h;
                y2 y2Var2 = (y2) this.f11906f;
                k0.s sVar2 = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar2.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    w0.j jVar = w0.j.f15113c;
                    w0.m mVarE = androidx.compose.foundation.a.e(androidx.compose.foundation.layout.c.b(jVar, 1.0f), z12, null, aVar, 6);
                    float f5 = 14;
                    w0.m mVarG = androidx.compose.foundation.layout.b.g(mVarE, f5, f5);
                    w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15097n, sVar2, 48);
                    int iHashCode = Long.hashCode(sVar2.T);
                    s0.g gVarL = sVar2.l();
                    w0.m mVarM = t.o.m(sVar2, mVarG);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar2.b0();
                    if (sVar2.S) {
                        sVar2.k(zVar);
                    } else {
                        sVar2.l0();
                    }
                    u1.h hVar5 = u1.i.f13836e;
                    k0.z.B(r0VarA, sVar2, hVar5);
                    u1.h hVar6 = u1.i.f13835d;
                    k0.z.B(gVarL, sVar2, hVar6);
                    u1.h hVar7 = u1.i.f13837f;
                    if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar2, iHashCode, hVar7);
                    }
                    u1.h hVar8 = u1.i.f13834c;
                    k0.z.B(mVarM, sVar2, hVar8);
                    w0.m mVarG2 = com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(androidx.compose.foundation.layout.b.j(jVar, 0.0f, 2, 0.0f, 0.0f, 13), 22), a0.e.f7a);
                    boolean z13 = y2Var2.f12140r;
                    u8.p pVar = y2Var2.f12134l;
                    w0.m mVarB = androidx.compose.foundation.a.b(mVarG2, z13 ? x2.f12105f : x2.i, d1.f0.f2972a);
                    s1.f0 f0VarE = w.p.e(w0.b.i, false);
                    int iHashCode2 = Long.hashCode(sVar2.T);
                    s0.g gVarL2 = sVar2.l();
                    w0.m mVarM2 = t.o.m(sVar2, mVarB);
                    sVar2.b0();
                    if (sVar2.S) {
                        sVar2.k(zVar);
                    } else {
                        sVar2.l0();
                    }
                    k0.z.B(f0VarE, sVar2, hVar5);
                    k0.z.B(gVarL2, sVar2, hVar6);
                    if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                        k0.a.y(iHashCode2, sVar2, iHashCode2, hVar7);
                    }
                    k0.z.B(mVarM2, sVar2, hVar8);
                    if (y2Var2.f12140r) {
                        sVar2.X(761561814);
                        i1.f fVarB = a.a.B();
                        hVar = hVar6;
                        long j10 = d1.p.f3020c;
                        w0.m mVarF = androidx.compose.foundation.layout.c.f(jVar, f5);
                        hVar3 = hVar7;
                        hVar2 = hVar5;
                        sVar = sVar2;
                        hVar4 = hVar8;
                        mVar = null;
                        h0.o0.b(fVarB, mVarF, j10, sVar, 3504);
                        z10 = false;
                    } else {
                        hVar = hVar6;
                        hVar2 = hVar5;
                        hVar3 = hVar7;
                        sVar = sVar2;
                        z10 = false;
                        mVar = null;
                        hVar4 = hVar8;
                        sVar.X(745251133);
                    }
                    sVar.q(z10);
                    sVar.q(true);
                    t0.a.b(sVar, androidx.compose.foundation.layout.c.h(jVar, 12));
                    if (pVar == u8.p.f14244f || !y2Var2.f12138p.isEmpty() || y2Var2.f12135m != null) {
                        z11 = true;
                        sVar.X(812863623);
                        x2.a(y2Var2, w.s0.a(), false, sVar, 0);
                        sVar.q(false);
                    } else if (pVar == u8.p.f14245g || !y2Var2.f12139q.isEmpty()) {
                        z11 = true;
                        sVar.X(813047050);
                        x2.c(y2Var2, w.s0.a(), false, sVar, 0);
                        sVar.q(false);
                    } else {
                        sVar.X(813243280);
                        w0.m mVarA = w.s0.a();
                        w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar, 0);
                        int iHashCode3 = Long.hashCode(sVar.T);
                        s0.g gVarL3 = sVar.l();
                        w0.m mVarM3 = t.o.m(sVar, mVarA);
                        sVar.b0();
                        if (sVar.S) {
                            sVar.k(zVar);
                        } else {
                            sVar.l0();
                        }
                        k0.z.B(vVarA, sVar, hVar2);
                        k0.z.B(gVarL3, sVar, hVar);
                        if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode3))) {
                            k0.a.y(iHashCode3, sVar, iHashCode3, hVar3);
                        }
                        k0.z.B(mVarM3, sVar, hVar4);
                        k0.s sVar3 = sVar;
                        w0.m mVar2 = mVar;
                        h0.t1.b(y2Var2.f12125b, null, x2.f12102c, 0L, g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar.j(h0.w1.f5235a)).f5221k, sVar3, 196992, 0, 65498);
                        k0.s sVar4 = sVar3;
                        if (e3.g(g1.r(y2Var2)).isEmpty()) {
                            i = 6;
                            sVar4.X(1807221641);
                        } else {
                            sVar4.X(1824696155);
                            i = 6;
                            t0.a.b(sVar4, androidx.compose.foundation.layout.c.c(jVar, 6));
                            e3.d(g1.r(y2Var2), mVar2, sVar4, 0);
                        }
                        sVar4.q(false);
                        List listR = g1.r(y2Var2);
                        if (listR.isEmpty()) {
                            y2Var = y2Var2;
                            sVar4.X(1807221641);
                            sVar4.q(false);
                            t0.a.b(sVar4, androidx.compose.foundation.layout.c.c(jVar, i));
                            k0.s sVar5 = sVar4;
                            h0.t1.b(y2Var.f12126c, null, x2.f12103d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar4.j(h0.w1.f5235a)).f5224n, sVar5, 384, 0, 65530);
                            sVar = sVar5;
                            z11 = true;
                            sVar.q(true);
                            sVar.q(false);
                        } else {
                            Iterator it = listR.iterator();
                            while (it.hasNext()) {
                                if (e3.f(e3.h((String) it.next()))) {
                                    sVar4.X(1824974566);
                                    t0.a.b(sVar4, androidx.compose.foundation.layout.c.c(jVar, 8));
                                    y2Var = y2Var2;
                                    e3.b(g1.r(y2Var2), y2Var.f12130g, y2Var.f12131h, null, 0, sVar4, 0, 24);
                                    sVar4 = sVar4;
                                    sVar4.q(false);
                                    t0.a.b(sVar4, androidx.compose.foundation.layout.c.c(jVar, i));
                                    k0.s sVar52 = sVar4;
                                    h0.t1.b(y2Var.f12126c, null, x2.f12103d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar4.j(h0.w1.f5235a)).f5224n, sVar52, 384, 0, 65530);
                                    sVar = sVar52;
                                    z11 = true;
                                    sVar.q(true);
                                    sVar.q(false);
                                }
                            }
                            y2Var = y2Var2;
                            sVar4.X(1807221641);
                            sVar4.q(false);
                            t0.a.b(sVar4, androidx.compose.foundation.layout.c.c(jVar, i));
                            k0.s sVar522 = sVar4;
                            h0.t1.b(y2Var.f12126c, null, x2.f12103d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar4.j(h0.w1.f5235a)).f5224n, sVar522, 384, 0, 65530);
                            sVar = sVar522;
                            z11 = true;
                            sVar.q(true);
                            sVar.q(false);
                        }
                    }
                    sVar.q(z11);
                } else {
                    sVar2.S();
                }
                return jb.v.f6774a;
            case 1:
                ((Integer) obj2).getClass();
                x2.f((y2) this.f11906f, this.f11907g, this.f11908h, (k0.s) obj, k0.z.D(1));
                break;
            default:
                ((Integer) obj2).getClass();
                g1.a((String) this.f11906f, this.f11908h, this.f11907g, (k0.s) obj, k0.z.D(1));
                break;
        }
        return jb.v.f6774a;
    }
}
