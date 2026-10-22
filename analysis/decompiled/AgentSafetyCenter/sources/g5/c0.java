package g5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public long f4284a;

    /* renamed from: b, reason: collision with root package name */
    public long f4285b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c0.class.equals(obj.getClass())) {
            c0 c0Var = (c0) obj;
            if (c0Var.f4284a == this.f4284a && c0Var.f4285b == this.f4285b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4285b) + (Long.hashCode(this.f4284a) * 31);
    }

    public final String toString() {
        return "PeriodicityInfo{repeatIntervalMillis=" + this.f4284a + ", flexIntervalMillis=" + this.f4285b + '}';
    }
}
