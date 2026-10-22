package r;

import b0.t1;
import b0.z1;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f8885a = b(true);

    /* renamed from: b, reason: collision with root package name */
    public static final k f8886b;

    static {
        b(false);
        f8886b = k.f8877b;
    }

    public static final void a(n0.m mVar, b0.p pVar, int i2) {
        pVar.T(-211209833);
        if ((((pVar.f(mVar) ? 4 : 2) | i2) & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            int iHashCode = Long.hashCode(pVar.Q);
            n0.m mVarV = a.a.V(pVar, mVar);
            t1 t1VarL = pVar.l();
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, f8886b, i1.g.f4477e);
            b0.b.q(pVar, t1VarL, i1.g.f4476d);
            b0.b.q(pVar, mVarV, i1.g.f4475c);
            i1.f fVar = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar, iHashCode, fVar);
            }
            pVar.q(true);
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new j1.a(i2, 4, mVar);
        }
    }

    public static final HashMap b(boolean z4) {
        HashMap map = new HashMap(9);
        c(map, z4, n0.b.f6772f);
        c(map, z4, n0.b.f6773g);
        c(map, z4, n0.b.f6774h);
        c(map, z4, n0.b.f6775i);
        c(map, z4, n0.b.f6776j);
        c(map, z4, n0.b.f6777k);
        c(map, z4, n0.b.f6778l);
        c(map, z4, n0.b.f6779m);
        c(map, z4, n0.b.f6780n);
        return map;
    }

    public static final void c(HashMap map, boolean z4, n0.e eVar) {
        map.put(eVar, new o(eVar, z4));
    }
}
