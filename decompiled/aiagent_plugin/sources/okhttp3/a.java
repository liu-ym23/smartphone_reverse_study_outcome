package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f39688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SocketFactory f39689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SSLSocketFactory f39690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HostnameVerifier f39691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f39692e;
    private final b f;
    private final Proxy g;
    private final ProxySelector h;
    private final v i;
    private final List<aa> j;
    private final List<l> k;

    public a(String r3, int r4, q r5, SocketFactory r6, SSLSocketFactory r7, HostnameVerifier r8, g r9, b r10, Proxy r11, List<? extends aa> r12, List<l> r13, ProxySelector r14) {
        q r15 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        HostnameVerifier r16 = (HostnameVerifier) ZeusTransformUtils.wrapperContextForParams(r8, HostnameVerifier.class, "com.obric.aiagent.plugin");
        b r17 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.aiagent.plugin");
        List r18 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List r19 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "uriHost");
        d.h.b.o.e(r15, "dns");
        d.h.b.o.e(r6, "socketFactory");
        d.h.b.o.e(r17, "proxyAuthenticator");
        d.h.b.o.e(r18, "protocols");
        d.h.b.o.e(r19, "connectionSpecs");
        d.h.b.o.e(r14, "proxySelector");
        this.f39688a = r15;
        this.f39689b = r6;
        this.f39690c = r7;
        this.f39691d = r16;
        this.f39692e = r9;
        this.f = r17;
        this.g = r11;
        this.h = r14;
        v.a r20 = new v.a();
        if (r7 == null) goto L5;
        String r21 = "https";
    L6:
        this.i = r20.f(r21).i(r3).b(r4).c();
        this.j = okhttp3.internal.c.b(r18);
        this.k = okhttp3.internal.c.b(r19);
        return;
    L5:
        r21 = "http";
        goto L6
    }

    public final q a() {
        return this.f39688a;
    }

    public final SocketFactory b() {
        return this.f39689b;
    }

    public final SSLSocketFactory c() {
        return this.f39690c;
    }

    public final HostnameVerifier d() {
        return this.f39691d;
    }

    public final g e() {
        return this.f39692e;
    }

    public final b f() {
        return this.f;
    }

    public final Proxy g() {
        return this.g;
    }

    public final ProxySelector h() {
        return this.h;
    }

    public final v i() {
        return this.i;
    }

    public final List<aa> j() {
        return this.j;
    }

    public final List<l> k() {
        return this.k;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (d.h.b.o.a(this.i, ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).i) == false) goto L9;
        if (a((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.i.hashCode()) * 31) + this.f39688a.hashCode()) * 31) + this.f.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.h.hashCode()) * 31) + Objects.hashCode(this.g)) * 31) + Objects.hashCode(this.f39690c)) * 31) + Objects.hashCode(this.f39691d)) * 31) + Objects.hashCode(this.f39692e);
    }

    public final boolean a(a r3) {
        d.h.b.o.e(r3, "that");
        if (d.h.b.o.a(this.f39688a, r3.f39688a) == true) goto L5;
    L23:
        return false;
    L5:
        if (d.h.b.o.a(this.f, r3.f) == false) goto L23;
        if (d.h.b.o.a(this.j, r3.j) == false) goto L23;
        if (d.h.b.o.a(this.k, r3.k) == false) goto L23;
        if (d.h.b.o.a(this.h, r3.h) == false) goto L23;
        if (d.h.b.o.a(this.g, r3.g) == false) goto L23;
        if (d.h.b.o.a(this.f39690c, r3.f39690c) == false) goto L23;
        if (d.h.b.o.a(this.f39691d, r3.f39691d) == false) goto L23;
        if (d.h.b.o.a(this.f39692e, r3.f39692e) == false) goto L23;
        if (this.i.c() != r3.i.c()) goto L23;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Address{").append(this.i.b()).append(':').append(this.i.c()).append(", ");
        if (this.g == null) goto L5;
        StringBuilder r1 = new StringBuilder().append("proxy=");
        Object r3 = this.g;
    L7:
        return r0.append(r1.append(r3).toString()).append('}').toString();
    L5:
        r1 = new StringBuilder().append("proxySelector=");
        r3 = this.h;
        goto L7
    }
}
