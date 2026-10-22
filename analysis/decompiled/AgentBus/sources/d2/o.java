package d2;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final long f2800a;

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.f2800a == ((o) obj).f2800a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2800a);
    }

    public final String toString() {
        long j2 = this.f2800a;
        return a(j2, 0L) ? "Unspecified" : a(j2, 4294967296L) ? "Sp" : a(j2, 8589934592L) ? "Em" : "Invalid";
    }
}
