package com.tencent.mmkv;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MMKVLogLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final MMKVLogLevel f8139a;

    /* renamed from: b, reason: collision with root package name */
    public static final MMKVLogLevel f8140b;

    /* renamed from: c, reason: collision with root package name */
    public static final MMKVLogLevel f8141c;

    /* renamed from: d, reason: collision with root package name */
    public static final MMKVLogLevel f8142d;

    /* renamed from: e, reason: collision with root package name */
    public static final MMKVLogLevel f8143e;
    public static final /* synthetic */ MMKVLogLevel[] h;

    static {
        MMKVLogLevel mMKVLogLevel = new MMKVLogLevel("LevelDebug", 0);
        f8139a = mMKVLogLevel;
        MMKVLogLevel mMKVLogLevel2 = new MMKVLogLevel("LevelInfo", 1);
        f8140b = mMKVLogLevel2;
        MMKVLogLevel mMKVLogLevel3 = new MMKVLogLevel("LevelWarning", 2);
        f8141c = mMKVLogLevel3;
        MMKVLogLevel mMKVLogLevel4 = new MMKVLogLevel("LevelError", 3);
        f8142d = mMKVLogLevel4;
        MMKVLogLevel mMKVLogLevel5 = new MMKVLogLevel("LevelNone", 4);
        f8143e = mMKVLogLevel5;
        h = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
    }

    public MMKVLogLevel() {
        throw null;
    }

    public static MMKVLogLevel valueOf(String str) {
        return (MMKVLogLevel) Enum.valueOf(MMKVLogLevel.class, str);
    }

    public static MMKVLogLevel[] values() {
        return (MMKVLogLevel[]) h.clone();
    }
}
