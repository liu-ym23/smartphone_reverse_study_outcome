package com.fasterxml.jackson.databind;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SerializationFeature.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum ab extends Enum<ab> implements com.fasterxml.jackson.databind.a.f {
    private static final /* synthetic */ ab[] C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f12245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ab f12246b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ab f12247c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ab f12248d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ab f12249e = null;
    public static final ab f = null;
    public static final ab g = null;
    public static final ab h = null;
    public static final ab i = null;
    public static final ab j = null;
    public static final ab k = null;
    public static final ab l = null;
    public static final ab m = null;
    public static final ab n = null;
    public static final ab o = null;
    public static final ab p = null;
    public static final ab q = null;
    public static final ab r = null;

    @Deprecated
    public static final ab s = null;

    @Deprecated
    public static final ab t = null;
    public static final ab u = null;

    @Deprecated
    public static final ab v = null;
    public static final ab w = null;
    public static final ab x = null;
    public static final ab y = null;
    public static final ab z = null;
    private final boolean A;
    private final int B;

    public static ab valueOf(String r2) {
        return (ab) ZeusTransformUtils.preCheckCast(Enum.valueOf(ab.class, r2), ab.class, "com.obric.aiagent.plugin");
    }

    public static ab[] values() {
        return (ab[]) ZeusTransformUtils.preCheckCast(C.clone(), ab[].class, "com.obric.aiagent.plugin");
    }

    static {
        ab r0 = new ab("WRAP_ROOT_VALUE", 0, false);
        f12245a = r0;
        ab r1 = new ab("INDENT_OUTPUT", 1, false);
        f12246b = r1;
        ab r3 = new ab("FAIL_ON_EMPTY_BEANS", 2, true);
        f12247c = r3;
        ab r5 = new ab("FAIL_ON_SELF_REFERENCES", 3, true);
        f12248d = r5;
        ab r7 = new ab("WRAP_EXCEPTIONS", 4, true);
        f12249e = r7;
        ab r9 = new ab("FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS", 5, true);
        f = r9;
        ab r11 = new ab("WRITE_SELF_REFERENCES_AS_NULL", 6, false);
        g = r11;
        ab r13 = new ab("CLOSE_CLOSEABLE", 7, false);
        h = r13;
        ab r15 = new ab("FLUSH_AFTER_WRITE_VALUE", 8, true);
        i = r15;
        ab r14 = new ab("WRITE_DATES_AS_TIMESTAMPS", 9, true);
        j = r14;
        ab r12 = new ab("WRITE_DATE_KEYS_AS_TIMESTAMPS", 10, false);
        k = r12;
        ab r10 = new ab("WRITE_DATES_WITH_ZONE_ID", 11, false);
        l = r10;
        ab r8 = new ab("WRITE_DATES_WITH_CONTEXT_TIME_ZONE", 12, true);
        m = r8;
        ab r6 = new ab("WRITE_DURATIONS_AS_TIMESTAMPS", 13, true);
        n = r6;
        ab r2 = new ab("WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS", 14, false);
        o = r2;
        ab r16 = new ab("WRITE_ENUMS_USING_TO_STRING", 15, false);
        p = r16;
        ab r4 = new ab("WRITE_ENUMS_USING_INDEX", 16, false);
        q = r4;
        ab r17 = new ab("WRITE_ENUM_KEYS_USING_INDEX", 17, false);
        r = r17;
        ab r18 = new ab("WRITE_NULL_MAP_VALUES", 18, true);
        s = r18;
        ab r19 = new ab("WRITE_EMPTY_JSON_ARRAYS", 19, true);
        t = r19;
        ab r20 = new ab("WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED", 20, false);
        u = r20;
        ab r21 = new ab("WRITE_BIGDECIMAL_AS_PLAIN", 21, false);
        v = r21;
        ab r22 = new ab("WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS", 22, true);
        w = r22;
        ab r23 = new ab("ORDER_MAP_ENTRIES_BY_KEYS", 23, false);
        x = r23;
        ab r24 = new ab("EAGER_SERIALIZER_FETCH", 24, true);
        y = r24;
        ab r25 = new ab("USE_EQUALITY_FOR_OBJECT_ID", 25, false);
        z = r25;
        C = new ab[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r2, r16, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25};
    }

    private ab(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.A = r3;
        this.B = 1 << ordinal();
    }

    @Override // com.fasterxml.jackson.databind.a.f
    public boolean a() {
        return this.A;
    }

    @Override // com.fasterxml.jackson.databind.a.f
    public int b() {
        return this.B;
    }

    public boolean a(int r1) {
        if ((this.B & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
