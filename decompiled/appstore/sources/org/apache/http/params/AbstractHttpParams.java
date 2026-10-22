package org.apache.http.params;

import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
    public AbstractHttpParams() {
    }

    @Override // org.apache.http.params.HttpParams
    public boolean getBooleanParameter(String r10, boolean r11) {
        Object r12 = getParameter(r10);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return ((Boolean) r12).booleanValue();
    }

    @Override // org.apache.http.params.HttpParams
    public double getDoubleParameter(String r10, double r11) {
        Object r12 = getParameter(r10);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return ((Double) r12).doubleValue();
    }

    @Override // org.apache.http.params.HttpParams
    public int getIntParameter(String r10, int r11) {
        Object r12 = getParameter(r10);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return ((Integer) r12).intValue();
    }

    @Override // org.apache.http.params.HttpParams
    public long getLongParameter(String r10, long r11) {
        Object r12 = getParameter(r10);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return ((Long) r12).longValue();
    }

    @Override // org.apache.http.params.HttpParamsNames
    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.params.HttpParams
    public boolean isParameterFalse(String r10) {
        return !getBooleanParameter(r10, false);
    }

    @Override // org.apache.http.params.HttpParams
    public boolean isParameterTrue(String r10) {
        return getBooleanParameter(r10, false);
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setBooleanParameter(String r10, boolean r11) {
        if (r11 == false) goto L4;
        Boolean r12 = Boolean.TRUE;
    L5:
        setParameter(r10, r12);
        return this;
    L4:
        r12 = Boolean.FALSE;
        goto L5
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setDoubleParameter(String r10, double r11) {
        setParameter(r10, Double.valueOf(r11));
        return this;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setIntParameter(String r10, int r11) {
        setParameter(r10, Integer.valueOf(r11));
        return this;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setLongParameter(String r10, long r11) {
        setParameter(r10, Long.valueOf(r11));
        return this;
    }
}
