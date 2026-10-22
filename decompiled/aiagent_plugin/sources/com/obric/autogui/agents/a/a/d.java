package com.obric.autogui.agents.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectAttemptModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f26242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f26243b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f26244c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d[] f26245d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f26246e = null;

    private static final /* synthetic */ d[] a() {
        return new d[]{f26242a, f26243b, f26244c};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26242a = new d("SECURE_PAGE", 0);
        f26243b = new d("TYPE_FRAMEWORK_RESULT_EFFECTIVE", 1);
        f26244c = new d("TYPE_OPERATION_FAILED", 2);
        d[] r0 = a();
        f26245d = r0;
        f26246e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f26245d.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
