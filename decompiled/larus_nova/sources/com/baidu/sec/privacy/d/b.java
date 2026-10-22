package com.baidu.sec.privacy.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sec.privacy.f.c;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f33508a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f33509b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f33510c = "";

    public static boolean a() {
        SharedPreferences r100 = c();     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        r100 = com.baidu.sec.privacy.b.b.a().getSharedPreferences("leroadcfg", 0);     // Catch: Throwable -> L8
    L6:
        return r100.getBoolean("s_a_pl", false);
    L8:
        th = move-exception;
        c.a(th);
        return false;
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static SharedPreferences b() {
        return a("getPlatformPrivateSharedPreferences");
    }

    public static SharedPreferences c() {
        return a("getPlatformSharedSharedPreferences");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_sec_privacy_d_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static SharedPreferences a(String r100) {
        Class r101 = INVOKESTATIC_com_baidu_sec_privacy_d_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu.mshield.ac.F");     // Catch: Throwable -> L6
        Object r102 = r101.getDeclaredMethod("getInstance", new Class[0]).invoke(r101, new Object[0]);     // Catch: Throwable -> L6
        return (SharedPreferences) r101.getDeclaredMethod(r100, new Class[]{Context.class}).invoke(r102, new Object[]{com.baidu.sec.privacy.b.b.a()});
    L6:
        th = move-exception;
        c.a(th);
        return null;
    }

    public static boolean b(String r100) {
    L32:
        th = move-exception;
        c.a(th);
    L35:
        return f33508a;
    L4:
        if (f33508a == false) goto L7;
        return true;
    L7:
        if (com.baidu.sec.privacy.b.b.d() == false) goto L13;
        com.baidu.sec.privacy.c r101 = com.baidu.sec.privacy.b.b.c();     // Catch: Throwable -> L32
        if (r101 == null) goto L12;
        f33508a = r101.a();     // Catch: Throwable -> L32
    L12:
        return f33508a;
    L13:
        com.baidu.sec.privacy.a r102 = com.baidu.sec.privacy.b.b.b();     // Catch: Throwable -> L32
        if (r102 == null) goto L37;
        boolean r103 = r102.a();     // Catch: Throwable -> L32
        f33508a = r103;     // Catch: Throwable -> L32
        return r103;
    L37:
        Class r104 = INVOKESTATIC_com_baidu_sec_privacy_d_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu." + r100 + ".ac.F");     // Catch: Throwable -> L30
        Object r105 = r104.getDeclaredMethod("getInstance", new Class[0]).invoke(r104, new Object[0]);     // Catch: Throwable -> L30
        Method[] r106 = INVOKESTATIC_com_baidu_sec_privacy_d_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu." + r100 + ".ac.FI").getDeclaredMethods();     // Catch: Throwable -> L30
        int r107 = r106.length;     // Catch: Throwable -> L30
        int r108 = 0;
    L20:
        if (r108 >= r107) goto L25;
        Method r109 = r106[r108];     // Catch: Throwable -> L30
        if ("cp".equals(r109.getName()) == true) goto L26;
        r108 = r108 + 1;     // Catch: Throwable -> L30
    L26:
        if (r109 != null) goto L28;
        f33508a = a();     // Catch: Throwable -> L30
        goto L35
    L28:
        f33508a = ((Boolean) r109.invoke(r105, new Object[]{com.baidu.sec.privacy.b.b.a()})).booleanValue();     // Catch: Throwable -> L30
        goto L35
    L25:
        r109 = null;
    L30:
        f33508a = a();     // Catch: Throwable -> L32
        goto L35
    }

    public static String a(String r100, SharedPreferences.OnSharedPreferenceChangeListener r101) {
        SharedPreferences r102 = b();     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r102 = com.baidu.sec.privacy.b.b.a().getSharedPreferences(f33510c, 0);     // Catch: Throwable -> L8
    L6:
        r102.registerOnSharedPreferenceChangeListener(r101);     // Catch: Throwable -> L8
        return r102.getString(f33509b, "");
    L8:
        th = move-exception;
        c.a(th);
        return "";
    }

    public static void a(String r100, boolean r101, com.baidu.sec.privacy.c r102) {
        if (r101 == false) goto L8;
        if (r102 != null) goto L6;
        return;
    L6:
        f33510c = r102.b();     // Catch: Throwable -> L12
        f33509b = r102.c();     // Catch: Throwable -> L12
    L15:
        return;
    L8:
        if ("sofire".equals(r100) == false) goto L10;
        r100 = "";
    L10:
        f33510c = "leroad" + r100 + "cfg";     // Catch: Throwable -> L12
        f33509b = "p_s_p_c";     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c.a(th);
    }
}
