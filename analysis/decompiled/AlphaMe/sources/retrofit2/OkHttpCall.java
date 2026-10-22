package retrofit2;

import f1.AbstractC0557a;
import h3.InterfaceC0601j;
import h3.InterfaceC0602k;
import h3.InterfaceC0603l;
import h3.M;
import h3.S;
import h3.V;
import h3.a0;
import h3.b0;
import h3.f0;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import k3.C0683E;
import k3.C0694i;
import k3.InterfaceC0696k;
import k3.o;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes2.dex */
final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final InterfaceC0601j callFactory;
    private volatile boolean canceled;

    @GuardedBy("this")
    @Nullable
    private Throwable creationFailure;

    @GuardedBy("this")
    private boolean executed;

    @GuardedBy("this")
    @Nullable
    private InterfaceC0602k rawCall;
    private final RequestFactory requestFactory;
    private final Converter<f0, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends f0 {
        private final f0 delegate;
        private final InterfaceC0696k delegateSource;

        @Nullable
        IOException thrownException;

        public ExceptionCatchingResponseBody(f0 f0Var) {
            this.delegate = f0Var;
            this.delegateSource = AbstractC0557a.h(new o(f0Var.getSource()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // k3.o, k3.InterfaceC0680B
                public long read(C0694i c0694i, long j4) throws IOException {
                    try {
                        return super.read(c0694i, j4);
                    } catch (IOException e4) {
                        ExceptionCatchingResponseBody.this.thrownException = e4;
                        throw e4;
                    }
                }
            });
        }

        @Override // h3.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.delegate.close();
        }

        @Override // h3.f0
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.delegate.getContentLength();
        }

        @Override // h3.f0
        public M contentType() {
            return this.delegate.contentType();
        }

        @Override // h3.f0
        /* renamed from: source */
        public InterfaceC0696k getSource() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends f0 {
        private final long contentLength;

        @Nullable
        private final M contentType;

        public NoContentResponseBody(@Nullable M m4, long j4) {
            this.contentType = m4;
            this.contentLength = j4;
        }

        @Override // h3.f0
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.contentLength;
        }

        @Override // h3.f0
        public M contentType() {
            return this.contentType;
        }

        @Override // h3.f0
        /* renamed from: source */
        public InterfaceC0696k getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, InterfaceC0601j interfaceC0601j, Converter<f0, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = interfaceC0601j;
        this.responseConverter = converter;
    }

    private InterfaceC0602k createRawCall() throws IOException {
        InterfaceC0601j interfaceC0601j = this.callFactory;
        V request = this.requestFactory.create(this.args);
        S s4 = (S) interfaceC0601j;
        s4.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(s4, request, false);
    }

    @GuardedBy("this")
    private InterfaceC0602k getRawCall() throws IOException {
        InterfaceC0602k interfaceC0602k = this.rawCall;
        if (interfaceC0602k != null) {
            return interfaceC0602k;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            InterfaceC0602k interfaceC0602kCreateRawCall = createRawCall();
            this.rawCall = interfaceC0602kCreateRawCall;
            return interfaceC0602kCreateRawCall;
        } catch (IOException | Error | RuntimeException e4) {
            Utils.throwIfFatal(e4);
            this.creationFailure = e4;
            throw e4;
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        InterfaceC0602k interfaceC0602k;
        this.canceled = true;
        synchronized (this) {
            interfaceC0602k = this.rawCall;
        }
        if (interfaceC0602k != null) {
            interfaceC0602k.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        InterfaceC0602k interfaceC0602k;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                interfaceC0602k = this.rawCall;
                th = this.creationFailure;
                if (interfaceC0602k == null && th == null) {
                    try {
                        InterfaceC0602k interfaceC0602kCreateRawCall = createRawCall();
                        this.rawCall = interfaceC0602kCreateRawCall;
                        interfaceC0602k = interfaceC0602kCreateRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            interfaceC0602k.cancel();
        }
        interfaceC0602k.enqueue(new InterfaceC0603l() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th4) {
                try {
                    callback.onFailure(OkHttpCall.this, th4);
                } catch (Throwable th5) {
                    Utils.throwIfFatal(th5);
                    th5.printStackTrace();
                }
            }

            @Override // h3.InterfaceC0603l
            public void onFailure(InterfaceC0602k interfaceC0602k2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // h3.InterfaceC0603l
            public void onResponse(InterfaceC0602k interfaceC0602k2, b0 b0Var) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(b0Var));
                    } catch (Throwable th4) {
                        Utils.throwIfFatal(th4);
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    Utils.throwIfFatal(th5);
                    callFailure(th5);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        InterfaceC0602k rawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            rawCall = getRawCall();
        }
        if (this.canceled) {
            rawCall.cancel();
        }
        return parseResponse(rawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z4 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            try {
                InterfaceC0602k interfaceC0602k = this.rawCall;
                if (interfaceC0602k == null || !interfaceC0602k.getCanceled()) {
                    z4 = false;
                }
            } finally {
            }
        }
        return z4;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(b0 b0Var) throws IOException {
        f0 f0Var = b0Var.f12870g;
        a0 a0VarE = b0Var.e();
        a0VarE.f12856g = new NoContentResponseBody(f0Var.contentType(), f0Var.getContentLength());
        b0 b0VarA = a0VarE.a();
        int i4 = b0VarA.f12867d;
        if (i4 < 200 || i4 >= 300) {
            try {
                return Response.error(Utils.buffer(f0Var), b0VarA);
            } finally {
                f0Var.close();
            }
        }
        if (i4 == 204 || i4 == 205) {
            f0Var.close();
            return Response.success((Object) null, b0VarA);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(f0Var);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), b0VarA);
        } catch (RuntimeException e4) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e4;
        }
    }

    @Override // retrofit2.Call
    public synchronized V request() {
        try {
        } catch (IOException e4) {
            throw new RuntimeException("Unable to create request.", e4);
        }
        return getRawCall().request();
    }

    @Override // retrofit2.Call
    public synchronized C0683E timeout() {
        try {
        } catch (IOException e4) {
            throw new RuntimeException("Unable to create call.", e4);
        }
        return getRawCall().timeout();
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
