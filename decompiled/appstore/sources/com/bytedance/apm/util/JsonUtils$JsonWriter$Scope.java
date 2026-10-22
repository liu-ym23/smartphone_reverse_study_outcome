package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
final enum JsonUtils$JsonWriter$Scope extends Enum<JsonUtils$JsonWriter$Scope> {
    private static final /* synthetic */ JsonUtils$JsonWriter$Scope[] $VALUES = null;
    public static final JsonUtils$JsonWriter$Scope DANGLING_KEY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NULL = null;

    static {
        JsonUtils$JsonWriter$Scope r10 = new JsonUtils$JsonWriter$Scope("EMPTY_ARRAY", 0);
        EMPTY_ARRAY = r10;
        JsonUtils$JsonWriter$Scope r11 = new JsonUtils$JsonWriter$Scope("NONEMPTY_ARRAY", 1);
        NONEMPTY_ARRAY = r11;
        JsonUtils$JsonWriter$Scope r12 = new JsonUtils$JsonWriter$Scope("EMPTY_OBJECT", 2);
        EMPTY_OBJECT = r12;
        JsonUtils$JsonWriter$Scope r13 = new JsonUtils$JsonWriter$Scope("DANGLING_KEY", 3);
        DANGLING_KEY = r13;
        JsonUtils$JsonWriter$Scope r14 = new JsonUtils$JsonWriter$Scope("NONEMPTY_OBJECT", 4);
        NONEMPTY_OBJECT = r14;
        JsonUtils$JsonWriter$Scope r15 = new JsonUtils$JsonWriter$Scope("NULL", 5);
        NULL = r15;
        $VALUES = new JsonUtils$JsonWriter$Scope[]{r10, r11, r12, r13, r14, r15};
    }

    private JsonUtils$JsonWriter$Scope(String r10, int r11) {
        super(r10, r11);
    }

    public static JsonUtils$JsonWriter$Scope valueOf(String r10) {
        return (JsonUtils$JsonWriter$Scope) Enum.valueOf(JsonUtils$JsonWriter$Scope.class, r10);
    }

    public static JsonUtils$JsonWriter$Scope[] values() {
        return (JsonUtils$JsonWriter$Scope[]) $VALUES.clone();
    }
}
