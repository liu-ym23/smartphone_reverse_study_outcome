package com.android.contacts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class TabStripView extends LinearLayout {
    private Drawable mBottomLeftStrip;
    private Drawable mBottomRightStrip;
    private int mSelectedTabIndex;

    public TabStripView(Context r2) {
        this(r2, null);
    }

    public TabStripView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        this.mGroupFlags |= 1024;
        this.mBottomLeftStrip = this.mContext.getResources().getDrawable(R.drawable.tab_bottom);
        this.mBottomRightStrip = this.mContext.getResources().getDrawable(R.drawable.tab_bottom);
    }

    public void setSelected(int r1, boolean r2) {
        this.mSelectedTabIndex = r1;
        getChildAt(r1).setSelected(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        if ((getParent() instanceof HorizontalScrollView) == false) goto L5;
        setMinimumWidth(((HorizontalScrollView) getParent()).getMeasuredWidth());
    L5:
        super.onMeasure(r2, r3);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int r1, int r2) {
        if (r2 != (r1 - 1)) goto L7;
        return this.mSelectedTabIndex;
    L7:
        if (r2 >= this.mSelectedTabIndex) goto L9;
        return r2;
    L9:
        return r2 + 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void childDrawableStateChanged(View r2) {
        if (r2 != getChildAt(this.mSelectedTabIndex)) goto L5;
        invalidate();
    L5:
        super.childDrawableStateChanged(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r8) {
        super.dispatchDraw(r8);
        View r0 = getChildAt(this.mSelectedTabIndex);
        this.mBottomRightStrip.setState(r0.getDrawableState());
        this.mBottomLeftStrip.setState(r0.getDrawableState());
        Rect r1 = new Rect();
        r1.left = r0.getLeft() - getScrollX();
        r1.right = r0.getRight() - getScrollX();
        int r2 = getHeight();
        this.mBottomLeftStrip.setBounds(Math.min(0, r1.left - this.mBottomLeftStrip.getIntrinsicWidth()), r2 - this.mBottomLeftStrip.getIntrinsicHeight(), r1.left, r2);
        this.mBottomRightStrip.setBounds(r1.right, r2 - this.mBottomRightStrip.getIntrinsicHeight(), Math.max(getWidth(), r1.right + this.mBottomRightStrip.getIntrinsicWidth()), r2);
        this.mBottomLeftStrip.draw(r8);
        this.mBottomRightStrip.draw(r8);
    }
}
