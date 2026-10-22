package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t2 implements u2 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7078a;

    public t2(Object obj) {
        this.f7078a = obj;
    }

    @Override // k0.u2
    public final Object a(s0.g gVar) {
        return this.f7078a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t2) && yb.k.a(this.f7078a, ((t2) obj).f7078a);
    }

    public final int hashCode() {
        Object obj = this.f7078a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "StaticValueHolder(value=" + this.f7078a + ')';
    }
}
