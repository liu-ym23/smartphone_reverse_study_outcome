package okhttp3;

import com.bytedance.keva.KevaImpl;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes4.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final List B = null;
    public static final List C = null;
    public final int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f22724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f22725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f22726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f22727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f22728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f22729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EventListener.Factory f22730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProxySelector f22731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CookieJar f22732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Cache f22733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final InternalCache f22734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SocketFactory f22735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SSLSocketFactory f22736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CertificateChainCleaner f22737n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HostnameVerifier f22738o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f22739p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Authenticator f22740q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Authenticator f22741r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConnectionPool f22742s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Dns f22743t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f22744u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f22745v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f22746w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f22747x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f22748y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f22749z;

    public static final class Builder {
        public int A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f22750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Proxy f22751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f22752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f22753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f22754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f22755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public EventListener.Factory f22756g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ProxySelector f22757h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CookieJar f22758i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Cache f22759j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public InternalCache f22760k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public SocketFactory f22761l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SSLSocketFactory f22762m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CertificateChainCleaner f22763n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public HostnameVerifier f22764o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public b f22765p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Authenticator f22766q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Authenticator f22767r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ConnectionPool f22768s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Dns f22769t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f22770u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f22771v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f22772w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f22773x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f22774y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f22775z;

        public Builder() {
            this.f22754e = new ArrayList();
            this.f22755f = new ArrayList();
            this.f22750a = new f();
            this.f22752c = OkHttpClient.B;
            this.f22753d = OkHttpClient.C;
            this.f22756g = EventListener.factory(EventListener.NONE);
            this.f22757h = ProxySelector.getDefault();
            this.f22758i = CookieJar.NO_COOKIES;
            this.f22761l = SocketFactory.getDefault();
            this.f22764o = OkHostnameVerifier.INSTANCE;
            this.f22765p = b.f22852c;
            Authenticator r10 = Authenticator.NONE;
            this.f22766q = r10;
            this.f22767r = r10;
            this.f22768s = new ConnectionPool();
            this.f22769t = Dns.SYSTEM;
            this.f22770u = true;
            this.f22771v = true;
            this.f22772w = true;
            this.f22773x = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f22774y = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f22775z = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.A = 0;
        }

        public Builder a(Interceptor r10) {
            if (r10 == null) goto L6;
            this.f22754e.add(r10);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder b(Interceptor r10) {
            if (r10 == null) goto L6;
            this.f22755f.add(r10);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public OkHttpClient c() {
            return new OkHttpClient(this);
        }

        public Builder d(Cache r10) {
            this.f22759j = r10;
            this.f22760k = null;
            return this;
        }

        public Builder e(long r10, TimeUnit r11) {
            this.f22773x = Util.checkDuration("timeout", r10, r11);
            return this;
        }

        public Builder f(ConnectionPool r10) {
            if (r10 == null) goto L6;
            this.f22768s = r10;
            return this;
        L6:
            throw new NullPointerException("connectionPool == null");
        }

        public Builder g(CookieJar r10) {
            if (r10 == null) goto L6;
            this.f22758i = r10;
            return this;
        L6:
            throw new NullPointerException("cookieJar == null");
        }

        public Builder h(Dns r10) {
            if (r10 == null) goto L6;
            this.f22769t = r10;
            return this;
        L6:
            throw new NullPointerException("dns == null");
        }

        public Builder i(EventListener r10) {
            if (r10 == null) goto L6;
            this.f22756g = EventListener.factory(r10);
            return this;
        L6:
            throw new NullPointerException("eventListener == null");
        }

        public Builder j(EventListener.Factory r10) {
            if (r10 == null) goto L6;
            this.f22756g = r10;
            return this;
        L6:
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder k(boolean r10) {
            this.f22771v = r10;
            return this;
        }

        public List l() {
            return this.f22754e;
        }

        public Builder m(List r10) {
            ArrayList r11 = new ArrayList(r10);
            if (r11.contains(Protocol.HTTP_1_1) == false) goto L15;
            if (r11.contains(Protocol.HTTP_1_0) == true) goto L13;
            if (r11.contains(null) == true) goto L11;
            r11.remove(Protocol.SPDY_3);
            this.f22752c = Collections.unmodifiableList(r11);
            return this;
        L11:
            throw new IllegalArgumentException("protocols must not contain null");
        L13:
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + r11);
        L15:
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + r11);
        }

        public Builder n(long r10, TimeUnit r11) {
            this.f22774y = Util.checkDuration("timeout", r10, r11);
            return this;
        }

        public Builder o(boolean r10) {
            this.f22772w = r10;
            return this;
        }

        public void p(InternalCache r10) {
            this.f22760k = r10;
            this.f22759j = null;
        }

        public Builder q(long r10, TimeUnit r11) {
            this.f22775z = Util.checkDuration("timeout", r10, r11);
            return this;
        }

        public Builder(OkHttpClient r10) {
            ArrayList r11 = new ArrayList();
            this.f22754e = r11;
            ArrayList r12 = new ArrayList();
            this.f22755f = r12;
            this.f22750a = r10.f22724a;
            this.f22751b = r10.f22725b;
            this.f22752c = r10.f22726c;
            this.f22753d = r10.f22727d;
            r11.addAll(r10.f22728e);
            r12.addAll(r10.f22729f);
            this.f22756g = r10.f22730g;
            this.f22757h = r10.f22731h;
            this.f22758i = r10.f22732i;
            this.f22760k = r10.f22734k;
            this.f22759j = r10.f22733j;
            this.f22761l = r10.f22735l;
            this.f22762m = r10.f22736m;
            this.f22763n = r10.f22737n;
            this.f22764o = r10.f22738o;
            this.f22765p = r10.f22739p;
            this.f22766q = r10.f22740q;
            this.f22767r = r10.f22741r;
            this.f22768s = r10.f22742s;
            this.f22769t = r10.f22743t;
            this.f22770u = r10.f22744u;
            this.f22771v = r10.f22745v;
            this.f22772w = r10.f22746w;
            this.f22773x = r10.f22747x;
            this.f22774y = r10.f22748y;
            this.f22775z = r10.f22749z;
            this.A = r10.A;
        }
    }

    public static class a extends Internal {
        public a() {
        }

        @Override // okhttp3.internal.Internal
        public void addLenient(Headers.Builder r10, String r11) {
            r10.b(r11);
        }

        @Override // okhttp3.internal.Internal
        public void apply(ConnectionSpec r10, SSLSocket r11, boolean r12) {
            r10.a(r11, r12);
        }

        @Override // okhttp3.internal.Internal
        public int code(Response.Builder r10) {
            return r10.f22809c;
        }

        @Override // okhttp3.internal.Internal
        public boolean connectionBecameIdle(ConnectionPool r10, RealConnection r11) {
            return r10.b(r11);
        }

        @Override // okhttp3.internal.Internal
        public Socket deduplicate(ConnectionPool r10, Address r11, StreamAllocation r12) {
            return r10.c(r11, r12);
        }

        @Override // okhttp3.internal.Internal
        public boolean equalsNonHost(Address r10, Address r11) {
            return r10.d(r11);
        }

        @Override // okhttp3.internal.Internal
        public RealConnection get(ConnectionPool r10, Address r11, StreamAllocation r12, Route r13) {
            return r10.d(r11, r12, r13);
        }

        @Override // okhttp3.internal.Internal
        public HttpUrl getHttpUrlChecked(String r10) {
            return HttpUrl.l(r10);
        }

        @Override // okhttp3.internal.Internal
        public Call newWebSocketCall(OkHttpClient r10, Request r11) {
            return j.e(r10, r11, true);
        }

        @Override // okhttp3.internal.Internal
        public void put(ConnectionPool r10, RealConnection r11) {
            r10.f(r11);
        }

        @Override // okhttp3.internal.Internal
        public RouteDatabase routeDatabase(ConnectionPool r10) {
            return r10.f22677e;
        }

        @Override // okhttp3.internal.Internal
        public void setCache(Builder r10, InternalCache r11) {
            r10.p(r11);
        }

        @Override // okhttp3.internal.Internal
        public StreamAllocation streamAllocation(Call r10) {
            return ((j) r10).streamAllocation();
        }

        @Override // okhttp3.internal.Internal
        public void addLenient(Headers.Builder r10, String r11, String r12) {
            r10.c(r11, r12);
        }
    }

    static {
        B = Util.immutableList(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        C = Util.immutableList(new ConnectionSpec[]{ConnectionSpec.f22681f, ConnectionSpec.f22683h});
        Internal.instance = new a();
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public final X509TrustManager A() {
        TrustManagerFactory r10 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: GeneralSecurityException -> L8
        r10.init(null);     // Catch: GeneralSecurityException -> L8
        TrustManager[] r11 = r10.getTrustManagers();     // Catch: GeneralSecurityException -> L8
        if (r11.length != 1) goto L11;
        TrustManager r12 = r11[0];     // Catch: GeneralSecurityException -> L8
        if ((r12 instanceof X509TrustManager) == false) goto L11;
        return (X509TrustManager) r12;
    L11:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r11));     // Catch: GeneralSecurityException -> L8
    L8:
        e = move-exception;
        throw Util.assertionError("No System TLS", e);
    }

    public int B() {
        return this.f22749z;
    }

    public Authenticator a() {
        return this.f22741r;
    }

    public b b() {
        return this.f22739p;
    }

    public int c() {
        return this.f22747x;
    }

    public ConnectionPool d() {
        return this.f22742s;
    }

    public List e() {
        return this.f22727d;
    }

    public CookieJar f() {
        return this.f22732i;
    }

    public f g() {
        return this.f22724a;
    }

    public Dns h() {
        return this.f22743t;
    }

    public EventListener.Factory i() {
        return this.f22730g;
    }

    public boolean j() {
        return this.f22745v;
    }

    public boolean k() {
        return this.f22744u;
    }

    public HostnameVerifier l() {
        return this.f22738o;
    }

    public List m() {
        return this.f22728e;
    }

    public InternalCache n() {
        Cache r10 = this.f22733j;
        if (r10 == null) goto L6;
        return r10.internalCache;
    L6:
        return this.f22734k;
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request r10) {
        return j.e(this, r10, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request r10, WebSocketListener r11) {
        RealWebSocket r12 = new RealWebSocket(r10, r11, new Random(), this.A);
        r12.connect(this);
        return r12;
    }

    public List o() {
        return this.f22729f;
    }

    public Builder p() {
        return new Builder(this);
    }

    public int q() {
        return this.A;
    }

    public List r() {
        return this.f22726c;
    }

    public Proxy s() {
        return this.f22725b;
    }

    public Authenticator t() {
        return this.f22740q;
    }

    public ProxySelector u() {
        return this.f22731h;
    }

    public int v() {
        return this.f22748y;
    }

    public boolean w() {
        return this.f22746w;
    }

    public SocketFactory x() {
        return this.f22735l;
    }

    public SSLSocketFactory y() {
        return this.f22736m;
    }

    public final SSLSocketFactory z(X509TrustManager r10) {
        SSLContext r11 = Platform.get().getSSLContext();     // Catch: GeneralSecurityException -> L4
        r11.init(null, new TrustManager[]{r10}, null);     // Catch: GeneralSecurityException -> L4
        return r11.getSocketFactory();
    L4:
        e = move-exception;
        throw Util.assertionError("No System TLS", e);
    }

    public OkHttpClient(Builder r10) {
        this.f22724a = r10.f22750a;
        this.f22725b = r10.f22751b;
        this.f22726c = r10.f22752c;
        List r11 = r10.f22753d;
        this.f22727d = r11;
        this.f22728e = Util.immutableList(r10.f22754e);
        this.f22729f = Util.immutableList(r10.f22755f);
        this.f22730g = r10.f22756g;
        this.f22731h = r10.f22757h;
        this.f22732i = r10.f22758i;
        this.f22733j = r10.f22759j;
        this.f22734k = r10.f22760k;
        this.f22735l = r10.f22761l;
        Iterator r12 = r11.iterator();
    L3:
        boolean r13 = false;
    L5:
        if (r12.hasNext() == false) goto L11;
        ConnectionSpec r14 = (ConnectionSpec) r12.next();
        if (r13 == true) goto L10;
        if (r14.d() == false) goto L3;
    L10:
        r13 = true;
        goto L5
    L11:
        SSLSocketFactory r15 = r10.f22762m;
        if (r15 != null) goto L16;
        if (r13 == false) goto L16;
        X509TrustManager r16 = A();
        this.f22736m = z(r16);
        this.f22737n = CertificateChainCleaner.get(r16);
    L17:
        this.f22738o = r10.f22764o;
        this.f22739p = r10.f22765p.e(this.f22737n);
        this.f22740q = r10.f22766q;
        this.f22741r = r10.f22767r;
        this.f22742s = r10.f22768s;
        this.f22743t = r10.f22769t;
        this.f22744u = r10.f22770u;
        this.f22745v = r10.f22771v;
        this.f22746w = r10.f22772w;
        this.f22747x = r10.f22773x;
        this.f22748y = r10.f22774y;
        this.f22749z = r10.f22775z;
        this.A = r10.A;
        if (this.f22728e.contains(null) == true) goto L25;
        if (this.f22729f.contains(null) == true) goto L23;
        return;
    L23:
        throw new IllegalStateException("Null network interceptor: " + this.f22729f);
    L25:
        throw new IllegalStateException("Null interceptor: " + this.f22728e);
    L16:
        this.f22736m = r15;
        this.f22737n = r10.f22763n;
        goto L17
    }
}
