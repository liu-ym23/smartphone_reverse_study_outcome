package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final enum eu extends Enum<eu> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eu f19841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final eu f19842b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ eu[] f19843d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19844e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19845c;

    private static final /* synthetic */ eu[] b() {
        return new eu[]{f19841a, f19842b};
    }

    private eu(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19845c = r3;
    }

    public final String a() {
        return this.f19845c;
    }

    static {
        f19841a = new eu("MISSING_UID", 0, "missing_uid");
        f19842b = new eu("MISSING_AUTH", 1, "missing_auth");
        eu[] r0 = b();
        f19843d = r0;
        f19844e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static eu valueOf(String r2) {
        return (eu) ZeusTransformUtils.preCheckCast(Enum.valueOf(eu.class, r2), eu.class, "com.obric.aiagent.plugin");
    }

    public static eu[] values() {
        return (eu[]) ZeusTransformUtils.preCheckCast(f19843d.clone(), eu[].class, "com.obric.aiagent.plugin");
    }
}
