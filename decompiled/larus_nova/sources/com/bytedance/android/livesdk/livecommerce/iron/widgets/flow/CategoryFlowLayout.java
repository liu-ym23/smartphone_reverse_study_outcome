package com.bytedance.android.livesdk.livecommerce.iron.widgets.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.TopCategoryView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class CategoryFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f149220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f149221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f149222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f149223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f149224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f149225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f149226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f149227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f149228i;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public int getNumOfLines() {
        return ((ArrayList) this.f149220a).size();
    }

    public CategoryFlowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public void setMaxLine(int r100) {
        this.f149227h = r100;
    }

    public void setSpaceV(int r100) {
        this.f149225f = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public CategoryFlowLayout(Context r100, AttributeSet r101) {
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
        if (r105 >= r104) goto L30;
        View r113 = getChildAt(r105);
        if (r113.getVisibility() == 8) goto L7;
        measureChild(r113, r210, r211);
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r114 = r102;
        int r115 = (r113.getMeasuredWidth() + r108.leftMargin) + r108.rightMargin;
        r111 = (r113.getMeasuredHeight() + r108.topMargin) + r108.bottomMargin;
        if ((r106 + r115) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L18;
        r107 = Math.max(r107, r106);
        int r116 = r115 + this.f149226g;
        r110 = r110 + r111;
        r112 = r112 + 1;
        int r109 = this.f149227h;
        if (r109 <= 0) goto L16;
        if (r112 <= r109) goto L16;
        r111 = r111;
    L31:
        if (r111 <= 0) goto L34;
        r110 = r110 + (((r110 / r111) - 1) * this.f149225f);
    L34:
        if (r101 == 1073741824) goto L37;
        r100 = getPaddingRight() + (r107 + getPaddingLeft());
    L37:
        if (r103 != 1073741824) goto L39;
        int r117 = r114;
    L40:
        setMeasuredDimension(r100, r117);
        return;
    L39:
        r117 = (r110 + getPaddingTop()) + getPaddingBottom();
    L16:
        int r118 = r116;
        if (r105 != (r104 - 1)) goto L28;
        r110 = r110 + r111;
        r107 = Math.max(r118, r107);
    L28:
        r106 = r118;
    L29:
        r105 = r105 + 1;
        r102 = r114;
        goto L3
    L18:
        if ((r113 instanceof ei2.a) == true) goto L20;
    L22:
        r116 = r106 + (r115 + this.f149226g);
    L23:
        r111 = Math.max(r111, r111);
        goto L16
    L20:
        if (((ei2.a) r113).getType() != 1) goto L22;
        r116 = (r100 - getPaddingLeft()) - getPaddingRight();
        goto L23
    L7:
        if (r105 != (r104 - 1)) goto L9;
        r107 = Math.max(r106, r107);
        r110 = r110 + r111;
    L9:
        r114 = r102;
        goto L29
    L30:
        r114 = r102;
        goto L31
    }

    public CategoryFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f149220a = new ArrayList();
        this.f149221b = new ArrayList();
        this.f149222c = new ArrayList();
        this.f149224e = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.max_select_cc, R.attr.tag_gravity_cc, R.attr.tag_maxline_cc, R.attr.tag_space_horizontal_cc, R.attr.tag_space_vertical_cc});
        int r104 = r103.getInt(1, -1);
        this.f149223d = r104;
        this.f149226g = r103.getDimensionPixelSize(3, 0);
        this.f149225f = r103.getDimensionPixelSize(4, 0);
        this.f149227h = r103.getInteger(2, 0);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r104 != (-1)) goto L6;
        this.f149223d = 1;
        goto L7
    L6:
        this.f149223d = -1;
    L7:
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f149220a).clear();
        ((ArrayList) this.f149221b).clear();
        ((ArrayList) this.f149222c).clear();
        this.f149224e.clear();
        int r100 = getWidth();
        View r101 = (View) getParent();
        int r102 = (r101.getHeight() - r101.getPaddingBottom()) - r101.getPaddingTop();
        this.f149228i = 0;
        int r103 = getChildCount();
        int r104 = 1;
        int r105 = 0;
        int r106 = 0;
        int r107 = 1;
        int r108 = 0;
    L3:
        int r112 = 8;
        if (r105 >= r103) goto L23;
        View r113 = getChildAt(r105);
        if (r113.getVisibility() == 8) goto L22;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r115 = (r113.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
        int r116 = (r113.getMeasuredHeight() + r114.topMargin) + r114.bottomMargin;
        if ((r115 + r106) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L16;
        r107 = r107 + 1;
        int r117 = this.f149227h;
        if (r117 <= 0) goto L14;
        if (r107 > r117) goto L23;
    L14:
        List<Integer> r118 = this.f149221b;
        ArrayList r119 = (ArrayList) r118;
        r119.add(Integer.valueOf(r108));
        List<List<View>> r109 = this.f149220a;
        ArrayList r120 = (ArrayList) r109;
        r120.add(this.f149224e);
        List<Integer> r121 = this.f149222c;
        ArrayList r122 = (ArrayList) r121;
        r122.add(Integer.valueOf(r106));
        this.f149224e = new ArrayList();
        r108 = r116;
        r106 = 0;
    L16:
        if ((r113 instanceof ei2.a) == true) goto L18;
    L20:
        r106 = r106 + (r115 + this.f149226g);
    L21:
        r108 = Math.max(r108, r116);
        this.f149224e.add(r113);
        goto L22
    L18:
        if (((ei2.a) r113).getType() != 1) goto L20;
        r106 = (r100 - getPaddingLeft()) - getPaddingRight();
    L22:
        r105 = r105 + 1;
    L23:
        List<Integer> r123 = this.f149221b;
        ArrayList r124 = (ArrayList) r123;
        r124.add(Integer.valueOf(r108));
        List<Integer> r125 = this.f149222c;
        ArrayList r126 = (ArrayList) r125;
        r126.add(Integer.valueOf(r106));
        List<List<View>> r127 = this.f149220a;
        ArrayList r128 = (ArrayList) r127;
        r128.add(this.f149224e);
        int r129 = getPaddingLeft();
        int r130 = getPaddingTop();
        int r131 = ((ArrayList) this.f149220a).size();
        int r132 = 0;
    L24:
        if (r132 >= r131) goto L54;
        List<View> r133 = (List) ListProtector.get(this.f149220a, r132);
        this.f149224e = r133;
        int r134 = r133.size();
        int r135 = ((Integer) ListProtector.get(this.f149221b, r132)).intValue() + this.f149225f;
        int r136 = ((Integer) ListProtector.get(this.f149222c, r132)).intValue();
        int r137 = this.f149223d;
        if (r137 == (-1)) goto L32;
        if (r137 == 0) goto L31;
        if (r137 != r104) goto L33;
        r129 = (r100 - (r136 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.f149224e);
    L33:
        int r138 = 0;
    L34:
        if (r138 >= r134) goto L50;
        View r139 = (View) ListProtector.get(this.f149224e, r138);
        if (r139.getVisibility() != r112) goto L38;
        int r213 = r100;
    L49:
        r138 = r138 + 1;
        r100 = r213;
        r104 = 1;
        r112 = 8;
        goto L34
    L38:
        ViewGroup.MarginLayoutParams r140 = (ViewGroup.MarginLayoutParams) r139.getLayoutParams();
        boolean r141 = r139 instanceof ei2.a;
        if (r141 == true) goto L41;
    L43:
        int r142 = r140.leftMargin + r129;
    L44:
        int r143 = r140.topMargin + r130;
        r213 = r100;
        r139.layout(r142, r143, r142 + r139.getMeasuredWidth(), r143 + r139.getMeasuredHeight());
        r129 = r129 + (((r139.getMeasuredWidth() + r140.leftMargin) + r140.rightMargin) + this.f149226g);
        if (r141 == false) goto L49;
        ei2.a r144 = (ei2.a) r139;
        if ((r144.getTagView() instanceof TopCategoryView) == false) goto L49;
        ((TopCategoryView) r144.getTagView()).setTabRow(r132 + 1);
        goto L49
    L41:
        if (((ei2.a) r139).getType() != r104) goto L43;
        r142 = (r100 - getPaddingRight()) - r139.getMeasuredWidth();
        goto L44
    L50:
        int r214 = r100;
        r130 = r130 + r135;
        if ((r130 - this.f149225f) > r102) goto L53;
        this.f149228i = r132 + 1;
    L53:
        r132 = r132 + 1;
        r100 = r214;
        r104 = 1;
        r112 = 8;
        goto L24
    L31:
        r129 = ((r100 - r136) / 2) + getPaddingLeft();
        goto L33
    L32:
        r129 = getPaddingLeft();
        goto L33
    }
}
