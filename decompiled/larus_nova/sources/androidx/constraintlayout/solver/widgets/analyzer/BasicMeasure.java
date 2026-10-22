package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
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

        public Measure() {
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r100, Measure r101);
    }

    public BasicMeasure(ConstraintWidgetContainer r100) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = r100;
    }

    private void measureChildren(ConstraintWidgetContainer r110) {
        int r100 = r110.mChildren.size();
        boolean r101 = r110.optimizeFor(64);
        Measurer r102 = r110.getMeasurer();
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L63;
        ConstraintWidget r104 = (ConstraintWidget) ListProtector.get(r110.mChildren, r103);
        if ((r104 instanceof Guideline) == true) goto L62;
        if ((r104 instanceof Barrier) == true) goto L62;
        if (r104.isInVirtualLayout() == true) goto L62;
        if (r101 == false) goto L23;
        HorizontalWidgetRun r105 = r104.horizontalRun;
        if (r105 == null) goto L23;
        VerticalWidgetRun r106 = r104.verticalRun;
        if (r106 == null) goto L23;
        if (r105.dimension.resolved == false) goto L23;
        if (r106.dimension.resolved == true) goto L62;
    L23:
        ConstraintWidget.DimensionBehaviour r107 = r104.getDimensionBehaviour(0);
        boolean r108 = true;
        ConstraintWidget.DimensionBehaviour r109 = r104.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r107 == r111) goto L26;
    L31:
        boolean r112 = false;
    L32:
        if (r112 == false) goto L34;
    L56:
        r108 = r112;
    L57:
        if (r108 == true) goto L62;
        measure(r102, r104, Measure.SELF_DIMENSIONS);
        Metrics r113 = r110.mMetrics;
        if (r113 == null) goto L62;
        r113.measuredWidgets++;
        goto L62
    L34:
        if (r110.optimizeFor(1) == false) goto L56;
        if ((r104 instanceof VirtualLayout) == true) goto L56;
        if (r107 == r111) goto L39;
    L44:
        if (r109 == r111) goto L46;
    L51:
        if (r107 == r111) goto L54;
        if (r109 != r111) goto L56;
    L54:
        if (r104.mDimensionRatio <= 0.0f) goto L56;
    L46:
        if (r104.mMatchConstraintDefaultHeight != 0) goto L51;
        if (r107 == r111) goto L51;
        if (r104.isInHorizontalChain() == true) goto L51;
        r112 = true;
        goto L51
    L39:
        if (r104.mMatchConstraintDefaultWidth != 0) goto L44;
        if (r109 == r111) goto L44;
        if (r104.isInHorizontalChain() == true) goto L44;
        r112 = true;
        goto L44
    L26:
        if (r104.mMatchConstraintDefaultWidth == 1) goto L31;
        if (r109 != r111) goto L31;
        if (r104.mMatchConstraintDefaultHeight == 1) goto L31;
        r112 = true;
    L62:
        r103 = r103 + 1;
        goto L3
    L63:
        r102.didMeasures();
    }

    public void updateHierarchy(ConstraintWidgetContainer r100) {
        this.mVariableDimensionsWidgets.clear();
        int r101 = r100.mChildren.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ConstraintWidget r103 = (ConstraintWidget) ListProtector.get(r100.mChildren, r102);
        ConstraintWidget.DimensionBehaviour r104 = r103.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r105 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r104 != r105) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r103);
    L9:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r103.getVerticalDimensionBehaviour() != r105) goto L9;
    L10:
        r100.invalidateGraph();
    }

    private boolean measure(Measurer r100, ConstraintWidget r101, int r102) {
        Measure r103 = this.mMeasure;
        r103.horizontalBehavior = r101.getHorizontalDimensionBehaviour();
        Measure r104 = this.mMeasure;
        r104.verticalBehavior = r101.getVerticalDimensionBehaviour();
        Measure r105 = this.mMeasure;
        r105.horizontalDimension = r101.getWidth();
        Measure r106 = this.mMeasure;
        r106.verticalDimension = r101.getHeight();
        Measure r107 = this.mMeasure;
        r107.measuredNeedsSolverPass = false;
        r107.measureStrategy = r102;
        ConstraintWidget.DimensionBehaviour r108 = r107.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r109 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r108 != r109) goto L5;
        boolean r110 = true;
    L7:
        if (r107.verticalBehavior != r109) goto L9;
        boolean r111 = true;
    L11:
        if (r110 == true) goto L13;
    L15:
        boolean r112 = false;
    L16:
        if (r111 == true) goto L18;
    L20:
        boolean r113 = false;
    L22:
        if (r112 == true) goto L24;
    L26:
        if (r113 == true) goto L28;
    L30:
        r100.measure(r101, r107);
        r101.setWidth(this.mMeasure.measuredWidth);
        r101.setHeight(this.mMeasure.measuredHeight);
        r101.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r101.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure r114 = this.mMeasure;
        r114.measureStrategy = Measure.SELF_DIMENSIONS;
        return r114.measuredNeedsSolverPass;
    L28:
        if (r101.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        r107.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r101.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        r107.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r101.mDimensionRatio <= 0.0f) goto L20;
        r113 = true;
        goto L22
    L13:
        if (r101.mDimensionRatio <= 0.0f) goto L15;
        r112 = true;
        goto L16
    L9:
        r111 = false;
        goto L11
    L5:
        r110 = false;
        goto L7
    }

    private void solveLinearSystem(ConstraintWidgetContainer r100, String r101, int r102, int r103) {
        int r104 = r100.getMinWidth();
        int r105 = r100.getMinHeight();
        r100.setMinWidth(0);
        r100.setMinHeight(0);
        r100.setWidth(r102);
        r100.setHeight(r103);
        r100.setMinWidth(r104);
        r100.setMinHeight(r105);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer r210, int r211, int r212, int r213, int r214, int r215, int r216, int r310, int r311, int r312) {
        Measurer r100 = r210.getMeasurer();
        int r101 = r210.mChildren.size();
        int r102 = r210.getWidth();
        int r103 = r210.getHeight();
        boolean r104 = Optimizer.enabled(r211, 128);
        if (r104 == false) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L44;
        int r110 = 0;
    L11:
        if (r110 >= r101) goto L44;
        ConstraintWidget r111 = (ConstraintWidget) ListProtector.get(r210.mChildren, r110);
        ConstraintWidget.DimensionBehaviour r112 = r111.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r113 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r112 != r113) goto L15;
        boolean r114 = true;
    L17:
        if (r111.getVerticalDimensionBehaviour() != r113) goto L19;
        boolean r115 = true;
    L20:
        if (r114 == false) goto L25;
        if (r115 == false) goto L25;
        if (r111.getDimensionRatio() <= 0.0f) goto L25;
        boolean r116 = true;
    L27:
        if (r111.isInHorizontalChain() == false) goto L31;
        if (r116 == false) goto L31;
    L29:
        r105 = false;
    L31:
        if (r111.isInVerticalChain() == false) goto L35;
        if (r116 == true) goto L29;
    L35:
        if ((r111 instanceof VirtualLayout) == true) goto L29;
        if (r111.isInHorizontalChain() == true) goto L29;
        if (r111.isInVerticalChain() == true) goto L29;
        r110 = r110 + 1;
    L25:
        r116 = false;
        goto L27
    L19:
        r115 = false;
        goto L20
    L15:
        r114 = false;
    L44:
        if (r105 == false) goto L49;
        Metrics r117 = LinearSystem.sMetrics;
        if (r117 == null) goto L49;
        r117.measures++;
    L49:
        if (r214 != 1073741824) goto L51;
        if (r216 != 1073741824) goto L51;
    L52:
        boolean r118 = true;
    L54:
        boolean r106 = r105 & r118;
        if (r106 == false) goto L83;
        int r119 = Math.min(r210.getMaxWidth(), r215);
        int r120 = Math.min(r210.getMaxHeight(), r310);
        if (r214 == 1073741824) goto L59;
    L61:
        if (r216 == 1073741824) goto L63;
    L65:
        if (r214 != 1073741824) goto L68;
        if (r216 != 1073741824) goto L68;
        boolean r107 = r210.directMeasure(r104);
        int r121 = 2;
    L75:
        if (r107 == false) goto L84;
        if (r214 != 1073741824) goto L78;
        boolean r122 = true;
    L79:
        if (r216 != 1073741824) goto L81;
        boolean r108 = true;
    L82:
        r210.updateFromRuns(r122, r108);
        goto L84
    L81:
        r108 = false;
        goto L82
    L78:
        r122 = false;
    L84:
        if (r107 == false) goto L86;
        if (r121 != 2) goto L86;
        return 0;
    L86:
        int r109 = r210.getOptimizationLevel();
        if (r101 <= 0) goto L89;
        measureChildren(r210);
    L89:
        updateHierarchy(r210);
        int r123 = this.mVariableDimensionsWidgets.size();
        if (r101 <= 0) goto L92;
        solveLinearSystem(r210, "First pass", r102, r103);
    L92:
        if (r123 <= 0) goto L195;
        ConstraintWidget.DimensionBehaviour r124 = r210.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r125 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r124 != r125) goto L96;
        boolean r126 = true;
    L98:
        if (r210.getVerticalDimensionBehaviour() != r125) goto L100;
        boolean r127 = true;
    L101:
        int r128 = Math.max(r210.getWidth(), this.constraintWidgetContainer.getMinWidth());
        int r129 = Math.max(r210.getHeight(), this.constraintWidgetContainer.getMinHeight());
        int r130 = 0;
        boolean r131 = false;
    L102:
        if (r130 >= r123) goto L127;
        ConstraintWidget r132 = (ConstraintWidget) ListProtector.get(this.mVariableDimensionsWidgets, r130);
        if ((r132 instanceof VirtualLayout) == false) goto L126;
        int r133 = r132.getWidth();
        int r134 = r132.getHeight();
        boolean r135 = measure(r100, r132, Measure.TRY_GIVEN_DIMENSIONS) | r131;
        Metrics r136 = r210.mMetrics;
        if (r136 == null) goto L109;
        r136.measuredMatchWidgets++;
    L109:
        int r137 = r132.getWidth();
        int r138 = r132.getHeight();
        if (r137 == r133) goto L117;
        r132.setWidth(r137);
        if (r126 == true) goto L114;
    L116:
        boolean r139 = true;
    L118:
        if (r138 == r134) goto L125;
        r132.setHeight(r138);
        if (r127 == true) goto L122;
    L124:
        r139 = true;
        goto L125
    L122:
        if (r132.getBottom() <= r129) goto L124;
        r129 = Math.max(r129, r132.getBottom() + r132.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L125:
        r131 = r139 | ((VirtualLayout) r132).needSolverPass();
        goto L126
    L114:
        if (r132.getRight() <= r128) goto L116;
        r128 = Math.max(r128, r132.getRight() + r132.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
        goto L116
    L117:
        r139 = r135;
    L126:
        r130 = r130 + 1;
        r109 = r109;
        r102 = r102;
        r103 = r103;
        goto L102
    L127:
        int r217 = r109;
        int r140 = r102;
        int r141 = r103;
        int r142 = 0;
        int r143 = 2;
    L128:
        if (r142 >= r143) goto L183;
        int r144 = 0;
    L130:
        if (r144 >= r123) goto L179;
        ConstraintWidget r145 = (ConstraintWidget) ListProtector.get(this.mVariableDimensionsWidgets, r144);
        if ((r145 instanceof Helper) == false) goto L136;
        if ((r145 instanceof VirtualLayout) == true) goto L136;
    L149:
        boolean r146 = r106;
        int r218 = r123;
        Measurer r147 = r100;
    L178:
        r144 = r144 + 1;
        r123 = r218;
        r100 = r147;
        r106 = r146;
    L136:
        if ((r145 instanceof Guideline) == true) goto L149;
        if (r145.getVisibility() == 8) goto L149;
        if (r106 == false) goto L148;
        if (r145.horizontalRun.dimension.resolved == false) goto L148;
        if (r145.verticalRun.dimension.resolved == true) goto L149;
    L148:
        if ((r145 instanceof VirtualLayout) == true) goto L149;
        int r148 = r145.getWidth();
        int r149 = r145.getHeight();
        int r150 = r145.getBaselineDistance();
        int r151 = Measure.TRY_GIVEN_DIMENSIONS;
        r146 = r106;
        if (r142 != 1) goto L153;
        r151 = Measure.USE_GIVEN_DIMENSIONS;
    L153:
        boolean r152 = measure(r100, r145, r151) | r131;
        Metrics r153 = r210.mMetrics;
        r218 = r123;
        r147 = r100;
        if (r153 == null) goto L157;
        r153.measuredMatchWidgets++;
    L157:
        int r154 = r145.getWidth();
        int r155 = r145.getHeight();
        if (r154 == r148) goto L165;
        r145.setWidth(r154);
        if (r126 == true) goto L162;
    L164:
        r152 = true;
        goto L165
    L162:
        if (r145.getRight() <= r128) goto L164;
        r128 = Math.max(r128, r145.getRight() + r145.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
    L165:
        if (r155 == r149) goto L173;
        r145.setHeight(r155);
        if (r127 == true) goto L169;
    L171:
        r152 = true;
        goto L173
    L169:
        if (r145.getBottom() <= r129) goto L171;
        r129 = Math.max(r129, r145.getBottom() + r145.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L173:
        if (r145.hasBaseline() == true) goto L175;
    L177:
        r131 = r152;
        goto L178
    L175:
        if (r150 == r145.getBaselineDistance()) goto L177;
        r131 = true;
        goto L178
    L179:
        boolean r156 = r106;
        int r219 = r123;
        Measurer r157 = r100;
        if (r131 == false) goto L183;
        solveLinearSystem(r210, "intermediate pass", r140, r141);
        r142 = r142 + 1;
        r100 = r157;
        r106 = r156;
        r143 = 2;
        r131 = false;
        r123 = r219;
    L183:
        if (r131 == false) goto L194;
        solveLinearSystem(r210, "2nd pass", r140, r141);
        if (r210.getWidth() >= r128) goto L187;
        r210.setWidth(r128);
        boolean r158 = true;
    L189:
        if (r210.getHeight() >= r129) goto L191;
        r210.setHeight(r129);
        boolean r159 = true;
    L192:
        if (r159 == false) goto L194;
        solveLinearSystem(r210, "3rd pass", r140, r141);
        goto L194
    L191:
        r159 = r158;
        goto L192
    L187:
        r158 = false;
    L194:
        int r160 = r217;
    L196:
        r210.setOptimizationLevel(r160);
        return 0;
    L100:
        r127 = false;
        goto L101
    L96:
        r126 = false;
        goto L98
    L195:
        r160 = r109;
    L68:
        boolean r161 = r210.directMeasureSetup(r104);
        if (r214 != 1073741824) goto L71;
        r161 = r161 & r210.directMeasureWithOrientation(r104, 0);
        r121 = 1;
    L72:
        if (r216 != 1073741824) goto L74;
        r107 = r210.directMeasureWithOrientation(r104, 1) & r161;
        r121 = r121 + 1;
        goto L75
    L74:
        r107 = r161;
        goto L75
    L71:
        r121 = 0;
        goto L72
    L63:
        if (r210.getHeight() == r120) goto L65;
        r210.setHeight(r120);
        r210.invalidateGraph();
        goto L65
    L59:
        if (r210.getWidth() == r119) goto L61;
        r210.setWidth(r119);
        r210.invalidateGraph();
        goto L61
    L83:
        r107 = false;
        r121 = 0;
    L51:
        if (r104 == true) goto L52;
        r118 = false;
        goto L54
    L5:
        if (Optimizer.enabled(r211, 64) == true) goto L8;
        r105 = false;
        goto L9
    }
}
