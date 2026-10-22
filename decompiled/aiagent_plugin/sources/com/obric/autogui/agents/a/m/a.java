package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f26648b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f26649c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f26650d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f26651e = null;
    public static final a f = null;
    private static final /* synthetic */ a[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f26647a, f26648b, f26649c, f26650d, f26651e, f};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26647a = new a("PREPARATION", 0);
        f26648b = new a("BEFORE_OPERATION_HOOK", 1);
        f26649c = new a("AFTER_OPERATION_HOOK", 2);
        f26650d = new a("SKIPPED_OPERATION_HOOK", 3);
        f26651e = new a("MODEL_SCREENSHOT_EVALUATION", 4);
        f = new a("COMPLETION", 5);
        a[] r0 = a();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
