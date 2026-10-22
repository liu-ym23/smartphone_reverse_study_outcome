package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum aq extends Enum<aq> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aq f20553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aq f20554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ aq[] f20555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20556d = null;

    private static final /* synthetic */ aq[] a() {
        return new aq[]{f20553a, f20554b};
    }

    private aq(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20553a = new aq("AFTER_COVER", 0);
        f20554b = new aq("AFTER_BODY", 1);
        aq[] r0 = a();
        f20555c = r0;
        f20556d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static aq valueOf(String r2) {
        return (aq) ZeusTransformUtils.preCheckCast(Enum.valueOf(aq.class, r2), aq.class, "com.obric.aiagent.plugin");
    }

    public static aq[] values() {
        return (aq[]) ZeusTransformUtils.preCheckCast(f20555c.clone(), aq[].class, "com.obric.aiagent.plugin");
    }
}
