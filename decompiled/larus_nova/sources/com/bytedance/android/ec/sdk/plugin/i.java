package com.bytedance.android.ec.sdk.plugin;

import com.bytedance.android.api.PluginExp;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginLoader f48157a;

    public i(PluginLoader r100) {
        this.f48157a = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.ec.sdk.plugin.MainInitializer");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.sdk.plugin.MainInitializer");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.sdk.plugin.MainInitializer");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.ec.sdk.plugin.MainInitializer");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.sdk.plugin.MainInitializer");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.sdk.plugin.MainInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ec.sdk.plugin.MainInitializer");
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        PluginLoader r101 = this.f48157a;     // Catch: Throwable -> L13
        r101.getClass();     // Catch: Throwable -> L13
        boolean r102 = ECServiceManager.f42805a;     // Catch: Throwable -> L13
        hj.c r103 = (hj.c) ECServiceManager.b(hj.c.class);     // Catch: Throwable -> L13
        if (r103 == null) goto L6;
        Boolean r104 = Boolean.valueOf(r103.load());     // Catch: Throwable -> L13
    L8:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L10;
        int r105 = 2;
    L11:
        r101.f48149a = r105;     // Catch: Throwable -> L13
        boolean r106 = PluginExp.f41754a;     // Catch: Throwable -> L13
        int r107 = com.bytedance.android.ec.sdk.initalizer.d.f48144a;     // Catch: Throwable -> L13
        PluginExp.b("PluginLoader initLoadPlugin 反射, isSaas: true");     // Catch: Throwable -> L13
        PluginExp.a();     // Catch: Throwable -> L13
        a().getMethod("init", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
        r100.onComplete();     // Catch: Throwable -> L13
        return;
    L10:
        r105 = 3;
        goto L11
    L6:
        r104 = null;
    L13:
        th = move-exception;
        this.f48157a.f48149a = 3;
        r100.onError(th);
    }
}
