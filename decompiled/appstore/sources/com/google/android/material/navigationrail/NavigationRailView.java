package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.b0;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;

    @Nullable
    private View headerView;
    private final int topMargin;

    public NavigationRailView(@NonNull Context r10) {
        this(r10, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean isHeaderViewVisible() {
        View r10 = this.headerView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() == 8) goto L7;
        return true;
    }

    private int makeMinWidthSpec(int r10) {
        int r11 = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L7;
        if (r11 <= 0) goto L7;
        int r12 = r11 + (getPaddingLeft() + getPaddingRight());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r10), r12), Ints.MAX_POWER_OF_TWO);
    L7:
        return r10;
    }

    public void addHeaderView(@LayoutRes int r10) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(r10, this, false));
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public /* bridge */ /* synthetic */ NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r10) {
        return createNavigationBarMenuView(r10);
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        NavigationRailMenuView r15 = getNavigationRailMenuView();
        int r16 = 0;
        if (isHeaderViewVisible() == false) goto L8;
        int r17 = this.headerView.getBottom() + this.topMargin;
        int r18 = r15.getTop();
        if (r18 >= r17) goto L10;
        r16 = r17 - r18;
    L10:
        if (r16 <= 0) goto L13;
        r15.layout(r15.getLeft(), r15.getTop() + r16, r15.getRight(), r15.getBottom() + r16);
        return;
    L13:
        return;
    L8:
        if (r15.isTopGravity() == false) goto L10;
        r16 = this.topMargin;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = makeMinWidthSpec(r10);
        super.onMeasure(r12, r11);
        if (isHeaderViewVisible() == false) goto L6;
        int r13 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE);
        measureChild(getNavigationRailMenuView(), r12, r13);
        return;
    }

    public void removeHeaderView() {
        View r10 = this.headerView;
        if (r10 == null) goto L6;
        removeView(r10);
        this.headerView = null;
        return;
    }

    public void setMenuGravity(int r10) {
        getNavigationRailMenuView().setMenuGravity(r10);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.navigationRailStyle);
    }

    public void addHeaderView(@NonNull View r10) {
        removeHeaderView();
        this.headerView = r10;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 49;
        r11.topMargin = this.topMargin;
        addView(r10, 0, r11);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context r10) {
        return new NavigationRailMenuView(r10);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.topMargin = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        b0 r14 = ThemeEnforcement.obtainTintedStyledAttributes(getContext(), r11, R.styleable.NavigationRailView, r12, r13, new int[0]);
        int r15 = r14.n(R.styleable.NavigationRailView_headerLayout, 0);
        if (r15 == 0) goto L5;
        addHeaderView(r15);
    L5:
        setMenuGravity(r14.k(R.styleable.NavigationRailView_menuGravity, 49));
        r14.w();
    }
}
