package m5;

import m.x;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final long f6428a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6429b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6430c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6431d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6432e;

    /* renamed from: f, reason: collision with root package name */
    public final long f6433f;

    /* renamed from: g, reason: collision with root package name */
    public final long f6434g;

    public l(long j2, long j4, long j10, long j11, long j12, long j13, long j14) {
        this.f6428a = j2;
        this.f6429b = j4;
        this.f6430c = j10;
        this.f6431d = j11;
        this.f6432e = j12;
        this.f6433f = j13;
        this.f6434g = j14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f6428a == lVar.f6428a && this.f6429b == lVar.f6429b && this.f6430c == lVar.f6430c && this.f6431d == lVar.f6431d && this.f6432e == lVar.f6432e && this.f6433f == lVar.f6433f && this.f6434g == lVar.f6434g;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6434g) + x.f(this.f6433f, x.f(this.f6432e, x.f(this.f6431d, x.f(this.f6430c, x.f(this.f6429b, Long.hashCode(this.f6428a) * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "HistogramSummary(count=" + this.f6428a + ", sum=" + this.f6429b + ", min=" + this.f6430c + ", max=" + this.f6431d + ", p50=" + this.f6432e + ", p90=" + this.f6433f + ", p99=" + this.f6434g + ")";
    }
}
