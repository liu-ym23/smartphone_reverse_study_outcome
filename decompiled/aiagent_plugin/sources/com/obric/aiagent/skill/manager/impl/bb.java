package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDerivedProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum bb extends Enum<bb> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bb f19546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bb f19547b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ bb[] f19548c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19549d = null;

    private static final /* synthetic */ bb[] a() {
        return new bb[]{f19546a, f19547b};
    }

    private bb(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19546a = new bb("CREATE", 0);
        f19547b = new bb("IMPORT", 1);
        bb[] r0 = a();
        f19548c = r0;
        f19549d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bb valueOf(String r2) {
        return (bb) ZeusTransformUtils.preCheckCast(Enum.valueOf(bb.class, r2), bb.class, "com.obric.aiagent.plugin");
    }

    public static bb[] values() {
        return (bb[]) ZeusTransformUtils.preCheckCast(f19548c.clone(), bb[].class, "com.obric.aiagent.plugin");
    }
}
