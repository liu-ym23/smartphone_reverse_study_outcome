package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q3 implements s3 {

    /* renamed from: a, reason: collision with root package name */
    public long f11909a;

    /* renamed from: b, reason: collision with root package name */
    public String f11910b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q3)) {
            return false;
        }
        q3 q3Var = (q3) obj;
        return this.f11909a == q3Var.f11909a && this.f11910b.equals(q3Var.f11910b);
    }

    public final int hashCode() {
        return this.f11910b.hashCode() + (Long.hashCode(this.f11909a) * 31);
    }

    public final String toString() {
        return "SectionHeader(dayMillis=" + this.f11909a + ", title=" + this.f11910b + ")";
    }
}
