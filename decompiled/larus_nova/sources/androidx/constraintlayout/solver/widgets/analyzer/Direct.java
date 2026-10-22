package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static BasicMeasure.Measure measure;

    public Direct() {
    }

    static {
        measure = new BasicMeasure.Measure();
    }

    private static boolean canMeasure(ConstraintWidget r100) {
        ConstraintWidget.DimensionBehaviour r101 = r100.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r102 = r100.getVerticalDimensionBehaviour();
        if (r100.getParent() == null) goto L5;
        ConstraintWidgetContainer r103 = (ConstraintWidgetContainer) r100.getParent();
    L6:
        if (r103 == null) goto L8;
        r103.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r104 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r103 == null) goto L10;
        r103.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r105 = ConstraintWidget.DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget.DimensionBehaviour r106 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r101 != r106) goto L13;
    L26:
        boolean r107 = true;
    L27:
        if (r102 != r106) goto L29;
    L42:
        boolean r108 = true;
    L44:
        if (r100.mDimensionRatio <= 0.0f) goto L48;
        if (r107 == true) goto L47;
        if (r108 == false) goto L48;
    L47:
        return true;
    L48:
        if (r107 == false) goto L52;
        if (r108 == false) goto L53;
        return true;
    L53:
        return false;
    L52:
        return false;
    L29:
        if (r102 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L42;
        if (r102 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        if (r100.mMatchConstraintDefaultHeight != 0) goto L39;
        if (r100.mDimensionRatio != 0.0f) goto L39;
        if (r100.hasDanglingDimension(1) == true) goto L42;
    L39:
        if (r100.isResolvedVertically() == true) goto L42;
        r108 = false;
        goto L44
    L13:
        if (r101 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        if (r101 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L23;
        if (r100.mMatchConstraintDefaultWidth != 0) goto L23;
        if (r100.mDimensionRatio != 0.0f) goto L23;
        if (r100.hasDanglingDimension(0) == true) goto L26;
    L23:
        if (r100.isResolvedHorizontally() == true) goto L26;
        r107 = false;
        goto L27
    L5:
        r103 = null;
        goto L6
    }

    private static void solveVerticalCenterConstraints(BasicMeasure.Measurer r100, ConstraintWidget r101) {
        float r102 = r101.getVerticalBiasPercent();
        int r103 = r101.mTop.mTarget.getFinalValue();
        int r104 = r101.mBottom.mTarget.getFinalValue();
        int r105 = r101.mTop.getMargin() + r103;
        int r106 = r104 - r101.mBottom.getMargin();
        if (r103 != r104) goto L5;
        r102 = 0.5f;
    L6:
        int r107 = r101.getHeight();
        int r108 = (r104 - r103) - r107;
        if (r103 <= r104) goto L9;
        r108 = (r103 - r104) - r107;
    L9:
        int r109 = (int) ((r102 * r108) + 0.5f);
        int r110 = r103 + r109;
        int r111 = r110 + r107;
        if (r103 <= r104) goto L12;
        r110 = r103 - r109;
        r111 = r110 - r107;
    L12:
        r101.setFinalVertical(r110, r111);
        verticalSolvingPass(r101, r100);
        return;
    L5:
        r103 = r105;
        r104 = r106;
        goto L6
    }

    public static void solvingPass(ConstraintWidgetContainer r110, BasicMeasure.Measurer r111) {
        ConstraintWidget.DimensionBehaviour r100 = r110.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r101 = r110.getVerticalDimensionBehaviour();
        r110.resetFinalResolution();
        ArrayList<ConstraintWidget> r102 = r110.getChildren();
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        ((ConstraintWidget) ListProtector.get(r102, r105)).resetFinalResolution();
        r105 = r105 + 1;
        goto L3
    L5:
        boolean r106 = r110.isRtl();
        if (r100 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r110.setFinalHorizontal(0, r110.getWidth());
    L9:
        int r107 = 0;
        boolean r108 = false;
        boolean r109 = false;
    L11:
        if (r107 >= r103) goto L34;
        ConstraintWidget r112 = (ConstraintWidget) ListProtector.get(r102, r107);
        if ((r112 instanceof Guideline) == false) goto L29;
        Guideline r113 = (Guideline) r112;
        if (r113.getOrientation() != 1) goto L33;
        if (r113.getRelativeBegin() == (-1)) goto L20;
        r113.setFinalValue(r113.getRelativeBegin());
    L27:
        r108 = true;
        goto L33
    L20:
        if (r113.getRelativeEnd() == (-1)) goto L25;
        if (r110.isResolvedHorizontally() == false) goto L25;
        r113.setFinalValue(r110.getWidth() - r113.getRelativeEnd());
    L25:
        if (r110.isResolvedHorizontally() == false) goto L27;
        r113.setFinalValue((int) ((r113.getRelativePercent() * r110.getWidth()) + 0.5f));
    L33:
        r107 = r107 + 1;
        goto L11
    L29:
        if ((r112 instanceof Barrier) == false) goto L33;
        if (((Barrier) r112).getOrientation() != 0) goto L33;
        r109 = true;
        goto L33
    L34:
        if (r108 == false) goto L43;
        int r114 = 0;
    L36:
        if (r114 >= r103) goto L43;
        ConstraintWidget r115 = (ConstraintWidget) ListProtector.get(r102, r114);
        if ((r115 instanceof Guideline) == false) goto L42;
        Guideline r116 = (Guideline) r115;
        if (r116.getOrientation() != 1) goto L42;
        horizontalSolvingPass(r116, r111, r106);
    L42:
        r114 = r114 + 1;
    L43:
        horizontalSolvingPass(r110, r111, r106);
        if (r109 == false) goto L54;
        int r117 = 0;
    L46:
        if (r117 >= r103) goto L54;
        ConstraintWidget r118 = (ConstraintWidget) ListProtector.get(r102, r117);
        if ((r118 instanceof Barrier) == false) goto L52;
        Barrier r119 = (Barrier) r118;
        if (r119.getOrientation() != 0) goto L52;
        solveBarrier(r119, r111, 0, r106);
    L52:
        r117 = r117 + 1;
    L54:
        if (r101 != ConstraintWidget.DimensionBehaviour.FIXED) goto L56;
        r110.setFinalVertical(0, r110.getHeight());
    L57:
        int r120 = 0;
        boolean r121 = false;
        boolean r122 = false;
    L58:
        if (r120 >= r103) goto L81;
        ConstraintWidget r123 = (ConstraintWidget) ListProtector.get(r102, r120);
        if ((r123 instanceof Guideline) == false) goto L76;
        Guideline r124 = (Guideline) r123;
        if (r124.getOrientation() != 0) goto L80;
        if (r124.getRelativeBegin() == (-1)) goto L67;
        r124.setFinalValue(r124.getRelativeBegin());
    L74:
        r121 = true;
        goto L80
    L67:
        if (r124.getRelativeEnd() == (-1)) goto L72;
        if (r110.isResolvedVertically() == false) goto L72;
        r124.setFinalValue(r110.getHeight() - r124.getRelativeEnd());
    L72:
        if (r110.isResolvedVertically() == false) goto L74;
        r124.setFinalValue((int) ((r124.getRelativePercent() * r110.getHeight()) + 0.5f));
    L80:
        r120 = r120 + 1;
        goto L58
    L76:
        if ((r123 instanceof Barrier) == false) goto L80;
        if (((Barrier) r123).getOrientation() != 1) goto L80;
        r122 = true;
        goto L80
    L81:
        if (r121 == false) goto L90;
        int r125 = 0;
    L83:
        if (r125 >= r103) goto L90;
        ConstraintWidget r126 = (ConstraintWidget) ListProtector.get(r102, r125);
        if ((r126 instanceof Guideline) == false) goto L89;
        Guideline r127 = (Guideline) r126;
        if (r127.getOrientation() != 0) goto L89;
        verticalSolvingPass(r127, r111);
    L89:
        r125 = r125 + 1;
    L90:
        verticalSolvingPass(r110, r111);
        if (r122 == false) goto L100;
        int r128 = 0;
    L93:
        if (r128 >= r103) goto L100;
        ConstraintWidget r129 = (ConstraintWidget) ListProtector.get(r102, r128);
        if ((r129 instanceof Barrier) == false) goto L99;
        Barrier r130 = (Barrier) r129;
        if (r130.getOrientation() != 1) goto L99;
        solveBarrier(r130, r111, 1, r106);
    L99:
        r128 = r128 + 1;
    L100:
        if (r104 >= r103) goto L107;
        ConstraintWidget r131 = (ConstraintWidget) ListProtector.get(r102, r104);
        if (r131.isMeasureRequested() == false) goto L106;
        if (canMeasure(r131) == false) goto L106;
        ConstraintWidgetContainer.measure(r131, r111, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
        horizontalSolvingPass(r131, r111, r106);
        verticalSolvingPass(r131, r111);
    L106:
        r104 = r104 + 1;
        goto L100
    L107:
        return;
    L56:
        r110.setFinalTop(0);
        goto L57
    L8:
        r110.setFinalLeft(0);
        goto L9
    }

    private static void verticalSolvingPass(ConstraintWidget r110, BasicMeasure.Measurer r111) {
        if ((r110 instanceof ConstraintWidgetContainer) == false) goto L5;
    L9:
        ConstraintAnchor r100 = r110.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r101 = r110.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int r102 = r100.getFinalValue();
        int r103 = r101.getFinalValue();
        if (r100.getDependents() == null) goto L78;
        if (r100.hasFinalValue() == false) goto L78;
        Iterator<ConstraintAnchor> r104 = r100.getDependents().iterator();
    L15:
        if (r104.hasNext() == false) goto L78;
        ConstraintAnchor r105 = r104.next();
        ConstraintWidget r106 = r105.mOwner;
        boolean r112 = canMeasure(r106);
        if (r106.isMeasureRequested() == false) goto L20;
        if (r112 == false) goto L20;
        ConstraintWidgetContainer.measure(r106, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        ConstraintWidget.DimensionBehaviour r113 = r106.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r114 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r113 != r114) goto L59;
        if (r112 == true) goto L59;
        if (r106.getVerticalDimensionBehaviour() != r114) goto L15;
        if (r106.mMatchConstraintMaxHeight < 0) goto L15;
        if (r106.mMatchConstraintMinHeight < 0) goto L15;
        if (r106.getVisibility() == 8) goto L37;
        if (r106.mMatchConstraintDefaultHeight != 0) goto L15;
        if (r106.getDimensionRatio() != 0.0f) goto L15;
    L37:
        if (r106.isInVerticalChain() == true) goto L15;
        if (r106.isInVirtualLayout() == true) goto L15;
        if (r105 != r106.mTop) goto L47;
        ConstraintAnchor r115 = r106.mBottom.mTarget;
        if (r115 == null) goto L47;
        if (r115.hasFinalValue() == false) goto L47;
    L52:
        boolean r107 = true;
    L54:
        if (r107 == false) goto L15;
        if (r106.isInVerticalChain() == true) goto L15;
        solveVerticalMatchConstraint(r110, r111, r106);
    L47:
        if (r105 != r106.mBottom) goto L53;
        ConstraintAnchor r108 = r106.mTop.mTarget;
        if (r108 == null) goto L53;
        if (r108.hasFinalValue() == true) goto L52;
    L53:
        r107 = false;
    L59:
        if (r106.isMeasureRequested() == true) goto L15;
        ConstraintAnchor r116 = r106.mTop;
        if (r105 != r116) goto L66;
        if (r106.mBottom.mTarget != null) goto L66;
        int r109 = r116.getMargin() + r102;
        r106.setFinalVertical(r109, r106.getHeight() + r109);
        verticalSolvingPass(r106, r111);
    L66:
        ConstraintAnchor r117 = r106.mBottom;
        if (r105 != r117) goto L71;
        if (r117.mTarget != null) goto L71;
        int r118 = r102 - r117.getMargin();
        r106.setFinalVertical(r118 - r106.getHeight(), r118);
        verticalSolvingPass(r106, r111);
    L71:
        if (r105 != r116) goto L15;
        ConstraintAnchor r119 = r117.mTarget;
        if (r119 == null) goto L15;
        if (r119.hasFinalValue() == false) goto L15;
        solveVerticalCenterConstraints(r111, r106);
    L78:
        if ((r110 instanceof Guideline) == false) goto L81;
        return;
    L81:
        if (r101.getDependents() != null) goto L83;
    L146:
        ConstraintAnchor r120 = r110.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r120.getDependents() != null) goto L149;
        return;
    L149:
        if (r120.hasFinalValue() == false) goto L265;
        int r121 = r120.getFinalValue();
        Iterator<ConstraintAnchor> r122 = r120.getDependents().iterator();
    L152:
        if (r122.hasNext() == false) goto L266;
        ConstraintAnchor r123 = r122.next();
        ConstraintWidget r124 = r123.mOwner;
        boolean r125 = canMeasure(r124);
        if (r124.isMeasureRequested() == false) goto L158;
        if (r125 == false) goto L158;
        ConstraintWidgetContainer.measure(r124, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L158:
        if (r124.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L161;
        if (r125 == false) goto L152;
    L161:
        if (r124.isMeasureRequested() == true) goto L152;
        if (r123 != r124.mBaseline) goto L152;
        r124.setFinalBaseline(r121);
        verticalSolvingPass(r124, r111);     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        throw th;
    L266:
        return;
    L265:
        return;
    L83:
        if (r101.hasFinalValue() == false) goto L146;
        Iterator<ConstraintAnchor> r126 = r101.getDependents().iterator();
    L86:
        if (r126.hasNext() == false) goto L146;
        ConstraintAnchor r127 = r126.next();
        ConstraintWidget r128 = r127.mOwner;
        boolean r129 = canMeasure(r128);
        if (r128.isMeasureRequested() == false) goto L92;
        if (r129 == false) goto L92;
        ConstraintWidgetContainer.measure(r128, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L92:
        if (r127 != r128.mTop) goto L98;
        ConstraintAnchor r130 = r128.mBottom.mTarget;
        if (r130 == null) goto L98;
        if (r130.hasFinalValue() == false) goto L98;
    L103:
        boolean r131 = true;
    L105:
        ConstraintWidget.DimensionBehaviour r132 = r128.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r133 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r132 != r133) goto L130;
        if (r129 == true) goto L130;
        if (r128.getVerticalDimensionBehaviour() != r133) goto L86;
        if (r128.mMatchConstraintMaxHeight < 0) goto L86;
        if (r128.mMatchConstraintMinHeight < 0) goto L86;
        if (r128.getVisibility() == 8) goto L122;
        if (r128.mMatchConstraintDefaultHeight != 0) goto L86;
        if (r128.getDimensionRatio() != 0.0f) goto L86;
    L122:
        if (r128.isInVerticalChain() == true) goto L86;
        if (r128.isInVirtualLayout() == true) goto L86;
        if (r131 == false) goto L86;
        if (r128.isInVerticalChain() == true) goto L86;
        solveVerticalMatchConstraint(r110, r111, r128);
    L130:
        if (r128.isMeasureRequested() == true) goto L86;
        ConstraintAnchor r134 = r128.mTop;
        if (r127 != r134) goto L137;
        if (r128.mBottom.mTarget != null) goto L137;
        int r135 = r134.getMargin() + r103;
        r128.setFinalVertical(r135, r128.getHeight() + r135);
        verticalSolvingPass(r128, r111);
    L137:
        ConstraintAnchor r136 = r128.mBottom;
        if (r127 != r136) goto L142;
        if (r134.mTarget != null) goto L142;
        int r137 = r103 - r136.getMargin();
        r128.setFinalVertical(r137 - r128.getHeight(), r137);
        verticalSolvingPass(r128, r111);
    L142:
        if (r131 == false) goto L86;
        if (r128.isInVerticalChain() == true) goto L86;
        solveVerticalCenterConstraints(r111, r128);
    L98:
        if (r127 != r128.mBottom) goto L104;
        ConstraintAnchor r138 = r128.mTop.mTarget;
        if (r138 == null) goto L104;
        if (r138.hasFinalValue() == true) goto L103;
    L104:
        r131 = false;
        goto L105
    L5:
        if (r110.isMeasureRequested() == false) goto L9;
        if (canMeasure(r110) == false) goto L9;
        ConstraintWidgetContainer.measure(r110, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L9
    }

    private static void horizontalSolvingPass(ConstraintWidget r110, BasicMeasure.Measurer r111, boolean r112) {
        if ((r110 instanceof ConstraintWidgetContainer) == false) goto L5;
    L9:
        ConstraintAnchor r100 = r110.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r101 = r110.getAnchor(ConstraintAnchor.Type.RIGHT);
        int r102 = r100.getFinalValue();
        int r103 = r101.getFinalValue();
        if (r100.getDependents() == null) goto L80;
        if (r100.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r104 = r100.getDependents().iterator();
    L15:
        if (r104.hasNext() == false) goto L80;
        ConstraintAnchor r105 = r104.next();
        ConstraintWidget r106 = r105.mOwner;
        boolean r113 = canMeasure(r106);
        if (r106.isMeasureRequested() == false) goto L20;
        if (r113 == false) goto L20;
        ConstraintWidgetContainer.measure(r106, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        ConstraintWidget.DimensionBehaviour r114 = r106.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r114 != r115) goto L59;
        if (r113 == true) goto L59;
        if (r106.getHorizontalDimensionBehaviour() != r115) goto L15;
        if (r106.mMatchConstraintMaxWidth < 0) goto L15;
        if (r106.mMatchConstraintMinWidth < 0) goto L15;
        if (r106.getVisibility() == 8) goto L37;
        if (r106.mMatchConstraintDefaultWidth != 0) goto L15;
        if (r106.getDimensionRatio() != 0.0f) goto L15;
    L37:
        if (r106.isInHorizontalChain() == true) goto L15;
        if (r106.isInVirtualLayout() == true) goto L15;
        if (r105 != r106.mLeft) goto L47;
        ConstraintAnchor r116 = r106.mRight.mTarget;
        if (r116 == null) goto L47;
        if (r116.hasFinalValue() == false) goto L47;
    L52:
        boolean r107 = true;
    L54:
        if (r107 == false) goto L15;
        if (r106.isInHorizontalChain() == true) goto L15;
        solveHorizontalMatchConstraint(r110, r111, r106, r112);
    L47:
        if (r105 != r106.mRight) goto L53;
        ConstraintAnchor r108 = r106.mLeft.mTarget;
        if (r108 == null) goto L53;
        if (r108.hasFinalValue() == true) goto L52;
    L53:
        r107 = false;
    L59:
        if (r106.isMeasureRequested() == true) goto L15;
        ConstraintAnchor r117 = r106.mLeft;
        if (r105 != r117) goto L66;
        if (r106.mRight.mTarget != null) goto L66;
        int r109 = r117.getMargin() + r102;
        r106.setFinalHorizontal(r109, r106.getWidth() + r109);
        horizontalSolvingPass(r106, r111, r112);
    L66:
        ConstraintAnchor r118 = r106.mRight;
        if (r105 != r118) goto L71;
        if (r117.mTarget != null) goto L71;
        int r119 = r102 - r118.getMargin();
        r106.setFinalHorizontal(r119 - r106.getWidth(), r119);
        horizontalSolvingPass(r106, r111, r112);
    L71:
        if (r105 != r117) goto L15;
        ConstraintAnchor r120 = r118.mTarget;
        if (r120 == null) goto L15;
        if (r120.hasFinalValue() == false) goto L15;
        if (r106.isInHorizontalChain() == true) goto L15;
        solveHorizontalCenterConstraints(r111, r106, r112);
    L80:
        if ((r110 instanceof Guideline) == false) goto L83;
        return;
    L83:
        if (r101.getDependents() != null) goto L85;
        return;
    L85:
        if (r101.hasFinalValue() == false) goto L233;
        Iterator<ConstraintAnchor> r121 = r101.getDependents().iterator();
    L88:
        if (r121.hasNext() == false) goto L234;
        ConstraintAnchor r122 = r121.next();
        ConstraintWidget r123 = r122.mOwner;
        boolean r124 = canMeasure(r123);
        if (r123.isMeasureRequested() == false) goto L94;
        if (r124 == false) goto L94;
        ConstraintWidgetContainer.measure(r123, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r122 != r123.mLeft) goto L100;
        ConstraintAnchor r125 = r123.mRight.mTarget;
        if (r125 == null) goto L100;
        if (r125.hasFinalValue() == false) goto L100;
    L105:
        boolean r126 = true;
    L107:
        ConstraintWidget.DimensionBehaviour r127 = r123.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r128 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r127 != r128) goto L132;
        if (r124 == true) goto L132;
        if (r123.getHorizontalDimensionBehaviour() != r128) goto L88;
        if (r123.mMatchConstraintMaxWidth < 0) goto L88;
        if (r123.mMatchConstraintMinWidth < 0) goto L88;
        if (r123.getVisibility() == 8) goto L124;
        if (r123.mMatchConstraintDefaultWidth != 0) goto L88;
        if (r123.getDimensionRatio() != 0.0f) goto L88;
    L124:
        if (r123.isInHorizontalChain() == true) goto L88;
        if (r123.isInVirtualLayout() == true) goto L88;
        if (r126 == false) goto L88;
        if (r123.isInHorizontalChain() == true) goto L88;
        solveHorizontalMatchConstraint(r110, r111, r123, r112);
    L132:
        if (r123.isMeasureRequested() == true) goto L88;
        ConstraintAnchor r129 = r123.mLeft;
        if (r122 != r129) goto L139;
        if (r123.mRight.mTarget != null) goto L139;
        int r130 = r129.getMargin() + r103;
        r123.setFinalHorizontal(r130, r123.getWidth() + r130);
        horizontalSolvingPass(r123, r111, r112);
    L139:
        ConstraintAnchor r131 = r123.mRight;
        if (r122 != r131) goto L144;
        if (r129.mTarget != null) goto L144;
        int r132 = r103 - r131.getMargin();
        r123.setFinalHorizontal(r132 - r123.getWidth(), r132);
        horizontalSolvingPass(r123, r111, r112);
    L144:
        if (r126 == false) goto L88;
        if (r123.isInHorizontalChain() == true) goto L88;
        solveHorizontalCenterConstraints(r111, r123, r112);
    L100:
        if (r122 != r123.mRight) goto L106;
        ConstraintAnchor r133 = r123.mLeft.mTarget;
        if (r133 == null) goto L106;
        if (r133.hasFinalValue() == true) goto L105;
    L106:
        r126 = false;
        goto L107
    L234:
        return;
    L233:
        return;
    L5:
        if (r110.isMeasureRequested() == false) goto L9;
        if (canMeasure(r110) == false) goto L9;
        ConstraintWidgetContainer.measure(r110, r111, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L9
    }

    private static void solveHorizontalCenterConstraints(BasicMeasure.Measurer r100, ConstraintWidget r101, boolean r102) {
        float r103 = r101.getHorizontalBiasPercent();
        int r104 = r101.mLeft.mTarget.getFinalValue();
        int r105 = r101.mRight.mTarget.getFinalValue();
        int r106 = r101.mLeft.getMargin() + r104;
        int r107 = r105 - r101.mRight.getMargin();
        if (r104 != r105) goto L5;
        r103 = 0.5f;
    L6:
        int r108 = r101.getWidth();
        int r109 = (r105 - r104) - r108;
        if (r104 <= r105) goto L9;
        r109 = (r104 - r105) - r108;
    L9:
        int r110 = ((int) ((r103 * r109) + 0.5f)) + r104;
        int r111 = r110 + r108;
        if (r104 <= r105) goto L12;
        r111 = r110 - r108;
    L12:
        r101.setFinalHorizontal(r110, r111);
        horizontalSolvingPass(r101, r100, r102);
        return;
    L5:
        r104 = r106;
        r105 = r107;
        goto L6
    }

    private static void solveVerticalMatchConstraint(ConstraintWidget r100, BasicMeasure.Measurer r101, ConstraintWidget r102) {
        float r103 = r102.getVerticalBiasPercent();
        int r104 = r102.mTop.mTarget.getFinalValue() + r102.mTop.getMargin();
        int r105 = r102.mBottom.mTarget.getFinalValue() - r102.mBottom.getMargin();
        if (r105 < r104) goto L20;
        int r106 = r102.getHeight();
        if (r102.getVisibility() == 8) goto L18;
        int r107 = r102.mMatchConstraintDefaultHeight;
        if (r107 == 2) goto L9;
        if (r107 != 0) goto L15;
        r106 = r105 - r104;
    L15:
        r106 = Math.max(r102.mMatchConstraintMinHeight, r106);
        int r108 = r102.mMatchConstraintMaxHeight;
        if (r108 <= 0) goto L18;
        r106 = Math.min(r108, r106);
        goto L18
    L9:
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L11;
        int r109 = r100.getHeight();
    L12:
        r106 = (int) ((r103 * 0.5f) * r109);
        goto L15
    L11:
        r109 = r100.getParent().getHeight();
    L18:
        int r110 = r104 + ((int) ((r103 * ((r105 - r104) - r106)) + 0.5f));
        r102.setFinalVertical(r110, r106 + r110);
        verticalSolvingPass(r102, r101);
        return;
    }

    private static void solveBarrier(Barrier r100, BasicMeasure.Measurer r101, int r102, boolean r103) {
        if (r100.allSolved() == false) goto L8;
        if (r102 != 0) goto L6;
        horizontalSolvingPass(r100, r101, r103);
        return;
    L6:
        verticalSolvingPass(r100, r101);
        return;
    }

    private static void solveHorizontalMatchConstraint(ConstraintWidget r100, BasicMeasure.Measurer r101, ConstraintWidget r102, boolean r110) {
        float r103 = r102.getHorizontalBiasPercent();
        int r104 = r102.mLeft.mTarget.getFinalValue() + r102.mLeft.getMargin();
        int r105 = r102.mRight.mTarget.getFinalValue() - r102.mRight.getMargin();
        if (r105 < r104) goto L20;
        int r106 = r102.getWidth();
        if (r102.getVisibility() == 8) goto L18;
        int r107 = r102.mMatchConstraintDefaultWidth;
        if (r107 == 2) goto L9;
        if (r107 != 0) goto L15;
        r106 = r105 - r104;
    L15:
        r106 = Math.max(r102.mMatchConstraintMinWidth, r106);
        int r108 = r102.mMatchConstraintMaxWidth;
        if (r108 <= 0) goto L18;
        r106 = Math.min(r108, r106);
        goto L18
    L9:
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L11;
        int r109 = r100.getWidth();
    L12:
        r106 = (int) ((r102.getHorizontalBiasPercent() * 0.5f) * r109);
        goto L15
    L11:
        r109 = r100.getParent().getWidth();
    L18:
        int r111 = r104 + ((int) ((r103 * ((r105 - r104) - r106)) + 0.5f));
        r102.setFinalHorizontal(r111, r106 + r111);
        horizontalSolvingPass(r102, r101, r110);
        return;
    }

    public static boolean solveChain(ConstraintWidgetContainer r110, LinearSystem r111, int r210, int r211, ChainHead r212, boolean r213, boolean r214, boolean r215) {
        if (r215 == false) goto L5;
        return false;
    L5:
        if (r210 != 0) goto L10;
        if (r110.isResolvedHorizontally() == true) goto L12;
        return false;
    L12:
        boolean r100 = r110.isRtl();
        ConstraintWidget r101 = r212.getFirst();
        ConstraintWidget r102 = r212.getLast();
        ConstraintWidget r103 = r212.getFirstVisibleWidget();
        ConstraintWidget r104 = r212.getLastVisibleWidget();
        ConstraintWidget r105 = r212.getHead();
        ConstraintAnchor r106 = r101.mListAnchors[r211];
        int r107 = r211 + 1;
        ConstraintAnchor r108 = r102.mListAnchors[r107];
        ConstraintAnchor r109 = r106.mTarget;
        if (r109 != null) goto L15;
        return false;
    L15:
        if (r108.mTarget != null) goto L18;
        return false;
    L18:
        if (r109.hasFinalValue() == true) goto L20;
        return false;
    L20:
        if (r108.mTarget.hasFinalValue() == false) goto L137;
        if (r103 == null) goto L135;
        if (r104 == null) goto L138;
        int r112 = r106.mTarget.getFinalValue() + r103.mListAnchors[r211].getMargin();
        int r113 = r108.mTarget.getFinalValue() - r104.mListAnchors[r107].getMargin();
        int r114 = r113 - r112;
        if (r114 > 0) goto L28;
        return false;
    L28:
        BasicMeasure.Measure r115 = new BasicMeasure.Measure();
        ConstraintWidget r116 = r101;
        boolean r117 = false;
        int r118 = 0;
        int r119 = 0;
        int r120 = 0;
    L29:
        ConstraintWidget r121 = null;
        if (r117 == true) goto L61;
        ConstraintAnchor r122 = r116.mListAnchors[r211];
        if (canMeasure(r116) == false) goto L33;
        ConstraintWidget r123 = r101;
        if (r116.mListDimensionBehaviors[r210] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        if (r116.isMeasureRequested() == false) goto L42;
        ConstraintWidgetContainer.measure(r116, r110.getMeasurer(), r115, BasicMeasure.Measure.SELF_DIMENSIONS);
    L42:
        int r124 = r120 + r116.mListAnchors[r211].getMargin();
        if (r210 != 0) goto L45;
        int r125 = r116.getWidth();
    L46:
        r120 = (r124 + r125) + r116.mListAnchors[r107].getMargin();
        r119 = r119 + 1;
        if (r116.getVisibility() == 8) goto L49;
        r118 = r118 + 1;
    L49:
        ConstraintAnchor r126 = r116.mListAnchors[r107].mTarget;
        if (r126 == null) goto L57;
        ConstraintWidget r127 = r126.mOwner;
        ConstraintAnchor r128 = r127.mListAnchors[r211].mTarget;
        if (r128 == null) goto L57;
        if (r128.mOwner != r116) goto L57;
        r121 = r127;
    L57:
        if (r121 == null) goto L59;
        r116 = r121;
    L60:
        r101 = r123;
        goto L29
    L59:
        r117 = true;
        goto L60
    L45:
        r125 = r116.getHeight();
        goto L46
    L37:
        return false;
    L33:
        return false;
    L61:
        ConstraintWidget r129 = r101;
        if (r118 != 0) goto L66;
        return false;
    L66:
        if (r118 == r119) goto L68;
        return false;
    L68:
        if (r114 >= r120) goto L70;
        return false;
    L70:
        int r130 = r114 - r120;
        if (r213 == false) goto L74;
        r130 = r130 / (r118 + 1);
    L73:
        int r131 = 1;
    L77:
        if (r118 != r131) goto L87;
        if (r210 != 0) goto L80;
        float r132 = r105.getHorizontalBiasPercent();
    L81:
        int r133 = (int) ((r112 + 0.5f) + (r130 * r132));
        if (r210 != 0) goto L84;
        r103.setFinalHorizontal(r133, r103.getWidth() + r133);
    L85:
        horizontalSolvingPass(r103, r110.getMeasurer(), r100);
        return true;
    L84:
        r103.setFinalVertical(r133, r103.getHeight() + r133);
        goto L85
    L80:
        r132 = r105.getVerticalBiasPercent();
        goto L81
    L87:
        if (r213 == false) goto L111;
        int r134 = r112 + r130;
        ConstraintWidget r135 = r129;
        boolean r136 = false;
    L89:
        if (r136 == true) goto L120;
        ConstraintAnchor r137 = r135.mListAnchors[r211];
        if (r135.getVisibility() != 8) goto L96;
        if (r210 != 0) goto L94;
        r135.setFinalHorizontal(r134, r134);
        horizontalSolvingPass(r135, r110.getMeasurer(), r100);
    L101:
        r135.addToSolver(r111, false);
        ConstraintAnchor r138 = r135.mListAnchors[r107].mTarget;
        if (r138 == null) goto L107;
        ConstraintWidget r139 = r138.mOwner;
        ConstraintAnchor r140 = r139.mListAnchors[r211].mTarget;
        if (r140 == null) goto L107;
        if (r140.mOwner != r135) goto L107;
    L108:
        if (r139 != null) goto L109;
        r136 = true;
        goto L89
    L109:
        r135 = r139;
    L107:
        r139 = null;
        goto L108
    L94:
        r135.setFinalVertical(r134, r134);
        verticalSolvingPass(r135, r110.getMeasurer());
        goto L101
    L96:
        int r141 = r134 + r135.mListAnchors[r211].getMargin();
        if (r210 != 0) goto L99;
        r135.setFinalHorizontal(r141, r135.getWidth() + r141);
        horizontalSolvingPass(r135, r110.getMeasurer(), r100);
        int r142 = r135.getWidth();
    L100:
        r134 = ((r141 + r142) + r135.mListAnchors[r107].getMargin()) + r130;
        goto L101
    L99:
        r135.setFinalVertical(r141, r135.getHeight() + r141);
        verticalSolvingPass(r135, r110.getMeasurer());
        r142 = r135.getHeight();
    L120:
        return true;
    L111:
        if (r214 == false) goto L120;
        if (r118 != 2) goto L118;
        if (r210 != 0) goto L115;
        r103.setFinalHorizontal(r112, r103.getWidth() + r112);
        r104.setFinalHorizontal(r113 - r104.getWidth(), r113);
        horizontalSolvingPass(r103, r110.getMeasurer(), r100);
        horizontalSolvingPass(r104, r110.getMeasurer(), r100);
        return true;
    L115:
        r103.setFinalVertical(r112, r103.getHeight() + r112);
        r104.setFinalVertical(r113 - r104.getHeight(), r113);
        verticalSolvingPass(r103, r110.getMeasurer());
        verticalSolvingPass(r104, r110.getMeasurer());
        return true;
    L118:
        return false;
    L74:
        if (r214 == false) goto L73;
        if (r118 <= 2) goto L73;
        r131 = 1;
        r130 = (r130 / r118) - 1;
        goto L77
    L138:
        return false;
    L135:
        return false;
    L137:
        return false;
    L10:
        if (r110.isResolvedVertically() == true) goto L12;
        return false;
    }
}
