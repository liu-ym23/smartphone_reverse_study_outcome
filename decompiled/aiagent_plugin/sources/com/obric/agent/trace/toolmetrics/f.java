package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientNetworkDeliveryTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f15882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f15883b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ f[] f15884d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f15885e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15886c;

    private static final /* synthetic */ f[] d() {
        return new f[]{f15882a, f15883b};
    }

    private f(String r1, int r2, String r3) {
        super(r1, r2);
        this.f15886c = r3;
    }

    public final String a() {
        return this.f15886c;
    }

    static {
        f15882a = new f("HTTP_COMPENSATION", 0, "http_compensation");
        f15883b = new f("ASYNC_NOTIFY", 1, "async_notify");
        f[] r0 = d();
        f15884d = r0;
        f15885e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public final String b() {
        return "network." + this.f15886c + ".planned";
    }

    public final String c() {
        return "network." + this.f15886c + ".callback_received";
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f15884d.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
