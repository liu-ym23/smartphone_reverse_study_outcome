package com.bytedance.android.ec.hybrid;

import com.bytedance.android.api.PluginExp;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.m;
import com.bytedance.android.ec.hybrid.service.IECFontService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import jk.b;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import yj.f;
import yj.g;
import yj.q;
import yj.t;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile IHybridHostService f46249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ExecutorService f46250b;

    static {
        new ArrayList();
    }

    public static ExecutorService d() {
        ExecutorService r100 = f46250b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("brid/ECHybrid"));
    }

    public static IHybridHostService h() {
        IHybridHostService r100 = f46249a;
        if (r100 == null) goto L14;
        return r100;
    L14:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        Object r102 = a("com.bytedance.android.ec.host.impl.HybridHostService").newInstance();     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        IHybridHostService r103 = (IHybridHostService) r102;     // Catch: Throwable -> L10
    L12:
        f46249a = r103;
        return f46249a;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.hostapi.IHybridHostService");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r103 = null;
        goto L12
    }

    public static g b() {
        IHybridHostService r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHostAB();
    }

    public static IECFontService c() {
        IHybridHostService r100 = h();
        if (r100 == null) goto L9;
        f r101 = r100.getHybridECSdkService();
        if (r101 == null) goto L10;
        r101.b();
        return null;
    L10:
        return null;
    L9:
        return null;
    }

    public static void e() {
        IHybridHostService r100 = h();
        if (r100 == null) goto L6;
        r100.getIHybridHostKVService();
        return;
    }

    public static q f() {
        IHybridHostService r100 = h();
        if (r100 == null) goto L7;
        q r101 = r100.getServiceProvider();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return yj.a.f568005a;
    }

    public static t g() {
        IHybridHostService r100 = h();
        t r101 = null;
        if (r100 == null) goto L5;
        t r102 = r100.getHybridLynxHostService();
    L6:
        if (r102 != null) goto L18;
        boolean r103 = PluginExp.f41754a;
        int r104 = b.f499469a;
        PluginExp.b("ECHybrid tryGetAppLynxHostServiceByReflect 反射, isSaas: true");
        PluginExp.a();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
        Object r106 = a("com.bytedance.android.ec.core.widget.liveboxview.HybridLynxHostServiceImpl").newInstance();     // Catch: Throwable -> L13
        if (r106 == null) goto L12;
        r101 = (t) r106;     // Catch: Throwable -> L13
    L16:
        return r101;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.hostapi.IHybridLynxHostService");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        Lazy r108 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(m.a.f47507b, "reflect get hybrid app lynx host service error");
        goto L16
    L18:
        return r102;
    L5:
        r102 = null;
        goto L6
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

    public static void i(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (f46250b == null) goto L7;
        ExecutorService r101 = f46250b;
        if (r101 == null) goto L9;
        r101.submit(r100);
        return;
    L9:
        return;
    L7:
        Schedulers.io().scheduleDirect(r100);
    }
}
