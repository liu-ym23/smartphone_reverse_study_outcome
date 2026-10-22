package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    public UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> r10) {
        this.matcher = (UriPatternMatcher) Args.notNull(r10, "Pattern matcher");
    }

    public String getRequestPath(HttpRequest r10) {
        String r11 = r10.getRequestLine().getUri();
        int r12 = r11.indexOf(63);
        if (r12 != (-1)) goto L9;
        int r13 = r11.indexOf(35);
        if (r13 != (-1)) goto L8;
        return r11;
    L8:
        return r11.substring(0, r13);
    L9:
        return r11.substring(0, r12);
    }

    @Override // org.apache.http.protocol.HttpRequestHandlerMapper
    public HttpRequestHandler lookup(HttpRequest r10) {
        Args.notNull(r10, "HTTP request");
        return this.matcher.lookup(getRequestPath(r10));
    }

    public void register(String r10, HttpRequestHandler r11) {
        Args.notNull(r10, "Pattern");
        Args.notNull(r11, "Handler");
        this.matcher.register(r10, r11);
    }

    public void unregister(String r10) {
        this.matcher.unregister(r10);
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }
}
