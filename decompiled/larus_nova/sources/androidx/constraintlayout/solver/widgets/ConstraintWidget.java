package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r100 = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = r100;
            r100[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r101 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r101;
            r101[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public static final enum DimensionBehaviour extends Enum<DimensionBehaviour> {
        private static final /* synthetic */ DimensionBehaviour[] $VALUES = null;
        public static final DimensionBehaviour FIXED = null;
        public static final DimensionBehaviour MATCH_CONSTRAINT = null;
        public static final DimensionBehaviour MATCH_PARENT = null;
        public static final DimensionBehaviour WRAP_CONTENT = null;

        static {
            DimensionBehaviour r100 = new DimensionBehaviour("FIXED", 0);
            FIXED = r100;
            DimensionBehaviour r101 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r101;
            DimensionBehaviour r102 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r102;
            DimensionBehaviour r103 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r103;
            $VALUES = new DimensionBehaviour[]{r100, r101, r102, r103};
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) $VALUES.clone();
        }

        public static DimensionBehaviour valueOf(String r100) {
            return (DimensionBehaviour) a.a(DimensionBehaviour.class, r100);
        }

        private DimensionBehaviour(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void resetFinalResolution() {
        int r100 = 0;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int r101 = this.mAnchors.size();
    L3:
        if (r100 >= r101) goto L5;
        ((ConstraintAnchor) ListProtector.get(this.mAnchors, r100)).resetFinalResolution();
        r100 = r100 + 1;
        goto L3
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean addFirst() {
        if ((this instanceof VirtualLayout) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof Guideline) == true) goto L8;
        return false;
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun != null) goto L6;
        this.horizontalRun = new HorizontalWidgetRun(this);
    L6:
        if (this.verticalRun != null) goto L9;
        this.verticalRun = new VerticalWidgetRun(this);
        return;
    }

    public int getHeight() {
        if (this.mVisibility != 8) goto L7;
        return 0;
    L7:
        return this.mHeight;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor r100 = this.mLeft;
        int r101 = 0;
        if (r100 == null) goto L5;
        r101 = 0 + r100.mMargin;
    L5:
        ConstraintAnchor r102 = this.mRight;
        if (r102 != null) goto L8;
        return r101;
    L8:
        return r101 + r102.mMargin;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getOptimizerWrapHeight() {
        int r100 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r100;
    L5:
        if (this.mMatchConstraintDefaultHeight != 1) goto L7;
        int r101 = Math.max(this.mMatchConstraintMinHeight, r100);
    L11:
        int r102 = this.mMatchConstraintMaxHeight;
        if (r102 <= 0) goto L17;
        if (r102 < r101) goto L15;
        return r101;
    L15:
        return r102;
    L17:
        return r101;
    L7:
        r101 = this.mMatchConstraintMinHeight;
        if (r101 <= 0) goto L10;
        this.mHeight = r101;
        goto L11
    L10:
        r101 = 0;
        goto L11
    }

    public int getOptimizerWrapWidth() {
        int r100 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r100;
    L5:
        if (this.mMatchConstraintDefaultWidth != 1) goto L7;
        int r101 = Math.max(this.mMatchConstraintMinWidth, r100);
    L11:
        int r102 = this.mMatchConstraintMaxWidth;
        if (r102 <= 0) goto L17;
        if (r102 < r101) goto L15;
        return r101;
    L15:
        return r102;
    L17:
        return r101;
    L7:
        r101 = this.mMatchConstraintMinWidth;
        if (r101 <= 0) goto L10;
        this.mWidth = r101;
        goto L11
    L10:
        r101 = 0;
        goto L11
    }

    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int r100 = 0;
        if (this.mLeft == null) goto L6;
        r100 = 0 + this.mTop.mMargin;
    L6:
        if (this.mRight != null) goto L8;
        return r100;
    L8:
        return r100 + this.mBottom.mMargin;
    }

    public int getWidth() {
        if (this.mVisibility != 8) goto L7;
        return 0;
    L7:
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget r100 = this.mParent;
        if (r100 == null) goto L9;
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r100).mPaddingLeft + this.mX;
    L9:
        return this.mX;
    }

    public int getY() {
        ConstraintWidget r100 = this.mParent;
        if (r100 == null) goto L9;
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r100).mPaddingTop + this.mY;
    L9:
        return this.mY;
    }

    public boolean hasDependencies() {
        int r100 = this.mAnchors.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        if (((ConstraintAnchor) ListProtector.get(this.mAnchors, r101)).hasDependents() == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor r100 = this.mLeft;
        ConstraintAnchor r101 = r100.mTarget;
        if (r101 != null) goto L5;
    L6:
        ConstraintAnchor r102 = this.mRight;
        ConstraintAnchor r103 = r102.mTarget;
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.mTarget != r102) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r101.mTarget != r100) goto L6;
        return true;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor r100 = this.mTop;
        ConstraintAnchor r101 = r100.mTarget;
        if (r101 != null) goto L5;
    L6:
        ConstraintAnchor r102 = this.mBottom;
        ConstraintAnchor r103 = r102.mTarget;
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.mTarget != r102) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r101.mTarget != r100) goto L6;
        return true;
    }

    public boolean isMeasureRequested() {
        if (this.mMeasureRequested == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mVisibility == 8) goto L7;
        return true;
    }

    public boolean isResolvedHorizontally() {
        if (this.resolvedHorizontal == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mLeft.hasFinalValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mRight.hasFinalValue() == false) goto L9;
        goto L9
    }

    public boolean isResolvedVertically() {
        if (this.resolvedVertical == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mTop.hasFinalValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mBottom.hasFinalValue() == false) goto L9;
        goto L9
    }

    public boolean isRoot() {
        if (this.mParent != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0) goto L5;
    L13:
        return false;
    L5:
        if (this.mDimensionRatio != 0.0f) goto L13;
        if (this.mMatchConstraintMinHeight != 0) goto L13;
        if (this.mMatchConstraintMaxHeight != 0) goto L13;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        return true;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth == 0) goto L5;
        return false;
    L5:
        if (this.mDimensionRatio == 0.0f) goto L7;
        return false;
    L7:
        if (this.mMatchConstraintMinWidth == 0) goto L9;
        return false;
    L9:
        if (this.mMatchConstraintMaxWidth == 0) goto L11;
        return false;
    L11:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] r100 = this.mListDimensionBehaviors;
        DimensionBehaviour r101 = r100[0];
        DimensionBehaviour r102 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r101 == r102) goto L5;
        return false;
    L5:
        if (r100[1] != r102) goto L9;
        return true;
    L9:
        return false;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float r100 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r100;
        this.mVerticalBiasPercent = r100;
        DimensionBehaviour[] r101 = this.mListDimensionBehaviors;
        DimensionBehaviour r102 = DimensionBehaviour.FIXED;
        r101[0] = r102;
        r101[1] = r102;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] r103 = this.mWeight;
        r103[0] = -1.0f;
        r103[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] r104 = this.mMaxDimension;
        r104[0] = Integer.MAX_VALUE;
        r104[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] r105 = this.isTerminalWidget;
        r105[0] = true;
        r105[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] r106 = this.mIsInBarrier;
        r106[0] = false;
        r106[1] = false;
        this.mMeasureRequested = true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = "";
        if (this.mType == null) goto L5;
        String r102 = "type: " + this.mType + " ";
    L6:
        r100.append(r102);
        if (this.mDebugName == null) goto L9;
        r101 = "id: " + this.mDebugName + " ";
    L9:
        r100.append(r101);
        r100.append("(");
        r100.append(this.mX);
        r100.append(", ");
        r100.append(this.mY);
        r100.append(") - (");
        r100.append(this.mWidth);
        r100.append(" x ");
        r100.append(this.mHeight);
        r100.append(")");
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r100 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r100;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r100};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r101 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r101, r101};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r102 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r102;
        this.mVerticalBiasPercent = r102;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (isInHorizontalChain() == false) goto L36;
        ConstraintWidget r100 = this;
        ConstraintWidget r101 = null;
    L5:
        if (r101 != null) goto L26;
        if (r100 == null) goto L26;
        ConstraintAnchor r102 = r100.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r102 != null) goto L10;
        ConstraintAnchor r103 = null;
    L11:
        if (r103 != null) goto L13;
        ConstraintWidget r104 = null;
    L15:
        if (r104 == getParent()) goto L37;
        if (r104 != null) goto L19;
        ConstraintAnchor r105 = null;
    L20:
        if (r105 == null) goto L24;
        if (r105.getOwner() == r100) goto L24;
        r101 = r100;
    L24:
        r100 = r104;
        goto L5
    L19:
        r105 = r104.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        goto L20
    L37:
        return r100;
    L13:
        r104 = r103.getOwner();
        goto L15
    L10:
        r103 = r102.getTarget();
    L26:
        return r101;
    L36:
        return null;
    }

    public int getLeft() {
        return getX();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getTop() {
        return getY();
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (isInVerticalChain() == false) goto L36;
        ConstraintWidget r100 = this;
        ConstraintWidget r101 = null;
    L5:
        if (r101 != null) goto L26;
        if (r100 == null) goto L26;
        ConstraintAnchor r102 = r100.getAnchor(ConstraintAnchor.Type.TOP);
        if (r102 != null) goto L10;
        ConstraintAnchor r103 = null;
    L11:
        if (r103 != null) goto L13;
        ConstraintWidget r104 = null;
    L15:
        if (r104 == getParent()) goto L37;
        if (r104 != null) goto L19;
        ConstraintAnchor r105 = null;
    L20:
        if (r105 == null) goto L24;
        if (r105.getOwner() == r100) goto L24;
        r101 = r100;
    L24:
        r100 = r104;
        goto L5
    L19:
        r105 = r104.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        goto L20
    L37:
        return r100;
    L13:
        r104 = r103.getOwner();
        goto L15
    L10:
        r103 = r102.getTarget();
    L26:
        return r101;
    L36:
        return null;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchors() {
        ConstraintWidget r100 = getParent();
        if (r100 != null) goto L5;
    L9:
        int r101 = this.mAnchors.size();
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L12;
        ((ConstraintAnchor) ListProtector.get(this.mAnchors, r102)).reset();
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L5:
        if ((r100 instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public ConstraintWidget(String r110) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r100 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r100;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r100};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r101 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r101, r101};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r102 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r102;
        this.mVerticalBiasPercent = r102;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(r110);
    }

    private boolean isChainHead(int r100) {
        int r101 = r100 * 2;
        ConstraintAnchor[] r102 = this.mListAnchors;
        ConstraintAnchor r103 = r102[r101];
        ConstraintAnchor r104 = r103.mTarget;
        if (r104 != null) goto L5;
    L11:
        return false;
    L5:
        if (r104.mTarget == r103) goto L11;
        ConstraintAnchor r105 = r102[r101 + 1];
        ConstraintAnchor r106 = r105.mTarget;
        if (r106 == null) goto L11;
        if (r106.mTarget != r105) goto L11;
        return true;
    }

    public void createObjectVariables(LinearSystem r100) {
        r100.createObjectVariable(this.mLeft);
        r100.createObjectVariable(this.mTop);
        r100.createObjectVariable(this.mRight);
        r100.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance <= 0) goto L6;
        r100.createObjectVariable(this.mBaseline);
        return;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r100) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r100.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r100.name());
    L9:
        return this.mCenterY;
    L11:
        return this.mCenterX;
    L13:
        return this.mCenter;
    L15:
        return this.mBaseline;
    L17:
        return this.mBottom;
    L19:
        return this.mRight;
    L21:
        return this.mTop;
    L23:
        return this.mLeft;
    }

    public float getBiasPercent(int r100) {
        if (r100 != 0) goto L6;
        return this.mHorizontalBiasPercent;
    L6:
        if (r100 == 1) goto L8;
        return -1.0f;
    L8:
        return this.mVerticalBiasPercent;
    }

    public DimensionBehaviour getDimensionBehaviour(int r100) {
        if (r100 != 0) goto L6;
        return getHorizontalDimensionBehaviour();
    L6:
        if (r100 == 1) goto L8;
        return null;
    L8:
        return getVerticalDimensionBehaviour();
    }

    public int getLength(int r100) {
        if (r100 != 0) goto L6;
        return getWidth();
    L6:
        if (r100 == 1) goto L8;
        return 0;
    L8:
        return getHeight();
    }

    public ConstraintWidget getNextChainMember(int r100) {
        if (r100 != 0) goto L10;
        ConstraintAnchor r101 = this.mRight;
        ConstraintAnchor r102 = r101.mTarget;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.mTarget == r101) goto L8;
        return null;
    L8:
        return r102.mOwner;
    L10:
        if (r100 != 1) goto L20;
        ConstraintAnchor r103 = this.mBottom;
        ConstraintAnchor r104 = r103.mTarget;
        if (r104 != null) goto L14;
        return null;
    L14:
        if (r104.mTarget == r103) goto L16;
        return null;
    L16:
        return r104.mOwner;
    L20:
        return null;
    }

    public ConstraintWidget getPreviousChainMember(int r100) {
        if (r100 != 0) goto L10;
        ConstraintAnchor r101 = this.mLeft;
        ConstraintAnchor r102 = r101.mTarget;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.mTarget == r101) goto L8;
        return null;
    L8:
        return r102.mOwner;
    L10:
        if (r100 != 1) goto L20;
        ConstraintAnchor r103 = this.mTop;
        ConstraintAnchor r104 = r103.mTarget;
        if (r104 != null) goto L14;
        return null;
    L14:
        if (r104.mTarget == r103) goto L16;
        return null;
    L16:
        return r104.mOwner;
    L20:
        return null;
    }

    public int getRelativePositioning(int r100) {
        if (r100 != 0) goto L6;
        return this.mRelX;
    L6:
        if (r100 == 1) goto L8;
        return 0;
    L8:
        return this.mRelY;
    }

    public WidgetRun getRun(int r100) {
        if (r100 != 0) goto L6;
        return this.horizontalRun;
    L6:
        if (r100 == 1) goto L8;
        return null;
    L8:
        return this.verticalRun;
    }

    public boolean hasDanglingDimension(int r100) {
        if (r100 != 0) goto L18;
        if (this.mLeft.mTarget == null) goto L7;
        int r101 = 1;
    L9:
        if (this.mRight.mTarget == null) goto L11;
        int r102 = 1;
    L13:
        if ((r101 + r102) < 2) goto L34;
        return false;
    L34:
        return true;
    L11:
        r102 = 0;
        goto L13
    L7:
        r101 = 0;
        goto L9
    L18:
        if (this.mTop.mTarget == null) goto L20;
        int r103 = 1;
    L22:
        if (this.mBottom.mTarget == null) goto L24;
        int r104 = 1;
    L25:
        int r105 = r103 + r104;
        if (this.mBaseline.mTarget == null) goto L28;
        int r106 = 1;
    L30:
        if ((r105 + r106) < 2) goto L35;
        return false;
    L35:
        return true;
    L28:
        r106 = 0;
        goto L30
    L24:
        r104 = 0;
        goto L25
    L20:
        r103 = 0;
        goto L22
    }

    public boolean oppositeDimensionDependsOn(int r100) {
        if (r100 != 0) goto L5;
        char r101 = 1;
    L6:
        DimensionBehaviour[] r102 = this.mListDimensionBehaviors;
        DimensionBehaviour r103 = r102[r100];
        DimensionBehaviour r104 = r102[r101];
        DimensionBehaviour r105 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r103 != r105) goto L10;
        if (r104 != r105) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public void resetAnchor(ConstraintAnchor r100) {
        if (getParent() != null) goto L5;
    L9:
        ConstraintAnchor r101 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r102 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r103 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r104 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor r105 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor r106 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor r107 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (r100 == r105) goto L12;
        if (r100 == r106) goto L28;
        if (r100 == r107) goto L37;
        if (r100 == r101) goto L55;
        if (r100 == r102) goto L55;
        if (r100 == r103) goto L50;
        if (r100 == r104) goto L50;
    L59:
        r100.reset();
        return;
    L50:
        if (r103.isConnected() == false) goto L59;
        if (r103.getTarget() != r104.getTarget()) goto L59;
        r105.reset();
    L55:
        if (r101.isConnected() == false) goto L59;
        if (r101.getTarget() != r102.getTarget()) goto L59;
        r105.reset();
        goto L59
    L37:
        if (r103.isConnected() == true) goto L39;
    L43:
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L39:
        if (r104.isConnected() == false) goto L43;
        if (r103.getTarget().getOwner() != r104.getTarget().getOwner()) goto L43;
        r103.reset();
        r104.reset();
        goto L43
    L28:
        if (r101.isConnected() == true) goto L30;
    L34:
        this.mHorizontalBiasPercent = 0.5f;
        goto L59
    L30:
        if (r102.isConnected() == false) goto L34;
        if (r101.getTarget().getOwner() != r102.getTarget().getOwner()) goto L34;
        r101.reset();
        r102.reset();
        goto L34
    L12:
        if (r101.isConnected() == false) goto L19;
        if (r102.isConnected() == false) goto L19;
        if (r101.getTarget() != r102.getTarget()) goto L19;
        r101.reset();
        r102.reset();
    L19:
        if (r103.isConnected() == true) goto L21;
    L25:
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L21:
        if (r104.isConnected() == false) goto L25;
        if (r103.getTarget() != r104.getTarget()) goto L25;
        r103.reset();
        r104.reset();
        goto L25
    L5:
        if ((getParent() instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetSolverVariables(Cache r100) {
        this.mLeft.resetSolverVariable(r100);
        this.mTop.resetSolverVariable(r100);
        this.mRight.resetSolverVariable(r100);
        this.mBottom.resetSolverVariable(r100);
        this.mBaseline.resetSolverVariable(r100);
        this.mCenter.resetSolverVariable(r100);
        this.mCenterX.resetSolverVariable(r100);
        this.mCenterY.resetSolverVariable(r100);
    }

    public void setBaselineDistance(int r100) {
        this.mBaselineDistance = r100;
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        this.hasBaseline = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setCompanionWidget(Object r100) {
        this.mCompanionWidget = r100;
    }

    public void setContainerItemSkip(int r100) {
        if (r100 < 0) goto L4;
        this.mContainerItemSkip = r100;
        return;
    L4:
        this.mContainerItemSkip = 0;
    }

    public void setDebugName(String r100) {
        this.mDebugName = r100;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0087 -> B:41:0x0088). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L45:
        this.mDimensionRatio = 0.0f;
        return;
    L5:
        if (r100.length() == 0) goto L45;
        int r102 = r100.length();
        int r103 = r100.indexOf(44);
        int r104 = 0;
        int r105 = -1;
        if (r103 > 0) goto L10;
    L19:
        int r106 = r100.indexOf(58);
        if (r106 >= 0) goto L22;
    L35:
        String r107 = r100.substring(r104);
        if (r107.length() <= 0) goto L40;
        float r108 = CastFloatProtector.parseFloat(r107);     // Catch: NumberFormatException -> L39
    L41:
        r101 = (r108 > r101 ? 1 : (r108 == r101 ? 0 : -1));
        if (r101 <= 0) goto L49;
        this.mDimensionRatio = r108;
        this.mDimensionRatioSide = r105;
        return;
    L49:
        return;
    L22:
        if (r106 >= (r102 - 1)) goto L35;
        String r109 = r100.substring(r104, r106);
        String r110 = r100.substring(r106 + 1);
        if (r109.length() <= 0) goto L40;
        if (r110.length() <= 0) goto L40;
        float r111 = CastFloatProtector.parseFloat(r109);     // Catch: NumberFormatException -> L39
        float r112 = CastFloatProtector.parseFloat(r110);     // Catch: NumberFormatException -> L39
        if (r111 <= 0.0f) goto L40;
        if (r112 <= 0.0f) goto L40;
        if (r105 != 1) goto L33;
        r108 = Math.abs(r112 / r111);     // Catch: NumberFormatException -> L39
        goto L41
    L33:
        r108 = Math.abs(r111 / r112);     // Catch: NumberFormatException -> L39
    L40:
        r108 = 0.0f;
        goto L41
    L10:
        if (r103 >= (r102 - 1)) goto L19;
        String r113 = r100.substring(0, r103);
        if (r113.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L15;
    L18:
        r105 = r104;
        r104 = r103 + 1;
        goto L19
    L15:
        if (r113.equalsIgnoreCase(FaceService.neutralLabel) == false) goto L17;
        r104 = 1;
        goto L18
    L17:
        r104 = -1;
        goto L18
    }

    public void setFinalBaseline(int r100) {
        if (this.hasBaseline == true) goto L5;
        return;
    L5:
        int r101 = r100 - this.mBaselineDistance;
        int r102 = this.mHeight + r101;
        this.mY = r101;
        this.mTop.setFinalValue(r101);
        this.mBottom.setFinalValue(r102);
        this.mBaseline.setFinalValue(r100);
        this.resolvedVertical = true;
    }

    public void setFinalLeft(int r100) {
        this.mLeft.setFinalValue(r100);
        this.mX = r100;
    }

    public void setFinalTop(int r100) {
        this.mTop.setFinalValue(r100);
        this.mY = r100;
    }

    public void setHasBaseline(boolean r100) {
        this.hasBaseline = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
        int r101 = this.mMinHeight;
        if (r100 >= r101) goto L6;
        this.mHeight = r101;
        return;
    }

    public void setHeightWrapContent(boolean r100) {
        this.mIsHeightWrapContent = r100;
    }

    public void setHorizontalBiasPercent(float r100) {
        this.mHorizontalBiasPercent = r100;
    }

    public void setHorizontalChainStyle(int r100) {
        this.mHorizontalChainStyle = r100;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour r100) {
        this.mListDimensionBehaviors[0] = r100;
    }

    public void setHorizontalWeight(float r100) {
        this.mWeight[0] = r100;
    }

    public void setInPlaceholder(boolean r100) {
        this.inPlaceholder = r100;
    }

    public void setInVirtualLayout(boolean r100) {
        this.mInVirtuaLayout = r100;
    }

    public void setMaxHeight(int r100) {
        this.mMaxDimension[1] = r100;
    }

    public void setMaxWidth(int r100) {
        this.mMaxDimension[0] = r100;
    }

    public void setMeasureRequested(boolean r100) {
        this.mMeasureRequested = r100;
    }

    public void setMinHeight(int r100) {
        if (r100 >= 0) goto L4;
        this.mMinHeight = 0;
        return;
    L4:
        this.mMinHeight = r100;
    }

    public void setMinWidth(int r100) {
        if (r100 >= 0) goto L4;
        this.mMinWidth = 0;
        return;
    L4:
        this.mMinWidth = r100;
    }

    public void setParent(ConstraintWidget r100) {
        this.mParent = r100;
    }

    public void setType(String r100) {
        this.mType = r100;
    }

    public void setVerticalBiasPercent(float r100) {
        this.mVerticalBiasPercent = r100;
    }

    public void setVerticalChainStyle(int r100) {
        this.mVerticalChainStyle = r100;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour r100) {
        this.mListDimensionBehaviors[1] = r100;
    }

    public void setVerticalWeight(float r100) {
        this.mWeight[1] = r100;
    }

    public void setVisibility(int r100) {
        this.mVisibility = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
        int r101 = this.mMinWidth;
        if (r100 >= r101) goto L6;
        this.mWidth = r101;
        return;
    }

    public void setWidthWrapContent(boolean r100) {
        this.mIsWidthWrapContent = r100;
    }

    public void setX(int r100) {
        this.mX = r100;
    }

    public void setY(int r100) {
        this.mY = r100;
    }

    public ConstraintWidget(int r100, int r101) {
        this(0, 0, r100, r101);
    }

    public void addToSolver(LinearSystem r510, boolean r511) {
        SolverVariable r110 = r510.createObjectVariable(this.mLeft);
        SolverVariable r111 = r510.createObjectVariable(this.mRight);
        SolverVariable r112 = r510.createObjectVariable(this.mTop);
        SolverVariable r113 = r510.createObjectVariable(this.mBottom);
        SolverVariable r100 = r510.createObjectVariable(this.mBaseline);
        ConstraintWidget r101 = this.mParent;
        if (r101 == null) goto L15;
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r101 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        boolean r104 = r103;
        boolean r105 = r102;
    L17:
        if (this.mVisibility == 8) goto L19;
    L25:
        boolean r106 = this.resolvedHorizontal;
        if (r106 == false) goto L28;
    L29:
        if (r106 == false) goto L39;
        r510.addEquality(r110, this.mX);
        r510.addEquality(r111, this.mX + this.mWidth);
        if (r105 == false) goto L39;
        ConstraintWidget r107 = this.mParent;
        if (r107 == null) goto L39;
        if (this.OPTIMIZE_WRAP_ON_RESOLVED == false) goto L37;
        ConstraintWidgetContainer r108 = (ConstraintWidgetContainer) r107;
        r108.addVerticalWrapMinVariable(this.mLeft);
        r108.addHorizontalWrapMaxVariable(this.mRight);
        goto L39
    L37:
        r510.addGreaterThan(r510.createObjectVariable(r107.mRight), r111, 0, 5);
    L39:
        if (this.resolvedVertical == false) goto L51;
        r510.addEquality(r112, this.mY);
        r510.addEquality(r113, this.mY + this.mHeight);
        if (this.mBaseline.hasDependents() == false) goto L43;
        r510.addEquality(r100, this.mY + this.mBaselineDistance);
    L43:
        if (r104 == false) goto L51;
        ConstraintWidget r109 = this.mParent;
        if (r109 == null) goto L51;
        if (this.OPTIMIZE_WRAP_ON_RESOLVED == false) goto L49;
        ConstraintWidgetContainer r114 = (ConstraintWidgetContainer) r109;
        r114.addVerticalWrapMinVariable(this.mTop);
        r114.addVerticalWrapMaxVariable(this.mBottom);
        goto L51
    L49:
        r510.addGreaterThan(r510.createObjectVariable(r109.mBottom), r113, 0, 5);
    L51:
        if (this.resolvedHorizontal == true) goto L53;
    L56:
        Metrics r115 = LinearSystem.sMetrics;
        if (r115 == null) goto L59;
        r115.widgets++;
    L59:
        if (r511 == false) goto L91;
        HorizontalWidgetRun r116 = this.horizontalRun;
        if (r116 == null) goto L91;
        VerticalWidgetRun r117 = this.verticalRun;
        if (r117 == null) goto L91;
        DependencyNode r118 = r116.start;
        if (r118.resolved == false) goto L91;
        if (r116.end.resolved == false) goto L91;
        if (r117.start.resolved == false) goto L91;
        if (r117.end.resolved == false) goto L91;
        if (r115 == null) goto L74;
        r115.graphSolved++;
    L74:
        r510.addEquality(r110, r118.value);
        r510.addEquality(r111, this.horizontalRun.end.value);
        r510.addEquality(r112, this.verticalRun.start.value);
        r510.addEquality(r113, this.verticalRun.end.value);
        r510.addEquality(r100, this.verticalRun.baseline.value);
        if (this.mParent == null) goto L88;
        if (r105 == true) goto L78;
    L82:
        if (r104 == false) goto L88;
        if (this.isTerminalWidget[1] == false) goto L88;
        if (isInVerticalChain() == true) goto L88;
        boolean r119 = false;
        r510.addGreaterThan(r510.createObjectVariable(this.mParent.mBottom), r113, 0, 8);
    L89:
        this.resolvedHorizontal = r119;
        this.resolvedVertical = r119;
        return;
    L78:
        if (this.isTerminalWidget[0] == false) goto L82;
        if (isInHorizontalChain() == true) goto L82;
        r510.addGreaterThan(r510.createObjectVariable(this.mParent.mRight), r111, 0, 8);
    L88:
        r119 = false;
    L91:
        if (r115 == null) goto L94;
        r115.linearSolved++;
    L94:
        if (this.mParent != null) goto L96;
        boolean r210 = false;
        boolean r211 = false;
    L125:
        int r120 = this.mWidth;
        int r121 = this.mMinWidth;
        if (r120 < r121) goto L129;
        r121 = r120;
    L129:
        int r122 = this.mHeight;
        int r123 = this.mMinHeight;
        if (r122 < r123) goto L133;
        r123 = r122;
    L133:
        DimensionBehaviour[] r124 = this.mListDimensionBehaviors;
        DimensionBehaviour r125 = r124[0];
        DimensionBehaviour r126 = DimensionBehaviour.MATCH_CONSTRAINT;
        int r212 = r121;
        if (r125 == r126) goto L136;
        boolean r127 = true;
    L137:
        DimensionBehaviour r128 = r124[1];
        int r213 = r123;
        SolverVariable r214 = r100;
        if (r128 == r126) goto L140;
        boolean r129 = true;
    L141:
        int r130 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = r130;
        SolverVariable r215 = r113;
        float r131 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = r131;
        SolverVariable r216 = r112;
        int r132 = this.mMatchConstraintDefaultWidth;
        SolverVariable r310 = r111;
        int r133 = this.mMatchConstraintDefaultHeight;
        if (r131 > 0.0f) goto L144;
    L176:
        r132 = r132;
        r133 = r133;
        int r134 = r212;
        int r311 = r213;
        boolean r135 = false;
    L177:
        int[] r136 = this.mResolvedMatchConstraintDefault;
        r136[0] = r132;
        r136[1] = r133;
        this.mResolvedHasRatio = r135;
        if (r135 == false) goto L183;
        int r137 = this.mResolvedDimensionRatioSide;
        int r138 = -1;
        if (r137 == 0) goto L182;
        if (r137 == (-1)) goto L182;
    L184:
        boolean r217 = false;
    L185:
        if (r135 == false) goto L190;
        int r139 = this.mResolvedDimensionRatioSide;
        if (r139 == 1) goto L189;
        if (r139 != r138) goto L190;
    L189:
        boolean r312 = true;
    L191:
        DimensionBehaviour r140 = this.mListDimensionBehaviors[0];
        DimensionBehaviour r141 = DimensionBehaviour.WRAP_CONTENT;
        if (r140 == r141) goto L194;
    L196:
        boolean r142 = false;
    L197:
        if (r142 == false) goto L199;
        int r218 = 0;
    L200:
        boolean r313 = !this.mCenter.isConnected();
        boolean[] r143 = this.mIsInBarrier;
        boolean r314 = r143[0];
        boolean r315 = r143[1];
        if (this.mHorizontalResolution != 2) goto L203;
    L236:
        SolverVariable r410 = r110;
    L237:
        if (r511 == false) goto L255;
        ConstraintWidget r144 = this;
        VerticalWidgetRun r145 = r144.verticalRun;
        if (r145 == null) goto L254;
        DependencyNode r146 = r145.start;
        if (r146.resolved == false) goto L254;
        if (r145.end.resolved == false) goto L254;
        r510 = r510;
        r216 = r216;
        r510.addEquality(r216, r146.value);
        r215 = r215;
        r510.addEquality(r215, r144.verticalRun.end.value);
        r214 = r214;
        r510.addEquality(r214, r144.verticalRun.baseline.value);
        ConstraintWidget r147 = r144.mParent;
        if (r147 == null) goto L252;
        if (r210 == true) goto L252;
        if (r104 == false) goto L252;
        char r148 = 1;
        if (r144.isTerminalWidget[1] == false) goto L251;
        int r149 = 8;
        int r150 = 0;
        r510.addGreaterThan(r510.createObjectVariable(r147.mBottom), r215, 0, 8);
    L253:
        boolean r151 = false;
    L258:
        if (r144.mVerticalResolution != 2) goto L260;
        boolean r152 = false;
    L261:
        if (r152 == false) goto L301;
        if (r144.resolvedVertical == true) goto L301;
        if (r144.mListDimensionBehaviors[r148] == r141) goto L267;
    L269:
        boolean r153 = false;
    L270:
        if (r153 == false) goto L272;
        r311 = 0;
    L272:
        ConstraintWidget r154 = r144.mParent;
        if (r154 == null) goto L275;
        SolverVariable r155 = r510.createObjectVariable(r154.mBottom);
    L276:
        ConstraintWidget r156 = r144.mParent;
        if (r156 == null) goto L279;
        SolverVariable r157 = r510.createObjectVariable(r156.mTop);
    L281:
        if (r144.mBaselineDistance > 0) goto L285;
        if (r144.mVisibility == r149) goto L285;
    L294:
        boolean r219 = r313;
    L295:
        boolean r158 = r144.isTerminalWidget[r148];
        DimensionBehaviour[] r159 = r144.mListDimensionBehaviors;
        DimensionBehaviour r160 = r159[r148];
        ConstraintAnchor r161 = r144.mTop;
        ConstraintAnchor r162 = r144.mBottom;
        int r163 = r144.mY;
        int r164 = r144.mMinHeight;
        int r165 = r144.mMaxDimension[r148];
        float r166 = r144.mVerticalBiasPercent;
        if (r159[0] != r126) goto L298;
        boolean r167 = true;
    L299:
        applyConstraints(r510, false, r104, r105, r158, r157, r155, r160, r153, r161, r162, r163, r311, r164, r165, r166, r312, r167, r210, r211, r315, r133, r132, r144.mMatchConstraintMinHeight, r144.mMatchConstraintMaxHeight, r144.mMatchConstraintPercentHeight, r219);
        goto L301
    L298:
        r167 = false;
    L285:
        if (r144.mBaseline.mTarget == null) goto L291;
        r510.addEquality(r214, r216, getBaselineDistance(), r149);
        r510.addEquality(r214, r510.createObjectVariable(r144.mBaseline.mTarget), r150, r149);
        if (r104 == 0) goto L289;
        r510.addGreaterThan(r155, r510.createObjectVariable(r144.mBottom), r150, 5);
    L289:
        r219 = false;
        goto L295
    L291:
        if (r144.mVisibility != r149) goto L293;
        r510.addEquality(r214, r216, r150, r149);
        goto L294
    L293:
        r510.addEquality(r214, r216, getBaselineDistance(), r149);
        goto L294
    L279:
        r157 = null;
        goto L281
    L275:
        r155 = null;
        goto L276
    L267:
        if ((r144 instanceof ConstraintWidgetContainer) == false) goto L269;
        r153 = true;
    L301:
        if (r135 == false) goto L306;
        ConstraintWidget r168 = this;
        if (r168.mResolvedDimensionRatioSide != 1) goto L305;
        r510.addRatio(r215, r216, r310, r410, r168.mResolvedDimensionRatio, 8);
    L308:
        if (r168.mCenter.isConnected() == false) goto L310;
        r510.addCenterPoint(r168, r168.mCenter.getTarget().getOwner(), (float) Math.toRadians(r168.mCircleConstraintAngle + 90.0f), r168.mCenter.getMargin());
    L310:
        r168.resolvedHorizontal = false;
        r168.resolvedVertical = false;
        return;
    L305:
        r510.addRatio(r310, r410, r215, r216, r168.mResolvedDimensionRatio, 8);
        goto L308
    L306:
        r168 = this;
        goto L308
    L260:
        r152 = r151;
        goto L261
    L251:
        r149 = 8;
        r150 = 0;
    L252:
        r149 = 8;
        r150 = 0;
        r148 = 1;
    L254:
        r149 = 8;
        r150 = 0;
        r148 = 1;
    L256:
        r151 = true;
        goto L258
    L255:
        r149 = 8;
        r150 = 0;
        r148 = 1;
        r144 = this;
        goto L256
    L203:
        if (this.resolvedHorizontal == true) goto L236;
        if (r511 == false) goto L223;
        HorizontalWidgetRun r169 = this.horizontalRun;
        if (r169 == null) goto L223;
        DependencyNode r170 = r169.start;
        if (r170.resolved == false) goto L223;
        if (r169.end.resolved == false) goto L223;
        if (r511 == false) goto L236;
        r510.addEquality(r110, r170.value);
        r510.addEquality(r310, this.horizontalRun.end.value);
        if (this.mParent == null) goto L221;
        if (r105 == false) goto L221;
        if (this.isTerminalWidget[0] == false) goto L221;
        if (isInHorizontalChain() == true) goto L221;
        r510.addGreaterThan(r510.createObjectVariable(this.mParent.mRight), r310, 0, 8);
    L221:
        r310 = r310;
        r410 = r110;
    L223:
        ConstraintWidget r171 = this.mParent;
        if (r171 == null) goto L226;
        SolverVariable r172 = r510.createObjectVariable(r171.mRight);
    L227:
        ConstraintWidget r173 = this.mParent;
        if (r173 == null) goto L230;
        SolverVariable r316 = r510.createObjectVariable(r173.mLeft);
    L231:
        boolean r317 = this.isTerminalWidget[0];
        DimensionBehaviour[] r174 = this.mListDimensionBehaviors;
        DimensionBehaviour r411 = r174[0];
        ConstraintAnchor r175 = this.mLeft;
        ConstraintAnchor r176 = this.mRight;
        int r177 = this.mX;
        int r178 = this.mMinWidth;
        int r412 = this.mMaxDimension[0];
        float r179 = this.mHorizontalBiasPercent;
        if (r174[1] != r126) goto L234;
        boolean r413 = true;
    L235:
        r310 = r310;
        r410 = r110;
        applyConstraints(r510, true, r105, r104, r317, r316, r172, r411, r142, r175, r176, r177, r218, r178, r412, r179, r217, r413, r211, r210, r314, r132, r133, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, r313);
        goto L237
    L234:
        r413 = false;
        goto L235
    L230:
        r316 = null;
        goto L231
    L226:
        r172 = null;
        goto L227
    L199:
        r218 = r134;
        goto L200
    L194:
        if ((this instanceof ConstraintWidgetContainer) == false) goto L196;
        r142 = true;
    L190:
        r312 = false;
    L182:
        r217 = true;
        goto L185
    L183:
        r138 = -1;
        goto L184
    L144:
        if (this.mVisibility == 8) goto L176;
        if (r125 != r126) goto L149;
        if (r132 != 0) goto L149;
        r132 = 3;
    L149:
        if (r128 != r126) goto L152;
        if (r133 != 0) goto L152;
        r133 = 3;
    L152:
        if (r125 != r126) goto L158;
        if (r128 != r126) goto L158;
        if (r132 != 3) goto L158;
        if (r133 != 3) goto L158;
        setupDimensionRatio(r105, r104, r127, r129);
    L173:
        r134 = r212;
    L174:
        r311 = r213;
    L175:
        r135 = true;
    L158:
        if (r125 != r126) goto L164;
        if (r132 != 3) goto L164;
        this.mResolvedDimensionRatioSide = 0;
        r134 = (int) (r131 * r122);
        if (r128 == r126) goto L174;
        r133 = r133;
        r311 = r213;
        r135 = false;
        r132 = 4;
    L164:
        if (r128 != r126) goto L173;
        if (r133 != 3) goto L173;
        this.mResolvedDimensionRatioSide = 1;
        if (r130 != (-1)) goto L169;
        this.mResolvedDimensionRatio = 1.0f / r131;
    L169:
        r311 = (int) (this.mResolvedDimensionRatio * r120);
        r132 = r132;
        if (r125 == r126) goto L172;
        r134 = r212;
        r135 = false;
        r133 = 4;
        goto L177
    L172:
        r133 = r133;
        r134 = r212;
        goto L175
    L140:
        r129 = false;
        goto L141
    L136:
        r127 = false;
        goto L137
    L96:
        if (isChainHead(0) == false) goto L98;
        ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
        boolean r180 = true;
    L100:
        if (isChainHead(1) == false) goto L102;
        ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
        boolean r181 = true;
    L103:
        if (r180 == true) goto L112;
        if (r105 == false) goto L112;
        if (this.mVisibility == 8) goto L112;
        if (this.mLeft.mTarget != null) goto L112;
        if (this.mRight.mTarget != null) goto L112;
        r510.addGreaterThan(r510.createObjectVariable(this.mParent.mRight), r111, 0, 1);
    L112:
        if (r181 == true) goto L123;
        if (r104 == false) goto L123;
        if (this.mVisibility == 8) goto L123;
        if (this.mTop.mTarget != null) goto L123;
        if (this.mBottom.mTarget != null) goto L123;
        if (this.mBaseline != null) goto L123;
        r510.addGreaterThan(r510.createObjectVariable(this.mParent.mBottom), r113, 0, 1);
    L123:
        r211 = r180;
        r210 = r181;
        goto L125
    L102:
        r181 = isInVerticalChain();
        goto L103
    L98:
        r180 = isInHorizontalChain();
        goto L100
    L53:
        if (this.resolvedVertical == false) goto L56;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        return;
    L28:
        if (this.resolvedVertical == false) goto L56;
    L19:
        if (hasDependencies() == true) goto L25;
        boolean[] r182 = this.mIsInBarrier;
        if (r182[0] == true) goto L25;
        if (r182[1] == true) goto L25;
        return;
    L11:
        if (r101.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT) goto L13;
        r103 = true;
        goto L14
    L6:
        if (r101.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) goto L8;
        r102 = true;
        goto L9
    L15:
        r105 = false;
        r104 = false;
        goto L17
    }

    public void copy(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        this.mHorizontalResolution = r100.mHorizontalResolution;
        this.mVerticalResolution = r100.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = r100.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = r100.mMatchConstraintDefaultHeight;
        int[] r102 = this.mResolvedMatchConstraintDefault;
        int[] r103 = r100.mResolvedMatchConstraintDefault;
        r102[0] = r103[0];
        r102[1] = r103[1];
        this.mMatchConstraintMinWidth = r100.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = r100.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = r100.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = r100.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = r100.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = r100.mIsWidthWrapContent;
        this.mIsHeightWrapContent = r100.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = r100.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = r100.mResolvedDimensionRatio;
        int[] r104 = r100.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(r104, r104.length);
        this.mCircleConstraintAngle = r100.mCircleConstraintAngle;
        this.hasBaseline = r100.hasBaseline;
        this.inPlaceholder = r100.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget r105 = null;
        if (this.mParent != null) goto L5;
        ConstraintWidget r106 = null;
    L6:
        this.mParent = r106;
        this.mWidth = r100.mWidth;
        this.mHeight = r100.mHeight;
        this.mDimensionRatio = r100.mDimensionRatio;
        this.mDimensionRatioSide = r100.mDimensionRatioSide;
        this.mX = r100.mX;
        this.mY = r100.mY;
        this.mRelX = r100.mRelX;
        this.mRelY = r100.mRelY;
        this.mOffsetX = r100.mOffsetX;
        this.mOffsetY = r100.mOffsetY;
        this.mBaselineDistance = r100.mBaselineDistance;
        this.mMinWidth = r100.mMinWidth;
        this.mMinHeight = r100.mMinHeight;
        this.mHorizontalBiasPercent = r100.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = r100.mVerticalBiasPercent;
        this.mCompanionWidget = r100.mCompanionWidget;
        this.mContainerItemSkip = r100.mContainerItemSkip;
        this.mVisibility = r100.mVisibility;
        this.mDebugName = r100.mDebugName;
        this.mType = r100.mType;
        this.mDistToTop = r100.mDistToTop;
        this.mDistToLeft = r100.mDistToLeft;
        this.mDistToRight = r100.mDistToRight;
        this.mDistToBottom = r100.mDistToBottom;
        this.mLeftHasCentered = r100.mLeftHasCentered;
        this.mRightHasCentered = r100.mRightHasCentered;
        this.mTopHasCentered = r100.mTopHasCentered;
        this.mBottomHasCentered = r100.mBottomHasCentered;
        this.mHorizontalWrapVisited = r100.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = r100.mVerticalWrapVisited;
        this.mHorizontalChainStyle = r100.mHorizontalChainStyle;
        this.mVerticalChainStyle = r100.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = r100.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = r100.mVerticalChainFixedPosition;
        float[] r107 = this.mWeight;
        float[] r108 = r100.mWeight;
        r107[0] = r108[0];
        r107[1] = r108[1];
        ConstraintWidget[] r109 = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] r110 = r100.mListNextMatchConstraintsWidget;
        r109[0] = r110[0];
        r109[1] = r110[1];
        ConstraintWidget[] r111 = this.mNextChainWidget;
        ConstraintWidget[] r112 = r100.mNextChainWidget;
        r111[0] = r112[0];
        r111[1] = r112[1];
        ConstraintWidget r113 = r100.mHorizontalNextWidget;
        if (r113 != null) goto L9;
        ConstraintWidget r114 = null;
    L10:
        this.mHorizontalNextWidget = r114;
        ConstraintWidget r115 = r100.mVerticalNextWidget;
        if (r115 == null) goto L14;
        r105 = r101.get(r115);
    L14:
        this.mVerticalNextWidget = r105;
        return;
    L9:
        r114 = r101.get(r113);
        goto L10
    L5:
        r106 = r101.get(r100.mParent);
        goto L6
    }

    public void setDebugSolverName(LinearSystem r100, String r101) {
        this.mDebugName = r101;
        SolverVariable r102 = r100.createObjectVariable(this.mLeft);
        SolverVariable r103 = r100.createObjectVariable(this.mTop);
        SolverVariable r104 = r100.createObjectVariable(this.mRight);
        SolverVariable r105 = r100.createObjectVariable(this.mBottom);
        r102.setName(r101 + ".left");
        r103.setName(r101 + ".top");
        r104.setName(r101 + ".right");
        r105.setName(r101 + ".bottom");
        r100.createObjectVariable(this.mBaseline).setName(r101 + ".baseline");
    }

    public void setDimension(int r100, int r101) {
        this.mWidth = r100;
        int r102 = this.mMinWidth;
        if (r100 >= r102) goto L5;
        this.mWidth = r102;
    L5:
        this.mHeight = r101;
        int r103 = this.mMinHeight;
        if (r101 >= r103) goto L9;
        this.mHeight = r103;
        return;
    }

    public void setDimensionRatio(float r100, int r101) {
        this.mDimensionRatio = r100;
        this.mDimensionRatioSide = r101;
    }

    public void setFinalHorizontal(int r100, int r101) {
        this.mLeft.setFinalValue(r100);
        this.mRight.setFinalValue(r101);
        this.mX = r100;
        this.mWidth = r101 - r100;
        this.resolvedHorizontal = true;
    }

    public void setFinalVertical(int r100, int r101) {
        this.mTop.setFinalValue(r100);
        this.mBottom.setFinalValue(r101);
        this.mY = r100;
        this.mHeight = r101 - r100;
        if (this.hasBaseline == false) goto L5;
        this.mBaseline.setFinalValue(r100 + this.mBaselineDistance);
    L5:
        this.resolvedVertical = true;
    }

    public void setGoneMargin(ConstraintAnchor.Type r100, int r101) {
        int r102 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r100.ordinal()];
        if (r102 != 1) goto L5;
        this.mLeft.mGoneMargin = r101;
        return;
    L5:
        if (r102 != 2) goto L7;
        this.mTop.mGoneMargin = r101;
        return;
    L7:
        if (r102 != 3) goto L9;
        this.mRight.mGoneMargin = r101;
        return;
    L9:
        if (r102 != 4) goto L19;
        this.mBottom.mGoneMargin = r101;
        return;
    }

    public void setHorizontalDimension(int r100, int r101) {
        this.mX = r100;
        int r102 = r101 - r100;
        this.mWidth = r102;
        int r103 = this.mMinWidth;
        if (r102 >= r103) goto L6;
        this.mWidth = r103;
        return;
    }

    public void setInBarrier(int r100, boolean r101) {
        this.mIsInBarrier[r100] = r101;
    }

    public void setLastMeasureSpec(int r100, int r101) {
        this.mLastHorizontalMeasureSpec = r100;
        this.mLastVerticalMeasureSpec = r101;
        setMeasureRequested(false);
    }

    public void setLength(int r100, int r101) {
        if (r101 != 0) goto L5;
        setWidth(r100);
        return;
    L5:
        if (r101 != 1) goto L9;
        setHeight(r100);
        return;
    }

    public void setOffset(int r100, int r101) {
        this.mOffsetX = r100;
        this.mOffsetY = r101;
    }

    public void setOrigin(int r100, int r101) {
        this.mX = r100;
        this.mY = r101;
    }

    public void setRelativePositioning(int r100, int r101) {
        if (r101 != 0) goto L5;
        this.mRelX = r100;
        return;
    L5:
        if (r101 != 1) goto L9;
        this.mRelY = r100;
        return;
    }

    public void setVerticalDimension(int r100, int r101) {
        this.mY = r100;
        int r102 = r101 - r100;
        this.mHeight = r102;
        int r103 = this.mMinHeight;
        if (r102 >= r103) goto L6;
        this.mHeight = r103;
        return;
    }

    public void updateFromRuns(boolean r100, boolean r101) {
        boolean r102 = r100 & this.horizontalRun.isResolved();
        boolean r103 = r101 & this.verticalRun.isResolved();
        HorizontalWidgetRun r104 = this.horizontalRun;
        int r105 = r104.start.value;
        VerticalWidgetRun r106 = this.verticalRun;
        int r107 = r106.start.value;
        int r108 = r104.end.value;
        int r109 = r106.end.value;
        int r110 = r109 - r107;
        if ((r108 - r105) < 0) goto L15;
        if (r110 < 0) goto L15;
        if (r105 == Integer.MIN_VALUE) goto L15;
        if (r105 == Integer.MAX_VALUE) goto L15;
        if (r107 == Integer.MIN_VALUE) goto L15;
        if (r107 == Integer.MAX_VALUE) goto L15;
        if (r108 == Integer.MIN_VALUE) goto L15;
        if (r108 == Integer.MAX_VALUE) goto L15;
        if (r109 == Integer.MIN_VALUE) goto L15;
        if (r109 == Integer.MAX_VALUE) goto L15;
    L16:
        int r111 = r108 - r105;
        int r112 = r109 - r107;
        if (r102 == false) goto L19;
        this.mX = r105;
    L19:
        if (r103 == false) goto L22;
        this.mY = r107;
    L22:
        if (this.mVisibility != 8) goto L25;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L25:
        if (r102 == true) goto L27;
    L34:
        if (r103 == true) goto L36;
        return;
    L36:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) goto L40;
        int r113 = this.mHeight;
        if (r112 >= r113) goto L40;
        r112 = r113;
    L40:
        this.mHeight = r112;
        int r114 = this.mMinHeight;
        if (r112 >= r114) goto L45;
        this.mHeight = r114;
        return;
    L45:
        return;
    L27:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) goto L31;
        int r115 = this.mWidth;
        if (r111 >= r115) goto L31;
        r111 = r115;
    L31:
        this.mWidth = r111;
        int r116 = this.mMinWidth;
        if (r111 >= r116) goto L34;
        this.mWidth = r116;
    L15:
        r108 = 0;
        r105 = 0;
        r109 = 0;
        r107 = 0;
        goto L16
    }

    public void updateFromSolver(LinearSystem r100, boolean r101) {
        int r102 = r100.getObjectVariableValue(this.mLeft);
        int r103 = r100.getObjectVariableValue(this.mTop);
        int r104 = r100.getObjectVariableValue(this.mRight);
        int r105 = r100.getObjectVariableValue(this.mBottom);
        if (r101 == false) goto L11;
        HorizontalWidgetRun r106 = this.horizontalRun;
        if (r106 == null) goto L11;
        DependencyNode r107 = r106.start;
        if (r107.resolved == false) goto L11;
        DependencyNode r108 = r106.end;
        if (r108.resolved == false) goto L11;
        r102 = r107.value;
        r104 = r108.value;
    L11:
        if (r101 == false) goto L19;
        VerticalWidgetRun r109 = this.verticalRun;
        if (r109 == null) goto L19;
        DependencyNode r110 = r109.start;
        if (r110.resolved == false) goto L19;
        DependencyNode r111 = r109.end;
        if (r111.resolved == false) goto L19;
        r103 = r110.value;
        r105 = r111.value;
    L19:
        int r112 = r105 - r103;
        if ((r104 - r102) < 0) goto L32;
        if (r112 < 0) goto L32;
        if (r102 == Integer.MIN_VALUE) goto L32;
        if (r102 == Integer.MAX_VALUE) goto L32;
        if (r103 == Integer.MIN_VALUE) goto L32;
        if (r103 == Integer.MAX_VALUE) goto L32;
        if (r104 == Integer.MIN_VALUE) goto L32;
        if (r104 == Integer.MAX_VALUE) goto L32;
        if (r105 == Integer.MIN_VALUE) goto L32;
        if (r105 == Integer.MAX_VALUE) goto L32;
    L33:
        setFrame(r102, r103, r104, r105);
        return;
    L32:
        r102 = 0;
        r105 = 0;
        r103 = 0;
        r104 = 0;
        goto L33
    }

    public ConstraintWidget(String r100, int r101, int r102) {
        this(r101, r102);
        setDebugName(r100);
    }

    public void connect(ConstraintAnchor r100, ConstraintAnchor r101, int r102) {
        if (r100.getOwner() != this) goto L6;
        connect(r100.getType(), r101.getOwner(), r101.getType(), r102);
        return;
    }

    public void connectCircularConstraint(ConstraintWidget r100, float r101, int r102) {
        ConstraintAnchor.Type r103 = ConstraintAnchor.Type.CENTER;
        immediateConnect(r103, r100, r103, r102, 0);
        this.mCircleConstraintAngle = r101;
    }

    public void setFrame(int r100, int r101, int r102) {
        if (r102 != 0) goto L5;
        setHorizontalDimension(r100, r101);
        return;
    L5:
        if (r102 != 1) goto L9;
        setVerticalDimension(r100, r101);
        return;
    }

    public void connect(ConstraintAnchor.Type r100, ConstraintWidget r101, ConstraintAnchor.Type r102) {
        connect(r100, r101, r102, 0);
    }

    public ConstraintWidget(int r110, int r111, int r112, int r113) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r100 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r100;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r100};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r101 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r101, r101};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r102 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r102;
        this.mVerticalBiasPercent = r102;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = r110;
        this.mY = r111;
        this.mWidth = r112;
        this.mHeight = r113;
        addAnchors();
    }

    public void connect(ConstraintAnchor.Type r100, ConstraintWidget r110, ConstraintAnchor.Type r111, int r112) {
        ConstraintAnchor.Type r101 = ConstraintAnchor.Type.CENTER;
        if (r100 != r101) goto L42;
        if (r111 != r101) goto L29;
        ConstraintAnchor.Type r102 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor r113 = getAnchor(r102);
        ConstraintAnchor.Type r114 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor r103 = getAnchor(r114);
        ConstraintAnchor.Type r104 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor r105 = getAnchor(r104);
        ConstraintAnchor.Type r106 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r107 = getAnchor(r106);
        boolean r108 = true;
        if (r113 != null) goto L8;
    L9:
        if (r103 != null) goto L11;
    L13:
        connect(r102, r110, r102, 0);
        connect(r114, r110, r114, 0);
        boolean r109 = true;
    L14:
        if (r105 != null) goto L16;
    L17:
        if (r107 != null) goto L19;
    L21:
        connect(r104, r110, r104, 0);
        connect(r106, r110, r106, 0);
    L22:
        if (r109 == false) goto L25;
        if (r108 == false) goto L25;
        getAnchor(r101).connect(r110.getAnchor(r101), 0);
        return;
    L25:
        if (r109 == false) goto L27;
        ConstraintAnchor.Type r115 = ConstraintAnchor.Type.CENTER_X;
        getAnchor(r115).connect(r110.getAnchor(r115), 0);
        return;
    L27:
        if (r108 == false) goto L104;
        ConstraintAnchor.Type r116 = ConstraintAnchor.Type.CENTER_Y;
        getAnchor(r116).connect(r110.getAnchor(r116), 0);
        return;
    L104:
        return;
    L19:
        if (r107.isConnected() == false) goto L21;
    L20:
        r108 = false;
        goto L22
    L16:
        if (r105.isConnected() == true) goto L20;
    L11:
        if (r103.isConnected() == false) goto L13;
    L12:
        r109 = false;
        goto L14
    L8:
        if (r113.isConnected() == true) goto L12;
    L29:
        ConstraintAnchor.Type r117 = ConstraintAnchor.Type.LEFT;
        if (r111 != r117) goto L32;
    L39:
        connect(r117, r110, r111, 0);
        connect(ConstraintAnchor.Type.RIGHT, r110, r111, 0);     // Catch: Throwable -> L98
        getAnchor(r101).connect(r110.getAnchor(r111), 0);
        return;
    L98:
        th = move-exception;
        throw th;
    L32:
        if (r111 == ConstraintAnchor.Type.RIGHT) goto L39;
        ConstraintAnchor.Type r118 = ConstraintAnchor.Type.TOP;
        if (r111 != r118) goto L37;
    L38:
        connect(r118, r110, r111, 0);
        connect(ConstraintAnchor.Type.BOTTOM, r110, r111, 0);
        getAnchor(r101).connect(r110.getAnchor(r111), 0);
        return;
    L37:
        if (r111 == ConstraintAnchor.Type.BOTTOM) goto L38;
        return;
    L42:
        ConstraintAnchor.Type r119 = ConstraintAnchor.Type.CENTER_X;
        if (r100 != r119) goto L49;
        ConstraintAnchor.Type r120 = ConstraintAnchor.Type.LEFT;
        if (r111 != r120) goto L47;
    L48:
        ConstraintAnchor r121 = getAnchor(r120);
        ConstraintAnchor r122 = r110.getAnchor(r111);
        ConstraintAnchor r123 = getAnchor(ConstraintAnchor.Type.RIGHT);
        r121.connect(r122, 0);
        r123.connect(r122, 0);
        getAnchor(r119).connect(r122, 0);
        return;
    L47:
        if (r111 == ConstraintAnchor.Type.RIGHT) goto L48;
    L49:
        ConstraintAnchor.Type r124 = ConstraintAnchor.Type.CENTER_Y;
        if (r100 != r124) goto L56;
        ConstraintAnchor.Type r125 = ConstraintAnchor.Type.TOP;
        if (r111 != r125) goto L54;
    L55:
        ConstraintAnchor r126 = r110.getAnchor(r111);
        getAnchor(r125).connect(r126, 0);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r126, 0);
        getAnchor(r124).connect(r126, 0);
        return;
    L54:
        if (r111 == ConstraintAnchor.Type.BOTTOM) goto L55;
    L56:
        if (r100 != r119) goto L59;
        if (r111 != r119) goto L59;
        ConstraintAnchor.Type r127 = ConstraintAnchor.Type.LEFT;
        getAnchor(r127).connect(r110.getAnchor(r127), 0);
        ConstraintAnchor.Type r128 = ConstraintAnchor.Type.RIGHT;
        getAnchor(r128).connect(r110.getAnchor(r128), 0);
        getAnchor(r119).connect(r110.getAnchor(r111), 0);
        return;
    L59:
        if (r100 != r124) goto L62;
        if (r111 != r124) goto L62;
        ConstraintAnchor.Type r129 = ConstraintAnchor.Type.TOP;
        getAnchor(r129).connect(r110.getAnchor(r129), 0);
        ConstraintAnchor.Type r130 = ConstraintAnchor.Type.BOTTOM;
        getAnchor(r130).connect(r110.getAnchor(r130), 0);
        getAnchor(r124).connect(r110.getAnchor(r111), 0);
        return;
    L62:
        ConstraintAnchor r131 = getAnchor(r100);
        ConstraintAnchor r132 = r110.getAnchor(r111);
        if (r131.isValidConnection(r132) == false) goto L113;
        ConstraintAnchor.Type r133 = ConstraintAnchor.Type.BASELINE;
        if (r100 != r133) goto L73;
        ConstraintAnchor r134 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r135 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r134 == null) goto L69;
        r134.reset();
    L69:
        if (r135 == null) goto L71;
        r135.reset();
    L71:
        r112 = 0;
    L96:
        r131.connect(r132, r112);
        return;
    L73:
        if (r100 != ConstraintAnchor.Type.TOP) goto L75;
    L87:
        ConstraintAnchor r136 = getAnchor(r133);
        if (r136 == null) goto L90;
        r136.reset();
    L90:
        ConstraintAnchor r137 = getAnchor(r101);
        if (r137.getTarget() == r132) goto L93;
        r137.reset();
    L93:
        ConstraintAnchor r138 = getAnchor(r100).getOpposite();
        ConstraintAnchor r139 = getAnchor(r124);
        if (r139.isConnected() == false) goto L96;
        r138.reset();
        r139.reset();
        goto L96
    L75:
        if (r100 == ConstraintAnchor.Type.BOTTOM) goto L87;
        if (r100 != ConstraintAnchor.Type.LEFT) goto L80;
    L81:
        ConstraintAnchor r140 = getAnchor(r101);
        if (r140.getTarget() == r132) goto L84;
        r140.reset();
    L84:
        ConstraintAnchor r141 = getAnchor(r100).getOpposite();
        ConstraintAnchor r142 = getAnchor(r119);
        if (r142.isConnected() == false) goto L96;
        r141.reset();
        r142.reset();
        goto L96
    L80:
        if (r100 != ConstraintAnchor.Type.RIGHT) goto L96;
    }

    public void setFrame(int r100, int r101, int r102, int r103) {
        int r104 = r102 - r100;
        int r105 = r103 - r101;
        this.mX = r100;
        this.mY = r101;
        if (this.mVisibility != 8) goto L6;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L6:
        DimensionBehaviour[] r106 = this.mListDimensionBehaviors;
        DimensionBehaviour r107 = r106[0];
        DimensionBehaviour r108 = DimensionBehaviour.FIXED;
        if (r107 != r108) goto L12;
        int r109 = this.mWidth;
        if (r104 >= r109) goto L12;
        r104 = r109;
    L12:
        if (r106[1] != r108) goto L16;
        int r110 = this.mHeight;
        if (r105 >= r110) goto L16;
        r105 = r110;
    L16:
        this.mWidth = r104;
        this.mHeight = r105;
        int r111 = this.mMinHeight;
        if (r105 >= r111) goto L19;
        this.mHeight = r111;
    L19:
        int r112 = this.mMinWidth;
        if (r104 >= r112) goto L23;
        this.mWidth = r112;
        return;
    }

    public void setHorizontalMatchStyle(int r100, int r101, int r102, float r103) {
        this.mMatchConstraintDefaultWidth = r100;
        this.mMatchConstraintMinWidth = r101;
        if (r102 != Integer.MAX_VALUE) goto L5;
        r102 = 0;
    L5:
        this.mMatchConstraintMaxWidth = r102;
        this.mMatchConstraintPercentWidth = r103;
        if (r103 > 0.0f) goto L8;
        return;
    L8:
        if (r103 >= 1.0f) goto L13;
        if (r100 != 0) goto L14;
        this.mMatchConstraintDefaultWidth = 2;
        return;
    L14:
        return;
    }

    public void setVerticalMatchStyle(int r100, int r101, int r102, float r103) {
        this.mMatchConstraintDefaultHeight = r100;
        this.mMatchConstraintMinHeight = r101;
        if (r102 != Integer.MAX_VALUE) goto L5;
        r102 = 0;
    L5:
        this.mMatchConstraintMaxHeight = r102;
        this.mMatchConstraintPercentHeight = r103;
        if (r103 > 0.0f) goto L8;
        return;
    L8:
        if (r103 >= 1.0f) goto L13;
        if (r100 != 0) goto L14;
        this.mMatchConstraintDefaultHeight = 2;
        return;
    L14:
        return;
    }

    public void setupDimensionRatio(boolean r100, boolean r101, boolean r102, boolean r103) {
        if (this.mResolvedDimensionRatioSide != (-1)) goto L13;
        if (r102 == false) goto L7;
        if (r103 == true) goto L7;
        this.mResolvedDimensionRatioSide = 0;
    L7:
        if (r102 == true) goto L13;
        if (r103 == false) goto L13;
        this.mResolvedDimensionRatioSide = 1;
        if (this.mDimensionRatioSide != (-1)) goto L13;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
    L13:
        if (this.mResolvedDimensionRatioSide != 0) goto L20;
        if (this.mTop.isConnected() == true) goto L17;
    L18:
        this.mResolvedDimensionRatioSide = 1;
    L27:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L47;
        if (this.mTop.isConnected() == false) goto L37;
        if (this.mBottom.isConnected() == false) goto L37;
        if (this.mLeft.isConnected() == false) goto L37;
        if (this.mRight.isConnected() == true) goto L47;
    L37:
        if (this.mTop.isConnected() == false) goto L42;
        if (this.mBottom.isConnected() == false) goto L42;
        this.mResolvedDimensionRatioSide = 0;
    L42:
        if (this.mLeft.isConnected() == false) goto L47;
        if (this.mRight.isConnected() == false) goto L47;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
    L47:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L58;
        int r104 = this.mMatchConstraintMinWidth;
        if (r104 > 0) goto L51;
    L53:
        if (r104 == 0) goto L55;
        return;
    L55:
        if (this.mMatchConstraintMinHeight <= 0) goto L61;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
        return;
    L61:
        return;
    L51:
        if (this.mMatchConstraintMinHeight != 0) goto L53;
        this.mResolvedDimensionRatioSide = 0;
        return;
    L58:
        return;
    L17:
        if (this.mBottom.isConnected() == false) goto L18;
    L20:
        if (this.mResolvedDimensionRatioSide != 1) goto L27;
        if (this.mLeft.isConnected() == true) goto L24;
    L25:
        this.mResolvedDimensionRatioSide = 0;
        goto L27
    L24:
        if (this.mRight.isConnected() == true) goto L27;
        goto L25
    }

    public ConstraintWidget(String r100, int r101, int r102, int r103, int r104) {
        this(r101, r102, r103, r104);
        setDebugName(r100);
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer r100, LinearSystem r101, HashSet<ConstraintWidget> r110, int r111, boolean r112) {
        if (r112 == true) goto L4;
    L7:
        if (r111 != 0) goto L20;
        HashSet<ConstraintAnchor> r113 = this.mLeft.getDependents();
        if (r113 == null) goto L14;
        Iterator<ConstraintAnchor> r114 = r113.iterator();
    L12:
        if (r114.hasNext() == false) goto L14;
        r114.next().mOwner.addChildrenToSolverByDependency(r100, r101, r110, r111, true);
    L14:
        HashSet<ConstraintAnchor> r115 = this.mRight.getDependents();
        if (r115 == null) goto L40;
        Iterator<ConstraintAnchor> r116 = r115.iterator();
    L18:
        if (r116.hasNext() == false) goto L52;
        r116.next().mOwner.addChildrenToSolverByDependency(r100, r101, r110, r111, true);
        goto L18
    L52:
        return;
    L40:
        return;
    L20:
        HashSet<ConstraintAnchor> r117 = this.mTop.getDependents();
        if (r117 == null) goto L26;
        Iterator<ConstraintAnchor> r118 = r117.iterator();
    L24:
        if (r118.hasNext() == false) goto L26;
        r118.next().mOwner.addChildrenToSolverByDependency(r100, r101, r110, r111, true);
    L26:
        HashSet<ConstraintAnchor> r119 = this.mBottom.getDependents();
        if (r119 == null) goto L32;
        Iterator<ConstraintAnchor> r120 = r119.iterator();
    L30:
        if (r120.hasNext() == false) goto L32;
        r120.next().mOwner.addChildrenToSolverByDependency(r100, r101, r110, r111, true);
    L32:
        HashSet<ConstraintAnchor> r121 = this.mBaseline.getDependents();
        if (r121 == null) goto L51;
        Iterator<ConstraintAnchor> r122 = r121.iterator();
    L36:
        if (r122.hasNext() == false) goto L53;
        r122.next().mOwner.addChildrenToSolverByDependency(r100, r101, r110, r111, true);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L53:
        return;
    L51:
        return;
    L4:
        if (r110.contains(this) == true) goto L6;
        return;
    L6:
        Optimizer.checkMatchParent(r100, r101, this);
        r110.remove(this);
        addToSolver(r101, r100.optimizeFor(64));
        goto L7
    }

    public void immediateConnect(ConstraintAnchor.Type r100, ConstraintWidget r101, ConstraintAnchor.Type r102, int r103, int r104) {
        getAnchor(r100).connect(r101.getAnchor(r102), r103, r104, true);
    }

    public void setFinalFrame(int r100, int r101, int r102, int r103, int r104, int r105) {
        setFrame(r100, r101, r102, r103);
        setBaselineDistance(r104);
        if (r105 != 0) goto L5;
        this.resolvedHorizontal = true;
        this.resolvedVertical = false;
        return;
    L5:
        if (r105 != 1) goto L8;
        this.resolvedHorizontal = false;
        this.resolvedVertical = true;
        return;
    L8:
        if (r105 != 2) goto L10;
        this.resolvedHorizontal = true;
        this.resolvedVertical = true;
        return;
    L10:
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
    }

    private void applyConstraints(LinearSystem r310, boolean r311, boolean r312, boolean r313, boolean r314, SolverVariable r315, SolverVariable r316, DimensionBehaviour r317, boolean r410, ConstraintAnchor r411, ConstraintAnchor r412, int r413, int r414, int r415, int r416, float r417, boolean r418, boolean r419, boolean r510, boolean r511, boolean r512, int r513, int r514, int r515, int r516, float r517, boolean r518) {
        SolverVariable r100 = r310.createObjectVariable(r411);
        SolverVariable r101 = r310.createObjectVariable(r412);
        SolverVariable r102 = r310.createObjectVariable(r411.getTarget());
        SolverVariable r103 = r310.createObjectVariable(r412.getTarget());
        if (LinearSystem.getMetrics() == null) goto L5;
        LinearSystem.getMetrics().nonresolvedWidgets++;
    L5:
        boolean r110 = r411.isConnected();
        boolean r111 = r412.isConnected();
        boolean r112 = this.mCenter.isConnected();
        if (r111 == false) goto L8;
        int r104 = (r110 ? 1 : 0) + 1;
    L9:
        if (r112 == false) goto L11;
        r104 = r104 + 1;
    L11:
        if (r418 == false) goto L13;
        int r113 = 3;
    L14:
        int r105 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[r317.ordinal()];
        if (r105 != 1) goto L17;
    L22:
        int r106 = r113;
    L23:
        boolean r114 = false;
    L28:
        if (this.mVisibility != 8) goto L30;
        int r115 = 0;
        r114 = false;
    L31:
        if (r518 == false) goto L40;
        if (r110 == true) goto L36;
        if (r111 == true) goto L36;
        if (r112 == true) goto L36;
        r310.addEquality(r100, r413);
    L36:
        if (r110 == false) goto L40;
        if (r111 == true) goto L40;
        r310.addEquality(r100, r102, r411.getMargin(), 8);
    L40:
        if (r114 == true) goto L53;
        if (r410 == false) goto L48;
        r310.addEquality(r101, r100, 0, 3);
        if (r415 <= 0) goto L46;
        r310.addGreaterThan(r101, r100, r415, 8);
    L46:
        if (r416 >= Integer.MAX_VALUE) goto L49;
        r310.addLowerThan(r101, r100, r416, 8);
    L49:
        int r210 = r515;
        int r107 = r516;
    L50:
        boolean r211 = r114;
    L51:
        int r212 = r104;
    L105:
        if (r518 == false) goto L324;
        if (r510 == false) goto L108;
        int r108 = 0;
        char r109 = 2;
    L325:
        if (r212 >= r109) goto L357;
        if (r312 == false) goto L358;
        if (r314 == false) goto L359;
        r310.addGreaterThan(r100, r315, r108, 8);
        if (r311 == false) goto L331;
    L334:
        boolean r116 = true;
    L335:
        if (r311 == true) goto L346;
        ConstraintAnchor r117 = this.mBaseline.mTarget;
        if (r117 == null) goto L346;
        ConstraintWidget r118 = r117.mOwner;
        if (r118.mDimensionRatio == 0.0f) goto L345;
        DimensionBehaviour[] r119 = r118.mListDimensionBehaviors;
        DimensionBehaviour r120 = r119[r108];
        DimensionBehaviour r121 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r120 != r121) goto L345;
        if (r119[1] != r121) goto L345;
        boolean r122 = true;
    L347:
        if (r122 == false) goto L360;
        r310.addGreaterThan(r316, r101, r108, 8);
        return;
    L360:
        return;
    L345:
        r122 = false;
    L346:
        r122 = r116;
        goto L347
    L331:
        if (this.mBaseline.mTarget == null) goto L334;
        r116 = false;
        goto L335
    L359:
        return;
    L358:
        return;
    L357:
        return;
    L108:
        if (r110 == true) goto L112;
        if (r111 == true) goto L112;
        if (r112 == true) goto L112;
    L303:
        SolverVariable r123 = r101;
        int r124 = 0;
        boolean r213 = r312;
    L304:
        if (r213 == false) goto L354;
        if (r314 == true) goto L307;
        return;
    L307:
        if (r412.mTarget == null) goto L310;
        r124 = r412.getMargin();
    L310:
        if (r103 != r316) goto L312;
        return;
    L312:
        if (this.OPTIMIZE_WRAP == true) goto L314;
    L322:
        r310.addGreaterThan(r316, r123, r124, 5);
        return;
    L314:
        if (r123.isFinalValue == false) goto L322;
        ConstraintWidget r125 = this.mParent;
        if (r125 == null) goto L322;
        ConstraintWidgetContainer r126 = (ConstraintWidgetContainer) r125;
        if (r311 == false) goto L320;
        r126.addHorizontalWrapMaxVariable(r412);
        return;
    L320:
        r126.addVerticalWrapMaxVariable(r412);
        return;
    L354:
        return;
    L112:
        if (r110 == false) goto L115;
        if (r111 == false) goto L303;
    L115:
        if (r110 == true) goto L131;
        if (r111 == false) goto L131;
        r310.addEquality(r101, r103, -r412.getMargin(), 8);
        if (r312 == false) goto L303;
        if (this.OPTIMIZE_WRAP == true) goto L122;
    L129:
        r310.addGreaterThan(r100, r315, 0, 5);
        goto L303
    L122:
        if (r100.isFinalValue == false) goto L129;
        ConstraintWidget r127 = this.mParent;
        if (r127 == null) goto L129;
        ConstraintWidgetContainer r128 = (ConstraintWidgetContainer) r127;
        if (r311 == false) goto L128;
        r128.addHorizontalWrapMinVariable(r411);
        goto L303
    L128:
        r128.addVerticalWrapMinVariable(r411);
    L131:
        if (r110 == false) goto L303;
        if (r111 == false) goto L303;
        ConstraintWidget r129 = r411.mTarget.mOwner;
        ConstraintWidget r130 = r412.mTarget.mOwner;
        ConstraintWidget r131 = getParent();
        int r132 = 6;
        if (r211 == false) goto L195;
        if (r106 != 0) goto L155;
        if (r107 != 0) goto L145;
        if (r210 != 0) goto L145;
        if (r102.isFinalValue == true) goto L141;
    L144:
        boolean r133 = false;
        boolean r134 = true;
        boolean r135 = false;
        int r214 = 8;
        int r215 = 8;
    L147:
        if ((r129 instanceof Barrier) == false) goto L149;
    L152:
        r215 = 4;
    L153:
        boolean r216 = r134;
        int r136 = 6;
    L212:
        if (r135 == false) goto L216;
        if (r102 != r103) goto L216;
        if (r129 == r131) goto L216;
        r135 = false;
        boolean r217 = false;
    L217:
        if (r133 == false) goto L226;
        if (r211 == true) goto L224;
        if (r419 == true) goto L224;
        if (r511 == true) goto L224;
        if (r102 != r315) goto L224;
        if (r103 != r316) goto L224;
        r213 = false;
        int r218 = 8;
        boolean r219 = false;
        int r220 = 8;
    L225:
        int r318 = r106;
        ConstraintWidget r221 = r131;
        r310.addCentering(r100, r102, r411.getMargin(), r417, r103, r101, r412.getMargin(), r218);
        r217 = r219;
    L228:
        if (this.mVisibility == 8) goto L230;
    L232:
        if (r135 == false) goto L243;
        if (r213 == false) goto L241;
        if (r102 == r103) goto L241;
        if (r211 == true) goto L241;
        if ((r129 instanceof Barrier) == false) goto L239;
    L240:
        int r137 = 6;
    L242:
        r310.addGreaterThan(r100, r102, r411.getMargin(), r137);
        SolverVariable r138 = r101;
        r310.addLowerThan(r138, r103, -r412.getMargin(), r137);
        r220 = r137;
    L244:
        if (r213 == false) goto L251;
        if (r512 == false) goto L251;
        if ((r129 instanceof Barrier) == true) goto L251;
        if ((r130 instanceof Barrier) == true) goto L251;
        int r139 = 6;
        int r140 = 6;
        r217 = true;
    L252:
        if (r217 == false) goto L284;
        if (r216 == false) goto L275;
        if (r511 == false) goto L256;
        if (r313 == false) goto L275;
    L256:
        ConstraintWidget r141 = r221;
        if (r129 == r141) goto L262;
        if (r130 == r141) goto L262;
        r132 = r139;
    L262:
        if ((r129 instanceof Guideline) == false) goto L264;
    L265:
        r132 = 5;
    L267:
        if ((r129 instanceof Barrier) == false) goto L269;
    L270:
        r132 = 5;
    L271:
        if (r511 == false) goto L273;
        int r142 = 5;
    L274:
        r139 = Math.max(r142, r139);
    L276:
        if (r213 == false) goto L283;
        r139 = Math.min(r140, r139);
        if (r418 == false) goto L283;
        if (r511 == true) goto L283;
        if (r129 == r141) goto L282;
        if (r130 != r141) goto L283;
    L282:
        r139 = 4;
    L283:
        r310.addEquality(r100, r102, r411.getMargin(), r139);
        r310.addEquality(r138, r103, -r412.getMargin(), r139);
        goto L284
    L273:
        r142 = r132;
        goto L274
    L269:
        if ((r130 instanceof Barrier) == false) goto L271;
    L264:
        if ((r130 instanceof Guideline) == false) goto L267;
    L275:
        r141 = r221;
    L284:
        if (r213 == true) goto L286;
    L291:
        if (r213 == false) goto L301;
        if (r211 == false) goto L301;
        r123 = r138;
        if (r415 != 0) goto L302;
        if (r210 != 0) goto L302;
        if (r211 == true) goto L298;
    L300:
        r124 = 0;
        r310.addGreaterThan(r123, r100, 0, 5);
        goto L304
    L298:
        if (r318 != 3) goto L300;
        r124 = 0;
        r310.addGreaterThan(r123, r100, 0, 8);
    L302:
        r124 = 0;
    L301:
        r123 = r138;
        goto L302
    L286:
        if (r315 != r102) goto L288;
        int r143 = r411.getMargin();
    L289:
        if (r102 == r315) goto L291;
        r310.addGreaterThan(r100, r315, r143, 5);
        goto L291
    L288:
        r143 = 0;
    L251:
        r139 = r215;
        r140 = r220;
        goto L252
    L239:
        if ((r130 instanceof Barrier) == true) goto L240;
    L241:
        r137 = r220;
        goto L242
    L243:
        r138 = r101;
        goto L244
    L230:
        if (r412.hasDependents() == true) goto L232;
        return;
    L224:
        r220 = r214;
        r219 = r217;
        r213 = r312;
        r218 = r136;
        goto L225
    L226:
        r318 = r106;
        r221 = r131;
        r220 = r214;
        r213 = r312;
    L216:
        r217 = true;
        goto L217
    L149:
        if ((r130 instanceof Barrier) == false) goto L153;
    L141:
        if (r103.isFinalValue == false) goto L144;
        r310.addEquality(r100, r102, r411.getMargin(), 8);
        r310.addEquality(r101, r103, -r412.getMargin(), 8);
        return;
    L145:
        r133 = true;
        r134 = false;
        r135 = true;
        r214 = 5;
        r215 = 5;
        goto L147
    L155:
        if (r106 != 1) goto L159;
        r316 = r316;
        r133 = true;
        r136 = 6;
        r135 = true;
        r216 = false;
        r215 = 4;
    L157:
        r214 = 8;
        goto L212
    L159:
        if (r106 == 3) goto L161;
        r133 = false;
        r136 = 6;
        r135 = false;
    L209:
        r216 = false;
    L210:
        r215 = 4;
    L211:
        r214 = 5;
        goto L212
    L161:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L169;
        if (r511 == false) goto L167;
        r316 = r316;
        r133 = true;
        if (r312 == false) goto L166;
        r136 = 5;
    L168:
        r135 = true;
        r216 = true;
        r215 = 5;
        goto L157
    L166:
        r136 = 4;
        goto L168
    L167:
        r316 = r316;
        r133 = true;
        r136 = 8;
        goto L168
    L169:
        if (r418 == true) goto L171;
        if (r107 <= 0) goto L183;
        r316 = r316;
        r133 = true;
        r136 = 6;
        r135 = true;
        r216 = true;
        r215 = 5;
        goto L211
    L183:
        if (r107 != 0) goto L192;
        if (r210 != 0) goto L192;
        if (r511 == true) goto L187;
        r316 = r316;
        r133 = true;
        r136 = 6;
        r135 = true;
        r216 = true;
        r215 = 8;
        goto L211
    L187:
        if (r129 == r131) goto L190;
        if (r130 == r131) goto L190;
        int r144 = 4;
    L191:
        r316 = r316;
        r214 = r144;
        r133 = true;
        r136 = 6;
        r135 = true;
        r216 = true;
        r215 = 4;
    L190:
        r144 = 5;
    L192:
        r316 = r316;
        r133 = true;
        r136 = 6;
        r135 = true;
        r216 = true;
        goto L210
    L171:
        if (r514 != 2) goto L173;
    L176:
        boolean r145 = true;
    L177:
        if (r145 == true) goto L179;
        int r146 = 8;
        int r147 = 5;
    L180:
        r316 = r316;
        r214 = r146;
        r215 = r147;
        r133 = true;
        r136 = 6;
        r135 = true;
        r216 = true;
        goto L212
    L179:
        r146 = 5;
        r147 = 4;
        goto L180
    L173:
        if (r514 == 1) goto L176;
        r145 = false;
        goto L177
    L195:
        if (r102.isFinalValue == true) goto L197;
    L208:
        r133 = true;
        r136 = 6;
        r135 = true;
        goto L209
    L197:
        if (r103.isFinalValue == false) goto L208;
        r310.addCentering(r100, r102, r411.getMargin(), r417, r103, r101, r412.getMargin(), 8);
        if (r312 == false) goto L350;
        if (r314 == true) goto L202;
        return;
    L202:
        if (r412.mTarget == null) goto L204;
        int r148 = r412.getMargin();
    L205:
        if (r103 == r316) goto L352;
        r310.addGreaterThan(r316, r101, r148, 5);
        return;
    L352:
        return;
    L204:
        r148 = 0;
        goto L205
    L350:
        return;
    L324:
        r108 = 0;
        r109 = 2;
        goto L325
    L48:
        r310.addEquality(r101, r100, r115, 8);
        goto L49
    L53:
        if (r104 == 2) goto L63;
        if (r418 == true) goto L63;
        if (r106 == 1) goto L58;
        if (r106 != 0) goto L63;
    L58:
        int r149 = Math.max(r515, r115);
        if (r516 <= 0) goto L61;
        r149 = Math.min(r516, r149);
    L61:
        r310.addEquality(r101, r100, r149, 8);
        r210 = r515;
        r107 = r516;
        r102 = r102;
        r101 = r101;
        r211 = false;
    L63:
        if (r515 != (-2)) goto L65;
        int r150 = r115;
    L66:
        if (r516 != (-2)) goto L68;
        r107 = r115;
    L69:
        if (r115 > 0) goto L71;
    L73:
        if (r150 <= 0) goto L75;
        r310.addGreaterThan(r101, r100, r150, 8);
        r115 = Math.max(r115, r150);
    L75:
        if (r107 <= 0) goto L85;
        if (r312 == true) goto L78;
    L80:
        boolean r151 = true;
    L81:
        if (r151 == false) goto L83;
        int r152 = 8;
        r310.addLowerThan(r101, r100, r107, 8);
    L84:
        r115 = Math.min(r115, r107);
    L87:
        if (r106 != 1) goto L95;
        if (r312 == false) goto L90;
        r310.addEquality(r101, r100, r115, r152);
    L93:
        r210 = r150;
        goto L50
    L90:
        if (r510 == false) goto L92;
        r310.addEquality(r101, r100, r115, 5);
        r310.addLowerThan(r101, r100, r115, r152);
        goto L93
    L92:
        r310.addEquality(r101, r100, r115, 5);
        r310.addLowerThan(r101, r100, r115, r152);
        goto L93
    L95:
        if (r106 != 2) goto L104;
        ConstraintAnchor.Type r153 = r411.getType();
        ConstraintAnchor.Type r154 = ConstraintAnchor.Type.TOP;
        if (r153 != r154) goto L99;
    L102:
        SolverVariable r155 = r310.createObjectVariable(this.mParent.getAnchor(r154));
        SolverVariable r156 = r310.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
    L103:
        SolverVariable r157 = r155;
        ArrayRow r158 = r310.createRow();
        int r420 = r150;
        r103 = r103;
        r212 = r104 == true ? 1 : 0;
        r102 = r102;
        r101 = r101;
        r310.addConstraint(r158.createRowDimensionRatio(r101, r100, r156, r157, r517));
        r314 = r314;
        r210 = r420;
        r211 = false;
        goto L105
    L99:
        if (r411.getType() == ConstraintAnchor.Type.BOTTOM) goto L102;
        r155 = r310.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
        r156 = r310.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
        goto L103
    L104:
        r102 = r102;
        r101 = r101;
        int r421 = r150;
        r103 = r103;
        r212 = r104;
        r210 = r421;
        r211 = r114;
        r314 = true;
        goto L105
    L83:
        r152 = 8;
        goto L84
    L78:
        if (r106 != 1) goto L80;
        r151 = false;
        goto L81
    L85:
        r152 = 8;
        goto L87
    L71:
        if (r106 == 1) goto L73;
        r115 = 0;
        goto L73
    L68:
        r107 = r516;
        goto L69
    L65:
        r150 = r515;
        goto L66
    L30:
        r115 = r414;
        goto L31
    L17:
        if (r105 == 2) goto L22;
        if (r105 == 3) goto L22;
        if (r105 != 4) goto L22;
        r106 = r113;
        if (r106 == 4) goto L23;
        r114 = true;
        goto L28
    L13:
        r113 = r513;
        goto L14
    L8:
        r104 = r110 ? 1 : 0;
        goto L9
    }
}
