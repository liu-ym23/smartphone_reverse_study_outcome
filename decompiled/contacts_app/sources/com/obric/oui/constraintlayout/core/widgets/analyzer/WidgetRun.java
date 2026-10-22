package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.android.vcard.VCardConstants;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WidgetRun implements Dependency {
    public DependencyNode end;
    DimensionDependency mDimension;
    protected ConstraintWidget.DimensionBehaviour mDimensionBehavior;
    boolean mResolved;
    RunGroup mRunGroup;
    protected RunType mRunType;
    ConstraintWidget mWidget;
    public int matchConstraintsType;
    public int orientation;
    public DependencyNode start;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type = r0;
            r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r0 = new RunType("NONE", 0);
            NONE = r0;
            RunType r1 = new RunType("START", 1);
            START = r1;
            RunType r3 = new RunType(VCardConstants.PROPERTY_END, 2);
            END = r3;
            RunType r5 = new RunType("CENTER", 3);
            CENTER = r5;
            $VALUES = new RunType[]{r0, r1, r3, r5};
        }

        private RunType(String r1, int r2) {
            super(r1, r2);
        }

        public static RunType valueOf(String r1) {
            return (RunType) Enum.valueOf(RunType.class, r1);
        }

        public static RunType[] values() {
            return (RunType[]) $VALUES.clone();
        }
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    abstract void reset();

    abstract boolean supportsWrapComputation();

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r1) {
    }

    protected void updateRunEnd(Dependency r1) {
    }

    protected void updateRunStart(Dependency r1) {
    }

    public WidgetRun(ConstraintWidget r2) {
        this.mDimension = new DimensionDependency(this);
        this.orientation = 0;
        this.mResolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.mWidget = r2;
    }

    public boolean isDimensionResolved() {
        return this.mDimension.resolved;
    }

    public boolean isCenterConnection() {
        int r0 = this.start.mTargets.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (this.start.mTargets.get(r2).mRun == this) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        int r1 = this.end.mTargets.size();
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L15;
        if (this.end.mTargets.get(r4).mRun == this) goto L13;
        r3 = r3 + 1;
    L13:
        r4 = r4 + 1;
        goto L9
    L15:
        if (r3 < 2) goto L24;
        return true;
    L24:
        return false;
    }

    public long wrapSize(int r4) {
        if (this.mDimension.resolved == false) goto L12;
        long r0 = this.mDimension.value;
        if (isCenterConnection() == false) goto L8;
        long r3 = this.start.mMargin - this.end.mMargin;
    L14:
        return r0 + r3;
    L8:
        if (r4 != 0) goto L11;
        r3 = this.start.mMargin;
        goto L14
    L11:
        return r0 - ((long) this.end.mMargin);
    L12:
        return 0;
    }

    protected final DependencyNode getTarget(ConstraintAnchor r3) {
        if (r3.mTarget != null) goto L5;
        return null;
    L5:
        ConstraintWidget r2 = r3.mTarget.mOwner;
        ConstraintAnchor.Type r4 = r3.mTarget.mType;
        int r5 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return r2.mVerticalRun.end;
    L23:
        return r2.mVerticalRun.baseline;
    L24:
        return r2.mVerticalRun.start;
    L25:
        return r2.mHorizontalRun.end;
    L21:
        return r2.mHorizontalRun.start;
    }

    protected void updateRunCenter(Dependency r5, ConstraintAnchor r6, ConstraintAnchor r7, int r8) {
        DependencyNode r9 = getTarget(r6);
        DependencyNode r0 = getTarget(r7);
        if (r9.resolved == true) goto L5;
        return;
    L5:
        if (r0.resolved == false) goto L28;
        int r1 = r9.value + r6.getMargin();
        int r10 = r0.value - r7.getMargin();
        int r11 = r10 - r1;
        if (this.mDimension.resolved == true) goto L13;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        resolveDimension(r8, r11);
    L13:
        if (this.mDimension.resolved == true) goto L16;
        return;
    L16:
        if (this.mDimension.value != r11) goto L19;
        this.start.resolve(r1);
        this.end.resolve(r10);
        return;
    L19:
        if (r8 != 0) goto L21;
        float r12 = this.mWidget.getHorizontalBiasPercent();
    L23:
        if (r9 != r0) goto L25;
        r1 = r9.value;
        r10 = r0.value;
        r12 = 0.5f;
    L25:
        this.start.resolve((int) ((r1 + 0.5f) + (((r10 - r1) - this.mDimension.value) * r12)));
        this.end.resolve(this.start.value + this.mDimension.value);
        return;
    L21:
        r12 = this.mWidget.getVerticalBiasPercent();
        goto L23
    }

    private void resolveDimension(int r5, int r6) {
        int r0 = this.matchConstraintsType;
        if (r0 != 0) goto L5;
        this.mDimension.resolve(getLimitedDimension(r6, r5));
        return;
    L5:
        if (r0 != 1) goto L7;
        this.mDimension.resolve(Math.min(getLimitedDimension(this.mDimension.wrapValue, r5), r6));
        return;
    L7:
        if (r0 != 2) goto L9;
        ConstraintWidget r7 = this.mWidget.getParent();
        if (r7 == null) goto L46;
        if (r5 != 0) goto L34;
        WidgetRun r8 = r7.mHorizontalRun;
    L36:
        if (r8.mDimension.resolved == false) goto L47;
        if (r5 != 0) goto L39;
        float r1 = this.mWidget.mMatchConstraintPercentWidth;
    L40:
        this.mDimension.resolve(getLimitedDimension((int) ((r8.mDimension.value * r1) + 0.5f), r5));
        return;
    L39:
        r1 = this.mWidget.mMatchConstraintPercentHeight;
        goto L40
    L47:
        return;
    L34:
        r8 = r7.mVerticalRun;
        goto L36
    L46:
        return;
    L9:
        if (r0 == 3) goto L12;
        return;
    L12:
        if (this.mWidget.mHorizontalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
    L20:
        if (r5 != 0) goto L22;
        WidgetRun r9 = this.mWidget.mVerticalRun;
    L24:
        if (r9.mDimension.resolved == false) goto L44;
        float r2 = this.mWidget.getDimensionRatio();
        if (r5 != 1) goto L28;
        int r10 = (int) ((r9.mDimension.value / r2) + 0.5f);
    L29:
        this.mDimension.resolve(r10);
        return;
    L28:
        r10 = (int) ((r2 * r9.mDimension.value) + 0.5f);
        goto L29
    L44:
        return;
    L22:
        r9 = this.mWidget.mHorizontalRun;
        goto L24
    L14:
        if (this.mWidget.mHorizontalRun.matchConstraintsType != 3) goto L20;
        if (this.mWidget.mVerticalRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L20;
        if (this.mWidget.mVerticalRun.matchConstraintsType != 3) goto L20;
    }

    protected final int getLimitedDimension(int r1, int r2) {
        if (r2 != 0) goto L8;
        int r3 = this.mWidget.mMatchConstraintMaxWidth;
        int r0 = Math.max(this.mWidget.mMatchConstraintMinWidth, r1);
        if (r3 <= 0) goto L6;
        r0 = Math.min(r3, r1);
    L6:
        if (r0 != r1) goto L13;
        return r1;
    L13:
        return r0;
    L8:
        int r4 = this.mWidget.mMatchConstraintMaxHeight;
        r0 = Math.max(this.mWidget.mMatchConstraintMinHeight, r1);
        if (r4 <= 0) goto L11;
        r0 = Math.min(r4, r1);
    L11:
        if (r0 != r1) goto L13;
        return r1;
    }

    protected final DependencyNode getTarget(ConstraintAnchor r2, int r3) {
        if (r2.mTarget != null) goto L5;
        return null;
    L5:
        ConstraintWidget r1 = r2.mTarget.mOwner;
        if (r3 != 0) goto L8;
        WidgetRun r4 = r1.mHorizontalRun;
    L9:
        ConstraintAnchor.Type r5 = r2.mTarget.mType;
        int r6 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$widgets$ConstraintAnchor$Type[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 == 2) goto L21;
        if (r6 == 3) goto L20;
        if (r6 == 5) goto L21;
        return null;
    L21:
        return r4.end;
    L20:
        return r4.start;
    L8:
        r4 = r1.mVerticalRun;
        goto L9
    }

    protected final void addTarget(DependencyNode r1, DependencyNode r2, int r3) {
        r1.mTargets.add(r2);
        r1.mMargin = r3;
        r2.mDependencies.add(r1);
    }

    protected final void addTarget(DependencyNode r2, DependencyNode r3, int r4, DimensionDependency r5) {
        r2.mTargets.add(r3);
        r2.mTargets.add(this.mDimension);
        r2.mMarginFactor = r4;
        r2.mMarginDependency = r5;
        r3.mDependencies.add(r2);
        r5.mDependencies.add(r2);
    }

    public long getWrapDimension() {
        if (this.mDimension.resolved == true) goto L5;
        return 0;
    L5:
        return this.mDimension.value;
    }

    public boolean isResolved() {
        return this.mResolved;
    }
}
