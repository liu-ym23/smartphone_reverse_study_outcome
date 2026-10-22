package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$id;

/* loaded from: classes2.dex */
public class g extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f21078a;

    /* renamed from: b, reason: collision with root package name */
    public int f21079b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21080c;

    /* renamed from: d, reason: collision with root package name */
    public int f21081d;

    public static int a(int i10, int i11, int i12) {
        return i11 != Integer.MIN_VALUE ? i11 != 1073741824 ? i12 : i10 : Math.min(i12, i10);
    }

    public int b(View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f21080c;
    }

    public int getItemSpacing() {
        return this.f21079b;
    }

    public int getLineSpacing() {
        return this.f21078a;
    }

    public int getRowCount() {
        return this.f21081d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int marginEnd;
        int marginStart;
        boolean z11;
        if (getChildCount() == 0) {
            this.f21081d = 0;
            return;
        }
        boolean z12 = true;
        this.f21081d = 1;
        boolean z13 = getLayoutDirection() == 1;
        int paddingRight = z13 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z13 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = 0;
        int measuredWidth = paddingRight;
        int i15 = paddingTop;
        while (i14 < getChildCount()) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
                z11 = z12;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = marginLayoutParams.getMarginStart();
                    marginEnd = marginLayoutParams.getMarginEnd();
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = measuredWidth + marginStart + childAt.getMeasuredWidth();
                int i16 = i12 - i10;
                int i17 = i16 - paddingLeft;
                z11 = z12;
                if (!this.f21080c && measuredWidth2 > i17) {
                    measuredWidth2 = paddingRight + marginStart + childAt.getMeasuredWidth();
                    i15 = paddingTop + this.f21078a;
                    this.f21081d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f21081d - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z13) {
                    childAt.layout(i16 - measuredWidth2, i15, (i16 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(measuredWidth + marginStart, i15, measuredWidth2, measuredHeight);
                }
                measuredWidth += marginStart + marginEnd + childAt.getMeasuredWidth() + this.f21079b;
                paddingTop = measuredHeight;
            }
            i14++;
            z12 = z11;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i12 = marginLayoutParams.leftMargin;
                    i13 = marginLayoutParams.rightMargin;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = paddingLeft2;
                if (paddingLeft2 + i12 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i18;
                } else {
                    paddingLeft = getPaddingLeft();
                    i15 = this.f21078a + paddingTop;
                }
                int measuredWidth = paddingLeft + i12 + childAt.getMeasuredWidth();
                int measuredHeight = i15 + childAt.getMeasuredHeight();
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i12 + i13 + childAt.getMeasuredWidth() + this.f21079b;
                if (i17 == getChildCount() - 1) {
                    i16 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i16 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i10) {
        this.f21079b = i10;
    }

    public void setLineSpacing(int i10) {
        this.f21078a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f21080c = z10;
    }
}
