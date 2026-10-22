package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum s extends Enum<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f26710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f26711b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f26712c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f26713d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ s[] f26714e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ s[] a() {
        return new s[]{f26710a, f26711b, f26712c, f26713d};
    }

    private s(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26710a = new s("COMPLETED", 0);
        f26711b = new s("TIMEOUT", 1);
        f26712c = new s("CANCELLED", 2);
        f26713d = new s("ERROR", 3);
        s[] r0 = a();
        f26714e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static s valueOf(String r2) {
        return (s) ZeusTransformUtils.preCheckCast(Enum.valueOf(s.class, r2), s.class, "com.obric.aiagent.plugin");
    }

    public static s[] values() {
        return (s[]) ZeusTransformUtils.preCheckCast(f26714e.clone(), s[].class, "com.obric.aiagent.plugin");
    }
}
