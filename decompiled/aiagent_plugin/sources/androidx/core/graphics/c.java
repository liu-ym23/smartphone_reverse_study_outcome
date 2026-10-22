package androidx.core.graphics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BlendModeCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {
    public static final c A = null;
    public static final c B = null;
    public static final c C = null;
    private static final /* synthetic */ c[] D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f1194b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f1195c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f1196d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f1197e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    public static final c k = null;
    public static final c l = null;
    public static final c m = null;
    public static final c n = null;
    public static final c o = null;
    public static final c p = null;
    public static final c q = null;
    public static final c r = null;
    public static final c s = null;
    public static final c t = null;
    public static final c u = null;
    public static final c v = null;
    public static final c w = null;
    public static final c x = null;
    public static final c y = null;
    public static final c z = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    private static /* synthetic */ c[] a() {
        return new c[]{f1193a, f1194b, f1195c, f1196d, f1197e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C};
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(D.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        f1193a = new c("CLEAR", 0);
        f1194b = new c("SRC", 1);
        f1195c = new c("DST", 2);
        f1196d = new c("SRC_OVER", 3);
        f1197e = new c("DST_OVER", 4);
        f = new c("SRC_IN", 5);
        g = new c("DST_IN", 6);
        h = new c("SRC_OUT", 7);
        i = new c("DST_OUT", 8);
        j = new c("SRC_ATOP", 9);
        k = new c("DST_ATOP", 10);
        l = new c("XOR", 11);
        m = new c("PLUS", 12);
        n = new c("MODULATE", 13);
        o = new c("SCREEN", 14);
        p = new c("OVERLAY", 15);
        q = new c("DARKEN", 16);
        r = new c("LIGHTEN", 17);
        s = new c("COLOR_DODGE", 18);
        t = new c("COLOR_BURN", 19);
        u = new c("HARD_LIGHT", 20);
        v = new c("SOFT_LIGHT", 21);
        w = new c("DIFFERENCE", 22);
        x = new c("EXCLUSION", 23);
        y = new c("MULTIPLY", 24);
        z = new c("HUE", 25);
        A = new c("SATURATION", 26);
        B = new c("COLOR", 27);
        C = new c("LUMINOSITY", 28);
        D = a();
    }
}
