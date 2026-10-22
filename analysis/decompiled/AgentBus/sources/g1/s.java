package g1;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: f, reason: collision with root package name */
    public int f3756f;

    /* renamed from: g, reason: collision with root package name */
    public int f3757g;

    /* renamed from: h, reason: collision with root package name */
    public long f3758h;

    /* renamed from: i, reason: collision with root package name */
    public long f3759i = u.f3764a;

    /* renamed from: j, reason: collision with root package name */
    public long f3760j = 0;

    public s() {
        long j2 = 0;
        this.f3758h = (j2 & 4294967295L) | (j2 << 32);
    }

    public int E() {
        return (int) (this.f3758h & 4294967295L);
    }

    public int G() {
        return (int) (this.f3758h >> 32);
    }

    public final void I() {
        this.f3756f = nb.i.k((int) (this.f3758h >> 32), d2.a.j(this.f3759i), d2.a.h(this.f3759i));
        this.f3757g = nb.i.k((int) (this.f3758h & 4294967295L), d2.a.i(this.f3759i), d2.a.g(this.f3759i));
        int i2 = this.f3756f;
        long j2 = this.f3758h;
        this.f3760j = (((i2 - ((int) (j2 >> 32))) / 2) << 32) | (4294967295L & ((r0 - ((int) (j2 & 4294967295L))) / 2));
    }

    public abstract void M(long j2, float f10, p7.k kVar);

    public final void N(long j2) {
        if (d2.k.a(this.f3758h, j2)) {
            return;
        }
        this.f3758h = j2;
        I();
    }

    public final void P(long j2) {
        if (d2.a.b(this.f3759i, j2)) {
            return;
        }
        this.f3759i = j2;
        I();
    }

    public abstract Object g();
}
