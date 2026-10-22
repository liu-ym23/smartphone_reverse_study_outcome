package C0;

import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class p<Z> implements v<Z> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f464a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f465b;

    /* renamed from: c, reason: collision with root package name */
    private final v<Z> f466c;

    /* renamed from: d, reason: collision with root package name */
    private a f467d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC1340f f468e;

    /* renamed from: f, reason: collision with root package name */
    private int f469f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f470g;

    interface a {
        void c(InterfaceC1340f interfaceC1340f, p<?> pVar);
    }

    p(v<Z> vVar, boolean z5, boolean z6) {
        this.f466c = (v) X0.j.d(vVar);
        this.f464a = z5;
        this.f465b = z6;
    }

    synchronized void a() {
        if (this.f470g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f469f++;
    }

    @Override // C0.v
    public synchronized void b() {
        if (this.f469f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f470g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f470g = true;
        if (this.f465b) {
            this.f466c.b();
        }
    }

    @Override // C0.v
    public int c() {
        return this.f466c.c();
    }

    @Override // C0.v
    public Class<Z> d() {
        return this.f466c.d();
    }

    v<Z> e() {
        return this.f466c;
    }

    boolean f() {
        return this.f464a;
    }

    void g() {
        synchronized (this.f467d) {
            synchronized (this) {
                try {
                    int i5 = this.f469f;
                    if (i5 <= 0) {
                        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                    }
                    int i6 = i5 - 1;
                    this.f469f = i6;
                    if (i6 == 0) {
                        this.f467d.c(this.f468e, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // C0.v
    public Z get() {
        return this.f466c.get();
    }

    synchronized void h(InterfaceC1340f interfaceC1340f, a aVar) {
        this.f468e = interfaceC1340f;
        this.f467d = aVar;
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f464a + ", listener=" + this.f467d + ", key=" + this.f468e + ", acquired=" + this.f469f + ", isRecycled=" + this.f470g + ", resource=" + this.f466c + '}';
    }
}
