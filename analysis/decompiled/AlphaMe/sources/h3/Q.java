package h3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
public final class Q {

    /* renamed from: A, reason: collision with root package name */
    public int f12751A;

    /* renamed from: B, reason: collision with root package name */
    public int f12752B;

    /* renamed from: C, reason: collision with root package name */
    public long f12753C;

    /* renamed from: D, reason: collision with root package name */
    public RouteDatabase f12754D;

    /* renamed from: a, reason: collision with root package name */
    public C0614x f12755a = new C0614x();

    /* renamed from: b, reason: collision with root package name */
    public r f12756b = new r();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f12757c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f12758d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0591A f12759e = Util.asFactory(B.f12700a);

    /* renamed from: f, reason: collision with root package name */
    public boolean f12760f = true;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0593b f12761g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12762h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12763i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0613w f12764j;

    /* renamed from: k, reason: collision with root package name */
    public C0599h f12765k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC0615y f12766l;

    /* renamed from: m, reason: collision with root package name */
    public Proxy f12767m;

    /* renamed from: n, reason: collision with root package name */
    public ProxySelector f12768n;

    /* renamed from: o, reason: collision with root package name */
    public InterfaceC0593b f12769o;

    /* renamed from: p, reason: collision with root package name */
    public SocketFactory f12770p;

    /* renamed from: q, reason: collision with root package name */
    public SSLSocketFactory f12771q;

    /* renamed from: r, reason: collision with root package name */
    public X509TrustManager f12772r;

    /* renamed from: s, reason: collision with root package name */
    public List f12773s;

    /* renamed from: t, reason: collision with root package name */
    public List f12774t;

    /* renamed from: u, reason: collision with root package name */
    public HostnameVerifier f12775u;

    /* renamed from: v, reason: collision with root package name */
    public C0605n f12776v;

    /* renamed from: w, reason: collision with root package name */
    public CertificateChainCleaner f12777w;

    /* renamed from: x, reason: collision with root package name */
    public int f12778x;

    /* renamed from: y, reason: collision with root package name */
    public int f12779y;

    /* renamed from: z, reason: collision with root package name */
    public int f12780z;

    public Q() {
        com.google.android.gms.common.internal.f fVar = InterfaceC0593b.f12863b0;
        this.f12761g = fVar;
        this.f12762h = true;
        this.f12763i = true;
        this.f12764j = InterfaceC0613w.f12987c0;
        this.f12766l = InterfaceC0615y.f12992d0;
        this.f12769o = fVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
        this.f12770p = socketFactory;
        this.f12773s = S.f12782F;
        this.f12774t = S.f12781E;
        this.f12775u = OkHostnameVerifier.INSTANCE;
        this.f12776v = C0605n.f12937c;
        this.f12779y = 10000;
        this.f12780z = 10000;
        this.f12751A = 10000;
        this.f12753C = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public final void a(InterfaceC0615y dns) {
        Intrinsics.checkNotNullParameter(dns, "dns");
        if (!Intrinsics.areEqual(dns, this.f12766l)) {
            this.f12754D = null;
        }
        Intrinsics.checkNotNullParameter(dns, "<set-?>");
        this.f12766l = dns;
    }
}
