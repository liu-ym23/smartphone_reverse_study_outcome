package z;

import kc.w;
import r2.i;
import s1.q;
import u1.a2;
import u1.f;
import u1.g1;
import u1.v;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends l implements a, v, a2 {

    /* renamed from: u, reason: collision with root package name */
    public static final i f16134u = new i(29);

    /* renamed from: s, reason: collision with root package name */
    public u.i f16135s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f16136t;

    public static final c1.c B0(d dVar, g1 g1Var, xb.a aVar) {
        c1.c cVar;
        if (dVar.f15126r && dVar.f16136t) {
            g1 g1VarT = f.t(dVar);
            if (!g1Var.H0().f15126r) {
                g1Var = null;
            }
            if (g1Var != null && (cVar = (c1.c) aVar.invoke()) != null) {
                float f5 = g1VarT.g(g1Var, false).f2167a;
                return cVar.e((Float.floatToRawIntBits(r4.f2168b) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
            }
        }
        return null;
    }

    @Override // z.a
    public final Object N(g1 g1Var, xb.a aVar, pb.i iVar) {
        Object objF = w.f(new c(this, g1Var, aVar, new ed.l(this, g1Var, aVar), null), iVar);
        return objF == ob.a.f9351c ? objF : jb.v.f6774a;
    }

    @Override // u1.v
    public final void Z(q qVar) {
        this.f16136t = true;
    }

    @Override // u1.a2
    public final Object k() {
        return f16134u;
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }
}
