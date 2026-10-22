package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillIdentityConflictException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ce extends Enum<ce> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ce f19647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ce f19648b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ce f19649c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ce[] f19650d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19651e = null;

    private static final /* synthetic */ ce[] a() {
        return new ce[]{f19647a, f19648b, f19649c};
    }

    private ce(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19647a = new ce("SLUG", 0);
        f19648b = new ce("PACKAGE_NAME", 1);
        f19649c = new ce("DISPLAY_NAME", 2);
        ce[] r0 = a();
        f19650d = r0;
        f19651e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ce valueOf(String r2) {
        return (ce) ZeusTransformUtils.preCheckCast(Enum.valueOf(ce.class, r2), ce.class, "com.obric.aiagent.plugin");
    }

    public static ce[] values() {
        return (ce[]) ZeusTransformUtils.preCheckCast(f19650d.clone(), ce[].class, "com.obric.aiagent.plugin");
    }
}
