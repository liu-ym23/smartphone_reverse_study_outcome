package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSecurity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum gi extends Enum<gi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gi f19988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gi f19989b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gi f19990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ gi[] f19991d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19992e = null;

    private static final /* synthetic */ gi[] a() {
        return new gi[]{f19988a, f19989b, f19990c};
    }

    private gi(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19988a = new gi("PROCESSING", 0);
        f19989b = new gi("COMPLETED", 1);
        f19990c = new gi("FAILED", 2);
        gi[] r0 = a();
        f19991d = r0;
        f19992e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static gi valueOf(String r2) {
        return (gi) ZeusTransformUtils.preCheckCast(Enum.valueOf(gi.class, r2), gi.class, "com.obric.aiagent.plugin");
    }

    public static gi[] values() {
        return (gi[]) ZeusTransformUtils.preCheckCast(f19991d.clone(), gi[].class, "com.obric.aiagent.plugin");
    }
}
