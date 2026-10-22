package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ScorllingViewBehavior.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f36688c = null;

    /* JADX INFO: compiled from: ScorllingViewBehavior.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ int a(a r0, OUnitedTitleBar r1) {
            return r0.a(r1);
        }

        private final int a(OUnitedTitleBar r2) {
            ViewGroup.LayoutParams r1 = r2.getLayoutParams();
            Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.b r3 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
            if (ZeusTransformUtils.instanceOf(r3, OUnitedTitleBar.Behavior.class) == true) goto L7;
            return 0;
        L7:
            return ((OUnitedTitleBar.Behavior) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.Behavior.class, "com.obric.aiagent.plugin")).b();
        }
    }

    static {
        f36688c = new a(null);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public /* synthetic */ View a(List r3) {
        return (View) ZeusTransformUtils.preCheckCast(b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")), View.class, "com.obric.aiagent.plugin");
    }

    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.ScrollingViewBehavior_Layout);
        o.c(r7, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        b(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, "styleable", "ScrollingViewBehavior_Layout_behavior_overlapTop"), 0));
        r7.recycle();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, View r2, View r3) {
        o.e(r1, "parent");
        o.e(r2, "child");
        o.e(r3, "dependency");
        return ZeusTransformUtils.instanceOf(r3, OUnitedTitleBar.class);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r2, View r3, View r4) {
        o.e(r2, "parent");
        o.e(r3, "child");
        o.e(r4, "dependency");
        a(r3, r4);
        b(r3, r4);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void c(CoordinatorLayout r1, View r2, View r3) {
        o.e(r1, "parent");
        o.e(r2, "child");
        o.e(r3, "dependency");
        if (ZeusTransformUtils.instanceOf(r3, OUnitedTitleBar.class) == false) goto L6;
        ViewCompat.d((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), androidx.core.view.accessibility.b.a.m.a());
        ViewCompat.d((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), androidx.core.view.accessibility.b.a.n.a());
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r3, View r4, Rect r5, boolean r6) {
        o.e(r3, "parent");
        o.e(r4, "child");
        o.e(r5, "rectangle");
        List<View> r7 = r3.getDependencies(r4);
        o.c(r7, "parent.getDependencies(child)");
        OUnitedTitleBar r8 = b(r7);
        if (r8 == null) goto L8;
        Rect r1 = new Rect(r5);
        r1.offset(r4.getLeft(), r4.getTop());
        Rect r2 = this.f36684a;
        r2.set(0, 0, r3.getWidth(), r3.getHeight());
        if (r2.contains(r1) == true) goto L8;
        r8.setExpanded(false);
        return true;
    L8:
        return false;
    }

    private final void a(View r5, View r6) {
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.b r1 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r1, BaseBehavior.class) == false) goto L6;
        ViewCompat.f(r5, (((r6.getBottom() - r5.getTop()) + ((BaseBehavior) ZeusTransformUtils.preCheckCast(r1, BaseBehavior.class, "com.obric.aiagent.plugin")).f36661a) + c()) - b(r6));
        return;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public float a(View r6) {
        o.e(r6, "header");
        if (ZeusTransformUtils.instanceOf(r6, OUnitedTitleBar.class) == false) goto L13;
        int r5 = ((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r6, OUnitedTitleBar.class, "com.obric.aiagent.plugin")).getTotalScrollRange();
        int r2 = ((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r6, OUnitedTitleBar.class, "com.obric.aiagent.plugin")).getDownNestedPreScrollRange();
        int r7 = a.a(f36688c, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r6, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        if (r2 != 0) goto L7;
    L9:
        int r8 = r5 - r2;
        if (r8 == 0) goto L13;
        return (r7 / r8) + 1.0f;
    L7:
        if ((r5 + r7) > r2) goto L9;
        return 0.0f;
    L13:
        return 0.0f;
    }

    public OUnitedTitleBar b(List<? extends View> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "views");
        int r6 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L9;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r4.get(r1), View.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, OUnitedTitleBar.class) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r2, OUnitedTitleBar.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public int c(View r2) {
        o.e(r2, "v");
        if (ZeusTransformUtils.instanceOf(r2, OUnitedTitleBar.class) == false) goto L6;
        return ((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r2, OUnitedTitleBar.class, "com.obric.aiagent.plugin")).getTotalScrollRange();
    L6:
        return super.c(r2);
    }

    private final void b(View r1, View r2) {
        ZeusTransformUtils.instanceOf(r2, OUnitedTitleBar.class);
    }
}
