package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class BaselineLayout extends ViewGroup {
    private int baseline;

    public BaselineLayout(Context r10) {
        super(r10, null, 0);
        this.baseline = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = ((r13 - r11) - getPaddingRight()) - r16;
        int r18 = getPaddingTop();
        int r19 = 0;
    L3:
        if (r19 >= r15) goto L15;
        View r20 = getChildAt(r19);
        if (r20.getVisibility() == 8) goto L14;
        int r21 = r20.getMeasuredWidth();
        int r22 = r20.getMeasuredHeight();
        int r23 = ((r17 - r21) / 2) + r16;
        if (this.baseline != (-1)) goto L10;
    L12:
        int r24 = r18;
    L13:
        r20.layout(r23, r24, r21 + r23, r22 + r24);
        goto L14
    L10:
        if (r20.getBaseline() == (-1)) goto L12;
        r24 = (this.baseline + r18) - r20.getBaseline();
    L14:
        r19 = r19 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        int r10 = getChildCount();
        int r11 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = -1;
        int r18 = -1;
    L3:
        if (r11 >= r10) goto L12;
        View r19 = getChildAt(r11);
        if (r19.getVisibility() == 8) goto L11;
        measureChild(r19, r12, r13);
        int r20 = r19.getBaseline();
        if (r20 == (-1)) goto L10;
        r17 = Math.max(r17, r20);
        r18 = Math.max(r18, r19.getMeasuredHeight() - r20);
    L10:
        r15 = Math.max(r15, r19.getMeasuredWidth());
        r14 = Math.max(r14, r19.getMeasuredHeight());
        r16 = View.combineMeasuredStates(r16, r19.getMeasuredState());
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        if (r17 == (-1)) goto L14;
        r14 = Math.max(r14, Math.max(r18, getPaddingBottom()) + r17);
        this.baseline = r17;
    L14:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r15, getSuggestedMinimumWidth()), r12, r16), View.resolveSizeAndState(Math.max(r14, getSuggestedMinimumHeight()), r13, r16 << 16));
    }

    public BaselineLayout(Context r10, AttributeSet r11) {
        super(r10, r11, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.baseline = -1;
    }
}
