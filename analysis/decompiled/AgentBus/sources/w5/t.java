package w5;

import androidx.lifecycle.k0;
import b0.f1;
import b0.t1;
import java.util.ArrayList;
import java.util.ListIterator;
import r.s0;

/* loaded from: classes.dex */
public final class t implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l0.q f10755f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c.i f10756g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f1 f10757h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f1 f10758i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f1 f10759j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f1 f10760k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f1 f10761l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f1 f10762m;

    public t(l0.q qVar, c.i iVar, f1 f1Var, f1 f1Var2, f1 f1Var3, f1 f1Var4, f1 f1Var5, f1 f1Var6) {
        this.f10755f = qVar;
        this.f10756g = iVar;
        this.f10757h = f1Var;
        this.f10758i = f1Var2;
        this.f10759j = f1Var3;
        this.f10760k = f1Var4;
        this.f10761l = f1Var5;
        this.f10762m = f1Var6;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        n0.j jVar;
        float f10;
        t tVar;
        b0.p pVar = (b0.p) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            n0.m mVarD = androidx.compose.foundation.layout.a.d(androidx.compose.foundation.layout.a.f745b.c(new n0.h(new s0(3))), 16);
            r.f fVar = r.i.f8867b;
            n0.c cVar = n0.b.f6784r;
            r.r rVarA = r.p.a(fVar, cVar, pVar, 0);
            int iK = b0.b.k(pVar);
            t1 t1VarL = pVar.l();
            n0.m mVarV = a.a.V(pVar, mVarD);
            i1.h.f4488c.getClass();
            p7.a aVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(aVar);
            } else {
                pVar.e0();
            }
            i1.f fVar2 = i1.g.f4477e;
            b0.b.q(pVar, rVarA, fVar2);
            i1.f fVar3 = i1.g.f4476d;
            b0.b.q(pVar, t1VarL, fVar3);
            i1.f fVar4 = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
                a1.a.r(iK, pVar, iK, fVar4);
            }
            i1.f fVar5 = i1.g.f4475c;
            b0.b.q(pVar, mVarV, fVar5);
            a0.d(0, pVar);
            float f11 = 12;
            n0.j jVar2 = n0.j.f6796a;
            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar2, f11));
            a0.h(0, pVar);
            float f12 = 10;
            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar2, f12));
            f1 f1Var = this.f10757h;
            e eVar = (e) f1Var.getValue();
            f1 f1Var2 = this.f10758i;
            boolean zBooleanValue = ((Boolean) f1Var2.getValue()).booleanValue();
            boolean zBooleanValue2 = ((Boolean) this.f10759j.getValue()).booleanValue();
            String str = (String) this.f10760k.getValue();
            pVar.S(-2141858798);
            Object objJ = pVar.J();
            Object obj3 = b0.k.f1229a;
            if (objJ == obj3) {
                jVar = jVar2;
                f10 = f12;
                objJ = new n(this.f10761l, 1);
                pVar.b0(objJ);
            } else {
                jVar = jVar2;
                f10 = f12;
            }
            pVar.q(false);
            l0.q qVar = this.f10755f;
            n0.j jVar3 = jVar;
            a0.i(eVar, zBooleanValue, zBooleanValue2, str, qVar, (p7.a) objJ, pVar, 221184);
            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar3, f11));
            n0.m mVarI = n7.m.I(r.s.a(), n7.m.E(pVar));
            r.r rVarA2 = r.p.a(new r.d(f10), cVar, pVar, 6);
            int iK2 = b0.b.k(pVar);
            t1 t1VarL2 = pVar.l();
            n0.m mVarV2 = a.a.V(pVar, mVarI);
            pVar.U();
            if (pVar.P) {
                pVar.k(aVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, rVarA2, fVar2);
            b0.b.q(pVar, t1VarL2, fVar3);
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK2))) {
                a1.a.r(iK2, pVar, iK2, fVar4);
            }
            b0.b.q(pVar, mVarV2, fVar5);
            pVar.S(350270124);
            for (b0 b0Var : a0.f10676k) {
                ArrayList arrayList = new ArrayList();
                ListIterator listIterator = qVar.listIterator();
                while (true) {
                    e7.a aVar2 = (e7.a) listIterator;
                    if (aVar2.hasNext()) {
                        Object next = aVar2.next();
                        if (b0Var.f10679c.contains(((a) next).f10660a)) {
                            arrayList.add(next);
                        }
                    }
                }
                a0.f(b0Var, arrayList, pVar, 0);
            }
            pVar.q(false);
            pVar.q(true);
            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar3, f11));
            boolean zBooleanValue3 = ((Boolean) f1Var2.getValue()).booleanValue();
            pVar.S(-2141839733);
            Object objJ2 = pVar.J();
            if (objJ2 == obj3) {
                tVar = this;
                objJ2 = new n(tVar.f10762m, 2);
                pVar.b0(objJ2);
            } else {
                tVar = this;
            }
            p7.a aVar3 = (p7.a) objJ2;
            pVar.q(false);
            pVar.S(-2141838443);
            c.i iVar = tVar.f10756g;
            boolean zH = pVar.h(iVar);
            Object objJ3 = pVar.J();
            if (zH || objJ3 == obj3) {
                objJ3 = new b0.l(iVar, qVar, f1Var, 3);
                pVar.b0(objJ3);
            }
            p7.a aVar4 = (p7.a) objJ3;
            pVar.q(false);
            pVar.S(-2141835852);
            boolean zH2 = pVar.h(iVar);
            Object objJ4 = pVar.J();
            if (zH2 || objJ4 == obj3) {
                objJ4 = new k0(iVar, 7);
                pVar.b0(objJ4);
            }
            pVar.q(false);
            a0.a(zBooleanValue3, aVar3, aVar4, (p7.a) objJ4, pVar, 48);
            pVar.q(true);
        }
        return c7.r.f1986a;
    }
}
