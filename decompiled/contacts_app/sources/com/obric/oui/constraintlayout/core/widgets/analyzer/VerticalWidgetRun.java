package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes3.dex */
public class VerticalWidgetRun extends WidgetRun {
    private static final boolean FORCE_USE = true;
    public DependencyNode baseline;
    DimensionDependency mBaselineDimension;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r0;
            r0[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public VerticalWidgetRun(ConstraintWidget r2) {
        super(r2);
        this.baseline = new DependencyNode(this);
        this.mBaselineDimension = null;
        DependencyNode r3 = this.start;
        r3.mType = DependencyNode.Type.TOP;
        DependencyNode r4 = this.end;
        r4.mType = DependencyNode.Type.BOTTOM;
        DependencyNode r5 = this.baseline;
        r5.mType = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    public String toString() {
        return "VerticalRun " + this.mWidget.getDebugName();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.mDimension.clear();
        this.mResolved = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.mResolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.mDimension.resolved = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.mWidget.mMatchConstraintDefaultHeight != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r7) {
        int r0 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        updateRunCenter(r7, this.mWidget.mTop, this.mWidget.mBottom, 1);
        return;
    L12:
        if (this.mDimension.readyToSolve == false) goto L40;
        if (this.mDimension.resolved == true) goto L40;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L40;
        int r8 = this.mWidget.mMatchConstraintDefaultHeight;
        if (r8 == 2) goto L34;
        if (r8 != 3) goto L40;
        if (this.mWidget.mHorizontalRun.mDimension.resolved == false) goto L40;
        int r9 = this.mWidget.getDimensionRatioSide();
        if (r9 == (-1)) goto L30;
        if (r9 == 0) goto L29;
        if (r9 == 1) goto L28;
        int r10 = 0;
    L33:
        this.mDimension.resolve(r10);
        goto L40
    L28:
        float r11 = this.mWidget.mHorizontalRun.mDimension.value;
        float r1 = this.mWidget.getDimensionRatio();
    L31:
        float r12 = r11 / r1;
    L32:
        r10 = (int) (r12 + 0.5f);
        goto L33
    L29:
        r12 = this.mWidget.mHorizontalRun.mDimension.value * this.mWidget.getDimensionRatio();
        goto L32
    L30:
        r11 = this.mWidget.mHorizontalRun.mDimension.value;
        r1 = this.mWidget.getDimensionRatio();
        goto L31
    L34:
        ConstraintWidget r13 = this.mWidget.getParent();
        if (r13 == null) goto L40;
        if (r13.mVerticalRun.mDimension.resolved == false) goto L40;
        this.mDimension.resolve((int) ((r13.mVerticalRun.mDimension.value * this.mWidget.mMatchConstraintPercentHeight) + 0.5f));
    L40:
        if (this.start.readyToSolve == true) goto L42;
        return;
    L42:
        if (this.end.readyToSolve == true) goto L45;
        return;
    L45:
        if (this.start.resolved == false) goto L52;
        if (this.end.resolved == false) goto L52;
        if (this.mDimension.resolved == false) goto L52;
        return;
    L52:
        if (this.mDimension.resolved == true) goto L62;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (this.mWidget.mMatchConstraintDefaultWidth != 0) goto L62;
        if (this.mWidget.isInVerticalChain() == true) goto L62;
        DependencyNode r14 = this.start.mTargets.get(0);
        DependencyNode r2 = this.end.mTargets.get(0);
        int r15 = r14.value + this.start.mMargin;
        int r3 = r2.value + this.end.mMargin;
        this.start.resolve(r15);
        this.end.resolve(r3);
        this.mDimension.resolve(r3 - r15);
        return;
    L62:
        if (this.mDimension.resolved == true) goto L76;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        if (this.matchConstraintsType != 1) goto L76;
        if (this.start.mTargets.size() <= 0) goto L76;
        if (this.end.mTargets.size() <= 0) goto L76;
        DependencyNode r16 = this.start.mTargets.get(0);
        DependencyNode r4 = this.end.mTargets.get(0);
        int r5 = (r4.value + this.end.mMargin) - (r16.value + this.start.mMargin);
        if (r5 >= this.mDimension.wrapValue) goto L74;
        this.mDimension.resolve(r5);
        goto L76
    L74:
        this.mDimension.resolve(this.mDimension.wrapValue);
    L76:
        if (this.mDimension.resolved == true) goto L79;
        return;
    L79:
        if (this.start.mTargets.size() > 0) goto L81;
        return;
    L81:
        if (this.end.mTargets.size() <= 0) goto L89;
        DependencyNode r17 = this.start.mTargets.get(0);
        DependencyNode r6 = this.end.mTargets.get(0);
        int r18 = r17.value + this.start.mMargin;
        int r19 = r6.value + this.end.mMargin;
        float r20 = this.mWidget.getVerticalBiasPercent();
        if (r17 != r6) goto L85;
        r18 = r17.value;
        r19 = r6.value;
        r20 = 0.5f;
    L85:
        this.start.resolve((int) ((r18 + 0.5f) + (((r19 - r18) - this.mDimension.value) * r20)));
        this.end.resolve(this.start.value + this.mDimension.value);
        return;
    L89:
        return;
    L9:
        updateRunEnd(r7);
        goto L12
    L10:
        updateRunStart(r7);
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (this.mWidget.measured == false) goto L6;
        this.mDimension.resolve(this.mWidget.getHeight());
    L6:
        if (this.mDimension.resolved == true) goto L24;
        this.mDimensionBehavior = this.mWidget.getVerticalDimensionBehaviour();
        if (this.mWidget.hasBaseline() == false) goto L11;
        this.mBaselineDimension = new BaselineDimensionDependency(this);
    L11:
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r0 = this.mWidget.getParent();
        if (r0 == null) goto L21;
        if (r0.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r1 = (r0.getHeight() - this.mWidget.mTop.getMargin()) - this.mWidget.mBottom.getMargin();
        addTarget(this.start, r0.mVerticalRun.start, this.mWidget.mTop.getMargin());
        addTarget(this.end, r0.mVerticalRun.end, -this.mWidget.mBottom.getMargin());
        this.mDimension.resolve(r1);
        return;
    L21:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.mDimension.resolve(this.mWidget.getHeight());
    L32:
        if (this.mDimension.resolved == false) goto L82;
        if (this.mWidget.measured == false) goto L82;
        if (this.mWidget.mListAnchors[2].mTarget == null) goto L53;
        if (this.mWidget.mListAnchors[3].mTarget == null) goto L53;
        if (this.mWidget.isInVerticalChain() == false) goto L42;
        DependencyNode r2 = this.start;
        r2.mMargin = this.mWidget.mListAnchors[2].getMargin();
        DependencyNode r3 = this.end;
        r3.mMargin = -this.mWidget.mListAnchors[3].getMargin();
    L50:
        if (this.mWidget.hasBaseline() == false) goto L160;
        addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
        return;
    L160:
        return;
    L42:
        DependencyNode r4 = getTarget(this.mWidget.mListAnchors[2]);
        if (r4 == null) goto L45;
        addTarget(this.start, r4, this.mWidget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r5 = getTarget(this.mWidget.mListAnchors[3]);
        if (r5 == null) goto L48;
        addTarget(this.end, r5, -this.mWidget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L53:
        if (this.mWidget.mListAnchors[2].mTarget == null) goto L60;
        DependencyNode r6 = getTarget(this.mWidget.mListAnchors[2]);
        if (r6 == null) goto L162;
        addTarget(this.start, r6, this.mWidget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.mDimension.value);
        if (this.mWidget.hasBaseline() == false) goto L163;
        addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
        return;
    L163:
        return;
    L162:
        return;
    L60:
        if (this.mWidget.mListAnchors[3].mTarget == null) goto L68;
        DependencyNode r7 = getTarget(this.mWidget.mListAnchors[3]);
        if (r7 == null) goto L65;
        addTarget(this.end, r7, -this.mWidget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.mDimension.value);
    L65:
        if (this.mWidget.hasBaseline() == false) goto L165;
        addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
        return;
    L165:
        return;
    L68:
        if (this.mWidget.mListAnchors[4].mTarget == null) goto L73;
        DependencyNode r8 = getTarget(this.mWidget.mListAnchors[4]);
        if (r8 == null) goto L167;
        addTarget(this.baseline, r8, 0);
        addTarget(this.start, this.baseline, -this.mWidget.getBaselineDistance());
        addTarget(this.end, this.start, this.mDimension.value);
        return;
    L167:
        return;
    L73:
        if ((this.mWidget instanceof Helper) == false) goto L75;
        return;
    L75:
        if (this.mWidget.getParent() != null) goto L77;
        return;
    L77:
        if (this.mWidget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L171;
        DependencyNode r9 = this.mWidget.getParent().mVerticalRun.start;
        addTarget(this.start, r9, this.mWidget.getY());
        addTarget(this.end, this.start, this.mDimension.value);
        if (this.mWidget.hasBaseline() == false) goto L172;
        addTarget(this.baseline, this.start, this.mWidget.getBaselineDistance());
        return;
    L172:
        return;
    L171:
        return;
    L82:
        if (this.mDimension.resolved == false) goto L84;
    L99:
        this.mDimension.addDependency(this);
    L101:
        if (this.mWidget.mListAnchors[2].mTarget == null) goto L117;
        if (this.mWidget.mListAnchors[3].mTarget == null) goto L117;
        if (this.mWidget.isInVerticalChain() == false) goto L107;
        DependencyNode r10 = this.start;
        r10.mMargin = this.mWidget.mListAnchors[2].getMargin();
        DependencyNode r11 = this.end;
        r11.mMargin = -this.mWidget.mListAnchors[3].getMargin();
    L114:
        if (this.mWidget.hasBaseline() == false) goto L157;
        addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
    L157:
        if (this.mDimension.mTargets.size() != 0) goto L174;
        this.mDimension.readyToSolve = true;
        return;
    L174:
        return;
    L107:
        DependencyNode r12 = getTarget(this.mWidget.mListAnchors[2]);
        DependencyNode r13 = getTarget(this.mWidget.mListAnchors[3]);
        if (r12 == null) goto L110;
        r12.addDependency(this);
    L110:
        if (r13 == null) goto L112;
        r13.addDependency(this);
    L112:
        this.mRunType = WidgetRun.RunType.CENTER;
    L117:
        if (this.mWidget.mListAnchors[2].mTarget == null) goto L131;
        DependencyNode r14 = getTarget(this.mWidget.mListAnchors[2]);
        if (r14 == null) goto L157;
        addTarget(this.start, r14, this.mWidget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.mDimension);
        if (this.mWidget.hasBaseline() == false) goto L124;
        addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
    L124:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        if (this.mWidget.getDimensionRatio() <= 0.0f) goto L157;
        if (this.mWidget.mHorizontalRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        this.mWidget.mHorizontalRun.mDimension.mDependencies.add(this.mDimension);
        this.mDimension.mTargets.add(this.mWidget.mHorizontalRun.mDimension);
        this.mDimension.updateDelegate = this;
        goto L157
    L131:
        if (this.mWidget.mListAnchors[3].mTarget == null) goto L138;
        DependencyNode r15 = getTarget(this.mWidget.mListAnchors[3]);
        if (r15 == null) goto L157;
        addTarget(this.end, r15, -this.mWidget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.mDimension);
        if (this.mWidget.hasBaseline() == false) goto L157;
        addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
        goto L157
    L138:
        if (this.mWidget.mListAnchors[4].mTarget == null) goto L143;
        DependencyNode r16 = getTarget(this.mWidget.mListAnchors[4]);
        if (r16 == null) goto L157;
        addTarget(this.baseline, r16, 0);
        addTarget(this.start, this.baseline, -1, this.mBaselineDimension);
        addTarget(this.end, this.start, 1, this.mDimension);
        goto L157
    L143:
        if ((this.mWidget instanceof Helper) == true) goto L157;
        if (this.mWidget.getParent() == null) goto L157;
        DependencyNode r17 = this.mWidget.getParent().mVerticalRun.start;
        addTarget(this.start, r17, this.mWidget.getY());
        addTarget(this.end, this.start, 1, this.mDimension);
        if (this.mWidget.hasBaseline() == false) goto L150;
        addTarget(this.baseline, this.start, 1, this.mBaselineDimension);
    L150:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        if (this.mWidget.getDimensionRatio() <= 0.0f) goto L157;
        if (this.mWidget.mHorizontalRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        this.mWidget.mHorizontalRun.mDimension.mDependencies.add(this.mDimension);
        this.mDimension.mTargets.add(this.mWidget.mHorizontalRun.mDimension);
        this.mDimension.updateDelegate = this;
        goto L157
    L84:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L99;
        int r18 = this.mWidget.mMatchConstraintDefaultHeight;
        if (r18 == 2) goto L95;
        if (r18 != 3) goto L101;
        if (this.mWidget.isInVerticalChain() == true) goto L101;
        if (this.mWidget.mMatchConstraintDefaultWidth == 3) goto L101;
        DimensionDependency r19 = this.mWidget.mHorizontalRun.mDimension;
        this.mDimension.mTargets.add(r19);
        r19.mDependencies.add(this.mDimension);
        this.mDimension.delegateToWidgetRun = true;
        this.mDimension.mDependencies.add(this.start);
        this.mDimension.mDependencies.add(this.end);
        goto L101
    L95:
        ConstraintWidget r20 = this.mWidget.getParent();
        if (r20 == null) goto L101;
        DimensionDependency r21 = r20.mVerticalRun.mDimension;
        this.mDimension.mTargets.add(r21);
        r21.mDependencies.add(this.mDimension);
        this.mDimension.delegateToWidgetRun = true;
        this.mDimension.mDependencies.add(this.start);
        this.mDimension.mDependencies.add(this.end);
        goto L101
    L24:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        ConstraintWidget r22 = this.mWidget.getParent();
        if (r22 == null) goto L32;
        if (r22.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        addTarget(this.start, r22.mVerticalRun.start, this.mWidget.mTop.getMargin());
        addTarget(this.end, r22.mVerticalRun.end, -this.mWidget.mBottom.getMargin());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved == false) goto L6;
        this.mWidget.setY(this.start.value);
        return;
    }
}
