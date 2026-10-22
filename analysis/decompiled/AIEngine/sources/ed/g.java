package ed;

import ad.n;
import ad.u;
import bd.l;
import com.stepos.core.model.manifest.ModelManifest;
import fd.d;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.http2.a;
import sd.h;
import sd.y;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends Http2Connection.b implements ad.d, d.a {

    /* renamed from: b, reason: collision with root package name */
    public final dd.e f8649b;

    /* renamed from: c, reason: collision with root package name */
    public final okhttp3.internal.connection.e f8650c;

    /* renamed from: d, reason: collision with root package name */
    public final u f8651d;

    /* renamed from: e, reason: collision with root package name */
    public final Socket f8652e;

    /* renamed from: f, reason: collision with root package name */
    public final Socket f8653f;

    /* renamed from: g, reason: collision with root package name */
    public final Handshake f8654g;
    public final Protocol h;

    /* renamed from: i, reason: collision with root package name */
    public final h f8655i;

    /* renamed from: j, reason: collision with root package name */
    public final sd.g f8656j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8657k;

    /* renamed from: l, reason: collision with root package name */
    public final ad.e f8658l;

    /* renamed from: m, reason: collision with root package name */
    public Http2Connection f8659m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8660n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8661o;

    /* renamed from: p, reason: collision with root package name */
    public int f8662p;

    /* renamed from: q, reason: collision with root package name */
    public int f8663q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f8664s;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f8665t;

    /* renamed from: u, reason: collision with root package name */
    public long f8666u;

    public g(dd.e taskRunner, okhttp3.internal.connection.e connectionPool, u route, Socket socket, Socket socket2, Handshake handshake, Protocol protocol, z zVar, y yVar, int i10, ad.e eVar) {
        kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
        kotlin.jvm.internal.g.f(connectionPool, "connectionPool");
        kotlin.jvm.internal.g.f(route, "route");
        this.f8649b = taskRunner;
        this.f8650c = connectionPool;
        this.f8651d = route;
        this.f8652e = socket;
        this.f8653f = socket2;
        this.f8654g = handshake;
        this.h = protocol;
        this.f8655i = zVar;
        this.f8656j = yVar;
        this.f8657k = i10;
        this.f8658l = eVar;
        this.f8664s = 1;
        this.f8665t = new ArrayList();
        this.f8666u = Long.MAX_VALUE;
    }

    public static void e(n nVar, u failedRoute, IOException failure) {
        kotlin.jvm.internal.g.f(failedRoute, "failedRoute");
        kotlin.jvm.internal.g.f(failure, "failure");
        if (failedRoute.f177b.type() != Proxy.Type.DIRECT) {
            okhttp3.a aVar = failedRoute.f176a;
            aVar.f10929g.connectFailed(aVar.h.j(), failedRoute.f177b.address(), failure);
        }
        stepos.support.v7.app.palette.b bVar = nVar.C;
        synchronized (bVar) {
            ((LinkedHashSet) bVar.h).add(failedRoute);
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.b
    public final synchronized void a(Http2Connection http2Connection, hd.e settings) {
        try {
            kotlin.jvm.internal.g.f(settings, "settings");
            int i10 = this.f8664s;
            int i11 = (settings.f9426a & 16) != 0 ? settings.f9427b[4] : Integer.MAX_VALUE;
            this.f8664s = i11;
            if (i11 < i10) {
                okhttp3.internal.connection.e eVar = this.f8650c;
                okhttp3.a address = this.f8651d.f176a;
                eVar.getClass();
                kotlin.jvm.internal.g.f(address, "address");
                e.a aVar = eVar.f11065e.get(address);
                if (aVar != null) {
                    eVar.b(aVar);
                    throw null;
                }
            } else if (i11 > i10) {
                okhttp3.internal.connection.e eVar2 = this.f8650c;
                eVar2.f11066f.d(eVar2.f11067g, 0L);
            }
        } finally {
        }
    }

    @Override // fd.d.a
    public final void b() {
        synchronized (this) {
            this.f8660n = true;
            lb.n nVar = lb.n.f10413a;
        }
        this.f8658l.getClass();
    }

    @Override // okhttp3.internal.http2.Http2Connection.b
    public final void c(okhttp3.internal.http2.e eVar) {
        eVar.c(ErrorCode.f11125j, null);
    }

    @Override // fd.d.a
    public final void cancel() {
        Socket socket = this.f8652e;
        if (socket != null) {
            l.c(socket);
        }
    }

    @Override // fd.d.a
    public final u d() {
        return this.f8651d;
    }

    @Override // fd.d.a
    public final void f(okhttp3.internal.connection.d dVar, IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (!(iOException instanceof StreamResetException)) {
                    if (!(this.f8659m != null) || (iOException instanceof ConnectionShutdownException)) {
                        z = !this.f8660n;
                        this.f8660n = true;
                        if (this.f8663q == 0) {
                            if (iOException != null) {
                                e(dVar.f11040a, this.f8651d, iOException);
                            }
                            this.f8662p++;
                        }
                    }
                } else if (((StreamResetException) iOException).f11191a == ErrorCode.f11125j) {
                    int i10 = this.r + 1;
                    this.r = i10;
                    if (i10 > 1) {
                        z = !this.f8660n;
                        this.f8660n = true;
                        this.f8662p++;
                    }
                } else if (((StreamResetException) iOException).f11191a != ErrorCode.f11126k || !dVar.f11053s) {
                    z = !this.f8660n;
                    this.f8660n = true;
                    this.f8662p++;
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.f8658l.getClass();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(okhttp3.a r10, java.util.List<ad.u> r11) {
        /*
            r9 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.g.f(r10, r0)
            okhttp3.g r0 = r10.h
            okhttp3.f r1 = bd.l.f3237a
            java.util.ArrayList r1 = r9.f8665t
            int r1 = r1.size()
            int r2 = r9.f8664s
            r3 = 0
            if (r1 >= r2) goto Lc2
            boolean r1 = r9.f8660n
            if (r1 == 0) goto L1a
            goto Lc2
        L1a:
            ad.u r1 = r9.f8651d
            okhttp3.a r2 = r1.f176a
            okhttp3.a r4 = r1.f176a
            boolean r2 = r2.a(r10)
            if (r2 != 0) goto L28
            goto Lc2
        L28:
            java.lang.String r2 = r0.f10980d
            java.lang.String r5 = r0.f10980d
            okhttp3.g r6 = r4.h
            java.lang.String r6 = r6.f10980d
            boolean r2 = kotlin.jvm.internal.g.b(r2, r6)
            r6 = 1
            if (r2 == 0) goto L38
            return r6
        L38:
            okhttp3.internal.http2.Http2Connection r2 = r9.f8659m
            if (r2 != 0) goto L3e
            goto Lc2
        L3e:
            if (r11 == 0) goto Lc2
            boolean r2 = r11.isEmpty()
            if (r2 == 0) goto L48
            goto Lc2
        L48:
            java.util.Iterator r11 = r11.iterator()
        L4c:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto Lc2
            java.lang.Object r2 = r11.next()
            ad.u r2 = (ad.u) r2
            java.net.Proxy r7 = r2.f177b
            java.net.Proxy$Type r7 = r7.type()
            java.net.Proxy$Type r8 = java.net.Proxy.Type.DIRECT
            if (r7 != r8) goto L4c
            java.net.Proxy r7 = r1.f177b
            java.net.Proxy$Type r7 = r7.type()
            if (r7 != r8) goto L4c
            java.net.InetSocketAddress r7 = r1.f178c
            java.net.InetSocketAddress r2 = r2.f178c
            boolean r2 = kotlin.jvm.internal.g.b(r7, r2)
            if (r2 == 0) goto L4c
            javax.net.ssl.HostnameVerifier r11 = r10.f10926d
            od.d r1 = od.d.f10858a
            if (r11 == r1) goto L7b
            goto Lc2
        L7b:
            okhttp3.f r11 = bd.l.f3237a
            okhttp3.g r11 = r4.h
            int r0 = r0.f10981e
            int r1 = r11.f10981e
            if (r0 == r1) goto L86
            goto Lc2
        L86:
            java.lang.String r11 = r11.f10980d
            boolean r11 = kotlin.jvm.internal.g.b(r5, r11)
            okhttp3.Handshake r0 = r9.f8654g
            if (r11 == 0) goto L91
            goto Lb2
        L91:
            boolean r9 = r9.f8661o
            if (r9 != 0) goto Lc2
            if (r0 == 0) goto Lc2
            java.util.List r9 = r0.a()
            boolean r11 = r9.isEmpty()
            if (r11 != 0) goto Lc2
            java.lang.Object r9 = r9.get(r3)
            java.lang.String r11 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.g.d(r9, r11)
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9
            boolean r9 = od.d.c(r5, r9)
            if (r9 == 0) goto Lc2
        Lb2:
            okhttp3.CertificatePinner r9 = r10.f10927e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc2
            kotlin.jvm.internal.g.c(r9)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc2
            kotlin.jvm.internal.g.c(r0)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc2
            java.util.List r10 = r0.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc2
            r9.a(r5, r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc2
            return r6
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ed.g.g(okhttp3.a, java.util.List):boolean");
    }

    public final boolean h(boolean z) throws SocketException {
        long j10;
        okhttp3.f fVar = l.f3237a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f8652e;
        kotlin.jvm.internal.g.c(socket);
        Socket socket2 = this.f8653f;
        kotlin.jvm.internal.g.c(socket2);
        kotlin.jvm.internal.g.c(this.f8655i);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f8659m;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.h) {
                    return false;
                }
                if (http2Connection.r < http2Connection.f11141q) {
                    if (jNanoTime >= http2Connection.f11142s) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j10 = jNanoTime - this.f8666u;
        }
        if (j10 < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !r4.f0();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final void i() throws SocketException {
        this.f8666u = System.nanoTime();
        Protocol protocol = this.h;
        if (protocol == Protocol.h || protocol == Protocol.f10883j) {
            Socket socket = this.f8653f;
            kotlin.jvm.internal.g.c(socket);
            h hVar = this.f8655i;
            kotlin.jvm.internal.g.c(hVar);
            sd.g gVar = this.f8656j;
            kotlin.jvm.internal.g.c(gVar);
            socket.setSoTimeout(0);
            Object obj = this.f8658l;
            okhttp3.internal.http2.a aVar = obj instanceof okhttp3.internal.http2.a ? (okhttp3.internal.http2.a) obj : null;
            if (aVar == null) {
                aVar = a.C0121a.f11192a;
            }
            Http2Connection.a aVar2 = new Http2Connection.a(this.f8649b);
            String peerName = this.f8651d.f176a.h.f10980d;
            kotlin.jvm.internal.g.f(peerName, "peerName");
            aVar2.f11161b = socket;
            String str = l.f3239c + ' ' + peerName;
            kotlin.jvm.internal.g.f(str, "<set-?>");
            aVar2.f11162c = str;
            aVar2.f11163d = hVar;
            aVar2.f11164e = gVar;
            aVar2.f11165f = this;
            aVar2.h = this.f8657k;
            aVar2.f11167i = aVar;
            Http2Connection http2Connection = new Http2Connection(aVar2);
            this.f8659m = http2Connection;
            hd.e eVar = Http2Connection.D;
            this.f8664s = (eVar.f9426a & 16) != 0 ? eVar.f9427b[4] : Integer.MAX_VALUE;
            okhttp3.internal.http2.f fVar = http2Connection.A;
            synchronized (fVar) {
                try {
                    if (fVar.f11251d) {
                        throw new IOException("closed");
                    }
                    Logger logger = okhttp3.internal.http2.f.h;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(l.d(">> CONNECTION " + hd.b.f9415b.e(), new Object[0]));
                    }
                    fVar.f11248a.z0(hd.b.f9415b);
                    fVar.f11248a.flush();
                } finally {
                }
            }
            okhttp3.internal.http2.f fVar2 = http2Connection.A;
            hd.e settings = http2Connection.f11144u;
            synchronized (fVar2) {
                try {
                    kotlin.jvm.internal.g.f(settings, "settings");
                    if (fVar2.f11251d) {
                        throw new IOException("closed");
                    }
                    fVar2.w(0, Integer.bitCount(settings.f9426a) * 6, 4, 0);
                    int i10 = 0;
                    while (i10 < 10) {
                        boolean z = true;
                        if (((1 << i10) & settings.f9426a) == 0) {
                            z = false;
                        }
                        if (z) {
                            fVar2.f11248a.writeShort(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                            fVar2.f11248a.writeInt(settings.f9427b[i10]);
                        }
                        i10++;
                    }
                    fVar2.f11248a.flush();
                } finally {
                }
            }
            if (http2Connection.f11144u.a() != 65535) {
                http2Connection.A.S(0, r8 - 65535);
            }
            dd.d.c(http2Connection.f11134j.e(), http2Connection.f11131c, 0L, http2Connection.B, 6);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Connection{");
        u uVar = this.f8651d;
        sb2.append(uVar.f176a.h.f10980d);
        sb2.append(':');
        sb2.append(uVar.f176a.h.f10981e);
        sb2.append(", proxy=");
        sb2.append(uVar.f177b);
        sb2.append(" hostAddress=");
        sb2.append(uVar.f178c);
        sb2.append(" cipherSuite=");
        Handshake handshake = this.f8654g;
        if (handshake == null || (obj = handshake.f10874b) == null) {
            obj = ModelManifest.BACKEND_NONE;
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.h);
        sb2.append('}');
        return sb2.toString();
    }
}
