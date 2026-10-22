package com.google.common.cache;

import l3.InterfaceC1656A;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class CacheBuilder$OneWeigher implements InterfaceC1656A {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheBuilder$OneWeigher f2724a;
    public static final /* synthetic */ CacheBuilder$OneWeigher[] b;

    static {
        CacheBuilder$OneWeigher cacheBuilder$OneWeigher = new CacheBuilder$OneWeigher("INSTANCE", 0);
        f2724a = cacheBuilder$OneWeigher;
        b = new CacheBuilder$OneWeigher[]{cacheBuilder$OneWeigher};
    }

    public static CacheBuilder$OneWeigher valueOf(String str) {
        return (CacheBuilder$OneWeigher) Enum.valueOf(CacheBuilder$OneWeigher.class, str);
    }

    public static CacheBuilder$OneWeigher[] values() {
        return (CacheBuilder$OneWeigher[]) b.clone();
    }
}
