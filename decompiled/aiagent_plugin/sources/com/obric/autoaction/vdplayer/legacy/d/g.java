package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f25891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f25892b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f25893c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f25894d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f25895e = null;
    private static final /* synthetic */ g[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ g[] a() {
        return new g[]{f25891a, f25892b, f25893c, f25894d, f25895e};
    }

    private g(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25891a = new g("IDLE", 0);
        f25892b = new g("USER_OPERATING", 1);
        f25893c = new g("RUN", 2);
        f25894d = new g("END_SUCCESS", 3);
        f25895e = new g("END_FAILURE", 4);
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
