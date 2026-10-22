package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f9964b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f9965c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f9966d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f9967e = null;
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
    private static final /* synthetic */ c[] p = null;
    private static final /* synthetic */ d.d.a q = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f9963a, f9964b, f9965c, f9966d, f9967e, f, g, h, i, j, k, l, m, n, o};
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(p.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9963a = new c("CALLER_CLOSED", 0);
        f9964b = new c("CONNECTOR_CLOSED", 1);
        f9965c = new c("DETACH_FAILED", 2);
        f9966d = new c("BINDING_FAILED", 3);
        f9967e = new c("BINDING_TIMEOUT", 4);
        f = new c("SERVICE_LOST_DURING_CLOSE", 5);
        g = new c("SERVICE_LOST_AFTER_COMMIT", 6);
        h = new c("RECOVERY_FAILED", 7);
        i = new c("DISPATCH_CANCELLED", 8);
        j = new c("STALE_ATTACH_COMMITTED", 9);
        k = new c("ATTACH_FAILED_DURING_CLOSE", 10);
        l = new c("ATTACH_COMMIT_UNKNOWN", 11);
        m = new c("ATTACH_FAILED", 12);
        n = new c("REMOTE_TERMINAL", 13);
        o = new c("INVALID_CALLBACK", 14);
        c[] r0 = a();
        p = r0;
        q = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
