package okhttp3.internal.connection;

import androidx.core.app.f;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import h3.B;
import h3.C0592a;
import h3.C0605n;
import h3.C0614x;
import h3.InterfaceC0602k;
import h3.InterfaceC0603l;
import h3.J;
import h3.S;
import h3.V;
import h3.b0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import k3.C0690e;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001^\u0018\u00002\u00020\u0001:\u0002z{B\u001f\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010P\u001a\u00020\u0007\u0012\u0006\u0010S\u001a\u00020\r¢\u0006\u0004\bx\u0010yJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0018\u0010\u0012J\u001d\u0010\u001b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b \u0010!J\u0015\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J;\u0010/\u001a\u00028\u0000\"\n\b\u0000\u0010(*\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00028\u0000H\u0000¢\u0006\u0004\b-\u0010.J\u001b\u00102\u001a\u0004\u0018\u00010'2\b\u0010,\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0004\b0\u00101J\u0011\u00106\u001a\u0004\u0018\u000103H\u0000¢\u0006\u0004\b4\u00105J\r\u00107\u001a\u00020\n¢\u0006\u0004\b7\u0010\fJ\u0017\u0010;\u001a\u00020\n2\u0006\u00108\u001a\u00020\rH\u0000¢\u0006\u0004\b9\u0010:J\r\u0010<\u001a\u00020\r¢\u0006\u0004\b<\u0010\u000fJ\u000f\u0010@\u001a\u00020=H\u0000¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020\nH\u0002¢\u0006\u0004\bA\u0010\fJ#\u0010B\u001a\u00028\u0000\"\n\b\u0000\u0010(*\u0004\u0018\u00010'2\u0006\u0010,\u001a\u00028\u0000H\u0002¢\u0006\u0004\bB\u00101J#\u0010D\u001a\u00028\u0000\"\n\b\u0000\u0010(*\u0004\u0018\u00010'2\u0006\u0010C\u001a\u00028\u0000H\u0002¢\u0006\u0004\bD\u00101J\u0017\u0010H\u001a\u00020G2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020=H\u0002¢\u0006\u0004\bJ\u0010?R\u0017\u0010L\u001a\u00020K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010P\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\tR\u0017\u0010S\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u000fR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Z\u001a\u00020Y8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010\u0003\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010i\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010j\u001a\u0004\bk\u0010lR\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010TR(\u0010m\u001a\u0004\u0018\u00010\u001f2\b\u0010i\u001a\u0004\u0018\u00010\u001f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010TR\u0016\u0010r\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010TR\u0016\u0010s\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010TR\u0016\u0010t\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010TR\u0018\u0010)\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010nR$\u0010u\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010j\u001a\u0004\bv\u0010l\"\u0004\bw\u0010&¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lh3/k;", "Lk3/e;", "timeout", "()Lk3/e;", "clone", "()Lokhttp3/internal/connection/RealCall;", "Lh3/V;", "request", "()Lh3/V;", "", "cancel", "()V", "", "isCanceled", "()Z", "Lh3/b0;", "execute", "()Lh3/b0;", "Lh3/l;", "responseCallback", "enqueue", "(Lh3/l;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lh3/V;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "exchange", "requestDone", "responseDone", "e", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "(Ljava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "", "redactedUrl$okhttp", "()Ljava/lang/String;", "redactedUrl", "callStart", "callDone", "cause", "timeoutExit", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "Lh3/a;", "createAddress", "(Lh3/J;)Lh3/a;", "toLoggableString", "Lh3/S;", "client", "Lh3/S;", "getClient", "()Lh3/S;", "originalRequest", "Lh3/V;", "getOriginalRequest", "forWebSocket", "Z", "getForWebSocket", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "Lh3/B;", "eventListener", "Lh3/B;", "getEventListener$okhttp", "()Lh3/B;", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "callStackTrace", "Ljava/lang/Object;", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "interceptorScopedExchange", "Lokhttp3/internal/connection/Exchange;", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "<init>", "(Lh3/S;Lh3/V;Z)V", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class RealCall implements InterfaceC0602k {

    @Nullable
    private Object callStackTrace;
    private volatile boolean canceled;

    @NotNull
    private final S client;

    @Nullable
    private RealConnection connection;

    @NotNull
    private final RealConnectionPool connectionPool;

    @Nullable
    private volatile RealConnection connectionToCancel;

    @NotNull
    private final B eventListener;

    @Nullable
    private volatile Exchange exchange;

    @Nullable
    private ExchangeFinder exchangeFinder;

    @NotNull
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;

    @Nullable
    private Exchange interceptorScopedExchange;

    @NotNull
    private final V originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;

    @NotNull
    private final AnonymousClass1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010 \u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/RealCall;", "other", "", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Lh3/l;", "responseCallback", "Lh3/l;", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "", "getHost", "()Ljava/lang/String;", "host", "Lh3/V;", "getRequest", "()Lh3/V;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", "call", "<init>", "(Lokhttp3/internal/connection/RealCall;Lh3/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class AsyncCall implements Runnable {

        @NotNull
        private volatile AtomicInteger callsPerHost;

        @NotNull
        private final InterfaceC0603l responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(@NotNull RealCall this$0, InterfaceC0603l responseCallback) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.this$0 = this$0;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(@NotNull ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            C0614x c0614x = this.this$0.getClient().f12787a;
            if (Util.assertionsEnabled && Thread.holdsLock(c0614x)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + c0614x);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e4) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e4);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().f12787a.b(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().f12787a.b(this);
                throw th;
            }
        }

        @NotNull
        /* renamed from: getCall, reason: from getter */
        public final RealCall getThis$0() {
            return this.this$0;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return this.this$0.getOriginalRequest().f12826a.f12725d;
        }

        @NotNull
        public final V getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            Throwable th;
            IOException e4;
            C0614x c0614x;
            String strStringPlus = Intrinsics.stringPlus("OkHttp ", this.this$0.redactedUrl$okhttp());
            RealCall realCall = this.this$0;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strStringPlus);
            try {
                realCall.timeout.enter();
                try {
                    try {
                        z4 = true;
                        try {
                            this.responseCallback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                            c0614x = realCall.getClient().f12787a;
                        } catch (IOException e5) {
                            e4 = e5;
                            if (z4) {
                                Platform.INSTANCE.get().log(Intrinsics.stringPlus("Callback failure for ", realCall.toLoggableString()), 4, e4);
                            } else {
                                this.responseCallback.onFailure(realCall, e4);
                            }
                            c0614x = realCall.getClient().f12787a;
                            c0614x.b(this);
                        } catch (Throwable th2) {
                            th = th2;
                            realCall.cancel();
                            if (!z4) {
                                IOException iOException = new IOException(Intrinsics.stringPlus("canceled due to ", th));
                                ExceptionsKt.addSuppressed(iOException, th);
                                this.responseCallback.onFailure(realCall, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        realCall.getClient().f12787a.b(this);
                        throw th3;
                    }
                } catch (IOException e6) {
                    z4 = false;
                    e4 = e6;
                } catch (Throwable th4) {
                    z4 = false;
                    th = th4;
                }
                c0614x.b(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CallReference extends WeakReference<RealCall> {

        @Nullable
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(@NotNull RealCall referent, @Nullable Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [k3.E, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(@NotNull S client, @NotNull V originalRequest, boolean z4) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z4;
        this.connectionPool = client.f12788b.f12962a;
        this.eventListener = Util.m1510asFactory$lambda8((B) ((f) client.f12791e).f3281a, this);
        ?? r22 = new C0690e() { // from class: okhttp3.internal.connection.RealCall.timeout.1
            @Override // k3.C0690e
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        r22.timeout(getClient().f12810x, TimeUnit.MILLISECONDS);
        this.timeout = r22;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    private final <E extends IOException> E callDone(E e4) throws IOException {
        Socket socketReleaseConnectionNoEvents$okhttp;
        boolean z4 = Util.assertionsEnabled;
        if (z4 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        RealConnection connection = this.connection;
        if (connection != null) {
            if (z4 && Thread.holdsLock(connection)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + connection);
            }
            synchronized (connection) {
                socketReleaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
                this.eventListener.getClass();
                Intrinsics.checkNotNullParameter(this, "call");
                Intrinsics.checkNotNullParameter(connection, "connection");
            } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        E ioe = (E) timeoutExit(e4);
        if (e4 != null) {
            B b4 = this.eventListener;
            Intrinsics.checkNotNull(ioe);
            b4.getClass();
            Intrinsics.checkNotNullParameter(this, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
        } else {
            this.eventListener.getClass();
            Intrinsics.checkNotNullParameter(this, "call");
        }
        return ioe;
    }

    private final void callStart() {
        this.callStackTrace = Platform.INSTANCE.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.getClass();
        Intrinsics.checkNotNullParameter(this, "call");
    }

    private final C0592a createAddress(J url) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        C0605n c0605n;
        if (url.f12731j) {
            S s4 = this.client;
            SSLSocketFactory sSLSocketFactory2 = s4.f12803q;
            if (sSLSocketFactory2 == null) {
                throw new IllegalStateException("CLEARTEXT-only client");
            }
            HostnameVerifier hostnameVerifier2 = s4.f12807u;
            c0605n = s4.f12808v;
            sSLSocketFactory = sSLSocketFactory2;
            hostnameVerifier = hostnameVerifier2;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            c0605n = null;
        }
        S s5 = this.client;
        return new C0592a(url.f12725d, url.f12726e, s5.f12798l, s5.f12802p, sSLSocketFactory, hostnameVerifier, c0605n, s5.f12801o, s5.f12799m, s5.f12806t, s5.f12805s, s5.f12800n);
    }

    private final <E extends IOException> E timeoutExit(E cause) {
        if (this.timeoutEarlyExit || !exit()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(connection)) {
            if (this.connection != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }

    @Override // h3.InterfaceC0602k
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection != null) {
            realConnection.cancel();
        }
        this.eventListener.getClass();
        Intrinsics.checkNotNullParameter(this, "call");
    }

    @Override // h3.InterfaceC0602k
    public void enqueue(@NotNull InterfaceC0603l responseCallback) {
        AsyncCall asyncCall;
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        callStart();
        C0614x c0614x = this.client.f12787a;
        AsyncCall call = new AsyncCall(this, responseCallback);
        c0614x.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (c0614x) {
            try {
                c0614x.f12989b.add(call);
                if (!call.getThis$0().getForWebSocket()) {
                    String host = call.getHost();
                    Iterator it = c0614x.f12990c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator it2 = c0614x.f12989b.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    asyncCall = null;
                                    break;
                                } else {
                                    asyncCall = (AsyncCall) it2.next();
                                    if (Intrinsics.areEqual(asyncCall.getHost(), host)) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            asyncCall = (AsyncCall) it.next();
                            if (Intrinsics.areEqual(asyncCall.getHost(), host)) {
                                break;
                            }
                        }
                    }
                    if (asyncCall != null) {
                        call.reuseCallsPerHostFrom(asyncCall);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        c0614x.c();
    }

    public final void enterNetworkInterceptorExchange(@NotNull V request, boolean newExchangeFinder) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (newExchangeFinder) {
            this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.f12826a), this, this.eventListener);
        }
    }

    @Override // h3.InterfaceC0602k
    @NotNull
    public b0 execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        enter();
        callStart();
        try {
            C0614x c0614x = this.client.f12787a;
            synchronized (c0614x) {
                Intrinsics.checkNotNullParameter(this, "call");
                c0614x.f12991d.add(this);
            }
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            C0614x c0614x2 = this.client.f12787a;
            c0614x2.getClass();
            Intrinsics.checkNotNullParameter(this, "call");
            c0614x2.a(c0614x2.f12991d, this);
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean closeExchange) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (closeExchange && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    @NotNull
    public final S getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @NotNull
    /* renamed from: getEventListener$okhttp, reason: from getter */
    public final B getEventListener() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    /* renamed from: getInterceptorScopedExchange$okhttp, reason: from getter */
    public final Exchange getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final V getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h3.b0 getResponseWithInterceptorChain$okhttp() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            h3.S r0 = r11.client
            java.util.List r0 = r0.f12789c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt.a(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            h3.S r1 = r11.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            h3.S r1 = r11.client
            h3.w r1 = r1.f12796j
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            h3.S r1 = r11.client
            h3.h r1 = r1.f12797k
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r11.forWebSocket
            if (r0 != 0) goto L42
            h3.S r0 = r11.client
            java.util.List r0 = r0.f12790d
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt.a(r2, r0)
        L42:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r11.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            h3.V r5 = r11.originalRequest
            h3.S r0 = r11.client
            int r6 = r0.f12811y
            r3 = 0
            r4 = 0
            int r7 = r0.f12812z
            int r8 = r0.f12783A
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            h3.V r2 = r11.originalRequest     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
            h3.b0 r2 = r9.proceed(r2)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
            boolean r3 = r11.getCanceled()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
            if (r3 != 0) goto L71
            r11.noMoreExchanges$okhttp(r0)
            return r2
        L71:
            okhttp3.internal.Util.closeQuietly(r2)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
            throw r2     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
        L7c:
            r2 = move-exception
            goto L94
        L7e:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r11.noMoreExchanges$okhttp(r1)     // Catch: java.lang.Throwable -> L8e
            if (r1 != 0) goto L93
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L8e
            throw r1     // Catch: java.lang.Throwable -> L8e
        L8e:
            r1 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L94
        L93:
            throw r1     // Catch: java.lang.Throwable -> L8e
        L94:
            if (r1 != 0) goto L99
            r11.noMoreExchanges$okhttp(r0)
        L99:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():h3.b0");
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    @Override // h3.InterfaceC0602k
    /* renamed from: isCanceled, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    public final <E extends IOException> E messageDone$okhttp(@NotNull Exchange exchange, boolean requestDone, boolean responseDone, E e4) {
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!Intrinsics.areEqual(exchange, this.exchange)) {
            return e4;
        }
        synchronized (this) {
            z4 = false;
            if (requestDone) {
                try {
                    if (!this.requestBodyOpen) {
                        if (responseDone || !this.responseBodyOpen) {
                            z5 = false;
                        }
                    }
                    if (requestDone) {
                        this.requestBodyOpen = false;
                    }
                    if (responseDone) {
                        this.responseBodyOpen = false;
                    }
                    boolean z6 = this.requestBodyOpen;
                    boolean z7 = (z6 || this.responseBodyOpen) ? false : true;
                    if (!z6 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                        z4 = true;
                    }
                    z5 = z4;
                    z4 = z7;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (responseDone) {
                }
                z5 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z4) {
            this.exchange = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        return z5 ? (E) callDone(e4) : e4;
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException e4) {
        boolean z4;
        synchronized (this) {
            try {
                z4 = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen) {
                        z4 = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4 ? callDone(e4) : e4;
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.f12826a.h();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().get(), this)) {
                break;
            }
            i4++;
        }
        if (i4 == -1) {
            throw new IllegalStateException("Check failed.".toString());
        }
        calls.remove(i4);
        this.connection = null;
        if (calls.isEmpty()) {
            realConnection.setIdleAtNs$okhttp(System.nanoTime());
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    @Override // h3.InterfaceC0602k
    @NotNull
    public V request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(@Nullable RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!(!this.timeoutEarlyExit)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.timeoutEarlyExit = true;
        exit();
    }

    @Override // h3.InterfaceC0602k
    @NotNull
    public C0690e timeout() {
        return this.timeout;
    }

    @NotNull
    /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public RealCall m1512clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
