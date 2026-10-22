package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.common.oui.R$styleable;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001!B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u0004\u0018\u00010 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eH\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u000bH\u0014¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010(¨\u0006+"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior;", "Lcom/obric/oui/titlebar/behavior/HeaderScrollingViewBehavior;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "Landroid/view/View;", "child", "dependency", "", "layoutDependsOn", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z", "onDependentViewChanged", "", "onDependentViewRemoved", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V", "Landroid/graphics/Rect;", "rectangle", "immediate", "onRequestChildRectangleOnScreen", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/graphics/Rect;Z)Z", "header", "", "getOverlapRatioForOffset", "(Landroid/view/View;)F", "", "views", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "a", "(Ljava/util/List;)Lcom/obric/oui/titlebar/OUnitedTitleBar;", "v", "", "getScrollRange", "(Landroid/view/View;)I", "offsetChildAsNeeded", "(Landroid/view/View;Landroid/view/View;)V", "updateLiftedStateIfNeeded", "h", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f17527h = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int a(a r10, OUnitedTitleBar r11) {
            return r10.b(r11);
        }

        public final int b(OUnitedTitleBar r10) {
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            if (r11 == null) goto L10;
            CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.c) r11).f();
            if ((r12 instanceof OUnitedTitleBar.Behavior) == true) goto L11;
            return 0;
        L11:
            return ((OUnitedTitleBar.Behavior) r12).getTopBottomOffsetForScrollingSibling();
        L10:
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }

        public a() {
        }
    }

    static {
        f17527h = new a(null);
    }

    public ScrollingViewBehavior() {
    }

    public OUnitedTitleBar a(List r10) {
        q.g(r10, "views");
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        View r13 = (View) r10.get(r12);
        if ((r13 instanceof OUnitedTitleBar) == true) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) r13;
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public /* bridge */ /* synthetic */ View findFirstDependency(List r10) {
        return a(r10);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public float getOverlapRatioForOffset(View r10) {
        q.g(r10, "header");
        if ((r10 instanceof OUnitedTitleBar) == false) goto L13;
        OUnitedTitleBar r11 = (OUnitedTitleBar) r10;
        int r12 = r11.getTotalScrollRange();
        int r13 = r11.getDownNestedPreScrollRange();
        int r14 = a.a(f17527h, r11);
        if (r13 != 0) goto L7;
    L9:
        int r15 = r12 - r13;
        if (r15 == 0) goto L13;
        return (r14 / r15) + 1.0f;
    L7:
        if ((r12 + r14) > r13) goto L9;
        return 0.0f;
    L13:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public int getScrollRange(View r10) {
        q.g(r10, "v");
        if ((r10 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r10).getTotalScrollRange();
    L6:
        return super.getScrollRange(r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12) {
        q.g(r10, "parent");
        q.g(r11, "child");
        q.g(r12, "dependency");
        return r12 instanceof OUnitedTitleBar;
    }

    public final void offsetChildAsNeeded(View r10, View r11) {
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L9;
        CoordinatorLayout.Behavior r13 = ((CoordinatorLayout.c) r12).f();
        if ((r13 instanceof BaseBehavior) == false) goto L10;
        ViewCompat.a0(r10, (((r11.getBottom() - r10.getTop()) + ((BaseBehavior) r13).f17490k) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r11));
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r10, View r11, View r12) {
        q.g(r10, "parent");
        q.g(r11, "child");
        q.g(r12, "dependency");
        offsetChildAsNeeded(r11, r12);
        updateLiftedStateIfNeeded(r11, r12);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(CoordinatorLayout r10, View r11, View r12) {
        q.g(r10, "parent");
        q.g(r11, "child");
        q.g(r12, "dependency");
        if ((r12 instanceof OUnitedTitleBar) == false) goto L6;
        ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2750q.b());
        ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2751r.b());
        ViewCompat.p0(r10, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r10, View r11, Rect r12, boolean r13) {
        q.g(r10, "parent");
        q.g(r11, "child");
        q.g(r12, "rectangle");
        List<View> r14 = r10.getDependencies(r11);
        q.f(r14, "parent.getDependencies(child)");
        OUnitedTitleBar r15 = a(r14);
        if (r15 == null) goto L8;
        Rect r16 = new Rect(r12);
        r16.offset(r11.getLeft(), r11.getTop());
        Rect r17 = this.f17523d;
        r17.set(0, 0, r10.getWidth(), r10.getHeight());
        if (r17.contains(r16) == true) goto L8;
        r15.setExpanded(false);
        return true;
    L8:
        return false;
    }

    public final void updateLiftedStateIfNeeded(View r10, View r11) {
        boolean r12 = r11 instanceof OUnitedTitleBar;
    }

    public ScrollingViewBehavior(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ScrollingViewBehavior_Layout);
        q.f(r12, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        setOverlayTop(r12.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
        r12.recycle();
    }
}
