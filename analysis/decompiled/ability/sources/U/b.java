package U;

import F9.G;
import F9.M;
import F9.t;
import F9.w;
import F9.y;
import android.text.TextUtils;
import android.util.Log;
import ca.AbstractC0897f;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import okhttp3.Protocol;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends t {
    public t b;
    public i c;
    public String d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public long f1240j;
    public long k;
    public long l;
    public long m;
    public int n;
    public JSONObject o;
    public JSONObject p;

    /* renamed from: q, reason: collision with root package name */
    public StringBuilder f1241q;

    @Override // F9.t
    public final void a(J9.i iVar, M m) {
        this.c.k.b = true;
        B7.a.A(new StringBuilder(" cacheConditionalHit() "), this.f1241q);
    }

    @Override // F9.t
    public final void b(J9.i iVar, M m) {
        this.c.k.f1242a = true;
        B7.a.A(new StringBuilder(" cacheHit() "), this.f1241q);
    }

    @Override // F9.t
    public final void c(J9.i iVar) {
        B7.a.A(new StringBuilder(" callEnd() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.c(iVar);
        }
        y();
    }

    @Override // F9.t
    public final void d(J9.i iVar, IOException iOException) {
        i iVar2 = this.c;
        B7.a.A(new StringBuilder(" callFailed() "), this.f1241q);
        this.n = 2;
        t tVar = this.b;
        if (tVar != null) {
            tVar.d(iVar, iOException);
        }
        if (this.e) {
            iVar2.f1249j.f1245a = S0.b.s(Thread.currentThread().getStackTrace());
            iVar2.f1249j.d = iOException.getClass().getName();
            iVar2.f1249j.c = iOException.getClass().getName() + ":" + iOException.getMessage();
            iVar2.f1249j.b = S0.b.e(iOException);
        }
        y();
    }

    @Override // F9.t
    public final void e(J9.i iVar) {
        i iVar2 = this.c;
        G g = iVar.b;
        y yVar = g.f626a;
        try {
            if (this.f1241q.length() > 1000) {
                this.f1241q = new StringBuilder();
            }
            this.f1241q.append(" url ".concat(yVar.i));
            this.f1241q.append(" callStart() " + System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.e(iVar);
        }
        if (this.e) {
            try {
                iVar2.g.f1247a = System.currentTimeMillis();
                O2.a aVar = iVar2.i;
                aVar.b = g.b;
                String str = yVar.i;
                this.d = str;
                aVar.c = str;
            } catch (Exception unused2) {
            }
        }
    }

    @Override // F9.t
    public final void g(J9.i iVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        i iVar2 = this.c;
        k.f(inetSocketAddress, "inetSocketAddress");
        B7.a.A(new StringBuilder(" connectEnd() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.g(iVar, inetSocketAddress, proxy, protocol);
        }
        if (this.e) {
            iVar2.e.d = proxy.address() != null;
            if (inetSocketAddress.getAddress() != null) {
                String hostAddress = inetSocketAddress.getAddress().getHostAddress();
                int port = inetSocketAddress.getPort();
                iVar2.d.b = hostAddress + ":" + port;
                R5.b bVar = iVar2.d;
                bVar.c = hostAddress;
                bVar.d = port + "";
            }
        }
    }

    @Override // F9.t
    public final void h(J9.i iVar, InetSocketAddress inetSocketAddress, Proxy proxy, IOException iOException) {
        k.f(inetSocketAddress, "inetSocketAddress");
        B7.a.A(new StringBuilder(" connectFailed() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.h(iVar, inetSocketAddress, proxy, iOException);
        }
    }

    @Override // F9.t
    public final void i(J9.i iVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        k.f(inetSocketAddress, "inetSocketAddress");
        B7.a.A(new StringBuilder(" connectStart() "), this.f1241q);
        if (this.e) {
            this.h = System.currentTimeMillis();
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.i(iVar, inetSocketAddress, proxy);
        }
    }

    @Override // F9.t
    public final void j(J9.i iVar, okhttp3.internal.connection.a connection) {
        i iVar2 = this.c;
        k.f(connection, "connection");
        B7.a.A(new StringBuilder(" connectionAcquired() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.j(iVar, connection);
        }
        if (this.e) {
            if (this.g == 0) {
                iVar2.d.f1153a = true;
            } else {
                iVar2.d.f1153a = false;
            }
        }
    }

    @Override // F9.t
    public final void k(J9.i iVar, okhttp3.internal.connection.a connection) {
        k.f(connection, "connection");
        B7.a.A(new StringBuilder(" connectionReleased() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.k(iVar, connection);
        }
    }

    @Override // F9.t
    public final void l(J9.i iVar, String str, List list) {
        i iVar2 = this.c;
        B7.a.A(new StringBuilder(" dnsEnd() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.l(iVar, str, list);
        }
        if (this.e) {
            iVar2.h.f1243a = (int) (System.currentTimeMillis() - this.g);
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it.next();
                    e eVar = new e();
                    eVar.f1244a = inetAddress.getHostAddress();
                    iVar2.c.add(eVar);
                }
            }
        }
    }

    @Override // F9.t
    public final void m(J9.i iVar, String str) {
        B7.a.A(new StringBuilder(" dnsStart() "), this.f1241q);
        if (this.e) {
            this.g = System.currentTimeMillis();
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.m(iVar, str);
        }
    }

    @Override // F9.t
    public final void n(J9.i iVar, long j5) {
        i iVar2 = this.c;
        B7.a.A(new StringBuilder(" requestBodyEnd() "), this.f1241q);
        boolean z10 = this.e;
        if (z10) {
            this.k = System.currentTimeMillis();
            iVar2.h.d = (int) (System.currentTimeMillis() - this.f1240j);
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.n(iVar, j5);
        }
        if (z10) {
            iVar2.e.b += j5;
        }
    }

    @Override // F9.t
    public final void o(J9.i iVar) {
        B7.a.A(new StringBuilder(" requestBodyStart() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.o(iVar);
        }
    }

    @Override // F9.t
    public final void p(J9.i iVar, G g) {
        i iVar2 = this.c;
        B7.a.A(new StringBuilder(" requestHeadersEnd() "), this.f1241q);
        boolean z10 = this.e;
        if (z10) {
            this.f = System.currentTimeMillis();
            iVar2.h.d = (int) (System.currentTimeMillis() - this.f1240j);
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.p(iVar, g);
        }
        g.a("User-Agent");
        w wVar = g.c;
        if (z10) {
            try {
                g gVar = iVar2.e;
                long j5 = gVar.b;
                String[] strArr = wVar.f657a;
                long length = strArr.length * 2;
                for (String str : strArr) {
                    length += str.length();
                }
                gVar.b = j5 + length;
                String str2 = g.f626a.i;
                this.d = str2;
                O2.a aVar = iVar2.i;
                aVar.b = g.b;
                aVar.c = str2;
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty("Host")) {
                        jSONObject.put("Host", wVar.b("Host"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.o = jSONObject;
                if (H.h.u) {
                    iVar2.m = jSONObject.optString("x-rum-traceparent");
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // F9.t
    public final void q(J9.i iVar) {
        B7.a.A(new StringBuilder(" requestHeadersStart() "), this.f1241q);
        if (this.e) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f1240j = jCurrentTimeMillis;
            this.c.g.c = jCurrentTimeMillis;
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.q(iVar);
        }
    }

    @Override // F9.t
    public final void r(J9.i iVar, long j5) {
        B7.a.A(new StringBuilder(" responseBodyEnd() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.r(iVar, j5);
        }
        if (this.e) {
            i iVar2 = this.c;
            iVar2.e.c += j5;
            iVar2.h.g = (int) (System.currentTimeMillis() - this.m);
        }
    }

    @Override // F9.t
    public final void s(J9.i iVar) {
        B7.a.A(new StringBuilder(" responseBodyStart() "), this.f1241q);
        if (this.e) {
            this.m = System.currentTimeMillis();
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.s(iVar);
        }
    }

    @Override // F9.t
    public final void t(J9.i iVar, M m) {
        i iVar2 = this.c;
        B7.a.A(new StringBuilder(" responseHeadersEnd() "), this.f1241q);
        t tVar = this.b;
        if (tVar != null) {
            tVar.t(iVar, m);
        }
        if (this.e) {
            try {
                int i = m.d;
                w wVar = m.f;
                iVar2.h.f = (int) (System.currentTimeMillis() - this.l);
                g gVar = iVar2.e;
                gVar.f1246a = i;
                long j5 = gVar.c;
                String[] strArr = wVar.f657a;
                long length = strArr.length * 2;
                for (String str : strArr) {
                    length += str.length();
                }
                gVar.c = j5 + length;
                iVar2.e.e = AbstractC0897f.h(H.h.f711a);
                if (i >= 400) {
                    this.n = 1;
                    iVar2.f1249j.f1245a = S0.b.s(Thread.currentThread().getStackTrace());
                    iVar2.f1249j.b = i;
                } else {
                    this.n = 3;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str2 : wVar.f()) {
                        try {
                            jSONObject.put(str2, wVar.b(str2));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                this.p = jSONObject;
                if (TextUtils.isEmpty(H.h.f715s) || TextUtils.isEmpty(this.p.optString(H.h.f715s))) {
                    return;
                }
                iVar2.l = this.p.optString(H.h.f715s);
            } catch (Exception unused) {
            }
        }
    }

    @Override // F9.t
    public final void u(J9.i iVar) {
        long jCurrentTimeMillis;
        long j5;
        B7.a.A(new StringBuilder(" responseHeadersStart() "), this.f1241q);
        if (this.e) {
            this.l = System.currentTimeMillis();
            if (this.k != 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
                j5 = this.k;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                j5 = this.f;
            }
            long j6 = jCurrentTimeMillis - j5;
            i iVar2 = this.c;
            iVar2.h.e = (int) j6;
            iVar2.g.d = System.currentTimeMillis();
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.u(iVar);
        }
    }

    @Override // F9.t
    public final void v(J9.i iVar, M m) {
        this.c.k.c = true;
        B7.a.A(new StringBuilder(" satisfactionFailure() "), this.f1241q);
    }

    @Override // F9.t
    public final void w(J9.i iVar, okhttp3.c cVar) {
        B7.a.A(new StringBuilder(" secureConnectEnd() "), this.f1241q);
        if (this.e) {
            this.c.h.c = (int) (System.currentTimeMillis() - this.i);
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.w(iVar, cVar);
        }
    }

    @Override // F9.t
    public final void x(J9.i iVar) {
        B7.a.A(new StringBuilder(" secureConnectStart() "), this.f1241q);
        if (this.e) {
            this.c.h.b = (int) (System.currentTimeMillis() - this.h);
            this.i = System.currentTimeMillis();
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.x(iVar);
        }
    }

    public final void y() {
        i iVar = this.c;
        if (!this.e) {
            this.f1241q = new StringBuilder();
            return;
        }
        iVar.g.b = System.currentTimeMillis() - iVar.g.f1247a;
        iVar.n.f443a = "okhttp";
        try {
            JSONObject jSONObject = new JSONObject(iVar.toString());
            jSONObject.put("net_consume_type", "okhttp");
            jSONObject.put("timing_totalSendBytes", iVar.e.b);
            jSONObject.put("timing_totalReceivedBytes", iVar.e.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("request_log", jSONObject.toString());
            if (iVar.k.d == 1 && this.n == 0) {
                this.n = 3;
            }
            jSONObject2.put("data_type", this.n);
            jSONObject2.put("eventListener", this.f1241q.toString());
            this.f1241q = new StringBuilder();
            JSONObject jSONObject3 = this.o;
            jSONObject2.put("requestHeader", jSONObject3 != null ? jSONObject3.toString() : "");
            h hVar = iVar.g;
            S0.b.x(hVar.b, hVar.f1247a, this.d, (String) iVar.d.b, iVar.e.f1246a, jSONObject2);
            if (H.h.b) {
                Log.d("net_info:", U7.a.e(new String[]{"request_log:" + jSONObject.toString() + "\n" + jSONObject2.toString()}));
            }
        } catch (Exception unused) {
        }
    }
}
