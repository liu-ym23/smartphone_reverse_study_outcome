package s;

import c7.r;
import eb.k;
import h4.n;
import i1.d1;
import i1.u;
import i1.x1;
import ia.d0;
import n0.l;
import p.i;

/* loaded from: classes.dex */
public final class d extends l implements a, u, x1 {

    /* renamed from: v, reason: collision with root package name */
    public static final n f9158v = new n(20, false);

    /* renamed from: t, reason: collision with root package name */
    public i f9159t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9160u;

    public static final t0.c l0(d dVar, d1 d1Var, p7.a aVar) {
        t0.c cVar;
        if (dVar.f6810s && dVar.f9160u) {
            d1 d1VarT = i1.l.t(dVar);
            if (!d1Var.z0().f6810s) {
                d1Var = null;
            }
            if (d1Var != null && (cVar = (t0.c) aVar.c()) != null) {
                float f10 = d1VarT.B(d1Var, false).f9656a;
                return cVar.e((Float.floatToRawIntBits(r4.f9657b) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32));
            }
        }
        return null;
    }

    @Override // s.a
    public final Object A(d1 d1Var, p7.a aVar, i7.i iVar) throws Throwable {
        Object objF = d0.f(new c(this, d1Var, aVar, new k(this, d1Var, aVar), null), iVar);
        return objF == h7.a.f4212f ? objF : r.f1986a;
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // i1.x1
    public final Object k() {
        return f9158v;
    }

    @Override // i1.u
    public final void l(g1.k kVar) {
        this.f9160u = true;
    }
}
