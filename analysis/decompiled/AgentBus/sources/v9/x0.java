package v9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x9.f f10604a = x9.i.c(x9.h.f11311q, new String[0]);

    /* renamed from: b, reason: collision with root package name */
    public static final x9.f f10605b = x9.i.c(x9.h.f11308n, new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final w0 f10606c = new w0("NO_EXPECTED_TYPE");

    /* renamed from: d, reason: collision with root package name */
    public static final w0 f10607d = new w0("UNIT_EXPECTED_TYPE");

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r27) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.x0.a(int):void");
    }

    public static boolean b(v vVar) {
        if (vVar == null) {
            a(28);
            throw null;
        }
        if (vVar.F0()) {
            return true;
        }
        return c.j(vVar) && b(((p) vVar.H0()).f10581h);
    }

    public static boolean c(v vVar, p7.k kVar, ea.h hVar) {
        if (vVar == null) {
            return false;
        }
        z0 z0VarH0 = vVar.H0();
        if (l(vVar)) {
            return ((Boolean) kVar.invoke(z0VarH0)).booleanValue();
        }
        if (hVar != null && hVar.contains(vVar)) {
            return false;
        }
        if (((Boolean) kVar.invoke(z0VarH0)).booleanValue()) {
            return true;
        }
        if (hVar == null) {
            hVar = new ea.h();
        }
        hVar.add(vVar);
        p pVar = z0VarH0 instanceof p ? (p) z0VarH0 : null;
        if (pVar != null && (c(pVar.f10580g, kVar, hVar) || c(pVar.f10581h, kVar, hVar))) {
            return true;
        }
        if ((z0VarH0 instanceof l) && c(((l) z0VarH0).f10564g, kVar, hVar)) {
            return true;
        }
        m0 m0VarE0 = vVar.E0();
        if (m0VarE0 instanceof u) {
            Iterator it = ((u) m0VarE0).f10592b.iterator();
            while (it.hasNext()) {
                if (c((v) it.next(), kVar, hVar)) {
                    return true;
                }
            }
            return false;
        }
        for (p0 p0Var : vVar.C0()) {
            if (!p0Var.c() && c(p0Var.b(), kVar, hVar)) {
                return true;
            }
        }
        return false;
    }

    public static List d(List list) {
        if (list == null) {
            a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new q0(((f8.q0) it.next()).k()));
        }
        return d7.r.m1(arrayList);
    }

    public static boolean e(v vVar) {
        if (vVar == null) {
            a(27);
            throw null;
        }
        if (!vVar.F0() && (!c.j(vVar) || !e(((p) vVar.H0()).f10581h))) {
            if (!(vVar.H0() instanceof l)) {
                if (f(vVar)) {
                    if (!(vVar.E0().c() instanceof f8.e)) {
                        v0 v0VarD = v0.d(vVar);
                        Collection<v> collectionD = vVar.E0().d();
                        ArrayList arrayList = new ArrayList(collectionD.size());
                        for (v vVar2 : collectionD) {
                            if (vVar2 == null) {
                                a(21);
                                throw null;
                            }
                            v vVarI = v0VarD.i(1, vVar2);
                            v vVarH = vVarI != null ? h(vVarI, vVar.F0()) : null;
                            if (vVarH != null) {
                                arrayList.add(vVarH);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (e((v) it.next())) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                m0 m0VarE0 = vVar.E0();
                if (m0VarE0 instanceof u) {
                    Iterator it2 = ((u) m0VarE0).f10592b.iterator();
                    while (it2.hasNext()) {
                        if (e((v) it2.next())) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean f(v vVar) {
        if (vVar == null) {
            a(60);
            throw null;
        }
        if ((vVar.E0().c() instanceof f8.q0 ? (f8.q0) vVar.E0().c() : null) != null) {
            return true;
        }
        vVar.E0();
        return false;
    }

    public static z0 g(v vVar, boolean z4) {
        if (vVar == null) {
            a(3);
            throw null;
        }
        z0 z0VarI0 = vVar.H0().I0(z4);
        if (z0VarI0 != null) {
            return z0VarI0;
        }
        a(4);
        throw null;
    }

    public static v h(v vVar, boolean z4) {
        if (vVar != null) {
            return z4 ? g(vVar, true) : vVar;
        }
        a(8);
        throw null;
    }

    public static z i(z zVar, boolean z4) {
        if (zVar == null) {
            a(5);
            throw null;
        }
        if (!z4) {
            return zVar;
        }
        z zVarI0 = zVar.I0(true);
        if (zVarI0 != null) {
            return zVarI0;
        }
        a(6);
        throw null;
    }

    public static e0 j(f8.q0 q0Var) {
        if (q0Var != null) {
            return new e0(q0Var);
        }
        a(45);
        throw null;
    }

    public static p0 k(f8.q0 q0Var, t8.a aVar) {
        if (q0Var != null) {
            return aVar.f9772a == 1 ? new q0(1, c.r(q0Var)) : new e0(q0Var);
        }
        a(46);
        throw null;
    }

    public static boolean l(v vVar) {
        if (vVar != null) {
            return vVar == f10606c || vVar == f10607d;
        }
        a(0);
        throw null;
    }
}
