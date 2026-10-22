package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes17.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols;
    private ConstraintWidget[] mAlignedBiggestElementsInRows;
    private int[] mAlignedDimensions;
    private ArrayList<WidgetsList> mChainList;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount;
    private float mFirstHorizontalBias;
    private int mFirstHorizontalStyle;
    private float mFirstVerticalBias;
    private int mFirstVerticalStyle;
    private int mHorizontalAlign;
    private float mHorizontalBias;
    private int mHorizontalGap;
    private int mHorizontalStyle;
    private float mLastHorizontalBias;
    private int mLastHorizontalStyle;
    private float mLastVerticalBias;
    private int mLastVerticalStyle;
    private int mMaxElementsWrap;
    private int mOrientation;
    private int mVerticalAlign;
    private float mVerticalBias;
    private int mVerticalGap;
    private int mVerticalStyle;
    private int mWrapMode;

    public class WidgetsList {
        private ConstraintWidget biggest;
        int biggestDimension;
        private ConstraintAnchor mBottom;
        private int mCount;
        private int mHeight;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mNbMatchConstraintsWidgets;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private int mStartIndex;
        private ConstraintAnchor mTop;
        private int mWidth;
        final /* synthetic */ Flow this$0;

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int r100 = this.mCount;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L26;
            if ((this.mStartIndex + r101) >= Flow.access$400(this.this$0)) goto L33;
            ConstraintWidget r102 = Flow.access$500(this.this$0)[this.mStartIndex + r101];
            if (this.mOrientation != 0) goto L17;
            int r103 = r102.getWidth();
            int r104 = Flow.access$000(this.this$0);
            if (r102.getVisibility() != 8) goto L12;
            r104 = 0;
        L12:
            this.mWidth += r103 + r104;
            int r105 = Flow.access$300(this.this$0, r102, this.mMax);
            if (this.biggest != null) goto L15;
        L16:
            this.biggest = r102;
            this.biggestDimension = r105;
            this.mHeight = r105;
        L25:
            r101 = r101 + 1;
            goto L3
        L15:
            if (this.biggestDimension >= r105) goto L25;
        L17:
            int r106 = Flow.access$200(this.this$0, r102, this.mMax);
            int r107 = Flow.access$300(this.this$0, r102, this.mMax);
            int r108 = Flow.access$100(this.this$0);
            if (r102.getVisibility() != 8) goto L20;
            r108 = 0;
        L20:
            this.mHeight += r107 + r108;
            if (this.biggest != null) goto L23;
        L24:
            this.biggest = r102;
            this.biggestDimension = r106;
            this.mWidth = r106;
            goto L25
        L23:
            if (this.biggestDimension >= r106) goto L25;
        L33:
            return;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public int getHeight() {
            if (this.mOrientation != 1) goto L7;
            return this.mHeight - Flow.access$100(this.this$0);
        L7:
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation != 0) goto L7;
            return this.mWidth - Flow.access$000(this.this$0);
        L7:
            return this.mWidth;
        }

        public static /* synthetic */ ConstraintWidget access$2000(WidgetsList r100) {
            return r100.biggest;
        }

        public void add(ConstraintWidget r100) {
            int r101 = 0;
            if (this.mOrientation != 0) goto L16;
            int r102 = Flow.access$200(this.this$0, r100, this.mMax);
            if (r100.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.mNbMatchConstraintsWidgets++;
            r102 = 0;
        L7:
            int r103 = Flow.access$000(this.this$0);
            if (r100.getVisibility() == 8) goto L11;
            r101 = r103;
        L11:
            this.mWidth += r102 + r101;
            int r104 = Flow.access$300(this.this$0, r100, this.mMax);
            if (this.biggest != null) goto L14;
        L15:
            this.biggest = r100;
            this.biggestDimension = r104;
            this.mHeight = r104;
        L28:
            this.mCount++;
            return;
        L14:
            if (this.biggestDimension >= r104) goto L28;
        L16:
            int r105 = Flow.access$200(this.this$0, r100, this.mMax);
            int r106 = Flow.access$300(this.this$0, r100, this.mMax);
            if (r100.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.mNbMatchConstraintsWidgets++;
            r106 = 0;
        L19:
            int r107 = Flow.access$100(this.this$0);
            if (r100.getVisibility() == 8) goto L23;
            r101 = r107;
        L23:
            this.mHeight += r106 + r101;
            if (this.biggest != null) goto L26;
        L27:
            this.biggest = r100;
            this.biggestDimension = r105;
            this.mWidth = r105;
            goto L28
        L26:
            if (this.biggestDimension >= r105) goto L28;
            goto L27
        }

        public void measureMatchConstraints(int r100) {
            int r101 = this.mNbMatchConstraintsWidgets;
            if (r101 != 0) goto L5;
            return;
        L5:
            int r102 = this.mCount;
            int r103 = r100 / r101;
            int r104 = 0;
        L6:
            if (r104 >= r102) goto L25;
            if ((this.mStartIndex + r104) >= Flow.access$400(this.this$0)) goto L25;
            ConstraintWidget r105 = Flow.access$500(this.this$0)[this.mStartIndex + r104];
            if (this.mOrientation != 0) goto L18;
            if (r105 == null) goto L24;
            if (r105.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r105.mMatchConstraintDefaultWidth != 0) goto L24;
            this.this$0.measure(r105, ConstraintWidget.DimensionBehaviour.FIXED, r103, r105.getVerticalDimensionBehaviour(), r105.getHeight());
        L24:
            r104 = r104 + 1;
            goto L6
        L18:
            if (r105 == null) goto L24;
            if (r105.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r105.mMatchConstraintDefaultHeight != 0) goto L24;
            this.this$0.measure(r105, r105.getHorizontalDimensionBehaviour(), r105.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r103);
        L25:
            recomputeDimensions();
        }

        public void setStartIndex(int r100) {
            this.mStartIndex = r100;
        }

        public void createConstraints(boolean r110, int r111, boolean r112) {
            int r100 = this.mCount;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L11;
            if ((this.mStartIndex + r101) >= Flow.access$400(this.this$0)) goto L11;
            ConstraintWidget r102 = Flow.access$500(this.this$0)[this.mStartIndex + r101];
            if (r102 == null) goto L10;
            r102.resetAnchors();
        L10:
            r101 = r101 + 1;
        L11:
            if (r100 != 0) goto L13;
            return;
        L13:
            if (this.biggest == null) goto L206;
            if (r112 == false) goto L18;
            if (r111 != 0) goto L18;
            boolean r103 = true;
        L19:
            int r104 = 0;
            int r105 = -1;
            int r106 = -1;
        L20:
            if (r104 >= r100) goto L33;
            if (r110 == false) goto L23;
            int r107 = (r100 - 1) - r104;
        L25:
            if ((this.mStartIndex + r107) >= Flow.access$400(this.this$0)) goto L33;
            if (Flow.access$500(this.this$0)[this.mStartIndex + r107].getVisibility() != 0) goto L32;
            if (r105 != (-1)) goto L31;
            r105 = r104;
        L31:
            r106 = r104;
        L32:
            r104 = r104 + 1;
            goto L20
        L23:
            r107 = r104;
        L33:
            ConstraintWidget r108 = null;
            if (this.mOrientation != 0) goto L112;
            ConstraintWidget r109 = this.biggest;
            r109.setVerticalChainStyle(Flow.access$600(this.this$0));
            int r113 = this.mPaddingTop;
            if (r111 <= 0) goto L38;
            r113 = r113 + Flow.access$100(this.this$0);
        L38:
            r109.mTop.connect(this.mTop, r113);
            if (r112 == false) goto L41;
            r109.mBottom.connect(this.mBottom, this.mPaddingBottom);
        L41:
            if (r111 <= 0) goto L44;
            this.mTop.mOwner.mBottom.connect(r109.mTop, 0);
        L44:
            if (Flow.access$700(this.this$0) == 3) goto L46;
        L59:
            ConstraintWidget r114 = r109;
        L60:
            int r115 = 0;
        L61:
            if (r115 >= r100) goto L207;
            if (r110 == false) goto L64;
            int r116 = (r100 - 1) - r115;
        L66:
            if ((this.mStartIndex + r116) >= Flow.access$400(this.this$0)) goto L208;
            ConstraintWidget r117 = Flow.access$500(this.this$0)[this.mStartIndex + r116];
            if (r115 != 0) goto L71;
            r117.connect(r117.mLeft, this.mLeft, this.mPaddingLeft);
        L71:
            if (r116 != 0) goto L83;
            int r118 = Flow.access$800(this.this$0);
            float r119 = Flow.access$900(this.this$0);
            if (this.mStartIndex == 0) goto L75;
        L77:
            if (r112 == true) goto L79;
        L81:
            r117.setHorizontalChainStyle(r118);
            r117.setHorizontalBiasPercent(r119);
            goto L83
        L79:
            if (Flow.access$1200(this.this$0) == (-1)) goto L81;
            r118 = Flow.access$1200(this.this$0);
            r119 = Flow.access$1300(this.this$0);
            goto L81
        L75:
            if (Flow.access$1000(this.this$0) == (-1)) goto L77;
            r118 = Flow.access$1000(this.this$0);
            r119 = Flow.access$1100(this.this$0);
        L83:
            if (r115 != (r100 - 1)) goto L85;
            r117.connect(r117.mRight, this.mRight, this.mPaddingRight);
        L85:
            if (r108 == null) goto L92;
            r117.mLeft.connect(r108.mRight, Flow.access$000(this.this$0));
            if (r115 != r105) goto L89;
            r117.mLeft.setGoneMargin(this.mPaddingLeft);
        L89:
            r108.mRight.connect(r117.mLeft, 0);
            if (r115 != (r106 + 1)) goto L92;
            r108.mRight.setGoneMargin(this.mPaddingRight);
        L92:
            if (r117 == r109) goto L111;
            if (Flow.access$700(this.this$0) == 3) goto L96;
        L101:
            int r120 = Flow.access$700(this.this$0);
            if (r120 != 0) goto L104;
            r117.mTop.connect(r109.mTop, 0);
            goto L111
        L104:
            if (r120 == 1) goto L108;
            if (r103 == false) goto L107;
            r117.mTop.connect(this.mTop, this.mPaddingTop);
            r117.mBottom.connect(this.mBottom, this.mPaddingBottom);
            goto L111
        L107:
            r117.mTop.connect(r109.mTop, 0);
            r117.mBottom.connect(r109.mBottom, 0);
            goto L111
        L108:
            r117.mBottom.connect(r109.mBottom, 0);
            goto L111
        L96:
            if (r114.hasBaseline() == false) goto L101;
            if (r117 == r114) goto L101;
            if (r117.hasBaseline() == false) goto L101;
            r117.mBaseline.connect(r114.mBaseline, 0);
        L111:
            r115 = r115 + 1;
            r108 = r117;
            goto L61
        L208:
            return;
        L64:
            r116 = r115;
            goto L66
        L207:
            return;
        L46:
            if (r109.hasBaseline() == true) goto L59;
            int r121 = 0;
        L48:
            if (r121 >= r100) goto L59;
            if (r110 == false) goto L51;
            int r122 = (r100 - 1) - r121;
        L53:
            if ((this.mStartIndex + r122) >= Flow.access$400(this.this$0)) goto L59;
            r114 = Flow.access$500(this.this$0)[this.mStartIndex + r122];
            if (r114.hasBaseline() == true) goto L60;
            r121 = r121 + 1;
            goto L48
        L51:
            r122 = r121;
            goto L53
        L112:
            ConstraintWidget r123 = this.biggest;
            r123.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int r124 = this.mPaddingLeft;
            if (r111 <= 0) goto L115;
            r124 = r124 + Flow.access$000(this.this$0);
        L115:
            if (r110 == false) goto L121;
            r123.mRight.connect(this.mRight, r124);
            if (r112 == false) goto L119;
            r123.mLeft.connect(this.mLeft, this.mPaddingRight);
        L119:
            if (r111 <= 0) goto L126;
            this.mRight.mOwner.mLeft.connect(r123.mRight, 0);
        L126:
            int r125 = 0;
        L127:
            if (r125 >= r100) goto L210;
            if ((this.mStartIndex + r125) >= Flow.access$400(this.this$0)) goto L209;
            ConstraintWidget r126 = Flow.access$500(this.this$0)[this.mStartIndex + r125];
            if (r125 != 0) goto L144;
            r126.connect(r126.mTop, this.mTop, this.mPaddingTop);
            int r127 = Flow.access$600(this.this$0);
            float r128 = Flow.access$1400(this.this$0);
            if (this.mStartIndex == 0) goto L136;
        L138:
            if (r112 == true) goto L140;
        L142:
            r126.setVerticalChainStyle(r127);
            r126.setVerticalBiasPercent(r128);
            goto L144
        L140:
            if (Flow.access$1700(this.this$0) == (-1)) goto L142;
            r127 = Flow.access$1700(this.this$0);
            r128 = Flow.access$1800(this.this$0);
            goto L142
        L136:
            if (Flow.access$1500(this.this$0) == (-1)) goto L138;
            r127 = Flow.access$1500(this.this$0);
            r128 = Flow.access$1600(this.this$0);
        L144:
            if (r125 != (r100 - 1)) goto L146;
            r126.connect(r126.mBottom, this.mBottom, this.mPaddingBottom);
        L146:
            if (r108 == null) goto L153;
            r126.mTop.connect(r108.mBottom, Flow.access$100(this.this$0));
            if (r125 != r105) goto L150;
            r126.mTop.setGoneMargin(this.mPaddingTop);
        L150:
            r108.mBottom.connect(r126.mTop, 0);
            if (r125 != (r106 + 1)) goto L153;
            r108.mBottom.setGoneMargin(this.mPaddingBottom);
        L153:
            if (r126 == r123) goto L177;
            if (r110 == false) goto L165;
            int r129 = Flow.access$1900(this.this$0);
            if (r129 != 0) goto L159;
            r126.mRight.connect(r123.mRight, 0);
            goto L177
        L159:
            if (r129 == 1) goto L163;
            if (r129 != 2) goto L177;
            r126.mLeft.connect(r123.mLeft, 0);
            r126.mRight.connect(r123.mRight, 0);
            goto L177
        L163:
            r126.mLeft.connect(r123.mLeft, 0);
            goto L177
        L165:
            int r130 = Flow.access$1900(this.this$0);
            if (r130 != 0) goto L168;
            r126.mLeft.connect(r123.mLeft, 0);
            goto L177
        L168:
            if (r130 == 1) goto L174;
            if (r130 != 2) goto L177;
            if (r103 == false) goto L173;
            r126.mLeft.connect(this.mLeft, this.mPaddingLeft);
            r126.mRight.connect(this.mRight, this.mPaddingRight);
            goto L177
        L173:
            r126.mLeft.connect(r123.mLeft, 0);
            r126.mRight.connect(r123.mRight, 0);
            goto L177
        L174:
            r126.mRight.connect(r123.mRight, 0);
        L177:
            r125 = r125 + 1;
            r108 = r126;
            goto L127
        L209:
            return;
        L210:
            return;
        L121:
            r123.mLeft.connect(this.mLeft, r124);
            if (r112 == false) goto L124;
            r123.mRight.connect(this.mRight, this.mPaddingRight);
        L124:
            if (r111 <= 0) goto L126;
            this.mLeft.mOwner.mRight.connect(r123.mLeft, 0);
        L18:
            r103 = false;
            goto L19
        }

        public WidgetsList(Flow r100, int r101, ConstraintAnchor r102, ConstraintAnchor r103, ConstraintAnchor r104, ConstraintAnchor r105, int r106) {
            this.this$0 = r100;
            this.biggest = null;
            this.biggestDimension = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
            this.mMax = 0;
            this.mOrientation = r101;
            this.mLeft = r102;
            this.mTop = r103;
            this.mRight = r104;
            this.mBottom = r105;
            this.mPaddingLeft = r100.getPaddingLeft();
            this.mPaddingTop = r100.getPaddingTop();
            this.mPaddingRight = r100.getPaddingRight();
            this.mPaddingBottom = r100.getPaddingBottom();
            this.mMax = r106;
        }

        public void setup(int r100, ConstraintAnchor r101, ConstraintAnchor r102, ConstraintAnchor r103, ConstraintAnchor r104, int r105, int r106, int r107, int r108, int r110) {
            this.mOrientation = r100;
            this.mLeft = r101;
            this.mTop = r102;
            this.mRight = r103;
            this.mBottom = r104;
            this.mPaddingLeft = r105;
            this.mPaddingTop = r106;
            this.mPaddingRight = r107;
            this.mPaddingBottom = r108;
            this.mMax = r110;
        }
    }

    public Flow() {
        this.mHorizontalStyle = -1;
        this.mVerticalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mFirstVerticalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mHorizontalGap = 0;
        this.mVerticalGap = 0;
        this.mHorizontalAlign = 2;
        this.mVerticalAlign = 2;
        this.mWrapMode = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mChainList = new ArrayList();
        this.mAlignedBiggestElementsInRows = null;
        this.mAlignedBiggestElementsInCols = null;
        this.mAlignedDimensions = null;
        this.mDisplayedWidgetsCount = 0;
    }

    public static /* synthetic */ int access$000(Flow r100) {
        return r100.mHorizontalGap;
    }

    public static /* synthetic */ int access$100(Flow r100) {
        return r100.mVerticalGap;
    }

    public static /* synthetic */ int access$1000(Flow r100) {
        return r100.mFirstHorizontalStyle;
    }

    public static /* synthetic */ float access$1100(Flow r100) {
        return r100.mFirstHorizontalBias;
    }

    public static /* synthetic */ int access$1200(Flow r100) {
        return r100.mLastHorizontalStyle;
    }

    public static /* synthetic */ float access$1300(Flow r100) {
        return r100.mLastHorizontalBias;
    }

    public static /* synthetic */ float access$1400(Flow r100) {
        return r100.mVerticalBias;
    }

    public static /* synthetic */ int access$1500(Flow r100) {
        return r100.mFirstVerticalStyle;
    }

    public static /* synthetic */ float access$1600(Flow r100) {
        return r100.mFirstVerticalBias;
    }

    public static /* synthetic */ int access$1700(Flow r100) {
        return r100.mLastVerticalStyle;
    }

    public static /* synthetic */ float access$1800(Flow r100) {
        return r100.mLastVerticalBias;
    }

    public static /* synthetic */ int access$1900(Flow r100) {
        return r100.mHorizontalAlign;
    }

    public static /* synthetic */ int access$400(Flow r100) {
        return r100.mDisplayedWidgetsCount;
    }

    public static /* synthetic */ ConstraintWidget[] access$500(Flow r100) {
        return r100.mDisplayedWidgets;
    }

    public static /* synthetic */ int access$600(Flow r100) {
        return r100.mVerticalStyle;
    }

    public static /* synthetic */ int access$700(Flow r100) {
        return r100.mVerticalAlign;
    }

    public static /* synthetic */ int access$800(Flow r100) {
        return r100.mHorizontalStyle;
    }

    public static /* synthetic */ float access$900(Flow r100) {
        return r100.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean r110) {
        if (this.mAlignedDimensions != null) goto L5;
        return;
    L5:
        if (this.mAlignedBiggestElementsInCols != null) goto L7;
        return;
    L7:
        if (this.mAlignedBiggestElementsInRows == null) goto L89;
        int r100 = 0;
    L11:
        if (r100 >= this.mDisplayedWidgetsCount) goto L13;
        this.mDisplayedWidgets[r100].resetAnchors();
        r100 = r100 + 1;
        goto L11
    L13:
        int[] r101 = this.mAlignedDimensions;
        int r102 = r101[0];
        int r103 = r101[1];
        ConstraintWidget r104 = null;
        int r105 = 0;
    L15:
        if (r105 >= r102) goto L33;
        if (r110 == false) goto L18;
        int r106 = (r102 - r105) - 1;
    L19:
        ConstraintWidget r107 = this.mAlignedBiggestElementsInCols[r106];
        if (r107 == null) goto L32;
        if (r107.getVisibility() == 8) goto L32;
        if (r105 != 0) goto L27;
        r107.connect(r107.mLeft, this.mLeft, getPaddingLeft());
        r107.setHorizontalChainStyle(this.mHorizontalStyle);
        r107.setHorizontalBiasPercent(this.mHorizontalBias);
    L27:
        if (r105 != (r102 - 1)) goto L29;
        r107.connect(r107.mRight, this.mRight, getPaddingRight());
    L29:
        if (r105 <= 0) goto L31;
        r107.connect(r107.mLeft, r104.mRight, this.mHorizontalGap);
        r104.connect(r104.mRight, r107.mLeft, 0);
    L31:
        r104 = r107;
    L32:
        r105 = r105 + 1;
        goto L15
    L18:
        r106 = r105;
        goto L19
    L33:
        int r111 = 0;
    L34:
        if (r111 >= r103) goto L49;
        ConstraintWidget r108 = this.mAlignedBiggestElementsInRows[r111];
        if (r108 == null) goto L48;
        if (r108.getVisibility() == 8) goto L48;
        if (r111 != 0) goto L43;
        r108.connect(r108.mTop, this.mTop, getPaddingTop());
        r108.setVerticalChainStyle(this.mVerticalStyle);
        r108.setVerticalBiasPercent(this.mVerticalBias);
    L43:
        if (r111 != (r103 - 1)) goto L45;
        r108.connect(r108.mBottom, this.mBottom, getPaddingBottom());
    L45:
        if (r111 <= 0) goto L47;
        r108.connect(r108.mTop, r104.mBottom, this.mVerticalGap);
        r104.connect(r104.mBottom, r108.mTop, 0);
    L47:
        r104 = r108;
    L48:
        r111 = r111 + 1;
        goto L34
    L49:
        int r112 = 0;
    L50:
        if (r112 >= r102) goto L90;
        int r109 = 0;
    L52:
        if (r109 >= r103) goto L70;
        int r113 = (r109 * r102) + r112;
        if (this.mOrientation != 1) goto L56;
        r113 = (r112 * r103) + r109;
    L56:
        ConstraintWidget[] r114 = this.mDisplayedWidgets;
        if (r113 >= r114.length) goto L69;
        ConstraintWidget r115 = r114[r113];
        if (r115 == null) goto L69;
        if (r115.getVisibility() == 8) goto L69;
        ConstraintWidget r116 = this.mAlignedBiggestElementsInCols[r112];
        ConstraintWidget r117 = this.mAlignedBiggestElementsInRows[r109];
        if (r115 == r116) goto L67;
        r115.connect(r115.mLeft, r116.mLeft, 0);
        r115.connect(r115.mRight, r116.mRight, 0);
    L67:
        if (r115 == r117) goto L69;
        r115.connect(r115.mTop, r117.mTop, 0);
        r115.connect(r115.mBottom, r117.mBottom, 0);
    L69:
        r109 = r109 + 1;
        goto L52
    L70:
        r112 = r112 + 1;
        goto L50
    L90:
        return;
    }

    public void setFirstHorizontalBias(float r100) {
        this.mFirstHorizontalBias = r100;
    }

    public void setFirstHorizontalStyle(int r100) {
        this.mFirstHorizontalStyle = r100;
    }

    public void setFirstVerticalBias(float r100) {
        this.mFirstVerticalBias = r100;
    }

    public void setFirstVerticalStyle(int r100) {
        this.mFirstVerticalStyle = r100;
    }

    public void setHorizontalAlign(int r100) {
        this.mHorizontalAlign = r100;
    }

    public void setHorizontalBias(float r100) {
        this.mHorizontalBias = r100;
    }

    public void setHorizontalGap(int r100) {
        this.mHorizontalGap = r100;
    }

    public void setHorizontalStyle(int r100) {
        this.mHorizontalStyle = r100;
    }

    public void setLastHorizontalBias(float r100) {
        this.mLastHorizontalBias = r100;
    }

    public void setLastHorizontalStyle(int r100) {
        this.mLastHorizontalStyle = r100;
    }

    public void setLastVerticalBias(float r100) {
        this.mLastVerticalBias = r100;
    }

    public void setLastVerticalStyle(int r100) {
        this.mLastVerticalStyle = r100;
    }

    public void setMaxElementsWrap(int r100) {
        this.mMaxElementsWrap = r100;
    }

    public void setOrientation(int r100) {
        this.mOrientation = r100;
    }

    public void setVerticalAlign(int r100) {
        this.mVerticalAlign = r100;
    }

    public void setVerticalBias(float r100) {
        this.mVerticalBias = r100;
    }

    public void setVerticalGap(int r100) {
        this.mVerticalGap = r100;
    }

    public void setVerticalStyle(int r100) {
        this.mVerticalStyle = r100;
    }

    public void setWrapMode(int r100) {
        this.mWrapMode = r100;
    }

    private final int getWidgetHeight(ConstraintWidget r110, int r111) {
        if (r110 != null) goto L6;
        return 0;
    L6:
        if (r110.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r100 = r110.mMatchConstraintDefaultHeight;
        if (r100 != 0) goto L11;
        return 0;
    L11:
        if (r100 != 2) goto L16;
        int r112 = (int) (r110.mMatchConstraintPercentHeight * r111);
        if (r112 == r110.getHeight()) goto L15;
        r110.setMeasureRequested(true);
        measure(r110, r110.getHorizontalDimensionBehaviour(), r110.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r112);
    L15:
        return r112;
    L16:
        if (r100 != 1) goto L20;
        return r110.getHeight();
    L20:
        if (r100 != 3) goto L24;
        return (int) ((r110.getWidth() * r110.mDimensionRatio) + 0.5f);
    L24:
        return r110.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget r110, int r111) {
        if (r110 != null) goto L6;
        return 0;
    L6:
        if (r110.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r100 = r110.mMatchConstraintDefaultWidth;
        if (r100 != 0) goto L11;
        return 0;
    L11:
        if (r100 != 2) goto L16;
        int r112 = (int) (r110.mMatchConstraintPercentWidth * r111);
        if (r112 == r110.getWidth()) goto L15;
        r110.setMeasureRequested(true);
        measure(r110, ConstraintWidget.DimensionBehaviour.FIXED, r112, r110.getVerticalDimensionBehaviour(), r110.getHeight());
    L15:
        return r112;
    L16:
        if (r100 != 1) goto L20;
        return r110.getWidth();
    L20:
        if (r100 != 3) goto L24;
        return (int) ((r110.getHeight() * r110.mDimensionRatio) + 0.5f);
    L24:
        return r110.getWidth();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r100, boolean r101) {
        super.addToSolver(r100, r101);
        if (getParent() == null) goto L5;
        boolean r102 = ((ConstraintWidgetContainer) getParent()).isRtl();
    L6:
        int r103 = this.mWrapMode;
        if (r103 == 0) goto L21;
        if (r103 != 1) goto L10;
        int r104 = this.mChainList.size();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L23;
        WidgetsList r106 = (WidgetsList) ListProtector.get(this.mChainList, r105);
        if (r105 != (r104 - 1)) goto L18;
        boolean r107 = true;
    L19:
        r106.createConstraints(r102, r105, r107);
        r105 = r105 + 1;
        goto L14
    L18:
        r107 = false;
    L23:
        needsCallbackFromSolver(false);
        return;
    L10:
        if (r103 != 2) goto L23;
        createAlignedConstraints(r102);
        goto L23
    L21:
        if (this.mChainList.size() <= 0) goto L23;
        ((WidgetsList) ListProtector.get(this.mChainList, 0)).createConstraints(r102, 0, true);
        goto L23
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.copy(r100, r101);
        Flow r102 = (Flow) r100;
        this.mHorizontalStyle = r102.mHorizontalStyle;
        this.mVerticalStyle = r102.mVerticalStyle;
        this.mFirstHorizontalStyle = r102.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = r102.mFirstVerticalStyle;
        this.mLastHorizontalStyle = r102.mLastHorizontalStyle;
        this.mLastVerticalStyle = r102.mLastVerticalStyle;
        this.mHorizontalBias = r102.mHorizontalBias;
        this.mVerticalBias = r102.mVerticalBias;
        this.mFirstHorizontalBias = r102.mFirstHorizontalBias;
        this.mFirstVerticalBias = r102.mFirstVerticalBias;
        this.mLastHorizontalBias = r102.mLastHorizontalBias;
        this.mLastVerticalBias = r102.mLastVerticalBias;
        this.mHorizontalGap = r102.mHorizontalGap;
        this.mVerticalGap = r102.mVerticalGap;
        this.mHorizontalAlign = r102.mHorizontalAlign;
        this.mVerticalAlign = r102.mVerticalAlign;
        this.mWrapMode = r102.mWrapMode;
        this.mMaxElementsWrap = r102.mMaxElementsWrap;
        this.mOrientation = r102.mOrientation;
    }

    public static /* synthetic */ int access$200(Flow r100, ConstraintWidget r101, int r102) {
        return r100.getWidgetWidth(r101, r102);
    }

    public static /* synthetic */ int access$300(Flow r100, ConstraintWidget r101, int r102) {
        return r100.getWidgetHeight(r101, r102);
    }

    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    public void measure(int r110, int r210, int r211, int r212) {
        if (this.mWidgetsCount > 0) goto L5;
    L8:
        int r111 = getPaddingLeft();
        int r112 = getPaddingRight();
        int r113 = getPaddingTop();
        int r114 = getPaddingBottom();
        int[] r100 = new int[2];
        int r101 = (r210 - r111) - r112;
        int r102 = this.mOrientation;
        if (r102 != 1) goto L11;
        r101 = (r212 - r113) - r114;
    L11:
        int r115 = r101;
        if (r102 != 0) goto L20;
        if (this.mHorizontalStyle != (-1)) goto L17;
        this.mHorizontalStyle = 0;
    L17:
        if (this.mVerticalStyle != (-1)) goto L25;
        this.mVerticalStyle = 0;
    L25:
        ConstraintWidget[] r103 = this.mWidgets;
        int r104 = 0;
        int r105 = 0;
    L26:
        int r116 = this.mWidgetsCount;
        if (r104 >= r116) goto L32;
        if (this.mWidgets[r104].getVisibility() != 8) goto L31;
        r105 = r105 + 1;
    L31:
        r104 = r104 + 1;
        goto L26
    L32:
        if (r105 <= 0) goto L41;
        r103 = new ConstraintWidget[r116 - r105];
        int r106 = 0;
        int r107 = 0;
    L35:
        if (r106 >= this.mWidgetsCount) goto L40;
        ConstraintWidget r117 = this.mWidgets[r106];
        if (r117.getVisibility() == 8) goto L39;
        r103[r107] = r117;
        r107 = r107 + 1;
    L39:
        r106 = r106 + 1;
        goto L35
    L40:
        int r108 = r107;
    L42:
        this.mDisplayedWidgets = r103;
        this.mDisplayedWidgetsCount = r108;
        int r109 = this.mWrapMode;
        if (r109 != 0) goto L45;
        boolean r118 = true;
        measureNoWrap(r103, r108, this.mOrientation, r115, r100);
    L52:
        char r119 = 0;
    L53:
        int r120 = (r100[r119] + r111) + r112;
        int r121 = (r100[r118 ? 1 : 0] + r113) + r114;
        if (r110 != 1073741824) goto L56;
        r120 = r210;
    L61:
        if (r211 != 1073741824) goto L63;
        r121 = r212;
    L68:
        setMeasure(r120, r121);
        setWidth(r120);
        setHeight(r121);
        if (this.mWidgetsCount > 0) goto L72;
        r118 = false;
    L72:
        needsCallbackFromSolver(r118);
        return;
    L63:
        if (r211 != Integer.MIN_VALUE) goto L65;
        r121 = Math.min(r121, r212);
        goto L68
    L65:
        if (r211 == 0) goto L68;
        r121 = 0;
        goto L68
    L56:
        if (r110 != Integer.MIN_VALUE) goto L58;
        r120 = Math.min(r120, r210);
        goto L61
    L58:
        if (r110 == 0) goto L61;
        r120 = 0;
        goto L61
    L45:
        if (r109 != 1) goto L47;
        r118 = true;
        measureChainWrap(r103, r108, this.mOrientation, r115, r100);
        goto L52
    L47:
        if (r109 == 2) goto L49;
        r100 = r100;
        r119 = 0;
        r118 = true;
        goto L53
    L49:
        r118 = true;
        measureAligned(r103, r108, this.mOrientation, r115, r100);
        goto L52
    L41:
        r108 = r116;
        goto L42
    L20:
        if (this.mHorizontalStyle != (-1)) goto L23;
        this.mHorizontalStyle = 0;
    L23:
        if (this.mVerticalStyle != (-1)) goto L25;
        this.mVerticalStyle = 0;
        goto L25
    L5:
        if (measureChildren() == true) goto L8;
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    private void measureAligned(ConstraintWidget[] r110, int r111, int r112, int r113, int[] r114) {
        if (r112 != 0) goto L19;
        int r100 = this.mMaxElementsWrap;
        if (r100 > 0) goto L18;
        r100 = 0;
        int r101 = 0;
        int r102 = 0;
    L7:
        if (r101 >= r111) goto L18;
        if (r101 <= 0) goto L10;
        r102 = r102 + this.mHorizontalGap;
    L10:
        ConstraintWidget r103 = r110[r101];
        if (r103 == null) goto L17;
        r102 = r102 + getWidgetWidth(r103, r113);
        if (r102 > r113) goto L18;
        r100 = r100 + 1;
    L17:
        r101 = r101 + 1;
    L18:
        int r104 = r100;
        int r105 = 0;
    L35:
        if (this.mAlignedDimensions != null) goto L38;
        this.mAlignedDimensions = new int[2];
    L38:
        if (r105 != 0) goto L40;
        if (r112 != 1) goto L40;
    L42:
        boolean r106 = true;
    L44:
        if (r106 == true) goto L111;
        if (r112 != 0) goto L47;
        r105 = (int) Math.ceil(r111 / r104);
    L48:
        ConstraintWidget[] r107 = this.mAlignedBiggestElementsInCols;
        if (r107 != null) goto L51;
    L54:
        this.mAlignedBiggestElementsInCols = new ConstraintWidget[r104];
    L55:
        ConstraintWidget[] r108 = this.mAlignedBiggestElementsInRows;
        if (r108 != null) goto L58;
    L61:
        this.mAlignedBiggestElementsInRows = new ConstraintWidget[r105];
    L62:
        int r109 = 0;
    L63:
        if (r109 >= r104) goto L87;
        int r115 = 0;
    L65:
        if (r115 >= r105) goto L86;
        int r116 = (r115 * r104) + r109;
        if (r112 != 1) goto L70;
        r116 = (r109 * r105) + r115;
    L70:
        if (r116 >= r110.length) goto L85;
        ConstraintWidget r117 = r110[r116];
        if (r117 == null) goto L85;
        int r118 = getWidgetWidth(r117, r113);
        ConstraintWidget r119 = this.mAlignedBiggestElementsInCols[r109];
        if (r119 != null) goto L78;
    L79:
        this.mAlignedBiggestElementsInCols[r109] = r117;
    L80:
        int r120 = getWidgetHeight(r117, r113);
        ConstraintWidget r121 = this.mAlignedBiggestElementsInRows[r115];
        if (r121 != null) goto L83;
    L84:
        this.mAlignedBiggestElementsInRows[r115] = r117;
        goto L85
    L83:
        if (r121.getHeight() >= r120) goto L85;
    L78:
        if (r119.getWidth() >= r118) goto L80;
    L85:
        r115 = r115 + 1;
        goto L65
    L86:
        r109 = r109 + 1;
        goto L63
    L87:
        int r122 = 0;
        int r123 = 0;
    L88:
        if (r122 >= r104) goto L95;
        ConstraintWidget r124 = this.mAlignedBiggestElementsInCols[r122];
        if (r124 == null) goto L94;
        if (r122 <= 0) goto L93;
        r123 = r123 + this.mHorizontalGap;
    L93:
        r123 = r123 + getWidgetWidth(r124, r113);
    L94:
        r122 = r122 + 1;
        goto L88
    L95:
        int r125 = 0;
        int r126 = 0;
    L96:
        if (r125 >= r105) goto L103;
        ConstraintWidget r127 = this.mAlignedBiggestElementsInRows[r125];
        if (r127 == null) goto L102;
        if (r125 <= 0) goto L101;
        r126 = r126 + this.mVerticalGap;
    L101:
        r126 = r126 + getWidgetHeight(r127, r113);
    L102:
        r125 = r125 + 1;
        goto L96
    L103:
        r114[0] = r123;
        r114[1] = r126;
        if (r112 == 0) goto L105;
        if (r126 <= r113) goto L42;
        if (r105 <= 1) goto L42;
        r105 = r105 - 1;
        goto L44
    L105:
        if (r123 <= r113) goto L42;
        if (r104 <= 1) goto L42;
        r104 = r104 - 1;
        goto L44
    L58:
        if (r108.length < r105) goto L61;
        Arrays.fill(r108, null);
        goto L62
    L51:
        if (r107.length < r104) goto L54;
        Arrays.fill(r107, null);
        goto L55
    L47:
        r104 = (int) Math.ceil(r111 / r105);
        goto L48
    L111:
        int[] r128 = this.mAlignedDimensions;
        r128[0] = r104;
        r128[1] = r105;
        return;
    L40:
        if (r104 != 0) goto L43;
        if (r112 == 0) goto L42;
    L43:
        r106 = false;
        goto L44
    L19:
        r105 = this.mMaxElementsWrap;
        if (r105 > 0) goto L33;
        r105 = 0;
        int r129 = 0;
        int r130 = 0;
    L22:
        if (r129 >= r111) goto L33;
        if (r129 <= 0) goto L25;
        r130 = r130 + this.mVerticalGap;
    L25:
        ConstraintWidget r131 = r110[r129];
        if (r131 == null) goto L32;
        r130 = r130 + getWidgetHeight(r131, r113);
        if (r130 > r113) goto L33;
        r105 = r105 + 1;
    L32:
        r129 = r129 + 1;
    L33:
        r104 = 0;
        goto L35
    }

    private void measureChainWrap(ConstraintWidget[] r210, int r310, int r311, int r312, int[] r313) {
        if (r310 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r110 = new WidgetsList(this, r311, this.mLeft, this.mTop, this.mRight, this.mBottom, r312);
        this.mChainList.add(r110);
        if (r311 != 0) goto L33;
        int r100 = 0;
        int r101 = 0;
        int r111 = 0;
    L8:
        if (r111 >= r310) goto L59;
        ConstraintWidget r112 = r210[r111];
        int r113 = getWidgetWidth(r112, r312);
        if (r112.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r100 = r100 + 1;
    L12:
        int r114 = r100;
        if (r101 == r312) goto L17;
        if (((this.mHorizontalGap + r101) + r113) > r312) goto L17;
    L19:
        boolean r102 = false;
    L20:
        if (r102 == true) goto L27;
        if (r111 <= 0) goto L27;
        int r103 = this.mMaxElementsWrap;
        if (r103 <= 0) goto L27;
        if ((r111 % r103) != 0) goto L27;
        r102 = true;
    L27:
        if (r102 == false) goto L30;
        r110 = new WidgetsList(this, r311, this.mLeft, this.mTop, this.mRight, this.mBottom, r312);
        r110.setStartIndex(r111);
        this.mChainList.add(r110);
    L29:
        r101 = r113;
    L32:
        r110.add(r112);
        r111 = r111 + 1;
        r100 = r114;
        goto L8
    L30:
        if (r111 <= 0) goto L29;
        r101 = r101 + (this.mHorizontalGap + r113);
    L17:
        if (WidgetsList.access$2000(r110) == null) goto L19;
        r102 = true;
    L59:
        int r104 = this.mChainList.size();
        ConstraintAnchor r105 = this.mLeft;
        ConstraintAnchor r106 = this.mTop;
        ConstraintAnchor r107 = this.mRight;
        ConstraintAnchor r108 = this.mBottom;
        int r109 = getPaddingLeft();
        int r115 = getPaddingTop();
        int r116 = getPaddingRight();
        int r117 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour r118 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r119 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r118 != r119) goto L62;
    L65:
        boolean r120 = true;
    L66:
        if (r100 <= 0) goto L75;
        if (r120 == false) goto L75;
        int r121 = 0;
    L69:
        if (r121 >= r104) goto L75;
        WidgetsList r122 = (WidgetsList) ListProtector.get(this.mChainList, r121);
        if (r311 != 0) goto L73;
        r122.measureMatchConstraints(r312 - r122.getWidth());
    L74:
        r121 = r121 + 1;
        goto L69
    L73:
        r122.measureMatchConstraints(r312 - r122.getHeight());
    L75:
        int r211 = r115;
        int r123 = r116;
        int r124 = 0;
        int r125 = 0;
        int r126 = 0;
        int r127 = r109;
        ConstraintAnchor r128 = r106;
        ConstraintAnchor r129 = r105;
        int r130 = r117;
    L76:
        if (r126 >= r104) goto L96;
        WidgetsList r212 = (WidgetsList) ListProtector.get(this.mChainList, r126);
        if (r311 == 0) goto L80;
        ConstraintAnchor r213 = r129;
        int r131 = r124;
        int r132 = r125;
        int r133 = r126;
        if (r133 >= (r104 - 1)) goto L90;
        ConstraintAnchor r214 = WidgetsList.access$2000((WidgetsList) ListProtector.get(this.mChainList, r133 + 1)).mLeft;
        int r215 = 0;
    L91:
        ConstraintAnchor r134 = WidgetsList.access$2000(r212).mRight;
        r212.setup(r311, r213, r128, r214, r108, r127, r211, r215, r130, r312);
        r125 = r132 + r212.getWidth();
        int r135 = Math.max(r131, r212.getHeight());
        if (r133 <= 0) goto L94;
        r125 = r125 + this.mHorizontalGap;
    L94:
        r124 = r135;
        r123 = r215;
        r129 = r134;
        r127 = 0;
    L95:
        r126 = r133 + 1;
        r107 = r214;
        goto L76
    L90:
        r214 = this.mRight;
        r215 = getPaddingRight();
        goto L91
    L80:
        if (r126 >= (r104 - 1)) goto L82;
        ConstraintAnchor r136 = WidgetsList.access$2000((WidgetsList) ListProtector.get(this.mChainList, r126 + 1)).mTop;
        int r137 = 0;
    L83:
        ConstraintAnchor r138 = WidgetsList.access$2000(r212).mBottom;
        ConstraintAnchor r139 = r129;
        ConstraintAnchor r216 = r129;
        int r140 = r124;
        ConstraintAnchor r141 = r128;
        int r142 = r125;
        ConstraintAnchor r143 = r107;
        ConstraintAnchor r314 = r107;
        r133 = r126;
        r212.setup(r311, r139, r141, r143, r136, r127, r211, r123, r137, r312);
        int r144 = Math.max(r142, r212.getWidth());
        r124 = r140 + r212.getHeight();
        if (r133 <= 0) goto L86;
        r124 = r124 + this.mVerticalGap;
    L86:
        r129 = r216;
        r125 = r144;
        r128 = r138;
        r211 = 0;
        r214 = r314;
        int r217 = r137;
        r108 = r136;
        r130 = r217;
        goto L95
    L82:
        r136 = this.mBottom;
        r137 = getPaddingBottom();
        goto L83
    L96:
        r313[0] = r125;
        r313[1] = r124;
        return;
    L62:
        if (getVerticalDimensionBehaviour() == r119) goto L65;
        r120 = false;
        goto L66
    L33:
        r100 = 0;
        int r145 = 0;
        int r146 = 0;
    L34:
        if (r146 >= r310) goto L59;
        ConstraintWidget r147 = r210[r146];
        int r148 = getWidgetHeight(r147, r312);
        if (r147.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r100 = r100 + 1;
    L38:
        int r149 = r100;
        if (r145 == r312) goto L43;
        if (((this.mVerticalGap + r145) + r148) > r312) goto L43;
    L45:
        boolean r150 = false;
    L46:
        if (r150 == true) goto L53;
        if (r146 <= 0) goto L53;
        int r151 = this.mMaxElementsWrap;
        if (r151 <= 0) goto L53;
        if ((r146 % r151) != 0) goto L53;
        r150 = true;
    L53:
        if (r150 == false) goto L56;
        r110 = new WidgetsList(this, r311, this.mLeft, this.mTop, this.mRight, this.mBottom, r312);
        r110.setStartIndex(r146);
        this.mChainList.add(r110);
    L55:
        r145 = r148;
    L58:
        r110.add(r147);
        r146 = r146 + 1;
        r100 = r149;
        goto L34
    L56:
        if (r146 <= 0) goto L55;
        r145 = r145 + (this.mVerticalGap + r148);
    L43:
        if (WidgetsList.access$2000(r110) == null) goto L45;
        r150 = true;
        goto L46
    }

    private void measureNoWrap(ConstraintWidget[] r210, int r211, int r212, int r213, int[] r214) {
        if (r211 != 0) goto L6;
        return;
    L6:
        if (this.mChainList.size() != 0) goto L8;
        WidgetsList r110 = new WidgetsList(this, r212, this.mLeft, this.mTop, this.mRight, this.mBottom, r213);
        this.mChainList.add(r110);
    L9:
        int r100 = 0;
    L10:
        if (r100 >= r211) goto L12;
        r110.add(r210[r100]);
        r100 = r100 + 1;
        goto L10
    L12:
        r214[0] = r110.getWidth();
        r214[1] = r110.getHeight();
        return;
    L8:
        WidgetsList r101 = (WidgetsList) ListProtector.get(this.mChainList, 0);
        r101.clear();
        r110 = r101;
        r110.setup(r212, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), r213);
        goto L9
    }
}
