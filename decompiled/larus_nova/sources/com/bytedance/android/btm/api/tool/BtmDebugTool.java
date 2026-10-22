package com.bytedance.android.btm.api.tool;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.model.j;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmDebugTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BtmDebugTool f42073b = null;

    public BtmDebugTool() {
    }

    public static b b() {
        return (b) f42072a.getValue();
    }

    static {
        f42073b = new BtmDebugTool();
        f42072a = LazyKt.lazy(BtmDebugTool$service$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.btm.debugtool.DebugToolServiceImpl");
    }

    public static void c(JSONObject r100) {
        if (BtmHostDependManager.F.c() == false) goto L6;
        b().a();
        return;
    }

    public final void onEventIntercepted(j r100) {
        if (BtmHostDependManager.F.c() == false) goto L6;
        b().onEventIntercepted(r100);
        return;
    }
}
