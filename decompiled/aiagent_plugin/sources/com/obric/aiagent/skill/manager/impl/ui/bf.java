package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum bf extends Enum<bf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bf f20636a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bf f20637b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bf f20638c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final bf f20639d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final bf f20640e = null;
    private static final /* synthetic */ bf[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ bf[] a() {
        return new bf[]{f20636a, f20637b, f20638c, f20639d, f20640e};
    }

    private bf(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20636a = new bf("NAME_REQUIRED", 0);
        f20637b = new bf("NAME_TOO_LONG", 1);
        f20638c = new bf("DESCRIPTION_REQUIRED", 2);
        f20639d = new bf("DESCRIPTION_TOO_LONG", 3);
        f20640e = new bf("BODY_REQUIRED", 4);
        bf[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bf valueOf(String r2) {
        return (bf) ZeusTransformUtils.preCheckCast(Enum.valueOf(bf.class, r2), bf.class, "com.obric.aiagent.plugin");
    }

    public static bf[] values() {
        return (bf[]) ZeusTransformUtils.preCheckCast(f.clone(), bf[].class, "com.obric.aiagent.plugin");
    }
}
