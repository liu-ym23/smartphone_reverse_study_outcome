package com.fasterxml.jackson.annotation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OptBoolean {

    /* renamed from: a, reason: collision with root package name */
    public static final OptBoolean f3501a;

    /* renamed from: b, reason: collision with root package name */
    public static final OptBoolean f3502b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ OptBoolean[] f3503c;

    static {
        OptBoolean optBoolean = new OptBoolean("TRUE", 0);
        f3501a = optBoolean;
        OptBoolean optBoolean2 = new OptBoolean("FALSE", 1);
        OptBoolean optBoolean3 = new OptBoolean("DEFAULT", 2);
        f3502b = optBoolean3;
        f3503c = new OptBoolean[]{optBoolean, optBoolean2, optBoolean3};
    }

    public OptBoolean() {
        throw null;
    }

    public static OptBoolean valueOf(String str) {
        return (OptBoolean) Enum.valueOf(OptBoolean.class, str);
    }

    public static OptBoolean[] values() {
        return (OptBoolean[]) f3503c.clone();
    }
}
