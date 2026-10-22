package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum dz extends Enum<dz> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dz f19791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final dz f19792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final dz f19793c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final dz f19794d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final dz f19795e = null;
    public static final dz f = null;
    private static final /* synthetic */ dz[] h = null;
    private static final /* synthetic */ d.d.a i = null;
    private final String g;

    private static final /* synthetic */ dz[] b() {
        return new dz[]{f19791a, f19792b, f19793c, f19794d, f19795e, f};
    }

    private dz(String r1, int r2, String r3) {
        super(r1, r2);
        this.g = r3;
    }

    public final String a() {
        return this.g;
    }

    static {
        f19791a = new dz("SUCCESS", 0, "success");
        f19792b = new dz("FAIL", 1, "fail");
        f19793c = new dz("CANCEL", 2, "cancel");
        f19794d = new dz("PARTIAL", 3, "partial");
        f19795e = new dz("BLOCKED", 4, "blocked");
        f = new dz("TIMEOUT", 5, "timeout");
        dz[] r0 = b();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static dz valueOf(String r2) {
        return (dz) ZeusTransformUtils.preCheckCast(Enum.valueOf(dz.class, r2), dz.class, "com.obric.aiagent.plugin");
    }

    public static dz[] values() {
        return (dz[]) ZeusTransformUtils.preCheckCast(h.clone(), dz[].class, "com.obric.aiagent.plugin");
    }
}
