package com.obric.agent.entitysync;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f14508b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f14509c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ g[] f14510d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f14511e = null;

    private static final /* synthetic */ g[] a() {
        return new g[]{f14507a, f14508b, f14509c};
    }

    private g(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f14507a = new g("INSERT", 0);
        f14508b = new g("UPDATE", 1);
        f14509c = new g("DELETE", 2);
        g[] r0 = a();
        f14510d = r0;
        f14511e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static g valueOf(String r2) {
        return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
    }

    public static g[] values() {
        return (g[]) ZeusTransformUtils.preCheckCast(f14510d.clone(), g[].class, "com.obric.aiagent.plugin");
    }
}
