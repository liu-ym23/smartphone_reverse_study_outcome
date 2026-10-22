package com.bytedance.apm.agent.instrumentation;

import C4.a;
import O.b;
import O.c;
import R.d;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public final class HttpInstrumentation {
    public static URLConnection openConnection(URLConnection uRLConnection) {
        if (a.c().b()) {
            int i = c.p;
            c cVar = b.f1029a;
            if (cVar.o && (!cVar.f1030j || !cVar.k)) {
                return uRLConnection;
            }
            if (uRLConnection instanceof HttpsURLConnection) {
                return new d((HttpsURLConnection) uRLConnection);
            }
            if (uRLConnection instanceof HttpURLConnection) {
                return new R.b((HttpURLConnection) uRLConnection);
            }
        }
        return uRLConnection;
    }

    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        if (a.c().b()) {
            int i = c.p;
            c cVar = b.f1029a;
            if (cVar.o && (!cVar.f1030j || !cVar.k)) {
                return uRLConnection;
            }
            if (uRLConnection instanceof HttpsURLConnection) {
                return new d((HttpsURLConnection) uRLConnection);
            }
            if (uRLConnection instanceof HttpURLConnection) {
                return new R.b((HttpURLConnection) uRLConnection);
            }
        }
        return uRLConnection;
    }
}
