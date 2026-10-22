package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFeatureAvailabilityResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum aq extends Enum<aq> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aq f19505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aq f19506b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final aq f19507c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final aq f19508d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final aq f19509e = null;
    private static final /* synthetic */ aq[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ aq[] a() {
        return new aq[]{f19505a, f19506b, f19507c, f19508d, f19509e};
    }

    private aq(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19505a = new aq("ALLOWED", 0);
        f19506b = new aq("FEATURE_DISABLED", 1);
        f19507c = new aq("EXTENSION_DISABLED", 2);
        f19508d = new aq("CAPABILITY_UNAVAILABLE", 3);
        f19509e = new aq("UNKNOWN", 4);
        aq[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static aq valueOf(String r2) {
        return (aq) ZeusTransformUtils.preCheckCast(Enum.valueOf(aq.class, r2), aq.class, "com.obric.aiagent.plugin");
    }

    public static aq[] values() {
        return (aq[]) ZeusTransformUtils.preCheckCast(f.clone(), aq[].class, "com.obric.aiagent.plugin");
    }
}
