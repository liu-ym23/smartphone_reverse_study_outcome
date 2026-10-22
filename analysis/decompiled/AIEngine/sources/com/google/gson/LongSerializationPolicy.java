package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class LongSerializationPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final LongSerializationPolicy f5427a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LongSerializationPolicy[] f5428b;

    static {
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy() { // from class: com.google.gson.LongSerializationPolicy.1
        };
        f5427a = longSerializationPolicy;
        f5428b = new LongSerializationPolicy[]{longSerializationPolicy, new LongSerializationPolicy() { // from class: com.google.gson.LongSerializationPolicy.2
        }};
    }

    public LongSerializationPolicy() {
        throw null;
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) f5428b.clone();
    }
}
