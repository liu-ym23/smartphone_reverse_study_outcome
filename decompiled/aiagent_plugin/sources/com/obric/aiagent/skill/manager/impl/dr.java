package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum dr extends Enum<dr> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dr f19760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final dr f19761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final dr f19762c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ dr[] f19763e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19764d;

    private static final /* synthetic */ dr[] b() {
        return new dr[]{f19760a, f19761b, f19762c};
    }

    private dr(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19764d = r3;
    }

    public final String a() {
        return this.f19764d;
    }

    static {
        f19760a = new dr("MANAGEMENT", 0, "obric_omni_skill_list_page");
        f19761b = new dr("MALL", 1, "obric_omni_skill_mall_page");
        f19762c = new dr("DETAIL", 2, "obric_omni_skill_detail_page");
        dr[] r0 = b();
        f19763e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static dr valueOf(String r2) {
        return (dr) ZeusTransformUtils.preCheckCast(Enum.valueOf(dr.class, r2), dr.class, "com.obric.aiagent.plugin");
    }

    public static dr[] values() {
        return (dr[]) ZeusTransformUtils.preCheckCast(f19763e.clone(), dr[].class, "com.obric.aiagent.plugin");
    }
}
