package g0;

import androidx.lifecycle.h0;
import h0.g0;
import p.a0;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class q extends w0.l implements u1.k, u1.n, u1.v {
    public boolean A;

    /* renamed from: s, reason: collision with root package name */
    public final v.k f4178s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f4179t;

    /* renamed from: u, reason: collision with root package name */
    public final float f4180u;

    /* renamed from: v, reason: collision with root package name */
    public final a2.i f4181v;

    /* renamed from: w, reason: collision with root package name */
    public final g0 f4182w;

    /* renamed from: x, reason: collision with root package name */
    public ed.e f4183x;

    /* renamed from: y, reason: collision with root package name */
    public float f4184y;

    /* renamed from: z, reason: collision with root package name */
    public long f4185z = 0;
    public final a0 B = new a0();

    public q(v.k kVar, boolean z10, float f5, a2.i iVar, g0 g0Var) {
        this.f4178s = kVar;
        this.f4179t = z10;
        this.f4180u = f5;
        this.f4181v = iVar;
        this.f4182w = g0Var;
    }

    public abstract void B0(v.m mVar, long j10, float f5);

    public abstract void C0(i0 i0Var);

    public final void D0(v.o oVar) {
        if (oVar instanceof v.m) {
            B0((v.m) oVar, this.f4185z, this.f4184y);
        } else if (oVar instanceof v.n) {
            E0(((v.n) oVar).f14315a);
        } else if (oVar instanceof v.l) {
            E0(((v.l) oVar).f14313a);
        }
    }

    public abstract void E0(v.m mVar);

    @Override // u1.n
    public final void b(i0 i0Var) {
        i0Var.b();
        ed.e eVar = this.f4183x;
        if (eVar != null) {
            eVar.b(i0Var, this.f4184y, this.f4181v.e());
        }
        C0(i0Var);
    }

    @Override // u1.v
    public final void m(long j10) {
        this.A = true;
        o2.c cVar = u1.f.u(this).A;
        this.f4185z = ac.a.i0(j10);
        float f5 = this.f4180u;
        this.f4184y = Float.isNaN(f5) ? l.a(cVar, this.f4179t, this.f4185z) : cVar.X(f5);
        a0 a0Var = this.B;
        Object[] objArr = a0Var.f9516a;
        int i = a0Var.f9517b;
        for (int i3 = 0; i3 < i; i3++) {
            D0((v.o) objArr[i3]);
        }
        a0Var.c();
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    @Override // w0.l
    public final void t0() {
        kc.w.u(p0(), null, null, new h0(this, (nb.c) null, 4), 3);
    }
}
