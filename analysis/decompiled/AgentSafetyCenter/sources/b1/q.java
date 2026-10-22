package b1;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import u1.c1;
import u1.g0;
import u1.i1;
import v1.a1;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends w0.l implements u1.k, i1, t1.f {

    /* renamed from: s, reason: collision with root package name */
    public final xb.l f1848s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1849t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1850u;

    /* renamed from: v, reason: collision with root package name */
    public final int f1851v;

    public q(androidx.room.d dVar, int i) {
        int i3 = (i & 1) != 0 ? 1 : 2;
        this.f1848s = (i & 4) != 0 ? null : dVar;
        this.f1851v = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [m0.e] */
    public final void B0(p pVar, p pVar2) {
        c1 c1Var;
        i iVar = (i) ((v1.t) u1.f.v(this)).getFocusOwner();
        q qVar = iVar.f1825h;
        pVar.equals(pVar2);
        w0.l lVar = this.f15114c;
        if (!lVar.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar2 = this.f15114c;
        g0 g0VarU = u1.f.u(this);
        loop0: while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 5120) != 0) {
                while (lVar2 != null) {
                    int i = lVar2.f15116g;
                    if ((i & 5120) != 0) {
                        if (lVar2 != lVar && (i & 1024) != 0) {
                            break loop0;
                        }
                        if ((i & 4096) != 0) {
                            u1.m mVarE = lVar2;
                            ?? eVar = 0;
                            while (mVarE != 0) {
                                if (mVarE instanceof d) {
                                    d dVar = (d) mVarE;
                                    if (qVar == iVar.f1825h) {
                                        dVar.w(pVar2);
                                    }
                                } else if ((mVarE.f15116g & 4096) != 0 && (mVarE instanceof u1.m)) {
                                    w0.l lVar3 = mVarE.f13866t;
                                    int i3 = 0;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                    while (lVar3 != null) {
                                        if ((lVar3.f15116g & 4096) != 0) {
                                            i3++;
                                            eVar = eVar;
                                            if (i3 == 1) {
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
                                    if (i3 == 1) {
                                    }
                                }
                                mVarE = u1.f.e(eVar);
                            }
                        }
                    }
                    lVar2 = lVar2.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar2 = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
        xb.l lVar4 = this.f1848s;
        if (lVar4 != null) {
            lVar4.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [m0.e] */
    public final l C0() {
        boolean z10;
        c1 c1Var;
        l lVar = new l();
        lVar.f1830a = true;
        n nVar = n.f1840b;
        lVar.f1831b = nVar;
        lVar.f1832c = nVar;
        lVar.f1833d = nVar;
        lVar.f1834e = nVar;
        lVar.f1835f = nVar;
        lVar.f1836g = nVar;
        lVar.f1837h = nVar;
        lVar.i = nVar;
        lVar.f1838j = k.f1826f;
        lVar.f1839k = k.f1827g;
        int i = this.f1851v;
        if (i == 1) {
            z10 = true;
        } else if (i == 0) {
            z10 = !(((l1.a) ((l1.c) ((l1.b) u1.f.h(this, a1.f14367m))).f7714a.getValue()).f7713a == 1);
        } else {
            if (i != 2) {
                od.f.e("Unknown Focusability");
                return null;
            }
            z10 = false;
        }
        lVar.f1830a = z10;
        w0.l lVar2 = this.f15114c;
        if (!lVar2.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar3 = this.f15114c;
        g0 g0VarU = u1.f.u(this);
        loop0: while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 3072) != 0) {
                while (lVar3 != null) {
                    int i3 = lVar3.f15116g;
                    if ((i3 & 3072) != 0) {
                        if (lVar3 != lVar2 && (i3 & 1024) != 0) {
                            break loop0;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            u1.m mVarE = lVar3;
                            ?? eVar = 0;
                            while (mVarE != 0) {
                                if (mVarE instanceof m) {
                                    ((m) mVarE).U(lVar);
                                } else if ((mVarE.f15116g & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 && (mVarE instanceof u1.m)) {
                                    w0.l lVar4 = mVarE.f13866t;
                                    int i10 = 0;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                    while (lVar4 != null) {
                                        if ((lVar4.f15116g & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                                            i10++;
                                            eVar = eVar;
                                            if (i10 == 1) {
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
                                    if (i10 == 1) {
                                    }
                                }
                                mVarE = u1.f.e(eVar);
                            }
                        }
                    }
                    lVar3 = lVar3.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar3 = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
        return lVar;
    }

    public final p D0() {
        c1 c1Var;
        if (!this.f15126r) {
            return p.f1847h;
        }
        i iVar = (i) ((v1.t) u1.f.v(this)).getFocusOwner();
        q qVar = iVar.f1825h;
        if (qVar == null) {
            return p.f1847h;
        }
        if (this == qVar) {
            iVar.getClass();
            return p.f1844c;
        }
        if (qVar.f15126r) {
            if (!qVar.f15114c.f15126r) {
                r1.a.b("visitAncestors called on an unattached node");
            }
            w0.l lVar = qVar.f15114c.i;
            g0 g0VarU = u1.f.u(qVar);
            while (g0VarU != null) {
                if ((g0VarU.H.f13746f.f15117h & 1024) != 0) {
                    while (lVar != null) {
                        if ((lVar.f15116g & 1024) != 0) {
                            w0.l lVarE = lVar;
                            m0.e eVar = null;
                            while (lVarE != null) {
                                if (lVarE instanceof q) {
                                    if (this == ((q) lVarE)) {
                                        return p.f1845f;
                                    }
                                } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                    int i = 0;
                                    for (w0.l lVar2 = ((u1.m) lVarE).f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
                                        if ((lVar2.f15116g & 1024) != 0) {
                                            i++;
                                            if (i == 1) {
                                                lVarE = lVar2;
                                            } else {
                                                if (eVar == null) {
                                                    eVar = new m0.e(new w0.l[16]);
                                                }
                                                if (lVarE != null) {
                                                    eVar.b(lVarE);
                                                    lVarE = null;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                lVarE = u1.f.e(eVar);
                            }
                        }
                        lVar = lVar.i;
                    }
                }
                g0VarU = g0VarU.t();
                lVar = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
            }
        }
        return p.f1847h;
    }

    public final void E0() {
        int iOrdinal = D0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return;
                }
                g5.f.a();
                return;
            }
        }
        u uVar = new u();
        u1.f.r(this, new a1.b(3, uVar, this));
        Object obj = uVar.f16098c;
        if (obj == null) {
            yb.k.f("focusProperties");
            throw null;
        }
        if (((j) obj).a()) {
            return;
        }
        ((i) ((v1.t) u1.f.v(this)).getFocusOwner()).b(8, true, true);
    }

    public final boolean F0(int i) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            boolean zV = false;
            if (!C0().f1830a) {
                return false;
            }
            int iOrdinal = e.u(this, i).ordinal();
            if (iOrdinal == 0) {
                zV = e.v(this);
            } else if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    zV = true;
                } else if (iOrdinal != 3) {
                    throw new androidx.fragment.app.d();
                }
            }
            return zV;
        } finally {
            Trace.endSection();
        }
    }

    @Override // u1.i1
    public final void c0() {
        E0();
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    @Override // w0.l
    public final void u0() {
        int iOrdinal = D0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return;
                }
                g5.f.a();
                return;
            }
        }
        i iVar = (i) ((v1.t) u1.f.v(this)).getFocusOwner();
        iVar.b(8, true, false);
        iVar.f1821d.a();
    }

    @Override // w0.l
    public final void v0() {
        if (D0().a()) {
            ((i) ((v1.t) u1.f.v(this)).getFocusOwner()).b(8, true, true);
        }
    }
}
