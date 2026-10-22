package okhttp3.internal.http2;

import bd.i;
import bd.l;
import com.stepos.core.ability.converter.BundleContentBridge;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$IntRef;
import lb.n;
import okhttp3.internal.http2.a;
import sd.g;
import sd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Http2Connection implements Closeable {
    public static final hd.e D;
    public final f A;
    public final c B;
    public final LinkedHashSet C;

    /* renamed from: a, reason: collision with root package name */
    public final b f11129a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f11130b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final String f11131c;

    /* renamed from: d, reason: collision with root package name */
    public int f11132d;

    /* renamed from: e, reason: collision with root package name */
    public int f11133e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final dd.e f11134j;

    /* renamed from: k, reason: collision with root package name */
    public final dd.d f11135k;

    /* renamed from: l, reason: collision with root package name */
    public final dd.d f11136l;

    /* renamed from: m, reason: collision with root package name */
    public final dd.d f11137m;

    /* renamed from: n, reason: collision with root package name */
    public final hd.d f11138n;

    /* renamed from: o, reason: collision with root package name */
    public long f11139o;

    /* renamed from: p, reason: collision with root package name */
    public long f11140p;

    /* renamed from: q, reason: collision with root package name */
    public long f11141q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f11142s;

    /* renamed from: t, reason: collision with root package name */
    public final okhttp3.internal.http2.a f11143t;

    /* renamed from: u, reason: collision with root package name */
    public final hd.e f11144u;

    /* renamed from: v, reason: collision with root package name */
    public hd.e f11145v;

    /* renamed from: w, reason: collision with root package name */
    public final id.a f11146w;

    /* renamed from: x, reason: collision with root package name */
    public long f11147x;

    /* renamed from: y, reason: collision with root package name */
    public long f11148y;
    public final Socket z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final dd.e f11160a;

        /* renamed from: b, reason: collision with root package name */
        public Socket f11161b;

        /* renamed from: c, reason: collision with root package name */
        public String f11162c;

        /* renamed from: d, reason: collision with root package name */
        public h f11163d;

        /* renamed from: e, reason: collision with root package name */
        public g f11164e;

        /* renamed from: f, reason: collision with root package name */
        public b f11165f;

        /* renamed from: g, reason: collision with root package name */
        public final hd.d f11166g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public okhttp3.internal.http2.a f11167i;

        public a(dd.e taskRunner) {
            kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
            this.f11160a = taskRunner;
            this.f11165f = b.f11168a;
            this.f11166g = hd.d.f9425a;
            this.f11167i = a.C0121a.f11192a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f11168a = new a();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a extends b {
            @Override // okhttp3.internal.http2.Http2Connection.b
            public final void c(e eVar) {
                eVar.c(ErrorCode.f11125j, null);
            }
        }

        public void a(Http2Connection http2Connection, hd.e settings) {
            kotlin.jvm.internal.g.f(settings, "settings");
        }

        public abstract void c(e eVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class c implements zb.a<n> {

        /* renamed from: a, reason: collision with root package name */
        public final d f11169a;

        public c(d dVar) {
            this.f11169a = dVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00f5, code lost:
        
            if (r17 == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00f7, code lost:
        
            r3.i(bd.l.f3237a, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00fc, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(final boolean r17, final int r18, sd.h r19, final int r20) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.c.b(boolean, int, sd.h, int):void");
        }

        public final void c(final int i10, final List headerBlock, final boolean z) {
            kotlin.jvm.internal.g.f(headerBlock, "headerBlock");
            final Http2Connection http2Connection = Http2Connection.this;
            if (i10 != 0 && (i10 & 1) == 0) {
                dd.d.c(http2Connection.f11136l, http2Connection.f11131c + '[' + i10 + "] onHeaders", 0L, new zb.a<n>(i10, headerBlock, z) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$1

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ int f11176b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ List<hd.a> f11177c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // zb.a
                    public final n invoke() {
                        hd.d dVar = this.f11175a.f11138n;
                        List<hd.a> responseHeaders = this.f11177c;
                        dVar.getClass();
                        kotlin.jvm.internal.g.f(responseHeaders, "responseHeaders");
                        Http2Connection http2Connection2 = this.f11175a;
                        int i11 = this.f11176b;
                        try {
                            http2Connection2.A.Q(i11, ErrorCode.f11126k);
                            synchronized (http2Connection2) {
                                http2Connection2.C.remove(Integer.valueOf(i11));
                            }
                        } catch (IOException unused) {
                        }
                        return n.f10413a;
                    }
                }, 6);
                return;
            }
            synchronized (http2Connection) {
                e eVarW = http2Connection.w(i10);
                if (eVarW != null) {
                    n nVar = n.f10413a;
                    eVarW.i(l.j(headerBlock), z);
                    return;
                }
                if (http2Connection.h) {
                    return;
                }
                if (i10 <= http2Connection.f11132d) {
                    return;
                }
                if (i10 % 2 == http2Connection.f11133e % 2) {
                    return;
                }
                final e eVar = new e(i10, http2Connection, false, z, l.j(headerBlock));
                http2Connection.f11132d = i10;
                http2Connection.f11130b.put(Integer.valueOf(i10), eVar);
                dd.d.c(http2Connection.f11134j.e(), http2Connection.f11131c + '[' + i10 + "] onStream", 0L, new zb.a<n>() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // zb.a
                    public final n invoke() {
                        e eVar2 = eVar;
                        Http2Connection http2Connection2 = http2Connection;
                        try {
                            http2Connection2.f11129a.c(eVar2);
                        } catch (IOException e10) {
                            kd.h.Companion.getClass();
                            kd.h.platform.log("Http2Connection.Listener failure for " + http2Connection2.f11131c, 4, e10);
                            try {
                                eVar2.c(ErrorCode.f11123d, e10);
                            } catch (IOException unused) {
                            }
                        }
                        return n.f10413a;
                    }
                }, 6);
            }
        }

        public final void e(final int i10, final List requestHeaders) {
            kotlin.jvm.internal.g.f(requestHeaders, "requestHeaders");
            final Http2Connection http2Connection = Http2Connection.this;
            synchronized (http2Connection) {
                if (http2Connection.C.contains(Integer.valueOf(i10))) {
                    http2Connection.S(i10, ErrorCode.f11123d);
                    return;
                }
                http2Connection.C.add(Integer.valueOf(i10));
                dd.d.c(http2Connection.f11136l, http2Connection.f11131c + '[' + i10 + "] onRequest", 0L, new zb.a<n>() { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // zb.a
                    public final n invoke() {
                        hd.d dVar = http2Connection.f11138n;
                        List<hd.a> requestHeaders2 = requestHeaders;
                        dVar.getClass();
                        kotlin.jvm.internal.g.f(requestHeaders2, "requestHeaders");
                        Http2Connection http2Connection2 = http2Connection;
                        int i11 = i10;
                        try {
                            http2Connection2.A.Q(i11, ErrorCode.f11126k);
                            synchronized (http2Connection2) {
                                http2Connection2.C.remove(Integer.valueOf(i11));
                            }
                        } catch (IOException unused) {
                        }
                        return n.f10413a;
                    }
                }, 6);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v8 */
        @Override // zb.a
        public final n invoke() throws Throwable {
            Throwable th;
            Http2Connection http2Connection = Http2Connection.this;
            d dVar = this.f11169a;
            ErrorCode errorCode = ErrorCode.f11124e;
            IOException iOException = null;
            try {
                try {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        http2Connection.a(this, errorCode, iOException);
                        i.b(dVar);
                        throw th;
                    }
                } catch (IOException e10) {
                    iOException = e10;
                }
                if (!dVar.a(true, this)) {
                    throw new IOException("Required SETTINGS preface not received");
                }
                do {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                        this = errorCode;
                        http2Connection.a(this, errorCode, iOException);
                        i.b(dVar);
                        throw th;
                    }
                } while (dVar.a(false, this));
                ErrorCode errorCode2 = ErrorCode.f11122c;
                try {
                    errorCode = ErrorCode.f11126k;
                    http2Connection.a(errorCode2, errorCode, null);
                    this = errorCode2;
                } catch (IOException e11) {
                    iOException = e11;
                    ErrorCode errorCode3 = ErrorCode.f11123d;
                    http2Connection.a(errorCode3, errorCode3, iOException);
                    this = errorCode3;
                    i.b(dVar);
                    return n.f10413a;
                }
                i.b(dVar);
                return n.f10413a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    static {
        hd.e eVar = new hd.e();
        eVar.c(7, 65535);
        eVar.c(5, 16384);
        D = eVar;
    }

    public Http2Connection(a aVar) {
        this.f11129a = aVar.f11165f;
        String str = aVar.f11162c;
        if (str == null) {
            kotlin.jvm.internal.g.l("connectionName");
            throw null;
        }
        this.f11131c = str;
        this.f11133e = 3;
        dd.e eVar = aVar.f11160a;
        this.f11134j = eVar;
        dd.d dVarE = eVar.e();
        this.f11135k = dVarE;
        this.f11136l = eVar.e();
        this.f11137m = eVar.e();
        this.f11138n = aVar.f11166g;
        this.f11143t = aVar.f11167i;
        hd.e eVar2 = new hd.e();
        eVar2.c(7, 16777216);
        this.f11144u = eVar2;
        this.f11145v = D;
        this.f11146w = new id.a(0);
        this.f11148y = r2.a();
        Socket socket = aVar.f11161b;
        if (socket == null) {
            kotlin.jvm.internal.g.l("socket");
            throw null;
        }
        this.z = socket;
        g gVar = aVar.f11164e;
        if (gVar == null) {
            kotlin.jvm.internal.g.l("sink");
            throw null;
        }
        this.A = new f(gVar);
        h hVar = aVar.f11163d;
        if (hVar == null) {
            kotlin.jvm.internal.g.l(BundleContentBridge.ROLE_SOURCE);
            throw null;
        }
        this.B = new c(new d(hVar));
        this.C = new LinkedHashSet();
        int i10 = aVar.h;
        if (i10 != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(i10);
            String name = str.concat(" ping");
            zb.a<Long> aVar2 = new zb.a<Long>() { // from class: okhttp3.internal.http2.Http2Connection.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // zb.a
                public final Long invoke() throws IOException {
                    boolean z;
                    Http2Connection http2Connection = Http2Connection.this;
                    synchronized (http2Connection) {
                        long j10 = http2Connection.f11140p;
                        long j11 = http2Connection.f11139o;
                        if (j10 < j11) {
                            z = true;
                        } else {
                            http2Connection.f11139o = j11 + 1;
                            z = false;
                        }
                    }
                    if (z) {
                        Http2Connection.this.o(null);
                        return -1L;
                    }
                    Http2Connection http2Connection2 = Http2Connection.this;
                    try {
                        http2Connection2.A.P(1, 0, false);
                    } catch (IOException e10) {
                        http2Connection2.o(e10);
                    }
                    return Long.valueOf(nanos);
                }
            };
            kotlin.jvm.internal.g.f(name, "name");
            dVarE.d(new dd.c(name, aVar2), nanos);
        }
    }

    public final synchronized e C(int i10) {
        e eVar;
        eVar = (e) this.f11130b.remove(Integer.valueOf(i10));
        notifyAll();
        return eVar;
    }

    public final void K(ErrorCode errorCode) {
        synchronized (this.A) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (this.h) {
                    return;
                }
                this.h = true;
                int i10 = this.f11132d;
                ref$IntRef.f10074a = i10;
                n nVar = n.f10413a;
                this.A.C(i10, errorCode, i.f3230a);
            }
        }
    }

    public final synchronized void P(long j10) {
        try {
            id.a.b(this.f11146w, j10, 0L, 2);
            long jA = this.f11146w.a();
            if (jA >= this.f11144u.a() / 2) {
                c0(0, jA);
                id.a.b(this.f11146w, 0L, jA, 1);
            }
            this.f11143t.a(this.f11146w);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.A.f11250c);
        r6 = r2;
        r8.f11147x += r6;
        r4 = lb.n.f10413a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(int r9, boolean r10, sd.e r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            okhttp3.internal.http2.f r8 = r8.A
            r8.o(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L6a
            monitor-enter(r8)
        L12:
            long r4 = r8.f11147x     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            long r6 = r8.f11148y     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f11130b     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            goto L12
        L2a:
            r9 = move-exception
            goto L68
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            okhttp3.internal.http2.f r4 = r8.A     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f11250c     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f11147x     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f11147x = r4     // Catch: java.lang.Throwable -> L2a
            lb.n r4 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.f r4 = r8.A
            if (r10 == 0) goto L56
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = r3
        L57:
            r4.o(r5, r9, r11, r2)
            goto Ld
        L5b:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L68:
            monitor-exit(r8)
            throw r9
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.Q(int, boolean, sd.e, long):void");
    }

    public final void S(final int i10, final ErrorCode errorCode) {
        dd.d.c(this.f11135k, this.f11131c + '[' + i10 + "] writeSynReset", 0L, new zb.a<n>() { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // zb.a
            public final n invoke() throws IOException {
                Http2Connection http2Connection = this.f11184a;
                try {
                    http2Connection.A.Q(i10, errorCode);
                } catch (IOException e10) {
                    http2Connection.o(e10);
                }
                return n.f10413a;
            }
        }, 6);
    }

    public final void a(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) throws IOException {
        int i10;
        Object[] array;
        okhttp3.f fVar = l.f3237a;
        try {
            K(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f11130b.isEmpty()) {
                    array = null;
                } else {
                    array = this.f11130b.values().toArray(new e[0]);
                    this.f11130b.clear();
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        e[] eVarArr = (e[]) array;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                try {
                    eVar.c(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.A.close();
        } catch (IOException unused3) {
        }
        try {
            this.z.close();
        } catch (IOException unused4) {
        }
        this.f11135k.f();
        this.f11136l.f();
        this.f11137m.f();
    }

    public final void c0(final int i10, final long j10) {
        dd.d.c(this.f11135k, this.f11131c + '[' + i10 + "] windowUpdate", 0L, new zb.a<n>() { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // zb.a
            public final n invoke() throws IOException {
                Http2Connection http2Connection = this.f11187a;
                try {
                    http2Connection.A.S(i10, j10);
                } catch (IOException e10) {
                    http2Connection.o(e10);
                }
                return n.f10413a;
            }
        }, 6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(ErrorCode.f11122c, ErrorCode.f11126k, null);
    }

    public final void flush() {
        this.A.flush();
    }

    public final void o(IOException iOException) throws IOException {
        ErrorCode errorCode = ErrorCode.f11123d;
        a(errorCode, errorCode, iOException);
    }

    public final synchronized e w(int i10) {
        return (e) this.f11130b.get(Integer.valueOf(i10));
    }
}
