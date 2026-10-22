package o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public long f9070a;

    public static final boolean a(long j10, long j11) {
        return j10 == j11;
    }

    public static String b(long j10) {
        return "PointerId(value=" + j10 + ')';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof r) && this.f9070a == ((r) obj).f9070a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9070a);
    }

    public final String toString() {
        return b(this.f9070a);
    }
}
