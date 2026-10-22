package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$styleable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {
    private static final int DEFAULT_CHILD_SPACING = 0;
    private static final int DEFAULT_CHILD_SPACING_FOR_LAST_ROW = -65538;
    private static final boolean DEFAULT_FLOW = true;
    private static final int DEFAULT_MAX_ROWS = Integer.MAX_VALUE;
    private static final float DEFAULT_ROW_SPACING = 0.0f;
    private static final boolean DEFAULT_RTL = false;
    private static final String LOG_TAG = "FlowLayout";
    private static final int ROW_VERTICAL_GRAVITY_AUTO = -65536;
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;
    private static final int SPACING_UNDEFINED = -65538;
    private static final int UNSPECIFIED_GRAVITY = -1;
    private float mAdjustedRowSpacing;
    private List<Integer> mChildNumForRow;
    private int mChildSpacing;
    private int mChildSpacingForLastRow;
    private int mChildWidth;
    private int mCurrentRow;
    private int mExactMeasuredHeight;
    private boolean mFlow;
    private int mGravity;
    private List<Integer> mHeightForRow;
    private List<Float> mHorizontalSpacingForRow;
    private int mMaxRows;
    private int mMinChildSpacing;
    private float mRowSpacing;
    private int mRowVerticalGravity;
    private boolean mRtl;
    private int mWidth;
    private List<Integer> mWidthForRow;

    static {
    }

    public FlowLayout(Context r10) {
        this(r10, null);
    }

    private float dpToPx(float r10) {
        return TypedValue.applyDimension(1, r10, getResources().getDisplayMetrics());
    }

    private int getHorizontalGravityOffsetForRow(int r10, int r11, int r12, int r13) {
        if (this.mChildSpacing != (-65536)) goto L5;
        return 0;
    L5:
        if (r13 < this.mWidthForRow.size()) goto L7;
        return 0;
    L7:
        if (r13 < this.mChildNumForRow.size()) goto L9;
        return 0;
    L9:
        if (this.mChildNumForRow.get(r13).intValue() > 0) goto L12;
        return 0;
    L12:
        if (r10 == 1) goto L18;
        if (r10 == 5) goto L22;
        return 0;
    L22:
        return (r11 - r12) - this.mWidthForRow.get(r13).intValue();
    L18:
        return ((r11 - r12) - this.mWidthForRow.get(r13).intValue()) / 2;
    }

    private float getSpacingForRow(int r10, int r11, int r12, int r13) {
        if (r10 != (-65536)) goto L9;
        if (r13 > 1) goto L10;
        return DEFAULT_ROW_SPACING;
    L10:
        return (r11 - r12) / (r13 - 1);
    L9:
        return r10;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new ViewGroup.MarginLayoutParams(r10);
    }

    public int getChildRow(int r10) {
        int r11 = (this.mChildWidth + r10) + (this.mChildSpacing * 2);
        this.mChildWidth = r11;
        if (r11 <= this.mWidth) goto L6;
        this.mCurrentRow++;
        this.mChildWidth = r10;
    L6:
        return this.mCurrentRow;
    }

    public int getChildSpacing() {
        return this.mChildSpacing;
    }

    public int getChildSpacingForLastRow() {
        return this.mChildSpacingForLastRow;
    }

    public int getMaxRows() {
        return this.mMaxRows;
    }

    public int getMinChildSpacing() {
        return this.mMinChildSpacing;
    }

    public float getRowSpacing() {
        return this.mRowSpacing;
    }

    public int getRowsCount() {
        return this.mChildNumForRow.size();
    }

    public boolean isFlow() {
        return this.mFlow;
    }

    public boolean isRtl() {
        return this.mRtl;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        int r10 = getPaddingLeft();
        int r11 = getPaddingRight();
        int r12 = getPaddingTop();
        int r13 = getPaddingBottom();
        if (this.mRtl == false) goto L5;
        int r14 = getWidth() - r11;
    L6:
        int r15 = this.mGravity;
        int r16 = r15 & 112;
        int r17 = r15 & 7;
        if (r16 == 16) goto L12;
        if (r16 != 80) goto L13;
        int r18 = (((r27 - r25) - r12) - r13) - this.mExactMeasuredHeight;
    L11:
        r12 = r12 + r18;
    L13:
        int r19 = r10 + r11;
        int r20 = r26 - r24;
        int r21 = r14 + getHorizontalGravityOffsetForRow(r17, r20, r19, 0);
        int r110 = this.mRowVerticalGravity & 112;
        int r111 = this.mChildNumForRow.size();
        int r112 = 0;
        int r113 = 0;
    L14:
        if (r112 >= r111) goto L45;
        int r114 = this.mChildNumForRow.get(r112).intValue();
        int r115 = this.mHeightForRow.get(r112).intValue();
        float r22 = this.mHorizontalSpacingForRow.get(r112).floatValue();
        int r28 = 0;
    L16:
        r10 = r10;
        if (r28 >= r114) goto L40;
        if (r113 >= getChildCount()) goto L40;
        int r29 = r113 + 1;
        View r116 = getChildAt(r113);
        r113 = r29;
        r111 = r111;
        if (r116.getVisibility() == 8) goto L16;
        int r30 = r28 + 1;
        ViewGroup.LayoutParams r31 = r116.getLayoutParams();
        if ((r31 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
        int r117 = r32.leftMargin;
        int r33 = r32.rightMargin;
        int r34 = r32.topMargin;
        int r35 = r32.bottomMargin;
        int r118 = r33;
        int r119 = r117;
    L27:
        int r36 = r116.getMeasuredWidth();
        int r120 = r116.getMeasuredHeight();
        int r121 = r12 + r34;
        int r210 = r17;
        if (r110 != 80) goto L31;
        int r37 = ((r12 + r115) - r35) - r120;
    L34:
        int r38 = r37 + r120;
        if (this.mRtl == false) goto L38;
        int r39 = r21 - r118;
        r116.layout(r39 - r36, r37, r39, r38);
        float r40 = r21 - (((r36 + r22) + r119) + r118);
    L37:
        r21 = (int) r40;
        r28 = r30;
        r114 = r114;
        r19 = r19;
        r110 = r110;
        r17 = r210;
        goto L16
    L38:
        int r41 = r21 + r119;
        r116.layout(r41, r37, r41 + r36, r38);
        r40 = r21 + (((r36 + r22) + r119) + r118);
        goto L37
    L31:
        if (r110 != 16) goto L33;
        r121 = r121 + ((((r115 - r34) - r35) - r120) / 2);
    L33:
        r37 = r121;
        goto L34
    L26:
        r35 = 0;
        r34 = 0;
        r118 = 0;
        r119 = 0;
    L40:
        int r122 = r19;
        int r211 = r17;
        int r123 = r110;
        int r212 = r111;
        if (this.mRtl == false) goto L43;
        int r42 = getWidth() - r11;
    L44:
        r112 = r112 + 1;
        int r43 = r42 + getHorizontalGravityOffsetForRow(r211, r20, r122, r112);
        r12 = (int) (r12 + (r115 + this.mAdjustedRowSpacing));
        r111 = r212;
        r17 = r211;
        r19 = r122;
        r110 = r123;
        r21 = r43;
        r10 = r10;
        goto L14
    L43:
        r42 = r10;
        goto L44
    L45:
        return;
    L12:
        r18 = ((((r27 - r25) - r12) - r13) - this.mExactMeasuredHeight) / 2;
        goto L11
    L5:
        r14 = r10;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r27, int r28) {
        super.onMeasure(r27, r28);
        int r10 = View.MeasureSpec.getSize(r27);
        int r11 = View.MeasureSpec.getMode(r27);
        int r12 = View.MeasureSpec.getSize(r28);
        int r13 = View.MeasureSpec.getMode(r28);
        this.mHorizontalSpacingForRow.clear();
        this.mHeightForRow.clear();
        this.mWidthForRow.clear();
        this.mChildNumForRow.clear();
        int r14 = getChildCount();
        int r15 = (r10 - getPaddingLeft()) - getPaddingRight();
        if (r11 != 0) goto L5;
    L7:
        boolean r16 = false;
    L8:
        int r17 = this.mChildSpacing;
        int r18 = -65536;
        if (r17 != (-65536)) goto L12;
        if (r11 != 0) goto L12;
        int r19 = 0;
    L13:
        if (r19 != (-65536)) goto L16;
        float r20 = this.mMinChildSpacing;
    L15:
        float r21 = r20;
        int r22 = 0;
        int r23 = 0;
        int r24 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L18:
        if (r24 >= r14) goto L36;
        float r114 = r21;
        View r25 = getChildAt(r24);
        int r26 = r22;
        if (r25.getVisibility() != 8) goto L22;
        r24 = r24;
        int r29 = r19;
        r11 = r11;
        r13 = r13;
        r14 = r14;
        r114 = r114;
        int r30 = -65536;
        int r31 = r23;
        r10 = r10;
        int r32 = r26;
        r12 = r12;
    L35:
        r23 = r31;
        r24 = r24 + 1;
        r19 = r29;
        r22 = r32;
        r18 = r30;
        r21 = r114;
        r10 = r10;
        r12 = r12;
        r11 = r11;
        r14 = r14;
        r13 = r13;
        goto L18
    L22:
        ViewGroup.LayoutParams r33 = r25.getLayoutParams();
        if ((r33 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        View r34 = r25;
        r30 = -65536;
        measureChildWithMargins(r25, r27, 0, r28, r112);
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r33;
        int r36 = r35.leftMargin + r35.rightMargin;
        int r37 = r36;
        int r38 = r35.topMargin + r35.bottomMargin;
    L26:
        r31 = r37 + r34.getMeasuredWidth();
        int r39 = r34.getMeasuredHeight() + r38;
        if (r16 == true) goto L29;
    L34:
        r29 = r19;
        r32 = r26 + 1;
        r111 = (int) (r111 + (r31 + r114));
        r31 = r31 + r23;
        r113 = Math.max(r113, r39);
        goto L35
    L29:
        if ((r111 + r31) <= r15) goto L34;
        r29 = r19;
        this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(r29, r15, r23, r26)));
        this.mChildNumForRow.add(Integer.valueOf(r26));
        this.mHeightForRow.add(Integer.valueOf(r113));
        int r40 = (int) r114;
        this.mWidthForRow.add(Integer.valueOf(r111 - r40));
        if (this.mHorizontalSpacingForRow.size() > this.mMaxRows) goto L33;
        r112 = r112 + r113;
    L33:
        r110 = Math.max(r110, r111);
        r111 = r31 + r40;
        r113 = r39;
        r32 = 1;
        goto L35
    L25:
        r30 = -65536;
        r34 = r25;
        measureChild(r34, r27, r28);
        r37 = 0;
        r38 = 0;
        goto L26
    L36:
        int r115 = r22;
        int r116 = r10;
        int r210 = r11;
        int r211 = r12;
        int r212 = r13;
        int r41 = r23;
        float r117 = r21;
        int r42 = r18;
        int r43 = r113;
        int r44 = r19;
        int r45 = this.mChildSpacingForLastRow;
        if (r45 != (-65537)) goto L43;
        if (this.mHorizontalSpacingForRow.size() < 1) goto L41;
        List<Float> r46 = this.mHorizontalSpacingForRow;
        r46.add(r46.get(r46.size() - 1));
    L46:
        this.mChildNumForRow.add(Integer.valueOf(r115));
        this.mHeightForRow.add(Integer.valueOf(r43));
        this.mWidthForRow.add(Integer.valueOf(r111 - ((int) r117)));
        if (this.mHorizontalSpacingForRow.size() > this.mMaxRows) goto L49;
        r112 = r112 + r43;
    L49:
        int r47 = Math.max(r110, r111);
        if (r44 != r42) goto L52;
        int r48 = r116;
        int r49 = r48;
    L55:
        int r50 = r112 + (getPaddingTop() + getPaddingBottom());
        int r51 = Math.min(this.mHorizontalSpacingForRow.size(), this.mMaxRows);
        float r52 = this.mRowSpacing;
        if (r52 != (-65536.0f)) goto L60;
        if (r212 != 0) goto L60;
        r52 = 0.0f;
    L60:
        if (r52 == (-65536.0f)) goto L62;
        this.mAdjustedRowSpacing = r52;
        if (r51 <= 1) goto L71;
        if (r212 != 0) goto L70;
        r50 = (int) (r50 + (r52 * (r51 - 1)));
        goto L71
    L70:
        int r53 = (int) (r50 + (r52 * (r51 - 1)));
        int r54 = r211;
        r50 = Math.min(r53, r54);
    L72:
        this.mExactMeasuredHeight = r50;
        if (r210 != 1073741824) goto L76;
        int r55 = r49;
    L77:
        if (r212 != 1073741824) goto L79;
        int r56 = r54;
    L80:
        setMeasuredDimension(r55, r56);
        return;
    L79:
        r56 = r50;
        goto L80
    L76:
        r55 = r48;
    L71:
        r54 = r211;
        goto L72
    L62:
        if (r51 <= 1) goto L64;
        this.mAdjustedRowSpacing = (r211 - r50) / (r51 - 1);
    L65:
        r50 = r211;
        r54 = r50;
        goto L72
    L64:
        this.mAdjustedRowSpacing = DEFAULT_ROW_SPACING;
        goto L65
    L52:
        if (r210 != 0) goto L54;
        r48 = (r47 + getPaddingLeft()) + getPaddingRight();
        r49 = r116;
        goto L55
    L54:
        r49 = r116;
        r48 = Math.min((r47 + getPaddingLeft()) + getPaddingRight(), r49);
        goto L55
    L41:
        this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(r44, r15, r41, r115)));
        goto L46
    L43:
        if (r45 == (-65538)) goto L45;
        this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(r45, r15, r41, r115)));
        goto L46
    L45:
        this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(r44, r15, r41, r115)));
        goto L46
    L16:
        r20 = r19;
    L12:
        r19 = r17;
        goto L13
    L5:
        if (this.mFlow == false) goto L7;
        r16 = true;
        goto L8
    }

    public void resetCurrentChildRow() {
        this.mCurrentRow = 1;
        this.mChildWidth = 0;
    }

    public void setChildSpacing(int r10) {
        this.mChildSpacing = r10;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int r10) {
        this.mChildSpacingForLastRow = r10;
        requestLayout();
    }

    public void setFlow(boolean r10) {
        this.mFlow = r10;
        requestLayout();
    }

    public void setGravity(int r10) {
        if (this.mGravity == r10) goto L6;
        this.mGravity = r10;
        requestLayout();
        return;
    }

    public void setMaxRows(int r10) {
        this.mMaxRows = r10;
        requestLayout();
    }

    public void setMinChildSpacing(int r10) {
        this.mMinChildSpacing = r10;
        requestLayout();
    }

    public void setRowSpacing(float r10) {
        this.mRowSpacing = r10;
        requestLayout();
    }

    public void setRowVerticalGravity(int r10) {
        if (this.mRowVerticalGravity == r10) goto L6;
        this.mRowVerticalGravity = r10;
        requestLayout();
        return;
    }

    public void setRtl(boolean r10) {
        this.mRtl = r10;
        requestLayout();
    }

    public FlowLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mFlow = true;
        this.mChildSpacing = 0;
        this.mMinChildSpacing = 0;
        this.mChildSpacingForLastRow = -65538;
        this.mRowSpacing = DEFAULT_ROW_SPACING;
        this.mAdjustedRowSpacing = DEFAULT_ROW_SPACING;
        this.mRtl = false;
        this.mMaxRows = Integer.MAX_VALUE;
        this.mGravity = -1;
        this.mRowVerticalGravity = -65536;
        this.mHorizontalSpacingForRow = new ArrayList();
        this.mHeightForRow = new ArrayList();
        this.mWidthForRow = new ArrayList();
        this.mChildNumForRow = new ArrayList();
        this.mCurrentRow = 1;
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.FlowLayout, 0, 0);
        this.mFlow = r12.getBoolean(R$styleable.FlowLayout_flFlow, true);     // Catch: Throwable -> L6
        this.mChildSpacing = r12.getInt(R$styleable.FlowLayout_flChildSpacing, 0);     // Catch: Throwable -> L6 NumberFormatException -> L8
    L23:
        this.mMinChildSpacing = r12.getInt(R$styleable.FlowLayout_flMinChildSpacing, 0);     // Catch: Throwable -> L6 NumberFormatException -> L11
    L31:
        this.mChildSpacingForLastRow = r12.getInt(R$styleable.FlowLayout_flChildSpacingForLastRow, -65538);     // Catch: Throwable -> L6 NumberFormatException -> L14
    L25:
        this.mRowSpacing = r12.getInt(R$styleable.FlowLayout_flRowSpacing, 0);     // Catch: Throwable -> L6 NumberFormatException -> L17
    L18:
        this.mMaxRows = r12.getInt(R$styleable.FlowLayout_flMaxRows, Integer.MAX_VALUE);     // Catch: Throwable -> L6
        this.mRtl = r12.getBoolean(R$styleable.FlowLayout_flRtl, false);     // Catch: Throwable -> L6
        this.mGravity = r12.getInt(R$styleable.FlowLayout_android_gravity, -1);     // Catch: Throwable -> L6
        this.mRowVerticalGravity = r12.getInt(R$styleable.FlowLayout_flRowVerticalGravity, -65536);     // Catch: Throwable -> L6
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels - (BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.search_recommend_flow_layout_margin_left) * 2);     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L17:
        this.mRowSpacing = r12.getDimension(R$styleable.FlowLayout_flRowSpacing, dpToPx(DEFAULT_ROW_SPACING));     // Catch: Throwable -> L6
        goto L18
    L14:
        this.mChildSpacingForLastRow = r12.getDimensionPixelSize(R$styleable.FlowLayout_flChildSpacingForLastRow, (int) dpToPx(DEFAULT_ROW_SPACING));     // Catch: Throwable -> L6
    L11:
        this.mMinChildSpacing = r12.getDimensionPixelSize(R$styleable.FlowLayout_flMinChildSpacing, (int) dpToPx(DEFAULT_ROW_SPACING));     // Catch: Throwable -> L6
        goto L31
    L8:
        this.mChildSpacing = r12.getDimensionPixelSize(R$styleable.FlowLayout_flChildSpacing, (int) dpToPx(DEFAULT_ROW_SPACING));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
    }
}
