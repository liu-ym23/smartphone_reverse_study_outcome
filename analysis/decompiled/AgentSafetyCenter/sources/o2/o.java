package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public long f9130a;

    public static final boolean a(long j10, long j11) {
        return j10 == j11;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof o) && this.f9130a == ((o) obj).f9130a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9130a);
    }

    public final String toString() {
        long j10 = this.f9130a;
        return a(j10, 0L) ? "Unspecified" : a(j10, 4294967296L) ? "Sp" : a(j10, 8589934592L) ? "Em" : "Invalid";
    }
}
