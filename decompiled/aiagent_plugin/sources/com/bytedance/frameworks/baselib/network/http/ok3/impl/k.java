package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import okhttp3.ttnet.TTNetDns;

/* JADX INFO: compiled from: OkHttp3DnsParserInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements TTNetDns {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile k f8538b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8539a;

    public k() {
        this.f8539a = k.class.getSimpleName();
    }

    public static k a() {
        if (f8538b != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8538b != null) goto L9;
        f8538b = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f8538b;
    }
}
