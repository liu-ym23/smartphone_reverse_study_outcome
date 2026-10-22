package com.alipay.sdk.m.i0;

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
    public static final String f25341a = "OpenIdHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f25342b;

    public b() {
    }

    public static String a(Context r100) {
        f r101 = f.a();
        return r101.a(r100.getApplicationContext(), r101.f25352c);
    }

    public static void a(boolean r100) {
        f.a();
        f.a(r100);
    }

    public static final boolean a() {
        Context r100 = null;
    L10:
        e = move-exception;
        e.toString();
    L12:
        if (r100 != null) goto L15;
        return false;
    L15:
        return f.a().a(r100, false);
    L4:
        if (f25342b == null) goto L7;
    L8:
        r100 = (Context) f25342b.invoke(null, new Object[0]);     // Catch: Exception -> L10
        goto L12
    L7:
        Method r101 = INVOKESTATIC_com_alipay_sdk_m_i0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);     // Catch: Exception -> L10
        f25342b = r101;     // Catch: Exception -> L10
        r101.setAccessible(true);     // Catch: Exception -> L10
        goto L8
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b(Context r100) {
        f r101 = f.a();
        return r101.a(r100.getApplicationContext(), r101.f25351b);
    }

    public static String c(Context r100) {
        f r101 = f.a();
        return r101.a(r100.getApplicationContext(), r101.f25350a);
    }

    public static String d(Context r100) {
        f r101 = f.a();
        return r101.a(r100.getApplicationContext(), r101.f25353d);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_i0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
