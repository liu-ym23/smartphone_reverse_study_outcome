package com.obric.oui.window.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: WindowSizeCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static final String TAG = "WindowSizeCalculator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f36874a = null;

    static {
        f36874a = new e();
    }

    private e() {
    }

    public final com.obric.oui.window.c.c a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        o.e(r4, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Rect r2 = b.f36871a.a(r4);
    L16:
        return new com.obric.oui.window.c.c(r2);
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r2 = b(r4);
        goto L16
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        r2 = c(r4);
        goto L16
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        r2 = d(r4);
        goto L16
    L14:
        r2 = e(r4);
        goto L16
    }

    public final Rect b(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        o.e(r9, "activity");
        Configuration r1 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getConfiguration();
        Field r3 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        r3.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        Object r2 = r3.get(r1);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        Object r4 = r2.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        if (r4 == null) goto L7;
        return new Rect((Rect) ZeusTransformUtils.preCheckCast(r4, Rect.class, "com.obric.aiagent.plugin"));
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
    L10:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return c(r9);
    L14:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return c(r9);
    L12:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return c(r9);
    L8:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return c(r9);
    }

    public final Rect c(Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");
        o.e(r11, "activity");
        Rect r1 = new Rect();
        Configuration r3 = ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getConfiguration();
        Field r5 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        r5.setAccessible(true);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        Object r4 = r5.get(r3);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (a.f36870a.a(r11) == false) goto L11;
        Object r6 = r4.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r4, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (r6 == null) goto L10;
        r1.set((Rect) ZeusTransformUtils.preCheckCast(r6, Rect.class, "com.obric.aiagent.plugin"));     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L24:
        Display r0 = r11.getWindowManager().getDefaultDisplay();
        Point r7 = new Point();
        c r8 = c.f36872a;
        o.c(r0, "currentDisplay");
        r8.a(r0, r7);
        if (a.f36870a.a(r11) == true) goto L36;
        int r2 = a((Context) ZeusTransformUtils.preCheckCast(r11, Context.class, "com.obric.aiagent.plugin"));
        if ((r1.bottom + r2) != r7.y) goto L30;
        r1.bottom += r2;
        goto L36
    L30:
        if ((r1.right + r2) != r7.x) goto L33;
        r1.right += r2;
        goto L36
    L33:
        if (r1.left != r2) goto L36;
        r1.left = 0;
    L36:
        if (r1.width() < r7.x) goto L40;
        if (r1.height() < r7.y) goto L40;
    L55:
        return r1;
    L40:
        if (a.f36870a.a(r11) == true) goto L55;
        DisplayCutout r9 = b(r0);
        if (r9 == null) goto L55;
        if (r1.left != d.f36873a.a(r9)) goto L47;
        r1.left = 0;
    L47:
        if ((r7.x - r1.right) != d.f36873a.c(r9)) goto L50;
        r1.right += d.f36873a.c(r9);
    L50:
        if (r1.top != d.f36873a.b(r9)) goto L53;
        r1.top = 0;
    L53:
        if ((r7.y - r1.bottom) != d.f36873a.d(r9)) goto L55;
        r1.bottom += d.f36873a.d(r9);
        goto L55
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L11:
        Object r12 = r4.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r4, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (r12 == null) goto L15;
        r1.set((Rect) ZeusTransformUtils.preCheckCast(r12, Rect.class, "com.obric.aiagent.plugin"));     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        goto L24
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L18:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        a(r11, r1);
    L22:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        a(r11, r1);
    L20:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        a(r11, r1);
    L16:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        a(r11, r1);
        goto L24
    }

    public final Rect d(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        o.e(r6, "activity");
        Rect r0 = new Rect();
        Display r2 = r6.getWindowManager().getDefaultDisplay();
        r2.getRectSize(r0);
        if (a.f36870a.a(r6) == true) goto L10;
        o.c(r2, "defaultDisplay");
        Point r3 = a(r2);
        int r4 = a((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"));
        if ((r0.bottom + r4) != r3.y) goto L8;
        r0.bottom += r4;
        goto L10
    L8:
        if ((r0.right + r4) != r3.x) goto L10;
        r0.right += r4;
    L10:
        return r0;
    }

    private final Rect e(Activity r3) {
        Display r4 = ((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin")).getWindowManager().getDefaultDisplay();
        o.c(r4, "defaultDisplay");
        Point r2 = a(r4);
        Rect r0 = new Rect();
        if (r2.x != 0) goto L5;
    L8:
        r4.getRectSize(r0);
    L9:
        return r0;
    L5:
        if (r2.y == 0) goto L8;
        r0.right = r2.x;
        r0.bottom = r2.y;
        goto L9
    }

    private final void a(Activity r2, Rect r3) {
        ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).getWindowManager().getDefaultDisplay().getRectSize(r3);
    }

    private final Point a(Display r2) {
        Point r1 = new Point();
        c.f36872a.a(r2, r1);
        return r1;
    }

    private final int a(Context r4) {
        Resources r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        int r5 = ZeusTransformUtils.getIdentifier(r3, "navigation_bar_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r5 > 0) goto L7;
        return 0;
    L7:
        return r3.getDimensionPixelSize(r5);
    }

    private final DisplayCutout b(Display r9) {
        Constructor r1 = ZeusTransformUtils.forName("android.view.DisplayInfo", "com.obric.aiagent.plugin").getConstructor(new Class[0]);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r1.setAccessible(true);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Object r2 = r1.newInstance(new Object[0]);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Method r4 = r9.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r2.getClass()});     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r4.setAccessible(true);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r4.invoke(r9, new Object[]{r2});     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Field r10 = r2.getClass().getDeclaredField("displayCutout");     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r10.setAccessible(true);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Object r11 = r10.get(r2);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        if (ZeusTransformUtils.instanceOf(r11, DisplayCutout.class) == false) goto L19;
    L23:
        return (DisplayCutout) ZeusTransformUtils.preCheckCast(r11, DisplayCutout.class, "com.obric.aiagent.plugin");
    L19:
        return null;
    L17:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L11:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L13:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L15:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L9:
        e = move-exception;
        a(TAG, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L19
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
