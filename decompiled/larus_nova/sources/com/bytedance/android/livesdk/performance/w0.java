package com.bytedance.android.livesdk.performance;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f154827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f154828b = -1;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String d() {
        StringBuilder r100 = new StringBuilder("getRomManufacturer: ");
        String r101 = Build.MANUFACTURER;
        r100.append(r101);
        Logger.d("RomUtils", r100.toString());
        return r101;
    }

    public static boolean b(String r100) {
        String r101 = f154827a;
        if (r101 == null) goto L7;
        return r101.equals(r100);
    L7:
        if (TextUtils.isEmpty(c("ro.miui.ui.version.name")) == true) goto L10;
        c("ro.miui.ui.version.name");
        f154827a = "MIUI";
    L26:
        return f154827a.equals(r100);
    L10:
        if (TextUtils.isEmpty(c(com.alipay.sdk.m.c.a.f25238a)) == true) goto L13;
        c(com.alipay.sdk.m.c.a.f25238a);
        f154827a = "EMUI";
        goto L26
    L13:
        if (TextUtils.isEmpty(c("ro.build.version.opporom")) == true) goto L16;
        c("ro.build.version.opporom");
        f154827a = "OPPO";
        goto L26
    L16:
        if (TextUtils.isEmpty(c("ro.vivo.os.version")) == true) goto L19;
        c("ro.vivo.os.version");
        f154827a = "VIVO";
        goto L26
    L19:
        if (TextUtils.isEmpty(c("ro.smartisan.version")) == true) goto L22;
        c("ro.smartisan.version");
        f154827a = "SMARTISAN";
        goto L26
    L22:
        if (Build.DISPLAY.toUpperCase().contains("FLYME") == false) goto L24;
        f154827a = "FLYME";
        goto L26
    L24:
        f154827a = Build.MANUFACTURER.toUpperCase();
        goto L26
    }

    public static String c(String r100) {
        Class r101 = a();     // Catch: Exception -> L8
        String r102 = (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});     // Catch: Exception -> L8
        Logger.d("RomUtils", "key is:" + r100 + " prop is: " + r102);     // Catch: Exception -> L6
    L11:
        return r102;
    L6:
        e = e;
    L10:
        Logger.e("RomUtils", "read the content of build.prop exception.", e);
    L8:
        e = e;
        r102 = "";
        goto L10
    }
}
