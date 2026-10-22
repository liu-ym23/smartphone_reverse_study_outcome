package com.bytedance.android.ecom.bcm.track.api;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ecom.bcm.track.api.p003const.AppendScene;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import cr.c;
import el9.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class EcomBcmTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f51058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51059b = null;

    public static c i() {
        return (c) f51058a.getValue();
    }

    static {
        f51058a = LazyKt.lazy(EcomBcmTracker$service$2.INSTANCE);
        f51059b = LazyKt.lazy(EcomBcmTracker$monitor$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ecom.bcm.track.impl.TrackServiceImpl");
    }

    @JvmStatic
    public static final String g(l r100) {
        return i().getBcmChainWithStandardContent(r100);
    }

    public static String h(String r100) {
        Boolean r101 = Boolean.FALSE;
        return i().getCompressedBcmChain(r100, r101, null, null);
    }

    @JvmStatic
    public static final String b(PageFinder r100, String r101) {
        if (r100 == null) goto L4;
        d r102 = new d();
        r102.f42023b = r100;
    L6:
        return i().appendEntranceInfo(r102, r101, AppendScene.UnKnown);
    L4:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final JSONObject c(PageFinder r100, JSONObject r101) {
        if (r100 == null) goto L4;
        d r102 = new d();
        r102.f42023b = r100;
    L6:
        return i().appendEntranceInfo(r102, r101, AppendScene.UnKnown);
    L4:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final String d(l r100, String r101) {
        return i().appendEntranceInfo(r100, r101, AppendScene.UnKnown);
    }

    @JvmStatic
    public static final JSONObject e(d r100, JSONObject r101) {
        return i().appendEntranceInfo(r100, r101, AppendScene.UnKnown);
    }

    @JvmStatic
    public static final Map<String, Object> f(PageFinder r100, Map<String, ? extends Object> r101) {
        return i().appendEventParams(r100, r101);
    }

    @JvmStatic
    public static final void j(PageFinder r100, BcmParams r101) {
        i().setUnitParams(r100, r101);
    }
}
