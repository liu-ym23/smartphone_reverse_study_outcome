package r0;

import c1.w;
import i1.f1;
import i1.h0;
import i1.m;
import ib.k;
import m.x;
import n0.l;
import o4.d0;

/* loaded from: classes.dex */
public final class b extends l implements f1, a, m {

    /* renamed from: t, reason: collision with root package name */
    public final c f8957t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8958u;

    /* renamed from: v, reason: collision with root package name */
    public final w f8959v;

    public b(c cVar, w wVar) {
        this.f8957t = cVar;
        this.f8959v = wVar;
        cVar.f8960f = this;
    }

    @Override // i1.m
    public final void T() {
        l0();
    }

    @Override // i1.j
    public final void W() {
        l0();
    }

    @Override // i1.j, i1.p1
    public final void b() {
        l0();
    }

    @Override // r0.a
    public final d2.c c() {
        return i1.l.u(this).A;
    }

    @Override // r0.a
    public final long d() {
        return k.W(i1.l.s(this, 128).f3758h);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [p7.k, q7.m] */
    @Override // i1.m
    public final void e(h0 h0Var) {
        boolean z4 = this.f8958u;
        c cVar = this.f8957t;
        if (!z4) {
            cVar.f8961g = null;
            i1.l.r(this, new a8.e(13, this, cVar));
            if (cVar.f8961g == null) {
                throw x.i("DrawResult not defined, did you forget to call onDraw?");
            }
            this.f8958u = true;
        }
        d0 d0Var = cVar.f8961g;
        q7.k.b(d0Var);
        ((q7.m) d0Var.f7326g).invoke(h0Var);
    }

    @Override // n0.l
    public final void e0() {
    }

    @Override // n0.l
    public final void f0() {
        l0();
    }

    @Override // r0.a
    public final d2.l getLayoutDirection() {
        return i1.l.u(this).B;
    }

    public final void l0() {
        this.f8958u = false;
        this.f8957t.f8961g = null;
        i1.l.l(this);
    }

    @Override // i1.f1
    public final void v() {
        l0();
    }
}
