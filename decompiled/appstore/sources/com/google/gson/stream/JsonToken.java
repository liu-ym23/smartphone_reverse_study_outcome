package com.google.gson.stream;

/* JADX INFO: loaded from: classes3.dex */
public final enum JsonToken extends Enum<JsonToken> {
    private static final /* synthetic */ JsonToken[] $VALUES = null;
    public static final JsonToken BEGIN_ARRAY = null;
    public static final JsonToken BEGIN_OBJECT = null;
    public static final JsonToken BOOLEAN = null;
    public static final JsonToken END_ARRAY = null;
    public static final JsonToken END_DOCUMENT = null;
    public static final JsonToken END_OBJECT = null;
    public static final JsonToken NAME = null;
    public static final JsonToken NULL = null;
    public static final JsonToken NUMBER = null;
    public static final JsonToken STRING = null;

    static {
        JsonToken r10 = new JsonToken("BEGIN_ARRAY", 0);
        BEGIN_ARRAY = r10;
        JsonToken r11 = new JsonToken("END_ARRAY", 1);
        END_ARRAY = r11;
        JsonToken r12 = new JsonToken("BEGIN_OBJECT", 2);
        BEGIN_OBJECT = r12;
        JsonToken r13 = new JsonToken("END_OBJECT", 3);
        END_OBJECT = r13;
        JsonToken r14 = new JsonToken("NAME", 4);
        NAME = r14;
        JsonToken r15 = new JsonToken("STRING", 5);
        STRING = r15;
        JsonToken r16 = new JsonToken("NUMBER", 6);
        NUMBER = r16;
        JsonToken r17 = new JsonToken("BOOLEAN", 7);
        BOOLEAN = r17;
        JsonToken r18 = new JsonToken("NULL", 8);
        NULL = r18;
        JsonToken r19 = new JsonToken("END_DOCUMENT", 9);
        END_DOCUMENT = r19;
        $VALUES = new JsonToken[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    private JsonToken(String r10, int r11) {
        super(r10, r11);
    }

    public static JsonToken valueOf(String r10) {
        return (JsonToken) Enum.valueOf(JsonToken.class, r10);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) $VALUES.clone();
    }
}
