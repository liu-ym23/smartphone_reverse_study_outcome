package h0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import h0.b;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a f9196a = new b.a();

    public static boolean a(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget constraintWidget2 = constraintWidget.V;
        androidx.constraintlayout.core.widgets.d dVar = constraintWidget2 != null ? (androidx.constraintlayout.core.widgets.d) constraintWidget2 : null;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1136a;
        if (dVar != null) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dVar.U[0];
        }
        if (dVar != null) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dVar.U[1];
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.f1138c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.f1137b;
        boolean z = dimensionBehaviour == dimensionBehaviour3 || constraintWidget.A() || dimensionBehaviour == dimensionBehaviour7 || (dimensionBehaviour == dimensionBehaviour6 && constraintWidget.r == 0 && constraintWidget.Y == 0.0f && constraintWidget.t(0)) || (dimensionBehaviour == dimensionBehaviour6 && constraintWidget.r == 1 && constraintWidget.u(0, constraintWidget.q()));
        boolean z3 = dimensionBehaviour2 == dimensionBehaviour3 || constraintWidget.B() || dimensionBehaviour2 == dimensionBehaviour7 || (dimensionBehaviour2 == dimensionBehaviour6 && constraintWidget.f1129s == 0 && constraintWidget.Y == 0.0f && constraintWidget.t(1)) || (dimensionBehaviour2 == dimensionBehaviour6 && constraintWidget.f1129s == 1 && constraintWidget.u(1, constraintWidget.k()));
        return (constraintWidget.Y > 0.0f && (z || z3)) || (z && z3);
    }

    public static void b(int i10, ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b, boolean z) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z3;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.f1120m) {
            return;
        }
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.z() && a(constraintWidget)) {
            androidx.constraintlayout.core.widgets.d.V(constraintWidget, interfaceC0086b, new b.a());
        }
        ConstraintAnchor constraintAnchorI = constraintWidget.i(ConstraintAnchor.Type.f1091a);
        ConstraintAnchor constraintAnchorI2 = constraintWidget.i(ConstraintAnchor.Type.f1093c);
        int iD = constraintAnchorI.d();
        int iD2 = constraintAnchorI2.d();
        HashSet<ConstraintAnchor> hashSet = constraintAnchorI.f1083a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1138c;
        if (hashSet != null && constraintAnchorI.f1085c) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f1086d;
                int i11 = i10 + 1;
                boolean zA = a(constraintWidget2);
                ConstraintAnchor constraintAnchor5 = constraintWidget2.J;
                ConstraintAnchor constraintAnchor6 = constraintWidget2.L;
                if (constraintWidget2.z() && zA) {
                    z3 = true;
                    androidx.constraintlayout.core.widgets.d.V(constraintWidget2, interfaceC0086b, new b.a());
                } else {
                    z3 = true;
                }
                boolean z10 = ((next == constraintAnchor5 && (constraintAnchor4 = constraintAnchor6.f1088f) != null && constraintAnchor4.f1085c) || (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor5.f1088f) != null && constraintAnchor3.f1085c)) ? z3 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.U[0];
                if (dimensionBehaviour2 != dimensionBehaviour || zA) {
                    if (!constraintWidget2.z()) {
                        if (next == constraintAnchor5 && constraintAnchor6.f1088f == null) {
                            int iE = constraintAnchor5.e() + iD;
                            constraintWidget2.J(iE, constraintWidget2.q() + iE);
                            b(i11, constraintWidget2, interfaceC0086b, z);
                        } else if (next == constraintAnchor6 && constraintAnchor5.f1088f == null) {
                            int iE2 = iD - constraintAnchor6.e();
                            constraintWidget2.J(iE2 - constraintWidget2.q(), iE2);
                            b(i11, constraintWidget2, interfaceC0086b, z);
                        } else if (z10 && !constraintWidget2.x()) {
                            c(i11, constraintWidget2, interfaceC0086b, z);
                        }
                    }
                } else if (dimensionBehaviour2 == dimensionBehaviour && constraintWidget2.f1132v >= 0 && constraintWidget2.f1131u >= 0 && (constraintWidget2.f1113i0 == 8 || (constraintWidget2.r == 0 && constraintWidget2.Y == 0.0f))) {
                    if (!constraintWidget2.x() && !constraintWidget2.G && z10 && !constraintWidget2.x()) {
                        d(i11, constraintWidget, interfaceC0086b, constraintWidget2, z);
                    }
                }
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        HashSet<ConstraintAnchor> hashSet2 = constraintAnchorI2.f1083a;
        if (hashSet2 != null && constraintAnchorI2.f1085c) {
            Iterator<ConstraintAnchor> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f1086d;
                int i12 = i10 + 1;
                boolean zA2 = a(constraintWidget3);
                ConstraintAnchor constraintAnchor7 = constraintWidget3.J;
                ConstraintAnchor constraintAnchor8 = constraintWidget3.L;
                if (constraintWidget3.z() && zA2) {
                    androidx.constraintlayout.core.widgets.d.V(constraintWidget3, interfaceC0086b, new b.a());
                }
                boolean z11 = (next2 == constraintAnchor7 && (constraintAnchor2 = constraintAnchor8.f1088f) != null && constraintAnchor2.f1085c) || (next2 == constraintAnchor8 && (constraintAnchor = constraintAnchor7.f1088f) != null && constraintAnchor.f1085c);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidget3.U[0];
                if (dimensionBehaviour3 != dimensionBehaviour || zA2) {
                    if (!constraintWidget3.z()) {
                        if (next2 == constraintAnchor7 && constraintAnchor8.f1088f == null) {
                            int iE3 = constraintAnchor7.e() + iD2;
                            constraintWidget3.J(iE3, constraintWidget3.q() + iE3);
                            b(i12, constraintWidget3, interfaceC0086b, z);
                        } else if (next2 == constraintAnchor8 && constraintAnchor7.f1088f == null) {
                            int iE4 = iD2 - constraintAnchor8.e();
                            constraintWidget3.J(iE4 - constraintWidget3.q(), iE4);
                            b(i12, constraintWidget3, interfaceC0086b, z);
                        } else if (z11 && !constraintWidget3.x()) {
                            c(i12, constraintWidget3, interfaceC0086b, z);
                        }
                    }
                } else if (dimensionBehaviour3 == dimensionBehaviour && constraintWidget3.f1132v >= 0 && constraintWidget3.f1131u >= 0) {
                    if (constraintWidget3.f1113i0 == 8 || (constraintWidget3.r == 0 && constraintWidget3.Y == 0.0f)) {
                        if (!constraintWidget3.x() && !constraintWidget3.G && z11 && !constraintWidget3.x()) {
                            d(i12, constraintWidget, interfaceC0086b, constraintWidget3, z);
                        }
                    }
                }
            }
        }
        constraintWidget.f1120m = true;
    }

    public static void c(int i10, ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b, boolean z) {
        float f8 = constraintWidget.f1108f0;
        ConstraintAnchor constraintAnchor = constraintWidget.J;
        int iD = constraintAnchor.f1088f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget.L;
        int iD2 = constraintAnchor2.f1088f.d();
        int iE = constraintAnchor.e() + iD;
        int iE2 = iD2 - constraintAnchor2.e();
        if (iD == iD2) {
            f8 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iQ = constraintWidget.q();
        int i11 = (iD2 - iD) - iQ;
        if (iD > iD2) {
            i11 = (iD - iD2) - iQ;
        }
        int i12 = ((int) (i11 > 0 ? (f8 * i11) + 0.5f : f8 * i11)) + iD;
        int i13 = i12 + iQ;
        if (iD > iD2) {
            i13 = i12 - iQ;
        }
        constraintWidget.J(i12, i13);
        b(i10 + 1, constraintWidget, interfaceC0086b, z);
    }

    public static void d(int i10, ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b, ConstraintWidget constraintWidget2, boolean z) {
        float f8 = constraintWidget2.f1108f0;
        ConstraintAnchor constraintAnchor = constraintWidget2.J;
        int iE = constraintAnchor.e() + constraintAnchor.f1088f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.L;
        int iD = constraintAnchor2.f1088f.d() - constraintAnchor2.e();
        if (iD >= iE) {
            int iQ = constraintWidget2.q();
            if (constraintWidget2.f1113i0 != 8) {
                int i11 = constraintWidget2.r;
                if (i11 == 2) {
                    iQ = (int) (constraintWidget2.f1108f0 * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.q() : constraintWidget.V.q()));
                } else if (i11 == 0) {
                    iQ = iD - iE;
                }
                iQ = Math.max(constraintWidget2.f1131u, iQ);
                int i12 = constraintWidget2.f1132v;
                if (i12 > 0) {
                    iQ = Math.min(i12, iQ);
                }
            }
            int i13 = iE + ((int) ((f8 * ((iD - iE) - iQ)) + 0.5f));
            constraintWidget2.J(i13, iQ + i13);
            b(i10 + 1, constraintWidget2, interfaceC0086b, z);
        }
    }

    public static void e(int i10, ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b) {
        float f8 = constraintWidget.f1110g0;
        ConstraintAnchor constraintAnchor = constraintWidget.K;
        int iD = constraintAnchor.f1088f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget.M;
        int iD2 = constraintAnchor2.f1088f.d();
        int iE = constraintAnchor.e() + iD;
        int iE2 = iD2 - constraintAnchor2.e();
        if (iD == iD2) {
            f8 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = constraintWidget.k();
        int i11 = (iD2 - iD) - iK;
        if (iD > iD2) {
            i11 = (iD - iD2) - iK;
        }
        int i12 = (int) (i11 > 0 ? (f8 * i11) + 0.5f : f8 * i11);
        int i13 = iD + i12;
        int i14 = i13 + iK;
        if (iD > iD2) {
            i13 = iD - i12;
            i14 = i13 - iK;
        }
        constraintWidget.K(i13, i14);
        g(i10 + 1, constraintWidget, interfaceC0086b);
    }

    public static void f(int i10, ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b, ConstraintWidget constraintWidget2) {
        float f8 = constraintWidget2.f1110g0;
        ConstraintAnchor constraintAnchor = constraintWidget2.K;
        int iE = constraintAnchor.e() + constraintAnchor.f1088f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.M;
        int iD = constraintAnchor2.f1088f.d() - constraintAnchor2.e();
        if (iD >= iE) {
            int iK = constraintWidget2.k();
            if (constraintWidget2.f1113i0 != 8) {
                int i11 = constraintWidget2.f1129s;
                if (i11 == 2) {
                    iK = (int) (f8 * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.k() : constraintWidget.V.k()));
                } else if (i11 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(constraintWidget2.f1134x, iK);
                int i12 = constraintWidget2.f1135y;
                if (i12 > 0) {
                    iK = Math.min(i12, iK);
                }
            }
            int i13 = iE + ((int) ((f8 * ((iD - iE) - iK)) + 0.5f));
            constraintWidget2.K(i13, iK + i13);
            g(i10 + 1, constraintWidget2, interfaceC0086b);
        }
    }

    public static void g(int i10, ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b) {
        boolean z;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.f1122n) {
            return;
        }
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.z() && a(constraintWidget)) {
            androidx.constraintlayout.core.widgets.d.V(constraintWidget, interfaceC0086b, new b.a());
        }
        ConstraintAnchor constraintAnchorI = constraintWidget.i(ConstraintAnchor.Type.f1092b);
        ConstraintAnchor constraintAnchorI2 = constraintWidget.i(ConstraintAnchor.Type.f1094d);
        int iD = constraintAnchorI.d();
        int iD2 = constraintAnchorI2.d();
        HashSet<ConstraintAnchor> hashSet = constraintAnchorI.f1083a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1138c;
        if (hashSet != null && constraintAnchorI.f1085c) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f1086d;
                int i11 = i10 + 1;
                boolean zA = a(constraintWidget2);
                ConstraintAnchor constraintAnchor5 = constraintWidget2.K;
                ConstraintAnchor constraintAnchor6 = constraintWidget2.M;
                if (constraintWidget2.z() && zA) {
                    androidx.constraintlayout.core.widgets.d.V(constraintWidget2, interfaceC0086b, new b.a());
                }
                boolean z3 = (next == constraintAnchor5 && (constraintAnchor4 = constraintAnchor6.f1088f) != null && constraintAnchor4.f1085c) || (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor5.f1088f) != null && constraintAnchor3.f1085c);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.U[1];
                if (dimensionBehaviour2 != dimensionBehaviour || zA) {
                    if (!constraintWidget2.z()) {
                        if (next == constraintAnchor5 && constraintAnchor6.f1088f == null) {
                            int iE = constraintAnchor5.e() + iD;
                            constraintWidget2.K(iE, constraintWidget2.k() + iE);
                            g(i11, constraintWidget2, interfaceC0086b);
                        } else if (next == constraintAnchor6 && constraintAnchor5.f1088f == null) {
                            int iE2 = iD - constraintAnchor6.e();
                            constraintWidget2.K(iE2 - constraintWidget2.k(), iE2);
                            g(i11, constraintWidget2, interfaceC0086b);
                        } else if (z3 && !constraintWidget2.y()) {
                            e(i11, constraintWidget2, interfaceC0086b);
                        }
                    }
                } else if (dimensionBehaviour2 == dimensionBehaviour && constraintWidget2.f1135y >= 0 && constraintWidget2.f1134x >= 0 && (constraintWidget2.f1113i0 == 8 || (constraintWidget2.f1129s == 0 && constraintWidget2.Y == 0.0f))) {
                    if (!constraintWidget2.y() && !constraintWidget2.G && z3 && !constraintWidget2.y()) {
                        f(i11, constraintWidget, interfaceC0086b, constraintWidget2);
                    }
                }
            }
        }
        boolean z10 = true;
        z10 = true;
        z10 = true;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        HashSet<ConstraintAnchor> hashSet2 = constraintAnchorI2.f1083a;
        if (hashSet2 != null && constraintAnchorI2.f1085c) {
            Iterator<ConstraintAnchor> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f1086d;
                int i12 = i10 + 1;
                boolean zA2 = a(constraintWidget3);
                ConstraintAnchor constraintAnchor7 = constraintWidget3.K;
                ConstraintAnchor constraintAnchor8 = constraintWidget3.M;
                if (constraintWidget3.z() && zA2) {
                    androidx.constraintlayout.core.widgets.d.V(constraintWidget3, interfaceC0086b, new b.a());
                }
                boolean z11 = (next2 == constraintAnchor7 && (constraintAnchor2 = constraintAnchor8.f1088f) != null && constraintAnchor2.f1085c) || (next2 == constraintAnchor8 && (constraintAnchor = constraintAnchor7.f1088f) != null && constraintAnchor.f1085c);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidget3.U[1];
                if (dimensionBehaviour3 != dimensionBehaviour || zA2) {
                    if (!constraintWidget3.z()) {
                        if (next2 == constraintAnchor7 && constraintAnchor8.f1088f == null) {
                            int iE3 = constraintAnchor7.e() + iD2;
                            constraintWidget3.K(iE3, constraintWidget3.k() + iE3);
                            g(i12, constraintWidget3, interfaceC0086b);
                        } else if (next2 == constraintAnchor8 && constraintAnchor7.f1088f == null) {
                            int iE4 = iD2 - constraintAnchor8.e();
                            constraintWidget3.K(iE4 - constraintWidget3.k(), iE4);
                            g(i12, constraintWidget3, interfaceC0086b);
                        } else if (z11 && !constraintWidget3.y()) {
                            e(i12, constraintWidget3, interfaceC0086b);
                        }
                    }
                } else if (dimensionBehaviour3 == dimensionBehaviour && constraintWidget3.f1135y >= 0 && constraintWidget3.f1134x >= 0 && (constraintWidget3.f1113i0 == 8 || (constraintWidget3.f1129s == 0 && constraintWidget3.Y == 0.0f))) {
                    if (!constraintWidget3.y() && !constraintWidget3.G && z11 && !constraintWidget3.y()) {
                        f(i12, constraintWidget, interfaceC0086b, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor constraintAnchorI3 = constraintWidget.i(ConstraintAnchor.Type.f1095e);
        if (constraintAnchorI3.f1083a != null && constraintAnchorI3.f1085c) {
            int iD3 = constraintAnchorI3.d();
            Iterator<ConstraintAnchor> it3 = constraintAnchorI3.f1083a.iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.f1086d;
                int i13 = i10 + 1;
                boolean zA3 = a(constraintWidget4);
                ConstraintAnchor constraintAnchor9 = constraintWidget4.N;
                if (constraintWidget4.z() && zA3) {
                    androidx.constraintlayout.core.widgets.d.V(constraintWidget4, interfaceC0086b, new b.a());
                }
                if (constraintWidget4.U[z10 ? 1 : 0] != dimensionBehaviour || zA3) {
                    if (!constraintWidget4.z()) {
                        if (next3 == constraintAnchor9) {
                            int iE5 = next3.e() + iD3;
                            if (constraintWidget4.E) {
                                int i14 = iE5 - constraintWidget4.c0;
                                int i15 = constraintWidget4.X + i14;
                                constraintWidget4.b0 = i14;
                                constraintWidget4.K.l(i14);
                                constraintWidget4.M.l(i15);
                                constraintAnchor9.l(iE5);
                                z = z10 ? 1 : 0;
                                constraintWidget4.f1118l = z;
                            } else {
                                z = z10 ? 1 : 0;
                            }
                            g(i13, constraintWidget4, interfaceC0086b);
                        }
                        z10 = z;
                    }
                }
                z = z10 ? 1 : 0;
                z10 = z;
            }
        }
        constraintWidget.f1122n = z10;
    }
}
