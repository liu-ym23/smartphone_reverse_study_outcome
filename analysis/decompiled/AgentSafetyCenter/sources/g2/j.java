package g2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public int f4250a;

    public final boolean equals(Object obj) {
        return (obj instanceof j) && this.f4250a == ((j) obj).f4250a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4250a);
    }

    public final String toString() {
        int i = this.f4250a;
        return i == 0 ? "None" : i == 1 ? "Weight" : i == 2 ? "Style" : i == 65535 ? "All" : "Invalid";
    }
}
