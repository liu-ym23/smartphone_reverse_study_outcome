package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillAdmissionPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f19257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f19258b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f19259c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f19260d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f19261e = null;
    public static final h f = null;
    public static final h g = null;
    private static final /* synthetic */ h[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final String h;

    private static final /* synthetic */ h[] b() {
        return new h[]{f19257a, f19258b, f19259c, f19260d, f19261e, f, g};
    }

    private h(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final String a() {
        return this.h;
    }

    static {
        f19257a = new h("GLOBAL_SKILL_DISABLED", 0, "global_skill_disabled");
        f19258b = new h("SKILL_DISABLED", 1, "skill_disabled");
        f19259c = new h("UNTRUSTED_NOT_REQUIRED", 2, "untrusted_not_required");
        f19260d = new h("SECURITY_NOT_STARTED", 3, "security_not_started");
        f19261e = new h("SECURITY_TASK_ID_MISSING", 4, "security_task_id_missing");
        f = new h("SECURITY_ERROR", 5, "security_error");
        g = new h("SECURITY_REJECTED", 6, "security_rejected");
        h[] r0 = b();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(i.clone(), h[].class, "com.obric.aiagent.plugin");
    }
}
