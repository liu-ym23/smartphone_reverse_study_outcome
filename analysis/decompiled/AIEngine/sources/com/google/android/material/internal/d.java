package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f5088a;

    /* renamed from: b, reason: collision with root package name */
    public int f5089b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5090c;

    /* renamed from: d, reason: collision with root package name */
    public int f5091d;

    public boolean a() {
        return this.f5090c;
    }

    public int getItemSpacing() {
        return this.f5089b;
    }

    public int getLineSpacing() {
        return this.f5088a;
    }

    public int getRowCount() {
        return this.f5091d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int marginEnd;
        int marginStart;
        boolean z3;
        int i14 = 0;
        if (getChildCount() == 0) {
            this.f5091d = 0;
            return;
        }
        boolean z10 = true;
        this.f5091d = 1;
        boolean z11 = getLayoutDirection() == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i15 = 0;
        int measuredWidth = paddingRight;
        int i16 = paddingTop;
        while (i15 < getChildCount()) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
                z3 = z10;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = marginLayoutParams.getMarginStart();
                    marginEnd = marginLayoutParams.getMarginEnd();
                } else {
                    marginEnd = i14;
                    marginStart = marginEnd;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth + marginStart;
                int i17 = i12 - i10;
                z3 = z10;
                int i18 = i17 - paddingLeft;
                if (!this.f5090c && measuredWidth2 > i18) {
                    measuredWidth2 = childAt.getMeasuredWidth() + paddingRight + marginStart;
                    i16 = paddingTop + this.f5088a;
                    this.f5091d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f5091d - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                if (z11) {
                    childAt.layout(i17 - measuredWidth2, i16, (i17 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(measuredWidth + marginStart, i16, measuredWidth2, measuredHeight);
                }
                measuredWidth += childAt.getMeasuredWidth() + marginStart + marginEnd + this.f5089b;
                paddingTop = measuredHeight;
            }
            i15++;
            z10 = z3;
            i14 = 0;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i15 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i15 - getPaddingRight();
        int i16 = paddingTop;
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = marginLayoutParams.leftMargin;
                    i13 = marginLayoutParams.rightMargin;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int i19 = i13;
                if (childAt.getMeasuredWidth() + paddingLeft + i14 > paddingRight && !a()) {
                    paddingLeft = getPaddingLeft();
                    i16 = paddingTop + this.f5088a;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i14;
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                if (measuredWidth > i17) {
                    i17 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i14 + i19 + this.f5089b + paddingLeft;
                if (i18 == getChildCount() - 1) {
                    i17 += i19;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i17;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i12 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i12 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i12) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i10) {
        this.f5089b = i10;
    }

    public void setLineSpacing(int i10) {
        this.f5088a = i10;
    }

    public void setSingleLine(boolean z) {
        this.f5090c = z;
    }
}
