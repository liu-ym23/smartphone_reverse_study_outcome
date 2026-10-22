package com.stepos.widget.tabbar;

import Y8.t;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.stepos.widget.R;
import com.stepos.widget.glass.StepOSGlassPanel;
import kotlin.Metadata;
import n9.C4946a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBarContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroid/graphics/drawable/Drawable;", "background", "LY8/t;", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "fitSystemWindows", "setFitsSystemWindows", "(Z)V", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "constructed", "Z", "Lcom/stepos/widget/glass/StepOSGlassPanel;", "glassPanel", "Lcom/stepos/widget/glass/StepOSGlassPanel;", "getGlassPanel", "()Lcom/stepos/widget/glass/StepOSGlassPanel;", "Lcom/stepos/widget/tabbar/StepOSTabBar;", "tabBar", "Lcom/stepos/widget/tabbar/StepOSTabBar;", "getTabBar", "()Lcom/stepos/widget/tabbar/StepOSTabBar;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSTabBarContainer extends FrameLayout {
    private boolean constructed;
    private final StepOSGlassPanel glassPanel;
    private final StepOSTabBar tabBar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBarContainer(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        kotlin.jvm.internal.p.i(child, "child");
        throw new IllegalStateException(("StepOSTabBarContainer 不接受子 View（收到 " + child.getClass().getName() + "）：它是「StepOSGlassPanel + 居中 StepOSTabBar」这一种固定组合的便利容器，内部两层在构造时就摆好了。加页签请用 tabBar.inflateMenu() / newTab()+addTab()；要在旁边放别的 View 请不要用本容器，直接自己写 StepOSGlassPanel + StepOSTabBar 两层").toString());
    }

    public final StepOSGlassPanel getGlassPanel() {
        return this.glassPanel;
    }

    public final StepOSTabBar getTabBar() {
        return this.tabBar;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.p.i(insets, "insets");
        return insets;
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (this.constructed) {
            this.glassPanel.setBackground(background);
        } else {
            super.setBackground(background);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        super.setFitsSystemWindows(fitSystemWindows);
        if (this.constructed) {
            this.glassPanel.setFitsSystemWindows(fitSystemWindows);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBarContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBarContainer(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSTabBarContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposTabBarContainerStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_TabBarContainer : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTabBarContainer(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        StepOSGlassPanel stepOSGlassPanel = new StepOSGlassPanel(context, null, 0, 0, 14, null);
        this.glassPanel = stepOSGlassPanel;
        StepOSTabBar stepOSTabBar = new StepOSTabBar(context, null, 0, 0, 14, null);
        this.tabBar = stepOSTabBar;
        stepOSTabBar.setId(R.id.stepos_tabbar_container_tab_bar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        t tVar = t.f7040a;
        super.addView(stepOSGlassPanel, 0, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_height));
        layoutParams2.gravity = 81;
        stepOSGlassPanel.addView(stepOSTabBar, layoutParams2);
        stepOSGlassPanel.setFitsSystemWindows(getFitsSystemWindows());
        Drawable background = getBackground();
        super.setBackground(null);
        if (background != null) {
            stepOSGlassPanel.setBackground(background);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSTabBarContainer, i10, i11);
        try {
            int i12 = R.styleable.StepOSTabBarContainer_steposGlassScope;
            if (typedArrayObtainStyledAttributes.hasValue(i12)) {
                stepOSGlassPanel.setGlassScope(typedArrayObtainStyledAttributes.getInt(i12, 0));
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTabBarContainer_steposTabBarMenu, 0);
            if (resourceId != 0) {
                stepOSTabBar.inflateMenu(resourceId);
            }
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTabBarContainer_steposGlassScrim, 0);
            if (resourceId2 != 0) {
                stepOSGlassPanel.setScrimResource(resourceId2);
            }
            int i13 = R.styleable.StepOSTabBarContainer_steposGlassScrimEnabled;
            if (typedArrayObtainStyledAttributes.hasValue(i13)) {
                stepOSGlassPanel.setScrimEnabled(typedArrayObtainStyledAttributes.getBoolean(i13, true));
            }
            C4946a.a(typedArrayObtainStyledAttributes, null);
            this.constructed = true;
        } finally {
        }
    }
}
