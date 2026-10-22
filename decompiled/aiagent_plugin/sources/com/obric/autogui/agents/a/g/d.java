package com.obric.autogui.agents.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f26451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f26452b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f26453c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d[] f26454d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f26455e = null;

    private static final /* synthetic */ d[] a() {
        return new d[]{f26451a, f26452b, f26453c};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26451a = new d("RETURN_ORIGINAL", 0);
        f26452b = new d("OBSERVE_ASYNC", 1);
        f26453c = new d("VERIFY_SYNC", 2);
        d[] r0 = a();
        f26454d = r0;
        f26455e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f26454d.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
