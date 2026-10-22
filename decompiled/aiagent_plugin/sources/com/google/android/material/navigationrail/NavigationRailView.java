package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.y;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private View headerView;
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    static /* synthetic */ Boolean access$000(NavigationRailView r0) {
        return r0.paddingTopSystemWindowInsets;
    }

    static /* synthetic */ boolean access$100(NavigationRailView r0, Boolean r1) {
        return r0.shouldApplyWindowInsetPadding(r1);
    }

    static /* synthetic */ Boolean access$200(NavigationRailView r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public /* synthetic */ NavigationBarMenuView createNavigationBarMenuView(Context r3) {
        return createNavigationBarMenuView((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public NavigationRailView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public NavigationRailView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.navigationRailStyle, "attr", "navigationRailStyle"));
    }

    public NavigationRailView(Context r4, AttributeSet r5, int r6) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), r6, ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_NavigationRailView, "style", "Widget_MaterialComponents_NavigationRailView"));
    }

    public NavigationRailView(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r13, r3, r11, r12);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.topMargin = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_navigation_rail_margin, "dimen", "mtrl_navigation_rail_margin"));
        y r14 = l.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, R.styleable.NavigationRailView, r11, r12, new int[0]);
        int r15 = r14.g(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_headerLayout, "styleable", "NavigationRailView_headerLayout"), 0);
        if (r15 == 0) goto L5;
        addHeaderView(r15);
    L5:
        setMenuGravity(r14.a(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_menuGravity, "styleable", "NavigationRailView_menuGravity"), 49));
        if (r14.g(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_itemMinHeight, "styleable", "NavigationRailView_itemMinHeight")) == false) goto L9;
        setItemMinimumHeight(r14.e(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_itemMinHeight, "styleable", "NavigationRailView_itemMinHeight"), -1));
    L9:
        if (r14.g(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, "styleable", "NavigationRailView_paddingTopSystemWindowInsets")) == false) goto L12;
        this.paddingTopSystemWindowInsets = Boolean.valueOf(r14.a(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, "styleable", "NavigationRailView_paddingTopSystemWindowInsets"), false));
    L12:
        if (r14.g(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, "styleable", "NavigationRailView_paddingBottomSystemWindowInsets")) == false) goto L14;
        this.paddingBottomSystemWindowInsets = Boolean.valueOf(r14.a(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, "styleable", "NavigationRailView_paddingBottomSystemWindowInsets"), false));
    L14:
        r14.b();
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        r.a(this, new AnonymousClass1(this));
    }

    private boolean shouldApplyWindowInsetPadding(Boolean r1) {
        if (r1 == null) goto L5;
        return r1.booleanValue();
    L5:
        return ViewCompat.v(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        int r4 = makeMinWidthSpec(r2);
        super.onMeasure(r4, r3);
        if (isHeaderViewVisible() == false) goto L6;
        int r5 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE);
        measureChild(getNavigationRailMenuView(), r4, r5);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        NavigationRailMenuView r6 = getNavigationRailMenuView();
        int r7 = 0;
        if (isHeaderViewVisible() == false) goto L8;
        int r8 = this.headerView.getBottom() + this.topMargin;
        int r0 = r6.getTop();
        if (r0 >= r8) goto L10;
        r7 = r8 - r0;
    L10:
        if (r7 <= 0) goto L13;
        r6.layout(r6.getLeft(), r6.getTop() + r7, r6.getRight(), r6.getBottom() + r7);
        return;
    L13:
        return;
    L8:
        if (r6.isTopGravity() == false) goto L10;
        r7 = this.topMargin;
        goto L10
    }

    public void addHeaderView(int r4) {
        addHeaderView(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, this, false, "com.obric.aiagent.plugin"));
    }

    public void addHeaderView(View r3) {
        removeHeaderView();
        this.headerView = r3;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 49;
        r0.topMargin = this.topMargin;
        addView(r3, 0, r0);
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public void removeHeaderView() {
        View r0 = this.headerView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.headerView = null;
        return;
    }

    public void setMenuGravity(int r1) {
        getNavigationRailMenuView().setMenuGravity(r1);
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), NavigationRailMenuView.class, "com.obric.aiagent.plugin")).getItemMinimumHeight();
    }

    public void setItemMinimumHeight(int r3) {
        ((NavigationRailMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), NavigationRailMenuView.class, "com.obric.aiagent.plugin")).setItemMinimumHeight(r3);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), NavigationRailMenuView.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public NavigationRailMenuView createNavigationBarMenuView(Context r2) {
        return new NavigationRailMenuView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private int makeMinWidthSpec(int r4) {
        int r0 = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(r4) == 1073741824) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = r0 + (getPaddingLeft() + getPaddingRight());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), r1), 1073741824);
    L7:
        return r4;
    }

    private boolean isHeaderViewVisible() {
        View r1 = this.headerView;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getVisibility() == 8) goto L7;
        return true;
    }
}
