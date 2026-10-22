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

/* JADX INFO: loaded from: classes4.dex */
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

    public RealInterceptorChain(List<Interceptor> r10, StreamAllocation r11, HttpCodec r12, RealConnection r13, int r14, Request r15, Call r16, EventListener r17, int r18, int r19, int r110) {
        this.interceptors = r10;
        this.connection = r13;
        this.streamAllocation = r11;
        this.httpCodec = r12;
        this.index = r14;
        this.request = r15;
        this.call = r16;
        this.eventListener = r17;
        this.connectTimeout = r18;
        this.readTimeout = r19;
        this.writeTimeout = r110;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        return this.connection;
    }

    public EventListener eventListener() {
        return this.eventListener;
    }

    public HttpCodec httpStream() {
        return this.httpCodec;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request r10) throws IOException {
        return proceed(r10, this.streamAllocation, this.httpCodec, this.connection);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int r17, TimeUnit r18) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, Util.checkDuration("timeout", r17, r18), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int r17, TimeUnit r18) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, Util.checkDuration("timeout", r17, r18), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int r17, TimeUnit r18) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", r17, r18));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public Response proceed(Request r18, StreamAllocation r19, HttpCodec r20, RealConnection r21) throws IOException {
        if (this.index >= this.interceptors.size()) goto L37;
        this.calls++;
        if (this.httpCodec == null) goto L12;
        if (this.connection.supportsUrl(r18.k()) == true) goto L12;
        throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
    L12:
        if (this.httpCodec != null) goto L14;
    L18:
        RealInterceptorChain r10 = new RealInterceptorChain(this.interceptors, r19, r20, r21, this.index + 1, r18, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
        Interceptor r11 = this.interceptors.get(this.index);
        Response r12 = r11.intercept(r10);
        if (r20 == null) goto L28;
        if ((this.index + 1) >= this.interceptors.size()) goto L28;
        if (r10.calls == 1) goto L28;
        throw new IllegalStateException("network interceptor " + r11 + " must call proceed() exactly once");
    L28:
        if (r12 == null) goto L35;
        if (r12.a() == null) goto L33;
        return r12;
    L33:
        throw new IllegalStateException("interceptor " + r11 + " returned a response with no body");
    L35:
        throw new NullPointerException("interceptor " + r11 + " returned null");
    L14:
        if (this.calls <= 1) goto L18;
        throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
    L37:
        throw new AssertionError();
    }
}
