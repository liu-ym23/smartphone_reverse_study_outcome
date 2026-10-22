package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
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

/* JADX INFO: loaded from: classes45.dex */
public final class x1 {
    public static int f() {
        Resources r100 = s1.getResources();
        int r101 = r100.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r101 != 0) goto L5;
        return 0;
    L5:
        return r100.getDimensionPixelSize(r101);
    }

    public static int g() {
        if (s1.y() >= s1.w()) goto L7;
        return s1.w();
    L7:
        return s1.y();
    }

    public static int h() {
        if (s1.y() <= s1.w()) goto L7;
        return s1.w();
    L7:
        return s1.y();
    }

    public static int k() {
        Resources r100 = s1.getResources();
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
        Rect r101 = new Rect();
        if ((r100 instanceof Activity) == false) goto L6;
        b(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r101);
    L6:
        return r101.height();
    }

    public static int e(Context r100) {
        if (r100 != null) goto L20;
        return 0;
    L20:
        if ((r100 instanceof Activity) == false) goto L8;
        WindowManager r101 = ((Activity) r100).getWindowManager();     // Catch: Exception -> L16
    L9:
        Display r102 = r101.getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r102, new Object[]{r103});     // Catch: Exception -> L12
        int r104 = r103.heightPixels;     // Catch: Exception -> L12
    L15:
        return r104;
    L12:
        e = move-exception;
        int r105 = s1.w();
        e.printStackTrace();
        r104 = r105;
        goto L15
    L8:
        r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L16
        goto L9
    L17:
        return s1.w();
    }

    public static DisplayMetrics i(Activity r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getWindowManager().getDefaultDisplay().getRealMetrics(r101);
        return r101;
    }

    public static int j(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 <= 0) goto L5;
        int r103 = r101.getDimensionPixelSize(r102);
    L6:
        Rect r104 = new Rect();
        if ((r100 instanceof Activity) == false) goto L11;
        b(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r104);
        int r105 = r104.height();
        return Math.min(Math.max((e(r100) - s1.A()) - r105, 0), r103);
    L11:
        if (c(r100) == true) goto L13;
        return 0;
    L13:
        return r103;
    L5:
        r103 = 0;
        goto L6
    }

    public static boolean l(Activity r100) {
        ViewGroup r101 = (ViewGroup) b(r100.getWindow());
        if (r101 == null) goto L15;
        int r102 = 0;
    L6:
        if (r102 >= r101.getChildCount()) goto L26;
        int r103 = r101.getChildAt(r102).getId();
        if (r103 == (-1)) goto L14;
        if ("navigationBarBackground".equals(s1.getResources().getResourceEntryName(r103)) == false) goto L14;
        if (r101.getChildAt(r102).getVisibility() != 0) goto L14;
        return true;
    L25:
        return false;
    L14:
        r102 = r102 + 1;
        goto L6
    L26:
        return false;
    L15:
        return false;
    }
}
