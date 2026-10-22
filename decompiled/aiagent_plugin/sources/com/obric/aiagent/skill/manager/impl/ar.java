package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ar extends Enum<ar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ar f19510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ar f19511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ar f19512c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ar f19513d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ar f19514e = null;
    private static final /* synthetic */ ar[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ ar[] a() {
        return new ar[]{f19510a, f19511b, f19512c, f19513d, f19514e};
    }

    private ar(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19510a = new ar("SKIPPED_LOCAL", 0);
        f19511b = new ar("SKIPPED_BY_CONFIG", 1);
        f19512c = new ar("UP_TO_DATE", 2);
        f19513d = new ar("UPDATED", 3);
        f19514e = new ar("FAILED_FALLBACK", 4);
        ar[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ar valueOf(String r2) {
        return (ar) ZeusTransformUtils.preCheckCast(Enum.valueOf(ar.class, r2), ar.class, "com.obric.aiagent.plugin");
    }

    public static ar[] values() {
        return (ar[]) ZeusTransformUtils.preCheckCast(f.clone(), ar[].class, "com.obric.aiagent.plugin");
    }
}
