package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes14.dex */
final enum JsonUtils$JsonWriter$Scope extends Enum<JsonUtils$JsonWriter$Scope> {
    public static final JsonUtils$JsonWriter$Scope DANGLING_KEY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsonUtils$JsonWriter$Scope[] f190627a = null;

    static {
        JsonUtils$JsonWriter$Scope r100 = new JsonUtils$JsonWriter$Scope("EMPTY_ARRAY", 0);
        EMPTY_ARRAY = r100;
        JsonUtils$JsonWriter$Scope r101 = new JsonUtils$JsonWriter$Scope("NONEMPTY_ARRAY", 1);
        NONEMPTY_ARRAY = r101;
        JsonUtils$JsonWriter$Scope r102 = new JsonUtils$JsonWriter$Scope("EMPTY_OBJECT", 2);
        EMPTY_OBJECT = r102;
        JsonUtils$JsonWriter$Scope r103 = new JsonUtils$JsonWriter$Scope("DANGLING_KEY", 3);
        DANGLING_KEY = r103;
        JsonUtils$JsonWriter$Scope r104 = new JsonUtils$JsonWriter$Scope("NONEMPTY_OBJECT", 4);
        NONEMPTY_OBJECT = r104;
        JsonUtils$JsonWriter$Scope r105 = new JsonUtils$JsonWriter$Scope("NULL", 5);
        NULL = r105;
        f190627a = new JsonUtils$JsonWriter$Scope[]{r100, r101, r102, r103, r104, r105};
    }

    public static JsonUtils$JsonWriter$Scope[] values() {
        return (JsonUtils$JsonWriter$Scope[]) f190627a.clone();
    }

    public static JsonUtils$JsonWriter$Scope valueOf(String r100) {
        return (JsonUtils$JsonWriter$Scope) r27.a.a(JsonUtils$JsonWriter$Scope.class, r100);
    }

    public JsonUtils$JsonWriter$Scope(String r100, int r101) {
        super(r100, r101);
    }
}
