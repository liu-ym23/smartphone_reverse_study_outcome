package d2;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final long f2792a;

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public static String b(long j2) {
        return ((int) (j2 >> 32)) + " x " + ((int) (j2 & 4294967295L));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f2792a == ((k) obj).f2792a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2792a);
    }

    public final String toString() {
        return b(this.f2792a);
    }
}
