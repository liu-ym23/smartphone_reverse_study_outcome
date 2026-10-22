package com.bytedance.android.annie.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f40060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f40061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f40062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f40063d;

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

    public static void c(FragmentActivity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L7;
        return;
    L7:
        if ((b(r100.getWindow()).getSystemUiVisibility() & 1024) != 1024) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        View r103 = b(r101);
        r103.setSystemUiVisibility(r103.getSystemUiVisibility() & (-1025));
        return;
    L14:
        return;
    L9:
        r102 = false;
        goto L10
    }

    public static void d(Window r100) {
        if (r100 == null) goto L5;
        r100.addFlags(Integer.MIN_VALUE);
        r100.clearFlags(67108864);
        r100.setStatusBarColor(0);
        View r101 = b(r100);
        r101.setSystemUiVisibility(r101.getSystemUiVisibility() | 1280);
        return;
    }

    public static boolean e(Window r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.getAttributes() == null) goto L8;
        if ((r100.getAttributes().flags & 1024) != 1024) goto L8;
        return true;
    }

    public static void h(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L20;
        if (r101 != null) goto L9;
        return;
    L9:
        if (b(r101) == null) goto L22;
        View r102 = v.a(r101);
        if (r102 == null) goto L18;
        int r103 = r102.getSystemUiVisibility();
        if ((r103 & 8192) == 0) goto L18;
        r102.setSystemUiVisibility(r103 & (-8193));
    L18:
        g(r101, false);
        f(r101, false);
        return;
    L22:
        return;
    }

    public static void f(Window r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((Boolean) RomUtils.f40051b.getValue()).booleanValue() == false) goto L21;
        WindowManager.LayoutParams r102 = r100.getAttributes();     // Catch: Throwable -> L17
        if (f40061b != null) goto L9;
        Field r103 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L17
        f40061b = r103;     // Catch: Throwable -> L17
        r103.setAccessible(true);     // Catch: Throwable -> L17
    L9:
        if (f40060a != null) goto L11;
        Field r104 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L17
        f40060a = r104;     // Catch: Throwable -> L17
        r104.setAccessible(true);     // Catch: Throwable -> L17
    L11:
        int r105 = f40061b.getInt(null);     // Catch: Throwable -> L17
        int r106 = f40060a.getInt(r102);     // Catch: Throwable -> L17
        if (r101 == false) goto L14;
        int r107 = r106 | r105;     // Catch: Throwable -> L17
    L15:
        f40060a.setInt(r102, r107);     // Catch: Throwable -> L17
        r100.setAttributes(r102);     // Catch: Throwable -> L17
        return;
    L14:
        r107 = (~r105) & r106;     // Catch: Throwable -> L17
    L22:
        return;
    }

    public static void g(Window r100, boolean r101) {
        if (r100 == null) goto L19;
        if (((Boolean) RomUtils.f40050a.getValue()).booleanValue() == false) goto L20;
        Class<?> r102 = r100.getClass();     // Catch: Throwable -> L16
        Class r103 = a();     // Catch: Throwable -> L16
        if (f40062c != null) goto L8;
    L9:
        Field r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");     // Catch: Throwable -> L16
        f40062c = r104;     // Catch: Throwable -> L16
        r104.setAccessible(true);     // Catch: Throwable -> L16
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L16
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Throwable -> L16
        f40063d = r106;     // Catch: Throwable -> L16
        r106.setAccessible(true);     // Catch: Throwable -> L16
    L10:
        int r107 = f40062c.getInt(r103);     // Catch: Throwable -> L16
        Method r108 = f40063d;     // Catch: Throwable -> L16
        Object[] r109 = new Object[2];     // Catch: Throwable -> L16
        if (r101 == false) goto L13;
        int r110 = r107;
    L14:
        r109[0] = Integer.valueOf(r110);     // Catch: Throwable -> L16
        r109[1] = Integer.valueOf(r107);     // Catch: Throwable -> L16
        r108.invoke(r100, r109);     // Catch: Throwable -> L16
        return;
    L13:
        r110 = 0;
        goto L14
    L8:
        if (f40063d != null) goto L10;
    L20:
        return;
    L21:
        return;
    }

    public static void i(Window r100, Boolean r101) {
        if (Build.VERSION.SDK_INT < 23) goto L27;
        if (r100 != null) goto L7;
        return;
    L7:
        if (b(r100) != null) goto L10;
        return;
    L10:
        if (r101.booleanValue() == false) goto L18;
        View r102 = v.a(r100);
        if (r102 == null) goto L25;
        int r103 = r102.getSystemUiVisibility();
        if ((r103 & 9216) == 9216) goto L25;
        r102.setSystemUiVisibility(r103 | 9216);
    L25:
        g(r100, true);
        f(r100, true);
        return;
    L18:
        View r104 = v.a(r100);
        if (r104 == null) goto L25;
        int r105 = r104.getSystemUiVisibility();
        if ((r105 & 8192) == 8192) goto L25;
        r104.setSystemUiVisibility(r105 | 8192);
        goto L25
    }

    public static void j(FragmentActivity r100, Boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        i(r100.getWindow(), r101);
    }
}
