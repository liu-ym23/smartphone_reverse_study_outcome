package hb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f9393a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9394b;

    public f(int i10, long j10) {
        this.f9393a = i10;
        this.f9394b = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f9393a == fVar.f9393a && this.f9394b == fVar.f9394b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9394b) + (Integer.hashCode(this.f9393a) * 31);
    }

    public final String toString() {
        return "FileSliceInfo(slicingCount=" + this.f9393a + ", bytesPerFileSlice=" + this.f9394b + ")";
    }
}
