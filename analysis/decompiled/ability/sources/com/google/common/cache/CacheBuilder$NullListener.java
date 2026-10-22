package com.google.common.cache;

import l3.z;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class CacheBuilder$NullListener implements z {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheBuilder$NullListener f2723a;
    public static final /* synthetic */ CacheBuilder$NullListener[] b;

    static {
        CacheBuilder$NullListener cacheBuilder$NullListener = new CacheBuilder$NullListener("INSTANCE", 0);
        f2723a = cacheBuilder$NullListener;
        b = new CacheBuilder$NullListener[]{cacheBuilder$NullListener};
    }

    public static CacheBuilder$NullListener valueOf(String str) {
        return (CacheBuilder$NullListener) Enum.valueOf(CacheBuilder$NullListener.class, str);
    }

    public static CacheBuilder$NullListener[] values() {
        return (CacheBuilder$NullListener[]) b.clone();
    }
}
