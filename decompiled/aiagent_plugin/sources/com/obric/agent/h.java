package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IAgentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f14564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f14565b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f14566c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f14567d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f14568e = null;
    private static final /* synthetic */ h[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ h[] a() {
        return new h[]{f14564a, f14565b, f14566c, f14567d, f14568e};
    }

    private h(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f14564a = new h("NA", 0);
        f14565b = new h("CHAT_WINDOW", 1);
        f14566c = new h("HALF_WINDOW", 2);
        f14567d = new h("FULL_SCREEN", 3);
        f14568e = new h("INVISIBLE", 4);
        h[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(f.clone(), h[].class, "com.obric.aiagent.plugin");
    }
}
