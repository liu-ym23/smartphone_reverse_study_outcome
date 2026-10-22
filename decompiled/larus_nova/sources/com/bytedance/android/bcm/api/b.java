package com.bytedance.android.bcm.api;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jc.b f41761a = null;

    static {
    L13:
        th = move-exception;
        th.getMessage();
    L15:
        jc.b r100 = jc.a.f498067a;
    L16:
        f41761a = r100;
        return;
    L18:
        Constructor r101 = a().getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L10
        r101.setAccessible(true);     // Catch: Throwable -> L10
        Object r102 = r101.newInstance(new Object[0]);     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        r100 = (jc.b) r102;     // Catch: Throwable -> L10
        goto L16
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bcm.api.inner.IBcmService");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L13
        goto L15
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.bcm.impl.BcmServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.bcm.impl.BcmServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.bcm.impl.BcmServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.bcm.impl.BcmServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.bcm.impl.BcmServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.bcm.impl.BcmServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.bcm.impl.BcmServiceImpl");
    }

    public static /* synthetic */ kc.a c(PageFinder r100, List r101) {
        return b(r100, r101, 20);
    }

    @JvmStatic
    public static final void f(PageFinder r100, Map<String, ? extends Object> r101) {
        f41761a.setUnitParamsV2(r100, r101);
    }

    @Deprecated(message = "biz out of use")
    @JvmStatic
    public static final kc.a b(PageFinder r100, List<String> r101, int r102) {
        return f41761a.getBcmChainByFinder(r100, r101, r102, false);
    }

    public static void d(PageFinder r100, BcmParams r101, boolean r102) {
        f41761a.setBcmPageParams(r100, r101, r102);
    }

    @JvmStatic
    public static final void e(PageFinder r100, String r101, BcmParams r102) {
        f41761a.setPageParams(r100, r101, r102);
    }
}
