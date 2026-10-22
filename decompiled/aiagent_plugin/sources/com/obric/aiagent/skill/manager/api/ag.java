package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ag extends Enum<ag> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ag f19170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ag f19171b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ ag[] f19172c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19173d = null;

    private static final /* synthetic */ ag[] a() {
        return new ag[]{f19170a, f19171b};
    }

    private ag(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19170a = new ag("HOME", 0);
        f19171b = new ag("SHARE", 1);
        ag[] r0 = a();
        f19172c = r0;
        f19173d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ag valueOf(String r2) {
        return (ag) ZeusTransformUtils.preCheckCast(Enum.valueOf(ag.class, r2), ag.class, "com.obric.aiagent.plugin");
    }

    public static ag[] values() {
        return (ag[]) ZeusTransformUtils.preCheckCast(f19172c.clone(), ag[].class, "com.obric.aiagent.plugin");
    }
}
