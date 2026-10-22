package y5;

import F9.G;
import F9.M;
import F9.t;
import F9.y;
import J9.i;
import S7.k;
import android.os.SystemClock;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.CancellationException;
import okhttp3.Protocol;

/* loaded from: classes3.dex */
public final class e extends t {
    public final k b;
    public final String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public long f6902j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6903q;

    /* renamed from: r, reason: collision with root package name */
    public Integer f6904r;

    /* renamed from: s, reason: collision with root package name */
    public Exception f6905s;

    public e(k kVar, String traceIdHeader) {
        kotlin.jvm.internal.k.f(traceIdHeader, "traceIdHeader");
        this.b = kVar;
        this.c = traceIdHeader;
    }

    @Override // F9.t
    public final void c(i iVar) {
        if (this.f6905s != null) {
            return;
        }
        G g = iVar.b;
        y(g.f626a, g.b, g.a(this.c));
    }

    @Override // F9.t
    public final void d(i iVar, IOException iOException) {
        this.f6905s = iOException;
        G g = iVar.b;
        y(g.f626a, g.b, g.a(this.c));
    }

    @Override // F9.t
    public final void e(i iVar) {
        this.d = SystemClock.elapsedRealtime();
    }

    @Override // F9.t
    public final void f(i iVar) {
        if (this.f6905s == null && this.f6904r == null) {
            this.f6905s = new CancellationException("Canceled");
            G g = iVar.b;
            y(g.f626a, g.b, g.a(this.c));
        }
    }

    @Override // F9.t
    public final void g(i iVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        kotlin.jvm.internal.k.f(inetSocketAddress, "inetSocketAddress");
        this.k = SystemClock.elapsedRealtime() - this.f;
    }

    @Override // F9.t
    public final void i(i iVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        kotlin.jvm.internal.k.f(inetSocketAddress, "inetSocketAddress");
        this.f = SystemClock.elapsedRealtime();
    }

    @Override // F9.t
    public final void j(i iVar, okhttp3.internal.connection.a connection) {
        kotlin.jvm.internal.k.f(connection, "connection");
        if (this.f == 0) {
            this.f6903q = true;
        }
    }

    @Override // F9.t
    public final void l(i iVar, String str, List list) {
        this.f6902j = SystemClock.elapsedRealtime() - this.e;
    }

    @Override // F9.t
    public final void m(i iVar, String str) {
        this.e = SystemClock.elapsedRealtime();
    }

    @Override // F9.t
    public final void n(i iVar, long j5) {
        this.o = j5;
    }

    @Override // F9.t
    public final void q(i iVar) {
        this.h = SystemClock.elapsedRealtime();
    }

    @Override // F9.t
    public final void r(i iVar, long j5) {
        this.p = j5;
        this.n = SystemClock.elapsedRealtime() - this.i;
    }

    @Override // F9.t
    public final void t(i iVar, M m) {
        this.f6904r = Integer.valueOf(m.d);
    }

    @Override // F9.t
    public final void u(i iVar) {
        this.m = SystemClock.elapsedRealtime() - this.h;
        this.i = SystemClock.elapsedRealtime();
    }

    @Override // F9.t
    public final void w(i iVar, okhttp3.c cVar) {
        this.l = SystemClock.elapsedRealtime() - this.g;
    }

    @Override // F9.t
    public final void x(i iVar) {
        this.g = SystemClock.elapsedRealtime();
    }

    public final void y(y yVar, String str, String str2) {
        try {
            this.b.invoke(new d(yVar.i, str, this.f6904r, SystemClock.elapsedRealtime() - this.d, this.f6902j, this.k, this.l, this.m, this.n, this.o, this.p, this.f6903q, this.f6905s, str2));
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
    }
}
