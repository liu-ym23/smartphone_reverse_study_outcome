package org.apache.http.protocol;

import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class DefaultedHttpContext implements HttpContext {
    private final HttpContext defaults;
    private final HttpContext local;

    public DefaultedHttpContext(HttpContext r10, HttpContext r11) {
        this.local = (HttpContext) Args.notNull(r10, "HTTP context");
        this.defaults = r11;
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String r10) {
        Object r11 = this.local.getAttribute(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return this.defaults.getAttribute(r10);
    }

    public HttpContext getDefaults() {
        return this.defaults;
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String r10) {
        return this.local.removeAttribute(r10);
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String r10, Object r11) {
        this.local.setAttribute(r10, r11);
    }

    public String toString() {
        return "[local: " + this.local + "defaults: " + this.defaults + "]";
    }
}
