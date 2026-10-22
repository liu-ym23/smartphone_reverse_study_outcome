package X6;

import F9.G;
import F9.M;
import F9.t;
import F9.y;
import aa.InterfaceC0315b;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Protocol;

/* loaded from: classes3.dex */
public final class d extends t {
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public long f1508j;
    public long k;
    public long l;
    public long m;
    public String n;
    public String o;
    public String p;

    /* renamed from: q, reason: collision with root package name */
    public String f1509q;

    /* renamed from: r, reason: collision with root package name */
    public InterfaceC0315b f1510r;

    @Override // F9.t
    public final void c(J9.i iVar) {
        this.c = System.currentTimeMillis();
        this.f1510r.debug("requestId: {}, method: {}, host: {}, request uri: {}, dns cost: {} ms, connect cost: {} ms, tls handshake cost: {} ms, send headers and body cost: {} ms, wait response cost: {} ms, request cost: {} ms\n", this.f1509q, this.n, this.o, this.p, Long.valueOf(this.e - this.d), Long.valueOf(this.g - this.f), Long.valueOf(this.i - this.h), Long.valueOf(this.k - this.f1508j), Long.valueOf(this.m - this.l), Long.valueOf(this.c - this.b));
    }

    @Override // F9.t
    public final void d(J9.i iVar, IOException iOException) {
        this.c = System.currentTimeMillis();
        this.c = System.currentTimeMillis();
        this.f1510r.debug("requestId: {}, method: {}, host: {}, request uri: {}, dns cost: {} ms, connect cost: {} ms, tls handshake cost: {} ms, send headers and body cost: {} ms, wait response cost: {} ms, request cost: {} ms\n", this.f1509q, this.n, this.o, this.p, Long.valueOf(this.e - this.d), Long.valueOf(this.g - this.f), Long.valueOf(this.i - this.h), Long.valueOf(this.k - this.f1508j), Long.valueOf(this.m - this.l), Long.valueOf(this.c - this.b));
    }

    @Override // F9.t
    public final void e(J9.i iVar) {
        this.b = System.currentTimeMillis();
        G g = iVar.b;
        this.n = g.b;
        y yVar = g.f626a;
        this.o = yVar.d;
        this.p = yVar.b();
    }

    @Override // F9.t
    public final void g(J9.i iVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        this.g = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void h(J9.i iVar, InetSocketAddress inetSocketAddress, Proxy proxy, IOException iOException) {
        this.g = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void i(J9.i iVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void l(J9.i iVar, String str, List list) {
        this.e = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void m(J9.i iVar, String str) {
        this.d = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void n(J9.i iVar, long j5) {
        this.k = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void p(J9.i iVar, G g) {
        this.k = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void q(J9.i iVar) {
        this.f1508j = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void r(J9.i iVar, long j5) {
        this.m = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void s(J9.i iVar) {
        this.l = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void t(J9.i iVar, M m) {
        this.m = System.currentTimeMillis();
        this.f1509q = M.b(m, "X-Tos-Request-Id");
    }

    @Override // F9.t
    public final void u(J9.i iVar) {
        this.l = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void w(J9.i iVar, okhttp3.c cVar) {
        this.i = System.currentTimeMillis();
    }

    @Override // F9.t
    public final void x(J9.i iVar) {
        this.h = System.currentTimeMillis();
    }
}
