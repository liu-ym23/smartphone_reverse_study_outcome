package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes3.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r100 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = r100;
            r100[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r100 = this.widget;
        if (r100.measured == false) goto L6;
        this.dimension.resolve(r100.getHeight());
    L6:
        if (this.dimension.resolved == true) goto L24;
        this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
        if (this.widget.hasBaseline() == false) goto L10;
        this.baselineDimension = new BaselineDimensionDependency(this);
    L10:
        ConstraintWidget.DimensionBehaviour r101 = this.dimensionBehavior;
        if (r101 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        DimensionDependency r102 = this.dimension;
        boolean r103 = r102.resolved;
        if (r103 == false) goto L80;
        ConstraintWidget r104 = this.widget;
        if (r104.measured == false) goto L80;
        ConstraintAnchor[] r105 = r104.mListAnchors;
        ConstraintAnchor r106 = r105[2];
        ConstraintAnchor r107 = r106.mTarget;
        if (r107 != null) goto L38;
    L52:
        if (r107 == null) goto L58;
        DependencyNode r108 = getTarget(r106);
        if (r108 == null) goto L155;
        addTarget(this.start, r108, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L156;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L156:
        return;
    L155:
        return;
    L58:
        ConstraintAnchor r109 = r105[3];
        if (r109.mTarget == null) goto L66;
        DependencyNode r110 = getTarget(r109);
        if (r110 == null) goto L64;
        addTarget(this.end, r110, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L64:
        if (this.widget.hasBaseline() == false) goto L158;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L158:
        return;
    L66:
        ConstraintAnchor r111 = r105[4];
        if (r111.mTarget == null) goto L72;
        DependencyNode r112 = getTarget(r111);
        if (r112 == null) goto L160;
        addTarget(this.baseline, r112, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L160:
        return;
    L72:
        if ((r104 instanceof Helper) == false) goto L74;
        return;
    L74:
        if (r104.getParent() != null) goto L76;
        return;
    L76:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L164;
        DependencyNode r113 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r113, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L165;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L165:
        return;
    L164:
        return;
    L38:
        if (r105[3].mTarget == null) goto L52;
        if (r104.isInVerticalChain() == false) goto L42;
        DependencyNode r114 = this.start;
        r114.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r115 = this.end;
        r115.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L153;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L153:
        return;
    L42:
        DependencyNode r116 = getTarget(this.widget.mListAnchors[2]);
        if (r116 == null) goto L45;
        addTarget(this.start, r116, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r117 = getTarget(this.widget.mListAnchors[3]);
        if (r117 == null) goto L48;
        addTarget(this.end, r117, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L80:
        if (r103 == false) goto L82;
    L97:
        r102.addDependency(this);
    L98:
        ConstraintWidget r118 = this.widget;
        ConstraintAnchor[] r119 = r118.mListAnchors;
        ConstraintAnchor r120 = r119[2];
        ConstraintAnchor r121 = r120.mTarget;
        if (r121 == null) goto L110;
        if (r119[3].mTarget == null) goto L110;
        if (r118.isInVerticalChain() == false) goto L105;
        DependencyNode r122 = this.start;
        r122.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r123 = this.end;
        r123.margin = -this.widget.mListAnchors[3].getMargin();
    L107:
        if (this.widget.hasBaseline() == false) goto L150;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L150:
        if (this.dimension.targets.size() != 0) goto L167;
        this.dimension.readyToSolve = true;
        return;
    L167:
        return;
    L105:
        DependencyNode r124 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r125 = getTarget(this.widget.mListAnchors[3]);
        r124.addDependency(this);
        r125.addDependency(this);
        this.mRunType = WidgetRun.RunType.CENTER;
    L110:
        if (r121 == null) goto L123;
        DependencyNode r126 = getTarget(r120);
        if (r126 == null) goto L150;
        addTarget(this.start, r126, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L116;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L116:
        ConstraintWidget.DimensionBehaviour r127 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r128 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r127 != r128) goto L150;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L150;
        HorizontalWidgetRun r129 = this.widget.horizontalRun;
        if (r129.dimensionBehavior != r128) goto L150;
        r129.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L150
    L123:
        ConstraintAnchor r130 = r119[3];
        if (r130.mTarget == null) goto L130;
        DependencyNode r131 = getTarget(r130);
        if (r131 == null) goto L150;
        addTarget(this.end, r131, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L150;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
        goto L150
    L130:
        ConstraintAnchor r132 = r119[4];
        if (r132.mTarget == null) goto L136;
        DependencyNode r133 = getTarget(r132);
        if (r133 == null) goto L150;
        addTarget(this.baseline, r133, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        addTarget(this.end, this.start, 1, this.dimension);
        goto L150
    L136:
        if ((r118 instanceof Helper) == true) goto L150;
        if (r118.getParent() == null) goto L150;
        DependencyNode r134 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r134, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L142;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L142:
        ConstraintWidget.DimensionBehaviour r135 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r136 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r135 != r136) goto L150;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L150;
        HorizontalWidgetRun r137 = this.widget.horizontalRun;
        if (r137.dimensionBehavior != r136) goto L150;
        r137.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L150
    L82:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        ConstraintWidget r138 = this.widget;
        int r139 = r138.mMatchConstraintDefaultHeight;
        if (r139 == 2) goto L93;
        if (r139 != 3) goto L98;
        if (r138.isInVerticalChain() == true) goto L98;
        ConstraintWidget r140 = this.widget;
        if (r140.mMatchConstraintDefaultWidth == 3) goto L98;
        DimensionDependency r141 = r140.horizontalRun.dimension;
        this.dimension.targets.add(r141);
        r141.dependencies.add(this.dimension);
        DimensionDependency r142 = this.dimension;
        r142.delegateToWidgetRun = true;
        r142.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L98
    L93:
        ConstraintWidget r143 = r138.getParent();
        if (r143 == null) goto L98;
        DimensionDependency r144 = r143.verticalRun.dimension;
        this.dimension.targets.add(r144);
        r144.dependencies.add(this.dimension);
        DimensionDependency r145 = this.dimension;
        r145.delegateToWidgetRun = true;
        r145.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L98
    L13:
        if (r101 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r146 = this.widget.getParent();
        if (r146 == null) goto L21;
        if (r146.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r147 = (r146.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r146.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r146.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r147);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.dimension.resolve(this.widget.getHeight());
        goto L31
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r148 = this.widget.getParent();
        if (r148 == null) goto L31;
        if (r148.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        addTarget(this.start, r148.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r148.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r100 = this.start;
        if (r100.resolved == false) goto L6;
        this.widget.setY(r100.value);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.widget.mMatchConstraintDefaultHeight != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    public VerticalWidgetRun(ConstraintWidget r100) {
        super(r100);
        DependencyNode r101 = new DependencyNode(this);
        this.baseline = r101;
        this.baselineDimension = null;
        DependencyNode r102 = this.start;
        r102.type = DependencyNode.Type.TOP;
        DependencyNode r103 = this.end;
        r103.type = DependencyNode.Type.BOTTOM;
        r101.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r100) {
        int r101 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L9;
        if (r101 != 3) goto L11;
        ConstraintWidget r102 = this.widget;
        updateRunCenter(r100, r102.mTop, r102.mBottom, 1);
        return;
    L11:
        DimensionDependency r103 = this.dimension;
        if (r103.readyToSolve == true) goto L14;
    L39:
        DependencyNode r104 = this.start;
        if (r104.readyToSolve == false) goto L87;
        DependencyNode r105 = this.end;
        if (r105.readyToSolve == true) goto L45;
        return;
    L45:
        if (r104.resolved == false) goto L52;
        if (r105.resolved == false) goto L52;
        if (this.dimension.resolved == false) goto L52;
        return;
    L52:
        if (this.dimension.resolved == true) goto L62;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        ConstraintWidget r106 = this.widget;
        if (r106.mMatchConstraintDefaultWidth != 0) goto L62;
        if (r106.isInVerticalChain() == true) goto L62;
        DependencyNode r107 = (DependencyNode) ListProtector.get(this.start.targets, 0);
        DependencyNode r108 = (DependencyNode) ListProtector.get(this.end.targets, 0);
        int r109 = r107.value;
        DependencyNode r110 = this.start;
        int r111 = r109 + r110.margin;
        int r112 = r108.value + this.end.margin;
        r110.resolve(r111);
        this.end.resolve(r112);
        this.dimension.resolve(r112 - r111);
        return;
    L62:
        if (this.dimension.resolved == true) goto L76;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        if (this.matchConstraintsType != 1) goto L76;
        if (this.start.targets.size() <= 0) goto L76;
        if (this.end.targets.size() <= 0) goto L76;
        DependencyNode r113 = (DependencyNode) ListProtector.get(this.start.targets, 0);
        DependencyNode r114 = (DependencyNode) ListProtector.get(this.end.targets, 0);
        int r115 = (r114.value + this.end.margin) - (r113.value + this.start.margin);
        DimensionDependency r116 = this.dimension;
        int r117 = r116.wrapValue;
        if (r115 >= r117) goto L74;
        r116.resolve(r115);
        goto L76
    L74:
        r116.resolve(r117);
    L76:
        if (this.dimension.resolved == true) goto L79;
        return;
    L79:
        if (this.start.targets.size() > 0) goto L81;
        return;
    L81:
        if (this.end.targets.size() <= 0) goto L89;
        DependencyNode r118 = (DependencyNode) ListProtector.get(this.start.targets, 0);
        DependencyNode r119 = (DependencyNode) ListProtector.get(this.end.targets, 0);
        int r120 = r118.value + this.start.margin;
        int r121 = r119.value + this.end.margin;
        float r122 = this.widget.getVerticalBiasPercent();
        if (r118 != r119) goto L85;
        r120 = r118.value;
        r121 = r119.value;
        r122 = 0.5f;
    L85:
        this.start.resolve((int) ((r120 + 0.5f) + (((r121 - r120) - this.dimension.value) * r122)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L89:
        return;
    L87:
        return;
    L14:
        if (r103.resolved == true) goto L39;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        ConstraintWidget r123 = this.widget;
        int r124 = r123.mMatchConstraintDefaultHeight;
        if (r124 == 2) goto L34;
        if (r124 != 3) goto L39;
        if (r123.horizontalRun.dimension.resolved == false) goto L39;
        int r125 = r123.getDimensionRatioSide();
        if (r125 == (-1)) goto L30;
        if (r125 == 0) goto L29;
        if (r125 == 1) goto L28;
        int r126 = 0;
    L33:
        this.dimension.resolve(r126);
        goto L39
    L28:
        ConstraintWidget r127 = this.widget;
        float r128 = r127.horizontalRun.dimension.value;
        float r129 = r127.getDimensionRatio();
    L31:
        float r130 = r128 / r129;
    L32:
        r126 = (int) (r130 + 0.5f);
        goto L33
    L29:
        ConstraintWidget r131 = this.widget;
        r130 = r131.horizontalRun.dimension.value * r131.getDimensionRatio();
        goto L32
    L30:
        ConstraintWidget r132 = this.widget;
        r128 = r132.horizontalRun.dimension.value;
        r129 = r132.getDimensionRatio();
        goto L31
    L34:
        ConstraintWidget r133 = r123.getParent();
        if (r133 == null) goto L39;
        DimensionDependency r134 = r133.verticalRun.dimension;
        if (r134.resolved == false) goto L39;
        this.dimension.resolve((int) ((r134.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
        goto L39
    L9:
        updateRunEnd(r100);
        goto L11
    L10:
        updateRunStart(r100);
        goto L11
    }
}
