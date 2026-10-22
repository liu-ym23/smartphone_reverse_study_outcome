package p1;

import d7.z;
import i1.d1;
import i1.f0;
import i1.s1;
import java.util.ArrayList;
import java.util.List;
import k.a0;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final n0.l f8312a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8313b;

    /* renamed from: c, reason: collision with root package name */
    public final f0 f8314c;

    /* renamed from: d, reason: collision with root package name */
    public final i f8315d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8316e;

    /* renamed from: f, reason: collision with root package name */
    public n f8317f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8318g;

    public n(n0.l lVar, boolean z4, f0 f0Var, i iVar) {
        this.f8312a = lVar;
        this.f8313b = z4;
        this.f8314c = f0Var;
        this.f8315d = iVar;
        this.f8318g = f0Var.f4453g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [n0.l] */
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
    /* JADX WARN: Type inference failed for: r5v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final t0.c a(d1 d1Var) {
        i1.k kVarE;
        n nVarL = l();
        if (nVarL == null) {
            return t0.c.f9655e;
        }
        n0.l lVar = (n0.l) nVarL.f8314c.H.f4404j;
        if ((lVar.f6800i & 8) != 0) {
            loop0: while (lVar != null) {
                if ((lVar.f6799h & 8) != 0) {
                    kVarE = lVar;
                    ?? eVar = 0;
                    while (kVarE != 0) {
                        if (kVarE instanceof s1) {
                            if (kVarE.g()) {
                                break loop0;
                            }
                        } else if ((kVarE.f6799h & 8) != 0 && (kVarE instanceof i1.k)) {
                            n0.l lVar2 = kVarE.f4514u;
                            int i2 = 0;
                            kVarE = kVarE;
                            eVar = eVar;
                            while (lVar2 != null) {
                                if ((lVar2.f6799h & 8) != 0) {
                                    i2++;
                                    eVar = eVar;
                                    if (i2 == 1) {
                                        kVarE = lVar2;
                                    } else {
                                        if (eVar == 0) {
                                            eVar = new d0.e(new n0.l[16]);
                                        }
                                        if (kVarE != 0) {
                                            eVar.b(kVarE);
                                            kVarE = 0;
                                        }
                                        eVar.b(lVar2);
                                    }
                                }
                                lVar2 = lVar2.f6802k;
                                kVarE = kVarE;
                                eVar = eVar;
                            }
                            if (i2 == 1) {
                            }
                        }
                        kVarE = i1.l.e(eVar);
                    }
                }
                if ((lVar.f6800i & 8) == 0) {
                    break;
                }
                lVar = lVar.f6802k;
            }
            kVarE = 0;
        } else {
            kVarE = 0;
        }
        s1 s1Var = (s1) kVarE;
        d1 d1VarS = s1Var != null ? i1.l.s(s1Var, 8) : null;
        return d1VarS == null ? nVarL.a(d1Var) : d1VarS.B(d1Var, true);
    }

    public final n b(f fVar, p7.k kVar) {
        i iVar = new i();
        iVar.f8306h = false;
        iVar.f8307i = false;
        kVar.invoke(iVar);
        n nVar = new n(new m(kVar), false, new f0(true, this.f8318g + (fVar != null ? 1000000000 : 2000000000)), iVar);
        nVar.f8316e = true;
        nVar.f8317f = this;
        return nVar;
    }

    public final void c(f0 f0Var, ArrayList arrayList) {
        d0.e eVarR = f0Var.r();
        Object[] objArr = eVarR.f2749f;
        int i2 = eVarR.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var2 = (f0) objArr[i10];
            if (f0Var2.B() && !f0Var2.P) {
                if (f0Var2.H.h(8)) {
                    arrayList.add(q.a(f0Var2, this.f8313b));
                } else {
                    c(f0Var2, arrayList);
                }
            }
        }
    }

    public final d1 d() {
        if (!this.f8316e) {
            s1 s1VarF = f();
            return s1VarF != null ? i1.l.s(s1VarF, 8) : (i1.r) this.f8314c.H.f4401g;
        }
        n nVarL = l();
        if (nVarL != null) {
            return nVarL.d();
        }
        return null;
    }

    public final void e(ArrayList arrayList, ArrayList arrayList2) {
        p(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            n nVar = (n) arrayList.get(size2);
            if (nVar.n()) {
                arrayList2.add(nVar);
            } else if (!nVar.f8315d.f8307i) {
                nVar.e(arrayList, arrayList2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r5v14, types: [i1.s1] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [n0.l] */
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
    /* JADX WARN: Type inference failed for: r6v15, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    public final s1 f() {
        n0.l lVarE;
        boolean z4 = this.f8315d.f8306h;
        f0 f0Var = this.f8314c;
        Object obj = null;
        if (z4) {
            n0.l lVar = (n0.l) f0Var.H.f4404j;
            if ((lVar.f6800i & 8) != 0) {
                lVarE = null;
                while (lVar != null) {
                    if ((lVar.f6799h & 8) != 0) {
                        i1.k kVarE = lVar;
                        ?? eVar = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof s1) {
                                ?? r52 = (s1) kVarE;
                                if (r52.g()) {
                                    if (r52.Q()) {
                                        return r52;
                                    }
                                    if (lVarE == null) {
                                        lVarE = r52;
                                    }
                                }
                            } else if ((kVarE.f6799h & 8) != 0 && (kVarE instanceof i1.k)) {
                                n0.l lVar2 = kVarE.f4514u;
                                int i2 = 0;
                                kVarE = kVarE;
                                eVar = eVar;
                                while (lVar2 != null) {
                                    if ((lVar2.f6799h & 8) != 0) {
                                        i2++;
                                        eVar = eVar;
                                        if (i2 == 1) {
                                            kVarE = lVar2;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new d0.e(new n0.l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar.b(lVar2);
                                        }
                                    }
                                    lVar2 = lVar2.f6802k;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                }
                                if (i2 == 1) {
                                }
                            }
                            kVarE = i1.l.e(eVar);
                        }
                    }
                    if ((lVar.f6800i & 8) == 0) {
                        break;
                    }
                    lVar = lVar.f6802k;
                }
                obj = lVarE;
            }
        } else {
            n0.l lVar3 = (n0.l) f0Var.H.f4404j;
            if ((lVar3.f6800i & 8) != 0) {
                loop3: while (lVar3 != null) {
                    if ((lVar3.f6799h & 8) != 0) {
                        lVarE = lVar3;
                        d0.e eVar2 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof s1) {
                                if (((s1) lVarE).g()) {
                                    obj = lVarE;
                                }
                            } else if ((lVarE.f6799h & 8) != 0 && (lVarE instanceof i1.k)) {
                                int i10 = 0;
                                for (n0.l lVar4 = ((i1.k) lVarE).f4514u; lVar4 != null; lVar4 = lVar4.f6802k) {
                                    if ((lVar4.f6799h & 8) != 0) {
                                        i10++;
                                        if (i10 == 1) {
                                            lVarE = lVar4;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new d0.e(new n0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar2.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar2.b(lVar4);
                                        }
                                    }
                                }
                                if (i10 == 1) {
                                }
                            }
                            lVarE = i1.l.e(eVar2);
                        }
                    }
                    if ((lVar3.f6800i & 8) == 0) {
                        break;
                    }
                    lVar3 = lVar3.f6802k;
                }
            }
        }
        return (s1) obj;
    }

    public final t0.c g() {
        d1 d1VarD = d();
        if (d1VarD != null) {
            if (!d1VarD.z0().f6810s) {
                d1VarD = null;
            }
            if (d1VarD != null) {
                return ib.k.w(d1VarD).B(d1VarD, true);
            }
        }
        return t0.c.f9655e;
    }

    public final t0.c h() {
        d1 d1VarD = d();
        if (d1VarD != null) {
            if (!d1VarD.z0().f6810s) {
                d1VarD = null;
            }
            if (d1VarD != null) {
                return ib.k.h(d1VarD);
            }
        }
        return t0.c.f9655e;
    }

    public final List i(boolean z4, boolean z10) {
        if (!z4 && this.f8315d.f8307i) {
            return z.f2978f;
        }
        ArrayList arrayList = new ArrayList();
        if (!n()) {
            return p(arrayList, z10);
        }
        ArrayList arrayList2 = new ArrayList();
        e(arrayList, arrayList2);
        return arrayList2;
    }

    public final i k() {
        boolean zN = n();
        i iVar = this.f8315d;
        if (!zN) {
            return iVar;
        }
        i iVarA = iVar.a();
        o(new ArrayList(), iVarA);
        return iVarA;
    }

    public final n l() {
        f0 f0VarN;
        n nVar = this.f8317f;
        if (nVar != null) {
            return nVar;
        }
        f0 f0Var = this.f8314c;
        boolean z4 = this.f8313b;
        if (z4) {
            f0VarN = f0Var.n();
            while (f0VarN != null) {
                i iVarQ = f0VarN.q();
                if (iVarQ != null && iVarQ.f8306h) {
                    break;
                }
                f0VarN = f0VarN.n();
            }
            f0VarN = null;
        } else {
            f0VarN = null;
        }
        if (f0VarN == null) {
            f0 f0VarN2 = f0Var.n();
            while (true) {
                if (f0VarN2 == null) {
                    f0VarN = null;
                    break;
                }
                if (f0VarN2.H.h(8)) {
                    f0VarN = f0VarN2;
                    break;
                }
                f0VarN2 = f0VarN2.n();
            }
        }
        if (f0VarN == null) {
            return null;
        }
        return q.a(f0VarN, z4);
    }

    public final i m() {
        return this.f8315d;
    }

    public final boolean n() {
        return this.f8313b && this.f8315d.f8306h;
    }

    public final void o(ArrayList arrayList, i iVar) {
        if (this.f8315d.f8307i) {
            return;
        }
        p(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            n nVar = (n) arrayList.get(size2);
            if (!nVar.n()) {
                iVar.h(nVar.f8315d);
                nVar.o(arrayList, iVar);
            }
        }
    }

    public final List p(ArrayList arrayList, boolean z4) {
        if (this.f8316e) {
            return z.f2978f;
        }
        c(this.f8314c, arrayList);
        if (z4) {
            i iVar = this.f8315d;
            a0 a0Var = iVar.f8304f;
            Object objG = a0Var.g(s.f8365v);
            if (objG == null) {
                objG = null;
            }
            f fVar = (f) objG;
            if (fVar != null && iVar.f8306h && !arrayList.isEmpty()) {
                arrayList.add(b(fVar, new k(1)));
            }
            v vVar = s.f8344a;
            if (a0Var.c(vVar) && !arrayList.isEmpty() && iVar.f8306h) {
                Object objG2 = a0Var.g(vVar);
                if (objG2 == null) {
                    objG2 = null;
                }
                List list = (List) objG2;
                String str = list != null ? (String) d7.r.P0(list) : null;
                if (str != null) {
                    arrayList.add(0, b(null, new l(str, 0)));
                }
            }
        }
        return arrayList;
    }
}
