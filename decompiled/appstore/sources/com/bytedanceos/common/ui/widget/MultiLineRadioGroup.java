package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

/* JADX INFO: loaded from: classes2.dex */
public class MultiLineRadioGroup extends RadioGroup {
    private final String TAG;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;

    public MultiLineRadioGroup(Context r10) {
        super(r10);
        this.TAG = "MultiLineRadioGroup";
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getWidth() - this.mPaddingRight;
        int r16 = this.mPaddingLeft;
        int r17 = r15 - r16;
        int r18 = this.mPaddingTop;
        int r19 = getChildCount();
        int r20 = 0;
        int r21 = 0;
    L3:
        if (r20 >= r19) goto L12;
        View r22 = getChildAt(r20);
        if (r22.getVisibility() == 8) goto L11;
        int r23 = r22.getMeasuredWidth();
        int r24 = r22.getMeasuredHeight();
        if ((r23 + r21) <= r17) goto L10;
        r16 = this.mPaddingLeft;
        r18 = r18 + r24;
        r21 = 0;
    L10:
        int r25 = r16 + r23;
        r22.layout(r16, r18, r25, r24 + r18);
        r21 = r21 + r23;
        r16 = r25;
    L11:
        r20 = r20 + 1;
        goto L3
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r14, int r15) {
        int r10 = View.MeasureSpec.getSize(r14);
        int r11 = View.MeasureSpec.getMode(r14);
        int r12 = View.MeasureSpec.getSize(r15);
        int r13 = View.MeasureSpec.getMode(r15);
        int r16 = this.mPaddingLeft + this.mPaddingRight;
        int r17 = getChildCount();
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        int r21 = 0;
    L3:
        if (r18 >= r17) goto L13;
        View r110 = getChildAt(r18);
        measureChild(r110, r14, r15);
        getLayoutParams();
        int r111 = r110.getMeasuredWidth();
        int r112 = r110.getMeasuredHeight();
        int r113 = r16 + r111;
        if (r113 <= r10) goto L7;
        r19 = Math.max(r19, r16);
        r21 = r21 + r20;
        r20 = r112;
        r16 = r111;
    L9:
        if (r18 != (r17 - 1)) goto L11;
        r19 = Math.max(r19, r16);
        r21 = r21 + ((this.mPaddingBottom + r20) + this.mPaddingTop);
    L11:
        r18 = r18 + 1;
        goto L3
    L7:
        r20 = Math.max(r20, r112);
        r16 = r113;
        goto L9
    L13:
        if (r11 == 1073741824) goto L16;
        r10 = r19;
    L16:
        if (r13 == 1073741824) goto L19;
        r12 = r21;
    L19:
        setMeasuredDimension(r10, r12);
    }

    public MultiLineRadioGroup(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.TAG = "MultiLineRadioGroup";
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
    }
}
