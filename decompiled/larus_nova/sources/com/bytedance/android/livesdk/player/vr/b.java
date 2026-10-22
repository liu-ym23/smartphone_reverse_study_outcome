package com.bytedance.android.livesdk.player.vr;

import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ies.ugc.aweme.plugin.v2.ext.Hive");
    }

    public static void b() {
        Class r100 = a();     // Catch: Throwable -> L5
        r100.getMethod("linkNativeLibs", new Class[]{String.class, String.class}).invoke(r100.getField("INSTANCE").get(null), new Object[]{"texturerender_native", "effect"});     // Catch: Throwable -> L5
        Logger.d(LiveVrEffectInfo.TAG, "reflect link[texturerender_native -> effect] ret = ${ret}");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.d(LiveVrEffectInfo.TAG, "reflect fail link[texturerender_native -> effect] ,message=" + th.getMessage());
    }
}
