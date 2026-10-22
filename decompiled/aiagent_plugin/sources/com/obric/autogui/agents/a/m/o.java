package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f26692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f26693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f26694c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ o[] f26695d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f26696e = null;

    private static final /* synthetic */ o[] a() {
        return new o[]{f26692a, f26693b, f26694c};
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26692a = new o("BASELINE", 0);
        f26693b = new o("TYPE_BEFORE_SUBMIT", 1);
        f26694c = new o("EVALUATION_ROUND", 2);
        o[] r0 = a();
        f26695d = r0;
        f26696e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(f26695d.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
