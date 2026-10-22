package com.obric.oui.window.floating;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.obric.oui.material.c;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OFloatingWindowHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f36885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f36886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f36888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ViewGroup f36889e;
    private float f;
    private final OFloatingWindowHelper$parentAttachStateChangeListener$1 g;

    public static /* synthetic */ void lambda$U3hrylFo9TzUX_xesxqlDgK0Nh4(a r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: lambda$cQToRlvg75sUK-fhIgrhABU-rN4, reason: not valid java name */
    public static /* synthetic */ void m1242lambda$cQToRlvg75sUKfhIgrhABUrN4(a r0) {
        a(r0);
    }

    public static /* synthetic */ WindowInsets lambda$kESHNz9RlPseF6xsIHpQH29gSx0(a r0, b r1, View r2, WindowInsets r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.window.floating.OFloatingWindowHelper$parentAttachStateChangeListener$1] */
    public a(View r2) {
        o.e(r2, "targetView");
        this.f36885a = r2;
        this.f36887c = 1;
        this.g = new OFloatingWindowHelper$parentAttachStateChangeListener$1(this);
    }

    public final void a(boolean r1) {
        this.f36886b = r1;
    }

    public final boolean a() {
        return this.f36886b;
    }

    public final void a(int r1) {
        this.f36887c = r1;
    }

    public final void b() {
        if (this.f36886b == true) goto L5;
        return;
    L5:
        if (this.f36888d == true) goto L9;
        d();
        return;
    }

    public final void a(View r2, c r3, int r4) {
        o.e(r2, "maskView");
        o.e(r3, "maskMaterialConfig");
        com.obric.oui.blur.a r0 = r3.g();
        o.a(r0);
        float r1 = r0.a();
        this.f = r1;
        if (r1 <= 0.0f) goto L5;
        l.a(r2, r3, r4);
    L6:
        k.a(r2, r2);
        return;
    L5:
        l.b(r2, 0);
        goto L6
    }

    public final void a(boolean r3, b<? super com.obric.oui.view.b, x> r4) {
        final b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "updateLayout");
        if (r3 == false) goto L6;
        com.obric.oui.window.a r6 = com.obric.oui.window.a.f36851a;
        r5.invoke(com.obric.oui.window.a.a(this.f36885a, null, true));
        this.f36885a.setOnApplyWindowInsetsListener(new $$Lambda$a$kESHNz9RlPseF6xsIHpQH29gSx0(this, r5));
        return;
    }

    private static final WindowInsets a(final a r4, b r5, View r6, WindowInsets r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "this$0");
        o.e(r8, "$updateLayout");
        o.e(r6, "$noName_0");
        o.e(r7, "insets");
        if (r4.f36886b == true) goto L5;
    L15:
        com.obric.oui.window.a r9 = com.obric.oui.window.a.f36851a;
        r8.invoke(com.obric.oui.window.a.a(r4.f36885a, r7, true));
    L16:
        return r7;
    L5:
        if (r4.f36888d == false) goto L15;
        if (Build.VERSION.SDK_INT < 23) goto L16;
        ViewGroup r10 = r4.f36889e;
        if (r10 == null) goto L16;
        WindowInsets r11 = r10.getRootWindowInsets();
        if (r11 == null) goto L16;
        com.obric.oui.window.a r2 = com.obric.oui.window.a.f36851a;
        ViewGroup r3 = r4.f36889e;
        o.a(r3);
        r8.invoke(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), r11, true));
        r4.f36885a.post(new $$Lambda$a$cQToRlvg75sUKfhIgrhABUrN4(r4));
        goto L16
    }

    private static final void a(a r1) {
        o.e(r1, "this$0");
        r1.e();
    }

    private final void d() {
        if (this.f36888d == false) goto L5;
        return;
    L5:
        this.f36885a.post(new $$Lambda$a$U3hrylFo9TzUX_xesxqlDgK0Nh4(this));
    }

    private static final void b(a r9) {
        o.e(r9, "this$0");
        if (r9.f36885a.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r9.f36885a.getParent(), ViewGroup.class) == false) goto L38;
        ViewParent r0 = r9.f36885a.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
        r9.f36889e = r1;
        if (r1 == null) goto L10;
        r1.removeView(r9.f36885a);
    L10:
        ViewGroup r2 = r9.f36889e;
        if (r2 == null) goto L14;
        r2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r9.g, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
    L14:
        Object r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.f36885a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window");
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r4 = (WindowManager) ZeusTransformUtils.preCheckCast(r3, WindowManager.class, "com.obric.aiagent.plugin");
        WindowManager.LayoutParams r5 = new WindowManager.LayoutParams(-1, -2, 1000, 16778024, -3);
        r5.gravity = r9.f36887c;
        if (Build.VERSION.SDK_INT < 30) goto L17;
        r5.setFitInsetsSides(0);
    L17:
        ViewGroup r6 = r9.f36889e;
        if (r6 != null) goto L20;
        IBinder r7 = null;
    L21:
        r5.token = r7;
        r4.addView(r9.f36885a, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L32
        r9.f36888d = true;     // Catch: Exception -> L32
        if (Build.VERSION.SDK_INT < 23) goto L39;
        ViewGroup r8 = r9.f36889e;     // Catch: Exception -> L32
        if (r8 != null) goto L28;
        return;
    L28:
        if (r8.getRootWindowInsets() == null) goto L41;
        r9.f36885a.requestApplyInsets();     // Catch: Exception -> L32
        return;
    L41:
        return;
    L39:
        return;
    L32:
        e = move-exception;
        com.obric.oui.d.a.b.e("OFloatingWindowHelper", o.a("Failed to add view to WindowManager: ", e.getMessage()));
        return;
    L20:
        r7 = r6.getWindowToken();
        goto L21
    }

    public final void c() {
        if (this.f36888d == false) goto L18;
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36885a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window");     // Catch: Exception -> L9
        if (r1 == null) goto L8;
        ((WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.aiagent.plugin")).removeViewImmediate(this.f36885a);     // Catch: Exception -> L9
    L11:
        this.f36888d = false;
        ViewGroup r2 = this.f36889e;
        if (r2 == null) goto L15;
        r2.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this.g, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
    L15:
        this.f36889e = null;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.obric.oui.d.a.b.e("OFloatingWindowHelper", o.a("Failed to remove view from WindowManager: ", e.getMessage()));
        goto L11
    }

    private final void e() {
        if (this.f36888d == false) goto L14;
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36885a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r1 = (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r2 = this.f36885a.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, WindowManager.LayoutParams.class) == false) goto L7;
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r2, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L8:
        int r4 = this.f36885a.getMeasuredHeight();
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.height == r4) goto L16;
        r3.height = r4;
        r1.updateViewLayout(this.f36885a, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
