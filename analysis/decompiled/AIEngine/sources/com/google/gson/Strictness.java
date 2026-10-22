package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Strictness {

    /* renamed from: a, reason: collision with root package name */
    public static final Strictness f5434a;

    /* renamed from: b, reason: collision with root package name */
    public static final Strictness f5435b;

    /* renamed from: c, reason: collision with root package name */
    public static final Strictness f5436c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ Strictness[] f5437d;

    static {
        Strictness strictness = new Strictness("LENIENT", 0);
        f5434a = strictness;
        Strictness strictness2 = new Strictness("LEGACY_STRICT", 1);
        f5435b = strictness2;
        Strictness strictness3 = new Strictness("STRICT", 2);
        f5436c = strictness3;
        f5437d = new Strictness[]{strictness, strictness2, strictness3};
    }

    public Strictness() {
        throw null;
    }

    public static Strictness valueOf(String str) {
        return (Strictness) Enum.valueOf(Strictness.class, str);
    }

    public static Strictness[] values() {
        return (Strictness[]) f5437d.clone();
    }
}
