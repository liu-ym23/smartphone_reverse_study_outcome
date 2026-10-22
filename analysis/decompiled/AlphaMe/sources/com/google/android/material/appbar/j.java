package com.google.android.material.appbar;

import K.z0;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j extends m {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    public j() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public abstract View findFirstDependency(List list);

    public final int getOverlapPixelsForOffset(View view) {
        if (this.overlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i4 = this.overlayTop;
        return AbstractC0557a.o((int) (overlapRatioForOffset * i4), 0, i4);
    }

    public abstract float getOverlapRatioForOffset(View view);

    public int getOverlayTop() {
        return this.overlayTop;
    }

    public abstract int getScrollRange(View view);

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    @Override // com.google.android.material.appbar.m
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        View viewFindFirstDependency = findFirstDependency(coordinatorLayout.v(view));
        if (viewFindFirstDependency == null) {
            coordinatorLayout.B(i4, view);
            this.verticalLayoutGap = 0;
            return;
        }
        A.d dVar = (A.d) view.getLayoutParams();
        Rect rect = this.tempRect1;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, viewFindFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin, ((viewFindFirstDependency.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
        z0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            rect.left = lastWindowInsets.b() + rect.left;
            rect.right -= lastWindowInsets.c();
        }
        Rect rect2 = this.tempRect2;
        int i5 = dVar.f7c;
        if (i5 == 0) {
            i5 = 8388659;
        }
        Gravity.apply(i5, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i4);
        int overlapPixelsForOffset = getOverlapPixelsForOffset(viewFindFirstDependency);
        view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
        this.verticalLayoutGap = rect2.top - viewFindFirstDependency.getBottom();
    }

    @Override // A.b
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
        View viewFindFirstDependency;
        z0 lastWindowInsets;
        int i8 = view.getLayoutParams().height;
        if ((i8 != -1 && i8 != -2) || (viewFindFirstDependency = findFirstDependency(coordinatorLayout.v(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i6);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (viewFindFirstDependency.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.a() + lastWindowInsets.d();
        }
        int scrollRange = getScrollRange(viewFindFirstDependency) + size;
        int measuredHeight = viewFindFirstDependency.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            scrollRange -= measuredHeight;
        }
        coordinatorLayout.C(view, i4, i5, View.MeasureSpec.makeMeasureSpec(scrollRange, i8 == -1 ? 1073741824 : Integer.MIN_VALUE), i7);
        return true;
    }

    public void setOverlayTop(int i4) {
        this.overlayTop = i4;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public j(int i4) {
        super(0);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }
}
