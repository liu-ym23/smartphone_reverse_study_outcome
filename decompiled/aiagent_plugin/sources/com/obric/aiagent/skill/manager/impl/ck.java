package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ck extends Enum<ck> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ck f19670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ck f19671b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ck[] f19672d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19673e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19674c;

    private static final /* synthetic */ ck[] b() {
        return new ck[]{f19670a, f19671b};
    }

    private ck(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19674c = r3;
    }

    public final String a() {
        return this.f19674c;
    }

    static {
        f19670a = new ck("SUCCESS", 0, "success");
        f19671b = new ck("FAIL", 1, "fail");
        ck[] r0 = b();
        f19672d = r0;
        f19673e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ck valueOf(String r2) {
        return (ck) ZeusTransformUtils.preCheckCast(Enum.valueOf(ck.class, r2), ck.class, "com.obric.aiagent.plugin");
    }

    public static ck[] values() {
        return (ck[]) ZeusTransformUtils.preCheckCast(f19672d.clone(), ck[].class, "com.obric.aiagent.plugin");
    }
}
