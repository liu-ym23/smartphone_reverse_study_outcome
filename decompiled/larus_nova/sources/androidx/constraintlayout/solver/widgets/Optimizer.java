package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* JADX INFO: loaded from: classes17.dex */
public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CACHE_MEASURES = 256;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DEPENDENCY_ORDERING = 512;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GRAPH = 64;
    public static final int OPTIMIZATION_GRAPH_WRAP = 128;
    public static final int OPTIMIZATION_GROUPING = 1024;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 257;
    static boolean[] flags;

    static {
        flags = new boolean[3];
    }

    public Optimizer() {
    }

    public static final boolean enabled(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static void checkMatchParent(ConstraintWidgetContainer r100, LinearSystem r101, ConstraintWidget r102) {
        r102.mHorizontalResolution = -1;
        r102.mVerticalResolution = -1;
        ConstraintWidget.DimensionBehaviour r103 = r100.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r104 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r103 == r104) goto L8;
        if (r102.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r105 = r102.mLeft.mMargin;
        int r106 = r100.getWidth() - r102.mRight.mMargin;
        ConstraintAnchor r107 = r102.mLeft;
        r107.mSolverVariable = r101.createObjectVariable(r107);
        ConstraintAnchor r108 = r102.mRight;
        r108.mSolverVariable = r101.createObjectVariable(r108);
        r101.addEquality(r102.mLeft.mSolverVariable, r105);
        r101.addEquality(r102.mRight.mSolverVariable, r106);
        r102.mHorizontalResolution = 2;
        r102.setHorizontalDimension(r105, r106);
    L8:
        if (r100.mListDimensionBehaviors[1] != r104) goto L10;
        return;
    L10:
        if (r102.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r109 = r102.mTop.mMargin;
        int r110 = r100.getHeight() - r102.mBottom.mMargin;
        ConstraintAnchor r111 = r102.mTop;
        r111.mSolverVariable = r101.createObjectVariable(r111);
        ConstraintAnchor r112 = r102.mBottom;
        r112.mSolverVariable = r101.createObjectVariable(r112);
        r101.addEquality(r102.mTop.mSolverVariable, r109);
        r101.addEquality(r102.mBottom.mSolverVariable, r110);
        if (r102.mBaselineDistance <= 0) goto L14;
    L15:
        ConstraintAnchor r113 = r102.mBaseline;
        r113.mSolverVariable = r101.createObjectVariable(r113);
        r101.addEquality(r102.mBaseline.mSolverVariable, r102.mBaselineDistance + r109);
    L16:
        r102.mVerticalResolution = 2;
        r102.setVerticalDimension(r109, r110);
        return;
    L14:
        if (r102.getVisibility() != 8) goto L16;
    }
}
