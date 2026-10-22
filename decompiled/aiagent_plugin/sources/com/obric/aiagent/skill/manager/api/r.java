package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum r extends Enum<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f19300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f19301b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f19302c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f19303d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r f19304e = null;
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
    private static final /* synthetic */ r[] r = null;
    private static final /* synthetic */ d.d.a s = null;

    private static final /* synthetic */ r[] a() {
        return new r[]{f19300a, f19301b, f19302c, f19303d, f19304e, f, g, h, i, j, k, l, m, n, o, p, q};
    }

    private r(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19300a = new r("INVALID_INPUT", 0);
        f19301b = new r("NOT_FOUND", 1);
        f19302c = new r("CONFLICT", 2);
        f19303d = new r("NOT_EDITABLE", 3);
        f19304e = new r("SCAN_IN_PROGRESS", 4);
        f = new r("SECURITY_SCAN_NOT_STARTED", 5);
        g = new r("SECURITY_SCAN_FAILED", 6);
        h = new r("SECURITY_RESULT_UNAVAILABLE", 7);
        i = new r("SECURITY_STATUS_REFRESH_FAILED", 8);
        j = new r("SECURITY_BLOCKED", 9);
        k = new r("ENABLE_LIMIT_REACHED", 10);
        l = new r("PACKAGE_INVALID", 11);
        m = new r("SERVICE_UNAVAILABLE", 12);
        n = new r("NETWORK_FAILURE", 13);
        o = new r("STORAGE_FAILURE", 14);
        p = new r("OVIRT_FAILURE", 15);
        q = new r("INTERNAL_FAILURE", 16);
        r[] r0 = a();
        r = r0;
        s = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static r valueOf(String r2) {
        return (r) ZeusTransformUtils.preCheckCast(Enum.valueOf(r.class, r2), r.class, "com.obric.aiagent.plugin");
    }

    public static r[] values() {
        return (r[]) ZeusTransformUtils.preCheckCast(r.clone(), r[].class, "com.obric.aiagent.plugin");
    }
}
