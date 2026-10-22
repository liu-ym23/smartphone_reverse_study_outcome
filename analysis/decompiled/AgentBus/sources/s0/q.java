package s0;

import a4.u;
import android.os.Trace;
import fi.iki.elonen.NanoHTTPD;
import i1.a1;
import i1.f0;
import i1.f1;
import i1.u1;
import ia.j1;
import j1.g1;
import j1.y;
import m4.u0;
import q7.v;

/* loaded from: classes.dex */
public final class q extends n0.l implements i1.i, f1, h1.d {

    /* renamed from: t, reason: collision with root package name */
    public final p7.k f9198t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9199u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9200v;

    /* renamed from: w, reason: collision with root package name */
    public final int f9201w;

    public q(j1 j1Var, int i2) {
        int i10 = (i2 & 1) != 0 ? 1 : 2;
        this.f9198t = (i2 & 4) != 0 ? null : j1Var;
        this.f9201w = i10;
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // n0.l
    public final void e0() {
        int iOrdinal = n0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new u();
                }
                return;
            }
        }
        u0 u0Var = (u0) ((y) i1.l.v(this)).getFocusOwner();
        u0Var.e(8, true, false);
        ((f) u0Var.f6344d).a();
    }

    @Override // n0.l
    public final void f0() {
        if (n0().a()) {
            ((u0) ((y) i1.l.v(this)).getFocusOwner()).e(8, true, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [d0.e] */
    public final void l0(p pVar, p pVar2) {
        a1 a1Var;
        u0 u0Var = (u0) ((y) i1.l.v(this)).getFocusOwner();
        q qVar = (q) u0Var.f6348h;
        pVar.equals(pVar2);
        n0.l lVar = this.f6797f;
        if (!lVar.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar2 = this.f6797f;
        f0 f0VarU = i1.l.u(this);
        loop0: while (f0VarU != null) {
            if ((((n0.l) f0VarU.H.f4404j).f6800i & 5120) != 0) {
                while (lVar2 != null) {
                    int i2 = lVar2.f6799h;
                    if ((i2 & 5120) != 0) {
                        if (lVar2 != lVar && (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                            break loop0;
                        }
                        if ((i2 & 4096) != 0) {
                            i1.k kVarE = lVar2;
                            ?? eVar = 0;
                            while (kVarE != 0) {
                                if (kVarE instanceof d) {
                                    d dVar = (d) kVarE;
                                    if (qVar == ((q) u0Var.f6348h)) {
                                        dVar.f(pVar2);
                                    }
                                } else if ((kVarE.f6799h & 4096) != 0 && (kVarE instanceof i1.k)) {
                                    n0.l lVar3 = kVarE.f4514u;
                                    int i10 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar3 != null) {
                                        if ((lVar3.f6799h & 4096) != 0) {
                                            i10++;
                                            eVar = eVar;
                                            if (i10 == 1) {
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
                                    if (i10 == 1) {
                                    }
                                }
                                kVarE = i1.l.e(eVar);
                            }
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        p7.k kVar = this.f9198t;
        if (kVar != null) {
            kVar.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [d0.e] */
    public final k m0() {
        boolean z4;
        a1 a1Var;
        k kVar = new k();
        kVar.f9178a = true;
        m mVar = m.f9189b;
        kVar.f9179b = mVar;
        kVar.f9180c = mVar;
        kVar.f9181d = mVar;
        kVar.f9182e = mVar;
        kVar.f9183f = mVar;
        kVar.f9184g = mVar;
        kVar.f9185h = mVar;
        kVar.f9186i = mVar;
        kVar.f9187j = j.f9174h;
        kVar.f9188k = j.f9175i;
        int i2 = this.f9201w;
        if (i2 == 1) {
            z4 = true;
        } else if (i2 == 0) {
            z4 = !(((z0.a) ((z0.c) ((z0.b) i1.l.h(this, g1.f5179m))).f11755a.getValue()).f11754a == 1);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("Unknown Focusability");
            }
            z4 = false;
        }
        kVar.f9178a = z4;
        n0.l lVar = this.f6797f;
        if (!lVar.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar2 = this.f6797f;
        f0 f0VarU = i1.l.u(this);
        loop0: while (f0VarU != null) {
            if ((((n0.l) f0VarU.H.f4404j).f6800i & 3072) != 0) {
                while (lVar2 != null) {
                    int i10 = lVar2.f6799h;
                    if ((i10 & 3072) != 0) {
                        if (lVar2 != lVar && (i10 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                            break loop0;
                        }
                        if ((i10 & 2048) != 0) {
                            i1.k kVarE = lVar2;
                            ?? eVar = 0;
                            while (kVarE != 0) {
                                if (kVarE instanceof l) {
                                    ((l) kVarE).x(kVar);
                                } else if ((kVarE.f6799h & 2048) != 0 && (kVarE instanceof i1.k)) {
                                    n0.l lVar3 = kVarE.f4514u;
                                    int i11 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar3 != null) {
                                        if ((lVar3.f6799h & 2048) != 0) {
                                            i11++;
                                            eVar = eVar;
                                            if (i11 == 1) {
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
                                    if (i11 == 1) {
                                    }
                                }
                                kVarE = i1.l.e(eVar);
                            }
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        return kVar;
    }

    public final p n0() {
        a1 a1Var;
        if (!this.f6810s) {
            return p.f9196i;
        }
        u0 u0Var = (u0) ((y) i1.l.v(this)).getFocusOwner();
        q qVar = (q) u0Var.f6348h;
        if (qVar == null) {
            return p.f9196i;
        }
        if (this == qVar) {
            u0Var.getClass();
            return p.f9193f;
        }
        if (qVar.f6810s) {
            if (!qVar.f6797f.f6810s) {
                f1.a.b("visitAncestors called on an unattached node");
            }
            n0.l lVar = qVar.f6797f.f6801j;
            f0 f0VarU = i1.l.u(qVar);
            while (f0VarU != null) {
                if ((((n0.l) f0VarU.H.f4404j).f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                    while (lVar != null) {
                        if ((lVar.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                            n0.l lVarE = lVar;
                            d0.e eVar = null;
                            while (lVarE != null) {
                                if (lVarE instanceof q) {
                                    if (this == ((q) lVarE)) {
                                        return p.f9194g;
                                    }
                                } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                    int i2 = 0;
                                    for (n0.l lVar2 = ((i1.k) lVarE).f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
                                        if ((lVar2.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                lVarE = lVar2;
                                            } else {
                                                if (eVar == null) {
                                                    eVar = new d0.e(new n0.l[16]);
                                                }
                                                if (lVarE != null) {
                                                    eVar.b(lVarE);
                                                    lVarE = null;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                lVarE = i1.l.e(eVar);
                            }
                        }
                        lVar = lVar.f6801j;
                    }
                }
                f0VarU = f0VarU.n();
                lVar = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
            }
        }
        return p.f9196i;
    }

    public final void o0() {
        int iOrdinal = n0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new u();
                }
                return;
            }
        }
        v vVar = new v();
        i1.l.r(this, new a8.e(18, vVar, this));
        Object obj = vVar.f8820f;
        if (obj == null) {
            q7.k.j("focusProperties");
            throw null;
        }
        if (((i) obj).a()) {
            return;
        }
        ((u0) ((y) i1.l.v(this)).getFocusOwner()).e(8, true, true);
    }

    public final boolean p0(int i2) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            boolean zV = false;
            if (!m0().f9178a) {
                return false;
            }
            int iOrdinal = e.u(this).ordinal();
            if (iOrdinal == 0) {
                zV = e.v(this);
            } else if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    zV = true;
                } else if (iOrdinal != 3) {
                    throw new u();
                }
            }
            return zV;
        } finally {
            Trace.endSection();
        }
    }

    @Override // i1.f1
    public final void v() {
        o0();
    }
}
