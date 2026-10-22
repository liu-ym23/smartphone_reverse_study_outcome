package u1;

import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    public static final p.z f13831a;

    static {
        p.z zVar = p.j0.f9585a;
        f13831a = new p.z();
    }

    public static final void a(w0.l lVar, int i, int i3) {
        if (!(lVar instanceof m)) {
            b(lVar, i & lVar.f15116g, i3);
            return;
        }
        m mVar = (m) lVar;
        int i10 = mVar.f13865s;
        b(lVar, i10 & i, i3);
        int i11 = (~i10) & i;
        for (w0.l lVar2 = mVar.f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
            a(lVar2, i11, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(w0.l lVar, int i, int i3) {
        if (i3 != 0 || lVar.q0()) {
            if ((i & 2) != 0 && (lVar instanceof w)) {
                f.m((w) lVar);
                if (i3 == 2) {
                    g1 g1VarS = f.s(lVar, 2);
                    g1VarS.f13813v = true;
                    g1VarS.K.invoke();
                    g1VarS.Y0();
                }
            }
            if ((i & 128) != 0 && (lVar instanceof v) && i3 != 2) {
                f.u(lVar).C();
            }
            if ((i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 && (lVar instanceof o)) {
                if (i3 == 1) {
                    g0 g0VarU = f.u(lVar);
                    g0VarU.a0(g0VarU.R + 1);
                } else if (i3 == 2) {
                    f.u(lVar).a0(r0.R - 1);
                }
                if (i3 != 2) {
                    g0 g0VarU2 = f.u(lVar);
                    if (g0VarU2.R != 0 && !g0VarU2.p() && !g0VarU2.q() && !g0VarU2.Q) {
                        v1.t tVar = (v1.t) j0.a(g0VarU2);
                        p5.c cVar = tVar.R.f13949e;
                        cVar.getClass();
                        if (g0VarU2.R > 0) {
                            ((m0.e) cVar.f9717f).b(g0VarU2);
                            g0VarU2.Q = true;
                        }
                        tVar.D(null);
                    }
                }
            }
            if ((i & 4) != 0 && (lVar instanceof n)) {
                f.l((n) lVar);
            }
            if ((i & 8) != 0 && (lVar instanceof v1)) {
                f.u(lVar).f13804u = true;
            }
            if ((i & 64) != 0 && (lVar instanceof q1)) {
                k0 k0Var = f.u((q1) lVar).I;
                k0Var.f13857p.f13967u = true;
                t0 t0Var = k0Var.f13858q;
                if (t0Var != null) {
                    t0Var.f13937z = true;
                }
            }
            if ((i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 && (lVar instanceof b1.m)) {
                b1.m mVar = (b1.m) lVar;
                g.f13788b = null;
                mVar.U(g.f13787a);
                if (g.f13788b != null) {
                    w0.l lVar2 = (w0.l) mVar;
                    if (!lVar2.f15114c.f15126r) {
                        r1.a.b("visitChildren called on an unattached node");
                    }
                    m0.e eVar = new m0.e(new w0.l[16]);
                    w0.l lVar3 = lVar2.f15114c;
                    w0.l lVar4 = lVar3.f15118j;
                    if (lVar4 == null) {
                        f.b(eVar, lVar3);
                    } else {
                        eVar.b(lVar4);
                    }
                    while (true) {
                        int i10 = eVar.f8160g;
                        if (i10 == 0) {
                            break;
                        }
                        w0.l lVarE = (w0.l) eVar.k(i10 - 1);
                        if ((lVarE.f15117h & 1024) == 0) {
                            f.b(eVar, lVarE);
                        } else {
                            while (true) {
                                if (lVarE == null) {
                                    break;
                                }
                                if ((lVarE.f15116g & 1024) != 0) {
                                    m0.e eVar2 = null;
                                    while (lVarE != null) {
                                        if (lVarE instanceof b1.q) {
                                            b1.q qVar = (b1.q) lVarE;
                                            b1.f fVar = ((b1.i) ((v1.t) f.v(qVar)).getFocusOwner()).f1821d;
                                            if (fVar.f1814c.a(qVar)) {
                                                fVar.a();
                                            }
                                        } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof m)) {
                                            int i11 = 0;
                                            for (w0.l lVar5 = ((m) lVarE).f13866t; lVar5 != null; lVar5 = lVar5.f15118j) {
                                                if ((lVar5.f15116g & 1024) != 0) {
                                                    i11++;
                                                    if (i11 == 1) {
                                                        lVarE = lVar5;
                                                    } else {
                                                        if (eVar2 == null) {
                                                            eVar2 = new m0.e(new w0.l[16]);
                                                        }
                                                        if (lVarE != null) {
                                                            eVar2.b(lVarE);
                                                            lVarE = null;
                                                        }
                                                        eVar2.b(lVar5);
                                                    }
                                                }
                                            }
                                            if (i11 == 1) {
                                            }
                                        }
                                        lVarE = f.e(eVar2);
                                    }
                                } else {
                                    lVarE = lVarE.f15118j;
                                }
                            }
                        }
                    }
                }
            }
            if ((i & 4096) == 0 || !(lVar instanceof b1.d)) {
                return;
            }
            b1.d dVar = (b1.d) lVar;
            b1.f fVar2 = ((b1.i) ((v1.t) f.v(dVar)).getFocusOwner()).f1821d;
            if (fVar2.f1815d.a(dVar)) {
                fVar2.a();
            }
        }
    }

    public static final void c(w0.l lVar) {
        if (!lVar.f15126r) {
            r1.a.b("autoInvalidateUpdatedNode called on unattached node");
        }
        a(lVar, -1, 0);
    }

    public static final int d(w0.k kVar) {
        int i = kVar instanceof s1.r ? 3 : 1;
        if (kVar instanceof a1.f) {
            i |= 4;
        }
        if (kVar instanceof AppendedSemanticsElement) {
            i |= 8;
        }
        if (kVar instanceof o1.z) {
            i |= 16;
        }
        if ((kVar instanceof t1.c) || (kVar instanceof t1.g)) {
            i |= 32;
        }
        if (kVar instanceof y.d) {
            i |= ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
        }
        if (kVar instanceof s1.l0) {
            i |= 64;
        }
        return kVar instanceof v1.t0 ? 524288 | i : i;
    }

    public static final int e(w0.l lVar) {
        int i = lVar.f15116g;
        if (i != 0) {
            return i;
        }
        Class<?> cls = lVar.getClass();
        p.z zVar = f13831a;
        int iD = zVar.d(cls);
        if (iD >= 0) {
            return zVar.f9652c[iD];
        }
        int i3 = lVar instanceof w ? 3 : 1;
        if (lVar instanceof n) {
            i3 |= 4;
        }
        if (lVar instanceof v1) {
            i3 |= 8;
        }
        if (lVar instanceof s1) {
            i3 |= 16;
        }
        if (lVar instanceof t1.f) {
            i3 |= 32;
        }
        if (lVar instanceof q1) {
            i3 |= 64;
        }
        if (lVar instanceof v) {
            i3 |= 128;
        }
        if (lVar instanceof o) {
            i3 |= ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
        }
        if (lVar instanceof b1.q) {
            i3 |= 1024;
        }
        if (lVar instanceof b1.m) {
            i3 |= RecyclerView.ItemAnimator.FLAG_MOVED;
        }
        if (lVar instanceof b1.d) {
            i3 |= 4096;
        }
        if (lVar instanceof m1.c) {
            i3 |= 8192;
        }
        if (lVar instanceof q1.a) {
            i3 |= 16384;
        }
        if (lVar instanceof k) {
            i3 |= 32768;
        }
        if (lVar instanceof a2) {
            i3 |= 262144;
        }
        if (lVar instanceof v1.t0) {
            i3 |= 524288;
        }
        zVar.h(i3, cls);
        return i3;
    }

    public static final int f(w0.l lVar) {
        if (!(lVar instanceof m)) {
            return e(lVar);
        }
        m mVar = (m) lVar;
        int iF = mVar.f13865s;
        for (w0.l lVar2 = mVar.f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
            iF |= f(lVar2);
        }
        return iF;
    }

    public static final boolean g(int i) {
        return (i & 128) != 0;
    }
}
