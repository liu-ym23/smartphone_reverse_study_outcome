package com.bytedance.android.gamecp.business;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class m0 {
    public static boolean b() {
        if (Intrinsics.areEqual("156", f("ro.config.hw_optb", "0")) == false) goto L7;
        if (Intrinsics.areEqual("true", f("hw_mc.pure_mode.enable", "false")) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static String c() {
        Class r100 = a("android.os.SystemProperties");     // Catch: Throwable -> L10
        Object r101 = r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{"hw_sc.build.platform.version"});     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        String r102 = (String) r101;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return r102;
    L12:
        return "";
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    public static String d() {
        Class r100 = a("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
        Object r101 = r100.getMethod("getOsBrand", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return (String) r101;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L8
    L8:
        return "";
    }

    static {
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

    public static boolean e(String r100) {
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.isEmpty() == false) goto L12;
        return false;
    L12:
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r101, 0)) < 3) goto L10;
        return true;
    L10:
        return false;
    }

    public static String f(String r100, String r101) {
        Class r102 = a("com.huawei.android.os.SystemPropertiesEx");     // Catch: Throwable -> L8
        Object r103 = r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, "unknown"});     // Catch: Throwable -> L8
        if (r103 == null) goto L7;
        return (String) r103;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L8
    L8:
        return r101;
    }
}
