package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPackageInstallFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum fq extends Enum<fq> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fq f19908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final fq f19909b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final fq f19910c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ fq[] f19911d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19912e = null;

    private static final /* synthetic */ fq[] a() {
        return new fq[]{f19908a, f19909b, f19910c};
    }

    private fq(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19908a = new fq("SERVICE_UNAVAILABLE", 0);
        f19909b = new fq("NETWORK_FAILURE", 1);
        f19910c = new fq("INVALID_RESPONSE", 2);
        fq[] r0 = a();
        f19911d = r0;
        f19912e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static fq valueOf(String r2) {
        return (fq) ZeusTransformUtils.preCheckCast(Enum.valueOf(fq.class, r2), fq.class, "com.obric.aiagent.plugin");
    }

    public static fq[] values() {
        return (fq[]) ZeusTransformUtils.preCheckCast(f19911d.clone(), fq[].class, "com.obric.aiagent.plugin");
    }
}
