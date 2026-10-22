package com.bytedance.android.shopping.widget.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f187423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f187424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f187425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f187426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f187427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f187428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f187429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f187430h;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public FlowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public void setMaxLine(int r100) {
        this.f187430h = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 1;
    L3:
        if (r105 >= r104) goto L23;
        View r113 = getChildAt(r105);
        if (r113.getVisibility() == 8) goto L7;
        measureChild(r113, r210, r211);
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r114 = r102;
        int r115 = (r113.getMeasuredWidth() + r108.leftMargin) + r108.rightMargin;
        r107 = (r113.getMeasuredHeight() + r108.topMargin) + r108.bottomMargin;
        if ((r106 + r115) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L16;
        r110 = Math.max(r110, r106);
        int r116 = r115 + this.f187429g;
        r111 = r111 + r107;
        r112 = r112 + 1;
        int r109 = this.f187430h;
        if (r109 <= 0) goto L17;
        if (r112 <= r109) goto L17;
        r107 = r107;
    L24:
        if (r107 <= 0) goto L27;
        r111 = r111 + (((r111 / r107) - 1) * this.f187428f);
    L27:
        if (r101 == 1073741824) goto L30;
        r100 = getPaddingRight() + (r110 + getPaddingLeft());
    L30:
        if (r103 != 1073741824) goto L32;
        int r117 = r114;
    L33:
        setMeasuredDimension(r100, r117);
        return;
    L32:
        r117 = (r111 + getPaddingTop()) + getPaddingBottom();
    L17:
        int r118 = r116;
        if (r105 != (r104 - 1)) goto L21;
        r111 = r111 + r107;
        r110 = Math.max(r118, r110);
    L21:
        r106 = r118;
    L22:
        r105 = r105 + 1;
        r102 = r114;
        goto L3
    L16:
        r116 = r106 + (r115 + this.f187429g);
        r107 = Math.max(r107, r107);
        goto L17
    L7:
        if (r105 != (r104 - 1)) goto L9;
        r110 = Math.max(r106, r110);
        r111 = r111 + r107;
    L9:
        r114 = r102;
        goto L22
    L23:
        r114 = r102;
        goto L24
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f187423a = new ArrayList();
        this.f187424b = new ArrayList();
        this.f187425c = new ArrayList();
        this.f187427e = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.max_select_c, R.attr.tag_gravity_c, R.attr.tag_maxline_c, R.attr.tag_space_horizontal_c, R.attr.tag_space_vertical_c});
        int r104 = r103.getInt(1, -1);
        this.f187426d = r104;
        this.f187429g = r103.getDimensionPixelSize(3, 0);
        this.f187428f = r103.getDimensionPixelSize(4, 0);
        this.f187430h = r103.getInteger(2, 0);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r104 != (-1)) goto L6;
        this.f187426d = 1;
        goto L7
    L6:
        this.f187426d = -1;
    L7:
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f187423a).clear();
        ((ArrayList) this.f187424b).clear();
        ((ArrayList) this.f187425c).clear();
        this.f187427e.clear();
        int r100 = getWidth();
        int r101 = getChildCount();
        int r102 = 1;
        int r103 = 0;
        int r104 = 0;
        int r105 = 1;
        int r106 = 0;
    L4:
        if (r103 >= r101) goto L17;
        View r112 = getChildAt(r103);
        if (r112.getVisibility() == 8) goto L16;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112.getLayoutParams();
        int r114 = (r112.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        int r115 = (r112.getMeasuredHeight() + r113.topMargin) + r113.bottomMargin;
        if ((r114 + r104) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L15;
        r105 = r105 + 1;
        int r116 = this.f187430h;
        if (r116 <= 0) goto L14;
        if (r105 > r116) goto L17;
    L14:
        List<Integer> r107 = this.f187424b;
        ArrayList r108 = (ArrayList) r107;
        r108.add(Integer.valueOf(r106));
        List<List<View>> r109 = this.f187423a;
        ArrayList r117 = (ArrayList) r109;
        r117.add(this.f187427e);
        List<Integer> r118 = this.f187425c;
        ArrayList r119 = (ArrayList) r118;
        r119.add(Integer.valueOf(r104));
        this.f187427e = new ArrayList();
        r106 = r115;
        r104 = 0;
    L15:
        r104 = r104 + (r114 + this.f187429g);
        r106 = Math.max(r106, r115);
        this.f187427e.add(r112);
    L16:
        r103 = r103 + 1;
    L17:
        List<Integer> r120 = this.f187424b;
        ArrayList r121 = (ArrayList) r120;
        r121.add(Integer.valueOf(r106));
        List<Integer> r122 = this.f187425c;
        ArrayList r123 = (ArrayList) r122;
        r123.add(Integer.valueOf(r104));
        List<List<View>> r124 = this.f187423a;
        ArrayList r125 = (ArrayList) r124;
        r125.add(this.f187427e);
        int r126 = getPaddingLeft();
        int r127 = getPaddingTop();
        int r128 = ((ArrayList) this.f187423a).size();
        int r129 = 0;
    L18:
        if (r129 >= r128) goto L35;
        List<View> r130 = (List) ListProtector.get(this.f187423a, r129);
        this.f187427e = r130;
        int r131 = r130.size();
        int r132 = ((Integer) ListProtector.get(this.f187424b, r129)).intValue() + this.f187428f;
        int r133 = ((Integer) ListProtector.get(this.f187425c, r129)).intValue();
        int r134 = this.f187426d;
        if (r134 == (-1)) goto L26;
        if (r134 == 0) goto L25;
        if (r134 != r102) goto L27;
        r126 = (r100 - (r133 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.f187427e);
    L27:
        int r135 = 0;
    L28:
        if (r135 >= r131) goto L34;
        View r136 = (View) ListProtector.get(this.f187427e, r135);
        if (r136.getVisibility() == 8) goto L33;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136.getLayoutParams();
        int r138 = r137.leftMargin + r126;
        int r139 = r137.topMargin + r127;
        r136.layout(r138, r139, r138 + r136.getMeasuredWidth(), r139 + r136.getMeasuredHeight());
        r126 = r126 + (((r136.getMeasuredWidth() + r137.leftMargin) + r137.rightMargin) + this.f187429g);
    L33:
        r135 = r135 + 1;
        goto L28
    L34:
        r127 = r127 + r132;
        r129 = r129 + 1;
        r102 = 1;
        goto L18
    L25:
        r126 = ((r100 - r133) / 2) + getPaddingLeft();
        goto L27
    L26:
        r126 = getPaddingLeft();
        goto L27
    }
}
