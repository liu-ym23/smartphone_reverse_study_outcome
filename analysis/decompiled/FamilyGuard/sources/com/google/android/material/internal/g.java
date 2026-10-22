package com.google.android.material.internal;

import a1.C0413f;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class g extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f13007a;

    /* renamed from: b, reason: collision with root package name */
    private int f13008b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13009c;

    /* renamed from: d, reason: collision with root package name */
    private int f13010d;

    private static int a(int i5, int i6, int i7) {
        return i6 != Integer.MIN_VALUE ? i6 != 1073741824 ? i7 : i5 : Math.min(i7, i5);
    }

    public int b(View view) {
        Object tag = view.getTag(C0413f.f6824G);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f13009c;
    }

    protected int getItemSpacing() {
        return this.f13008b;
    }

    protected int getLineSpacing() {
        return this.f13007a;
    }

    protected int getRowCount() {
        return this.f13010d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int marginEnd;
        int marginStart;
        boolean z6;
        if (getChildCount() == 0) {
            this.f13010d = 0;
            return;
        }
        boolean z7 = true;
        this.f13010d = 1;
        boolean z8 = getLayoutDirection() == 1;
        int paddingRight = z8 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z8 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i9 = 0;
        int measuredWidth = paddingRight;
        int i10 = paddingTop;
        while (i9 < getChildCount()) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(C0413f.f6824G, -1);
                z6 = z7;
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
                int i11 = i7 - i5;
                int i12 = i11 - paddingLeft;
                z6 = z7;
                if (!this.f13009c && measuredWidth2 > i12) {
                    measuredWidth2 = paddingRight + marginStart + childAt.getMeasuredWidth();
                    i10 = paddingTop + this.f13007a;
                    this.f13010d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(C0413f.f6824G, Integer.valueOf(this.f13010d - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                if (z8) {
                    childAt.layout(i11 - measuredWidth2, i10, (i11 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(measuredWidth + marginStart, i10, measuredWidth2, measuredHeight);
                }
                measuredWidth += marginStart + marginEnd + childAt.getMeasuredWidth() + this.f13008b;
                paddingTop = measuredHeight;
            }
            i9++;
            z7 = z6;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        int i9 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i9 - getPaddingRight();
        int i10 = paddingTop;
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i5, i6);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i7 = marginLayoutParams.leftMargin;
                    i8 = marginLayoutParams.rightMargin;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i13 = paddingLeft2;
                if (paddingLeft2 + i7 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i13;
                } else {
                    paddingLeft = getPaddingLeft();
                    i10 = this.f13007a + paddingTop;
                }
                int measuredWidth = paddingLeft + i7 + childAt.getMeasuredWidth();
                int measuredHeight = i10 + childAt.getMeasuredHeight();
                if (measuredWidth > i11) {
                    i11 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i7 + i8 + childAt.getMeasuredWidth() + this.f13008b;
                if (i12 == getChildCount() - 1) {
                    i11 += i8;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i11 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i5) {
        this.f13008b = i5;
    }

    protected void setLineSpacing(int i5) {
        this.f13007a = i5;
    }

    public void setSingleLine(boolean z5) {
        this.f13009c = z5;
    }
}
