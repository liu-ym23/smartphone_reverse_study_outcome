package yb;

import La.D;
import La.w;
import Mb.J;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
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
import kotlin.Metadata;
import okhttp3.Protocol;
import okhttp3.c;
import p9.InterfaceC5063a;
import tb.C5528A;
import tb.C5530C;
import tb.C5532E;
import tb.C5534a;
import tb.C5541h;
import xb.C5873d;
import yb.InterfaceC6039t;
import zb.InterfaceC6480d;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001+B\u0093\u0001\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0004\b\"\u0010 J%\u0010'\u001a\u00020\u00002\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00152\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u0004\u0018\u00010\u00002\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00152\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b)\u0010(J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J!\u00100\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020/H\u0016¢\u0006\u0004\b4\u00103J\u000f\u00105\u001a\u00020\u0001H\u0016¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020/¢\u0006\u0004\b7\u00103J9\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020/H\u0002¢\u0006\u0004\b:\u00103J\u001f\u0010<\u001a\u00020/2\u0006\u0010&\u001a\u00020%2\u0006\u0010;\u001a\u00020#H\u0002¢\u0006\u0004\b<\u0010=J\u0011\u0010>\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b>\u0010?R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010@R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010AR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010BR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010BR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010BR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010BR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010BR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010GR\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010H\u001a\u0004\b.\u0010IR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010J\u001a\u0004\bK\u0010LR\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010BR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010\u001a\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010B\u001a\u0004\bP\u0010QR\u001a\u0010\u001b\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u0010D\u001a\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010DR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010WR$\u0010]\u001a\u0004\u0018\u00010V8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bK\u0010W\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010S¨\u0006m"}, d2 = {"Lyb/f;", "Lyb/t$b;", "Lzb/d$a;", "Lxb/d;", "taskRunner", "Lyb/o;", "connectionPool", "", "readTimeoutMillis", "writeTimeoutMillis", "socketConnectTimeoutMillis", "socketReadTimeoutMillis", "pingIntervalMillis", "", "retryOnConnectionFailure", "Lyb/m;", "call", "Lyb/p;", "routePlanner", "Ltb/E;", M5.a.CARD_TYPE_ROUTE, "", "routes", "attempt", "Ltb/A;", "tunnelRequest", "connectionSpecIndex", "isTlsFallback", "<init>", "(Lxb/d;Lyb/o;IIIIIZLyb/m;Lyb/p;Ltb/E;Ljava/util/List;ILtb/A;IZ)V", "Lyb/t$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lyb/t$a;", "c", "o", "Lokhttp3/b;", "connectionSpecs", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "u", "(Ljava/util/List;Ljavax/net/ssl/SSLSocket;)Lyb/f;", "t", "Lyb/n;", Const.INTENT_KEY_APIKEY, "()Lyb/n;", "Ljava/io/IOException;", "e", "LY8/t;", Const.INTENT_KEY_UMID, "(Lyb/m;Ljava/io/IOException;)V", Const.INTENT_KEY_PKGNAME, "()V", "cancel", "f", "()Lyb/t$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "p", "(ILtb/A;IZ)Lyb/f;", "k", "connectionSpec", "l", "(Ljavax/net/ssl/SSLSocket;Lokhttp3/b;)V", "r", "()Ltb/A;", "Lxb/d;", "Lyb/o;", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lyb/m;", "Lyb/p;", "Ltb/E;", "()Ltb/E;", "Ljava/util/List;", "s", "()Ljava/util/List;", "m", "n", "Ltb/A;", "getConnectionSpecIndex$okhttp", "()I", "isTlsFallback$okhttp", "()Z", "q", "canceled", "Ljava/net/Socket;", "Ljava/net/Socket;", "rawSocket", "getJavaNetSocket$okhttp", "()Ljava/net/Socket;", "setJavaNetSocket$okhttp", "(Ljava/net/Socket;)V", "javaNetSocket", "Lokhttp3/c;", "Lokhttp3/c;", "handshake", "Lokhttp3/Protocol;", "Lokhttp3/Protocol;", "protocol", "Lyb/a;", "v", "Lyb/a;", "socket", "w", "Lyb/n;", "connection", "isReady", "x", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6025f implements InterfaceC6039t.b, InterfaceC6480d.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5873d taskRunner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C6034o connectionPool;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int readTimeoutMillis;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int writeTimeoutMillis;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int socketConnectTimeoutMillis;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int socketReadTimeoutMillis;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int pingIntervalMillis;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean retryOnConnectionFailure;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final C6032m call;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final C6035p routePlanner;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C5532E route;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final List<C5532E> routes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final int attempt;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final C5528A tunnelRequest;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final int connectionSpecIndex;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final boolean isTlsFallback;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public volatile boolean canceled;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public Socket rawSocket;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public Socket javaNetSocket;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public okhttp3.c handshake;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public Protocol protocol;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public InterfaceC6020a socket;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public C6033n connection;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.f$b */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44174a;

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
            f44174a = iArr;
        }
    }

    public C6025f(C5873d taskRunner, C6034o connectionPool, int i10, int i11, int i12, int i13, int i14, boolean z10, C6032m call, C6035p routePlanner, C5532E route, List<C5532E> list, int i15, C5528A c5528a, int i16, boolean z11) {
        kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.i(connectionPool, "connectionPool");
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(routePlanner, "routePlanner");
        kotlin.jvm.internal.p.i(route, "route");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i10;
        this.writeTimeoutMillis = i11;
        this.socketConnectTimeoutMillis = i12;
        this.socketReadTimeoutMillis = i13;
        this.pingIntervalMillis = i14;
        this.retryOnConnectionFailure = z10;
        this.call = call;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = i15;
        this.tunnelRequest = c5528a;
        this.connectionSpecIndex = i16;
        this.isTlsFallback = z11;
    }

    public static final List m(C5541h c5541h, okhttp3.c cVar, C5534a c5534a) {
        Ib.c certificateChainCleaner = c5541h.getCertificateChainCleaner();
        kotlin.jvm.internal.p.f(certificateChainCleaner);
        return certificateChainCleaner.a(cVar.e(), c5534a.getUrl().getHost());
    }

    public static final List n(okhttp3.c cVar) {
        List<Certificate> listE = cVar.e();
        ArrayList arrayList = new ArrayList(C1174w.x(listE, 10));
        for (Certificate certificate : listE) {
            kotlin.jvm.internal.p.g(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    public static /* synthetic */ C6025f q(C6025f c6025f, int i10, C5528A c5528a, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = c6025f.attempt;
        }
        if ((i12 & 2) != 0) {
            c5528a = c6025f.tunnelRequest;
        }
        if ((i12 & 4) != 0) {
            i11 = c6025f.connectionSpecIndex;
        }
        if ((i12 & 8) != 0) {
            z10 = c6025f.isTlsFallback;
        }
        return c6025f.p(i10, c5528a, i11, z10);
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: a */
    public C6033n getConnection() throws IOException {
        this.call.getClient().getRouteDatabase().a(getRoute());
        C6033n c6033n = this.connection;
        kotlin.jvm.internal.p.f(c6033n);
        c6033n.getConnectionListener().b(c6033n, getRoute(), this.call);
        C6037r c6037rM = this.routePlanner.m(this, this.routes);
        if (c6037rM != null) {
            return c6037rM.h();
        }
        synchronized (c6033n) {
            this.connectionPool.f(c6033n);
            this.call.f(c6033n);
            Y8.t tVar = Y8.t.f7040a;
        }
        this.call.getEventListener().j(this.call, c6033n);
        c6033n.getConnectionListener().e(c6033n, this.call);
        return c6033n;
    }

    @Override // zb.InterfaceC6480d.a
    public void b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01d8  */
    @Override // yb.InterfaceC6039t.b
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public yb.InterfaceC6039t.ConnectResult getResult() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.C6025f.getResult():yb.t$a");
    }

    @Override // yb.InterfaceC6039t.b, zb.InterfaceC6480d.a
    public void cancel() throws IOException {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            ub.q.h(socket);
        }
    }

    @Override // zb.InterfaceC6480d.a
    public void d(C6032m call, IOException e10) {
        kotlin.jvm.internal.p.i(call, "call");
    }

    @Override // zb.InterfaceC6480d.a
    /* renamed from: e, reason: from getter */
    public C5532E getRoute() {
        return this.route;
    }

    @Override // yb.InterfaceC6039t.b
    public InterfaceC6039t.b f() {
        return new C6025f(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // yb.InterfaceC6039t.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public yb.InterfaceC6039t.ConnectResult g() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.C6025f.g():yb.t$a");
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: isReady */
    public boolean getIsReady() {
        return this.protocol != null;
    }

    public final void j() {
        Socket socket = this.javaNetSocket;
        if (socket != null) {
            ub.q.h(socket);
        }
    }

    public final void k() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = getRoute().getProxy().type();
        int i10 = type == null ? -1 : b.f44174a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            socketCreateSocket = getRoute().getAddress().getSocketFactory().createSocket();
            kotlin.jvm.internal.p.f(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(getRoute().getProxy());
        }
        this.rawSocket = socketCreateSocket;
        if (this.canceled) {
            throw new IOException("canceled");
        }
        socketCreateSocket.setSoTimeout(this.socketReadTimeoutMillis);
        try {
            okhttp3.internal.platform.c.INSTANCE.e().connectSocket(socketCreateSocket, getRoute().getSocketAddress(), this.socketConnectTimeoutMillis);
            try {
                this.socket = C6021b.b(socketCreateSocket);
            } catch (NullPointerException e10) {
                if (kotlin.jvm.internal.p.d(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + getRoute().getSocketAddress());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void l(SSLSocket sslSocket, okhttp3.b connectionSpec) throws IOException {
        final C5534a address = getRoute().getAddress();
        try {
            if (connectionSpec.getSupportsTlsExtensions()) {
                okhttp3.internal.platform.c.INSTANCE.e().configureTlsExtensions(sslSocket, address.getUrl().getHost(), address.f());
            }
            sslSocket.startHandshake();
            SSLSession session = sslSocket.getSession();
            c.Companion companion = okhttp3.c.INSTANCE;
            kotlin.jvm.internal.p.f(session);
            final okhttp3.c cVarB = companion.b(session);
            HostnameVerifier hostnameVerifier = address.getHostnameVerifier();
            kotlin.jvm.internal.p.f(hostnameVerifier);
            if (hostnameVerifier.verify(address.getUrl().getHost(), session)) {
                final C5541h certificatePinner = address.getCertificatePinner();
                kotlin.jvm.internal.p.f(certificatePinner);
                final okhttp3.c cVar = new okhttp3.c(cVarB.getTlsVersion(), cVarB.getCipherSuite(), cVarB.d(), new InterfaceC5063a() { // from class: yb.d
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return C6025f.m(certificatePinner, cVarB, address);
                    }
                });
                this.handshake = cVar;
                certificatePinner.d(address.getUrl().getHost(), new InterfaceC5063a() { // from class: yb.e
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return C6025f.n(cVar);
                    }
                });
                String selectedProtocol = connectionSpec.getSupportsTlsExtensions() ? okhttp3.internal.platform.c.INSTANCE.e().getSelectedProtocol(sslSocket) : null;
                this.javaNetSocket = sslSocket;
                this.socket = C6021b.b(sslSocket);
                this.protocol = selectedProtocol != null ? Protocol.INSTANCE.a(selectedProtocol) : Protocol.HTTP_1_1;
                okhttp3.internal.platform.c.INSTANCE.e().afterHandshake(sslSocket);
                return;
            }
            List<Certificate> listE = cVarB.e();
            if (listE.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + address.getUrl().getHost() + " not verified (no certificates)");
            }
            Certificate certificate = listE.get(0);
            kotlin.jvm.internal.p.g(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) certificate;
            throw new SSLPeerUnverifiedException(w.p("\n            |Hostname " + address.getUrl().getHost() + " not verified:\n            |    certificate: " + C5541h.INSTANCE.a(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + Ib.d.f3429a.a(x509Certificate) + "\n            ", null, 1, null));
        } catch (Throwable th) {
            okhttp3.internal.platform.c.INSTANCE.e().afterHandshake(sslSocket);
            ub.q.h(sslSocket);
            throw th;
        }
    }

    public final InterfaceC6039t.ConnectResult o() throws IOException {
        C5528A c5528aR = r();
        if (c5528aR == null) {
            return new InterfaceC6039t.ConnectResult(this, null, null, 6, null);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            ub.q.h(socket);
        }
        int i10 = this.attempt + 1;
        if (i10 < 21) {
            this.call.getEventListener().g(this.call, getRoute().getSocketAddress(), getRoute().getProxy(), null);
            return new InterfaceC6039t.ConnectResult(this, q(this, i10, c5528aR, 0, false, 12, null), null, 4, null);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        this.call.getEventListener().h(this.call, getRoute().getSocketAddress(), getRoute().getProxy(), null, protocolException);
        this.connectionPool.getConnectionListener().c(getRoute(), this.call, protocolException);
        return new InterfaceC6039t.ConnectResult(this, null, protocolException, 2, null);
    }

    public final C6025f p(int attempt, C5528A tunnelRequest, int connectionSpecIndex, boolean isTlsFallback) {
        return new C6025f(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this.routePlanner, getRoute(), this.routes, attempt, tunnelRequest, connectionSpecIndex, isTlsFallback);
    }

    public final C5528A r() throws IOException {
        C5528A c5528a = this.tunnelRequest;
        kotlin.jvm.internal.p.f(c5528a);
        String str = "CONNECT " + ub.q.u(getRoute().getAddress().getUrl(), true) + " HTTP/1.1";
        while (true) {
            InterfaceC6020a interfaceC6020a = this.socket;
            if (interfaceC6020a == null) {
                kotlin.jvm.internal.p.A("socket");
                interfaceC6020a = null;
            }
            Ab.b bVar = new Ab.b(null, this, interfaceC6020a);
            InterfaceC6020a interfaceC6020a2 = this.socket;
            if (interfaceC6020a2 == null) {
                kotlin.jvm.internal.p.A("socket");
                interfaceC6020a2 = null;
            }
            J timeout = interfaceC6020a2.getSource().getTimeout();
            long j10 = this.readTimeoutMillis;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            timeout.h(j10, timeUnit);
            InterfaceC6020a interfaceC6020a3 = this.socket;
            if (interfaceC6020a3 == null) {
                kotlin.jvm.internal.p.A("socket");
                interfaceC6020a3 = null;
            }
            interfaceC6020a3.getSink().getTimeout().h(this.writeTimeoutMillis, timeUnit);
            bVar.B(c5528a.getHeaders(), str);
            bVar.d();
            C5530C.a aVarG = bVar.g(false);
            kotlin.jvm.internal.p.f(aVarG);
            C5530C c5530cC = aVarG.q(c5528a).c();
            bVar.A(c5530cC);
            int code = c5530cC.getCode();
            if (code == 200) {
                return null;
            }
            if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c5530cC.getCode());
            }
            C5528A c5528aAuthenticate = getRoute().getAddress().getProxyAuthenticator().authenticate(getRoute(), c5530cC);
            if (c5528aAuthenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (D.L("close", C5530C.J(c5530cC, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, null, 2, null), true)) {
                return c5528aAuthenticate;
            }
            c5528a = c5528aAuthenticate;
        }
    }

    public final List<C5532E> s() {
        return this.routes;
    }

    public final C6025f t(List<okhttp3.b> connectionSpecs, SSLSocket sslSocket) {
        kotlin.jvm.internal.p.i(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.p.i(sslSocket, "sslSocket");
        int i10 = this.connectionSpecIndex + 1;
        int size = connectionSpecs.size();
        for (int i11 = i10; i11 < size; i11++) {
            if (connectionSpecs.get(i11).e(sslSocket)) {
                return q(this, 0, null, i11, this.connectionSpecIndex != -1, 3, null);
            }
        }
        return null;
    }

    public final C6025f u(List<okhttp3.b> connectionSpecs, SSLSocket sslSocket) throws IOException {
        kotlin.jvm.internal.p.i(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.p.i(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        C6025f c6025fT = t(connectionSpecs, sslSocket);
        if (c6025fT != null) {
            return c6025fT;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.isTlsFallback);
        sb2.append(", modes=");
        sb2.append(connectionSpecs);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        kotlin.jvm.internal.p.f(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        kotlin.jvm.internal.p.h(string, "toString(...)");
        sb2.append(string);
        throw new UnknownServiceException(sb2.toString());
    }
}
