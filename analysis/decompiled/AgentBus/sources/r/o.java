package r;

import java.util.List;

/* loaded from: classes.dex */
public final class o implements g1.p {

    /* renamed from: a, reason: collision with root package name */
    public final n0.e f8905a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8906b;

    public o(n0.e eVar, boolean z4) {
        this.f8905a = eVar;
        this.f8906b = z4;
    }

    @Override // g1.p
    public final i1.l0 b(i1.m0 m0Var, List list, long j2) {
        long j4;
        long jA;
        boolean zIsEmpty = list.isEmpty();
        d7.a0 a0Var = d7.a0.f2944f;
        if (zIsEmpty) {
            return m0Var.l0(d2.a.j(j2), d2.a.i(j2), a0Var, j.f8873i);
        }
        if (this.f8906b) {
            j4 = j2;
            jA = j4;
        } else {
            j4 = j2;
            jA = d2.a.a(j4, 0, 0, 10);
        }
        if (list.size() == 1) {
            g1.o oVar = (g1.o) list.get(0);
            oVar.g();
            g1.s sVarB = oVar.b(jA);
            int iMax = Math.max(d2.a.j(j4), sVarB.f3756f);
            int iMax2 = Math.max(d2.a.i(j4), sVarB.f3757g);
            return m0Var.l0(iMax, iMax2, a0Var, new m(sVarB, oVar, m0Var, iMax, iMax2, this));
        }
        g1.s[] sVarArr = new g1.s[list.size()];
        q7.t tVar = new q7.t();
        tVar.f8818f = d2.a.j(j2);
        q7.t tVar2 = new q7.t();
        tVar2.f8818f = d2.a.i(j2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            g1.o oVar2 = (g1.o) list.get(i2);
            oVar2.g();
            g1.s sVarB2 = oVar2.b(jA);
            sVarArr[i2] = sVarB2;
            tVar.f8818f = Math.max(tVar.f8818f, sVarB2.f3756f);
            tVar2.f8818f = Math.max(tVar2.f8818f, sVarB2.f3757g);
        }
        return m0Var.l0(tVar.f8818f, tVar2.f8818f, a0Var, new n(sVarArr, list, m0Var, tVar, tVar2, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f8905a.equals(oVar.f8905a) && this.f8906b == oVar.f8906b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f8906b) + (this.f8905a.hashCode() * 31);
    }

    public final String toString() {
        return "BoxMeasurePolicy(alignment=" + this.f8905a + ", propagateMinConstraints=" + this.f8906b + ')';
    }
}
