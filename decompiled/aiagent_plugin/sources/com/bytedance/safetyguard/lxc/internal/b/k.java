package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f9763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f9764b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f9765c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f9766d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ k[] f9767e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ k[] a() {
        return new k[]{f9763a, f9764b, f9765c, f9766d};
    }

    public static k valueOf(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.aiagent.plugin");
    }

    public static k[] values() {
        return (k[]) ZeusTransformUtils.preCheckCast(f9767e.clone(), k[].class, "com.obric.aiagent.plugin");
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9763a = new k("MALFORMED_TARGET", 0);
        f9764b = new k("SSRF_BASELINE", 1);
        f9765c = new k("DNS", 2);
        f9766d = new k("BUSINESS_POLICY", 3);
        k[] r0 = a();
        f9767e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
