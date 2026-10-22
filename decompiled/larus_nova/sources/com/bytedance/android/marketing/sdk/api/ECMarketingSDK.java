package com.bytedance.android.marketing.sdk.api;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes12.dex */
public final class ECMarketingSDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f162668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f162669b = null;

    public ECMarketingSDK() {
    }

    public static final IMarketingServiceV2 c() {
        return (IMarketingServiceV2) f162669b.getValue();
    }

    static {
        f162668a = LazyKt.lazy(ECMarketingSDK$service$2.INSTANCE);
        f162669b = LazyKt.lazy(ECMarketingSDK$serviceV2$2.INSTANCE);
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

    public static final Object b(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Constructor r103 = a(r100[r102]).getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L7
        r103.setAccessible(true);     // Catch: Throwable -> L7
        return r103.newInstance(new Object[0]);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return null;
    }
}
