package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths;

    public BottomNavigationMenuView(@NonNull Context r10) {
        super(r10);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        setLayoutParams(r11);
        Resources r12 = getResources();
        this.inactiveItemMaxWidth = r12.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r12.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r12.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r12.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = r12.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.tempChildWidths = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context r10) {
        return new BottomNavigationItemView(r10);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = r13 - r11;
        int r17 = r14 - r12;
        int r18 = 0;
        int r19 = 0;
    L3:
        if (r18 >= r15) goto L13;
        View r20 = getChildAt(r18);
        if (r20.getVisibility() == 8) goto L12;
        if (ViewCompat.A(this) != 1) goto L10;
        int r21 = r16 - r19;
        r20.layout(r21 - r20.getMeasuredWidth(), 0, r21, r17);
    L11:
        r19 = r19 + r20.getMeasuredWidth();
        goto L12
    L10:
        r20.layout(r19, 0, r20.getMeasuredWidth() + r19, r17);
    L12:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        MenuBuilder r13 = getMenu();
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = r13.getVisibleItems().size();
        int r10 = getChildCount();
        int r16 = View.MeasureSpec.makeMeasureSpec(this.itemHeight, Ints.MAX_POWER_OF_TWO);
        int r17 = 1;
        if (isShifting(getLabelVisibilityMode(), r15) == true) goto L5;
    L30:
        if (r15 == 0) goto L33;
        r17 = r15;
    L33:
        int r18 = Math.min(r14 / r17, this.activeItemMaxWidth);
        int r19 = r14 - (r15 * r18);
        int r110 = 0;
    L34:
        if (r110 >= r10) goto L42;
        if (getChildAt(r110).getVisibility() == 8) goto L40;
        int[] r20 = this.tempChildWidths;
        r20[r110] = r18;
        if (r19 <= 0) goto L41;
        r20[r110] = r18 + 1;
        r19 = r19 - 1;
    L41:
        r110 = r110 + 1;
        goto L34
    L40:
        this.tempChildWidths[r110] = 0;
    L42:
        int r111 = 0;
        int r112 = 0;
    L43:
        if (r111 >= r10) goto L49;
        View r21 = getChildAt(r111);
        if (r21.getVisibility() == 8) goto L48;
        r21.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[r111], Ints.MAX_POWER_OF_TWO), r16);
        r21.getLayoutParams().width = r21.getMeasuredWidth();
        r112 = r112 + r21.getMeasuredWidth();
    L48:
        r111 = r111 + 1;
        goto L43
    L49:
        setMeasuredDimension(View.resolveSizeAndState(r112, View.MeasureSpec.makeMeasureSpec(r112, Ints.MAX_POWER_OF_TWO), 0), View.resolveSizeAndState(this.itemHeight, r16, 0));
        return;
    L5:
        if (isItemHorizontalTranslationEnabled() == false) goto L30;
        View r22 = getChildAt(getSelectedItemPosition());
        int r23 = this.activeItemMinWidth;
        if (r22.getVisibility() == 8) goto L10;
        r22.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r16);
        r23 = Math.max(r23, r22.getMeasuredWidth());
    L10:
        if (r22.getVisibility() == 8) goto L12;
        int r24 = 1;
    L13:
        int r113 = r15 - r24;
        int r25 = Math.min(r14 - (this.inactiveItemMinWidth * r113), Math.min(r23, this.activeItemMaxWidth));
        int r114 = r14 - r25;
        if (r113 != 0) goto L16;
        int r26 = 1;
    L17:
        int r27 = Math.min(r114 / r26, this.inactiveItemMaxWidth);
        int r115 = r114 - (r113 * r27);
        int r116 = 0;
    L18:
        if (r116 >= r10) goto L42;
        if (getChildAt(r116).getVisibility() == 8) goto L28;
        int[] r28 = this.tempChildWidths;
        if (r116 != getSelectedItemPosition()) goto L24;
        int r29 = r25;
    L25:
        r28[r116] = r29;
        if (r115 <= 0) goto L29;
        int[] r30 = this.tempChildWidths;
        r30[r116] = r30[r116] + 1;
        r115 = r115 - 1;
    L29:
        r116 = r116 + 1;
        goto L18
    L24:
        r29 = r27;
        goto L25
    L28:
        this.tempChildWidths[r116] = 0;
        goto L29
    L16:
        r26 = r113;
        goto L17
    L12:
        r24 = 0;
        goto L13
    }

    public void setItemHorizontalTranslationEnabled(boolean r10) {
        this.itemHorizontalTranslationEnabled = r10;
    }
}
