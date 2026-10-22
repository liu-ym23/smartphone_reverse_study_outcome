package p0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import p0.C5034b;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static C5034b.a f38034a = new C5034b.a();

    /* renamed from: b, reason: collision with root package name */
    public static int f38035b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f38036c = 0;

    public static boolean a(int i10, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourV = constraintWidget.V();
        androidx.constraintlayout.core.widgets.d dVar = constraintWidget.M() != null ? (androidx.constraintlayout.core.widgets.d) constraintWidget.M() : null;
        if (dVar != null) {
            dVar.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            dVar.V();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z10 = dimensionBehaviourC == dimensionBehaviour5 || constraintWidget.p0() || dimensionBehaviourC == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviourC == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f12022w == 0 && constraintWidget.f11989f0 == 0.0f && constraintWidget.c0(0)) || (dimensionBehaviourC == dimensionBehaviour2 && constraintWidget.f12022w == 1 && constraintWidget.f0(0, constraintWidget.Y()));
        boolean z11 = dimensionBehaviourV == dimensionBehaviour5 || constraintWidget.q0() || dimensionBehaviourV == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviourV == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f12024x == 0 && constraintWidget.f11989f0 == 0.0f && constraintWidget.c0(1)) || (dimensionBehaviourV == dimensionBehaviour && constraintWidget.f12024x == 1 && constraintWidget.f0(1, constraintWidget.z()));
        if (constraintWidget.f11989f0 <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    public static void b(int i10, ConstraintWidget constraintWidget, C5034b.InterfaceC0492b interfaceC0492b, boolean z10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z11;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.i0()) {
            return;
        }
        boolean z12 = true;
        f38035b++;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.o0()) {
            int i11 = i10 + 1;
            if (a(i11, constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.Y1(i11, constraintWidget, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
            }
        }
        ConstraintAnchor constraintAnchorQ = constraintWidget.q(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorQ2 = constraintWidget.q(ConstraintAnchor.Type.RIGHT);
        int iE = constraintAnchorQ.e();
        int iE2 = constraintAnchorQ2.e();
        if (constraintAnchorQ.d() != null && constraintAnchorQ.n()) {
            Iterator<ConstraintAnchor> it = constraintAnchorQ.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f11925d;
                int i12 = i10 + 1;
                boolean zA = a(i12, constraintWidget2);
                if (constraintWidget2.o0() && zA) {
                    z11 = z12;
                    androidx.constraintlayout.core.widgets.d.Y1(i12, constraintWidget2, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
                } else {
                    z11 = z12;
                }
                boolean z13 = ((next == constraintWidget2.f11964Q && (constraintAnchor4 = constraintWidget2.f11968S.f11927f) != null && constraintAnchor4.n()) || (next == constraintWidget2.f11968S && (constraintAnchor3 = constraintWidget2.f11964Q.f11927f) != null && constraintAnchor3.n())) ? z11 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget2.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourC != dimensionBehaviour || zA) {
                    if (!constraintWidget2.o0()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.f11964Q;
                        if (next == constraintAnchor5 && constraintWidget2.f11968S.f11927f == null) {
                            int iF = constraintAnchor5.f() + iE;
                            constraintWidget2.K0(iF, constraintWidget2.Y() + iF);
                            b(i12, constraintWidget2, interfaceC0492b, z10);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.f11968S;
                            if (next == constraintAnchor6 && constraintAnchor5.f11927f == null) {
                                int iF2 = iE - constraintAnchor6.f();
                                constraintWidget2.K0(iF2 - constraintWidget2.Y(), iF2);
                                b(i12, constraintWidget2, interfaceC0492b, z10);
                            } else if (z13 && !constraintWidget2.k0()) {
                                d(i12, interfaceC0492b, constraintWidget2, z10);
                            }
                        }
                    }
                } else if (constraintWidget2.C() == dimensionBehaviour && constraintWidget2.f11932A >= 0 && constraintWidget2.f12028z >= 0 && ((constraintWidget2.X() == 8 || (constraintWidget2.f12022w == 0 && constraintWidget2.x() == 0.0f)) && !constraintWidget2.k0() && !constraintWidget2.n0() && z13 && !constraintWidget2.k0())) {
                    e(i12, constraintWidget, interfaceC0492b, constraintWidget2, z10);
                }
                z12 = z11;
            }
        }
        boolean z14 = z12;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (constraintAnchorQ2.d() != null && constraintAnchorQ2.n()) {
            Iterator<ConstraintAnchor> it2 = constraintAnchorQ2.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f11925d;
                int i13 = i10 + 1;
                boolean zA2 = a(i13, constraintWidget3);
                if (constraintWidget3.o0() && zA2) {
                    androidx.constraintlayout.core.widgets.d.Y1(i13, constraintWidget3, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
                }
                boolean z15 = ((next2 == constraintWidget3.f11964Q && (constraintAnchor2 = constraintWidget3.f11968S.f11927f) != null && constraintAnchor2.n()) || (next2 == constraintWidget3.f11968S && (constraintAnchor = constraintWidget3.f11964Q.f11927f) != null && constraintAnchor.n())) ? z14 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC2 = constraintWidget3.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourC2 != dimensionBehaviour2 || zA2) {
                    if (!constraintWidget3.o0()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.f11964Q;
                        if (next2 == constraintAnchor7 && constraintWidget3.f11968S.f11927f == null) {
                            int iF3 = constraintAnchor7.f() + iE2;
                            constraintWidget3.K0(iF3, constraintWidget3.Y() + iF3);
                            b(i13, constraintWidget3, interfaceC0492b, z10);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.f11968S;
                            if (next2 == constraintAnchor8 && constraintAnchor7.f11927f == null) {
                                int iF4 = iE2 - constraintAnchor8.f();
                                constraintWidget3.K0(iF4 - constraintWidget3.Y(), iF4);
                                b(i13, constraintWidget3, interfaceC0492b, z10);
                            } else if (z15 && !constraintWidget3.k0()) {
                                d(i13, interfaceC0492b, constraintWidget3, z10);
                            }
                        }
                    }
                } else if (constraintWidget3.C() == dimensionBehaviour2 && constraintWidget3.f11932A >= 0 && constraintWidget3.f12028z >= 0 && (constraintWidget3.X() == 8 || (constraintWidget3.f12022w == 0 && constraintWidget3.x() == 0.0f))) {
                    if (!constraintWidget3.k0() && !constraintWidget3.n0() && z15 && !constraintWidget3.k0()) {
                        e(i13, constraintWidget, interfaceC0492b, constraintWidget3, z10);
                    }
                }
            }
        }
        constraintWidget.s0();
    }

    public static void c(int i10, androidx.constraintlayout.core.widgets.a aVar, C5034b.InterfaceC0492b interfaceC0492b, int i11, boolean z10) {
        if (aVar.y1()) {
            if (i11 == 0) {
                b(i10 + 1, aVar, interfaceC0492b, z10);
            } else {
                i(i10 + 1, aVar, interfaceC0492b);
            }
        }
    }

    public static void d(int i10, C5034b.InterfaceC0492b interfaceC0492b, ConstraintWidget constraintWidget, boolean z10) {
        float fA = constraintWidget.A();
        int iE = constraintWidget.f11964Q.f11927f.e();
        int iE2 = constraintWidget.f11968S.f11927f.e();
        int iF = constraintWidget.f11964Q.f() + iE;
        int iF2 = iE2 - constraintWidget.f11968S.f();
        if (iE == iE2) {
            fA = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iY = constraintWidget.Y();
        int i11 = (iE2 - iE) - iY;
        if (iE > iE2) {
            i11 = (iE - iE2) - iY;
        }
        int i12 = ((int) (i11 > 0 ? (fA * i11) + 0.5f : fA * i11)) + iE;
        int i13 = i12 + iY;
        if (iE > iE2) {
            i13 = i12 - iY;
        }
        constraintWidget.K0(i12, i13);
        b(i10 + 1, constraintWidget, interfaceC0492b, z10);
    }

    public static void e(int i10, ConstraintWidget constraintWidget, C5034b.InterfaceC0492b interfaceC0492b, ConstraintWidget constraintWidget2, boolean z10) {
        float fA = constraintWidget2.A();
        int iE = constraintWidget2.f11964Q.f11927f.e() + constraintWidget2.f11964Q.f();
        int iE2 = constraintWidget2.f11968S.f11927f.e() - constraintWidget2.f11968S.f();
        if (iE2 >= iE) {
            int iY = constraintWidget2.Y();
            if (constraintWidget2.X() != 8) {
                int i11 = constraintWidget2.f12022w;
                if (i11 == 2) {
                    iY = (int) (constraintWidget2.A() * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.Y() : constraintWidget.M().Y()));
                } else if (i11 == 0) {
                    iY = iE2 - iE;
                }
                iY = Math.max(constraintWidget2.f12028z, iY);
                int i12 = constraintWidget2.f11932A;
                if (i12 > 0) {
                    iY = Math.min(i12, iY);
                }
            }
            int i13 = iE + ((int) ((fA * ((iE2 - iE) - iY)) + 0.5f));
            constraintWidget2.K0(i13, iY + i13);
            b(i10 + 1, constraintWidget2, interfaceC0492b, z10);
        }
    }

    public static void f(int i10, C5034b.InterfaceC0492b interfaceC0492b, ConstraintWidget constraintWidget) {
        float fT = constraintWidget.T();
        int iE = constraintWidget.f11966R.f11927f.e();
        int iE2 = constraintWidget.f11970T.f11927f.e();
        int iF = constraintWidget.f11966R.f() + iE;
        int iF2 = iE2 - constraintWidget.f11970T.f();
        if (iE == iE2) {
            fT = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iZ = constraintWidget.z();
        int i11 = (iE2 - iE) - iZ;
        if (iE > iE2) {
            i11 = (iE - iE2) - iZ;
        }
        int i12 = (int) (i11 > 0 ? (fT * i11) + 0.5f : fT * i11);
        int i13 = iE + i12;
        int i14 = i13 + iZ;
        if (iE > iE2) {
            i13 = iE - i12;
            i14 = i13 - iZ;
        }
        constraintWidget.N0(i13, i14);
        i(i10 + 1, constraintWidget, interfaceC0492b);
    }

    public static void g(int i10, ConstraintWidget constraintWidget, C5034b.InterfaceC0492b interfaceC0492b, ConstraintWidget constraintWidget2) {
        float fT = constraintWidget2.T();
        int iE = constraintWidget2.f11966R.f11927f.e() + constraintWidget2.f11966R.f();
        int iE2 = constraintWidget2.f11970T.f11927f.e() - constraintWidget2.f11970T.f();
        if (iE2 >= iE) {
            int iZ = constraintWidget2.z();
            if (constraintWidget2.X() != 8) {
                int i11 = constraintWidget2.f12024x;
                if (i11 == 2) {
                    iZ = (int) (fT * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.z() : constraintWidget.M().z()));
                } else if (i11 == 0) {
                    iZ = iE2 - iE;
                }
                iZ = Math.max(constraintWidget2.f11936C, iZ);
                int i12 = constraintWidget2.f11938D;
                if (i12 > 0) {
                    iZ = Math.min(i12, iZ);
                }
            }
            int i13 = iE + ((int) ((fT * ((iE2 - iE) - iZ)) + 0.5f));
            constraintWidget2.N0(i13, iZ + i13);
            i(i10 + 1, constraintWidget2, interfaceC0492b);
        }
    }

    public static void h(androidx.constraintlayout.core.widgets.d dVar, C5034b.InterfaceC0492b interfaceC0492b) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = dVar.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourV = dVar.V();
        f38035b = 0;
        f38036c = 0;
        dVar.y0();
        ArrayList<ConstraintWidget> arrayListW1 = dVar.w1();
        int size = arrayListW1.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayListW1.get(i10).y0();
        }
        boolean zV1 = dVar.V1();
        if (dimensionBehaviourC == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.K0(0, dVar.Y());
        } else {
            dVar.L0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = arrayListW1.get(i11);
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                if (fVar.x1() == 1) {
                    if (fVar.y1() != -1) {
                        fVar.B1(fVar.y1());
                    } else if (fVar.z1() != -1 && dVar.p0()) {
                        fVar.B1(dVar.Y() - fVar.z1());
                    } else if (dVar.p0()) {
                        fVar.B1((int) ((fVar.A1() * dVar.Y()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget).C1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = arrayListW1.get(i12);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar2 = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                    if (fVar2.x1() == 1) {
                        b(0, fVar2, interfaceC0492b, zV1);
                    }
                }
            }
        }
        b(0, dVar, interfaceC0492b, zV1);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget3 = arrayListW1.get(i13);
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget3;
                    if (aVar.C1() == 0) {
                        c(0, aVar, interfaceC0492b, 0, zV1);
                    }
                }
            }
        }
        if (dimensionBehaviourV == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.N0(0, dVar.z());
        } else {
            dVar.M0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = arrayListW1.get(i14);
            if (constraintWidget4 instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar3 = (androidx.constraintlayout.core.widgets.f) constraintWidget4;
                if (fVar3.x1() == 0) {
                    if (fVar3.y1() != -1) {
                        fVar3.B1(fVar3.y1());
                    } else if (fVar3.z1() != -1 && dVar.q0()) {
                        fVar3.B1(dVar.z() - fVar3.z1());
                    } else if (dVar.q0()) {
                        fVar3.B1((int) ((fVar3.A1() * dVar.z()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget4).C1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = arrayListW1.get(i15);
                if (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar4 = (androidx.constraintlayout.core.widgets.f) constraintWidget5;
                    if (fVar4.x1() == 0) {
                        i(1, fVar4, interfaceC0492b);
                    }
                }
            }
        }
        i(0, dVar, interfaceC0492b);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = arrayListW1.get(i16);
                if (constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) constraintWidget6;
                    if (aVar2.C1() == 1) {
                        c(0, aVar2, interfaceC0492b, 1, zV1);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            ConstraintWidget constraintWidget7 = arrayListW1.get(i17);
            if (constraintWidget7.o0() && a(0, constraintWidget7)) {
                androidx.constraintlayout.core.widgets.d.Y1(0, constraintWidget7, interfaceC0492b, f38034a, C5034b.a.f38010k);
                if (!(constraintWidget7 instanceof androidx.constraintlayout.core.widgets.f)) {
                    b(0, constraintWidget7, interfaceC0492b, zV1);
                    i(0, constraintWidget7, interfaceC0492b);
                } else if (((androidx.constraintlayout.core.widgets.f) constraintWidget7).x1() == 0) {
                    i(0, constraintWidget7, interfaceC0492b);
                } else {
                    b(0, constraintWidget7, interfaceC0492b, zV1);
                }
            }
        }
    }

    public static void i(int i10, ConstraintWidget constraintWidget, C5034b.InterfaceC0492b interfaceC0492b) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.r0()) {
            return;
        }
        boolean z10 = true;
        f38036c++;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.o0()) {
            int i11 = i10 + 1;
            if (a(i11, constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.Y1(i11, constraintWidget, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
            }
        }
        ConstraintAnchor constraintAnchorQ = constraintWidget.q(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchorQ2 = constraintWidget.q(ConstraintAnchor.Type.BOTTOM);
        int iE = constraintAnchorQ.e();
        int iE2 = constraintAnchorQ2.e();
        if (constraintAnchorQ.d() != null && constraintAnchorQ.n()) {
            Iterator<ConstraintAnchor> it = constraintAnchorQ.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f11925d;
                int i12 = i10 + 1;
                boolean zA = a(i12, constraintWidget2);
                if (constraintWidget2.o0() && zA) {
                    androidx.constraintlayout.core.widgets.d.Y1(i12, constraintWidget2, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
                }
                boolean z11 = ((next == constraintWidget2.f11966R && (constraintAnchor4 = constraintWidget2.f11970T.f11927f) != null && constraintAnchor4.n()) || (next == constraintWidget2.f11970T && (constraintAnchor3 = constraintWidget2.f11966R.f11927f) != null && constraintAnchor3.n())) ? z10 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourV = constraintWidget2.V();
                boolean z12 = z10;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourV != dimensionBehaviour || zA) {
                    if (!constraintWidget2.o0()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.f11966R;
                        if (next == constraintAnchor5 && constraintWidget2.f11970T.f11927f == null) {
                            int iF = constraintAnchor5.f() + iE;
                            constraintWidget2.N0(iF, constraintWidget2.z() + iF);
                            i(i12, constraintWidget2, interfaceC0492b);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.f11970T;
                            if (next == constraintAnchor6 && constraintAnchor5.f11927f == null) {
                                int iF2 = iE - constraintAnchor6.f();
                                constraintWidget2.N0(iF2 - constraintWidget2.z(), iF2);
                                i(i12, constraintWidget2, interfaceC0492b);
                            } else if (z11 && !constraintWidget2.m0()) {
                                f(i12, interfaceC0492b, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.V() == dimensionBehaviour && constraintWidget2.f11938D >= 0 && constraintWidget2.f11936C >= 0 && ((constraintWidget2.X() == 8 || (constraintWidget2.f12024x == 0 && constraintWidget2.x() == 0.0f)) && !constraintWidget2.m0() && !constraintWidget2.n0() && z11 && !constraintWidget2.m0())) {
                    g(i12, constraintWidget, interfaceC0492b, constraintWidget2);
                }
                z10 = z12;
            }
        }
        boolean z13 = z10;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (constraintAnchorQ2.d() != null && constraintAnchorQ2.n()) {
            Iterator<ConstraintAnchor> it2 = constraintAnchorQ2.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f11925d;
                int i13 = i10 + 1;
                boolean zA2 = a(i13, constraintWidget3);
                if (constraintWidget3.o0() && zA2) {
                    androidx.constraintlayout.core.widgets.d.Y1(i13, constraintWidget3, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
                }
                boolean z14 = ((next2 == constraintWidget3.f11966R && (constraintAnchor2 = constraintWidget3.f11970T.f11927f) != null && constraintAnchor2.n()) || (next2 == constraintWidget3.f11970T && (constraintAnchor = constraintWidget3.f11966R.f11927f) != null && constraintAnchor.n())) ? z13 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourV2 = constraintWidget3.V();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourV2 != dimensionBehaviour2 || zA2) {
                    if (!constraintWidget3.o0()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.f11966R;
                        if (next2 == constraintAnchor7 && constraintWidget3.f11970T.f11927f == null) {
                            int iF3 = constraintAnchor7.f() + iE2;
                            constraintWidget3.N0(iF3, constraintWidget3.z() + iF3);
                            i(i13, constraintWidget3, interfaceC0492b);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.f11970T;
                            if (next2 == constraintAnchor8 && constraintAnchor7.f11927f == null) {
                                int iF4 = iE2 - constraintAnchor8.f();
                                constraintWidget3.N0(iF4 - constraintWidget3.z(), iF4);
                                i(i13, constraintWidget3, interfaceC0492b);
                            } else if (z14 && !constraintWidget3.m0()) {
                                f(i13, interfaceC0492b, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.V() == dimensionBehaviour2 && constraintWidget3.f11938D >= 0 && constraintWidget3.f11936C >= 0 && (constraintWidget3.X() == 8 || (constraintWidget3.f12024x == 0 && constraintWidget3.x() == 0.0f))) {
                    if (!constraintWidget3.m0() && !constraintWidget3.n0() && z14 && !constraintWidget3.m0()) {
                        g(i13, constraintWidget, interfaceC0492b, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor constraintAnchorQ3 = constraintWidget.q(ConstraintAnchor.Type.BASELINE);
        if (constraintAnchorQ3.d() != null && constraintAnchorQ3.n()) {
            int iE3 = constraintAnchorQ3.e();
            Iterator<ConstraintAnchor> it3 = constraintAnchorQ3.d().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.f11925d;
                int i14 = i10 + 1;
                boolean zA3 = a(i14, constraintWidget4);
                if (constraintWidget4.o0() && zA3) {
                    androidx.constraintlayout.core.widgets.d.Y1(i14, constraintWidget4, interfaceC0492b, new C5034b.a(), C5034b.a.f38010k);
                }
                if (constraintWidget4.V() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || zA3) {
                    if (!constraintWidget4.o0() && next3 == constraintWidget4.f11972U) {
                        constraintWidget4.J0(next3.f() + iE3);
                        i(i14, constraintWidget4, interfaceC0492b);
                    }
                }
            }
        }
        constraintWidget.t0();
    }
}
