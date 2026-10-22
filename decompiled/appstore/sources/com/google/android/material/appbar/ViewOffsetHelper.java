package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
class ViewOffsetHelper {
    private boolean horizontalOffsetEnabled;
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private boolean verticalOffsetEnabled;
    private final View view;

    public ViewOffsetHelper(View r10) {
        this.verticalOffsetEnabled = true;
        this.horizontalOffsetEnabled = true;
        this.view = r10;
    }

    public void applyOffsets() {
        View r10 = this.view;
        ViewCompat.a0(r10, this.offsetTop - (r10.getTop() - this.layoutTop));
        View r11 = this.view;
        ViewCompat.Z(r11, this.offsetLeft - (r11.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean r10) {
        this.horizontalOffsetEnabled = r10;
    }

    public boolean setLeftAndRightOffset(int r10) {
        if (this.horizontalOffsetEnabled == true) goto L5;
        return false;
    L5:
        if (this.offsetLeft == r10) goto L10;
        this.offsetLeft = r10;
        applyOffsets();
        return true;
    L10:
        return false;
    }

    public boolean setTopAndBottomOffset(int r10) {
        if (this.verticalOffsetEnabled == true) goto L5;
        return false;
    L5:
        if (this.offsetTop == r10) goto L10;
        this.offsetTop = r10;
        applyOffsets();
        return true;
    L10:
        return false;
    }

    public void setVerticalOffsetEnabled(boolean r10) {
        this.verticalOffsetEnabled = r10;
    }
}
