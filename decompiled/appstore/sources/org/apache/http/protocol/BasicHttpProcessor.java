package org.apache.http.protocol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList, Cloneable {
    protected final List<HttpRequestInterceptor> requestInterceptors;
    protected final List<HttpResponseInterceptor> responseInterceptors;

    public BasicHttpProcessor() {
        this.requestInterceptors = new ArrayList();
        this.responseInterceptors = new ArrayList();
    }

    public final void addInterceptor(HttpRequestInterceptor r10) {
        addRequestInterceptor(r10);
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.requestInterceptors.add(r10);
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.responseInterceptors.add(r11, r10);
    }

    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void clearRequestInterceptors() {
        this.requestInterceptors.clear();
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void clearResponseInterceptors() {
        this.responseInterceptors.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor r10 = (BasicHttpProcessor) super.clone();
        copyInterceptors(r10);
        return r10;
    }

    public BasicHttpProcessor copy() {
        BasicHttpProcessor r10 = new BasicHttpProcessor();
        copyInterceptors(r10);
        return r10;
    }

    public void copyInterceptors(BasicHttpProcessor r10) {
        r10.requestInterceptors.clear();
        r10.requestInterceptors.addAll(this.requestInterceptors);
        r10.responseInterceptors.clear();
        r10.responseInterceptors.addAll(this.responseInterceptors);
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public HttpRequestInterceptor getRequestInterceptor(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 < this.requestInterceptors.size()) goto L7;
        return null;
    L7:
        return this.requestInterceptors.get(r10);
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public int getRequestInterceptorCount() {
        return this.requestInterceptors.size();
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public HttpResponseInterceptor getResponseInterceptor(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 < this.responseInterceptors.size()) goto L7;
        return null;
    L7:
        return this.responseInterceptors.get(r10);
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public int getResponseInterceptorCount() {
        return this.responseInterceptors.size();
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws IOException, HttpException {
        Iterator<HttpRequestInterceptor> r12 = this.requestInterceptors.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().process(r10, r11);
        goto L4
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> r10) {
        Iterator<HttpRequestInterceptor> r11 = this.requestInterceptors.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r11.next().getClass().equals(r10) == false) goto L4;
        r11.remove();
        goto L4
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> r10) {
        Iterator<HttpResponseInterceptor> r11 = this.responseInterceptors.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r11.next().getClass().equals(r10) == false) goto L4;
        r11.remove();
        goto L4
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList, org.apache.http.protocol.HttpResponseInterceptorList
    public void setInterceptors(List<?> r10) {
        Args.notNull(r10, "Inteceptor list");
        this.requestInterceptors.clear();
        this.responseInterceptors.clear();
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Object r12 = r11.next();
        if ((r12 instanceof HttpRequestInterceptor) == false) goto L9;
        addInterceptor((HttpRequestInterceptor) r12);
    L9:
        if ((r12 instanceof HttpResponseInterceptor) == false) goto L4;
        addInterceptor((HttpResponseInterceptor) r12);
        goto L4
    }

    public final void addInterceptor(HttpRequestInterceptor r10, int r11) {
        addRequestInterceptor(r10, r11);
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.requestInterceptors.add(r11, r10);
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.responseInterceptors.add(r10);
    }

    public final void addInterceptor(HttpResponseInterceptor r10) {
        addResponseInterceptor(r10);
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws IOException, HttpException {
        Iterator<HttpResponseInterceptor> r12 = this.responseInterceptors.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().process(r10, r11);
        goto L4
    }

    public final void addInterceptor(HttpResponseInterceptor r10, int r11) {
        addResponseInterceptor(r10, r11);
    }
}
