package org.apache.http.impl;

import com.android.volley.toolbox.HttpClientStack;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public static final DefaultHttpRequestFactory INSTANCE = null;
    private static final String[] RFC2616_COMMON_METHODS = null;
    private static final String[] RFC2616_ENTITY_ENC_METHODS = null;
    private static final String[] RFC2616_SPECIAL_METHODS = null;
    private static final String[] RFC5789_ENTITY_ENC_METHODS = null;

    static {
        INSTANCE = new DefaultHttpRequestFactory();
        RFC2616_COMMON_METHODS = new String[]{"GET"};
        RFC2616_ENTITY_ENC_METHODS = new String[]{"POST", "PUT"};
        RFC2616_SPECIAL_METHODS = new String[]{"HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"};
        RFC5789_ENTITY_ENC_METHODS = new String[]{HttpClientStack.HttpPatch.METHOD_NAME};
    }

    public DefaultHttpRequestFactory() {
    }

    private static boolean isOneOf(String[] r10, String r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10[r13].equalsIgnoreCase(r11) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(RequestLine r10) throws MethodNotSupportedException {
        Args.notNull(r10, "Request line");
        String r11 = r10.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, r11) == false) goto L7;
        return new BasicHttpRequest(r10);
    L7:
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, r11) == false) goto L11;
        return new BasicHttpEntityEnclosingRequest(r10);
    L11:
        if (isOneOf(RFC2616_SPECIAL_METHODS, r11) == false) goto L15;
        return new BasicHttpRequest(r10);
    L15:
        if (isOneOf(RFC5789_ENTITY_ENC_METHODS, r11) == false) goto L19;
        return new BasicHttpEntityEnclosingRequest(r10);
    L19:
        throw new MethodNotSupportedException(r11 + " method not supported");
    }

    @Override // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String r10, String r11) throws MethodNotSupportedException {
        if (isOneOf(RFC2616_COMMON_METHODS, r10) == false) goto L7;
        return new BasicHttpRequest(r10, r11);
    L7:
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, r10) == false) goto L11;
        return new BasicHttpEntityEnclosingRequest(r10, r11);
    L11:
        if (isOneOf(RFC2616_SPECIAL_METHODS, r10) == false) goto L15;
        return new BasicHttpRequest(r10, r11);
    L15:
        if (isOneOf(RFC5789_ENTITY_ENC_METHODS, r10) == false) goto L19;
        return new BasicHttpEntityEnclosingRequest(r10, r11);
    L19:
        throw new MethodNotSupportedException(r10 + " method not supported");
    }
}
