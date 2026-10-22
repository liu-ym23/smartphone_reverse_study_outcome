package ed;

import ad.i;
import ad.s;
import fd.d;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import okhttp3.Response;
import okhttp3.h;
import sd.c0;
import sd.e0;
import sd.m;
import sd.n;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.internal.connection.d f8633a;

    /* renamed from: b, reason: collision with root package name */
    public final i f8634b;

    /* renamed from: c, reason: collision with root package name */
    public final e f8635c;

    /* renamed from: d, reason: collision with root package name */
    public final fd.d f8636d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8637e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8638f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a extends m {

        /* renamed from: b, reason: collision with root package name */
        public final long f8639b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f8640c;

        /* renamed from: d, reason: collision with root package name */
        public long f8641d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f8642e;
        public final /* synthetic */ d h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, c0 delegate, long j10) {
            super(delegate);
            kotlin.jvm.internal.g.f(delegate, "delegate");
            this.h = dVar;
            this.f8639b = j10;
        }

        public final <E extends IOException> E a(E e10) {
            if (this.f8640c) {
                return e10;
            }
            this.f8640c = true;
            return (E) this.h.a(this.f8641d, false, true, e10);
        }

        @Override // sd.m, sd.c0, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f8642e) {
                return;
            }
            this.f8642e = true;
            long j10 = this.f8639b;
            if (j10 != -1 && this.f8641d != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        @Override // sd.m, sd.c0, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        @Override // sd.c0
        public final void j0(sd.e source, long j10) throws IOException {
            kotlin.jvm.internal.g.f(source, "source");
            if (this.f8642e) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f8639b;
            if (j11 != -1 && this.f8641d + j10 > j11) {
                StringBuilder sbQ = ai.onnxruntime.a.q(j11, "expected ", " bytes but received ");
                sbQ.append(this.f8641d + j10);
                throw new ProtocolException(sbQ.toString());
            }
            try {
                this.f11961a.j0(source, j10);
                this.f8641d += j10;
            } catch (IOException e10) {
                throw a(e10);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b extends n {

        /* renamed from: a, reason: collision with root package name */
        public final long f8643a;

        /* renamed from: b, reason: collision with root package name */
        public long f8644b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f8645c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f8646d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f8647e;
        public final /* synthetic */ d h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, e0 delegate, long j10) {
            super(delegate);
            kotlin.jvm.internal.g.f(delegate, "delegate");
            this.h = dVar;
            this.f8643a = j10;
            this.f8645c = true;
            if (j10 == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e10) {
            if (this.f8646d) {
                return e10;
            }
            this.f8646d = true;
            d dVar = this.h;
            if (e10 == null && this.f8645c) {
                this.f8645c = false;
                dVar.f8634b.responseBodyStart(dVar.f8633a);
            }
            return (E) dVar.a(this.f8644b, true, false, e10);
        }

        @Override // sd.n, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f8647e) {
                return;
            }
            this.f8647e = true;
            try {
                super.close();
                a(null);
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        @Override // sd.n, sd.e0
        public final long read(sd.e sink, long j10) throws IOException {
            kotlin.jvm.internal.g.f(sink, "sink");
            if (this.f8647e) {
                throw new IllegalStateException("closed");
            }
            try {
                long j11 = delegate().read(sink, j10);
                if (this.f8645c) {
                    this.f8645c = false;
                    d dVar = this.h;
                    dVar.f8634b.responseBodyStart(dVar.f8633a);
                }
                if (j11 == -1) {
                    a(null);
                    return -1L;
                }
                long j12 = this.f8644b + j11;
                long j13 = this.f8643a;
                if (j13 == -1 || j12 <= j13) {
                    this.f8644b = j12;
                    if (j12 == j13) {
                        a(null);
                    }
                    return j11;
                }
                throw new ProtocolException("expected " + j13 + " bytes but received " + j12);
            } catch (IOException e10) {
                throw a(e10);
            }
        }
    }

    public d(okhttp3.internal.connection.d dVar, i eventListener, e finder, fd.d dVar2) {
        kotlin.jvm.internal.g.f(eventListener, "eventListener");
        kotlin.jvm.internal.g.f(finder, "finder");
        this.f8633a = dVar;
        this.f8634b = eventListener;
        this.f8635c = finder;
        this.f8636d = dVar2;
    }

    public final <E extends IOException> E a(long j10, boolean z, boolean z3, E e10) {
        if (e10 != null) {
            g(e10);
        }
        i iVar = this.f8634b;
        okhttp3.internal.connection.d dVar = this.f8633a;
        if (z3) {
            if (e10 != null) {
                iVar.requestFailed(dVar, e10);
            } else {
                iVar.requestBodyEnd(dVar, j10);
            }
        }
        if (z) {
            if (e10 != null) {
                iVar.responseFailed(dVar, e10);
            } else {
                iVar.responseBodyEnd(dVar, j10);
            }
        }
        return (E) dVar.g(this, z3, z, e10);
    }

    public final a b(h request, boolean z) {
        kotlin.jvm.internal.g.f(request, "request");
        this.f8637e = z;
        s sVar = request.f10995d;
        kotlin.jvm.internal.g.c(sVar);
        long jContentLength = sVar.contentLength();
        this.f8634b.requestBodyStart(this.f8633a);
        return new a(this, this.f8636d.d(request, jContentLength), jContentLength);
    }

    public final g c() {
        d.a aVarH = this.f8636d.h();
        g gVar = aVarH instanceof g ? (g) aVarH : null;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    public final f d() throws SocketException {
        okhttp3.internal.connection.d dVar = this.f8633a;
        if (dVar.f11049n) {
            throw new IllegalStateException("Check failed.");
        }
        dVar.f11049n = true;
        dVar.h.j();
        d.a aVarH = this.f8636d.h();
        kotlin.jvm.internal.g.d(aVarH, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        g gVar = (g) aVarH;
        Socket socket = gVar.f8653f;
        kotlin.jvm.internal.g.c(socket);
        sd.h hVar = gVar.f8655i;
        kotlin.jvm.internal.g.c(hVar);
        sd.g gVar2 = gVar.f8656j;
        kotlin.jvm.internal.g.c(gVar2);
        socket.setSoTimeout(0);
        gVar.b();
        return new f(hVar, gVar2, this);
    }

    public final fd.g e(Response response) throws IOException {
        fd.d dVar = this.f8636d;
        try {
            String strA = Response.a("Content-Type", response);
            long jC = dVar.c(response);
            return new fd.g(strA, jC, new z(new b(this, dVar.b(response), jC)));
        } catch (IOException e10) {
            this.f8634b.responseFailed(this.f8633a, e10);
            g(e10);
            throw e10;
        }
    }

    public final Response.Builder f(boolean z) throws IOException {
        try {
            Response.Builder builderF = this.f8636d.f(z);
            if (builderF == null) {
                return builderF;
            }
            builderF.b(this);
            return builderF;
        } catch (IOException e10) {
            this.f8634b.responseFailed(this.f8633a, e10);
            g(e10);
            throw e10;
        }
    }

    public final void g(IOException iOException) {
        this.f8638f = true;
        this.f8636d.h().f(this.f8633a, iOException);
    }
}
