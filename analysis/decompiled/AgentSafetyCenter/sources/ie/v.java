package ie;

import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class v implements c {

    /* renamed from: c, reason: collision with root package name */
    public final n0 f6086c;

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f6087f;

    /* renamed from: g, reason: collision with root package name */
    public final ad.w f6088g;

    /* renamed from: h, reason: collision with root package name */
    public final l f6089h;
    public volatile boolean i;

    /* renamed from: j, reason: collision with root package name */
    public ed.j f6090j;

    /* renamed from: k, reason: collision with root package name */
    public Throwable f6091k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6092l;

    public v(n0 n0Var, Object[] objArr, ad.w wVar, l lVar) {
        this.f6086c = n0Var;
        this.f6087f = objArr;
        this.f6088g = wVar;
        this.f6089h = lVar;
    }

    public final ed.j a() {
        ad.p pVar;
        ad.q qVarA;
        n0 n0Var = this.f6086c;
        w0[] w0VarArr = n0Var.f6049j;
        Object[] objArr = this.f6087f;
        int length = objArr.length;
        if (length != w0VarArr.length) {
            g5.f.s(k0.a.r(k0.a.t(length, "Argument count (", ") doesn't match expected count ("), w0VarArr.length, ")"));
            return null;
        }
        String str = n0Var.f6043c;
        ad.q qVar = n0Var.f6042b;
        String str2 = n0Var.f6044d;
        ad.n nVar = n0Var.f6045e;
        ad.s sVar = n0Var.f6046f;
        boolean z10 = n0Var.f6047g;
        boolean z11 = n0Var.f6048h;
        boolean z12 = n0Var.i;
        l0 l0Var = new l0();
        l0Var.f6007a = str;
        l0Var.f6008b = qVar;
        l0Var.f6009c = str2;
        l0Var.f6011e = new ad.y();
        l0Var.f6013g = sVar;
        l0Var.f6014h = z10;
        if (nVar != null) {
            l0Var.f6012f = nVar.c();
        } else {
            l0Var.f6012f = new ne.b();
        }
        if (z11) {
            n6.a aVar = new n6.a();
            aVar.f8776c = new ArrayList();
            aVar.f8777f = new ArrayList();
            VarHandle.storeStoreFence();
            l0Var.f6015j = aVar;
        } else if (z12) {
            String string = UUID.randomUUID().toString();
            string.getClass();
            p5.m mVar = new p5.m(3);
            od.l lVar = od.l.f9459h;
            mVar.f9741f = f8.b.l(string);
            mVar.f9742g = ad.u.f575e;
            mVar.f9743h = new ArrayList();
            VarHandle.storeStoreFence();
            l0Var.i = mVar;
            ad.s sVar2 = ad.u.f576f;
            sVar2.getClass();
            if (!sVar2.f571b.equals("multipart")) {
                g5.f.l(sVar2, "multipart != ");
                return null;
            }
            mVar.f9742g = sVar2;
        }
        VarHandle.storeStoreFence();
        if (n0Var.f6050k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            w0VarArr[i].a(l0Var, objArr[i]);
        }
        ne.b bVar = l0Var.f6012f;
        ad.q qVar2 = l0Var.f6008b;
        ad.p pVar2 = l0Var.f6010d;
        if (pVar2 != null) {
            qVarA = pVar2.a();
        } else {
            String str3 = l0Var.f6009c;
            qVar2.getClass();
            str3.getClass();
            try {
                pVar = new ad.p();
                pVar.c(qVar2, str3);
            } catch (IllegalArgumentException unused) {
                pVar = null;
            }
            ad.q qVarA2 = pVar != null ? pVar.a() : null;
            if (qVarA2 == null) {
                StringBuilder sb2 = new StringBuilder("Malformed URL. Base: ");
                sb2.append(qVar2);
                g5.f.j(sb2, ", Relative: ", l0Var.f6009c);
                return null;
            }
            qVarA = qVarA2;
        }
        ad.c0 c0Var = l0Var.f6016k;
        ad.c0 c0Var2 = c0Var;
        if (c0Var == null) {
            n6.a aVar2 = l0Var.f6015j;
            if (aVar2 != null) {
                ArrayList arrayList2 = (ArrayList) aVar2.f8776c;
                ArrayList arrayList3 = (ArrayList) aVar2.f8777f;
                arrayList2.getClass();
                arrayList3.getClass();
                ad.k kVar = new ad.k();
                kVar.f540a = bd.b.x(arrayList2);
                kVar.f541b = bd.b.x(arrayList3);
                VarHandle.storeStoreFence();
                c0Var2 = kVar;
            } else {
                p5.m mVar2 = l0Var.i;
                if (mVar2 != null) {
                    ArrayList arrayList4 = (ArrayList) mVar2.f9743h;
                    if (arrayList4.isEmpty()) {
                        od.f.e("Multipart body must have at least one part.");
                        return null;
                    }
                    od.l lVar2 = (od.l) mVar2.f9741f;
                    ad.s sVar3 = (ad.s) mVar2.f9742g;
                    List listX = bd.b.x(arrayList4);
                    lVar2.getClass();
                    sVar3.getClass();
                    ad.u uVar = new ad.u();
                    uVar.f579a = lVar2;
                    uVar.f580b = listX;
                    Pattern pattern = ad.s.f568d;
                    uVar.f581c = id.k.t(sVar3 + "; boundary=" + lVar2.p());
                    uVar.f582d = -1L;
                    VarHandle.storeStoreFence();
                    c0Var2 = uVar;
                } else {
                    c0Var2 = c0Var;
                    if (l0Var.f6014h) {
                        long j10 = 0;
                        bd.b.c(j10, j10, j10);
                        ad.b0 b0Var = new ad.b0();
                        b0Var.f436a = null;
                        b0Var.f437b = 0;
                        b0Var.f438c = new byte[0];
                        VarHandle.storeStoreFence();
                        c0Var2 = b0Var;
                    }
                }
            }
        }
        ad.s sVar4 = l0Var.f6013g;
        ad.c0 c0Var3 = c0Var2;
        if (sVar4 != null) {
            if (c0Var2 != null) {
                ad.a0 a0Var = new ad.a0(1);
                a0Var.f432c = c0Var2;
                a0Var.f431b = sVar4;
                VarHandle.storeStoreFence();
                c0Var3 = a0Var;
            } else {
                bVar.a(HttpHeaders.CONTENT_TYPE, sVar4.f570a);
                c0Var3 = c0Var2;
            }
        }
        ad.y yVar = l0Var.f6011e;
        yVar.getClass();
        yVar.f631a = qVarA;
        yVar.f633c = bVar.d().c();
        yVar.l(l0Var.f6007a, c0Var3);
        Method method = n0Var.f6041a;
        p pVar3 = new p();
        pVar3.f6058a = method;
        pVar3.f6059b = Collections.unmodifiableList(arrayList);
        VarHandle.storeStoreFence();
        yVar.n(p.class, pVar3);
        ad.z zVarE = yVar.e();
        ad.w wVar = this.f6088g;
        wVar.getClass();
        return new ed.j(wVar, zVarE);
    }

    public final ed.j b() throws IOException {
        ed.j jVar = this.f6090j;
        if (jVar != null) {
            return jVar;
        }
        Throwable th = this.f6091k;
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
            ed.j jVarA = a();
            this.f6090j = jVarA;
            return jVarA;
        } catch (IOException | Error | RuntimeException e10) {
            w0.r(e10);
            this.f6091k = e10;
            throw e10;
        }
    }

    public final o0 c(ad.e0 e0Var) throws IOException {
        ad.h0 h0Var = e0Var.f473k;
        ad.d0 d0VarG = e0Var.g();
        ad.s sVarE = h0Var.e();
        long jD = h0Var.d();
        u uVar = new u();
        uVar.f6081f = sVarE;
        uVar.f6082g = jD;
        VarHandle.storeStoreFence();
        d0VarG.f459g = uVar;
        ad.e0 e0VarA = d0VarG.a();
        int i = e0VarA.f471h;
        if (i < 200 || i >= 300) {
            try {
                w0.c(h0Var);
                if (e0VarA.e()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new o0(e0VarA, null);
            } finally {
                h0Var.close();
            }
        }
        if (i == 204 || i == 205) {
            h0Var.close();
            if (e0VarA.e()) {
                return new o0(e0VarA, null);
            }
            g5.f.s("rawResponse must be successful response");
            return null;
        }
        t tVar = new t();
        tVar.f6077f = h0Var;
        tVar.f6078g = new od.c0(new s(tVar, h0Var.g()));
        VarHandle.storeStoreFence();
        try {
            Object objConvert = this.f6089h.convert(tVar);
            if (e0VarA.e()) {
                return new o0(e0VarA, objConvert);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e10) {
            IOException iOException = tVar.f6079h;
            if (iOException == null) {
                throw e10;
            }
            throw iOException;
        }
    }

    @Override // ie.c
    public final void cancel() {
        ed.j jVar;
        this.i = true;
        synchronized (this) {
            jVar = this.f6090j;
        }
        if (jVar != null) {
            jVar.cancel();
        }
    }

    @Override // ie.c
    /* renamed from: clone */
    public final c m3clone() {
        return new v(this.f6086c, this.f6087f, this.f6088g, this.f6089h);
    }

    @Override // ie.c
    public final boolean g() {
        boolean z10 = true;
        if (this.i) {
            return true;
        }
        synchronized (this) {
            try {
                ed.j jVar = this.f6090j;
                if (jVar == null || !jVar.f3812q) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // ie.c
    public final void i(f fVar) {
        ed.j jVar;
        Throwable th;
        synchronized (this) {
            try {
                if (this.f6092l) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f6092l = true;
                jVar = this.f6090j;
                th = this.f6091k;
                if (jVar == null && th == null) {
                    try {
                        ed.j jVarA = a();
                        this.f6090j = jVarA;
                        jVar = jVarA;
                    } catch (Throwable th2) {
                        th = th2;
                        w0.r(th);
                        this.f6091k = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            fVar.t(this, th);
            return;
        }
        if (this.i) {
            jVar.cancel();
        }
        n6.a aVar = new n6.a();
        aVar.f8777f = this;
        aVar.f8776c = fVar;
        VarHandle.storeStoreFence();
        jVar.d(aVar);
    }

    @Override // ie.c
    public final synchronized ad.z o() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return b().f3802f;
    }

    /* renamed from: clone, reason: collision with other method in class */
    public final Object m4clone() {
        return new v(this.f6086c, this.f6087f, this.f6088g, this.f6089h);
    }
}
