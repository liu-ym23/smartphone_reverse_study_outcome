package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: c, reason: collision with root package name */
    public int f11277c;

    /* renamed from: f, reason: collision with root package name */
    public int f11278f;

    /* renamed from: g, reason: collision with root package name */
    public long f11279g;

    /* renamed from: h, reason: collision with root package name */
    public long f11280h = q0.f11290a;
    public long i = 0;

    public o0() {
        long j10 = 0;
        this.f11279g = (j10 & 4294967295L) | (j10 << 32);
    }

    public abstract int H(l lVar);

    public int I() {
        return (int) (this.f11279g & 4294967295L);
    }

    public int L() {
        return (int) (this.f11279g >> 32);
    }

    public final void N() {
        this.f11277c = p5.f.q((int) (this.f11279g >> 32), o2.a.k(this.f11280h), o2.a.i(this.f11280h));
        this.f11278f = p5.f.q((int) (this.f11279g & 4294967295L), o2.a.j(this.f11280h), o2.a.h(this.f11280h));
        int i = this.f11277c;
        long j10 = this.f11279g;
        this.i = (((i - ((int) (j10 >> 32))) / 2) << 32) | (4294967295L & ((r0 - ((int) (j10 & 4294967295L))) / 2));
    }

    public abstract void R(long j10, float f5, xb.l lVar);

    public final void S(long j10) {
        if (o2.k.b(this.f11279g, j10)) {
            return;
        }
        this.f11279g = j10;
        N();
    }

    public final void U(long j10) {
        if (o2.a.c(this.f11280h, j10)) {
            return;
        }
        this.f11280h = j10;
        N();
    }

    public abstract Object v();
}
