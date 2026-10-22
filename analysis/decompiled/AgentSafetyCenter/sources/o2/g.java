package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public long f9115a;

    public final boolean equals(Object obj) {
        return (obj instanceof g) && this.f9115a == ((g) obj).f9115a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9115a);
    }

    public final String toString() {
        long j10 = this.f9115a;
        if (j10 == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return "(" + ((Object) f.c(Float.intBitsToFloat((int) (j10 >> 32)))) + ", " + ((Object) f.c(Float.intBitsToFloat((int) (j10 & 4294967295L)))) + ')';
    }
}
