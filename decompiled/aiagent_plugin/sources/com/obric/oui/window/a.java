package com.obric.oui.window;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.oui.view.b;
import com.obric.oui.window.a.f;
import com.obric.oui.window.a.g;
import com.obric.oui.window.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: OWindowConfigController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36851a = null;

    static {
        f36851a = new a();
    }

    public static final b a(View r3, WindowInsets r4) {
        o.e(r3, "view");
        return a(r3, r4, false, 4, null);
    }

    private a() {
    }

    public final void a(p r2, w<g> r3) {
        p r1 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.aiagent.plugin");
        w<g> r4 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
        o.e(r1, "lifecycleOwner");
        com.obric.oui.window.listener.b.f36901a.a(r4, r1);
    }

    public final com.obric.oui.window.a.a a() {
        return com.obric.oui.window.c.a.f36875a.b();
    }

    public final f b() {
        return com.obric.oui.window.c.a.f36875a.a();
    }

    public final float c() {
        return com.obric.oui.window.c.a.f36875a.c();
    }

    public static final int a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r2 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin"), "status_bar_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r2 > 0) goto L8;
        Class r3 = ZeusTransformUtils.forName("com.android.internal.R$dimen", "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        Object r4 = r3.newInstance();     // Catch: Exception -> L11
        int r5 = Integer.parseInt(r3.getField("status_bar_height").get(r4).toString());     // Catch: Exception -> L11
        return ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDimensionPixelSize(r5);
    L11:
        return 0;
    L8:
        return ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDimensionPixelSize(r2);
    }

    public final int b(Context r6) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), "navigation_bar_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r1 > 0) goto L8;
        Class r2 = ZeusTransformUtils.forName("com.android.internal.R$dimen", "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        Object r3 = r2.newInstance();     // Catch: Exception -> L11
        int r4 = Integer.parseInt(r2.getField("navigation_bar_height").get(r3).toString());     // Catch: Exception -> L11
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDimensionPixelSize(r4);
    L11:
        return 0;
    L8:
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDimensionPixelSize(r1);
    }

    public final int a(View r9) {
        o.e(r9, "rootView");
        WindowInsetsController r10 = r9.getWindowInsetsController();     // Catch: Exception -> L36
        if (r10 != null) goto L6;
        return 0;
    L6:
        Method r0 = r10.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L36
        r0.setAccessible(true);     // Catch: Exception -> L36
        Object r11 = r0.invoke(r10, new Object[0]);     // Catch: Exception -> L36
        if (Build.VERSION.SDK_INT < 35) goto L10;
        Class r1 = ZeusTransformUtils.forName("android.view.InsetsSource", "com.obric.aiagent.plugin");     // Catch: Exception -> L36
    L12:
        if (Build.VERSION.SDK_INT < 35) goto L14;
        Field r2 = r1.getDeclaredField("ID_IME");     // Catch: Exception -> L36
    L15:
        r2.setAccessible(true);     // Catch: Exception -> L36
        Rect r3 = null;
        int r4 = r2.getInt(null);     // Catch: Exception -> L36
        Method r5 = r11.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L36
        r5.setAccessible(true);     // Catch: Exception -> L36
        Object r12 = r5.invoke(r11, new Object[]{Integer.valueOf(r4)});     // Catch: Exception -> L36
        if (r12 != null) goto L19;
        r12 = null;
    L19:
        if (r12 != null) goto L21;
        return 0;
    L21:
        Method r6 = r12.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L36
        r6.setAccessible(true);     // Catch: Exception -> L36
        Object r7 = r6.invoke(r12, new Object[0]);     // Catch: Exception -> L36
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L24;
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L36
    L25:
        if (r8 != null) goto L28;
        return 0;
    L28:
        if (r8.booleanValue() == false) goto L38;
        Method r13 = r12.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L36
        r13.setAccessible(true);     // Catch: Exception -> L36
        Object r14 = r13.invoke(r12, new Object[0]);     // Catch: Exception -> L36
        if (ZeusTransformUtils.instanceOf(r14, Rect.class) == false) goto L32;
        r3 = (Rect) ZeusTransformUtils.preCheckCast(r14, Rect.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L36
    L32:
        if (r3 != null) goto L34;
        return 0;
    L34:
        return r3.height();
    L38:
        return 0;
    L24:
        r8 = null;
        goto L25
    L14:
        r2 = r1.getDeclaredField("ITYPE_IME");     // Catch: Exception -> L36
        goto L15
    L10:
        r1 = ZeusTransformUtils.forName("android.view.InsetsState", "com.obric.aiagent.plugin");     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    }

    public final Activity getActivity(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L7;
        return (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L10;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context.baseContext");
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r5), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    }

    public final boolean c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r4), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L8;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isInMultiWindowMode();
    L8:
        return false;
    }

    public static final Size d(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f36851a.getActivity(r6), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
        Object r1 = r6.getSystemService("window");
        Rect r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, WindowManager.class) == false) goto L13;
        WindowManager r2 = (WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.aiagent.plugin");
    L15:
        if (Build.VERSION.SDK_INT < 30) goto L22;
        if (r2 == null) goto L23;
        WindowMetrics r4 = r2.getCurrentWindowMetrics();
        if (r4 == null) goto L23;
        r3 = r4.getBounds();
    L23:
        if (r3 == null) goto L27;
        return new Size(r3.width(), r3.height());
    L27:
        return new Size(com.obric.oui.common.util.g.a(r6), com.obric.oui.common.util.g.b(r6));
    L22:
        r3 = (Rect) ZeusTransformUtils.preCheckCast(null, Rect.class, "com.obric.aiagent.plugin");
        goto L23
    L13:
        r2 = null;
        goto L15
    L9:
        return new Size(e.f36874a.a(r0).a().width(), e.f36874a.a(r0).a().height());
    L5:
        return new Size(0, 0);
    }

    public static final boolean e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        Resources r6 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(r6, "config_navBarInteractionMode", WsChannelMultiProcessSharedProvider.INT_TYPE, "android", "com.obric.aiagent.plugin");
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r6.getInteger(r0) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean f(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return false;
    L7:
        return e(r3);
    }

    public static /* synthetic */ b a(View r0, WindowInsets r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = true;
    L9:
        return a(r0, r1, r2);
    }

    public static final b a(View r3, WindowInsets r4, boolean r5) {
        o.e(r3, "view");
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        b r6 = b.f36820a;
        o.c(r6, "NONE");
        return r6;
    L6:
        if (r4 != null) goto L8;
        r4 = r3.getRootWindowInsets();
    L8:
        if (r4 != null) goto L11;
        b r7 = b.f36820a;
        o.c(r7, "NONE");
        return r7;
    L11:
        if (r5 == false) goto L14;
        b r8 = com.obric.oui.view.g.a(r4).a(com.obric.oui.view.g.m.b());
        o.c(r8, "toWindowInsetsCompat(ins…Compat.Type.systemBars())");
        return r8;
    L14:
        b r9 = com.obric.oui.view.g.a(r4).e();
        o.c(r9, "toWindowInsetsCompat(insets).systemWindowInsets");
        return r9;
    }

    public final boolean g(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getConfiguration().orientation == 2) goto L13;
        return false;
    L13:
        return true;
    L7:
        e = move-exception;
        com.obric.oui.d.a.b.b("OWindowConfigController", "isLandscape error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    public static final int a(Activity r2, Boolean r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        if (r4 != null) goto L13;
        return 2;
    L13:
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.aiagent.plugin");
        if (r5 == null) goto L23;
        WindowManager.LayoutParams r6 = r5.getAttributes();
        if (r6 != null) goto L20;
        return 2;
    L20:
        return r6.layoutInDisplayCutoutMode;
    L23:
        return 2;
    L5:
        if (r3.booleanValue() == true) goto L7;
        return 2;
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L9;
        return 3;
    L9:
        return 1;
    }

    public static final void a(Context r3, WindowManager.LayoutParams r4, Boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "params");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        a r0 = f36851a;
        if (r0.g(r6) == true) goto L10;
        return;
    L10:
        r4.layoutInDisplayCutoutMode = a((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r6), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"), r5);
    }
}
