package com.bytedance.apm.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f190679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f190680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f190681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f190682d;

    public static String c() {
        if (f190680b == true) goto L5;
    L8:
        boolean r100 = true;
        if (a("miui.os.Build") == null) goto L13;
        f190679a = true;     // Catch: Exception -> L90
        boolean r101 = true;
    L14:
        String r102 = "";
        if (r101 == true) goto L91;
        String r103 = Build.DISPLAY;
        boolean r104 = false;
        if (r103.contains("Flyme") == false) goto L26;
    L29:
        boolean r105 = true;
    L30:
        if (r105 == true) goto L32;
        String r106 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r106) == true) goto L37;
        boolean r107 = r106.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    L38:
        if (r107 == true) goto L40;
        String r108 = d(com.alipay.sdk.m.c.a.f25238a);
        if (r108 != null) goto L47;
    L49:
        String r109 = "";
    L51:
        if (TextUtils.isEmpty(r109) == true) goto L53;
        r102 = r109;
    L87:
        f190681c = r102;
        return r102;
    L53:
        String r110 = d("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r110) == false) goto L56;
    L58:
        boolean r111 = false;
    L59:
        if (r111 == false) goto L62;
        r102 = d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
        goto L87
    L62:
        if (TextUtils.isEmpty(r103) == false) goto L64;
    L66:
        boolean r112 = false;
    L67:
        if (r112 == false) goto L69;
        r102 = r103 + "_" + d("ro.gn.sv.version");
        goto L87
    L69:
        String r113 = r106 + Build.BRAND;
        if (TextUtils.isEmpty(r113) == true) goto L77;
        String r114 = r113.toLowerCase(Locale.getDefault());
        if (r114.contains(AppConstants.CHANNEL_360) == false) goto L75;
    L76:
        r104 = true;
        goto L77
    L75:
        if (r114.contains("qiku") == true) goto L76;
    L77:
        if (r104 == false) goto L80;
        r102 = d("ro.build.uiversion") + "_" + r103;
        goto L87
    L80:
        if ((!TextUtils.isEmpty(d("ro.letv.release.version"))) == false) goto L83;
        r102 = "eui_" + d("ro.letv.release.version") + "_" + r103;
    L83:
        if (TextUtils.isEmpty(r102) == false) goto L87;
        f190680b = true;
    L86:
        r102 = r103;
        goto L87
    L64:
        if (r103.toLowerCase(Locale.getDefault()).contains("amigo") == false) goto L66;
        r112 = true;
        goto L67
    L56:
        if (r110.toLowerCase(Locale.getDefault()).contains("funtouch") == false) goto L58;
        r111 = true;
        goto L59
    L47:
        if (r108.toLowerCase(Locale.getDefault()).contains("emotionui") == false) goto L49;
        r109 = r108 + "_" + r103;
        goto L51
    L40:
        if (TextUtils.isEmpty(r106) == true) goto L42;
        r104 = r106.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    L42:
        if (r104 == false) goto L87;
        r102 = "coloros_" + d("ro.build.version.opporom") + "_" + r103;
        goto L87
    L37:
        r107 = false;
        goto L38
    L32:
        if (r103.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L87;
    L26:
        if ("flyme".equals(Build.USER) == true) goto L29;
        r105 = false;
        goto L30
    L91:
        if (a("miui.os.Build") == null) goto L20;
        f190679a = true;     // Catch: Exception -> L89
    L21:
        if (r100 == false) goto L87;
        r102 = "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    L20:
        r100 = f190679a;
    L13:
        r101 = f190679a;
        goto L14
    L5:
        if (TextUtils.isEmpty(f190681c) == true) goto L8;
        return f190681c;
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

    public static String d(String r100) {
        String r101 = "";
        BufferedReader r102 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        String r103 = "";
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L23;
        return r103;
    L23:
        Process r104 = b(Runtime.getRuntime(), "getprop ".concat(r100));     // Catch: Throwable -> L20
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r104.getInputStream()), 1024);     // Catch: Throwable -> L20
        r101 = r105.readLine();     // Catch: Throwable -> L17
        r104.destroy();     // Catch: Throwable -> L17
        d27.d.a(r105);
        return r101;
    L17:
        r102 = r105;
    L18:
        d27.d.a(r102);
        return r101;
    L4:
        if (f190682d != null) goto L6;
        f190682d = a("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L8
    L6:
        r103 = (String) f190682d.invoke(null, new Object[]{r100});     // Catch: Exception -> L8
        goto L11
    }

    public static Process b(Runtime r110, String r111) {
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
