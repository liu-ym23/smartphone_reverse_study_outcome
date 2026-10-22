package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.constraintlayout.a.c.h;
import com.obric.oui.constraintlayout.a.c.k;
import com.obric.oui.constraintlayout.a.c.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static e sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected com.obric.oui.constraintlayout.widget.b mConstraintLayoutSpec;
    private c mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected com.obric.oui.constraintlayout.a.c.f mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    a mMeasurer;
    private com.obric.oui.constraintlayout.a.e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private ArrayList<b> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<com.obric.oui.constraintlayout.a.c.e> mTempMapIdToWidget;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34920a = null;

        static {
            int[] r0 = new int[com.obric.oui.constraintlayout.a.c.e.a.values().length];
            f34920a = r0;
            r0[com.obric.oui.constraintlayout.a.c.e.a.f34756a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f34920a[com.obric.oui.constraintlayout.a.c.e.a.f34757b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f34920a[com.obric.oui.constraintlayout.a.c.e.a.f34759d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f34920a[com.obric.oui.constraintlayout.a.c.e.a.f34758c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
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
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftToLeft;
        public int leftToRight;
        int mDimensionRatioSide;
        float mDimensionRatioValue;
        boolean mHeightSet;
        boolean mHorizontalDimensionFixed;
        boolean mIsGuideline;
        boolean mIsHelper;
        boolean mIsInPlaceholder;
        boolean mIsVirtualGroup;
        boolean mNeedsBaseline;
        int mResolveGoneLeftMargin;
        int mResolveGoneRightMargin;
        int mResolvedGuideBegin;
        int mResolvedGuideEnd;
        float mResolvedGuidePercent;
        float mResolvedHorizontalBias;
        int mResolvedLeftToLeft;
        int mResolvedLeftToRight;
        int mResolvedRightToLeft;
        int mResolvedRightToRight;
        boolean mVerticalDimensionFixed;
        com.obric.oui.constraintlayout.a.c.e mWidget;
        boolean mWidthSet;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        public int orientation;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int wrapBehaviorInParent;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f34921a = null;

            static {
                SparseIntArray r0 = new SparseIntArray();
                f34921a = r0;
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

        public com.obric.oui.constraintlayout.a.c.e getConstraintWidget() {
            return this.mWidget;
        }

        public void setWidgetDebugName(String r1) {
            this.mWidget.a(r1);
        }

        public void reset() {
            com.obric.oui.constraintlayout.a.c.e r0 = this.mWidget;
            if (r0 == null) goto L6;
            r0.w();
            return;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
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
            this.mWidthSet = true;
            this.mHeightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.mDimensionRatioValue = 0.0f;
            this.mDimensionRatioSide = 1;
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
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            this.mNeedsBaseline = false;
            this.mIsGuideline = false;
            this.mIsHelper = false;
            this.mIsInPlaceholder = false;
            this.mIsVirtualGroup = false;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolveGoneLeftMargin = Integer.MIN_VALUE;
            this.mResolveGoneRightMargin = Integer.MIN_VALUE;
            this.mResolvedHorizontalBias = 0.5f;
            this.mWidget = new com.obric.oui.constraintlayout.a.c.e();
            this.helped = false;
            if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L6;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
            this.leftMargin = r1.leftMargin;
            this.rightMargin = r1.rightMargin;
            this.topMargin = r1.topMargin;
            this.bottomMargin = r1.bottomMargin;
            setMarginStart(r1.getMarginStart());
            setMarginEnd(r1.getMarginEnd());
        L6:
            if (ZeusTransformUtils.instanceOf(r10, LayoutParams.class) == true) goto L8;
            return;
        L8:
            LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10, LayoutParams.class, "com.obric.aiagent.plugin");
            this.guideBegin = r11.guideBegin;
            this.guideEnd = r11.guideEnd;
            this.guidePercent = r11.guidePercent;
            this.guidelineUseRtl = r11.guidelineUseRtl;
            this.leftToLeft = r11.leftToLeft;
            this.leftToRight = r11.leftToRight;
            this.rightToLeft = r11.rightToLeft;
            this.rightToRight = r11.rightToRight;
            this.topToTop = r11.topToTop;
            this.topToBottom = r11.topToBottom;
            this.bottomToTop = r11.bottomToTop;
            this.bottomToBottom = r11.bottomToBottom;
            this.baselineToBaseline = r11.baselineToBaseline;
            this.baselineToTop = r11.baselineToTop;
            this.baselineToBottom = r11.baselineToBottom;
            this.circleConstraint = r11.circleConstraint;
            this.circleRadius = r11.circleRadius;
            this.circleAngle = r11.circleAngle;
            this.startToEnd = r11.startToEnd;
            this.startToStart = r11.startToStart;
            this.endToStart = r11.endToStart;
            this.endToEnd = r11.endToEnd;
            this.goneLeftMargin = r11.goneLeftMargin;
            this.goneTopMargin = r11.goneTopMargin;
            this.goneRightMargin = r11.goneRightMargin;
            this.goneBottomMargin = r11.goneBottomMargin;
            this.goneStartMargin = r11.goneStartMargin;
            this.goneEndMargin = r11.goneEndMargin;
            this.goneBaselineMargin = r11.goneBaselineMargin;
            this.baselineMargin = r11.baselineMargin;
            this.horizontalBias = r11.horizontalBias;
            this.verticalBias = r11.verticalBias;
            this.dimensionRatio = r11.dimensionRatio;
            this.mDimensionRatioValue = r11.mDimensionRatioValue;
            this.mDimensionRatioSide = r11.mDimensionRatioSide;
            this.horizontalWeight = r11.horizontalWeight;
            this.verticalWeight = r11.verticalWeight;
            this.horizontalChainStyle = r11.horizontalChainStyle;
            this.verticalChainStyle = r11.verticalChainStyle;
            this.constrainedWidth = r11.constrainedWidth;
            this.constrainedHeight = r11.constrainedHeight;
            this.matchConstraintDefaultWidth = r11.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r11.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r11.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r11.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r11.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r11.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r11.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r11.matchConstraintPercentHeight;
            this.editorAbsoluteX = r11.editorAbsoluteX;
            this.editorAbsoluteY = r11.editorAbsoluteY;
            this.orientation = r11.orientation;
            this.mHorizontalDimensionFixed = r11.mHorizontalDimensionFixed;
            this.mVerticalDimensionFixed = r11.mVerticalDimensionFixed;
            this.mNeedsBaseline = r11.mNeedsBaseline;
            this.mIsGuideline = r11.mIsGuideline;
            this.mResolvedLeftToLeft = r11.mResolvedLeftToLeft;
            this.mResolvedLeftToRight = r11.mResolvedLeftToRight;
            this.mResolvedRightToLeft = r11.mResolvedRightToLeft;
            this.mResolvedRightToRight = r11.mResolvedRightToRight;
            this.mResolveGoneLeftMargin = r11.mResolveGoneLeftMargin;
            this.mResolveGoneRightMargin = r11.mResolveGoneRightMargin;
            this.mResolvedHorizontalBias = r11.mResolvedHorizontalBias;
            this.constraintTag = r11.constraintTag;
            this.wrapBehaviorInParent = r11.wrapBehaviorInParent;
            this.mWidget = r11.mWidget;
            this.mWidthSet = r11.mWidthSet;
            this.mHeightSet = r11.mHeightSet;
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
            this.mWidthSet = true;
            this.mHeightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.mDimensionRatioValue = 0.0f;
            this.mDimensionRatioSide = 1;
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
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            this.mNeedsBaseline = false;
            this.mIsGuideline = false;
            this.mIsHelper = false;
            this.mIsInPlaceholder = false;
            this.mIsVirtualGroup = false;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolveGoneLeftMargin = Integer.MIN_VALUE;
            this.mResolveGoneRightMargin = Integer.MIN_VALUE;
            this.mResolvedHorizontalBias = 0.5f;
            this.mWidget = new com.obric.oui.constraintlayout.a.c.e();
            this.helped = false;
            TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.ConstraintLayout_Layout);
            int r16 = r15.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r16) goto L118;
            int r5 = r15.getIndex(r1);
            int r6 = a.f34921a.get(r5);
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
            this.mHeightSet = true;
            goto L117
        L12:
            c.a(this, r15, r5, 0);
            this.mWidthSet = true;
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
            INVOKESTATIC_com_obric_oui_constraintlayout_widget_ConstraintLayout$LayoutParams_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r10 = r15.getInt(r5, 0);
            this.matchConstraintDefaultWidth = r10;
            if (r10 != 1) goto L117;
            INVOKESTATIC_com_obric_oui_constraintlayout_widget_ConstraintLayout$LayoutParams_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
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
            this.mIsGuideline = false;
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            if (this.width != (-2)) goto L10;
            if (this.constrainedWidth == false) goto L10;
            this.mHorizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L10;
            this.matchConstraintDefaultWidth = 1;
        L10:
            if (this.height != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.mVerticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (this.width != 0) goto L19;
        L20:
            this.mHorizontalDimensionFixed = false;
            if (this.width == 0) goto L23;
        L26:
            if (this.height != 0) goto L28;
        L29:
            this.mVerticalDimensionFixed = false;
            if (this.height == 0) goto L32;
        L35:
            if (this.guidePercent == (-1.0f)) goto L37;
        L40:
            this.mIsGuideline = true;
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            if (ZeusTransformUtils.instanceOf(this.mWidget, h.class) == true) goto L43;
            this.mWidget = new h();
        L43:
            ((h) ZeusTransformUtils.preCheckCast(this.mWidget, h.class, "com.obric.aiagent.plugin")).a(this.orientation);
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
            this.mWidthSet = true;
            this.mHeightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.mDimensionRatioValue = 0.0f;
            this.mDimensionRatioSide = 1;
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
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            this.mNeedsBaseline = false;
            this.mIsGuideline = false;
            this.mIsHelper = false;
            this.mIsInPlaceholder = false;
            this.mIsVirtualGroup = false;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolveGoneLeftMargin = Integer.MIN_VALUE;
            this.mResolveGoneRightMargin = Integer.MIN_VALUE;
            this.mResolvedHorizontalBias = 0.5f;
            this.mWidget = new com.obric.oui.constraintlayout.a.c.e();
            this.helped = false;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r11) {
            int r0 = this.leftMargin;
            int r1 = this.rightMargin;
            super.resolveLayoutDirection(r11);
            boolean r2 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r12 = true;
        L6:
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolveGoneLeftMargin = -1;
            this.mResolveGoneRightMargin = -1;
            this.mResolveGoneLeftMargin = this.goneLeftMargin;
            this.mResolveGoneRightMargin = this.goneRightMargin;
            float r5 = this.horizontalBias;
            this.mResolvedHorizontalBias = r5;
            int r6 = this.guideBegin;
            this.mResolvedGuideBegin = r6;
            int r7 = this.guideEnd;
            this.mResolvedGuideEnd = r7;
            float r8 = this.guidePercent;
            this.mResolvedGuidePercent = r8;
            if (r12 == false) goto L43;
            int r13 = this.startToEnd;
            if (r13 == (-1)) goto L12;
            this.mResolvedRightToLeft = r13;
        L11:
            r2 = true;
        L15:
            int r14 = this.endToStart;
            if (r14 == (-1)) goto L18;
            this.mResolvedLeftToRight = r14;
            r2 = true;
        L18:
            int r15 = this.endToEnd;
            if (r15 == (-1)) goto L21;
            this.mResolvedLeftToLeft = r15;
            r2 = true;
        L21:
            int r16 = this.goneStartMargin;
            if (r16 == Integer.MIN_VALUE) goto L24;
            this.mResolveGoneRightMargin = r16;
        L24:
            int r17 = this.goneEndMargin;
            if (r17 == Integer.MIN_VALUE) goto L28;
            this.mResolveGoneLeftMargin = r17;
        L28:
            if (r2 == false) goto L31;
            this.mResolvedHorizontalBias = 1.0f - r5;
        L31:
            if (this.mIsGuideline == false) goto L62;
            if (this.orientation != 1) goto L62;
            if (this.guidelineUseRtl == false) goto L62;
            if (r8 == (-1.0f)) goto L39;
            this.mResolvedGuidePercent = 1.0f - r8;
            this.mResolvedGuideBegin = -1;
            this.mResolvedGuideEnd = -1;
            goto L62
        L39:
            if (r6 == (-1)) goto L41;
            this.mResolvedGuideEnd = r6;
            this.mResolvedGuideBegin = -1;
            this.mResolvedGuidePercent = -1.0f;
            goto L62
        L41:
            if (r7 == (-1)) goto L62;
            this.mResolvedGuideBegin = r7;
            this.mResolvedGuideEnd = -1;
            this.mResolvedGuidePercent = -1.0f;
        L62:
            if (this.endToStart == (-1)) goto L64;
            return;
        L64:
            if (this.endToEnd == (-1)) goto L66;
            return;
        L66:
            if (this.startToStart == (-1)) goto L68;
            return;
        L68:
            if (this.startToEnd != (-1)) goto L97;
            int r18 = this.rightToLeft;
            if (r18 == (-1)) goto L75;
            this.mResolvedRightToLeft = r18;
            if (this.rightMargin > 0) goto L81;
            if (r1 <= 0) goto L81;
            this.rightMargin = r1;
        L81:
            int r19 = this.leftToLeft;
            if (r19 == (-1)) goto L87;
            this.mResolvedLeftToLeft = r19;
            if (this.leftMargin > 0) goto L98;
            if (r0 <= 0) goto L99;
            this.leftMargin = r0;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r110 = this.leftToRight;
            if (r110 == (-1)) goto L101;
            this.mResolvedLeftToRight = r110;
            if (this.leftMargin > 0) goto L102;
            if (r0 <= 0) goto L103;
            this.leftMargin = r0;
            return;
        L103:
            return;
        L102:
            return;
        L101:
            return;
        L75:
            int r111 = this.rightToRight;
            if (r111 == (-1)) goto L81;
            this.mResolvedRightToRight = r111;
            if (this.rightMargin > 0) goto L81;
            if (r1 <= 0) goto L81;
            this.rightMargin = r1;
            goto L81
        L97:
            return;
        L12:
            int r112 = this.startToStart;
            if (r112 == (-1)) goto L15;
            this.mResolvedRightToRight = r112;
            goto L11
        L43:
            int r113 = this.startToEnd;
            if (r113 == (-1)) goto L46;
            this.mResolvedLeftToRight = r113;
        L46:
            int r114 = this.startToStart;
            if (r114 == (-1)) goto L49;
            this.mResolvedLeftToLeft = r114;
        L49:
            int r115 = this.endToStart;
            if (r115 == (-1)) goto L52;
            this.mResolvedRightToLeft = r115;
        L52:
            int r116 = this.endToEnd;
            if (r116 == (-1)) goto L55;
            this.mResolvedRightToRight = r116;
        L55:
            int r117 = this.goneStartMargin;
            if (r117 == Integer.MIN_VALUE) goto L58;
            this.mResolveGoneLeftMargin = r117;
        L58:
            int r118 = this.goneEndMargin;
            if (r118 == Integer.MIN_VALUE) goto L62;
            this.mResolveGoneRightMargin = r118;
            goto L62
        L5:
            r12 = false;
            goto L6
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_oui_constraintlayout_widget_ConstraintLayout$LayoutParams_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    class a implements com.obric.oui.constraintlayout.a.c.a.b.InterfaceC0938b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f34922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f34923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f34924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f34925d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f34926e;
        int f;
        int g;
        final /* synthetic */ ConstraintLayout h;

        public void a(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.f34923b = r3;
            this.f34924c = r4;
            this.f34925d = r5;
            this.f34926e = r6;
            this.f = r1;
            this.g = r2;
        }

        a(ConstraintLayout r1, ConstraintLayout r2) {
            this.h = r1;
            this.f34922a = r2;
        }

        @Override // com.obric.oui.constraintlayout.a.c.a.b.InterfaceC0938b
        public final void a(com.obric.oui.constraintlayout.a.c.e r22, com.obric.oui.constraintlayout.a.c.a.b.a r23) {
            if (r22 != null) goto L6;
            return;
        L6:
            if (r22.B() != 8) goto L12;
            if (r22.s() == true) goto L12;
            r23.h = 0;
            r23.i = 0;
            r23.j = 0;
            return;
        L12:
            if (r22.A() != null) goto L14;
            return;
        L14:
            long r3 = 0;
            if (ConstraintLayout.access$000(this.h) == null) goto L17;
            ConstraintLayout.access$000(this.h).I++;
            r3 = System.nanoTime();
        L17:
            com.obric.oui.constraintlayout.a.c.e.a r6 = r23.f34681d;
            com.obric.oui.constraintlayout.a.c.e.a r8 = r23.f34682e;
            int r9 = r23.f;
            int r10 = r23.g;
            int r11 = this.f34923b + this.f34924c;
            int r12 = this.f34925d;
            View r13 = (View) ZeusTransformUtils.preCheckCast(r22.T(), View.class, "com.obric.aiagent.plugin");
            int r14 = AnonymousClass1.f34920a[r6.ordinal()];
            if (r14 != 1) goto L20;
            int r5 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
        L55:
            int r7 = AnonymousClass1.f34920a[r8.ordinal()];
            if (r7 != 1) goto L58;
            int r15 = View.MeasureSpec.makeMeasureSpec(r10, 1073741824);
        L93:
            com.obric.oui.constraintlayout.a.c.f r16 = (com.obric.oui.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(r22.A(), com.obric.oui.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L119;
            if (k.a(ConstraintLayout.access$100(this.h), 256) == false) goto L119;
            if (r13.getMeasuredWidth() != r22.F()) goto L119;
            if (r13.getMeasuredWidth() >= r16.F()) goto L119;
            if (r13.getMeasuredHeight() != r22.G()) goto L119;
            if (r13.getMeasuredHeight() >= r16.G()) goto L119;
            if (r13.getBaseline() != r22.S()) goto L119;
            if (r22.t() == true) goto L119;
            if (a(r22.u(), r5, r22.F()) == true) goto L112;
        L114:
            boolean r17 = false;
        L115:
            if (r17 == false) goto L119;
            r23.h = r22.F();
            r23.i = r22.G();
            r23.j = r22.S();
            return;
        L112:
            if (a(r22.v(), r15, r22.G()) == false) goto L114;
            r17 = true;
        L119:
            if (r6 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L121;
            boolean r18 = true;
        L123:
            if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L125;
            boolean r19 = true;
        L127:
            if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L129;
        L132:
            boolean r20 = true;
        L134:
            if (r6 != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L136;
        L139:
            boolean r21 = true;
        L141:
            if (r18 == true) goto L143;
        L145:
            boolean r110 = false;
        L146:
            if (r19 == true) goto L148;
        L150:
            boolean r111 = false;
        L151:
            if (r13 != null) goto L153;
            return;
        L153:
            long r112 = r3;
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            if (r23.m == com.obric.oui.constraintlayout.a.c.a.b.a.f34679b) goto L166;
            if (r23.m == com.obric.oui.constraintlayout.a.c.a.b.a.f34680c) goto L166;
            if (r18 == false) goto L166;
            if (r22.n != 0) goto L166;
            if (r19 == false) goto L166;
            if (r22.o != 0) goto L166;
            int r24 = -1;
            int r113 = 0;
            int r114 = 0;
            int r115 = 0;
        L205:
            if (r113 == r24) goto L207;
            boolean r25 = true;
        L209:
            if (r114 == r23.f) goto L211;
        L214:
            boolean r26 = true;
        L215:
            r23.l = r26;
            if (r4.mNeedsBaseline == false) goto L218;
            r25 = true;
        L218:
            if (r25 == true) goto L220;
        L224:
            r23.h = r114;
            r23.i = r115;
            r23.k = r25;
            r23.j = r113;
            if (ConstraintLayout.access$000(this.h) == null) goto L228;
            long r1 = System.nanoTime();
            ConstraintLayout.access$000(this.h).f34777a += r1 - r112;
            return;
        L228:
            return;
        L220:
            if (r113 == (-1)) goto L224;
            if (r22.S() == r113) goto L224;
            r23.l = true;
            goto L224
        L211:
            if (r115 != r23.g) goto L214;
            r26 = false;
            goto L215
        L207:
            r25 = false;
        L166:
            if (ZeusTransformUtils.instanceOf(r13, VirtualLayout.class) == true) goto L168;
        L170:
            r13.measure(r5, r15);
        L171:
            r22.d(r5, r15);
            int r27 = r13.getMeasuredWidth();
            int r28 = r13.getMeasuredHeight();
            r113 = r13.getBaseline();
            if (r22.q <= 0) goto L174;
            r114 = Math.max(r22.q, r27);
        L176:
            if (r22.r <= 0) goto L179;
            r114 = Math.min(r22.r, r114);
        L179:
            if (r22.t <= 0) goto L181;
            r115 = Math.max(r22.t, r28);
        L183:
            if (r22.u <= 0) goto L185;
            r115 = Math.min(r22.u, r115);
        L185:
            int r29 = r15;
            if (k.a(ConstraintLayout.access$100(this.h), 1) == false) goto L188;
        L194:
            if (r27 != r114) goto L198;
            if (r28 != r115) goto L198;
        L197:
            r24 = -1;
        L198:
            if (r27 == r114) goto L200;
            int r30 = 1073741824;
            int r31 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        L201:
            if (r28 == r115) goto L203;
            int r32 = View.MeasureSpec.makeMeasureSpec(r115, r30);
        L204:
            r13.measure(r31, r32);
            r22.d(r31, r32);
            r114 = r13.getMeasuredWidth();
            r115 = r13.getMeasuredHeight();
            r113 = r13.getBaseline();
            goto L197
        L203:
            r32 = r29;
            goto L204
        L200:
            r30 = 1073741824;
            r31 = r5;
            goto L201
        L188:
            if (r110 == false) goto L191;
            if (r20 == false) goto L191;
            r114 = (int) ((r115 * r22.P) + 0.5f);
        L191:
            if (r111 == false) goto L194;
            if (r21 == false) goto L194;
            r115 = (int) ((r114 / r22.P) + 0.5f);
            goto L194
        L181:
            r115 = r28;
            goto L183
        L174:
            r114 = r27;
            goto L176
        L168:
            if (ZeusTransformUtils.instanceOf(r22, m.class) == false) goto L170;
            ((VirtualLayout) ZeusTransformUtils.preCheckCast(r13, VirtualLayout.class, "com.obric.aiagent.plugin")).onMeasure((m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin"), r5, r15);
            goto L171
        L148:
            if (r22.P <= 0.0f) goto L150;
            r111 = true;
            goto L151
        L143:
            if (r22.P <= 0.0f) goto L145;
            r110 = true;
            goto L146
        L136:
            if (r6 == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L139;
            r21 = false;
            goto L141
        L129:
            if (r8 == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L132;
            r20 = false;
            goto L134
        L125:
            r19 = false;
            goto L127
        L121:
            r18 = false;
            goto L123
        L58:
            if (r7 != 2) goto L60;
            r15 = ViewGroup.getChildMeasureSpec(this.g, r11, -2);
            goto L93
        L60:
            if (r7 != 3) goto L62;
            r15 = ViewGroup.getChildMeasureSpec(this.g, r11 + r22.O(), -1);
            goto L93
        L62:
            if (r7 == 4) goto L64;
            r15 = 0;
            goto L93
        L64:
            r15 = ViewGroup.getChildMeasureSpec(this.g, r11, -2);
            if (r22.o != 1) goto L67;
            boolean r33 = true;
        L69:
            if (r23.m == com.obric.oui.constraintlayout.a.c.a.b.a.f34679b) goto L73;
            if (r23.m != com.obric.oui.constraintlayout.a.c.a.b.a.f34680c) goto L93;
        L73:
            if (r13.getMeasuredWidth() != r22.F()) goto L75;
            boolean r116 = true;
        L77:
            if (r23.m == com.obric.oui.constraintlayout.a.c.a.b.a.f34680c) goto L87;
            if (r33 == false) goto L87;
            if (r33 == false) goto L82;
            if (r116 == true) goto L87;
        L82:
            if (ZeusTransformUtils.instanceOf(r13, Placeholder.class) == true) goto L87;
            if (r22.e() == true) goto L87;
            boolean r34 = false;
        L88:
            if (r34 == false) goto L93;
            r15 = View.MeasureSpec.makeMeasureSpec(r22.G(), 1073741824);
        L87:
            r34 = true;
            goto L88
        L75:
            r116 = false;
            goto L77
        L67:
            r33 = false;
            goto L69
        L20:
            if (r14 != 2) goto L22;
            r5 = ViewGroup.getChildMeasureSpec(this.f, r12, -2);
            goto L55
        L22:
            if (r14 != 3) goto L24;
            r5 = ViewGroup.getChildMeasureSpec(this.f, r12 + r22.N(), -1);
            goto L55
        L24:
            if (r14 == 4) goto L26;
            r5 = 0;
            goto L55
        L26:
            r5 = ViewGroup.getChildMeasureSpec(this.f, r12, -2);
            if (r22.n != 1) goto L29;
            boolean r35 = true;
        L31:
            if (r23.m == com.obric.oui.constraintlayout.a.c.a.b.a.f34679b) goto L35;
            if (r23.m != com.obric.oui.constraintlayout.a.c.a.b.a.f34680c) goto L55;
        L35:
            if (r13.getMeasuredHeight() != r22.G()) goto L37;
            boolean r117 = true;
        L39:
            if (r23.m == com.obric.oui.constraintlayout.a.c.a.b.a.f34680c) goto L49;
            if (r35 == false) goto L49;
            if (r35 == false) goto L44;
            if (r117 == true) goto L49;
        L44:
            if (ZeusTransformUtils.instanceOf(r13, Placeholder.class) == true) goto L49;
            if (r22.d() == true) goto L49;
            boolean r36 = false;
        L50:
            if (r36 == false) goto L55;
            r5 = View.MeasureSpec.makeMeasureSpec(r22.F(), 1073741824);
        L49:
            r36 = true;
            goto L50
        L37:
            r117 = false;
            goto L39
        L29:
            r35 = false;
            goto L31
        }

        private boolean a(int r3, int r4, int r5) {
            if (r3 != r4) goto L5;
            return true;
        L5:
            int r6 = View.MeasureSpec.getMode(r3);
            int r0 = View.MeasureSpec.getMode(r4);
            int r7 = View.MeasureSpec.getSize(r4);
            if (r0 == 1073741824) goto L8;
        L12:
            return false;
        L8:
            if (r6 == Integer.MIN_VALUE) goto L10;
            if (r6 != 0) goto L12;
        L10:
            if (r5 != r7) goto L12;
            return true;
        }

        @Override // com.obric.oui.constraintlayout.a.c.a.b.InterfaceC0938b
        public final void a() {
            int r0 = this.f34922a.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L9;
            View r4 = this.f34922a.getChildAt(r2);
            if (ZeusTransformUtils.instanceOf(r4, Placeholder.class) == false) goto L8;
            ((Placeholder) ZeusTransformUtils.preCheckCast(r4, Placeholder.class, "com.obric.aiagent.plugin")).updatePostMeasure(this.f34922a);
        L8:
            r2 = r2 + 1;
            goto L4
        L9:
            int r3 = ConstraintLayout.access$200(this.f34922a).size();
            if (r3 <= 0) goto L13;
        L11:
            if (r1 >= r3) goto L18;
            ((ConstraintHelper) ZeusTransformUtils.preCheckCast(ConstraintLayout.access$200(this.f34922a).get(r1), ConstraintHelper.class, "com.obric.aiagent.plugin")).updatePostMeasure(this.f34922a);
            r1 = r1 + 1;
            goto L11
        L18:
            return;
        }
    }

    public interface b {
        boolean update(int r1, int r2, int r3, View r4, LayoutParams r5);
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

    static /* synthetic */ com.obric.oui.constraintlayout.a.e access$000(ConstraintLayout r0) {
        return r0.mMetrics;
    }

    static /* synthetic */ int access$100(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$200(ConstraintLayout r0) {
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
        this.mLayoutWidget = new com.obric.oui.constraintlayout.a.c.f();
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
        this.mLayoutWidget = new com.obric.oui.constraintlayout.a.c.f();
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
        this.mLayoutWidget = new com.obric.oui.constraintlayout.a.c.f();
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
        this.mLayoutWidget = new com.obric.oui.constraintlayout.a.c.f();
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
        this.mConstraintLayoutSpec = new com.obric.oui.constraintlayout.widget.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r5);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r6) {
        super.onViewAdded(r6);
        com.obric.oui.constraintlayout.a.c.e r0 = getViewWidget(r6);
        if (ZeusTransformUtils.instanceOf(r6, Guideline.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, h.class) == true) goto L8;
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r1.mWidget = new h();
        r1.mIsGuideline = true;
        ((h) ZeusTransformUtils.preCheckCast(r1.mWidget, h.class, "com.obric.aiagent.plugin")).a(r1.orientation);
    L8:
        if (ZeusTransformUtils.instanceOf(r6, ConstraintHelper.class) == false) goto L12;
        ConstraintHelper r2 = (ConstraintHelper) ZeusTransformUtils.preCheckCast(r6, ConstraintHelper.class, "com.obric.aiagent.plugin");
        r2.validateParams();
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mIsHelper = true;
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
        com.obric.oui.constraintlayout.a.c.e r0 = getViewWidget(r3);
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
        com.obric.oui.constraintlayout.a.c.e r2 = getViewWidget(getChildAt(r1));
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
        com.obric.oui.constraintlayout.a.c.e r20 = getViewWidget(r19);
        if (r20 == null) goto L52;
        LayoutParams r21 = (LayoutParams) ZeusTransformUtils.preCheckCast(r19.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        this.mLayoutWidget.b(r20);
        applyConstraintsFromLayoutParams(r6, r19, r20, r21, this.mTempMapIdToWidget);
    L52:
        r18 = r18 + 1;
        goto L47
    }

    public void applyConstraintsFromLayoutParams(boolean r18, View r19, com.obric.oui.constraintlayout.a.c.e r20, LayoutParams r21, SparseArray<com.obric.oui.constraintlayout.a.c.e> r22) {
        r21.validate();
        r21.helped = false;
        r20.l(r19.getVisibility());
        if (r21.mIsInPlaceholder == false) goto L5;
        r20.d(true);
        r20.l(8);
    L5:
        r20.a(r19);
        if (ZeusTransformUtils.instanceOf(r19, ConstraintHelper.class) == false) goto L10;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r19, ConstraintHelper.class, "com.obric.aiagent.plugin")).resolveRtl(r20, this.mLayoutWidget.ag());
    L10:
        if (r21.mIsGuideline == false) goto L18;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r20, h.class, "com.obric.aiagent.plugin");
        int r1 = r21.mResolvedGuideBegin;
        int r2 = r21.mResolvedGuideEnd;
        float r3 = r21.mResolvedGuidePercent;
        if (r3 == (-1.0f)) goto L14;
        r0.e(r3);
        return;
    L14:
        if (r1 == (-1)) goto L16;
        r0.b(r1);
        return;
    L16:
        if (r2 == (-1)) goto L112;
        r0.A(r2);
        return;
    L112:
        return;
    L18:
        int r4 = r21.mResolvedLeftToLeft;
        int r5 = r21.mResolvedLeftToRight;
        int r13 = r21.mResolvedRightToLeft;
        int r14 = r21.mResolvedRightToRight;
        int r6 = r21.mResolveGoneLeftMargin;
        int r15 = r21.mResolveGoneRightMargin;
        float r7 = r21.mResolvedHorizontalBias;
        if (r21.circleConstraint == (-1)) goto L23;
        com.obric.oui.constraintlayout.a.c.e r8 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r21.circleConstraint), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L76;
        r20.a(r8, r21.circleAngle, r21.circleRadius);
    L76:
        if (r18 == false) goto L83;
        if (r21.editorAbsoluteX == (-1)) goto L80;
    L81:
        r20.e(r21.editorAbsoluteX, r21.editorAbsoluteY);
        goto L83
    L80:
        if (r21.editorAbsoluteY != (-1)) goto L81;
    L83:
        if (r21.mHorizontalDimensionFixed == false) goto L85;
        r20.a(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        r20.q(r21.width);
        if (r21.width != (-2)) goto L96;
        r20.a(com.obric.oui.constraintlayout.a.c.e.a.f34757b);
    L96:
        if (r21.mVerticalDimensionFixed == false) goto L98;
        r20.b(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        r20.r(r21.height);
        if (r21.height != (-2)) goto L108;
        r20.b(com.obric.oui.constraintlayout.a.c.e.a.f34757b);
    L108:
        r20.b(r21.dimensionRatio);
        r20.c(r21.horizontalWeight);
        r20.d(r21.verticalWeight);
        r20.v(r21.horizontalChainStyle);
        r20.w(r21.verticalChainStyle);
        r20.k(r21.wrapBehaviorInParent);
        r20.a(r21.matchConstraintDefaultWidth, r21.matchConstraintMinWidth, r21.matchConstraintMaxWidth, r21.matchConstraintPercentWidth);
        r20.b(r21.matchConstraintDefaultHeight, r21.matchConstraintMinHeight, r21.matchConstraintMaxHeight, r21.matchConstraintPercentHeight);
        return;
    L98:
        if (r21.height == (-1)) goto L100;
        r20.b(com.obric.oui.constraintlayout.a.c.e.a.f34758c);
        r20.r(0);
        goto L108
    L100:
        if (r21.constrainedHeight == false) goto L102;
        r20.b(com.obric.oui.constraintlayout.a.c.e.a.f34758c);
    L103:
        com.obric.oui.constraintlayout.a.c.d r9 = r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34745c);
        r9.f34740d = r21.topMargin;
        com.obric.oui.constraintlayout.a.c.d r10 = r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e);
        r10.f34740d = r21.bottomMargin;
        goto L108
    L102:
        r20.b(com.obric.oui.constraintlayout.a.c.e.a.f34759d);
        goto L103
    L85:
        if (r21.width == (-1)) goto L87;
        r20.a(com.obric.oui.constraintlayout.a.c.e.a.f34758c);
        r20.q(0);
        goto L96
    L87:
        if (r21.constrainedWidth == false) goto L89;
        r20.a(com.obric.oui.constraintlayout.a.c.e.a.f34758c);
    L90:
        com.obric.oui.constraintlayout.a.c.d r11 = r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34744b);
        r11.f34740d = r21.leftMargin;
        com.obric.oui.constraintlayout.a.c.d r12 = r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34746d);
        r12.f34740d = r21.rightMargin;
        goto L96
    L89:
        r20.a(com.obric.oui.constraintlayout.a.c.e.a.f34759d);
        goto L90
    L23:
        if (r4 == (-1)) goto L28;
        com.obric.oui.constraintlayout.a.c.e r16 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r4), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L27;
        float r17 = r7;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34744b, r16, com.obric.oui.constraintlayout.a.c.d.a.f34744b, r21.leftMargin, r6);
    L33:
        if (r13 == (-1)) goto L37;
        com.obric.oui.constraintlayout.a.c.e r23 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r13), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L42;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34746d, r23, com.obric.oui.constraintlayout.a.c.d.a.f34744b, r21.rightMargin, r15);
    L42:
        if (r21.topToTop == (-1)) goto L47;
        com.obric.oui.constraintlayout.a.c.e r24 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r21.topToTop), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L52;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34745c, r24, com.obric.oui.constraintlayout.a.c.d.a.f34745c, r21.topMargin, r21.goneTopMargin);
    L52:
        if (r21.bottomToTop == (-1)) goto L57;
        com.obric.oui.constraintlayout.a.c.e r25 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r21.bottomToTop), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L62;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e, r25, com.obric.oui.constraintlayout.a.c.d.a.f34745c, r21.bottomMargin, r21.goneBottomMargin);
    L62:
        if (r21.baselineToBaseline == (-1)) goto L65;
        setWidgetBaseline(r20, r21, r22, r21.baselineToBaseline, com.obric.oui.constraintlayout.a.c.d.a.f);
    L71:
        if (r17 < 0.0f) goto L74;
        r20.a(r17);
    L74:
        if (r21.verticalBias < 0.0f) goto L76;
        r20.b(r21.verticalBias);
        goto L76
    L65:
        if (r21.baselineToTop == (-1)) goto L68;
        setWidgetBaseline(r20, r21, r22, r21.baselineToTop, com.obric.oui.constraintlayout.a.c.d.a.f34745c);
        goto L71
    L68:
        if (r21.baselineToBottom == (-1)) goto L71;
        setWidgetBaseline(r20, r21, r22, r21.baselineToBottom, com.obric.oui.constraintlayout.a.c.d.a.f34747e);
        goto L71
    L57:
        if (r21.bottomToBottom == (-1)) goto L62;
        com.obric.oui.constraintlayout.a.c.e r26 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r21.bottomToBottom), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L62;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e, r26, com.obric.oui.constraintlayout.a.c.d.a.f34747e, r21.bottomMargin, r21.goneBottomMargin);
        goto L62
    L47:
        if (r21.topToBottom == (-1)) goto L52;
        com.obric.oui.constraintlayout.a.c.e r27 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r21.topToBottom), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L52;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34745c, r27, com.obric.oui.constraintlayout.a.c.d.a.f34747e, r21.topMargin, r21.goneTopMargin);
        goto L52
    L37:
        if (r14 == (-1)) goto L42;
        com.obric.oui.constraintlayout.a.c.e r28 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r14), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r28 == null) goto L42;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34746d, r28, com.obric.oui.constraintlayout.a.c.d.a.f34746d, r21.rightMargin, r15);
        goto L42
    L27:
        r17 = r7;
        goto L33
    L28:
        r17 = r7;
        if (r5 == (-1)) goto L33;
        com.obric.oui.constraintlayout.a.c.e r29 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r22.get(r5), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L33;
        r20.a(com.obric.oui.constraintlayout.a.c.d.a.f34744b, r29, com.obric.oui.constraintlayout.a.c.d.a.f34746d, r21.leftMargin, r6);
        goto L33
    }

    private void setWidgetBaseline(com.obric.oui.constraintlayout.a.c.e r3, LayoutParams r4, SparseArray<com.obric.oui.constraintlayout.a.c.e> r5, int r6, com.obric.oui.constraintlayout.a.c.d.a r7) {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r6), View.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.a.c.e r8 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r5.get(r6), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L12;
        if (r2 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), LayoutParams.class) == false) goto L14;
        r4.mNeedsBaseline = true;
        if (r7 != com.obric.oui.constraintlayout.a.c.d.a.f) goto L10;
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r9.mNeedsBaseline = true;
        r9.mWidget.c(true);
    L10:
        r3.a(com.obric.oui.constraintlayout.a.c.d.a.f).a(r8.a(r7), r4.baselineMargin, r4.goneBaselineMargin, true);
        r3.c(true);
        r3.a(com.obric.oui.constraintlayout.a.c.d.a.f34745c).k();
        r3.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e).k();
        return;
    L14:
        return;
    }

    private com.obric.oui.constraintlayout.a.c.e getTargetWidget(int r4) {
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
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mWidget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    public final com.obric.oui.constraintlayout.a.c.e getViewWidget(View r3) {
        if (r3 == this) goto L4;
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L9;
        r3.setLayoutParams(generateLayoutParams(r3.getLayoutParams()));
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mWidget;
    L9:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mWidget;
    L4:
        return this.mLayoutWidget;
    }

    public void fillMetrics(com.obric.oui.constraintlayout.a.e r1) {
        this.mMetrics = r1;
        this.mLayoutWidget.a(r1);
    }

    public void resolveSystem(com.obric.oui.constraintlayout.a.c.f r18, int r19, int r20, int r21) {
        int r7 = View.MeasureSpec.getMode(r20);
        int r0 = View.MeasureSpec.getSize(r20);
        int r8 = View.MeasureSpec.getMode(r21);
        int r1 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r2 = r16 + r13;
        int r4 = getPaddingWidth();
        this.mMeasurer.a(r20, r21, r16, r13, r4, r2);
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L8;
        if (r9 > 0) goto L8;
        r9 = Math.max(0, getPaddingLeft());
    L11:
        int r10 = r0 - r4;
        int r11 = r1 - r2;
        setSelfDimensionBehaviour(r18, r7, r10, r8, r11);
        r18.a(r19, r7, r10, r8, r11, this.mLastMeasureWidth, this.mLastMeasureHeight, r9, r16);
        return;
    L8:
        if (isRtl() == true) goto L11;
        r9 = r5;
        goto L11
    }

    public void resolveMeasuredDimension(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
        int r0 = this.mMeasurer.f34926e;
        int r9 = resolveSizeAndState(r5 + this.mMeasurer.f34925d, r3, 0);
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
    public void onMeasure(int r11, int r12) {
        if (this.mMetrics == null) goto L5;
        long r0 = System.nanoTime();
        this.mMetrics.K = getChildCount();
        this.mMetrics.L++;
    L6:
        boolean r2 = this.mDirtyHierarchy | dynamicUpdateConstraints(r11, r12);
        this.mDirtyHierarchy = r2;
        if (r2 == true) goto L14;
        int r3 = getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        if (getChildAt(r4).isLayoutRequested() == true) goto L12;
        r4 = r4 + 1;
        goto L9
    L12:
        this.mDirtyHierarchy = true;
    L14:
        boolean r5 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r11;
        this.mOnMeasureHeightMeasureSpec = r12;
        this.mLayoutWidget.h(isRtl());
        if (this.mDirtyHierarchy == false) goto L19;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L19;
        this.mLayoutWidget.f();
    L19:
        this.mLayoutWidget.a(this.mMetrics);
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r11, r12);
        resolveMeasuredDimension(r11, r12, this.mLayoutWidget.F(), this.mLayoutWidget.G(), this.mLayoutWidget.i(), this.mLayoutWidget.af());
        com.obric.oui.constraintlayout.a.e r10 = this.mMetrics;
        if (r10 == null) goto L25;
        r10.f34776J += System.nanoTime() - r0;
        return;
    L25:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public boolean isRtl() {
        if ((((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().flags & UiType.FLAG_NO_FEEDBACK) == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (1 == getLayoutDirection()) goto L10;
        return false;
    L10:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private int getPaddingWidth() {
        int r0 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int r2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (r2 > 0) goto L5;
        return r0;
    L5:
        return r2;
    }

    public void setSelfDimensionBehaviour(com.obric.oui.constraintlayout.a.c.f r9, int r10, int r11, int r12, int r13) {
        int r0 = this.mMeasurer.f34926e;
        int r1 = this.mMeasurer.f34925d;
        com.obric.oui.constraintlayout.a.c.e.a r2 = com.obric.oui.constraintlayout.a.c.e.a.f34756a;
        com.obric.oui.constraintlayout.a.c.e.a r3 = com.obric.oui.constraintlayout.a.c.e.a.f34756a;
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
        r3 = com.obric.oui.constraintlayout.a.c.e.a.f34757b;
        if (r4 != 0) goto L17;
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L22:
        r3 = com.obric.oui.constraintlayout.a.c.e.a.f34757b;
        if (r4 != 0) goto L26;
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L7:
        r11 = Math.min(this.mMaxWidth - r1, r11);
        goto L14
    L8:
        r2 = com.obric.oui.constraintlayout.a.c.e.a.f34757b;
        if (r4 != 0) goto L6;
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    L11:
        r2 = com.obric.oui.constraintlayout.a.c.e.a.f34757b;
        if (r4 != 0) goto L14;
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    }

    public void setState(int r1, int r2, int r3) {
        com.obric.oui.constraintlayout.widget.b r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        com.obric.oui.constraintlayout.a.e r12 = this.mMetrics;
        if (r12 == null) goto L5;
        r12.H++;
    L5:
        int r13 = getChildCount();
        boolean r14 = isInEditMode();
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r16 >= r13) goto L27;
        View r0 = getChildAt(r16);
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.a.c.e r2 = r1.mWidget;
        if (r0.getVisibility() != 8) goto L19;
        if (r1.mIsGuideline == true) goto L19;
        if (r1.mIsHelper == true) goto L19;
        if (r1.mIsVirtualGroup == true) goto L19;
        if (r14 == true) goto L19;
    L26:
        r16 = r16 + 1;
    L19:
        if (r1.mIsInPlaceholder == true) goto L26;
        int r3 = r2.D();
        int r4 = r2.E();
        int r5 = r2.F() + r3;
        int r6 = r2.G() + r4;
        r0.layout(r3, r4, r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, Placeholder.class) == false) goto L26;
        View r17 = ((Placeholder) ZeusTransformUtils.preCheckCast(r0, Placeholder.class, "com.obric.aiagent.plugin")).getContent();
        if (r17 == null) goto L26;
        r17.setVisibility(0);
        r17.layout(r3, r4, r5, r6);
        goto L26
    L27:
        int r18 = this.mConstraintHelpers.size();
        if (r18 <= 0) goto L31;
    L29:
        if (r15 >= r18) goto L39;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r15), ConstraintHelper.class, "com.obric.aiagent.plugin")).updatePostLayout(this);
        r15 = r15 + 1;
        goto L29
    L39:
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
        com.obric.oui.constraintlayout.widget.b r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void loadLayoutDescription(int r6) {
        if (r6 != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new com.obric.oui.constraintlayout.widget.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r6);     // Catch: Resources.NotFoundException -> L6
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
        com.obric.oui.constraintlayout.a.c.f r2 = this.mLayoutWidget;
        r2.a(r2.k);
        INVOKESTATIC_com_obric_oui_constraintlayout_widget_ConstraintLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, " setDebugName " + this.mLayoutWidget.C());
    L11:
        Iterator<com.obric.oui.constraintlayout.a.c.e> r3 = this.mLayoutWidget.ak().iterator();
    L13:
        if (r3.hasNext() == false) goto L24;
        com.obric.oui.constraintlayout.a.c.e r6 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.T(), View.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        if (r6.k != null) goto L22;
        int r8 = r7.getId();
        if (r8 == (-1)) goto L22;
        r6.k = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getResourceEntryName(r8);
    L22:
        if (r6.C() != null) goto L13;
        r6.a(r6.k);
        INVOKESTATIC_com_obric_oui_constraintlayout_widget_ConstraintLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(TAG, " setDebugName " + r6.C());
        goto L13
    L24:
        this.mLayoutWidget.a(r0);
        return r0.toString();
    }

    public void addValueModifier(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.mModifiers != null) goto L5;
        this.mModifiers = new ArrayList();
    L5:
        this.mModifiers.add(r4);
    }

    void removeValueModifier(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.mModifiers.remove(r4);
    }

    public boolean dynamicUpdateConstraints(int r12, int r13) {
        boolean r1 = false;
        if (this.mModifiers != null) goto L5;
        return false;
    L5:
        int r14 = View.MeasureSpec.getSize(r12);
        int r15 = View.MeasureSpec.getSize(r13);
        Iterator<b> r0 = this.mModifiers.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        b r9 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin");
        Iterator<com.obric.oui.constraintlayout.a.c.e> r10 = this.mLayoutWidget.ak().iterator();
    L10:
        if (r10.hasNext() == false) goto L7;
        View r6 = (View) ZeusTransformUtils.preCheckCast(((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).T(), View.class, "com.obric.aiagent.plugin");
        r1 = r1 | r9.update(r14, r15, r6.getId(), r6, (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L10
    L12:
        return r1;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_constraintlayout_widget_ConstraintLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
