package com.bytedance.android.live.plugin_api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class LivePluginSPIManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f85852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<a>> f85853b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f85854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f85855d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LivePluginSPIManager f85856e = null;

    public interface a {
        void afterReady();
    }

    static {
        f85852a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePluginSPIManager.class), "service", "getService()Lcom/bytedance/android/live/plugin_api/service/IPluginService;"))};
        f85856e = new LivePluginSPIManager();
        f85853b = new ConcurrentHashMap();
        f85855d = LazyKt.lazy(LivePluginSPIManager$service$2.INSTANCE);
    }

    public LivePluginSPIManager() {
    }

    public static com.bytedance.android.live.plugin_api.a a() {
        b r100 = f85854c;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r100.isDisabled("com.ss.android.live.broadcast") == false) goto L9;
        com.bytedance.android.live.plugin_api.a.f85857a.getClass();
        return com.bytedance.android.live.plugin_api.a.C1324a.f85858a;
    L9:
        b r101 = f85854c;
        if (r101 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r101.getPlugin("com.ss.android.live.broadcast");
    }

    public static boolean b() {
        b r100 = f85854c;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r100.isPlugin("com.ss.android.live.broadcast");
    }

    public static boolean c() {
        b r100 = f85854c;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r100.isPluginReady("com.ss.android.live.broadcast");
    }

    public static void d(a r100) {
        b r101 = f85854c;
        if (r101 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r101.isDisabled("com.ss.android.live.broadcast") == false) goto L9;
        return;
    L9:
        if (c() == false) goto L11;
    L19:
        r100.afterReady();
        return;
    L11:
        if (b() == false) goto L19;
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> r102 = f85853b;
        CopyOnWriteArrayList<a> r103 = r102.get("com.ss.android.live.broadcast");
        if (r103 != null) goto L18;
        r103 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<a> r104 = r102.putIfAbsent("com.ss.android.live.broadcast", r103);
        if (r104 == null) goto L18;
        r103 = r104;
    L18:
        r103.add(r100);
    }

    public static void e(a r100) {
        CopyOnWriteArrayList<a> r101 = f85853b.get("com.ss.android.live.broadcast");
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }
}
