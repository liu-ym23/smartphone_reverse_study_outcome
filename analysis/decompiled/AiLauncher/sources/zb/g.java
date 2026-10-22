package zb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.AbstractC5550q;
import tb.C5528A;
import tb.C5530C;
import tb.C5534a;
import tb.C5536c;
import tb.C5541h;
import tb.C5544k;
import tb.InterfaceC5535b;
import tb.InterfaceC5538e;
import tb.InterfaceC5543j;
import tb.InterfaceC5546m;
import tb.InterfaceC5549p;
import tb.v;
import tb.w;
import tb.z;
import yb.C6027h;
import yb.C6032m;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BÑ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.BC\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010/\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b-\u00102Jí\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2\n\b\u0002\u00103\u001a\u0004\u0018\u00010'2\n\b\u0002\u00104\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b5\u00106J\u0011\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0007H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0003\u001a\u00020<H\u0016¢\u0006\u0004\b\u0003\u0010=J\u000f\u0010>\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020@2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\bA\u0010BJ\u0015\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bF\u0010GR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010LR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010?R\u001a\u0010\r\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010N\u001a\u0004\bW\u0010;R\u001a\u0010\u000e\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u0010N\u001a\u0004\bX\u0010;R\u001a\u0010\u000f\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bY\u0010N\u001a\u0004\bZ\u0010;R\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010[\u001a\u0004\bV\u0010\\R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\bF\u0010e\u001a\u0004\bM\u0010fR\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u0010g\u001a\u0004\bh\u0010iR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bJ\u0010n\u001a\u0004\bo\u0010pR\u001a\u0010 \u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010[\u001a\u0004\bO\u0010\\R\u001a\u0010\"\u001a\u00020!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bW\u0010q\u001a\u0004\br\u0010sR\u001a\u0010$\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bc\u0010t\u001a\u0004\bS\u0010uR\u001a\u0010&\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bh\u0010v\u001a\u0004\bw\u0010xR\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bQ\u0010y\u001a\u0004\bz\u0010{R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bl\u0010|\u001a\u0004\b}\u0010~R\u001b\u0010,\u001a\u0004\u0018\u00010+8\u0006¢\u0006\u000e\n\u0004\bo\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0082\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010NR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0013\u0010\u0083\u0001\u001a\u0005\b]\u0010\u0084\u0001R\u0017\u0010\u0087\u0001\u001a\u00030\u0085\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bY\u0010\u0086\u0001R\u0015\u0010\u0088\u0001\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010uR\u0015\u0010\u0089\u0001\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010u¨\u0006\u008a\u0001"}, d2 = {"Lzb/g;", "Ltb/w$a;", "Lyb/m;", "call", "", "Ltb/w;", "interceptors", "", "index", "Lyb/h;", "exchange", "Ltb/A;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "Ltb/b;", "authenticator", "Ltb/c;", "cache", "Ltb/h;", "certificatePinner", "Ltb/k;", "connectionPool", "Ltb/m;", "cookieJar", "Ltb/p;", "dns", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Ljava/net/Proxy;", "proxy", "proxyAuthenticator", "Ljava/net/ProxySelector;", "proxySelector", "", "retryOnConnectionFailure", "Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerOrNull", "LIb/c;", "certificateChainCleaner", "<init>", "(Lyb/m;Ljava/util/List;ILyb/h;Ltb/A;IIILtb/b;Ltb/c;Ltb/h;Ltb/k;Ltb/m;Ltb/p;Ljavax/net/ssl/HostnameVerifier;Ljava/net/Proxy;Ltb/b;Ljava/net/ProxySelector;ZLjavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;LIb/c;)V", "", "Ltb/z;", "client", "(Lyb/m;Ljava/util/List;ILjava/lang/Void;Ltb/A;Ltb/z;)V", "sslSocketFactory", "x509TrustManager", "m", "(ILyb/h;Ltb/A;IIILtb/b;Ltb/c;Ltb/h;Ltb/k;Ltb/m;Ltb/p;Ljavax/net/ssl/HostnameVerifier;Ljava/net/Proxy;Ltb/b;Ljava/net/ProxySelector;ZLjavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;LIb/c;)Lzb/g;", "Ltb/j;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ltb/j;", "D", "()I", "Ltb/e;", "()Ltb/e;", Const.INTENT_KEY_PKGNAME, "()Ltb/A;", "Ltb/C;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/A;)Ltb/C;", "Ltb/v;", "url", "Ltb/a;", "l", "(Ltb/v;)Ltb/a;", Const.INTENT_KEY_APIKEY, "Lyb/m;", "o", "()Lyb/m;", "Ljava/util/List;", "c", "I", Const.INTENT_KEY_UMID, "Lyb/h;", "t", "()Lyb/h;", "e", "Ltb/A;", "y", "f", "q", "x", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "B", "Ltb/b;", "()Ltb/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ltb/h;", "p", "()Ltb/h;", "k", "Ltb/k;", "r", "()Ltb/k;", "Ltb/m;", "()Ltb/m;", "Ltb/p;", "s", "()Ltb/p;", "n", "Ljavax/net/ssl/HostnameVerifier;", "u", "()Ljavax/net/ssl/HostnameVerifier;", "Ljava/net/Proxy;", "v", "()Ljava/net/Proxy;", "Ljava/net/ProxySelector;", "w", "()Ljava/net/ProxySelector;", "Z", "()Z", "Ljavax/net/SocketFactory;", "z", "()Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "C", "()Ljavax/net/ssl/X509TrustManager;", "LIb/c;", "getCertificateChainCleaner", "()LIb/c;", "calls", "Ltb/c;", "()Ltb/c;", "Ltb/q;", "()Ltb/q;", "eventListener", "followSslRedirects", "followRedirects", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class g implements w.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6032m call;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<w> interceptors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C6027h exchange;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C5528A request;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int connectTimeoutMillis;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int readTimeoutMillis;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int writeTimeoutMillis;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5535b authenticator;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final C5541h certificatePinner;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C5544k connectionPool;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5546m cookieJar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5549p dns;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final HostnameVerifier hostnameVerifier;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final Proxy proxy;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5535b proxyAuthenticator;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final ProxySelector proxySelector;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final boolean retryOnConnectionFailure;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final SocketFactory socketFactory;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final SSLSocketFactory sslSocketFactoryOrNull;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final X509TrustManager x509TrustManagerOrNull;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final Ib.c certificateChainCleaner;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public int calls;

    /* JADX WARN: Multi-variable type inference failed */
    public g(C6032m call, List<? extends w> interceptors, int i10, C6027h c6027h, C5528A request, int i11, int i12, int i13, InterfaceC5535b authenticator, C5536c c5536c, C5541h certificatePinner, C5544k connectionPool, InterfaceC5546m cookieJar, InterfaceC5549p dns, HostnameVerifier hostnameVerifier, Proxy proxy, InterfaceC5535b proxyAuthenticator, ProxySelector proxySelector, boolean z10, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, Ib.c cVar) {
        p.i(call, "call");
        p.i(interceptors, "interceptors");
        p.i(request, "request");
        p.i(authenticator, "authenticator");
        p.i(certificatePinner, "certificatePinner");
        p.i(connectionPool, "connectionPool");
        p.i(cookieJar, "cookieJar");
        p.i(dns, "dns");
        p.i(hostnameVerifier, "hostnameVerifier");
        p.i(proxyAuthenticator, "proxyAuthenticator");
        p.i(proxySelector, "proxySelector");
        p.i(socketFactory, "socketFactory");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i10;
        this.exchange = c6027h;
        this.request = request;
        this.connectTimeoutMillis = i11;
        this.readTimeoutMillis = i12;
        this.writeTimeoutMillis = i13;
        this.authenticator = authenticator;
        this.certificatePinner = certificatePinner;
        this.connectionPool = connectionPool;
        this.cookieJar = cookieJar;
        this.dns = dns;
        this.hostnameVerifier = hostnameVerifier;
        this.proxy = proxy;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxySelector = proxySelector;
        this.retryOnConnectionFailure = z10;
        this.socketFactory = socketFactory;
        this.sslSocketFactoryOrNull = sSLSocketFactory;
        this.x509TrustManagerOrNull = x509TrustManager;
        this.certificateChainCleaner = cVar;
    }

    public static /* synthetic */ g n(g gVar, int i10, C6027h c6027h, C5528A c5528a, int i11, int i12, int i13, InterfaceC5535b interfaceC5535b, C5536c c5536c, C5541h c5541h, C5544k c5544k, InterfaceC5546m interfaceC5546m, InterfaceC5549p interfaceC5549p, HostnameVerifier hostnameVerifier, Proxy proxy, InterfaceC5535b interfaceC5535b2, ProxySelector proxySelector, boolean z10, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, Ib.c cVar, int i14, Object obj) {
        C5536c c5536c2;
        int i15 = (i14 & 1) != 0 ? gVar.index : i10;
        C6027h c6027h2 = (i14 & 2) != 0 ? gVar.exchange : c6027h;
        C5528A c5528a2 = (i14 & 4) != 0 ? gVar.request : c5528a;
        int i16 = (i14 & 8) != 0 ? gVar.connectTimeoutMillis : i11;
        int i17 = (i14 & 16) != 0 ? gVar.readTimeoutMillis : i12;
        int i18 = (i14 & 32) != 0 ? gVar.writeTimeoutMillis : i13;
        InterfaceC5535b authenticator = (i14 & 64) != 0 ? gVar.getAuthenticator() : interfaceC5535b;
        if ((i14 & 128) != 0) {
            gVar.j();
            c5536c2 = null;
        } else {
            c5536c2 = c5536c;
        }
        return gVar.m(i15, c6027h2, c5528a2, i16, i17, i18, authenticator, c5536c2, (i14 & 256) != 0 ? gVar.getCertificatePinner() : c5541h, (i14 & 512) != 0 ? gVar.getConnectionPool() : c5544k, (i14 & 1024) != 0 ? gVar.getCookieJar() : interfaceC5546m, (i14 & 2048) != 0 ? gVar.getDns() : interfaceC5549p, (i14 & 4096) != 0 ? gVar.getHostnameVerifier() : hostnameVerifier, (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? gVar.getProxy() : proxy, (i14 & 16384) != 0 ? gVar.getProxyAuthenticator() : interfaceC5535b2, (i14 & 32768) != 0 ? gVar.getProxySelector() : proxySelector, (i14 & 65536) != 0 ? gVar.getRetryOnConnectionFailure() : z10, (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? gVar.getSocketFactory() : socketFactory, (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? gVar.getSslSocketFactoryOrNull() : sSLSocketFactory, (i14 & 524288) != 0 ? gVar.getX509TrustManagerOrNull() : x509TrustManager, (i14 & 1048576) != 0 ? gVar.certificateChainCleaner : cVar);
    }

    /* renamed from: A, reason: from getter */
    public SSLSocketFactory getSslSocketFactoryOrNull() {
        return this.sslSocketFactoryOrNull;
    }

    /* renamed from: B, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* renamed from: C, reason: from getter */
    public X509TrustManager getX509TrustManagerOrNull() {
        return this.x509TrustManagerOrNull;
    }

    /* renamed from: D, reason: from getter */
    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // tb.w.a
    public boolean a() {
        return this.call.getClient().getFollowRedirects();
    }

    @Override // tb.w.a
    /* renamed from: b, reason: from getter */
    public C5528A getRequest() {
        return this.request;
    }

    @Override // tb.w.a
    /* renamed from: c, reason: from getter */
    public InterfaceC5546m getCookieJar() {
        return this.cookieJar;
    }

    @Override // tb.w.a
    public InterfaceC5538e call() {
        return this.call;
    }

    @Override // tb.w.a
    /* renamed from: d, reason: from getter */
    public InterfaceC5535b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Override // tb.w.a
    /* renamed from: e, reason: from getter */
    public boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Override // tb.w.a
    /* renamed from: f, reason: from getter */
    public InterfaceC5535b getAuthenticator() {
        return this.authenticator;
    }

    @Override // tb.w.a
    public InterfaceC5543j g() {
        C6027h c6027h = this.exchange;
        if (c6027h != null) {
            return c6027h.j();
        }
        return null;
    }

    @Override // tb.w.a
    public AbstractC5550q h() {
        return this.call.getEventListener();
    }

    @Override // tb.w.a
    public C5530C i(C5528A request) throws IOException {
        p.i(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        C6027h c6027h = this.exchange;
        if (c6027h != null) {
            if (!c6027h.getFinder().getRoutePlanner().g(request.getUrl())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        g gVarN = n(this, this.index + 1, null, request, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 2097146, null);
        w wVar = this.interceptors.get(this.index);
        C5530C c5530cIntercept = wVar.intercept(gVarN);
        if (c5530cIntercept == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (this.exchange == null || this.index + 1 >= this.interceptors.size() || gVarN.calls == 1) {
            return c5530cIntercept;
        }
        throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
    }

    @Override // tb.w.a
    public C5536c j() {
        return null;
    }

    @Override // tb.w.a
    public boolean k() {
        return this.call.getClient().getFollowSslRedirects();
    }

    public final C5534a l(v url) {
        SSLSocketFactory sslSocketFactoryOrNull;
        HostnameVerifier hostnameVerifier;
        C5541h certificatePinner;
        p.i(url, "url");
        if (url.i()) {
            sslSocketFactoryOrNull = getSslSocketFactoryOrNull();
            hostnameVerifier = getHostnameVerifier();
            certificatePinner = getCertificatePinner();
        } else {
            sslSocketFactoryOrNull = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new C5534a(url.getHost(), url.getPort(), getDns(), getSocketFactory(), sslSocketFactoryOrNull, hostnameVerifier, certificatePinner, getProxyAuthenticator(), getProxy(), this.call.getClient().B(), this.call.getClient().k(), getProxySelector());
    }

    public final g m(int index, C6027h exchange, C5528A request, int connectTimeoutMillis, int readTimeoutMillis, int writeTimeoutMillis, InterfaceC5535b authenticator, C5536c cache, C5541h certificatePinner, C5544k connectionPool, InterfaceC5546m cookieJar, InterfaceC5549p dns, HostnameVerifier hostnameVerifier, Proxy proxy, InterfaceC5535b proxyAuthenticator, ProxySelector proxySelector, boolean retryOnConnectionFailure, SocketFactory socketFactory, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Ib.c certificateChainCleaner) {
        p.i(request, "request");
        p.i(authenticator, "authenticator");
        p.i(certificatePinner, "certificatePinner");
        p.i(connectionPool, "connectionPool");
        p.i(cookieJar, "cookieJar");
        p.i(dns, "dns");
        p.i(hostnameVerifier, "hostnameVerifier");
        p.i(proxyAuthenticator, "proxyAuthenticator");
        p.i(proxySelector, "proxySelector");
        p.i(socketFactory, "socketFactory");
        return new g(this.call, this.interceptors, index, exchange, request, connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, authenticator, cache, certificatePinner, connectionPool, cookieJar, dns, hostnameVerifier, proxy, proxyAuthenticator, proxySelector, retryOnConnectionFailure, socketFactory, sslSocketFactory, x509TrustManager, certificateChainCleaner);
    }

    /* renamed from: o, reason: from getter */
    public final C6032m getCall() {
        return this.call;
    }

    /* renamed from: p, reason: from getter */
    public C5541h getCertificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: q, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: r, reason: from getter */
    public C5544k getConnectionPool() {
        return this.connectionPool;
    }

    /* renamed from: s, reason: from getter */
    public InterfaceC5549p getDns() {
        return this.dns;
    }

    /* renamed from: t, reason: from getter */
    public final C6027h getExchange() {
        return this.exchange;
    }

    /* renamed from: u, reason: from getter */
    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: v, reason: from getter */
    public Proxy getProxy() {
        return this.proxy;
    }

    /* renamed from: w, reason: from getter */
    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public final int x() {
        return this.readTimeoutMillis;
    }

    public final C5528A y() {
        return this.request;
    }

    /* renamed from: z, reason: from getter */
    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public /* synthetic */ g(C6032m c6032m, List list, int i10, Void r11, C5528A c5528a, z zVar, int i11, kotlin.jvm.internal.i iVar) {
        this(c6032m, list, i10, r11, c5528a, (i11 & 32) != 0 ? c6032m.getClient() : zVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public g(C6032m call, List<? extends w> interceptors, int i10, Void r29, C5528A request, z client) {
        p.i(call, "call");
        p.i(interceptors, "interceptors");
        p.i(request, "request");
        p.i(client, "client");
        int connectTimeoutMillis = client.getConnectTimeoutMillis();
        int readTimeoutMillis = client.getReadTimeoutMillis();
        int writeTimeoutMillis = client.getWriteTimeoutMillis();
        InterfaceC5535b authenticator = client.getAuthenticator();
        client.e();
        this(call, interceptors, i10, (C6027h) r29, request, connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, authenticator, null, client.getCertificatePinner(), client.getConnectionPool(), client.getCookieJar(), client.getDns(), client.getHostnameVerifier(), client.getProxy(), client.getProxyAuthenticator(), client.getProxySelector(), client.getRetryOnConnectionFailure(), client.getSocketFactory(), client.getSslSocketFactoryOrNull(), client.getX509TrustManager(), client.getCertificateChainCleaner());
    }
}
