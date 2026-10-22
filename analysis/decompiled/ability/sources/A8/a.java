package A8;

import D7.N;
import D9.l;
import F9.F;
import F9.G;
import F9.K;
import F9.L;
import F9.M;
import F9.y;
import L9.g;
import V9.h;
import V9.i;
import V9.q;
import V9.r;
import V9.u;
import V9.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import okhttp3.Protocol;
import org.json.HTTP;

/* loaded from: classes4.dex */
public final class a implements K9.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f159a = 1;
    public int b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public Object h;

    public a(KotlinClassHeader$Kind kind, F8.f fVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i) {
        k.f(kind, "kind");
        this.c = kind;
        this.d = fVar;
        this.e = strArr;
        this.f = strArr2;
        this.g = strArr3;
        this.h = str;
        this.b = i;
    }

    @Override // K9.e
    public void a() {
        ((h) this.f).flush();
    }

    @Override // K9.e
    public okhttp3.internal.connection.a b() {
        return (okhttp3.internal.connection.a) this.d;
    }

    @Override // K9.e
    public w c(M m) {
        if (!K9.f.a(m)) {
            return i(0L);
        }
        if ("chunked".equalsIgnoreCase(M.b(m, "Transfer-Encoding"))) {
            y yVar = m.f631a.f626a;
            if (this.b == 4) {
                this.b = 5;
                return new L9.d(this, yVar);
            }
            throw new IllegalStateException(("state: " + this.b).toString());
        }
        long jI = G9.b.i(m);
        if (jI != -1) {
            return i(jI);
        }
        if (this.b == 4) {
            this.b = 5;
            ((okhttp3.internal.connection.a) this.d).k();
            return new g(this);
        }
        throw new IllegalStateException(("state: " + this.b).toString());
    }

    @Override // K9.e
    public void cancel() throws IOException {
        Socket socket = ((okhttp3.internal.connection.a) this.d).c;
        if (socket != null) {
            G9.b.d(socket);
        }
    }

    @Override // K9.e
    public void d(G g) {
        Proxy.Type type = ((okhttp3.internal.connection.a) this.d).b.b.type();
        k.e(type, "connection.route().proxy.type()");
        StringBuilder sb = new StringBuilder();
        sb.append(g.b);
        sb.append(' ');
        y yVar = g.f626a;
        if (yVar.f660j || type != Proxy.Type.HTTP) {
            String strB = yVar.b();
            String strD = yVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(yVar);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        k.e(string, "StringBuilder().apply(builderAction).toString()");
        j(g.c, string);
    }

    @Override // K9.e
    public L e(boolean z10) {
        L9.a aVar = (L9.a) this.g;
        int i = this.b;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.b).toString());
        }
        try {
            String strJ = ((i) aVar.b).j(aVar.f944a);
            aVar.f944a -= strJ.length();
            l lVarJ = N.J(strJ);
            int i6 = lVarJ.b;
            L l = new L();
            l.b = (Protocol) lVarJ.c;
            l.c = i6;
            l.d = (String) lVarJ.d;
            l.f = aVar.f().g();
            if (z10 && i6 == 100) {
                return null;
            }
            if (i6 == 100) {
                this.b = 3;
                return l;
            }
            if (102 > i6 || i6 >= 200) {
                this.b = 4;
                return l;
            }
            this.b = 3;
            return l;
        } catch (EOFException e) {
            throw new IOException("unexpected end of stream on ".concat(((okhttp3.internal.connection.a) this.d).b.f635a.i.h()), e);
        }
    }

    @Override // K9.e
    public long f(M m) {
        if (!K9.f.a(m)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(M.b(m, "Transfer-Encoding"))) {
            return -1L;
        }
        return G9.b.i(m);
    }

    @Override // K9.e
    public u g(G g, long j5) throws ProtocolException {
        K k = g.d;
        if (k != null && k.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(g.a("Transfer-Encoding"))) {
            if (this.b == 1) {
                this.b = 2;
                return new L9.c(this);
            }
            throw new IllegalStateException(("state: " + this.b).toString());
        }
        if (j5 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.b == 1) {
            this.b = 2;
            return new L9.f(this);
        }
        throw new IllegalStateException(("state: " + this.b).toString());
    }

    @Override // K9.e
    public void h() {
        ((h) this.f).flush();
    }

    public L9.e i(long j5) {
        if (this.b == 4) {
            this.b = 5;
            return new L9.e(this, j5);
        }
        throw new IllegalStateException(("state: " + this.b).toString());
    }

    public void j(F9.w wVar, String requestLine) {
        h hVar = (h) this.f;
        k.f(requestLine, "requestLine");
        if (this.b != 0) {
            throw new IllegalStateException(("state: " + this.b).toString());
        }
        hVar.m(requestLine).m(HTTP.CRLF);
        int size = wVar.size();
        for (int i = 0; i < size; i++) {
            hVar.m(wVar.e(i)).m(": ").m(wVar.h(i)).m(HTTP.CRLF);
        }
        hVar.m(HTTP.CRLF);
        this.b = 1;
    }

    public String toString() {
        switch (this.f159a) {
            case 0:
                return ((KotlinClassHeader$Kind) this.c) + " version=" + ((F8.f) this.d);
            default:
                return super.toString();
        }
    }

    public a(F f, okhttp3.internal.connection.a aVar, r source, q sink) {
        k.f(source, "source");
        k.f(sink, "sink");
        this.c = f;
        this.d = aVar;
        this.e = source;
        this.f = sink;
        k.f(source, "source");
        L9.a aVar2 = new L9.a();
        aVar2.b = source;
        aVar2.f944a = 262144L;
        this.g = aVar2;
    }
}
