package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class d1 {
    public static int e() {
        Resources r100 = y0.getResources();
        int r101 = r100.getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100.getDimensionPixelSize(r101);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static boolean c(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean r103 = false;
        if (r102 <= 0) goto L5;
        boolean r104 = r101.getBoolean(r102);
    L16:
        Class r105 = a("android.os.SystemProperties");     // Catch: Exception -> L15
        String r106 = (String) r105.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r105, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L15
        if ("1".equals(r106) == true) goto L14;
        if ("0".equals(r106) == false) goto L12;
        r103 = true;
        goto L14
    L12:
        r103 = r104;
    L14:
        return r103;
    L18:
        return r104;
    L5:
        r104 = false;
        goto L16
    }

    public static int d(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 <= 0) goto L5;
        int r103 = r101.getDimensionPixelSize(r102);
    L6:
        Rect r104 = new Rect();
        if ((r100 instanceof Activity) == false) goto L22;
        b(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r104);
        int r105 = r104.height();
    L18:
        int r106 = y0.f();
    L20:
        return Math.min(Math.max((r106 - y0.h()) - r105, 0), r103);
    L10:
        if ((r100 instanceof Activity) == false) goto L12;
        WindowManager r107 = ((Activity) r100).getWindowManager();     // Catch: Exception -> L18
    L13:
        Display r108 = r107.getDefaultDisplay();
        DisplayMetrics r109 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r108, new Object[]{r109});     // Catch: Exception -> L16
        r106 = r109.heightPixels;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        int r110 = y0.f();
        e.printStackTrace();
        r106 = r110;
        goto L20
    L12:
        r107 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L18
        goto L13
    L22:
        if (c(r100) == true) goto L24;
        return 0;
    L24:
        return r103;
    L5:
        r103 = 0;
        goto L6
    }
}
