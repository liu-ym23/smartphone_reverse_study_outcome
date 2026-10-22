package com.android.contacts.widget.dslv;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes2.dex */
public class DragSortItemView extends ViewGroup {
    private int mGravity;

    public DragSortItemView(Context r3) {
        super(r3);
        this.mGravity = 48;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }

    public void setGravity(int r1) {
        this.mGravity = r1;
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        View r6 = getChildAt(0);
        if (r6 != null) goto L6;
        return;
    L6:
        if (this.mGravity != 48) goto L8;
        r6.layout(0, 0, getMeasuredWidth(), r6.getMeasuredHeight());
        return;
    L8:
        r6.layout(0, getMeasuredHeight() - r6.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getSize(r6);
        int r8 = View.MeasureSpec.getMode(r7);
        View r3 = getChildAt(0);
        if (r3 != null) goto L7;
        setMeasuredDimension(0, r1);
        return;
    L7:
        if (r3.isLayoutRequested() == false) goto L9;
        measureChild(r3, r6, View.MeasureSpec.makeMeasureSpec(0, 0));
    L9:
        if (r8 != 0) goto L14;
        ViewGroup.LayoutParams r9 = getLayoutParams();
        if (r9.height <= 0) goto L13;
        r0 = r9.height;
        goto L14
    L13:
        r0 = r3.getMeasuredHeight();
    L14:
        setMeasuredDimension(r1, r0);
    }
}
