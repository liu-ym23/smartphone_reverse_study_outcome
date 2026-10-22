package com.bytedance.android.locallife.core.service;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes12.dex */
public final class LifeServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f162660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f162661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f162662c;

    static {
        f162660a = new ConcurrentHashMap();
        f162661b = LazyKt.lazy(LifeServiceManager.class, LifeServiceManager$DEFAULT_SERVICE$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.locallife.init.LifeServiceInitializer");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.locallife.init.LifeServiceInitializer");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.locallife.init.LifeServiceInitializer");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.locallife.init.LifeServiceInitializer");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.locallife.init.LifeServiceInitializer");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.locallife.init.LifeServiceInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.locallife.init.LifeServiceInitializer");
    }

    public static void d() {
        monitor-enter(LifeServiceManager.class);
        Class r100 = a();     // Catch: Throwable -> L6 Exception -> L8
        r100.getDeclaredMethod("init", new Class[0]).invoke(r100.newInstance(), new Object[0]);     // Catch: Throwable -> L6 Exception -> L8
    L12:
        monitor-exit(LifeServiceManager.class);
        return;
    L8:
        e = move-exception;
        a r101 = f162662c;     // Catch: Throwable -> L6
        if (r101 == null) goto L12;
        r101.a(e);     // Catch: Throwable -> L6
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static Object b(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ConcurrentHashMap<Class<?>, Object> r101 = f162660a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L5;
        d();
        r102 = r101.get(r100);
    L5:
        if (r102 != null) goto L8;
        r102 = ((ConcurrentHashMap) f162661b.getValue()).get(r100);
    L8:
        if ((r102 instanceof List) == true) goto L10;
        Object r103 = null;
    L11:
        List r104 = (List) r103;
        if (r104 == null) goto L14;
        int r105 = r104.size();
    L16:
        if (r105 < 1) goto L21;
        if (r102 == null) goto L20;
        r102 = ListProtector.get((List) r102, 0);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    L21:
        if (r102 != null) goto L25;
        a r106 = f162662c;
        if (r106 == null) goto L25;
        r106.a(new RuntimeException(r100 + " obtained is EMPTY!"));
    L25:
        return r102;
    L14:
        r105 = 0;
        goto L16
    L10:
        r103 = r102;
        goto L11
    }

    public static List c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ConcurrentHashMap<Class<?>, Object> r101 = f162660a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L5;
        d();
        r102 = r101.get(r100);
    L5:
        if (r102 != null) goto L7;
        r102 = ((ConcurrentHashMap) f162661b.getValue()).get(r100);
    L7:
        if (r102 != null) goto L14;
        a r103 = f162662c;
        if (r103 == null) goto L12;
        r103.a(new RuntimeException(r100 + " array obtained is EMPTY!"));
    L12:
        return CollectionsKt.emptyList();
    L14:
        if ((r102 instanceof List) == true) goto L16;
        Object r104 = null;
    L17:
        List r105 = (List) r104;
        if (r105 == null) goto L21;
        return r105;
    L21:
        return CollectionsKt.listOf(r102);
    L16:
        r104 = r102;
        goto L17
    }

    public static void e(Class r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        monitor-enter(LifeServiceManager.class);
        f162660a.put(r100, r101);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(LifeServiceManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
