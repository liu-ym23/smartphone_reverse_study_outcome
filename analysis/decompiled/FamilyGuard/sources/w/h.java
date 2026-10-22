package w;

import java.util.ArrayList;
import java.util.Iterator;
import v.C1177a;
import v.d;
import v.e;
import w.C1196b;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static C1196b.a f23438a = new C1196b.a();

    /* renamed from: b, reason: collision with root package name */
    private static int f23439b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f23440c = 0;

    private static boolean a(int i5, v.e eVar) {
        e.b bVar;
        e.b bVar2;
        e.b bVarA = eVar.A();
        e.b bVarT = eVar.T();
        v.f fVar = eVar.K() != null ? (v.f) eVar.K() : null;
        if (fVar != null) {
            fVar.A();
            e.b bVar3 = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.T();
            e.b bVar4 = e.b.FIXED;
        }
        e.b bVar5 = e.b.FIXED;
        boolean z5 = bVarA == bVar5 || eVar.n0() || bVarA == e.b.WRAP_CONTENT || (bVarA == (bVar2 = e.b.MATCH_CONSTRAINT) && eVar.f23100w == 0 && eVar.f23063d0 == 0.0f && eVar.a0(0)) || (bVarA == bVar2 && eVar.f23100w == 1 && eVar.d0(0, eVar.W()));
        boolean z6 = bVarT == bVar5 || eVar.o0() || bVarT == e.b.WRAP_CONTENT || (bVarT == (bVar = e.b.MATCH_CONSTRAINT) && eVar.f23102x == 0 && eVar.f23063d0 == 0.0f && eVar.a0(1)) || (bVarT == bVar && eVar.f23102x == 1 && eVar.d0(1, eVar.x()));
        if (eVar.f23063d0 <= 0.0f || !(z5 || z6)) {
            return z5 && z6;
        }
        return true;
    }

    private static void b(int i5, v.e eVar, C1196b.InterfaceC0254b interfaceC0254b, boolean z5) {
        v.d dVar;
        v.d dVar2;
        boolean z6;
        v.d dVar3;
        v.d dVar4;
        if (eVar.g0()) {
            return;
        }
        boolean z7 = true;
        f23439b++;
        if (!(eVar instanceof v.f) && eVar.m0()) {
            int i6 = i5 + 1;
            if (a(i6, eVar)) {
                v.f.S1(i6, eVar, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
            }
        }
        v.d dVarO = eVar.o(d.b.LEFT);
        v.d dVarO2 = eVar.o(d.b.RIGHT);
        int iE = dVarO.e();
        int iE2 = dVarO2.e();
        if (dVarO.d() != null && dVarO.n()) {
            Iterator<v.d> it = dVarO.d().iterator();
            while (it.hasNext()) {
                v.d next = it.next();
                v.e eVar2 = next.f23002d;
                int i7 = i5 + 1;
                boolean zA = a(i7, eVar2);
                if (eVar2.m0() && zA) {
                    z6 = z7;
                    v.f.S1(i7, eVar2, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
                } else {
                    z6 = z7;
                }
                boolean z8 = ((next == eVar2.f23044O && (dVar4 = eVar2.f23046Q.f23004f) != null && dVar4.n()) || (next == eVar2.f23046Q && (dVar3 = eVar2.f23044O.f23004f) != null && dVar3.n())) ? z6 : false;
                e.b bVarA = eVar2.A();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarA != bVar || zA) {
                    if (!eVar2.m0()) {
                        v.d dVar5 = eVar2.f23044O;
                        if (next == dVar5 && eVar2.f23046Q.f23004f == null) {
                            int iF = dVar5.f() + iE;
                            eVar2.F0(iF, eVar2.W() + iF);
                            b(i7, eVar2, interfaceC0254b, z5);
                        } else {
                            v.d dVar6 = eVar2.f23046Q;
                            if (next == dVar6 && dVar5.f23004f == null) {
                                int iF2 = iE - dVar6.f();
                                eVar2.F0(iF2 - eVar2.W(), iF2);
                                b(i7, eVar2, interfaceC0254b, z5);
                            } else if (z8 && !eVar2.i0()) {
                                d(i7, interfaceC0254b, eVar2, z5);
                            }
                        }
                    }
                } else if (eVar2.A() == bVar && eVar2.f23020A >= 0 && eVar2.f23106z >= 0 && ((eVar2.V() == 8 || (eVar2.f23100w == 0 && eVar2.v() == 0.0f)) && !eVar2.i0() && !eVar2.l0() && z8 && !eVar2.i0())) {
                    e(i7, eVar, interfaceC0254b, eVar2, z5);
                }
                z7 = z6;
            }
        }
        boolean z9 = z7;
        if (eVar instanceof v.h) {
            return;
        }
        if (dVarO2.d() != null && dVarO2.n()) {
            Iterator<v.d> it2 = dVarO2.d().iterator();
            while (it2.hasNext()) {
                v.d next2 = it2.next();
                v.e eVar3 = next2.f23002d;
                int i8 = i5 + 1;
                boolean zA2 = a(i8, eVar3);
                if (eVar3.m0() && zA2) {
                    v.f.S1(i8, eVar3, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
                }
                boolean z10 = ((next2 == eVar3.f23044O && (dVar2 = eVar3.f23046Q.f23004f) != null && dVar2.n()) || (next2 == eVar3.f23046Q && (dVar = eVar3.f23044O.f23004f) != null && dVar.n())) ? z9 : false;
                e.b bVarA2 = eVar3.A();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVarA2 != bVar2 || zA2) {
                    if (!eVar3.m0()) {
                        v.d dVar7 = eVar3.f23044O;
                        if (next2 == dVar7 && eVar3.f23046Q.f23004f == null) {
                            int iF3 = dVar7.f() + iE2;
                            eVar3.F0(iF3, eVar3.W() + iF3);
                            b(i8, eVar3, interfaceC0254b, z5);
                        } else {
                            v.d dVar8 = eVar3.f23046Q;
                            if (next2 == dVar8 && dVar7.f23004f == null) {
                                int iF4 = iE2 - dVar8.f();
                                eVar3.F0(iF4 - eVar3.W(), iF4);
                                b(i8, eVar3, interfaceC0254b, z5);
                            } else if (z10 && !eVar3.i0()) {
                                d(i8, interfaceC0254b, eVar3, z5);
                            }
                        }
                    }
                } else if (eVar3.A() == bVar2 && eVar3.f23020A >= 0 && eVar3.f23106z >= 0 && (eVar3.V() == 8 || (eVar3.f23100w == 0 && eVar3.v() == 0.0f))) {
                    if (!eVar3.i0() && !eVar3.l0() && z10 && !eVar3.i0()) {
                        e(i8, eVar, interfaceC0254b, eVar3, z5);
                    }
                }
            }
        }
        eVar.q0();
    }

    private static void c(int i5, C1177a c1177a, C1196b.InterfaceC0254b interfaceC0254b, int i6, boolean z5) {
        if (c1177a.t1()) {
            if (i6 == 0) {
                b(i5 + 1, c1177a, interfaceC0254b, z5);
            } else {
                i(i5 + 1, c1177a, interfaceC0254b);
            }
        }
    }

    private static void d(int i5, C1196b.InterfaceC0254b interfaceC0254b, v.e eVar, boolean z5) {
        float fY = eVar.y();
        int iE = eVar.f23044O.f23004f.e();
        int iE2 = eVar.f23046Q.f23004f.e();
        int iF = eVar.f23044O.f() + iE;
        int iF2 = iE2 - eVar.f23046Q.f();
        if (iE == iE2) {
            fY = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iW = eVar.W();
        int i6 = (iE2 - iE) - iW;
        if (iE > iE2) {
            i6 = (iE - iE2) - iW;
        }
        int i7 = ((int) (i6 > 0 ? (fY * i6) + 0.5f : fY * i6)) + iE;
        int i8 = i7 + iW;
        if (iE > iE2) {
            i8 = i7 - iW;
        }
        eVar.F0(i7, i8);
        b(i5 + 1, eVar, interfaceC0254b, z5);
    }

    private static void e(int i5, v.e eVar, C1196b.InterfaceC0254b interfaceC0254b, v.e eVar2, boolean z5) {
        float fY = eVar2.y();
        int iE = eVar2.f23044O.f23004f.e() + eVar2.f23044O.f();
        int iE2 = eVar2.f23046Q.f23004f.e() - eVar2.f23046Q.f();
        if (iE2 >= iE) {
            int iW = eVar2.W();
            if (eVar2.V() != 8) {
                int i6 = eVar2.f23100w;
                if (i6 == 2) {
                    iW = (int) (eVar2.y() * 0.5f * (eVar instanceof v.f ? eVar.W() : eVar.K().W()));
                } else if (i6 == 0) {
                    iW = iE2 - iE;
                }
                iW = Math.max(eVar2.f23106z, iW);
                int i7 = eVar2.f23020A;
                if (i7 > 0) {
                    iW = Math.min(i7, iW);
                }
            }
            int i8 = iE + ((int) ((fY * ((iE2 - iE) - iW)) + 0.5f));
            eVar2.F0(i8, iW + i8);
            b(i5 + 1, eVar2, interfaceC0254b, z5);
        }
    }

    private static void f(int i5, C1196b.InterfaceC0254b interfaceC0254b, v.e eVar) {
        float fR = eVar.R();
        int iE = eVar.f23045P.f23004f.e();
        int iE2 = eVar.f23047R.f23004f.e();
        int iF = eVar.f23045P.f() + iE;
        int iF2 = iE2 - eVar.f23047R.f();
        if (iE == iE2) {
            fR = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iX = eVar.x();
        int i6 = (iE2 - iE) - iX;
        if (iE > iE2) {
            i6 = (iE - iE2) - iX;
        }
        int i7 = (int) (i6 > 0 ? (fR * i6) + 0.5f : fR * i6);
        int i8 = iE + i7;
        int i9 = i8 + iX;
        if (iE > iE2) {
            i8 = iE - i7;
            i9 = i8 - iX;
        }
        eVar.I0(i8, i9);
        i(i5 + 1, eVar, interfaceC0254b);
    }

    private static void g(int i5, v.e eVar, C1196b.InterfaceC0254b interfaceC0254b, v.e eVar2) {
        float fR = eVar2.R();
        int iE = eVar2.f23045P.f23004f.e() + eVar2.f23045P.f();
        int iE2 = eVar2.f23047R.f23004f.e() - eVar2.f23047R.f();
        if (iE2 >= iE) {
            int iX = eVar2.x();
            if (eVar2.V() != 8) {
                int i6 = eVar2.f23102x;
                if (i6 == 2) {
                    iX = (int) (fR * 0.5f * (eVar instanceof v.f ? eVar.x() : eVar.K().x()));
                } else if (i6 == 0) {
                    iX = iE2 - iE;
                }
                iX = Math.max(eVar2.f23024C, iX);
                int i7 = eVar2.f23026D;
                if (i7 > 0) {
                    iX = Math.min(i7, iX);
                }
            }
            int i8 = iE + ((int) ((fR * ((iE2 - iE) - iX)) + 0.5f));
            eVar2.I0(i8, iX + i8);
            i(i5 + 1, eVar2, interfaceC0254b);
        }
    }

    public static void h(v.f fVar, C1196b.InterfaceC0254b interfaceC0254b) {
        e.b bVarA = fVar.A();
        e.b bVarT = fVar.T();
        f23439b = 0;
        f23440c = 0;
        fVar.v0();
        ArrayList<v.e> arrayListR1 = fVar.r1();
        int size = arrayListR1.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayListR1.get(i5).v0();
        }
        boolean zP1 = fVar.P1();
        if (bVarA == e.b.FIXED) {
            fVar.F0(0, fVar.W());
        } else {
            fVar.G0(0);
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i6 = 0; i6 < size; i6++) {
            v.e eVar = arrayListR1.get(i6);
            if (eVar instanceof v.h) {
                v.h hVar = (v.h) eVar;
                if (hVar.s1() == 1) {
                    if (hVar.t1() != -1) {
                        hVar.w1(hVar.t1());
                    } else if (hVar.u1() != -1 && fVar.n0()) {
                        hVar.w1(fVar.W() - hVar.u1());
                    } else if (fVar.n0()) {
                        hVar.w1((int) ((hVar.v1() * fVar.W()) + 0.5f));
                    }
                    z5 = true;
                }
            } else if ((eVar instanceof C1177a) && ((C1177a) eVar).x1() == 0) {
                z6 = true;
            }
        }
        if (z5) {
            for (int i7 = 0; i7 < size; i7++) {
                v.e eVar2 = arrayListR1.get(i7);
                if (eVar2 instanceof v.h) {
                    v.h hVar2 = (v.h) eVar2;
                    if (hVar2.s1() == 1) {
                        b(0, hVar2, interfaceC0254b, zP1);
                    }
                }
            }
        }
        b(0, fVar, interfaceC0254b, zP1);
        if (z6) {
            for (int i8 = 0; i8 < size; i8++) {
                v.e eVar3 = arrayListR1.get(i8);
                if (eVar3 instanceof C1177a) {
                    C1177a c1177a = (C1177a) eVar3;
                    if (c1177a.x1() == 0) {
                        c(0, c1177a, interfaceC0254b, 0, zP1);
                    }
                }
            }
        }
        if (bVarT == e.b.FIXED) {
            fVar.I0(0, fVar.x());
        } else {
            fVar.H0(0);
        }
        boolean z7 = false;
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            v.e eVar4 = arrayListR1.get(i9);
            if (eVar4 instanceof v.h) {
                v.h hVar3 = (v.h) eVar4;
                if (hVar3.s1() == 0) {
                    if (hVar3.t1() != -1) {
                        hVar3.w1(hVar3.t1());
                    } else if (hVar3.u1() != -1 && fVar.o0()) {
                        hVar3.w1(fVar.x() - hVar3.u1());
                    } else if (fVar.o0()) {
                        hVar3.w1((int) ((hVar3.v1() * fVar.x()) + 0.5f));
                    }
                    z7 = true;
                }
            } else if ((eVar4 instanceof C1177a) && ((C1177a) eVar4).x1() == 1) {
                z8 = true;
            }
        }
        if (z7) {
            for (int i10 = 0; i10 < size; i10++) {
                v.e eVar5 = arrayListR1.get(i10);
                if (eVar5 instanceof v.h) {
                    v.h hVar4 = (v.h) eVar5;
                    if (hVar4.s1() == 0) {
                        i(1, hVar4, interfaceC0254b);
                    }
                }
            }
        }
        i(0, fVar, interfaceC0254b);
        if (z8) {
            for (int i11 = 0; i11 < size; i11++) {
                v.e eVar6 = arrayListR1.get(i11);
                if (eVar6 instanceof C1177a) {
                    C1177a c1177a2 = (C1177a) eVar6;
                    if (c1177a2.x1() == 1) {
                        c(0, c1177a2, interfaceC0254b, 1, zP1);
                    }
                }
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            v.e eVar7 = arrayListR1.get(i12);
            if (eVar7.m0() && a(0, eVar7)) {
                v.f.S1(0, eVar7, interfaceC0254b, f23438a, C1196b.a.f23392k);
                if (!(eVar7 instanceof v.h)) {
                    b(0, eVar7, interfaceC0254b, zP1);
                    i(0, eVar7, interfaceC0254b);
                } else if (((v.h) eVar7).s1() == 0) {
                    i(0, eVar7, interfaceC0254b);
                } else {
                    b(0, eVar7, interfaceC0254b, zP1);
                }
            }
        }
    }

    private static void i(int i5, v.e eVar, C1196b.InterfaceC0254b interfaceC0254b) {
        v.d dVar;
        v.d dVar2;
        v.d dVar3;
        v.d dVar4;
        if (eVar.p0()) {
            return;
        }
        boolean z5 = true;
        f23440c++;
        if (!(eVar instanceof v.f) && eVar.m0()) {
            int i6 = i5 + 1;
            if (a(i6, eVar)) {
                v.f.S1(i6, eVar, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
            }
        }
        v.d dVarO = eVar.o(d.b.TOP);
        v.d dVarO2 = eVar.o(d.b.BOTTOM);
        int iE = dVarO.e();
        int iE2 = dVarO2.e();
        if (dVarO.d() != null && dVarO.n()) {
            Iterator<v.d> it = dVarO.d().iterator();
            while (it.hasNext()) {
                v.d next = it.next();
                v.e eVar2 = next.f23002d;
                int i7 = i5 + 1;
                boolean zA = a(i7, eVar2);
                if (eVar2.m0() && zA) {
                    v.f.S1(i7, eVar2, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
                }
                boolean z6 = ((next == eVar2.f23045P && (dVar4 = eVar2.f23047R.f23004f) != null && dVar4.n()) || (next == eVar2.f23047R && (dVar3 = eVar2.f23045P.f23004f) != null && dVar3.n())) ? z5 : false;
                e.b bVarT = eVar2.T();
                boolean z7 = z5;
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarT != bVar || zA) {
                    if (!eVar2.m0()) {
                        v.d dVar5 = eVar2.f23045P;
                        if (next == dVar5 && eVar2.f23047R.f23004f == null) {
                            int iF = dVar5.f() + iE;
                            eVar2.I0(iF, eVar2.x() + iF);
                            i(i7, eVar2, interfaceC0254b);
                        } else {
                            v.d dVar6 = eVar2.f23047R;
                            if (next == dVar6 && dVar5.f23004f == null) {
                                int iF2 = iE - dVar6.f();
                                eVar2.I0(iF2 - eVar2.x(), iF2);
                                i(i7, eVar2, interfaceC0254b);
                            } else if (z6 && !eVar2.k0()) {
                                f(i7, interfaceC0254b, eVar2);
                            }
                        }
                    }
                } else if (eVar2.T() == bVar && eVar2.f23026D >= 0 && eVar2.f23024C >= 0 && ((eVar2.V() == 8 || (eVar2.f23102x == 0 && eVar2.v() == 0.0f)) && !eVar2.k0() && !eVar2.l0() && z6 && !eVar2.k0())) {
                    g(i7, eVar, interfaceC0254b, eVar2);
                }
                z5 = z7;
            }
        }
        boolean z8 = z5;
        if (eVar instanceof v.h) {
            return;
        }
        if (dVarO2.d() != null && dVarO2.n()) {
            Iterator<v.d> it2 = dVarO2.d().iterator();
            while (it2.hasNext()) {
                v.d next2 = it2.next();
                v.e eVar3 = next2.f23002d;
                int i8 = i5 + 1;
                boolean zA2 = a(i8, eVar3);
                if (eVar3.m0() && zA2) {
                    v.f.S1(i8, eVar3, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
                }
                boolean z9 = ((next2 == eVar3.f23045P && (dVar2 = eVar3.f23047R.f23004f) != null && dVar2.n()) || (next2 == eVar3.f23047R && (dVar = eVar3.f23045P.f23004f) != null && dVar.n())) ? z8 : false;
                e.b bVarT2 = eVar3.T();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVarT2 != bVar2 || zA2) {
                    if (!eVar3.m0()) {
                        v.d dVar7 = eVar3.f23045P;
                        if (next2 == dVar7 && eVar3.f23047R.f23004f == null) {
                            int iF3 = dVar7.f() + iE2;
                            eVar3.I0(iF3, eVar3.x() + iF3);
                            i(i8, eVar3, interfaceC0254b);
                        } else {
                            v.d dVar8 = eVar3.f23047R;
                            if (next2 == dVar8 && dVar7.f23004f == null) {
                                int iF4 = iE2 - dVar8.f();
                                eVar3.I0(iF4 - eVar3.x(), iF4);
                                i(i8, eVar3, interfaceC0254b);
                            } else if (z9 && !eVar3.k0()) {
                                f(i8, interfaceC0254b, eVar3);
                            }
                        }
                    }
                } else if (eVar3.T() == bVar2 && eVar3.f23026D >= 0 && eVar3.f23024C >= 0 && (eVar3.V() == 8 || (eVar3.f23102x == 0 && eVar3.v() == 0.0f))) {
                    if (!eVar3.k0() && !eVar3.l0() && z9 && !eVar3.k0()) {
                        g(i8, eVar, interfaceC0254b, eVar3);
                    }
                }
            }
        }
        v.d dVarO3 = eVar.o(d.b.BASELINE);
        if (dVarO3.d() != null && dVarO3.n()) {
            int iE3 = dVarO3.e();
            Iterator<v.d> it3 = dVarO3.d().iterator();
            while (it3.hasNext()) {
                v.d next3 = it3.next();
                v.e eVar4 = next3.f23002d;
                int i9 = i5 + 1;
                boolean zA3 = a(i9, eVar4);
                if (eVar4.m0() && zA3) {
                    v.f.S1(i9, eVar4, interfaceC0254b, new C1196b.a(), C1196b.a.f23392k);
                }
                if (eVar4.T() != e.b.MATCH_CONSTRAINT || zA3) {
                    if (!eVar4.m0() && next3 == eVar4.f23048S) {
                        eVar4.E0(next3.f() + iE3);
                        i(i9, eVar4, interfaceC0254b);
                    }
                }
            }
        }
        eVar.r0();
    }
}
