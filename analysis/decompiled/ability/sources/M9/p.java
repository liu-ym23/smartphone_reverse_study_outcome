package M9;

import D7.N;
import F9.F;
import F9.G;
import F9.L;
import F9.M;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class p implements K9.e {
    public static final List g = G9.b.j("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List h = G9.b.j("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.internal.connection.a f993a;
    public final K9.g b;
    public final o c;
    public volatile w d;
    public final Protocol e;
    public volatile boolean f;

    public p(F f, okhttp3.internal.connection.a aVar, K9.g gVar, o http2Connection) {
        kotlin.jvm.internal.k.f(http2Connection, "http2Connection");
        this.f993a = aVar;
        this.b = gVar;
        this.c = http2Connection;
        List list = f.f620s;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.e = list.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // K9.e
    public final void a() {
        w wVar = this.d;
        kotlin.jvm.internal.k.c(wVar);
        wVar.f().close();
    }

    @Override // K9.e
    public final okhttp3.internal.connection.a b() {
        return this.f993a;
    }

    @Override // K9.e
    public final V9.w c(M m) {
        w wVar = this.d;
        kotlin.jvm.internal.k.c(wVar);
        return wVar.i;
    }

    @Override // K9.e
    public final void cancel() {
        this.f = true;
        w wVar = this.d;
        if (wVar != null) {
            wVar.e(ErrorCode.CANCEL);
        }
    }

    @Override // K9.e
    public final void d(G g10) throws IOException {
        int i;
        w wVar;
        boolean z10;
        if (this.d != null) {
            return;
        }
        boolean z11 = g10.d != null;
        F9.w wVar2 = g10.c;
        ArrayList arrayList = new ArrayList(wVar2.size() + 4);
        arrayList.add(new C0247a(C0247a.f, g10.b));
        ByteString byteString = C0247a.g;
        F9.y url = g10.f626a;
        kotlin.jvm.internal.k.f(url, "url");
        String strB = url.b();
        String strD = url.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new C0247a(byteString, strB));
        String strA = g10.a("Host");
        if (strA != null) {
            arrayList.add(new C0247a(C0247a.i, strA));
        }
        arrayList.add(new C0247a(C0247a.h, url.f659a));
        int size = wVar2.size();
        for (int i6 = 0; i6 < size; i6++) {
            String strE = wVar2.e(i6);
            Locale US = Locale.US;
            kotlin.jvm.internal.k.e(US, "US");
            String lowerCase = strE.toLowerCase(US);
            kotlin.jvm.internal.k.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && kotlin.jvm.internal.k.b(wVar2.h(i6), "trailers"))) {
                arrayList.add(new C0247a(lowerCase, wVar2.h(i6)));
            }
        }
        o oVar = this.c;
        oVar.getClass();
        boolean z12 = !z11;
        synchronized (oVar.f991w) {
            synchronized (oVar) {
                try {
                    if (oVar.e > 1073741823) {
                        oVar.i(ErrorCode.REFUSED_STREAM);
                    }
                    if (oVar.f) {
                        throw new ConnectionShutdownException();
                    }
                    i = oVar.e;
                    oVar.e = i + 2;
                    wVar = new w(i, oVar, z12, false, null);
                    z10 = !z11 || oVar.f989t >= oVar.u || wVar.e >= wVar.f;
                    if (wVar.h()) {
                        oVar.b.put(Integer.valueOf(i), wVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            oVar.f991w.i(arrayList, i, z12);
        }
        if (z10) {
            oVar.f991w.flush();
        }
        this.d = wVar;
        if (this.f) {
            w wVar3 = this.d;
            kotlin.jvm.internal.k.c(wVar3);
            wVar3.e(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        w wVar4 = this.d;
        kotlin.jvm.internal.k.c(wVar4);
        v vVar = wVar4.k;
        long j5 = this.b.g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        vVar.g(j5);
        w wVar5 = this.d;
        kotlin.jvm.internal.k.c(wVar5);
        wVar5.l.g(this.b.h);
    }

    @Override // K9.e
    public final L e(boolean z10) throws NumberFormatException, IOException {
        F9.w wVar;
        w wVar2 = this.d;
        if (wVar2 == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (wVar2) {
            wVar2.k.h();
            while (wVar2.g.isEmpty() && wVar2.m == null) {
                try {
                    try {
                        wVar2.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    wVar2.k.k();
                    throw th;
                }
            }
            wVar2.k.k();
            if (wVar2.g.isEmpty()) {
                IOException iOException = wVar2.n;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode = wVar2.m;
                kotlin.jvm.internal.k.c(errorCode);
                throw new StreamResetException(errorCode);
            }
            Object objRemoveFirst = wVar2.g.removeFirst();
            kotlin.jvm.internal.k.e(objRemoveFirst, "headersQueue.removeFirst()");
            wVar = (F9.w) objRemoveFirst;
        }
        Protocol protocol = this.e;
        kotlin.jvm.internal.k.f(protocol, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = wVar.size();
        D9.l lVarJ = null;
        for (int i = 0; i < size; i++) {
            String name = wVar.e(i);
            String value = wVar.h(i);
            if (kotlin.jvm.internal.k.b(name, ":status")) {
                lVarJ = N.J("HTTP/1.1 " + value);
            } else if (!h.contains(name)) {
                kotlin.jvm.internal.k.f(name, "name");
                kotlin.jvm.internal.k.f(value, "value");
                arrayList.add(name);
                arrayList.add(j9.m.R0(value).toString());
            }
        }
        if (lVarJ == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        L l = new L();
        l.b = protocol;
        l.c = lVarJ.b;
        l.d = (String) lVarJ.d;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        F9.v vVar = new F9.v(0);
        D7.A.g0(vVar.f656a, strArr);
        l.f = vVar;
        if (z10 && l.c == 100) {
            return null;
        }
        return l;
    }

    @Override // K9.e
    public final long f(M m) {
        if (K9.f.a(m)) {
            return G9.b.i(m);
        }
        return 0L;
    }

    @Override // K9.e
    public final V9.u g(G g10, long j5) {
        w wVar = this.d;
        kotlin.jvm.internal.k.c(wVar);
        return wVar.f();
    }

    @Override // K9.e
    public final void h() {
        this.c.flush();
    }
}
