package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f9974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ e[] f9975c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f9976d = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f9973a, f9974b};
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f9975c.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9973a = new e("INITIAL", 0);
        f9974b = new e("RECOVERY", 1);
        e[] r0 = a();
        f9975c = r0;
        f9976d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
