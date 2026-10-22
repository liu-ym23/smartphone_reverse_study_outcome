package n6;

import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p {
    public int A;
    public long B;
    public androidx.emoji2.text.m C;
    public q6.d D;

    /* renamed from: b, reason: collision with root package name */
    public androidx.emoji2.text.m f4074b;

    /* renamed from: e, reason: collision with root package name */
    public a1.n f4076e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4077f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4078g;

    /* renamed from: h, reason: collision with root package name */
    public b f4079h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4080i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4081j;

    /* renamed from: k, reason: collision with root package name */
    public b f4082k;

    /* renamed from: l, reason: collision with root package name */
    public b f4083l;

    /* renamed from: m, reason: collision with root package name */
    public ProxySelector f4084m;

    /* renamed from: n, reason: collision with root package name */
    public b f4085n;

    /* renamed from: o, reason: collision with root package name */
    public SocketFactory f4086o;

    /* renamed from: p, reason: collision with root package name */
    public SSLSocketFactory f4087p;

    /* renamed from: q, reason: collision with root package name */
    public X509TrustManager f4088q;

    /* renamed from: r, reason: collision with root package name */
    public List f4089r;

    /* renamed from: s, reason: collision with root package name */
    public List f4090s;

    /* renamed from: t, reason: collision with root package name */
    public HostnameVerifier f4091t;

    /* renamed from: u, reason: collision with root package name */
    public e f4092u;

    /* renamed from: v, reason: collision with root package name */
    public z6.d f4093v;

    /* renamed from: w, reason: collision with root package name */
    public int f4094w;

    /* renamed from: x, reason: collision with root package name */
    public int f4095x;
    public int y;
    public int z;

    /* renamed from: a, reason: collision with root package name */
    public a1.w f4073a = new a1.w(7);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4075c = new ArrayList();
    public final ArrayList d = new ArrayList();

    public p() {
        TimeZone timeZone = o6.f.f4330a;
        this.f4076e = new a1.n(12);
        this.f4077f = true;
        this.f4078g = true;
        b bVar = b.f3995b;
        this.f4079h = bVar;
        this.f4080i = true;
        this.f4081j = true;
        this.f4082k = b.f3996c;
        this.f4083l = b.d;
        this.f4085n = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        kotlin.jvm.internal.p.d(socketFactory, "getDefault(...)");
        this.f4086o = socketFactory;
        this.f4089r = q.F;
        this.f4090s = q.E;
        this.f4091t = z6.e.f6547a;
        this.f4092u = e.f4010c;
        this.f4094w = 10000;
        this.f4095x = 10000;
        this.y = 10000;
        this.A = 60000;
        this.B = 1024L;
    }
}
