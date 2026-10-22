package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f23003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RetryAndFollowUpInterceptor f23004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EventListener f23005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Request f23006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f23007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23008f;

    public final class a extends NamedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Callback f23009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f23010b;

        public a(j r10, Callback r11) {
            this.f23010b = r10;
            super("OkHttp %s", new Object[]{r10.f()});
            this.f23009a = r11;
        }

        public j a() {
            return this.f23010b;
        }

        public String b() {
            return this.f23010b.f23006d.k().m();
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Response r10 = this.f23010b.d();     // Catch: Throwable -> L11
            boolean r11 = true;
            if (this.f23010b.f23004b.isCanceled() == false) goto L9;
            this.f23009a.onFailure(this.f23010b, new IOException("Canceled"));     // Catch: Throwable -> L7
        L27:
        L10:
            this.f23010b.f23003a.g().e(this);
            return;
        L9:
            this.f23009a.onResponse(this.f23010b, r10);     // Catch: Throwable -> L7
        L7:
            IOException th = th;
        L26:
        L16:
            th = move-exception;
            this.f23010b.f23003a.g().e(this);
            throw th;
        L14:
            if ((th instanceof IOException) == false) goto L18;
            IOException r12 = th;     // Catch: Throwable -> L16
        L19:
            if (r11 == false) goto L21;
            Platform.get().log(4, "Callback failure for " + this.f23010b.g(), r12);     // Catch: Throwable -> L16
            goto L10
        L21:
            j.a(this.f23010b).callFailed(this.f23010b, r12);     // Catch: Throwable -> L16
            this.f23009a.onFailure(this.f23010b, r12);     // Catch: Throwable -> L16
            goto L10
        L18:
            r12 = new IOException(th);     // Catch: Throwable -> L16
        L11:
            th = move-exception;
            r11 = false;
            th = th;
            goto L26
        }
    }

    public j(OkHttpClient r10, Request r11, boolean r12) {
        this.f23003a = r10;
        this.f23006d = r11;
        this.f23007e = r12;
        this.f23004b = new RetryAndFollowUpInterceptor(r10, r12);
    }

    public static /* synthetic */ EventListener a(j r10) {
        return r10.f23005c;
    }

    public static j e(OkHttpClient r10, Request r11, boolean r12) {
        j r13 = new j(r10, r11, r12);
        r13.f23005c = r10.i().create(r13);
        return r13;
    }

    public final void b() {
        Object r10 = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.f23004b.setCallStackTrace(r10);
    }

    public j c() {
        return e(this.f23003a, this.f23006d, this.f23007e);
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.f23004b.cancel();
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return c();
    }

    public Response d() {
        ArrayList r10 = new ArrayList();
        r10.addAll(this.f23003a.m());
        r10.add(this.f23004b);
        r10.add(new BridgeInterceptor(this.f23003a.f()));
        r10.add(new CacheInterceptor(this.f23003a.n()));
        r10.add(new ConnectInterceptor(this.f23003a));
        if (this.f23007e == true) goto L5;
        r10.addAll(this.f23003a.o());
    L5:
        r10.add(new CallServerInterceptor(this.f23007e));
        return new RealInterceptorChain(r10, null, null, null, 0, this.f23006d, this, this.f23005c, this.f23003a.c(), this.f23003a.v(), this.f23003a.B()).proceed(this.f23006d);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f23008f == true) goto L12;
        this.f23008f = true;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        b();
        this.f23005c.callStart(this);
        this.f23003a.g().a(new a(this, r10));
        return;
    L12:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L9
    }

    @Override // okhttp3.Call
    public Response execute() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f23008f == true) goto L24;
        this.f23008f = true;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        b();
        this.f23005c.callStart(this);
        this.f23003a.g().b(this);     // Catch: Throwable -> L14 IOException -> L16
        Response r10 = d();     // Catch: Throwable -> L14 IOException -> L16
        if (r10 == null) goto L13;
        this.f23003a.g().f(this);
        return r10;
    L13:
        throw new IOException("Canceled");     // Catch: Throwable -> L14 IOException -> L16
    L14:
        th = move-exception;
        this.f23003a.g().f(this);
        throw th;
    L16:
        e = move-exception;
        this.f23005c.callFailed(this, e);     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L24:
        throw new IllegalStateException("Already Executed");     // Catch: Throwable -> L21
    }

    public String f() {
        return this.f23006d.k().E();
    }

    public String g() {
        StringBuilder r10 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r11 = "canceled ";
    L6:
        r10.append(r11);
        if (this.f23007e == false) goto L9;
        String r12 = "web socket";
    L10:
        r10.append(r12);
        r10.append(" to ");
        r10.append(f());
        return r10.toString();
    L9:
        r12 = "call";
        goto L10
    L5:
        r11 = "";
        goto L6
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.f23004b.isCanceled();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r10 = this.f23008f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.f23006d;
    }

    @Override // okhttp3.Call
    public StreamAllocation streamAllocation() {
        return this.f23004b.streamAllocation();
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Call mo57clone() {
        return c();
    }
}
