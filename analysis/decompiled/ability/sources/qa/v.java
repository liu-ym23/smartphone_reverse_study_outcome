package qa;

import F9.InterfaceC0228f;
import fa.C1449a;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class v implements InterfaceC1852d {

    /* renamed from: a, reason: collision with root package name */
    public final K f5660a;
    public final Object b;
    public final Object[] c;
    public final InterfaceC0228f d;
    public final InterfaceC1859k e;
    public volatile boolean f;
    public J9.i g;
    public Throwable h;
    public boolean i;

    public v(K k, Object obj, Object[] objArr, InterfaceC0228f interfaceC0228f, InterfaceC1859k interfaceC1859k) {
        this.f5660a = k;
        this.b = obj;
        this.c = objArr;
        this.d = interfaceC0228f;
        this.e = interfaceC1859k;
    }

    public final J9.i a() {
        F9.y yVarD;
        K k = this.f5660a;
        U[] uArr = k.k;
        Object[] objArr = this.c;
        int length = objArr.length;
        if (length != uArr.length) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.o(B7.a.u(length, "Argument count (", ") doesn't match expected count ("), ")", uArr.length));
        }
        I i = new I(k.d, k.c, k.e, k.f, k.g, k.h, k.i, k.f5643j);
        if (k.l) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i6 = 0; i6 < length; i6++) {
            arrayList.add(objArr[i6]);
            uArr[i6].a(i, objArr[i6]);
        }
        F9.x xVar = i.d;
        if (xVar != null) {
            yVarD = xVar.d();
        } else {
            String link = i.c;
            F9.y yVar = i.b;
            yVar.getClass();
            kotlin.jvm.internal.k.f(link, "link");
            F9.x xVarG = yVar.g(link);
            yVarD = xVarG != null ? xVarG.d() : null;
            if (yVarD == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + yVar + ", Relative: " + i.c);
            }
        }
        F9.K h = i.k;
        if (h == null) {
            C1449a c1449a = i.f5631j;
            if (c1449a != null) {
                h = new F9.u((ArrayList) c1449a.b, (ArrayList) c1449a.c);
            } else {
                A5.c cVar = i.i;
                if (cVar != null) {
                    ArrayList arrayList2 = (ArrayList) cVar.d;
                    if (arrayList2.isEmpty()) {
                        throw new IllegalStateException("Multipart body must have at least one part.");
                    }
                    h = new F9.D((ByteString) cVar.b, (F9.B) cVar.c, G9.b.w(arrayList2));
                } else if (i.h) {
                    h = F9.K.create((F9.B) null, new byte[0]);
                }
            }
        }
        F9.B b = i.g;
        F9.v vVar = i.f;
        if (b != null) {
            if (h != null) {
                h = new F9.H(h, b);
            } else {
                vVar.c(HttpHeaders.CONTENT_TYPE, b.f597a);
            }
        }
        K1.a aVar = i.e;
        aVar.getClass();
        aVar.f903a = yVarD;
        aVar.c = vVar.g().g();
        aVar.h(i.f5630a, h);
        aVar.r(C1865q.class, new C1865q(k.f5642a, this.b, k.b, arrayList));
        F9.G gD = aVar.d();
        F9.F f = (F9.F) this.d;
        f.getClass();
        return new J9.i(f, gD);
    }

    public final J9.i b() throws IOException {
        J9.i iVar = this.g;
        if (iVar != null) {
            return iVar;
        }
        Throwable th = this.h;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            J9.i iVarA = a();
            this.g = iVarA;
            return iVarA;
        } catch (IOException | Error | RuntimeException e) {
            U.o(e);
            this.h = e;
            throw e;
        }
    }

    public final L c(F9.M m) throws IOException {
        F9.P p = m.g;
        F9.L lF = m.f();
        lF.g = new C1868u(p.c(), p.b());
        F9.M mA = lF.a();
        int i = mA.d;
        if (i < 200 || i >= 300) {
            try {
                V9.g gVar = new V9.g();
                p.f().o(gVar);
                F9.O o = new F9.O(p.c(), p.b(), gVar, 0);
                if (mA.c()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new L(mA, null, o);
            } finally {
                p.close();
            }
        }
        if (i == 204 || i == 205) {
            p.close();
            if (mA.c()) {
                return new L(mA, null, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        C1867t c1867t = new C1867t(p);
        try {
            Object objConvert = this.e.convert(c1867t);
            if (mA.c()) {
                return new L(mA, objConvert, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e) {
            IOException iOException = c1867t.d;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }

    @Override // qa.InterfaceC1852d
    public final void cancel() {
        J9.i iVar;
        this.f = true;
        synchronized (this) {
            iVar = this.g;
        }
        if (iVar != null) {
            iVar.cancel();
        }
    }

    public final Object clone() {
        return new v(this.f5660a, this.b, this.c, this.d, this.e);
    }

    @Override // qa.InterfaceC1852d
    public final void g(InterfaceC1855g interfaceC1855g) {
        J9.i iVar;
        Throwable th;
        synchronized (this) {
            try {
                if (this.i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.i = true;
                iVar = this.g;
                th = this.h;
                if (iVar == null && th == null) {
                    try {
                        J9.i iVarA = a();
                        this.g = iVarA;
                        iVar = iVarA;
                    } catch (Throwable th2) {
                        th = th2;
                        U.o(th);
                        this.h = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            interfaceC1855g.r(this, th);
            return;
        }
        if (this.f) {
            iVar.cancel();
        }
        iVar.c(new M0.k(9, this, interfaceC1855g));
    }

    @Override // qa.InterfaceC1852d
    public final synchronized F9.G i() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return b().b;
    }

    @Override // qa.InterfaceC1852d
    public final boolean l() {
        boolean z10 = true;
        if (this.f) {
            return true;
        }
        synchronized (this) {
            try {
                J9.i iVar = this.g;
                if (iVar == null || !iVar.o) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // qa.InterfaceC1852d
    /* renamed from: clone */
    public final InterfaceC1852d mo7357clone() {
        return new v(this.f5660a, this.b, this.c, this.d, this.e);
    }
}
