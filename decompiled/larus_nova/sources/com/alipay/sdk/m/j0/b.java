package com.alipay.sdk.m.j0;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25381a = "IdentifierManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f25382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f25383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f25384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f25385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f25386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f25387g;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        Class<?> r100 = INVOKESTATIC_com_alipay_sdk_m_j0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.id.impl.IdProviderImpl");     // Catch: Exception -> L12
        f25383c = r100;     // Catch: Exception -> L12
        f25382b = r100.newInstance();     // Catch: Exception -> L12
        f25384d = f25383c.getMethod("getUDID", new Class[]{Context.class});     // Catch: Exception -> L12
        f25385e = f25383c.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L12
        f25386f = f25383c.getMethod("getVAID", new Class[]{Context.class});     // Catch: Exception -> L12
        f25387g = f25383c.getMethod("getAAID", new Class[]{Context.class});     // Catch: Exception -> L12
        return;
    }

    public static boolean a() {
        if (f25383c != null) goto L5;
    L7:
        return false;
    L5:
        if (f25382b == null) goto L7;
        return true;
    }

    public b() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_j0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String a(Context r100) {
        return a(r100, f25387g);
    }

    public static String b(Context r100) {
        return a(r100, f25385e);
    }

    public static String c(Context r100) {
        return a(r100, f25384d);
    }

    public static String d(Context r100) {
        return a(r100, f25386f);
    }

    public static String a(Context r100, Method r101) {
        Object r102 = f25382b;
        if (r102 == null) goto L10;
        if (r101 != null) goto L13;
        return null;
    L13:
        Object r103 = r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L12
        if (r103 == null) goto L16;
        return (String) r103;
    L16:
        return null;
    L17:
        return null;
    L10:
        return null;
    }
}
