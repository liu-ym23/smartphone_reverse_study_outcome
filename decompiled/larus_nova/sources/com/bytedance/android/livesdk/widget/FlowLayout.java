package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes11.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f160864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f160865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f160866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f160867d;

    public int getCurLine() {
        return this.f160867d;
    }

    public int getItemSpacing() {
        return this.f160865b;
    }

    public int getLineSpacing() {
        return this.f160864a;
    }

    public FlowLayout(Context r100) {
        this(r100, null);
    }

    public void setItemSpacing(int r100) {
        this.f160865b = r100;
        requestLayout();
    }

    public void setLineSpacing(int r100) {
        this.f160864a = r100;
        requestLayout();
    }

    public void setSingleLine(boolean r100) {
        this.f160866c = r100;
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r210) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r210);
        int r103 = View.MeasureSpec.getMode(r210);
        if (r101 == Integer.MIN_VALUE) goto L7;
        if (r101 == 1073741824) goto L7;
        int r104 = Integer.MAX_VALUE;
    L8:
        int r105 = getPaddingLeft();
        int r111 = getPaddingTop();
        int r106 = r104 - getPaddingRight();
        int r112 = 0;
        int r113 = r111;
        int r114 = 0;
        int r115 = 0;
    L10:
        if (r114 >= getChildCount()) goto L33;
        View r116 = getChildAt(r114);
        if (r116.getVisibility() != 8) goto L14;
        int r117 = r106;
    L32:
        r114 = r114 + 1;
        r106 = r117;
        r112 = 0;
        goto L10
    L14:
        measureChild(r116, View.MeasureSpec.makeMeasureSpec(r112, r112), r210);
        ViewGroup.LayoutParams r107 = r116.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        int r109 = r108.leftMargin + r112;
        int r118 = r108.rightMargin + r112;
    L18:
        int r119 = (r105 + r109) + r116.getMeasuredWidth();
        r117 = r106;
        if (r119 <= r106) goto L24;
        if (this.f160866c == true) goto L24;
        r105 = getPaddingLeft();
        r113 = r111 + this.f160864a;
    L24:
        if (r119 <= (r100 - getPaddingRight())) goto L26;
        measureChild(r116, View.MeasureSpec.makeMeasureSpec((((r100 - getPaddingRight()) - r105) - r109) - r118, Integer.MIN_VALUE), r210);
    L26:
        int r120 = (r105 + r109) + r116.getMeasuredWidth();
        r111 = r116.getMeasuredHeight() + r113;
        if (r120 <= r115) goto L29;
        r115 = r120;
    L29:
        r105 = r105 + (((r109 + r118) + r116.getMeasuredWidth()) + this.f160865b);
        if (r114 != (getChildCount() - 1)) goto L32;
        r115 = r115 + r118;
        goto L32
    L17:
        r118 = 0;
        r109 = 0;
        goto L18
    L33:
        int r121 = r115 + getPaddingRight();
        int r122 = r111 + getPaddingBottom();
        if (r101 == Integer.MIN_VALUE) goto L38;
        int r123 = 1073741824;
        if (r101 == 1073741824) goto L39;
        r100 = r121;
    L39:
        if (r103 == Integer.MIN_VALUE) goto L42;
        if (r103 == r123) goto L43;
        r102 = r122;
    L43:
        setMeasuredDimension(r100, r102);
        return;
    L42:
        r102 = Math.min(r122, r102);
        goto L43
    L38:
        r123 = 1073741824;
        r100 = Math.min(r121, r100);
    L7:
        r104 = r100;
        goto L8
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160867d = 1;
        this.f160866c = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        int r115 = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L8;
        boolean r116 = true;
    L9:
        if (r116 == false) goto L11;
        int r100 = getPaddingRight();
    L12:
        if (r116 == false) goto L14;
        int r101 = getPaddingLeft();
    L15:
        int r102 = getPaddingTop();
        int r117 = (r113 - r111) - r101;
        int r103 = r100;
        int r118 = r102;
        int r104 = 0;
    L17:
        if (r104 >= getChildCount()) goto L35;
        View r105 = getChildAt(r104);
        if (r105.getVisibility() == 8) goto L34;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        int r108 = MarginLayoutParamsCompat.getMarginStart(r107);
        int r109 = MarginLayoutParamsCompat.getMarginEnd(r107);
    L25:
        int r119 = (r103 + r108) + r105.getMeasuredWidth();
        if (this.f160866c == true) goto L29;
        if (r119 <= r117) goto L29;
        r118 = this.f160864a + r102;
        r115 = r115 + 1;
        r103 = r100;
    L29:
        int r120 = r103 + r108;
        int r121 = r105.getMeasuredWidth() + r120;
        int r122 = r105.getMeasuredHeight() + r118;
        if (r116 == false) goto L32;
        r105.layout(r117 - r121, r118, (r117 - r103) - r108, r122);
    L33:
        r103 = r103 + (((r108 + r109) + r105.getMeasuredWidth()) + this.f160865b);
        r102 = r122;
        goto L34
    L32:
        r105.layout(r120, r118, r121, r122);
        goto L33
    L24:
        r109 = 0;
        r108 = 0;
    L34:
        r104 = r104 + 1;
        goto L17
    L35:
        this.f160867d = r115;
        return;
    L14:
        r101 = getPaddingRight();
        goto L15
    L11:
        r100 = getPaddingLeft();
        goto L12
    L8:
        r116 = false;
        goto L9
    }
}
