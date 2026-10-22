package com.bytedance.android.annie.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f40076a = null;

    static {
        f40076a = new t();
    }

    public t() {
    }

    private final Application getContext() {
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L7;
        return null;
    L7:
        return com.bytedance.android.annie.ng.g.a();
    }

    public static int i() {
        Resources r100 = p.f40070a.getResources();
        int r101 = r100.getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100.getDimensionPixelSize(r101);
    }

    public final int h() {
        if (AnnieConfigSettingKeys.ANNIE_METRICS_ADAPTER.a().booleanValue() == true) goto L5;
        Resources r100 = Resources.getSystem();
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    L16:
        return r101.heightPixels;
    L5:
        Application r102 = getContext();
        if (r102 == null) goto L12;
        Context r103 = r102.getApplicationContext();
        if (r103 == null) goto L12;
        Resources r104 = r103.getResources();
        if (r104 == null) goto L12;
        r101 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
    L13:
        if (r101 != null) goto L16;
        Resources r105 = Resources.getSystem();
        r101 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
    L12:
        r101 = null;
        goto L13
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
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r102 <= 0) goto L5;
        boolean r103 = r101.getBoolean(r102);
    L15:
        Class r104 = a("android.os.SystemProperties");     // Catch: Exception -> L14
        Object r105 = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r104, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L14
        String r106 = (String) r105;     // Catch: Exception -> L14
        if (Intrinsics.areEqual("1", r106) == true) goto L17;
        if (Intrinsics.areEqual("0", r106) == false) goto L13;
        return true;
    L17:
        return false;
    L13:
        return r103;
    L5:
        r103 = false;
        goto L15
    }

    public static int f(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getWindowManager().getDefaultDisplay().getRealMetrics(r101);
        return r101.heightPixels;
    }

    public static int g(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getWindowManager().getDefaultDisplay().getRealMetrics(r101);
        return r101.widthPixels;
    }

    public final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L6;
        WindowManager r101 = ((Activity) r100).getWindowManager();     // Catch: Exception -> L13
    L7:
        Display r102 = r101.getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r102, new Object[]{r103});     // Catch: Exception -> L10
        return r103.heightPixels;
    L10:
        e = move-exception;
        int r104 = h();
        e.printStackTrace();
        return r104;
    L6:
        Object r105 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L13
        r101 = (WindowManager) r105;     // Catch: Exception -> L13
        goto L7
    L14:
        return h();
    }

    public final int e(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (((Boolean) RomUtils.f40050a.getValue()).booleanValue() == true) goto L8;
    L10:
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 <= 0) goto L13;
        int r103 = r101.getDimensionPixelSize(r102);
    L14:
        Rect r104 = new Rect();
        if ((r100 instanceof Activity) == false) goto L19;
        b(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r104);
        int r105 = r104.height();
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((d(r100) - i()) - r105, 0), r103);
    L19:
        if (c(r100) == true) goto L22;
        return 0;
    L22:
        return r103;
    L13:
        r103 = 0;
        goto L14
    L8:
        if (Settings.Global.getInt(r100.getContentResolver(), "hide_gesture_line", 0) != 1) goto L10;
        return 0;
    }
}
