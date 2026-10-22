package com.bytedance.android.gamecp.host_api;

import bw.m;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import ew.s;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile m f57354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f57355b = null;

    public a() {
    }

    static {
        f57355b = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.livesdk.gamecp.HostServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.gamecp.HostServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.gamecp.HostServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.livesdk.gamecp.HostServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.gamecp.HostServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.gamecp.HostServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.livesdk.gamecp.HostServiceImpl");
    }

    @JvmStatic
    public static final m b() {
        if (f57354a == null) goto L6;
        m r100 = f57354a;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        a r101 = f57355b;
        monitor-enter(r101);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (f57354a == null) goto L27;
        m r102 = f57354a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L24
        monitor-exit(r101);
        return r102;
    L27:
        f57354a = (m) JavaCalls.newEmptyInstance(a());     // Catch: Exception -> L18 Throwable -> L24
        if (f57354a == null) goto L20;
        m r103 = f57354a;     // Catch: Exception -> L18 Throwable -> L24
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L18 Throwable -> L24
        monitor-exit(r101);
        return r103;
    L20:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r101);
        return new s();
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L20
    }
}
