package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        public LayoutParams(int r100, int r101, float r102) {
            super(r100, r101, r102);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public int getChildrenSkipCount(View r100, int r101) {
        return 0;
    }

    public int getLocationOffset(View r100) {
        return 0;
    }

    public int getNextLocationOffset(View r100) {
        return 0;
    }

    public int measureNullChild(int r100) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r100 = this.mOrientation;
        if (r100 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r100 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r100 = getChildCount();
        int r101 = this.mBaselineAlignedChildIndex;
        if (r100 <= r101) goto L29;
        View r102 = getChildAt(r101);
        int r103 = r102.getBaseline();
        if (r103 == (-1)) goto L11;
        int r104 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r105 = this.mGravity & 112;
        if (r105 == 48) goto L27;
        if (r105 != 16) goto L22;
        r104 = r104 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r105 != 80) goto L27;
        r104 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r104 + ((LinearLayout.LayoutParams) ((LayoutParams) r102.getLayoutParams())).topMargin) + r103;
    L11:
        if (this.mBaselineAlignedChildIndex != 0) goto L14;
        return -1;
    L14:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    L29:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    L5:
        return super.getBaseline();
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public LinearLayoutCompat(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas r100) {
        int r101 = getVirtualChildCount();
        boolean r102 = ViewUtils.isLayoutRtl(this);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L17;
        View r104 = getVirtualChildAt(r103);
        if (r104 == null) goto L15;
        if (r104.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r103) == false) goto L15;
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        if (r102 == false) goto L13;
        int r106 = r104.getRight() + ((LinearLayout.LayoutParams) r105).rightMargin;
    L14:
        drawVerticalDivider(r100, r106);
        goto L15
    L13:
        r106 = (r104.getLeft() - ((LinearLayout.LayoutParams) r105).leftMargin) - this.mDividerWidth;
    L15:
        r103 = r103 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r101) == false) goto L35;
        View r107 = getVirtualChildAt(r101 - 1);
        if (r107 != null) goto L23;
        if (r102 == false) goto L22;
        int r108 = getPaddingLeft();
    L28:
        drawVerticalDivider(r100, r108);
        return;
    L22:
        int r109 = getWidth() - getPaddingRight();
        int r110 = this.mDividerWidth;
    L26:
        r108 = r109 - r110;
        goto L28
    L23:
        LayoutParams r111 = (LayoutParams) r107.getLayoutParams();
        if (r102 == false) goto L27;
        r109 = r107.getLeft() - ((LinearLayout.LayoutParams) r111).leftMargin;
        r110 = this.mDividerWidth;
        goto L26
    L27:
        r108 = r107.getRight() + ((LinearLayout.LayoutParams) r111).rightMargin;
        goto L28
    }

    public void drawDividersVertical(Canvas r100) {
        int r101 = getVirtualChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        View r103 = getVirtualChildAt(r102);
        if (r103 == null) goto L11;
        if (r103.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r102) == false) goto L11;
        drawHorizontalDivider(r100, (r103.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) r103.getLayoutParams())).topMargin) - this.mDividerHeight);
    L11:
        r102 = r102 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r101) == false) goto L25;
        View r104 = getVirtualChildAt(r101 - 1);
        if (r104 != null) goto L17;
        int r105 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r100, r105);
        return;
    L17:
        r105 = r104.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) r104.getLayoutParams())).bottomMargin;
        goto L18
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public View getVirtualChildAt(int r100) {
        return getChildAt(r100);
    }

    public boolean hasDividerBeforeChildAt(int r100) {
        if (r100 != 0) goto L9;
        if ((this.mShowDividers & 1) == 0) goto L25;
        return true;
    L25:
        return false;
    L9:
        if (r100 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) == 0) goto L26;
        return true;
    L26:
        return false;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r101 = r100 - 1;
    L17:
        if (r101 < 0) goto L28;
        if (getChildAt(r101).getVisibility() != 8) goto L20;
        r101 = r101 - 1;
        goto L17
    L20:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r100);
        return;
    L8:
        drawDividersHorizontal(r100);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        r100.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        r100.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void setBaselineAligned(boolean r100) {
        this.mBaselineAligned = r100;
    }

    public void setBaselineAlignedChildIndex(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r100;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r100) {
        if (r100 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r100;
        boolean r101 = false;
        if (r100 == null) goto L8;
        this.mDividerWidth = r100.getIntrinsicWidth();
        this.mDividerHeight = r100.getIntrinsicHeight();
    L9:
        if (r100 != null) goto L11;
        r101 = true;
    L11:
        setWillNotDraw(r101);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r100) {
        this.mDividerPadding = r100;
    }

    public void setGravity(int r100) {
        if (this.mGravity != r100) goto L5;
        return;
    L5:
        if ((8388615 & r100) != 0) goto L8;
        r100 = r100 | GravityCompat.START;
    L8:
        if ((r100 & 112) != 0) goto L10;
        r100 = r100 | 48;
    L10:
        this.mGravity = r100;
        requestLayout();
    }

    public void setHorizontalGravity(int r100) {
        int r101 = r100 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r102 = this.mGravity;
        if ((8388615 & r102) == r101) goto L6;
        this.mGravity = r101 | ((-8388616) & r102);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r100) {
        this.mUseLargestChild = r100;
    }

    public void setOrientation(int r100) {
        if (this.mOrientation == r100) goto L6;
        this.mOrientation = r100;
        requestLayout();
        return;
    }

    public void setShowDividers(int r100) {
        if (r100 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r100;
    }

    public void setVerticalGravity(int r100) {
        int r101 = r100 & 112;
        int r102 = this.mGravity;
        if ((r102 & 112) == r101) goto L6;
        this.mGravity = r101 | (r102 & (-113));
        requestLayout();
        return;
    }

    public void setWeightSum(float r100) {
        this.mWeightSum = Math.max(0.0f, r100);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public LinearLayoutCompat(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void forceUniformHeight(int r110, int r111) {
        int r100 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L10;
        View r102 = getVirtualChildAt(r101);
        if (r102.getVisibility() == 8) goto L9;
        LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
        if (((LinearLayout.LayoutParams) r103).height != (-1)) goto L9;
        int r104 = ((LinearLayout.LayoutParams) r103).width;
        ((LinearLayout.LayoutParams) r103).width = r102.getMeasuredWidth();
        measureChildWithMargins(r102, r111, 0, r100, 0);
        ((LinearLayout.LayoutParams) r103).width = r104;
    L9:
        r101 = r101 + 1;
        goto L3
    }

    private void forceUniformWidth(int r110, int r111) {
        int r100 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L10;
        View r102 = getVirtualChildAt(r101);
        if (r102.getVisibility() == 8) goto L9;
        LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
        if (((LinearLayout.LayoutParams) r103).width != (-1)) goto L9;
        int r104 = ((LinearLayout.LayoutParams) r103).height;
        ((LinearLayout.LayoutParams) r103).height = r102.getMeasuredHeight();
        measureChildWithMargins(r102, r100, 0, r111, 0);
        ((LinearLayout.LayoutParams) r103).height = r104;
    L9:
        r101 = r101 + 1;
        goto L3
    }

    public void drawHorizontalDivider(Canvas r100, int r101) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r101, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r101);
        this.mDivider.draw(r100);
    }

    public void drawVerticalDivider(Canvas r100, int r101) {
        this.mDivider.setBounds(r101, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r101, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r100);
    }

    void measureHorizontal(int r310, int r311) {
        this.mTotalLength = 0;
        int r110 = getVirtualChildCount();
        int r111 = View.MeasureSpec.getMode(r310);
        int r112 = View.MeasureSpec.getMode(r311);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r113 = this.mMaxAscent;
        int[] r100 = this.mMaxDescent;
        r113[3] = -1;
        r113[2] = -1;
        r113[1] = -1;
        r113[0] = -1;
        r100[3] = -1;
        r100[2] = -1;
        r100[1] = -1;
        r100[0] = -1;
        boolean r101 = this.mBaselineAligned;
        boolean r102 = this.mUseLargestChild;
        int r103 = 1073741824;
        if (r111 != 1073741824) goto L10;
        boolean r114 = true;
    L11:
        float r104 = 0.0f;
        int r105 = 0;
        int r115 = 0;
        int r210 = 0;
        int r211 = 0;
        int r212 = 0;
        boolean r213 = false;
        int r214 = 0;
        boolean r215 = true;
        boolean r216 = false;
    L12:
        int[] r217 = r100;
        if (r105 >= r110) goto L88;
        View r106 = getVirtualChildAt(r105);
        if (r106 != null) goto L19;
        this.mTotalLength += measureNullChild(r105);
    L17:
        int r107 = r105;
        boolean r312 = r102;
        boolean r313 = r101;
    L87:
        r105 = r107 + 1;
        r100 = r217;
        r102 = r312;
        r101 = r313;
        r103 = 1073741824;
        goto L12
    L19:
        if (r106.getVisibility() != 8) goto L22;
        r105 = r105 + getChildrenSkipCount(r106, r105);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r105) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r116 = (LayoutParams) r106.getLayoutParams();
        float r108 = ((LinearLayout.LayoutParams) r116).weight;
        float r314 = r104 + r108;
        if (r111 != r103) goto L37;
        if (((LinearLayout.LayoutParams) r116).width != 0) goto L37;
        if (r108 <= 0.0f) goto L37;
        if (r114 == false) goto L32;
        this.mTotalLength += ((LinearLayout.LayoutParams) r116).leftMargin + ((LinearLayout.LayoutParams) r116).rightMargin;
    L33:
        if (r101 == false) goto L35;
        int r109 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r106.measure(r109, r109);
        int r315 = r105;
        r312 = r102;
        r313 = r101;
        View r117 = r106;
    L55:
        int r118 = 1073741824;
    L56:
        if (r112 != r118) goto L58;
    L60:
        boolean r119 = false;
    L61:
        int r120 = ((LinearLayout.LayoutParams) r116).topMargin + ((LinearLayout.LayoutParams) r116).bottomMargin;
        int r121 = r117.getMeasuredHeight() + r120;
        r214 = View.combineMeasuredStates(r214, r117.getMeasuredState());
        if (r313 == false) goto L69;
        int r122 = r117.getBaseline();
        if (r122 == (-1)) goto L69;
        int r123 = ((LinearLayout.LayoutParams) r116).gravity;
        if (r123 >= 0) goto L68;
        r123 = this.mGravity;
    L68:
        int r124 = (((r123 & 112) >> 4) & (-2)) >> 1;
        r113[r124] = Math.max(r113[r124], r122);
        r217[r124] = Math.max(r217[r124], r121 - r122);
    L69:
        r210 = Math.max(r210, r121);
        if (r215 == true) goto L72;
    L74:
        r215 = false;
    L76:
        if (((LinearLayout.LayoutParams) r116).weight <= 0.0f) goto L81;
        if (r119 == true) goto L80;
        r120 = r121;
    L80:
        r212 = Math.max(r212, r120);
    L86:
        int r125 = r315;
        r107 = getChildrenSkipCount(r117, r125) + r125;
        r104 = r314;
        goto L87
    L81:
        int r126 = r212;
        if (r119 == true) goto L85;
        r120 = r121;
    L85:
        r211 = Math.max(r211, r120);
        r212 = r126;
        goto L86
    L72:
        if (((LinearLayout.LayoutParams) r116).height != (-1)) goto L74;
        r215 = true;
        goto L76
    L58:
        if (((LinearLayout.LayoutParams) r116).height != (-1)) goto L60;
        r119 = true;
        r216 = true;
        goto L61
    L35:
        r315 = r105;
        r312 = r102;
        r313 = r101;
        r117 = r106;
        r118 = 1073741824;
        r213 = true;
        goto L56
    L32:
        int r127 = this.mTotalLength;
        this.mTotalLength = Math.max(r127, (((LinearLayout.LayoutParams) r116).leftMargin + r127) + ((LinearLayout.LayoutParams) r116).rightMargin);
    L37:
        if (((LinearLayout.LayoutParams) r116).width == 0) goto L39;
    L41:
        int r128 = Integer.MIN_VALUE;
    L43:
        if (r314 != 0.0f) goto L45;
        int r218 = this.mTotalLength;
    L46:
        r315 = r105;
        int r316 = r128;
        r312 = r102;
        r313 = r101;
        measureChildBeforeLayout(r106, r315, r310, r218, r311, 0);
        if (r316 == Integer.MIN_VALUE) goto L49;
        ((LinearLayout.LayoutParams) r116).width = r316;
    L49:
        int r129 = r106.getMeasuredWidth();
        if (r114 == false) goto L52;
        r117 = r106;
        this.mTotalLength = this.mTotalLength + (((((LinearLayout.LayoutParams) r116).leftMargin + r129) + ((LinearLayout.LayoutParams) r116).rightMargin) + getNextLocationOffset(r117));
    L53:
        if (r312 == false) goto L55;
        r115 = Math.max(r129, r115);
        goto L55
    L52:
        r117 = r106;
        int r130 = this.mTotalLength;
        this.mTotalLength = Math.max(r130, (((r130 + r129) + ((LinearLayout.LayoutParams) r116).leftMargin) + ((LinearLayout.LayoutParams) r116).rightMargin) + getNextLocationOffset(r117));
        goto L53
    L45:
        r218 = 0;
        goto L46
    L39:
        if (r108 <= 0.0f) goto L41;
        ((LinearLayout.LayoutParams) r116).width = -2;
        r128 = 0;
        goto L43
    L88:
        boolean r317 = r102;
        boolean r318 = r101;
        int r131 = r210;
        int r132 = r211;
        int r133 = r212;
        int r134 = r214;
        if (this.mTotalLength > 0) goto L91;
    L93:
        int r135 = r113[1];
        if (r135 == (-1)) goto L96;
    L103:
        int r136 = Math.max(r131, Math.max(r113[3], Math.max(r113[0], Math.max(r135, r113[2]))) + Math.max(r217[3], Math.max(r217[0], Math.max(r217[1], r217[2]))));
    L104:
        if (r317 == true) goto L106;
    L122:
        int r219 = r136;
        int r137 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r137;
        int r138 = View.resolveSizeAndState(Math.max(r137, getSuggestedMinimumWidth()), r310, 0);
        int r139 = (16777215 & r138) - this.mTotalLength;
        if (r213 == true) goto L144;
        if (r139 != 0) goto L126;
    L128:
        int r140 = Math.max(r132, r133);
        if (r317 == true) goto L131;
    L143:
        int r220 = r110;
        int r141 = r219;
    L214:
        if (r215 == false) goto L216;
    L218:
        r140 = r141;
    L219:
        setMeasuredDimension(r138 | (r134 & (-16777216)), View.resolveSizeAndState(Math.max(r140 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r311, r134 << 16));
        if (r216 == false) goto L237;
        forceUniformHeight(r220, r310);
        return;
    L237:
        return;
    L216:
        if (r112 == 1073741824) goto L218;
    L131:
        if (r111 == 1073741824) goto L143;
        int r142 = 0;
    L133:
        if (r142 >= r110) goto L143;
        View r143 = getVirtualChildAt(r142);
        if (r143 == null) goto L142;
        if (r143.getVisibility() == 8) goto L142;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r143.getLayoutParams())).weight <= 0.0f) goto L142;
        r143.measure(View.MeasureSpec.makeMeasureSpec(r115, 1073741824), View.MeasureSpec.makeMeasureSpec(r143.getMeasuredHeight(), 1073741824));
    L142:
        r142 = r142 + 1;
        goto L133
    L126:
        if (r104 <= 0.0f) goto L128;
    L144:
        float r144 = this.mWeightSum;
        if (r144 <= 0.0f) goto L147;
        r104 = r144;
    L147:
        r113[3] = -1;
        r113[2] = -1;
        r113[1] = -1;
        r113[0] = -1;
        r217[3] = -1;
        r217[2] = -1;
        r217[1] = -1;
        r217[0] = -1;
        this.mTotalLength = 0;
        int r145 = r132;
        int r146 = r134;
        int r147 = -1;
        int r148 = 0;
    L148:
        if (r148 >= r110) goto L202;
        View r149 = getVirtualChildAt(r148);
        if (r149 != null) goto L152;
    L200:
        int r150 = r139;
        r110 = r110;
    L201:
        r148 = r148 + 1;
        r139 = r150;
        r110 = r110;
        goto L148
    L152:
        if (r149.getVisibility() == 8) goto L200;
        LayoutParams r151 = (LayoutParams) r149.getLayoutParams();
        float r152 = ((LinearLayout.LayoutParams) r151).weight;
        if (r152 <= 0.0f) goto L171;
        int r153 = (int) ((r139 * r152) / r104);
        float r154 = r104 - r152;
        int r155 = r139 - r153;
        int r156 = ViewGroup.getChildMeasureSpec(r311, ((getPaddingTop() + getPaddingBottom()) + ((LinearLayout.LayoutParams) r151).topMargin) + ((LinearLayout.LayoutParams) r151).bottomMargin, ((LinearLayout.LayoutParams) r151).height);
        if (((LinearLayout.LayoutParams) r151).width != 0) goto L165;
        int r157 = 1073741824;
        if (r111 != 1073741824) goto L166;
        if (r153 > 0) goto L164;
        r153 = 0;
    L164:
        r149.measure(View.MeasureSpec.makeMeasureSpec(r153, 1073741824), r156);
    L170:
        r146 = View.combineMeasuredStates(r146, r149.getMeasuredState() & (-16777216));
        r104 = r154;
        r150 = r155;
    L172:
        if (r114 == false) goto L174;
        this.mTotalLength += ((r149.getMeasuredWidth() + ((LinearLayout.LayoutParams) r151).leftMargin) + ((LinearLayout.LayoutParams) r151).rightMargin) + getNextLocationOffset(r149);
    L176:
        if (r112 != 1073741824) goto L178;
    L180:
        boolean r158 = false;
    L181:
        int r159 = ((LinearLayout.LayoutParams) r151).topMargin + ((LinearLayout.LayoutParams) r151).bottomMargin;
        int r160 = r149.getMeasuredHeight() + r159;
        r147 = Math.max(r147, r160);
        if (r158 == true) goto L185;
        r159 = r160;
    L185:
        int r161 = Math.max(r145, r159);
        if (r215 == false) goto L190;
        int r162 = -1;
        if (((LinearLayout.LayoutParams) r151).height != (-1)) goto L191;
        boolean r163 = true;
    L192:
        if (r318 == false) goto L199;
        int r164 = r149.getBaseline();
        if (r164 == r162) goto L199;
        int r165 = ((LinearLayout.LayoutParams) r151).gravity;
        if (r165 >= 0) goto L198;
        r165 = this.mGravity;
    L198:
        int r166 = (((r165 & 112) >> 4) & (-2)) >> 1;
        r113[r166] = Math.max(r113[r166], r164);
        r217[r166] = Math.max(r217[r166], r160 - r164);
    L199:
        r215 = r163;
        r145 = r161;
        r104 = r104;
    L191:
        r163 = false;
        goto L192
    L190:
        r162 = -1;
        goto L191
    L178:
        if (((LinearLayout.LayoutParams) r151).height != (-1)) goto L180;
        r158 = true;
        goto L181
    L174:
        int r167 = this.mTotalLength;
        this.mTotalLength = Math.max(r167, (((r149.getMeasuredWidth() + r167) + ((LinearLayout.LayoutParams) r151).leftMargin) + ((LinearLayout.LayoutParams) r151).rightMargin) + getNextLocationOffset(r149));
    L166:
        int r168 = r149.getMeasuredWidth() + r153;
        if (r168 >= 0) goto L169;
        r168 = 0;
    L169:
        r149.measure(View.MeasureSpec.makeMeasureSpec(r168, r157), r156);
        goto L170
    L165:
        r157 = 1073741824;
        goto L166
    L171:
        r150 = r139;
        goto L172
    L202:
        r220 = r110;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int r169 = r113[1];
        if (r169 == (-1)) goto L205;
    L212:
        int r170 = Math.max(r147, Math.max(r113[3], Math.max(r113[0], Math.max(r169, r113[2]))) + Math.max(r217[3], Math.max(r217[0], Math.max(r217[1], r217[2]))));
    L213:
        r141 = r170;
        r140 = r145;
        r134 = r146;
        goto L214
    L205:
        if (r113[0] != (-1)) goto L212;
        if (r113[2] != (-1)) goto L212;
        if (r113[3] != (-1)) goto L212;
        r170 = r147;
        goto L213
    L106:
        if (r111 == Integer.MIN_VALUE) goto L108;
        if (r111 != 0) goto L122;
    L108:
        this.mTotalLength = 0;
        int r171 = 0;
    L109:
        if (r171 >= r110) goto L122;
        View r172 = getVirtualChildAt(r171);
        if (r172 != null) goto L114;
        this.mTotalLength += measureNullChild(r171);
    L121:
        r171 = r171 + 1;
        r136 = r136;
        goto L109
    L114:
        if (r172.getVisibility() != 8) goto L117;
        r171 = r171 + getChildrenSkipCount(r172, r171);
        goto L121
    L117:
        LayoutParams r173 = (LayoutParams) r172.getLayoutParams();
        if (r114 == false) goto L120;
        this.mTotalLength += ((((LinearLayout.LayoutParams) r173).leftMargin + r115) + ((LinearLayout.LayoutParams) r173).rightMargin) + getNextLocationOffset(r172);
        goto L121
    L120:
        int r174 = this.mTotalLength;
        this.mTotalLength = Math.max(r174, (((r174 + r115) + ((LinearLayout.LayoutParams) r173).leftMargin) + ((LinearLayout.LayoutParams) r173).rightMargin) + getNextLocationOffset(r172));
        goto L121
    L96:
        if (r113[0] != (-1)) goto L103;
        if (r113[2] != (-1)) goto L103;
        if (r113[3] != (-1)) goto L103;
        r136 = r131;
        goto L104
    L91:
        if (hasDividerBeforeChildAt(r110) == false) goto L93;
        this.mTotalLength += this.mDividerWidth;
        goto L93
    L10:
        r114 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    void measureVertical(int r310, int r311) {
        this.mTotalLength = 0;
        int r110 = getVirtualChildCount();
        int r111 = View.MeasureSpec.getMode(r310);
        int r112 = View.MeasureSpec.getMode(r311);
        int r113 = this.mBaselineAlignedChildIndex;
        boolean r114 = this.mUseLargestChild;
        float r100 = 0.0f;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        boolean r115 = false;
        boolean r116 = true;
        boolean r210 = false;
    L3:
        int r117 = 8;
        int r211 = r104;
        if (r106 >= r110) goto L72;
        View r107 = getVirtualChildAt(r106);
        if (r107 != null) goto L8;
        this.mTotalLength += measureNullChild(r106);
        int r212 = r110;
        int r213 = r112;
        r104 = r211;
    L71:
        r106 = r106 + 1;
        r112 = r213;
        r110 = r212;
        goto L3
    L8:
        int r214 = r101;
        if (r107.getVisibility() != 8) goto L12;
        r106 = r106 + getChildrenSkipCount(r107, r106);
        r212 = r110;
        r104 = r211;
        r101 = r214;
        r213 = r112;
        goto L71
    L12:
        if (hasDividerBeforeChildAt(r106) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r118 = (LayoutParams) r107.getLayoutParams();
        float r108 = ((LinearLayout.LayoutParams) r118).weight;
        float r215 = r100 + r108;
        if (r112 == 1073741824) goto L17;
    L21:
        int r216 = r102;
        if (((LinearLayout.LayoutParams) r118).height == 0) goto L24;
    L26:
        int r109 = Integer.MIN_VALUE;
    L28:
        if (r215 != 0.0f) goto L30;
        int r217 = this.mTotalLength;
    L31:
        int r119 = r214;
        int r312 = r109;
        int r218 = r216;
        int r120 = r103;
        r212 = r110;
        r213 = r112;
        int r121 = r211;
        int r313 = r105;
        int r122 = r106;
        measureChildBeforeLayout(r107, r106, r310, 0, r311, r217);
        if (r312 == Integer.MIN_VALUE) goto L34;
        ((LinearLayout.LayoutParams) r118).height = r312;
    L34:
        int r123 = r107.getMeasuredHeight();
        int r124 = this.mTotalLength;
        View r125 = r107;
        this.mTotalLength = Math.max(r124, (((r124 + r123) + ((LinearLayout.LayoutParams) r118).topMargin) + ((LinearLayout.LayoutParams) r118).bottomMargin) + getNextLocationOffset(r125));
        if (r114 == false) goto L37;
        int r126 = Math.max(r123, r120);
    L38:
        if (r113 >= 0) goto L40;
    L42:
        if (r122 >= r113) goto L49;
        if (((LinearLayout.LayoutParams) r118).weight <= 0.0f) goto L49;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L49:
        if (r111 != 1073741824) goto L51;
    L53:
        boolean r127 = false;
    L54:
        int r128 = ((LinearLayout.LayoutParams) r118).leftMargin + ((LinearLayout.LayoutParams) r118).rightMargin;
        int r129 = r125.getMeasuredWidth() + r128;
        int r130 = Math.max(r218, r129);
        int r131 = View.combineMeasuredStates(r119, r125.getMeasuredState());
        if (r116 == true) goto L57;
    L59:
        r116 = false;
    L61:
        if (((LinearLayout.LayoutParams) r118).weight <= 0.0f) goto L66;
        if (r127 == true) goto L65;
        r128 = r129;
    L65:
        r104 = Math.max(r121, r128);
        int r132 = r313;
    L70:
        int r133 = getChildrenSkipCount(r125, r122) + r122;
        r103 = r126;
        r100 = r215;
        r105 = r132;
        r101 = r131;
        r106 = r133;
        r102 = r130;
        goto L71
    L66:
        if (r127 == true) goto L69;
        r128 = r129;
    L69:
        r132 = Math.max(r313, r128);
        r104 = r121;
        goto L70
    L57:
        if (((LinearLayout.LayoutParams) r118).width != (-1)) goto L59;
        r116 = true;
        goto L61
    L51:
        if (((LinearLayout.LayoutParams) r118).width != (-1)) goto L53;
        r127 = true;
        r210 = true;
        goto L54
    L40:
        if (r113 != (r122 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r126 = r120;
        goto L38
    L30:
        r217 = 0;
        goto L31
    L24:
        if (r108 <= 0.0f) goto L26;
        ((LinearLayout.LayoutParams) r118).height = -2;
        r109 = 0;
        goto L28
    L17:
        if (((LinearLayout.LayoutParams) r118).height != 0) goto L21;
        if (r108 <= 0.0f) goto L21;
        int r134 = this.mTotalLength;
        this.mTotalLength = Math.max(r134, (((LinearLayout.LayoutParams) r118).topMargin + r134) + ((LinearLayout.LayoutParams) r118).bottomMargin);
        r126 = r103;
        r125 = r107;
        r313 = r105;
        r119 = r214;
        r218 = r102;
        r115 = true;
        r212 = r110;
        r213 = r112;
        r121 = r211;
        r122 = r106;
        goto L38
    L72:
        int r135 = r101;
        int r136 = r103;
        int r137 = r105;
        int r219 = r110;
        int r220 = r112;
        int r138 = r102;
        if (this.mTotalLength <= 0) goto L77;
        int r139 = r219;
        if (hasDividerBeforeChildAt(r139) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r114 == true) goto L81;
    L93:
        int r140 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r140;
        int r141 = View.resolveSizeAndState(Math.max(r140, getSuggestedMinimumHeight()), r311, 0);
        int r142 = (16777215 & r141) - this.mTotalLength;
        if (r115 == true) goto L115;
        if (r142 != 0) goto L97;
    L99:
        int r143 = Math.max(r137, r211);
        if (r114 == true) goto L102;
    L114:
        int r144 = r135;
    L160:
        if (r116 == false) goto L162;
    L164:
        r143 = r138;
    L165:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r143 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r310, r144), r141);
        if (r210 == false) goto L186;
        forceUniformWidth(r139, r311);
        return;
    L186:
        return;
    L162:
        if (r111 == 1073741824) goto L164;
    L102:
        if (r220 == 1073741824) goto L114;
        int r145 = 0;
    L104:
        if (r145 >= r139) goto L114;
        View r146 = getVirtualChildAt(r145);
        if (r146 == null) goto L113;
        if (r146.getVisibility() == 8) goto L113;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r146.getLayoutParams())).weight <= 0.0f) goto L113;
        r146.measure(View.MeasureSpec.makeMeasureSpec(r146.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r136, 1073741824));
    L113:
        r145 = r145 + 1;
        goto L104
    L97:
        if (r100 <= 0.0f) goto L99;
    L115:
        float r147 = this.mWeightSum;
        if (r147 <= 0.0f) goto L118;
        r100 = r147;
    L118:
        this.mTotalLength = 0;
        int r148 = r142;
        int r149 = r137;
        r144 = r135;
        int r150 = 0;
    L119:
        if (r150 >= r139) goto L159;
        View r151 = getVirtualChildAt(r150);
        if (r151.getVisibility() != 8) goto L123;
        int r221 = r148;
    L158:
        r150 = r150 + 1;
        r148 = r221;
        goto L119
    L123:
        LayoutParams r152 = (LayoutParams) r151.getLayoutParams();
        float r153 = ((LinearLayout.LayoutParams) r152).weight;
        if (r153 <= 0.0f) goto L140;
        int r154 = (int) ((r148 * r153) / r100);
        float r155 = r100 - r153;
        r221 = r148 - r154;
        int r156 = ViewGroup.getChildMeasureSpec(r310, ((getPaddingLeft() + getPaddingRight()) + ((LinearLayout.LayoutParams) r152).leftMargin) + ((LinearLayout.LayoutParams) r152).rightMargin, ((LinearLayout.LayoutParams) r152).width);
        if (((LinearLayout.LayoutParams) r152).height != 0) goto L134;
        int r157 = 1073741824;
        if (r220 != 1073741824) goto L135;
        if (r154 > 0) goto L133;
        r154 = 0;
    L133:
        r151.measure(r156, View.MeasureSpec.makeMeasureSpec(r154, 1073741824));
    L139:
        r144 = View.combineMeasuredStates(r144, r151.getMeasuredState() & (-256));
        r100 = r155;
    L141:
        int r158 = ((LinearLayout.LayoutParams) r152).leftMargin + ((LinearLayout.LayoutParams) r152).rightMargin;
        int r159 = r151.getMeasuredWidth() + r158;
        r138 = Math.max(r138, r159);
        float r160 = r100;
        if (r111 == 1073741824) goto L146;
        int r222 = r144;
        int r161 = -1;
        if (((LinearLayout.LayoutParams) r152).width != (-1)) goto L147;
        boolean r162 = true;
    L148:
        if (r162 == true) goto L151;
        r158 = r159;
    L151:
        int r163 = Math.max(r149, r158);
        if (r116 == true) goto L154;
    L156:
        boolean r164 = false;
    L157:
        int r165 = this.mTotalLength;
        this.mTotalLength = Math.max(r165, (((r151.getMeasuredHeight() + r165) + ((LinearLayout.LayoutParams) r152).topMargin) + ((LinearLayout.LayoutParams) r152).bottomMargin) + getNextLocationOffset(r151));
        r116 = r164;
        r144 = r222;
        r149 = r163;
        r100 = r160;
        goto L158
    L154:
        if (((LinearLayout.LayoutParams) r152).width != r161) goto L156;
        r164 = true;
    L147:
        r162 = false;
        goto L148
    L146:
        r222 = r144;
        r161 = -1;
    L135:
        int r166 = r151.getMeasuredHeight() + r154;
        if (r166 >= 0) goto L138;
        r166 = 0;
    L138:
        r151.measure(r156, View.MeasureSpec.makeMeasureSpec(r166, r157));
        goto L139
    L134:
        r157 = 1073741824;
        goto L135
    L140:
        r221 = r148;
        goto L141
    L159:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r143 = r149;
        goto L160
    L81:
        if (r220 == Integer.MIN_VALUE) goto L83;
        if (r220 != 0) goto L93;
    L83:
        this.mTotalLength = 0;
        int r167 = 0;
    L84:
        if (r167 >= r139) goto L93;
        View r168 = getVirtualChildAt(r167);
        if (r168 != null) goto L89;
        this.mTotalLength += measureNullChild(r167);
    L92:
        r167 = r167 + 1;
        r117 = 8;
        goto L84
    L89:
        if (r168.getVisibility() != r117) goto L91;
        r167 = r167 + getChildrenSkipCount(r168, r167);
        goto L92
    L91:
        LayoutParams r169 = (LayoutParams) r168.getLayoutParams();
        int r170 = this.mTotalLength;
        this.mTotalLength = Math.max(r170, (((r170 + r136) + ((LinearLayout.LayoutParams) r169).topMargin) + ((LinearLayout.LayoutParams) r169).bottomMargin) + getNextLocationOffset(r168));
        goto L92
    L77:
        r139 = r219;
        goto L79
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r100, r101);
        return;
    L5:
        measureHorizontal(r100, r101);
    }

    public LinearLayoutCompat(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray r100 = TintTypedArray.obtainStyledAttributes(r110, r111, new int[]{R.attr.gravity, R.attr.orientation, R.attr.baselineAligned, R.attr.baselineAlignedChildIndex, R.attr.weightSum, com.larus.nova.R.attr.divider, com.larus.nova.R.attr.dividerPadding, com.larus.nova.R.attr.measureWithLargestChild, com.larus.nova.R.attr.showDividers}, r112, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{R.attr.gravity, R.attr.orientation, R.attr.baselineAligned, R.attr.baselineAlignedChildIndex, R.attr.weightSum, com.larus.nova.R.attr.divider, com.larus.nova.R.attr.dividerPadding, com.larus.nova.R.attr.measureWithLargestChild, com.larus.nova.R.attr.showDividers}, r111, r100.getWrappedTypeArray(), r112, 0);
        int r113 = r100.getInt(1, -1);
        if (r113 < 0) goto L5;
        setOrientation(r113);
    L5:
        int r114 = r100.getInt(0, -1);
        if (r114 < 0) goto L8;
        setGravity(r114);
    L8:
        boolean r115 = r100.getBoolean(2, true);
        if (r115 == true) goto L11;
        setBaselineAligned(r115);
    L11:
        this.mWeightSum = r100.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = r100.getInt(3, -1);
        this.mUseLargestChild = r100.getBoolean(7, false);
        setDividerDrawable(r100.getDrawable(5));
        this.mShowDividers = r100.getInt(8, 0);
        this.mDividerPadding = r100.getDimensionPixelSize(6, 0);
        r100.recycle();
    }

    public void layoutHorizontal(int r210, int r211, int r212, int r213) {
        boolean r100 = ViewUtils.isLayoutRtl(this);
        int r101 = getPaddingTop();
        int r102 = r213 - r211;
        int r103 = r102 - getPaddingBottom();
        int r104 = (r102 - r101) - getPaddingBottom();
        int r110 = getVirtualChildCount();
        int r105 = this.mGravity;
        int r111 = r105 & 112;
        boolean r112 = this.mBaselineAligned;
        int[] r113 = this.mMaxAscent;
        int[] r114 = this.mMaxDescent;
        int r106 = GravityCompat.getAbsoluteGravity(8388615 & r105, ViewCompat.getLayoutDirection(this));
        if (r106 != 1) goto L5;
        int r107 = getPaddingLeft() + (((r212 - r210) - this.mTotalLength) / 2);
    L10:
        if (r100 == false) goto L12;
        int r115 = r110 - 1;
        int r116 = -1;
    L13:
        int r108 = 0;
    L14:
        if (r108 >= r110) goto L52;
        int r109 = r115 + (r116 * r108);
        View r117 = getVirtualChildAt(r109);
        if (r117 != null) goto L19;
        r107 = r107 + measureNullChild(r109);
    L50:
        int r118 = r110;
    L51:
        r108 = r108 + 1;
        r110 = r118;
        r111 = r111;
        r101 = r101;
        goto L14
    L19:
        if (r117.getVisibility() == 8) goto L50;
        int r119 = r117.getMeasuredWidth();
        int r120 = r117.getMeasuredHeight();
        LayoutParams r121 = (LayoutParams) r117.getLayoutParams();
        int r122 = r108;
        if (r112 == false) goto L25;
        r118 = r110;
        if (((LinearLayout.LayoutParams) r121).height == (-1)) goto L26;
        int r123 = r117.getBaseline();
    L27:
        int r124 = ((LinearLayout.LayoutParams) r121).gravity;
        if (r124 >= 0) goto L30;
        r124 = r111;
    L30:
        int r125 = r124 & 112;
        if (r125 != 16) goto L33;
        int r126 = ((((r104 - r120) / 2) + r101) + ((LinearLayout.LayoutParams) r121).topMargin) - ((LinearLayout.LayoutParams) r121).bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r109) == false) goto L48;
        r107 = r107 + this.mDividerWidth;
    L48:
        int r127 = ((LinearLayout.LayoutParams) r121).leftMargin + r107;
        setChildFrame(r117, r127 + getLocationOffset(r117), r126, r119, r120);
        int r128 = r127 + ((r119 + ((LinearLayout.LayoutParams) r121).rightMargin) + getNextLocationOffset(r117));
        r108 = r122 + getChildrenSkipCount(r117, r109);
        r107 = r128;
        goto L51
    L33:
        if (r125 != 48) goto L35;
        r126 = ((LinearLayout.LayoutParams) r121).topMargin + r101;
        if (r123 == (-1)) goto L46;
        r126 = r126 + (r113[1] - r123);
        goto L46
    L35:
        if (r125 == 80) goto L37;
        r126 = r101;
        goto L46
    L37:
        r126 = (r103 - r120) - ((LinearLayout.LayoutParams) r121).bottomMargin;
        if (r123 == (-1)) goto L46;
        r126 = r126 - (r114[2] - (r117.getMeasuredHeight() - r123));
    L26:
        r123 = -1;
        goto L27
    L25:
        r118 = r110;
        goto L26
    L52:
        return;
    L12:
        r115 = 0;
        r116 = 1;
        goto L13
    L5:
        if (r106 == 5) goto L7;
        r107 = getPaddingLeft();
        goto L10
    L7:
        r107 = ((getPaddingLeft() + r212) - r210) - this.mTotalLength;
        goto L10
    }

    public void layoutVertical(int r110, int r111, int r210, int r211) {
        int r100 = getPaddingLeft();
        int r101 = r210 - r110;
        int r102 = r101 - getPaddingRight();
        int r103 = (r101 - r100) - getPaddingRight();
        int r112 = getVirtualChildCount();
        int r104 = this.mGravity;
        int r105 = r104 & 112;
        int r113 = r104 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r105 != 16) goto L5;
        int r106 = getPaddingTop() + (((r211 - r111) - this.mTotalLength) / 2);
    L9:
        int r114 = 0;
    L10:
        if (r114 >= r112) goto L32;
        View r115 = getVirtualChildAt(r114);
        if (r115 != null) goto L15;
        r106 = r106 + measureNullChild(r114);
    L31:
        r114 = r114 + 1;
        goto L10
    L15:
        if (r115.getVisibility() == 8) goto L31;
        int r107 = r115.getMeasuredWidth();
        int r116 = r115.getMeasuredHeight();
        LayoutParams r108 = (LayoutParams) r115.getLayoutParams();
        int r109 = ((LinearLayout.LayoutParams) r108).gravity;
        if (r109 >= 0) goto L19;
        r109 = r113;
    L19:
        int r117 = GravityCompat.getAbsoluteGravity(r109, ViewCompat.getLayoutDirection(this)) & 7;
        if (r117 != 1) goto L22;
        int r118 = (((r103 - r107) / 2) + r100) + ((LinearLayout.LayoutParams) r108).leftMargin;
        int r119 = ((LinearLayout.LayoutParams) r108).rightMargin;
    L26:
        int r120 = r118 - r119;
    L27:
        int r121 = r120;
        if (hasDividerBeforeChildAt(r114) == false) goto L30;
        r106 = r106 + this.mDividerHeight;
    L30:
        int r122 = r106 + ((LinearLayout.LayoutParams) r108).topMargin;
        setChildFrame(r115, r121, r122 + getLocationOffset(r115), r107, r116);
        int r123 = r122 + ((r116 + ((LinearLayout.LayoutParams) r108).bottomMargin) + getNextLocationOffset(r115));
        r114 = r114 + getChildrenSkipCount(r115, r114);
        r106 = r123;
        goto L31
    L22:
        if (r117 == 5) goto L24;
        r120 = ((LinearLayout.LayoutParams) r108).leftMargin + r100;
        goto L27
    L24:
        r118 = r102 - r107;
        r119 = ((LinearLayout.LayoutParams) r108).rightMargin;
        goto L26
    L32:
        return;
    L5:
        if (r105 == 80) goto L7;
        r106 = getPaddingTop();
        goto L9
    L7:
        r106 = ((getPaddingTop() + r211) - r111) - this.mTotalLength;
        goto L9
    }

    private void setChildFrame(View r100, int r101, int r102, int r103, int r104) {
        r100.layout(r101, r102, r103 + r101, r104 + r102);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r101, r102, r103, r104);
        return;
    L5:
        layoutHorizontal(r101, r102, r103, r104);
    }

    public void measureChildBeforeLayout(View r100, int r101, int r102, int r110, int r111, int r112) {
        measureChildWithMargins(r100, r102, r110, r111, r112);
    }
}
