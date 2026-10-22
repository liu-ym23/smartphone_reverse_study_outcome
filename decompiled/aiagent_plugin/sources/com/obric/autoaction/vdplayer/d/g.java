package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f25484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f25485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f25486c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f25487d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f25488e = null;
    private static final /* synthetic */ g[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ g[] a() {
        return new g[]{f25484a, f25485b, f25486c, f25487d, f25488e};
    }

    private g(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25484a = new g("IDLE", 0);
        f25485b = new g("USER_OPERATING", 1);
        f25486c = new g("RUN", 2);
        f25487d = new g("END_SUCCESS", 3);
        f25488e = new g("END_FAILURE", 4);
        g[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static g valueOf(String r2) {
        return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
    }

    public static g[] values() {
        return (g[]) ZeusTransformUtils.preCheckCast(f.clone(), g[].class, "com.obric.aiagent.plugin");
    }
}
