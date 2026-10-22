package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillStoreMetadataRefreshCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum gv extends Enum<gv> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gv f20052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gv f20053b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gv f20054c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gv f20055d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gv f20056e = null;
    private static final /* synthetic */ gv[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ gv[] a() {
        return new gv[]{f20052a, f20053b, f20054c, f20055d, f20056e};
    }

    private gv(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20052a = new gv("UPDATED", 0);
        f20053b = new gv("UNCHANGED", 1);
        f20054c = new gv("SKIPPED", 2);
        f20055d = new gv("NOT_FOUND", 3);
        f20056e = new gv("FAILED", 4);
        gv[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static gv valueOf(String r2) {
        return (gv) ZeusTransformUtils.preCheckCast(Enum.valueOf(gv.class, r2), gv.class, "com.obric.aiagent.plugin");
    }

    public static gv[] values() {
        return (gv[]) ZeusTransformUtils.preCheckCast(f.clone(), gv[].class, "com.obric.aiagent.plugin");
    }
}
