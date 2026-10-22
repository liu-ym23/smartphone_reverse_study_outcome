package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFeatureAvailabilityResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum bq extends Enum<bq> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bq f19581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bq f19582b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bq f19583c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final bq f19584d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ bq[] f19585e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ bq[] a() {
        return new bq[]{f19581a, f19582b, f19583c, f19584d};
    }

    private bq(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19581a = new bq("AVAILABLE", 0);
        f19582b = new bq("FEATURE_DISABLED", 1);
        f19583c = new bq("CAPABILITY_UNAVAILABLE", 2);
        f19584d = new bq("UNKNOWN", 3);
        bq[] r0 = a();
        f19585e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bq valueOf(String r2) {
        return (bq) ZeusTransformUtils.preCheckCast(Enum.valueOf(bq.class, r2), bq.class, "com.obric.aiagent.plugin");
    }

    public static bq[] values() {
        return (bq[]) ZeusTransformUtils.preCheckCast(f19585e.clone(), bq[].class, "com.obric.aiagent.plugin");
    }
}
