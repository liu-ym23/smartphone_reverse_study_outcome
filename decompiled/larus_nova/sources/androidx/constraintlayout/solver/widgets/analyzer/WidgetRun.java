package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WidgetRun implements Dependency {
    DimensionDependency dimension;
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    protected RunType mRunType;
    public int matchConstraintsType;
    public int orientation;
    boolean resolved;
    RunGroup runGroup;
    public DependencyNode start;
    ConstraintWidget widget;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r100 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r100;
            r100[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r100 = new RunType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            RunType r101 = new RunType(GXAnimation.STATE_START, 1);
            START = r101;
            RunType r102 = new RunType(GXAnimation.STATE_END, 2);
            END = r102;
            RunType r103 = new RunType("CENTER", 3);
            CENTER = r103;
            $VALUES = new RunType[]{r100, r101, r102, r103};
        }

        public static RunType[] values() {
            return (RunType[]) $VALUES.clone();
        }

        public static RunType valueOf(String r100) {
            return (RunType) a.a(RunType.class, r100);
        }

        private RunType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r100) {
    }

    public void updateRunEnd(Dependency r100) {
    }

    public void updateRunStart(Dependency r100) {
    }

    public long getWrapDimension() {
        DimensionDependency r100 = this.dimension;
        if (r100.resolved == true) goto L5;
        return 0;
    L5:
        return r100.value;
    }

    public boolean isCenterConnection() {
        int r100 = this.start.targets.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L8;
        if (((DependencyNode) ListProtector.get(this.start.targets, r101)).run == this) goto L7;
        r102 = r102 + 1;
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        int r103 = this.end.targets.size();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        if (((DependencyNode) ListProtector.get(this.end.targets, r104)).run == this) goto L13;
        r102 = r102 + 1;
    L13:
        r104 = r104 + 1;
        goto L9
    L15:
        if (r102 < 2) goto L24;
        return true;
    L24:
        return false;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public WidgetRun(ConstraintWidget r100) {
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = r100;
    }

    public final DependencyNode getTarget(ConstraintAnchor r100) {
        ConstraintAnchor r101 = r100.mTarget;
        if (r101 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r102 = r101.mOwner;
        ConstraintAnchor.Type r103 = r101.mType;
        int r104 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r103.ordinal()];
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L25;
        if (r104 == 3) goto L24;
        if (r104 == 4) goto L23;
        if (r104 == 5) goto L22;
        return null;
    L22:
        return r102.verticalRun.end;
    L23:
        return r102.verticalRun.baseline;
    L24:
        return r102.verticalRun.start;
    L25:
        return r102.horizontalRun.end;
    L21:
        return r102.horizontalRun.start;
    }

    public long wrapSize(int r100) {
        DimensionDependency r101 = this.dimension;
        if (r101.resolved == false) goto L12;
        long r102 = r101.value;
        if (isCenterConnection() == false) goto L8;
        int r103 = this.start.margin - this.end.margin;
    L14:
        return r102 + ((long) r103);
    L8:
        if (r100 != 0) goto L11;
        r103 = this.start.margin;
        goto L14
    L11:
        return r102 - ((long) this.end.margin);
    L12:
        return 0;
    }

    private void resolveDimension(int r100, int r101) {
        int r102 = this.matchConstraintsType;
        if (r102 != 0) goto L5;
        this.dimension.resolve(getLimitedDimension(r101, r100));
        return;
    L5:
        if (r102 != 1) goto L7;
        this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, r100), r101));
        return;
    L7:
        if (r102 != 2) goto L9;
        ConstraintWidget r103 = this.widget.getParent();
        if (r103 == null) goto L46;
        if (r100 != 0) goto L33;
        WidgetRun r104 = r103.horizontalRun;
    L34:
        DimensionDependency r105 = r104.dimension;
        if (r105.resolved == false) goto L47;
        ConstraintWidget r106 = this.widget;
        if (r100 != 0) goto L39;
        float r107 = r106.mMatchConstraintPercentWidth;
    L40:
        this.dimension.resolve(getLimitedDimension((int) ((r105.value * r107) + 0.5f), r100));
        return;
    L39:
        r107 = r106.mMatchConstraintPercentHeight;
        goto L40
    L47:
        return;
    L33:
        r104 = r103.verticalRun;
        goto L34
    L46:
        return;
    L9:
        if (r102 != 3) goto L50;
        ConstraintWidget r108 = this.widget;
        WidgetRun r109 = r108.horizontalRun;
        ConstraintWidget.DimensionBehaviour r110 = r109.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 == r111) goto L14;
    L20:
        if (r100 != 0) goto L23;
        r109 = r108.verticalRun;
    L23:
        if (r109.dimension.resolved == false) goto L44;
        float r112 = r108.getDimensionRatio();
        if (r100 != 1) goto L27;
        int r113 = (int) ((r109.dimension.value / r112) + 0.5f);
    L28:
        this.dimension.resolve(r113);
        return;
    L27:
        r113 = (int) ((r112 * r109.dimension.value) + 0.5f);
        goto L28
    L44:
        return;
    L14:
        if (r109.matchConstraintsType != 3) goto L20;
        VerticalWidgetRun r114 = r108.verticalRun;
        if (r114.dimensionBehavior != r111) goto L20;
        if (r114.matchConstraintsType != 3) goto L20;
        return;
    }

    public final int getLimitedDimension(int r100, int r101) {
        if (r101 != 0) goto L8;
        ConstraintWidget r102 = this.widget;
        int r103 = r102.mMatchConstraintMaxWidth;
        int r104 = Math.max(r102.mMatchConstraintMinWidth, r100);
        if (r103 <= 0) goto L6;
        r104 = Math.min(r103, r100);
    L6:
        if (r104 != r100) goto L13;
        return r100;
    L13:
        return r104;
    L8:
        ConstraintWidget r105 = this.widget;
        int r106 = r105.mMatchConstraintMaxHeight;
        r104 = Math.max(r105.mMatchConstraintMinHeight, r100);
        if (r106 <= 0) goto L11;
        r104 = Math.min(r106, r100);
    L11:
        if (r104 != r100) goto L13;
        return r100;
    }

    public final DependencyNode getTarget(ConstraintAnchor r100, int r101) {
        ConstraintAnchor r102 = r100.mTarget;
        if (r102 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r103 = r102.mOwner;
        if (r101 != 0) goto L8;
        WidgetRun r104 = r103.horizontalRun;
    L9:
        ConstraintAnchor.Type r105 = r102.mType;
        int r106 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r105.ordinal()];
        if (r106 == 1) goto L20;
        if (r106 == 2) goto L21;
        if (r106 == 3) goto L20;
        if (r106 == 5) goto L21;
        return null;
    L21:
        return r104.end;
    L20:
        return r104.start;
    L8:
        r104 = r103.verticalRun;
        goto L9
    }

    public final void addTarget(DependencyNode r100, DependencyNode r101, int r102) {
        r100.targets.add(r101);
        r100.margin = r102;
        r101.dependencies.add(r100);
    }

    public final void addTarget(DependencyNode r100, DependencyNode r101, int r102, DimensionDependency r103) {
        r100.targets.add(r101);
        r100.targets.add(this.dimension);
        r100.marginFactor = r102;
        r100.marginDependency = r103;
        r101.dependencies.add(r100);
        r103.dependencies.add(r100);
    }

    public void updateRunCenter(Dependency r100, ConstraintAnchor r101, ConstraintAnchor r102, int r103) {
        DependencyNode r104 = getTarget(r101);
        DependencyNode r105 = getTarget(r102);
        if (r104.resolved == true) goto L5;
        return;
    L5:
        if (r105.resolved == false) goto L29;
        int r106 = r104.value + r101.getMargin();
        int r107 = r105.value - r102.getMargin();
        int r108 = r107 - r106;
        if (this.dimension.resolved == false) goto L10;
    L12:
        DimensionDependency r109 = this.dimension;
        if (r109.resolved == true) goto L16;
        return;
    L16:
        if (r109.value != r108) goto L19;
        this.start.resolve(r106);
        this.end.resolve(r107);
        return;
    L19:
        ConstraintWidget r110 = this.widget;
        if (r103 != 0) goto L22;
        float r111 = r110.getHorizontalBiasPercent();
    L24:
        if (r104 != r105) goto L26;
        r106 = r104.value;
        r107 = r105.value;
        r111 = 0.5f;
    L26:
        this.start.resolve((int) ((r106 + 0.5f) + (((r107 - r106) - this.dimension.value) * r111)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L22:
        r111 = r110.getVerticalBiasPercent();
        goto L24
    L10:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        resolveDimension(r103, r108);
        goto L12
    }
}
