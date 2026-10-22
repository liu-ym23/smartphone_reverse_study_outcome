package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d2 implements e2 {

    /* renamed from: a, reason: collision with root package name */
    public long f11543a;

    /* renamed from: b, reason: collision with root package name */
    public String f11544b;

    /* renamed from: c, reason: collision with root package name */
    public int f11545c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f11543a == d2Var.f11543a && this.f11544b.equals(d2Var.f11544b) && this.f11545c == d2Var.f11545c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11545c) + androidx.activity.b.d(Long.hashCode(this.f11543a) * 31, 31, this.f11544b);
    }

    public final String toString() {
        return "SectionHeader(dayMillis=" + this.f11543a + ", title=" + this.f11544b + ", interceptCount=" + this.f11545c + ")";
    }
}
