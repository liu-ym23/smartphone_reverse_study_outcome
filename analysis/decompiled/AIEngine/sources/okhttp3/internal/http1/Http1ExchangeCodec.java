package okhttp3.internal.http1;

import ad.n;
import ad.s;
import bd.i;
import bd.l;
import fd.d;
import fd.i;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import okhttp3.f;
import sd.c0;
import sd.e0;
import sd.f0;
import sd.g;
import sd.h;
import sd.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Http1ExchangeCodec implements fd.d {

    /* renamed from: a, reason: collision with root package name */
    public final n f11098a;

    /* renamed from: b, reason: collision with root package name */
    public final d.a f11099b;

    /* renamed from: c, reason: collision with root package name */
    public final h f11100c;

    /* renamed from: d, reason: collision with root package name */
    public final g f11101d;

    /* renamed from: e, reason: collision with root package name */
    public int f11102e;

    /* renamed from: f, reason: collision with root package name */
    public final gd.a f11103f;

    /* renamed from: g, reason: collision with root package name */
    public okhttp3.f f11104g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public abstract class a implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public final o f11105a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11106b;

        public a() {
            this.f11105a = new o(Http1ExchangeCodec.this.f11100c.timeout());
        }

        public final void a() {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            int i10 = http1ExchangeCodec.f11102e;
            if (i10 == 6) {
                return;
            }
            if (i10 == 5) {
                Http1ExchangeCodec.j(http1ExchangeCodec, this.f11105a);
                http1ExchangeCodec.f11102e = 6;
            } else {
                throw new IllegalStateException("state: " + http1ExchangeCodec.f11102e);
            }
        }

        @Override // sd.e0
        public long read(sd.e sink, long j10) throws IOException {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            kotlin.jvm.internal.g.f(sink, "sink");
            try {
                return http1ExchangeCodec.f11100c.read(sink, j10);
            } catch (IOException e10) {
                http1ExchangeCodec.f11099b.b();
                this.a();
                throw e10;
            }
        }

        @Override // sd.e0
        public final f0 timeout() {
            return this.f11105a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b implements c0 {

        /* renamed from: a, reason: collision with root package name */
        public final o f11108a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11109b;

        public b() {
            this.f11108a = new o(Http1ExchangeCodec.this.f11101d.timeout());
        }

        @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.f11109b) {
                return;
            }
            this.f11109b = true;
            Http1ExchangeCodec.this.f11101d.D("0\r\n\r\n");
            Http1ExchangeCodec.j(Http1ExchangeCodec.this, this.f11108a);
            Http1ExchangeCodec.this.f11102e = 3;
        }

        @Override // sd.c0, java.io.Flushable
        public final synchronized void flush() {
            if (this.f11109b) {
                return;
            }
            Http1ExchangeCodec.this.f11101d.flush();
        }

        @Override // sd.c0
        public final void j0(sd.e source, long j10) {
            g gVar = Http1ExchangeCodec.this.f11101d;
            kotlin.jvm.internal.g.f(source, "source");
            if (this.f11109b) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            gVar.s0(j10);
            gVar.D("\r\n");
            gVar.j0(source, j10);
            gVar.D("\r\n");
        }

        @Override // sd.c0
        public final f0 timeout() {
            return this.f11108a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        public final okhttp3.g f11111d;

        /* renamed from: e, reason: collision with root package name */
        public long f11112e;
        public boolean h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Http1ExchangeCodec f11113j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Http1ExchangeCodec http1ExchangeCodec, okhttp3.g url) {
            super();
            kotlin.jvm.internal.g.f(url, "url");
            this.f11113j = http1ExchangeCodec;
            this.f11111d = url;
            this.f11112e = -1L;
            this.h = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zI;
            if (this.f11106b) {
                return;
            }
            if (this.h) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                okhttp3.f fVar = l.f3237a;
                kotlin.jvm.internal.g.f(timeUnit, "timeUnit");
                try {
                    zI = l.i(this, 100);
                } catch (IOException unused) {
                    zI = false;
                }
                if (!zI) {
                    this.f11113j.f11099b.b();
                    a();
                }
            }
            this.f11106b = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
        
            if (r11.h == false) goto L27;
         */
        @Override // okhttp3.internal.http1.Http1ExchangeCodec.a, sd.e0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long read(sd.e r12, long r13) throws java.io.IOException {
            /*
                r11 = this;
                okhttp3.internal.http1.Http1ExchangeCodec r0 = r11.f11113j
                sd.h r1 = r0.f11100c
                java.lang.String r2 = "sink"
                kotlin.jvm.internal.g.f(r12, r2)
                r2 = 0
                int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r4 < 0) goto Ld0
                boolean r4 = r11.f11106b
                if (r4 != 0) goto Lc8
                boolean r4 = r11.h
                r5 = -1
                if (r4 != 0) goto L1a
                goto L7c
            L1a:
                long r7 = r11.f11112e
                int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r4 == 0) goto L24
                int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r4 != 0) goto L7d
            L24:
                java.lang.String r4 = "expected chunk size and optional extensions but was \""
                int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r7 == 0) goto L2d
                r1.N()
            L2d:
                long r7 = r1.E0()     // Catch: java.lang.NumberFormatException -> Lbd
                r11.f11112e = r7     // Catch: java.lang.NumberFormatException -> Lbd
                java.lang.String r1 = r1.N()     // Catch: java.lang.NumberFormatException -> Lbd
                java.lang.CharSequence r1 = gc.q.L0(r1)     // Catch: java.lang.NumberFormatException -> Lbd
                java.lang.String r1 = r1.toString()     // Catch: java.lang.NumberFormatException -> Lbd
                long r7 = r11.f11112e     // Catch: java.lang.NumberFormatException -> Lbd
                int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r7 < 0) goto La1
                int r7 = r1.length()     // Catch: java.lang.NumberFormatException -> Lbd
                r8 = 0
                if (r7 <= 0) goto L54
                java.lang.String r7 = ";"
                boolean r7 = gc.o.k0(r1, r7, r8)     // Catch: java.lang.NumberFormatException -> Lbd
                if (r7 == 0) goto La1
            L54:
                long r9 = r11.f11112e
                int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r1 != 0) goto L78
                r11.h = r8
                gd.a r1 = r0.f11103f
                okhttp3.f r1 = r1.a()
                r0.f11104g = r1
                ad.n r1 = r0.f11098a
                kotlin.jvm.internal.g.c(r1)
                ad.g r1 = r1.f125j
                okhttp3.f r2 = r0.f11104g
                kotlin.jvm.internal.g.c(r2)
                okhttp3.g r3 = r11.f11111d
                fd.e.b(r1, r3, r2)
                r11.a()
            L78:
                boolean r1 = r11.h
                if (r1 != 0) goto L7d
            L7c:
                return r5
            L7d:
                long r1 = r11.f11112e
                long r13 = java.lang.Math.min(r13, r1)
                long r12 = super.read(r12, r13)
                int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r14 == 0) goto L91
                long r0 = r11.f11112e
                long r0 = r0 - r12
                r11.f11112e = r0
                return r12
            L91:
                fd.d$a r12 = r0.f11099b
                r12.b()
                java.net.ProtocolException r12 = new java.net.ProtocolException
                java.lang.String r13 = "unexpected end of stream"
                r12.<init>(r13)
                r11.a()
                throw r12
            La1:
                java.net.ProtocolException r12 = new java.net.ProtocolException     // Catch: java.lang.NumberFormatException -> Lbd
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lbd
                r13.<init>(r4)     // Catch: java.lang.NumberFormatException -> Lbd
                long r2 = r11.f11112e     // Catch: java.lang.NumberFormatException -> Lbd
                r13.append(r2)     // Catch: java.lang.NumberFormatException -> Lbd
                r13.append(r1)     // Catch: java.lang.NumberFormatException -> Lbd
                r11 = 34
                r13.append(r11)     // Catch: java.lang.NumberFormatException -> Lbd
                java.lang.String r11 = r13.toString()     // Catch: java.lang.NumberFormatException -> Lbd
                r12.<init>(r11)     // Catch: java.lang.NumberFormatException -> Lbd
                throw r12     // Catch: java.lang.NumberFormatException -> Lbd
            Lbd:
                r11 = move-exception
                java.net.ProtocolException r12 = new java.net.ProtocolException
                java.lang.String r11 = r11.getMessage()
                r12.<init>(r11)
                throw r12
            Lc8:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "closed"
                r11.<init>(r12)
                throw r11
            Ld0:
                java.lang.String r11 = "byteCount < 0: "
                java.lang.String r11 = com.stepos.core.ota.d.f(r13, r11)
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r11 = r11.toString()
                r12.<init>(r11)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http1.Http1ExchangeCodec.c.read(sd.e, long):long");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class d extends a {

        /* renamed from: d, reason: collision with root package name */
        public long f11114d;

        public d(long j10) {
            super();
            this.f11114d = j10;
            if (j10 == 0) {
                a();
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean zI;
            if (this.f11106b) {
                return;
            }
            if (this.f11114d != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                okhttp3.f fVar = l.f3237a;
                kotlin.jvm.internal.g.f(timeUnit, "timeUnit");
                try {
                    zI = l.i(this, 100);
                } catch (IOException unused) {
                    zI = false;
                }
                if (!zI) {
                    Http1ExchangeCodec.this.f11099b.b();
                    a();
                }
            }
            this.f11106b = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.a, sd.e0
        public final long read(sd.e sink, long j10) throws IOException {
            kotlin.jvm.internal.g.f(sink, "sink");
            if (j10 < 0) {
                throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
            }
            if (this.f11106b) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f11114d;
            if (j11 == 0) {
                return -1L;
            }
            long j12 = super.read(sink, Math.min(j11, j10));
            if (j12 == -1) {
                Http1ExchangeCodec.this.f11099b.b();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
            long j13 = this.f11114d - j12;
            this.f11114d = j13;
            if (j13 == 0) {
                a();
            }
            return j12;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class e implements c0 {

        /* renamed from: a, reason: collision with root package name */
        public final o f11116a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11117b;

        public e() {
            this.f11116a = new o(Http1ExchangeCodec.this.f11101d.timeout());
        }

        @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f11117b) {
                return;
            }
            this.f11117b = true;
            o oVar = this.f11116a;
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            Http1ExchangeCodec.j(http1ExchangeCodec, oVar);
            http1ExchangeCodec.f11102e = 3;
        }

        @Override // sd.c0, java.io.Flushable
        public final void flush() {
            if (this.f11117b) {
                return;
            }
            Http1ExchangeCodec.this.f11101d.flush();
        }

        @Override // sd.c0
        public final void j0(sd.e source, long j10) {
            kotlin.jvm.internal.g.f(source, "source");
            if (this.f11117b) {
                throw new IllegalStateException("closed");
            }
            i.a(source.f11926b, 0L, j10);
            Http1ExchangeCodec.this.f11101d.j0(source, j10);
        }

        @Override // sd.c0
        public final f0 timeout() {
            return this.f11116a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class f extends a {

        /* renamed from: d, reason: collision with root package name */
        public boolean f11119d;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f11106b) {
                return;
            }
            if (!this.f11119d) {
                a();
            }
            this.f11106b = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.a, sd.e0
        public final long read(sd.e sink, long j10) throws IOException {
            kotlin.jvm.internal.g.f(sink, "sink");
            if (j10 < 0) {
                throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
            }
            if (this.f11106b) {
                throw new IllegalStateException("closed");
            }
            if (this.f11119d) {
                return -1L;
            }
            long j11 = super.read(sink, j10);
            if (j11 != -1) {
                return j11;
            }
            this.f11119d = true;
            a();
            return -1L;
        }
    }

    public Http1ExchangeCodec(n nVar, d.a aVar, h source, g sink) {
        kotlin.jvm.internal.g.f(source, "source");
        kotlin.jvm.internal.g.f(sink, "sink");
        this.f11098a = nVar;
        this.f11099b = aVar;
        this.f11100c = source;
        this.f11101d = sink;
        this.f11103f = new gd.a(source);
    }

    public static final void j(Http1ExchangeCodec http1ExchangeCodec, o oVar) {
        f0 f0Var = oVar.f11962e;
        f0.a delegate = f0.f11935d;
        kotlin.jvm.internal.g.f(delegate, "delegate");
        oVar.f11962e = delegate;
        f0Var.a();
        f0Var.b();
    }

    @Override // fd.d
    public final void a() {
        this.f11101d.flush();
    }

    @Override // fd.d
    public final e0 b(Response response) {
        if (!fd.e.a(response)) {
            return k(0L);
        }
        if ("chunked".equalsIgnoreCase(Response.a("Transfer-Encoding", response))) {
            okhttp3.g gVar = response.f10888a.f10992a;
            if (this.f11102e == 4) {
                this.f11102e = 5;
                return new c(this, gVar);
            }
            throw new IllegalStateException(("state: " + this.f11102e).toString());
        }
        long jE = l.e(response);
        if (jE != -1) {
            return k(jE);
        }
        if (this.f11102e == 4) {
            this.f11102e = 5;
            this.f11099b.b();
            return new f();
        }
        throw new IllegalStateException(("state: " + this.f11102e).toString());
    }

    @Override // fd.d
    public final long c(Response response) {
        if (!fd.e.a(response)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(Response.a("Transfer-Encoding", response))) {
            return -1L;
        }
        return l.e(response);
    }

    @Override // fd.d
    public final void cancel() {
        this.f11099b.cancel();
    }

    @Override // fd.d
    public final c0 d(okhttp3.h request, long j10) throws ProtocolException {
        kotlin.jvm.internal.g.f(request, "request");
        s sVar = request.f10995d;
        if (sVar != null && sVar.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(request.a("Transfer-Encoding"))) {
            if (this.f11102e == 1) {
                this.f11102e = 2;
                return new b();
            }
            throw new IllegalStateException(("state: " + this.f11102e).toString());
        }
        if (j10 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f11102e == 1) {
            this.f11102e = 2;
            return new e();
        }
        throw new IllegalStateException(("state: " + this.f11102e).toString());
    }

    @Override // fd.d
    public final void e(okhttp3.h request) {
        kotlin.jvm.internal.g.f(request, "request");
        Proxy.Type type = this.f11099b.d().f177b.type();
        kotlin.jvm.internal.g.e(type, "type(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.f10993b);
        sb2.append(' ');
        okhttp3.g gVar = request.f10992a;
        if (kotlin.jvm.internal.g.b(gVar.f10977a, "https") || type != Proxy.Type.HTTP) {
            String strB = gVar.b();
            String strD = gVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb2.append(strB);
        } else {
            sb2.append(gVar);
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        l(request.f10994c, string);
    }

    @Override // fd.d
    public final Response.Builder f(boolean z) throws IOException {
        gd.a aVar = this.f11103f;
        int i10 = this.f11102e;
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            throw new IllegalStateException(("state: " + this.f11102e).toString());
        }
        try {
            String strX = aVar.f9144a.x(aVar.f9145b);
            aVar.f9145b -= strX.length();
            fd.i iVarA = i.a.a(strX);
            int i11 = iVarA.f8848b;
            Response.Builder builder = new Response.Builder();
            builder.f10902b = iVarA.f8847a;
            builder.f10903c = i11;
            builder.f10904d = iVarA.f8849c;
            builder.f10906f = aVar.a().e();
            Http1ExchangeCodec$readResponseHeaders$responseBuilder$1 trailersFn = new zb.a<okhttp3.f>() { // from class: okhttp3.internal.http1.Http1ExchangeCodec$readResponseHeaders$responseBuilder$1
                @Override // zb.a
                public final f invoke() {
                    throw new IllegalStateException("trailers not available");
                }
            };
            kotlin.jvm.internal.g.f(trailersFn, "trailersFn");
            builder.f10913n = trailersFn;
            if (z && i11 == 100) {
                return null;
            }
            if (i11 == 100) {
                this.f11102e = 3;
                return builder;
            }
            if (102 > i11 || i11 >= 200) {
                this.f11102e = 4;
                return builder;
            }
            this.f11102e = 3;
            return builder;
        } catch (EOFException e10) {
            throw new IOException(ai.onnxruntime.a.k("unexpected end of stream on ", this.f11099b.d().f176a.h.h()), e10);
        }
    }

    @Override // fd.d
    public final void g() {
        this.f11101d.flush();
    }

    @Override // fd.d
    public final d.a h() {
        return this.f11099b;
    }

    @Override // fd.d
    public final okhttp3.f i() {
        if (this.f11102e != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        okhttp3.f fVar = this.f11104g;
        return fVar == null ? l.f3237a : fVar;
    }

    public final d k(long j10) {
        if (this.f11102e == 4) {
            this.f11102e = 5;
            return new d(j10);
        }
        throw new IllegalStateException(("state: " + this.f11102e).toString());
    }

    public final void l(okhttp3.f headers, String requestLine) {
        kotlin.jvm.internal.g.f(headers, "headers");
        kotlin.jvm.internal.g.f(requestLine, "requestLine");
        if (this.f11102e != 0) {
            throw new IllegalStateException(("state: " + this.f11102e).toString());
        }
        g gVar = this.f11101d;
        gVar.D(requestLine).D("\r\n");
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            gVar.D(headers.b(i10)).D(": ").D(headers.g(i10)).D("\r\n");
        }
        gVar.D("\r\n");
        this.f11102e = 1;
    }
}
