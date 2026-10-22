package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: a, reason: collision with root package name */
    public y f15978a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.f15978a.equals(((l) obj).f15978a);
    }

    public final int hashCode() {
        return this.f15978a.hashCode();
    }

    public final String toString() {
        return "Updated(payload=" + this.f15978a + ")";
    }
}
