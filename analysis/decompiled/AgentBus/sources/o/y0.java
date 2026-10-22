package o;

import b0.f2;
import b0.l1;

/* loaded from: classes.dex */
public final class y0 implements p.t0 {

    /* renamed from: n, reason: collision with root package name */
    public static final q6.b f7158n = new q6.b(17, w0.f7140g, k.f7074j);

    /* renamed from: f, reason: collision with root package name */
    public final l1 f7159f;

    /* renamed from: g, reason: collision with root package name */
    public final l1 f7160g = new l1(0);

    /* renamed from: h, reason: collision with root package name */
    public final q.i f7161h = new q.i();

    /* renamed from: i, reason: collision with root package name */
    public final l1 f7162i = new l1(Integer.MAX_VALUE);

    /* renamed from: j, reason: collision with root package name */
    public float f7163j;

    /* renamed from: k, reason: collision with root package name */
    public final a4.p f7164k;

    /* renamed from: l, reason: collision with root package name */
    public final b0.i0 f7165l;

    /* renamed from: m, reason: collision with root package name */
    public final b0.i0 f7166m;

    public y0(int i2) {
        this.f7159f = new l1(i2);
        c1.w wVar = new c1.w(22, this);
        a4.p pVar = new a4.p();
        pVar.f192f = wVar;
        pVar.f193g = new p.l(pVar);
        pVar.f194h = new p0();
        Boolean bool = Boolean.FALSE;
        pVar.f195i = b0.b.n(bool);
        pVar.f196j = b0.b.n(bool);
        pVar.f197k = b0.b.n(bool);
        this.f7164k = pVar;
        this.f7165l = b0.b.j(new x0(this, 1));
        this.f7166m = b0.b.j(new x0(this, 0));
    }

    @Override // p.t0
    public final boolean a() {
        return ((Boolean) this.f7166m.getValue()).booleanValue();
    }

    @Override // p.t0
    public final Object b(int i2, f2 f2Var, i7.c cVar) {
        Object objB = this.f7164k.b(i2, f2Var, cVar);
        return objB == h7.a.f4212f ? objB : c7.r.f1986a;
    }

    @Override // p.t0
    public final boolean i() {
        return this.f7164k.i();
    }

    @Override // p.t0
    public final boolean l() {
        return ((Boolean) this.f7165l.getValue()).booleanValue();
    }

    @Override // p.t0
    public final float n(float f10) {
        return this.f7164k.n(f10);
    }
}
