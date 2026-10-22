package com.android.contacts.PinnedHeaderList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class WrapperView extends ViewGroup {
    Drawable divider;
    int dividerHeight;
    View header;
    View item;

    public WrapperView(Context r1) {
        super(r1);
        setDescendantFocusability(393216);
    }

    void update(View r3, View r4, Drawable r5, int r6) {
        if (r3 == null) goto L24;
        View r0 = this.item;
        if (r0 == r3) goto L12;
        removeView(r0);
        this.item = r3;
        ViewParent r1 = r3.getParent();
        if (r1 == null) goto L11;
        if (r1 == this) goto L11;
        if ((r1 instanceof ViewGroup) == false) goto L11;
        ((ViewGroup) r1).removeView(r3);
    L11:
        addView(r3);
    L12:
        View r7 = this.header;
        if (r7 == r4) goto L20;
        if (r7 == null) goto L16;
        removeView(r7);
    L16:
        this.header = r4;
        if (r4 == null) goto L20;
        addView(r4);
    L20:
        if (this.divider == r5) goto L25;
        this.divider = r5;
        this.dividerHeight = r6;
        invalidate();
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("List view item must not be null.");
    }

    public boolean hasHeader() {
        if (this.header == null) goto L5;
        return true;
    L5:
        return false;
    }

    public View getItem() {
        return this.item;
    }

    public View getHeader() {
        return this.header;
    }

    @Override // android.view.View
    protected void onMeasure(int r6, int r7) {
        int r8 = View.MeasureSpec.getSize(r6);
        int r0 = View.MeasureSpec.makeMeasureSpec(r8, 1073741824);
        View r1 = this.header;
        if (r1 == null) goto L12;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 != null) goto L7;
    L9:
        this.header.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
    L10:
        int r3 = this.header.getMeasuredHeight() + 0;
    L15:
        ViewGroup.LayoutParams r4 = this.item.getLayoutParams();
        if (r4 != null) goto L18;
    L20:
        this.item.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
    L21:
        setMeasuredDimension(r8, r3 + this.item.getMeasuredHeight());
        return;
    L18:
        if (r4.height <= 0) goto L20;
        this.item.measure(r0, View.MeasureSpec.makeMeasureSpec(r4.height, 1073741824));
        goto L21
    L7:
        if (r2.height <= 0) goto L9;
        this.header.measure(r0, View.MeasureSpec.makeMeasureSpec(r2.height, 1073741824));
        goto L10
    L12:
        if (this.divider == null) goto L14;
        r3 = this.dividerHeight + 0;
        goto L15
    L14:
        r3 = 0;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        int r6 = getWidth();
        int r7 = getHeight();
        View r8 = this.header;
        if (r8 == null) goto L5;
        r8.layout(0, 0, r6, r8.getMeasuredHeight());
        this.item.layout(0, this.header.getMeasuredHeight(), r6, r7);
        return;
    L5:
        Drawable r9 = this.divider;
        if (r9 == null) goto L8;
        r9.setBounds(0, 0, r6, this.dividerHeight);
        this.item.layout(0, this.dividerHeight, r6, r7);
        return;
    L8:
        this.item.layout(0, 0, r6, r7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        if (this.header == null) goto L5;
        return;
    L5:
        if (this.divider == null) goto L9;
        this.divider.draw(r2);
        return;
    }
}
