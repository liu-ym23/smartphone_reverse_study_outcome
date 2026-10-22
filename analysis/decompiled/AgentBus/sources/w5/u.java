package w5;

import b0.t1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import y.k0;

/* loaded from: classes.dex */
public final class u implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10763f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Serializable f10764g;

    public /* synthetic */ u(int i2, Serializable serializable) {
        this.f10763f = i2;
        this.f10764g = serializable;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        switch (this.f10763f) {
            case 0:
                b0.p pVar = (b0.p) obj2;
                ((Number) obj3).intValue();
                q7.k.e((m.k) obj, "$this$AnimatedVisibility");
                float f10 = 12;
                n0.j jVar = n0.j.f6796a;
                n0.m mVarF = androidx.compose.foundation.layout.a.f(jVar, f10, 0.0f, f10, f10, 2);
                ArrayList arrayList = (ArrayList) this.f10764g;
                r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6784r, pVar, 0);
                int iK = b0.b.k(pVar);
                t1 t1VarL = pVar.l();
                n0.m mVarV = a.a.V(pVar, mVarF);
                i1.h.f4488c.getClass();
                i1.y yVar = i1.g.f4474b;
                pVar.U();
                if (pVar.P) {
                    pVar.k(yVar);
                } else {
                    pVar.e0();
                }
                b0.b.q(pVar, rVarA, i1.g.f4477e);
                b0.b.q(pVar, t1VarL, i1.g.f4476d);
                i1.f fVar = i1.g.f4478f;
                if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
                    a1.a.r(iK, pVar, iK, fVar);
                }
                b0.b.q(pVar, mVarV, i1.g.f4475c);
                y.a0.b(null, 0.0f, u0.z.c(4293256682L), pVar, 384, 3);
                n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar, 8));
                if (arrayList.isEmpty()) {
                    pVar.S(-1599692897);
                    k0.a("等待执行…", null, a0.f10671f, s7.a.z(11), null, null, 0L, 0L, 0, false, 0, 0, null, pVar, 3462, 0, 131058);
                    pVar = pVar;
                    pVar.q(false);
                } else {
                    pVar.S(-1599583436);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a0.b((a) it.next(), pVar, 0);
                        n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar, 6));
                    }
                    pVar.q(false);
                }
                pVar.q(true);
                return c7.r.f1986a;
            default:
                b0.p pVar2 = (b0.p) obj2;
                ((Number) obj3).intValue();
                q7.k.e((m.k) obj, "$this$AnimatedVisibility");
                float f11 = 16;
                n0.j jVar2 = n0.j.f6796a;
                n0.m mVarF2 = androidx.compose.foundation.layout.a.f(jVar2, f11, 0.0f, f11, f11, 2);
                c0 c0Var = (c0) this.f10764g;
                r.r rVarA2 = r.p.a(r.i.f8867b, n0.b.f6784r, pVar2, 0);
                int iK2 = b0.b.k(pVar2);
                t1 t1VarL2 = pVar2.l();
                n0.m mVarV2 = a.a.V(pVar2, mVarF2);
                i1.h.f4488c.getClass();
                i1.y yVar2 = i1.g.f4474b;
                pVar2.U();
                if (pVar2.P) {
                    pVar2.k(yVar2);
                } else {
                    pVar2.e0();
                }
                b0.b.q(pVar2, rVarA2, i1.g.f4477e);
                b0.b.q(pVar2, t1VarL2, i1.g.f4476d);
                i1.f fVar2 = i1.g.f4478f;
                if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iK2))) {
                    a1.a.r(iK2, pVar2, iK2, fVar2);
                }
                b0.b.q(pVar2, mVarV2, i1.g.f4475c);
                pVar2.S(-585741150);
                Iterator it2 = e0.f10700g.iterator();
                int i2 = 0;
                while (true) {
                    boolean z4 = true;
                    if (!it2.hasNext()) {
                        pVar2.q(false);
                        pVar2.q(true);
                        return c7.r.f1986a;
                    }
                    Object next = it2.next();
                    int i10 = i2 + 1;
                    if (i2 < 0) {
                        d7.s.z0();
                        throw null;
                    }
                    f0 f0Var = (f0) next;
                    pVar2.S(-585739526);
                    if (i2 > 0) {
                        y.a0.b(androidx.compose.foundation.layout.a.e(jVar2, 0, 8), 0.0f, u0.z.c(4293256682L), pVar2, 390, 2);
                    }
                    pVar2.q(false);
                    if (f0Var.f10707a != c0Var) {
                        z4 = false;
                    }
                    e0.d(f0Var, z4, pVar2, 0);
                    i2 = i10;
                }
                break;
        }
    }
}
