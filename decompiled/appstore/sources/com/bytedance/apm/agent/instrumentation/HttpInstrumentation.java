package com.bytedance.apm.agent.instrumentation;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class HttpInstrumentation {
    public HttpInstrumentation() {
    }

    public static URLConnection openConnection(URLConnection r10) {
        if ((r10 instanceof HttpsURLConnection) == false) goto L7;
        return new HttpsURLConnectionExtension((HttpsURLConnection) r10);
    L7:
        if ((r10 instanceof HttpURLConnection) == true) goto L9;
        return r10;
    L9:
        return new HttpURLConnectionExtension((HttpURLConnection) r10);
    }

    public static URLConnection openConnectionWithProxy(URLConnection r10) {
        if ((r10 instanceof HttpsURLConnection) == false) goto L7;
        return new HttpsURLConnectionExtension((HttpsURLConnection) r10);
    L7:
        if ((r10 instanceof HttpURLConnection) == true) goto L9;
        return r10;
    L9:
        return new HttpURLConnectionExtension((HttpURLConnection) r10);
    }
}
