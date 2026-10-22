package u1;

import android.view.View;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final d f13777a = new d(0);

    /* renamed from: b, reason: collision with root package name */
    public static final k1 f13778b = new k1(1);

    public static final long a(float f5, boolean z10, boolean z11) {
        return (((z10 ? 1L : 0L) | (z11 ? 2L : 0L)) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    public static final void b(m0.e eVar, w0.l lVar) {
        m0.e eVarX = u(lVar).x();
        int i = eVarX.f8160g - 1;
        Object[] objArr = eVarX.f8158c;
        if (i < objArr.length) {
            while (i >= 0) {
                eVar.b(((g0) objArr[i]).H.f13746f);
                i--;
            }
        }
    }

    public static final int c(o0 o0Var, s1.l lVar) {
        o0 o0VarF0 = o0Var.f0();
        if (o0VarF0 == null) {
            r1.a.b("Child of " + o0Var + " cannot be null when calculating alignment line");
        }
        if (o0Var.p0().b().containsKey(lVar)) {
            Integer num = (Integer) o0Var.p0().b().get(lVar);
            if (num != null) {
                return num.intValue();
            }
        } else {
            int iH = o0VarF0.H(lVar);
            if (iH != Integer.MIN_VALUE) {
                o0VarF0.f13881n = true;
                o0Var.f13882o = true;
                o0Var.v0();
                o0VarF0.f13881n = false;
                o0Var.f13882o = false;
                return iH + ((int) (lVar instanceof s1.l ? o0VarF0.r0() & 4294967295L : o0VarF0.r0() >> 32));
            }
        }
        return Integer.MIN_VALUE;
    }

    public static final w0.l d(l lVar, int i) {
        w0.l lVar2 = ((w0.l) lVar).f15114c.f15118j;
        if (lVar2 == null || (lVar2.f15117h & i) == 0) {
            return null;
        }
        while (lVar2 != null) {
            int i3 = lVar2.f15116g;
            if ((i3 & 2) != 0) {
                return null;
            }
            if ((i3 & i) != 0) {
                return lVar2;
            }
            lVar2 = lVar2.f15118j;
        }
        return null;
    }

    public static final w0.l e(m0.e eVar) {
        int i;
        if (eVar == null || (i = eVar.f8160g) == 0) {
            return null;
        }
        return (w0.l) eVar.k(i - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final w f(w0.l lVar) {
        if ((lVar.f15116g & 2) != 0) {
            if (lVar instanceof w) {
                return (w) lVar;
            }
            if (lVar instanceof m) {
                w0.l lVar2 = ((m) lVar).f13866t;
                while (lVar2 != 0) {
                    if (lVar2 instanceof w) {
                        return (w) lVar2;
                    }
                    lVar2 = (!(lVar2 instanceof m) || (lVar2.f15116g & 2) == 0) ? lVar2.f15118j : ((m) lVar2).f13866t;
                }
            }
        }
        return null;
    }

    public static final int g(long j10, long j11) {
        boolean zP = p(j10);
        if (zP != p(j11)) {
            return zP ? -1 : 1;
        }
        return (Math.min(k(j10), k(j11)) >= 0.0f && o(j10) != o(j11)) ? o(j10) ? -1 : 1 : (int) Math.signum(k(j10) - k(j11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object h(k kVar, k0.s1 s1Var) {
        if (!((w0.l) kVar).f15114c.f15126r) {
            r1.a.b("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }
        s0.g gVar = (s0.g) u(kVar).D;
        gVar.getClass();
        return k0.z.x(gVar, s1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final a2 i(l lVar, Object obj) {
        c1 c1Var;
        w0.l lVar2 = (w0.l) lVar;
        if (!lVar2.f15114c.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar3 = lVar2.f15114c.i;
        g0 g0VarU = u(lVar);
        while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 262144) != 0) {
                while (lVar3 != null) {
                    if ((lVar3.f15116g & 262144) != 0) {
                        m mVarE = lVar3;
                        ?? eVar = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof a2) {
                                a2 a2Var = (a2) mVarE;
                                if (obj.equals(a2Var.k())) {
                                    return a2Var;
                                }
                            } else if ((mVarE.f15116g & 262144) != 0 && (mVarE instanceof m)) {
                                w0.l lVar4 = mVarE.f13866t;
                                int i = 0;
                                mVarE = mVarE;
                                eVar = eVar;
                                while (lVar4 != null) {
                                    if ((lVar4.f15116g & 262144) != 0) {
                                        i++;
                                        eVar = eVar;
                                        if (i == 1) {
                                            mVarE = lVar4;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar.b(lVar4);
                                        }
                                    }
                                    lVar4 = lVar4.f15118j;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                }
                                if (i == 1) {
                                }
                            }
                            mVarE = e(eVar);
                        }
                    }
                    lVar3 = lVar3.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar3 = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, u1.a2, u1.l] */
    /* JADX WARN: Type inference failed for: r3v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r3v9 */
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
    public static final a2 j(a2 a2Var) {
        c1 c1Var;
        w0.l lVar = (w0.l) a2Var;
        if (!lVar.f15114c.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar2 = lVar.f15114c.i;
        g0 g0VarU = u(a2Var);
        while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 262144) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f15116g & 262144) != 0) {
                        m mVarE = lVar2;
                        ?? eVar = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof a2) {
                                a2 a2Var2 = (a2) mVarE;
                                if (yb.k.a(a2Var.k(), a2Var2.k()) && a2Var.getClass() == a2Var2.getClass()) {
                                    return a2Var2;
                                }
                            } else if ((mVarE.f15116g & 262144) != 0 && (mVarE instanceof m)) {
                                w0.l lVar3 = mVarE.f13866t;
                                int i = 0;
                                mVarE = mVarE;
                                eVar = eVar;
                                while (lVar3 != null) {
                                    if ((lVar3.f15116g & 262144) != 0) {
                                        i++;
                                        eVar = eVar;
                                        if (i == 1) {
                                            mVarE = lVar3;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar.b(lVar3);
                                        }
                                    }
                                    lVar3 = lVar3.f15118j;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                }
                                if (i == 1) {
                                }
                            }
                            mVarE = e(eVar);
                        }
                    }
                    lVar2 = lVar2.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar2 = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
        return null;
    }

    public static final float k(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(n nVar) {
        if (((w0.l) nVar).f15114c.f15126r) {
            s(nVar, 1).O0();
        }
    }

    public static final void m(w wVar) {
        u(wVar).C();
    }

    public static final void n(v1 v1Var) {
        u(v1Var).E();
    }

    public static final boolean o(long j10) {
        return (j10 & 2) != 0;
    }

    public static final boolean p(long j10) {
        return (j10 & 1) != 0;
    }

    public static final boolean q(g0 g0Var) {
        if (g0Var.f13794k == null) {
            return false;
        }
        g0 g0VarT = g0Var.t();
        return (g0VarT != null ? g0VarT.f13794k : null) == null || g0Var.I.f13844b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(w0.l lVar, xb.a aVar) {
        j1 j1Var = lVar.f15119k;
        if (j1Var == null) {
            j1Var = new j1();
            j1Var.f13842c = (i1) lVar;
            VarHandle.storeStoreFence();
            lVar.f15119k = j1Var;
        }
        ((v1.t) v(lVar)).getSnapshotObserver().a(j1Var, e.f13756j, aVar);
    }

    public static final g1 s(l lVar, int i) {
        g1 g1Var = ((w0.l) lVar).f15114c.f15120l;
        g1Var.getClass();
        if (g1Var.H0() != lVar || !h1.g(i)) {
            return g1Var;
        }
        g1 g1Var2 = g1Var.f13811t;
        g1Var2.getClass();
        return g1Var2;
    }

    public static final g1 t(l lVar) {
        if (!((w0.l) lVar).f15114c.f15126r) {
            r1.a.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        g1 g1VarS = s(lVar, 2);
        if (!g1VarS.H0().f15126r) {
            r1.a.b("LayoutCoordinates is not attached.");
        }
        return g1VarS;
    }

    public static final g0 u(l lVar) {
        g1 g1Var = ((w0.l) lVar).f15114c.f15120l;
        if (g1Var != null) {
            return g1Var.f13810s;
        }
        throw w2.c.a("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final n1 v(l lVar) {
        n1 n1Var = u(lVar).f13800q;
        if (n1Var != null) {
            return n1Var;
        }
        throw w2.c.a("This node does not have an owner.");
    }

    public static final View w(l lVar) {
        if (!((w0.l) lVar).f15114c.f15126r) {
            r1.a.b("Cannot get View because the Modifier node is not currently attached.");
        }
        return (View) j0.a(u(lVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, u1.a2, u1.l] */
    /* JADX WARN: Type inference failed for: r12v0, types: [xb.l] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [w0.l] */
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
    public static final void x(a2 a2Var, xb.l lVar) {
        c1 c1Var;
        w0.l lVar2 = (w0.l) a2Var;
        if (!lVar2.f15114c.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar3 = lVar2.f15114c.i;
        g0 g0VarU = u(a2Var);
        while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 262144) != 0) {
                while (lVar3 != null) {
                    if ((lVar3.f15116g & 262144) != 0) {
                        m mVarE = lVar3;
                        ?? eVar = 0;
                        while (mVarE != 0) {
                            boolean zBooleanValue = true;
                            if (mVarE instanceof a2) {
                                a2 a2Var2 = (a2) mVarE;
                                if (yb.k.a(a2Var.k(), a2Var2.k()) && a2Var.getClass() == a2Var2.getClass()) {
                                    zBooleanValue = ((Boolean) lVar.invoke(a2Var2)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else {
                                if (((mVarE.f15116g & 262144) != 0) && (mVarE instanceof m)) {
                                    w0.l lVar4 = mVarE.f13866t;
                                    int i = 0;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                    while (lVar4 != null) {
                                        if ((lVar4.f15116g & 262144) != 0) {
                                            i++;
                                            eVar = eVar;
                                            if (i == 1) {
                                                mVarE = lVar4;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new m0.e(new w0.l[16]);
                                                }
                                                if (mVarE != 0) {
                                                    eVar.b(mVarE);
                                                    mVarE = 0;
                                                }
                                                eVar.b(lVar4);
                                            }
                                        }
                                        lVar4 = lVar4.f15118j;
                                        mVarE = mVarE;
                                        eVar = eVar;
                                    }
                                    if (i == 1) {
                                    }
                                }
                            }
                            mVarE = e(eVar);
                        }
                    }
                    lVar3 = lVar3.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar3 = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, u1.a2] */
    /* JADX WARN: Type inference failed for: r13v0, types: [xb.l] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final void y(a2 a2Var, xb.l lVar) {
        w0.l lVar2 = (w0.l) a2Var;
        if (!lVar2.f15114c.f15126r) {
            r1.a.b("visitSubtreeIf called on an unattached node");
        }
        m0.e eVar = new m0.e(new w0.l[16]);
        w0.l lVar3 = lVar2.f15114c;
        w0.l lVar4 = lVar3.f15118j;
        if (lVar4 == null) {
            b(eVar, lVar3);
        } else {
            eVar.b(lVar4);
        }
        while (true) {
            int i = eVar.f8160g;
            if (i == 0) {
                return;
            }
            w0.l lVar5 = (w0.l) eVar.k(i - 1);
            if ((lVar5.f15117h & 262144) != 0) {
                for (w0.l lVar6 = lVar5; lVar6 != null; lVar6 = lVar6.f15118j) {
                    if ((lVar6.f15116g & 262144) != 0) {
                        m mVarE = lVar6;
                        ?? eVar2 = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof a2) {
                                a2 a2Var2 = (a2) mVarE;
                                z1 z1Var = (yb.k.a(a2Var.k(), a2Var2.k()) && a2Var.getClass() == a2Var2.getClass()) ? (z1) lVar.invoke(a2Var2) : z1.f13977c;
                                if (z1Var == z1.f13979g) {
                                    return;
                                }
                                if (z1Var == z1.f13978f) {
                                    break;
                                }
                            } else if ((mVarE.f15116g & 262144) != 0 && (mVarE instanceof m)) {
                                w0.l lVar7 = mVarE.f13866t;
                                int i3 = 0;
                                mVarE = mVarE;
                                eVar2 = eVar2;
                                while (lVar7 != null) {
                                    if ((lVar7.f15116g & 262144) != 0) {
                                        i3++;
                                        eVar2 = eVar2;
                                        if (i3 == 1) {
                                            mVarE = lVar7;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar2.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar2.b(lVar7);
                                        }
                                    }
                                    lVar7 = lVar7.f15118j;
                                    mVarE = mVarE;
                                    eVar2 = eVar2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            mVarE = e(eVar2);
                        }
                    }
                }
            }
            b(eVar, lVar5);
        }
    }
}
