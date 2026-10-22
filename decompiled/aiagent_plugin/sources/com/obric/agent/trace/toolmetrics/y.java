package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum y extends Enum<y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f15944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f15945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f15946c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f15947d = null;
    private static final /* synthetic */ y[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15948e;

    private static final /* synthetic */ y[] b() {
        return new y[]{f15944a, f15945b, f15946c, f15947d};
    }

    private y(String r1, int r2, String r3) {
        super(r1, r2);
        this.f15948e = r3;
    }

    public final String a() {
        return this.f15948e;
    }

    static {
        f15944a = new y("EXACT", 0, "exact");
        f15945b = new y("TIMEOUT", 1, "timeout");
        f15946c = new y("CANCELLED", 2, "cancelled");
        f15947d = new y("RIGHT_CENSORED", 3, "right_censored");
        y[] r0 = b();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static y valueOf(String r2) {
        return (y) ZeusTransformUtils.preCheckCast(Enum.valueOf(y.class, r2), y.class, "com.obric.aiagent.plugin");
    }

    public static y[] values() {
        return (y[]) ZeusTransformUtils.preCheckCast(f.clone(), y[].class, "com.obric.aiagent.plugin");
    }
}
