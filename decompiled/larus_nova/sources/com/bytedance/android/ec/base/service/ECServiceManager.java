package com.bytedance.android.ec.base.service;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class ECServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f42805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f42806b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f42807c = null;

    static {
        f42806b = new ConcurrentHashMap();
        f42807c = LazyKt.lazy(ECServiceManager$DEFAULT_SERVICE$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.sdk.initalizer.ECInitializer");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.sdk.initalizer.ECInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ec.sdk.initalizer.ECInitializer");
    }

    public static Object b(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = f42806b.get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public static Object c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = f42806b.get(r100);
        if (r101 == null) goto L5;
    L9:
        if (r101 == null) goto L11;
        return r101;
    L11:
        return ((ConcurrentHashMap) f42807c.getValue()).get(r100);
    L5:
        if (f42805a == true) goto L9;
        f42805a = true;
        Class r102 = a();     // Catch: Exception -> L12
        r102.getDeclaredMethod("init", new Class[0]).invoke(r102.newInstance(), new Object[0]);     // Catch: Exception -> L12
    L8:
        r101 = f42806b.get(r100);
        goto L9
    }

    public static boolean d(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (f42806b.get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(Map r100) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.SERVICES);
        ArrayList r101 = new ArrayList(r100.size());
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        Map.Entry r103 = (Map.Entry) r102.next();
        ConcurrentHashMap<Class<?>, Object> r104 = f42806b;
        if (r104.contains(r103.getKey()) == false) goto L16;
        Object r105 = r104.get(r103.getKey());
        Class<?> r106 = null;
        if (r105 == null) goto L10;
        Class<?> r107 = r105.getClass();
    L11:
        Object r108 = r103.getValue();
        if (r108 == null) goto L15;
        r106 = r108.getClass();
    L15:
        if (Intrinsics.areEqual(r107, r106) == false) goto L16;
    L17:
        r101.add(Unit.INSTANCE);
        goto L4
    L10:
        r107 = null;
    L16:
        r104.put((Class<?>) r103.getKey(), r103.getValue());
        goto L17
    }

    public static void e(Class r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        f42806b.put(r100, r101);
    }
}
