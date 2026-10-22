package com.bytedance.frameworks.baselib.network.http.cronet.b;

import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: CronetSsCall.java */
/* JADX INFO: loaded from: classes.dex */
class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HttpURLConnection f8217e;

    public e(com.bytedance.retrofit2.b.c r1) {
        super(r1);
        this.f8217e = null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.a
    HttpURLConnection b() {
        return this.f8217e;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.a
    void a(HttpURLConnection r1) {
        this.f8217e = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public IOException a(Exception r4) {
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r4.getClass().getName()) == false) goto L5;
        int r0 = i.a(this.f8217e);
    L7:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r4.getClass().getName()) == false) goto L9;
    L10:
        r0 = i.a(this.f8217e);
    L12:
        return new c(r4, this.g, r0);
    L9:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r4.getClass().getName()) == false) goto L12;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public int a(IOException r3) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        return -1;
    L10:
        return i.a(this.f8217e);
    }

    @Override // com.bytedance.retrofit2.b.e
    public void n() {
        c(this.f8217e);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.a, com.bytedance.retrofit2.b.e
    public boolean a(long r8) {
        super.a(r8);
        if (this.f8217e != null) goto L16;
    L14:
        return true;
    L16:
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L9;
        com.bytedance.frameworks.baselib.network.h.a.a(this.f8217e).call("configureConnection", new Class[]{String.class, Object[].class}, new Object[]{"setThrottleNetSpeed", new Object[]{Long.valueOf(r8)}});     // Catch: Throwable -> L11
    L15:
        goto L14
    L9:
        com.bytedance.frameworks.baselib.network.h.a.a(this.f8217e).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r8)});     // Catch: Throwable -> L11
        goto L15
    }
}
