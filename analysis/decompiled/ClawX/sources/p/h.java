package p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final b f4622a = new b();

    public static boolean a(o.d dVar) {
        int[] iArr = dVar.f4239o0;
        int i8 = iArr[0];
        int i9 = iArr[1];
        o.d dVar2 = dVar.S;
        o.e eVar = dVar2 != null ? (o.e) dVar2 : null;
        if (eVar != null) {
            int i10 = eVar.f4239o0[0];
        }
        if (eVar != null) {
            int i11 = eVar.f4239o0[1];
        }
        boolean z = i8 == 1 || dVar.x() || i8 == 2 || (i8 == 3 && dVar.f4241q == 0 && dVar.V == 0.0f && dVar.q(0)) || (i8 == 3 && dVar.f4241q == 1 && dVar.r(0, dVar.n()));
        boolean z2 = i9 == 1 || dVar.y() || i9 == 2 || (i9 == 3 && dVar.f4242r == 0 && dVar.V == 0.0f && dVar.q(1)) || (i8 == 3 && dVar.f4242r == 1 && dVar.r(1, dVar.k()));
        return (dVar.V > 0.0f && (z || z2)) || (z && z2);
    }

    public static n b(o.d dVar, int i8, ArrayList arrayList, n nVar) {
        int i9;
        int i10 = i8 == 0 ? dVar.f4235m0 : dVar.f4237n0;
        if (i10 != -1 && (nVar == null || i10 != nVar.f4630b)) {
            int i11 = 0;
            while (true) {
                if (i11 >= arrayList.size()) {
                    break;
                }
                n nVar2 = (n) arrayList.get(i11);
                if (nVar2.f4630b == i10) {
                    if (nVar != null) {
                        nVar.c(i8, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i11++;
                }
            }
        } else if (i10 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if (dVar instanceof o.i) {
                o.i iVar = (o.i) dVar;
                int i12 = 0;
                while (true) {
                    if (i12 >= iVar.f4294q0) {
                        i9 = -1;
                        break;
                    }
                    o.d dVar2 = iVar.f4293p0[i12];
                    if ((i8 == 0 && (i9 = dVar2.f4235m0) != -1) || (i8 == 1 && (i9 = dVar2.f4237n0) != -1)) {
                        break;
                    }
                    i12++;
                }
                if (i9 != -1) {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= arrayList.size()) {
                            break;
                        }
                        n nVar3 = (n) arrayList.get(i13);
                        if (nVar3.f4630b == i9) {
                            nVar = nVar3;
                            break;
                        }
                        i13++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n();
                nVar.f4629a = new ArrayList();
                nVar.d = null;
                nVar.f4632e = -1;
                int i14 = n.f4628f;
                n.f4628f = i14 + 1;
                nVar.f4630b = i14;
                nVar.f4631c = i8;
            }
            arrayList.add(nVar);
        }
        int i15 = nVar.f4630b;
        ArrayList arrayList2 = nVar.f4629a;
        if (arrayList2.contains(dVar)) {
            return nVar;
        }
        arrayList2.add(dVar);
        if (dVar instanceof o.h) {
            o.h hVar = (o.h) dVar;
            hVar.f4290s0.c(hVar.f4291t0 == 0 ? 1 : 0, arrayList, nVar);
        }
        if (i8 == 0) {
            dVar.f4235m0 = i15;
            dVar.H.c(i8, arrayList, nVar);
            dVar.J.c(i8, arrayList, nVar);
        } else {
            dVar.f4237n0 = i15;
            dVar.I.c(i8, arrayList, nVar);
            dVar.L.c(i8, arrayList, nVar);
            dVar.K.c(i8, arrayList, nVar);
        }
        dVar.O.c(i8, arrayList, nVar);
        return nVar;
    }

    public static void c(int i8, o.d dVar, r.f fVar, boolean z) {
        o.c cVar;
        o.c cVar2;
        char c3;
        o.c cVar3;
        o.c cVar4;
        o.c cVar5;
        if (dVar.f4232l) {
            return;
        }
        if (!(dVar instanceof o.e) && dVar.w() && a(dVar)) {
            o.e.Q(dVar, fVar, new b());
        }
        o.c cVarI = dVar.i(2);
        o.c cVarI2 = dVar.i(4);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet hashSet = cVarI.f4204a;
        if (hashSet != null && cVarI.f4206c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                o.c cVar6 = (o.c) it.next();
                o.d dVar2 = cVar6.d;
                int i9 = i8 + 1;
                boolean zA = a(dVar2);
                o.c cVar7 = dVar2.H;
                o.c cVar8 = dVar2.J;
                if (dVar2.w() && zA) {
                    c3 = 0;
                    o.e.Q(dVar2, fVar, new b());
                } else {
                    c3 = 0;
                }
                int i10 = dVar2.f4239o0[c3];
                if (i10 != 3 || zA) {
                    if (!dVar2.w()) {
                        if (cVar6 == cVar7 && cVar8.f4208f == null) {
                            int iE = cVar7.e() + iD;
                            dVar2.E(iE, dVar2.n() + iE);
                            c(i9, dVar2, fVar, z);
                        } else if (cVar6 == cVar8 && cVar7.f4208f == null) {
                            int iE2 = iD - cVar8.e();
                            dVar2.E(iE2 - dVar2.n(), iE2);
                            c(i9, dVar2, fVar, z);
                        } else if (cVar6 == cVar7 && (cVar3 = cVar8.f4208f) != null && cVar3.f4206c && !dVar2.u()) {
                            d(i9, dVar2, fVar, z);
                        }
                    }
                } else if (i10 == 3 && dVar2.f4245u >= 0 && dVar2.f4244t >= 0 && (dVar2.f4222f0 == 8 || (dVar2.f4241q == 0 && dVar2.V == 0.0f))) {
                    if (!dVar2.u() && !dVar2.E && ((cVar6 == cVar7 && (cVar5 = cVar8.f4208f) != null && cVar5.f4206c) || (cVar6 == cVar8 && (cVar4 = cVar7.f4208f) != null && cVar4.f4206c))) {
                        if (!dVar2.u()) {
                            e(i9, dVar, fVar, dVar2, z);
                        }
                    }
                }
            }
        }
        if (dVar instanceof o.h) {
            return;
        }
        HashSet hashSet2 = cVarI2.f4204a;
        if (hashSet2 != null && cVarI2.f4206c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                o.c cVar9 = (o.c) it2.next();
                o.d dVar3 = cVar9.d;
                int i11 = i8 + 1;
                boolean zA2 = a(dVar3);
                o.c cVar10 = dVar3.H;
                o.c cVar11 = dVar3.J;
                if (dVar3.w() && zA2) {
                    o.e.Q(dVar3, fVar, new b());
                }
                boolean z2 = (cVar9 == cVar10 && (cVar2 = cVar11.f4208f) != null && cVar2.f4206c) || (cVar9 == cVar11 && (cVar = cVar10.f4208f) != null && cVar.f4206c);
                int i12 = dVar3.f4239o0[0];
                if (i12 != 3 || zA2) {
                    if (!dVar3.w()) {
                        if (cVar9 == cVar10 && cVar11.f4208f == null) {
                            int iE3 = cVar10.e() + iD2;
                            dVar3.E(iE3, dVar3.n() + iE3);
                            c(i11, dVar3, fVar, z);
                        } else if (cVar9 == cVar11 && cVar10.f4208f == null) {
                            int iE4 = iD2 - cVar11.e();
                            dVar3.E(iE4 - dVar3.n(), iE4);
                            c(i11, dVar3, fVar, z);
                        } else if (z2 && !dVar3.u()) {
                            d(i11, dVar3, fVar, z);
                        }
                    }
                } else if (i12 == 3 && dVar3.f4245u >= 0 && dVar3.f4244t >= 0 && (dVar3.f4222f0 == 8 || (dVar3.f4241q == 0 && dVar3.V == 0.0f))) {
                    if (!dVar3.u() && !dVar3.E && z2 && !dVar3.u()) {
                        e(i11, dVar, fVar, dVar3, z);
                    }
                }
            }
        }
        dVar.f4232l = true;
    }

    public static void d(int i8, o.d dVar, r.f fVar, boolean z) {
        float f3 = dVar.f4217c0;
        o.c cVar = dVar.H;
        int iD = cVar.f4208f.d();
        o.c cVar2 = dVar.J;
        int iD2 = cVar2.f4208f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f3 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iN = dVar.n();
        int i9 = (iD2 - iD) - iN;
        if (iD > iD2) {
            i9 = (iD - iD2) - iN;
        }
        int i10 = ((int) (i9 > 0 ? (f3 * i9) + 0.5f : f3 * i9)) + iD;
        int i11 = i10 + iN;
        if (iD > iD2) {
            i11 = i10 - iN;
        }
        dVar.E(i10, i11);
        c(i8 + 1, dVar, fVar, z);
    }

    public static void e(int i8, o.d dVar, r.f fVar, o.d dVar2, boolean z) {
        float f3 = dVar2.f4217c0;
        o.c cVar = dVar2.H;
        int iE = cVar.e() + cVar.f4208f.d();
        o.c cVar2 = dVar2.J;
        int iD = cVar2.f4208f.d() - cVar2.e();
        if (iD >= iE) {
            int iN = dVar2.n();
            if (dVar2.f4222f0 != 8) {
                int i9 = dVar2.f4241q;
                if (i9 == 2) {
                    iN = (int) (dVar2.f4217c0 * 0.5f * (dVar instanceof o.e ? dVar.n() : dVar.S.n()));
                } else if (i9 == 0) {
                    iN = iD - iE;
                }
                iN = Math.max(dVar2.f4244t, iN);
                int i10 = dVar2.f4245u;
                if (i10 > 0) {
                    iN = Math.min(i10, iN);
                }
            }
            int i11 = iE + ((int) ((f3 * ((iD - iE) - iN)) + 0.5f));
            dVar2.E(i11, iN + i11);
            c(i8 + 1, dVar2, fVar, z);
        }
    }

    public static void f(int i8, o.d dVar, r.f fVar) {
        float f3 = dVar.f4218d0;
        o.c cVar = dVar.I;
        int iD = cVar.f4208f.d();
        o.c cVar2 = dVar.K;
        int iD2 = cVar2.f4208f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f3 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = dVar.k();
        int i9 = (iD2 - iD) - iK;
        if (iD > iD2) {
            i9 = (iD - iD2) - iK;
        }
        int i10 = (int) (i9 > 0 ? (f3 * i9) + 0.5f : f3 * i9);
        int i11 = iD + i10;
        int i12 = i11 + iK;
        if (iD > iD2) {
            i11 = iD - i10;
            i12 = i11 - iK;
        }
        dVar.F(i11, i12);
        i(i8 + 1, dVar, fVar);
    }

    public static void g(int i8, o.d dVar, r.f fVar, o.d dVar2) {
        float f3 = dVar2.f4218d0;
        o.c cVar = dVar2.I;
        int iE = cVar.e() + cVar.f4208f.d();
        o.c cVar2 = dVar2.K;
        int iD = cVar2.f4208f.d() - cVar2.e();
        if (iD >= iE) {
            int iK = dVar2.k();
            if (dVar2.f4222f0 != 8) {
                int i9 = dVar2.f4242r;
                if (i9 == 2) {
                    iK = (int) (f3 * 0.5f * (dVar instanceof o.e ? dVar.k() : dVar.S.k()));
                } else if (i9 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(dVar2.f4247w, iK);
                int i10 = dVar2.f4248x;
                if (i10 > 0) {
                    iK = Math.min(i10, iK);
                }
            }
            int i11 = iE + ((int) ((f3 * ((iD - iE) - iK)) + 0.5f));
            dVar2.F(i11, iK + i11);
            i(i8 + 1, dVar2, fVar);
        }
    }

    public static boolean h(int i8, int i9, int i10, int i11) {
        return (i10 == 1 || i10 == 2 || (i10 == 4 && i8 != 2)) || (i11 == 1 || i11 == 2 || (i11 == 4 && i9 != 2));
    }

    public static void i(int i8, o.d dVar, r.f fVar) {
        o.c cVar;
        o.c cVar2;
        float f3;
        o.c cVar3;
        o.c cVar4;
        o.c cVar5;
        if (dVar.f4234m) {
            return;
        }
        if (!(dVar instanceof o.e) && dVar.w() && a(dVar)) {
            o.e.Q(dVar, fVar, new b());
        }
        o.c cVarI = dVar.i(3);
        o.c cVarI2 = dVar.i(5);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet hashSet = cVarI.f4204a;
        if (hashSet != null && cVarI.f4206c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                o.c cVar6 = (o.c) it.next();
                o.d dVar2 = cVar6.d;
                int i9 = i8 + 1;
                boolean zA = a(dVar2);
                o.c cVar7 = dVar2.I;
                o.c cVar8 = dVar2.K;
                if (dVar2.w() && zA) {
                    f3 = 0.0f;
                    o.e.Q(dVar2, fVar, new b());
                } else {
                    f3 = 0.0f;
                }
                int i10 = dVar2.f4239o0[1];
                if (i10 != 3 || zA) {
                    if (!dVar2.w()) {
                        if (cVar6 == cVar7 && cVar8.f4208f == null) {
                            int iE = cVar7.e() + iD;
                            dVar2.F(iE, dVar2.k() + iE);
                            i(i9, dVar2, fVar);
                        } else if (cVar6 == cVar8 && cVar8.f4208f == null) {
                            int iE2 = iD - cVar8.e();
                            dVar2.F(iE2 - dVar2.k(), iE2);
                            i(i9, dVar2, fVar);
                        } else if (cVar6 == cVar7 && (cVar3 = cVar8.f4208f) != null && cVar3.f4206c) {
                            f(i9, dVar2, fVar);
                        }
                    }
                } else if (i10 == 3 && dVar2.f4248x >= 0 && dVar2.f4247w >= 0 && (dVar2.f4222f0 == 8 || (dVar2.f4242r == 0 && dVar2.V == f3))) {
                    if (!dVar2.v() && !dVar2.E && ((cVar6 == cVar7 && (cVar5 = cVar8.f4208f) != null && cVar5.f4206c) || (cVar6 == cVar8 && (cVar4 = cVar7.f4208f) != null && cVar4.f4206c))) {
                        if (!dVar2.v()) {
                            g(i9, dVar, fVar, dVar2);
                        }
                    }
                }
            }
        }
        if (dVar instanceof o.h) {
            return;
        }
        HashSet hashSet2 = cVarI2.f4204a;
        if (hashSet2 != null && cVarI2.f4206c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                o.c cVar9 = (o.c) it2.next();
                o.d dVar3 = cVar9.d;
                int i11 = i8 + 1;
                boolean zA2 = a(dVar3);
                o.c cVar10 = dVar3.I;
                o.c cVar11 = dVar3.K;
                if (dVar3.w() && zA2) {
                    o.e.Q(dVar3, fVar, new b());
                }
                boolean z = (cVar9 == cVar10 && (cVar2 = cVar11.f4208f) != null && cVar2.f4206c) || (cVar9 == cVar11 && (cVar = cVar10.f4208f) != null && cVar.f4206c);
                int i12 = dVar3.f4239o0[1];
                if (i12 != 3 || zA2) {
                    if (!dVar3.w()) {
                        if (cVar9 == cVar10 && cVar11.f4208f == null) {
                            int iE3 = cVar10.e() + iD2;
                            dVar3.F(iE3, dVar3.k() + iE3);
                            i(i11, dVar3, fVar);
                        } else if (cVar9 == cVar11 && cVar10.f4208f == null) {
                            int iE4 = iD2 - cVar11.e();
                            dVar3.F(iE4 - dVar3.k(), iE4);
                            i(i11, dVar3, fVar);
                        } else if (z && !dVar3.v()) {
                            f(i11, dVar3, fVar);
                        }
                    }
                } else if (i12 == 3 && dVar3.f4248x >= 0 && dVar3.f4247w >= 0 && (dVar3.f4222f0 == 8 || (dVar3.f4242r == 0 && dVar3.V == 0.0f))) {
                    if (!dVar3.v() && !dVar3.E && z && !dVar3.v()) {
                        g(i11, dVar, fVar, dVar3);
                    }
                }
            }
        }
        o.c cVarI3 = dVar.i(6);
        if (cVarI3.f4204a != null && cVarI3.f4206c) {
            int iD3 = cVarI3.d();
            Iterator it3 = cVarI3.f4204a.iterator();
            while (it3.hasNext()) {
                o.c cVar12 = (o.c) it3.next();
                o.d dVar4 = cVar12.d;
                int i13 = i8 + 1;
                boolean zA3 = a(dVar4);
                o.c cVar13 = dVar4.L;
                if (dVar4.w() && zA3) {
                    o.e.Q(dVar4, fVar, new b());
                }
                if (dVar4.f4239o0[1] != 3 || zA3) {
                    if (!dVar4.w() && cVar12 == cVar13) {
                        int iE5 = cVar12.e() + iD3;
                        if (dVar4.D) {
                            int i14 = iE5 - dVar4.Z;
                            int i15 = dVar4.U + i14;
                            dVar4.Y = i14;
                            dVar4.I.l(i14);
                            dVar4.K.l(i15);
                            cVar13.l(iE5);
                            dVar4.f4231k = true;
                        }
                        i(i13, dVar4, fVar);
                    }
                }
            }
        }
        dVar.f4234m = true;
    }
}
