package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements HttpRequestInterceptor {
    public c() {
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public final void process(HttpRequest r100, HttpContext r101) {
        if (Looper.myLooper() != null) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        return;
    L8:
        throw new RuntimeException("This thread forbids HTTP requests");
    }
}
