package com.bytedance.safetyguard.lxc.internal.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f10717b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f10718c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f10719d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f10720e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    private static final /* synthetic */ b[] i = null;
    private static final /* synthetic */ d.d.a j = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f10716a, f10717b, f10718c, f10719d, f10720e, f, g, h};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(i.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10716a = new b("SUCCESS", 0);
        f10717b = new b("CONTINUE", 1);
        f10718c = new b("HTTP_ERROR", 2);
        f10719d = new b("UPSTREAM_ERROR", 3);
        f10720e = new b("NETWORK_ERROR", 4);
        f = new b("MALFORMED_RESPONSE", 5);
        g = new b("TIMEOUT", 6);
        h = new b("CANCELLED", 7);
        b[] r0 = a();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
