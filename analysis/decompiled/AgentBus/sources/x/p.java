package x;

import i1.h0;
import k.z;
import o4.d0;
import p.v;

/* loaded from: classes.dex */
public abstract class p extends n0.l implements i1.i, i1.m, i1.u {
    public boolean B;

    /* renamed from: t, reason: collision with root package name */
    public final q.i f11045t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f11046u;

    /* renamed from: v, reason: collision with root package name */
    public final float f11047v;

    /* renamed from: w, reason: collision with root package name */
    public final d0 f11048w;

    /* renamed from: x, reason: collision with root package name */
    public final y.m f11049x;

    /* renamed from: y, reason: collision with root package name */
    public c1.o f11050y;

    /* renamed from: z, reason: collision with root package name */
    public float f11051z;
    public long A = 0;
    public final z C = new z();

    public p(q.i iVar, boolean z4, float f10, d0 d0Var, y.m mVar) {
        this.f11045t = iVar;
        this.f11046u = z4;
        this.f11047v = f10;
        this.f11048w = d0Var;
        this.f11049x = mVar;
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // n0.l
    public final void d0() {
        ia.d0.s(Z(), null, null, new v(this, (g7.d) null, 8), 3);
    }

    @Override // i1.m
    public final void e(h0 h0Var) {
        h0Var.a();
        c1.o oVar = this.f11050y;
        if (oVar != null) {
            oVar.b(h0Var, this.f11051z, this.f11048w.L());
        }
        m0(h0Var);
    }

    public abstract void l0(q.k kVar, long j2, float f10);

    @Override // i1.u
    public final void m(long j2) {
        this.B = true;
        d2.c cVar = i1.l.u(this).A;
        this.A = ib.k.W(j2);
        float f10 = this.f11047v;
        this.f11051z = Float.isNaN(f10) ? k.a(cVar, this.f11046u, this.A) : cVar.o(f10);
        z zVar = this.C;
        Object[] objArr = zVar.f5556a;
        int i2 = zVar.f5557b;
        for (int i10 = 0; i10 < i2; i10++) {
            n0((q.m) objArr[i10]);
        }
        zVar.c();
    }

    public abstract void m0(h0 h0Var);

    public final void n0(q.m mVar) {
        if (mVar instanceof q.k) {
            l0((q.k) mVar, this.A, this.f11051z);
        } else if (mVar instanceof q.l) {
            o0(((q.l) mVar).f8617a);
        } else if (mVar instanceof q.j) {
            o0(((q.j) mVar).f8615a);
        }
    }

    public abstract void o0(q.k kVar);
}
