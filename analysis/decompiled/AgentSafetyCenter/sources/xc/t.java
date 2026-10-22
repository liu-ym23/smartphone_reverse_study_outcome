package xc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class t implements vc.e {

    /* renamed from: a, reason: collision with root package name */
    public final vc.e f15666a;

    public t(vc.e eVar) {
        this.f15666a = eVar;
    }

    @Override // vc.e
    public final boolean c() {
        return false;
    }

    @Override // vc.e
    public final int d() {
        return 1;
    }

    @Override // vc.e
    public final String e(int i) {
        return String.valueOf(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f15666a.equals(tVar.f15666a) && yb.k.a(a(), tVar.a());
    }

    @Override // vc.e
    public final vc.e f(int i) {
        if (i >= 0) {
            return this.f15666a;
        }
        StringBuilder sbT = k0.a.t(i, "Illegal index ", ", ");
        sbT.append(a());
        sbT.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbT.toString().toString());
    }

    @Override // vc.e
    public final t.o getKind() {
        return vc.g.f14892c;
    }

    public final int hashCode() {
        return a().hashCode() + (this.f15666a.hashCode() * 31);
    }

    public final String toString() {
        return a() + '(' + this.f15666a + ')';
    }
}
