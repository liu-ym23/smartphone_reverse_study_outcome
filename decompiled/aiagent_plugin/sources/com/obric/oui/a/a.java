package com.obric.oui.a;

import com.obric.oui.material.j;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BlendMode.java */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {
    public static final a A = null;
    public static final a B = null;
    public static final a C = null;
    public static final a D = null;
    public static final a E = null;
    public static final a[] F = null;
    private static final /* synthetic */ a[] H = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f33927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f33928c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f33929d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f33930e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    public static final a j = null;
    public static final a k = null;
    public static final a l = null;
    public static final a m = null;
    public static final a n = null;
    public static final a o = null;
    public static final a p = null;
    public static final a q = null;
    public static final a r = null;
    public static final a s = null;
    public static final a t = null;
    public static final a u = null;
    public static final a v = null;
    public static final a w = null;
    public static final a x = null;
    public static final a y = null;
    public static final a z = null;
    public final int G;

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(H.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("CLEAR", 0, 0);
        f33926a = r0;
        a r1 = new a("SRC", 1, 1);
        f33927b = r1;
        a r3 = new a("DST", 2, 2);
        f33928c = r3;
        a r5 = new a("SRC_OVER", 3, 3);
        f33929d = r5;
        a r7 = new a("DST_OVER", 4, 4);
        f33930e = r7;
        a r9 = new a("SRC_IN", 5, 5);
        f = r9;
        a r11 = new a("DST_IN", 6, 6);
        g = r11;
        a r13 = new a("SRC_OUT", 7, 7);
        h = r13;
        a r15 = new a("DST_OUT", 8, 8);
        i = r15;
        a r14 = new a("SRC_ATOP", 9, 9);
        j = r14;
        a r12 = new a("DST_ATOP", 10, 10);
        k = r12;
        a r10 = new a("XOR", 11, 11);
        l = r10;
        a r8 = new a("PLUS", 12, 12);
        m = r8;
        a r6 = new a("MODULATE", 13, 13);
        n = r6;
        a r4 = new a("SCREEN", 14, 14);
        o = r4;
        a r2 = new a("OVERLAY", 15, 15);
        p = r2;
        a r16 = new a("DARKEN", 16, 16);
        q = r16;
        a r17 = new a("LIGHTEN", 17, 17);
        r = r17;
        a r18 = new a("COLOR_DODGE", 18, 18);
        s = r18;
        a r19 = new a("COLOR_BURN", 19, 19);
        t = r19;
        a r20 = new a("HARD_LIGHT", 20, 20);
        u = r20;
        a r21 = new a("SOFT_LIGHT", 21, 21);
        v = r21;
        a r22 = new a("DIFFERENCE", 22, 22);
        w = r22;
        a r23 = new a("EXCLUSION", 23, 23);
        x = r23;
        a r24 = new a("MULTIPLY", 24, 24);
        y = r24;
        a r25 = new a("HUE", 25, 25);
        z = r25;
        a r26 = new a("SATURATION", 26, 26);
        A = r26;
        a r27 = new a("COLOR", 27, 27);
        B = r27;
        a r28 = new a("LUMINOSITY", 28, 28);
        C = r28;
        a r29 = new a("PLUS_DARKER", 29, 101);
        D = r29;
        a r30 = new a("PLUS_LIGHTER", 30, 102);
        E = r30;
        H = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30};
        F = values();
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.G = r3;
    }

    public int a() {
        return this.G;
    }

    public static int a(int r1) {
        return a(r1, false);
    }

    public static int a(int r1, boolean r2) {
        if (j.f35493b == true) goto L7;
        if (r2 == true) goto L7;
        return r1;
    L7:
        if (r1 != f33929d.ordinal()) goto L11;
        return l.a.f35498a.ordinal();
    L11:
        if (r1 != t.ordinal()) goto L15;
        return l.a.f35499b.ordinal();
    L15:
        if (r1 != s.ordinal()) goto L19;
        return l.a.f35500c.ordinal();
    L19:
        if (r1 != D.ordinal()) goto L23;
        return l.a.f35501d.ordinal();
    L23:
        if (r1 != E.ordinal()) goto L27;
        return l.a.f35502e.ordinal();
    L27:
        if (r1 != C.ordinal()) goto L31;
        return l.a.f.ordinal();
    L31:
        if (r1 != p.ordinal()) goto L35;
        return l.a.g.ordinal();
    L35:
        if (r1 != v.ordinal()) goto L39;
        return l.a.h.ordinal();
    L39:
        return l.a.f35498a.ordinal();
    }

    public static int a(a r1) {
        return a(r1, false);
    }

    public static int a(a r1, boolean r2) {
        if (j.f35493b == true) goto L11;
        if (r2 == true) goto L11;
        if (r1 != null) goto L9;
        r1 = f33929d;
    L9:
        return r1.G;
    L11:
        if (r1 != f33929d) goto L15;
        return l.a.f35498a.ordinal();
    L15:
        if (r1 != t) goto L19;
        return l.a.f35499b.ordinal();
    L19:
        if (r1 != s) goto L23;
        return l.a.f35500c.ordinal();
    L23:
        if (r1 != D) goto L27;
        return l.a.f35501d.ordinal();
    L27:
        if (r1 != E) goto L31;
        return l.a.f35502e.ordinal();
    L31:
        if (r1 != C) goto L35;
        return l.a.f.ordinal();
    L35:
        if (r1 != p) goto L39;
        return l.a.g.ordinal();
    L39:
        if (r1 != v) goto L43;
        return l.a.h.ordinal();
    L43:
        return l.a.f35498a.ordinal();
    }
}
