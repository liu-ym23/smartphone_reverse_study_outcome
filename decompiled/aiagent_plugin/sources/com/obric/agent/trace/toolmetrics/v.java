package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum v extends Enum<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f15930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f15931b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ v[] f15932c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f15933d = null;

    private static final /* synthetic */ v[] a() {
        return new v[]{f15930a, f15931b};
    }

    private v(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f15930a = new v("COMMON", 0);
        f15931b = new v("EXT", 1);
        v[] r0 = a();
        f15932c = r0;
        f15933d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static v valueOf(String r2) {
        return (v) ZeusTransformUtils.preCheckCast(Enum.valueOf(v.class, r2), v.class, "com.obric.aiagent.plugin");
    }

    public static v[] values() {
        return (v[]) ZeusTransformUtils.preCheckCast(f15932c.clone(), v[].class, "com.obric.aiagent.plugin");
    }
}
