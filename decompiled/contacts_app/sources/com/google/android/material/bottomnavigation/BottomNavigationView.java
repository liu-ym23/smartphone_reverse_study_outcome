package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {
    private static final int MAX_ITEM_COUNT = 5;

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public BottomNavigationView(Context r2) {
        this(r2, null);
    }

    public BottomNavigationView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(Context r8, AttributeSet r9, int r10, int r11) {
        super(r8, r9, r10, r11);
        Context r12 = getContext();
        TintTypedArray r13 = ThemeEnforcement.obtainTintedStyledAttributes(r12, r9, R.styleable.BottomNavigationView, r10, r11, new int[0]);
        setItemHorizontalTranslationEnabled(r13.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if (r13.hasValue(R.styleable.BottomNavigationView_android_minHeight) == false) goto L6;
        setMinimumHeight(r13.getDimensionPixelSize(R.styleable.BottomNavigationView_android_minHeight, 0));
    L6:
        if (r13.getBoolean(R.styleable.BottomNavigationView_compatShadowEnabled, true) == true) goto L8;
    L10:
        r13.recycle();
        applyWindowInsets();
        return;
    L8:
        if (shouldDrawCompatibilityTopDivider() == false) goto L10;
        addCompatibilityTopDivider(r12);
        goto L10
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1(this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, makeMinHeightSpec(r2));
    }

    private int makeMinHeightSpec(int r4) {
        int r0 = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(r4) == 1073741824) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = r0 + (getPaddingTop() + getPaddingBottom());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), r1), 1073741824);
    L7:
        return r4;
    }

    public void setItemHorizontalTranslationEnabled(boolean r3) {
        BottomNavigationMenuView r0 = (BottomNavigationMenuView) getMenuView();
        if (r0.isItemHorizontalTranslationEnabled() == r3) goto L6;
        r0.setItemHorizontalTranslationEnabled(r3);
        getPresenter().updateMenuView(false);
        return;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected NavigationBarMenuView createNavigationBarMenuView(Context r1) {
        return new BottomNavigationMenuView(r1);
    }

    private void addCompatibilityTopDivider(Context r4) {
        View r0 = new View(r4);
        r0.setBackgroundColor(ContextCompat.getColor(r4, R.color.design_bottom_navigation_shadow_color));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r0);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener r1) {
        setOnItemSelectedListener(r1);
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener r1) {
        setOnItemReselectedListener(r1);
    }
}
