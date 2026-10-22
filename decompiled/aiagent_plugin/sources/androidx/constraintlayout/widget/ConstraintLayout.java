package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.c.h;
import androidx.constraintlayout.a.c.k;
import androidx.constraintlayout.a.c.m;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static e sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected b mConstraintLayoutSpec;
    private c mConstraintSet;
    private int mConstraintSetId;
    private d mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected androidx.constraintlayout.a.c.f mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    a mMeasurer;
    private androidx.constraintlayout.a.e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<androidx.constraintlayout.a.c.e> mTempMapIdToWidget;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f936a = null;

        static {
            int[] r0 = new int[androidx.constraintlayout.a.c.e.a.values().length];
            f936a = r0;
            r0[androidx.constraintlayout.a.c.e.a.f775a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f936a[androidx.constraintlayout.a.c.e.a.f776b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f936a[androidx.constraintlayout.a.c.e.a.f778d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f936a[androidx.constraintlayout.a.c.e.a.f777c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;
        boolean heightSet;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        androidx.constraintlayout.a.c.e widget;
        boolean widthSet;
        public int wrapBehaviorInParent;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f937a = null;

            static {
                SparseIntArray r0 = new SparseIntArray();
                f937a = r0;
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, "styleable", "ConstraintLayout_Layout_layout_constraintWidth"), 64);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, "styleable", "ConstraintLayout_Layout_layout_constraintHeight"), 65);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_toLeftOf"), 8);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_toRightOf"), 9);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, "styleable", "ConstraintLayout_Layout_layout_constraintRight_toLeftOf"), 10);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, "styleable", "ConstraintLayout_Layout_layout_constraintRight_toRightOf"), 11);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintTop_toTopOf"), 12);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintTop_toBottomOf"), 13);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_toTopOf"), 14);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_toBottomOf"), 15);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf"), 16);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toTopOf"), 52);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf"), 53);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, "styleable", "ConstraintLayout_Layout_layout_constraintCircle"), 2);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, "styleable", "ConstraintLayout_Layout_layout_constraintCircleRadius"), 3);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, "styleable", "ConstraintLayout_Layout_layout_constraintCircleAngle"), 4);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, "styleable", "ConstraintLayout_Layout_layout_editor_absoluteX"), 49);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, "styleable", "ConstraintLayout_Layout_layout_editor_absoluteY"), 50);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_begin"), 5);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_end"), 6);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_percent"), 7);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, "styleable", "ConstraintLayout_Layout_guidelineUseRtl"), 67);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_orientation, "styleable", "ConstraintLayout_Layout_android_orientation"), 1);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, "styleable", "ConstraintLayout_Layout_layout_constraintStart_toEndOf"), 17);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, "styleable", "ConstraintLayout_Layout_layout_constraintStart_toStartOf"), 18);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, "styleable", "ConstraintLayout_Layout_layout_constraintEnd_toStartOf"), 19);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, "styleable", "ConstraintLayout_Layout_layout_constraintEnd_toEndOf"), 20);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, "styleable", "ConstraintLayout_Layout_layout_goneMarginLeft"), 21);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, "styleable", "ConstraintLayout_Layout_layout_goneMarginTop"), 22);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, "styleable", "ConstraintLayout_Layout_layout_goneMarginRight"), 23);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, "styleable", "ConstraintLayout_Layout_layout_goneMarginBottom"), 24);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, "styleable", "ConstraintLayout_Layout_layout_goneMarginStart"), 25);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, "styleable", "ConstraintLayout_Layout_layout_goneMarginEnd"), 26);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, "styleable", "ConstraintLayout_Layout_layout_goneMarginBaseline"), 55);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, "styleable", "ConstraintLayout_Layout_layout_marginBaseline"), 54);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_bias"), 29);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_bias"), 30);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, "styleable", "ConstraintLayout_Layout_layout_constraintDimensionRatio"), 44);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_weight"), 45);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_weight"), 46);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle"), 47);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_chainStyle"), 48);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, "styleable", "ConstraintLayout_Layout_layout_constrainedWidth"), 27);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, "styleable", "ConstraintLayout_Layout_layout_constrainedHeight"), 28);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_default"), 31);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_default"), 32);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_min"), 33);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_max"), 34);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_percent"), 35);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_min"), 36);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_max"), 37);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_percent"), 38);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_creator"), 39);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, "styleable", "ConstraintLayout_Layout_layout_constraintTop_creator"), 40);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, "styleable", "ConstraintLayout_Layout_layout_constraintRight_creator"), 41);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_creator"), 42);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_creator"), 43);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTag, "styleable", "ConstraintLayout_Layout_layout_constraintTag"), 51);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, "styleable", "ConstraintLayout_Layout_layout_wrapBehaviorInParent"), 66);
            }
        }

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.e(r0, r1);
        }

        public androidx.constraintlayout.a.c.e getConstraintWidget() {
            return this.widget;
        }

        public void setWidgetDebugName(String r1) {
            this.widget.a(r1);
        }

        public void reset() {
            androidx.constraintlayout.a.c.e r0 = this.widget;
            if (r0 == null) goto L6;
            r0.w();
            return;
        }

        public LayoutParams(LayoutParams r9) {
            super(r9);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new androidx.constraintlayout.a.c.e();
            this.helped = false;
            this.guideBegin = r9.guideBegin;
            this.guideEnd = r9.guideEnd;
            this.guidePercent = r9.guidePercent;
            this.guidelineUseRtl = r9.guidelineUseRtl;
            this.leftToLeft = r9.leftToLeft;
            this.leftToRight = r9.leftToRight;
            this.rightToLeft = r9.rightToLeft;
            this.rightToRight = r9.rightToRight;
            this.topToTop = r9.topToTop;
            this.topToBottom = r9.topToBottom;
            this.bottomToTop = r9.bottomToTop;
            this.bottomToBottom = r9.bottomToBottom;
            this.baselineToBaseline = r9.baselineToBaseline;
            this.baselineToTop = r9.baselineToTop;
            this.baselineToBottom = r9.baselineToBottom;
            this.circleConstraint = r9.circleConstraint;
            this.circleRadius = r9.circleRadius;
            this.circleAngle = r9.circleAngle;
            this.startToEnd = r9.startToEnd;
            this.startToStart = r9.startToStart;
            this.endToStart = r9.endToStart;
            this.endToEnd = r9.endToEnd;
            this.goneLeftMargin = r9.goneLeftMargin;
            this.goneTopMargin = r9.goneTopMargin;
            this.goneRightMargin = r9.goneRightMargin;
            this.goneBottomMargin = r9.goneBottomMargin;
            this.goneStartMargin = r9.goneStartMargin;
            this.goneEndMargin = r9.goneEndMargin;
            this.goneBaselineMargin = r9.goneBaselineMargin;
            this.baselineMargin = r9.baselineMargin;
            this.horizontalBias = r9.horizontalBias;
            this.verticalBias = r9.verticalBias;
            this.dimensionRatio = r9.dimensionRatio;
            this.dimensionRatioValue = r9.dimensionRatioValue;
            this.dimensionRatioSide = r9.dimensionRatioSide;
            this.horizontalWeight = r9.horizontalWeight;
            this.verticalWeight = r9.verticalWeight;
            this.horizontalChainStyle = r9.horizontalChainStyle;
            this.verticalChainStyle = r9.verticalChainStyle;
            this.constrainedWidth = r9.constrainedWidth;
            this.constrainedHeight = r9.constrainedHeight;
            this.matchConstraintDefaultWidth = r9.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r9.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r9.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r9.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r9.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r9.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r9.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r9.matchConstraintPercentHeight;
            this.editorAbsoluteX = r9.editorAbsoluteX;
            this.editorAbsoluteY = r9.editorAbsoluteY;
            this.orientation = r9.orientation;
            this.horizontalDimensionFixed = r9.horizontalDimensionFixed;
            this.verticalDimensionFixed = r9.verticalDimensionFixed;
            this.needsBaseline = r9.needsBaseline;
            this.isGuideline = r9.isGuideline;
            this.resolvedLeftToLeft = r9.resolvedLeftToLeft;
            this.resolvedLeftToRight = r9.resolvedLeftToRight;
            this.resolvedRightToLeft = r9.resolvedRightToLeft;
            this.resolvedRightToRight = r9.resolvedRightToRight;
            this.resolveGoneLeftMargin = r9.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = r9.resolveGoneRightMargin;
            this.resolvedHorizontalBias = r9.resolvedHorizontalBias;
            this.constraintTag = r9.constraintTag;
            this.wrapBehaviorInParent = r9.wrapBehaviorInParent;
            this.widget = r9.widget;
            this.widthSet = r9.widthSet;
            this.heightSet = r9.heightSet;
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r13, r14);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new androidx.constraintlayout.a.c.e();
            this.helped = false;
            TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.ConstraintLayout_Layout);
            int r16 = r15.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r16) goto L118;
            int r5 = r15.getIndex(r1);
            int r6 = a.f937a.get(r5);
            switch(r6) {
                case 1: goto L116;
                case 2: goto L113;
                case 3: goto L112;
                case 4: goto L109;
                case 5: goto L108;
                case 6: goto L107;
                case 7: goto L106;
                case 8: goto L103;
                case 9: goto L100;
                case 10: goto L97;
                case 11: goto L94;
                case 12: goto L91;
                case 13: goto L88;
                case 14: goto L85;
                case 15: goto L82;
                case 16: goto L79;
                case 17: goto L76;
                case 18: goto L73;
                case 19: goto L70;
                case 20: goto L67;
                case 21: goto L66;
                case 22: goto L65;
                case 23: goto L64;
                case 24: goto L63;
                case 25: goto L62;
                case 26: goto L61;
                case 27: goto L60;
                case 28: goto L59;
                case 29: goto L58;
                case 30: goto L57;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L122;
                case 34: goto L126;
                case 35: goto L40;
                case 36: goto L120;
                case 37: goto L124;
                case 38: goto L29;
                default: goto L6;
            };
        L6:
            switch(r6) {
                case 44: goto L28;
                case 45: goto L27;
                case 46: goto L26;
                case 47: goto L25;
                case 48: goto L24;
                case 49: goto L23;
                case 50: goto L22;
                case 51: goto L21;
                case 52: goto L18;
                case 53: goto L15;
                case 54: goto L14;
                case 55: goto L13;
                default: goto L7;
            };
        L7:
            switch(r6) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L117;
            };
        L9:
            this.guidelineUseRtl = r15.getBoolean(r5, this.guidelineUseRtl);
            goto L117
        L10:
            this.wrapBehaviorInParent = r15.getInt(r5, this.wrapBehaviorInParent);
            goto L117
        L11:
            c.a(this, r15, r5, 1);
            this.heightSet = true;
            goto L117
        L12:
            c.a(this, r15, r5, 0);
            this.widthSet = true;
        L117:
            r1 = r1 + 1;
            goto L3
        L13:
            this.goneBaselineMargin = r15.getDimensionPixelSize(r5, this.goneBaselineMargin);
            goto L117
        L14:
            this.baselineMargin = r15.getDimensionPixelSize(r5, this.baselineMargin);
            goto L117
        L15:
            int r7 = r15.getResourceId(r5, this.baselineToBottom);
            this.baselineToBottom = r7;
            if (r7 != (-1)) goto L117;
            this.baselineToBottom = r15.getInt(r5, -1);
            goto L117
        L18:
            int r8 = r15.getResourceId(r5, this.baselineToTop);
            this.baselineToTop = r8;
            if (r8 != (-1)) goto L117;
            this.baselineToTop = r15.getInt(r5, -1);
            goto L117
        L21:
            this.constraintTag = r15.getString(r5);
            goto L117
        L22:
            this.editorAbsoluteY = r15.getDimensionPixelOffset(r5, this.editorAbsoluteY);
            goto L117
        L23:
            this.editorAbsoluteX = r15.getDimensionPixelOffset(r5, this.editorAbsoluteX);
            goto L117
        L24:
            this.verticalChainStyle = r15.getInt(r5, 0);
            goto L117
        L25:
            this.horizontalChainStyle = r15.getInt(r5, 0);
            goto L117
        L26:
            this.verticalWeight = r15.getFloat(r5, this.verticalWeight);
            goto L117
        L27:
            this.horizontalWeight = r15.getFloat(r5, this.horizontalWeight);
            goto L117
        L28:
            c.a(this, r15.getString(r5));
            goto L117
        L29:
            this.matchConstraintPercentHeight = Math.max(0.0f, r15.getFloat(r5, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L117
        L40:
            this.matchConstraintPercentWidth = Math.max(0.0f, r15.getFloat(r5, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L117
        L51:
            int r9 = r15.getInt(r5, 0);
            this.matchConstraintDefaultHeight = r9;
            if (r9 != 1) goto L117;
            INVOKESTATIC_androidx_constraintlayout_widget_ConstraintLayout$LayoutParams_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r10 = r15.getInt(r5, 0);
            this.matchConstraintDefaultWidth = r10;
            if (r10 != 1) goto L117;
            INVOKESTATIC_androidx_constraintlayout_widget_ConstraintLayout$LayoutParams_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L117
        L57:
            this.verticalBias = r15.getFloat(r5, this.verticalBias);
            goto L117
        L58:
            this.horizontalBias = r15.getFloat(r5, this.horizontalBias);
            goto L117
        L59:
            this.constrainedHeight = r15.getBoolean(r5, this.constrainedHeight);
            goto L117
        L60:
            this.constrainedWidth = r15.getBoolean(r5, this.constrainedWidth);
            goto L117
        L61:
            this.goneEndMargin = r15.getDimensionPixelSize(r5, this.goneEndMargin);
            goto L117
        L62:
            this.goneStartMargin = r15.getDimensionPixelSize(r5, this.goneStartMargin);
            goto L117
        L63:
            this.goneBottomMargin = r15.getDimensionPixelSize(r5, this.goneBottomMargin);
            goto L117
        L64:
            this.goneRightMargin = r15.getDimensionPixelSize(r5, this.goneRightMargin);
            goto L117
        L65:
            this.goneTopMargin = r15.getDimensionPixelSize(r5, this.goneTopMargin);
            goto L117
        L66:
            this.goneLeftMargin = r15.getDimensionPixelSize(r5, this.goneLeftMargin);
            goto L117
        L67:
            int r17 = r15.getResourceId(r5, this.endToEnd);
            this.endToEnd = r17;
            if (r17 != (-1)) goto L117;
            this.endToEnd = r15.getInt(r5, -1);
            goto L117
        L70:
            int r18 = r15.getResourceId(r5, this.endToStart);
            this.endToStart = r18;
            if (r18 != (-1)) goto L117;
            this.endToStart = r15.getInt(r5, -1);
            goto L117
        L73:
            int r19 = r15.getResourceId(r5, this.startToStart);
            this.startToStart = r19;
            if (r19 != (-1)) goto L117;
            this.startToStart = r15.getInt(r5, -1);
            goto L117
        L76:
            int r20 = r15.getResourceId(r5, this.startToEnd);
            this.startToEnd = r20;
            if (r20 != (-1)) goto L117;
            this.startToEnd = r15.getInt(r5, -1);
            goto L117
        L79:
            int r21 = r15.getResourceId(r5, this.baselineToBaseline);
            this.baselineToBaseline = r21;
            if (r21 != (-1)) goto L117;
            this.baselineToBaseline = r15.getInt(r5, -1);
            goto L117
        L82:
            int r22 = r15.getResourceId(r5, this.bottomToBottom);
            this.bottomToBottom = r22;
            if (r22 != (-1)) goto L117;
            this.bottomToBottom = r15.getInt(r5, -1);
            goto L117
        L85:
            int r23 = r15.getResourceId(r5, this.bottomToTop);
            this.bottomToTop = r23;
            if (r23 != (-1)) goto L117;
            this.bottomToTop = r15.getInt(r5, -1);
            goto L117
        L88:
            int r24 = r15.getResourceId(r5, this.topToBottom);
            this.topToBottom = r24;
            if (r24 != (-1)) goto L117;
            this.topToBottom = r15.getInt(r5, -1);
            goto L117
        L91:
            int r25 = r15.getResourceId(r5, this.topToTop);
            this.topToTop = r25;
            if (r25 != (-1)) goto L117;
            this.topToTop = r15.getInt(r5, -1);
            goto L117
        L94:
            int r26 = r15.getResourceId(r5, this.rightToRight);
            this.rightToRight = r26;
            if (r26 != (-1)) goto L117;
            this.rightToRight = r15.getInt(r5, -1);
            goto L117
        L97:
            int r27 = r15.getResourceId(r5, this.rightToLeft);
            this.rightToLeft = r27;
            if (r27 != (-1)) goto L117;
            this.rightToLeft = r15.getInt(r5, -1);
            goto L117
        L100:
            int r28 = r15.getResourceId(r5, this.leftToRight);
            this.leftToRight = r28;
            if (r28 != (-1)) goto L117;
            this.leftToRight = r15.getInt(r5, -1);
            goto L117
        L103:
            int r29 = r15.getResourceId(r5, this.leftToLeft);
            this.leftToLeft = r29;
            if (r29 != (-1)) goto L117;
            this.leftToLeft = r15.getInt(r5, -1);
            goto L117
        L106:
            this.guidePercent = r15.getFloat(r5, this.guidePercent);
            goto L117
        L107:
            this.guideEnd = r15.getDimensionPixelOffset(r5, this.guideEnd);
            goto L117
        L108:
            this.guideBegin = r15.getDimensionPixelOffset(r5, this.guideBegin);
            goto L117
        L109:
            float r30 = r15.getFloat(r5, this.circleAngle) % 360.0f;
            this.circleAngle = r30;
            if (r30 >= 0.0f) goto L117;
            this.circleAngle = (360.0f - r30) % 360.0f;
            goto L117
        L112:
            this.circleRadius = r15.getDimensionPixelSize(r5, this.circleRadius);
            goto L117
        L113:
            int r31 = r15.getResourceId(r5, this.circleConstraint);
            this.circleConstraint = r31;
            if (r31 != (-1)) goto L117;
            this.circleConstraint = r15.getInt(r5, -1);
            goto L117
        L116:
            this.orientation = r15.getInt(r5, this.orientation);
            goto L117
        L120:
            this.matchConstraintMinHeight = r15.getDimensionPixelSize(r5, this.matchConstraintMinHeight);     // Catch: Exception -> L37
        L38:
            if (r15.getInt(r5, this.matchConstraintMinHeight) != (-2)) goto L117;
            this.matchConstraintMinHeight = -2;
            goto L117
        L122:
            this.matchConstraintMinWidth = r15.getDimensionPixelSize(r5, this.matchConstraintMinWidth);     // Catch: Exception -> L48
        L49:
            if (r15.getInt(r5, this.matchConstraintMinWidth) != (-2)) goto L117;
            this.matchConstraintMinWidth = -2;
            goto L117
        L124:
            this.matchConstraintMaxHeight = r15.getDimensionPixelSize(r5, this.matchConstraintMaxHeight);     // Catch: Exception -> L32
        L33:
            if (r15.getInt(r5, this.matchConstraintMaxHeight) != (-2)) goto L117;
            this.matchConstraintMaxHeight = -2;
            goto L117
        L126:
            this.matchConstraintMaxWidth = r15.getDimensionPixelSize(r5, this.matchConstraintMaxWidth);     // Catch: Exception -> L43
        L44:
            if (r15.getInt(r5, this.matchConstraintMaxWidth) != (-2)) goto L117;
            this.matchConstraintMaxWidth = -2;
            goto L117
        L118:
            r15.recycle();
            validate();
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width != (-2)) goto L10;
            if (this.constrainedWidth == false) goto L10;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L10;
            this.matchConstraintDefaultWidth = 1;
        L10:
            if (this.height != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (this.width != 0) goto L19;
        L20:
            this.horizontalDimensionFixed = false;
            if (this.width == 0) goto L23;
        L26:
            if (this.height != 0) goto L28;
        L29:
            this.verticalDimensionFixed = false;
            if (this.height == 0) goto L32;
        L35:
            if (this.guidePercent == (-1.0f)) goto L37;
        L40:
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (ZeusTransformUtils.instanceOf(this.widget, h.class) == true) goto L43;
            this.widget = new h();
        L43:
            ((h) ZeusTransformUtils.preCheckCast(this.widget, h.class, "com.obric.aiagent.plugin")).a(this.orientation);
            return;
        L37:
            if (this.guideBegin != (-1)) goto L40;
            if (this.guideEnd != (-1)) goto L40;
            return;
        L32:
            if (this.matchConstraintDefaultHeight != 1) goto L35;
            this.height = -2;
            this.constrainedHeight = true;
            goto L35
        L28:
            if (this.height != (-1)) goto L35;
        L23:
            if (this.matchConstraintDefaultWidth != 1) goto L26;
            this.width = -2;
            this.constrainedWidth = true;
            goto L26
        L19:
            if (this.width != (-1)) goto L26;
            goto L20
        }

        public LayoutParams(int r7, int r8) {
            super(r7, r8);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new androidx.constraintlayout.a.c.e();
            this.helped = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r8) {
            super(r8);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new androidx.constraintlayout.a.c.e();
            this.helped = false;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r11) {
            int r0 = this.leftMargin;
            int r1 = this.rightMargin;
            boolean r3 = false;
            if (Build.VERSION.SDK_INT < 17) goto L7;
            super.resolveLayoutDirection(r11);
            if (1 != getLayoutDirection()) goto L7;
            boolean r12 = true;
        L8:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float r5 = this.horizontalBias;
            this.resolvedHorizontalBias = r5;
            int r6 = this.guideBegin;
            this.resolvedGuideBegin = r6;
            int r7 = this.guideEnd;
            this.resolvedGuideEnd = r7;
            float r8 = this.guidePercent;
            this.resolvedGuidePercent = r8;
            if (r12 == false) goto L45;
            int r13 = this.startToEnd;
            if (r13 == (-1)) goto L14;
            this.resolvedRightToLeft = r13;
        L13:
            r3 = true;
        L17:
            int r14 = this.endToStart;
            if (r14 == (-1)) goto L20;
            this.resolvedLeftToRight = r14;
            r3 = true;
        L20:
            int r15 = this.endToEnd;
            if (r15 == (-1)) goto L23;
            this.resolvedLeftToLeft = r15;
            r3 = true;
        L23:
            int r16 = this.goneStartMargin;
            if (r16 == Integer.MIN_VALUE) goto L26;
            this.resolveGoneRightMargin = r16;
        L26:
            int r17 = this.goneEndMargin;
            if (r17 == Integer.MIN_VALUE) goto L30;
            this.resolveGoneLeftMargin = r17;
        L30:
            if (r3 == false) goto L33;
            this.resolvedHorizontalBias = 1.0f - r5;
        L33:
            if (this.isGuideline == false) goto L64;
            if (this.orientation != 1) goto L64;
            if (this.guidelineUseRtl == false) goto L64;
            if (r8 == (-1.0f)) goto L41;
            this.resolvedGuidePercent = 1.0f - r8;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L64
        L41:
            if (r6 == (-1)) goto L43;
            this.resolvedGuideEnd = r6;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0f;
            goto L64
        L43:
            if (r7 == (-1)) goto L64;
            this.resolvedGuideBegin = r7;
            this.resolvedGuideEnd = -1;
            this.resolvedGuidePercent = -1.0f;
        L64:
            if (this.endToStart == (-1)) goto L66;
            return;
        L66:
            if (this.endToEnd == (-1)) goto L68;
            return;
        L68:
            if (this.startToStart == (-1)) goto L70;
            return;
        L70:
            if (this.startToEnd != (-1)) goto L99;
            int r18 = this.rightToLeft;
            if (r18 == (-1)) goto L77;
            this.resolvedRightToLeft = r18;
            if (this.rightMargin > 0) goto L83;
            if (r1 <= 0) goto L83;
            this.rightMargin = r1;
        L83:
            int r19 = this.leftToLeft;
            if (r19 == (-1)) goto L89;
            this.resolvedLeftToLeft = r19;
            if (this.leftMargin > 0) goto L100;
            if (r0 <= 0) goto L101;
            this.leftMargin = r0;
            return;
        L101:
            return;
        L100:
            return;
        L89:
            int r110 = this.leftToRight;
            if (r110 == (-1)) goto L103;
            this.resolvedLeftToRight = r110;
            if (this.leftMargin > 0) goto L104;
            if (r0 <= 0) goto L105;
            this.leftMargin = r0;
            return;
        L105:
            return;
        L104:
            return;
        L103:
            return;
        L77:
            int r111 = this.rightToRight;
            if (r111 == (-1)) goto L83;
            this.resolvedRightToRight = r111;
            if (this.rightMargin > 0) goto L83;
            if (r1 <= 0) goto L83;
            this.rightMargin = r1;
            goto L83
        L99:
            return;
        L14:
            int r112 = this.startToStart;
            if (r112 == (-1)) goto L17;
            this.resolvedRightToRight = r112;
            goto L13
        L45:
            int r113 = this.startToEnd;
            if (r113 == (-1)) goto L48;
            this.resolvedLeftToRight = r113;
        L48:
            int r114 = this.startToStart;
            if (r114 == (-1)) goto L51;
            this.resolvedLeftToLeft = r114;
        L51:
            int r115 = this.endToStart;
            if (r115 == (-1)) goto L54;
            this.resolvedRightToLeft = r115;
        L54:
            int r116 = this.endToEnd;
            if (r116 == (-1)) goto L57;
            this.resolvedRightToRight = r116;
        L57:
            int r117 = this.goneStartMargin;
            if (r117 == Integer.MIN_VALUE) goto L60;
            this.resolveGoneLeftMargin = r117;
        L60:
            int r118 = this.goneEndMargin;
            if (r118 == Integer.MIN_VALUE) goto L64;
            this.resolveGoneRightMargin = r118;
        L7:
            r12 = false;
            goto L8
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_constraintlayout_widget_ConstraintLayout$LayoutParams_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    class a implements androidx.constraintlayout.a.c.a.b.InterfaceC0012b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f942e;
        int f;
        int g;
        final /* synthetic */ ConstraintLayout h;

        public void a(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.f939b = r3;
            this.f940c = r4;
            this.f941d = r5;
            this.f942e = r6;
            this.f = r1;
            this.g = r2;
        }

        public a(ConstraintLayout r1, ConstraintLayout r2) {
            this.h = r1;
            this.f938a = r2;
        }

        @Override // androidx.constraintlayout.a.c.a.b.InterfaceC0012b
        public final void a(androidx.constraintlayout.a.c.e r18, androidx.constraintlayout.a.c.a.b.a r19) {
            if (r18 != null) goto L6;
            return;
        L6:
            if (r18.B() != 8) goto L12;
            if (r18.s() == true) goto L12;
            r19.h = 0;
            r19.i = 0;
            r19.j = 0;
            return;
        L12:
            if (r18.A() != null) goto L14;
            return;
        L14:
            androidx.constraintlayout.a.c.e.a r3 = r19.f700d;
            androidx.constraintlayout.a.c.e.a r4 = r19.f701e;
            int r6 = r19.f;
            int r7 = r19.g;
            int r8 = this.f939b + this.f940c;
            int r9 = this.f941d;
            View r10 = (View) ZeusTransformUtils.preCheckCast(r18.T(), View.class, "com.obric.aiagent.plugin");
            int r11 = AnonymousClass1.f936a[r3.ordinal()];
            if (r11 == 1) goto L48;
            if (r11 == 2) goto L47;
            if (r11 == 3) goto L46;
            if (r11 == 4) goto L20;
            int r12 = 0;
        L49:
            int r13 = AnonymousClass1.f936a[r4.ordinal()];
            if (r13 == 1) goto L85;
            if (r13 != 2) goto L53;
            int r14 = ViewGroup.getChildMeasureSpec(this.g, r8, -2);
        L86:
            androidx.constraintlayout.a.c.f r15 = (androidx.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(r18.A(), androidx.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L112;
            if (k.a(ConstraintLayout.access$000(this.h), 256) == false) goto L112;
            if (r10.getMeasuredWidth() != r18.F()) goto L112;
            if (r10.getMeasuredWidth() >= r15.F()) goto L112;
            if (r10.getMeasuredHeight() != r18.G()) goto L112;
            if (r10.getMeasuredHeight() >= r15.G()) goto L112;
            if (r10.getBaseline() != r18.S()) goto L112;
            if (r18.t() == true) goto L112;
            if (a(r18.u(), r12, r18.F()) == true) goto L105;
        L107:
            boolean r16 = false;
        L108:
            if (r16 == false) goto L112;
            r19.h = r18.F();
            r19.i = r18.G();
            r19.j = r18.S();
            return;
        L105:
            if (a(r18.v(), r14, r18.G()) == false) goto L107;
            r16 = true;
        L112:
            if (r3 != androidx.constraintlayout.a.c.e.a.f777c) goto L114;
            boolean r17 = true;
        L116:
            if (r4 != androidx.constraintlayout.a.c.e.a.f777c) goto L118;
            boolean r20 = true;
        L120:
            if (r4 != androidx.constraintlayout.a.c.e.a.f778d) goto L122;
        L125:
            boolean r5 = true;
        L127:
            if (r3 != androidx.constraintlayout.a.c.e.a.f778d) goto L129;
        L132:
            boolean r21 = true;
        L134:
            if (r17 == true) goto L136;
        L138:
            boolean r110 = false;
        L139:
            if (r20 == true) goto L141;
        L143:
            boolean r111 = false;
        L144:
            if (r10 != null) goto L146;
            return;
        L146:
            LayoutParams r112 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            if (r19.m == androidx.constraintlayout.a.c.a.b.a.f698b) goto L159;
            if (r19.m == androidx.constraintlayout.a.c.a.b.a.f699c) goto L159;
            if (r17 == false) goto L159;
            if (r18.n != 0) goto L159;
            if (r20 == false) goto L159;
            if (r18.o != 0) goto L159;
            int r0 = -1;
            int r22 = 0;
            int r113 = 0;
            int r114 = 0;
        L198:
            if (r22 == r0) goto L200;
            boolean r23 = true;
        L202:
            if (r113 == r19.f) goto L204;
        L207:
            boolean r24 = true;
        L208:
            r19.l = r24;
            if (r112.needsBaseline == false) goto L211;
            r23 = true;
        L211:
            if (r23 == true) goto L213;
        L217:
            r19.h = r113;
            r19.i = r114;
            r19.k = r23;
            r19.j = r22;
            return;
        L213:
            if (r22 == (-1)) goto L217;
            if (r18.S() == r22) goto L217;
            r19.l = true;
            goto L217
        L204:
            if (r114 != r19.g) goto L207;
            r24 = false;
            goto L208
        L200:
            r23 = false;
        L159:
            if (ZeusTransformUtils.instanceOf(r10, VirtualLayout.class) == true) goto L161;
        L163:
            r10.measure(r12, r14);
        L164:
            r18.d(r12, r14);
            int r25 = r10.getMeasuredWidth();
            int r26 = r10.getMeasuredHeight();
            r22 = r10.getBaseline();
            if (r18.q <= 0) goto L167;
            r113 = Math.max(r18.q, r25);
        L169:
            if (r18.r <= 0) goto L172;
            r113 = Math.min(r18.r, r113);
        L172:
            if (r18.t <= 0) goto L174;
            r114 = Math.max(r18.t, r26);
        L176:
            if (r18.u <= 0) goto L179;
            r114 = Math.min(r18.u, r114);
        L179:
            if (k.a(ConstraintLayout.access$000(this.h), 1) == false) goto L181;
        L187:
            if (r25 != r113) goto L192;
            if (r26 != r114) goto L192;
        L190:
            r0 = -1;
        L192:
            if (r25 == r113) goto L194;
            int r27 = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        L195:
            if (r26 == r114) goto L197;
            r14 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        L197:
            r10.measure(r27, r14);
            r18.d(r27, r14);
            r113 = r10.getMeasuredWidth();
            r114 = r10.getMeasuredHeight();
            r22 = r10.getBaseline();
            goto L190
        L194:
            r27 = r12;
            goto L195
        L181:
            if (r110 == false) goto L184;
            if (r5 == false) goto L184;
            r113 = (int) ((r114 * r18.O) + 0.5f);
        L184:
            if (r111 == false) goto L187;
            if (r21 == false) goto L187;
            r114 = (int) ((r113 / r18.O) + 0.5f);
            goto L187
        L174:
            r114 = r26;
            goto L176
        L167:
            r113 = r25;
            goto L169
        L161:
            if (ZeusTransformUtils.instanceOf(r18, m.class) == false) goto L163;
            ((VirtualLayout) ZeusTransformUtils.preCheckCast(r10, VirtualLayout.class, "com.obric.aiagent.plugin")).onMeasure((m) ZeusTransformUtils.preCheckCast(r18, m.class, "com.obric.aiagent.plugin"), r12, r14);
            goto L164
        L141:
            if (r18.O <= 0.0f) goto L143;
            r111 = true;
            goto L144
        L136:
            if (r18.O <= 0.0f) goto L138;
            r110 = true;
            goto L139
        L129:
            if (r3 == androidx.constraintlayout.a.c.e.a.f775a) goto L132;
            r21 = false;
            goto L134
        L122:
            if (r4 == androidx.constraintlayout.a.c.e.a.f775a) goto L125;
            r5 = false;
            goto L127
        L118:
            r20 = false;
            goto L120
        L114:
            r17 = false;
            goto L116
        L53:
            if (r13 != 3) goto L55;
            r14 = ViewGroup.getChildMeasureSpec(this.g, r8 + r18.O(), -1);
            goto L86
        L55:
            if (r13 == 4) goto L57;
            r14 = 0;
            goto L86
        L57:
            r14 = ViewGroup.getChildMeasureSpec(this.g, r8, -2);
            if (r18.o != 1) goto L60;
            boolean r28 = true;
        L62:
            if (r19.m == androidx.constraintlayout.a.c.a.b.a.f698b) goto L66;
            if (r19.m != androidx.constraintlayout.a.c.a.b.a.f699c) goto L86;
        L66:
            if (r10.getMeasuredWidth() != r18.F()) goto L68;
            boolean r29 = true;
        L70:
            if (r19.m == androidx.constraintlayout.a.c.a.b.a.f699c) goto L80;
            if (r28 == false) goto L80;
            if (r28 == false) goto L75;
            if (r29 == true) goto L80;
        L75:
            if (ZeusTransformUtils.instanceOf(r10, Placeholder.class) == true) goto L80;
            if (r18.e() == true) goto L80;
            boolean r30 = false;
        L81:
            if (r30 == false) goto L86;
            r14 = View.MeasureSpec.makeMeasureSpec(r18.G(), 1073741824);
        L80:
            r30 = true;
            goto L81
        L68:
            r29 = false;
            goto L70
        L60:
            r28 = false;
            goto L62
        L85:
            r14 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
            goto L86
        L20:
            r12 = ViewGroup.getChildMeasureSpec(this.f, r9, -2);
            if (r18.n != 1) goto L23;
            boolean r31 = true;
        L25:
            if (r19.m == androidx.constraintlayout.a.c.a.b.a.f698b) goto L29;
            if (r19.m != androidx.constraintlayout.a.c.a.b.a.f699c) goto L49;
        L29:
            if (r10.getMeasuredHeight() != r18.G()) goto L31;
            boolean r115 = true;
        L33:
            if (r19.m == androidx.constraintlayout.a.c.a.b.a.f699c) goto L43;
            if (r31 == false) goto L43;
            if (r31 == false) goto L38;
            if (r115 == true) goto L43;
        L38:
            if (ZeusTransformUtils.instanceOf(r10, Placeholder.class) == true) goto L43;
            if (r18.d() == true) goto L43;
            boolean r32 = false;
        L44:
            if (r32 == false) goto L49;
            r12 = View.MeasureSpec.makeMeasureSpec(r18.F(), 1073741824);
        L43:
            r32 = true;
            goto L44
        L31:
            r115 = false;
            goto L33
        L23:
            r31 = false;
            goto L25
        L46:
            r12 = ViewGroup.getChildMeasureSpec(this.f, r9 + r18.N(), -1);
            goto L49
        L47:
            r12 = ViewGroup.getChildMeasureSpec(this.f, r9, -2);
            goto L49
        L48:
            r12 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
            goto L49
        }

        private boolean a(int r3, int r4, int r5) {
            if (r3 != r4) goto L5;
            return true;
        L5:
            int r0 = View.MeasureSpec.getMode(r3);
            View.MeasureSpec.getSize(r3);
            int r6 = View.MeasureSpec.getMode(r4);
            int r7 = View.MeasureSpec.getSize(r4);
            if (r6 == 1073741824) goto L8;
            return false;
        L8:
            if (r0 == Integer.MIN_VALUE) goto L10;
            if (r0 == 0) goto L10;
            return false;
        L10:
            if (r5 != r7) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // androidx.constraintlayout.a.c.a.b.InterfaceC0012b
        public final void a() {
            int r0 = this.f938a.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L9;
            View r4 = this.f938a.getChildAt(r2);
            if (ZeusTransformUtils.instanceOf(r4, Placeholder.class) == false) goto L8;
            ((Placeholder) ZeusTransformUtils.preCheckCast(r4, Placeholder.class, "com.obric.aiagent.plugin")).updatePostMeasure(this.f938a);
        L8:
            r2 = r2 + 1;
            goto L4
        L9:
            int r3 = ConstraintLayout.access$100(this.f938a).size();
            if (r3 <= 0) goto L13;
        L11:
            if (r1 >= r3) goto L18;
            ((ConstraintHelper) ZeusTransformUtils.preCheckCast(ConstraintLayout.access$100(this.f938a).get(r1), ConstraintHelper.class, "com.obric.aiagent.plugin")).updatePostMeasure(this.f938a);
            r1 = r1 + 1;
            goto L11
        L18:
            return;
        }
    }

    static {
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.v(r0, r1);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    static /* synthetic */ int access$000(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$100(ConstraintLayout r0) {
        return r0.mConstraintHelpers;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public static e getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new e();
    L6:
        return sSharedValues;
    }

    public void setDesignInformation(int r3, Object r4, Object r5) {
        if (r3 == 0) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        int r7 = r6.indexOf("/");
        if (r7 == (-1)) goto L13;
        r6 = r6.substring(r7 + 1);
    L13:
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        this.mDesignIds.put(r6, Integer.valueOf(r8));
    }

    public Object getDesignInformation(int r2, Object r3) {
        if (r2 == 0) goto L4;
        return null;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        HashMap<String, Integer> r5 = this.mDesignIds;
        if (r5 != null) goto L8;
        return null;
    L8:
        if (r5.containsKey(r4) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r4);
    L13:
        return null;
    }

    public ConstraintLayout(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"));
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new androidx.constraintlayout.a.c.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new androidx.constraintlayout.a.c.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r6, 0, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new androidx.constraintlayout.a.c.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r7, r5, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r5, r6);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new androidx.constraintlayout.a.c.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r8, r5, r6);
    }

    @Override // android.view.View
    public void setId(int r3) {
        this.mChildrenByIds.remove(getId());
        super.setId(r3);
        this.mChildrenByIds.put(getId(), this);
    }

    private void init(AttributeSet r8, int r9, int r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        this.mLayoutWidget.a(this);
        this.mLayoutWidget.a(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r11 == null) goto L37;
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r11, R.styleable.ConstraintLayout_Layout, r9, r10);
        int r13 = r12.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r13) goto L36;
        int r3 = r12.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_minWidth, "styleable", "ConstraintLayout_Layout_android_minWidth")) goto L10;
        this.mMinWidth = r12.getDimensionPixelOffset(r3, this.mMinWidth);
    L35:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_minHeight, "styleable", "ConstraintLayout_Layout_android_minHeight")) goto L13;
        this.mMinHeight = r12.getDimensionPixelOffset(r3, this.mMinHeight);
        goto L35
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_maxWidth, "styleable", "ConstraintLayout_Layout_android_maxWidth")) goto L16;
        this.mMaxWidth = r12.getDimensionPixelOffset(r3, this.mMaxWidth);
        goto L35
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_maxHeight, "styleable", "ConstraintLayout_Layout_android_maxHeight")) goto L19;
        this.mMaxHeight = r12.getDimensionPixelOffset(r3, this.mMaxHeight);
        goto L35
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_optimizationLevel, "styleable", "ConstraintLayout_Layout_layout_optimizationLevel")) goto L22;
        this.mOptimizationLevel = r12.getInt(r3, this.mOptimizationLevel);
        goto L35
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layoutDescription, "styleable", "ConstraintLayout_Layout_layoutDescription")) goto L29;
        int r4 = r12.getResourceId(r3, 0);
        if (r4 == 0) goto L35;
        parseLayoutDescription(r4);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraintSet, "styleable", "ConstraintLayout_Layout_constraintSet")) goto L35;
        int r5 = r12.getResourceId(r3, 0);
        c r6 = new c();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r6;     // Catch: Resources.NotFoundException -> L33
        r6.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r5;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r12.recycle();
    L37:
        this.mLayoutWidget.a(this.mOptimizationLevel);
    }

    public void parseLayoutDescription(int r5) {
        this.mConstraintLayoutSpec = new b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r5);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r6) {
        super.onViewAdded(r6);
        androidx.constraintlayout.a.c.e r0 = getViewWidget(r6);
        if (ZeusTransformUtils.instanceOf(r6, Guideline.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, h.class) == true) goto L8;
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r1.widget = new h();
        r1.isGuideline = true;
        ((h) ZeusTransformUtils.preCheckCast(r1.widget, h.class, "com.obric.aiagent.plugin")).a(r1.orientation);
    L8:
        if (ZeusTransformUtils.instanceOf(r6, ConstraintHelper.class) == false) goto L12;
        ConstraintHelper r2 = (ConstraintHelper) ZeusTransformUtils.preCheckCast(r6, ConstraintHelper.class, "com.obric.aiagent.plugin");
        r2.validateParams();
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).isHelper = true;
        if (this.mConstraintHelpers.contains(r2) == true) goto L12;
        this.mConstraintHelpers.add(r2);
    L12:
        this.mChildrenByIds.put(r6.getId(), r6);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        this.mChildrenByIds.remove(r3.getId());
        androidx.constraintlayout.a.c.e r0 = getViewWidget(r3);
        this.mLayoutWidget.c(r0);
        this.mConstraintHelpers.remove(r3);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int r2) {
        if (r2 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r2;
        requestLayout();
    }

    public void setMinHeight(int r2) {
        if (r2 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r2;
        requestLayout();
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int r2) {
        if (r2 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r2;
        requestLayout();
    }

    public void setMaxHeight(int r2) {
        if (r2 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r2;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private boolean updateHierarchy() {
        int r0 = getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (getChildAt(r2).isLayoutRequested() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r1;
    }

    private void setChildrenConstraints() {
        boolean r6 = isInEditMode();
        int r7 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L10;
        androidx.constraintlayout.a.c.e r2 = getViewWidget(getChildAt(r1));
        if (r2 == null) goto L8;
        r2.w();
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r6 == false) goto L20;
        int r3 = 0;
    L12:
        if (r3 >= r7) goto L20;
        View r4 = getChildAt(r3);
        String r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getResourceName(r4.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r5, Integer.valueOf(r4.getId()));     // Catch: Resources.NotFoundException -> L54
        int r8 = r5.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r8 == (-1)) goto L17;
        r5 = r5.substring(r8 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r4.getId()).a(r5);     // Catch: Resources.NotFoundException -> L54
    L18:
        r3 = r3 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r9 = 0;
    L22:
        if (r9 >= r7) goto L29;
        View r10 = getChildAt(r9);
        if (r10.getId() != this.mConstraintSetId) goto L28;
        if (ZeusTransformUtils.instanceOf(r10, Constraints.class) == false) goto L28;
        this.mConstraintSet = ((Constraints) ZeusTransformUtils.preCheckCast(r10, Constraints.class, "com.obric.aiagent.plugin")).getConstraintSet();
    L28:
        r9 = r9 + 1;
    L29:
        c r11 = this.mConstraintSet;
        if (r11 == null) goto L32;
        r11.a(this, true);
    L32:
        this.mLayoutWidget.al();
        int r12 = this.mConstraintHelpers.size();
        if (r12 <= 0) goto L37;
        int r13 = 0;
    L35:
        if (r13 >= r12) goto L37;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r13), ConstraintHelper.class, "com.obric.aiagent.plugin")).updatePreLayout(this);
        r13 = r13 + 1;
    L37:
        int r14 = 0;
    L38:
        if (r14 >= r7) goto L43;
        View r15 = getChildAt(r14);
        if (ZeusTransformUtils.instanceOf(r15, Placeholder.class) == false) goto L42;
        ((Placeholder) ZeusTransformUtils.preCheckCast(r15, Placeholder.class, "com.obric.aiagent.plugin")).updatePreLayout(this);
    L42:
        r14 = r14 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r16 = 0;
    L44:
        if (r16 >= r7) goto L46;
        View r17 = getChildAt(r16);
        this.mTempMapIdToWidget.put(r17.getId(), getViewWidget(r17));
        r16 = r16 + 1;
        goto L44
    L46:
        int r18 = 0;
    L47:
        if (r18 >= r7) goto L53;
        View r19 = getChildAt(r18);
        androidx.constraintlayout.a.c.e r20 = getViewWidget(r19);
        if (r20 == null) goto L52;
        LayoutParams r21 = (LayoutParams) ZeusTransformUtils.preCheckCast(r19.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        this.mLayoutWidget.b(r20);
        applyConstraintsFromLayoutParams(r6, r19, r20, r21, this.mTempMapIdToWidget);
    L52:
        r18 = r18 + 1;
        goto L47
    }

    public void applyConstraintsFromLayoutParams(boolean r19, View r20, androidx.constraintlayout.a.c.e r21, LayoutParams r22, SparseArray<androidx.constraintlayout.a.c.e> r23) {
        r22.validate();
        r22.helped = false;
        r21.l(r20.getVisibility());
        if (r22.isInPlaceholder == false) goto L5;
        r21.d(true);
        r21.l(8);
    L5:
        r21.a(r20);
        if (ZeusTransformUtils.instanceOf(r20, ConstraintHelper.class) == false) goto L10;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r20, ConstraintHelper.class, "com.obric.aiagent.plugin")).resolveRtl(r21, this.mLayoutWidget.ag());
    L10:
        if (r22.isGuideline == false) goto L21;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r21, h.class, "com.obric.aiagent.plugin");
        int r2 = r22.resolvedGuideBegin;
        int r3 = r22.resolvedGuideEnd;
        float r4 = r22.resolvedGuidePercent;
        if (Build.VERSION.SDK_INT >= 17) goto L15;
        r2 = r22.guideBegin;
        r3 = r22.guideEnd;
        r4 = r22.guidePercent;
    L15:
        if (r4 == (-1.0f)) goto L17;
        r0.e(r4);
        return;
    L17:
        if (r2 == (-1)) goto L19;
        r0.b(r2);
        return;
    L19:
        if (r3 == (-1)) goto L136;
        r0.A(r3);
        return;
    L136:
        return;
    L21:
        int r1 = r22.resolvedLeftToLeft;
        int r5 = r22.resolvedLeftToRight;
        int r6 = r22.resolvedRightToLeft;
        int r7 = r22.resolvedRightToRight;
        int r8 = r22.resolveGoneLeftMargin;
        int r13 = r22.resolveGoneRightMargin;
        float r14 = r22.resolvedHorizontalBias;
        if (Build.VERSION.SDK_INT >= 17) goto L41;
        r1 = r22.leftToLeft;
        int r9 = r22.leftToRight;
        int r10 = r22.rightToLeft;
        r7 = r22.rightToRight;
        int r11 = r22.goneLeftMargin;
        int r12 = r22.goneRightMargin;
        r14 = r22.horizontalBias;
        if (r1 != (-1)) goto L32;
        if (r9 != (-1)) goto L32;
        if (r22.startToStart == (-1)) goto L30;
        r1 = r22.startToStart;
        goto L32
    L30:
        if (r22.startToEnd == (-1)) goto L32;
        r9 = r22.startToEnd;
    L32:
        if (r10 != (-1)) goto L40;
        if (r7 != (-1)) goto L40;
        if (r22.endToStart == (-1)) goto L38;
        r10 = r22.endToStart;
        goto L40
    L38:
        if (r22.endToEnd == (-1)) goto L40;
        r7 = r22.endToEnd;
    L40:
        int r15 = r10;
        int r16 = r12;
        r8 = r11;
        r5 = r9;
    L42:
        float r17 = r14;
        int r18 = r7;
        if (r22.circleConstraint == (-1)) goto L47;
        androidx.constraintlayout.a.c.e r24 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r22.circleConstraint), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L100;
        r21.a(r24, r22.circleAngle, r22.circleRadius);
    L100:
        if (r19 == false) goto L107;
        if (r22.editorAbsoluteX == (-1)) goto L104;
    L105:
        r21.e(r22.editorAbsoluteX, r22.editorAbsoluteY);
        goto L107
    L104:
        if (r22.editorAbsoluteY != (-1)) goto L105;
    L107:
        if (r22.horizontalDimensionFixed == false) goto L109;
        r21.a(androidx.constraintlayout.a.c.e.a.f775a);
        r21.q(r22.width);
        if (r22.width != (-2)) goto L120;
        r21.a(androidx.constraintlayout.a.c.e.a.f776b);
    L120:
        if (r22.verticalDimensionFixed == false) goto L122;
        r21.b(androidx.constraintlayout.a.c.e.a.f775a);
        r21.r(r22.height);
        if (r22.height != (-2)) goto L132;
        r21.b(androidx.constraintlayout.a.c.e.a.f776b);
    L132:
        r21.b(r22.dimensionRatio);
        r21.c(r22.horizontalWeight);
        r21.d(r22.verticalWeight);
        r21.v(r22.horizontalChainStyle);
        r21.w(r22.verticalChainStyle);
        r21.k(r22.wrapBehaviorInParent);
        r21.a(r22.matchConstraintDefaultWidth, r22.matchConstraintMinWidth, r22.matchConstraintMaxWidth, r22.matchConstraintPercentWidth);
        r21.b(r22.matchConstraintDefaultHeight, r22.matchConstraintMinHeight, r22.matchConstraintMaxHeight, r22.matchConstraintPercentHeight);
        return;
    L122:
        if (r22.height == (-1)) goto L124;
        r21.b(androidx.constraintlayout.a.c.e.a.f777c);
        r21.r(0);
        goto L132
    L124:
        if (r22.constrainedHeight == false) goto L126;
        r21.b(androidx.constraintlayout.a.c.e.a.f777c);
    L127:
        androidx.constraintlayout.a.c.d r25 = r21.a(androidx.constraintlayout.a.c.d.a.f764c);
        r25.f759d = r22.topMargin;
        androidx.constraintlayout.a.c.d r26 = r21.a(androidx.constraintlayout.a.c.d.a.f766e);
        r26.f759d = r22.bottomMargin;
        goto L132
    L126:
        r21.b(androidx.constraintlayout.a.c.e.a.f778d);
        goto L127
    L109:
        if (r22.width == (-1)) goto L111;
        r21.a(androidx.constraintlayout.a.c.e.a.f777c);
        r21.q(0);
        goto L120
    L111:
        if (r22.constrainedWidth == false) goto L113;
        r21.a(androidx.constraintlayout.a.c.e.a.f777c);
    L114:
        androidx.constraintlayout.a.c.d r27 = r21.a(androidx.constraintlayout.a.c.d.a.f763b);
        r27.f759d = r22.leftMargin;
        androidx.constraintlayout.a.c.d r28 = r21.a(androidx.constraintlayout.a.c.d.a.f765d);
        r28.f759d = r22.rightMargin;
        goto L120
    L113:
        r21.a(androidx.constraintlayout.a.c.e.a.f778d);
        goto L114
    L47:
        if (r1 == (-1)) goto L52;
        androidx.constraintlayout.a.c.e r29 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r1), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L51;
        float r30 = r17;
        r21.a(androidx.constraintlayout.a.c.d.a.f763b, r29, androidx.constraintlayout.a.c.d.a.f763b, r22.leftMargin, r8);
    L57:
        if (r15 == (-1)) goto L61;
        androidx.constraintlayout.a.c.e r31 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r15), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L66;
        r21.a(androidx.constraintlayout.a.c.d.a.f765d, r31, androidx.constraintlayout.a.c.d.a.f763b, r22.rightMargin, r16);
    L66:
        if (r22.topToTop == (-1)) goto L71;
        androidx.constraintlayout.a.c.e r32 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r22.topToTop), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r32 == null) goto L76;
        r21.a(androidx.constraintlayout.a.c.d.a.f764c, r32, androidx.constraintlayout.a.c.d.a.f764c, r22.topMargin, r22.goneTopMargin);
    L76:
        if (r22.bottomToTop == (-1)) goto L81;
        androidx.constraintlayout.a.c.e r33 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r22.bottomToTop), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r33 == null) goto L86;
        r21.a(androidx.constraintlayout.a.c.d.a.f766e, r33, androidx.constraintlayout.a.c.d.a.f764c, r22.bottomMargin, r22.goneBottomMargin);
    L86:
        if (r22.baselineToBaseline == (-1)) goto L89;
        setWidgetBaseline(r21, r22, r23, r22.baselineToBaseline, androidx.constraintlayout.a.c.d.a.f);
    L95:
        if (r30 < 0.0f) goto L98;
        r21.a(r30);
    L98:
        if (r22.verticalBias < 0.0f) goto L100;
        r21.b(r22.verticalBias);
        goto L100
    L89:
        if (r22.baselineToTop == (-1)) goto L92;
        setWidgetBaseline(r21, r22, r23, r22.baselineToTop, androidx.constraintlayout.a.c.d.a.f764c);
        goto L95
    L92:
        if (r22.baselineToBottom == (-1)) goto L95;
        setWidgetBaseline(r21, r22, r23, r22.baselineToBottom, androidx.constraintlayout.a.c.d.a.f766e);
        goto L95
    L81:
        if (r22.bottomToBottom == (-1)) goto L86;
        androidx.constraintlayout.a.c.e r34 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r22.bottomToBottom), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L86;
        r21.a(androidx.constraintlayout.a.c.d.a.f766e, r34, androidx.constraintlayout.a.c.d.a.f766e, r22.bottomMargin, r22.goneBottomMargin);
        goto L86
    L71:
        if (r22.topToBottom == (-1)) goto L76;
        androidx.constraintlayout.a.c.e r35 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r22.topToBottom), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L76;
        r21.a(androidx.constraintlayout.a.c.d.a.f764c, r35, androidx.constraintlayout.a.c.d.a.f766e, r22.topMargin, r22.goneTopMargin);
        goto L76
    L61:
        if (r18 == (-1)) goto L66;
        androidx.constraintlayout.a.c.e r36 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r18), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r36 == null) goto L66;
        r21.a(androidx.constraintlayout.a.c.d.a.f765d, r36, androidx.constraintlayout.a.c.d.a.f765d, r22.rightMargin, r16);
        goto L66
    L51:
        r30 = r17;
        goto L57
    L52:
        r30 = r17;
        if (r5 == (-1)) goto L57;
        androidx.constraintlayout.a.c.e r37 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r23.get(r5), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r37 == null) goto L57;
        r21.a(androidx.constraintlayout.a.c.d.a.f763b, r37, androidx.constraintlayout.a.c.d.a.f765d, r22.leftMargin, r8);
        goto L57
    L41:
        r16 = r13;
        r15 = r6;
        goto L42
    }

    private void setWidgetBaseline(androidx.constraintlayout.a.c.e r3, LayoutParams r4, SparseArray<androidx.constraintlayout.a.c.e> r5, int r6, androidx.constraintlayout.a.c.d.a r7) {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r6), View.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r8 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r5.get(r6), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L12;
        if (r2 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), LayoutParams.class) == false) goto L14;
        r4.needsBaseline = true;
        if (r7 != androidx.constraintlayout.a.c.d.a.f) goto L10;
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r9.needsBaseline = true;
        r9.widget.c(true);
    L10:
        r3.a(androidx.constraintlayout.a.c.d.a.f).a(r8.a(r7), r4.baselineMargin, r4.goneBaselineMargin, true);
        r3.c(true);
        r3.a(androidx.constraintlayout.a.c.d.a.f764c).k();
        r3.a(androidx.constraintlayout.a.c.d.a.f766e).k();
        return;
    L14:
        return;
    }

    private final androidx.constraintlayout.a.c.e getTargetWidget(int r4) {
        if (r4 == 0) goto L4;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r4), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L13;
        r0 = findViewById(r4);
        if (r0 == null) goto L13;
        if (r0 == this) goto L13;
        if (r0.getParent() != this) goto L13;
        onViewAdded(r0);
    L13:
        if (r0 == this) goto L15;
        if (r0 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).widget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    public final androidx.constraintlayout.a.c.e getViewWidget(View r3) {
        if (r3 == this) goto L4;
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L9;
        r3.setLayoutParams(generateLayoutParams(r3.getLayoutParams()));
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).widget;
    L9:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).widget;
    L4:
        return this.mLayoutWidget;
    }

    public void fillMetrics(androidx.constraintlayout.a.e r1) {
        this.mMetrics = r1;
        this.mLayoutWidget.a(r1);
    }

    public void resolveSystem(androidx.constraintlayout.a.c.f r18, int r19, int r20, int r21) {
        int r7 = View.MeasureSpec.getMode(r20);
        int r0 = View.MeasureSpec.getSize(r20);
        int r8 = View.MeasureSpec.getMode(r21);
        int r1 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r2 = r16 + r13;
        int r4 = getPaddingWidth();
        this.mMeasurer.a(r20, r21, r16, r13, r4, r2);
        if (Build.VERSION.SDK_INT < 17) goto L13;
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L10;
        if (r9 > 0) goto L10;
        r5 = Math.max(0, getPaddingLeft());
    L12:
        int r10 = r5;
    L14:
        int r11 = r0 - r4;
        int r12 = r1 - r2;
        setSelfDimensionBehaviour(r18, r7, r11, r8, r12);
        r18.a(r19, r7, r11, r8, r12, this.mLastMeasureWidth, this.mLastMeasureHeight, r10, r16);
        return;
    L10:
        if (isRtl() == false) goto L12;
        r5 = r9;
        goto L12
    L13:
        r10 = Math.max(0, getPaddingLeft());
        goto L14
    }

    public void resolveMeasuredDimension(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
        int r0 = this.mMeasurer.f942e;
        int r9 = resolveSizeAndState(r5 + this.mMeasurer.f941d, r3, 0);
        int r10 = resolveSizeAndState(r6 + r0, r4, 0) & 16777215;
        int r11 = this.mMaxWidth;
        int r12 = Math.min(r11, r9 & 16777215);
        int r13 = Math.min(this.mMaxHeight, r10);
        if (r7 == false) goto L5;
        r12 = r12 | 16777216;
    L5:
        if (r8 == false) goto L7;
        r13 = r13 | 16777216;
    L7:
        setMeasuredDimension(r12, r13);
        this.mLastMeasureWidth = r12;
        this.mLastMeasureHeight = r13;
    }

    @Override // android.view.View
    public void onMeasure(int r9, int r10) {
        if (this.mOnMeasureWidthMeasureSpec != r9) goto L6;
        int r0 = this.mOnMeasureHeightMeasureSpec;
    L6:
        if (this.mDirtyHierarchy == true) goto L13;
        int r1 = getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (getChildAt(r2).isLayoutRequested() == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        this.mDirtyHierarchy = true;
    L13:
        boolean r3 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r9;
        this.mOnMeasureHeightMeasureSpec = r10;
        this.mLayoutWidget.h(isRtl());
        if (this.mDirtyHierarchy == false) goto L18;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L18;
        this.mLayoutWidget.f();
    L18:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r9, r10);
        resolveMeasuredDimension(r9, r10, this.mLayoutWidget.F(), this.mLayoutWidget.G(), this.mLayoutWidget.i(), this.mLayoutWidget.af());
    }

    public boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        if ((((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().flags & UiType.FLAG_NO_FEEDBACK) == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (1 == getLayoutDirection()) goto L12;
        return false;
    L12:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    private int getPaddingWidth() {
        int r1 = 0;
        int r0 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT < 17) goto L5;
        r1 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
    L5:
        if (r1 > 0) goto L7;
        return r0;
    L7:
        return r1;
    }

    public void setSelfDimensionBehaviour(androidx.constraintlayout.a.c.f r9, int r10, int r11, int r12, int r13) {
        int r0 = this.mMeasurer.f942e;
        int r1 = this.mMeasurer.f941d;
        androidx.constraintlayout.a.c.e.a r2 = androidx.constraintlayout.a.c.e.a.f775a;
        androidx.constraintlayout.a.c.e.a r3 = androidx.constraintlayout.a.c.e.a.f775a;
        int r4 = getChildCount();
        if (r10 == Integer.MIN_VALUE) goto L11;
        if (r10 == 0) goto L8;
        if (r10 == 1073741824) goto L7;
    L6:
        r11 = 0;
    L14:
        if (r12 == Integer.MIN_VALUE) goto L22;
        if (r12 == 0) goto L19;
        if (r12 == 1073741824) goto L18;
    L17:
        r13 = 0;
    L26:
        if (r11 == r9.F()) goto L28;
    L29:
        r9.c();
    L30:
        r9.o(0);
        r9.p(0);
        r9.h(this.mMaxWidth - r1);
        r9.i(this.mMaxHeight - r0);
        r9.s(0);
        r9.t(0);
        r9.a(r2);
        r9.q(r11);
        r9.b(r3);
        r9.r(r13);
        r9.s(this.mMinWidth - r1);
        r9.t(this.mMinHeight - r0);
        return;
    L28:
        if (r13 == r9.G()) goto L30;
    L18:
        r13 = Math.min(this.mMaxHeight - r0, r13);
        goto L26
    L19:
        r3 = androidx.constraintlayout.a.c.e.a.f776b;
        if (r4 != 0) goto L17;
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L22:
        r3 = androidx.constraintlayout.a.c.e.a.f776b;
        if (r4 != 0) goto L26;
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L7:
        r11 = Math.min(this.mMaxWidth - r1, r11);
        goto L14
    L8:
        r2 = androidx.constraintlayout.a.c.e.a.f776b;
        if (r4 != 0) goto L6;
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    L11:
        r2 = androidx.constraintlayout.a.c.e.a.f776b;
        if (r4 != 0) goto L14;
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    }

    public void setState(int r1, int r2, int r3) {
        b r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = getChildCount();
        boolean r13 = isInEditMode();
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r12) goto L24;
        View r0 = getChildAt(r15);
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r2 = r1.widget;
        if (r0.getVisibility() != 8) goto L16;
        if (r1.isGuideline == true) goto L16;
        if (r1.isHelper == true) goto L16;
        if (r1.isVirtualGroup == true) goto L16;
        if (r13 == true) goto L16;
    L23:
        r15 = r15 + 1;
    L16:
        if (r1.isInPlaceholder == true) goto L23;
        int r3 = r2.D();
        int r4 = r2.E();
        int r5 = r2.F() + r3;
        int r6 = r2.G() + r4;
        r0.layout(r3, r4, r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, Placeholder.class) == false) goto L23;
        View r16 = ((Placeholder) ZeusTransformUtils.preCheckCast(r0, Placeholder.class, "com.obric.aiagent.plugin")).getContent();
        if (r16 == null) goto L23;
        r16.setVisibility(0);
        r16.layout(r3, r4, r5, r6);
        goto L23
    L24:
        int r17 = this.mConstraintHelpers.size();
        if (r17 <= 0) goto L28;
    L26:
        if (r14 >= r17) goto L36;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r14), ConstraintHelper.class, "com.obric.aiagent.plugin")).updatePostLayout(this);
        r14 = r14 + 1;
        goto L26
    L36:
        return;
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        this.mLayoutWidget.a(r1);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.h();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    public void setConstraintSet(c r1) {
        this.mConstraintSet = r1;
    }

    public View getViewById(int r2) {
        return (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r2), View.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r22) {
        ArrayList<ConstraintHelper> r1 = this.mConstraintHelpers;
        if (r1 == null) goto L9;
        int r2 = r1.size();
        if (r2 <= 0) goto L9;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r4), ConstraintHelper.class, "com.obric.aiagent.plugin")).updatePreDraw(this);
        r4 = r4 + 1;
    L9:
        super.dispatchDraw(r22);
        if (isInEditMode() == false) goto L24;
        float r3 = getWidth();
        float r5 = getHeight();
        int r7 = getChildCount();
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L32;
        View r9 = getChildAt(r8);
        if (r9.getVisibility() == 8) goto L23;
        Object r10 = r9.getTag();
        if (r10 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L23;
        String[] r11 = ((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin")).split(",");
        if (r11.length != 4) goto L23;
        int r12 = Integer.parseInt(r11[0]);
        int r13 = Integer.parseInt(r11[1]);
        int r14 = Integer.parseInt(r11[2]);
        int r15 = (int) ((r12 / 1080.0f) * r3);
        int r16 = (int) ((r13 / 1920.0f) * r5);
        int r17 = (int) ((Integer.parseInt(r11[3]) / 1920.0f) * r5);
        Paint r18 = new Paint();
        r18.setColor(-65536);
        float r19 = r15;
        float r110 = r16;
        float r111 = r15 + ((int) ((r14 / 1080.0f) * r3));
        r22.drawLine(r19, r110, r111, r110, r18);
        float r20 = r16 + r17;
        r22.drawLine(r111, r110, r111, r20, r18);
        r22.drawLine(r111, r20, r19, r20, r18);
        r22.drawLine(r19, r20, r19, r110, r18);
        r18.setColor(-16711936);
        r22.drawLine(r19, r110, r111, r20, r18);
        r22.drawLine(r19, r20, r111, r110, r18);
    L23:
        r8 = r8 + 1;
        goto L12
    L32:
        return;
    }

    public void setOnConstraintsChanged(d r1) {
        this.mConstraintsChangedListener = r1;
        b r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void loadLayoutDescription(int r6) {
        if (r6 != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r6);     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public String getSceneString() {
        StringBuilder r0 = new StringBuilder();
        if (this.mLayoutWidget.k != null) goto L9;
        int r1 = getId();
        if (r1 == (-1)) goto L7;
        this.mLayoutWidget.k = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getResourceEntryName(r1);
        goto L9
    L7:
        this.mLayoutWidget.k = "parent";
    L9:
        if (this.mLayoutWidget.C() != null) goto L11;
        androidx.constraintlayout.a.c.f r2 = this.mLayoutWidget;
        r2.a(r2.k);
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, " setDebugName " + this.mLayoutWidget.C());
    L11:
        Iterator<androidx.constraintlayout.a.c.e> r3 = this.mLayoutWidget.ak().iterator();
    L13:
        if (r3.hasNext() == false) goto L24;
        androidx.constraintlayout.a.c.e r6 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r3.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.T(), View.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        if (r6.k != null) goto L22;
        int r8 = r7.getId();
        if (r8 == (-1)) goto L22;
        r6.k = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getResourceEntryName(r8);
    L22:
        if (r6.C() != null) goto L13;
        r6.a(r6.k);
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, " setDebugName " + r6.C());
        goto L13
    L24:
        this.mLayoutWidget.a(r0);
        return r0.toString();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_constraintlayout_widget_ConstraintLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
