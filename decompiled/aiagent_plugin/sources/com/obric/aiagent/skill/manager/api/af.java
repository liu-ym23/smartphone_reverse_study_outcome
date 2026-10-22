package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum af extends Enum<af> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f19166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final af f19167b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ af[] f19168c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19169d = null;

    private static final /* synthetic */ af[] a() {
        return new af[]{f19166a, f19167b};
    }

    private af(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19166a = new af("DELETE_CONTENTS", 0);
        f19167b = new af("DELETE_DIRECTORY", 1);
        af[] r0 = a();
        f19168c = r0;
        f19169d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static af valueOf(String r2) {
        return (af) ZeusTransformUtils.preCheckCast(Enum.valueOf(af.class, r2), af.class, "com.obric.aiagent.plugin");
    }

    public static af[] values() {
        return (af[]) ZeusTransformUtils.preCheckCast(f19168c.clone(), af[].class, "com.obric.aiagent.plugin");
    }
}
