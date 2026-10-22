package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f9985b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f9986c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f9987d = null;
    private static final /* synthetic */ h[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9988e;

    private static final /* synthetic */ h[] b() {
        return new h[]{f9984a, f9985b, f9986c, f9987d};
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(f.clone(), h[].class, "com.obric.aiagent.plugin");
    }

    private h(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.f9988e = r3;
    }

    public final boolean a() {
        return this.f9988e;
    }

    static {
        f9984a = new h("LOCAL_CLOSE", 0, false);
        f9985b = new h("SERVICE_DETACH", 1, false);
        f9986c = new h("FAIL_CLOSED", 2, true);
        f9987d = new h("REMOTE_TERMINAL", 3, false);
        h[] r0 = b();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
