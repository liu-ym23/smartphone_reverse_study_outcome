package com.android.contacts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class InterpolatingLayout extends ViewGroup {
    private Rect mInRect;
    private Rect mOutRect;

    public static final class LayoutParams extends LinearLayout.LayoutParams {
        private int leftMarginConstant;
        private float leftMarginMultiplier;
        private int leftPaddingConstant;
        private float leftPaddingMultiplier;
        public int narrowMarginLeft;
        public int narrowMarginRight;
        public int narrowPaddingLeft;
        public int narrowPaddingRight;
        public int narrowParentWidth;
        public int narrowWidth;
        private int rightMarginConstant;
        private float rightMarginMultiplier;
        private int rightPaddingConstant;
        private float rightPaddingMultiplier;
        public int wideMarginLeft;
        public int wideMarginRight;
        public int widePaddingLeft;
        public int widePaddingRight;
        public int wideParentWidth;
        public int wideWidth;
        private int widthConstant;
        private float widthMultiplier;

        public LayoutParams(Context r4, AttributeSet r5) {
            super(r4, r5);
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.InterpolatingLayout_Layout);
            this.narrowParentWidth = r6.getDimensionPixelSize(4, -1);
            this.narrowWidth = r6.getDimensionPixelSize(5, -1);
            this.narrowMarginLeft = r6.getDimensionPixelSize(0, -1);
            this.narrowPaddingLeft = r6.getDimensionPixelSize(2, -1);
            this.narrowMarginRight = r6.getDimensionPixelSize(1, -1);
            this.narrowPaddingRight = r6.getDimensionPixelSize(3, -1);
            this.wideParentWidth = r6.getDimensionPixelSize(10, -1);
            this.wideWidth = r6.getDimensionPixelSize(11, -1);
            this.wideMarginLeft = r6.getDimensionPixelSize(6, -1);
            this.widePaddingLeft = r6.getDimensionPixelSize(8, -1);
            this.wideMarginRight = r6.getDimensionPixelSize(7, -1);
            this.widePaddingRight = r6.getDimensionPixelSize(9, -1);
            r6.recycle();
            int r7 = this.narrowWidth;
            if (r7 == (-1)) goto L5;
            float r8 = this.wideWidth - r7;
            int r1 = this.wideParentWidth;
            int r2 = this.narrowParentWidth;
            float r9 = r8 / (r1 - r2);
            this.widthMultiplier = r9;
            this.widthConstant = (int) (r7 - (r2 * r9));
        L5:
            int r10 = this.narrowMarginLeft;
            if (r10 == (-1)) goto L8;
            float r11 = this.wideMarginLeft - r10;
            int r3 = this.wideParentWidth;
            int r12 = this.narrowParentWidth;
            float r13 = r11 / (r3 - r12);
            this.leftMarginMultiplier = r13;
            this.leftMarginConstant = (int) (r10 - (r12 * r13));
        L8:
            int r14 = this.narrowPaddingLeft;
            if (r14 == (-1)) goto L11;
            float r15 = this.widePaddingLeft - r14;
            int r16 = this.wideParentWidth;
            int r17 = this.narrowParentWidth;
            float r18 = r15 / (r16 - r17);
            this.leftPaddingMultiplier = r18;
            this.leftPaddingConstant = (int) (r14 - (r17 * r18));
        L11:
            int r19 = this.narrowMarginRight;
            if (r19 == (-1)) goto L14;
            float r20 = this.wideMarginRight - r19;
            int r21 = this.wideParentWidth;
            int r22 = this.narrowParentWidth;
            float r23 = r20 / (r21 - r22);
            this.rightMarginMultiplier = r23;
            this.rightMarginConstant = (int) (r19 - (r22 * r23));
        L14:
            int r24 = this.narrowPaddingRight;
            if (r24 == (-1)) goto L18;
            float r25 = this.widePaddingRight - r24;
            int r0 = this.wideParentWidth;
            int r26 = this.narrowParentWidth;
            float r27 = r25 / (r0 - r26);
            this.rightPaddingMultiplier = r27;
            this.rightPaddingConstant = (int) (r24 - (r26 * r27));
            return;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public int resolveWidth(int r3) {
            if (this.narrowWidth == (-1)) goto L5;
            int r4 = ((int) (r3 * this.widthMultiplier)) + this.widthConstant;
            if (r4 > 0) goto L10;
            return -2;
        L10:
            return r4;
        L5:
            return this.width;
        }

        public int resolveLeftMargin(int r3) {
            if (this.narrowMarginLeft == (-1)) goto L5;
            int r4 = ((int) (r3 * this.leftMarginMultiplier)) + this.leftMarginConstant;
            if (r4 >= 0) goto L10;
            return 0;
        L10:
            return r4;
        L5:
            return this.leftMargin;
        }

        public int resolveLeftPadding(int r2) {
            int r3 = ((int) (r2 * this.leftPaddingMultiplier)) + this.leftPaddingConstant;
            if (r3 >= 0) goto L6;
            return 0;
        L6:
            return r3;
        }

        public int resolveRightMargin(int r3) {
            if (this.narrowMarginRight == (-1)) goto L5;
            int r4 = ((int) (r3 * this.rightMarginMultiplier)) + this.rightMarginConstant;
            if (r4 >= 0) goto L10;
            return 0;
        L10:
            return r4;
        L5:
            return this.rightMargin;
        }

        public int resolveRightPadding(int r2) {
            int r3 = ((int) (r2 * this.rightPaddingMultiplier)) + this.rightPaddingConstant;
            if (r3 >= 0) goto L6;
            return 0;
        L6:
            return r3;
        }
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public InterpolatingLayout(Context r1) {
        super(r1);
        this.mInRect = new Rect();
        this.mOutRect = new Rect();
    }

    public InterpolatingLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mInRect = new Rect();
        this.mOutRect = new Rect();
    }

    public InterpolatingLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mInRect = new Rect();
        this.mOutRect = new Rect();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.View
    protected void onMeasure(int r17, int r18) {
        int r2 = View.MeasureSpec.getSize(r17);
        int r3 = View.MeasureSpec.getSize(r18);
        int r4 = getChildCount();
        View r6 = null;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L4:
        if (r7 >= r4) goto L27;
        View r11 = getChildAt(r7);
        if (r11.getVisibility() == 8) goto L26;
        LayoutParams r12 = (LayoutParams) r11.getLayoutParams();
        if (r12.width != (-1)) goto L14;
        if (r6 != null) goto L13;
        r6 = r11;
    L25:
        r8 = r8 + (r12.resolveLeftMargin(r2) + r12.resolveRightMargin(r2));
        goto L26
    L13:
        throw new RuntimeException("Interpolating layout allows at most one child with layout_width='match_parent'");
    L14:
        int r13 = r12.resolveWidth(r2);
        if (r13 == (-2)) goto L17;
        int r14 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
    L18:
        int r5 = r12.height;
        if (r5 == (-2)) goto L23;
        if (r5 == (-1)) goto L22;
        int r10 = View.MeasureSpec.makeMeasureSpec(r12.height, 1073741824);
    L24:
        r11.measure(r14, r10);
        r8 = r8 + r11.getMeasuredWidth();
        r9 = Math.max(r11.getMeasuredHeight(), r9);
        goto L25
    L22:
        r10 = View.MeasureSpec.makeMeasureSpec((r3 - r12.topMargin) - r12.bottomMargin, 1073741824);
        goto L24
    L23:
        r10 = 0;
        goto L24
    L17:
        r14 = 0;
    L26:
        r7 = r7 + 1;
        goto L4
    L27:
        if (r6 == null) goto L33;
        int r15 = r2 - r8;
        if (r15 <= 0) goto L31;
        int r16 = View.MeasureSpec.makeMeasureSpec(r15, 1073741824);
    L32:
        r6.measure(r16, r18);
        r8 = r8 + r6.getMeasuredWidth();
        r9 = Math.max(r6.getMeasuredHeight(), r9);
        goto L33
    L31:
        r16 = 0;
    L33:
        setMeasuredDimension(resolveSize(r8, r17), resolveSize(r9, r18));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        int r14 = r12 - r10;
        int r15 = getChildCount();
        int r16 = 0;
        int r0 = 0;
    L3:
        if (r16 >= r15) goto L25;
        View r1 = getChildAt(r16);
        if (r1.getVisibility() == 8) goto L24;
        LayoutParams r2 = (LayoutParams) r1.getLayoutParams();
        int r3 = r2.gravity;
        if (r3 != (-1)) goto L11;
        r3 = 51;
    L11:
        if (r2.narrowPaddingLeft != (-1)) goto L15;
        if (r2.narrowPaddingRight != (-1)) goto L15;
    L23:
        int r4 = r2.resolveLeftMargin(r14);
        int r5 = r2.resolveRightMargin(r14);
        this.mInRect.set(r0 + r4, r2.topMargin, r12 - r5, r13 - r2.bottomMargin);
        Gravity.apply(r3, r1.getMeasuredWidth(), r1.getMeasuredHeight(), this.mInRect, this.mOutRect);
        r1.layout(this.mOutRect.left, this.mOutRect.top, this.mOutRect.right, this.mOutRect.bottom);
        r0 = this.mOutRect.right + r5;
    L15:
        if (r2.narrowPaddingLeft != (-1)) goto L17;
        int r6 = r1.getPaddingLeft();
    L19:
        if (r2.narrowPaddingRight != (-1)) goto L21;
        int r7 = r1.getPaddingRight();
    L22:
        r1.setPadding(r6, r1.getPaddingTop(), r7, r1.getPaddingBottom());
        goto L23
    L21:
        r7 = r2.resolveRightPadding(r14);
        goto L22
    L17:
        r6 = r2.resolveLeftPadding(r14);
    L24:
        r16 = r16 + 1;
        goto L3
    }
}
