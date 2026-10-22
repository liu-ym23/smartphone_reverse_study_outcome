package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {
    public static final a A = null;
    public static final a B = null;
    public static final a C = null;
    private static final /* synthetic */ a[] D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f36359b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f36360c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f36361d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f36362e = null;
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

    private static final /* synthetic */ a[] a() {
        return new a[]{f36358a, f36359b, f36360c, f36361d, f36362e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(D.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f36358a = new a("CLEAR", 0);
        f36359b = new a("SRC", 1);
        f36360c = new a("DST", 2);
        f36361d = new a("SRC_OVER", 3);
        f36362e = new a("DST_OVER", 4);
        f = new a("SRC_IN", 5);
        g = new a("DST_IN", 6);
        h = new a("SRC_OUT", 7);
        i = new a("DST_OUT", 8);
        j = new a("SRC_ATOP", 9);
        k = new a("DST_ATOP", 10);
        l = new a("XOR", 11);
        m = new a("PLUS", 12);
        n = new a("MODULATE", 13);
        o = new a("SCREEN", 14);
        p = new a("OVERLAY", 15);
        q = new a("DARKEN", 16);
        r = new a("LIGHTEN", 17);
        s = new a("COLOR_DODGE", 18);
        t = new a("COLOR_BURN", 19);
        u = new a("HARD_LIGHT", 20);
        v = new a("SOFT_LIGHT", 21);
        w = new a("DIFFERENCE", 22);
        x = new a("EXCLUSION", 23);
        y = new a("MULTIPLY", 24);
        z = new a("HUE", 25);
        A = new a("SATURATION", 26);
        B = new a("COLOR", 27);
        C = new a("LUMINOSITY", 28);
        D = a();
    }
}
