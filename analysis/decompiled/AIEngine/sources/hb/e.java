package hb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f9388a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9389b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9390c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9391d;

    /* renamed from: e, reason: collision with root package name */
    public long f9392e;

    public e() {
        this(0, 0, 0L, 0L, 0L);
    }

    public final long a() {
        return this.f9391d;
    }

    public final int b() {
        return this.f9388a;
    }

    public final int c() {
        return this.f9389b;
    }

    public final long d() {
        return this.f9390c;
    }

    public final boolean e() {
        return this.f9390c + this.f9392e == this.f9391d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f9388a == eVar.f9388a && this.f9389b == eVar.f9389b && this.f9390c == eVar.f9390c && this.f9391d == eVar.f9391d && this.f9392e == eVar.f9392e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9392e) + a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.f9389b, Integer.hashCode(this.f9388a) * 31, 31), this.f9390c, 31), this.f9391d, 31);
    }

    public final String toString() {
        long j10 = this.f9392e;
        StringBuilder sbD = h0.e.d(this.f9388a, "FileSlice(id=", this.f9389b, ", position=", ", startBytes=");
        sbD.append(this.f9390c);
        a0.a.s(this.f9391d, ", endBytes=", ", downloaded=", sbD);
        return ai.onnxruntime.a.m(sbD, j10, ")");
    }

    public e(int i10, int i11, long j10, long j11, long j12) {
        this.f9388a = i10;
        this.f9389b = i11;
        this.f9390c = j10;
        this.f9391d = j11;
        this.f9392e = j12;
    }
}
