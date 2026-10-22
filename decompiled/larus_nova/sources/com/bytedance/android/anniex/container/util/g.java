package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ies.bullet.base.utils.RomUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f40622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f40623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f40624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f40625d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.MiuiWindowManager$LayoutParams");
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void c(Activity r100) {
        Window r101 = r100.getWindow();
        if (r101 == null) goto L11;
        int r102 = b46.b.f17524a;
        if ((b(r100.getWindow()).getSystemUiVisibility() & 1024) != 1024) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L12;
        View r104 = b(r101);
        r104.setSystemUiVisibility(r104.getSystemUiVisibility() & (-1025));
        return;
    L12:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static void f(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L20;
        if (r101 != null) goto L9;
        return;
    L9:
        if (b(r101) == null) goto L22;
        View r102 = k.a(r101);
        if (r102 == null) goto L18;
        int r103 = r102.getSystemUiVisibility();
        if ((r103 & 8192) == 0) goto L18;
        r102.setSystemUiVisibility(r103 & (-8193));
    L18:
        e(r101, false);
        d(r101, false);
        return;
    L22:
        return;
    }

    public static void g(Activity r100) {
        Window r101 = r100.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r101 != null) goto L7;
        return;
    L7:
        if (b(r101) == null) goto L20;
        View r102 = k.a(r101);
        if (r102 == null) goto L16;
        int r103 = r102.getSystemUiVisibility();
        if ((r103 & 9216) == 9216) goto L16;
        r102.setSystemUiVisibility(r103 | 9216);
    L16:
        e(r101, true);
        d(r101, true);
        return;
    L20:
        return;
    }

    public static void d(Window r100, boolean r101) {
        if (((Boolean) RomUtils.f246321b.getValue()).booleanValue() == false) goto L19;
        WindowManager.LayoutParams r102 = r100.getAttributes();     // Catch: Throwable -> L16
        if (f40623b != null) goto L8;
        Field r103 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L16
        f40623b = r103;     // Catch: Throwable -> L16
        r103.setAccessible(true);     // Catch: Throwable -> L16
    L8:
        if (f40622a != null) goto L10;
        Field r104 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L16
        f40622a = r104;     // Catch: Throwable -> L16
        r104.setAccessible(true);     // Catch: Throwable -> L16
    L10:
        int r105 = f40623b.getInt(null);     // Catch: Throwable -> L16
        int r106 = f40622a.getInt(r102);     // Catch: Throwable -> L16
        if (r101 == false) goto L13;
        int r107 = r106 | r105;     // Catch: Throwable -> L16
    L14:
        f40622a.setInt(r102, r107);     // Catch: Throwable -> L16
        r100.setAttributes(r102);     // Catch: Throwable -> L16
        return;
    L13:
        r107 = (~r105) & r106;     // Catch: Throwable -> L16
    L20:
        return;
    }

    public static void e(Window r100, boolean r101) {
        if (((Boolean) RomUtils.f246320a.getValue()).booleanValue() == false) goto L18;
        Class<?> r102 = r100.getClass();     // Catch: Throwable -> L15
        Class r103 = a();     // Catch: Throwable -> L15
        if (f40624c != null) goto L7;
    L8:
        Field r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");     // Catch: Throwable -> L15
        f40624c = r104;     // Catch: Throwable -> L15
        r104.setAccessible(true);     // Catch: Throwable -> L15
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L15
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Throwable -> L15
        f40625d = r106;     // Catch: Throwable -> L15
        r106.setAccessible(true);     // Catch: Throwable -> L15
    L9:
        int r107 = f40624c.getInt(r103);     // Catch: Throwable -> L15
        Method r108 = f40625d;     // Catch: Throwable -> L15
        Object[] r109 = new Object[2];     // Catch: Throwable -> L15
        if (r101 == false) goto L12;
        int r110 = r107;
    L13:
        r109[0] = Integer.valueOf(r110);     // Catch: Throwable -> L15
        r109[1] = Integer.valueOf(r107);     // Catch: Throwable -> L15
        r108.invoke(r100, r109);     // Catch: Throwable -> L15
        return;
    L12:
        r110 = 0;
        goto L13
    L7:
        if (f40625d != null) goto L9;
    L18:
        return;
    }
}
