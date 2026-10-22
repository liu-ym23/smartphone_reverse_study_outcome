package com.bytedance.safetyguard.lxc.internal.e.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f10706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f10707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f10708c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ n[] f10709d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f10710e = null;

    private static final /* synthetic */ n[] a() {
        return new n[]{f10706a, f10707b, f10708c};
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f10709d.clone(), n[].class, "com.obric.aiagent.plugin");
    }

    private n(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10706a = new n("INFO", 0);
        f10707b = new n("WARN", 1);
        f10708c = new n("ERROR", 2);
        n[] r0 = a();
        f10709d = r0;
        f10710e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
