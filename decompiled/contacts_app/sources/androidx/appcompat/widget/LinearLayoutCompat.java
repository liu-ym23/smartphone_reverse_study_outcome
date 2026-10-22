package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
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
        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2, r3);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View r1, int r2) {
        return 0;
    }

    int getLocationOffset(View r1) {
        return 0;
    }

    int getNextLocationOffset(View r1) {
        return 0;
    }

    int measureNullChild(int r1) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public LinearLayoutCompat(Context r2) {
        this(r2, null);
    }

    public LinearLayoutCompat(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LinearLayoutCompat(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray r3 = TintTypedArray.obtainStyledAttributes(r12, r13, R.styleable.LinearLayoutCompat, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, R.styleable.LinearLayoutCompat, r13, r3.getWrappedTypeArray(), r14, 0);
        int r15 = r3.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (r15 < 0) goto L5;
        setOrientation(r15);
    L5:
        int r16 = r3.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r16 < 0) goto L8;
        setGravity(r16);
    L8:
        boolean r17 = r3.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (r17 == true) goto L11;
        setBaselineAligned(r17);
    L11:
        this.mWeightSum = r3.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = r3.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = r3.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(r3.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = r3.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = r3.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        r3.recycle();
    }

    public void setShowDividers(int r2) {
        if (r2 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r2;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable r3) {
        if (r3 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r3;
        boolean r0 = false;
        if (r3 == null) goto L8;
        this.mDividerWidth = r3.getIntrinsicWidth();
        this.mDividerHeight = r3.getIntrinsicHeight();
    L9:
        if (r3 != null) goto L11;
        r0 = true;
    L11:
        setWillNotDraw(r0);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r1) {
        this.mDividerPadding = r1;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r3) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r3);
        return;
    L8:
        drawDividersHorizontal(r3);
    }

    void drawDividersVertical(Canvas r6) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getVirtualChildAt(r1);
        if (r2 == null) goto L11;
        if (r2.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r1) == false) goto L11;
        drawHorizontalDivider(r6, (r2.getTop() - ((LayoutParams) r2.getLayoutParams()).topMargin) - this.mDividerHeight);
    L11:
        r1 = r1 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r0) == false) goto L25;
        View r3 = getVirtualChildAt(r0 - 1);
        if (r3 != null) goto L17;
        int r4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r6, r4);
        return;
    L17:
        r4 = r3.getBottom() + ((LayoutParams) r3.getLayoutParams()).bottomMargin;
        goto L18
    }

    void drawDividersHorizontal(Canvas r7) {
        int r0 = getVirtualChildCount();
        boolean r1 = ViewUtils.isLayoutRtl(this);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        View r3 = getVirtualChildAt(r2);
        if (r3 == null) goto L15;
        if (r3.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r2) == false) goto L15;
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        if (r1 == false) goto L13;
        int r5 = r3.getRight() + r4.rightMargin;
    L14:
        drawVerticalDivider(r7, r5);
        goto L15
    L13:
        r5 = (r3.getLeft() - r4.leftMargin) - this.mDividerWidth;
    L15:
        r2 = r2 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r0) == false) goto L35;
        View r6 = getVirtualChildAt(r0 - 1);
        if (r6 != null) goto L23;
        if (r1 == false) goto L22;
        int r8 = getPaddingLeft();
    L28:
        drawVerticalDivider(r7, r8);
        return;
    L22:
        int r9 = getWidth() - getPaddingRight();
        int r10 = this.mDividerWidth;
    L26:
        r8 = r9 - r10;
        goto L28
    L23:
        LayoutParams r11 = (LayoutParams) r6.getLayoutParams();
        if (r1 == false) goto L27;
        r9 = r6.getLeft() - r11.leftMargin;
        r10 = this.mDividerWidth;
        goto L26
    L27:
        r8 = r6.getRight() + r11.rightMargin;
        goto L28
    }

    void drawHorizontalDivider(Canvas r5, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(r5);
    }

    void drawVerticalDivider(Canvas r6, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r6);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean r1) {
        this.mBaselineAligned = r1;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean r1) {
        this.mUseLargestChild = r1;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r0 = getChildCount();
        int r1 = this.mBaselineAlignedChildIndex;
        if (r0 <= r1) goto L29;
        View r2 = getChildAt(r1);
        int r3 = r2.getBaseline();
        if (r3 == (-1)) goto L11;
        int r4 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r5 = this.mGravity & 112;
        if (r5 == 48) goto L27;
        if (r5 != 16) goto L22;
        r4 = r4 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r5 != 80) goto L27;
        r4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r4 + ((LayoutParams) r2.getLayoutParams()).topMargin) + r3;
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

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r3;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    View getVirtualChildAt(int r1) {
        return getChildAt(r1);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float r2) {
        this.mWeightSum = Math.max(0.0f, r2);
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r3, r4);
        return;
    L5:
        measureHorizontal(r3, r4);
    }

    protected boolean hasDividerBeforeChildAt(int r5) {
        if (r5 != 0) goto L9;
        if ((this.mShowDividers & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r5 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) != 0) goto L13;
        return false;
    L13:
        return true;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r6 = r5 - 1;
    L17:
        if (r6 < 0) goto L28;
        if (getChildAt(r6).getVisibility() != 8) goto L27;
        r6 = r6 - 1;
        goto L17
    L27:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    void measureVertical(int r34, int r35) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r34);
        int r13 = View.MeasureSpec.getMode(r35);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        boolean r18 = false;
        boolean r20 = false;
        boolean r19 = true;
        float r0 = 0.0f;
    L3:
        int r10 = 8;
        int r22 = r4;
        if (r6 >= r11) goto L72;
        View r7 = getVirtualChildAt(r6);
        if (r7 != null) goto L8;
        this.mTotalLength += measureNullChild(r6);
        int r23 = r11;
        int r24 = r13;
        r4 = r22;
    L71:
        r6 = r6 + 1;
        r11 = r23;
        r13 = r24;
        goto L3
    L8:
        int r25 = r1;
        if (r7.getVisibility() != 8) goto L12;
        r6 = r6 + getChildrenSkipCount(r7, r6);
        r23 = r11;
        r4 = r22;
        r1 = r25;
        r24 = r13;
        goto L71
    L12:
        if (hasDividerBeforeChildAt(r6) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r16 = (LayoutParams) r7.getLayoutParams();
        float r26 = r0 + r16.weight;
        if (r13 == 1073741824) goto L17;
    L21:
        int r27 = r2;
        if (r16.height == 0) goto L24;
    L26:
        int r8 = Integer.MIN_VALUE;
    L28:
        if (r26 != 0.0f) goto L30;
        int r28 = this.mTotalLength;
    L31:
        int r9 = r25;
        int r30 = r8;
        int r29 = r27;
        int r17 = r3;
        r24 = r13;
        int r110 = r22;
        r23 = r11;
        int r31 = r5;
        int r111 = r6;
        measureChildBeforeLayout(r7, r6, r34, 0, r35, r28);
        if (r30 == Integer.MIN_VALUE) goto L34;
        r16.height = r30;
    L34:
        int r21 = r7.getMeasuredHeight();
        int r32 = this.mTotalLength;
        View r33 = r7;
        this.mTotalLength = Math.max(r32, (((r32 + r21) + r16.topMargin) + r16.bottomMargin) + getNextLocationOffset(r33));
        if (r15 == false) goto L37;
        int r36 = Math.max(r21, r17);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r111 >= r14) goto L49;
        if (r16.weight <= 0.0f) goto L49;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L49:
        if (r12 != 1073741824) goto L51;
    L53:
        boolean r37 = false;
    L54:
        int r38 = r16.leftMargin + r16.rightMargin;
        int r39 = r33.getMeasuredWidth() + r38;
        int r40 = Math.max(r29, r39);
        int r41 = View.combineMeasuredStates(r9, r33.getMeasuredState());
        if (r19 == true) goto L57;
    L59:
        r19 = false;
    L61:
        if (r16.weight <= 0.0f) goto L66;
        if (r37 == true) goto L65;
        r38 = r39;
    L65:
        r4 = Math.max(r110, r38);
        int r42 = r31;
    L70:
        int r43 = getChildrenSkipCount(r33, r111) + r111;
        r3 = r36;
        r0 = r26;
        r5 = r42;
        r1 = r41;
        r6 = r43;
        r2 = r40;
        goto L71
    L66:
        if (r37 == true) goto L69;
        r38 = r39;
    L69:
        r42 = Math.max(r31, r38);
        r4 = r110;
        goto L70
    L57:
        if (r16.width != (-1)) goto L59;
        r19 = true;
        goto L61
    L51:
        if (r16.width != (-1)) goto L53;
        r37 = true;
        r20 = true;
        goto L54
    L40:
        if (r14 != (r111 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r36 = r17;
        goto L38
    L30:
        r28 = 0;
        goto L31
    L24:
        if (r16.weight <= 0.0f) goto L26;
        r16.height = -2;
        r8 = 0;
        goto L28
    L17:
        if (r16.height != 0) goto L21;
        if (r16.weight <= 0.0f) goto L21;
        int r44 = this.mTotalLength;
        this.mTotalLength = Math.max(r44, (r16.topMargin + r44) + r16.bottomMargin);
        r36 = r3;
        r33 = r7;
        r31 = r5;
        r23 = r11;
        r18 = true;
        r9 = r25;
        r29 = r2;
        r111 = r6;
        r24 = r13;
        r110 = r22;
        goto L38
    L72:
        int r45 = r1;
        int r46 = r3;
        int r47 = r5;
        int r210 = r11;
        int r211 = r13;
        int r48 = r2;
        if (this.mTotalLength <= 0) goto L77;
        int r49 = r210;
        if (hasDividerBeforeChildAt(r49) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r15 == true) goto L81;
    L93:
        int r50 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r50;
        int r51 = View.resolveSizeAndState(Math.max(r50, getSuggestedMinimumHeight()), r35, 0);
        int r52 = (16777215 & r51) - this.mTotalLength;
        if (r18 == true) goto L115;
        if (r52 != 0) goto L97;
    L99:
        int r53 = Math.max(r47, r22);
        if (r15 == true) goto L102;
    L114:
        int r54 = r45;
    L160:
        if (r19 == false) goto L162;
    L164:
        r53 = r48;
    L165:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r53 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r34, r54), r51);
        if (r20 == false) goto L186;
        forceUniformWidth(r49, r35);
        return;
    L186:
        return;
    L162:
        if (r12 == 1073741824) goto L164;
    L102:
        if (r211 == 1073741824) goto L114;
        int r55 = 0;
    L104:
        if (r55 >= r49) goto L114;
        View r56 = getVirtualChildAt(r55);
        if (r56 == null) goto L113;
        if (r56.getVisibility() == 8) goto L113;
        if (((LayoutParams) r56.getLayoutParams()).weight <= 0.0f) goto L113;
        r56.measure(View.MeasureSpec.makeMeasureSpec(r56.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r46, 1073741824));
    L113:
        r55 = r55 + 1;
        goto L104
    L97:
        if (r0 <= 0.0f) goto L99;
    L115:
        float r112 = this.mWeightSum;
        if (r112 <= 0.0f) goto L118;
        r0 = r112;
    L118:
        this.mTotalLength = 0;
        int r113 = r52;
        int r57 = r47;
        r54 = r45;
        int r58 = 0;
    L119:
        if (r58 >= r49) goto L159;
        View r114 = getVirtualChildAt(r58);
        if (r114.getVisibility() != 8) goto L123;
        int r212 = r113;
    L158:
        r58 = r58 + 1;
        r113 = r212;
        goto L119
    L123:
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        float r116 = r115.weight;
        if (r116 <= 0.0f) goto L140;
        int r117 = (int) ((r113 * r116) / r0);
        float r59 = r0 - r116;
        r212 = r113 - r117;
        int r60 = getChildMeasureSpec(r34, ((getPaddingLeft() + getPaddingRight()) + r115.leftMargin) + r115.rightMargin, r115.width);
        if (r115.height != 0) goto L134;
        int r118 = 1073741824;
        if (r211 != 1073741824) goto L135;
        if (r117 > 0) goto L133;
        r117 = 0;
    L133:
        r114.measure(r60, View.MeasureSpec.makeMeasureSpec(r117, 1073741824));
    L139:
        r54 = View.combineMeasuredStates(r54, r114.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
        r0 = r59;
    L141:
        int r119 = r115.leftMargin + r115.rightMargin;
        int r120 = r114.getMeasuredWidth() + r119;
        r48 = Math.max(r48, r120);
        float r121 = r0;
        if (r12 == 1073741824) goto L146;
        int r213 = r54;
        int r61 = -1;
        if (r115.width != (-1)) goto L147;
        boolean r62 = true;
    L148:
        if (r62 == true) goto L151;
        r119 = r120;
    L151:
        int r63 = Math.max(r57, r119);
        if (r19 == true) goto L154;
    L156:
        boolean r64 = false;
    L157:
        int r122 = this.mTotalLength;
        this.mTotalLength = Math.max(r122, (((r114.getMeasuredHeight() + r122) + r115.topMargin) + r115.bottomMargin) + getNextLocationOffset(r114));
        r19 = r64;
        r54 = r213;
        r57 = r63;
        r0 = r121;
        goto L158
    L154:
        if (r115.width != r61) goto L156;
        r64 = true;
    L147:
        r62 = false;
        goto L148
    L146:
        r213 = r54;
        r61 = -1;
    L135:
        int r123 = r114.getMeasuredHeight() + r117;
        if (r123 >= 0) goto L138;
        r123 = 0;
    L138:
        r114.measure(r60, View.MeasureSpec.makeMeasureSpec(r123, r118));
        goto L139
    L134:
        r118 = 1073741824;
        goto L135
    L140:
        r212 = r113;
        goto L141
    L159:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r53 = r57;
        goto L160
    L81:
        if (r211 == Integer.MIN_VALUE) goto L83;
        if (r211 != 0) goto L93;
    L83:
        this.mTotalLength = 0;
        int r65 = 0;
    L84:
        if (r65 >= r49) goto L93;
        View r66 = getVirtualChildAt(r65);
        if (r66 != null) goto L89;
        this.mTotalLength += measureNullChild(r65);
    L92:
        r65 = r65 + 1;
        r10 = 8;
        goto L84
    L89:
        if (r66.getVisibility() != r10) goto L91;
        r65 = r65 + getChildrenSkipCount(r66, r65);
        goto L92
    L91:
        LayoutParams r124 = (LayoutParams) r66.getLayoutParams();
        int r125 = this.mTotalLength;
        this.mTotalLength = Math.max(r125, (((r125 + r46) + r124.topMargin) + r124.bottomMargin) + getNextLocationOffset(r66));
        goto L92
    L77:
        r49 = r210;
        goto L79
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (r8.width != (-1)) goto L9;
        int r9 = r8.height;
        r8.height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        r8.height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    void measureHorizontal(int r39, int r40) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r39);
        int r13 = View.MeasureSpec.getMode(r40);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r15 = this.mMaxAscent;
        int[] r6 = this.mMaxDescent;
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r6[3] = -1;
        r6[2] = -1;
        r6[1] = -1;
        r6[0] = -1;
        boolean r4 = this.mBaselineAligned;
        boolean r3 = this.mUseLargestChild;
        int r2 = 1073741824;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        int r1 = 0;
        int r14 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        boolean r24 = false;
        int r25 = 0;
        boolean r27 = false;
        boolean r26 = true;
        float r0 = 0.0f;
    L12:
        int[] r28 = r6;
        if (r1 >= r11) goto L89;
        View r7 = getVirtualChildAt(r1);
        if (r7 != null) goto L19;
        this.mTotalLength += measureNullChild(r1);
    L17:
        boolean r32 = r3;
        boolean r36 = r4;
        int r37 = r2;
        int r5 = r1;
        int r8 = r37;
    L88:
        int r9 = r5 + 1;
        r6 = r28;
        r3 = r32;
        r4 = r36;
        r2 = r8;
        r1 = r9;
        goto L12
    L19:
        if (r7.getVisibility() != 8) goto L22;
        r1 = r1 + getChildrenSkipCount(r7, r1);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r1) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r10 = (LayoutParams) r7.getLayoutParams();
        float r31 = r0 + r10.weight;
        if (r12 != r2) goto L37;
        if (r10.width != 0) goto L37;
        if (r10.weight <= 0.0f) goto L37;
        if (r19 == false) goto L32;
        this.mTotalLength += r10.leftMargin + r10.rightMargin;
    L33:
        if (r4 == false) goto L35;
        int r16 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r7.measure(r16, r16);
        int r34 = r1;
        r32 = r3;
        r36 = r4;
        View r17 = r7;
    L55:
        r8 = 1073741824;
    L56:
        if (r13 != r8) goto L58;
    L60:
        boolean r18 = false;
    L61:
        int r20 = r10.topMargin + r10.bottomMargin;
        int r29 = r17.getMeasuredHeight() + r20;
        r25 = View.combineMeasuredStates(r25, r17.getMeasuredState());
        if (r36 == false) goto L70;
        int r30 = r17.getBaseline();
        if (r30 == (-1)) goto L70;
        if (r10.gravity >= 0) goto L68;
        int r33 = this.mGravity;
    L69:
        int r35 = (((r33 & 112) >> 4) & (-2)) >> 1;
        r15[r35] = Math.max(r15[r35], r30);
        r28[r35] = Math.max(r28[r35], r29 - r30);
        goto L70
    L68:
        r33 = r10.gravity;
    L70:
        r21 = Math.max(r21, r29);
        if (r26 == true) goto L73;
    L75:
        r26 = false;
    L77:
        if (r10.weight <= 0.0f) goto L82;
        if (r18 == true) goto L81;
        r20 = r29;
    L81:
        r23 = Math.max(r23, r20);
    L87:
        int r110 = r34;
        r5 = getChildrenSkipCount(r17, r110) + r110;
        r0 = r31;
        goto L88
    L82:
        int r111 = r23;
        if (r18 == true) goto L86;
        r20 = r29;
    L86:
        r22 = Math.max(r22, r20);
        r23 = r111;
        goto L87
    L73:
        if (r10.height != (-1)) goto L75;
        r26 = true;
        goto L77
    L58:
        if (r10.height != (-1)) goto L60;
        r18 = true;
        r27 = true;
        goto L61
    L35:
        r34 = r1;
        r32 = r3;
        r36 = r4;
        r17 = r7;
        r24 = true;
        r8 = 1073741824;
        goto L56
    L32:
        int r38 = this.mTotalLength;
        this.mTotalLength = Math.max(r38, (r10.leftMargin + r38) + r10.rightMargin);
    L37:
        if (r10.width == 0) goto L39;
    L41:
        byte r41 = -2;
        int r42 = Integer.MIN_VALUE;
    L43:
        if (r31 != 0.0f) goto L45;
        int r210 = this.mTotalLength;
    L46:
        r34 = r1;
        int r310 = r42;
        r32 = r3;
        r36 = r4;
        measureChildBeforeLayout(r7, r34, r39, r210, r40, 0);
        if (r310 == Integer.MIN_VALUE) goto L49;
        r10.width = r310;
    L49:
        int r43 = r7.getMeasuredWidth();
        if (r19 == false) goto L52;
        r17 = r7;
        this.mTotalLength = this.mTotalLength + (((r10.leftMargin + r43) + r10.rightMargin) + getNextLocationOffset(r17));
    L53:
        if (r32 == false) goto L55;
        r14 = Math.max(r43, r14);
        goto L55
    L52:
        r17 = r7;
        int r44 = this.mTotalLength;
        this.mTotalLength = Math.max(r44, (((r44 + r43) + r10.leftMargin) + r10.rightMargin) + getNextLocationOffset(r17));
        goto L53
    L45:
        r210 = 0;
        goto L46
    L39:
        if (r10.weight <= 0.0f) goto L41;
        r41 = -2;
        r10.width = -2;
        r42 = 0;
        goto L43
    L89:
        boolean r311 = r3;
        boolean r312 = r4;
        int r45 = r21;
        int r46 = r22;
        int r112 = r23;
        int r47 = r25;
        if (this.mTotalLength > 0) goto L92;
    L94:
        int r48 = r15[1];
        if (r48 == (-1)) goto L97;
    L104:
        int r49 = Math.max(r45, Math.max(r15[3], Math.max(r15[0], Math.max(r48, r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L105:
        if (r311 == true) goto L107;
    L123:
        int r211 = r49;
        int r50 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r50;
        int r51 = View.resolveSizeAndState(Math.max(r50, getSuggestedMinimumWidth()), r39, 0);
        int r52 = (16777215 & r51) - this.mTotalLength;
        if (r24 == true) goto L145;
        if (r52 != 0) goto L127;
    L129:
        int r53 = Math.max(r46, r112);
        if (r311 == true) goto L132;
    L144:
        int r212 = r11;
        int r54 = r211;
    L216:
        if (r26 == false) goto L218;
    L220:
        r53 = r54;
    L221:
        setMeasuredDimension(r51 | (r47 & (-16777216)), View.resolveSizeAndState(Math.max(r53 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r40, r47 << 16));
        if (r27 == false) goto L239;
        forceUniformHeight(r212, r39);
        return;
    L239:
        return;
    L218:
        if (r13 == 1073741824) goto L220;
    L132:
        if (r12 == 1073741824) goto L144;
        int r113 = 0;
    L134:
        if (r113 >= r11) goto L144;
        View r55 = getVirtualChildAt(r113);
        if (r55 == null) goto L143;
        if (r55.getVisibility() == 8) goto L143;
        if (((LayoutParams) r55.getLayoutParams()).weight <= 0.0f) goto L143;
        r55.measure(View.MeasureSpec.makeMeasureSpec(r14, 1073741824), View.MeasureSpec.makeMeasureSpec(r55.getMeasuredHeight(), 1073741824));
    L143:
        r113 = r113 + 1;
        goto L134
    L127:
        if (r0 <= 0.0f) goto L129;
    L145:
        float r56 = this.mWeightSum;
        if (r56 <= 0.0f) goto L148;
        r0 = r56;
    L148:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r28[3] = -1;
        r28[2] = -1;
        r28[1] = -1;
        r28[0] = -1;
        this.mTotalLength = 0;
        int r57 = r46;
        int r58 = -1;
        int r59 = r47;
        int r114 = 0;
    L149:
        if (r114 >= r11) goto L204;
        View r115 = getVirtualChildAt(r114);
        if (r115 != null) goto L153;
    L202:
        int r60 = r52;
        r11 = r11;
    L203:
        r114 = r114 + 1;
        r52 = r60;
        r11 = r11;
        goto L149
    L153:
        if (r115.getVisibility() == 8) goto L202;
        LayoutParams r61 = (LayoutParams) r115.getLayoutParams();
        float r62 = r61.weight;
        if (r62 <= 0.0f) goto L172;
        int r63 = (int) ((r52 * r62) / r0);
        float r64 = r0 - r62;
        int r65 = r52 - r63;
        int r66 = getChildMeasureSpec(r40, ((getPaddingTop() + getPaddingBottom()) + r61.topMargin) + r61.bottomMargin, r61.height);
        if (r61.width != 0) goto L166;
        int r67 = 1073741824;
        if (r12 != 1073741824) goto L167;
        if (r63 > 0) goto L165;
        r63 = 0;
    L165:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r63, 1073741824), r66);
    L171:
        r59 = View.combineMeasuredStates(r59, r115.getMeasuredState() & (-16777216));
        r0 = r64;
        r60 = r65;
    L173:
        if (r19 == false) goto L175;
        this.mTotalLength += ((r115.getMeasuredWidth() + r61.leftMargin) + r61.rightMargin) + getNextLocationOffset(r115);
    L177:
        if (r13 != 1073741824) goto L179;
    L181:
        boolean r68 = false;
    L182:
        int r69 = r61.topMargin + r61.bottomMargin;
        int r116 = r115.getMeasuredHeight() + r69;
        r58 = Math.max(r58, r116);
        if (r68 == true) goto L186;
        r69 = r116;
    L186:
        int r70 = Math.max(r57, r69);
        if (r26 == false) goto L191;
        int r71 = -1;
        if (r61.height != (-1)) goto L192;
        boolean r72 = true;
    L193:
        if (r312 == false) goto L201;
        int r117 = r115.getBaseline();
        if (r117 == r71) goto L201;
        if (r61.gravity >= 0) goto L199;
        int r73 = this.mGravity;
    L200:
        int r74 = (((r73 & 112) >> 4) & (-2)) >> 1;
        r15[r74] = Math.max(r15[r74], r117);
        r28[r74] = Math.max(r28[r74], r116 - r117);
        goto L201
    L199:
        r73 = r61.gravity;
    L201:
        r26 = r72;
        r57 = r70;
        r0 = r0;
    L192:
        r72 = false;
        goto L193
    L191:
        r71 = -1;
        goto L192
    L179:
        if (r61.height != (-1)) goto L181;
        r68 = true;
        goto L182
    L175:
        int r75 = this.mTotalLength;
        this.mTotalLength = Math.max(r75, (((r115.getMeasuredWidth() + r75) + r61.leftMargin) + r61.rightMargin) + getNextLocationOffset(r115));
    L167:
        int r76 = r115.getMeasuredWidth() + r63;
        if (r76 >= 0) goto L170;
        r76 = 0;
    L170:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r76, r67), r66);
        goto L171
    L166:
        r67 = 1073741824;
        goto L167
    L172:
        r60 = r52;
        goto L173
    L204:
        r212 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int r77 = r15[1];
        if (r77 == (-1)) goto L207;
    L214:
        int r78 = Math.max(r58, Math.max(r15[3], Math.max(r15[0], Math.max(r77, r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L215:
        r54 = r78;
        r53 = r57;
        r47 = r59;
        goto L216
    L207:
        if (r15[0] != (-1)) goto L214;
        if (r15[2] != (-1)) goto L214;
        if (r15[3] != (-1)) goto L214;
        r78 = r58;
        goto L215
    L107:
        if (r12 == Integer.MIN_VALUE) goto L109;
        if (r12 != 0) goto L123;
    L109:
        this.mTotalLength = 0;
        int r79 = 0;
    L110:
        if (r79 >= r11) goto L123;
        View r80 = getVirtualChildAt(r79);
        if (r80 != null) goto L115;
        this.mTotalLength += measureNullChild(r79);
    L122:
        r79 = r79 + 1;
        r49 = r49;
        goto L110
    L115:
        if (r80.getVisibility() != 8) goto L118;
        r79 = r79 + getChildrenSkipCount(r80, r79);
        goto L122
    L118:
        LayoutParams r81 = (LayoutParams) r80.getLayoutParams();
        if (r19 == false) goto L121;
        this.mTotalLength += ((r81.leftMargin + r14) + r81.rightMargin) + getNextLocationOffset(r80);
        goto L122
    L121:
        int r82 = this.mTotalLength;
        this.mTotalLength = Math.max(r82, (((r82 + r14) + r81.leftMargin) + r81.rightMargin) + getNextLocationOffset(r80));
        goto L122
    L97:
        if (r15[0] != (-1)) goto L104;
        if (r15[2] != (-1)) goto L104;
        if (r15[3] != (-1)) goto L104;
        r49 = r45;
        goto L105
    L92:
        if (hasDividerBeforeChildAt(r11) == false) goto L94;
        this.mTotalLength += this.mDividerWidth;
        goto L94
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    private void forceUniformHeight(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (r8.height != (-1)) goto L9;
        int r9 = r8.width;
        r8.width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        r8.width = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    void measureChildBeforeLayout(View r7, int r8, int r9, int r10, int r11, int r12) {
        measureChildWithMargins(r7, r9, r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r3, r4, r5, r6);
        return;
    L5:
        layoutHorizontal(r3, r4, r5, r6);
    }

    void layoutVertical(int r18, int r19, int r20, int r21) {
        int r7 = getPaddingLeft();
        int r0 = r20 - r18;
        int r8 = r0 - getPaddingRight();
        int r9 = (r0 - r7) - getPaddingRight();
        int r10 = getVirtualChildCount();
        int r1 = this.mGravity;
        int r2 = r1 & 112;
        int r11 = r1 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r2 != 16) goto L5;
        int r3 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r10) goto L33;
        View r13 = getVirtualChildAt(r12);
        if (r13 != null) goto L15;
        r3 = r3 + measureNullChild(r12);
    L31:
        int r4 = 1;
    L32:
        r12 = r12 + r4;
        goto L10
    L15:
        if (r13.getVisibility() == 8) goto L31;
        int r5 = r13.getMeasuredWidth();
        int r15 = r13.getMeasuredHeight();
        LayoutParams r6 = (LayoutParams) r13.getLayoutParams();
        int r14 = r6.gravity;
        if (r14 >= 0) goto L19;
        r14 = r11;
    L19:
        int r16 = GravityCompat.getAbsoluteGravity(r14, ViewCompat.getLayoutDirection(this)) & 7;
        if (r16 != 1) goto L22;
        int r17 = (((r9 - r5) / 2) + r7) + r6.leftMargin;
        int r22 = r6.rightMargin;
    L26:
        int r23 = r17 - r22;
    L27:
        int r24 = r23;
        if (hasDividerBeforeChildAt(r12) == false) goto L30;
        r3 = r3 + this.mDividerHeight;
    L30:
        int r110 = r3 + r6.topMargin;
        setChildFrame(r13, r24, r110 + getLocationOffset(r13), r5, r15);
        int r111 = r110 + ((r15 + r6.bottomMargin) + getNextLocationOffset(r13));
        r12 = r12 + getChildrenSkipCount(r13, r12);
        r3 = r111;
        r4 = 1;
        goto L32
    L22:
        if (r16 == 5) goto L24;
        r23 = r6.leftMargin + r7;
        goto L27
    L24:
        r17 = r8 - r5;
        r22 = r6.rightMargin;
        goto L26
    L33:
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = getPaddingTop();
        goto L9
    L7:
        r3 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r7 = getPaddingTop();
        int r1 = r28 - r26;
        int r8 = r1 - getPaddingBottom();
        int r9 = (r1 - r7) - getPaddingBottom();
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & 112;
        boolean r12 = this.mBaselineAligned;
        int[] r13 = this.mMaxAscent;
        int[] r14 = this.mMaxDescent;
        int r3 = GravityCompat.getAbsoluteGravity(8388615 & r2, ViewCompat.getLayoutDirection(this));
        boolean r5 = true;
        if (r3 != 1) goto L5;
        int r4 = getPaddingLeft() + (((r27 - r25) - this.mTotalLength) / 2);
    L10:
        if (r0 == false) goto L12;
        int r16 = r10 - 1;
        int r17 = -1;
    L13:
        int r6 = 0;
    L14:
        if (r6 >= r10) goto L52;
        int r15 = r16 + (r17 * r6);
        View r18 = getVirtualChildAt(r15);
        if (r18 != null) goto L19;
        r4 = r4 + measureNullChild(r15);
        boolean r21 = r5;
    L51:
        r6 = r6 + 1;
        r10 = r10;
        r11 = r11;
        r5 = r21;
        r7 = r7;
        goto L14
    L19:
        if (r18.getVisibility() == 8) goto L49;
        int r19 = r18.getMeasuredWidth();
        int r20 = r18.getMeasuredHeight();
        LayoutParams r22 = (LayoutParams) r18.getLayoutParams();
        int r110 = r6;
        if (r12 == false) goto L25;
        r10 = r10;
        if (r22.height == (-1)) goto L26;
        int r111 = r18.getBaseline();
    L27:
        int r23 = r22.gravity;
        if (r23 >= 0) goto L30;
        r23 = r11;
    L30:
        int r24 = r23 & 112;
        r11 = r11;
        if (r24 != 16) goto L33;
        r21 = true;
        int r29 = ((((r9 - r20) / 2) + r7) + r22.topMargin) - r22.bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r15) == false) goto L48;
        r4 = r4 + this.mDividerWidth;
    L48:
        int r112 = r22.leftMargin + r4;
        r7 = r7;
        setChildFrame(r18, r112 + getLocationOffset(r18), r29, r19, r20);
        int r113 = r112 + ((r19 + r22.rightMargin) + getNextLocationOffset(r18));
        r6 = r110 + getChildrenSkipCount(r18, r15);
        r4 = r113;
        goto L51
    L33:
        if (r24 != 48) goto L35;
        r29 = r22.topMargin + r7;
        if (r111 == (-1)) goto L43;
        r21 = true;
        r29 = r29 + (r13[1] - r111);
    L43:
        r21 = true;
        goto L46
    L35:
        if (r24 == 80) goto L37;
        r29 = r7;
        goto L43
    L37:
        r29 = (r8 - r20) - r22.bottomMargin;
        if (r111 == (-1)) goto L43;
        r29 = r29 - (r14[2] - (r18.getMeasuredHeight() - r111));
    L26:
        r111 = -1;
        goto L27
    L25:
        r10 = r10;
        goto L26
    L49:
        r21 = true;
        goto L51
    L52:
        return;
    L12:
        r16 = 0;
        r17 = 1;
        goto L13
    L5:
        if (r3 == 5) goto L7;
        r4 = getPaddingLeft();
        goto L10
    L7:
        r4 = ((getPaddingLeft() + r27) - r25) - this.mTotalLength;
        goto L10
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }

    public void setOrientation(int r2) {
        if (this.mOrientation == r2) goto L6;
        this.mOrientation = r2;
        requestLayout();
        return;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int r2) {
        if (this.mGravity != r2) goto L5;
        return;
    L5:
        if ((8388615 & r2) != 0) goto L8;
        r2 = r2 | GravityCompat.START;
    L8:
        if ((r2 & 112) != 0) goto L10;
        r2 = r2 | 48;
    L10:
        this.mGravity = r2;
        requestLayout();
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int r3) {
        int r4 = r3 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int r1 = this.mGravity;
        if ((8388615 & r1) == r4) goto L6;
        this.mGravity = r4 | ((-8388616) & r1);
        requestLayout();
        return;
    }

    public void setVerticalGravity(int r3) {
        int r4 = r3 & 112;
        int r0 = this.mGravity;
        if ((r0 & 112) == r4) goto L6;
        this.mGravity = r4 | (r0 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        int r2 = this.mOrientation;
        if (r2 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r2 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(ACCESSIBILITY_CLASS_NAME);
    }
}
