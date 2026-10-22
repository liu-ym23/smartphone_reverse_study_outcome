package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    static {
        tempDimensions = new int[2];
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r100 = this.widget;
        if (r100.measured == false) goto L6;
        this.dimension.resolve(r100.getWidth());
    L6:
        if (this.dimension.resolved == true) goto L22;
        ConstraintWidget.DimensionBehaviour r101 = this.widget.getHorizontalDimensionBehaviour();
        this.dimensionBehavior = r101;
        if (r101 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        ConstraintWidget.DimensionBehaviour r102 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r101 != r102) goto L20;
        ConstraintWidget r103 = this.widget.getParent();
        if (r103 == null) goto L16;
        if (r103.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r104 = (r103.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
        addTarget(this.start, r103.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r103.horizontalRun.end, -this.widget.mRight.getMargin());
        this.dimension.resolve(r104);
        return;
    L16:
        if (r103.getHorizontalDimensionBehaviour() == r102) goto L17;
    L20:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getWidth());
    L32:
        DimensionDependency r105 = this.dimension;
        if (r105.resolved == false) goto L67;
        ConstraintWidget r106 = this.widget;
        if (r106.measured == false) goto L67;
        ConstraintAnchor[] r107 = r106.mListAnchors;
        ConstraintAnchor r108 = r107[0];
        ConstraintAnchor r109 = r108.mTarget;
        if (r109 != null) goto L39;
    L50:
        if (r109 == null) goto L54;
        DependencyNode r110 = getTarget(r108);
        if (r110 == null) goto L112;
        addTarget(this.start, r110, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L112:
        return;
    L54:
        ConstraintAnchor r111 = r107[1];
        if (r111.mTarget == null) goto L60;
        DependencyNode r112 = getTarget(r111);
        if (r112 == null) goto L114;
        addTarget(this.end, r112, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
        return;
    L114:
        return;
    L60:
        if ((r106 instanceof Helper) == false) goto L62;
        return;
    L62:
        if (r106.getParent() != null) goto L64;
        return;
    L64:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L118;
        DependencyNode r113 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r113, this.widget.getX());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L118:
        return;
    L39:
        if (r107[1].mTarget == null) goto L50;
        if (r106.isInHorizontalChain() == false) goto L43;
        DependencyNode r114 = this.start;
        r114.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r115 = this.end;
        r115.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L43:
        DependencyNode r116 = getTarget(this.widget.mListAnchors[0]);
        if (r116 == null) goto L46;
        addTarget(this.start, r116, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r117 = getTarget(this.widget.mListAnchors[1]);
        if (r117 == null) goto L49;
        addTarget(this.end, r117, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L67:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L87;
        ConstraintWidget r118 = this.widget;
        int r119 = r118.mMatchConstraintDefaultWidth;
        if (r119 != 2) goto L71;
        ConstraintWidget r120 = r118.getParent();
        if (r120 == null) goto L87;
        DimensionDependency r121 = r120.verticalRun.dimension;
        this.dimension.targets.add(r121);
        r121.dependencies.add(this.dimension);
        DimensionDependency r122 = this.dimension;
        r122.delegateToWidgetRun = true;
        r122.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L87
    L71:
        if (r119 != 3) goto L87;
        if (r118.mMatchConstraintDefaultHeight != 3) goto L82;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        VerticalWidgetRun r123 = r118.verticalRun;
        r123.start.updateDelegate = this;
        r123.end.updateDelegate = this;
        r105.updateDelegate = this;
        if (r118.isInVerticalChain() == false) goto L79;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        VerticalWidgetRun r124 = this.widget.verticalRun;
        r124.dimension.updateDelegate = this;
        this.dimension.targets.add(r124.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        goto L87
    L79:
        if (this.widget.isInHorizontalChain() == false) goto L81;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
        goto L87
    L81:
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        goto L87
    L82:
        DimensionDependency r125 = r118.verticalRun.dimension;
        r105.targets.add(r125);
        r125.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        DimensionDependency r126 = this.dimension;
        r126.delegateToWidgetRun = true;
        r126.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        this.end.targets.add(this.dimension);
    L87:
        ConstraintWidget r127 = this.widget;
        ConstraintAnchor[] r128 = r127.mListAnchors;
        ConstraintAnchor r129 = r128[0];
        ConstraintAnchor r130 = r129.mTarget;
        if (r130 != null) goto L90;
    L95:
        if (r130 == null) goto L99;
        DependencyNode r131 = getTarget(r129);
        if (r131 == null) goto L122;
        addTarget(this.start, r131, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L122:
        return;
    L99:
        ConstraintAnchor r132 = r128[1];
        if (r132.mTarget == null) goto L105;
        DependencyNode r133 = getTarget(r132);
        if (r133 == null) goto L124;
        addTarget(this.end, r133, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        return;
    L124:
        return;
    L105:
        if ((r127 instanceof Helper) == false) goto L107;
        return;
    L107:
        if (r127.getParent() == null) goto L127;
        DependencyNode r134 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r134, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L127:
        return;
    L90:
        if (r128[1].mTarget == null) goto L95;
        if (r127.isInHorizontalChain() == false) goto L94;
        DependencyNode r135 = this.start;
        r135.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r136 = this.end;
        r136.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L94:
        DependencyNode r137 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r138 = getTarget(this.widget.mListAnchors[1]);
        r137.addDependency(this);
        r138.addDependency(this);
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L22:
        ConstraintWidget.DimensionBehaviour r139 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r140 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r139 != r140) goto L32;
        ConstraintWidget r141 = this.widget.getParent();
        if (r141 == null) goto L29;
        if (r141.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r141.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r141.horizontalRun.end, -this.widget.mRight.getMargin());
        return;
    L29:
        if (r141.getHorizontalDimensionBehaviour() != r140) goto L32;
        goto L30
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r100 = this.start;
        if (r100.resolved == false) goto L6;
        this.widget.setX(r100.value);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    public HorizontalWidgetRun(ConstraintWidget r100) {
        super(r100);
        DependencyNode r101 = this.start;
        r101.type = DependencyNode.Type.LEFT;
        DependencyNode r102 = this.end;
        r102.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r110) {
        int r100 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L9;
        if (r100 != 3) goto L12;
        ConstraintWidget r101 = this.widget;
        updateRunCenter(r110, r101.mLeft, r101.mRight, 0);
        return;
    L12:
        if (this.dimension.resolved == false) goto L14;
    L135:
        DependencyNode r102 = this.start;
        if (r102.readyToSolve == false) goto L187;
        DependencyNode r103 = this.end;
        if (r103.readyToSolve == true) goto L141;
        return;
    L141:
        if (r102.resolved == false) goto L148;
        if (r103.resolved == false) goto L148;
        if (this.dimension.resolved == false) goto L148;
        return;
    L148:
        if (this.dimension.resolved == true) goto L158;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L158;
        ConstraintWidget r104 = this.widget;
        if (r104.mMatchConstraintDefaultWidth != 0) goto L158;
        if (r104.isInHorizontalChain() == true) goto L158;
        DependencyNode r105 = (DependencyNode) ListProtector.get(this.start.targets, 0);
        DependencyNode r106 = (DependencyNode) ListProtector.get(this.end.targets, 0);
        int r107 = r105.value;
        DependencyNode r108 = this.start;
        int r109 = r107 + r108.margin;
        int r111 = r106.value + this.end.margin;
        r108.resolve(r109);
        this.end.resolve(r111);
        this.dimension.resolve(r111 - r109);
        return;
    L158:
        if (this.dimension.resolved == true) goto L172;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L172;
        if (this.matchConstraintsType != 1) goto L172;
        if (this.start.targets.size() <= 0) goto L172;
        if (this.end.targets.size() <= 0) goto L172;
        DependencyNode r112 = (DependencyNode) ListProtector.get(this.start.targets, 0);
        DependencyNode r113 = (DependencyNode) ListProtector.get(this.end.targets, 0);
        int r114 = Math.min((r113.value + this.end.margin) - (r112.value + this.start.margin), this.dimension.wrapValue);
        ConstraintWidget r115 = this.widget;
        int r116 = r115.mMatchConstraintMaxWidth;
        int r117 = Math.max(r115.mMatchConstraintMinWidth, r114);
        if (r116 <= 0) goto L170;
        r117 = Math.min(r116, r117);
    L170:
        this.dimension.resolve(r117);
    L172:
        if (this.dimension.resolved == true) goto L174;
        return;
    L174:
        DependencyNode r118 = (DependencyNode) ListProtector.get(this.start.targets, 0);
        DependencyNode r119 = (DependencyNode) ListProtector.get(this.end.targets, 0);
        int r120 = r118.value + this.start.margin;
        int r121 = r119.value + this.end.margin;
        float r122 = this.widget.getHorizontalBiasPercent();
        if (r118 != r119) goto L177;
        r120 = r118.value;
        r121 = r119.value;
        r122 = 0.5f;
    L177:
        this.start.resolve((int) ((r120 + 0.5f) + (((r121 - r120) - this.dimension.value) * r122)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L187:
        return;
    L14:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L135;
        ConstraintWidget r123 = this.widget;
        int r124 = r123.mMatchConstraintDefaultWidth;
        if (r124 == 2) goto L130;
        if (r124 != 3) goto L135;
        int r125 = r123.mMatchConstraintDefaultHeight;
        if (r125 == 0) goto L34;
        if (r125 == 3) goto L34;
        int r126 = r123.getDimensionRatioSide();
        if (r126 == (-1)) goto L30;
        if (r126 == 0) goto L29;
        if (r126 == 1) goto L28;
        int r127 = 0;
    L33:
        this.dimension.resolve(r127);
        goto L135
    L28:
        ConstraintWidget r128 = this.widget;
        float r129 = r128.verticalRun.dimension.value;
        float r130 = r128.getDimensionRatio();
    L31:
        float r131 = r129 * r130;
    L32:
        r127 = (int) (r131 + 0.5f);
        goto L33
    L29:
        ConstraintWidget r132 = this.widget;
        r131 = r132.verticalRun.dimension.value / r132.getDimensionRatio();
        goto L32
    L30:
        ConstraintWidget r133 = this.widget;
        r129 = r133.verticalRun.dimension.value;
        r130 = r133.getDimensionRatio();
    L34:
        VerticalWidgetRun r134 = r123.verticalRun;
        DependencyNode r135 = r134.start;
        DependencyNode r136 = r134.end;
        if (r123.mLeft.mTarget == null) goto L37;
        boolean r137 = true;
    L39:
        if (r123.mTop.mTarget == null) goto L41;
        boolean r138 = true;
    L43:
        if (r123.mRight.mTarget == null) goto L45;
        boolean r139 = true;
    L47:
        if (r123.mBottom.mTarget == null) goto L49;
        boolean r140 = true;
    L50:
        int r141 = r123.getDimensionRatioSide();
        if (r137 == false) goto L88;
        if (r138 == false) goto L88;
        if (r139 == false) goto L88;
        if (r140 == false) goto L88;
        float r142 = this.widget.getDimensionRatio();
        if (r135.resolved == true) goto L58;
    L66:
        DependencyNode r143 = this.start;
        if (r143.resolved == false) goto L77;
        DependencyNode r144 = this.end;
        if (r144.resolved == false) goto L77;
        if (r135.readyToSolve == true) goto L73;
        return;
    L73:
        if (r136.readyToSolve == false) goto L181;
        computeInsetRatio(tempDimensions, r143.value + r143.margin, r144.value - r144.margin, ((DependencyNode) ListProtector.get(r135.targets, 0)).value + r135.margin, ((DependencyNode) ListProtector.get(r136.targets, 0)).value - r136.margin, r142, r141);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L77
    L181:
        return;
    L77:
        DependencyNode r145 = this.start;
        if (r145.readyToSolve == true) goto L80;
        return;
    L80:
        if (this.end.readyToSolve == true) goto L82;
        return;
    L82:
        if (r135.readyToSolve == true) goto L84;
        return;
    L84:
        if (r136.readyToSolve == false) goto L184;
        computeInsetRatio(tempDimensions, ((DependencyNode) ListProtector.get(r145.targets, 0)).value + this.start.margin, ((DependencyNode) ListProtector.get(this.end.targets, 0)).value - this.end.margin, ((DependencyNode) ListProtector.get(r135.targets, 0)).value + r135.margin, ((DependencyNode) ListProtector.get(r136.targets, 0)).value - r136.margin, r142, r141);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L135
    L184:
        return;
    L58:
        if (r136.resolved == false) goto L66;
        DependencyNode r146 = this.start;
        if (r146.readyToSolve == true) goto L62;
        return;
    L62:
        if (this.end.readyToSolve == false) goto L180;
        computeInsetRatio(tempDimensions, ((DependencyNode) ListProtector.get(r146.targets, 0)).value + this.start.margin, ((DependencyNode) ListProtector.get(this.end.targets, 0)).value - this.end.margin, r135.value + r135.margin, r136.value - r136.margin, r142, r141);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        return;
    L180:
        return;
    L88:
        if (r137 == false) goto L109;
        if (r139 == false) goto L109;
        if (this.start.readyToSolve == true) goto L93;
        return;
    L93:
        if (this.end.readyToSolve == false) goto L185;
        float r147 = this.widget.getDimensionRatio();
        int r148 = ((DependencyNode) ListProtector.get(this.start.targets, 0)).value + this.start.margin;
        int r149 = ((DependencyNode) ListProtector.get(this.end.targets, 0)).value - this.end.margin;
        if (r141 == (-1)) goto L104;
        if (r141 == 0) goto L104;
        if (r141 != 1) goto L135;
        int r150 = getLimitedDimension(r149 - r148, 0);
        int r151 = (int) ((r150 / r147) + 0.5f);
        int r152 = getLimitedDimension(r151, 1);
        if (r151 == r152) goto L103;
        r150 = (int) ((r152 * r147) + 0.5f);
    L103:
        this.dimension.resolve(r150);
        this.widget.verticalRun.dimension.resolve(r152);
    L104:
        int r153 = getLimitedDimension(r149 - r148, 0);
        int r154 = (int) ((r153 * r147) + 0.5f);
        int r155 = getLimitedDimension(r154, 1);
        if (r154 == r155) goto L107;
        r153 = (int) ((r155 / r147) + 0.5f);
    L107:
        this.dimension.resolve(r153);
        this.widget.verticalRun.dimension.resolve(r155);
        goto L135
    L185:
        return;
    L109:
        if (r138 == false) goto L135;
        if (r140 == false) goto L135;
        if (r135.readyToSolve == true) goto L114;
        return;
    L114:
        if (r136.readyToSolve == false) goto L186;
        float r156 = this.widget.getDimensionRatio();
        int r157 = ((DependencyNode) ListProtector.get(r135.targets, 0)).value + r135.margin;
        int r158 = ((DependencyNode) ListProtector.get(r136.targets, 0)).value - r136.margin;
        if (r141 == (-1)) goto L125;
        if (r141 == 0) goto L121;
        if (r141 == 1) goto L125;
    L121:
        int r159 = getLimitedDimension(r158 - r157, 1);
        int r160 = (int) ((r159 * r156) + 0.5f);
        int r161 = getLimitedDimension(r160, 0);
        if (r160 == r161) goto L124;
        r159 = (int) ((r161 / r156) + 0.5f);
    L124:
        this.dimension.resolve(r161);
        this.widget.verticalRun.dimension.resolve(r159);
    L125:
        int r162 = getLimitedDimension(r158 - r157, 1);
        int r163 = (int) ((r162 / r156) + 0.5f);
        int r164 = getLimitedDimension(r163, 0);
        if (r163 == r164) goto L128;
        r162 = (int) ((r164 * r156) + 0.5f);
    L128:
        this.dimension.resolve(r164);
        this.widget.verticalRun.dimension.resolve(r162);
        goto L135
    L186:
        return;
    L49:
        r140 = false;
        goto L50
    L45:
        r139 = false;
        goto L47
    L41:
        r138 = false;
        goto L43
    L37:
        r137 = false;
        goto L39
    L130:
        ConstraintWidget r165 = r123.getParent();
        if (r165 == null) goto L135;
        DimensionDependency r166 = r165.horizontalRun.dimension;
        if (r166.resolved == false) goto L135;
        this.dimension.resolve((int) ((r166.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
        goto L135
    L9:
        updateRunEnd(r110);
        goto L12
    L10:
        updateRunStart(r110);
        goto L12
    }

    private void computeInsetRatio(int[] r100, int r101, int r102, int r103, int r104, float r105, int r106) {
        int r107 = r102 - r101;
        int r108 = r104 - r103;
        if (r106 == (-1)) goto L9;
        if (r106 == 0) goto L8;
        if (r106 != 1) goto L19;
        r100[0] = r107;
        r100[1] = (int) ((r107 * r105) + 0.5f);
        return;
    L19:
        return;
    L8:
        r100[0] = (int) ((r108 * r105) + 0.5f);
        r100[1] = r108;
        return;
    L9:
        int r109 = (int) ((r108 * r105) + 0.5f);
        int r110 = (int) ((r107 / r105) + 0.5f);
        if (r109 > r107) goto L12;
        r100[0] = r109;
        r100[1] = r108;
        return;
    L12:
        if (r110 > r108) goto L18;
        r100[0] = r107;
        r100[1] = r110;
        return;
    }
}
