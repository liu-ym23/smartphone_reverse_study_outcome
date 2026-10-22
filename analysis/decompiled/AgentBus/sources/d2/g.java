package d2;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final long f2785a;

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f2785a == ((g) obj).f2785a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2785a);
    }

    public final String toString() {
        long j2 = this.f2785a;
        if (j2 == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return "(" + ((Object) f.b(Float.intBitsToFloat((int) (j2 >> 32)))) + ", " + ((Object) f.b(Float.intBitsToFloat((int) (4294967295L & j2)))) + ')';
    }
}
