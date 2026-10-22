package com.alipay.android.phone.mrpc.core;

import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes28.dex */
public final class d extends DefaultHttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f25014a;

    public d(b r100, ClientConnectionManager r101, HttpParams r102) {
        this.f25014a = r100;
        super(r101, r102);
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new f(this);
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final HttpContext createHttpContext() {
        BasicHttpContext r100 = new BasicHttpContext();
        r100.setAttribute("http.authscheme-registry", getAuthSchemes());
        r100.setAttribute("http.cookiespec-registry", getCookieSpecs());
        r100.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return r100;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor r100 = super.createHttpProcessor();
        r100.addRequestInterceptor(b.a());
        r100.addRequestInterceptor(new b.a(this.f25014a, (byte) 0));
        return r100;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final RedirectHandler createRedirectHandler() {
        return new e(this);
    }
}
