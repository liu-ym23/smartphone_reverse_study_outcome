package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum as extends Enum<as> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final as f19515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final as f19516b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final as f19517c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ as[] f19518e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19519d;

    private static final /* synthetic */ as[] b() {
        return new as[]{f19515a, f19516b, f19517c};
    }

    private as(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19519d = r3;
    }

    public final String a() {
        return this.f19519d;
    }

    static {
        f19515a = new as("CREATE", 0, "obric_omni_skill_create_card");
        f19516b = new as("IMPORT", 1, "obric_omni_skill_import_card");
        f19517c = new as("EDIT", 2, "obric_omni_skill_edit_card");
        as[] r0 = b();
        f19518e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static as valueOf(String r2) {
        return (as) ZeusTransformUtils.preCheckCast(Enum.valueOf(as.class, r2), as.class, "com.obric.aiagent.plugin");
    }

    public static as[] values() {
        return (as[]) ZeusTransformUtils.preCheckCast(f19518e.clone(), as[].class, "com.obric.aiagent.plugin");
    }
}
