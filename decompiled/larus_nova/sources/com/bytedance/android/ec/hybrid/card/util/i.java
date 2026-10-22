package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.ec.hybrid.log.mall.b.a f46603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f46604b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f46605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f46606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f46607e = null;

    public i() {
    }

    static {
        f46607e = new i();
        f46603a = com.bytedance.android.ec.hybrid.log.mall.b.a.f47455b;
        f46604b = new AtomicInteger(0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.lynx.animax.util.LynxAnimaX");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.lynx.animax.util.LynxAnimaX");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.lynx.animax.util.LynxAnimaX");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.lynx.animax.util.LynxAnimaX");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.lynx.animax.util.LynxAnimaX");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.lynx.animax.util.LynxAnimaX");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.lynx.animax.util.LynxAnimaX");
    }
}
