package com.obric.autogui.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f26108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f26109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f26110d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f26111e = null;
    private static final /* synthetic */ c[] g = null;
    private static final /* synthetic */ d.d.a h = null;
    private final int f;

    private static final /* synthetic */ c[] b() {
        return new c[]{f26107a, f26108b, f26109c, f26110d, f26111e};
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f = r3;
    }

    public final int a() {
        return this.f;
    }

    static {
        f26107a = new c("UNKNOWN", 0, -1);
        f26108b = new c("INIT", 1, 0);
        f26109c = new c("DIALOG", 2, 1);
        f26110d = new c("FINISH", 3, 2);
        f26111e = new c("PROCESSING", 4, 3);
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
