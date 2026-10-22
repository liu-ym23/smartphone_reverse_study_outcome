package y;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f11349a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11350b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11351c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11352d;

    public a(long j2, long j4, long j10, long j11) {
        this.f11349a = j2;
        this.f11350b = j4;
        this.f11351c = j10;
        this.f11352d = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return u0.m.c(this.f11349a, aVar.f11349a) && u0.m.c(this.f11350b, aVar.f11350b) && u0.m.c(this.f11351c, aVar.f11351c) && u0.m.c(this.f11352d, aVar.f11352d);
    }

    public final int hashCode() {
        int i2 = u0.m.f9917g;
        return Long.hashCode(this.f11352d) + m.x.f(this.f11351c, m.x.f(this.f11350b, Long.hashCode(this.f11349a) * 31, 31), 31);
    }
}
