package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum cp extends Enum<cp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cp f19689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cp f19690b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ cp[] f19691d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19692e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19693c;

    private static final /* synthetic */ cp[] b() {
        return new cp[]{f19689a, f19690b};
    }

    private cp(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19693c = r3;
    }

    public final String a() {
        return this.f19693c;
    }

    static {
        f19689a = new cp("FIRST_INSTALL", 0, "first_install");
        f19690b = new cp("UPDATE", 1, "update");
        cp[] r0 = b();
        f19691d = r0;
        f19692e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static cp valueOf(String r2) {
        return (cp) ZeusTransformUtils.preCheckCast(Enum.valueOf(cp.class, r2), cp.class, "com.obric.aiagent.plugin");
    }

    public static cp[] values() {
        return (cp[]) ZeusTransformUtils.preCheckCast(f19691d.clone(), cp[].class, "com.obric.aiagent.plugin");
    }
}
