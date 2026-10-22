package com.apm.lite.k;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f29995a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f29996b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f29997c = null;

    static {
        f29997c = PatternProtector.compile("^0-([\\d]+)$");
    }

    public static String b() {
        BufferedReader r100 = null;
        String r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(f(Runtime.getRuntime(), "getprop ro.build.version.emui").getInputStream()), 1024);     // Catch: Throwable -> L7
        r101 = r102.readLine();     // Catch: Throwable -> L6
        r102.close();     // Catch: Throwable -> L6
        j.a(r102);
        return r101;
    L6:
        String r103 = r101;
        r100 = r102;
    L8:
        j.a(r100);
        return r103;
    L7:
        r103 = null;
        goto L8
    }

    public static boolean e() {
        if (f29995a == true) goto L11;
        if (a() == null) goto L9;
        com.apm.lite.j.e.f29956a = true;     // Catch: Exception -> L12
        f29995a = true;     // Catch: Exception -> L12
        return true;
    L9:
        f29995a = true;
    L11:
        return com.apm.lite.j.e.f29956a;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    public static int g() {
        int r100 = f29996b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        int r101 = d("/sys/devices/system/cpu/possible");
        if (r101 > 0) goto L8;
        r101 = d("/sys/devices/system/cpu/present");
    L8:
        if (r101 <= 0) goto L24;
    L17:
        if (r101 > 0) goto L19;
        r101 = Runtime.getRuntime().availableProcessors();
    L19:
        if (r101 > 0) goto L21;
        r101 = 1;
    L21:
        f29996b = r101;
        return r101;
    L24:
        File[] r102 = new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new d());     // Catch: Throwable -> L23
        if (r102 == null) goto L16;
        if (r102.length <= 0) goto L16;
        r101 = r102.length;     // Catch: Throwable -> L23
    L16:
        r101 = -1;
        goto L17
    }

    public static boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = b();
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
    L23:
        String r101 = Build.BRAND;     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r101) == false) goto L14;
    L15:
        String r102 = Build.MANUFACTURER;     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r102) == true) goto L20;
        if (r102.toLowerCase(Locale.getDefault()).startsWith(RomUtils.BRAND_HUAWEI) == false) goto L20;
        return true;
    L14:
        if (r101.toLowerCase(Locale.getDefault()).startsWith(RomUtils.BRAND_HUAWEI) == false) goto L15;
        return true;
    L20:
        return false;
    L8:
        if (r100.toLowerCase(Locale.getDefault()).startsWith("emotionui") == false) goto L23;
        return true;
    }

    public static int d(String r100) {
        int r101 = -1;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r100)));     // Catch: Throwable -> L16
        String r103 = r102.readLine();     // Catch: Throwable -> L15
        if (r103 == null) goto L23;
        Matcher r104 = f29997c.matcher(r103);     // Catch: Throwable -> L15
        if (r104.matches() == true) goto L31;
    L29:
        r102.close();     // Catch: IOException -> L21
    L12:
        return r101;
    L31:
        r101 = CastIntegerProtector.parseInt(r104.group(1)) + 1;
        goto L29
    L23:
        r102.close();     // Catch: IOException -> L22
    L19:
        return -1;
    L17:
        if (r102 == null) goto L19;
    L16:
        r102 = null;
        goto L17
    }

    public static Process f(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
