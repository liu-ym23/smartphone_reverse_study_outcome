package com.fasterxml.jackson.databind.node;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class JsonNodeType {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonNodeType f4270a;

    /* renamed from: b, reason: collision with root package name */
    public static final JsonNodeType f4271b;

    /* renamed from: c, reason: collision with root package name */
    public static final JsonNodeType f4272c;

    /* renamed from: d, reason: collision with root package name */
    public static final JsonNodeType f4273d;

    /* renamed from: e, reason: collision with root package name */
    public static final JsonNodeType f4274e;
    public static final JsonNodeType h;

    /* renamed from: j, reason: collision with root package name */
    public static final JsonNodeType f4275j;

    /* renamed from: k, reason: collision with root package name */
    public static final JsonNodeType f4276k;

    /* renamed from: l, reason: collision with root package name */
    public static final JsonNodeType f4277l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ JsonNodeType[] f4278m;

    static {
        JsonNodeType jsonNodeType = new JsonNodeType("ARRAY", 0);
        f4270a = jsonNodeType;
        JsonNodeType jsonNodeType2 = new JsonNodeType("BINARY", 1);
        f4271b = jsonNodeType2;
        JsonNodeType jsonNodeType3 = new JsonNodeType("BOOLEAN", 2);
        f4272c = jsonNodeType3;
        JsonNodeType jsonNodeType4 = new JsonNodeType("MISSING", 3);
        f4273d = jsonNodeType4;
        JsonNodeType jsonNodeType5 = new JsonNodeType("NULL", 4);
        f4274e = jsonNodeType5;
        JsonNodeType jsonNodeType6 = new JsonNodeType("NUMBER", 5);
        h = jsonNodeType6;
        JsonNodeType jsonNodeType7 = new JsonNodeType("OBJECT", 6);
        f4275j = jsonNodeType7;
        JsonNodeType jsonNodeType8 = new JsonNodeType("POJO", 7);
        f4276k = jsonNodeType8;
        JsonNodeType jsonNodeType9 = new JsonNodeType("STRING", 8);
        f4277l = jsonNodeType9;
        f4278m = new JsonNodeType[]{jsonNodeType, jsonNodeType2, jsonNodeType3, jsonNodeType4, jsonNodeType5, jsonNodeType6, jsonNodeType7, jsonNodeType8, jsonNodeType9};
    }

    public JsonNodeType() {
        throw null;
    }

    public static JsonNodeType valueOf(String str) {
        return (JsonNodeType) Enum.valueOf(JsonNodeType.class, str);
    }

    public static JsonNodeType[] values() {
        return (JsonNodeType[]) f4278m.clone();
    }
}
