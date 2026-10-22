package com.bytedance.common.wschannel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TransportMode.java */
/* JADX INFO: loaded from: classes.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6958a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f6959b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f6960c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f6961d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f6962e = null;
    private static final /* synthetic */ h[] g = null;
    final int f;

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(g.clone(), h[].class, "com.obric.aiagent.plugin");
    }

    static {
        h r0 = new h("TUDP", 0, 0);
        f6958a = r0;
        h r1 = new h("TLS", 1, 1);
        f6959b = r1;
        h r3 = new h("HTTP2", 2, 2);
        f6960c = r3;
        h r5 = new h("TUDP_PROXY", 3, 3);
        f6961d = r5;
        h r7 = new h("TLS_PROXY", 4, 4);
        f6962e = r7;
        g = new h[]{r0, r1, r3, r5, r7};
    }

    private h(String r1, int r2, int r3) {
        super(r1, r2);
        this.f = r3;
    }

    public int a() {
        return this.f;
    }
}
