package okhttp3.internal.connection;

import ad.u;
import bd.l;
import fd.d;
import gc.k;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import lb.n;
import mb.m;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.internal.connection.h;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.ByteString;
import sd.f0;
import sd.y;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConnectPlan implements h.b, d.a {

    /* renamed from: a, reason: collision with root package name */
    public final dd.e f11003a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11004b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11005c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11006d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11007e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11008f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11009g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final ed.c f11010i;

    /* renamed from: j, reason: collision with root package name */
    public final f f11011j;

    /* renamed from: k, reason: collision with root package name */
    public final u f11012k;

    /* renamed from: l, reason: collision with root package name */
    public final List<u> f11013l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11014m;

    /* renamed from: n, reason: collision with root package name */
    public final okhttp3.h f11015n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11016o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11017p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f11018q;
    public Socket r;

    /* renamed from: s, reason: collision with root package name */
    public Socket f11019s;

    /* renamed from: t, reason: collision with root package name */
    public Handshake f11020t;

    /* renamed from: u, reason: collision with root package name */
    public Protocol f11021u;

    /* renamed from: v, reason: collision with root package name */
    public z f11022v;

    /* renamed from: w, reason: collision with root package name */
    public y f11023w;

    /* renamed from: x, reason: collision with root package name */
    public ed.g f11024x;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11025a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f11025a = iArr;
        }
    }

    public ConnectPlan(dd.e taskRunner, e connectionPool, int i10, int i11, int i12, int i13, int i14, boolean z, ed.c user, f fVar, u route, List<u> list, int i15, okhttp3.h hVar, int i16, boolean z3) {
        kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
        kotlin.jvm.internal.g.f(connectionPool, "connectionPool");
        kotlin.jvm.internal.g.f(user, "user");
        kotlin.jvm.internal.g.f(route, "route");
        this.f11003a = taskRunner;
        this.f11004b = connectionPool;
        this.f11005c = i10;
        this.f11006d = i11;
        this.f11007e = i12;
        this.f11008f = i13;
        this.f11009g = i14;
        this.h = z;
        this.f11010i = user;
        this.f11011j = fVar;
        this.f11012k = route;
        this.f11013l = list;
        this.f11014m = i15;
        this.f11015n = hVar;
        this.f11016o = i16;
        this.f11017p = z3;
    }

    @Override // okhttp3.internal.connection.h.b
    public final ed.g a() {
        this.f11010i.q(this.f11012k);
        ed.g gVar = this.f11024x;
        kotlin.jvm.internal.g.c(gVar);
        this.f11010i.a(gVar, this.f11012k);
        g gVarH = this.f11011j.h(this, this.f11013l);
        if (gVarH != null) {
            return gVarH.f11084a;
        }
        synchronized (gVar) {
            e eVar = this.f11004b;
            eVar.getClass();
            okhttp3.f fVar = l.f3237a;
            eVar.h.add(gVar);
            eVar.f11066f.d(eVar.f11067g, 0L);
            this.f11010i.u(gVar);
            n nVar = n.f10413a;
        }
        this.f11010i.f(gVar);
        this.f11010i.r(gVar);
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004c A[Catch: all -> 0x002a, IOException -> 0x002e, TRY_ENTER, TryCatch #5 {all -> 0x002a, blocks: (B:7:0x0019, B:9:0x001d, B:11:0x0025, B:26:0x0047, B:29:0x004c, B:31:0x0050, B:33:0x0054, B:42:0x0069, B:43:0x0070, B:35:0x005a, B:37:0x005e, B:39:0x0062, B:44:0x0071, B:45:0x0099, B:55:0x00be, B:49:0x00aa, B:53:0x00bb, B:52:0x00b9), top: B:119:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa A[Catch: all -> 0x002a, IOException -> 0x0106, TRY_ENTER, TryCatch #2 {IOException -> 0x0106, blocks: (B:7:0x0019, B:26:0x0047, B:49:0x00aa, B:53:0x00bb, B:52:0x00b9), top: B:119:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:69:0x010b, B:71:0x0112, B:74:0x0117, B:77:0x011c, B:79:0x0120, B:82:0x0129, B:85:0x012e, B:90:0x0138), top: B:115:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0142  */
    @Override // okhttp3.internal.connection.h.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.internal.connection.h.a c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.c():okhttp3.internal.connection.h$a");
    }

    @Override // okhttp3.internal.connection.h.b, fd.d.a
    public final void cancel() {
        this.f11018q = true;
        Socket socket = this.r;
        if (socket != null) {
            l.c(socket);
        }
    }

    @Override // fd.d.a
    public final u d() {
        return this.f11012k;
    }

    @Override // okhttp3.internal.connection.h.b
    public final h.b e() {
        return new ConnectPlan(this.f11003a, this.f11004b, this.f11005c, this.f11006d, this.f11007e, this.f11008f, this.f11009g, this.h, this.f11010i, this.f11011j, this.f11012k, this.f11013l, this.f11014m, this.f11015n, this.f11016o, this.f11017p);
    }

    @Override // okhttp3.internal.connection.h.b
    public final h.a g() {
        Socket socket;
        Socket socket2;
        u uVar = this.f11012k;
        if (this.r != null) {
            throw new IllegalStateException("TCP already connected");
        }
        ed.c cVar = this.f11010i;
        cVar.w(this);
        boolean z = false;
        try {
            try {
                cVar.b(uVar);
                h();
                z = true;
                h.a aVar = new h.a(this, null, null, 6);
                cVar.n(this);
                return aVar;
            } catch (IOException e10) {
                cVar.j(uVar, e10);
                h.a aVar2 = new h.a(this, null, e10, 2);
                cVar.n(this);
                if (!z && (socket2 = this.r) != null) {
                    l.c(socket2);
                }
                return aVar2;
            }
        } catch (Throwable th) {
            cVar.n(this);
            if (!z && (socket = this.r) != null) {
                l.c(socket);
            }
            throw th;
        }
    }

    public final void h() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = this.f11012k.f177b.type();
        int i10 = type == null ? -1 : a.f11025a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            socketCreateSocket = this.f11012k.f176a.f10924b.createSocket();
            kotlin.jvm.internal.g.c(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(this.f11012k.f177b);
        }
        this.r = socketCreateSocket;
        if (this.f11018q) {
            throw new IOException("canceled");
        }
        socketCreateSocket.setSoTimeout(this.f11008f);
        try {
            kd.h.Companion.getClass();
            kd.h.platform.connectSocket(socketCreateSocket, this.f11012k.f178c, this.f11007e);
            try {
                this.f11022v = new z(jd.b.K(socketCreateSocket));
                this.f11023w = jd.b.i(jd.b.I(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (kotlin.jvm.internal.g.b(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f11012k.f178c);
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void i(SSLSocket sSLSocket, okhttp3.e eVar) {
        String selectedProtocol;
        Protocol protocolA;
        boolean z = eVar.f10968b;
        final okhttp3.a aVar = this.f11012k.f176a;
        if (z) {
            try {
                kd.h.Companion.getClass();
                kd.h.platform.configureTlsExtensions(sSLSocket, aVar.h.f10980d, aVar.f10930i);
            } catch (Throwable th) {
                kd.h.Companion.getClass();
                kd.h.platform.afterHandshake(sSLSocket);
                l.c(sSLSocket);
                throw th;
            }
        }
        sSLSocket.startHandshake();
        SSLSession session = sSLSocket.getSession();
        kotlin.jvm.internal.g.c(session);
        final Handshake handshakeA = Handshake.Companion.a(session);
        HostnameVerifier hostnameVerifier = aVar.f10926d;
        okhttp3.g gVar = aVar.h;
        kotlin.jvm.internal.g.c(hostnameVerifier);
        String str = gVar.f10980d;
        String str2 = gVar.f10980d;
        if (hostnameVerifier.verify(str, session)) {
            final CertificatePinner certificatePinner = aVar.f10927e;
            kotlin.jvm.internal.g.c(certificatePinner);
            final Handshake handshake = new Handshake(handshakeA.f10873a, handshakeA.f10874b, handshakeA.f10875c, new zb.a<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.ConnectPlan$connectTls$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // zb.a
                public final List<? extends Certificate> invoke() {
                    od.c cVar = certificatePinner.f10861b;
                    kotlin.jvm.internal.g.c(cVar);
                    return cVar.a(aVar.h.f10980d, handshakeA.a());
                }
            });
            this.f11020t = handshake;
            certificatePinner.b(str2, new zb.a<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.ConnectPlan$connectTls$1
                {
                    super(0);
                }

                @Override // zb.a
                public final List<? extends X509Certificate> invoke() {
                    List<Certificate> listA = handshake.a();
                    ArrayList arrayList = new ArrayList(m.Z(listA, 10));
                    for (Certificate certificate : listA) {
                        kotlin.jvm.internal.g.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                        arrayList.add((X509Certificate) certificate);
                    }
                    return arrayList;
                }
            });
            if (z) {
                kd.h.Companion.getClass();
                selectedProtocol = kd.h.platform.getSelectedProtocol(sSLSocket);
            } else {
                selectedProtocol = null;
            }
            this.f11019s = sSLSocket;
            this.f11022v = new z(jd.b.K(sSLSocket));
            this.f11023w = jd.b.i(jd.b.I(sSLSocket));
            if (selectedProtocol != null) {
                Protocol.f10879b.getClass();
                protocolA = Protocol.a.a(selectedProtocol);
            } else {
                protocolA = Protocol.f10881d;
            }
            this.f11021u = protocolA;
            kd.h.Companion.getClass();
            kd.h.platform.afterHandshake(sSLSocket);
            return;
        }
        List<Certificate> listA = handshakeA.a();
        if (listA.isEmpty()) {
            throw new SSLPeerUnverifiedException("Hostname " + str2 + " not verified (no certificates)");
        }
        Certificate certificate = listA.get(0);
        kotlin.jvm.internal.g.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate x509Certificate = (X509Certificate) certificate;
        StringBuilder sb2 = new StringBuilder("\n            |Hostname ");
        sb2.append(str2);
        sb2.append(" not verified:\n            |    certificate: ");
        CertificatePinner certificatePinner2 = CertificatePinner.f10859c;
        StringBuilder sb3 = new StringBuilder("sha256/");
        ByteString byteString = ByteString.f11312d;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        kotlin.jvm.internal.g.e(encoded, "getEncoded(...)");
        sb3.append(ByteString.a.c(encoded).c("SHA-256").a());
        sb2.append(sb3.toString());
        sb2.append("\n            |    DN: ");
        sb2.append(x509Certificate.getSubjectDN().getName());
        sb2.append("\n            |    subjectAltNames: ");
        sb2.append(kotlin.collections.a.D0(od.d.a(x509Certificate, 7), od.d.a(x509Certificate, 2)));
        sb2.append("\n            ");
        throw new SSLPeerUnverifiedException(k.a0(sb2.toString()));
    }

    @Override // okhttp3.internal.connection.h.b
    public final boolean isReady() {
        return this.f11021u != null;
    }

    public final h.a j() throws IOException {
        okhttp3.h hVar = this.f11015n;
        kotlin.jvm.internal.g.c(hVar);
        u uVar = this.f11012k;
        String str = "CONNECT " + l.k(uVar.f176a.h, true) + " HTTP/1.1";
        z zVar = this.f11022v;
        kotlin.jvm.internal.g.c(zVar);
        y yVar = this.f11023w;
        kotlin.jvm.internal.g.c(yVar);
        Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, zVar, yVar);
        f0 f0VarTimeout = zVar.f11986a.timeout();
        long j10 = this.f11005c;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        f0VarTimeout.g(j10, timeUnit);
        yVar.f11983a.timeout().g(this.f11006d, timeUnit);
        http1ExchangeCodec.l(hVar.f10994c, str);
        http1ExchangeCodec.a();
        Response.Builder builderF = http1ExchangeCodec.f(false);
        kotlin.jvm.internal.g.c(builderF);
        builderF.f10901a = hVar;
        Response responseA = builderF.a();
        int i10 = responseA.f10891d;
        long jE = l.e(responseA);
        if (jE != -1) {
            Http1ExchangeCodec.d dVarK = http1ExchangeCodec.k(jE);
            l.i(dVarK, Integer.MAX_VALUE);
            dVarK.close();
        }
        if (i10 == 200) {
            return new h.a(this, null, null, 6);
        }
        if (i10 != 407) {
            throw new IOException(ai.onnxruntime.providers.a.a(i10, "Unexpected response code for CONNECT: "));
        }
        uVar.f176a.f10928f.a(uVar, responseA);
        throw new IOException("Failed to authenticate with proxy");
    }

    public final ConnectPlan k(List<okhttp3.e> connectionSpecs, SSLSocket sSLSocket) {
        String[] strArr;
        String[] strArr2;
        kotlin.jvm.internal.g.f(connectionSpecs, "connectionSpecs");
        int i10 = this.f11016o;
        int i11 = i10 + 1;
        int size = connectionSpecs.size();
        while (i11 < size) {
            okhttp3.e eVar = connectionSpecs.get(i11);
            eVar.getClass();
            if (eVar.f10967a && (((strArr = eVar.f10970d) == null || bd.i.f(strArr, sSLSocket.getEnabledProtocols(), ob.c.f10852a)) && ((strArr2 = eVar.f10969c) == null || bd.i.f(strArr2, sSLSocket.getEnabledCipherSuites(), okhttp3.c.f10946c)))) {
                boolean z = i10 != -1;
                int i12 = (3 & 1) != 0 ? this.f11014m : 0;
                okhttp3.h hVar = (3 & 2) != 0 ? this.f11015n : null;
                if ((3 & 4) != 0) {
                    i11 = this.f11016o;
                }
                int i13 = i11;
                if ((3 & 8) != 0) {
                    z = this.f11017p;
                }
                return new ConnectPlan(this.f11003a, this.f11004b, this.f11005c, this.f11006d, this.f11007e, this.f11008f, this.f11009g, this.h, this.f11010i, this.f11011j, this.f11012k, this.f11013l, i12, hVar, i13, z);
            }
            i11++;
        }
        return null;
    }

    public final ConnectPlan l(List<okhttp3.e> connectionSpecs, SSLSocket sSLSocket) throws UnknownServiceException {
        kotlin.jvm.internal.g.f(connectionSpecs, "connectionSpecs");
        if (this.f11016o != -1) {
            return this;
        }
        ConnectPlan connectPlanK = k(connectionSpecs, sSLSocket);
        if (connectPlanK != null) {
            return connectPlanK;
        }
        StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.f11017p);
        sb2.append(", modes=");
        sb2.append(connectionSpecs);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        kotlin.jvm.internal.g.c(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        kotlin.jvm.internal.g.e(string, "toString(...)");
        sb2.append(string);
        throw new UnknownServiceException(sb2.toString());
    }

    @Override // fd.d.a
    public final void b() {
    }

    @Override // fd.d.a
    public final void f(d dVar, IOException iOException) {
    }
}
