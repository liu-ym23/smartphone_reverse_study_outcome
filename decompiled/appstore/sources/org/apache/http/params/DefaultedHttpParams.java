package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams r10, HttpParams r11) {
        this.local = (HttpParams) Args.notNull(r10, "Local HTTP parameters");
        this.defaults = r11;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    @Override // org.apache.http.params.AbstractHttpParams, org.apache.http.params.HttpParamsNames
    public Set<String> getNames() {
        HashSet r10 = new HashSet(getNames(this.defaults));
        r10.addAll(getNames(this.local));
        return r10;
    }

    @Override // org.apache.http.params.HttpParams
    public Object getParameter(String r10) {
        Object r11 = this.local.getParameter(r10);
        if (r11 != null) goto L8;
        HttpParams r12 = this.defaults;
        if (r12 != null) goto L7;
        return r11;
    L7:
        return r12.getParameter(r10);
    L8:
        return r11;
    }

    @Override // org.apache.http.params.HttpParams
    public boolean removeParameter(String r10) {
        return this.local.removeParameter(r10);
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setParameter(String r10, Object r11) {
        return this.local.setParameter(r10, r11);
    }

    private Set<String> getNames(HttpParams r10) {
        if ((r10 instanceof HttpParamsNames) == false) goto L7;
        return ((HttpParamsNames) r10).getNames();
    L7:
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
