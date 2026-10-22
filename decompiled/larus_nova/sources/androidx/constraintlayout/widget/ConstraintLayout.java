package androidx.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r100 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = r100;
            r100[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
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
        public int baselineToBaseline;
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
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
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
        ConstraintWidget widget;

        public static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map = null;

            private Table() {
            }

            static {
                SparseIntArray r100 = new SparseIntArray();
                map = r100;
                r100.append(84, 8);
                r100.append(85, 9);
                r100.append(87, 10);
                r100.append(88, 11);
                r100.append(94, 12);
                r100.append(93, 13);
                r100.append(65, 14);
                r100.append(64, 15);
                r100.append(60, 16);
                r100.append(66, 2);
                r100.append(68, 3);
                r100.append(67, 4);
                r100.append(103, 49);
                r100.append(104, 50);
                r100.append(72, 5);
                r100.append(73, 6);
                r100.append(74, 7);
                r100.append(0, 1);
                r100.append(89, 17);
                r100.append(90, 18);
                r100.append(71, 19);
                r100.append(70, 20);
                r100.append(108, 21);
                r100.append(111, 22);
                r100.append(109, 23);
                r100.append(106, 24);
                r100.append(110, 25);
                r100.append(107, 26);
                r100.append(80, 29);
                r100.append(95, 30);
                r100.append(69, 44);
                r100.append(82, 45);
                r100.append(97, 46);
                r100.append(81, 47);
                r100.append(96, 48);
                r100.append(58, 27);
                r100.append(57, 28);
                r100.append(99, 31);
                r100.append(76, 32);
                r100.append(101, 33);
                r100.append(100, 34);
                r100.append(102, 35);
                r100.append(78, 36);
                r100.append(77, 37);
                r100.append(79, 38);
                r100.append(83, 39);
                r100.append(92, 40);
                r100.append(86, 41);
                r100.append(63, 42);
                r100.append(59, 43);
                r100.append(91, 51);
            }
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int r100 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r100 == (-2)) goto L5;
        L9:
            int r101 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r101 != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (r100 == 0) goto L19;
            if (r100 == (-1)) goto L19;
        L24:
            if (r101 == 0) goto L26;
            if (r101 == (-1)) goto L26;
        L32:
            if (this.guidePercent == (-1.0f)) goto L34;
        L37:
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if ((this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline) == true) goto L40;
            this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
        L40:
            ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
            return;
        L34:
            if (this.guideBegin != (-1)) goto L37;
            if (this.guideEnd != (-1)) goto L37;
            return;
        L26:
            this.verticalDimensionFixed = false;
            if (r101 != 0) goto L32;
            if (this.matchConstraintDefaultHeight != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.constrainedHeight = true;
        L19:
            this.horizontalDimensionFixed = false;
            if (r100 != 0) goto L24;
            if (this.matchConstraintDefaultWidth != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.constrainedWidth = true;
            goto L24
        L5:
            if (this.constrainedWidth == false) goto L9;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L9;
            this.matchConstraintDefaultWidth = 1;
            goto L9
        }

        public void reset() {
            ConstraintWidget r100 = this.widget;
            if (r100 == null) goto L6;
            r100.reset();
            return;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = r100.guideBegin;
            this.guideEnd = r100.guideEnd;
            this.guidePercent = r100.guidePercent;
            this.leftToLeft = r100.leftToLeft;
            this.leftToRight = r100.leftToRight;
            this.rightToLeft = r100.rightToLeft;
            this.rightToRight = r100.rightToRight;
            this.topToTop = r100.topToTop;
            this.topToBottom = r100.topToBottom;
            this.bottomToTop = r100.bottomToTop;
            this.bottomToBottom = r100.bottomToBottom;
            this.baselineToBaseline = r100.baselineToBaseline;
            this.circleConstraint = r100.circleConstraint;
            this.circleRadius = r100.circleRadius;
            this.circleAngle = r100.circleAngle;
            this.startToEnd = r100.startToEnd;
            this.startToStart = r100.startToStart;
            this.endToStart = r100.endToStart;
            this.endToEnd = r100.endToEnd;
            this.goneLeftMargin = r100.goneLeftMargin;
            this.goneTopMargin = r100.goneTopMargin;
            this.goneRightMargin = r100.goneRightMargin;
            this.goneBottomMargin = r100.goneBottomMargin;
            this.goneStartMargin = r100.goneStartMargin;
            this.goneEndMargin = r100.goneEndMargin;
            this.horizontalBias = r100.horizontalBias;
            this.verticalBias = r100.verticalBias;
            this.dimensionRatio = r100.dimensionRatio;
            this.dimensionRatioValue = r100.dimensionRatioValue;
            this.dimensionRatioSide = r100.dimensionRatioSide;
            this.horizontalWeight = r100.horizontalWeight;
            this.verticalWeight = r100.verticalWeight;
            this.horizontalChainStyle = r100.horizontalChainStyle;
            this.verticalChainStyle = r100.verticalChainStyle;
            this.constrainedWidth = r100.constrainedWidth;
            this.constrainedHeight = r100.constrainedHeight;
            this.matchConstraintDefaultWidth = r100.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r100.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r100.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r100.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r100.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r100.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r100.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r100.matchConstraintPercentHeight;
            this.editorAbsoluteX = r100.editorAbsoluteX;
            this.editorAbsoluteY = r100.editorAbsoluteY;
            this.orientation = r100.orientation;
            this.horizontalDimensionFixed = r100.horizontalDimensionFixed;
            this.verticalDimensionFixed = r100.verticalDimensionFixed;
            this.needsBaseline = r100.needsBaseline;
            this.isGuideline = r100.isGuideline;
            this.resolvedLeftToLeft = r100.resolvedLeftToLeft;
            this.resolvedLeftToRight = r100.resolvedLeftToRight;
            this.resolvedRightToLeft = r100.resolvedRightToLeft;
            this.resolvedRightToRight = r100.resolvedRightToRight;
            this.resolveGoneLeftMargin = r100.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = r100.resolveGoneRightMargin;
            this.resolvedHorizontalBias = r100.resolvedHorizontalBias;
            this.constraintTag = r100.constraintTag;
            this.widget = r100.widget;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r110) {
            int r100 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r101 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(r110);
            boolean r102 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r111 = true;
        L6:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float r103 = this.horizontalBias;
            this.resolvedHorizontalBias = r103;
            int r104 = this.guideBegin;
            this.resolvedGuideBegin = r104;
            int r105 = this.guideEnd;
            this.resolvedGuideEnd = r105;
            float r106 = this.guidePercent;
            this.resolvedGuidePercent = r106;
            if (r111 == false) goto L41;
            int r112 = this.startToEnd;
            if (r112 == (-1)) goto L12;
            this.resolvedRightToLeft = r112;
        L11:
            r102 = true;
        L15:
            int r113 = this.endToStart;
            if (r113 == (-1)) goto L18;
            this.resolvedLeftToRight = r113;
            r102 = true;
        L18:
            int r114 = this.endToEnd;
            if (r114 == (-1)) goto L21;
            this.resolvedLeftToLeft = r114;
            r102 = true;
        L21:
            int r115 = this.goneStartMargin;
            if (r115 == (-1)) goto L24;
            this.resolveGoneRightMargin = r115;
        L24:
            int r116 = this.goneEndMargin;
            if (r116 == (-1)) goto L28;
            this.resolveGoneLeftMargin = r116;
        L28:
            if (r102 == false) goto L31;
            this.resolvedHorizontalBias = 1.0f - r103;
        L31:
            if (this.isGuideline == false) goto L60;
            if (this.orientation != 1) goto L60;
            if (r106 == (-1.0f)) goto L37;
            this.resolvedGuidePercent = 1.0f - r106;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L60
        L37:
            if (r104 == (-1)) goto L39;
            this.resolvedGuideEnd = r104;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0f;
            goto L60
        L39:
            if (r105 == (-1)) goto L60;
            this.resolvedGuideBegin = r105;
            this.resolvedGuideEnd = -1;
            this.resolvedGuidePercent = -1.0f;
        L60:
            if (this.endToStart == (-1)) goto L62;
            return;
        L62:
            if (this.endToEnd == (-1)) goto L64;
            return;
        L64:
            if (this.startToStart == (-1)) goto L66;
            return;
        L66:
            if (this.startToEnd != (-1)) goto L95;
            int r117 = this.rightToLeft;
            if (r117 == (-1)) goto L73;
            this.resolvedRightToLeft = r117;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L79;
            if (r101 <= 0) goto L79;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r101;
        L79:
            int r118 = this.leftToLeft;
            if (r118 == (-1)) goto L85;
            this.resolvedLeftToLeft = r118;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L96;
            if (r100 <= 0) goto L97;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100;
            return;
        L97:
            return;
        L96:
            return;
        L85:
            int r119 = this.leftToRight;
            if (r119 == (-1)) goto L99;
            this.resolvedLeftToRight = r119;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L100;
            if (r100 <= 0) goto L101;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100;
            return;
        L101:
            return;
        L100:
            return;
        L99:
            return;
        L73:
            int r120 = this.rightToRight;
            if (r120 == (-1)) goto L79;
            this.resolvedRightToRight = r120;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L79;
            if (r101 <= 0) goto L79;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r101;
            goto L79
        L95:
            return;
        L12:
            int r121 = this.startToStart;
            if (r121 == (-1)) goto L15;
            this.resolvedRightToRight = r121;
            goto L11
        L41:
            int r122 = this.startToEnd;
            if (r122 == (-1)) goto L44;
            this.resolvedLeftToRight = r122;
        L44:
            int r123 = this.startToStart;
            if (r123 == (-1)) goto L47;
            this.resolvedLeftToLeft = r123;
        L47:
            int r124 = this.endToStart;
            if (r124 == (-1)) goto L50;
            this.resolvedRightToLeft = r124;
        L50:
            int r125 = this.endToEnd;
            if (r125 == (-1)) goto L53;
            this.resolvedRightToRight = r125;
        L53:
            int r126 = this.goneStartMargin;
            if (r126 == (-1)) goto L56;
            this.resolveGoneLeftMargin = r126;
        L56:
            int r127 = this.goneEndMargin;
            if (r127 == (-1)) goto L60;
            this.resolveGoneRightMargin = r127;
            goto L60
        L5:
            r111 = false;
            goto L6
        }

        public void setWidgetDebugName(String r100) {
            this.widget.setDebugName(r100);
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(Context r110, AttributeSet r111) {
            super(r110, r111);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
            int r113 = r112.getIndexCount();
            int r100 = 0;
        L3:
            if (r100 >= r113) goto L135;
            int r101 = r112.getIndex(r100);
            int r102 = Table.map.get(r101);
            switch(r102) {
                case 1: goto L133;
                case 2: goto L130;
                case 3: goto L129;
                case 4: goto L126;
                case 5: goto L125;
                case 6: goto L124;
                case 7: goto L123;
                case 8: goto L120;
                case 9: goto L117;
                case 10: goto L114;
                case 11: goto L111;
                case 12: goto L108;
                case 13: goto L105;
                case 14: goto L102;
                case 15: goto L99;
                case 16: goto L96;
                case 17: goto L93;
                case 18: goto L90;
                case 19: goto L87;
                case 20: goto L84;
                case 21: goto L83;
                case 22: goto L82;
                case 23: goto L81;
                case 24: goto L80;
                case 25: goto L79;
                case 26: goto L78;
                case 27: goto L77;
                case 28: goto L76;
                case 29: goto L75;
                case 30: goto L74;
                case 31: goto L73;
                case 32: goto L72;
                case 33: goto L140;
                case 34: goto L146;
                case 35: goto L61;
                case 36: goto L138;
                case 37: goto L144;
                case 38: goto L50;
                default: goto L6;
            };
        L6:
            switch(r102) {
                case 44: goto L15;
                case 45: goto L14;
                case 46: goto L13;
                case 47: goto L12;
                case 48: goto L11;
                case 49: goto L10;
                case 50: goto L9;
                case 51: goto L8;
                default: goto L134;
            };
        L8:
            this.constraintTag = r112.getString(r101);
            goto L134
        L9:
            this.editorAbsoluteY = r112.getDimensionPixelOffset(r101, this.editorAbsoluteY);
            goto L134
        L10:
            this.editorAbsoluteX = r112.getDimensionPixelOffset(r101, this.editorAbsoluteX);
            goto L134
        L11:
            this.verticalChainStyle = r112.getInt(r101, 0);
            goto L134
        L12:
            this.horizontalChainStyle = r112.getInt(r101, 0);
            goto L134
        L13:
            this.verticalWeight = r112.getFloat(r101, this.verticalWeight);
            goto L134
        L14:
            this.horizontalWeight = r112.getFloat(r101, this.horizontalWeight);
            goto L134
        L15:
            String r103 = r112.getString(r101);
            this.dimensionRatio = r103;
            this.dimensionRatioValue = Float.NaN;
            this.dimensionRatioSide = -1;
            if (r103 == null) goto L134;
            int r104 = r103.length();
            int r105 = this.dimensionRatio.indexOf(44);
            if (r105 > 0) goto L20;
        L28:
            int r106 = 0;
        L29:
            int r107 = this.dimensionRatio.indexOf(58);
            if (r107 >= 0) goto L32;
        L46:
            String r108 = this.dimensionRatio.substring(r106);
            if (r108.length() <= 0) goto L134;
            this.dimensionRatioValue = CastFloatProtector.parseFloat(r108);     // Catch: NumberFormatException -> L137
            goto L134
        L32:
            if (r107 >= (r104 - 1)) goto L46;
            String r109 = this.dimensionRatio.substring(r106, r107);
            String r114 = this.dimensionRatio.substring(r107 + 1);
            if (r109.length() <= 0) goto L134;
            if (r114.length() <= 0) goto L134;
            float r115 = CastFloatProtector.parseFloat(r109);     // Catch: NumberFormatException -> L137
            float r116 = CastFloatProtector.parseFloat(r114);     // Catch: NumberFormatException -> L137
            if (r115 <= 0.0f) goto L134;
            if (r116 <= 0.0f) goto L134;
            if (this.dimensionRatioSide != 1) goto L44;
            this.dimensionRatioValue = Math.abs(r116 / r115);     // Catch: NumberFormatException -> L137
            goto L134
        L44:
            this.dimensionRatioValue = Math.abs(r115 / r116);     // Catch: NumberFormatException -> L137
            goto L134
        L20:
            if (r105 >= (r104 - 1)) goto L28;
            String r117 = this.dimensionRatio.substring(0, r105);
            if (r117.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L25;
            this.dimensionRatioSide = 0;
        L27:
            r106 = r105 + 1;
            goto L29
        L25:
            if (r117.equalsIgnoreCase(FaceService.neutralLabel) == false) goto L27;
            this.dimensionRatioSide = 1;
        L134:
            r100 = r100 + 1;
            goto L3
        L50:
            this.matchConstraintPercentHeight = Math.max(0.0f, r112.getFloat(r101, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L134
        L61:
            this.matchConstraintPercentWidth = Math.max(0.0f, r112.getFloat(r101, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L134
        L72:
            this.matchConstraintDefaultHeight = r112.getInt(r101, 0);
            goto L134
        L73:
            this.matchConstraintDefaultWidth = r112.getInt(r101, 0);
            goto L134
        L74:
            this.verticalBias = r112.getFloat(r101, this.verticalBias);
            goto L134
        L75:
            this.horizontalBias = r112.getFloat(r101, this.horizontalBias);
            goto L134
        L76:
            this.constrainedHeight = r112.getBoolean(r101, this.constrainedHeight);
            goto L134
        L77:
            this.constrainedWidth = r112.getBoolean(r101, this.constrainedWidth);
            goto L134
        L78:
            this.goneEndMargin = r112.getDimensionPixelSize(r101, this.goneEndMargin);
            goto L134
        L79:
            this.goneStartMargin = r112.getDimensionPixelSize(r101, this.goneStartMargin);
            goto L134
        L80:
            this.goneBottomMargin = r112.getDimensionPixelSize(r101, this.goneBottomMargin);
            goto L134
        L81:
            this.goneRightMargin = r112.getDimensionPixelSize(r101, this.goneRightMargin);
            goto L134
        L82:
            this.goneTopMargin = r112.getDimensionPixelSize(r101, this.goneTopMargin);
            goto L134
        L83:
            this.goneLeftMargin = r112.getDimensionPixelSize(r101, this.goneLeftMargin);
            goto L134
        L84:
            int r118 = r112.getResourceId(r101, this.endToEnd);
            this.endToEnd = r118;
            if (r118 != (-1)) goto L134;
            this.endToEnd = r112.getInt(r101, -1);
            goto L134
        L87:
            int r119 = r112.getResourceId(r101, this.endToStart);
            this.endToStart = r119;
            if (r119 != (-1)) goto L134;
            this.endToStart = r112.getInt(r101, -1);
            goto L134
        L90:
            int r120 = r112.getResourceId(r101, this.startToStart);
            this.startToStart = r120;
            if (r120 != (-1)) goto L134;
            this.startToStart = r112.getInt(r101, -1);
            goto L134
        L93:
            int r121 = r112.getResourceId(r101, this.startToEnd);
            this.startToEnd = r121;
            if (r121 != (-1)) goto L134;
            this.startToEnd = r112.getInt(r101, -1);
            goto L134
        L96:
            int r122 = r112.getResourceId(r101, this.baselineToBaseline);
            this.baselineToBaseline = r122;
            if (r122 != (-1)) goto L134;
            this.baselineToBaseline = r112.getInt(r101, -1);
            goto L134
        L99:
            int r123 = r112.getResourceId(r101, this.bottomToBottom);
            this.bottomToBottom = r123;
            if (r123 != (-1)) goto L134;
            this.bottomToBottom = r112.getInt(r101, -1);
            goto L134
        L102:
            int r124 = r112.getResourceId(r101, this.bottomToTop);
            this.bottomToTop = r124;
            if (r124 != (-1)) goto L134;
            this.bottomToTop = r112.getInt(r101, -1);
            goto L134
        L105:
            int r125 = r112.getResourceId(r101, this.topToBottom);
            this.topToBottom = r125;
            if (r125 != (-1)) goto L134;
            this.topToBottom = r112.getInt(r101, -1);
            goto L134
        L108:
            int r126 = r112.getResourceId(r101, this.topToTop);
            this.topToTop = r126;
            if (r126 != (-1)) goto L134;
            this.topToTop = r112.getInt(r101, -1);
            goto L134
        L111:
            int r127 = r112.getResourceId(r101, this.rightToRight);
            this.rightToRight = r127;
            if (r127 != (-1)) goto L134;
            this.rightToRight = r112.getInt(r101, -1);
            goto L134
        L114:
            int r128 = r112.getResourceId(r101, this.rightToLeft);
            this.rightToLeft = r128;
            if (r128 != (-1)) goto L134;
            this.rightToLeft = r112.getInt(r101, -1);
            goto L134
        L117:
            int r129 = r112.getResourceId(r101, this.leftToRight);
            this.leftToRight = r129;
            if (r129 != (-1)) goto L134;
            this.leftToRight = r112.getInt(r101, -1);
            goto L134
        L120:
            int r130 = r112.getResourceId(r101, this.leftToLeft);
            this.leftToLeft = r130;
            if (r130 != (-1)) goto L134;
            this.leftToLeft = r112.getInt(r101, -1);
            goto L134
        L123:
            this.guidePercent = r112.getFloat(r101, this.guidePercent);
            goto L134
        L124:
            this.guideEnd = r112.getDimensionPixelOffset(r101, this.guideEnd);
            goto L134
        L125:
            this.guideBegin = r112.getDimensionPixelOffset(r101, this.guideBegin);
            goto L134
        L126:
            float r131 = r112.getFloat(r101, this.circleAngle) % 360.0f;
            this.circleAngle = r131;
            if (r131 >= 0.0f) goto L134;
            this.circleAngle = (360.0f - r131) % 360.0f;
            goto L134
        L129:
            this.circleRadius = r112.getDimensionPixelSize(r101, this.circleRadius);
            goto L134
        L130:
            int r132 = r112.getResourceId(r101, this.circleConstraint);
            this.circleConstraint = r132;
            if (r132 != (-1)) goto L134;
            this.circleConstraint = r112.getInt(r101, -1);
            goto L134
        L133:
            this.orientation = r112.getInt(r101, this.orientation);
            goto L134
        L138:
            this.matchConstraintMinHeight = r112.getDimensionPixelSize(r101, this.matchConstraintMinHeight);     // Catch: Exception -> L58
        L59:
            if (r112.getInt(r101, this.matchConstraintMinHeight) != (-2)) goto L134;
            this.matchConstraintMinHeight = -2;
            goto L134
        L140:
            this.matchConstraintMinWidth = r112.getDimensionPixelSize(r101, this.matchConstraintMinWidth);     // Catch: Exception -> L69
        L70:
            if (r112.getInt(r101, this.matchConstraintMinWidth) != (-2)) goto L134;
            this.matchConstraintMinWidth = -2;
            goto L134
        L144:
            this.matchConstraintMaxHeight = r112.getDimensionPixelSize(r101, this.matchConstraintMaxHeight);     // Catch: Exception -> L53
        L54:
            if (r112.getInt(r101, this.matchConstraintMaxHeight) != (-2)) goto L134;
            this.matchConstraintMaxHeight = -2;
            goto L134
        L146:
            this.matchConstraintMaxWidth = r112.getDimensionPixelSize(r101, this.matchConstraintMaxWidth);     // Catch: Exception -> L64
        L65:
            if (r112.getInt(r101, this.matchConstraintMaxWidth) != (-2)) goto L134;
            this.matchConstraintMaxWidth = -2;
            goto L134
        L135:
            r112.recycle();
            validate();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }
    }

    public class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;
        final /* synthetic */ ConstraintLayout this$0;

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r100 = this.layout.getChildCount();
            int r101 = 0;
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L8;
            View r103 = this.layout.getChildAt(r102);
            if ((r103 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r103).updatePostMeasure(this.layout);
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            int r104 = ConstraintLayout.access$100(this.layout).size();
            if (r104 <= 0) goto L12;
        L10:
            if (r101 >= r104) goto L17;
            ((ConstraintHelper) ListProtector.get(ConstraintLayout.access$100(this.layout), r101)).updatePostMeasure(this.layout);
            r101 = r101 + 1;
            goto L10
        L17:
            return;
        }

        public Measurer(ConstraintLayout r100, ConstraintLayout r101) {
            this.this$0 = r100;
            this.layout = r101;
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void measure(ConstraintWidget r110, BasicMeasure.Measure r111) {
            if (r110 != null) goto L6;
            return;
        L6:
            if (r110.getVisibility() != 8) goto L12;
            if (r110.isInPlaceholder() == true) goto L12;
            r111.measuredWidth = 0;
            r111.measuredHeight = 0;
            r111.measuredBaseline = 0;
            return;
        L12:
            if (r110.getParent() != null) goto L14;
            return;
        L14:
            ConstraintWidget.DimensionBehaviour r100 = r111.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r101 = r111.verticalBehavior;
            int r102 = r111.horizontalDimension;
            int r103 = r111.verticalDimension;
            int r104 = this.paddingTop + this.paddingBottom;
            int r105 = this.paddingWidth;
            View r112 = (View) r110.getCompanionWidget();
            int[] r113 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            int r114 = r113[r100.ordinal()];
            if (r114 == 1) goto L48;
            if (r114 == 2) goto L47;
            if (r114 == 3) goto L46;
            if (r114 == 4) goto L20;
            int r106 = 0;
        L49:
            int r107 = r113[r101.ordinal()];
            if (r107 == 1) goto L85;
            if (r107 != 2) goto L53;
            int r108 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r104, -2);
        L86:
            ConstraintWidgetContainer r109 = (ConstraintWidgetContainer) r110.getParent();
            if (r109 != null) goto L89;
        L111:
            ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r100 != r115) goto L114;
            boolean r116 = true;
        L115:
            if (r101 != r115) goto L117;
            boolean r117 = true;
        L118:
            ConstraintWidget.DimensionBehaviour r118 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r101 != r118) goto L121;
        L124:
            boolean r119 = true;
        L125:
            if (r100 != r118) goto L127;
        L130:
            boolean r120 = true;
        L132:
            if (r116 == true) goto L134;
        L136:
            boolean r121 = false;
        L137:
            if (r117 == true) goto L139;
        L141:
            boolean r122 = false;
        L142:
            if (r112 != null) goto L144;
            return;
        L144:
            LayoutParams r123 = (LayoutParams) r112.getLayoutParams();
            int r124 = r111.measureStrategy;
            if (r124 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L157;
            if (r124 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L157;
            if (r116 == false) goto L157;
            if (r110.mMatchConstraintDefaultWidth != 0) goto L157;
            if (r117 == false) goto L157;
            if (r110.mMatchConstraintDefaultHeight != 0) goto L157;
            int r125 = -1;
            int r126 = 0;
            int r127 = 0;
            int r128 = 0;
        L196:
            if (r127 == r125) goto L198;
            boolean r129 = true;
        L200:
            if (r128 == r111.horizontalDimension) goto L202;
        L205:
            boolean r130 = true;
        L206:
            r111.measuredNeedsSolverPass = r130;
            if (r123.needsBaseline == false) goto L209;
            r129 = true;
        L209:
            if (r129 == true) goto L211;
        L215:
            r111.measuredWidth = r128;
            r111.measuredHeight = r126;
            r111.measuredHasBaseline = r129;
            r111.measuredBaseline = r127;
            return;
        L211:
            if (r127 == (-1)) goto L215;
            if (r110.getBaselineDistance() == r127) goto L215;
            r111.measuredNeedsSolverPass = true;
            goto L215
        L202:
            if (r126 != r111.verticalDimension) goto L205;
            r130 = false;
            goto L206
        L198:
            r129 = false;
        L157:
            if ((r112 instanceof VirtualLayout) == true) goto L159;
        L161:
            r112.measure(r106, r108);
        L162:
            r110.setLastMeasureSpec(r106, r108);
            int r131 = r112.getMeasuredWidth();
            int r132 = r112.getMeasuredHeight();
            r127 = r112.getBaseline();
            int r133 = r110.mMatchConstraintMinWidth;
            if (r133 <= 0) goto L165;
            r128 = Math.max(r133, r131);
        L166:
            int r134 = r110.mMatchConstraintMaxWidth;
            if (r134 <= 0) goto L169;
            r128 = Math.min(r134, r128);
        L169:
            int r135 = r110.mMatchConstraintMinHeight;
            if (r135 <= 0) goto L172;
            r126 = Math.max(r135, r132);
        L173:
            int r136 = r110.mMatchConstraintMaxHeight;
            if (r136 <= 0) goto L177;
            r126 = Math.min(r136, r126);
        L177:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1) == false) goto L179;
        L185:
            if (r131 != r128) goto L190;
            if (r132 != r126) goto L190;
        L188:
            r125 = -1;
        L190:
            if (r131 == r128) goto L192;
            int r137 = View.MeasureSpec.makeMeasureSpec(r128, 1073741824);
        L193:
            if (r132 == r126) goto L195;
            r108 = View.MeasureSpec.makeMeasureSpec(r126, 1073741824);
        L195:
            r112.measure(r137, r108);
            r110.setLastMeasureSpec(r137, r108);
            r128 = r112.getMeasuredWidth();
            r126 = r112.getMeasuredHeight();
            r127 = r112.getBaseline();
            goto L188
        L192:
            r137 = r106;
            goto L193
        L179:
            if (r121 == false) goto L182;
            if (r119 == false) goto L182;
            r128 = (int) ((r126 * r110.mDimensionRatio) + 0.5f);
        L182:
            if (r122 == false) goto L185;
            if (r120 == false) goto L185;
            r126 = (int) ((r128 / r110.mDimensionRatio) + 0.5f);
            goto L185
        L172:
            r126 = r132;
            goto L173
        L165:
            r128 = r131;
            goto L166
        L159:
            if ((r110 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) == false) goto L161;
            ((VirtualLayout) r112).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) r110, r106, r108);
            goto L162
        L139:
            if (r110.mDimensionRatio <= 0.0f) goto L141;
            r122 = true;
            goto L142
        L134:
            if (r110.mDimensionRatio <= 0.0f) goto L136;
            r121 = true;
            goto L137
        L127:
            if (r100 == ConstraintWidget.DimensionBehaviour.FIXED) goto L130;
            r120 = false;
            goto L132
        L121:
            if (r101 == ConstraintWidget.DimensionBehaviour.FIXED) goto L124;
            r119 = false;
            goto L125
        L117:
            r117 = false;
            goto L118
        L114:
            r116 = false;
            goto L115
        L89:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) == false) goto L111;
            if (r112.getMeasuredWidth() != r110.getWidth()) goto L111;
            if (r112.getMeasuredWidth() >= r109.getWidth()) goto L111;
            if (r112.getMeasuredHeight() != r110.getHeight()) goto L111;
            if (r112.getMeasuredHeight() >= r109.getHeight()) goto L111;
            if (r112.getBaseline() != r110.getBaselineDistance()) goto L111;
            if (r110.isMeasureRequested() == true) goto L111;
            if (isSimilarSpec(r110.getLastHorizontalMeasureSpec(), r106, r110.getWidth()) == true) goto L105;
        L107:
            boolean r138 = false;
        L108:
            if (r138 == false) goto L111;
            r111.measuredWidth = r110.getWidth();
            r111.measuredHeight = r110.getHeight();
            r111.measuredBaseline = r110.getBaselineDistance();
            return;
        L105:
            if (isSimilarSpec(r110.getLastVerticalMeasureSpec(), r108, r110.getHeight()) == false) goto L107;
            r138 = true;
            goto L108
        L53:
            if (r107 != 3) goto L55;
            r108 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r104 + r110.getVerticalMargin(), -1);
            goto L86
        L55:
            if (r107 == 4) goto L57;
            r108 = 0;
            goto L86
        L57:
            r108 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r104, -2);
            if (r110.mMatchConstraintDefaultHeight != 1) goto L60;
            boolean r139 = true;
        L61:
            int r140 = r111.measureStrategy;
            if (r140 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L66;
            if (r140 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L86;
        L66:
            if (r112.getMeasuredWidth() != r110.getWidth()) goto L68;
            boolean r141 = true;
        L70:
            if (r111.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L80;
            if (r139 == false) goto L80;
            if (r139 == false) goto L75;
            if (r141 == true) goto L80;
        L75:
            if ((r112 instanceof Placeholder) == true) goto L80;
            if (r110.isResolvedVertically() == true) goto L80;
            boolean r142 = false;
        L81:
            if (r142 == false) goto L86;
            r108 = View.MeasureSpec.makeMeasureSpec(r110.getHeight(), 1073741824);
        L80:
            r142 = true;
            goto L81
        L68:
            r141 = false;
            goto L70
        L60:
            r139 = false;
            goto L61
        L85:
            r108 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
            goto L86
        L20:
            r106 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r105, -2);
            if (r110.mMatchConstraintDefaultWidth != 1) goto L23;
            boolean r143 = true;
        L24:
            int r144 = r111.measureStrategy;
            if (r144 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L29;
            if (r144 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L49;
        L29:
            if (r112.getMeasuredHeight() != r110.getHeight()) goto L31;
            boolean r145 = true;
        L33:
            if (r111.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L43;
            if (r143 == false) goto L43;
            if (r143 == false) goto L38;
            if (r145 == true) goto L43;
        L38:
            if ((r112 instanceof Placeholder) == true) goto L43;
            if (r110.isResolvedHorizontally() == true) goto L43;
            boolean r146 = false;
        L44:
            if (r146 == false) goto L49;
            r106 = View.MeasureSpec.makeMeasureSpec(r110.getWidth(), 1073741824);
        L43:
            r146 = true;
            goto L44
        L31:
            r145 = false;
            goto L33
        L23:
            r143 = false;
            goto L24
        L46:
            r106 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r105 + r110.getHorizontalMargin(), -1);
            goto L49
        L47:
            r106 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r105, -2);
            goto L49
        L48:
            r106 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
            goto L49
        }

        private boolean isSimilarSpec(int r100, int r101, int r102) {
            if (r100 != r101) goto L5;
            return true;
        L5:
            int r103 = View.MeasureSpec.getMode(r100);
            View.MeasureSpec.getSize(r100);
            int r104 = View.MeasureSpec.getMode(r101);
            int r105 = View.MeasureSpec.getSize(r101);
            if (r104 == 1073741824) goto L8;
            return false;
        L8:
            if (r103 == Integer.MIN_VALUE) goto L10;
            if (r103 == 0) goto L10;
            return false;
        L10:
            if (r102 != r105) goto L15;
            return true;
        L15:
            return false;
        }

        public void captureLayoutInfos(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.paddingTop = r102;
            this.paddingBottom = r103;
            this.paddingWidth = r104;
            this.paddingHeight = r105;
            this.layoutWidthSpec = r100;
            this.layoutHeightSpec = r101;
        }
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

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    private int getPaddingWidth() {
        int r100 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int r101 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    private void setChildrenConstraints() {
        boolean r100 = isInEditMode();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ConstraintWidget r103 = getViewWidget(getChildAt(r102));
        if (r103 == null) goto L8;
        r103.reset();
    L8:
        r102 = r102 + 1;
        goto L3
    L10:
        if (r100 == false) goto L20;
        int r104 = 0;
    L12:
        if (r104 >= r101) goto L20;
        View r105 = getChildAt(r104);
        String r106 = getResources().getResourceName(r105.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r106, Integer.valueOf(r105.getId()));     // Catch: Resources.NotFoundException -> L54
        int r107 = r106.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r107 == (-1)) goto L17;
        r106 = r106.substring(r107 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r105.getId()).setDebugName(r106);     // Catch: Resources.NotFoundException -> L54
    L18:
        r104 = r104 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r108 = 0;
    L22:
        if (r108 >= r101) goto L29;
        View r109 = getChildAt(r108);
        if (r109.getId() != this.mConstraintSetId) goto L28;
        if ((r109 instanceof Constraints) == false) goto L28;
        this.mConstraintSet = ((Constraints) r109).getConstraintSet();
    L28:
        r108 = r108 + 1;
    L29:
        ConstraintSet r110 = this.mConstraintSet;
        if (r110 == null) goto L32;
        r110.applyToInternal(this, true);
    L32:
        this.mLayoutWidget.removeAllChildren();
        int r111 = this.mConstraintHelpers.size();
        if (r111 <= 0) goto L37;
        int r112 = 0;
    L35:
        if (r112 >= r111) goto L37;
        ((ConstraintHelper) ListProtector.get(this.mConstraintHelpers, r112)).updatePreLayout(this);
        r112 = r112 + 1;
    L37:
        int r113 = 0;
    L38:
        if (r113 >= r101) goto L43;
        View r114 = getChildAt(r113);
        if ((r114 instanceof Placeholder) == false) goto L42;
        ((Placeholder) r114).updatePreLayout(this);
    L42:
        r113 = r113 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r115 = 0;
    L44:
        if (r115 >= r101) goto L46;
        View r116 = getChildAt(r115);
        ConstraintWidget r117 = getViewWidget(r116);
        this.mTempMapIdToWidget.put(r116.getId(), r117);
        r115 = r115 + 1;
        goto L44
    L46:
        int r118 = 0;
    L47:
        if (r118 >= r101) goto L53;
        View r119 = getChildAt(r118);
        ConstraintWidget r120 = getViewWidget(r119);
        if (r120 == null) goto L52;
        LayoutParams r121 = (LayoutParams) r119.getLayoutParams();
        this.mLayoutWidget.add(r120);
        applyConstraintsFromLayoutParams(r100, r119, r120, r121, this.mTempMapIdToWidget);
    L52:
        r118 = r118 + 1;
        goto L47
    }

    private boolean updateHierarchy() {
        int r100 = getChildCount();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L8;
        if (getChildAt(r102).isLayoutRequested() == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        r101 = true;
    L8:
        if (r101 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r101;
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return false;
    L8:
        if (1 != getLayoutDirection()) goto L12;
        return true;
    L12:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public ConstraintLayout(Context r100) {
        super(r100);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
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
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public static /* synthetic */ int access$000(ConstraintLayout r100) {
        return r100.mOptimizationLevel;
    }

    public static /* synthetic */ ArrayList access$100(ConstraintLayout r100) {
        return r100.mConstraintHelpers;
    }

    private final ConstraintWidget getTargetWidget(int r100) {
        if (r100 == 0) goto L4;
        View r101 = this.mChildrenByIds.get(r100);
        if (r101 != null) goto L13;
        r101 = findViewById(r100);
        if (r101 == null) goto L13;
        if (r101 == this) goto L13;
        if (r101.getParent() != this) goto L13;
        onViewAdded(r101);
    L13:
        if (r101 == this) goto L15;
        if (r101 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) r101.getLayoutParams()).widget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r110) {
        ArrayList<ConstraintHelper> r100 = this.mConstraintHelpers;
        if (r100 == null) goto L9;
        int r101 = r100.size();
        if (r101 <= 0) goto L9;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L9;
        ((ConstraintHelper) ListProtector.get(this.mConstraintHelpers, r102)).updatePreDraw(this);
        r102 = r102 + 1;
    L9:
        super.dispatchDraw(r110);
        if (isInEditMode() == false) goto L24;
        int r103 = getChildCount();
        float r104 = getWidth();
        float r105 = getHeight();
        int r106 = 0;
    L12:
        if (r106 >= r103) goto L32;
        View r107 = getChildAt(r106);
        if (r107.getVisibility() == 8) goto L23;
        Object r108 = r107.getTag();
        if (r108 == null) goto L23;
        if ((r108 instanceof String) == false) goto L23;
        String[] r109 = ((String) r108).split(",");
        if (r109.length != 4) goto L23;
        int r111 = CastIntegerProtector.parseInt(r109[0]);
        int r112 = CastIntegerProtector.parseInt(r109[1]);
        int r113 = CastIntegerProtector.parseInt(r109[2]);
        int r114 = (int) ((r111 / 1080.0f) * r104);
        int r115 = (int) ((r112 / 1920.0f) * r105);
        int r116 = (int) ((CastIntegerProtector.parseInt(r109[3]) / 1920.0f) * r105);
        Paint r117 = new Paint();
        r117.setColor(-65536);
        float r118 = r114;
        float r119 = r115;
        float r120 = r114 + ((int) ((r113 / 1080.0f) * r104));
        r110.drawLine(r118, r119, r120, r119, r117);
        float r121 = r115 + r116;
        r110.drawLine(r120, r119, r120, r121, r117);
        r110.drawLine(r120, r121, r118, r121, r117);
        r110.drawLine(r118, r121, r118, r119, r117);
        r117.setColor(FakePickerAvatarCreator.GREEN);
        r110.drawLine(r118, r119, r120, r121, r117);
        r110.drawLine(r118, r121, r120, r119, r117);
    L23:
        r106 = r106 + 1;
        goto L12
    L32:
        return;
    }

    public void fillMetrics(Metrics r100) {
        this.mMetrics = r100;
        this.mLayoutWidget.fillMetrics(r100);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public View getViewById(int r100) {
        return this.mChildrenByIds.get(r100);
    }

    public final ConstraintWidget getViewWidget(View r100) {
        if (r100 == this) goto L4;
        if (r100 != null) goto L8;
        return null;
    L8:
        return ((LayoutParams) r100.getLayoutParams()).widget;
    L4:
        return this.mLayoutWidget;
    }

    public void loadLayoutDescription(int r100) {
        if (r100 != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r100);     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r100) {
        super.onViewAdded(r100);
        ConstraintWidget r101 = getViewWidget(r100);
        if ((r100 instanceof Guideline) == false) goto L8;
        if ((r101 instanceof androidx.constraintlayout.solver.widgets.Guideline) == true) goto L8;
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        androidx.constraintlayout.solver.widgets.Guideline r103 = new androidx.constraintlayout.solver.widgets.Guideline();
        r102.widget = r103;
        r102.isGuideline = true;
        r103.setOrientation(r102.orientation);
    L8:
        if ((r100 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r104 = (ConstraintHelper) r100;
        r104.validateParams();
        ((LayoutParams) r100.getLayoutParams()).isHelper = true;
        if (this.mConstraintHelpers.contains(r104) == true) goto L12;
        this.mConstraintHelpers.add(r104);
    L12:
        this.mChildrenByIds.put(r100.getId(), r100);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        this.mChildrenByIds.remove(r100.getId());
        ConstraintWidget r101 = getViewWidget(r100);
        this.mLayoutWidget.remove(r101);
        this.mConstraintHelpers.remove(r100);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int r100) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r100) {
        super.removeView(r100);
    }

    public void setConstraintSet(ConstraintSet r100) {
        this.mConstraintSet = r100;
    }

    @Override // android.view.View
    public void setId(int r100) {
        this.mChildrenByIds.remove(getId());
        super.setId(r100);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r100) {
        if (r100 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r100;
        requestLayout();
    }

    public void setMaxWidth(int r100) {
        if (r100 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r100;
        requestLayout();
    }

    public void setMinHeight(int r100) {
        if (r100 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r100;
        requestLayout();
    }

    public void setMinWidth(int r100) {
        if (r100 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r100;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r100) {
        this.mConstraintsChangedListener = r100;
        ConstraintLayoutStates r101 = this.mConstraintLayoutSpec;
        if (r101 == null) goto L6;
        r101.setOnConstraintsChanged(r100);
        return;
    }

    public void setOptimizationLevel(int r100) {
        this.mOptimizationLevel = r100;
        this.mLayoutWidget.setOptimizationLevel(r100);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public ConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
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
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r101, 0, 0);
    }

    public Object getDesignInformation(int r100, Object r101) {
        if (r100 == 0) goto L4;
        return null;
    L4:
        if ((r101 instanceof String) == false) goto L13;
        String r102 = (String) r101;
        HashMap<String, Integer> r103 = this.mDesignIds;
        if (r103 != null) goto L8;
        return null;
    L8:
        if (r103.containsKey(r102) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r102);
    L13:
        return null;
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r110) {
        if (this.mDirtyHierarchy == true) goto L11;
        int r101 = getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L11;
        if (getChildAt(r102).isLayoutRequested() == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        this.mDirtyHierarchy = true;
    L11:
        if (this.mDirtyHierarchy == true) goto L29;
        int r103 = this.mOnMeasureWidthMeasureSpec;
        if (r103 == r100) goto L15;
    L18:
        if (r103 != r100) goto L29;
        if (View.MeasureSpec.getMode(r100) != 1073741824) goto L29;
        if (View.MeasureSpec.getMode(r110) != Integer.MIN_VALUE) goto L29;
        if (View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) != Integer.MIN_VALUE) goto L29;
        if (View.MeasureSpec.getSize(r110) < this.mLayoutWidget.getHeight()) goto L29;
        this.mOnMeasureWidthMeasureSpec = r100;
        this.mOnMeasureHeightMeasureSpec = r110;
        resolveMeasuredDimension(r100, r110, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        return;
    L15:
        if (this.mOnMeasureHeightMeasureSpec != r110) goto L18;
        resolveMeasuredDimension(r100, r110, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        return;
    L29:
        this.mOnMeasureWidthMeasureSpec = r100;
        this.mOnMeasureHeightMeasureSpec = r110;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L34;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L34;
        this.mLayoutWidget.updateHierarchy();
    L34:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r100, r110);
        resolveMeasuredDimension(r100, r110, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    public ConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
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
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r101, r102, 0);
    }

    private void init(AttributeSet r100, int r101, int r102) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r100 == null) goto L37;
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent}, r101, r102);
        int r104 = r103.getIndexCount();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L36;
        int r106 = r103.getIndex(r105);
        if (r106 != 16) goto L10;
        this.mMinWidth = r103.getDimensionPixelOffset(r106, this.mMinWidth);
    L35:
        r105 = r105 + 1;
        goto L5
    L10:
        if (r106 != 17) goto L13;
        this.mMinHeight = r103.getDimensionPixelOffset(r106, this.mMinHeight);
        goto L35
    L13:
        if (r106 != 14) goto L16;
        this.mMaxWidth = r103.getDimensionPixelOffset(r106, this.mMaxWidth);
        goto L35
    L16:
        if (r106 != 15) goto L19;
        this.mMaxHeight = r103.getDimensionPixelOffset(r106, this.mMaxHeight);
        goto L35
    L19:
        if (r106 != 113) goto L22;
        this.mOptimizationLevel = r103.getInt(r106, this.mOptimizationLevel);
        goto L35
    L22:
        if (r106 != 56) goto L29;
        int r107 = r103.getResourceId(r106, 0);
        if (r107 == 0) goto L35;
        parseLayoutDescription(r107);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r106 != 34) goto L35;
        int r108 = r103.getResourceId(r106, 0);
        ConstraintSet r109 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r109;     // Catch: Resources.NotFoundException -> L33
        r109.load(getContext(), r108);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r108;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r103.recycle();
    L37:
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        super.addView(r100, r101, r102);
    }

    public void setDesignInformation(int r100, Object r101, Object r102) {
        if (r100 == 0) goto L4;
        return;
    L4:
        if ((r101 instanceof String) == true) goto L6;
        return;
    L6:
        if ((r102 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r103 = (String) r101;
        int r104 = r103.indexOf(HTTP.URL_DEFAULT);
        if (r104 == (-1)) goto L13;
        r103 = r103.substring(r104 + 1);
    L13:
        int r105 = ((Integer) r102).intValue();
        this.mDesignIds.put(r103, Integer.valueOf(r105));
    }

    public void setState(int r100, int r101, int r102) {
        ConstraintLayoutStates r103 = this.mConstraintLayoutSpec;
        if (r103 == null) goto L6;
        r103.updateConstraints(r100, r101, r102);
        return;
    }

    public ConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
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
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r101, r102, r103);
    }

    public void resolveSystem(ConstraintWidgetContainer r210, int r211, int r212, int r213) {
        int r100 = View.MeasureSpec.getMode(r212);
        int r101 = View.MeasureSpec.getSize(r212);
        int r110 = View.MeasureSpec.getMode(r213);
        int r102 = View.MeasureSpec.getSize(r213);
        int r111 = Math.max(0, getPaddingTop());
        int r112 = Math.max(0, getPaddingBottom());
        int r103 = r111 + r112;
        int r104 = getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(r212, r213, r111, r112, r104, r103);
        int r105 = Math.max(0, getPaddingStart());
        int r106 = Math.max(0, getPaddingEnd());
        if (r105 > 0) goto L8;
        if (r106 > 0) goto L8;
        int r113 = Math.max(0, getPaddingLeft());
    L11:
        int r114 = r101 - r104;
        int r115 = r102 - r103;
        setSelfDimensionBehaviour(r210, r100, r114, r110, r115);
        r210.measure(r211, r100, r114, r110, r115, this.mLastMeasureWidth, this.mLastMeasureHeight, r113, r111);
        return;
    L8:
        if (isRtl() == false) goto L10;
        r113 = r106;
        goto L11
    L10:
        r113 = r105;
        goto L11
    }

    public void applyConstraintsFromLayoutParams(boolean r110, View r210, ConstraintWidget r211, LayoutParams r212, SparseArray<ConstraintWidget> r213) {
        r212.validate();
        r212.helped = false;
        r211.setVisibility(r210.getVisibility());
        if (r212.isInPlaceholder == false) goto L5;
        r211.setInPlaceholder(true);
        r211.setVisibility(8);
    L5:
        r211.setCompanionWidget(r210);
        if ((r210 instanceof ConstraintHelper) == false) goto L9;
        ((ConstraintHelper) r210).resolveRtl(r211, this.mLayoutWidget.isRtl());
    L9:
        if (r212.isGuideline == false) goto L17;
        androidx.constraintlayout.solver.widgets.Guideline r100 = (androidx.constraintlayout.solver.widgets.Guideline) r211;
        int r101 = r212.resolvedGuideBegin;
        int r102 = r212.resolvedGuideEnd;
        float r103 = r212.resolvedGuidePercent;
        if (r103 == (-1.0f)) goto L13;
        r100.setGuidePercent(r103);
        return;
    L13:
        if (r101 == (-1)) goto L15;
        r100.setGuideBegin(r101);
        return;
    L15:
        if (r102 == (-1)) goto L110;
        r100.setGuideEnd(r102);
        return;
    L110:
        return;
    L17:
        int r104 = r212.resolvedLeftToLeft;
        int r105 = r212.resolvedLeftToRight;
        int r111 = r212.resolvedRightToLeft;
        int r112 = r212.resolvedRightToRight;
        int r106 = r212.resolveGoneLeftMargin;
        int r113 = r212.resolveGoneRightMargin;
        float r107 = r212.resolvedHorizontalBias;
        int r108 = r212.circleConstraint;
        if (r108 == (-1)) goto L22;
        ConstraintWidget r109 = r213.get(r108);
        if (r109 == null) goto L74;
        r211.connectCircularConstraint(r109, r212.circleAngle, r212.circleRadius);
    L74:
        if (r110 == false) goto L81;
        int r114 = r212.editorAbsoluteX;
        if (r114 == (-1)) goto L78;
    L79:
        r211.setOrigin(r114, r212.editorAbsoluteY);
        goto L81
    L78:
        if (r212.editorAbsoluteY != (-1)) goto L79;
    L81:
        if (r212.horizontalDimensionFixed == false) goto L83;
        r211.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r211.setWidth(((ViewGroup.MarginLayoutParams) r212).width);
        if (((ViewGroup.MarginLayoutParams) r212).width != (-2)) goto L94;
        r211.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L94:
        if (r212.verticalDimensionFixed == false) goto L96;
        r211.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r211.setHeight(((ViewGroup.MarginLayoutParams) r212).height);
        if (((ViewGroup.MarginLayoutParams) r212).height != (-2)) goto L106;
        r211.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L106:
        r211.setDimensionRatio(r212.dimensionRatio);
        r211.setHorizontalWeight(r212.horizontalWeight);
        r211.setVerticalWeight(r212.verticalWeight);
        r211.setHorizontalChainStyle(r212.horizontalChainStyle);
        r211.setVerticalChainStyle(r212.verticalChainStyle);
        r211.setHorizontalMatchStyle(r212.matchConstraintDefaultWidth, r212.matchConstraintMinWidth, r212.matchConstraintMaxWidth, r212.matchConstraintPercentWidth);
        r211.setVerticalMatchStyle(r212.matchConstraintDefaultHeight, r212.matchConstraintMinHeight, r212.matchConstraintMaxHeight, r212.matchConstraintPercentHeight);
        return;
    L96:
        if (((ViewGroup.MarginLayoutParams) r212).height == (-1)) goto L98;
        r211.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r211.setHeight(0);
        goto L106
    L98:
        if (r212.constrainedHeight == false) goto L100;
        r211.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L101:
        ConstraintAnchor r115 = r211.getAnchor(ConstraintAnchor.Type.TOP);
        r115.mMargin = ((ViewGroup.MarginLayoutParams) r212).topMargin;
        ConstraintAnchor r116 = r211.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r116.mMargin = ((ViewGroup.MarginLayoutParams) r212).bottomMargin;
        goto L106
    L100:
        r211.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L101
    L83:
        if (((ViewGroup.MarginLayoutParams) r212).width == (-1)) goto L85;
        r211.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r211.setWidth(0);
        goto L94
    L85:
        if (r212.constrainedWidth == false) goto L87;
        r211.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L88:
        ConstraintAnchor r117 = r211.getAnchor(ConstraintAnchor.Type.LEFT);
        r117.mMargin = ((ViewGroup.MarginLayoutParams) r212).leftMargin;
        ConstraintAnchor r118 = r211.getAnchor(ConstraintAnchor.Type.RIGHT);
        r118.mMargin = ((ViewGroup.MarginLayoutParams) r212).rightMargin;
        goto L94
    L87:
        r211.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L88
    L22:
        if (r104 == (-1)) goto L27;
        ConstraintWidget r119 = r213.get(r104);
        if (r119 == null) goto L26;
        ConstraintAnchor.Type r120 = ConstraintAnchor.Type.LEFT;
        float r121 = r107;
        r211.immediateConnect(r120, r119, r120, ((ViewGroup.MarginLayoutParams) r212).leftMargin, r106);
    L32:
        if (r111 == (-1)) goto L36;
        ConstraintWidget r122 = r213.get(r111);
        if (r122 == null) goto L40;
        r211.immediateConnect(ConstraintAnchor.Type.RIGHT, r122, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) r212).rightMargin, r113);
    L40:
        int r123 = r212.topToTop;
        if (r123 == (-1)) goto L45;
        ConstraintWidget r124 = r213.get(r123);
        if (r124 == null) goto L50;
        ConstraintAnchor.Type r125 = ConstraintAnchor.Type.TOP;
        r211.immediateConnect(r125, r124, r125, ((ViewGroup.MarginLayoutParams) r212).topMargin, r212.goneTopMargin);
    L50:
        int r126 = r212.bottomToTop;
        if (r126 == (-1)) goto L55;
        ConstraintWidget r127 = r213.get(r126);
        if (r127 == null) goto L60;
        r211.immediateConnect(ConstraintAnchor.Type.BOTTOM, r127, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) r212).bottomMargin, r212.goneBottomMargin);
    L60:
        int r128 = r212.baselineToBaseline;
        if (r128 == (-1)) goto L68;
        View r129 = this.mChildrenByIds.get(r128);
        ConstraintWidget r130 = r213.get(r212.baselineToBaseline);
        if (r130 == null) goto L68;
        if (r129 == null) goto L68;
        if ((r129.getLayoutParams() instanceof LayoutParams) == false) goto L68;
        LayoutParams r131 = (LayoutParams) r129.getLayoutParams();
        r212.needsBaseline = true;
        r131.needsBaseline = true;
        ConstraintAnchor.Type r132 = ConstraintAnchor.Type.BASELINE;
        r211.getAnchor(r132).connect(r130.getAnchor(r132), 0, -1, true);
        r211.setHasBaseline(true);
        r131.widget.setHasBaseline(true);
        r211.getAnchor(ConstraintAnchor.Type.TOP).reset();
        r211.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
    L68:
        float r133 = r121;
        if (r133 < 0.0f) goto L71;
        r211.setHorizontalBiasPercent(r133);
    L71:
        float r134 = r212.verticalBias;
        if (r134 < 0.0f) goto L74;
        r211.setVerticalBiasPercent(r134);
        goto L74
    L55:
        int r135 = r212.bottomToBottom;
        if (r135 == (-1)) goto L60;
        ConstraintWidget r136 = r213.get(r135);
        if (r136 == null) goto L60;
        ConstraintAnchor.Type r137 = ConstraintAnchor.Type.BOTTOM;
        r211.immediateConnect(r137, r136, r137, ((ViewGroup.MarginLayoutParams) r212).bottomMargin, r212.goneBottomMargin);
        goto L60
    L45:
        int r138 = r212.topToBottom;
        if (r138 == (-1)) goto L50;
        ConstraintWidget r139 = r213.get(r138);
        if (r139 == null) goto L50;
        r211.immediateConnect(ConstraintAnchor.Type.TOP, r139, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) r212).topMargin, r212.goneTopMargin);
        goto L50
    L36:
        if (r112 == (-1)) goto L40;
        ConstraintWidget r140 = r213.get(r112);
        if (r140 == null) goto L40;
        ConstraintAnchor.Type r141 = ConstraintAnchor.Type.RIGHT;
        r211.immediateConnect(r141, r140, r141, ((ViewGroup.MarginLayoutParams) r212).rightMargin, r113);
        goto L40
    L26:
        r121 = r107;
        goto L32
    L27:
        r121 = r107;
        if (r105 == (-1)) goto L32;
        ConstraintWidget r142 = r213.get(r105);
        if (r142 == null) goto L32;
        r211.immediateConnect(ConstraintAnchor.Type.LEFT, r142, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) r212).leftMargin, r106);
        goto L32
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r104 = getChildCount();
        boolean r105 = isInEditMode();
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r104) goto L23;
        View r111 = getChildAt(r107);
        LayoutParams r108 = (LayoutParams) r111.getLayoutParams();
        ConstraintWidget r109 = r108.widget;
        if (r111.getVisibility() != 8) goto L15;
        if (r108.isGuideline == true) goto L15;
        if (r108.isHelper == true) goto L15;
        if (r108.isVirtualGroup == true) goto L15;
        if (r105 == true) goto L15;
    L22:
        r107 = r107 + 1;
    L15:
        if (r108.isInPlaceholder == true) goto L22;
        int r112 = r109.getX();
        int r113 = r109.getY();
        int r114 = r109.getWidth() + r112;
        int r115 = r109.getHeight() + r113;
        r111.layout(r112, r113, r114, r115);
        if ((r111 instanceof Placeholder) == false) goto L22;
        View r116 = ((Placeholder) r111).getContent();
        if (r116 == null) goto L22;
        r116.setVisibility(0);
        r116.layout(r112, r113, r114, r115);
        goto L22
    L23:
        int r117 = this.mConstraintHelpers.size();
        if (r117 <= 0) goto L27;
    L25:
        if (r106 >= r117) goto L35;
        ((ConstraintHelper) ListProtector.get(this.mConstraintHelpers, r106)).updatePostLayout(this);
        r106 = r106 + 1;
        goto L25
    L35:
        return;
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer r100, int r101, int r110, int r111, int r112) {
        Measurer r102 = this.mMeasurer;
        int r103 = r102.paddingHeight;
        int r104 = r102.paddingWidth;
        ConstraintWidget.DimensionBehaviour r105 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r106 = getChildCount();
        if (r101 == Integer.MIN_VALUE) goto L12;
        if (r101 == 0) goto L9;
        if (r101 == 1073741824) goto L8;
        ConstraintWidget.DimensionBehaviour r107 = r105;
    L7:
        r110 = 0;
    L15:
        if (r111 == Integer.MIN_VALUE) goto L23;
        if (r111 == 0) goto L20;
        if (r111 == 1073741824) goto L19;
    L18:
        r112 = 0;
    L27:
        if (r110 == r100.getWidth()) goto L29;
    L30:
        r100.invalidateMeasures();
    L31:
        r100.setX(0);
        r100.setY(0);
        r100.setMaxWidth(this.mMaxWidth - r104);
        r100.setMaxHeight(this.mMaxHeight - r103);
        r100.setMinWidth(0);
        r100.setMinHeight(0);
        r100.setHorizontalDimensionBehaviour(r107);
        r100.setWidth(r110);
        r100.setVerticalDimensionBehaviour(r105);
        r100.setHeight(r112);
        r100.setMinWidth(this.mMinWidth - r104);
        r100.setMinHeight(this.mMinHeight - r103);
        return;
    L29:
        if (r112 == r100.getHeight()) goto L31;
    L19:
        r112 = Math.min(this.mMaxHeight - r103, r112);
        goto L27
    L20:
        r105 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r106 != 0) goto L18;
        r112 = Math.max(0, this.mMinHeight);
        goto L27
    L23:
        r105 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r106 != 0) goto L27;
        r112 = Math.max(0, this.mMinHeight);
        goto L27
    L8:
        r110 = Math.min(this.mMaxWidth - r104, r110);
        r107 = r105;
        goto L15
    L9:
        r107 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r106 != 0) goto L7;
        r110 = Math.max(0, this.mMinWidth);
        goto L15
    L12:
        r107 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r106 != 0) goto L15;
        r110 = Math.max(0, this.mMinWidth);
        goto L15
    }

    public void resolveMeasuredDimension(int r100, int r101, int r102, int r103, boolean r104, boolean r105) {
        Measurer r106 = this.mMeasurer;
        int r107 = r106.paddingHeight;
        int r108 = ViewGroup.resolveSizeAndState(r102 + r106.paddingWidth, r100, 0);
        int r109 = ViewGroup.resolveSizeAndState(r103 + r107, r101, 0) & 16777215;
        int r110 = this.mMaxWidth;
        int r111 = Math.min(r110, r108 & 16777215);
        int r112 = Math.min(this.mMaxHeight, r109);
        if (r104 == false) goto L5;
        r111 = r111 | 16777216;
    L5:
        if (r105 == false) goto L7;
        r112 = r112 | 16777216;
    L7:
        setMeasuredDimension(r111, r112);
        this.mLastMeasureWidth = r111;
        this.mLastMeasureHeight = r112;
    }
}
