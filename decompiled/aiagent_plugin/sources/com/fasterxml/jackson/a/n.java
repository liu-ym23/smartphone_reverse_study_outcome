package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonToken.java */
/* JADX INFO: loaded from: classes.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f12151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f12152b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f12153c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f12154d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f12155e = null;
    public static final n f = null;
    public static final n g = null;
    public static final n h = null;
    public static final n i = null;
    public static final n j = null;
    public static final n k = null;
    public static final n l = null;
    public static final n m = null;
    private static final /* synthetic */ n[] w = null;
    final String n;
    final char[] o;
    final byte[] p;
    final int q;
    final boolean r;
    final boolean s;
    final boolean t;
    final boolean u;
    final boolean v;

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(w.clone(), n[].class, "com.obric.aiagent.plugin");
    }

    static {
        n r0 = new n("NOT_AVAILABLE", 0, null, -1);
        f12151a = r0;
        n r1 = new n("START_OBJECT", 1, "{", 1);
        f12152b = r1;
        n r4 = new n("END_OBJECT", 2, "}", 2);
        f12153c = r4;
        n r6 = new n("START_ARRAY", 3, "[", 3);
        f12154d = r6;
        n r8 = new n("END_ARRAY", 4, "]", 4);
        f12155e = r8;
        n r10 = new n("FIELD_NAME", 5, null, 5);
        f = r10;
        n r12 = new n("VALUE_EMBEDDED_OBJECT", 6, null, 12);
        g = r12;
        n r14 = new n("VALUE_STRING", 7, null, 6);
        h = r14;
        n r11 = new n("VALUE_NUMBER_INT", 8, null, 7);
        i = r11;
        n r15 = new n("VALUE_NUMBER_FLOAT", 9, null, 8);
        j = r15;
        n r3 = new n("VALUE_TRUE", 10, "true", 9);
        k = r3;
        n r2 = new n("VALUE_FALSE", 11, "false", 10);
        l = r2;
        n r9 = new n("VALUE_NULL", 12, "null", 11);
        m = r9;
        w = new n[]{r0, r1, r4, r6, r8, r10, r12, r14, r11, r15, r3, r2, r9};
    }

    private n(String r3, int r4, String r5, int r6) {
        super(r3, r4);
        boolean r7 = false;
        if (r5 != null) goto L5;
        this.n = null;
        this.o = null;
        this.p = null;
    L8:
        this.q = r6;
        if (r6 != 10) goto L11;
    L14:
        boolean r8 = true;
    L15:
        this.u = r8;
        if (r6 != 7) goto L18;
    L21:
        boolean r9 = true;
    L22:
        this.t = r9;
        if (r6 != 1) goto L25;
    L28:
        boolean r10 = true;
    L29:
        this.r = r10;
        if (r6 != 2) goto L32;
    L35:
        boolean r0 = true;
    L36:
        this.s = r0;
        if (r10 == true) goto L44;
        if (r0 == true) goto L44;
        if (r6 == 5) goto L44;
        if (r6 == (-1)) goto L44;
        r7 = true;
    L44:
        this.v = r7;
        return;
    L32:
        if (r6 == 4) goto L35;
        r0 = false;
        goto L36
    L25:
        if (r6 == 3) goto L28;
        r10 = false;
        goto L29
    L18:
        if (r6 == 8) goto L21;
        r9 = false;
        goto L22
    L11:
        if (r6 == 9) goto L14;
        r8 = false;
        goto L15
    L5:
        this.n = r5;
        char[] r11 = r5.toCharArray();
        this.o = r11;
        int r12 = r11.length;
        this.p = new byte[r12];
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        this.p[r13] = (byte) this.o[r13];
        r13 = r13 + 1;
        goto L6
    }

    public final int a() {
        return this.q;
    }

    public final String b() {
        return this.n;
    }

    public final char[] c() {
        return this.o;
    }

    public final boolean d() {
        return this.t;
    }

    public final boolean e() {
        return this.r;
    }

    public final boolean f() {
        return this.s;
    }

    public final boolean g() {
        return this.v;
    }
}
