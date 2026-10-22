package com.alibaba.android.vlayout.layout;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.LayoutManagerHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class MarginLayoutHelper extends LayoutHelper {
    protected int mMarginBottom;
    protected int mMarginLeft;
    protected int mMarginRight;
    protected int mMarginTop;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;

    public MarginLayoutHelper() {
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public int computeMarginEnd(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L7;
        return this.mMarginBottom;
    L7:
        return this.mMarginRight;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public int computeMarginStart(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L7;
        return this.mMarginTop;
    L7:
        return this.mMarginLeft;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public int computePaddingEnd(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L7;
        return this.mPaddingBottom;
    L7:
        return this.mPaddingRight;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public int computePaddingStart(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L7;
        return this.mPaddingTop;
    L7:
        return this.mPaddingLeft;
    }

    public int getHorizontalMargin() {
        return this.mMarginLeft + this.mMarginRight;
    }

    public int getHorizontalPadding() {
        return this.mPaddingLeft + this.mPaddingRight;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public int getVerticalMargin() {
        return this.mMarginTop + this.mMarginBottom;
    }

    public int getVerticalPadding() {
        return this.mPaddingTop + this.mPaddingBottom;
    }

    public void setMargin(int r10, int r11, int r12, int r13) {
        this.mMarginLeft = r10;
        this.mMarginTop = r11;
        this.mMarginRight = r12;
        this.mMarginBottom = r13;
    }

    public void setMarginBottom(int r10) {
        this.mMarginBottom = r10;
    }

    public void setMarginLeft(int r10) {
        this.mMarginLeft = r10;
    }

    public void setMarginRight(int r10) {
        this.mMarginRight = r10;
    }

    public void setMarginTop(int r10) {
        this.mMarginTop = r10;
    }

    public void setPadding(int r10, int r11, int r12, int r13) {
        this.mPaddingLeft = r10;
        this.mPaddingRight = r12;
        this.mPaddingTop = r11;
        this.mPaddingBottom = r13;
    }

    public void setPaddingBottom(int r10) {
        this.mPaddingBottom = r10;
    }

    public void setPaddingLeft(int r10) {
        this.mPaddingLeft = r10;
    }

    public void setPaddingRight(int r10) {
        this.mPaddingRight = r10;
    }

    public void setPaddingTop(int r10) {
        this.mPaddingTop = r10;
    }
}
