package com.bytedance.android.annie.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f40070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f40071b;

    static {
        f40070a = new p();
    }

    public p() {
    }

    public static int f() {
        int r100 = f40071b;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = 0;
        Resources r102 = com.bytedance.android.annie.ng.g.a().getResources();     // Catch: Exception -> L19
        Integer r103 = null;
        if (r102 == null) goto L9;
        Integer r104 = Integer.valueOf(r102.getIdentifier("status_bar_height", "dimen", "android"));     // Catch: Exception -> L19
    L10:
        if (r104 != null) goto L12;
    L17:
        f40071b = r101;
        goto L18
    L12:
        if (r104.intValue() <= 0) goto L17;
        int r105 = r104.intValue();     // Catch: Exception -> L19
        Resources r106 = com.bytedance.android.annie.ng.g.a().getResources();     // Catch: Exception -> L19
        if (r106 == null) goto L16;
        r103 = Integer.valueOf(r106.getDimensionPixelSize(r105));     // Catch: Exception -> L19
    L16:
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L19
        r101 = r103.intValue();     // Catch: Exception -> L19
    L9:
        r104 = null;
    L18:
        return r101;
    }

    private final Application getContext() {
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L7;
        return null;
    L7:
        return com.bytedance.android.annie.ng.g.a();
    }

    public final DisplayMetrics b() {
        if (AnnieConfigSettingKeys.ANNIE_METRICS_ADAPTER.a().booleanValue() == true) goto L6;
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    L6:
        Application r101 = getContext();
        if (r101 == null) goto L13;
        Context r102 = r101.getApplicationContext();
        if (r102 == null) goto L13;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L13;
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
    L14:
        if (r104 != null) goto L17;
        Resources r105 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
    L17:
        return r104;
    L13:
        r104 = null;
        goto L14
    }

    public final int d() {
        return b().heightPixels;
    }

    public final int e() {
        return b().widthPixels;
    }

    public final Resources getResources() {
        Application r100 = getContext();
        if (r100 == null) goto L5;
        Resources r101 = r100.getResources();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return Resources.getSystem();
    L5:
        r101 = null;
        goto L6
    }

    public static DisplayMetrics c(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        if (r100 != null) goto L6;
        return r101;
    L6:
        if ((r100 instanceof Activity) == false) goto L8;
        WindowManager r102 = ((Activity) r100).getWindowManager();
    L9:
        if (r102 != null) goto L11;
        return r101;
    L11:
        r102.getDefaultDisplay().getRealMetrics(r101);
        return r101;
    L8:
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.WindowManager");
        r102 = (WindowManager) r103;
        goto L9
    }

    public static float g(Context r100) {
        int r101 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L6:
        r101 = 0;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;     // Catch: Exception -> L34
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;     // Catch: Exception -> L34
        if (el9.a.a() == true) goto L46;
        Class<?> r104 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L13
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L13
    L36:
        Object r105 = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{"ro.sf.lcd_density"});     // Catch: Exception -> L34
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L34
        r101 = ((Integer) r105).intValue();     // Catch: Exception -> L34
    L13:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L17;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L34
    L17:
        throw th;     // Catch: Exception -> L34
    L46:
        r104 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L22
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L27;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L34
    L27:
        if ((th instanceof PluginClassNotFoundException) == false) goto L29;
        throw th;     // Catch: Exception -> L34
    L29:
        if ((th instanceof ClassNotFoundException) == false) goto L31;
    L35:
        r104 = MiraPluginFix.forName("android.os.SystemProperties");     // Catch: Exception -> L34
        goto L36
    L31:
        if ((th instanceof NoClassDefFoundError) == true) goto L35;
        throw th;     // Catch: Exception -> L34
    L38:
        if (r101 == 0) goto L41;
        if (r100 == null) goto L41;
        return r100.getResources().getConfiguration().densityDpi / r101;
    L41:
        return 1.0f;
    L5:
        if (DisplayMetrics.DENSITY_DEVICE_STABLE != 160) goto L38;
        goto L6
    }

    public final int a(float r100) {
        return (int) ((r100 * b().density) + 0.5f);
    }

    public final float h(int r100) {
        return r100 / b().density;
    }
}
