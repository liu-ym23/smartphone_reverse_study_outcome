package x;

import android.view.View;
import android.view.ViewGroup;
import b0.f1;
import b0.f2;
import b0.y0;
import j1.q0;
import m.x;
import o.g0;
import o.h0;
import u0.z;

/* loaded from: classes.dex */
public final class e implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final f1 f11005a;

    public e(f1 f1Var) {
        this.f11005a = f1Var;
    }

    @Override // o.g0
    public final h0 a(q.i iVar, b0.p pVar) {
        long j2;
        pVar.S(988743187);
        d dVar = (d) pVar.j(r.f11053a);
        f1 f1Var = this.f11005a;
        if (((u0.m) f1Var.getValue()).f9918a != u0.m.f9916f) {
            pVar.S(-303571590);
            pVar.q(false);
            j2 = ((u0.m) f1Var.getValue()).f9918a;
        } else {
            pVar.S(-303521246);
            dVar.getClass();
            pVar.S(2042140174);
            j2 = u0.m.f9912b;
            z.i(j2);
            pVar.q(false);
            pVar.q(false);
        }
        f1 f1VarP = b0.b.p(new u0.m(j2), pVar);
        dVar.getClass();
        pVar.S(-1629816343);
        f fVar = ((double) z.i(u0.m.f9912b)) > 0.5d ? r.f11054b : r.f11055c;
        pVar.q(false);
        f1 f1VarP2 = b0.b.p(fVar, pVar);
        pVar.S(331259447);
        ViewGroup viewGroupB = s.b((View) pVar.j(q0.f5303e));
        boolean zF = pVar.f(this) | pVar.f(iVar) | pVar.f(viewGroupB);
        Object objJ = pVar.J();
        Object obj = b0.k.f1229a;
        if (zF || objJ == obj) {
            objJ = new a(f1VarP, f1VarP2, viewGroupB);
            pVar.b0(objJ);
        }
        a aVar = (a) objJ;
        pVar.q(false);
        boolean zF2 = pVar.f(iVar) | pVar.h(aVar);
        Object objJ2 = pVar.J();
        if (zF2 || objJ2 == obj) {
            objJ2 = new f2(iVar, aVar, (g7.d) null, 23);
            pVar.b0(objJ2);
        }
        p7.n nVar = (p7.n) objJ2;
        g7.l lVar = pVar.O;
        boolean zF3 = pVar.f(iVar) | pVar.f(aVar);
        Object objJ3 = pVar.J();
        if (zF3 || objJ3 == obj) {
            objJ3 = new y0(lVar, nVar);
            pVar.b0(objJ3);
        }
        pVar.q(false);
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return d2.f.a(Float.NaN, Float.NaN) && this.f11005a.equals(((e) obj).f11005a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11005a.hashCode() + x.d(Float.NaN, Boolean.hashCode(true) * 31, 31);
    }
}
