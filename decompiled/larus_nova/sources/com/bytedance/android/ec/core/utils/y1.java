package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45751a = 0;

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

    static {
    }

    public static void b(boolean r100, Window r101) {
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L8
        Class r103 = a();     // Catch: Throwable -> L8
        int r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r103);     // Catch: Throwable -> L8
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L8
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Throwable -> L8
        Object[] r107 = new Object[2];     // Catch: Throwable -> L8
        if (r100 == false) goto L5;
        int r108 = r104;
    L6:
        r107[0] = Integer.valueOf(r108);     // Catch: Throwable -> L8
        r107[1] = Integer.valueOf(r104);     // Catch: Throwable -> L8
        r106.invoke(r101, r107);     // Catch: Throwable -> L8
        return;
    L5:
        r108 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public static void c(Activity r100, Window r101, boolean r102) {
        if (r100 == null) goto L29;
        if (r101 == null) goto L31;
    L24:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        View r103 = r101.getDecorView();     // Catch: Throwable -> L24
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L24
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L24
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");     // Catch: Throwable -> L24
    L12:
        int r105 = r103.getSystemUiVisibility();     // Catch: Throwable -> L24
        if (r102 == true) goto L15;
        r103.setSystemUiVisibility(r105 & (-8193));     // Catch: Throwable -> L24
    L16:
        r101.clearFlags(67108864);     // Catch: Throwable -> L24
        r101.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L24
        goto L18
    L15:
        r103.setSystemUiVisibility(r105 | 8192);     // Catch: Throwable -> L24
    L18:
        if (OSUtils.isMIUI6Later() == false) goto L21;
        b(r102, r101);     // Catch: Throwable -> L24
    L21:
        if (OSUtils.isFlymeOS4Later() == false) goto L30;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(r100, r102);     // Catch: Throwable -> L24
        return;
    L30:
        return;
    L31:
        return;
    }
}
