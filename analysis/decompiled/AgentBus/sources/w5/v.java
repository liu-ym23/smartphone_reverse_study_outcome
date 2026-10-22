package w5;

import androidx.compose.foundation.layout.FillElement;
import b0.f1;
import b0.t1;
import java.util.ArrayList;
import r.g0;
import r.i0;
import r.j0;
import y.k0;

/* loaded from: classes.dex */
public final class v implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f1 f10765f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b0 f10766g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f10767h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10768i;

    public v(f1 f1Var, b0 b0Var, b bVar, ArrayList arrayList) {
        this.f10765f = f1Var;
        this.f10766g = b0Var;
        this.f10767h = bVar;
        this.f10768i = arrayList;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0.p pVar = (b0.p) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6784r, pVar, 0);
            int iK = b0.b.k(pVar);
            t1 t1VarL = pVar.l();
            FillElement fillElement = androidx.compose.foundation.layout.a.f744a;
            n0.m mVarV = a.a.V(pVar, fillElement);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            i1.f fVar = i1.g.f4477e;
            b0.b.q(pVar, rVarA, fVar);
            i1.f fVar2 = i1.g.f4476d;
            b0.b.q(pVar, t1VarL, fVar2);
            i1.f fVar3 = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
                a1.a.r(iK, pVar, iK, fVar3);
            }
            i1.f fVar4 = i1.g.f4475c;
            b0.b.q(pVar, mVarV, fVar4);
            pVar.S(1862476056);
            f1 f1Var = this.f10765f;
            boolean zF = pVar.f(f1Var);
            Object objJ = pVar.J();
            if (zF || objJ == b0.k.f1229a) {
                objJ = new n(f1Var, 3);
                pVar.b0(objJ);
            }
            pVar.q(false);
            n0.m mVarD = androidx.compose.foundation.layout.a.d(androidx.compose.foundation.a.c(fillElement, false, (p7.a) objJ, 7), 12);
            i0 i0VarA = g0.a(r.i.f8866a, n0.b.f6782p, pVar, 48);
            int iK2 = b0.b.k(pVar);
            t1 t1VarL2 = pVar.l();
            n0.m mVarV2 = a.a.V(pVar, mVarD);
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, i0VarA, fVar);
            b0.b.q(pVar, t1VarL2, fVar2);
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK2))) {
                a1.a.r(iK2, pVar, iK2, fVar3);
            }
            b0.b.q(pVar, mVarV2, fVar4);
            k0.a(((Boolean) f1Var.getValue()).booleanValue() ? "▾" : "▸", null, a0.f10675j, s7.a.z(12), null, v1.p.f10370c, 0L, 0L, 0, false, 0, 0, null, pVar, 3456, 0, 130994);
            n7.m.b(pVar, androidx.compose.foundation.layout.a.h(8));
            b0 b0Var = this.f10766g;
            k0.a("Phase " + b0Var.f10677a + ": " + b0Var.f10678b, j0.a(), a0.f10674i, s7.a.z(13), v1.k.f10359i, null, 0L, 0L, 0, false, 0, 0, null, pVar, 200064, 0, 131024);
            a0.g(this.f10767h, pVar, 0);
            pVar.q(true);
            androidx.compose.animation.a.b(((Boolean) f1Var.getValue()).booleanValue(), null, m.t.a(), m.t.b(), null, j0.i.d(930384793, new u(0, this.f10768i), pVar), pVar, 1600518);
            pVar.q(true);
        }
        return c7.r.f1986a;
    }
}
