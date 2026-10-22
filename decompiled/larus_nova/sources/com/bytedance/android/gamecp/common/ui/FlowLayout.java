package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes44.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f56926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56927d;

    public int getItemSpacing() {
        return this.f56925b;
    }

    public int getLineSpacing() {
        return this.f56924a;
    }

    public FlowLayout(Context r100) {
        this(r100, null);
    }

    public void setItemSpacing(int r100) {
        this.f56925b = r100;
        requestLayout();
    }

    public void setLineSpacing(int r100) {
        this.f56924a = r100;
        requestLayout();
    }

    public void setSingleLine(boolean r100) {
        this.f56926c = r100;
    }

    public void setSingleLineLimitChildNumber(boolean r100) {
        this.f56927d = r100;
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        if (r101 == Integer.MIN_VALUE) goto L7;
        if (r101 == 1073741824) goto L7;
        int r104 = Integer.MAX_VALUE;
    L8:
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop();
        int r107 = r104 - getPaddingRight();
        int r110 = r106;
        int r111 = 0;
        int r112 = 0;
    L10:
        if (r111 >= getChildCount()) goto L37;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L36;
        measureChild(r113, r210, r211);
        ViewGroup.LayoutParams r108 = r113.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        int r114 = r109.leftMargin + 0;
        int r115 = r109.rightMargin + 0;
    L18:
        int r116 = (r105 + r114) + r113.getMeasuredWidth();
        int r117 = r105;
        if (r116 > r107) goto L21;
    L23:
        int r118 = r117;
    L25:
        if (this.f56926c == false) goto L30;
        if (r116 <= r107) goto L30;
        if (this.f56927d == false) goto L30;
        r112 = r118;
    L30:
        int r119 = (r118 + r114) + r113.getMeasuredWidth();
        r110 = r113.getMeasuredHeight() + r106;
        if (r119 <= r112) goto L33;
        r112 = r119;
    L33:
        r105 = r118 + (((r114 + r115) + r113.getMeasuredWidth()) + this.f56925b);
        if (r111 != (getChildCount() - 1)) goto L36;
        r112 = r112 + r115;
        goto L36
    L21:
        if (this.f56926c == true) goto L23;
        r118 = getPaddingLeft();
        r106 = this.f56924a + r110;
        goto L25
    L17:
        r115 = 0;
        r114 = 0;
    L36:
        r111 = r111 + 1;
    L37:
        int r120 = r112 + getPaddingRight();
        int r121 = r110 + getPaddingBottom();
        if (r101 == Integer.MIN_VALUE) goto L42;
        int r122 = 1073741824;
        if (r101 == 1073741824) goto L43;
        r100 = r120;
    L43:
        if (r103 == Integer.MIN_VALUE) goto L46;
        if (r103 == r122) goto L47;
        r102 = r121;
    L47:
        setMeasuredDimension(r100, r102);
        return;
    L46:
        r102 = Math.min(r121, r102);
        goto L47
    L42:
        r122 = 1073741824;
        r100 = Math.min(r120, r100);
    L7:
        r104 = r100;
        goto L8
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f56926c = false;
        this.f56927d = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        boolean r114 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L9;
        r114 = false;
    L9:
        if (r114 == false) goto L11;
        int r101 = getPaddingRight();
    L12:
        if (r114 == false) goto L14;
        int r102 = getPaddingLeft();
    L15:
        int r103 = getPaddingTop();
        int r115 = (r112 - r110) - r102;
        int r104 = r101;
        int r116 = r103;
        int r105 = 0;
    L17:
        if (r105 >= getChildCount()) goto L40;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() == 8) goto L39;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        int r109 = MarginLayoutParamsCompat.getMarginStart(r108);
        int r117 = MarginLayoutParamsCompat.getMarginEnd(r108);
    L25:
        int r118 = (r104 + r109) + r106.getMeasuredWidth();
        boolean r119 = this.f56926c;
        if (r119 == true) goto L29;
        if (r118 <= r115) goto L29;
        r116 = this.f56924a + r103;
        r104 = r101;
    L29:
        if (r119 == false) goto L34;
        if (r118 <= r115) goto L34;
        if (this.f56927d == false) goto L34;
        r106.layout(0, 0, 0, 0);
    L34:
        int r120 = r104 + r109;
        int r121 = r106.getMeasuredWidth() + r120;
        int r122 = r106.getMeasuredHeight() + r116;
        if (r114 == false) goto L37;
        r106.layout(r115 - r121, r116, (r115 - r104) - r109, r122);
    L38:
        r104 = r104 + (((r109 + r117) + r106.getMeasuredWidth()) + this.f56925b);
        r103 = r122;
        goto L39
    L37:
        r106.layout(r120, r116, r121, r122);
        goto L38
    L24:
        r117 = 0;
        r109 = 0;
    L39:
        r105 = r105 + 1;
        goto L17
    L40:
        return;
    L14:
        r102 = getPaddingRight();
        goto L15
    L11:
        r101 = getPaddingLeft();
        goto L12
    }
}
