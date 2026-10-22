package t6;

import c7.h;
import c7.o;
import c7.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.Arrays;
import k4.v;
import k4.z;
import kotlin.jvm.internal.p;
import n6.k;
import n6.m;
import n6.q;
import n6.r;
import n6.s;
import n6.t;
import s6.g;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements s6.f {

    /* renamed from: f, reason: collision with root package name */
    public static final k f5595f;

    /* renamed from: a, reason: collision with root package name */
    public final q f5596a;

    /* renamed from: b, reason: collision with root package name */
    public final s6.e f5597b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.d f5598c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final a f5599e;

    static {
        k kVar = k.f4053b;
        String[] inputNamesAndValues = (String[]) Arrays.copyOf(new String[]{"OkHttp-Response-Body", "Truncated"}, 2);
        p.e(inputNamesAndValues, "inputNamesAndValues");
        if (inputNamesAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = strArr.length;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            if (strArr[i9] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr[i9] = n.T1(inputNamesAndValues[i9]).toString();
        }
        int iJ = a.a.J(0, strArr.length - 1, 2);
        if (iJ >= 0) {
            while (true) {
                String str = strArr[i8];
                String str2 = strArr[i8 + 1];
                v.T(str);
                v.U(str2, str);
                if (i8 == iJ) {
                    break;
                } else {
                    i8 += 2;
                }
            }
        }
        f5595f = new k(strArr);
    }

    public f(q qVar, s6.e eVar, a4.d socket) {
        p.e(socket, "socket");
        this.f5596a = qVar;
        this.f5597b = eVar;
        this.f5598c = socket;
        this.f5599e = new a((c7.p) socket.f97c);
    }

    @Override // s6.f
    public final void a() {
        ((o) this.f5598c.d).flush();
    }

    @Override // s6.f
    public final void b(s sVar) {
        Proxy.Type type = this.f5597b.e().f4164b.type();
        p.d(type, "type(...)");
        StringBuilder sb = new StringBuilder();
        sb.append(sVar.f4129b);
        sb.append(' ');
        m mVar = sVar.f4128a;
        if (p.a(mVar.f4063a, "https") || type != Proxy.Type.HTTP) {
            String strB = mVar.b();
            String strD = mVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(mVar);
        }
        sb.append(" HTTP/1.1");
        j(sVar.f4130c, sb.toString());
    }

    @Override // s6.f
    public final boolean c() {
        return this.d == 6;
    }

    @Override // s6.f
    public final void cancel() {
        this.f5597b.cancel();
    }

    @Override // s6.f
    public final u d() {
        return this.f5598c;
    }

    @Override // s6.f
    public final s6.e e() {
        return this.f5597b;
    }

    @Override // s6.f
    public final long f(n6.u uVar) {
        if (!g.a(uVar)) {
            return 0L;
        }
        String strF = uVar.f4150f.f("Transfer-Encoding");
        if (strF == null) {
            strF = null;
        }
        if ("chunked".equalsIgnoreCase(strF)) {
            return -1L;
        }
        return o6.f.e(uVar);
    }

    @Override // s6.f
    public final t g() throws IOException {
        a aVar = this.f5599e;
        int i8 = this.d;
        if (i8 != 0 && i8 != 1 && i8 != 2 && i8 != 3) {
            throw new IllegalStateException(("state: " + this.d).toString());
        }
        try {
            String strW = ((h) aVar.f5585c).w(aVar.f5584b);
            aVar.f5584b -= strW.length();
            d8.m mVarB = z.B(strW);
            int i9 = mVarB.f2076b;
            t tVar = new t();
            tVar.f4133b = (r) mVarB.f2077c;
            tVar.f4134c = i9;
            tVar.d = (String) mVarB.d;
            tVar.f4136f = aVar.f().h();
            if (i9 == 100) {
                this.d = 3;
                return tVar;
            }
            if (102 > i9 || i9 >= 200) {
                this.d = 4;
                return tVar;
            }
            this.d = 3;
            return tVar;
        } catch (EOFException e9) {
            throw new IOException(m0.f.c("unexpected end of stream on ", this.f5597b.e().f4163a.f3992h.f()), e9);
        }
    }

    @Override // s6.f
    public final c7.v h(n6.u uVar) {
        s sVar = uVar.f4146a;
        if (!g.a(uVar)) {
            return i(sVar.f4128a, 0L);
        }
        String strF = uVar.f4150f.f("Transfer-Encoding");
        if (strF == null) {
            strF = null;
        }
        if ("chunked".equalsIgnoreCase(strF)) {
            m mVar = sVar.f4128a;
            if (this.d == 4) {
                this.d = 5;
                return new c(this, mVar);
            }
            throw new IllegalStateException(("state: " + this.d).toString());
        }
        long jE = o6.f.e(uVar);
        if (jE != -1) {
            return i(sVar.f4128a, jE);
        }
        m url = sVar.f4128a;
        if (this.d != 4) {
            throw new IllegalStateException(("state: " + this.d).toString());
        }
        this.d = 5;
        this.f5597b.g();
        p.e(url, "url");
        return new e(this, url);
    }

    public final d i(m mVar, long j4) {
        if (this.d == 4) {
            this.d = 5;
            return new d(this, mVar, j4);
        }
        throw new IllegalStateException(("state: " + this.d).toString());
    }

    public final void j(k headers, String requestLine) {
        p.e(headers, "headers");
        p.e(requestLine, "requestLine");
        if (this.d != 0) {
            throw new IllegalStateException(("state: " + this.d).toString());
        }
        a4.d dVar = this.f5598c;
        o oVar = (o) dVar.d;
        o oVar2 = (o) dVar.d;
        oVar.B(requestLine);
        oVar.B("\r\n");
        int size = headers.size();
        for (int i8 = 0; i8 < size; i8++) {
            oVar2.B(headers.g(i8));
            oVar2.B(": ");
            oVar2.B(headers.i(i8));
            oVar2.B("\r\n");
        }
        oVar2.B("\r\n");
        this.d = 1;
    }
}
