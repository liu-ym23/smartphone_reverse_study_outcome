package com.bytedance.android.ec.base.settings;

import androidx.lifecycle.LifecycleOwner;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f42816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<LifecycleOwner, ConcurrentHashMap<String, Object>> f42817b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f42818c = null;

    static {
        f42816a = new ConcurrentHashMap();
        f42817b = new WeakHashMap();
        f42818c = new ConcurrentHashMap();
    }

    public static ConcurrentHashMap a() {
        return f42818c;
    }

    public static ConcurrentHashMap b() {
        return f42816a;
    }

    public static WeakHashMap c() {
        return f42817b;
    }

    public static void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f42816a.put(r100, r101);
    }

    public static void e(LifecycleOwner r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter("key_test_a", "key");
        WeakHashMap<LifecycleOwner, ConcurrentHashMap<String, Object>> r102 = f42817b;
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
