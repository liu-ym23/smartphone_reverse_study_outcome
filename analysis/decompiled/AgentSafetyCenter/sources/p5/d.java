package p5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f9719a;

    /* renamed from: b, reason: collision with root package name */
    public Long f9720b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9719a.equals(dVar.f9719a) && this.f9720b.equals(dVar.f9720b);
    }

    public final int hashCode() {
        return this.f9720b.hashCode() + (this.f9719a.hashCode() * 31);
    }

    public final String toString() {
        return "Preference(key=" + this.f9719a + ", value=" + this.f9720b + ')';
    }
}
