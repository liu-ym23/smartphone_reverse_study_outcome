package org.apache.http.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this(null);
    }

    public void clear() {
        this.map.clear();
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String r10) {
        Args.notNull(r10, "Id");
        Object r11 = this.map.get(r10);
        if (r11 != null) goto L8;
        HttpContext r12 = this.parentContext;
        if (r12 != null) goto L7;
        return r11;
    L7:
        return r12.getAttribute(r10);
    L8:
        return r11;
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String r10) {
        Args.notNull(r10, "Id");
        return this.map.remove(r10);
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String r10, Object r11) {
        Args.notNull(r10, "Id");
        if (r11 == null) goto L5;
        this.map.put(r10, r11);
        return;
    L5:
        this.map.remove(r10);
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicHttpContext(HttpContext r10) {
        this.map = new ConcurrentHashMap();
        this.parentContext = r10;
    }
}
