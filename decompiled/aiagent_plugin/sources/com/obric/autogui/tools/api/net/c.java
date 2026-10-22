package com.obric.autogui.tools.api.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOHttpExceptionInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f31482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f31483b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f31484c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f31485d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f31486e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    private static final /* synthetic */ c[] k = null;
    private static final /* synthetic */ d.d.a l = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f31482a, f31483b, f31484c, f31485d, f31486e, f, g, h, i, j};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f31482a = new c("UserCanceled", 0);
        f31483b = new c("ApiError", 1);
        f31484c = new c("NetworkNotAvailable", 2);
        f31485d = new c("NetworkChanging", 3);
        f31486e = new c("WeakConnection", 4);
        f = new c("ServerUnreachable", 5);
        g = new c("TransferTimedOut", 6);
        h = new c("FailedDuringTransfer", 7);
        i = new c("FailedForBadRequest", 8);
        j = new c("RespondedError", 9);
        c[] r0 = a();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(k.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
