package d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 implements o2.c {

    /* renamed from: c, reason: collision with root package name */
    public int f2975c;

    /* renamed from: f, reason: collision with root package name */
    public float f2976f;

    /* renamed from: g, reason: collision with root package name */
    public float f2977g;

    /* renamed from: h, reason: collision with root package name */
    public float f2978h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public long f2979j;

    /* renamed from: k, reason: collision with root package name */
    public long f2980k;

    /* renamed from: l, reason: collision with root package name */
    public float f2981l;

    /* renamed from: m, reason: collision with root package name */
    public long f2982m;

    /* renamed from: n, reason: collision with root package name */
    public j0 f2983n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2984o;

    /* renamed from: p, reason: collision with root package name */
    public long f2985p;

    /* renamed from: q, reason: collision with root package name */
    public o2.c f2986q;

    /* renamed from: r, reason: collision with root package name */
    public o2.l f2987r;

    /* renamed from: s, reason: collision with root package name */
    public int f2988s;

    /* renamed from: t, reason: collision with root package name */
    public c0 f2989t;

    @Override // o2.c
    public final float T() {
        return this.f2986q.T();
    }

    @Override // o2.c
    public final float a() {
        return this.f2986q.a();
    }

    public final void b(float f5) {
        if (this.f2978h == f5) {
            return;
        }
        this.f2975c |= 4;
        this.f2978h = f5;
    }

    public final void c(float f5) {
        if (this.f2976f == f5) {
            return;
        }
        this.f2975c |= 1;
        this.f2976f = f5;
    }

    public final void d(float f5) {
        if (this.f2977g == f5) {
            return;
        }
        this.f2975c |= 2;
        this.f2977g = f5;
    }

    public final void f(long j10) {
        if (m0.b(this.f2982m, j10)) {
            return;
        }
        this.f2975c |= 4096;
        this.f2982m = j10;
    }
}
