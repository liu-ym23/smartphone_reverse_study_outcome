package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillVersionPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ec extends Enum<ec> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ec f19804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ec f19805b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ ec[] f19806c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19807d = null;

    private static final /* synthetic */ ec[] a() {
        return new ec[]{f19804a, f19805b};
    }

    private ec(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19804a = new ec("ALREADY_INSTALLED", 0);
        f19805b = new ec("DOWNLOAD", 1);
        ec[] r0 = a();
        f19806c = r0;
        f19807d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ec valueOf(String r2) {
        return (ec) ZeusTransformUtils.preCheckCast(Enum.valueOf(ec.class, r2), ec.class, "com.obric.aiagent.plugin");
    }

    public static ec[] values() {
        return (ec[]) ZeusTransformUtils.preCheckCast(f19806c.clone(), ec[].class, "com.obric.aiagent.plugin");
    }
}
