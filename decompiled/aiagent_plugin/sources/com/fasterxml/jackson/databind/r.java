package com.fasterxml.jackson.databind;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MapperFeature.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum r extends Enum<r> implements com.fasterxml.jackson.databind.a.f {
    public static final r A = null;
    public static final r B = null;
    public static final r C = null;
    public static final r D = null;
    public static final r E = null;
    public static final r F = null;
    private static final /* synthetic */ r[] I = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f13096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f13097b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f13098c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f13099d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r f13100e = null;
    public static final r f = null;
    public static final r g = null;
    public static final r h = null;
    public static final r i = null;
    public static final r j = null;
    public static final r k = null;
    public static final r l = null;
    public static final r m = null;
    public static final r n = null;
    public static final r o = null;
    public static final r p = null;
    public static final r q = null;
    public static final r r = null;
    public static final r s = null;
    public static final r t = null;
    public static final r u = null;
    public static final r v = null;
    public static final r w = null;
    public static final r x = null;
    public static final r y = null;
    public static final r z = null;
    private final boolean G;
    private final long H;

    public static r valueOf(String r2) {
        return (r) ZeusTransformUtils.preCheckCast(Enum.valueOf(r.class, r2), r.class, "com.obric.aiagent.plugin");
    }

    public static r[] values() {
        return (r[]) ZeusTransformUtils.preCheckCast(I.clone(), r[].class, "com.obric.aiagent.plugin");
    }

    static {
        r r0 = new r("USE_ANNOTATIONS", 0, true);
        f13096a = r0;
        r r1 = new r("USE_GETTERS_AS_SETTERS", 1, true);
        f13097b = r1;
        r r4 = new r("PROPAGATE_TRANSIENT_MARKER", 2, false);
        f13098c = r4;
        r r5 = new r("AUTO_DETECT_CREATORS", 3, true);
        f13099d = r5;
        r r7 = new r("AUTO_DETECT_FIELDS", 4, true);
        f13100e = r7;
        r r9 = new r("AUTO_DETECT_GETTERS", 5, true);
        f = r9;
        r r11 = new r("AUTO_DETECT_IS_GETTERS", 6, true);
        g = r11;
        r r13 = new r("AUTO_DETECT_SETTERS", 7, true);
        h = r13;
        r r15 = new r("REQUIRE_SETTERS_FOR_GETTERS", 8, false);
        i = r15;
        r r14 = new r("ALLOW_FINAL_FIELDS_AS_MUTATORS", 9, true);
        j = r14;
        r r12 = new r("INFER_PROPERTY_MUTATORS", 10, true);
        k = r12;
        r r10 = new r("INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES", 11, true);
        l = r10;
        r r8 = new r("ALLOW_VOID_VALUED_PROPERTIES", 12, false);
        m = r8;
        r r6 = new r("CAN_OVERRIDE_ACCESS_MODIFIERS", 13, true);
        n = r6;
        r r3 = new r("OVERRIDE_PUBLIC_ACCESS_MODIFIERS", 14, true);
        o = r3;
        r r2 = new r("USE_STATIC_TYPING", 15, false);
        p = r2;
        r r16 = new r("USE_BASE_TYPE_AS_DEFAULT_IMPL", 16, false);
        q = r16;
        r r17 = new r("INFER_BUILDER_TYPE_BINDINGS", 17, true);
        r = r17;
        r r18 = new r("DEFAULT_VIEW_INCLUSION", 18, true);
        s = r18;
        r r19 = new r("SORT_PROPERTIES_ALPHABETICALLY", 19, false);
        t = r19;
        r r20 = new r("SORT_CREATOR_PROPERTIES_FIRST", 20, true);
        u = r20;
        r r21 = new r("ACCEPT_CASE_INSENSITIVE_PROPERTIES", 21, false);
        v = r21;
        r r22 = new r("ACCEPT_CASE_INSENSITIVE_ENUMS", 22, false);
        w = r22;
        r r23 = new r("ACCEPT_CASE_INSENSITIVE_VALUES", 23, false);
        x = r23;
        r r24 = new r("USE_WRAPPER_NAME_AS_PROPERTY_NAME", 24, false);
        y = r24;
        r r25 = new r("USE_STD_BEAN_NAMING", 25, false);
        z = r25;
        r r26 = new r("ALLOW_EXPLICIT_PROPERTY_RENAMING", 26, false);
        A = r26;
        r r27 = new r("ALLOW_COERCION_OF_SCALARS", 27, true);
        B = r27;
        r r28 = new r("IGNORE_DUPLICATE_MODULE_REGISTRATIONS", 28, true);
        C = r28;
        r r29 = new r("IGNORE_MERGE_FOR_UNMERGEABLE", 29, true);
        D = r29;
        r r30 = new r("BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES", 30, false);
        E = r30;
        r r31 = new r("APPLY_DEFAULT_VALUES", 31, true);
        F = r31;
        I = new r[]{r0, r1, r4, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r3, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31};
    }

    public static long c() {
        r[] r0 = values();
        int r1 = r0.length;
        long r2 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L8;
        r r5 = r0[r4];
        if (r5.a() == false) goto L7;
        r2 = r2 | r5.d();
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    private r(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.G = r3;
        this.H = 1 << ordinal();
    }

    @Override // com.fasterxml.jackson.databind.a.f
    public boolean a() {
        return this.G;
    }

    @Override // com.fasterxml.jackson.databind.a.f
    @Deprecated
    public int b() {
        return (int) this.H;
    }

    public long d() {
        return this.H;
    }

    public boolean a(long r3) {
        if ((r3 & this.H) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
