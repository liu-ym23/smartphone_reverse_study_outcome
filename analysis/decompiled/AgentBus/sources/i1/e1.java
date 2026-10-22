package i1;

import androidx.compose.ui.semantics.AppendedSemanticsElement;
import fi.iki.elonen.NanoHTTPD;

/* loaded from: classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final k.y f4446a;

    static {
        k.y yVar = k.e0.f5483a;
        f4446a = new k.y();
    }

    public static final void a(n0.l lVar, int i2, int i10) {
        if (!(lVar instanceof k)) {
            b(lVar, i2 & lVar.f6799h, i10);
            return;
        }
        k kVar = (k) lVar;
        int i11 = kVar.f4513t;
        b(lVar, i11 & i2, i10);
        int i12 = (~i11) & i2;
        for (n0.l lVar2 = kVar.f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
            a(lVar2, i12, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(n0.l lVar, int i2, int i10) {
        if (i10 != 0 || lVar.a0()) {
            if ((i2 & 2) != 0 && (lVar instanceof v)) {
                l.m((v) lVar);
                if (i10 == 2) {
                    l.s(lVar, 2).N0();
                }
            }
            if ((i2 & 128) != 0 && (lVar instanceof u) && i10 != 2) {
                l.u(lVar).x();
            }
            if ((i2 & 256) != 0 && (lVar instanceof n)) {
                if (i10 == 1) {
                    f0 f0VarU = l.u(lVar);
                    f0VarU.R(f0VarU.O + 1);
                } else if (i10 == 2) {
                    l.u(lVar).R(r0.O - 1);
                }
                if (i10 != 2) {
                    f0 f0VarU2 = l.u(lVar);
                    if (f0VarU2.O != 0 && !f0VarU2.j() && !f0VarU2.k() && !f0VarU2.N) {
                        j1.y yVar = (j1.y) l.w(f0VarU2);
                        q6.b bVar = yVar.R.f4599e;
                        bVar.getClass();
                        if (f0VarU2.O > 0) {
                            ((d0.e) bVar.f8788h).b(f0VarU2);
                            f0VarU2.N = true;
                        }
                        yVar.A(null);
                    }
                }
            }
            if ((i2 & 4) != 0 && (lVar instanceof m)) {
                l.l((m) lVar);
            }
            if ((i2 & 8) != 0 && (lVar instanceof s1)) {
                l.u(lVar).f4467u = true;
            }
            if ((i2 & 64) != 0 && (lVar instanceof n1)) {
                i0 i0Var = l.u((n1) lVar).I;
                i0Var.f4507o.f4616t = true;
                r0 r0Var = i0Var.f4508p;
                if (r0Var != null) {
                    r0Var.f4582z = true;
                }
            }
            if ((i2 & 2048) != 0 && (lVar instanceof s0.l)) {
                s0.l lVar2 = (s0.l) lVar;
                e.f4445b = null;
                lVar2.x(e.f4444a);
                if (e.f4445b != null) {
                    n0.l lVar3 = (n0.l) lVar2;
                    if (!lVar3.f6797f.f6810s) {
                        f1.a.b("visitChildren called on an unattached node");
                    }
                    d0.e eVar = new d0.e(new n0.l[16]);
                    n0.l lVar4 = lVar3.f6797f;
                    n0.l lVar5 = lVar4.f6802k;
                    if (lVar5 == null) {
                        l.b(eVar, lVar4);
                    } else {
                        eVar.b(lVar5);
                    }
                    while (true) {
                        int i11 = eVar.f2751h;
                        if (i11 == 0) {
                            break;
                        }
                        n0.l lVarE = (n0.l) eVar.j(i11 - 1);
                        if ((lVarE.f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 0) {
                            l.b(eVar, lVarE);
                        } else {
                            while (true) {
                                if (lVarE == null) {
                                    break;
                                }
                                if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                    d0.e eVar2 = null;
                                    while (lVarE != null) {
                                        if (lVarE instanceof s0.q) {
                                            s0.q qVar = (s0.q) lVarE;
                                            s0.f fVar = (s0.f) ((m4.u0) ((j1.y) l.v(qVar)).getFocusOwner()).f6344d;
                                            if (fVar.f9170c.a(qVar)) {
                                                fVar.a();
                                            }
                                        } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof k)) {
                                            int i12 = 0;
                                            for (n0.l lVar6 = ((k) lVarE).f4514u; lVar6 != null; lVar6 = lVar6.f6802k) {
                                                if ((lVar6.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                                    i12++;
                                                    if (i12 == 1) {
                                                        lVarE = lVar6;
                                                    } else {
                                                        if (eVar2 == null) {
                                                            eVar2 = new d0.e(new n0.l[16]);
                                                        }
                                                        if (lVarE != null) {
                                                            eVar2.b(lVarE);
                                                            lVarE = null;
                                                        }
                                                        eVar2.b(lVar6);
                                                    }
                                                }
                                            }
                                            if (i12 == 1) {
                                            }
                                        }
                                        lVarE = l.e(eVar2);
                                    }
                                } else {
                                    lVarE = lVarE.f6802k;
                                }
                            }
                        }
                    }
                }
            }
            if ((i2 & 4096) == 0 || !(lVar instanceof s0.d)) {
                return;
            }
            s0.d dVar = (s0.d) lVar;
            s0.f fVar2 = (s0.f) ((m4.u0) ((j1.y) l.v(dVar)).getFocusOwner()).f6344d;
            if (fVar2.f9171d.a(dVar)) {
                fVar2.a();
            }
        }
    }

    public static final void c(n0.l lVar) {
        if (!lVar.f6810s) {
            f1.a.b("autoInvalidateUpdatedNode called on unattached node");
        }
        a(lVar, -1, 0);
    }

    public static final int d(n0.k kVar) {
        int i2 = kVar instanceof r.y ? 3 : 1;
        if (kVar instanceof r0.e) {
            i2 |= 4;
        }
        if (kVar instanceof AppendedSemanticsElement) {
            i2 |= 8;
        }
        if ((kVar instanceof r.y) || (kVar instanceof r.y)) {
            i2 |= 32;
        }
        return kVar instanceof j1.z0 ? 524288 | i2 : i2;
    }

    public static final int e(n0.l lVar) {
        int i2 = lVar.f6799h;
        if (i2 != 0) {
            return i2;
        }
        Class<?> cls = lVar.getClass();
        k.y yVar = f4446a;
        int iD = yVar.d(cls);
        if (iD >= 0) {
            return yVar.f5552c[iD];
        }
        int i10 = lVar instanceof v ? 3 : 1;
        if (lVar instanceof m) {
            i10 |= 4;
        }
        if (lVar instanceof s1) {
            i10 |= 8;
        }
        if (lVar instanceof p1) {
            i10 |= 16;
        }
        if (lVar instanceof h1.d) {
            i10 |= 32;
        }
        if (lVar instanceof n1) {
            i10 |= 64;
        }
        if (lVar instanceof u) {
            i10 |= 128;
        }
        if (lVar instanceof n) {
            i10 |= 256;
        }
        if (lVar instanceof s0.q) {
            i10 |= NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
        }
        if (lVar instanceof s0.l) {
            i10 |= 2048;
        }
        if (lVar instanceof s0.d) {
            i10 |= 4096;
        }
        if (lVar instanceof a1.d) {
            i10 |= NanoHTTPD.HTTPSession.BUFSIZE;
        }
        if (lVar instanceof e1.a) {
            i10 |= 16384;
        }
        if (lVar instanceof i) {
            i10 |= 32768;
        }
        if (lVar instanceof x1) {
            i10 |= 262144;
        }
        if (lVar instanceof j1.z0) {
            i10 |= 524288;
        }
        yVar.h(i10, cls);
        return i10;
    }

    public static final int f(n0.l lVar) {
        if (!(lVar instanceof k)) {
            return e(lVar);
        }
        k kVar = (k) lVar;
        int iF = kVar.f4513t;
        for (n0.l lVar2 = kVar.f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
            iF |= f(lVar2);
        }
        return iF;
    }

    public static final boolean g(int i2) {
        return (i2 & 128) != 0;
    }
}
