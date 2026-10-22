package com.bytedance.android.ec.monitor.duration;

import com.bytedance.android.ec.core.opt.monitor.ReportDuration;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public final class DurationMonitorManager implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f47980c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f47981d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, d> f47982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f47983b;

    public static final class a {
        public a() {
        }

        public static f a() {
            e r100 = (e) DurationMonitorManager.f47980c.getValue();
            if (r100 == null) goto L7;
            return (f) r100;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.monitor.duration.IDurationMonitorManagerInner");
        }
    }

    static {
        f47981d = new a();
        f47980c = LazyKt.lazy(DurationMonitorManager$Companion$instance$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.ec.core.opt.monitor.ReportDuration");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.core.opt.monitor.ReportDuration");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.core.opt.monitor.ReportDuration");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.ec.core.opt.monitor.ReportDuration");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.core.opt.monitor.ReportDuration");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.core.opt.monitor.ReportDuration");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ec.core.opt.monitor.ReportDuration");
    }

    @Override // com.bytedance.android.ec.monitor.duration.f
    public final g b() {
        if (this.f47983b != null) goto L9;
        c().getMethod(MiPushClient.COMMAND_REGISTER, new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        System.out.println("Django >> [DurationMonitor]: reflect ReportDuration fail: " + e);
    L9:
        return this.f47983b;
    }

    public DurationMonitorManager() {
        this.f47982a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ec.monitor.duration.e
    public final void a(ReportDuration r100) {
        Intrinsics.checkNotNullParameter(r100, "reportDuration");
        this.f47983b = r100;
    }

    @Override // com.bytedance.android.ec.monitor.duration.e
    public final String create(String r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        String[] r101 = com.bytedance.android.ec.monitor.duration.a.f47984a;
        if (ArraysKt.contains(com.bytedance.android.ec.monitor.duration.a.f47984a, r100) == false) goto L6;
        DurationMonitorImpl r102 = new DurationMonitorImpl(r100);
        String r103 = String.valueOf(r102.hashCode());
        this.f47982a.put(r103, r102);
        return r103;
    L6:
        System.out.println("Django >> [DurationMonitor create]: no business name.");
        throw new Exception("");
    }

    @Override // com.bytedance.android.ec.monitor.duration.e
    public final d get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorKey");
        return this.f47982a.get(r100);
    }

    @Override // com.bytedance.android.ec.monitor.duration.f
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorKey");
        this.f47982a.remove(r100);
    }
}
