package p5;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final long f8477a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8478b;

    public /* synthetic */ p() {
        this(0L, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f8477a == pVar.f8477a && this.f8478b == pVar.f8478b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8478b) + (Long.hashCode(this.f8477a) * 31);
    }

    public final String toString() {
        return "PeerState(lastWakeAtMs=" + this.f8477a + ", consecutiveNoShow=" + this.f8478b + ")";
    }

    public p(long j2, int i2) {
        this.f8477a = j2;
        this.f8478b = i2;
    }
}
