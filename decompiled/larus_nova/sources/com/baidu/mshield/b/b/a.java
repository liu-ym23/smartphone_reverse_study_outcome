package com.baidu.mshield.b.b;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_b_b_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static synchronized String a(Context r100) {
        monitor-enter(a.class);
        Class r101 = INVOKESTATIC_com_baidu_mshield_b_b_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu.mshield.ac.F");     // Catch: Throwable -> L12
        Method r102 = r101.getDeclaredMethod("getInstance", new Class[0]);     // Catch: Throwable -> L12
        r102.setAccessible(true);     // Catch: Throwable -> L12
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Throwable -> L12
        Method r104 = r101.getDeclaredMethod("gzd", new Class[]{Context.class});     // Catch: Throwable -> L12
        r104.setAccessible(true);     // Catch: Throwable -> L12
        String r105 = (String) r104.invoke(r103, new Object[]{r100});     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r105;
    L12:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L16
        return "";
    L16:
        th = move-exception;
        throw th;
    }

    public static String b(Context r100) {
    L6:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    L4:
        Method r101 = INVOKESTATIC_com_baidu_mshield_b_b_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu.mshield.utility.c").getDeclaredMethod("loadExternalDeviceId", new Class[]{Context.class});     // Catch: Throwable -> L6
        r101.setAccessible(true);     // Catch: Throwable -> L6
        return (String) r101.invoke(null, new Object[]{r100});
    }

    public static String c(Context r100) {
    L6:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    L4:
        Method r101 = INVOKESTATIC_com_baidu_mshield_b_b_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu.mshield.utility.c").getDeclaredMethod("loadSettingDeviceId", new Class[]{Context.class});     // Catch: Throwable -> L6
        r101.setAccessible(true);     // Catch: Throwable -> L6
        return (String) r101.invoke(null, new Object[]{r100});
    }
}
