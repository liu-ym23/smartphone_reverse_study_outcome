package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f8471b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f8472c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f8473d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f8474e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    public static final d l = null;
    public static final d m = null;
    public static final d n = null;
    public static final d o = null;
    public static final d p = null;
    private static final /* synthetic */ d[] q = null;

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(q.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        d r0 = new d("IDLE", 0);
        f8470a = r0;
        d r1 = new d("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        f8471b = r1;
        d r3 = new d("WAITING_FOR_AVAILABLE_SOCKET", 2);
        f8472c = r3;
        d r5 = new d("WAITING_FOR_DELEGATE", 3);
        f8473d = r5;
        d r7 = new d("WAITING_FOR_CACHE", 4);
        f8474e = r7;
        d r9 = new d("WAITING_FOR_APPCACHE", 5);
        f = r9;
        d r11 = new d("DOWNLOADING_PAC_FILE", 6);
        g = r11;
        d r13 = new d("RESOLVING_PROXY_FOR_URL", 7);
        h = r13;
        d r15 = new d("RESOLVING_HOST_IN_PAC_FILE", 8);
        i = r15;
        d r14 = new d("ESTABLISHING_PROXY_TUNNEL", 9);
        j = r14;
        d r12 = new d("RESOLVING_HOST", 10);
        k = r12;
        d r10 = new d("CONNECTING", 11);
        l = r10;
        d r8 = new d("SSL_HANDSHAKE", 12);
        m = r8;
        d r6 = new d("SENDING_REQUEST", 13);
        n = r6;
        d r4 = new d("WAITING_FOR_RESPONSE", 14);
        o = r4;
        d r2 = new d("READING_RESPONSE", 15);
        p = r2;
        q = new d[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
    }
}
