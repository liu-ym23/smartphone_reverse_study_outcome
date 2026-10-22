package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes5.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final HttpCodec httpCodec;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final StreamAllocation streamAllocation;
    private final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> r1, StreamAllocation r2, HttpCodec r3, RealConnection r4, int r5, Request r6, Call r7, EventListener r8, int r9, int r10, int r11) {
        this.interceptors = r1;
        this.connection = r4;
        this.streamAllocation = r2;
        this.httpCodec = r3;
        this.index = r5;
        this.request = r6;
        this.call = r7;
        this.eventListener = r8;
        this.connectTimeout = r9;
        this.readTimeout = r10;
        this.writeTimeout = r11;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        return this.connection;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int r17, TimeUnit r18) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, Util.checkDuration("timeout", r17, r18), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int r17, TimeUnit r18) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, Util.checkDuration("timeout", r17, r18), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int r17, TimeUnit r18) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", r17, r18));
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public HttpCodec httpStream() {
        return this.httpCodec;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    public EventListener eventListener() {
        return this.eventListener;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request r4) throws IOException {
        return proceed(r4, this.streamAllocation, this.httpCodec, this.connection);
    }

    public Response proceed(Request r18, StreamAllocation r19, HttpCodec r20, RealConnection r21) throws IOException {
        if (this.index >= this.interceptors.size()) goto L37;
        this.calls++;
        if (this.httpCodec == null) goto L12;
        if (this.connection.supportsUrl(r18.url()) == true) goto L12;
        throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
    L12:
        if (this.httpCodec != null) goto L14;
    L18:
        RealInterceptorChain r1 = new RealInterceptorChain(this.interceptors, r19, r20, r21, this.index + 1, r18, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
        Interceptor r5 = this.interceptors.get(this.index);
        Response r6 = r5.intercept(r1);
        if (r20 == null) goto L28;
        if ((this.index + 1) >= this.interceptors.size()) goto L28;
        if (r1.calls == 1) goto L28;
        throw new IllegalStateException("network interceptor " + r5 + " must call proceed() exactly once");
    L28:
        if (r6 == null) goto L35;
        if (r6.body() == null) goto L33;
        return r6;
    L33:
        throw new IllegalStateException("interceptor " + r5 + " returned a response with no body");
    L35:
        throw new NullPointerException("interceptor " + r5 + " returned null");
    L14:
        if (this.calls <= 1) goto L18;
        throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
    L37:
        throw new AssertionError();
    }
}
