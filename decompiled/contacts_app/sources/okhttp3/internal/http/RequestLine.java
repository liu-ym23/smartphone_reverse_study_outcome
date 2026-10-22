package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* JADX INFO: loaded from: classes5.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String get(Request r2, Proxy.Type r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.method());
        r0.append(' ');
        if (includeAuthorityInRequestLine(r2, r3) == false) goto L5;
        r0.append(r2.url());
    L6:
        r0.append(" HTTP/1.1");
        return r0.toString();
    L5:
        r0.append(requestPath(r2.url()));
        goto L6
    }

    private static boolean includeAuthorityInRequestLine(Request r0, Proxy.Type r1) {
        if (r0.isHttps() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public static String requestPath(HttpUrl r2) {
        String r0 = r2.encodedPath();
        String r3 = r2.encodedQuery();
        if (r3 != null) goto L5;
        return r0;
    L5:
        return r0 + '?' + r3;
    }
}
