package C0;

import Y0.a;

/* loaded from: classes.dex */
final class u<Z> implements v<Z>, a.f {

    /* renamed from: e, reason: collision with root package name */
    private static final D.e<u<?>> f486e = Y0.a.d(20, new a());

    /* renamed from: a, reason: collision with root package name */
    private final Y0.c f487a = Y0.c.a();

    /* renamed from: b, reason: collision with root package name */
    private v<Z> f488b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f489c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f490d;

    class a implements a.d<u<?>> {
        a() {
        }

        @Override // Y0.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u<?> a() {
            return new u<>();
        }
    }

    u() {
    }

    private void a(v<Z> vVar) {
        this.f490d = false;
        this.f489c = true;
        this.f488b = vVar;
    }

    static <Z> u<Z> e(v<Z> vVar) {
        u<Z> uVar = (u) X0.j.d(f486e.b());
        uVar.a(vVar);
        return uVar;
    }

    private void f() {
        this.f488b = null;
        f486e.a(this);
    }

    @Override // C0.v
    public synchronized void b() {
        this.f487a.c();
        this.f490d = true;
        if (!this.f489c) {
            this.f488b.b();
            f();
        }
    }

    @Override // C0.v
    public int c() {
        return this.f488b.c();
    }

    @Override // C0.v
    public Class<Z> d() {
        return this.f488b.d();
    }

    @Override // Y0.a.f
    public Y0.c g() {
        return this.f487a;
    }

    @Override // C0.v
    public Z get() {
        return this.f488b.get();
    }

    synchronized void h() {
        this.f487a.c();
        if (!this.f489c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f489c = false;
        if (this.f490d) {
            b();
        }
    }
}
