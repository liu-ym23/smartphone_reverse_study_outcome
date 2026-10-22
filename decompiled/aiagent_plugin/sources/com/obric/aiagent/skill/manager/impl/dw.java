package com.obric.aiagent.skill.manager.impl;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum dw extends Enum<dw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dw f19776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final dw f19777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final dw f19778c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final dw f19779d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final dw f19780e = null;
    public static final dw f = null;
    public static final dw g = null;
    public static final dw h = null;
    public static final dw i = null;
    public static final dw j = null;
    public static final dw k = null;
    public static final dw l = null;
    public static final dw m = null;
    public static final dw n = null;
    public static final dw o = null;
    private static final /* synthetic */ dw[] q = null;
    private static final /* synthetic */ d.d.a r = null;
    private final String p;

    private static final /* synthetic */ dw[] b() {
        return new dw[]{f19776a, f19777b, f19778c, f19779d, f19780e, f, g, h, i, j, k, l, m, n, o};
    }

    private dw(String r1, int r2, String r3) {
        super(r1, r2);
        this.p = r3;
    }

    public final String a() {
        return this.p;
    }

    static {
        f19776a = new dw("INVALID_INPUT", 0, "invalid_input");
        f19777b = new dw("NOT_FOUND", 1, "not_found");
        f19778c = new dw("CONFLICT", 2, "conflict");
        f19779d = new dw("POLICY_REJECTED", 3, "policy_rejected");
        f19780e = new dw("PACKAGE_INVALID", 4, "package_invalid");
        f = new dw("NETWORK_TIMEOUT", 5, "network_timeout");
        g = new dw("NETWORK_FAILED", 6, "network_failed");
        h = new dw("SERVICE_UNAVAILABLE", 7, "service_unavailable");
        i = new dw("STORAGE_FAILED", 8, "storage_failed");
        j = new dw("OVIRT_FAILED", 9, "ovirt_failed");
        k = new dw("INTERNAL_FAILED", 10, "internal_failed");
        l = new dw("SECURITY_BLOCKED", 11, "security_blocked");
        m = new dw("PROCESSING_POLL_LIMIT", 12, "processing_poll_limit");
        n = new dw("CANCELLED", 13, "cancelled");
        o = new dw("UNKNOWN", 14, SensitiveType.UNKNOWN);
        dw[] r0 = b();
        q = r0;
        r = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static dw valueOf(String r2) {
        return (dw) ZeusTransformUtils.preCheckCast(Enum.valueOf(dw.class, r2), dw.class, "com.obric.aiagent.plugin");
    }

    public static dw[] values() {
        return (dw[]) ZeusTransformUtils.preCheckCast(q.clone(), dw[].class, "com.obric.aiagent.plugin");
    }
}
