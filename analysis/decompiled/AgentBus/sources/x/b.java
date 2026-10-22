package x;

import android.view.View;
import i1.h0;
import j1.q0;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class b extends p implements m {
    public l D;
    public n E;

    @Override // x.m
    public final void P() {
        this.E = null;
        i1.l.l(this);
    }

    @Override // n0.l
    public final void e0() {
        l lVar = this.D;
        if (lVar != null) {
            P();
            nb.f fVar = lVar.f11035i;
            n nVar = (n) ((LinkedHashMap) fVar.f6947g).get(this);
            if (nVar != null) {
                nVar.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) fVar.f6947g;
                n nVar2 = (n) linkedHashMap.get(this);
                if (nVar2 != null) {
                }
                linkedHashMap.remove(this);
                lVar.f11034h.add(nVar);
            }
        }
    }

    @Override // x.p
    public final void l0(q.k kVar, long j2, float f10) {
        l lVarA = this.D;
        if (lVarA == null) {
            lVarA = s.a(s.b((View) i1.l.h(this, q0.f5303e)));
            this.D = lVarA;
        }
        n nVarA = lVarA.a(this);
        int iU = s7.a.U(f10);
        long jL = this.f11048w.L();
        this.f11049x.c();
        nVarA.b(kVar, this.f11046u, j2, iU, jL, 0.1f, new t9.h(13, this));
        this.E = nVarA;
        i1.l.l(this);
    }

    @Override // x.p
    public final void m0(h0 h0Var) {
        u0.l lVarA = h0Var.f4489f.f10630g.a();
        n nVar = this.E;
        if (nVar != null) {
            long j2 = this.A;
            long jL = this.f11048w.L();
            this.f11049x.c();
            nVar.e(j2, jL, 0.1f);
            nVar.draw(u0.b.a(lVarA));
        }
    }

    @Override // x.p
    public final void o0(q.k kVar) {
        n nVar = this.E;
        if (nVar != null) {
            nVar.d();
        }
    }
}
