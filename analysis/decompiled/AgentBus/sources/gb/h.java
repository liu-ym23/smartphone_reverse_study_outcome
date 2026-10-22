package gb;

import ab.n;
import ab.p;
import ab.t;
import ab.u;
import ab.w;
import ab.x;
import ab.y;
import ab.z;
import eb.m;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import ob.c0;
import ob.e0;
import ob.i;
import ob.i0;
import ob.j;
import ob.k0;
import q7.k;

/* loaded from: classes.dex */
public final class h implements fb.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4051a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f4052b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4053c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4054d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4055e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4056f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4057g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4058h;

    public h(y8.a aVar, d9.f fVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i2) {
        k.e(aVar, "kind");
        this.f4053c = aVar;
        this.f4054d = fVar;
        this.f4055e = strArr;
        this.f4056f = strArr2;
        this.f4057g = strArr3;
        this.f4058h = str;
        this.f4052b = i2;
    }

    @Override // fb.e
    public void a() {
        ((i) this.f4056f).flush();
    }

    @Override // fb.e
    public void b() {
        ((i) this.f4056f).flush();
    }

    @Override // fb.e
    public i0 c(w wVar, long j2) {
        k.e(wVar, "request");
        if ("chunked".equalsIgnoreCase(wVar.f663c.a("Transfer-Encoding"))) {
            if (this.f4052b == 1) {
                this.f4052b = 2;
                return new c(this);
            }
            throw new IllegalStateException(("state: " + this.f4052b).toString());
        }
        if (j2 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f4052b == 1) {
            this.f4052b = 2;
            return new f(this);
        }
        throw new IllegalStateException(("state: " + this.f4052b).toString());
    }

    @Override // fb.e
    public void cancel() throws IOException {
        Socket socket = ((m) this.f4054d).f3297c;
        if (socket != null) {
            bb.b.e(socket);
        }
    }

    @Override // fb.e
    public k0 d(z zVar) {
        if (!fb.f.a(zVar)) {
            return i(0L);
        }
        if ("chunked".equalsIgnoreCase(z.a(zVar, "Transfer-Encoding"))) {
            p pVar = zVar.f684f.f661a;
            if (this.f4052b == 4) {
                this.f4052b = 5;
                return new d(this, pVar);
            }
            throw new IllegalStateException(("state: " + this.f4052b).toString());
        }
        long jK = bb.b.k(zVar);
        if (jK != -1) {
            return i(jK);
        }
        if (this.f4052b == 4) {
            this.f4052b = 5;
            ((m) this.f4054d).k();
            return new g(this);
        }
        throw new IllegalStateException(("state: " + this.f4052b).toString());
    }

    @Override // fb.e
    public y e(boolean z4) {
        a aVar = (a) this.f4057g;
        int i2 = this.f4052b;
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalStateException(("state: " + this.f4052b).toString());
        }
        try {
            String strF = ((j) aVar.f4033b).F(aVar.f4032a);
            aVar.f4032a -= strF.length();
            x xVarA0 = a.a.a0(strF);
            int i10 = xVarA0.f668b;
            y yVar = new y();
            yVar.f672b = (u) xVarA0.f669c;
            yVar.f673c = i10;
            yVar.f674d = (String) xVarA0.f670d;
            yVar.f676f = aVar.a().h();
            if (z4 && i10 == 100) {
                return null;
            }
            if (i10 == 100) {
                this.f4052b = 3;
                return yVar;
            }
            if (102 > i10 || i10 >= 200) {
                this.f4052b = 4;
                return yVar;
            }
            this.f4052b = 3;
            return yVar;
        } catch (EOFException e10) {
            throw new IOException("unexpected end of stream on ".concat(((m) this.f4054d).f3296b.f515a.f493h.f()), e10);
        }
    }

    @Override // fb.e
    public void f(w wVar) {
        k.e(wVar, "request");
        Proxy.Type type = ((m) this.f4054d).f3296b.f516b.type();
        k.d(type, "connection.route().proxy.type()");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(wVar.f662b);
        sb2.append(' ');
        p pVar = wVar.f661a;
        if (pVar.f596i || type != Proxy.Type.HTTP) {
            String strB = pVar.b();
            String strD = pVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb2.append(strB);
        } else {
            sb2.append(pVar);
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        j(wVar.f663c, string);
    }

    @Override // fb.e
    public m g() {
        return (m) this.f4054d;
    }

    @Override // fb.e
    public long h(z zVar) {
        if (!fb.f.a(zVar)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(z.a(zVar, "Transfer-Encoding"))) {
            return -1L;
        }
        return bb.b.k(zVar);
    }

    public e i(long j2) {
        if (this.f4052b == 4) {
            this.f4052b = 5;
            return new e(this, j2);
        }
        throw new IllegalStateException(("state: " + this.f4052b).toString());
    }

    public void j(n nVar, String str) {
        i iVar = (i) this.f4056f;
        k.e(str, "requestLine");
        if (this.f4052b != 0) {
            throw new IllegalStateException(("state: " + this.f4052b).toString());
        }
        iVar.M(str).M("\r\n");
        int size = nVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            iVar.M(nVar.f(i2)).M(": ").M(nVar.i(i2)).M("\r\n");
        }
        iVar.M("\r\n");
        this.f4052b = 1;
    }

    public String toString() {
        switch (this.f4051a) {
            case 2:
                return ((y8.a) this.f4053c) + " version=" + ((d9.f) this.f4054d);
            default:
                return super.toString();
        }
    }

    public h(t tVar, m mVar, e0 e0Var, c0 c0Var) {
        k.e(e0Var, "source");
        k.e(c0Var, "sink");
        this.f4053c = tVar;
        this.f4054d = mVar;
        this.f4055e = e0Var;
        this.f4056f = c0Var;
        this.f4057g = new a(e0Var);
    }

    public h(db.e eVar) {
        k.e(eVar, "taskRunner");
        this.f4053c = eVar;
        this.f4058h = hb.h.f4289a;
    }
}
