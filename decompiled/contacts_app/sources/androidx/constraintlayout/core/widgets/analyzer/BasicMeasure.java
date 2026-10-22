package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets;

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;

        static {
        }

        public Measure() {
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r1, Measure r2);
    }

    public void updateHierarchy(ConstraintWidgetContainer r6) {
        this.mVariableDimensionsWidgets.clear();
        int r0 = r6.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ConstraintWidget r2 = r6.mChildren.get(r1);
        if (r2.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L9;
    L10:
        r6.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer r2) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = r2;
    }

    private void measureChildren(ConstraintWidgetContainer r12) {
        int r0 = r12.mChildren.size();
        boolean r1 = r12.optimizeFor(64);
        Measurer r2 = r12.getMeasurer();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L70;
        ConstraintWidget r5 = r12.mChildren.get(r4);
        if ((r5 instanceof Guideline) == true) goto L69;
        if ((r5 instanceof Barrier) == true) goto L69;
        if (r5.isInVirtualLayout() == true) goto L69;
        if (r1 == true) goto L15;
    L23:
        ConstraintWidget.DimensionBehaviour r6 = r5.getDimensionBehaviour(0);
        boolean r7 = true;
        ConstraintWidget.DimensionBehaviour r8 = r5.getDimensionBehaviour(1);
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L26;
    L32:
        boolean r9 = false;
    L33:
        if (r9 == false) goto L35;
    L63:
        r7 = r9;
    L64:
        if (r7 == true) goto L69;
        measure(r2, r5, Measure.SELF_DIMENSIONS);
        if (r12.mMetrics == null) goto L69;
        r12.mMetrics.measuredWidgets++;
        goto L69
    L35:
        if (r12.optimizeFor(1) == false) goto L63;
        if ((r5 instanceof VirtualLayout) == true) goto L63;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r5.mMatchConstraintDefaultWidth != 0) goto L48;
        if (r8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r5.isInHorizontalChain() == true) goto L48;
        r9 = true;
    L48:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        if (r5.mMatchConstraintDefaultHeight != 0) goto L57;
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        if (r5.isInHorizontalChain() == true) goto L57;
        r9 = true;
    L57:
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L61;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L63;
    L61:
        if (r5.mDimensionRatio <= 0.0f) goto L63;
    L26:
        if (r5.mMatchConstraintDefaultWidth == 1) goto L32;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (r5.mMatchConstraintDefaultHeight == 1) goto L32;
        r9 = true;
        goto L33
    L15:
        if (r5.horizontalRun == null) goto L23;
        if (r5.verticalRun == null) goto L23;
        if (r5.horizontalRun.dimension.resolved == false) goto L23;
        if (r5.verticalRun.dimension.resolved == false) goto L23;
    L69:
        r4 = r4 + 1;
        goto L3
    L70:
        r2.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer r3, String r4, int r5, int r6, int r7) {
        int r8 = r3.getMinWidth();
        int r0 = r3.getMinHeight();
        r3.setMinWidth(0);
        r3.setMinHeight(0);
        r3.setWidth(r6);
        r3.setHeight(r7);
        r3.setMinWidth(r8);
        r3.setMinHeight(r0);
        this.constraintWidgetContainer.setPass(r5);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        Measurer r5 = r24.getMeasurer();
        int r6 = r24.mChildren.size();
        int r7 = r24.getWidth();
        int r8 = r24.getHeight();
        boolean r9 = Optimizer.enabled(r25, 128);
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L44;
        int r12 = 0;
    L11:
        if (r12 >= r6) goto L44;
        ConstraintWidget r13 = r24.mChildren.get(r12);
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L15;
        boolean r14 = true;
    L17:
        if (r13.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        boolean r11 = true;
    L20:
        if (r14 == false) goto L25;
        if (r11 == false) goto L25;
        if (r13.getDimensionRatio() <= 0.0f) goto L25;
        boolean r15 = true;
    L27:
        if (r13.isInHorizontalChain() == false) goto L31;
        if (r15 == false) goto L31;
    L29:
        r2 = false;
    L31:
        if (r13.isInVerticalChain() == false) goto L35;
        if (r15 == true) goto L29;
    L35:
        if ((r13 instanceof VirtualLayout) == true) goto L29;
        if (r13.isInHorizontalChain() == true) goto L29;
        if (r13.isInVerticalChain() == true) goto L29;
        r12 = r12 + 1;
    L25:
        r15 = false;
        goto L27
    L19:
        r11 = false;
        goto L20
    L15:
        r14 = false;
    L44:
        if (r2 == false) goto L49;
        if (LinearSystem.sMetrics == null) goto L49;
        LinearSystem.sMetrics.measures++;
    L49:
        if (r28 != 1073741824) goto L51;
        if (r30 != 1073741824) goto L51;
    L52:
        boolean r16 = true;
    L54:
        boolean r3 = r2 & r16;
        int r17 = 2;
        if (r3 == false) goto L83;
        int r18 = Math.min(r24.getMaxWidth(), r29);
        int r19 = Math.min(r24.getMaxHeight(), r31);
        if (r28 == 1073741824) goto L59;
    L61:
        if (r30 == 1073741824) goto L63;
    L65:
        if (r28 != 1073741824) goto L68;
        if (r30 != 1073741824) goto L68;
        boolean r10 = r24.directMeasure(r9);
        int r110 = 2;
    L75:
        if (r10 == false) goto L84;
        if (r28 != 1073741824) goto L78;
        boolean r111 = true;
    L79:
        if (r30 != 1073741824) goto L81;
        boolean r4 = true;
    L82:
        r24.updateFromRuns(r111, r4);
        goto L84
    L81:
        r4 = false;
        goto L82
    L78:
        r111 = false;
    L84:
        if (r10 == false) goto L86;
        if (r110 != 2) goto L86;
        return 0;
    L86:
        int r20 = r24.getOptimizationLevel();
        if (r6 <= 0) goto L89;
        measureChildren(r24);
    L89:
        updateHierarchy(r24);
        int r21 = this.mVariableDimensionsWidgets.size();
        if (r6 <= 0) goto L92;
        solveLinearSystem(r24, "First pass", 0, r7, r8);
    L92:
        if (r21 > 0) goto L94;
        int r0 = r20;
    L185:
        r24.setOptimizationLevel(r0);
        return 0;
    L94:
        if (r24.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L96;
        boolean r112 = true;
    L98:
        if (r24.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L100;
        boolean r22 = true;
    L101:
        int r23 = Math.max(r24.getWidth(), this.constraintWidgetContainer.getMinWidth());
        int r113 = Math.max(r24.getHeight(), this.constraintWidgetContainer.getMinHeight());
        int r114 = 0;
        boolean r115 = false;
    L102:
        if (r114 >= r21) goto L128;
        ConstraintWidget r116 = this.mVariableDimensionsWidgets.get(r114);
        if ((r116 instanceof VirtualLayout) == true) goto L106;
        r7 = r7;
    L127:
        r114 = r114 + 1;
        r20 = r20;
        r8 = r8;
        r7 = r7;
        r17 = 2;
        goto L102
    L106:
        int r117 = r116.getWidth();
        int r34 = r116.getHeight();
        boolean r35 = measure(r5, r116, Measure.TRY_GIVEN_DIMENSIONS) | r115;
        if (r24.mMetrics == null) goto L110;
        r24.mMetrics.measuredMatchWidgets++;
    L110:
        int r36 = r116.getWidth();
        int r37 = r116.getHeight();
        if (r36 == r117) goto L118;
        r116.setWidth(r36);
        if (r112 == true) goto L115;
    L117:
        boolean r38 = true;
    L119:
        if (r37 == r34) goto L126;
        r116.setHeight(r37);
        if (r22 == true) goto L123;
    L125:
        r38 = true;
        goto L126
    L123:
        if (r116.getBottom() <= r113) goto L125;
        r113 = Math.max(r113, r116.getBottom() + r116.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L126:
        r115 = r38 | ((VirtualLayout) r116).needSolverPass();
        goto L127
    L115:
        if (r116.getRight() <= r23) goto L117;
        r23 = Math.max(r23, r116.getRight() + r116.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
        goto L117
    L118:
        r38 = r35;
        goto L119
    L128:
        int r39 = r20;
        int r118 = r7;
        int r119 = r8;
        int r40 = r17;
        int r41 = 0;
    L129:
        if (r41 >= r40) goto L183;
        int r42 = 0;
    L131:
        if (r42 >= r21) goto L180;
        ConstraintWidget r120 = this.mVariableDimensionsWidgets.get(r42);
        if ((r120 instanceof Helper) == false) goto L137;
        if ((r120 instanceof VirtualLayout) == true) goto L137;
    L150:
        boolean r210 = r3;
        r21 = r21;
        r5 = r5;
    L179:
        r42 = r42 + 1;
        r5 = r5;
        r3 = r210;
        r21 = r21;
    L137:
        if ((r120 instanceof Guideline) == true) goto L150;
        if (r120.getVisibility() == 8) goto L150;
        if (r3 == false) goto L149;
        if (r120.horizontalRun.dimension.resolved == false) goto L149;
        if (r120.verticalRun.dimension.resolved == true) goto L150;
    L149:
        if ((r120 instanceof VirtualLayout) == true) goto L150;
        int r121 = r120.getWidth();
        int r122 = r120.getHeight();
        int r43 = r120.getBaselineDistance();
        int r211 = Measure.TRY_GIVEN_DIMENSIONS;
        r210 = r3;
        if (r41 != 1) goto L154;
        r211 = Measure.USE_GIVEN_DIMENSIONS;
    L154:
        boolean r44 = measure(r5, r120, r211) | r115;
        if (r24.mMetrics == null) goto L158;
        r24.mMetrics.measuredMatchWidgets++;
    L158:
        int r45 = r120.getWidth();
        int r46 = r120.getHeight();
        if (r45 == r121) goto L166;
        r120.setWidth(r45);
        if (r112 == true) goto L163;
    L165:
        r44 = true;
        goto L166
    L163:
        if (r120.getRight() <= r23) goto L165;
        r23 = Math.max(r23, r120.getRight() + r120.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
    L166:
        if (r46 == r122) goto L174;
        r120.setHeight(r46);
        if (r22 == true) goto L170;
    L172:
        r44 = true;
        goto L174
    L170:
        if (r120.getBottom() <= r113) goto L172;
        r113 = Math.max(r113, r120.getBottom() + r120.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L174:
        if (r120.hasBaseline() == true) goto L176;
    L178:
        r115 = r44;
        goto L179
    L176:
        if (r43 == r120.getBaselineDistance()) goto L178;
        r115 = true;
        goto L179
    L180:
        boolean r212 = r3;
        int r213 = r21;
        Measurer r214 = r5;
        if (r115 == false) goto L183;
        r41 = r41 + 1;
        solveLinearSystem(r24, "intermediate pass", r41, r118, r119);
        r5 = r214;
        r3 = r212;
        r21 = r213;
        r40 = 2;
        r115 = false;
    L183:
        r0 = r39;
        goto L185
    L100:
        r22 = false;
        goto L101
    L96:
        r112 = false;
    L68:
        boolean r123 = r24.directMeasureSetup(r9);
        if (r28 != 1073741824) goto L71;
        r123 = r123 & r24.directMeasureWithOrientation(r9, 0);
        r110 = 1;
    L72:
        if (r30 != 1073741824) goto L74;
        r10 = r24.directMeasureWithOrientation(r9, 1) & r123;
        r110 = r110 + 1;
        goto L75
    L74:
        r10 = r123;
        goto L75
    L71:
        r110 = 0;
        goto L72
    L63:
        if (r24.getHeight() == r19) goto L65;
        r24.setHeight(r19);
        r24.invalidateGraph();
        goto L65
    L59:
        if (r24.getWidth() == r18) goto L61;
        r24.setWidth(r18);
        r24.invalidateGraph();
        goto L61
    L83:
        r10 = false;
        r110 = 0;
    L51:
        if (r9 == true) goto L52;
        r16 = false;
        goto L54
    L5:
        if (Optimizer.enabled(r25, 64) == true) goto L8;
        r2 = false;
        goto L9
    }

    private boolean measure(Measurer r5, ConstraintWidget r6, int r7) {
        this.mMeasure.horizontalBehavior = r6.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = r6.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = r6.getWidth();
        this.mMeasure.verticalDimension = r6.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.measureStrategy = r7;
        if (this.mMeasure.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        boolean r8 = true;
    L7:
        if (this.mMeasure.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L9;
        boolean r0 = true;
    L11:
        if (r8 == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r0 == true) goto L18;
    L20:
        boolean r1 = false;
    L22:
        if (r9 == true) goto L24;
    L26:
        if (r1 == true) goto L28;
    L30:
        r5.measure(r6, this.mMeasure);
        r6.setWidth(this.mMeasure.measuredWidth);
        r6.setHeight(this.mMeasure.measuredHeight);
        r6.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r6.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.measureStrategy = Measure.SELF_DIMENSIONS;
        return this.mMeasure.measuredNeedsSolverPass;
    L28:
        if (r6.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r6.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r6.mDimensionRatio <= 0.0f) goto L20;
        r1 = true;
        goto L22
    L13:
        if (r6.mDimensionRatio <= 0.0f) goto L15;
        r9 = true;
        goto L16
    L9:
        r0 = false;
        goto L11
    L5:
        r8 = false;
        goto L7
    }
}
