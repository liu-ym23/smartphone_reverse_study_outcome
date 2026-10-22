package a1;

import a2.m;
import u1.i0;
import u1.i1;
import u1.n;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends l implements i1, a, n {

    /* renamed from: s, reason: collision with root package name */
    public d f11s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12t;

    /* renamed from: u, reason: collision with root package name */
    public m f13u;

    public final void B0() {
        this.f12t = false;
        this.f11s.f15f = null;
        u1.f.l(this);
    }

    @Override // u1.n
    public final void H() {
        B0();
    }

    @Override // u1.l
    public final void L() {
        B0();
    }

    @Override // a1.a
    public final o2.c a() {
        return u1.f.u(this).A;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [xb.l, yb.l] */
    @Override // u1.n
    public final void b(i0 i0Var) {
        d dVar = this.f11s;
        if (!this.f12t) {
            dVar.f15f = null;
            u1.f.r(this, new b(0, this, dVar));
            if (dVar.f15f == null) {
                throw w2.c.a("DrawResult not defined, did you forget to call onDraw?");
            }
            this.f12t = true;
        }
        g gVar = dVar.f15f;
        gVar.getClass();
        ((yb.l) gVar.f19f).invoke(i0Var);
    }

    @Override // u1.l
    public final void c() {
        B0();
    }

    @Override // u1.i1
    public final void c0() {
        B0();
    }

    @Override // a1.a
    public final long e() {
        return ac.a.i0(u1.f.s(this, 128).f11279g);
    }

    @Override // a1.a
    public final o2.l getLayoutDirection() {
        return u1.f.u(this).B;
    }

    @Override // w0.l
    public final void v0() {
        B0();
    }

    @Override // w0.l
    public final void u0() {
    }
}
