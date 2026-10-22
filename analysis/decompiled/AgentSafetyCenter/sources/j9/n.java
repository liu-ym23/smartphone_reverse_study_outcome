package j9;

import android.content.res.Resources;
import d1.f0;
import g9.o1;
import h0.t1;
import java.lang.invoke.VarHandle;
import java.util.List;
import k0.c1;
import k0.y0;
import s8.d1;
import s8.g1;
import s8.l2;
import s8.n0;
import s8.t3;
import s8.x1;
import w.p0;
import w.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6691c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6692f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6693g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6694h;

    public /* synthetic */ n(int i) {
        this.f6691c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        int i = this.f6691c;
        y0 y0Var = k0.m.f6974a;
        int i3 = 4;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                kc.t tVar = (kc.t) this.f6692f;
                i9.b0 b0Var = (i9.b0) this.f6693g;
                c1 c1Var = (c1) this.f6694h;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    boolean z10 = ((String) c1Var.getValue()) != null;
                    Object objM = sVar.M();
                    Object obj3 = objM;
                    if (objM == y0Var) {
                        e9.s sVar2 = new e9.s(4);
                        sVar2.f3721f = c1Var;
                        VarHandle.storeStoreFence();
                        sVar.i0(sVar2);
                        obj3 = sVar2;
                    }
                    xb.a aVar = (xb.a) obj3;
                    boolean zH = sVar.h(tVar) | sVar.h(b0Var);
                    Object objM2 = sVar.M();
                    Object obj4 = objM2;
                    if (zH || objM2 == y0Var) {
                        e9.r rVar = new e9.r(1);
                        rVar.f3717f = tVar;
                        rVar.f3718g = c1Var;
                        rVar.f3719h = b0Var;
                        VarHandle.storeStoreFence();
                        sVar.i0(rVar);
                        obj4 = rVar;
                    }
                    b0.c(z10, aVar, (xb.a) obj4, androidx.compose.foundation.layout.c.f904c, sVar, 3120);
                    break;
                } else {
                    sVar.S();
                    break;
                }
            case 1:
                ((Integer) obj2).getClass();
                a.d((xb.a) this.f6692f, (xb.a) this.f6693g, (w0.m) this.f6694h, (k0.s) obj, k0.z.D(1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                b0.a((String) this.f6692f, (xb.a) this.f6693g, (w0.m) this.f6694h, (k0.s) obj, k0.z.D(1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                s8.s.e((List) this.f6692f, (k8.b) this.f6693g, (xb.l) this.f6694h, (k0.s) obj, k0.z.D(1));
                break;
            case 4:
                List<jb.g> list = (List) this.f6692f;
                d1 d1Var = (d1) this.f6693g;
                xb.l lVar = (xb.l) this.f6694h;
                k0.s sVar3 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (sVar3.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    float f5 = x1.A;
                    w0.j jVar = w0.j.f15113c;
                    float f10 = 0.0f;
                    float f11 = 2;
                    w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.d(jVar, f5, 0.0f, 2), f11, f11);
                    r0 r0VarA = p0.a(w.k.f14990a, w0.b.f15098o, sVar3, 48);
                    int iHashCode = Long.hashCode(sVar3.T);
                    s0.g gVarL = sVar3.l();
                    w0.m mVarM = t.o.m(sVar3, mVarG);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar3.b0();
                    if (sVar3.S) {
                        sVar3.k(zVar);
                    } else {
                        sVar3.l0();
                    }
                    k0.z.B(r0VarA, sVar3, u1.i.f13836e);
                    k0.z.B(gVarL, sVar3, u1.i.f13835d);
                    u1.h hVar = u1.i.f13837f;
                    if (sVar3.S || !yb.k.a(sVar3.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar3, iHashCode, hVar);
                    }
                    k0.z.B(mVarM, sVar3, u1.i.f13834c);
                    sVar3.X(335065674);
                    k0.s sVar4 = sVar3;
                    for (jb.g gVar : list) {
                        d1 d1Var2 = (d1) gVar.f6759c;
                        int iIntValue3 = ((Number) gVar.f6760f).intValue();
                        boolean z11 = d1Var2 == d1Var;
                        w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.d(jVar, x1.A - i3, f10, 2), a0.e.a(x1.B)), z11 ? x1.f12099z : d1.p.f3023f, f0.f2972a);
                        boolean zG = sVar4.g(z11) | sVar4.f(lVar) | sVar4.d(d1Var2.ordinal());
                        Object objM3 = sVar4.M();
                        Object obj5 = objM3;
                        if (zG || objM3 == y0Var) {
                            n0 n0Var = new n0();
                            n0Var.f11814c = z11;
                            n0Var.f11815f = lVar;
                            n0Var.f11816g = d1Var2;
                            VarHandle.storeStoreFence();
                            sVar4.i0(n0Var);
                            obj5 = n0Var;
                        }
                        w0.m mVarH = androidx.compose.foundation.layout.b.h(androidx.compose.foundation.a.e(mVarB, false, null, (xb.a) obj5, 7), 12, f10, 2);
                        s1.f0 f0VarE = w.p.e(w0.b.i, false);
                        int iHashCode2 = Long.hashCode(sVar4.T);
                        s0.g gVarL2 = sVar4.l();
                        w0.m mVarM2 = t.o.m(sVar4, mVarH);
                        u1.j.f13840e.getClass();
                        u1.z zVar2 = u1.i.f13833b;
                        sVar4.b0();
                        if (sVar4.S) {
                            sVar4.k(zVar2);
                        } else {
                            sVar4.l0();
                        }
                        k0.z.B(f0VarE, sVar4, u1.i.f13836e);
                        k0.z.B(gVarL2, sVar4, u1.i.f13835d);
                        u1.h hVar2 = u1.i.f13837f;
                        if (sVar4.S || !yb.k.a(sVar4.M(), Integer.valueOf(iHashCode2))) {
                            k0.a.y(iHashCode2, sVar4, iHashCode2, hVar2);
                        }
                        k0.z.B(mVarM2, sVar4, u1.i.f13834c);
                        k0.s sVar5 = sVar4;
                        t1.b(t2.a.o(iIntValue3, sVar4), null, z11 ? x1.f12092s : x1.f12095v, x1.T, z11 ? g2.k.f4253h : g2.k.f4252g, 0L, null, com.stepos.statsrpk.h.t(18), 0, false, 0, 0, null, sVar5, 3072, 6, 130002);
                        sVar5.q(true);
                        f10 = 0.0f;
                        jVar = jVar;
                        sVar4 = sVar5;
                        i3 = 4;
                    }
                    k0.s sVar6 = sVar4;
                    sVar6.q(false);
                    sVar6.q(true);
                    break;
                } else {
                    sVar3.S();
                    break;
                }
                break;
            case 5:
                ((Integer) obj2).getClass();
                g1.f((t3) this.f6692f, (xb.a) this.f6693g, (xb.a) this.f6694h, (k0.s) obj, k0.z.D(1));
                break;
            default:
                ((Integer) obj2).getClass();
                l2.c((o1) this.f6692f, (xb.l) this.f6693g, (xb.a) this.f6694h, (k0.s) obj, k0.z.D(1));
                break;
        }
        return vVar;
    }
}
