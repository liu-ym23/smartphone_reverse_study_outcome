package tb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import okhttp3.Protocol;
import okhttp3.internal.platform.c;
import tb.AbstractC5550q;
import tb.InterfaceC5538e;
import xb.C5873d;
import yb.C6032m;
import yb.C6038s;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002\r\u0018B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00118\u0007¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010%\u001a\u00020 8\u0007¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010.\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u0017\u00103\u001a\u00020/8\u0007¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b!\u00102R\u0017\u00106\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u0010*R\u0017\u00109\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b7\u0010(\u001a\u0004\b8\u0010*R\u0017\u0010?\u001a\u00020:8\u0007¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010E\u001a\u00020@8\u0007¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0019\u0010J\u001a\u0004\u0018\u00010F8\u0007¢\u0006\f\n\u0004\b=\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010O\u001a\u00020K8\u0007¢\u0006\f\n\u0004\b\u0013\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010Q\u001a\u00020/8\u0007¢\u0006\f\n\u0004\bC\u00101\u001a\u0004\bP\u00102R\u0017\u0010V\u001a\u00020R8\u0007¢\u0006\f\n\u0004\b#\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010[\u001a\u0004\u0018\u00010W8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010X\u001a\u0004\bY\u0010ZR\u0019\u0010`\u001a\u0004\u0018\u00010\\8\u0007¢\u0006\f\n\u0004\b5\u0010]\u001a\u0004\b^\u0010_R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020a0\u00168\u0007¢\u0006\f\n\u0004\b8\u0010\u0019\u001a\u0004\bA\u0010\u001bR\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020c0\u00168\u0007¢\u0006\f\n\u0004\bd\u0010\u0019\u001a\u0004\be\u0010\u001bR\u0017\u0010k\u001a\u00020g8\u0007¢\u0006\f\n\u0004\bY\u0010h\u001a\u0004\bi\u0010jR\u0017\u0010p\u001a\u00020l8\u0007¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\b4\u0010oR\u0019\u0010t\u001a\u0004\u0018\u00010q8\u0007¢\u0006\f\n\u0004\bi\u0010r\u001a\u0004\b0\u0010sR\u0017\u0010w\u001a\u00020u8\u0007¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b,\u0010vR\u0017\u0010y\u001a\u00020u8\u0007¢\u0006\f\n\u0004\bx\u0010\t\u001a\u0004\b7\u0010vR\u0017\u0010{\u001a\u00020u8\u0007¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\bz\u0010vR\u0017\u0010}\u001a\u00020u8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b|\u0010vR\u0017\u0010\u007f\u001a\u00020u8\u0007¢\u0006\f\n\u0004\b~\u0010\t\u001a\u0004\b~\u0010vR\u0019\u0010\u0081\u0001\u001a\u00020u8\u0007¢\u0006\r\n\u0004\be\u0010\t\u001a\u0005\b\u0080\u0001\u0010vR\u001b\u0010\u0084\u0001\u001a\u00030\u0082\u00018\u0007¢\u0006\u000e\n\u0005\bH\u0010\u0080\u0001\u001a\u0005\bx\u0010\u0083\u0001R\u001e\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bP\u0010\u0086\u0001\u001a\u0005\bd\u0010\u0087\u0001R\u001e\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\bM\u0010\u008a\u0001\u001a\u0005\bm\u0010\u008b\u0001R\u001b\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0007¢\u0006\u000e\n\u0005\bz\u0010\u008e\u0001\u001a\u0005\b;\u0010\u008f\u0001R\u001e\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0007¢\u0006\u000f\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0005\b'\u0010\u0094\u0001¨\u0006\u0095\u0001"}, d2 = {"Ltb/z;", "Ltb/e$a;", "", "Ltb/z$a;", "builder", "<init>", "(Ltb/z$a;)V", "()V", "LY8/t;", "I", "Ltb/A;", "request", "Ltb/e;", Const.INTENT_KEY_APIKEY, "(Ltb/A;)Ltb/e;", "z", "()Ltb/z$a;", "Ltb/o;", "Ltb/o;", "m", "()Ltb/o;", "dispatcher", "", "Ltb/w;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "w", "()Ljava/util/List;", "interceptors", "c", "y", "networkInterceptors", "Ltb/q$c;", Const.INTENT_KEY_UMID, "Ltb/q$c;", "o", "()Ltb/q$c;", "eventListenerFactory", "", "e", "Z", "G", "()Z", "retryOnConnectionFailure", "f", "p", "fastFallback", "Ltb/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ltb/b;", "()Ltb/b;", "authenticator", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "q", "followRedirects", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "r", "followSslRedirects", "Ltb/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ltb/m;", "l", "()Ltb/m;", "cookieJar", "Ltb/p;", "k", "Ltb/p;", "n", "()Ltb/p;", "dns", "Ljava/net/Proxy;", "Ljava/net/Proxy;", "C", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "Ljava/net/ProxySelector;", ExifInterface.LONGITUDE_EAST, "()Ljava/net/ProxySelector;", "proxySelector", "D", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "H", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "t", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "L", "()Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Lokhttp3/b;", "connectionSpecs", "Lokhttp3/Protocol;", "s", "B", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "v", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Ltb/h;", "u", "Ltb/h;", "()Ltb/h;", "certificatePinner", "LIb/c;", "LIb/c;", "()LIb/c;", "certificateChainCleaner", "", "()I", "callTimeoutMillis", "x", "connectTimeoutMillis", "F", "readTimeoutMillis", "K", "writeTimeoutMillis", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "pingIntervalMillis", "J", "webSocketCloseTimeout", "", "()J", "minWebSocketMessageToCompress", "Lyb/s;", "Lyb/s;", "()Lyb/s;", "routeDatabase", "Lxb/d;", "Lxb/d;", "()Lxb/d;", "taskRunner", "Ltb/k;", "Ltb/k;", "()Ltb/k;", "connectionPool", "Ltb/c;", "cache", "Ltb/c;", "()Ltb/c;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class z implements InterfaceC5538e.a {

    /* renamed from: G, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: collision with root package name */
    public static final List<Protocol> f42290H = ub.q.l(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: I, reason: collision with root package name */
    public static final List<okhttp3.b> f42291I = ub.q.l(okhttp3.b.f37630i, okhttp3.b.f37632k);

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public final int pingIntervalMillis;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final int webSocketCloseTimeout;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public final long minWebSocketMessageToCompress;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public final C6038s routeDatabase;

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public final C5873d taskRunner;

    /* renamed from: F, reason: collision with root package name and from kotlin metadata */
    public final C5544k connectionPool;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5548o dispatcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<w> interceptors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<w> networkInterceptors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5550q.c eventListenerFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean retryOnConnectionFailure;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean fastFallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5535b authenticator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean followRedirects;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final boolean followSslRedirects;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5546m cookieJar;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5549p dns;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Proxy proxy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final ProxySelector proxySelector;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5535b proxyAuthenticator;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final SocketFactory socketFactory;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final SSLSocketFactory sslSocketFactoryOrNull;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final X509TrustManager x509TrustManager;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final List<okhttp3.b> connectionSpecs;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final List<Protocol> protocols;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final HostnameVerifier hostnameVerifier;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final C5541h certificatePinner;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final Ib.c certificateChainCleaner;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final int callTimeoutMillis;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final int connectTimeoutMillis;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final int readTimeoutMillis;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final int writeTimeoutMillis;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Ltb/z$b;", "", "<init>", "()V", "", "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Lokhttp3/b;", "DEFAULT_CONNECTION_SPECS", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.z$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<okhttp3.b> a() {
            return z.f42291I;
        }

        public final List<Protocol> b() {
            return z.f42290H;
        }

        public Companion() {
        }
    }

    public z(a builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        kotlin.jvm.internal.p.i(builder, "builder");
        this.dispatcher = builder.getDispatcher();
        this.interceptors = ub.q.w(builder.C());
        this.networkInterceptors = ub.q.w(builder.E());
        this.eventListenerFactory = builder.getEventListenerFactory();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
        this.fastFallback = builder.getFastFallback();
        this.authenticator = builder.getAuthenticator();
        this.followRedirects = builder.getFollowRedirects();
        this.followSslRedirects = builder.getFollowSslRedirects();
        this.cookieJar = builder.getCookieJar();
        builder.n();
        this.dns = builder.getDns();
        this.proxy = builder.getProxy();
        if (builder.getProxy() != null) {
            proxySelector = Gb.a.f2871a;
        } else {
            proxySelector = builder.getProxySelector();
            if (proxySelector == null && (proxySelector = ProxySelector.getDefault()) == null) {
                proxySelector = Gb.a.f2871a;
            }
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator();
        this.socketFactory = builder.getSocketFactory();
        List<okhttp3.b> listT = builder.t();
        this.connectionSpecs = listT;
        this.protocols = builder.G();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.callTimeoutMillis = builder.getCallTimeout();
        this.connectTimeoutMillis = builder.getConnectTimeout();
        this.readTimeoutMillis = builder.getReadTimeout();
        this.writeTimeoutMillis = builder.getWriteTimeout();
        this.pingIntervalMillis = builder.getPingInterval();
        this.webSocketCloseTimeout = builder.getWebSocketCloseTimeout();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress();
        C6038s routeDatabase = builder.getRouteDatabase();
        this.routeDatabase = routeDatabase == null ? new C6038s() : routeDatabase;
        C5873d taskRunner = builder.getTaskRunner();
        this.taskRunner = taskRunner == null ? C5873d.f43622m : taskRunner;
        C5544k connectionPool = builder.getConnectionPool();
        if (connectionPool == null) {
            connectionPool = new C5544k();
            builder.V(connectionPool);
        }
        this.connectionPool = connectionPool;
        List<okhttp3.b> list = listT;
        if ((list instanceof Collection) && list.isEmpty()) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = C5541h.f42190d;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((okhttp3.b) it.next()).getIsTls()) {
                    if (builder.getSslSocketFactoryOrNull() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull();
                        Ib.c certificateChainCleaner = builder.getCertificateChainCleaner();
                        kotlin.jvm.internal.p.f(certificateChainCleaner);
                        this.certificateChainCleaner = certificateChainCleaner;
                        X509TrustManager x509TrustManagerOrNull = builder.getX509TrustManagerOrNull();
                        kotlin.jvm.internal.p.f(x509TrustManagerOrNull);
                        this.x509TrustManager = x509TrustManagerOrNull;
                        this.certificatePinner = builder.getCertificatePinner().g(certificateChainCleaner);
                    } else {
                        c.Companion companion = okhttp3.internal.platform.c.INSTANCE;
                        X509TrustManager x509TrustManagerPlatformTrustManager = companion.e().platformTrustManager();
                        this.x509TrustManager = x509TrustManagerPlatformTrustManager;
                        this.sslSocketFactoryOrNull = companion.e().newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                        Ib.c cVarA = Ib.c.INSTANCE.a(x509TrustManagerPlatformTrustManager);
                        this.certificateChainCleaner = cVarA;
                        this.certificatePinner = builder.getCertificatePinner().g(cVarA);
                    }
                }
            }
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = C5541h.f42190d;
        }
        I();
    }

    /* renamed from: A, reason: from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<Protocol> B() {
        return this.protocols;
    }

    /* renamed from: C, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* renamed from: D, reason: from getter */
    public final InterfaceC5535b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: E, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* renamed from: F, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* renamed from: G, reason: from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* renamed from: H, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final void I() {
        List<w> list = this.interceptors;
        kotlin.jvm.internal.p.g(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<w> list2 = this.networkInterceptors;
        kotlin.jvm.internal.p.g(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<okhttp3.b> list3 = this.connectionSpecs;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((okhttp3.b) it.next()).getIsTls()) {
                    if (this.sslSocketFactoryOrNull == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.sslSocketFactoryOrNull != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.certificateChainCleaner != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!kotlin.jvm.internal.p.d(this.certificatePinner, C5541h.f42190d)) {
            throw new IllegalStateException("Check failed.");
        }
        Y8.t tVar = Y8.t.f7040a;
    }

    /* renamed from: J, reason: from getter */
    public final int getWebSocketCloseTimeout() {
        return this.webSocketCloseTimeout;
    }

    /* renamed from: K, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* renamed from: L, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    @Override // tb.InterfaceC5538e.a
    public InterfaceC5538e a(C5528A request) {
        kotlin.jvm.internal.p.i(request, "request");
        return new C6032m(this, request, false);
    }

    /* renamed from: d, reason: from getter */
    public final InterfaceC5535b getAuthenticator() {
        return this.authenticator;
    }

    public final C5536c e() {
        return null;
    }

    /* renamed from: f, reason: from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* renamed from: g, reason: from getter */
    public final Ib.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    /* renamed from: h, reason: from getter */
    public final C5541h getCertificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: i, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: j, reason: from getter */
    public final C5544k getConnectionPool() {
        return this.connectionPool;
    }

    public final List<okhttp3.b> k() {
        return this.connectionSpecs;
    }

    /* renamed from: l, reason: from getter */
    public final InterfaceC5546m getCookieJar() {
        return this.cookieJar;
    }

    /* renamed from: m, reason: from getter */
    public final C5548o getDispatcher() {
        return this.dispatcher;
    }

    /* renamed from: n, reason: from getter */
    public final InterfaceC5549p getDns() {
        return this.dns;
    }

    /* renamed from: o, reason: from getter */
    public final AbstractC5550q.c getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getFastFallback() {
        return this.fastFallback;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    /* renamed from: s, reason: from getter */
    public final C6038s getRouteDatabase() {
        return this.routeDatabase;
    }

    /* renamed from: t, reason: from getter */
    public final SSLSocketFactory getSslSocketFactoryOrNull() {
        return this.sslSocketFactoryOrNull;
    }

    /* renamed from: u, reason: from getter */
    public final C5873d getTaskRunner() {
        return this.taskRunner;
    }

    /* renamed from: v, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<w> w() {
        return this.interceptors;
    }

    /* renamed from: x, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<w> y() {
        return this.networkInterceptors;
    }

    public a z() {
        return new a(this);
    }

    @Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001b\u0010'\u001a\u00020\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u001d\u00101\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u001d\u00103\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b3\u00102J\u001d\u00104\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b4\u00102J\u001d\u00105\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b5\u00102J\r\u00106\u001a\u00020\u0004¢\u0006\u0004\b6\u00107R\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010C\u001a\u0004\bD\u0010ER \u0010H\u001a\b\u0012\u0004\u0012\u00020\u000f0B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b6\u0010C\u001a\u0004\bG\u0010ER\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010\u0019\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010U\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b3\u0010N\u001a\u0004\bS\u0010P\"\u0004\bT\u0010RR\"\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010]\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010N\u001a\u0004\b[\u0010P\"\u0004\b\\\u0010RR\"\u0010`\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010N\u001a\u0004\b^\u0010P\"\u0004\b_\u0010RR\"\u0010g\u001a\u00020a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010!\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010s\u001a\u0004\u0018\u00010m8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010{\u001a\u0004\u0018\u00010t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010\u007f\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b|\u0010V\u001a\u0004\b}\u0010X\"\u0004\b~\u0010ZR*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R+\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b>\u0010C\u001a\u0005\b\u0098\u0001\u0010E\"\u0006\b\u0099\u0001\u0010\u009a\u0001R.\u0010\u009e\u0001\u001a\t\u0012\u0005\u0012\u00030\u009b\u00010$8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b\u0098\u0001\u0010C\u001a\u0005\b\u009c\u0001\u0010E\"\u0006\b\u009d\u0001\u0010\u009a\u0001R)\u0010¥\u0001\u001a\u00030\u009f\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bc\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R'\u0010*\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b9\u0010¦\u0001\u001a\u0006\b\u0089\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R+\u0010¯\u0001\u001a\u0005\u0018\u00010ª\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bi\u0010«\u0001\u001a\u0006\b\u0081\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R'\u0010´\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\bJ\u0010}\u001a\u0005\b|\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R(\u0010¶\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\bS\u0010}\u001a\u0006\b\u0091\u0001\u0010±\u0001\"\u0006\bµ\u0001\u0010³\u0001R(\u0010¹\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b[\u0010}\u001a\u0006\b·\u0001\u0010±\u0001\"\u0006\b¸\u0001\u0010³\u0001R(\u0010¼\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b^\u0010}\u001a\u0006\bº\u0001\u0010±\u0001\"\u0006\b»\u0001\u0010³\u0001R)\u0010¿\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b¡\u0001\u0010}\u001a\u0006\b½\u0001\u0010±\u0001\"\u0006\b¾\u0001\u0010³\u0001R(\u0010Â\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\bD\u0010}\u001a\u0006\bÀ\u0001\u0010±\u0001\"\u0006\bÁ\u0001\u0010³\u0001R(\u0010Ç\u0001\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bÃ\u0001\u0010w\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R+\u0010Î\u0001\u001a\u0005\u0018\u00010È\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bG\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R,\u0010Õ\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R+\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0005\bu\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001¨\u0006Ü\u0001"}, d2 = {"Ltb/z$a;", "", "<init>", "()V", "Ltb/z;", "okHttpClient", "(Ltb/z;)V", "Ltb/o;", "dispatcher", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/o;)Ltb/z$a;", "Ltb/k;", "connectionPool", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ltb/k;)Ltb/z$a;", "Ltb/w;", "interceptor", Const.INTENT_KEY_APIKEY, "(Ltb/w;)Ltb/z$a;", Const.INTENT_KEY_PKGNAME, "Ltb/q$c;", "eventListenerFactory", "l", "(Ltb/q$c;)Ltb/z$a;", "", "retryOnConnectionFailure", "U", "(Z)Ltb/z$a;", "Ltb/b;", "authenticator", "c", "(Ltb/b;)Ltb/z$a;", "Ltb/p;", "dns", "k", "(Ltb/p;)Ltb/z$a;", "", "Lokhttp3/b;", "connectionSpecs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ltb/z$a;", "Ltb/h;", "certificatePinner", "f", "(Ltb/h;)Ltb/z$a;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "e", "(JLjava/util/concurrent/TimeUnit;)Ltb/z$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_WEST, Const.INTENT_KEY_UMID, "()Ltb/z;", "Ltb/o;", "v", "()Ltb/o;", "setDispatcher$okhttp", "(Ltb/o;)V", "Ltb/k;", "s", "()Ltb/k;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ltb/k;)V", "", "Ljava/util/List;", "C", "()Ljava/util/List;", "interceptors", ExifInterface.LONGITUDE_EAST, "networkInterceptors", "Ltb/q$c;", "x", "()Ltb/q$c;", "setEventListenerFactory$okhttp", "(Ltb/q$c;)V", "Z", "L", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "y", "setFastFallback$okhttp", "fastFallback", "Ltb/b;", "m", "()Ltb/b;", "setAuthenticator$okhttp", "(Ltb/b;)V", "z", "setFollowRedirects$okhttp", "followRedirects", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setFollowSslRedirects$okhttp", "followSslRedirects", "Ltb/m;", "Ltb/m;", "u", "()Ltb/m;", "setCookieJar$okhttp", "(Ltb/m;)V", "cookieJar", "Ltb/p;", "w", "()Ltb/p;", "setDns$okhttp", "(Ltb/p;)V", "Ljava/net/Proxy;", "Ljava/net/Proxy;", "H", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxy", "Ljava/net/ProxySelector;", "n", "Ljava/net/ProxySelector;", "J", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxySelector", "o", "I", "setProxyAuthenticator$okhttp", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "p", "Ljavax/net/SocketFactory;", "N", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "q", "Ljavax/net/ssl/SSLSocketFactory;", "O", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "r", "Ljavax/net/ssl/X509TrustManager;", ExifInterface.LATITUDE_SOUTH, "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "t", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "Lokhttp3/Protocol;", "G", "setProtocols$okhttp", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "B", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "hostnameVerifier", "Ltb/h;", "()Ltb/h;", "setCertificatePinner$okhttp", "(Ltb/h;)V", "LIb/c;", "LIb/c;", "()LIb/c;", "setCertificateChainCleaner$okhttp", "(LIb/c;)V", "certificateChainCleaner", "", "()I", "setCallTimeout$okhttp", "(I)V", "callTimeout", "setConnectTimeout$okhttp", "connectTimeout", "K", "setReadTimeout$okhttp", "readTimeout", "R", "setWriteTimeout$okhttp", "writeTimeout", "F", "setPingInterval$okhttp", "pingInterval", "Q", "setWebSocketCloseTimeout$okhttp", "webSocketCloseTimeout", "D", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "minWebSocketMessageToCompress", "Lyb/s;", "Lyb/s;", "M", "()Lyb/s;", "setRouteDatabase$okhttp", "(Lyb/s;)V", "routeDatabase", "Lxb/d;", "Lxb/d;", "P", "()Lxb/d;", "setTaskRunner$okhttp", "(Lxb/d;)V", "taskRunner", "Ltb/c;", "cache", "Ltb/c;", "()Ltb/c;", "setCache$okhttp", "(Ltb/c;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: A, reason: collision with root package name and from kotlin metadata */
        public int writeTimeout;

        /* renamed from: B, reason: collision with root package name and from kotlin metadata */
        public int pingInterval;

        /* renamed from: C, reason: collision with root package name and from kotlin metadata */
        public int webSocketCloseTimeout;

        /* renamed from: D, reason: collision with root package name and from kotlin metadata */
        public long minWebSocketMessageToCompress;

        /* renamed from: E, reason: collision with root package name and from kotlin metadata */
        public C6038s routeDatabase;

        /* renamed from: F, reason: collision with root package name and from kotlin metadata */
        public C5873d taskRunner;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public C5548o dispatcher;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public C5544k connectionPool;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<w> interceptors;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final List<w> networkInterceptors;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public AbstractC5550q.c eventListenerFactory;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean retryOnConnectionFailure;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public boolean fastFallback;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public InterfaceC5535b authenticator;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public boolean followRedirects;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public boolean followSslRedirects;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public InterfaceC5546m cookieJar;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public InterfaceC5549p dns;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public Proxy proxy;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public ProxySelector proxySelector;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public InterfaceC5535b proxyAuthenticator;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public SocketFactory socketFactory;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public SSLSocketFactory sslSocketFactoryOrNull;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public X509TrustManager x509TrustManagerOrNull;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public List<okhttp3.b> connectionSpecs;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        public List<? extends Protocol> protocols;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        public HostnameVerifier hostnameVerifier;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        public C5541h certificatePinner;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        public Ib.c certificateChainCleaner;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        public int callTimeout;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        public int connectTimeout;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        public int readTimeout;

        public a() {
            this.dispatcher = new C5548o();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = ub.q.c(AbstractC5550q.NONE);
            this.retryOnConnectionFailure = true;
            this.fastFallback = true;
            InterfaceC5535b interfaceC5535b = InterfaceC5535b.f42159b;
            this.authenticator = interfaceC5535b;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = InterfaceC5546m.f42216b;
            this.dns = InterfaceC5549p.f42229b;
            this.proxyAuthenticator = interfaceC5535b;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.p.h(socketFactory, "getDefault(...)");
            this.socketFactory = socketFactory;
            Companion companion = z.INSTANCE;
            this.connectionSpecs = companion.a();
            this.protocols = companion.b();
            this.hostnameVerifier = Ib.d.f3429a;
            this.certificatePinner = C5541h.f42190d;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.webSocketCloseTimeout = 60000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        /* renamed from: A, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        /* renamed from: B, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final List<w> C() {
            return this.interceptors;
        }

        /* renamed from: D, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<w> E() {
            return this.networkInterceptors;
        }

        /* renamed from: F, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final List<Protocol> G() {
            return this.protocols;
        }

        /* renamed from: H, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* renamed from: I, reason: from getter */
        public final InterfaceC5535b getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        /* renamed from: J, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* renamed from: K, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* renamed from: L, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        /* renamed from: M, reason: from getter */
        public final C6038s getRouteDatabase() {
            return this.routeDatabase;
        }

        /* renamed from: N, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        /* renamed from: O, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        /* renamed from: P, reason: from getter */
        public final C5873d getTaskRunner() {
            return this.taskRunner;
        }

        /* renamed from: Q, reason: from getter */
        public final int getWebSocketCloseTimeout() {
            return this.webSocketCloseTimeout;
        }

        /* renamed from: R, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        /* renamed from: S, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        public final a T(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.p.i(unit, "unit");
            this.readTimeout = ub.q.g("timeout", timeout, unit);
            return this;
        }

        public final a U(boolean retryOnConnectionFailure) {
            this.retryOnConnectionFailure = retryOnConnectionFailure;
            return this;
        }

        public final void V(C5544k c5544k) {
            this.connectionPool = c5544k;
        }

        public final a W(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.p.i(unit, "unit");
            this.writeTimeout = ub.q.g("timeout", timeout, unit);
            return this;
        }

        public final a a(w interceptor) {
            kotlin.jvm.internal.p.i(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final a b(w interceptor) {
            kotlin.jvm.internal.p.i(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final a c(InterfaceC5535b authenticator) {
            kotlin.jvm.internal.p.i(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        public final z d() {
            return new z(this);
        }

        public final a e(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.p.i(unit, "unit");
            this.callTimeout = ub.q.g("timeout", timeout, unit);
            return this;
        }

        public final a f(C5541h certificatePinner) {
            kotlin.jvm.internal.p.i(certificatePinner, "certificatePinner");
            if (!kotlin.jvm.internal.p.d(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public final a g(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.p.i(unit, "unit");
            this.connectTimeout = ub.q.g("timeout", timeout, unit);
            return this;
        }

        public final a h(C5544k connectionPool) {
            kotlin.jvm.internal.p.i(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        public final a i(List<okhttp3.b> connectionSpecs) {
            kotlin.jvm.internal.p.i(connectionSpecs, "connectionSpecs");
            if (!kotlin.jvm.internal.p.d(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = ub.q.w(connectionSpecs);
            return this;
        }

        public final a j(C5548o dispatcher) {
            kotlin.jvm.internal.p.i(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        public final a k(InterfaceC5549p dns) {
            kotlin.jvm.internal.p.i(dns, "dns");
            if (!kotlin.jvm.internal.p.d(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        public final a l(AbstractC5550q.c eventListenerFactory) {
            kotlin.jvm.internal.p.i(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        /* renamed from: m, reason: from getter */
        public final InterfaceC5535b getAuthenticator() {
            return this.authenticator;
        }

        public final C5536c n() {
            return null;
        }

        /* renamed from: o, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        /* renamed from: p, reason: from getter */
        public final Ib.c getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        /* renamed from: q, reason: from getter */
        public final C5541h getCertificatePinner() {
            return this.certificatePinner;
        }

        /* renamed from: r, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        /* renamed from: s, reason: from getter */
        public final C5544k getConnectionPool() {
            return this.connectionPool;
        }

        public final List<okhttp3.b> t() {
            return this.connectionSpecs;
        }

        /* renamed from: u, reason: from getter */
        public final InterfaceC5546m getCookieJar() {
            return this.cookieJar;
        }

        /* renamed from: v, reason: from getter */
        public final C5548o getDispatcher() {
            return this.dispatcher;
        }

        /* renamed from: w, reason: from getter */
        public final InterfaceC5549p getDns() {
            return this.dns;
        }

        /* renamed from: x, reason: from getter */
        public final AbstractC5550q.c getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* renamed from: y, reason: from getter */
        public final boolean getFastFallback() {
            return this.fastFallback;
        }

        /* renamed from: z, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(z okHttpClient) {
            this();
            kotlin.jvm.internal.p.i(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.getDispatcher();
            this.connectionPool = okHttpClient.getConnectionPool();
            Z8.A.E(this.interceptors, okHttpClient.w());
            Z8.A.E(this.networkInterceptors, okHttpClient.y());
            this.eventListenerFactory = okHttpClient.getEventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.getRetryOnConnectionFailure();
            this.fastFallback = okHttpClient.getFastFallback();
            this.authenticator = okHttpClient.getAuthenticator();
            this.followRedirects = okHttpClient.getFollowRedirects();
            this.followSslRedirects = okHttpClient.getFollowSslRedirects();
            this.cookieJar = okHttpClient.getCookieJar();
            okHttpClient.e();
            this.dns = okHttpClient.getDns();
            this.proxy = okHttpClient.getProxy();
            this.proxySelector = okHttpClient.getProxySelector();
            this.proxyAuthenticator = okHttpClient.getProxyAuthenticator();
            this.socketFactory = okHttpClient.getSocketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.getSslSocketFactoryOrNull();
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.k();
            this.protocols = okHttpClient.B();
            this.hostnameVerifier = okHttpClient.getHostnameVerifier();
            this.certificatePinner = okHttpClient.getCertificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.getCallTimeoutMillis();
            this.connectTimeout = okHttpClient.getConnectTimeoutMillis();
            this.readTimeout = okHttpClient.getReadTimeoutMillis();
            this.writeTimeout = okHttpClient.getWriteTimeoutMillis();
            this.pingInterval = okHttpClient.getPingIntervalMillis();
            this.webSocketCloseTimeout = okHttpClient.getWebSocketCloseTimeout();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
            this.taskRunner = okHttpClient.getTaskRunner();
        }
    }

    public z() {
        this(new a());
    }
}
