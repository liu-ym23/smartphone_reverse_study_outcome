package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f91037a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.revenue.RevenueInitializer");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.revenue.RevenueInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.revenue.RevenueInitializer");
    }

    public static void c() {
        if (f91037a == false) goto L11;
        return;
    L11:
        Class r100 = a();     // Catch: Throwable -> L8
        r100.getDeclaredMethod("ensureInitialized", new Class[0]).invoke(r100.getField("INSTANCE").get(null), new Object[0]);     // Catch: Throwable -> L8
    L9:
        f91037a = true;
        return;
    L8:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L9
    }

    static {
    }

    public static dy0.c d(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        c();
        m r101 = m.f163449e;
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        dy0.c r103 = (dy0.c) r101.d(r102, r100);
        if (r103 == null) goto L5;
        return r103;
    L5:
        b.a(r100, r102);
        throw null;
    }

    public static dy0.c e(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        c();
        m r101 = m.f163449e;
        cy0.e.f465759a.getClass();
        return (dy0.c) r101.d(cy0.e.a.f465760a, r100);
    }

    public static dy0.d b(com.bytedance.android.live.revenue.core.b r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getService(r101);
    }
}
