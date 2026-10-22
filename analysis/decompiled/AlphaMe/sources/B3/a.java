package B3;

/* loaded from: classes2.dex */
public final class a extends t3.g {

    /* renamed from: e, reason: collision with root package name */
    public final x3.b f215e;

    /* renamed from: f, reason: collision with root package name */
    public final x3.b f216f;

    /* renamed from: g, reason: collision with root package name */
    public final x3.a f217g;

    public a(x3.b bVar, x3.b bVar2) {
        x3.c cVar = x3.d.f15934a;
        this.f215e = bVar;
        this.f216f = bVar2;
        this.f217g = cVar;
    }

    @Override // t3.g
    public final void e() {
        this.f217g.b();
    }

    @Override // t3.g
    public final void f(Throwable th) {
        this.f216f.call(th);
    }

    @Override // t3.g
    public final void g(Object obj) {
        this.f215e.call(obj);
    }
}
