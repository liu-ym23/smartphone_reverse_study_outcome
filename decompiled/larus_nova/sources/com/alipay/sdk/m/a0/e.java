package com.alipay.sdk.m.a0;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f25229a;

    static {
        f25229a = new e();
    }

    public e() {
    }

    public static e a() {
        return f25229a;
    }

    public static String a(String r100, String r101) {
    L6:
        return r101;
    L4:
        return (String) INVOKESTATIC_com_alipay_sdk_m_a0_e_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, r101});
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b() {
        return "android";
    }

    public static boolean c() {
        String[] r100 = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int r101 = 0;
    L4:
        if (r101 >= 5) goto L10;
        if (new PolarisFileWrapper(r100[r101] + "su").exists() == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean d() {
        if (Build.HARDWARE.contains("goldfish") == false) goto L6;
    L11:
        return true;
    L6:
        if (Build.PRODUCT.contains("sdk") == true) goto L11;
        if (Build.FINGERPRINT.contains("generic") == true) goto L11;
        return false;
    L16:
        return false;
    }

    public static String e() {
        return Build.BOARD;
    }

    public static String f() {
        return Build.BRAND;
    }

    public static String g() {
        return Build.DEVICE;
    }

    public static String h() {
        return Build.DISPLAY;
    }

    public static String i() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        return Build.MANUFACTURER;
    }

    public static String k() {
        return Build.MODEL;
    }

    public static String l() {
        return Build.PRODUCT;
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static String n() {
        return Build.VERSION.SDK;
    }

    public static String o() {
        return Build.TAGS;
    }

    public static String p() {
        return a("ro.kernel.qemu", "0");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_a0_e_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
