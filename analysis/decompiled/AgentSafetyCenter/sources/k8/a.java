package k8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f7274a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f7275b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7276c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7277d;

    public a(long j10, long j11, long j12, int i) {
        j11 = (i & 4) != 0 ? 0L : j11;
        j12 = (i & 8) != 0 ? 0L : j12;
        this.f7274a = j10;
        this.f7275b = null;
        this.f7276c = j11;
        this.f7277d = j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7274a == aVar.f7274a && yb.k.a(this.f7275b, aVar.f7275b) && this.f7276c == aVar.f7276c && this.f7277d == aVar.f7277d;
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.f7274a) * 31;
        Integer num = this.f7275b;
        return Long.hashCode(this.f7277d) + k0.a.i(this.f7276c, (iHashCode + (num == null ? 0 : num.hashCode())) * 31, 31);
    }

    public final String toString() {
        return "ActionListChartFocus(anchorDayStartMillis=" + this.f7274a + ", todayHourIndex=" + this.f7275b + ", weekBucketStartMillis=" + this.f7276c + ", weekBucketEndMillis=" + this.f7277d + ")";
    }
}
