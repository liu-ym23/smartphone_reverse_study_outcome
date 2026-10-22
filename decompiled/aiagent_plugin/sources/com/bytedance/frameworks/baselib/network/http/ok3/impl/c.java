package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f8467b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f8468c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f8469d = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f8469d.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("HANDSHAKE_UNKNOWN", 0);
        f8466a = r0;
        c r1 = new c("HANDSHAKE_RESUME", 1);
        f8467b = r1;
        c r3 = new c("HANDSHAKE_FULL", 2);
        f8468c = r3;
        f8469d = new c[]{r0, r1, r3};
    }
}
