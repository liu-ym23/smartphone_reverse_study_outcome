package com.bytedance.ai.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f37675a = null;

    static {
        f37675a = new l();
    }

    public l() {
    }

    public static int a(Context r100) {
        Resources r101 = null;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;     // Catch: Exception -> L30
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;     // Catch: Exception -> L30
        if (el9.a.a() == false) goto L63;
        Class<?> r104 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L18
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L18
    L32:
        boolean r105 = true;
        Object r106 = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r104, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L30
        String r107 = (String) r106;     // Catch: Exception -> L30
        if (Intrinsics.areEqual("1", r107) == false) goto L36;
    L48:
        r105 = false;
    L49:
        if (r105 == true) goto L51;
        return 0;
    L51:
        if (r100 == null) goto L53;
        r101 = r100.getResources();
    L53:
        if (r101 == null) goto L55;
        int r108 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
    L56:
        if (r108 <= 0) goto L65;
        if (r101 != null) goto L59;
        return 0;
    L59:
        return r101.getDimensionPixelSize(r108);
    L65:
        return 0;
    L55:
        r108 = 0;
        goto L56
    L36:
        if (Intrinsics.areEqual("0", r107) == false) goto L39;
    L18:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L23;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L30
    L23:
        if ((th instanceof PluginClassNotFoundException) == false) goto L25;
        throw th;     // Catch: Exception -> L30
    L25:
        if ((th instanceof ClassNotFoundException) == false) goto L27;
    L31:
        r104 = MiraPluginFix.forName("android.os.SystemProperties");     // Catch: Exception -> L30
        goto L32
    L27:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;     // Catch: Exception -> L30
    L63:
        r104 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L9
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L13;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L30
    L13:
        throw th;     // Catch: Exception -> L30
    L39:
        if (r100 == null) goto L41;
        Resources r109 = r100.getResources();
    L42:
        if (r109 == null) goto L44;
        int r110 = r109.getIdentifier("config_showNavigationBar", "bool", "android");
    L45:
        if (r110 <= 0) goto L48;
        if (r109 == null) goto L48;
        r105 = r109.getBoolean(r110);
        goto L49
    L44:
        r110 = 0;
        goto L45
    L41:
        r109 = null;
        goto L42
    }

    @JvmStatic
    public static final int b(Window r100) {
        if (r100 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L8;
        Activity r102 = r101.currentActivity();
        if (r102 == null) goto L8;
        r100 = r102.getWindow();
    L8:
        r100 = null;
    L9:
        if (r100 == null) goto L17;
        f37675a.getClass();
        DisplayMetrics r103 = new DisplayMetrics();
        WindowManager r104 = r100.getWindowManager();
        if (r104 == null) goto L16;
        Display r105 = r104.getDefaultDisplay();
        if (r105 == null) goto L16;
        r105.getRealMetrics(r103);
    L16:
        return r103.heightPixels;
    L17:
        Resources r106 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).heightPixels;
    }

    @JvmStatic
    public static final int c(Window r100) {
        if (r100 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L8;
        Activity r102 = r101.currentActivity();
        if (r102 == null) goto L8;
        r100 = r102.getWindow();
    L8:
        r100 = null;
    L9:
        if (r100 == null) goto L17;
        f37675a.getClass();
        DisplayMetrics r103 = new DisplayMetrics();
        WindowManager r104 = r100.getWindowManager();
        if (r104 == null) goto L16;
        Display r105 = r104.getDefaultDisplay();
        if (r105 == null) goto L16;
        r105.getRealMetrics(r103);
    L16:
        return r103.widthPixels;
    L17:
        Resources r106 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).widthPixels;
    }

    public static String e(l r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "targetKey");
        h2.a r102 = f2.b.f475099c;
        if (r102 == null) goto L10;
        Context r103 = r102.f483562a;
        if (r103 == null) goto L10;
        int r104 = r103.getResources().getIdentifier(r101, "string", r103.getPackageName());
        if (r104 == 0) goto L10;
        return r103.getString(r104);
    L10:
        return null;
    }

    public static String d(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetKey");
        int r103 = r100.getResources().getIdentifier(r101, "string", r100.getPackageName());
        if (r103 == 0) goto L5;
        String r104 = r100.getString(r103);
        Intrinsics.checkNotNull(r104);
        return r104;
    L5:
        String r105 = r100.getString(r102);
        Intrinsics.checkNotNull(r105);
        return r105;
    }
}
