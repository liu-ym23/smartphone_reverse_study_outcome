package d5;

import la.k0;
import la.s0;
import la.u0;

/* loaded from: classes.dex */
public final class u implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2902a;

    /* renamed from: b, reason: collision with root package name */
    public final m f2903b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2904c;

    /* renamed from: d, reason: collision with root package name */
    public final t f2905d;

    /* renamed from: e, reason: collision with root package name */
    public final u0 f2906e;

    /* renamed from: f, reason: collision with root package name */
    public final la.i f2907f;

    /* renamed from: g, reason: collision with root package name */
    public final ka.g f2908g;

    public u(String str, m mVar, String str2, t tVar) {
        q7.k.e(str, "id");
        q7.k.e(mVar, "role");
        this.f2902a = str;
        this.f2903b = mVar;
        this.f2904c = str2;
        this.f2905d = tVar;
        this.f2906e = k0.c(q.f2898a);
        this.f2907f = la.i.f5927g;
        this.f2908g = a.a.b(Integer.MAX_VALUE, 6, null);
    }

    @Override // d5.e
    public final la.j a() {
        return this.f2907f;
    }

    @Override // d5.e
    public final Object b(i7.c cVar) {
        p pVar = new p("closed", null);
        u0 u0Var = this.f2906e;
        u0Var.getClass();
        u0Var.g(null, pVar);
        ka.y.close$default(this.f2908g, null, 1, null);
        return c7.r.f1986a;
    }

    @Override // d5.e
    public final t c() {
        return this.f2905d;
    }

    @Override // d5.e
    public final boolean d() {
        return d.getAcceptsBusinessRpc(this);
    }

    @Override // d5.e
    public final String e() {
        return this.f2904c;
    }

    @Override // d5.e
    public final m f() {
        return this.f2903b;
    }

    @Override // d5.e
    public final String g() {
        return d.getVendor(this);
    }

    @Override // d5.e
    public final String getId() {
        return this.f2902a;
    }

    @Override // d5.e
    public final s0 h() {
        return this.f2906e;
    }

    @Override // d5.e
    public final Object i(c5.b bVar, i7.c cVar) {
        this.f2908g.u(bVar);
        return c7.r.f1986a;
    }
}
