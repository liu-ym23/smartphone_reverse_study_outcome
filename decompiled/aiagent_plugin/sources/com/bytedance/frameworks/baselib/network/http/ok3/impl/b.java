package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8421b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8422c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f8423d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8424e = null;
    public static final b f = null;
    private static final /* synthetic */ b[] h = null;
    final int g;

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("CONNECTION_INFO_UNKNOWN", 0, 0);
        f8420a = r0;
        b r1 = new b("CONNECTION_INFO_HTTP1_1", 1, 1);
        f8421b = r1;
        b r3 = new b("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        f8422c = r3;
        b r5 = new b("CONNECTION_INFO_HTTP2", 3, 4);
        f8423d = r5;
        b r8 = new b("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        f8424e = r8;
        b r10 = new b("CONNECTION_INFO_HTTP1_0", 5, 9);
        f = r10;
        h = new b[]{r0, r1, r3, r5, r8, r10};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.g = r3;
    }
}
