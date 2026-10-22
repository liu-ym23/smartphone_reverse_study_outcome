package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 implements u2 {

    /* renamed from: a, reason: collision with root package name */
    public yb.l f6898a;

    /* JADX WARN: Type inference failed for: r0v1, types: [xb.l, yb.l] */
    @Override // k0.u2
    public final Object a(s0.g gVar) {
        return this.f6898a.invoke(gVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && this.f6898a.equals(((f0) obj).f6898a);
    }

    public final int hashCode() {
        return this.f6898a.hashCode();
    }

    public final String toString() {
        return "ComputedValueHolder(compute=" + this.f6898a + ')';
    }
}
