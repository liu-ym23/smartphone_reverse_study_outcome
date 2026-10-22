package yb;

import Z8.C1165m;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.Protocol;
import tb.C5528A;
import tb.C5530C;
import tb.C5532E;
import tb.C5534a;
import xb.C5873d;
import yb.C6040u;
import yb.InterfaceC6039t;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bq\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 J/\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0000¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0000¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00152\u0006\u0010(\u001a\u00020#H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u00020+H\u0002¢\u0006\u0004\b8\u00109R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010:R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010>R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010>R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010>R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010@R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010@R\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\b;\u0010BR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010ER\u0014\u0010F\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010@R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR \u0010U\u001a\b\u0012\u0004\u0012\u00020\u001b0Q8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\b=\u0010T¨\u0006V"}, d2 = {"Lyb/p;", "Lyb/t;", "Lxb/d;", "taskRunner", "Lyb/o;", "connectionPool", "", "readTimeoutMillis", "writeTimeoutMillis", "socketConnectTimeoutMillis", "socketReadTimeoutMillis", "pingIntervalMillis", "", "retryOnConnectionFailure", "fastFallback", "Ltb/a;", Const.JSON_KEY_ADDRESS, "Lyb/s;", "routeDatabase", "Lyb/m;", "call", "Ltb/A;", "request", "<init>", "(Lxb/d;Lyb/o;IIIIIZZLtb/a;Lyb/s;Lyb/m;Ltb/A;)V", "e", "()Z", "Lyb/t$b;", Const.INTENT_KEY_UMID, "()Lyb/t$b;", "Lyb/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lyb/f;", "planToReplace", "", "Ltb/E;", "routes", "Lyb/r;", "m", "(Lyb/f;Ljava/util/List;)Lyb/r;", M5.a.CARD_TYPE_ROUTE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/E;Ljava/util/List;)Lyb/f;", "Lyb/n;", "failedConnection", Const.INTENT_KEY_APIKEY, "(Lyb/n;)Z", "Ltb/v;", "url", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/v;)Z", "l", "()Lyb/r;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ltb/E;)Ltb/A;", "connection", "o", "(Lyb/n;)Ltb/E;", "Lxb/d;", Const.INTENT_KEY_PKGNAME, "Lyb/o;", "c", "I", "f", "Z", "Ltb/a;", "()Ltb/a;", "k", "Lyb/s;", "Lyb/m;", "doExtensiveHealthChecks", "Lyb/u$b;", "n", "Lyb/u$b;", "routeSelection", "Lyb/u;", "Lyb/u;", "routeSelector", "p", "Ltb/E;", "nextRouteToTry", "LZ8/m;", "q", "LZ8/m;", "()LZ8/m;", "deferredPlans", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6035p implements InterfaceC6039t {

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
    public final boolean fastFallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final C5534a address;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C6038s routeDatabase;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final C6032m call;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final boolean doExtensiveHealthChecks;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public C6040u.b routeSelection;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public C6040u routeSelector;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public C5532E nextRouteToTry;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final C1165m<InterfaceC6039t.b> deferredPlans;

    public C6035p(C5873d taskRunner, C6034o connectionPool, int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11, C5534a address, C6038s routeDatabase, C6032m call, C5528A request) {
        kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.i(connectionPool, "connectionPool");
        kotlin.jvm.internal.p.i(address, "address");
        kotlin.jvm.internal.p.i(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(request, "request");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i10;
        this.writeTimeoutMillis = i11;
        this.socketConnectTimeoutMillis = i12;
        this.socketReadTimeoutMillis = i13;
        this.pingIntervalMillis = i14;
        this.retryOnConnectionFailure = z10;
        this.fastFallback = z11;
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.doExtensiveHealthChecks = !kotlin.jvm.internal.p.d(request.getMethod(), "GET");
        this.deferredPlans = new C1165m<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C6025f k(C6035p c6035p, C5532E c5532e, List list, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            list = null;
        }
        return c6035p.j(c5532e, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C6037r n(C6035p c6035p, C6025f c6025f, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c6025f = null;
        }
        if ((i10 & 2) != 0) {
            list = null;
        }
        return c6035p.m(c6025f, list);
    }

    @Override // yb.InterfaceC6039t
    public boolean a(C6033n failedConnection) {
        C6040u c6040u;
        C5532E c5532eO;
        if (!c().isEmpty() || this.nextRouteToTry != null) {
            return true;
        }
        if (failedConnection != null && (c5532eO = o(failedConnection)) != null) {
            this.nextRouteToTry = c5532eO;
            return true;
        }
        C6040u.b bVar = this.routeSelection;
        if ((bVar == null || !bVar.b()) && (c6040u = this.routeSelector) != null) {
            return c6040u.a();
        }
        return true;
    }

    @Override // yb.InterfaceC6039t
    /* renamed from: b, reason: from getter */
    public C5534a getAddress() {
        return this.address;
    }

    @Override // yb.InterfaceC6039t
    public C1165m<InterfaceC6039t.b> c() {
        return this.deferredPlans;
    }

    @Override // yb.InterfaceC6039t
    public InterfaceC6039t.b d() throws IOException {
        C6037r c6037rL = l();
        if (c6037rL != null) {
            return c6037rL;
        }
        C6037r c6037rN = n(this, null, null, 3, null);
        if (c6037rN != null) {
            return c6037rN;
        }
        if (!c().isEmpty()) {
            return c().removeFirst();
        }
        C6025f c6025fI = i();
        C6037r c6037rM = m(c6025fI, c6025fI.s());
        return c6037rM != null ? c6037rM : c6025fI;
    }

    @Override // yb.InterfaceC6039t
    public boolean e() {
        return this.call.getCanceled();
    }

    @Override // yb.InterfaceC6039t
    public boolean g(tb.v url) {
        kotlin.jvm.internal.p.i(url, "url");
        tb.v url2 = getAddress().getUrl();
        return url.getPort() == url2.getPort() && kotlin.jvm.internal.p.d(url.getHost(), url2.getHost());
    }

    public final C5528A h(C5532E route) throws IOException {
        C5528A c5528aB = new C5528A.a().u(route.getAddress().getUrl()).n("CONNECT", null).l(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30852k, ub.q.u(route.getAddress().getUrl(), true)).l("Proxy-Connection", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30858q).l(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, "okhttp/5.4.0").b();
        C5528A c5528aAuthenticate = route.getAddress().getProxyAuthenticator().authenticate(route, new C5530C.a().q(c5528aB).o(Protocol.HTTP_1_1).f(407).l("Preemptive Authenticate").r(-1L).p(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return c5528aAuthenticate == null ? c5528aB : c5528aAuthenticate;
    }

    public final C6025f i() throws IOException {
        C5532E c5532e = this.nextRouteToTry;
        if (c5532e != null) {
            this.nextRouteToTry = null;
            return k(this, c5532e, null, 2, null);
        }
        C6040u.b bVar = this.routeSelection;
        if (bVar != null && bVar.b()) {
            return k(this, bVar.c(), null, 2, null);
        }
        C6040u c6040u = this.routeSelector;
        if (c6040u == null) {
            c6040u = new C6040u(getAddress(), this.routeDatabase, this.call, this.fastFallback);
            this.routeSelector = c6040u;
        }
        if (!c6040u.a()) {
            throw new IOException("exhausted all routes");
        }
        C6040u.b bVarC = c6040u.c();
        this.routeSelection = bVarC;
        if (e()) {
            throw new IOException("Canceled");
        }
        return j(bVarC.c(), bVarC.a());
    }

    public final C6025f j(C5532E route, List<C5532E> routes) throws IOException {
        kotlin.jvm.internal.p.i(route, "route");
        if (route.getAddress().getSslSocketFactory() == null) {
            if (!route.getAddress().b().contains(okhttp3.b.f37632k)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String host = route.getAddress().getUrl().getHost();
            if (!okhttp3.internal.platform.c.INSTANCE.e().isCleartextTrafficPermitted(host)) {
                throw new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy");
            }
        } else if (route.getAddress().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        return new C6025f(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.call, this, route, routes, 0, route.c() ? h(route) : null, -1, false);
    }

    public final C6037r l() throws IOException {
        Socket socketB;
        boolean z10;
        C6033n connection = this.call.getConnection();
        if (connection == null) {
            return null;
        }
        boolean zQ = connection.q(this.doExtensiveHealthChecks);
        synchronized (connection) {
            try {
                if (!zQ) {
                    z10 = !connection.getNoNewExchanges();
                    connection.x(true);
                    socketB = this.call.B();
                } else if (connection.getNoNewExchanges() || !g(connection.u().getAddress().getUrl())) {
                    socketB = this.call.B();
                    z10 = false;
                } else {
                    z10 = false;
                    socketB = null;
                }
            } finally {
            }
        }
        if (this.call.getConnection() != null) {
            if (socketB == null) {
                return new C6037r(connection);
            }
            throw new IllegalStateException("Check failed.");
        }
        if (socketB != null) {
            ub.q.h(socketB);
        }
        this.call.getEventListener().k(this.call, connection);
        connection.getConnectionListener().g(connection, this.call);
        if (socketB != null) {
            connection.getConnectionListener().f(connection);
        } else if (z10) {
            connection.getConnectionListener().h(connection);
        }
        return null;
    }

    public final C6037r m(C6025f planToReplace, List<C5532E> routes) throws IOException {
        C6033n c6033nA = this.connectionPool.a(this.doExtensiveHealthChecks, getAddress(), this.call, routes, planToReplace != null && planToReplace.getIsReady());
        if (c6033nA == null) {
            return null;
        }
        if (planToReplace != null) {
            this.nextRouteToTry = planToReplace.getM5.a.CARD_TYPE_ROUTE java.lang.String();
            planToReplace.j();
        }
        this.call.getEventListener().j(this.call, c6033nA);
        c6033nA.getConnectionListener().e(c6033nA, this.call);
        return new C6037r(c6033nA);
    }

    public final C5532E o(C6033n connection) {
        C5532E c5532eU;
        synchronized (connection) {
            c5532eU = null;
            if (connection.getRouteFailureCount() == 0 && connection.getNoNewExchanges() && ub.q.f(connection.u().getAddress().getUrl(), getAddress().getUrl())) {
                c5532eU = connection.u();
            }
        }
        return c5532eU;
    }
}
