package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, StoreTabConfig> f186935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f186936b = null;

    static {
        f186935a = new ConcurrentHashMap();
        f186936b = new AtomicInteger(0);
    }

    public static StoreTabConfig a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return f186935a.get(r100);
    }

    public static String b(StoreTabConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "tabConfig");
        String r101 = String.valueOf(f186936b.getAndIncrement());
        f186935a.put(r101, r100);
        return r101;
    }
}
