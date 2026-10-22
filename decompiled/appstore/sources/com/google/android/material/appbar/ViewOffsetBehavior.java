package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes3.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getLeftAndRightOffset();
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getTopAndBottomOffset();
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isHorizontalOffsetEnabled() == false) goto L7;
        return true;
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isVerticalOffsetEnabled() == false) goto L7;
        return true;
    }

    public void layoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        r10.onLayoutChild(r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        layoutChild(r10, r11, r12);
        if (this.viewOffsetHelper != null) goto L5;
        this.viewOffsetHelper = new ViewOffsetHelper(r11);
    L5:
        this.viewOffsetHelper.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int r13 = this.tempTopBottomOffset;
        if (r13 == 0) goto L8;
        this.viewOffsetHelper.setTopAndBottomOffset(r13);
        this.tempTopBottomOffset = 0;
    L8:
        int r14 = this.tempLeftRightOffset;
        if (r14 == 0) goto L13;
        this.viewOffsetHelper.setLeftAndRightOffset(r14);
        this.tempLeftRightOffset = 0;
        return true;
    L13:
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean r10) {
        ViewOffsetHelper r11 = this.viewOffsetHelper;
        if (r11 == null) goto L6;
        r11.setHorizontalOffsetEnabled(r10);
        return;
    }

    public boolean setLeftAndRightOffset(int r10) {
        ViewOffsetHelper r11 = this.viewOffsetHelper;
        if (r11 != null) goto L5;
        this.tempLeftRightOffset = r10;
        return false;
    L5:
        return r11.setLeftAndRightOffset(r10);
    }

    public boolean setTopAndBottomOffset(int r10) {
        ViewOffsetHelper r11 = this.viewOffsetHelper;
        if (r11 != null) goto L5;
        this.tempTopBottomOffset = r10;
        return false;
    L5:
        return r11.setTopAndBottomOffset(r10);
    }

    public void setVerticalOffsetEnabled(boolean r10) {
        ViewOffsetHelper r11 = this.viewOffsetHelper;
        if (r11 == null) goto L6;
        r11.setVerticalOffsetEnabled(r10);
        return;
    }

    public ViewOffsetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
