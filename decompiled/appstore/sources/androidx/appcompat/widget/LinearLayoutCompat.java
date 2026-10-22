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
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.primitives.Ints;
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context r10) {
        this(r10, null);
    }

    private void b(int r11, int r12) {
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        View r14 = getVirtualChildAt(r13);
        if (r14.getVisibility() == 8) goto L9;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (((LinearLayout.LayoutParams) r15).width != (-1)) goto L9;
        int r16 = ((LinearLayout.LayoutParams) r15).height;
        ((LinearLayout.LayoutParams) r15).height = r14.getMeasuredHeight();
        measureChildWithMargins(r14, r10, 0, r12, 0);
        ((LinearLayout.LayoutParams) r15).height = r16;
    L9:
        r13 = r13 + 1;
        goto L3
    }

    private void c(View r10, int r11, int r12, int r13, int r14) {
        r10.layout(r11, r12, r13 + r11, r14 + r12);
    }

    public final void a(int r11, int r12) {
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        View r14 = getVirtualChildAt(r13);
        if (r14.getVisibility() == 8) goto L9;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (((LinearLayout.LayoutParams) r15).height != (-1)) goto L9;
        int r16 = ((LinearLayout.LayoutParams) r15).width;
        ((LinearLayout.LayoutParams) r15).width = r14.getMeasuredWidth();
        measureChildWithMargins(r14, r12, 0, r10, 0);
        ((LinearLayout.LayoutParams) r15).width = r16;
    L9:
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas r10) {
        int r11 = getVirtualChildCount();
        boolean r12 = i0.b(this);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L17;
        View r14 = getVirtualChildAt(r13);
        if (r14 == null) goto L15;
        if (r14.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r13) == false) goto L15;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (r12 == false) goto L13;
        int r16 = r14.getRight() + ((LinearLayout.LayoutParams) r15).rightMargin;
    L14:
        drawVerticalDivider(r10, r16);
        goto L15
    L13:
        r16 = (r14.getLeft() - ((LinearLayout.LayoutParams) r15).leftMargin) - this.mDividerWidth;
    L15:
        r13 = r13 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r11) == false) goto L35;
        View r17 = getVirtualChildAt(r11 - 1);
        if (r17 != null) goto L24;
        if (r12 == false) goto L22;
        int r18 = getPaddingLeft();
    L28:
        drawVerticalDivider(r10, r18);
        return;
    L22:
        int r19 = getWidth() - getPaddingRight();
        int r20 = this.mDividerWidth;
    L23:
        r18 = r19 - r20;
        goto L28
    L24:
        LayoutParams r21 = (LayoutParams) r17.getLayoutParams();
        if (r12 == false) goto L27;
        r19 = r17.getLeft() - ((LinearLayout.LayoutParams) r21).leftMargin;
        r20 = this.mDividerWidth;
        goto L23
    L27:
        r18 = r17.getRight() + ((LinearLayout.LayoutParams) r21).rightMargin;
        goto L28
    }

    public void drawDividersVertical(Canvas r10) {
        int r11 = getVirtualChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        View r13 = getVirtualChildAt(r12);
        if (r13 == null) goto L11;
        if (r13.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r12) == false) goto L11;
        drawHorizontalDivider(r10, (r13.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) r13.getLayoutParams())).topMargin) - this.mDividerHeight);
    L11:
        r12 = r12 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r11) == false) goto L25;
        View r14 = getVirtualChildAt(r11 - 1);
        if (r14 != null) goto L17;
        int r15 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r10, r15);
        return;
    L17:
        r15 = r14.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) r14.getLayoutParams())).bottomMargin;
        goto L18
    }

    public void drawHorizontalDivider(Canvas r10, int r11) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r11, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r11);
        this.mDivider.draw(r10);
    }

    public void drawVerticalDivider(Canvas r10, int r11) {
        this.mDivider.setBounds(r11, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r11, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r10);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r10 = getChildCount();
        int r11 = this.mBaselineAlignedChildIndex;
        if (r10 <= r11) goto L29;
        View r12 = getChildAt(r11);
        int r13 = r12.getBaseline();
        if (r13 == (-1)) goto L11;
        int r14 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r15 = this.mGravity & 112;
        if (r15 == 48) goto L27;
        if (r15 != 16) goto L22;
        r14 = r14 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r15 != 80) goto L27;
        r14 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r14 + ((LinearLayout.LayoutParams) ((LayoutParams) r12.getLayoutParams())).topMargin) + r13;
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

    public int getChildrenSkipCount(View r10, int r11) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View r10) {
        return 0;
    }

    public int getNextLocationOffset(View r10) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int r10) {
        return getChildAt(r10);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int r10) {
        if (r10 != 0) goto L9;
        if ((this.mShowDividers & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r10 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) != 0) goto L13;
        return false;
    L13:
        return true;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r11 = r10 - 1;
    L17:
        if (r11 < 0) goto L28;
        if (getChildAt(r11).getVisibility() != 8) goto L27;
        r11 = r11 - 1;
        goto L17
    L27:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r10 = i0.b(this);
        int r11 = getPaddingTop();
        int r12 = r28 - r26;
        int r13 = r12 - getPaddingBottom();
        int r14 = (r12 - r11) - getPaddingBottom();
        int r15 = getVirtualChildCount();
        int r16 = this.mGravity;
        int r17 = r16 & 112;
        boolean r18 = this.mBaselineAligned;
        int[] r19 = this.mMaxAscent;
        int[] r110 = this.mMaxDescent;
        int r20 = androidx.core.view.c.b(8388615 & r16, ViewCompat.A(this));
        boolean r21 = true;
        if (r20 != 1) goto L5;
        int r22 = getPaddingLeft() + (((r27 - r25) - this.mTotalLength) / 2);
    L10:
        if (r10 == false) goto L12;
        int r111 = r15 - 1;
        int r112 = -1;
    L13:
        int r23 = 0;
    L14:
        if (r23 >= r15) goto L52;
        int r24 = r111 + (r112 * r23);
        View r29 = getVirtualChildAt(r24);
        if (r29 != null) goto L20;
        r22 = r22 + measureNullChild(r24);
        boolean r210 = r21;
    L51:
        r23 = r23 + 1;
        r15 = r15;
        r17 = r17;
        r21 = r210;
        r11 = r11;
        goto L14
    L20:
        if (r29.getVisibility() == 8) goto L50;
        int r113 = r29.getMeasuredWidth();
        int r30 = r29.getMeasuredHeight();
        LayoutParams r31 = (LayoutParams) r29.getLayoutParams();
        int r114 = r23;
        if (r18 == false) goto L26;
        r15 = r15;
        if (((LinearLayout.LayoutParams) r31).height == (-1)) goto L27;
        int r115 = r29.getBaseline();
    L28:
        int r32 = ((LinearLayout.LayoutParams) r31).gravity;
        if (r32 >= 0) goto L31;
        r32 = r17;
    L31:
        int r33 = r32 & 112;
        r17 = r17;
        if (r33 != 16) goto L34;
        r210 = true;
        int r34 = ((((r14 - r30) / 2) + r11) + ((LinearLayout.LayoutParams) r31).topMargin) - ((LinearLayout.LayoutParams) r31).bottomMargin;
    L47:
        if (hasDividerBeforeChildAt(r24) == false) goto L49;
        r22 = r22 + this.mDividerWidth;
    L49:
        int r116 = ((LinearLayout.LayoutParams) r31).leftMargin + r22;
        r11 = r11;
        c(r29, r116 + getLocationOffset(r29), r34, r113, r30);
        int r117 = r116 + ((r113 + ((LinearLayout.LayoutParams) r31).rightMargin) + getNextLocationOffset(r29));
        r23 = r114 + getChildrenSkipCount(r29, r24);
        r22 = r117;
        goto L51
    L34:
        if (r33 != 48) goto L36;
        r34 = ((LinearLayout.LayoutParams) r31).topMargin + r11;
        if (r115 != (-1)) goto L44;
    L38:
        r210 = true;
        goto L47
    L44:
        r210 = true;
        r34 = r34 + (r19[1] - r115);
        goto L47
    L36:
        if (r33 == 80) goto L39;
        r34 = r11;
        goto L38
    L39:
        r34 = (r13 - r30) - ((LinearLayout.LayoutParams) r31).bottomMargin;
        if (r115 == (-1)) goto L38;
        r34 = r34 - (r110[2] - (r29.getMeasuredHeight() - r115));
    L27:
        r115 = -1;
        goto L28
    L26:
        r15 = r15;
        goto L27
    L50:
        r210 = true;
        goto L51
    L52:
        return;
    L12:
        r111 = 0;
        r112 = 1;
        goto L13
    L5:
        if (r20 == 5) goto L7;
        r22 = getPaddingLeft();
        goto L10
    L7:
        r22 = ((getPaddingLeft() + r27) - r25) - this.mTotalLength;
        goto L10
    }

    public void layoutVertical(int r18, int r19, int r20, int r21) {
        int r10 = getPaddingLeft();
        int r11 = r20 - r18;
        int r12 = r11 - getPaddingRight();
        int r13 = (r11 - r10) - getPaddingRight();
        int r14 = getVirtualChildCount();
        int r15 = this.mGravity;
        int r16 = r15 & 112;
        int r17 = r15 & 8388615;
        if (r16 != 16) goto L5;
        int r22 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r110 = 0;
    L10:
        if (r110 >= r14) goto L34;
        View r111 = getVirtualChildAt(r110);
        if (r111 != null) goto L16;
        r22 = r22 + measureNullChild(r110);
    L14:
        int r23 = 1;
    L33:
        r110 = r110 + r23;
        goto L10
    L16:
        if (r111.getVisibility() == 8) goto L14;
        int r24 = r111.getMeasuredWidth();
        int r112 = r111.getMeasuredHeight();
        LayoutParams r25 = (LayoutParams) r111.getLayoutParams();
        int r26 = ((LinearLayout.LayoutParams) r25).gravity;
        if (r26 >= 0) goto L20;
        r26 = r17;
    L20:
        int r27 = androidx.core.view.c.b(r26, ViewCompat.A(this)) & 7;
        if (r27 != 1) goto L23;
        int r28 = (((r13 - r24) / 2) + r10) + ((LinearLayout.LayoutParams) r25).leftMargin;
        int r29 = ((LinearLayout.LayoutParams) r25).rightMargin;
    L27:
        int r30 = r28 - r29;
    L25:
        int r31 = r30;
        if (hasDividerBeforeChildAt(r110) == false) goto L32;
        r22 = r22 + this.mDividerHeight;
    L32:
        int r113 = r22 + ((LinearLayout.LayoutParams) r25).topMargin;
        c(r111, r31, r113 + getLocationOffset(r111), r24, r112);
        int r114 = r113 + ((r112 + ((LinearLayout.LayoutParams) r25).bottomMargin) + getNextLocationOffset(r111));
        r110 = r110 + getChildrenSkipCount(r111, r110);
        r22 = r114;
        r23 = 1;
        goto L33
    L23:
        if (r27 == 5) goto L26;
        r30 = ((LinearLayout.LayoutParams) r25).leftMargin + r10;
        goto L25
    L26:
        r28 = r12 - r24;
        r29 = ((LinearLayout.LayoutParams) r25).rightMargin;
        goto L27
    L34:
        return;
    L5:
        if (r16 == 80) goto L7;
        r22 = getPaddingTop();
        goto L9
    L7:
        r22 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    public void measureChildBeforeLayout(View r10, int r11, int r12, int r13, int r14, int r15) {
        measureChildWithMargins(r10, r12, r13, r14, r15);
    }

    public void measureHorizontal(int r40, int r41) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r40);
        int r13 = View.MeasureSpec.getMode(r41);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r15 = this.mMaxAscent;
        int[] r10 = this.mMaxDescent;
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r10[3] = -1;
        r10[2] = -1;
        r10[1] = -1;
        r10[0] = -1;
        boolean r14 = this.mBaselineAligned;
        boolean r16 = this.mUseLargestChild;
        int r17 = Ints.MAX_POWER_OF_TWO;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        int r18 = 0;
        int r110 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        boolean r24 = false;
        int r25 = 0;
        boolean r27 = false;
        boolean r26 = true;
        float r20 = 0.0f;
    L12:
        int[] r28 = r10;
        if (r18 >= r11) goto L89;
        View r29 = getVirtualChildAt(r18);
        if (r29 != null) goto L19;
        this.mTotalLength += measureNullChild(r18);
    L17:
        boolean r33 = r16;
        boolean r37 = r14;
        int r38 = r17;
        int r30 = r18;
        int r31 = r38;
    L88:
        int r32 = r30 + 1;
        r10 = r28;
        r16 = r33;
        r14 = r37;
        r17 = r31;
        r18 = r32;
        goto L12
    L19:
        if (r29.getVisibility() != 8) goto L22;
        r18 = r18 + getChildrenSkipCount(r29, r18);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r18) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r111 = (LayoutParams) r29.getLayoutParams();
        float r34 = ((LinearLayout.LayoutParams) r111).weight;
        float r35 = r20 + r34;
        if (r12 != r17) goto L37;
        if (((LinearLayout.LayoutParams) r111).width != 0) goto L37;
        if (r34 <= 0.0f) goto L37;
        if (r19 == false) goto L32;
        this.mTotalLength += ((LinearLayout.LayoutParams) r111).leftMargin + ((LinearLayout.LayoutParams) r111).rightMargin;
    L33:
        if (r14 == false) goto L35;
        int r36 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r29.measure(r36, r36);
        int r39 = r18;
        r33 = r16;
        r37 = r14;
        View r42 = r29;
    L55:
        r31 = Ints.MAX_POWER_OF_TWO;
    L56:
        if (r13 != r31) goto L58;
    L60:
        boolean r43 = false;
    L61:
        int r44 = ((LinearLayout.LayoutParams) r111).topMargin + ((LinearLayout.LayoutParams) r111).bottomMargin;
        int r45 = r42.getMeasuredHeight() + r44;
        r25 = View.combineMeasuredStates(r25, r42.getMeasuredState());
        if (r37 == false) goto L69;
        int r46 = r42.getBaseline();
        if (r46 == (-1)) goto L69;
        int r47 = ((LinearLayout.LayoutParams) r111).gravity;
        if (r47 >= 0) goto L68;
        r47 = this.mGravity;
    L68:
        int r48 = (((r47 & 112) >> 4) & (-2)) >> 1;
        r15[r48] = Math.max(r15[r48], r46);
        r28[r48] = Math.max(r28[r48], r45 - r46);
    L69:
        r21 = Math.max(r21, r45);
        if (r26 == true) goto L72;
    L74:
        r26 = false;
    L76:
        if (((LinearLayout.LayoutParams) r111).weight <= 0.0f) goto L82;
        if (r43 == true) goto L80;
        r44 = r45;
    L80:
        r23 = Math.max(r23, r44);
    L81:
        int r112 = r39;
        r30 = getChildrenSkipCount(r42, r112) + r112;
        r20 = r35;
        goto L88
    L82:
        int r113 = r23;
        if (r43 == true) goto L86;
        r44 = r45;
    L86:
        r22 = Math.max(r22, r44);
        r23 = r113;
        goto L81
    L72:
        if (((LinearLayout.LayoutParams) r111).height != (-1)) goto L74;
        r26 = true;
        goto L76
    L58:
        if (((LinearLayout.LayoutParams) r111).height != (-1)) goto L60;
        r43 = true;
        r27 = true;
        goto L61
    L35:
        r39 = r18;
        r33 = r16;
        r37 = r14;
        r42 = r29;
        r24 = true;
        r31 = Ints.MAX_POWER_OF_TWO;
        goto L56
    L32:
        int r49 = this.mTotalLength;
        this.mTotalLength = Math.max(r49, (((LinearLayout.LayoutParams) r111).leftMargin + r49) + ((LinearLayout.LayoutParams) r111).rightMargin);
    L37:
        if (((LinearLayout.LayoutParams) r111).width == 0) goto L39;
    L41:
        byte r50 = -2;
        int r51 = Integer.MIN_VALUE;
    L43:
        if (r35 != 0.0f) goto L45;
        int r210 = this.mTotalLength;
    L46:
        r39 = r18;
        int r310 = r51;
        r33 = r16;
        r37 = r14;
        measureChildBeforeLayout(r29, r39, r40, r210, r41, 0);
        if (r310 == Integer.MIN_VALUE) goto L49;
        ((LinearLayout.LayoutParams) r111).width = r310;
    L49:
        int r52 = r29.getMeasuredWidth();
        if (r19 == false) goto L52;
        r42 = r29;
        this.mTotalLength = this.mTotalLength + (((((LinearLayout.LayoutParams) r111).leftMargin + r52) + ((LinearLayout.LayoutParams) r111).rightMargin) + getNextLocationOffset(r42));
    L53:
        if (r33 == false) goto L55;
        r110 = Math.max(r52, r110);
        goto L55
    L52:
        r42 = r29;
        int r53 = this.mTotalLength;
        this.mTotalLength = Math.max(r53, (((r53 + r52) + ((LinearLayout.LayoutParams) r111).leftMargin) + ((LinearLayout.LayoutParams) r111).rightMargin) + getNextLocationOffset(r42));
        goto L53
    L45:
        r210 = 0;
        goto L46
    L39:
        if (r34 <= 0.0f) goto L41;
        r50 = -2;
        ((LinearLayout.LayoutParams) r111).width = -2;
        r51 = 0;
        goto L43
    L89:
        boolean r311 = r16;
        boolean r312 = r14;
        int r54 = r21;
        int r55 = r22;
        int r114 = r23;
        int r56 = r25;
        if (this.mTotalLength > 0) goto L92;
    L94:
        int r57 = r15[1];
        if (r57 == (-1)) goto L97;
    L104:
        int r58 = Math.max(r54, Math.max(r15[3], Math.max(r15[0], Math.max(r57, r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L105:
        if (r311 == true) goto L107;
    L110:
        int r211 = r58;
        int r59 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r59;
        int r60 = View.resolveSizeAndState(Math.max(r59, getSuggestedMinimumWidth()), r40, 0);
        int r61 = (16777215 & r60) - this.mTotalLength;
        if (r24 == true) goto L147;
        if (r61 != 0) goto L129;
    L131:
        int r62 = Math.max(r55, r114);
        if (r311 == true) goto L134;
    L146:
        int r212 = r11;
        int r63 = r56;
    L216:
        if (r26 == false) goto L218;
    L220:
        r62 = r211;
    L221:
        setMeasuredDimension(r60 | ((-16777216) & r63), View.resolveSizeAndState(Math.max(r62 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r41, r63 << 16));
        if (r27 == false) goto L239;
        a(r212, r40);
        return;
    L239:
        return;
    L218:
        if (r13 == 1073741824) goto L220;
    L134:
        if (r12 == 1073741824) goto L146;
        int r115 = 0;
    L136:
        if (r115 >= r11) goto L146;
        View r64 = getVirtualChildAt(r115);
        if (r64 == null) goto L145;
        if (r64.getVisibility() == 8) goto L145;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r64.getLayoutParams())).weight <= 0.0f) goto L145;
        r64.measure(View.MeasureSpec.makeMeasureSpec(r110, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r64.getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
    L145:
        r115 = r115 + 1;
        goto L136
    L129:
        if (r20 <= 0.0f) goto L131;
    L147:
        float r65 = this.mWeightSum;
        if (r65 <= 0.0f) goto L150;
        r20 = r65;
    L150:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r28[3] = -1;
        r28[2] = -1;
        r28[1] = -1;
        r28[0] = -1;
        this.mTotalLength = 0;
        int r66 = r55;
        int r67 = -1;
        r63 = r56;
        int r116 = 0;
    L151:
        if (r116 >= r11) goto L204;
        View r117 = getVirtualChildAt(r116);
        if (r117 != null) goto L155;
    L156:
        int r68 = r61;
        r11 = r11;
    L203:
        r116 = r116 + 1;
        r61 = r68;
        r11 = r11;
        goto L151
    L155:
        if (r117.getVisibility() == 8) goto L156;
        LayoutParams r69 = (LayoutParams) r117.getLayoutParams();
        float r70 = ((LinearLayout.LayoutParams) r69).weight;
        if (r70 <= 0.0f) goto L174;
        int r71 = (int) ((r61 * r70) / r20);
        float r72 = r20 - r70;
        int r73 = r61 - r71;
        int r74 = ViewGroup.getChildMeasureSpec(r41, ((getPaddingTop() + getPaddingBottom()) + ((LinearLayout.LayoutParams) r69).topMargin) + ((LinearLayout.LayoutParams) r69).bottomMargin, ((LinearLayout.LayoutParams) r69).height);
        if (((LinearLayout.LayoutParams) r69).width != 0) goto L168;
        int r75 = Ints.MAX_POWER_OF_TWO;
        if (r12 != 1073741824) goto L169;
        if (r71 > 0) goto L167;
        r71 = 0;
    L167:
        r117.measure(View.MeasureSpec.makeMeasureSpec(r71, Ints.MAX_POWER_OF_TWO), r74);
    L173:
        r63 = View.combineMeasuredStates(r63, r117.getMeasuredState() & (-16777216));
        r20 = r72;
        r68 = r73;
    L175:
        if (r19 == false) goto L178;
        this.mTotalLength += ((r117.getMeasuredWidth() + ((LinearLayout.LayoutParams) r69).leftMargin) + ((LinearLayout.LayoutParams) r69).rightMargin) + getNextLocationOffset(r117);
    L179:
        if (r13 != 1073741824) goto L181;
    L183:
        boolean r76 = false;
    L184:
        int r77 = ((LinearLayout.LayoutParams) r69).topMargin + ((LinearLayout.LayoutParams) r69).bottomMargin;
        int r118 = r117.getMeasuredHeight() + r77;
        r67 = Math.max(r67, r118);
        if (r76 == true) goto L188;
        r77 = r118;
    L188:
        int r78 = Math.max(r66, r77);
        if (r26 == false) goto L193;
        int r79 = -1;
        if (((LinearLayout.LayoutParams) r69).height != (-1)) goto L194;
        boolean r80 = true;
    L195:
        if (r312 == false) goto L202;
        int r119 = r117.getBaseline();
        if (r119 == r79) goto L202;
        int r81 = ((LinearLayout.LayoutParams) r69).gravity;
        if (r81 >= 0) goto L201;
        r81 = this.mGravity;
    L201:
        int r82 = (((r81 & 112) >> 4) & (-2)) >> 1;
        r15[r82] = Math.max(r15[r82], r119);
        r28[r82] = Math.max(r28[r82], r118 - r119);
    L202:
        r26 = r80;
        r66 = r78;
        r20 = r20;
    L194:
        r80 = false;
        goto L195
    L193:
        r79 = -1;
        goto L194
    L181:
        if (((LinearLayout.LayoutParams) r69).height != (-1)) goto L183;
        r76 = true;
        goto L184
    L178:
        int r83 = this.mTotalLength;
        this.mTotalLength = Math.max(r83, (((r117.getMeasuredWidth() + r83) + ((LinearLayout.LayoutParams) r69).leftMargin) + ((LinearLayout.LayoutParams) r69).rightMargin) + getNextLocationOffset(r117));
    L169:
        int r84 = r117.getMeasuredWidth() + r71;
        if (r84 >= 0) goto L172;
        r84 = 0;
    L172:
        r117.measure(View.MeasureSpec.makeMeasureSpec(r84, r75), r74);
        goto L173
    L168:
        r75 = Ints.MAX_POWER_OF_TWO;
        goto L169
    L174:
        r68 = r61;
        goto L175
    L204:
        r212 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int r85 = r15[1];
        if (r85 == (-1)) goto L207;
    L214:
        int r86 = Math.max(r67, Math.max(r15[3], Math.max(r15[0], Math.max(r85, r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L215:
        r211 = r86;
        r62 = r66;
        goto L216
    L207:
        if (r15[0] != (-1)) goto L214;
        if (r15[2] != (-1)) goto L214;
        if (r15[3] != (-1)) goto L214;
        r86 = r67;
        goto L215
    L107:
        if (r12 == Integer.MIN_VALUE) goto L111;
        if (r12 != 0) goto L110;
    L111:
        this.mTotalLength = 0;
        int r87 = 0;
    L112:
        if (r87 >= r11) goto L110;
        View r88 = getVirtualChildAt(r87);
        if (r88 != null) goto L117;
        this.mTotalLength += measureNullChild(r87);
    L124:
        r87 = r87 + 1;
        r58 = r58;
        goto L112
    L117:
        if (r88.getVisibility() != 8) goto L120;
        r87 = r87 + getChildrenSkipCount(r88, r87);
        goto L124
    L120:
        LayoutParams r89 = (LayoutParams) r88.getLayoutParams();
        if (r19 == false) goto L123;
        this.mTotalLength += ((((LinearLayout.LayoutParams) r89).leftMargin + r110) + ((LinearLayout.LayoutParams) r89).rightMargin) + getNextLocationOffset(r88);
        goto L124
    L123:
        int r90 = this.mTotalLength;
        this.mTotalLength = Math.max(r90, (((r90 + r110) + ((LinearLayout.LayoutParams) r89).leftMargin) + ((LinearLayout.LayoutParams) r89).rightMargin) + getNextLocationOffset(r88));
        goto L124
    L97:
        if (r15[0] != (-1)) goto L104;
        if (r15[2] != (-1)) goto L104;
        if (r15[3] != (-1)) goto L104;
        r58 = r54;
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

    public int measureNullChild(int r10) {
        return 0;
    }

    public void measureVertical(int r34, int r35) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r34);
        int r13 = View.MeasureSpec.getMode(r35);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        int r10 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        boolean r110 = false;
        boolean r21 = false;
        boolean r111 = true;
        float r22 = 0.0f;
    L3:
        int r112 = 8;
        int r23 = r18;
        if (r20 >= r11) goto L71;
        View r24 = getVirtualChildAt(r20);
        if (r24 != null) goto L8;
        this.mTotalLength += measureNullChild(r20);
        int r25 = r13;
        r18 = r23;
        int r26 = r11;
    L70:
        r20 = r20 + 1;
        r11 = r26;
        r13 = r25;
        goto L3
    L8:
        int r27 = r10;
        if (r24.getVisibility() != 8) goto L12;
        r20 = r20 + getChildrenSkipCount(r24, r20);
        r18 = r23;
        r10 = r27;
        r26 = r11;
        r25 = r13;
        goto L70
    L12:
        if (hasDividerBeforeChildAt(r20) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r113 = (LayoutParams) r24.getLayoutParams();
        float r28 = ((LinearLayout.LayoutParams) r113).weight;
        float r29 = r22 + r28;
        if (r13 == 1073741824) goto L17;
    L21:
        int r210 = r16;
        if (((LinearLayout.LayoutParams) r113).height == 0) goto L24;
    L26:
        int r30 = Integer.MIN_VALUE;
    L28:
        if (r29 != 0.0f) goto L30;
        int r211 = this.mTotalLength;
    L31:
        int r31 = r27;
        int r32 = r30;
        int r212 = r210;
        int r33 = r17;
        r25 = r13;
        int r114 = r23;
        r26 = r11;
        int r36 = r19;
        int r115 = r20;
        measureChildBeforeLayout(r24, r20, r34, 0, r35, r211);
        if (r32 == Integer.MIN_VALUE) goto L34;
        ((LinearLayout.LayoutParams) r113).height = r32;
    L34:
        int r37 = r24.getMeasuredHeight();
        int r38 = this.mTotalLength;
        View r39 = r24;
        this.mTotalLength = Math.max(r38, (((r38 + r37) + ((LinearLayout.LayoutParams) r113).topMargin) + ((LinearLayout.LayoutParams) r113).bottomMargin) + getNextLocationOffset(r39));
        if (r15 == false) goto L37;
        int r40 = Math.max(r37, r33);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r115 >= r14) goto L48;
        if (((LinearLayout.LayoutParams) r113).weight <= 0.0f) goto L48;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L48:
        if (r12 != 1073741824) goto L50;
    L52:
        boolean r41 = false;
    L53:
        int r42 = ((LinearLayout.LayoutParams) r113).leftMargin + ((LinearLayout.LayoutParams) r113).rightMargin;
        int r43 = r39.getMeasuredWidth() + r42;
        int r44 = Math.max(r212, r43);
        int r45 = View.combineMeasuredStates(r31, r39.getMeasuredState());
        if (r111 == true) goto L56;
    L58:
        r111 = false;
    L60:
        if (((LinearLayout.LayoutParams) r113).weight <= 0.0f) goto L65;
        if (r41 == true) goto L64;
        r42 = r43;
    L64:
        r18 = Math.max(r114, r42);
    L69:
        int r46 = getChildrenSkipCount(r39, r115) + r115;
        r17 = r40;
        r16 = r44;
        r22 = r29;
        r19 = r36;
        r20 = r46;
        r10 = r45;
        goto L70
    L65:
        if (r41 == true) goto L68;
        r42 = r43;
    L68:
        r36 = Math.max(r36, r42);
        r18 = r114;
        goto L69
    L56:
        if (((LinearLayout.LayoutParams) r113).width != (-1)) goto L58;
        r111 = true;
        goto L60
    L50:
        if (((LinearLayout.LayoutParams) r113).width != (-1)) goto L52;
        r41 = true;
        r21 = true;
        goto L53
    L40:
        if (r14 != (r115 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r40 = r33;
        goto L38
    L30:
        r211 = 0;
        goto L31
    L24:
        if (r28 <= 0.0f) goto L26;
        ((LinearLayout.LayoutParams) r113).height = -2;
        r30 = 0;
        goto L28
    L17:
        if (((LinearLayout.LayoutParams) r113).height != 0) goto L21;
        if (r28 <= 0.0f) goto L21;
        int r47 = this.mTotalLength;
        this.mTotalLength = Math.max(r47, (((LinearLayout.LayoutParams) r113).topMargin + r47) + ((LinearLayout.LayoutParams) r113).bottomMargin);
        r40 = r17;
        r39 = r24;
        r36 = r19;
        r110 = true;
        r31 = r27;
        r212 = r16;
        r25 = r13;
        r114 = r23;
        r26 = r11;
        r115 = r20;
        goto L38
    L71:
        int r48 = r10;
        int r49 = r17;
        int r50 = r19;
        int r213 = r13;
        int r51 = r16;
        int r214 = r11;
        if (this.mTotalLength <= 0) goto L76;
        int r52 = r214;
        if (hasDividerBeforeChildAt(r52) == false) goto L78;
        this.mTotalLength += this.mDividerHeight;
    L78:
        if (r15 == true) goto L80;
    L92:
        int r53 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r53;
        int r54 = View.resolveSizeAndState(Math.max(r53, getSuggestedMinimumHeight()), r35, 0);
        int r55 = (16777215 & r54) - this.mTotalLength;
        if (r110 == true) goto L114;
        if (r55 != 0) goto L96;
    L98:
        int r56 = Math.max(r50, r23);
        if (r15 == true) goto L101;
    L113:
        int r57 = r48;
    L156:
        if (r111 == false) goto L158;
    L160:
        r56 = r51;
    L161:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r56 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r34, r57), r54);
        if (r21 == false) goto L182;
        b(r52, r35);
        return;
    L182:
        return;
    L158:
        if (r12 == 1073741824) goto L160;
    L101:
        if (r213 == 1073741824) goto L113;
        int r58 = 0;
    L103:
        if (r58 >= r52) goto L113;
        View r59 = getVirtualChildAt(r58);
        if (r59 == null) goto L112;
        if (r59.getVisibility() == 8) goto L112;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r59.getLayoutParams())).weight <= 0.0f) goto L112;
        r59.measure(View.MeasureSpec.makeMeasureSpec(r59.getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r49, Ints.MAX_POWER_OF_TWO));
    L112:
        r58 = r58 + 1;
        goto L103
    L96:
        if (r22 <= 0.0f) goto L98;
    L114:
        float r116 = this.mWeightSum;
        if (r116 <= 0.0f) goto L117;
        r22 = r116;
    L117:
        this.mTotalLength = 0;
        int r117 = r55;
        int r60 = r50;
        r57 = r48;
        int r61 = 0;
    L118:
        if (r61 >= r52) goto L155;
        View r118 = getVirtualChildAt(r61);
        if (r118.getVisibility() != 8) goto L122;
        int r215 = r117;
    L154:
        r61 = r61 + 1;
        r117 = r215;
        goto L118
    L122:
        LayoutParams r119 = (LayoutParams) r118.getLayoutParams();
        float r120 = ((LinearLayout.LayoutParams) r119).weight;
        if (r120 <= 0.0f) goto L139;
        int r121 = (int) ((r117 * r120) / r22);
        float r62 = r22 - r120;
        r215 = r117 - r121;
        int r63 = ViewGroup.getChildMeasureSpec(r34, ((getPaddingLeft() + getPaddingRight()) + ((LinearLayout.LayoutParams) r119).leftMargin) + ((LinearLayout.LayoutParams) r119).rightMargin, ((LinearLayout.LayoutParams) r119).width);
        if (((LinearLayout.LayoutParams) r119).height != 0) goto L133;
        int r122 = Ints.MAX_POWER_OF_TWO;
        if (r213 != 1073741824) goto L134;
        if (r121 > 0) goto L132;
        r121 = 0;
    L132:
        r118.measure(r63, View.MeasureSpec.makeMeasureSpec(r121, Ints.MAX_POWER_OF_TWO));
    L138:
        r57 = View.combineMeasuredStates(r57, r118.getMeasuredState() & (-256));
        r22 = r62;
    L140:
        int r123 = ((LinearLayout.LayoutParams) r119).leftMargin + ((LinearLayout.LayoutParams) r119).rightMargin;
        int r124 = r118.getMeasuredWidth() + r123;
        r51 = Math.max(r51, r124);
        float r125 = r22;
        if (r12 == 1073741824) goto L145;
        int r216 = r57;
        int r64 = -1;
        if (((LinearLayout.LayoutParams) r119).width == (-1)) goto L147;
    L146:
        r123 = r124;
    L147:
        int r65 = Math.max(r60, r123);
        if (r111 == true) goto L150;
    L152:
        boolean r66 = false;
    L153:
        int r126 = this.mTotalLength;
        this.mTotalLength = Math.max(r126, (((r118.getMeasuredHeight() + r126) + ((LinearLayout.LayoutParams) r119).topMargin) + ((LinearLayout.LayoutParams) r119).bottomMargin) + getNextLocationOffset(r118));
        r111 = r66;
        r57 = r216;
        r60 = r65;
        r22 = r125;
        goto L154
    L150:
        if (((LinearLayout.LayoutParams) r119).width != r64) goto L152;
        r66 = true;
        goto L153
    L145:
        r216 = r57;
        r64 = -1;
    L134:
        int r127 = r118.getMeasuredHeight() + r121;
        if (r127 >= 0) goto L137;
        r127 = 0;
    L137:
        r118.measure(r63, View.MeasureSpec.makeMeasureSpec(r127, r122));
        goto L138
    L133:
        r122 = Ints.MAX_POWER_OF_TWO;
        goto L134
    L139:
        r215 = r117;
        goto L140
    L155:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r56 = r60;
        goto L156
    L80:
        if (r213 == Integer.MIN_VALUE) goto L82;
        if (r213 != 0) goto L92;
    L82:
        this.mTotalLength = 0;
        int r67 = 0;
    L83:
        if (r67 >= r52) goto L92;
        View r68 = getVirtualChildAt(r67);
        if (r68 != null) goto L88;
        this.mTotalLength += measureNullChild(r67);
    L91:
        r67 = r67 + 1;
        r112 = 8;
        goto L83
    L88:
        if (r68.getVisibility() != r112) goto L90;
        r67 = r67 + getChildrenSkipCount(r68, r67);
        goto L91
    L90:
        LayoutParams r128 = (LayoutParams) r68.getLayoutParams();
        int r129 = this.mTotalLength;
        this.mTotalLength = Math.max(r129, (((r129 + r49) + ((LinearLayout.LayoutParams) r128).topMargin) + ((LinearLayout.LayoutParams) r128).bottomMargin) + getNextLocationOffset(r68));
        goto L91
    L76:
        r52 = r214;
        goto L78
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r10);
        return;
    L8:
        drawDividersHorizontal(r10);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r11, r12, r13, r14);
        return;
    L5:
        layoutHorizontal(r11, r12, r13, r14);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r10, r11);
        return;
    L5:
        measureHorizontal(r10, r11);
    }

    public void setBaselineAligned(boolean r10) {
        this.mBaselineAligned = r10;
    }

    public void setBaselineAlignedChildIndex(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r10;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r10) {
        if (r10 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r10;
        boolean r11 = false;
        if (r10 == null) goto L8;
        this.mDividerWidth = r10.getIntrinsicWidth();
        this.mDividerHeight = r10.getIntrinsicHeight();
    L9:
        if (r10 != null) goto L11;
        r11 = true;
    L11:
        setWillNotDraw(r11);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r10) {
        this.mDividerPadding = r10;
    }

    public void setGravity(@GravityInt int r10) {
        if (this.mGravity != r10) goto L5;
        return;
    L5:
        if ((8388615 & r10) != 0) goto L8;
        r10 = r10 | 8388611;
    L8:
        if ((r10 & 112) != 0) goto L10;
        r10 = r10 | 48;
    L10:
        this.mGravity = r10;
        requestLayout();
    }

    public void setHorizontalGravity(int r10) {
        int r11 = r10 & 8388615;
        int r12 = this.mGravity;
        if ((8388615 & r12) == r11) goto L6;
        this.mGravity = r11 | ((-8388616) & r12);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r10) {
        this.mUseLargestChild = r10;
    }

    public void setOrientation(int r10) {
        if (this.mOrientation == r10) goto L6;
        this.mOrientation = r10;
        requestLayout();
        return;
    }

    public void setShowDividers(int r10) {
        if (r10 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r10;
    }

    public void setVerticalGravity(int r10) {
        int r11 = r10 & 112;
        int r12 = this.mGravity;
        if ((r12 & 112) == r11) goto L6;
        this.mGravity = r11 | (r12 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    public void setWeightSum(float r10) {
        this.mWeightSum = Math.max(0.0f, r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r10 = this.mOrientation;
        if (r10 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r10 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    public LinearLayoutCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        int[] r10 = R$styleable.LinearLayoutCompat;
        b0 r11 = b0.v(r12, r13, r10, r14, 0);
        ViewCompat.n0(this, r12, r10, r13, r11.r(), r14, 0);
        int r15 = r11.k(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (r15 < 0) goto L5;
        setOrientation(r15);
    L5:
        int r16 = r11.k(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (r16 < 0) goto L8;
        setGravity(r16);
    L8:
        boolean r17 = r11.a(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (r17 == true) goto L11;
        setBaselineAligned(r17);
    L11:
        this.mWeightSum = r11.i(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = r11.k(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = r11.a(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(r11.g(R$styleable.LinearLayoutCompat_divider));
        this.mShowDividers = r11.k(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = r11.f(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        r11.w();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }
}
