package i1;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final h1 f4519a = new h1(1);

    /* renamed from: b, reason: collision with root package name */
    public static final d2.d f4520b = new d2.d(1.0f, 1.0f);

    public static final long a(float f10, boolean z4, boolean z10) {
        return (((z4 ? 1L : 0L) | (z10 ? 2L : 0L)) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32);
    }

    public static final void b(d0.e eVar, n0.l lVar) {
        d0.e eVarS = u(lVar).s();
        int i2 = eVarS.f2751h - 1;
        Object[] objArr = eVarS.f2749f;
        if (i2 < objArr.length) {
            while (i2 >= 0) {
                eVar.b((n0.l) ((f0) objArr[i2]).H.f4404j);
                i2--;
            }
        }
    }

    public static final int c(m0 m0Var, g1.f fVar) {
        m0 m0VarZ = m0Var.Z();
        if (m0VarZ == null) {
            f1.a.b("Child of " + m0Var + " cannot be null when calculating alignment line");
        }
        if (m0Var.e0().a().containsKey(fVar)) {
            Integer num = (Integer) m0Var.e0().a().get(fVar);
            if (num != null) {
                return num.intValue();
            }
        } else {
            int iW = m0VarZ.W(fVar);
            if (iW != Integer.MIN_VALUE) {
                m0VarZ.f4531o = true;
                m0Var.f4532p = true;
                m0Var.n0();
                m0VarZ.f4531o = false;
                m0Var.f4532p = false;
                return iW + ((int) (fVar instanceof g1.f ? m0VarZ.g0() & 4294967295L : m0VarZ.g0() >> 32));
            }
        }
        return Integer.MIN_VALUE;
    }

    public static final n0.l d(j jVar, int i2) {
        n0.l lVar = ((n0.l) jVar).f6797f.f6802k;
        if (lVar == null || (lVar.f6800i & i2) == 0) {
            return null;
        }
        while (lVar != null) {
            int i10 = lVar.f6799h;
            if ((i10 & 2) != 0) {
                return null;
            }
            if ((i10 & i2) != 0) {
                return lVar;
            }
            lVar = lVar.f6802k;
        }
        return null;
    }

    public static final n0.l e(d0.e eVar) {
        int i2;
        if (eVar == null || (i2 = eVar.f2751h) == 0) {
            return null;
        }
        return (n0.l) eVar.j(i2 - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final v f(n0.l lVar) {
        if ((lVar.f6799h & 2) != 0) {
            if (lVar instanceof v) {
                return (v) lVar;
            }
            if (lVar instanceof k) {
                n0.l lVar2 = ((k) lVar).f4514u;
                while (lVar2 != 0) {
                    if (lVar2 instanceof v) {
                        return (v) lVar2;
                    }
                    lVar2 = (!(lVar2 instanceof k) || (lVar2.f6799h & 2) == 0) ? lVar2.f6802k : ((k) lVar2).f4514u;
                }
            }
        }
        return null;
    }

    public static final int g(long j2, long j4) {
        boolean zP = p(j2);
        if (zP != p(j4)) {
            return zP ? -1 : 1;
        }
        return (Math.min(k(j2), k(j4)) >= 0.0f && o(j2) != o(j4)) ? o(j2) ? -1 : 1 : (int) Math.signum(k(j2) - k(j4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object h(i iVar, b0.w1 w1Var) {
        if (!((n0.l) iVar).f6797f.f6810s) {
            f1.a.b("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }
        j0.h hVar = (j0.h) u(iVar).D;
        hVar.getClass();
        return b0.b.o(hVar, w1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final x1 i(j jVar, Object obj) {
        a1 a1Var;
        n0.l lVar = (n0.l) jVar;
        if (!lVar.f6797f.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar2 = lVar.f6797f.f6801j;
        f0 f0VarU = u(jVar);
        while (f0VarU != null) {
            if ((((n0.l) f0VarU.H.f4404j).f6800i & 262144) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f6799h & 262144) != 0) {
                        k kVarE = lVar2;
                        ?? eVar = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof x1) {
                                x1 x1Var = (x1) kVarE;
                                if (obj.equals(x1Var.k())) {
                                    return x1Var;
                                }
                            } else if ((kVarE.f6799h & 262144) != 0 && (kVarE instanceof k)) {
                                n0.l lVar3 = kVarE.f4514u;
                                int i2 = 0;
                                kVarE = kVarE;
                                eVar = eVar;
                                while (lVar3 != null) {
                                    if ((lVar3.f6799h & 262144) != 0) {
                                        i2++;
                                        eVar = eVar;
                                        if (i2 == 1) {
                                            kVarE = lVar3;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new d0.e(new n0.l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar.b(lVar3);
                                        }
                                    }
                                    lVar3 = lVar3.f6802k;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                }
                                if (i2 == 1) {
                                }
                            }
                            kVarE = e(eVar);
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [i1.j, i1.x1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [n0.l] */
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
    public static final x1 j(x1 x1Var) {
        a1 a1Var;
        n0.l lVar = (n0.l) x1Var;
        if (!lVar.f6797f.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar2 = lVar.f6797f.f6801j;
        f0 f0VarU = u(x1Var);
        while (f0VarU != null) {
            if ((((n0.l) f0VarU.H.f4404j).f6800i & 262144) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f6799h & 262144) != 0) {
                        k kVarE = lVar2;
                        ?? eVar = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof x1) {
                                x1 x1Var2 = (x1) kVarE;
                                if (q7.k.a(x1Var.k(), x1Var2.k()) && x1Var.getClass() == x1Var2.getClass()) {
                                    return x1Var2;
                                }
                            } else if ((kVarE.f6799h & 262144) != 0 && (kVarE instanceof k)) {
                                n0.l lVar3 = kVarE.f4514u;
                                int i2 = 0;
                                kVarE = kVarE;
                                eVar = eVar;
                                while (lVar3 != null) {
                                    if ((lVar3.f6799h & 262144) != 0) {
                                        i2++;
                                        eVar = eVar;
                                        if (i2 == 1) {
                                            kVarE = lVar3;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new d0.e(new n0.l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar.b(lVar3);
                                        }
                                    }
                                    lVar3 = lVar3.f6802k;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                }
                                if (i2 == 1) {
                                }
                            }
                            kVarE = e(eVar);
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        return null;
    }

    public static final float k(long j2) {
        return Float.intBitsToFloat((int) (j2 >> 32));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(m mVar) {
        if (((n0.l) mVar).f6797f.f6810s) {
            s(mVar, 1).G0();
        }
    }

    public static final void m(v vVar) {
        u(vVar).x();
    }

    public static final void n(s1 s1Var) {
        u(s1Var).z();
    }

    public static final boolean o(long j2) {
        return (j2 & 2) != 0;
    }

    public static final boolean p(long j2) {
        return (j2 & 1) != 0;
    }

    public static final boolean q(f0 f0Var) {
        if (f0Var.f4458l == null) {
            return false;
        }
        f0 f0VarN = f0Var.n();
        if ((f0VarN != null ? f0VarN.f4458l : null) == null) {
            return true;
        }
        f0Var.I.getClass();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(n0.l lVar, p7.a aVar) {
        g1 g1Var = lVar.f6803l;
        if (g1Var == null) {
            g1Var = new g1((f1) lVar);
            lVar.f6803l = g1Var;
        }
        ((j1.y) v(lVar)).getSnapshotObserver().a(g1Var, d.f4424l, aVar);
    }

    public static final d1 s(j jVar, int i2) {
        d1 d1Var = ((n0.l) jVar).f6797f.f6804m;
        q7.k.b(d1Var);
        if (d1Var.z0() != jVar || !e1.g(i2)) {
            return d1Var;
        }
        d1 d1Var2 = d1Var.f4438u;
        q7.k.b(d1Var2);
        return d1Var2;
    }

    public static final d1 t(j jVar) {
        if (!((n0.l) jVar).f6797f.f6810s) {
            f1.a.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        d1 d1VarS = s(jVar, 2);
        if (!d1VarS.z0().f6810s) {
            f1.a.b("LayoutCoordinates is not attached.");
        }
        return d1VarS;
    }

    public static final f0 u(j jVar) {
        d1 d1Var = ((n0.l) jVar).f6797f.f6804m;
        if (d1Var != null) {
            return d1Var.f4437t;
        }
        throw m.x.i("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final k1 v(j jVar) {
        k1 k1Var = u(jVar).f4464r;
        if (k1Var != null) {
            return k1Var;
        }
        throw m.x.i("This node does not have an owner.");
    }

    public static final k1 w(f0 f0Var) {
        k1 k1Var = f0Var.f4464r;
        if (k1Var != null) {
            return k1Var;
        }
        throw m.x.i("LayoutNode should be attached to an owner");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [i1.j, i1.x1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0, types: [p7.k] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [n0.l] */
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
    public static final void x(x1 x1Var, p7.k kVar) {
        a1 a1Var;
        n0.l lVar = (n0.l) x1Var;
        if (!lVar.f6797f.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar2 = lVar.f6797f.f6801j;
        f0 f0VarU = u(x1Var);
        while (f0VarU != null) {
            if ((((n0.l) f0VarU.H.f4404j).f6800i & 262144) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f6799h & 262144) != 0) {
                        k kVarE = lVar2;
                        ?? eVar = 0;
                        while (kVarE != 0) {
                            boolean zBooleanValue = true;
                            if (kVarE instanceof x1) {
                                x1 x1Var2 = (x1) kVarE;
                                if (q7.k.a(x1Var.k(), x1Var2.k()) && x1Var.getClass() == x1Var2.getClass()) {
                                    zBooleanValue = ((Boolean) kVar.invoke(x1Var2)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else {
                                if (((kVarE.f6799h & 262144) != 0) && (kVarE instanceof k)) {
                                    n0.l lVar3 = kVarE.f4514u;
                                    int i2 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar3 != null) {
                                        if ((lVar3.f6799h & 262144) != 0) {
                                            i2++;
                                            eVar = eVar;
                                            if (i2 == 1) {
                                                kVarE = lVar3;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new d0.e(new n0.l[16]);
                                                }
                                                if (kVarE != 0) {
                                                    eVar.b(kVarE);
                                                    kVarE = 0;
                                                }
                                                eVar.b(lVar3);
                                            }
                                        }
                                        lVar3 = lVar3.f6802k;
                                        kVarE = kVarE;
                                        eVar = eVar;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                            }
                            kVarE = e(eVar);
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [i1.x1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [p7.k] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final void y(x1 x1Var, p7.k kVar) {
        n0.l lVar = (n0.l) x1Var;
        if (!lVar.f6797f.f6810s) {
            f1.a.b("visitSubtreeIf called on an unattached node");
        }
        d0.e eVar = new d0.e(new n0.l[16]);
        n0.l lVar2 = lVar.f6797f;
        n0.l lVar3 = lVar2.f6802k;
        if (lVar3 == null) {
            b(eVar, lVar2);
        } else {
            eVar.b(lVar3);
        }
        while (true) {
            int i2 = eVar.f2751h;
            if (i2 == 0) {
                return;
            }
            n0.l lVar4 = (n0.l) eVar.j(i2 - 1);
            if ((lVar4.f6800i & 262144) != 0) {
                for (n0.l lVar5 = lVar4; lVar5 != null; lVar5 = lVar5.f6802k) {
                    if ((lVar5.f6799h & 262144) != 0) {
                        k kVarE = lVar5;
                        ?? eVar2 = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof x1) {
                                x1 x1Var2 = (x1) kVarE;
                                w1 w1Var = (q7.k.a(x1Var.k(), x1Var2.k()) && x1Var.getClass() == x1Var2.getClass()) ? (w1) kVar.invoke(x1Var2) : w1.f4626f;
                                if (w1Var == w1.f4628h) {
                                    return;
                                }
                                if (w1Var == w1.f4627g) {
                                    break;
                                }
                            } else if ((kVarE.f6799h & 262144) != 0 && (kVarE instanceof k)) {
                                n0.l lVar6 = kVarE.f4514u;
                                int i10 = 0;
                                kVarE = kVarE;
                                eVar2 = eVar2;
                                while (lVar6 != null) {
                                    if ((lVar6.f6799h & 262144) != 0) {
                                        i10++;
                                        eVar2 = eVar2;
                                        if (i10 == 1) {
                                            kVarE = lVar6;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new d0.e(new n0.l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar2.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar2.b(lVar6);
                                        }
                                    }
                                    lVar6 = lVar6.f6802k;
                                    kVarE = kVarE;
                                    eVar2 = eVar2;
                                }
                                if (i10 == 1) {
                                }
                            }
                            kVarE = e(eVar2);
                        }
                    }
                }
            }
            b(eVar, lVar4);
        }
    }
}
