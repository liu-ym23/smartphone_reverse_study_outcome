package a2;

import java.util.ArrayList;
import java.util.List;
import p.f0;
import s1.v0;
import u1.g0;
import u1.g1;
import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final w0.l f85a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f86b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f87c;

    /* renamed from: d, reason: collision with root package name */
    public final k f88d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f89e;

    /* renamed from: f, reason: collision with root package name */
    public p f90f;

    /* renamed from: g, reason: collision with root package name */
    public final int f91g;

    public p(w0.l lVar, boolean z10, g0 g0Var, k kVar) {
        this.f85a = lVar;
        this.f86b = z10;
        this.f87c = g0Var;
        this.f88d = kVar;
        this.f91g = g0Var.f13790f;
    }

    public static /* synthetic */ List j(int i, p pVar) {
        return pVar.i((i & 1) != 0 ? !pVar.f86b : false, (i & 2) == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final c1.c a(g1 g1Var) {
        u1.m mVarE;
        p pVarL = l();
        if (pVarL == null) {
            return c1.c.f2166e;
        }
        w0.l lVar = pVarL.f87c.H.f13746f;
        if ((lVar.f15117h & 8) != 0) {
            loop0: while (lVar != null) {
                if ((lVar.f15116g & 8) != 0) {
                    mVarE = lVar;
                    ?? eVar = 0;
                    while (mVarE != 0) {
                        if (mVarE instanceof v1) {
                            if (mVarE.g()) {
                                break loop0;
                            }
                        } else if ((mVarE.f15116g & 8) != 0 && (mVarE instanceof u1.m)) {
                            w0.l lVar2 = mVarE.f13866t;
                            int i = 0;
                            mVarE = mVarE;
                            eVar = eVar;
                            while (lVar2 != null) {
                                if ((lVar2.f15116g & 8) != 0) {
                                    i++;
                                    eVar = eVar;
                                    if (i == 1) {
                                        mVarE = lVar2;
                                    } else {
                                        if (eVar == 0) {
                                            eVar = new m0.e(new w0.l[16]);
                                        }
                                        if (mVarE != 0) {
                                            eVar.b(mVarE);
                                            mVarE = 0;
                                        }
                                        eVar.b(lVar2);
                                    }
                                }
                                lVar2 = lVar2.f15118j;
                                mVarE = mVarE;
                                eVar = eVar;
                            }
                            if (i == 1) {
                            }
                        }
                        mVarE = u1.f.e(eVar);
                    }
                }
                if ((lVar.f15117h & 8) == 0) {
                    break;
                }
                lVar = lVar.f15118j;
            }
            mVarE = 0;
        } else {
            mVarE = 0;
        }
        v1 v1Var = (v1) mVarE;
        g1 g1VarS = v1Var != null ? u1.f.s(v1Var, 8) : null;
        return g1VarS == null ? pVarL.a(g1Var) : g1VarS.g(g1Var, true);
    }

    public final p b(g gVar, xb.l lVar) {
        k kVar = new k();
        kVar.f77g = false;
        kVar.f78h = false;
        lVar.invoke(kVar);
        p pVar = new p(new o(lVar), false, new g0(true, this.f91g + (gVar != null ? 1000000000 : 2000000000)), kVar);
        pVar.f89e = true;
        pVar.f90f = this;
        return pVar;
    }

    public final void c(g0 g0Var, ArrayList arrayList) {
        m0.e eVarW = g0Var.w();
        Object[] objArr = eVarW.f8158c;
        int i = eVarW.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if (g0Var2.G() && !g0Var2.S) {
                if (g0Var2.H.d(8)) {
                    arrayList.add(s.a(g0Var2, this.f86b));
                } else {
                    c(g0Var2, arrayList);
                }
            }
        }
    }

    public final g1 d() {
        if (!this.f89e) {
            v1 v1VarF = f();
            return v1VarF != null ? u1.f.s(v1VarF, 8) : this.f87c.H.f13743c;
        }
        p pVarL = l();
        if (pVarL != null) {
            return pVarL.d();
        }
        return null;
    }

    public final void e(ArrayList arrayList, ArrayList arrayList2) {
        p(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            p pVar = (p) arrayList.get(size2);
            if (pVar.m()) {
                arrayList2.add(pVar);
            } else if (!pVar.f88d.f78h) {
                pVar.e(arrayList, arrayList2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v14, types: [u1.v1] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    public final v1 f() {
        w0.l lVarE;
        boolean z10 = this.f88d.f77g;
        Object obj = null;
        g0 g0Var = this.f87c;
        if (z10) {
            w0.l lVar = g0Var.H.f13746f;
            if ((lVar.f15117h & 8) != 0) {
                lVarE = null;
                while (lVar != null) {
                    if ((lVar.f15116g & 8) != 0) {
                        u1.m mVarE = lVar;
                        ?? eVar = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof v1) {
                                ?? r52 = (v1) mVarE;
                                if (r52.g()) {
                                    if (r52.o0()) {
                                        return r52;
                                    }
                                    if (lVarE == null) {
                                        lVarE = r52;
                                    }
                                }
                            } else if ((mVarE.f15116g & 8) != 0 && (mVarE instanceof u1.m)) {
                                w0.l lVar2 = mVarE.f13866t;
                                int i = 0;
                                mVarE = mVarE;
                                eVar = eVar;
                                while (lVar2 != null) {
                                    if ((lVar2.f15116g & 8) != 0) {
                                        i++;
                                        eVar = eVar;
                                        if (i == 1) {
                                            mVarE = lVar2;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar.b(lVar2);
                                        }
                                    }
                                    lVar2 = lVar2.f15118j;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                }
                                if (i == 1) {
                                }
                            }
                            mVarE = u1.f.e(eVar);
                        }
                    }
                    if ((lVar.f15117h & 8) == 0) {
                        break;
                    }
                    lVar = lVar.f15118j;
                }
                obj = lVarE;
            }
        } else {
            w0.l lVar3 = g0Var.H.f13746f;
            if ((lVar3.f15117h & 8) != 0) {
                loop3: while (lVar3 != null) {
                    if ((lVar3.f15116g & 8) != 0) {
                        lVarE = lVar3;
                        m0.e eVar2 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof v1) {
                                if (((v1) lVarE).g()) {
                                    obj = lVarE;
                                }
                            } else if ((lVarE.f15116g & 8) != 0 && (lVarE instanceof u1.m)) {
                                int i3 = 0;
                                for (w0.l lVar4 = ((u1.m) lVarE).f13866t; lVar4 != null; lVar4 = lVar4.f15118j) {
                                    if ((lVar4.f15116g & 8) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            lVarE = lVar4;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar2.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar2.b(lVar4);
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            lVarE = u1.f.e(eVar2);
                        }
                    }
                    if ((lVar3.f15117h & 8) == 0) {
                        break;
                    }
                    lVar3 = lVar3.f15118j;
                }
            }
        }
        return (v1) obj;
    }

    public final c1.c g() {
        g1 g1VarD = d();
        if (g1VarD != null) {
            if (!g1VarD.H0().f15126r) {
                g1VarD = null;
            }
            if (g1VarD != null) {
                return v0.i(g1VarD).g(g1VarD, true);
            }
        }
        return c1.c.f2166e;
    }

    public final c1.c h() {
        g1 g1VarD = d();
        if (g1VarD != null) {
            if (!g1VarD.H0().f15126r) {
                g1VarD = null;
            }
            if (g1VarD != null) {
                return v0.g(g1VarD);
            }
        }
        return c1.c.f2166e;
    }

    public final List i(boolean z10, boolean z11) {
        if (!z10 && this.f88d.f78h) {
            return kb.s.f7404c;
        }
        ArrayList arrayList = new ArrayList();
        if (!m()) {
            return p(arrayList, z11);
        }
        ArrayList arrayList2 = new ArrayList();
        e(arrayList, arrayList2);
        return arrayList2;
    }

    public final k k() {
        boolean zM = m();
        k kVar = this.f88d;
        if (!zM) {
            return kVar;
        }
        k kVarA = kVar.a();
        o(new ArrayList(), kVarA);
        return kVarA;
    }

    public final p l() {
        g0 g0VarT;
        p pVar = this.f90f;
        if (pVar != null) {
            return pVar;
        }
        g0 g0Var = this.f87c;
        boolean z10 = this.f86b;
        if (z10) {
            g0VarT = g0Var.t();
            while (g0VarT != null) {
                k kVarV = g0VarT.v();
                if (kVarV != null && kVarV.f77g) {
                    break;
                }
                g0VarT = g0VarT.t();
            }
            g0VarT = null;
        } else {
            g0VarT = null;
        }
        if (g0VarT == null) {
            g0 g0VarT2 = g0Var.t();
            while (true) {
                if (g0VarT2 == null) {
                    g0VarT = null;
                    break;
                }
                if (g0VarT2.H.d(8)) {
                    g0VarT = g0VarT2;
                    break;
                }
                g0VarT2 = g0VarT2.t();
            }
        }
        if (g0VarT == null) {
            return null;
        }
        return s.a(g0VarT, z10);
    }

    public final boolean m() {
        return this.f86b && this.f88d.f77g;
    }

    public final boolean n() {
        if (this.f89e || !j(4, this).isEmpty()) {
            return false;
        }
        g0 g0VarT = this.f87c.t();
        while (true) {
            if (g0VarT == null) {
                g0VarT = null;
                break;
            }
            k kVarV = g0VarT.v();
            if (kVarV != null && kVarV.f77g) {
                break;
            }
            g0VarT = g0VarT.t();
        }
        return g0VarT == null;
    }

    public final void o(ArrayList arrayList, k kVar) {
        if (this.f88d.f78h) {
            return;
        }
        p(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            p pVar = (p) arrayList.get(size2);
            if (!pVar.m()) {
                kVar.c(pVar.f88d);
                pVar.o(arrayList, kVar);
            }
        }
    }

    public final List p(ArrayList arrayList, boolean z10) {
        if (this.f89e) {
            return kb.s.f7404c;
        }
        c(this.f87c, arrayList);
        if (z10) {
            k kVar = this.f88d;
            f0 f0Var = kVar.f75c;
            Object objG = f0Var.g(u.f138w);
            if (objG == null) {
                objG = null;
            }
            g gVar = (g) objG;
            if (gVar != null && kVar.f77g && !arrayList.isEmpty()) {
                arrayList.add(b(gVar, new m(gVar, 0)));
            }
            x xVar = u.f117a;
            if (f0Var.c(xVar) && !arrayList.isEmpty() && kVar.f77g) {
                Object objG2 = f0Var.g(xVar);
                if (objG2 == null) {
                    objG2 = null;
                }
                List list = (List) objG2;
                String str = list != null ? (String) kb.l.x0(list) : null;
                if (str != null) {
                    arrayList.add(0, b(null, new n(str, 0)));
                }
            }
        }
        return arrayList;
    }
}
