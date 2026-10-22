package com.bytedance.safetyguard.lxc.internal.e.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10749c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10750d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f10751e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    public static final a j = null;
    public static final a k = null;
    public static final a l = null;
    private static final /* synthetic */ a[] m = null;
    private static final /* synthetic */ d.d.a n = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f10747a, f10748b, f10749c, f10750d, f10751e, f, g, h, i, j, k, l};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(m.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10747a = new a("MISSING_HEADER", 0);
        f10748b = new a("INVALID_VERSION", 1);
        f10749c = new a("INVALID_TARGET", 2);
        f10750d = new a("INVALID_TIMESTAMP", 3);
        f10751e = new a("BODY_HASH_MISMATCH", 4);
        f = new a("AUTH_HEADER_NOT_ALLOWED", 5);
        g = new a("SIGNATURE_INVALID", 6);
        h = new a("SESSION_INVALID", 7);
        i = new a("IDENTITY_NOT_SUPPORTED", 8);
        j = new a("TARGET_NOT_ALLOWED", 9);
        k = new a("AUTH_TARGET_NOT_ALLOWED", 10);
        l = new a("INVALID_PATH", 11);
        a[] r0 = a();
        m = r0;
        n = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
