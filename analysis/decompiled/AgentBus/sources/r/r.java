package r;

import java.util.List;

/* loaded from: classes.dex */
public final class r implements g1.p, e0 {

    /* renamed from: a, reason: collision with root package name */
    public final g f8935a;

    /* renamed from: b, reason: collision with root package name */
    public final n0.c f8936b;

    public r(g gVar, n0.c cVar) {
        this.f8935a = gVar;
        this.f8936b = cVar;
    }

    @Override // r.e0
    public final int a(g1.s sVar) {
        return sVar.f3756f;
    }

    @Override // g1.p
    public final i1.l0 b(i1.m0 m0Var, List list, long j2) {
        return n7.b.r(this, d2.a.i(j2), d2.a.j(j2), d2.a.g(j2), d2.a.h(j2), m0Var.y(this.f8935a.a()), m0Var, list, new g1.s[list.size()], list.size());
    }

    @Override // r.e0
    public final i1.l0 c(g1.s[] sVarArr, i1.m0 m0Var, int[] iArr, int i2, int i10) {
        return m0Var.l0(i10, i2, d7.a0.f2944f, new q(sVarArr, this, i10, m0Var, iArr));
    }

    @Override // r.e0
    public final int d(g1.s sVar) {
        return sVar.f3757g;
    }

    @Override // r.e0
    public final long e(int i2, int i10, int i11, boolean z4) {
        return !z4 ? d2.b.a(0, i11, i2, i10) : w7.e0.t(0, i11, i2, i10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f8935a.equals(rVar.f8935a) && this.f8936b.equals(rVar.f8936b);
    }

    @Override // r.e0
    public final void f(int i2, i1.m0 m0Var, int[] iArr, int[] iArr2) {
        this.f8935a.c(i2, m0Var, iArr, iArr2);
    }

    public final int hashCode() {
        return Float.hashCode(this.f8936b.f6787a) + (this.f8935a.hashCode() * 31);
    }

    public final String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.f8935a + ", horizontalAlignment=" + this.f8936b + ')';
    }
}
