package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ew extends Enum<ew> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ew f19847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ew f19848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ew f19849c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ ew[] f19850e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19851d;

    public static d.d.a<ew> b() {
        return f;
    }

    private static final /* synthetic */ ew[] c() {
        return new ew[]{f19847a, f19848b, f19849c};
    }

    private ew(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19851d = r3;
    }

    public final String a() {
        return this.f19851d;
    }

    static {
        f19847a = new ew("CREATE", 0, "create");
        f19848b = new ew("UPDATE", 1, "update");
        f19849c = new ew("DELETE", 2, "delete");
        ew[] r0 = c();
        f19850e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ew valueOf(String r2) {
        return (ew) ZeusTransformUtils.preCheckCast(Enum.valueOf(ew.class, r2), ew.class, "com.obric.aiagent.plugin");
    }

    public static ew[] values() {
        return (ew[]) ZeusTransformUtils.preCheckCast(f19850e.clone(), ew[].class, "com.obric.aiagent.plugin");
    }
}
