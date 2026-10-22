package M;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f4487a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4488b;

    public i(long j10, long j11) {
        this.f4487a = j10;
        this.f4488b = j11;
    }

    public long a() {
        return this.f4488b;
    }

    public long b() {
        return this.f4487a;
    }

    public String toString() {
        return this.f4487a + "/" + this.f4488b;
    }

    public i(double d10) {
        this((long) (d10 * 10000.0d), 10000L);
    }
}
