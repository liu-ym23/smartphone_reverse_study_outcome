package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f1228a = new boolean[3];

    public static void a(d dVar, androidx.constraintlayout.core.c cVar, ConstraintWidget constraintWidget) {
        constraintWidget.f1124o = -1;
        ConstraintAnchor constraintAnchor = constraintWidget.N;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        ConstraintAnchor constraintAnchor2 = constraintWidget.M;
        ConstraintAnchor constraintAnchor3 = constraintWidget.K;
        ConstraintAnchor constraintAnchor4 = constraintWidget.L;
        ConstraintAnchor constraintAnchor5 = constraintWidget.J;
        constraintWidget.f1126p = -1;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar.U;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr2[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1139d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1137b;
        if (dimensionBehaviour != dimensionBehaviour3 && dimensionBehaviourArr[0] == dimensionBehaviour2) {
            int i10 = constraintAnchor5.f1089g;
            int iQ = dVar.q() - constraintAnchor4.f1089g;
            constraintAnchor5.f1090i = cVar.k(constraintAnchor5);
            constraintAnchor4.f1090i = cVar.k(constraintAnchor4);
            cVar.d(constraintAnchor5.f1090i, i10);
            cVar.d(constraintAnchor4.f1090i, iQ);
            constraintWidget.f1124o = 2;
            constraintWidget.f1100a0 = i10;
            int i11 = iQ - i10;
            constraintWidget.W = i11;
            int i12 = constraintWidget.f1104d0;
            if (i11 < i12) {
                constraintWidget.W = i12;
            }
        }
        if (dimensionBehaviourArr2[1] == dimensionBehaviour3 || dimensionBehaviourArr[1] != dimensionBehaviour2) {
            return;
        }
        int i13 = constraintAnchor3.f1089g;
        int iK = dVar.k() - constraintAnchor2.f1089g;
        constraintAnchor3.f1090i = cVar.k(constraintAnchor3);
        constraintAnchor2.f1090i = cVar.k(constraintAnchor2);
        cVar.d(constraintAnchor3.f1090i, i13);
        cVar.d(constraintAnchor2.f1090i, iK);
        if (constraintWidget.c0 > 0 || constraintWidget.f1113i0 == 8) {
            SolverVariable solverVariableK = cVar.k(constraintAnchor);
            constraintAnchor.f1090i = solverVariableK;
            cVar.d(solverVariableK, constraintWidget.c0 + i13);
        }
        constraintWidget.f1126p = 2;
        constraintWidget.b0 = i13;
        int i14 = iK - i13;
        constraintWidget.X = i14;
        int i15 = constraintWidget.f1106e0;
        if (i14 < i15) {
            constraintWidget.X = i15;
        }
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
