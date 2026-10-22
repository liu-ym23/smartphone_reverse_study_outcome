package r;

import b0.o1;

/* loaded from: classes.dex */
public final class n0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8903a;

    /* renamed from: b, reason: collision with root package name */
    public final o1 f8904b;

    public n0(z zVar, String str) {
        this.f8903a = str;
        this.f8904b = b0.b.n(zVar);
    }

    @Override // r.o0
    public final int a(i1.m0 m0Var, d2.l lVar) {
        return e().f8955c;
    }

    @Override // r.o0
    public final int b(i1.m0 m0Var) {
        return e().f8954b;
    }

    @Override // r.o0
    public final int c(i1.m0 m0Var) {
        return e().f8956d;
    }

    @Override // r.o0
    public final int d(i1.m0 m0Var, d2.l lVar) {
        return e().f8953a;
    }

    public final z e() {
        return (z) this.f8904b.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n0) {
            return q7.k.a(e(), ((n0) obj).e());
        }
        return false;
    }

    public final void f(z zVar) {
        this.f8904b.setValue(zVar);
    }

    public final int hashCode() {
        return this.f8903a.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8903a);
        sb2.append("(left=");
        sb2.append(e().f8953a);
        sb2.append(", top=");
        sb2.append(e().f8954b);
        sb2.append(", right=");
        sb2.append(e().f8955c);
        sb2.append(", bottom=");
        return m.x.m(sb2, e().f8956d, ')');
    }
}
