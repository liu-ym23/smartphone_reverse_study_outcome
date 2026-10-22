package xc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements vc.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f15662a;

    /* renamed from: b, reason: collision with root package name */
    public final vc.e f15663b;

    /* renamed from: c, reason: collision with root package name */
    public final vc.e f15664c;

    public s(String str, vc.e eVar, vc.e eVar2) {
        this.f15662a = str;
        this.f15663b = eVar;
        this.f15664c = eVar2;
    }

    @Override // vc.e
    public final String a() {
        return this.f15662a;
    }

    @Override // vc.e
    public final boolean c() {
        return false;
    }

    @Override // vc.e
    public final int d() {
        return 2;
    }

    @Override // vc.e
    public final String e(int i) {
        return String.valueOf(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f15662a.equals(sVar.f15662a) && this.f15663b.equals(sVar.f15663b) && this.f15664c.equals(sVar.f15664c);
    }

    @Override // vc.e
    public final vc.e f(int i) {
        if (i < 0) {
            od.f.c(androidx.activity.b.n(k0.a.t(i, "Illegal index ", ", "), this.f15662a, " expects only non-negative indices"));
            return null;
        }
        int i3 = i % 2;
        if (i3 == 0) {
            return this.f15663b;
        }
        if (i3 == 1) {
            return this.f15664c;
        }
        od.f.e("Unreached");
        return null;
    }

    @Override // vc.e
    public final t.o getKind() {
        return vc.g.f14893d;
    }

    public final int hashCode() {
        return this.f15664c.hashCode() + ((this.f15663b.hashCode() + (this.f15662a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return this.f15662a + '(' + this.f15663b + ", " + this.f15664c + ')';
    }
}
