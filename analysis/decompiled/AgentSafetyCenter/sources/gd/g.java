package gd;

import ad.d0;
import ad.e0;
import ad.n;
import ad.o;
import ad.q;
import ad.w;
import ad.x;
import ad.z;
import b8.r;
import ed.m;
import java.io.EOFException;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.net.Proxy;
import java.net.Socket;
import od.b0;
import od.c0;
import od.g0;
import od.i0;
import od.j;
import od.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements fd.d {

    /* renamed from: a, reason: collision with root package name */
    public final w f4726a;

    /* renamed from: b, reason: collision with root package name */
    public final m f4727b;

    /* renamed from: c, reason: collision with root package name */
    public final k f4728c;

    /* renamed from: d, reason: collision with root package name */
    public final j f4729d;

    /* renamed from: e, reason: collision with root package name */
    public int f4730e;

    /* renamed from: f, reason: collision with root package name */
    public final r f4731f;

    /* renamed from: g, reason: collision with root package name */
    public n f4732g;

    public g(w wVar, m mVar, c0 c0Var, b0 b0Var) {
        c0Var.getClass();
        b0Var.getClass();
        this.f4726a = wVar;
        this.f4727b = mVar;
        this.f4728c = c0Var;
        this.f4729d = b0Var;
        r rVar = new r();
        rVar.f2015f = c0Var;
        rVar.f2014c = 262144L;
        VarHandle.storeStoreFence();
        this.f4731f = rVar;
    }

    @Override // fd.d
    public final void a() {
        this.f4729d.flush();
    }

    @Override // fd.d
    public final d0 b(boolean z10) {
        r rVar = this.f4731f;
        int i = this.f4730e;
        if (i != 1 && i != 2 && i != 3) {
            o.b(this.f4730e, "state: ");
            return null;
        }
        try {
            String strQ = ((k) rVar.f2015f).q(rVar.f2014c);
            rVar.f2014c -= strQ.length();
            b2.a aVarA = id.c.A(strQ);
            int i3 = aVarA.f1860b;
            d0 d0Var = new d0();
            d0Var.f454b = (x) aVarA.f1861c;
            d0Var.f455c = i3;
            d0Var.f456d = (String) aVarA.f1862d;
            d0Var.f458f = rVar.a().c();
            if (z10 && i3 == 100) {
                return null;
            }
            if (i3 == 100) {
                this.f4730e = 3;
                return d0Var;
            }
            if (102 > i3 || i3 >= 200) {
                this.f4730e = 4;
                return d0Var;
            }
            this.f4730e = 3;
            return d0Var;
        } catch (EOFException e10) {
            throw new IOException("unexpected end of stream on ".concat(this.f4727b.f3820a.f518a.f428h.f()), e10);
        }
    }

    @Override // fd.d
    public final void c(z zVar) {
        zVar.getClass();
        Proxy.Type type = this.f4727b.f3820a.f519b.type();
        type.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) zVar.f638c);
        sb2.append(' ');
        q qVar = (q) zVar.f637b;
        if (qVar.f567j || type != Proxy.Type.HTTP) {
            String strB = qVar.b();
            String strD = qVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb2.append(strB);
        } else {
            sb2.append(qVar);
        }
        sb2.append(" HTTP/1.1");
        j((n) zVar.f639d, sb2.toString());
    }

    @Override // fd.d
    public final void cancel() throws IOException {
        Socket socket = this.f4727b.f3821b;
        if (socket != null) {
            bd.b.e(socket);
        }
    }

    @Override // fd.d
    public final m d() {
        return this.f4727b;
    }

    @Override // fd.d
    public final i0 e(e0 e0Var) {
        if (!fd.e.a(e0Var)) {
            return i(0L);
        }
        if ("chunked".equalsIgnoreCase(e0.d(e0Var, "Transfer-Encoding"))) {
            q qVar = (q) e0Var.f468c.f637b;
            if (this.f4730e == 4) {
                this.f4730e = 5;
                return new c(this, qVar);
            }
            o.b(this.f4730e, "state: ");
            return null;
        }
        long j10 = bd.b.j(e0Var);
        if (j10 != -1) {
            return i(j10);
        }
        if (this.f4730e != 4) {
            o.b(this.f4730e, "state: ");
            return null;
        }
        this.f4730e = 5;
        this.f4727b.j();
        return new f(this);
    }

    @Override // fd.d
    public final g0 f(z zVar, long j10) {
        zVar.getClass();
        boolean zEqualsIgnoreCase = "chunked".equalsIgnoreCase(((n) zVar.f639d).a("Transfer-Encoding"));
        j jVar = this.f4729d;
        if (zEqualsIgnoreCase) {
            if (this.f4730e != 1) {
                o.b(this.f4730e, "state: ");
                return null;
            }
            this.f4730e = 2;
            b bVar = new b();
            bVar.f4717g = this;
            bVar.f4715c = new od.r(jVar.b());
            VarHandle.storeStoreFence();
            return bVar;
        }
        if (j10 == -1) {
            od.f.e("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.f4730e != 1) {
            o.b(this.f4730e, "state: ");
            return null;
        }
        this.f4730e = 2;
        e eVar = new e();
        eVar.f4724g = this;
        eVar.f4722c = new od.r(jVar.b());
        VarHandle.storeStoreFence();
        return eVar;
    }

    @Override // fd.d
    public final void g() {
        this.f4729d.flush();
    }

    @Override // fd.d
    public final long h(e0 e0Var) {
        if (!fd.e.a(e0Var)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(e0.d(e0Var, "Transfer-Encoding"))) {
            return -1L;
        }
        return bd.b.j(e0Var);
    }

    public final d i(long j10) {
        if (this.f4730e == 4) {
            this.f4730e = 5;
            return new d(this, j10);
        }
        o.b(this.f4730e, "state: ");
        return null;
    }

    public final void j(n nVar, String str) {
        if (this.f4730e != 0) {
            o.b(this.f4730e, "state: ");
            return;
        }
        j jVar = this.f4729d;
        jVar.v(str).v("\r\n");
        int size = nVar.size();
        for (int i = 0; i < size; i++) {
            jVar.v(nVar.b(i)).v(": ").v(nVar.d(i)).v("\r\n");
        }
        jVar.v("\r\n");
        this.f4730e = 1;
    }
}
