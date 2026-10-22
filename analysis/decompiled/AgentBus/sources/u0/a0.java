package u0;

/* loaded from: classes.dex */
public final class a0 implements d2.c {

    /* renamed from: f, reason: collision with root package name */
    public int f9872f;

    /* renamed from: g, reason: collision with root package name */
    public float f9873g;

    /* renamed from: h, reason: collision with root package name */
    public float f9874h;

    /* renamed from: i, reason: collision with root package name */
    public float f9875i;

    /* renamed from: j, reason: collision with root package name */
    public float f9876j;

    /* renamed from: k, reason: collision with root package name */
    public long f9877k;

    /* renamed from: l, reason: collision with root package name */
    public long f9878l;

    /* renamed from: m, reason: collision with root package name */
    public float f9879m;

    /* renamed from: n, reason: collision with root package name */
    public long f9880n;

    /* renamed from: o, reason: collision with root package name */
    public c0 f9881o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9882p;

    /* renamed from: q, reason: collision with root package name */
    public long f9883q;

    /* renamed from: r, reason: collision with root package name */
    public d2.c f9884r;

    /* renamed from: s, reason: collision with root package name */
    public d2.l f9885s;

    /* renamed from: t, reason: collision with root package name */
    public int f9886t;

    /* renamed from: u, reason: collision with root package name */
    public w f9887u;

    public final void a(float f10) {
        if (this.f9875i == f10) {
            return;
        }
        this.f9872f |= 4;
        this.f9875i = f10;
    }

    public final void b(float f10) {
        if (this.f9873g == f10) {
            return;
        }
        this.f9872f |= 1;
        this.f9873g = f10;
    }

    @Override // d2.c
    public final float c() {
        return this.f9884r.c();
    }

    public final void e(float f10) {
        if (this.f9874h == f10) {
            return;
        }
        this.f9872f |= 2;
        this.f9874h = f10;
    }

    public final void f(long j2) {
        long j4 = this.f9880n;
        int i2 = f0.f9907b;
        if (j4 == j2) {
            return;
        }
        this.f9872f |= 4096;
        this.f9880n = j2;
    }

    @Override // d2.c
    public final float j() {
        return this.f9884r.j();
    }
}
