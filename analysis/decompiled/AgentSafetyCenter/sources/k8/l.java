package k8;

import androidx.compose.foundation.layout.FillElement;
import com.stepos.agentsafetycenter.MainActivity;
import java.lang.invoke.VarHandle;
import java.util.Set;
import k0.c1;
import k0.y0;
import m8.k0;
import s1.f0;
import s8.i3;
import s8.j3;
import s8.l2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements xb.r {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ k0 f7315c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ xb.a f7316f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ xb.l f7317g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ c1 f7318h;

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean z10;
        boolean z11;
        Object obj5;
        k0.s sVar;
        b bVar;
        a aVar;
        Set set;
        k0.s sVar2;
        k0 k0Var = this.f7315c;
        xb.a aVar2 = this.f7316f;
        xb.l lVar = this.f7317g;
        c1 c1Var = this.f7318h;
        d0 d0Var = (d0) obj2;
        k0.s sVar3 = (k0.s) obj3;
        ((Integer) obj4).getClass();
        int i = MainActivity.f2491h;
        ((r.k) obj).getClass();
        d0Var.getClass();
        if (d0Var instanceof x) {
            sVar3.X(-1286125538);
            w.p.a(androidx.compose.foundation.layout.c.f904c, sVar3, 6);
            sVar3.q(false);
        } else {
            sVar3.X(-1285776850);
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            f0 f0VarE = w.p.e(w0.b.f15089c, false);
            int iHashCode = Long.hashCode(sVar3.T);
            s0.g gVarL = sVar3.l();
            w0.m mVarM = t.o.m(sVar3, fillElement);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar3.b0();
            if (sVar3.S) {
                sVar3.k(zVar);
            } else {
                sVar3.l0();
            }
            k0.z.B(f0VarE, sVar3, u1.i.f13836e);
            k0.z.B(gVarL, sVar3, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar3.S || !yb.k.a(sVar3.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar3, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar3, u1.i.f13834c);
            boolean z12 = d0Var instanceof c0;
            y0 y0Var = k0.m.f6974a;
            if (z12) {
                sVar3.X(-355706573);
                c0 c0Var = (c0) d0Var;
                j3 j3Var = c0Var.f7287a;
                String str = c0Var.f7288b;
                boolean zH = sVar3.h(k0Var) | sVar3.h(d0Var);
                Object objM = sVar3.M();
                if (zH || objM == y0Var) {
                    objM = new androidx.lifecycle.r(k0Var, d0Var, null, 3);
                    sVar3.i0(objM);
                }
                k0.z.g(j3Var, str, (xb.p) objM, sVar3);
                j3 j3VarR = k0Var.R(j3Var);
                s8.t tVarB = k0Var.v().b();
                Set set2 = k0Var.v().f8274f;
                boolean zH2 = sVar3.h(d0Var);
                Object objM2 = sVar3.M();
                Object obj6 = objM2;
                if (zH2 || objM2 == y0Var) {
                    e9.j jVar = new e9.j(6);
                    jVar.f3666f = d0Var;
                    jVar.f3667g = c1Var;
                    VarHandle.storeStoreFence();
                    sVar3.i0(jVar);
                    obj6 = jVar;
                }
                xb.a aVar3 = (xb.a) obj6;
                boolean zH3 = sVar3.h(d0Var) | sVar3.h(k0Var);
                Object objM3 = sVar3.M();
                Object obj7 = objM3;
                if (zH3 || objM3 == y0Var) {
                    p pVar = new p(0);
                    pVar.f7334f = d0Var;
                    pVar.f7335g = k0Var;
                    VarHandle.storeStoreFence();
                    sVar3.i0(pVar);
                    obj7 = pVar;
                }
                xb.l lVar2 = (xb.l) obj7;
                boolean zH4 = sVar3.h(d0Var) | sVar3.h(k0Var);
                Object objM4 = sVar3.M();
                Object obj8 = objM4;
                if (zH4 || objM4 == y0Var) {
                    p pVar2 = new p(1);
                    pVar2.f7334f = d0Var;
                    pVar2.f7335g = k0Var;
                    VarHandle.storeStoreFence();
                    sVar3.i0(pVar2);
                    obj8 = pVar2;
                }
                i3.b(j3VarR, tVarB, set2, aVar3, lVar2, (xb.l) obj8, null, sVar3, 0);
                sVar3.q(false);
                z11 = true;
                z10 = false;
                sVar2 = sVar3;
            } else {
                if (d0Var instanceof w) {
                    sVar3.X(-353217087);
                    s8.t tVarB2 = k0Var.v().b();
                    boolean z13 = k0Var.v().f8286s;
                    w wVar = (w) d0Var;
                    b bVar2 = wVar.f7355a;
                    boolean z14 = wVar.f7356b;
                    b bVar3 = wVar.f7358d;
                    a aVar4 = wVar.f7357c;
                    Set set3 = k0Var.v().f8274f;
                    boolean zH5 = sVar3.h(k0Var);
                    Object objM5 = sVar3.M();
                    Object obj9 = objM5;
                    if (zH5 || objM5 == y0Var) {
                        e9.j jVar2 = new e9.j(7);
                        jVar2.f3666f = k0Var;
                        jVar2.f3667g = c1Var;
                        VarHandle.storeStoreFence();
                        sVar3.i0(jVar2);
                        obj9 = jVar2;
                    }
                    xb.a aVar5 = (xb.a) obj9;
                    boolean zF = sVar3.f(d0Var);
                    Object objM6 = sVar3.M();
                    Object obj10 = objM6;
                    if (zF || objM6 == y0Var) {
                        q qVar = new q(0);
                        qVar.f7337f = d0Var;
                        qVar.f7338g = c1Var;
                        VarHandle.storeStoreFence();
                        sVar3.i0(qVar);
                        obj10 = qVar;
                    }
                    xb.q qVar2 = (xb.q) obj10;
                    boolean zH6 = sVar3.h(k0Var);
                    Object objM7 = sVar3.M();
                    Object obj11 = objM7;
                    if (zH6 || objM7 == y0Var) {
                        h hVar2 = new h(2);
                        hVar2.f7304f = k0Var;
                        VarHandle.storeStoreFence();
                        sVar3.i0(hVar2);
                        obj11 = hVar2;
                    }
                    xb.l lVar3 = (xb.l) obj11;
                    boolean zH7 = sVar3.h(k0Var);
                    Object objM8 = sVar3.M();
                    Object obj12 = objM8;
                    if (zH7 || objM8 == y0Var) {
                        h hVar3 = new h(3);
                        hVar3.f7304f = k0Var;
                        VarHandle.storeStoreFence();
                        sVar3.i0(hVar3);
                        obj12 = hVar3;
                    }
                    xb.l lVar4 = (xb.l) obj12;
                    boolean zH8 = sVar3.h(k0Var);
                    Object objM9 = sVar3.M();
                    if (zH8 || objM9 == y0Var) {
                        bVar = bVar3;
                        aVar = aVar4;
                        set = set3;
                        androidx.activity.d0 d0Var2 = new androidx.activity.d0(0, k0Var, k0.class, "markAllInterceptsInActionListViewed", "markAllInterceptsInActionListViewed()V", 0, 0, 5);
                        sVar3.i0(d0Var2);
                        objM9 = d0Var2;
                    } else {
                        aVar = aVar4;
                        bVar = bVar3;
                        set = set3;
                    }
                    z10 = false;
                    s8.s.f(tVarB2, z13, bVar2, z14, bVar, aVar, set, aVar5, qVar2, lVar3, lVar4, (xb.a) ((yb.i) objM9), null, sVar3, 0);
                    k0.s sVar4 = sVar3;
                    sVar4.q(false);
                    sVar = sVar4;
                } else {
                    z10 = false;
                    if (d0Var.equals(z.f7361a)) {
                        sVar3.X(681419304);
                        l2.a(aVar2, null, sVar3, 0);
                        sVar3.q(false);
                        sVar = sVar3;
                    } else if (d0Var.equals(a0.f7278a)) {
                        sVar3.X(681426017);
                        boolean zF2 = sVar3.f(lVar);
                        Object objM10 = sVar3.M();
                        if (zF2 || objM10 == y0Var) {
                            z11 = true;
                            j jVar3 = new j(1);
                            jVar3.f7309f = lVar;
                            VarHandle.storeStoreFence();
                            sVar3.i0(jVar3);
                            obj5 = jVar3;
                        } else {
                            z11 = true;
                            obj5 = objM10;
                        }
                        j9.a.d(aVar2, (xb.a) obj5, null, sVar3, 0);
                        sVar3.q(false);
                        sVar2 = sVar3;
                    } else {
                        z11 = true;
                        if (d0Var.equals(b0.f7283a)) {
                            sVar3.X(681439485);
                            Object objM11 = sVar3.M();
                            Object obj13 = objM11;
                            if (objM11 == y0Var) {
                                e9.s sVar5 = new e9.s(7);
                                sVar5.f3721f = c1Var;
                                VarHandle.storeStoreFence();
                                sVar3.i0(sVar5);
                                obj13 = sVar5;
                            }
                            j9.a.c((xb.a) obj13, null, sVar3, 6);
                            sVar3.q(false);
                            sVar2 = sVar3;
                        } else if (d0Var.equals(y.f7360a)) {
                            sVar3.X(681446499);
                            e9.b.c(aVar2, null, sVar3, 0);
                            sVar3.q(false);
                            sVar2 = sVar3;
                        } else {
                            if (!d0Var.equals(x.f7359a)) {
                                sVar3.X(681263382);
                                sVar3.q(false);
                                g5.f.a();
                                return null;
                            }
                            sVar3.X(681452324);
                            sVar3.q(false);
                            sVar2 = sVar3;
                        }
                    }
                }
                z11 = true;
                sVar2 = sVar;
            }
            sVar2.q(z11);
            sVar2.q(z10);
        }
        return jb.v.f6774a;
    }
}
