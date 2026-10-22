package y3;

import Z2.I;

/* loaded from: classes2.dex */
public final class d extends t3.g {

    /* renamed from: e, reason: collision with root package name */
    public final t3.g f16354e;

    /* renamed from: f, reason: collision with root package name */
    public final x3.e f16355f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16356g;

    public d(t3.g gVar, x3.e eVar) {
        this.f16354e = gVar;
        this.f16355f = eVar;
    }

    @Override // t3.g
    public final void e() {
        if (this.f16356g) {
            return;
        }
        this.f16354e.e();
    }

    @Override // t3.g
    public final void f(Throwable th) {
        if (this.f16356g) {
            E3.c.a(th);
        } else {
            this.f16356g = true;
            this.f16354e.f(th);
        }
    }

    @Override // t3.g
    public final void g(Object obj) {
        try {
            this.f16354e.g(this.f16355f.call(obj));
        } catch (Throwable th) {
            I.D(th);
            c();
            w3.h.a(obj, th);
            f(th);
        }
    }

    @Override // t3.g
    public final void i(t3.d dVar) {
        this.f16354e.i(dVar);
    }
}
