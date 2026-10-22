package com.bytedance.android.ec.base.settings;

import androidx.lifecycle.LifecycleOwner;
import com.google.gson.Gson;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SDKSettingsCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f42808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f42809b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap<LifecycleOwner, ConcurrentHashMap<String, Object>> f42810c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f42811d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SDKSettingsCacheManager f42812e = null;

    public SDKSettingsCacheManager() {
    }

    public static Gson a() {
        return (Gson) f42811d.getValue();
    }

    static {
        f42812e = new SDKSettingsCacheManager();
        f42808a = new ConcurrentHashMap();
        f42809b = new ConcurrentHashMap();
        f42810c = new WeakHashMap();
        f42811d = LazyKt.lazy(SDKSettingsCacheManager$gson$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return f42809b;
    }

    public static ConcurrentHashMap c() {
        return f42808a;
    }

    public static WeakHashMap d() {
        return f42810c;
    }

    public static void e(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f42808a.put(r100, r101);
    }

    public static void f(LifecycleOwner r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter("key_test_a", "key");
        WeakHashMap<LifecycleOwner, ConcurrentHashMap<String, Object>> r102 = f42810c;
        monitor-enter(r102);
        ConcurrentHashMap<String, Object> r103 = r102.get(r100);     // Catch: Throwable -> L11
        if (r103 != null) goto L7;
        r103 = new ConcurrentHashMap();     // Catch: Throwable -> L11
        r102.put(r100, r103);     // Catch: Throwable -> L11
    L7:
        ConcurrentHashMap<String, Object> r104 = r103;     // Catch: Throwable -> L11
        monitor-exit(r102);
        r104.put("key_test_a", r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
