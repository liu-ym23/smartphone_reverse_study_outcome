package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f9969b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f9970c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d[] f9971d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f9972e = null;

    public static d.d.a<d> a() {
        return f9972e;
    }

    private static final /* synthetic */ d[] b() {
        return new d[]{f9968a, f9969b, f9970c};
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f9971d.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9968a = new d("PROXY_ATTACHMENT", 0);
        f9969b = new d("SIDECAR_OPERATION", 1);
        f9970c = new d("SIDECAR_SESSION", 2);
        d[] r0 = b();
        f9971d = r0;
        f9972e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
