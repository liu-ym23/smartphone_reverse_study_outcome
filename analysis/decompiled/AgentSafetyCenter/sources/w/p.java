package w;

import java.util.HashMap;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f15020a = c(true);

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f15021b = c(false);

    /* renamed from: c, reason: collision with root package name */
    public static final o f15022c = o.f15014b;

    public static final void a(w0.m mVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-211209833);
        if ((i & 6) == 0) {
            i3 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i3 & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            int iHashCode = Long.hashCode(sVar.T);
            w0.m mVarM = t.o.m(sVar, mVar);
            s0.g gVarL = sVar.l();
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(f15022c, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            sVar.q(true);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new m(i, 0, mVar);
        }
    }

    public static final void b(s1.n0 n0Var, s1.o0 o0Var, s1.e0 e0Var, o2.l lVar, int i, int i3, w0.e eVar) {
        w0.e eVar2;
        Object objV = e0Var.v();
        l lVar2 = objV instanceof l ? (l) objV : null;
        s1.n0.k(n0Var, o0Var, ((lVar2 == null || (eVar2 = lVar2.f15000s) == null) ? eVar : eVar2).a(ac.a.b(o0Var.f11277c, o0Var.f11278f), ac.a.b(i, i3), lVar));
    }

    public static final HashMap c(boolean z10) {
        HashMap map = new HashMap(9);
        d(map, z10, w0.b.f15089c);
        d(map, z10, w0.b.f15090f);
        d(map, z10, w0.b.f15091g);
        d(map, z10, w0.b.f15092h);
        d(map, z10, w0.b.i);
        d(map, z10, w0.b.f15093j);
        d(map, z10, w0.b.f15094k);
        d(map, z10, w0.b.f15095l);
        d(map, z10, w0.b.f15096m);
        return map;
    }

    public static final void d(HashMap map, boolean z10, w0.e eVar) {
        map.put(eVar, new s(eVar, z10));
    }

    public static final s1.f0 e(w0.e eVar, boolean z10) {
        s1.f0 f0Var = (s1.f0) (z10 ? f15020a : f15021b).get(eVar);
        return f0Var == null ? new s(eVar, z10) : f0Var;
    }
}
