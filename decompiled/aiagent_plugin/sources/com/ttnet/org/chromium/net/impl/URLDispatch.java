package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
public class URLDispatch {
    private static final String TAG = "URLDispatch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f38063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f38064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f38065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f38066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f38067e;
    private com.ttnet.org.chromium.net.urlconnection.g f;

    static {
    }

    public URLDispatch(String r1) {
        this.f38063a = r1;
        this.f = new com.ttnet.org.chromium.net.urlconnection.g();
    }

    public void a(int r1) {
        com.ttnet.org.chromium.net.urlconnection.g r0 = this.f;
        if (r1 > 0) goto L6;
        r1 = 300;
    L6:
        r0.a(r1);
    }

    public void a(Runnable r3) {
        this.f.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void a() {
        this.f.c();
    }

    public void setResult(String r1, String r2, String r3, String r4) {
        this.f38064b = r1;
        this.f38066d = r2;
        this.f38065c = r3;
        this.f38067e = r4;
    }

    public String b() {
        return this.f38064b;
    }

    public String c() {
        return this.f38065c;
    }

    public String d() {
        return this.f38066d;
    }

    public String e() {
        return this.f38067e;
    }
}
