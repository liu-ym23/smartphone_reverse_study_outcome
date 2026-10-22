package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ga extends Enum<ga> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ga f19968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ga f19969b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ ga[] f19970c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19971d = null;

    private static final /* synthetic */ ga[] a() {
        return new ga[]{f19968a, f19969b};
    }

    private ga(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19968a = new ga("VALID", 0);
        f19969b = new ga("INVALID", 1);
        ga[] r0 = a();
        f19970c = r0;
        f19971d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ga valueOf(String r2) {
        return (ga) ZeusTransformUtils.preCheckCast(Enum.valueOf(ga.class, r2), ga.class, "com.obric.aiagent.plugin");
    }

    public static ga[] values() {
        return (ga[]) ZeusTransformUtils.preCheckCast(f19970c.clone(), ga[].class, "com.obric.aiagent.plugin");
    }
}
