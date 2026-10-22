package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OutboundSecurityConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f9751b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ h[] f9752c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f9753d = null;

    private static final /* synthetic */ h[] a() {
        return new h[]{f9750a, f9751b};
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(f9752c.clone(), h[].class, "com.obric.aiagent.plugin");
    }

    private h(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9750a = new h("DOMAIN_NOT_ALLOWED", 0);
        f9751b = new h("PORT_NOT_ALLOWED", 1);
        h[] r0 = a();
        f9752c = r0;
        f9753d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
