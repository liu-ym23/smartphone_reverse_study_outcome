package r;

import java.util.List;

/* loaded from: classes.dex */
public final class i0 implements g1.p, e0 {

    /* renamed from: a, reason: collision with root package name */
    public final c f8870a;

    /* renamed from: b, reason: collision with root package name */
    public final n0.d f8871b;

    public i0(c cVar, n0.d dVar) {
        this.f8870a = cVar;
        this.f8871b = dVar;
    }

    @Override // r.e0
    public final int a(g1.s sVar) {
        return sVar.f3757g;
    }

    @Override // g1.p
    public final i1.l0 b(i1.m0 m0Var, List list, long j2) {
        return n7.b.r(this, d2.a.j(j2), d2.a.i(j2), d2.a.h(j2), d2.a.g(j2), m0Var.y(this.f8870a.a()), m0Var, list, new g1.s[list.size()], list.size());
    }

    @Override // r.e0
    public final i1.l0 c(g1.s[] sVarArr, i1.m0 m0Var, int[] iArr, int i2, int i10) {
        return m0Var.l0(i2, i10, d7.a0.f2944f, new h0(sVarArr, this, i10, iArr));
    }

    @Override // r.e0
    public final int d(g1.s sVar) {
        return sVar.f3756f;
    }

    @Override // r.e0
    public final long e(int i2, int i10, int i11, boolean z4) {
        return !z4 ? d2.b.a(i2, i10, 0, i11) : w7.e0.u(i2, i10, 0, i11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return q7.k.a(this.f8870a, i0Var.f8870a) && this.f8871b.equals(i0Var.f8871b);
    }

    @Override // r.e0
    public final void f(int i2, i1.m0 m0Var, int[] iArr, int[] iArr2) {
        this.f8870a.b(m0Var, i2, iArr, m0Var.c0(), iArr2);
    }

    public final int hashCode() {
        return Float.hashCode(this.f8871b.f6788a) + (this.f8870a.hashCode() * 31);
    }

    public final String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.f8870a + ", verticalAlignment=" + this.f8871b + ')';
    }
}
