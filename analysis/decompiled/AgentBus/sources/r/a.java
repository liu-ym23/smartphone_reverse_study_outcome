package r;

import b0.o1;

/* loaded from: classes.dex */
public final class a implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f8837a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8838b;

    /* renamed from: c, reason: collision with root package name */
    public final o1 f8839c = b0.b.n(k2.a.f5574e);

    /* renamed from: d, reason: collision with root package name */
    public final o1 f8840d = b0.b.n(Boolean.TRUE);

    public a(int i2, String str) {
        this.f8837a = i2;
        this.f8838b = str;
    }

    @Override // r.o0
    public final int a(i1.m0 m0Var, d2.l lVar) {
        return e().f5577c;
    }

    @Override // r.o0
    public final int b(i1.m0 m0Var) {
        return e().f5576b;
    }

    @Override // r.o0
    public final int c(i1.m0 m0Var) {
        return e().f5578d;
    }

    @Override // r.o0
    public final int d(i1.m0 m0Var, d2.l lVar) {
        return e().f5575a;
    }

    public final k2.a e() {
        return (k2.a) this.f8839c.getValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f8837a == ((a) obj).f8837a;
        }
        return false;
    }

    public final void f(o2.j0 j0Var, int i2) {
        int i10 = this.f8837a;
        if (i2 == 0 || (i2 & i10) != 0) {
            this.f8839c.setValue(j0Var.f7236a.h(i10));
            this.f8840d.setValue(Boolean.valueOf(j0Var.f7236a.p(i10)));
        }
    }

    public final int hashCode() {
        return this.f8837a;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8838b);
        sb2.append('(');
        sb2.append(e().f5575a);
        sb2.append(", ");
        sb2.append(e().f5576b);
        sb2.append(", ");
        sb2.append(e().f5577c);
        sb2.append(", ");
        return m.x.m(sb2, e().f5578d, ')');
    }
}
