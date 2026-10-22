package com.jeffmony.async.http;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncSSLEngineConfigurator {
    void configureEngine(SSLEngine r10, AsyncHttpClientMiddleware.a r11, String r12, int r13);

    SSLEngine createEngine(SSLContext r10, String r11, int r12);
}
