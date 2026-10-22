package r6;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import k4.z;
import okhttp3.internal.platform.Platform;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements u, s6.e {

    /* renamed from: a, reason: collision with root package name */
    public final q6.d f5107a;

    /* renamed from: b, reason: collision with root package name */
    public final q f5108b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5109c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5110e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5111f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5112g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f5113h;

    /* renamed from: i, reason: collision with root package name */
    public final o f5114i;

    /* renamed from: j, reason: collision with root package name */
    public final r f5115j;

    /* renamed from: k, reason: collision with root package name */
    public final n6.x f5116k;

    /* renamed from: l, reason: collision with root package name */
    public final List f5117l;

    /* renamed from: m, reason: collision with root package name */
    public final n6.s f5118m;

    /* renamed from: n, reason: collision with root package name */
    public final int f5119n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f5120o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f5121p;

    /* renamed from: q, reason: collision with root package name */
    public Socket f5122q;

    /* renamed from: r, reason: collision with root package name */
    public Socket f5123r;

    /* renamed from: s, reason: collision with root package name */
    public n6.j f5124s;

    /* renamed from: t, reason: collision with root package name */
    public n6.r f5125t;

    /* renamed from: u, reason: collision with root package name */
    public a4.d f5126u;

    /* renamed from: v, reason: collision with root package name */
    public p f5127v;

    public c(q6.d taskRunner, q connectionPool, int i8, int i9, int i10, int i11, int i12, boolean z, o oVar, r rVar, n6.x route, List list, n6.s sVar, int i13, boolean z2) {
        kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.e(connectionPool, "connectionPool");
        kotlin.jvm.internal.p.e(route, "route");
        this.f5107a = taskRunner;
        this.f5108b = connectionPool;
        this.f5109c = i8;
        this.d = i9;
        this.f5110e = i10;
        this.f5111f = i11;
        this.f5112g = i12;
        this.f5113h = z;
        this.f5114i = oVar;
        this.f5115j = rVar;
        this.f5116k = route;
        this.f5117l = list;
        this.f5118m = sVar;
        this.f5119n = i13;
        this.f5120o = z2;
    }

    @Override // r6.u
    public final u a() {
        return new c(this.f5107a, this.f5108b, this.f5109c, this.d, this.f5110e, this.f5111f, this.f5112g, this.f5113h, this.f5114i, this.f5115j, this.f5116k, this.f5117l, this.f5118m, this.f5119n, this.f5120o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0141 A[Catch: all -> 0x003e, TryCatch #9 {all -> 0x003e, blocks: (B:7:0x0024, B:9:0x0028, B:20:0x0047, B:23:0x004e, B:25:0x0052, B:27:0x005e, B:29:0x0062, B:31:0x006e, B:32:0x0091, B:48:0x00c6, B:50:0x00c9, B:52:0x00cc, B:54:0x00d8, B:56:0x00e2, B:58:0x00e6, B:60:0x00f1, B:83:0x0137, B:85:0x0141, B:88:0x0146, B:91:0x014b, B:93:0x014f, B:96:0x0158, B:99:0x015d, B:103:0x0163, B:73:0x011f, B:74:0x0122, B:36:0x00a3, B:37:0x00a6, B:38:0x00a7, B:39:0x00ae, B:40:0x00af, B:41:0x00b2, B:42:0x00b3, B:46:0x00c2, B:45:0x00c0), top: B:129:0x0024 }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, r6.q] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // r6.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r6.t c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.c.c():r6.t");
    }

    @Override // r6.u, s6.e
    public final void cancel() throws IOException {
        this.f5121p = true;
        Socket socket = this.f5122q;
        if (socket != null) {
            o6.f.c(socket);
        }
    }

    @Override // r6.u
    public final p d() throws IOException {
        androidx.emoji2.text.m mVar = this.f5114i.f5157a.B;
        n6.x route = this.f5116k;
        synchronized (mVar) {
            kotlin.jvm.internal.p.e(route, "route");
            ((LinkedHashSet) mVar.f621a).remove(route);
        }
        p pVar = this.f5127v;
        kotlin.jvm.internal.p.b(pVar);
        kotlin.jvm.internal.p.e(this.f5116k, "route");
        s sVarD = this.f5115j.d(this, this.f5117l);
        if (sVarD != null) {
            return sVarD.f5209a;
        }
        synchronized (pVar) {
            q qVar = this.f5108b;
            qVar.getClass();
            TimeZone timeZone = o6.f.f4330a;
            qVar.d.add(pVar);
            qVar.f5191b.c(qVar.f5192c, 0L);
            this.f5114i.b(pVar);
        }
        return pVar;
    }

    @Override // s6.e
    public final n6.x e() {
        return this.f5116k;
    }

    @Override // r6.u
    public final t f() throws IOException {
        Socket socket;
        Socket socket2;
        q qVar = this.f5108b;
        n6.x xVar = this.f5116k;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5114i.f5173s;
        if (this.f5122q != null) {
            throw new IllegalStateException("TCP already connected");
        }
        copyOnWriteArrayList.add(this);
        boolean z = false;
        try {
            try {
                InetSocketAddress inetSocketAddress = xVar.f4165c;
                kotlin.jvm.internal.p.e(inetSocketAddress, "inetSocketAddress");
                qVar.getClass();
                h();
                z = true;
                t tVar = new t(this, (Throwable) null, 6);
                copyOnWriteArrayList.remove(this);
                return tVar;
            } catch (IOException e9) {
                n6.a aVar = xVar.f4163a;
                if (xVar.f4164b.type() != Proxy.Type.DIRECT) {
                    n6.a aVar2 = xVar.f4163a;
                    aVar2.f3991g.connectFailed(aVar2.f3992h.g(), xVar.f4164b.address(), e9);
                }
                InetSocketAddress inetSocketAddress2 = xVar.f4165c;
                kotlin.jvm.internal.p.e(inetSocketAddress2, "inetSocketAddress");
                qVar.getClass();
                t tVar2 = new t(this, e9, 2);
                copyOnWriteArrayList.remove(this);
                if (!z && (socket = this.f5122q) != null) {
                    o6.f.c(socket);
                }
                return tVar2;
            }
        } catch (Throwable th) {
            copyOnWriteArrayList.remove(this);
            if (!z && (socket2 = this.f5122q) != null) {
                o6.f.c(socket2);
            }
            throw th;
        }
    }

    public final void h() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = this.f5116k.f4164b.type();
        int i8 = type == null ? -1 : b.f5106a[type.ordinal()];
        if (i8 == 1 || i8 == 2) {
            socketCreateSocket = this.f5116k.f4163a.f3987b.createSocket();
            kotlin.jvm.internal.p.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(this.f5116k.f4164b);
        }
        this.f5122q = socketCreateSocket;
        if (this.f5121p) {
            throw new IOException("canceled");
        }
        socketCreateSocket.setSoTimeout(this.f5111f);
        try {
            Platform.INSTANCE.get().connectSocket(socketCreateSocket, this.f5116k.f4165c, this.f5110e);
            try {
                this.f5126u = new a4.d(new a1.w(socketCreateSocket));
            } catch (NullPointerException e9) {
                if (kotlin.jvm.internal.p.a(e9.getMessage(), "throw with null exception")) {
                    throw new IOException(e9);
                }
            }
        } catch (ConnectException e10) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f5116k.f4165c);
            connectException.initCause(e10);
            throw connectException;
        }
    }

    public final void i(SSLSocket sSLSocket, n6.h hVar) throws IOException {
        n6.r rVarD;
        boolean z = hVar.f4035b;
        n6.a aVar = this.f5116k.f4163a;
        n6.m mVar = aVar.f3992h;
        if (z) {
            try {
                Platform.INSTANCE.get().configureTlsExtensions(sSLSocket, mVar.d, aVar.f3993i);
            } catch (Throwable th) {
                Platform.INSTANCE.get().afterHandshake(sSLSocket);
                o6.f.c(sSLSocket);
                throw th;
            }
        }
        sSLSocket.startHandshake();
        SSLSession session = sSLSocket.getSession();
        kotlin.jvm.internal.p.b(session);
        n6.j jVarR = z.r(session);
        HostnameVerifier hostnameVerifier = aVar.d;
        kotlin.jvm.internal.p.b(hostnameVerifier);
        String str = mVar.d;
        String hostname = mVar.d;
        if (hostnameVerifier.verify(str, session)) {
            n6.e eVar = aVar.f3989e;
            kotlin.jvm.internal.p.b(eVar);
            this.f5124s = new n6.j(jVarR.f4050a, jVarR.f4051b, jVarR.f4052c, new com.stepos.stepclaw.memory.embedding.g(eVar, jVarR, aVar, 4));
            kotlin.jvm.internal.p.e(hostname, "hostname");
            Iterator it = eVar.f4011a.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            String selectedProtocol = z ? Platform.INSTANCE.get().getSelectedProtocol(sSLSocket) : null;
            this.f5123r = sSLSocket;
            this.f5126u = new a4.d(new a1.w(sSLSocket));
            if (selectedProtocol != null) {
                n6.r.f4119b.getClass();
                rVarD = n6.b.d(selectedProtocol);
            } else {
                rVarD = n6.r.d;
            }
            this.f5125t = rVarD;
            Platform.INSTANCE.get().afterHandshake(sSLSocket);
            return;
        }
        List listA = jVarR.a();
        if (listA.isEmpty()) {
            throw new SSLPeerUnverifiedException("Hostname " + hostname + " not verified (no certificates)");
        }
        Object obj = listA.get(0);
        kotlin.jvm.internal.p.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate x509Certificate = (X509Certificate) obj;
        StringBuilder sb = new StringBuilder("\n            |Hostname ");
        sb.append(hostname);
        sb.append(" not verified:\n            |    certificate: ");
        n6.e eVar2 = n6.e.f4010c;
        StringBuilder sb2 = new StringBuilder("sha256/");
        c7.i iVar = c7.i.d;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        kotlin.jvm.internal.p.d(encoded, "getEncoded(...)");
        sb2.append(t1.f.j(encoded).b("SHA-256").a());
        sb.append(sb2.toString());
        sb.append("\n            |    DN: ");
        sb.append(x509Certificate.getSubjectDN().getName());
        sb.append("\n            |    subjectAltNames: ");
        sb.append(c5.m.E0(z6.e.a(x509Certificate, 7), z6.e.a(x509Certificate, 2)));
        sb.append("\n            ");
        throw new SSLPeerUnverifiedException(x5.o.R0(sb.toString()));
    }

    @Override // r6.u
    public final boolean isReady() {
        return this.f5125t != null;
    }

    public final t j() throws IOException, NumberFormatException {
        n6.s sVar = this.f5118m;
        kotlin.jvm.internal.p.b(sVar);
        n6.x xVar = this.f5116k;
        String str = "CONNECT " + o6.f.i(xVar.f4163a.f3992h, true) + " HTTP/1.1";
        a4.d dVar = this.f5126u;
        if (dVar == null) {
            kotlin.jvm.internal.p.l("socket");
            throw null;
        }
        t6.f fVar = new t6.f(null, this, dVar);
        a4.d dVar2 = this.f5126u;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.l("socket");
            throw null;
        }
        c7.x xVarD = ((c7.p) dVar2.f97c).f1184a.d();
        long j4 = this.f5109c;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        xVarD.g(j4, timeUnit);
        a4.d dVar3 = this.f5126u;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.l("socket");
            throw null;
        }
        ((c7.o) dVar3.d).f1181a.d().g(this.d, timeUnit);
        fVar.j(sVar.f4130c, str);
        fVar.a();
        n6.t tVarG = fVar.g();
        tVarG.f4132a = sVar;
        n6.u uVarA = tVarG.a();
        int i8 = uVarA.d;
        long jE = o6.f.e(uVarA);
        if (jE != -1) {
            t6.d dVarI = fVar.i(uVarA.f4146a.f4128a, jE);
            o6.f.g(dVarI, Integer.MAX_VALUE);
            dVarI.close();
        }
        if (i8 == 200) {
            return new t(this, (Throwable) null, 6);
        }
        if (i8 != 407) {
            throw new IOException(a8.b.j(i8, "Unexpected response code for CONNECT: "));
        }
        xVar.f4163a.f3990f.getClass();
        throw new IOException("Failed to authenticate with proxy");
    }

    public final c k(List connectionSpecs, SSLSocket sSLSocket) {
        String[] strArr;
        String[] strArr2;
        kotlin.jvm.internal.p.e(connectionSpecs, "connectionSpecs");
        int i8 = this.f5119n;
        int size = connectionSpecs.size();
        for (int i9 = i8 + 1; i9 < size; i9++) {
            n6.h hVar = (n6.h) connectionSpecs.get(i9);
            hVar.getClass();
            if (hVar.f4034a && (((strArr = hVar.d) == null || o6.d.e(strArr, sSLSocket.getEnabledProtocols(), e5.a.f2366b)) && ((strArr2 = hVar.f4036c) == null || o6.d.e(strArr2, sSLSocket.getEnabledCipherSuites(), n6.g.f4014c)))) {
                return new c(this.f5107a, this.f5108b, this.f5109c, this.d, this.f5110e, this.f5111f, this.f5112g, this.f5113h, this.f5114i, this.f5115j, this.f5116k, this.f5117l, this.f5118m, i9, i8 != -1);
            }
        }
        return null;
    }

    public final c l(List connectionSpecs, SSLSocket sSLSocket) throws UnknownServiceException {
        kotlin.jvm.internal.p.e(connectionSpecs, "connectionSpecs");
        if (this.f5119n != -1) {
            return this;
        }
        c cVarK = k(connectionSpecs, sSLSocket);
        if (cVarK != null) {
            return cVarK;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f5120o);
        sb.append(", modes=");
        sb.append(connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        kotlin.jvm.internal.p.b(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        kotlin.jvm.internal.p.d(string, "toString(...)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // s6.e
    public final void g() {
    }

    @Override // s6.e
    public final void b(o oVar, IOException iOException) {
    }
}
