package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String get(Request r10, Proxy.Type r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.g());
        r12.append(TokenParser.SP);
        if (includeAuthorityInRequestLine(r10, r11) == false) goto L5;
        r12.append(r10.k());
    L6:
        r12.append(" HTTP/1.1");
        return r12.toString();
    L5:
        r12.append(requestPath(r10.k()));
        goto L6
    }

    private static boolean includeAuthorityInRequestLine(Request r10, Proxy.Type r11) {
        if (r10.f() == false) goto L5;
    L7:
        return false;
    L5:
        if (r11 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public static String requestPath(HttpUrl r10) {
        String r11 = r10.h();
        String r12 = r10.j();
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r11 + '?' + r12;
    }
}
