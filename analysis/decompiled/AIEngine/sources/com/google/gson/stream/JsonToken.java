package com.google.gson.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class JsonToken {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonToken f5471a;

    /* renamed from: b, reason: collision with root package name */
    public static final JsonToken f5472b;

    /* renamed from: c, reason: collision with root package name */
    public static final JsonToken f5473c;

    /* renamed from: d, reason: collision with root package name */
    public static final JsonToken f5474d;

    /* renamed from: e, reason: collision with root package name */
    public static final JsonToken f5475e;
    public static final JsonToken h;

    /* renamed from: j, reason: collision with root package name */
    public static final JsonToken f5476j;

    /* renamed from: k, reason: collision with root package name */
    public static final JsonToken f5477k;

    /* renamed from: l, reason: collision with root package name */
    public static final JsonToken f5478l;

    /* renamed from: m, reason: collision with root package name */
    public static final JsonToken f5479m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ JsonToken[] f5480n;

    static {
        JsonToken jsonToken = new JsonToken("BEGIN_ARRAY", 0);
        f5471a = jsonToken;
        JsonToken jsonToken2 = new JsonToken("END_ARRAY", 1);
        f5472b = jsonToken2;
        JsonToken jsonToken3 = new JsonToken("BEGIN_OBJECT", 2);
        f5473c = jsonToken3;
        JsonToken jsonToken4 = new JsonToken("END_OBJECT", 3);
        f5474d = jsonToken4;
        JsonToken jsonToken5 = new JsonToken("NAME", 4);
        f5475e = jsonToken5;
        JsonToken jsonToken6 = new JsonToken("STRING", 5);
        h = jsonToken6;
        JsonToken jsonToken7 = new JsonToken("NUMBER", 6);
        f5476j = jsonToken7;
        JsonToken jsonToken8 = new JsonToken("BOOLEAN", 7);
        f5477k = jsonToken8;
        JsonToken jsonToken9 = new JsonToken("NULL", 8);
        f5478l = jsonToken9;
        JsonToken jsonToken10 = new JsonToken("END_DOCUMENT", 9);
        f5479m = jsonToken10;
        f5480n = new JsonToken[]{jsonToken, jsonToken2, jsonToken3, jsonToken4, jsonToken5, jsonToken6, jsonToken7, jsonToken8, jsonToken9, jsonToken10};
    }

    public JsonToken() {
        throw null;
    }

    public static JsonToken valueOf(String str) {
        return (JsonToken) Enum.valueOf(JsonToken.class, str);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) f5480n.clone();
    }
}
