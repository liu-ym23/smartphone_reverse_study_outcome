package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 implements u2 {

    /* renamed from: a, reason: collision with root package name */
    public k1 f6975a;

    @Override // k0.u2
    public final Object a(s0.g gVar) {
        return this.f6975a.getValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && this.f6975a.equals(((m0) obj).f6975a);
    }

    public final int hashCode() {
        return this.f6975a.hashCode();
    }

    public final String toString() {
        return "DynamicValueHolder(state=" + this.f6975a + ')';
    }
}
