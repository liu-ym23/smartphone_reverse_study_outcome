package com.google.android.material.appbar;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i extends l {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    public i() {
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
        int i = this.overlayTop;
        return td.h.j((int) (overlapRatioForOffset * i), 0, i);
    }

    public abstract float getOverlapRatioForOffset(View view);

    public int getOverlayTop() {
        return this.overlayTop;
    }

    public abstract int getScrollRange(View view);

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    @Override // com.google.android.material.appbar.l
    public void layoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        View viewFindFirstDependency = findFirstDependency(aVar.v(view));
        if (viewFindFirstDependency == null) {
            aVar.B(i, view);
            this.verticalLayoutGap = 0;
            return;
        }
        b3.d dVar = (b3.d) view.getLayoutParams();
        Rect rect = this.tempRect1;
        rect.set(aVar.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, viewFindFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, (aVar.getWidth() - aVar.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin, ((viewFindFirstDependency.getBottom() + aVar.getHeight()) - aVar.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
        m1 lastWindowInsets = aVar.getLastWindowInsets();
        if (lastWindowInsets != null && aVar.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            rect.left = lastWindowInsets.b() + rect.left;
            rect.right -= lastWindowInsets.c();
        }
        Rect rect2 = this.tempRect2;
        int i3 = dVar.f1879c;
        if (i3 == 0) {
            i3 = 8388659;
        }
        Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int overlapPixelsForOffset = getOverlapPixelsForOffset(viewFindFirstDependency);
        view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
        this.verticalLayoutGap = rect2.top - viewFindFirstDependency.getBottom();
    }

    @Override // b3.a
    public boolean onMeasureChild(androidx.coordinatorlayout.widget.a aVar, View view, int i, int i3, int i10, int i11) {
        View viewFindFirstDependency;
        m1 lastWindowInsets;
        int i12 = view.getLayoutParams().height;
        if ((i12 != -1 && i12 != -2) || (viewFindFirstDependency = findFirstDependency(aVar.v(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (size <= 0) {
            size = aVar.getHeight();
        } else if (viewFindFirstDependency.getFitsSystemWindows() && (lastWindowInsets = aVar.getLastWindowInsets()) != null) {
            size += lastWindowInsets.a() + lastWindowInsets.d();
        }
        int scrollRange = getScrollRange(viewFindFirstDependency) + size;
        int measuredHeight = viewFindFirstDependency.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            scrollRange -= measuredHeight;
        }
        aVar.C(view, i, i3, View.MeasureSpec.makeMeasureSpec(scrollRange, i12 == -1 ? 1073741824 : Integer.MIN_VALUE), i11);
        return true;
    }

    public void setOverlayTop(int i) {
        this.overlayTop = i;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public i(int i) {
        super(0);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }
}
