package x2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final b f15546a = new b();

    public static boolean a(w2.e eVar) {
        int[] iArr = eVar.f15184o0;
        int i = iArr[0];
        int i3 = iArr[1];
        w2.e eVar2 = eVar.S;
        w2.f fVar = eVar2 != null ? (w2.f) eVar2 : null;
        if (fVar != null) {
            int i10 = fVar.f15184o0[0];
        }
        if (fVar != null) {
            int i11 = fVar.f15184o0[1];
        }
        boolean z10 = i == 1 || eVar.y() || i == 2 || (i == 3 && eVar.f15187r == 0 && eVar.V == 0.0f && eVar.r(0)) || (i == 3 && eVar.f15187r == 1 && eVar.s(0, eVar.o()));
        boolean z11 = i3 == 1 || eVar.z() || i3 == 2 || (i3 == 3 && eVar.f15188s == 0 && eVar.V == 0.0f && eVar.r(1)) || (i3 == 3 && eVar.f15188s == 1 && eVar.s(1, eVar.i()));
        return (eVar.V > 0.0f && (z10 || z11)) || (z10 && z11);
    }

    public static m b(w2.e eVar, int i, ArrayList arrayList, m mVar) {
        int i3;
        int i10 = i == 0 ? eVar.f15180m0 : eVar.f15182n0;
        if (i10 != -1 && (mVar == null || i10 != mVar.f15554b)) {
            int i11 = 0;
            while (true) {
                if (i11 >= arrayList.size()) {
                    break;
                }
                m mVar2 = (m) arrayList.get(i11);
                if (mVar2.f15554b == i10) {
                    if (mVar != null) {
                        mVar.c(i, mVar2);
                        arrayList.remove(mVar);
                    }
                    mVar = mVar2;
                } else {
                    i11++;
                }
            }
        } else if (i10 != -1) {
            return mVar;
        }
        if (mVar == null) {
            if (eVar instanceof w2.a) {
                w2.a aVar = (w2.a) eVar;
                int i12 = 0;
                while (true) {
                    if (i12 >= aVar.f15129q0) {
                        i3 = -1;
                        break;
                    }
                    w2.e eVar2 = aVar.f15128p0[i12];
                    if ((i == 0 && (i3 = eVar2.f15180m0) != -1) || (i == 1 && (i3 = eVar2.f15182n0) != -1)) {
                        break;
                    }
                    i12++;
                }
                if (i3 != -1) {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= arrayList.size()) {
                            break;
                        }
                        m mVar3 = (m) arrayList.get(i13);
                        if (mVar3.f15554b == i3) {
                            mVar = mVar3;
                            break;
                        }
                        i13++;
                    }
                }
            }
            if (mVar == null) {
                mVar = new m();
                mVar.f15553a = new ArrayList();
                mVar.f15556d = null;
                mVar.f15557e = -1;
                int i14 = m.f15552f;
                m.f15552f = i14 + 1;
                mVar.f15554b = i14;
                mVar.f15555c = i;
            }
            arrayList.add(mVar);
        }
        ArrayList arrayList2 = mVar.f15553a;
        if (arrayList2.contains(eVar)) {
            return mVar;
        }
        arrayList2.add(eVar);
        if (eVar instanceof w2.g) {
            w2.g gVar = (w2.g) eVar;
            gVar.f15210s0.b(gVar.f15211t0 == 0 ? 1 : 0, arrayList, mVar);
        }
        int i15 = mVar.f15554b;
        if (i == 0) {
            eVar.f15180m0 = i15;
            eVar.H.b(i, arrayList, mVar);
            eVar.J.b(i, arrayList, mVar);
        } else {
            eVar.f15182n0 = i15;
            eVar.I.b(i, arrayList, mVar);
            eVar.L.b(i, arrayList, mVar);
            eVar.K.b(i, arrayList, mVar);
        }
        eVar.O.b(i, arrayList, mVar);
        return mVar;
    }

    public static void c(int i, w2.e eVar, z2.e eVar2, boolean z10) {
        w2.d dVar;
        w2.d dVar2;
        boolean z11;
        w2.d dVar3;
        w2.d dVar4;
        if (eVar.f15179m) {
            return;
        }
        if (!(eVar instanceof w2.f) && eVar.x() && a(eVar)) {
            w2.f.R(eVar, eVar2, new b());
        }
        w2.d dVarG = eVar.g(2);
        w2.d dVarG2 = eVar.g(4);
        int iC = dVarG.c();
        int iC2 = dVarG2.c();
        HashSet hashSet = dVarG.f15150a;
        if (hashSet != null && dVarG.f15152c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                w2.d dVar5 = (w2.d) it.next();
                w2.e eVar3 = dVar5.f15153d;
                int i3 = i + 1;
                boolean zA = a(eVar3);
                w2.d dVar6 = eVar3.H;
                w2.d dVar7 = eVar3.J;
                if (eVar3.x() && zA) {
                    z11 = true;
                    w2.f.R(eVar3, eVar2, new b());
                } else {
                    z11 = true;
                }
                boolean z12 = ((dVar5 == dVar6 && (dVar4 = dVar7.f15155f) != null && dVar4.f15152c) || (dVar5 == dVar7 && (dVar3 = dVar6.f15155f) != null && dVar3.f15152c)) ? z11 : false;
                int i10 = eVar3.f15184o0[0];
                if (i10 != 3 || zA) {
                    if (!eVar3.x()) {
                        if (dVar5 == dVar6 && dVar7.f15155f == null) {
                            int iD = dVar6.d() + iC;
                            eVar3.F(iD, eVar3.o() + iD);
                            c(i3, eVar3, eVar2, z10);
                        } else if (dVar5 == dVar7 && dVar6.f15155f == null) {
                            int iD2 = iC - dVar7.d();
                            eVar3.F(iD2 - eVar3.o(), iD2);
                            c(i3, eVar3, eVar2, z10);
                        } else if (z12 && !eVar3.v()) {
                            d(i3, eVar3, eVar2, z10);
                        }
                    }
                } else if (i10 == 3 && eVar3.f15191v >= 0 && eVar3.f15190u >= 0 && (eVar3.f0 == 8 || (eVar3.f15187r == 0 && eVar3.V == 0.0f))) {
                    if (!eVar3.v() && z12 && !eVar3.v()) {
                        e(i3, eVar, eVar2, eVar3, z10);
                    }
                }
            }
        }
        if (eVar instanceof w2.g) {
            return;
        }
        HashSet hashSet2 = dVarG2.f15150a;
        if (hashSet2 != null && dVarG2.f15152c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                w2.d dVar8 = (w2.d) it2.next();
                w2.e eVar4 = dVar8.f15153d;
                int i11 = i + 1;
                boolean zA2 = a(eVar4);
                w2.d dVar9 = eVar4.H;
                w2.d dVar10 = eVar4.J;
                if (eVar4.x() && zA2) {
                    w2.f.R(eVar4, eVar2, new b());
                }
                boolean z13 = (dVar8 == dVar9 && (dVar2 = dVar10.f15155f) != null && dVar2.f15152c) || (dVar8 == dVar10 && (dVar = dVar9.f15155f) != null && dVar.f15152c);
                int i12 = eVar4.f15184o0[0];
                if (i12 != 3 || zA2) {
                    if (!eVar4.x()) {
                        if (dVar8 == dVar9 && dVar10.f15155f == null) {
                            int iD3 = dVar9.d() + iC2;
                            eVar4.F(iD3, eVar4.o() + iD3);
                            c(i11, eVar4, eVar2, z10);
                        } else if (dVar8 == dVar10 && dVar9.f15155f == null) {
                            int iD4 = iC2 - dVar10.d();
                            eVar4.F(iD4 - eVar4.o(), iD4);
                            c(i11, eVar4, eVar2, z10);
                        } else if (z13 && !eVar4.v()) {
                            d(i11, eVar4, eVar2, z10);
                        }
                    }
                } else if (i12 == 3 && eVar4.f15191v >= 0 && eVar4.f15190u >= 0) {
                    if (eVar4.f0 == 8 || (eVar4.f15187r == 0 && eVar4.V == 0.0f)) {
                        if (!eVar4.v() && z13 && !eVar4.v()) {
                            e(i11, eVar, eVar2, eVar4, z10);
                        }
                    }
                }
            }
        }
        eVar.f15179m = true;
    }

    public static void d(int i, w2.e eVar, z2.e eVar2, boolean z10) {
        float f5 = eVar.f15163c0;
        w2.d dVar = eVar.H;
        int iC = dVar.f15155f.c();
        w2.d dVar2 = eVar.J;
        int iC2 = dVar2.f15155f.c();
        int iD = dVar.d() + iC;
        int iD2 = iC2 - dVar2.d();
        if (iC == iC2) {
            f5 = 0.5f;
        } else {
            iC = iD;
            iC2 = iD2;
        }
        int iO = eVar.o();
        int i3 = (iC2 - iC) - iO;
        if (iC > iC2) {
            i3 = (iC - iC2) - iO;
        }
        int i10 = ((int) (i3 > 0 ? (f5 * i3) + 0.5f : f5 * i3)) + iC;
        int i11 = i10 + iO;
        if (iC > iC2) {
            i11 = i10 - iO;
        }
        eVar.F(i10, i11);
        c(i + 1, eVar, eVar2, z10);
    }

    public static void e(int i, w2.e eVar, z2.e eVar2, w2.e eVar3, boolean z10) {
        float f5 = eVar3.f15163c0;
        w2.d dVar = eVar3.H;
        int iD = dVar.d() + dVar.f15155f.c();
        w2.d dVar2 = eVar3.J;
        int iC = dVar2.f15155f.c() - dVar2.d();
        if (iC >= iD) {
            int iO = eVar3.o();
            if (eVar3.f0 != 8) {
                int i3 = eVar3.f15187r;
                if (i3 == 2) {
                    iO = (int) (eVar3.f15163c0 * 0.5f * (eVar instanceof w2.f ? eVar.o() : eVar.S.o()));
                } else if (i3 == 0) {
                    iO = iC - iD;
                }
                iO = Math.max(eVar3.f15190u, iO);
                int i10 = eVar3.f15191v;
                if (i10 > 0) {
                    iO = Math.min(i10, iO);
                }
            }
            int i11 = iD + ((int) ((f5 * ((iC - iD) - iO)) + 0.5f));
            eVar3.F(i11, iO + i11);
            c(i + 1, eVar3, eVar2, z10);
        }
    }

    public static void f(int i, w2.e eVar, z2.e eVar2) {
        float f5 = eVar.f15165d0;
        w2.d dVar = eVar.I;
        int iC = dVar.f15155f.c();
        w2.d dVar2 = eVar.K;
        int iC2 = dVar2.f15155f.c();
        int iD = dVar.d() + iC;
        int iD2 = iC2 - dVar2.d();
        if (iC == iC2) {
            f5 = 0.5f;
        } else {
            iC = iD;
            iC2 = iD2;
        }
        int i3 = eVar.i();
        int i10 = (iC2 - iC) - i3;
        if (iC > iC2) {
            i10 = (iC - iC2) - i3;
        }
        int i11 = (int) (i10 > 0 ? (f5 * i10) + 0.5f : f5 * i10);
        int i12 = iC + i11;
        int i13 = i12 + i3;
        if (iC > iC2) {
            i12 = iC - i11;
            i13 = i12 - i3;
        }
        eVar.G(i12, i13);
        i(i + 1, eVar, eVar2);
    }

    public static void g(int i, w2.e eVar, z2.e eVar2, w2.e eVar3) {
        float f5 = eVar3.f15165d0;
        w2.d dVar = eVar3.I;
        int iD = dVar.d() + dVar.f15155f.c();
        w2.d dVar2 = eVar3.K;
        int iC = dVar2.f15155f.c() - dVar2.d();
        if (iC >= iD) {
            int i3 = eVar3.i();
            if (eVar3.f0 != 8) {
                int i10 = eVar3.f15188s;
                if (i10 == 2) {
                    i3 = (int) (f5 * 0.5f * (eVar instanceof w2.f ? eVar.i() : eVar.S.i()));
                } else if (i10 == 0) {
                    i3 = iC - iD;
                }
                i3 = Math.max(eVar3.f15193x, i3);
                int i11 = eVar3.f15194y;
                if (i11 > 0) {
                    i3 = Math.min(i11, i3);
                }
            }
            int i12 = iD + ((int) ((f5 * ((iC - iD) - i3)) + 0.5f));
            eVar3.G(i12, i3 + i12);
            i(i + 1, eVar3, eVar2);
        }
    }

    public static boolean h(int i, int i3, int i10, int i11) {
        return (i10 == 1 || i10 == 2 || (i10 == 4 && i != 2)) || (i11 == 1 || i11 == 2 || (i11 == 4 && i3 != 2));
    }

    public static void i(int i, w2.e eVar, z2.e eVar2) {
        boolean z10;
        w2.d dVar;
        w2.d dVar2;
        w2.d dVar3;
        w2.d dVar4;
        if (eVar.f15181n) {
            return;
        }
        if (!(eVar instanceof w2.f) && eVar.x() && a(eVar)) {
            w2.f.R(eVar, eVar2, new b());
        }
        w2.d dVarG = eVar.g(3);
        w2.d dVarG2 = eVar.g(5);
        int iC = dVarG.c();
        int iC2 = dVarG2.c();
        HashSet hashSet = dVarG.f15150a;
        if (hashSet != null && dVarG.f15152c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                w2.d dVar5 = (w2.d) it.next();
                w2.e eVar3 = dVar5.f15153d;
                int i3 = i + 1;
                boolean zA = a(eVar3);
                w2.d dVar6 = eVar3.I;
                w2.d dVar7 = eVar3.K;
                if (eVar3.x() && zA) {
                    w2.f.R(eVar3, eVar2, new b());
                }
                boolean z11 = (dVar5 == dVar6 && (dVar4 = dVar7.f15155f) != null && dVar4.f15152c) || (dVar5 == dVar7 && (dVar3 = dVar6.f15155f) != null && dVar3.f15152c);
                int i10 = eVar3.f15184o0[1];
                if (i10 != 3 || zA) {
                    if (!eVar3.x()) {
                        if (dVar5 == dVar6 && dVar7.f15155f == null) {
                            int iD = dVar6.d() + iC;
                            eVar3.G(iD, eVar3.i() + iD);
                            i(i3, eVar3, eVar2);
                        } else if (dVar5 == dVar7 && dVar6.f15155f == null) {
                            int iD2 = iC - dVar7.d();
                            eVar3.G(iD2 - eVar3.i(), iD2);
                            i(i3, eVar3, eVar2);
                        } else if (z11 && !eVar3.w()) {
                            f(i3, eVar3, eVar2);
                        }
                    }
                } else if (i10 == 3 && eVar3.f15194y >= 0 && eVar3.f15193x >= 0 && (eVar3.f0 == 8 || (eVar3.f15188s == 0 && eVar3.V == 0.0f))) {
                    if (!eVar3.w() && z11 && !eVar3.w()) {
                        g(i3, eVar, eVar2, eVar3);
                    }
                }
            }
        }
        boolean z12 = true;
        z12 = true;
        z12 = true;
        if (eVar instanceof w2.g) {
            return;
        }
        HashSet hashSet2 = dVarG2.f15150a;
        if (hashSet2 != null && dVarG2.f15152c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                w2.d dVar8 = (w2.d) it2.next();
                w2.e eVar4 = dVar8.f15153d;
                int i11 = i + 1;
                boolean zA2 = a(eVar4);
                w2.d dVar9 = eVar4.I;
                w2.d dVar10 = eVar4.K;
                if (eVar4.x() && zA2) {
                    w2.f.R(eVar4, eVar2, new b());
                }
                boolean z13 = (dVar8 == dVar9 && (dVar2 = dVar10.f15155f) != null && dVar2.f15152c) || (dVar8 == dVar10 && (dVar = dVar9.f15155f) != null && dVar.f15152c);
                int i12 = eVar4.f15184o0[1];
                if (i12 != 3 || zA2) {
                    if (!eVar4.x()) {
                        if (dVar8 == dVar9 && dVar10.f15155f == null) {
                            int iD3 = dVar9.d() + iC2;
                            eVar4.G(iD3, eVar4.i() + iD3);
                            i(i11, eVar4, eVar2);
                        } else if (dVar8 == dVar10 && dVar9.f15155f == null) {
                            int iD4 = iC2 - dVar10.d();
                            eVar4.G(iD4 - eVar4.i(), iD4);
                            i(i11, eVar4, eVar2);
                        } else if (z13 && !eVar4.w()) {
                            f(i11, eVar4, eVar2);
                        }
                    }
                } else if (i12 == 3 && eVar4.f15194y >= 0 && eVar4.f15193x >= 0 && (eVar4.f0 == 8 || (eVar4.f15188s == 0 && eVar4.V == 0.0f))) {
                    if (!eVar4.w() && z13 && !eVar4.w()) {
                        g(i11, eVar, eVar2, eVar4);
                    }
                }
            }
        }
        w2.d dVarG3 = eVar.g(6);
        if (dVarG3.f15150a != null && dVarG3.f15152c) {
            int iC3 = dVarG3.c();
            Iterator it3 = dVarG3.f15150a.iterator();
            while (it3.hasNext()) {
                w2.d dVar11 = (w2.d) it3.next();
                w2.e eVar5 = dVar11.f15153d;
                int i13 = i + 1;
                boolean zA3 = a(eVar5);
                w2.d dVar12 = eVar5.L;
                if (eVar5.x() && zA3) {
                    w2.f.R(eVar5, eVar2, new b());
                }
                if (eVar5.f15184o0[z12 ? 1 : 0] != 3 || zA3) {
                    if (!eVar5.x()) {
                        if (dVar11 == dVar12) {
                            int iD5 = dVar11.d() + iC3;
                            if (eVar5.E) {
                                int i14 = iD5 - eVar5.Z;
                                int i15 = eVar5.U + i14;
                                eVar5.Y = i14;
                                eVar5.I.i(i14);
                                eVar5.K.i(i15);
                                dVar12.i(iD5);
                                z10 = z12 ? 1 : 0;
                                eVar5.f15177l = z10;
                            } else {
                                z10 = z12 ? 1 : 0;
                            }
                            i(i13, eVar5, eVar2);
                        }
                        z12 = z10;
                    }
                }
                z10 = z12 ? 1 : 0;
                z12 = z10;
            }
        }
        eVar.f15181n = z12;
    }
}
