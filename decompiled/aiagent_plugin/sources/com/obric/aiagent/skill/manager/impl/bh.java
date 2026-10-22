package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDerivedProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum bh extends Enum<bh> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bh f19561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh f19562b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ bh[] f19563c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19564d = null;

    private static final /* synthetic */ bh[] a() {
        return new bh[]{f19561a, f19562b};
    }

    private bh(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19561a = new bh("LIMIT_REACHED", 0);
        f19562b = new bh("SECURITY_FAILED", 1);
        bh[] r0 = a();
        f19563c = r0;
        f19564d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bh valueOf(String r2) {
        return (bh) ZeusTransformUtils.preCheckCast(Enum.valueOf(bh.class, r2), bh.class, "com.obric.aiagent.plugin");
    }

    public static bh[] values() {
        return (bh[]) ZeusTransformUtils.preCheckCast(f19563c.clone(), bh[].class, "com.obric.aiagent.plugin");
    }
}
