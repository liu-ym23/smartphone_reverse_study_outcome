package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes28.dex */
public final class e extends DefaultRedirectHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f25016b;

    public e(d r100) {
        this.f25016b = r100;
    }

    @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
    public final boolean isRedirectRequested(HttpResponse r100, HttpContext r101) {
        this.f25015a++;
        boolean r102 = super.isRedirectRequested(r100, r101);
        if (r102 == false) goto L5;
    L11:
        return r102;
    L5:
        if (this.f25015a >= 5) goto L11;
        int r103 = r100.getStatusLine().getStatusCode();
        if (r103 != 301) goto L9;
    L10:
        return true;
    L9:
        if (r103 != 302) goto L11;
        goto L10
    }
}
