package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean[] f12168a = new boolean[3];

    public static void a(d dVar, androidx.constraintlayout.core.c cVar, ConstraintWidget constraintWidget) {
        constraintWidget.f12016t = -1;
        constraintWidget.f12018u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.f11981b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f11981b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i10 = constraintWidget.f11964Q.f11928g;
            int iY = dVar.Y() - constraintWidget.f11968S.f11928g;
            ConstraintAnchor constraintAnchor = constraintWidget.f11964Q;
            constraintAnchor.f11930i = cVar.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.f11968S;
            constraintAnchor2.f11930i = cVar.q(constraintAnchor2);
            cVar.f(constraintWidget.f11964Q.f11930i, i10);
            cVar.f(constraintWidget.f11968S.f11930i, iY);
            constraintWidget.f12016t = 2;
            constraintWidget.T0(i10, iY);
        }
        if (dVar.f11981b0[1] == dimensionBehaviour2 || constraintWidget.f11981b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i11 = constraintWidget.f11966R.f11928g;
        int iZ = dVar.z() - constraintWidget.f11970T.f11928g;
        ConstraintAnchor constraintAnchor3 = constraintWidget.f11966R;
        constraintAnchor3.f11930i = cVar.q(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.f11970T;
        constraintAnchor4.f11930i = cVar.q(constraintAnchor4);
        cVar.f(constraintWidget.f11966R.f11930i, i11);
        cVar.f(constraintWidget.f11970T.f11930i, iZ);
        if (constraintWidget.f12005n0 > 0 || constraintWidget.X() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.f11972U;
            constraintAnchor5.f11930i = cVar.q(constraintAnchor5);
            cVar.f(constraintWidget.f11972U.f11930i, constraintWidget.f12005n0 + i11);
        }
        constraintWidget.f12018u = 2;
        constraintWidget.k1(i11, iZ);
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
