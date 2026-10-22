package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractHttpMessage implements HttpMessage {
    protected HeaderGroup headergroup;

    @Deprecated
    protected HttpParams params;

    @Deprecated
    public AbstractHttpMessage(HttpParams r10) {
        this.headergroup = new HeaderGroup();
        this.params = r10;
    }

    @Override // org.apache.http.HttpMessage
    public void addHeader(Header r10) {
        this.headergroup.addHeader(r10);
    }

    @Override // org.apache.http.HttpMessage
    public boolean containsHeader(String r10) {
        return this.headergroup.containsHeader(r10);
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
    }

    @Override // org.apache.http.HttpMessage
    public Header getFirstHeader(String r10) {
        return this.headergroup.getFirstHeader(r10);
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getHeaders(String r10) {
        return this.headergroup.getHeaders(r10);
    }

    @Override // org.apache.http.HttpMessage
    public Header getLastHeader(String r10) {
        return this.headergroup.getLastHeader(r10);
    }

    @Override // org.apache.http.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if (this.params != null) goto L6;
        this.params = new BasicHttpParams();
    L6:
        return this.params;
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        return this.headergroup.iterator();
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeader(Header r10) {
        this.headergroup.removeHeader(r10);
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeaders(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        HeaderIterator r11 = this.headergroup.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        if (r10.equalsIgnoreCase(r11.nextHeader().getName()) == false) goto L6;
        r11.remove();
        goto L6
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(Header r10) {
        this.headergroup.updateHeader(r10);
    }

    @Override // org.apache.http.HttpMessage
    public void setHeaders(Header[] r10) {
        this.headergroup.setHeaders(r10);
    }

    @Override // org.apache.http.HttpMessage
    @Deprecated
    public void setParams(HttpParams r10) {
        this.params = (HttpParams) Args.notNull(r10, "HTTP parameters");
    }

    @Override // org.apache.http.HttpMessage
    public void addHeader(String r10, String r11) {
        Args.notNull(r10, "Header name");
        this.headergroup.addHeader(new BasicHeader(r10, r11));
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String r10) {
        return this.headergroup.iterator(r10);
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(String r10, String r11) {
        Args.notNull(r10, "Header name");
        this.headergroup.updateHeader(new BasicHeader(r10, r11));
    }

    public AbstractHttpMessage() {
        this(null);
    }
}
