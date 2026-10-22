package com.bytedance.android.live.core.utils.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public class IESStatusBarUtil {
    public static final int BUILD_VERSION_CODE_M = 23;
    public static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private IESStatusBarUtil() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void hideNavigation(Window r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setSystemUiVisibility((r101.getSystemUiVisibility() | 2) | 512);
    }

    public static void statusBarLightMode(Window r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = Build.VERSION.SDK_INT;
        if (miuisetstatusbarlightmode(r100, true) == false) goto L8;
        return;
    L8:
        if (flymeSetStatusBarLightMode(r100, true) == false) goto L11;
        return;
    L11:
        if (r101 < 23) goto L14;
        androidVersionMStatusBarMode(r100, true);
        return;
    }

    public static void transparencyBar(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        r101.clearFlags(67108864);
        View r102 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
        a.C1098a r103 = a.f66401b;
        r103.a();
        r103.a();
        r102.setSystemUiVisibility(1280);
        r103.a();
        r101.addFlags(Integer.MIN_VALUE);
        r101.setStatusBarColor(0);
    }

    public static void statusBarLightMode(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        statusBarLightMode(r100.getWindow());
    }

    public static void androidVersionMStatusBarMode(Window r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.clearFlags(67108864);
        a.f66401b.a();
        r100.addFlags(Integer.MIN_VALUE);
        View r102 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
        int r103 = r102.getSystemUiVisibility();
        if (r101 == false) goto L7;
        int r104 = r103 | 8192;
    L8:
        r102.setSystemUiVisibility(r104);
        return;
    L7:
        r104 = r103 & (-8193);
        goto L8
    }

    public static boolean flymeSetStatusBarLightMode(Window r100, boolean r101) {
        if (r100 != null) goto L12;
    L9:
        return false;
    L12:
        WindowManager.LayoutParams r102 = r100.getAttributes();     // Catch: Exception -> L11
        Field r103 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Exception -> L11
        Field r104 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Exception -> L11
        r103.setAccessible(true);     // Catch: Exception -> L11
        r104.setAccessible(true);     // Catch: Exception -> L11
        int r105 = r103.getInt(null);     // Catch: Exception -> L11
        int r106 = r104.getInt(r102);     // Catch: Exception -> L11
        if (r101 == false) goto L6;
        int r107 = r106 | r105;     // Catch: Exception -> L11
    L7:
        r104.setInt(r102, r107);     // Catch: Exception -> L11
        r100.setAttributes(r102);     // Catch: Exception -> L11
        return true;
    L6:
        r107 = (~r105) & r106;     // Catch: Exception -> L11
        goto L7
    }

    public static boolean miuisetstatusbarlightmode(Window r100, boolean r101) {
        if (r100 == null) goto L18;
        Class<?> r102 = r100.getClass();
        Class r103 = INVOKESTATIC_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L16
        int r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r103);     // Catch: Exception -> L16
        Class<?> r105 = Integer.TYPE;     // Catch: Exception -> L16
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Exception -> L16
        if (r101 == false) goto L8;
        r106.invoke(r100, new Object[]{Integer.valueOf(r104), Integer.valueOf(r104)});     // Catch: Exception -> L16
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r101 == false) goto L13;
        INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(8192);     // Catch: Exception -> L16
        goto L14
    L13:
        INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(0);     // Catch: Exception -> L16
    L14:
        return true;
    L8:
        r106.invoke(r100, new Object[]{0, Integer.valueOf(r104)});     // Catch: Exception -> L16
        goto L10
    L19:
        return false;
    L18:
        return false;
    }
}
