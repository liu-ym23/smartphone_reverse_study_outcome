package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkBiz.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f22209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f22210b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f22211c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f22212d = null;
    private static final /* synthetic */ c[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f22213e;
    private final int f;

    private static final /* synthetic */ c[] b() {
        return new c[]{f22209a, f22210b, f22211c, f22212d};
    }

    private c(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.f22213e = r3;
        this.f = r4;
    }

    public final String a() {
        return this.f22213e;
    }

    public final int getType() {
        return this.f;
    }

    static {
        f22209a = new c("UNKNOWN", 0, "unknown_biz", 404);
        f22210b = new c("O_AUTO_TASK", 1, "oauto_task", 1);
        f22211c = new c("O_SIMPLE_TASK", 2, "o_simple_task", 2);
        f22212d = new c("O_COMPLEX_TASK", 3, "o_complex_task", 3);
        c[] r0 = b();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(g.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
