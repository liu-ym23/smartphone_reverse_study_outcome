package k5;

/* loaded from: classes.dex */
public final class o implements r {

    /* renamed from: a, reason: collision with root package name */
    public final l f5638a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5639b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5640c;

    public o(l lVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        q7.k.e(lVar, "reason");
        this.f5638a = lVar;
        this.f5639b = str;
        this.f5640c = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f5638a == oVar.f5638a && q7.k.a(this.f5639b, oVar.f5639b) && this.f5640c == oVar.f5640c;
    }

    public final int hashCode() {
        int iHashCode = this.f5638a.hashCode() * 31;
        String str = this.f5639b;
        return Long.hashCode(this.f5640c) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "FrameDropped(reason=" + this.f5638a + ", method=" + this.f5639b + ", timestamp=" + this.f5640c + ")";
    }
}
