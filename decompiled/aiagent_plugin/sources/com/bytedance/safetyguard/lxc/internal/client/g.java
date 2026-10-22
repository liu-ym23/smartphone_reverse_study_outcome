package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f9980b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f9981c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f9982d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f9983e = null;
    private static final /* synthetic */ g[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ g[] a() {
        return new g[]{f9979a, f9980b, f9981c, f9982d, f9983e};
    }

    public static g valueOf(String r2) {
        return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
    }

    public static g[] values() {
        return (g[]) ZeusTransformUtils.preCheckCast(f.clone(), g[].class, "com.obric.aiagent.plugin");
    }

    private g(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9979a = new g("UNBOUND", 0);
        f9980b = new g("BINDING", 1);
        f9981c = new g("CONNECTED", 2);
        f9982d = new g("RETRYING", 3);
        f9983e = new g("CLOSED", 4);
        g[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
