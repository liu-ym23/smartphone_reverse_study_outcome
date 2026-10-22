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
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
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
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public LinearLayoutCompat(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public LinearLayoutCompat(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public LinearLayoutCompat(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r3, r5, r12);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        y r1 = y.a(r3, r5, R.styleable.LinearLayoutCompat, r12, 0);
        ViewCompat.a(this, r3, R.styleable.LinearLayoutCompat, r5, r1.a(), r12, 0);
        int r13 = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_orientation, "styleable", "LinearLayoutCompat_android_orientation"), -1);
        if (r13 < 0) goto L5;
        setOrientation(r13);
    L5:
        int r14 = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_gravity, "styleable", "LinearLayoutCompat_android_gravity"), -1);
        if (r14 < 0) goto L8;
        setGravity(r14);
    L8:
        boolean r15 = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_baselineAligned, "styleable", "LinearLayoutCompat_android_baselineAligned"), true);
        if (r15 == true) goto L11;
        setBaselineAligned(r15);
    L11:
        this.mWeightSum = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_weightSum, "styleable", "LinearLayoutCompat_android_weightSum"), -1.0f);
        this.mBaselineAlignedChildIndex = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, "styleable", "LinearLayoutCompat_android_baselineAlignedChildIndex"), -1);
        this.mUseLargestChild = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_measureWithLargestChild, "styleable", "LinearLayoutCompat_measureWithLargestChild"), false);
        setDividerDrawable(r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_divider, "styleable", "LinearLayoutCompat_divider")));
        this.mShowDividers = r1.a(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_showDividers, "styleable", "LinearLayoutCompat_showDividers"), 0);
        this.mDividerPadding = r1.e(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_dividerPadding, "styleable", "LinearLayoutCompat_dividerPadding"), 0);
        r1.b();
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
    public void onDraw(Canvas r3) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r3);
        return;
    L8:
        drawDividersHorizontal(r3);
    }

    void drawDividersVertical(Canvas r7) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L14;
        View r3 = getVirtualChildAt(r1);
        if (r3 == null) goto L12;
        if (r3.getVisibility() == 8) goto L12;
        if (hasDividerBeforeChildAt(r1) == false) goto L12;
        drawHorizontalDivider(r7, (r3.getTop() - ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).topMargin) - this.mDividerHeight);
    L12:
        r1 = r1 + 1;
        goto L4
    L14:
        if (hasDividerBeforeChildAt(r0) == false) goto L26;
        View r2 = getVirtualChildAt(r0 - 1);
        if (r2 != null) goto L18;
        int r4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L19:
        drawHorizontalDivider(r7, r4);
        return;
    L18:
        r4 = r2.getBottom() + ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).bottomMargin;
        goto L19
    }

    void drawDividersHorizontal(Canvas r8) {
        int r0 = getVirtualChildCount();
        boolean r1 = ac.a(this);
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L18;
        View r4 = getVirtualChildAt(r2);
        if (r4 == null) goto L16;
        if (r4.getVisibility() == 8) goto L16;
        if (hasDividerBeforeChildAt(r2) == false) goto L16;
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r1 == false) goto L14;
        int r5 = r4.getRight() + r3.rightMargin;
    L15:
        drawVerticalDivider(r8, r5);
        goto L16
    L14:
        r5 = (r4.getLeft() - r3.leftMargin) - this.mDividerWidth;
    L16:
        r2 = r2 + 1;
        goto L4
    L18:
        if (hasDividerBeforeChildAt(r0) == false) goto L36;
        View r6 = getVirtualChildAt(r0 - 1);
        if (r6 != null) goto L24;
        if (r1 == false) goto L23;
        int r7 = getPaddingLeft();
    L29:
        drawVerticalDivider(r8, r7);
        return;
    L23:
        int r9 = getWidth() - getPaddingRight();
        int r10 = this.mDividerWidth;
    L27:
        r7 = r9 - r10;
        goto L29
    L24:
        LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r1 == false) goto L28;
        r9 = r6.getLeft() - r11.leftMargin;
        r10 = this.mDividerWidth;
        goto L27
    L28:
        r7 = r6.getRight() + r11.rightMargin;
        goto L29
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
        return (r4 + ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).topMargin) + r3;
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
    public void onMeasure(int r3, int r4) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r3, r4);
        return;
    L5:
        measureHorizontal(r3, r4);
    }

    public boolean hasDividerBeforeChildAt(int r5) {
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

    void measureVertical(int r33, int r34) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r33);
        int r13 = View.MeasureSpec.getMode(r34);
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
        float r0 = 0.0f;
        boolean r19 = true;
    L3:
        String r10 = "com.obric.aiagent.plugin";
        r1 = r1;
        int r7 = 8;
        r4 = r4;
        if (r6 >= r11) goto L73;
        View r8 = getVirtualChildAt(r6);
        if (r8 != null) goto L9;
        this.mTotalLength += measureNullChild(r6);
    L8:
        int r22 = r11;
    L72:
        r6 = r6 + 1;
        r11 = r22;
        r13 = r13;
        goto L3
    L9:
        int r24 = r2;
        if (r8.getVisibility() != 8) goto L13;
        r6 = r6 + getChildrenSkipCount(r8, r6);
        r2 = r24;
        goto L8
    L13:
        if (hasDividerBeforeChildAt(r6) == false) goto L15;
        this.mTotalLength += this.mDividerHeight;
    L15:
        LayoutParams r16 = (LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        float r25 = r0 + r16.weight;
        if (r13 != 1073741824) goto L23;
        if (r16.height != 0) goto L23;
        if (r16.weight <= 0.0f) goto L23;
        int r9 = this.mTotalLength;
        this.mTotalLength = Math.max(r9, (r16.topMargin + r9) + r16.bottomMargin);
        int r17 = r3;
        View r21 = r8;
        int r30 = r5;
        r13 = r13;
        r18 = true;
        int r23 = r1;
        int r110 = r4;
        int r28 = r24;
        r22 = r11;
        int r111 = r6;
    L39:
        if (r14 >= 0) goto L41;
    L43:
        if (r111 >= r14) goto L50;
        if (r16.weight <= 0.0f) goto L50;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L50:
        if (r12 != 1073741824) goto L52;
    L54:
        boolean r26 = false;
    L55:
        int r27 = r16.leftMargin + r16.rightMargin;
        int r29 = r21.getMeasuredWidth() + r27;
        int r31 = Math.max(r28, r29);
        int r32 = View.combineMeasuredStates(r23, r21.getMeasuredState());
        if (r19 == true) goto L58;
    L60:
        r19 = false;
    L62:
        if (r16.weight <= 0.0f) goto L67;
        if (r26 == true) goto L66;
        r27 = r29;
    L66:
        r4 = Math.max(r110, r27);
        int r35 = r30;
    L71:
        int r36 = getChildrenSkipCount(r21, r111) + r111;
        r3 = r17;
        r0 = r25;
        r5 = r35;
        r1 = r32;
        r6 = r36;
        r2 = r31;
        goto L72
    L67:
        if (r26 == true) goto L70;
        r27 = r29;
    L70:
        r35 = Math.max(r30, r27);
        r4 = r110;
        goto L71
    L58:
        if (r16.width != (-1)) goto L60;
        r19 = true;
        goto L62
    L52:
        if (r16.width != (-1)) goto L54;
        r26 = true;
        r20 = true;
        goto L55
    L41:
        if (r14 != (r111 + 1)) goto L43;
        this.mBaselineChildTop = this.mTotalLength;
    L23:
        if (r16.height == 0) goto L25;
    L27:
        int r37 = Integer.MIN_VALUE;
    L29:
        if (r25 != 0.0f) goto L31;
        int r210 = this.mTotalLength;
    L32:
        r23 = r1;
        int r211 = r37;
        r28 = r24;
        int r38 = r3;
        r13 = r13;
        r110 = r4;
        r22 = r11;
        r30 = r5;
        r111 = r6;
        measureChildBeforeLayout(r8, r6, r33, 0, r34, r210);
        if (r211 == Integer.MIN_VALUE) goto L35;
        r16.height = r211;
    L35:
        int r39 = r8.getMeasuredHeight();
        int r40 = this.mTotalLength;
        r21 = r8;
        this.mTotalLength = Math.max(r40, (((r40 + r39) + r16.topMargin) + r16.bottomMargin) + getNextLocationOffset(r21));
        if (r15 == false) goto L38;
        r17 = Math.max(r39, r38);
        goto L39
    L38:
        r17 = r38;
        goto L39
    L31:
        r210 = 0;
        goto L32
    L25:
        if (r16.weight <= 0.0f) goto L27;
        r16.height = -2;
        r37 = 0;
        goto L29
    L73:
        int r41 = r3;
        int r42 = r5;
        int r212 = r13;
        int r43 = r1;
        int r44 = r2;
        int r213 = r11;
        if (this.mTotalLength <= 0) goto L78;
        int r45 = r213;
        if (hasDividerBeforeChildAt(r45) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r15 == false) goto L96;
        int r46 = r212;
        if (r46 == Integer.MIN_VALUE) goto L85;
        if (r46 == 0) goto L85;
    L84:
        int r214 = r44;
    L97:
        int r47 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r47;
        int r48 = View.resolveSizeAndState(Math.max(r47, getSuggestedMinimumHeight()), r34, 0);
        int r49 = (16777215 & r48) - this.mTotalLength;
        if (r18 == true) goto L119;
        if (r49 != 0) goto L101;
    L103:
        int r50 = Math.max(r42, r4);
        if (r15 == false) goto L164;
        if (r46 == 1073741824) goto L164;
        int r51 = 0;
    L108:
        if (r51 >= r45) goto L164;
        View r52 = getVirtualChildAt(r51);
        if (r52 == null) goto L117;
        if (r52.getVisibility() == 8) goto L117;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r52.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).weight <= 0.0f) goto L117;
        r52.measure(View.MeasureSpec.makeMeasureSpec(r52.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r41, 1073741824));
    L117:
        r51 = r51 + 1;
    L164:
        if (r19 == false) goto L166;
    L168:
        r50 = r214;
    L169:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r50 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r33, r43), r48);
        if (r20 == false) goto L188;
        forceUniformWidth(r45, r34);
        return;
    L188:
        return;
    L166:
        if (r12 == 1073741824) goto L168;
    L101:
        if (r0 <= 0.0f) goto L103;
    L119:
        float r53 = this.mWeightSum;
        if (r53 <= 0.0f) goto L122;
        r0 = r53;
    L122:
        this.mTotalLength = 0;
        int r112 = 0;
        int r113 = r49;
        int r54 = r42;
        int r55 = r214;
    L123:
        if (r112 >= r45) goto L163;
        View r114 = getVirtualChildAt(r112);
        if (r114.getVisibility() != 8) goto L127;
        int r215 = r46;
        r10 = r10;
        int r216 = r113;
    L162:
        r112 = r112 + 1;
        r10 = r10;
        r113 = r216;
        r46 = r215;
        goto L123
    L127:
        LayoutParams r56 = (LayoutParams) ZeusTransformUtils.preCheckCast(r114.getLayoutParams(), LayoutParams.class, r10);
        float r115 = r56.weight;
        if (r115 <= 0.0f) goto L144;
        int r116 = (int) ((r113 * r115) / r0);
        float r57 = r0 - r115;
        r216 = r113 - r116;
        int r58 = getChildMeasureSpec(r33, ((getPaddingLeft() + getPaddingRight()) + r56.leftMargin) + r56.rightMargin, r56.width);
        if (r56.height != 0) goto L138;
        int r117 = 1073741824;
        if (r46 != 1073741824) goto L139;
        if (r116 > 0) goto L137;
        r116 = 0;
    L137:
        r114.measure(r58, View.MeasureSpec.makeMeasureSpec(r116, 1073741824));
    L143:
        r43 = View.combineMeasuredStates(r43, r114.getMeasuredState() & (-256));
        r0 = r57;
    L145:
        int r118 = r56.leftMargin + r56.rightMargin;
        int r119 = r114.getMeasuredWidth() + r118;
        r55 = Math.max(r55, r119);
        float r217 = r0;
        if (r12 == 1073741824) goto L150;
        r215 = r46;
        int r59 = -1;
        if (r56.width != (-1)) goto L151;
        boolean r60 = true;
    L152:
        if (r60 == true) goto L155;
        r118 = r119;
    L155:
        int r61 = Math.max(r54, r118);
        if (r19 == true) goto L158;
    L160:
        boolean r62 = false;
    L161:
        int r120 = this.mTotalLength;
        this.mTotalLength = Math.max(r120, (((r114.getMeasuredHeight() + r120) + r56.topMargin) + r56.bottomMargin) + getNextLocationOffset(r114));
        r19 = r62;
        r54 = r61;
        r0 = r217;
        goto L162
    L158:
        if (r56.width != r59) goto L160;
        r62 = true;
    L151:
        r60 = false;
        goto L152
    L150:
        r215 = r46;
        r59 = -1;
    L139:
        int r121 = r114.getMeasuredHeight() + r116;
        if (r121 >= 0) goto L142;
        r121 = 0;
    L142:
        r114.measure(r58, View.MeasureSpec.makeMeasureSpec(r121, r117));
        goto L143
    L138:
        r117 = 1073741824;
        goto L139
    L144:
        r216 = r113;
        goto L145
    L163:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r214 = r55;
        r50 = r54;
    L85:
        this.mTotalLength = 0;
        int r63 = 0;
    L86:
        if (r63 >= r45) goto L84;
        View r122 = getVirtualChildAt(r63);
        if (r122 != null) goto L91;
        this.mTotalLength += measureNullChild(r63);
    L95:
        r63 = r63 + 1;
        r44 = r44;
        r7 = 8;
        goto L86
    L91:
        if (r122.getVisibility() != r7) goto L94;
        r63 = r63 + getChildrenSkipCount(r122, r63);
        goto L95
    L94:
        LayoutParams r64 = (LayoutParams) ZeusTransformUtils.preCheckCast(r122.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r123 = this.mTotalLength;
        this.mTotalLength = Math.max(r123, (((r123 + r41) + r64.topMargin) + r64.bottomMargin) + getNextLocationOffset(r122));
        goto L95
    L96:
        r214 = r44;
        r46 = r212;
        goto L97
    L78:
        r45 = r213;
        goto L79
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r8.width != (-1)) goto L9;
        int r9 = r8.height;
        r8.height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        r8.height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    void measureHorizontal(int r41, int r42) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r41);
        int r13 = View.MeasureSpec.getMode(r42);
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
        int r26 = 0;
        boolean r28 = false;
        boolean r27 = true;
        float r0 = 0.0f;
    L12:
        int[] r29 = r6;
        String r5 = "com.obric.aiagent.plugin";
        if (r1 >= r11) goto L88;
        View r10 = getVirtualChildAt(r1);
        if (r10 != null) goto L18;
        this.mTotalLength += measureNullChild(r1);
        boolean r33 = r3;
        boolean r38 = r4;
        int r39 = r2;
        int r7 = r1;
        int r8 = r39;
    L87:
        int r9 = r7 + 1;
        r6 = r29;
        r3 = r33;
        r4 = r38;
        r2 = r8;
        r1 = r9;
        goto L12
    L18:
        if (r10.getVisibility() != 8) goto L21;
        r7 = r1 + getChildrenSkipCount(r10, r1);
        r33 = r3;
        r38 = r4;
        r8 = 1073741824;
        goto L87
    L21:
        if (hasDividerBeforeChildAt(r1) == false) goto L23;
        this.mTotalLength += this.mDividerWidth;
    L23:
        LayoutParams r16 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        float r34 = r0 + r16.weight;
        if (r12 != 1073741824) goto L36;
        if (r16.width != 0) goto L36;
        if (r16.weight <= 0.0f) goto L36;
        if (r19 == false) goto L31;
        this.mTotalLength += r16.leftMargin + r16.rightMargin;
    L32:
        if (r4 == false) goto L34;
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r10.measure(r17, r17);
        int r36 = r1;
        r33 = r3;
        r38 = r4;
        LayoutParams r18 = r16;
    L54:
        r8 = 1073741824;
    L55:
        if (r13 != r8) goto L57;
    L59:
        boolean r20 = false;
    L60:
        int r25 = r18.topMargin + r18.bottomMargin;
        int r30 = r10.getMeasuredHeight() + r25;
        r26 = View.combineMeasuredStates(r26, r10.getMeasuredState());
        if (r38 == false) goto L69;
        int r31 = r10.getBaseline();
        if (r31 == (-1)) goto L69;
        if (r18.gravity >= 0) goto L67;
        int r32 = this.mGravity;
    L68:
        int r35 = (((r32 & 112) >> 4) & (-2)) >> 1;
        r15[r35] = Math.max(r15[r35], r31);
        r29[r35] = Math.max(r29[r35], r30 - r31);
        goto L69
    L67:
        r32 = r18.gravity;
    L69:
        r21 = Math.max(r21, r30);
        if (r27 == true) goto L72;
    L74:
        r27 = false;
    L76:
        if (r18.weight <= 0.0f) goto L81;
        if (r20 == true) goto L80;
        r25 = r30;
    L80:
        r23 = Math.max(r23, r25);
    L86:
        int r37 = r36;
        r7 = r37 + getChildrenSkipCount(r10, r37);
        r0 = r34;
        goto L87
    L81:
        int r40 = r23;
        if (r20 == true) goto L85;
        r25 = r30;
    L85:
        r22 = Math.max(r22, r25);
        r23 = r40;
        goto L86
    L72:
        if (r18.height != (-1)) goto L74;
        r27 = true;
        goto L76
    L57:
        if (r18.height != (-1)) goto L59;
        r20 = true;
        r28 = true;
        goto L60
    L34:
        r36 = r1;
        r33 = r3;
        r38 = r4;
        r18 = r16;
        r24 = true;
        r8 = 1073741824;
        goto L55
    L31:
        int r43 = this.mTotalLength;
        this.mTotalLength = Math.max(r43, (r16.leftMargin + r43) + r16.rightMargin);
    L36:
        if (r16.width == 0) goto L38;
    L40:
        byte r44 = -2;
        int r45 = Integer.MIN_VALUE;
    L42:
        if (r34 != 0.0f) goto L44;
        int r310 = this.mTotalLength;
    L45:
        r36 = r1;
        int r311 = r45;
        r33 = r3;
        r38 = r4;
        r18 = r16;
        measureChildBeforeLayout(r10, r36, r41, r310, r42, 0);
        if (r311 == Integer.MIN_VALUE) goto L48;
        r18.width = r311;
    L48:
        int r46 = r10.getMeasuredWidth();
        if (r19 == false) goto L51;
        this.mTotalLength += ((r18.leftMargin + r46) + r18.rightMargin) + getNextLocationOffset(r10);
    L52:
        if (r33 == false) goto L54;
        r14 = Math.max(r46, r14);
        goto L54
    L51:
        int r47 = this.mTotalLength;
        this.mTotalLength = Math.max(r47, (((r47 + r46) + r18.leftMargin) + r18.rightMargin) + getNextLocationOffset(r10));
        goto L52
    L44:
        r310 = 0;
        goto L45
    L38:
        if (r16.weight <= 0.0f) goto L40;
        r44 = -2;
        r16.width = -2;
        r45 = 0;
        goto L42
    L88:
        boolean r312 = r3;
        boolean r313 = r4;
        int r48 = r21;
        int r49 = r22;
        int r50 = r23;
        int r110 = r26;
        if (this.mTotalLength <= 0) goto L94;
        if (hasDividerBeforeChildAt(r11) == false) goto L94;
        this.mTotalLength += this.mDividerWidth;
    L94:
        if (r15[1] == (-1)) goto L96;
    L103:
        int r51 = Math.max(r48, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r29[3], Math.max(r29[0], Math.max(r29[1], r29[2]))));
    L104:
        if (r312 == true) goto L106;
    L122:
        int r210 = r51;
        int r52 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r52;
        int r53 = View.resolveSizeAndState(Math.max(r52, getSuggestedMinimumWidth()), r41, 0);
        int r54 = (16777215 & r53) - this.mTotalLength;
        if (r24 == true) goto L144;
        if (r54 != 0) goto L126;
    L128:
        int r55 = Math.max(r49, r50);
        if (r312 == true) goto L131;
    L143:
        int r314 = r11;
        int r211 = r110;
    L216:
        if (r27 == false) goto L218;
    L220:
        r55 = r210;
    L221:
        setMeasuredDimension(r53 | (r211 & (-16777216)), View.resolveSizeAndState(Math.max(r55 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r42, r211 << 16));
        if (r28 == false) goto L240;
        forceUniformHeight(r314, r41);
        return;
    L240:
        return;
    L218:
        if (r13 == 1073741824) goto L220;
    L131:
        if (r12 == 1073741824) goto L143;
        int r111 = 0;
    L133:
        if (r111 >= r11) goto L143;
        View r56 = getVirtualChildAt(r111);
        if (r56 == null) goto L142;
        if (r56.getVisibility() == 8) goto L142;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r56.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).weight <= 0.0f) goto L142;
        r56.measure(View.MeasureSpec.makeMeasureSpec(r14, 1073741824), View.MeasureSpec.makeMeasureSpec(r56.getMeasuredHeight(), 1073741824));
    L142:
        r111 = r111 + 1;
        goto L133
    L126:
        if (r0 <= 0.0f) goto L128;
    L144:
        float r57 = this.mWeightSum;
        if (r57 <= 0.0f) goto L147;
        r0 = r57;
    L147:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r29[3] = -1;
        r29[2] = -1;
        r29[1] = -1;
        r29[0] = -1;
        this.mTotalLength = 0;
        int r58 = r49;
        int r59 = -1;
        int r112 = r110;
        int r113 = 0;
    L148:
        if (r113 >= r11) goto L204;
        View r60 = getVirtualChildAt(r113);
        if (r60 != null) goto L152;
    L202:
        r5 = r5;
        r11 = r11;
        int r61 = r54;
    L203:
        r113 = r113 + 1;
        r54 = r61;
        r5 = r5;
        r11 = r11;
        goto L148
    L152:
        if (r60.getVisibility() == 8) goto L202;
        LayoutParams r62 = (LayoutParams) ZeusTransformUtils.preCheckCast(r60.getLayoutParams(), LayoutParams.class, r5);
        float r63 = r62.weight;
        if (r63 <= 0.0f) goto L171;
        int r64 = (int) ((r54 * r63) / r0);
        float r65 = r0 - r63;
        int r66 = r54 - r64;
        int r67 = getChildMeasureSpec(r42, ((getPaddingTop() + getPaddingBottom()) + r62.topMargin) + r62.bottomMargin, r62.height);
        if (r62.width != 0) goto L165;
        int r68 = 1073741824;
        if (r12 != 1073741824) goto L166;
        if (r64 > 0) goto L164;
        r64 = 0;
    L164:
        r60.measure(View.MeasureSpec.makeMeasureSpec(r64, 1073741824), r67);
    L170:
        r112 = View.combineMeasuredStates(r112, r60.getMeasuredState() & (-16777216));
        r0 = r65;
        r61 = r66;
    L172:
        if (r19 == false) goto L174;
        this.mTotalLength += ((r60.getMeasuredWidth() + r62.leftMargin) + r62.rightMargin) + getNextLocationOffset(r60);
    L176:
        if (r13 != 1073741824) goto L178;
    L180:
        boolean r69 = false;
    L181:
        int r70 = r62.topMargin + r62.bottomMargin;
        int r114 = r60.getMeasuredHeight() + r70;
        r59 = Math.max(r59, r114);
        if (r69 == true) goto L185;
        r70 = r114;
    L185:
        int r71 = Math.max(r58, r70);
        if (r27 == false) goto L190;
        int r72 = -1;
        if (r62.height != (-1)) goto L191;
        boolean r73 = true;
    L192:
        if (r313 == false) goto L201;
        int r74 = r60.getBaseline();
        if (r74 == r72) goto L201;
        if (r62.gravity >= 0) goto L198;
        int r75 = this.mGravity;
    L199:
        int r76 = (((r75 & 112) >> 4) & (-2)) >> 1;
        r15[r76] = Math.max(r15[r76], r74);
        r29[r76] = Math.max(r29[r76], r114 - r74);
        goto L201
    L198:
        r75 = r62.gravity;
    L201:
        r58 = r71;
        r27 = r73;
        r0 = r0;
    L191:
        r73 = false;
        goto L192
    L190:
        r72 = -1;
        goto L191
    L178:
        if (r62.height != (-1)) goto L180;
        r69 = true;
        goto L181
    L174:
        int r77 = this.mTotalLength;
        this.mTotalLength = Math.max(r77, (((r60.getMeasuredWidth() + r77) + r62.leftMargin) + r62.rightMargin) + getNextLocationOffset(r60));
    L166:
        int r78 = r60.getMeasuredWidth() + r64;
        if (r78 >= 0) goto L169;
        r78 = 0;
    L169:
        r60.measure(View.MeasureSpec.makeMeasureSpec(r78, r68), r67);
        goto L170
    L165:
        r68 = 1073741824;
        goto L166
    L171:
        r61 = r54;
        goto L172
    L204:
        r314 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        if (r15[1] == (-1)) goto L207;
    L214:
        int r79 = Math.max(r59, Math.max(r15[3], Math.max(r15[0], Math.max(r15[1], r15[2]))) + Math.max(r29[3], Math.max(r29[0], Math.max(r29[1], r29[2]))));
    L215:
        r210 = r79;
        r55 = r58;
        r211 = r112;
        goto L216
    L207:
        if (r15[0] != (-1)) goto L214;
        if (r15[2] != (-1)) goto L214;
        if (r15[3] != (-1)) goto L214;
        r79 = r59;
        goto L215
    L106:
        if (r12 == Integer.MIN_VALUE) goto L108;
        if (r12 != 0) goto L122;
    L108:
        this.mTotalLength = 0;
        int r80 = 0;
    L109:
        if (r80 >= r11) goto L122;
        View r81 = getVirtualChildAt(r80);
        if (r81 != null) goto L114;
        this.mTotalLength += measureNullChild(r80);
    L121:
        r80 = r80 + 1;
        r51 = r51;
        goto L109
    L114:
        if (r81.getVisibility() != 8) goto L117;
        r80 = r80 + getChildrenSkipCount(r81, r80);
        goto L121
    L117:
        LayoutParams r82 = (LayoutParams) ZeusTransformUtils.preCheckCast(r81.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r19 == false) goto L120;
        this.mTotalLength += ((r82.leftMargin + r14) + r82.rightMargin) + getNextLocationOffset(r81);
        goto L121
    L120:
        int r83 = this.mTotalLength;
        this.mTotalLength = Math.max(r83, (((r83 + r14) + r82.leftMargin) + r82.rightMargin) + getNextLocationOffset(r81));
        goto L121
    L96:
        if (r15[0] != (-1)) goto L103;
        if (r15[2] != (-1)) goto L103;
        if (r15[3] != (-1)) goto L103;
        r51 = r48;
        goto L104
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
        LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
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
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
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
        int r11 = r1 & 8388615;
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
        LayoutParams r6 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r14 = r6.gravity;
        if (r14 >= 0) goto L19;
        r14 = r11;
    L19:
        int r16 = androidx.core.view.d.a(r14, ViewCompat.i(this)) & 7;
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

    void layoutHorizontal(int r26, int r27, int r28, int r29) {
        boolean r0 = ac.a(this);
        int r7 = getPaddingTop();
        int r1 = r29 - r27;
        int r8 = r1 - getPaddingBottom();
        int r9 = (r1 - r7) - getPaddingBottom();
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & 112;
        boolean r12 = this.mBaselineAligned;
        int[] r13 = this.mMaxAscent;
        int[] r14 = this.mMaxDescent;
        int r3 = androidx.core.view.d.a(8388615 & r2, ViewCompat.i(this));
        char r15 = 2;
        boolean r5 = true;
        if (r3 != 1) goto L5;
        int r4 = getPaddingLeft() + (((r28 - r26) - this.mTotalLength) / 2);
    L10:
        if (r0 == false) goto L12;
        int r16 = r10 - 1;
        int r17 = -1;
    L13:
        int r6 = 0;
    L14:
        if (r6 >= r10) goto L52;
        int r18 = r16 + (r17 * r6);
        View r19 = getVirtualChildAt(r18);
        if (r19 != null) goto L19;
        r4 = r4 + measureNullChild(r18);
        boolean r20 = r5;
        char r21 = r15;
    L51:
        r6 = r6 + 1;
        r10 = r10;
        r11 = r11;
        r5 = r20;
        r15 = r21;
        goto L14
    L19:
        if (r19.getVisibility() == 8) goto L49;
        int r110 = r19.getMeasuredWidth();
        int r22 = r19.getMeasuredHeight();
        int r210 = r6;
        r10 = r10;
        LayoutParams r111 = (LayoutParams) ZeusTransformUtils.preCheckCast(r19.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r12 == true) goto L23;
    L25:
        int r23 = -1;
    L26:
        int r24 = r111.gravity;
        if (r24 >= 0) goto L29;
        r24 = r11;
    L29:
        int r25 = r24 & 112;
        r11 = r11;
        if (r25 != 16) goto L32;
        r20 = true;
        r21 = 2;
        int r30 = ((((r9 - r22) / 2) + r7) + r111.topMargin) - r111.bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r18) == false) goto L48;
        r4 = r4 + this.mDividerWidth;
    L48:
        int r211 = r4 + r111.leftMargin;
        setChildFrame(r19, r211 + getLocationOffset(r19), r30, r110, r22);
        int r212 = r211 + ((r110 + r111.rightMargin) + getNextLocationOffset(r19));
        r6 = r210 + getChildrenSkipCount(r19, r18);
        r4 = r212;
        goto L51
    L32:
        if (r25 != 48) goto L34;
        r30 = r111.topMargin + r7;
        if (r23 == (-1)) goto L42;
        r20 = true;
        r30 = r30 + (r13[1] - r23);
    L43:
        r21 = 2;
    L42:
        r20 = true;
        goto L43
    L34:
        if (r25 == 80) goto L36;
        r30 = r7;
        goto L42
    L36:
        r30 = (r8 - r22) - r111.bottomMargin;
        if (r23 == (-1)) goto L42;
        r30 = r30 - (r14[2] - (r19.getMeasuredHeight() - r23));
        goto L42
    L23:
        if (r111.height == (-1)) goto L25;
        r23 = r19.getBaseline();
        goto L26
    L49:
        r20 = true;
        r21 = 2;
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
        r4 = ((getPaddingLeft() + r28) - r26) - this.mTotalLength;
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
        r2 = r2 | 8388611;
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
        int r4 = r3 & 8388615;
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
        this.mGravity = r4 | (r0 & (-113));
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
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
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
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
