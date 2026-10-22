package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum w extends Enum<w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f19318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f19319b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ w[] f19320c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19321d = null;

    private static final /* synthetic */ w[] a() {
        return new w[]{f19318a, f19319b};
    }

    private w(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19318a = new w("INSTALLED", 0);
        f19319b = new w("ALREADY_INSTALLED", 1);
        w[] r0 = a();
        f19320c = r0;
        f19321d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static w valueOf(String r2) {
        return (w) ZeusTransformUtils.preCheckCast(Enum.valueOf(w.class, r2), w.class, "com.obric.aiagent.plugin");
    }

    public static w[] values() {
        return (w[]) ZeusTransformUtils.preCheckCast(f19320c.clone(), w[].class, "com.obric.aiagent.plugin");
    }
}
