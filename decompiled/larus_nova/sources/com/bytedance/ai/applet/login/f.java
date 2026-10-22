package com.bytedance.ai.applet.login;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f34745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f34746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f34747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ai.widget.contianer.h f34748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l2.a f34749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Activity f34750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f34751g;

    public static final class a {
    }

    static {
    }

    public final void c() {
        com.bytedance.ai.utils.g.f37637a.d("DrawerWidgetContainer", "closeDrawer");
        ViewGroup.LayoutParams r100 = this.f34745a.getChildAt(1).getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r101 = ((CoordinatorLayout.LayoutParams) r100).getBehavior();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        ((BottomSheetBehavior) r101).b(4, true);
    }

    public final void f() {
        com.bytedance.ai.widget.contianer.h r100 = this.f34748d;
        if (r100 == null) goto L7;
        l2.a r101 = this.f34749e;
        if (r101 == null) goto L7;
        r101.c(r100);
    L7:
        this.f34749e = null;
        this.f34748d = null;
        ViewGroup r102 = this.f34747c;
        if (r102 == null) goto L11;
        r102.removeAllViews();
        return;
    }

    public final void e() {
        c();
        f();
        ViewParent r100 = this.f34745a.getParent();
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L8;
        r101.removeView(this.f34745a);
    L8:
        this.f34750f = null;
        this.f34751g = null;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CoordinatorLayout r101 = new CoordinatorLayout(r100);
        FrameLayout r102 = new FrameLayout(r100);
        this.f34746b = r102;
        r102.setBackgroundColor(ColorProtector.parseColor("#26000000"));
        ViewGroup r103 = this.f34746b;
        if (r103 == null) goto L5;
        r103.setOnClickListener(new e(this));
    L5:
        r101.addView(this.f34746b, new CoordinatorLayout.LayoutParams(-1, -1));
        FrameLayout r104 = new FrameLayout(r100);
        this.f34747c = r104;
        r104.setId(View.generateViewId());
        ViewGroup r105 = this.f34747c;
        if (r105 == null) goto L8;
        r105.setBackgroundResource(R.drawable.normal_drawer_background);
    L8:
        CoordinatorLayout.LayoutParams r106 = new CoordinatorLayout.LayoutParams(-1, -2);
        r106.setBehavior(new BottomSheetBehavior());
        r101.addView(this.f34747c, r106);
        CoordinatorLayout.Behavior r107 = r106.getBehavior();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        BottomSheetBehavior r108 = (BottomSheetBehavior) r107;
        r108.getClass();
        g r109 = new g(this);
        if (r108.M.contains(r109) == true) goto L11;
        r108.M.add(r109);
    L11:
        this.f34745a = r101;
    }

    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ViewParent r101 = this.f34745a.getParent();     // Catch: Exception -> L18
        ViewGroup r102 = null;
        if ((r101 instanceof ViewGroup) == false) goto L6;
        ViewGroup r103 = (ViewGroup) r101;     // Catch: Exception -> L18
    L7:
        View r104 = r100.findViewById(android.R.id.content);     // Catch: Exception -> L18
        if ((r104 instanceof ViewGroup) == false) goto L11;
        r102 = (ViewGroup) r104;     // Catch: Exception -> L18
    L11:
        if (Intrinsics.areEqual(r103, r102) == true) goto L16;
        if (r103 == null) goto L14;
        r103.removeView(this.f34745a);     // Catch: Exception -> L18
    L14:
        if (r102 == null) goto L16;
        r102.addView(this.f34745a, -1, -1);     // Catch: Exception -> L18
    L16:
        this.f34750f = r100;     // Catch: Exception -> L18
        return;
    L6:
        r103 = null;
    L18:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("DrawerWidgetContainer", "attachDrawer: failed", e);
    }

    public final void d(Function0<Unit> r100) {
        com.bytedance.ai.utils.g.f37637a.d("DrawerWidgetContainer", "openDrawer");
        this.f34751g = r100;
        ViewGroup.LayoutParams r101 = this.f34745a.getChildAt(1).getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ai.view.popup.anim.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        ((BottomSheetBehavior) r102).b(3, true);
    }

    public final void a(l2.a r100, com.bytedance.ai.widget.contianer.h r101) {
        View r102 = r101.realView();
        if (r102 != null) goto L7;
        com.bytedance.ai.utils.g.f37637a.e("DrawerWidgetContainer", "addWidgetContainer: realView is null");
        return;
    L7:
        if (r102.getParent() == null) goto L9;
        com.bytedance.ai.utils.g.f37637a.d("DrawerWidgetContainer", "addWidgetContainer: removing from parent first");
        ViewParent r103 = r102.getParent();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r103).removeView(r102);
    L9:
        this.f34749e = r100;
        this.f34748d = r101;
        ViewGroup r104 = this.f34747c;
        if (r104 == null) goto L13;
        r104.addView(r102, -1, -2);
        return;
    }
}
