package org.apache.http.protocol;

import java.util.LinkedList;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;

/* JADX INFO: loaded from: classes4.dex */
public class HttpProcessorBuilder {
    private ChainBuilder<HttpRequestInterceptor> requestChainBuilder;
    private ChainBuilder<HttpResponseInterceptor> responseChainBuilder;

    public HttpProcessorBuilder() {
    }

    public static HttpProcessorBuilder create() {
        return new HttpProcessorBuilder();
    }

    private ChainBuilder<HttpRequestInterceptor> getRequestChainBuilder() {
        if (this.requestChainBuilder != null) goto L6;
        this.requestChainBuilder = new ChainBuilder();
    L6:
        return this.requestChainBuilder;
    }

    private ChainBuilder<HttpResponseInterceptor> getResponseChainBuilder() {
        if (this.responseChainBuilder != null) goto L6;
        this.responseChainBuilder = new ChainBuilder();
    L6:
        return this.responseChainBuilder;
    }

    public HttpProcessorBuilder add(HttpRequestInterceptor r10) {
        return addLast(r10);
    }

    public HttpProcessorBuilder addAll(HttpRequestInterceptor... r10) {
        return addAllLast(r10);
    }

    public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addAllFirst(r10);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addAllLast(r10);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpRequestInterceptor r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addFirst(r10);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpRequestInterceptor r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addLast(r10);
        return this;
    }

    public HttpProcessor build() {
        ChainBuilder<HttpRequestInterceptor> r10 = this.requestChainBuilder;
        LinkedList<HttpResponseInterceptor> r11 = null;
        if (r10 == null) goto L5;
        LinkedList<HttpRequestInterceptor> r12 = r10.build();
    L6:
        ChainBuilder<HttpResponseInterceptor> r13 = this.responseChainBuilder;
        if (r13 == null) goto L10;
        r11 = r13.build();
    L10:
        return new ImmutableHttpProcessor(r12, r11);
    L5:
        r12 = null;
        goto L6
    }

    public HttpProcessorBuilder add(HttpResponseInterceptor r10) {
        return addLast(r10);
    }

    public HttpProcessorBuilder addAll(HttpResponseInterceptor... r10) {
        return addAllLast(r10);
    }

    public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addAllFirst(r10);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addAllLast(r10);
        return this;
    }

    public HttpProcessorBuilder addFirst(HttpResponseInterceptor r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addFirst(r10);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpResponseInterceptor r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addLast(r10);
        return this;
    }
}
