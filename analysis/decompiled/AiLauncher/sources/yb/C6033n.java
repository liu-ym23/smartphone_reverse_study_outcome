package yb;

import Mb.J;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import okhttp3.Protocol;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.a;
import okhttp3.internal.http2.c;
import tb.C5532E;
import tb.C5534a;
import tb.C5541h;
import tb.InterfaceC5543j;
import tb.z;
import xb.C5873d;
import zb.InterfaceC6480d;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001WB[\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001aH\u0016¢\u0006\u0004\b(\u0010\u001cJ\u000f\u0010)\u001a\u00020\u001aH\u0000¢\u0006\u0004\b)\u0010\u001cJ\u000f\u0010*\u001a\u00020\u001aH\u0000¢\u0006\u0004\b*\u0010\u001cJ\r\u0010+\u001a\u00020\u001a¢\u0006\u0004\b+\u0010\u001cJ'\u0010/\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020,2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001dH\u0000¢\u0006\u0004\b/\u00100J\u001f\u00106\u001a\u0002052\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0000¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u001aH\u0000¢\u0006\u0004\b8\u0010\u001cJ\u000f\u00109\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u001aH\u0016¢\u0006\u0004\b;\u0010\u001cJ\u000f\u0010<\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u001f¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010I\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bI\u0010JJ\u0011\u0010K\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\bK\u0010LJ'\u0010P\u001a\u00020\u001a2\u0006\u00102\u001a\u0002012\u0006\u0010M\u001a\u00020\t2\u0006\u0010O\u001a\u00020NH\u0000¢\u0006\u0004\bP\u0010QJ!\u0010U\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020R2\b\u0010T\u001a\u0004\u0018\u00010NH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0010H\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bI\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bU\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bT\u0010b\u001a\u0004\bT\u0010:R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010cR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010cR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010dR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010\u0017\u001a\u00020\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bg\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\"\u0010u\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010q\u001a\u0004\bk\u0010r\"\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010qR\"\u0010z\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010j\u001a\u0004\bn\u0010w\"\u0004\bx\u0010yR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010jR\u0016\u0010}\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010jR%\u0010\u0080\u0001\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00148\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b6\u0010j\u001a\u0004\b\u007f\u0010wR(\u0010\u0085\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020R0\u0082\u00010\u0081\u00018\u0006¢\u0006\u000e\n\u0005\b)\u0010\u0083\u0001\u001a\u0005\be\u0010\u0084\u0001R(\u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b9\u0010\u0087\u0001\u001a\u0005\bi\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0015\u0010\u008c\u0001\u001a\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b|\u0010r¨\u0006\u008d\u0001"}, d2 = {"Lyb/n;", "Lokhttp3/internal/http2/c$c;", "Ltb/j;", "Lzb/d$a;", "", "Lxb/d;", "taskRunner", "Lyb/o;", "connectionPool", "Ltb/E;", M5.a.CARD_TYPE_ROUTE, "Ljava/net/Socket;", "rawSocket", "javaNetSocket", "Lokhttp3/c;", "handshake", "Lokhttp3/Protocol;", "protocol", "Lyb/a;", "socket", "", "pingIntervalMillis", "Lyb/g;", "connectionListener", "<init>", "(Lxb/d;Lyb/o;Ltb/E;Ljava/net/Socket;Ljava/net/Socket;Lokhttp3/c;Lokhttp3/Protocol;Lyb/a;ILyb/g;)V", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "", "candidates", "", "v", "(Ljava/util/List;)Z", "Ltb/v;", "url", "B", "(Ltb/v;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/v;Lokhttp3/c;)Z", Const.INTENT_KEY_PKGNAME, "t", "o", "z", "Ltb/a;", Const.JSON_KEY_ADDRESS, "routes", "p", "(Ltb/a;Ljava/util/List;)Z", "Ltb/z;", "client", "Lzb/g;", "chain", "Lzb/d;", "s", "(Ltb/z;Lzb/g;)Lzb/d;", "C", "u", "()Ltb/E;", "cancel", "y", "()Ljava/net/Socket;", "doExtensiveChecks", "q", "(Z)Z", "LBb/p;", "stream", "f", "(LBb/p;)V", "Lokhttp3/internal/http2/c;", "connection", "LBb/s;", "settings", "c", "(Lokhttp3/internal/http2/c;LBb/s;)V", "n", "()Lokhttp3/c;", "failedRoute", "Ljava/io/IOException;", "failure", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ltb/z;Ltb/E;Ljava/io/IOException;)V", "Lyb/m;", "call", "e", Const.INTENT_KEY_UMID, "(Lyb/m;Ljava/io/IOException;)V", Const.INTENT_KEY_APIKEY, "()Lokhttp3/Protocol;", "", "toString", "()Ljava/lang/String;", "Lxb/d;", "getTaskRunner", "()Lxb/d;", "Lyb/o;", "getConnectionPool", "()Lyb/o;", "Ltb/E;", "Ljava/net/Socket;", "Lokhttp3/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lokhttp3/Protocol;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lyb/a;", "k", "I", "l", "Lyb/g;", "()Lyb/g;", "m", "Lokhttp3/internal/http2/c;", "http2Connection", "Z", "()Z", "x", "(Z)V", "noNewExchanges", "noCoalescedConnections", "()I", "setRouteFailureCount$okhttp", "(I)V", "routeFailureCount", "successCount", "r", "refusedStreamCount", UxipConstants.f30680s, "getAllocationLimit$okhttp", "allocationLimit", "", "Ljava/lang/ref/Reference;", "Ljava/util/List;", "()Ljava/util/List;", "calls", "", "J", "()J", "w", "(J)V", "idleAtNs", "isMultiplexed", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6033n extends c.AbstractC0484c implements InterfaceC5543j, InterfaceC6480d.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C5873d taskRunner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C6034o connectionPool;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C5532E route;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Socket rawSocket;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Socket javaNetSocket;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final okhttp3.c handshake;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Protocol protocol;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6020a socket;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final int pingIntervalMillis;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final AbstractC6026g connectionListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public okhttp3.internal.http2.c http2Connection;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean noNewExchanges;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean noCoalescedConnections;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public int routeFailureCount;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public int successCount;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public int refusedStreamCount;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public int allocationLimit;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final List<Reference<C6032m>> calls;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public long idleAtNs;

    public C6033n(C5873d taskRunner, C6034o connectionPool, C5532E route, Socket rawSocket, Socket javaNetSocket, okhttp3.c cVar, Protocol protocol, InterfaceC6020a socket, int i10, AbstractC6026g connectionListener) {
        kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.i(connectionPool, "connectionPool");
        kotlin.jvm.internal.p.i(route, "route");
        kotlin.jvm.internal.p.i(rawSocket, "rawSocket");
        kotlin.jvm.internal.p.i(javaNetSocket, "javaNetSocket");
        kotlin.jvm.internal.p.i(protocol, "protocol");
        kotlin.jvm.internal.p.i(socket, "socket");
        kotlin.jvm.internal.p.i(connectionListener, "connectionListener");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.route = route;
        this.rawSocket = rawSocket;
        this.javaNetSocket = javaNetSocket;
        this.handshake = cVar;
        this.protocol = protocol;
        this.socket = socket;
        this.pingIntervalMillis = i10;
        this.connectionListener = connectionListener;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public final void A() throws IOException {
        this.javaNetSocket.setSoTimeout(0);
        Object obj = this.connectionListener;
        okhttp3.internal.http2.a aVar = obj instanceof okhttp3.internal.http2.a ? (okhttp3.internal.http2.a) obj : null;
        if (aVar == null) {
            aVar = a.C0482a.f37647a;
        }
        okhttp3.internal.http2.c cVarA = new c.a(true, this.taskRunner).o(this.socket, getRoute().getAddress().getUrl().getHost()).k(this).l(this.pingIntervalMillis).b(aVar).a();
        this.http2Connection = cVarA;
        this.allocationLimit = okhttp3.internal.http2.c.INSTANCE.a().d();
        okhttp3.internal.http2.c.S1(cVarA, false, 1, null);
    }

    public final boolean B(tb.v url) {
        okhttp3.c cVar;
        if (!ub.q.f42674b || Thread.holdsLock(this)) {
            tb.v url2 = getRoute().getAddress().getUrl();
            if (url.getPort() != url2.getPort()) {
                return false;
            }
            if (kotlin.jvm.internal.p.d(url.getHost(), url2.getHost())) {
                return true;
            }
            return (this.noCoalescedConnections || (cVar = this.handshake) == null || !g(url, cVar)) ? false : true;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void C() throws SocketException {
        this.javaNetSocket.setSoTimeout(0);
        b();
    }

    @Override // tb.InterfaceC5543j
    /* renamed from: a, reason: from getter */
    public Protocol getProtocol() {
        return this.protocol;
    }

    @Override // zb.InterfaceC6480d.a
    public void b() {
        synchronized (this) {
            this.noNewExchanges = true;
            Y8.t tVar = Y8.t.f7040a;
        }
        this.connectionListener.h(this);
    }

    @Override // okhttp3.internal.http2.c.AbstractC0484c
    public void c(okhttp3.internal.http2.c connection, Bb.s settings) {
        kotlin.jvm.internal.p.i(connection, "connection");
        kotlin.jvm.internal.p.i(settings, "settings");
        synchronized (this) {
            this.allocationLimit = settings.d();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // zb.InterfaceC6480d.a
    public void cancel() throws IOException {
        ub.q.h(this.rawSocket);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // zb.InterfaceC6480d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(yb.C6032m r4, java.io.IOException r5) {
        /*
            r3 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.p.i(r4, r0)
            monitor-enter(r3)
            boolean r0 = r5 instanceof okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L26
            r1 = 1
            if (r0 == 0) goto L41
            r0 = r5
            okhttp3.internal.http2.StreamResetException r0 = (okhttp3.internal.http2.StreamResetException) r0     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r0 = r0.errorCode     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L26
            if (r0 != r2) goto L28
            int r4 = r3.refusedStreamCount     // Catch: java.lang.Throwable -> L26
            int r4 = r4 + r1
            r3.refusedStreamCount = r4     // Catch: java.lang.Throwable -> L26
            if (r4 <= r1) goto L4c
            boolean r4 = r3.noNewExchanges     // Catch: java.lang.Throwable -> L26
            r4 = r4 ^ r1
            r3.noNewExchanges = r1     // Catch: java.lang.Throwable -> L26
            int r5 = r3.routeFailureCount     // Catch: java.lang.Throwable -> L26
            int r5 = r5 + r1
            r3.routeFailureCount = r5     // Catch: java.lang.Throwable -> L26
            goto L6a
        L26:
            r4 = move-exception
            goto L75
        L28:
            okhttp3.internal.http2.StreamResetException r5 = (okhttp3.internal.http2.StreamResetException) r5     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r5 = r5.errorCode     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.lang.Throwable -> L26
            if (r5 != r0) goto L36
            boolean r4 = r4.getCanceled()     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L4c
        L36:
            boolean r4 = r3.noNewExchanges     // Catch: java.lang.Throwable -> L26
            r4 = r4 ^ r1
            r3.noNewExchanges = r1     // Catch: java.lang.Throwable -> L26
            int r5 = r3.routeFailureCount     // Catch: java.lang.Throwable -> L26
            int r5 = r5 + r1
            r3.routeFailureCount = r5     // Catch: java.lang.Throwable -> L26
            goto L6a
        L41:
            boolean r0 = r3.r()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L4e
            boolean r0 = r5 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r4 = 0
            goto L6a
        L4e:
            boolean r0 = r3.noNewExchanges     // Catch: java.lang.Throwable -> L26
            r0 = r0 ^ r1
            r3.noNewExchanges = r1     // Catch: java.lang.Throwable -> L26
            int r2 = r3.successCount     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L69
            if (r5 == 0) goto L64
            tb.z r4 = r4.getClient()     // Catch: java.lang.Throwable -> L26
            tb.E r2 = r3.getRoute()     // Catch: java.lang.Throwable -> L26
            r3.h(r4, r2, r5)     // Catch: java.lang.Throwable -> L26
        L64:
            int r4 = r3.routeFailureCount     // Catch: java.lang.Throwable -> L26
            int r4 = r4 + r1
            r3.routeFailureCount = r4     // Catch: java.lang.Throwable -> L26
        L69:
            r4 = r0
        L6a:
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L26
            monitor-exit(r3)
            if (r4 == 0) goto L74
            yb.g r4 = r3.connectionListener
            r4.h(r3)
        L74:
            return
        L75:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.C6033n.d(yb.m, java.io.IOException):void");
    }

    @Override // zb.InterfaceC6480d.a
    /* renamed from: e, reason: from getter */
    public C5532E getRoute() {
        return this.route;
    }

    @Override // okhttp3.internal.http2.c.AbstractC0484c
    public void f(Bb.p stream) throws IOException {
        kotlin.jvm.internal.p.i(stream, "stream");
        stream.g(ErrorCode.REFUSED_STREAM, null);
    }

    public final boolean g(tb.v url, okhttp3.c handshake) {
        List<Certificate> listE = handshake.e();
        if (!listE.isEmpty()) {
            Ib.d dVar = Ib.d.f3429a;
            String host = url.getHost();
            Certificate certificate = listE.get(0);
            kotlin.jvm.internal.p.g(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.e(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    public final void h(z client, C5532E failedRoute, IOException failure) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(failedRoute, "failedRoute");
        kotlin.jvm.internal.p.i(failure, "failure");
        if (failedRoute.getProxy().type() != Proxy.Type.DIRECT) {
            C5534a address = failedRoute.getAddress();
            address.getProxySelector().connectFailed(address.getUrl().u(), failedRoute.getProxy().address(), failure);
        }
        client.getRouteDatabase().b(failedRoute);
    }

    public final List<Reference<C6032m>> i() {
        return this.calls;
    }

    /* renamed from: j, reason: from getter */
    public final AbstractC6026g getConnectionListener() {
        return this.connectionListener;
    }

    /* renamed from: k, reason: from getter */
    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    /* renamed from: m, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    /* renamed from: n, reason: from getter */
    public okhttp3.c getHandshake() {
        return this.handshake;
    }

    public final void o() {
        synchronized (this) {
            this.successCount++;
        }
    }

    public final boolean p(C5534a address, List<C5532E> routes) {
        kotlin.jvm.internal.p.i(address, "address");
        if (ub.q.f42674b && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !getRoute().getAddress().d(address)) {
            return false;
        }
        if (kotlin.jvm.internal.p.d(address.getUrl().getHost(), u().getAddress().getUrl().getHost())) {
            return true;
        }
        if (this.http2Connection == null || routes == null || !v(routes) || address.getHostnameVerifier() != Ib.d.f3429a || !B(address.getUrl())) {
            return false;
        }
        try {
            C5541h certificatePinner = address.getCertificatePinner();
            kotlin.jvm.internal.p.f(certificatePinner);
            String host = address.getUrl().getHost();
            okhttp3.c handshake = getHandshake();
            kotlin.jvm.internal.p.f(handshake);
            certificatePinner.b(host, handshake.e());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean q(boolean doExtensiveChecks) {
        long j10;
        if (ub.q.f42674b && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        if (this.rawSocket.isClosed() || this.javaNetSocket.isClosed() || this.javaNetSocket.isInputShutdown() || this.javaNetSocket.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.http2.c cVar = this.http2Connection;
        if (cVar != null) {
            return cVar.z1(jNanoTime);
        }
        synchronized (this) {
            j10 = jNanoTime - this.idleAtNs;
        }
        if (j10 < 10000000000L || !doExtensiveChecks) {
            return true;
        }
        return ub.q.m(this.javaNetSocket, this.socket.getSource());
    }

    public final boolean r() {
        return this.http2Connection != null;
    }

    public final InterfaceC6480d s(z client, zb.g chain) throws SocketException {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(chain, "chain");
        InterfaceC6020a interfaceC6020a = this.socket;
        okhttp3.internal.http2.c cVar = this.http2Connection;
        if (cVar != null) {
            return new Bb.o(client, this, chain, cVar);
        }
        this.javaNetSocket.setSoTimeout(chain.getReadTimeoutMillis());
        J jC = interfaceC6020a.getSource().getTimeout();
        long jX = chain.x();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        jC.h(jX, timeUnit);
        interfaceC6020a.getSink().getTimeout().h(chain.getWriteTimeoutMillis(), timeUnit);
        return new Ab.b(client, this, interfaceC6020a);
    }

    public final void t() {
        synchronized (this) {
            this.noCoalescedConnections = true;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public String toString() {
        Object cipherSuite;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(getRoute().getAddress().getUrl().getHost());
        sb2.append(':');
        sb2.append(getRoute().getAddress().getUrl().getPort());
        sb2.append(", proxy=");
        sb2.append(getRoute().getProxy());
        sb2.append(" hostAddress=");
        sb2.append(getRoute().getSocketAddress());
        sb2.append(" cipherSuite=");
        okhttp3.c cVar = this.handshake;
        if (cVar == null || (cipherSuite = cVar.getCipherSuite()) == null) {
            cipherSuite = "none";
        }
        sb2.append(cipherSuite);
        sb2.append(" protocol=");
        sb2.append(this.protocol);
        sb2.append('}');
        return sb2.toString();
    }

    public C5532E u() {
        return getRoute();
    }

    public final boolean v(List<C5532E> candidates) {
        List<C5532E> list = candidates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (C5532E c5532e : list) {
            Proxy.Type type = c5532e.getProxy().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && getRoute().getProxy().type() == type2 && kotlin.jvm.internal.p.d(getRoute().getSocketAddress(), c5532e.getSocketAddress())) {
                return true;
            }
        }
        return false;
    }

    public final void w(long j10) {
        this.idleAtNs = j10;
    }

    public final void x(boolean z10) {
        this.noNewExchanges = z10;
    }

    /* renamed from: y, reason: from getter */
    public Socket getJavaNetSocket() {
        return this.javaNetSocket;
    }

    public final void z() throws IOException {
        this.idleAtNs = System.nanoTime();
        Protocol protocol = this.protocol;
        if (protocol == Protocol.HTTP_2 || protocol == Protocol.H2_PRIOR_KNOWLEDGE) {
            A();
        }
    }
}
