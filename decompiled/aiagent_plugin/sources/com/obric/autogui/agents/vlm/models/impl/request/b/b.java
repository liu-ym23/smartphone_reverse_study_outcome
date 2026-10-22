package com.obric.autogui.agents.vlm.models.impl.request.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StdModelInferencingErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f28050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f28051b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f28052c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f28053d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f28054e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    private static final /* synthetic */ b[] j = null;
    private static final /* synthetic */ d.d.a k = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f28050a, f28051b, f28052c, f28053d, f28054e, f, g, h, i};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f28050a = new b("CLIENT_INTERNAL_ERROR", 0);
        f28051b = new b("REQUEST_CANCELLED", 1);
        f28052c = new b("API_REQUEST_SERVICE_ERROR", 2);
        f28053d = new b("REQUEST_NETWORK_ERROR", 3);
        f28054e = new b("REQUEST_TIMEOUT", 4);
        f = new b("REQUEST_OTHER_ERROR", 5);
        g = new b("SESSION_INVALID", 6);
        h = new b("SERVICE_BUSINESS_EXCEPTION", 7);
        i = new b("CLIENT_BUSINESS_EXCEPTION", 8);
        b[] r0 = a();
        j = r0;
        k = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(j.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
