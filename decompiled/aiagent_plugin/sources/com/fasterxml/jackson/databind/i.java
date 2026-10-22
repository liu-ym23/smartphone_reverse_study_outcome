package com.fasterxml.jackson.databind;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeserializationFeature.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum i extends Enum<i> implements com.fasterxml.jackson.databind.a.f {
    public static final i A = null;
    public static final i B = null;
    private static final /* synthetic */ i[] E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f12755b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f12756c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f12757d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f12758e = null;
    public static final i f = null;
    public static final i g = null;
    public static final i h = null;
    public static final i i = null;
    public static final i j = null;
    public static final i k = null;
    public static final i l = null;
    public static final i m = null;
    public static final i n = null;
    public static final i o = null;
    public static final i p = null;
    public static final i q = null;
    public static final i r = null;
    public static final i s = null;
    public static final i t = null;
    public static final i u = null;
    public static final i v = null;
    public static final i w = null;
    public static final i x = null;
    public static final i y = null;
    public static final i z = null;
    private final boolean C;
    private final int D;

    public static i valueOf(String r2) {
        return (i) ZeusTransformUtils.preCheckCast(Enum.valueOf(i.class, r2), i.class, "com.obric.aiagent.plugin");
    }

    public static i[] values() {
        return (i[]) ZeusTransformUtils.preCheckCast(E.clone(), i[].class, "com.obric.aiagent.plugin");
    }

    static {
        i r0 = new i("USE_BIG_DECIMAL_FOR_FLOATS", 0, false);
        f12754a = r0;
        i r1 = new i("USE_BIG_INTEGER_FOR_INTS", 1, false);
        f12755b = r1;
        i r3 = new i("USE_LONG_FOR_INTS", 2, false);
        f12756c = r3;
        i r5 = new i("USE_JAVA_ARRAY_FOR_JSON_ARRAY", 3, false);
        f12757d = r5;
        i r7 = new i("FAIL_ON_UNKNOWN_PROPERTIES", 4, true);
        f12758e = r7;
        i r9 = new i("FAIL_ON_NULL_FOR_PRIMITIVES", 5, false);
        f = r9;
        i r11 = new i("FAIL_ON_NUMBERS_FOR_ENUMS", 6, false);
        g = r11;
        i r13 = new i("FAIL_ON_INVALID_SUBTYPE", 7, true);
        h = r13;
        i r15 = new i("FAIL_ON_READING_DUP_TREE_KEY", 8, false);
        i = r15;
        i r14 = new i("FAIL_ON_IGNORED_PROPERTIES", 9, false);
        j = r14;
        i r12 = new i("FAIL_ON_UNRESOLVED_OBJECT_IDS", 10, true);
        k = r12;
        i r10 = new i("FAIL_ON_MISSING_CREATOR_PROPERTIES", 11, false);
        l = r10;
        i r8 = new i("FAIL_ON_NULL_CREATOR_PROPERTIES", 12, false);
        m = r8;
        i r6 = new i("FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY", 13, true);
        n = r6;
        i r4 = new i("FAIL_ON_TRAILING_TOKENS", 14, false);
        o = r4;
        i r2 = new i("WRAP_EXCEPTIONS", 15, true);
        p = r2;
        i r16 = new i("ACCEPT_SINGLE_VALUE_AS_ARRAY", 16, false);
        q = r16;
        i r17 = new i("UNWRAP_SINGLE_VALUE_ARRAYS", 17, false);
        r = r17;
        i r18 = new i("UNWRAP_ROOT_VALUE", 18, false);
        s = r18;
        i r19 = new i("ACCEPT_EMPTY_STRING_AS_NULL_OBJECT", 19, false);
        t = r19;
        i r20 = new i("ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT", 20, false);
        u = r20;
        i r21 = new i("ACCEPT_FLOAT_AS_INT", 21, true);
        v = r21;
        i r22 = new i("READ_ENUMS_USING_TO_STRING", 22, false);
        w = r22;
        i r23 = new i("READ_UNKNOWN_ENUM_VALUES_AS_NULL", 23, false);
        x = r23;
        i r24 = new i("READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE", 24, false);
        y = r24;
        i r25 = new i("READ_DATE_TIMESTAMPS_AS_NANOSECONDS", 25, true);
        z = r25;
        i r26 = new i("ADJUST_DATES_TO_CONTEXT_TIME_ZONE", 26, true);
        A = r26;
        i r27 = new i("EAGER_DESERIALIZER_FETCH", 27, true);
        B = r27;
        E = new i[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
    }

    private i(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.C = r3;
        this.D = 1 << ordinal();
    }

    @Override // com.fasterxml.jackson.databind.a.f
    public boolean a() {
        return this.C;
    }

    @Override // com.fasterxml.jackson.databind.a.f
    public int b() {
        return this.D;
    }

    public boolean a(int r1) {
        if ((this.D & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
