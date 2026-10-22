package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillEditGuards.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum di extends Enum<di> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final di f19743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final di f19744b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final di f19745c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final di f19746d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final di f19747e = null;
    private static final /* synthetic */ di[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ di[] a() {
        return new di[]{f19743a, f19744b, f19745c, f19746d, f19747e};
    }

    private di(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19743a = new di("SCAN_NOT_STARTED", 0);
        f19744b = new di("SCAN_IN_PROGRESS", 1);
        f19745c = new di("SCAN_FAILED", 2);
        f19746d = new di("RESULT_UNAVAILABLE", 3);
        f19747e = new di("STATUS_REFRESH_FAILED", 4);
        di[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static di valueOf(String r2) {
        return (di) ZeusTransformUtils.preCheckCast(Enum.valueOf(di.class, r2), di.class, "com.obric.aiagent.plugin");
    }

    public static di[] values() {
        return (di[]) ZeusTransformUtils.preCheckCast(f.clone(), di[].class, "com.obric.aiagent.plugin");
    }
}
