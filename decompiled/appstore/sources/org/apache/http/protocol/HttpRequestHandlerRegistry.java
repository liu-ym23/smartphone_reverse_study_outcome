package org.apache.http.protocol;

import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    public HttpRequestHandlerRegistry() {
        this.matcher = new UriPatternMatcher();
    }

    public Map<String, HttpRequestHandler> getHandlers() {
        return this.matcher.getObjects();
    }

    @Override // org.apache.http.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String r10) {
        return this.matcher.lookup(r10);
    }

    public void register(String r10, HttpRequestHandler r11) {
        Args.notNull(r10, "URI request pattern");
        Args.notNull(r11, "Request handler");
        this.matcher.register(r10, r11);
    }

    public void setHandlers(Map<String, HttpRequestHandler> r10) {
        this.matcher.setObjects(r10);
    }

    public void unregister(String r10) {
        this.matcher.unregister(r10);
    }
}
