package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f26681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f26682b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f26683c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f26684d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f26685e = null;
    public static final l f = null;
    public static final l g = null;
    private static final /* synthetic */ l[] h = null;
    private static final /* synthetic */ d.d.a i = null;

    private static final /* synthetic */ l[] a() {
        return new l[]{f26681a, f26682b, f26683c, f26684d, f26685e, f, g};
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26681a = new l("NOT_REQUIRED", 0);
        f26682b = new l("REUSED", 1);
        f26683c = new l("SKIPPED", 2);
        f26684d = new l("COMPLETED", 3);
        f26685e = new l("TIMEOUT", 4);
        f = new l("CANCELLED", 5);
        g = new l("ERROR", 6);
        l[] r0 = a();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static l valueOf(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(Enum.valueOf(l.class, r2), l.class, "com.obric.aiagent.plugin");
    }

    public static l[] values() {
        return (l[]) ZeusTransformUtils.preCheckCast(h.clone(), l[].class, "com.obric.aiagent.plugin");
    }
}
