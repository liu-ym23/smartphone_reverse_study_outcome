package xc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 implements vc.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f15626a;

    /* renamed from: b, reason: collision with root package name */
    public final vc.d f15627b;

    public f0(String str, vc.d dVar) {
        dVar.getClass();
        this.f15626a = str;
        this.f15627b = dVar;
    }

    @Override // vc.e
    public final String a() {
        return this.f15626a;
    }

    @Override // vc.e
    public final boolean c() {
        return false;
    }

    @Override // vc.e
    public final int d() {
        return 0;
    }

    @Override // vc.e
    public final String e(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f15626a.equals(f0Var.f15626a) && yb.k.a(this.f15627b, f0Var.f15627b);
    }

    @Override // vc.e
    public final vc.e f(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // vc.e
    public final t.o getKind() {
        return this.f15627b;
    }

    public final int hashCode() {
        return (this.f15627b.hashCode() * 31) + this.f15626a.hashCode();
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("PrimitiveDescriptor("), this.f15626a, ')');
    }
}
