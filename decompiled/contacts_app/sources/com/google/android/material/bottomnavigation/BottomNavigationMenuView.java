package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths;

    public BottomNavigationMenuView(Context r2) {
        super(r2);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        setLayoutParams(r3);
        Resources r4 = getResources();
        this.inactiveItemMaxWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // android.view.View
    protected void onMeasure(int r12, int r13) {
        MenuBuilder r0 = getMenu();
        int r14 = View.MeasureSpec.getSize(r12);
        int r1 = r0.getVisibleItems().size();
        int r2 = getChildCount();
        this.tempChildWidths.clear();
        int r15 = View.MeasureSpec.getSize(r13);
        int r3 = View.MeasureSpec.makeMeasureSpec(r15, 1073741824);
        int r6 = 0;
        int r7 = 1;
        if (isShifting(getLabelVisibilityMode(), r1) == true) goto L5;
    L29:
        if (r1 == 0) goto L32;
        r7 = r1;
    L32:
        int r4 = Math.min(r14 / r7, this.activeItemMaxWidth);
        int r16 = r14 - (r1 * r4);
        int r5 = 0;
    L33:
        if (r5 >= r2) goto L41;
        if (getChildAt(r5).getVisibility() == 8) goto L39;
        if (r16 <= 0) goto L38;
        int r8 = r4 + 1;
        r16 = r16 - 1;
    L40:
        this.tempChildWidths.add(Integer.valueOf(r8));
        r5 = r5 + 1;
        goto L33
    L38:
        r8 = r4;
        goto L40
    L39:
        r8 = 0;
    L41:
        int r17 = 0;
    L42:
        if (r6 >= r2) goto L48;
        View r9 = getChildAt(r6);
        if (r9.getVisibility() == 8) goto L47;
        r9.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(r6).intValue(), 1073741824), r3);
        r9.getLayoutParams().width = r9.getMeasuredWidth();
        r17 = r17 + r9.getMeasuredWidth();
    L47:
        r6 = r6 + 1;
        goto L42
    L48:
        setMeasuredDimension(r17, r15);
        return;
    L5:
        if (isItemHorizontalTranslationEnabled() == false) goto L29;
        View r10 = getChildAt(getSelectedItemPosition());
        int r11 = this.activeItemMinWidth;
        if (r10.getVisibility() == 8) goto L10;
        r10.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r3);
        r11 = Math.max(r11, r10.getMeasuredWidth());
    L10:
        if (r10.getVisibility() == 8) goto L12;
        int r18 = 1;
    L13:
        int r19 = r1 - r18;
        int r20 = Math.min(r14 - (this.inactiveItemMinWidth * r19), Math.min(r11, this.activeItemMaxWidth));
        int r110 = r14 - r20;
        if (r19 == 0) goto L17;
        r7 = r19;
    L17:
        int r21 = Math.min(r110 / r7, this.inactiveItemMaxWidth);
        int r111 = r110 - (r19 * r21);
        int r22 = 0;
    L18:
        if (r22 >= r2) goto L41;
        if (getChildAt(r22).getVisibility() != 8) goto L22;
        int r23 = 0;
    L28:
        this.tempChildWidths.add(Integer.valueOf(r23));
        r22 = r22 + 1;
        goto L18
    L22:
        if (r22 != getSelectedItemPosition()) goto L24;
        r23 = r20;
    L25:
        if (r111 <= 0) goto L28;
        r23 = r23 + 1;
        r111 = r111 - 1;
        goto L28
    L24:
        r23 = r21;
        goto L25
    L12:
        r18 = 0;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = r8 - r6;
        int r12 = r9 - r7;
        int r13 = 0;
        int r0 = 0;
    L3:
        if (r13 >= r10) goto L13;
        View r1 = getChildAt(r13);
        if (r1.getVisibility() == 8) goto L12;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        int r2 = r11 - r0;
        r1.layout(r2 - r1.getMeasuredWidth(), 0, r2, r12);
    L11:
        r0 = r0 + r1.getMeasuredWidth();
        goto L12
    L10:
        r1.layout(r0, 0, r1.getMeasuredWidth() + r0, r12);
    L12:
        r13 = r13 + 1;
        goto L3
    }

    public void setItemHorizontalTranslationEnabled(boolean r1) {
        this.itemHorizontalTranslationEnabled = r1;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView createNavigationBarItemView(Context r1) {
        return new BottomNavigationItemView(r1);
    }
}
