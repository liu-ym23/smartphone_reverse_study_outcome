package com.bytedance.android.ec.sdk.initalizer;

import android.os.Handler;
import android.util.Log;
import com.bytedance.android.api.PluginExp;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
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

    static {
    }

    public static void b(final ECInitLogger r100) {
        Intrinsics.checkNotNullParameter(r100, "initLogger");
        if (e.a() == true) goto L11;
        boolean r101 = PluginExp.f41754a;     // Catch: Exception -> L6
        int r102 = d.f48144a;     // Catch: Exception -> L6
        PluginExp.b("ECInitializer init 反射, isSaas: true");     // Catch: Exception -> L6
        PluginExp.a();     // Catch: Exception -> L6
        a().getMethod("init", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        final String r103 = "ECBusinessInitializer init e: " + Log.getStackTraceString(e);
        Intrinsics.checkNotNullParameter(r103, "errorMessage");
        ((Handler) r100.f48137b.getValue()).postDelayed(new ECInitLogger$logInitExceptionEvent$1(r100, r103), 30000);
        return;
    }
}
