package c1;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final long f1803a;

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public static String b(long j2) {
        return "PointerId(value=" + j2 + ')';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f1803a == ((k) obj).f1803a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1803a);
    }

    public final String toString() {
        return b(this.f1803a);
    }
}
