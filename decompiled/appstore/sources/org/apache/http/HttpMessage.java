package org.apache.http;

import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpMessage {
    void addHeader(String r10, String r11);

    void addHeader(Header r10);

    boolean containsHeader(String r10);

    Header[] getAllHeaders();

    Header getFirstHeader(String r10);

    Header[] getHeaders(String r10);

    Header getLastHeader(String r10);

    @Deprecated
    HttpParams getParams();

    ProtocolVersion getProtocolVersion();

    HeaderIterator headerIterator();

    HeaderIterator headerIterator(String r10);

    void removeHeader(Header r10);

    void removeHeaders(String r10);

    void setHeader(String r10, String r11);

    void setHeader(Header r10);

    void setHeaders(Header[] r10);

    @Deprecated
    void setParams(HttpParams r10);
}
