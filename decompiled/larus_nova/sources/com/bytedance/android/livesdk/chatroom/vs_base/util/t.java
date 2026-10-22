package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes8.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f118215a = 0;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.Display");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.Display");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.Display");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.Display");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.Display");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.Display");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.Display");
    }

    public static String c() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "navigationbar_is_min";
    L6:
        if (StringsKt.equals(r100, SystemUtils.PRODUCT_HUAWEI, true) == false) goto L8;
    L33:
        return "navigationbar_is_min";
    L8:
        if (StringsKt.equals(SystemUtils.PRODUCT_HONOR, r100, true) == true) goto L33;
        if (StringsKt.equals(r100, "XIAOMI", true) == false) goto L15;
        return "force_fsg_nav_bar";
    L15:
        if (StringsKt.equals(r100, DimLocationCheckUtil.VIVO, true) == false) goto L19;
        return "navigation_gesture_on";
    L19:
        if (StringsKt.equals(r100, AppConstants.CHANNEL_OPPO, true) == false) goto L23;
        return "hide_navigationbar_enable";
    L23:
        if (StringsKt.equals(r100, SmEditTextLeakOpt.SAMSUNG, true) == false) goto L27;
        return "navigationbar_hide_bar_enabled";
    L27:
        if (StringsKt.equals(r100, "Nokia", true) == false) goto L33;
        if (Build.VERSION.SDK_INT >= 28) goto L31;
        return "navigation_bar_can_hiden";
    L31:
        return "swipe_up_to_switch_apps_enabled";
    }

    public static int e() {
        return Math.max(s1.w(), s1.y());
    }

    public static int f() {
        return Math.min(s1.w(), s1.y());
    }

    @JvmStatic
    public static final int g() {
        if (s1.getContext() == null) goto L8;
        if (i() == false) goto L8;
        return Math.max(s1.w(), s1.y());
    L8:
        return Math.min(s1.w(), s1.y());
    }

    @JvmStatic
    public static final int h() {
        if (s1.getContext() == null) goto L8;
        if (i() == false) goto L8;
        return Math.min(s1.w(), s1.y());
    L8:
        return Math.max(s1.w(), s1.y());
    }

    @JvmStatic
    public static final boolean i() {
        if (s1.getContext().getResources().getConfiguration().orientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int j() {
        DisplayMetrics r100 = s1.q(s1.getContext());
        return Math.min(r100.heightPixels, r100.widthPixels);
    }

    static {
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

    public static int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L6;
        WindowManager r101 = ((Activity) r100).getWindowManager();     // Catch: Exception -> L17
    L9:
        Display r102 = r101.getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        a().getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r102, new Object[]{r103});     // Catch: Exception -> L12
        return r103.heightPixels;
    L12:
        e = move-exception;
        int r104 = g();
        e.printStackTrace();
        return r104;
    L6:
        Object r105 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L17
        if (r105 == null) goto L16;
        r101 = (WindowManager) r105;     // Catch: Exception -> L17
        goto L9
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L17
    L18:
        return g();
    }
}
