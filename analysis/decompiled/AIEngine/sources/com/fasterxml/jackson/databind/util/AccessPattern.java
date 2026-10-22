package com.fasterxml.jackson.databind.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AccessPattern {

    /* renamed from: a, reason: collision with root package name */
    public static final AccessPattern f4491a;

    /* renamed from: b, reason: collision with root package name */
    public static final AccessPattern f4492b;

    /* renamed from: c, reason: collision with root package name */
    public static final AccessPattern f4493c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AccessPattern[] f4494d;

    static {
        AccessPattern accessPattern = new AccessPattern("ALWAYS_NULL", 0);
        f4491a = accessPattern;
        AccessPattern accessPattern2 = new AccessPattern("CONSTANT", 1);
        f4492b = accessPattern2;
        AccessPattern accessPattern3 = new AccessPattern("DYNAMIC", 2);
        f4493c = accessPattern3;
        f4494d = new AccessPattern[]{accessPattern, accessPattern2, accessPattern3};
    }

    public AccessPattern() {
        throw null;
    }

    public static AccessPattern valueOf(String str) {
        return (AccessPattern) Enum.valueOf(AccessPattern.class, str);
    }

    public static AccessPattern[] values() {
        return (AccessPattern[]) f4494d.clone();
    }
}
