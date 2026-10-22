package y;

import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends w0.l implements v1 {

    /* renamed from: s, reason: collision with root package name */
    public xb.a f15752s;

    /* renamed from: t, reason: collision with root package name */
    public x.c f15753t;

    /* renamed from: u, reason: collision with root package name */
    public u.f0 f15754u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f15755v;

    /* renamed from: w, reason: collision with root package name */
    public a2.h f15756w;

    /* renamed from: x, reason: collision with root package name */
    public h0 f15757x;

    /* renamed from: y, reason: collision with root package name */
    public h0 f15758y;

    public final void B0() {
        this.f15756w = new a2.h(new g0(this, 1), new g0(this, 2));
        this.f15758y = this.f15755v ? new h0(this, 1) : null;
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        fc.c[] cVarArr = a2.w.f144a;
        a2.x xVar = a2.u.f128m;
        fc.c[] cVarArr2 = a2.w.f144a;
        fc.c cVar = cVarArr2[6];
        kVar.d(xVar, Boolean.TRUE);
        kVar.d(a2.u.J, this.f15757x);
        u.f0 f0Var = this.f15754u;
        a2.h hVar = this.f15756w;
        if (f0Var == u.f0.f13453c) {
            if (hVar == null) {
                yb.k.f("scrollAxisRange");
                throw null;
            }
            a2.x xVar2 = a2.u.f136u;
            fc.c cVar2 = cVarArr2[12];
            kVar.d(xVar2, hVar);
        } else {
            if (hVar == null) {
                yb.k.f("scrollAxisRange");
                throw null;
            }
            a2.x xVar3 = a2.u.f135t;
            fc.c cVar3 = cVarArr2[11];
            kVar.d(xVar3, hVar);
        }
        h0 h0Var = this.f15758y;
        if (h0Var != null) {
            kVar.d(a2.j.f55f, new a2.a(null, h0Var));
        }
        kVar.d(a2.j.A, new a2.a(null, new a2.m(new g0(this, 0), 1)));
        this.f15753t.getClass();
        a2.b bVar = new a2.b(-1, 1);
        a2.x xVar4 = a2.u.f122f;
        fc.c cVar4 = cVarArr2[22];
        kVar.d(xVar4, bVar);
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }
}
