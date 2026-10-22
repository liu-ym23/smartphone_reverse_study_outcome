package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okhttp3.ttnet.TTOkHttpConstants;
import okio.AsyncTimeout;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class RealCall implements Call {
    final OkHttpClient client;

    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout;

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        static {
        }

        AsyncCall(RealCall r3, Callback r4) {
            this.this$0 = r3;
            super("OkHttp %s", new Object[]{r3.redactedUrl()});
            this.responseCallback = r4;
        }

        String host() {
            return this.this$0.originalRequest.url().host();
        }

        Request request() {
            return this.this$0.originalRequest;
        }

        RealCall get() {
            return this.this$0;
        }

        void executeOn(ExecutorService r3) {
            r3.execute(this);     // Catch: Throwable -> L4 RejectedExecutionException -> L6
        L12:
            return;
        L4:
            th = move-exception;
            this.this$0.client.dispatcher().finished(this);
            throw th;
        L6:
            e = move-exception;
            InterruptedIOException r0 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L4
            r0.initCause(e);     // Catch: Throwable -> L4
            RealCall.access$000(this.this$0).callFailed(this.this$0, r0);     // Catch: Throwable -> L4
            this.responseCallback.onFailure(this.this$0, r0);     // Catch: Throwable -> L4
            this.this$0.client.dispatcher().finished(this);
            goto L12
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            this.this$0.timeout.enter();
            boolean r2 = false;
        L27:
            this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain());     // Catch: Throwable -> L7 IOException -> L9
        L6:
            this.this$0.client.dispatcher().finished(this);
            return;
        L9:
            e = e;
            r2 = true;
        L17:
            IOException r0 = this.this$0.timeoutExit(e);     // Catch: Throwable -> L23
            if (r2 == false) goto L20;
            Platform.get().log(4, "Callback failure for " + this.this$0.toLoggableString(), r0);     // Catch: Throwable -> L23
            goto L6
        L20:
            RealCall.access$000(this.this$0).callFailed(this.this$0, r0);     // Catch: Throwable -> L23
            this.responseCallback.onFailure(this.this$0, r0);     // Catch: Throwable -> L23
        L7:
            th = th;
            r2 = true;
        L12:
            this.this$0.cancel();     // Catch: Throwable -> L23
            if (r2 == true) goto L15;
            this.responseCallback.onFailure(this.this$0, new IOException("canceled due to " + th));     // Catch: Throwable -> L23
        L15:
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            this.this$0.client.dispatcher().finished(this);
            throw th;
        L16:
            e = e;
        L11:
            th = th;
            goto L12
        }
    }

    static /* synthetic */ EventListener access$000(RealCall r0) {
        return r0.eventListener;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // okhttp3.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    private RealCall(OkHttpClient r1, Request r2, boolean r3) {
        this.client = r1;
        this.originalRequest = r2;
        this.forWebSocket = r3;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(r1, r3);
        AsyncTimeout r4 = new AnonymousClass1(this);
        this.timeout = r4;
        r4.timeout(r1.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient r1, Request r2, boolean r3) {
        RealCall r0 = new RealCall(r1, r2, r3);
        r0.eventListener = r1.eventListenerFactory().create(r0);
        return r0;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.executed == true) goto L22;
        this.executed = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        this.client.dispatcher().executed(this);     // Catch: Throwable -> L14 IOException -> L16
        Response r0 = getResponseWithInterceptorChain();     // Catch: Throwable -> L14 IOException -> L16
        if (r0 == null) goto L13;
        this.client.dispatcher().finished(this);
        return r0;
    L13:
        throw new IOException("Canceled");     // Catch: Throwable -> L14 IOException -> L16
    L16:
        e = move-exception;
        IOException r1 = timeoutExit(e);     // Catch: Throwable -> L14
        this.eventListener.callFailed(this, r1);     // Catch: Throwable -> L14
        throw r1;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.client.dispatcher().finished(this);
        throw th;
    L22:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L23
    }

    @Nullable
    IOException timeoutExit(@Nullable IOException r2) {
        if (this.timeout.exit() == true) goto L5;
        return r2;
    L5:
        InterruptedIOException r1 = new InterruptedIOException("timeout");
        if (r2 == null) goto L8;
        r1.initCause(r2);
    L8:
        return r1;
    }

    private void captureCallStackTrace() {
        Object r0 = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.retryAndFollowUpInterceptor.setCallStackTrace(r0);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.executed == true) goto L10;
        this.executed = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(this, r3));
        return;
    L10:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L11
    }

    @Override // okhttp3.Call
    public void cancel() {
        cancelWithError(TTOkHttpConstants.ERR_TTNET_UNKNOWN);
    }

    public void cancelWithError(int r1) {
        this.retryAndFollowUpInterceptor.cancel(r1);
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r0 = this.executed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    String toLoggableString() {
        StringBuilder r0 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r1 = "canceled ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.forWebSocket == false) goto L9;
        String r3 = "web socket";
    L11:
        return r2.append(r3).append(" to ").append(redactedUrl()).toString();
    L9:
        r3 = "call";
        goto L11
    L5:
        r1 = "";
        goto L6
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    Response getResponseWithInterceptorChain() throws IOException {
        ArrayList r1 = new ArrayList();
        r1.addAll(this.client.interceptors());
        r1.add(this.retryAndFollowUpInterceptor);
        r1.add(new BridgeInterceptor(this.client.cookieJar()));
        r1.add(new CacheInterceptor(this.client.internalCache()));
        r1.add(new ConnectInterceptor(this.client));
        if (this.forWebSocket == true) goto L5;
        r1.addAll(this.client.networkInterceptors());
    L5:
        r1.add(new CallServerInterceptor(this.forWebSocket));
        Response r0 = new RealInterceptorChain(r1, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (this.retryAndFollowUpInterceptor.isCanceled() == true) goto L8;
        return r0;
    L8:
        Util.closeQuietly(r0);
        throw new IOException("Canceled#Reason=" + this.retryAndFollowUpInterceptor.canceledReason());
    }
}
