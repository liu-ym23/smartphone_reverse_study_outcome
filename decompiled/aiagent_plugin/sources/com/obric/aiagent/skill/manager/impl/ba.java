package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDerivedProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ba extends Enum<ba> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ba f19541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ba f19542b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ba f19543c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ba f19544d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ ba[] f19545e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ ba[] a() {
        return new ba[]{f19541a, f19542b, f19543c, f19544d};
    }

    private ba(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19541a = new ba("ADD", 0);
        f19542b = new ba("ENABLE", 1);
        f19543c = new ba("USE", 2);
        f19544d = new ba("SECURITY_BLOCKED", 3);
        ba[] r0 = a();
        f19545e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ba valueOf(String r2) {
        return (ba) ZeusTransformUtils.preCheckCast(Enum.valueOf(ba.class, r2), ba.class, "com.obric.aiagent.plugin");
    }

    public static ba[] values() {
        return (ba[]) ZeusTransformUtils.preCheckCast(f19545e.clone(), ba[].class, "com.obric.aiagent.plugin");
    }
}
