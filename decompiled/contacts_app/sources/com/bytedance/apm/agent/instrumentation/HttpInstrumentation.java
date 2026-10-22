package com.bytedance.apm.agent.instrumentation;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpInstrumentation {
    public HttpInstrumentation() {
    }

    public static URLConnection openConnection(URLConnection r1) {
        if ((r1 instanceof HttpsURLConnection) == false) goto L7;
        return new HttpsURLConnectionExtension((HttpsURLConnection) r1);
    L7:
        if ((r1 instanceof HttpURLConnection) == true) goto L9;
        return r1;
    L9:
        return new HttpURLConnectionExtension((HttpURLConnection) r1);
    }

    public static URLConnection openConnectionWithProxy(URLConnection r1) {
        if ((r1 instanceof HttpsURLConnection) == false) goto L7;
        return new HttpsURLConnectionExtension((HttpsURLConnection) r1);
    L7:
        if ((r1 instanceof HttpURLConnection) == true) goto L9;
        return r1;
    L9:
        return new HttpURLConnectionExtension((HttpURLConnection) r1);
    }
}
