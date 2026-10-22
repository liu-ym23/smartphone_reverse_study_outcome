package retrofit2;

import fg.j;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f24027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f24028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f24029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public okhttp3.Call f24030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f24031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24032f;

    public class a implements okhttp3.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f24033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f24034b;

        public a(d r10, Callback r11) {
            this.f24034b = r10;
            this.f24033a = r11;
        }

        public final void a(Throwable r10) {
            this.f24033a.onFailure(this.f24034b, r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        public final void b(Response r10) {
            this.f24033a.onResponse(this.f24034b, r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call r10, IOException r11) {
            this.f24033a.onFailure(this.f24034b, r11);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call r10, okhttp3.Response r11) {
            b(this.f24034b.c(r11));
            return;
        L5:
            th = move-exception;
            a(th);
        }
    }

    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f24035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IOException f24036b;

        public class a extends fg.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f24037a;

            public a(b r10, Source r11) {
                this.f24037a = r10;
                super(r11);
            }

            @Override // fg.f, okio.Source
            public long read(Buffer r10, long r11) {
                return super.read(r10, r11);
            L4:
                e = move-exception;
                this.f24037a.f24036b = e;
                throw e;
            }
        }

        public b(ResponseBody r10) {
            this.f24035a = r10;
        }

        public void b() {
            IOException r10 = this.f24036b;
            if (r10 != null) goto L5;
            return;
        L5:
            throw r10;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f24035a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f24035a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f24035a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return j.d(new a(this, this.f24035a.source()));
        }
    }

    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaType f24038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f24039b;

        public c(MediaType r10, long r11) {
            this.f24038a = r10;
            this.f24039b = r11;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f24039b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f24038a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public d(h r10, Object[] r11) {
        this.f24027a = r10;
        this.f24028b = r11;
    }

    public d a() {
        return new d(this.f24027a, this.f24028b);
    }

    public final okhttp3.Call b() {
        Request r10 = this.f24027a.c(this.f24028b);
        okhttp3.Call r11 = this.f24027a.f24083a.newCall(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new NullPointerException("Call.Factory returned null.");
    }

    public Response c(okhttp3.Response r10) {
        ResponseBody r11 = r10.a();
        okhttp3.Response r12 = r10.n().b(new c(r11.contentType(), r11.contentLength())).c();
        int r13 = r12.d();
        if (r13 >= 200) goto L5;
    L28:
        Response r14 = Response.c(i.a(r11), r12);     // Catch: Throwable -> L23
        r11.close();
        return r14;
    L23:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        if (r13 >= 300) goto L28;
        if (r13 != 204) goto L10;
    L18:
        r11.close();
        return Response.i(null, r12);
    L10:
        if (r13 == 205) goto L18;
        b r15 = new b(r11);
        return Response.i(this.f24027a.d(r15), r12);
    L15:
        e = move-exception;
        r15.b();
        throw e;
    }

    @Override // retrofit2.Call
    public void cancel() {
        this.f24029c = true;
        monitor-enter(this);
        okhttp3.Call r10 = this.f24030d;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r10 == null) goto L14;
        r10.cancel();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    @Override // retrofit2.Call
    public void enqueue(Callback r10) {
        i.b(r10, "callback == null");
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f24032f == true) goto L25;
        this.f24032f = true;     // Catch: Throwable -> L13
        okhttp3.Call r11 = this.f24030d;     // Catch: Throwable -> L13
        Throwable th = this.f24031e;     // Catch: Throwable -> L13
        if (r11 != null) goto L15;
        if (th != null) goto L15;
        okhttp3.Call r12 = b();     // Catch: Throwable -> L11
        this.f24030d = r12;     // Catch: Throwable -> L11
        r11 = r12;
        goto L15
    L11:
        th = th;
        this.f24031e = th;     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (th == null) goto L20;
        r10.onFailure(this, th);
        return;
    L20:
        if (this.f24029c == false) goto L22;
        r11.cancel();
    L22:
        r11.enqueue(new a(this, r10));
        return;
    L25:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L13
    }

    @Override // retrofit2.Call
    public Response execute() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f24032f == true) goto L29;
        this.f24032f = true;     // Catch: Throwable -> L11
        Throwable r10 = this.f24031e;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        okhttp3.Call r11 = this.f24030d;     // Catch: Throwable -> L11
        if (r11 == null) goto L33;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (this.f24029c == false) goto L27;
        r11.cancel();
    L27:
        return c(r11.execute());
    L33:
        r11 = b();     // Catch: Throwable -> L11 Throwable -> L19
        this.f24030d = r11;     // Catch: Throwable -> L11 Throwable -> L19
    L19:
        e = move-exception;
        this.f24031e = e;     // Catch: Throwable -> L11
        throw e;     // Catch: Throwable -> L11
    L8:
        if ((r10 instanceof IOException) == false) goto L14;
        throw ((IOException) r10);     // Catch: Throwable -> L11
    L14:
        throw ((RuntimeException) r10);     // Catch: Throwable -> L11
    L29:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L11
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean r10 = true;
        if (this.f24029c == false) goto L5;
        return true;
    L5:
        monitor-enter(this);
        okhttp3.Call r11 = this.f24030d;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
    L13:
        r10 = false;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r10;
    L9:
        if (r11.isCanceled() == false) goto L13;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r10 = this.f24032f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    public synchronized Request request() {
        monitor-enter(this);
        okhttp3.Call r10 = this.f24030d;     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        Request r11 = r10.request();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        Throwable r12 = this.f24031e;     // Catch: Throwable -> L8
        if (r12 != null) goto L13;
        okhttp3.Call r13 = b();     // Catch: Throwable -> L8 IOException -> L21 RuntimeException -> L23
        this.f24030d = r13;     // Catch: Throwable -> L8 IOException -> L21 RuntimeException -> L23
        Request r14 = r13.request();     // Catch: Throwable -> L8 IOException -> L21 RuntimeException -> L23
        monitor-exit(this);
        return r14;
    L21:
        e = move-exception;
        this.f24031e = e;     // Catch: Throwable -> L8
        throw new RuntimeException("Unable to create request.", e);     // Catch: Throwable -> L8
    L23:
        e = move-exception;
        this.f24031e = e;     // Catch: Throwable -> L8
        throw e;     // Catch: Throwable -> L8
    L13:
        if ((r12 instanceof IOException) == false) goto L17;
        throw new RuntimeException("Unable to create request.", this.f24031e);     // Catch: Throwable -> L8
    L17:
        throw ((RuntimeException) r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Call mo73clone() {
        return a();
    }
}
