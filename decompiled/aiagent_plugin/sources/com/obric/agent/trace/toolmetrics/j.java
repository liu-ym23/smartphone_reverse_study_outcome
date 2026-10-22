package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f15894b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ j[] f15895c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f15896d = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f15893a, f15894b};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f15893a = new j("DISPATCH_START", 0);
        f15894b = new j("RESULT_READY", 1);
        j[] r0 = a();
        f15895c = r0;
        f15896d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f15895c.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
