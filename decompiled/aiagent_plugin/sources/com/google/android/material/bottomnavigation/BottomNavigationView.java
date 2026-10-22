package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.y;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {
    static final int MAX_ITEM_COUNT = 5;

    @Deprecated
    public interface a extends NavigationBarView.a {
    }

    @Deprecated
    public interface b extends NavigationBarView.b {
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public BottomNavigationView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public BottomNavigationView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.bottomNavigationStyle, "attr", "bottomNavigationStyle"));
    }

    public BottomNavigationView(Context r4, AttributeSet r5, int r6) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), r6, ZeusTransformUtils.mapRes(R.style.Widget_Design_BottomNavigationView, "style", "Widget_Design_BottomNavigationView"));
    }

    public BottomNavigationView(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r13, r3, r11, r12);
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        y r15 = l.b(r14, r3, R.styleable.BottomNavigationView, r11, r12, new int[0]);
        setItemHorizontalTranslationEnabled(r15.a(ZeusTransformUtils.mapRes(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, "styleable", "BottomNavigationView_itemHorizontalTranslationEnabled"), true));
        if (r15.g(ZeusTransformUtils.mapRes(R.styleable.BottomNavigationView_android_minHeight, "styleable", "BottomNavigationView_android_minHeight")) == false) goto L5;
        setMinimumHeight(r15.e(ZeusTransformUtils.mapRes(R.styleable.BottomNavigationView_android_minHeight, "styleable", "BottomNavigationView_android_minHeight"), 0));
    L5:
        r15.b();
        if (shouldDrawCompatibilityTopDivider() == false) goto L8;
        addCompatibilityTopDivider(r14);
    L8:
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        r.a(this, new AnonymousClass1(this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
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

    public void setItemHorizontalTranslationEnabled(boolean r4) {
        BottomNavigationMenuView r0 = (BottomNavigationMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), BottomNavigationMenuView.class, "com.obric.aiagent.plugin");
        if (r0.isItemHorizontalTranslationEnabled() == r4) goto L6;
        r0.setItemHorizontalTranslationEnabled(r4);
        getPresenter().updateMenuView(false);
        return;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), BottomNavigationMenuView.class, "com.obric.aiagent.plugin")).isItemHorizontalTranslationEnabled();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public NavigationBarMenuView createNavigationBarMenuView(Context r2) {
        return new BottomNavigationMenuView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(getBackground(), MaterialShapeDrawable.class) == true) goto L7;
        return true;
    }

    private void addCompatibilityTopDivider(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        View r0 = new View(r7);
        r0.setBackgroundColor(androidx.core.content.a.c(r7, ZeusTransformUtils.mapRes(R.color.design_bottom_navigation_shadow_color, "color", "design_bottom_navigation_shadow_color")));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_bottom_navigation_shadow_height, "dimen", "design_bottom_navigation_shadow_height"))));
        addView(r0);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(b r3) {
        setOnItemSelectedListener((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(a r3) {
        setOnItemReselectedListener((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"));
    }
}
