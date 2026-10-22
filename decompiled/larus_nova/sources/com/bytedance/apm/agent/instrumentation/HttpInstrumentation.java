package com.bytedance.apm.agent.instrumentation;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes14.dex */
public final class HttpInstrumentation {
    public HttpInstrumentation() {
    }

    public static URLConnection openConnection(URLConnection r100) {
        if ((r100 instanceof HttpsURLConnection) == false) goto L7;
        return new HttpsURLConnectionExtension((HttpsURLConnection) r100);
    L7:
        if ((r100 instanceof HttpURLConnection) == true) goto L9;
        return r100;
    L9:
        return new HttpURLConnectionExtension((HttpURLConnection) r100);
    }

    public static URLConnection openConnectionWithProxy(URLConnection r100) {
        if ((r100 instanceof HttpsURLConnection) == false) goto L7;
        return new HttpsURLConnectionExtension((HttpsURLConnection) r100);
    L7:
        if ((r100 instanceof HttpURLConnection) == true) goto L9;
        return r100;
    L9:
        return new HttpURLConnectionExtension((HttpURLConnection) r100);
    }
}
