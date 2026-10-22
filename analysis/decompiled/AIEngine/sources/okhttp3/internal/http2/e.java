package okhttp3.internal.http2;

import bd.l;
import com.stepos.core.ability.speech.TtsCloudWsSession;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.jvm.internal.g;
import lb.n;
import sd.c0;
import sd.e0;
import sd.f0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f11225a;

    /* renamed from: b, reason: collision with root package name */
    public final Http2Connection f11226b;

    /* renamed from: c, reason: collision with root package name */
    public final id.a f11227c;

    /* renamed from: d, reason: collision with root package name */
    public long f11228d;

    /* renamed from: e, reason: collision with root package name */
    public long f11229e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque<okhttp3.f> f11230f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11231g;
    public final b h;

    /* renamed from: i, reason: collision with root package name */
    public final a f11232i;

    /* renamed from: j, reason: collision with root package name */
    public final c f11233j;

    /* renamed from: k, reason: collision with root package name */
    public final c f11234k;

    /* renamed from: l, reason: collision with root package name */
    public ErrorCode f11235l;

    /* renamed from: m, reason: collision with root package name */
    public IOException f11236m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a implements c0 {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f11237a;

        /* renamed from: b, reason: collision with root package name */
        public final sd.e f11238b = new sd.e();

        /* renamed from: c, reason: collision with root package name */
        public boolean f11239c;

        public a(boolean z) {
            this.f11237a = z;
        }

        /* JADX WARN: Finally extract failed */
        public final void a(boolean z) throws SocketTimeoutException {
            long jMin;
            boolean z3;
            e eVar = e.this;
            synchronized (eVar) {
                try {
                    eVar.f11234k.i();
                    while (eVar.f11228d >= eVar.f11229e && !this.f11237a && !this.f11239c) {
                        try {
                            synchronized (eVar) {
                                ErrorCode errorCode = eVar.f11235l;
                                if (errorCode != null) {
                                    break;
                                }
                                try {
                                    eVar.wait();
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    throw new InterruptedIOException();
                                }
                            }
                        } catch (Throwable th) {
                            eVar.f11234k.l();
                            throw th;
                        }
                    }
                    eVar.f11234k.l();
                    eVar.b();
                    jMin = Math.min(eVar.f11229e - eVar.f11228d, this.f11238b.f11926b);
                    eVar.f11228d += jMin;
                    z3 = z && jMin == this.f11238b.f11926b;
                    n nVar = n.f10413a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            e.this.f11234k.i();
            try {
                e eVar2 = e.this;
                eVar2.f11226b.Q(eVar2.f11225a, z3, this.f11238b, jMin);
            } finally {
                e.this.f11234k.l();
            }
        }

        @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws SocketTimeoutException {
            boolean z;
            e eVar = e.this;
            okhttp3.f fVar = l.f3237a;
            synchronized (eVar) {
                if (this.f11239c) {
                    return;
                }
                synchronized (eVar) {
                    z = eVar.f11235l == null;
                    n nVar = n.f10413a;
                }
                e eVar2 = e.this;
                if (!eVar2.f11232i.f11237a) {
                    if (this.f11238b.f11926b > 0) {
                        while (this.f11238b.f11926b > 0) {
                            a(true);
                        }
                    } else if (z) {
                        eVar2.f11226b.Q(eVar2.f11225a, true, null, 0L);
                    }
                }
                e eVar3 = e.this;
                synchronized (eVar3) {
                    this.f11239c = true;
                    eVar3.notifyAll();
                    n nVar2 = n.f10413a;
                }
                e.this.f11226b.flush();
                e.this.a();
            }
        }

        @Override // sd.c0, java.io.Flushable
        public final void flush() throws SocketTimeoutException {
            e eVar = e.this;
            okhttp3.f fVar = l.f3237a;
            synchronized (eVar) {
                eVar.b();
                n nVar = n.f10413a;
            }
            while (this.f11238b.f11926b > 0) {
                a(false);
                e.this.f11226b.flush();
            }
        }

        @Override // sd.c0
        public final void j0(sd.e source, long j10) throws SocketTimeoutException {
            g.f(source, "source");
            okhttp3.f fVar = l.f3237a;
            sd.e eVar = this.f11238b;
            eVar.j0(source, j10);
            while (eVar.f11926b >= TtsCloudWsSession.UPLINK_QUEUE_WARN_BYTES) {
                a(false);
            }
        }

        @Override // sd.c0
        public final f0 timeout() {
            return e.this.f11234k;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public final long f11241a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11242b;

        /* renamed from: c, reason: collision with root package name */
        public final sd.e f11243c = new sd.e();

        /* renamed from: d, reason: collision with root package name */
        public final sd.e f11244d = new sd.e();

        /* renamed from: e, reason: collision with root package name */
        public okhttp3.f f11245e;
        public boolean h;

        public b(long j10, boolean z) {
            this.f11241a = j10;
            this.f11242b = z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long j10;
            e eVar = e.this;
            synchronized (eVar) {
                this.h = true;
                sd.e eVar2 = this.f11244d;
                j10 = eVar2.f11926b;
                eVar2.o();
                eVar.notifyAll();
                n nVar = n.f10413a;
            }
            if (j10 > 0) {
                e eVar3 = e.this;
                okhttp3.f fVar = l.f3237a;
                eVar3.f11226b.P(j10);
            }
            e.this.a();
        }

        @Override // sd.e0
        public final long read(sd.e sink, long j10) throws Throwable {
            boolean z;
            ErrorCode errorCode;
            Throwable streamResetException;
            long j11;
            g.f(sink, "sink");
            if (j10 < 0) {
                throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
            }
            do {
                e eVar = e.this;
                synchronized (eVar) {
                    eVar.f11226b.getClass();
                    a aVar = eVar.f11232i;
                    z = true;
                    boolean z3 = aVar.f11239c || aVar.f11237a;
                    if (z3) {
                        eVar.f11233j.i();
                    }
                    try {
                        synchronized (eVar) {
                            errorCode = eVar.f11235l;
                        }
                        e eVar2 = e.this;
                        okhttp3.internal.http2.a aVar2 = eVar2.f11226b.f11143t;
                        id.a aVar3 = eVar2.f11227c;
                        long j12 = this.f11244d.f11926b;
                        aVar2.b(aVar3);
                    } finally {
                        if (z3) {
                            eVar.f11233j.l();
                        }
                    }
                }
                if (errorCode != null && !this.f11242b) {
                    streamResetException = eVar.f11236m;
                    if (streamResetException == null) {
                        synchronized (eVar) {
                            ErrorCode errorCode2 = eVar.f11235l;
                            g.c(errorCode2);
                            streamResetException = new StreamResetException(errorCode2);
                        }
                    }
                }
                streamResetException = null;
                if (this.h) {
                    throw new IOException("stream closed");
                }
                sd.e eVar3 = this.f11244d;
                long j13 = eVar3.f11926b;
                if (j13 > 0) {
                    j11 = eVar3.read(sink, Math.min(j10, j13));
                    id.a.b(eVar.f11227c, j11, 0L, 2);
                    long jA = eVar.f11227c.a();
                    if (streamResetException == null && jA >= eVar.f11226b.f11144u.a() / 2) {
                        eVar.f11226b.c0(eVar.f11225a, jA);
                        id.a.b(eVar.f11227c, 0L, jA, 1);
                    }
                    z = false;
                } else {
                    if (this.f11242b || streamResetException != null) {
                        z = false;
                    } else {
                        try {
                            eVar.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    j11 = -1;
                }
                n nVar = n.f10413a;
                e eVar22 = e.this;
                okhttp3.internal.http2.a aVar22 = eVar22.f11226b.f11143t;
                id.a aVar32 = eVar22.f11227c;
                long j122 = this.f11244d.f11926b;
                aVar22.b(aVar32);
            } while (z);
            if (j11 != -1) {
                return j11;
            }
            if (streamResetException == null) {
                return -1L;
            }
            throw streamResetException;
        }

        @Override // sd.e0
        public final f0 timeout() {
            return e.this.f11233j;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class c extends sd.b {
        public c() {
        }

        @Override // sd.b
        public final void k() {
            e.this.e(ErrorCode.f11126k);
            final Http2Connection http2Connection = e.this.f11226b;
            synchronized (http2Connection) {
                long j10 = http2Connection.r;
                long j11 = http2Connection.f11141q;
                if (j10 < j11) {
                    return;
                }
                http2Connection.f11141q = j11 + 1;
                http2Connection.f11142s = System.nanoTime() + 1000000000;
                n nVar = n.f10413a;
                dd.d.c(http2Connection.f11135k, ai.onnxruntime.a.o(new StringBuilder(), http2Connection.f11131c, " ping"), 0L, new zb.a<n>() { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$2
                    {
                        super(0);
                    }

                    @Override // zb.a
                    public final n invoke() throws IOException {
                        Http2Connection http2Connection2 = http2Connection;
                        http2Connection2.getClass();
                        try {
                            http2Connection2.A.P(2, 0, false);
                        } catch (IOException e10) {
                            http2Connection2.o(e10);
                        }
                        return n.f10413a;
                    }
                }, 6);
            }
        }

        public final void l() throws SocketTimeoutException {
            if (j()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public e(int i10, Http2Connection connection, boolean z, boolean z3, okhttp3.f fVar) {
        g.f(connection, "connection");
        this.f11225a = i10;
        this.f11226b = connection;
        this.f11227c = new id.a(i10);
        this.f11229e = connection.f11145v.a();
        ArrayDeque<okhttp3.f> arrayDeque = new ArrayDeque<>();
        this.f11230f = arrayDeque;
        this.h = new b(connection.f11144u.a(), z3);
        this.f11232i = new a(z);
        this.f11233j = new c();
        this.f11234k = new c();
        if (fVar == null) {
            if (!g()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (g()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(fVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r3 = this;
            okhttp3.f r0 = bd.l.f3237a
            monitor-enter(r3)
            okhttp3.internal.http2.e$b r0 = r3.h     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f11242b     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.h     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            okhttp3.internal.http2.e$a r0 = r3.f11232i     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f11237a     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.f11239c     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L37
        L1a:
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            boolean r1 = r3.h()     // Catch: java.lang.Throwable -> L18
            lb.n r2 = lb.n.f10413a     // Catch: java.lang.Throwable -> L18
            monitor-exit(r3)
            if (r0 == 0) goto L2d
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.f11126k
            r1 = 0
            r3.c(r0, r1)
            return
        L2d:
            if (r1 != 0) goto L36
            okhttp3.internal.http2.Http2Connection r0 = r3.f11226b
            int r3 = r3.f11225a
            r0.C(r3)
        L36:
            return
        L37:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.a():void");
    }

    public final void b() throws IOException {
        a aVar = this.f11232i;
        if (aVar.f11239c) {
            throw new IOException("stream closed");
        }
        if (aVar.f11237a) {
            throw new IOException("stream finished");
        }
        if (this.f11235l != null) {
            IOException iOException = this.f11236m;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f11235l;
            g.c(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void c(ErrorCode errorCode, IOException iOException) {
        if (d(errorCode, iOException)) {
            this.f11226b.A.Q(this.f11225a, errorCode);
        }
    }

    public final boolean d(ErrorCode errorCode, IOException iOException) {
        okhttp3.f fVar = l.f3237a;
        synchronized (this) {
            if (this.f11235l != null) {
                return false;
            }
            this.f11235l = errorCode;
            this.f11236m = iOException;
            notifyAll();
            if (this.h.f11242b && this.f11232i.f11237a) {
                return false;
            }
            n nVar = n.f10413a;
            this.f11226b.C(this.f11225a);
            return true;
        }
    }

    public final void e(ErrorCode errorCode) {
        if (d(errorCode, null)) {
            this.f11226b.S(this.f11225a, errorCode);
        }
    }

    public final a f() {
        synchronized (this) {
            try {
                if (!this.f11231g && !g()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f11232i;
    }

    public final boolean g() {
        boolean z = (this.f11225a & 1) == 1;
        this.f11226b.getClass();
        return true == z;
    }

    public final synchronized boolean h() {
        try {
            if (this.f11235l != null) {
                return false;
            }
            b bVar = this.h;
            if (bVar.f11242b || bVar.h) {
                a aVar = this.f11232i;
                if (aVar.f11237a || aVar.f11239c) {
                    if (this.f11231g) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(okhttp3.f headers, boolean z) {
        boolean zH;
        g.f(headers, "headers");
        okhttp3.f fVar = l.f3237a;
        synchronized (this) {
            try {
                if (this.f11231g && headers.a(":status") == null && headers.a(":method") == null) {
                    this.h.f11245e = headers;
                } else {
                    this.f11231g = true;
                    this.f11230f.add(headers);
                }
                if (z) {
                    this.h.f11242b = true;
                }
                zH = h();
                notifyAll();
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.f11226b.C(this.f11225a);
    }

    public final synchronized void j(ErrorCode errorCode) {
        if (this.f11235l == null) {
            this.f11235l = errorCode;
            notifyAll();
        }
    }
}
