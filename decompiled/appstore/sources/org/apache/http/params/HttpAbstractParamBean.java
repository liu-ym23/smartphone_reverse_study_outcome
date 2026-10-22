package org.apache.http.params;

import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class HttpAbstractParamBean {
    protected final HttpParams params;

    public HttpAbstractParamBean(HttpParams r10) {
        this.params = (HttpParams) Args.notNull(r10, "HTTP parameters");
    }
}
