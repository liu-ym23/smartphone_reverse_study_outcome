package r6;

import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.digests.Blake2xsDigest;
import org.tukaani.xz.common.Util;
import u6.a0;
import u6.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p extends u6.l implements s6.e {

    /* renamed from: b, reason: collision with root package name */
    public final q6.d f5174b;

    /* renamed from: c, reason: collision with root package name */
    public final n6.x f5175c;
    public final Socket d;

    /* renamed from: e, reason: collision with root package name */
    public final Socket f5176e;

    /* renamed from: f, reason: collision with root package name */
    public final n6.j f5177f;

    /* renamed from: g, reason: collision with root package name */
    public final n6.r f5178g;

    /* renamed from: h, reason: collision with root package name */
    public final a4.d f5179h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5180i;

    /* renamed from: j, reason: collision with root package name */
    public u6.n f5181j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5182k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5183l;

    /* renamed from: m, reason: collision with root package name */
    public int f5184m;

    /* renamed from: n, reason: collision with root package name */
    public int f5185n;

    /* renamed from: o, reason: collision with root package name */
    public int f5186o;

    /* renamed from: p, reason: collision with root package name */
    public int f5187p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f5188q;

    /* renamed from: r, reason: collision with root package name */
    public long f5189r;

    public p(q6.d taskRunner, q connectionPool, n6.x route, Socket rawSocket, Socket javaNetSocket, n6.j jVar, n6.r protocol, a4.d socket, int i8) {
        kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.e(connectionPool, "connectionPool");
        kotlin.jvm.internal.p.e(route, "route");
        kotlin.jvm.internal.p.e(rawSocket, "rawSocket");
        kotlin.jvm.internal.p.e(javaNetSocket, "javaNetSocket");
        kotlin.jvm.internal.p.e(protocol, "protocol");
        kotlin.jvm.internal.p.e(socket, "socket");
        this.f5174b = taskRunner;
        this.f5175c = route;
        this.d = rawSocket;
        this.f5176e = javaNetSocket;
        this.f5177f = jVar;
        this.f5178g = protocol;
        this.f5179h = socket;
        this.f5180i = i8;
        this.f5187p = 1;
        this.f5188q = new ArrayList();
        this.f5189r = Util.VLI_MAX;
    }

    public static void d(n6.q qVar, n6.x failedRoute, IOException failure) {
        kotlin.jvm.internal.p.e(failedRoute, "failedRoute");
        kotlin.jvm.internal.p.e(failure, "failure");
        if (failedRoute.f4164b.type() != Proxy.Type.DIRECT) {
            n6.a aVar = failedRoute.f4163a;
            aVar.f3991g.connectFailed(aVar.f3992h.g(), failedRoute.f4164b.address(), failure);
        }
        androidx.emoji2.text.m mVar = qVar.B;
        synchronized (mVar) {
            ((LinkedHashSet) mVar.f621a).add(failedRoute);
        }
    }

    @Override // u6.l
    public final void a(u6.n nVar, z settings) {
        kotlin.jvm.internal.p.e(settings, "settings");
        synchronized (this) {
            this.f5187p = (settings.f5781a & 8) != 0 ? settings.f5782b[3] : Integer.MAX_VALUE;
        }
    }

    @Override // s6.e
    public final void b(o oVar, IOException iOException) {
        synchronized (this) {
            try {
                if (!(iOException instanceof a0)) {
                    if (!(this.f5181j != null) || (iOException instanceof u6.a)) {
                        this.f5182k = true;
                        if (this.f5185n == 0) {
                            if (iOException != null) {
                                d(oVar.f5157a, this.f5175c, iOException);
                            }
                            this.f5184m++;
                        }
                    }
                } else if (((a0) iOException).f5669a == u6.b.f5674g) {
                    int i8 = this.f5186o + 1;
                    this.f5186o = i8;
                    if (i8 > 1) {
                        this.f5182k = true;
                        this.f5184m++;
                    }
                } else if (((a0) iOException).f5669a != u6.b.f5675h || !oVar.f5171q) {
                    this.f5182k = true;
                    this.f5184m++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // u6.l
    public final void c(u6.v vVar) {
        vVar.e(u6.b.f5674g, null);
    }

    @Override // s6.e
    public final void cancel() throws IOException {
        o6.f.c(this.d);
    }

    @Override // s6.e
    public final n6.x e() {
        return this.f5175c;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(n6.a r11, java.util.List r12) {
        /*
            r10 = this;
            java.lang.String r0 = "hostname"
            n6.m r1 = r11.f3992h
            java.util.TimeZone r2 = o6.f.f4330a
            java.util.ArrayList r2 = r10.f5188q
            int r2 = r2.size()
            int r3 = r10.f5187p
            r4 = 0
            if (r2 >= r3) goto Ldd
            boolean r2 = r10.f5182k
            if (r2 == 0) goto L17
            goto Ldd
        L17:
            n6.x r2 = r10.f5175c
            n6.a r3 = r2.f4163a
            n6.a r5 = r2.f4163a
            boolean r3 = r3.a(r11)
            if (r3 != 0) goto L25
            goto Ldd
        L25:
            java.lang.String r3 = r1.d
            java.lang.String r6 = r1.d
            n6.m r7 = r5.f3992h
            java.lang.String r7 = r7.d
            boolean r3 = kotlin.jvm.internal.p.a(r3, r7)
            r7 = 1
            if (r3 == 0) goto L35
            return r7
        L35:
            u6.n r3 = r10.f5181j
            if (r3 != 0) goto L3b
            goto Ldd
        L3b:
            if (r12 == 0) goto Ldd
            boolean r3 = r12.isEmpty()
            if (r3 == 0) goto L45
            goto Ldd
        L45:
            java.util.Iterator r12 = r12.iterator()
        L49:
            boolean r3 = r12.hasNext()
            if (r3 == 0) goto Ldd
            java.lang.Object r3 = r12.next()
            n6.x r3 = (n6.x) r3
            java.net.Proxy r8 = r3.f4164b
            java.net.Proxy$Type r8 = r8.type()
            java.net.Proxy$Type r9 = java.net.Proxy.Type.DIRECT
            if (r8 != r9) goto L49
            java.net.Proxy r8 = r2.f4164b
            java.net.Proxy$Type r8 = r8.type()
            if (r8 != r9) goto L49
            java.net.InetSocketAddress r8 = r2.f4165c
            java.net.InetSocketAddress r3 = r3.f4165c
            boolean r3 = kotlin.jvm.internal.p.a(r8, r3)
            if (r3 == 0) goto L49
            javax.net.ssl.HostnameVerifier r12 = r11.d
            z6.e r2 = z6.e.f6547a
            if (r12 == r2) goto L78
            goto Ldd
        L78:
            java.util.TimeZone r12 = o6.f.f4330a
            n6.m r12 = r5.f3992h
            int r1 = r1.f4066e
            int r2 = r12.f4066e
            if (r1 == r2) goto L83
            goto Ldd
        L83:
            java.lang.String r12 = r12.d
            boolean r12 = kotlin.jvm.internal.p.a(r6, r12)
            n6.j r1 = r10.f5177f
            if (r12 == 0) goto L8e
            goto Laf
        L8e:
            boolean r10 = r10.f5183l
            if (r10 != 0) goto Ldd
            if (r1 == 0) goto Ldd
            java.util.List r10 = r1.a()
            boolean r12 = r10.isEmpty()
            if (r12 != 0) goto Ldd
            java.lang.Object r10 = r10.get(r4)
            java.lang.String r12 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.p.c(r10, r12)
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            boolean r10 = z6.e.c(r6, r10)
            if (r10 == 0) goto Ldd
        Laf:
            n6.e r10 = r11.f3989e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            kotlin.jvm.internal.p.b(r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            kotlin.jvm.internal.p.b(r1)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            java.util.List r11 = r1.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            kotlin.jvm.internal.p.e(r6, r0)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            java.lang.String r12 = "peerCertificates"
            kotlin.jvm.internal.p.e(r11, r12)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            java.util.Set r10 = r10.f4011a     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            java.util.Iterator r10 = r10.iterator()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            boolean r11 = r10.hasNext()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            if (r11 != 0) goto Ld0
            return r7
        Ld0:
            java.lang.Object r10 = r10.next()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            r10.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            java.lang.ClassCastException r10 = new java.lang.ClassCastException     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            r10.<init>()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
            throw r10     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Ldd
        Ldd:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.p.f(n6.a, java.util.List):boolean");
    }

    @Override // s6.e
    public final void g() {
        synchronized (this) {
            this.f5182k = true;
        }
    }

    public final boolean h(boolean z) throws SocketException {
        long j4;
        TimeZone timeZone = o6.f.f4330a;
        long jNanoTime = System.nanoTime();
        if (this.d.isClosed() || this.f5176e.isClosed() || this.f5176e.isInputShutdown() || this.f5176e.isOutputShutdown()) {
            return false;
        }
        u6.n nVar = this.f5181j;
        if (nVar != null) {
            synchronized (nVar) {
                if (nVar.f5718f) {
                    return false;
                }
                if (nVar.f5727p < nVar.f5726o) {
                    if (jNanoTime >= nVar.f5728q) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j4 = jNanoTime - this.f5189r;
        }
        if (j4 < 10000000000L || !z) {
            return true;
        }
        Socket socket = this.f5176e;
        c7.p source = (c7.p) this.f5179h.f97c;
        kotlin.jvm.internal.p.e(socket, "<this>");
        kotlin.jvm.internal.p.e(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.q();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final void i() throws SocketException {
        this.f5189r = System.nanoTime();
        n6.r rVar = this.f5178g;
        if (rVar == n6.r.f4122f || rVar == n6.r.f4123g) {
            this.f5176e.setSoTimeout(0);
            u6.c cVar = u6.c.f5678a;
            g.n nVar = new g.n(this.f5174b);
            a4.d socket = this.f5179h;
            String peerName = this.f5175c.f4163a.f3992h.d;
            kotlin.jvm.internal.p.e(socket, "socket");
            kotlin.jvm.internal.p.e(peerName, "peerName");
            nVar.f2783c = socket;
            String str = o6.f.f4331b + ' ' + peerName;
            kotlin.jvm.internal.p.e(str, "<set-?>");
            nVar.d = str;
            nVar.f2784e = this;
            nVar.f2781a = this.f5180i;
            nVar.f2785f = cVar;
            u6.n nVar2 = new u6.n(nVar);
            this.f5181j = nVar2;
            z zVar = u6.n.B;
            this.f5187p = (zVar.f5781a & 8) != 0 ? zVar.f5782b[3] : Integer.MAX_VALUE;
            u6.w wVar = nVar2.y;
            synchronized (wVar) {
                try {
                    if (wVar.d) {
                        throw new IOException("closed");
                    }
                    Logger logger = u6.w.f5772f;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(o6.f.d(">> CONNECTION " + u6.h.f5702a.d(), new Object[0]));
                    }
                    wVar.f5773a.r(u6.h.f5702a);
                    wVar.f5773a.flush();
                } catch (Throwable th) {
                    throw th;
                }
            }
            u6.w wVar2 = nVar2.y;
            z settings = nVar2.f5730s;
            wVar2.getClass();
            kotlin.jvm.internal.p.e(settings, "settings");
            synchronized (wVar2) {
                try {
                    if (wVar2.d) {
                        throw new IOException("closed");
                    }
                    wVar2.e(0, Integer.bitCount(settings.f5781a) * 6, 4, 0);
                    for (int i8 = 0; i8 < 10; i8++) {
                        boolean z = true;
                        if (((1 << i8) & settings.f5781a) == 0) {
                            z = false;
                        }
                        if (z) {
                            wVar2.f5773a.writeShort(i8);
                            wVar2.f5773a.writeInt(settings.f5782b[i8]);
                        }
                    }
                    wVar2.f5773a.flush();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (nVar2.f5730s.a() != 65535) {
                nVar2.y.o(0, r7 - Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
            }
            q6.c.b(nVar2.f5719g.d(), nVar2.f5716c, 0L, nVar2.z, 6);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        n6.x xVar = this.f5175c;
        sb.append(xVar.f4163a.f3992h.d);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(xVar.f4163a.f3992h.f4066e);
        sb.append(", proxy=");
        sb.append(xVar.f4164b);
        sb.append(" hostAddress=");
        sb.append(xVar.f4165c);
        sb.append(" cipherSuite=");
        n6.j jVar = this.f5177f;
        if (jVar == null || (obj = jVar.f4051b) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f5178g);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
