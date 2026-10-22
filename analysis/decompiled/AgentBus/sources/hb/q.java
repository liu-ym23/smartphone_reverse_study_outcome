package hb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import ob.i0;
import ob.k0;

/* loaded from: classes.dex */
public final class q implements fb.e {

    /* renamed from: g, reason: collision with root package name */
    public static final List f4335g = bb.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h, reason: collision with root package name */
    public static final List f4336h = bb.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public final eb.m f4337a;

    /* renamed from: b, reason: collision with root package name */
    public final fb.g f4338b;

    /* renamed from: c, reason: collision with root package name */
    public final p f4339c;

    /* renamed from: d, reason: collision with root package name */
    public volatile x f4340d;

    /* renamed from: e, reason: collision with root package name */
    public final ab.u f4341e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f4342f;

    public q(ab.t tVar, eb.m mVar, fb.g gVar, p pVar) {
        q7.k.e(pVar, "http2Connection");
        this.f4337a = mVar;
        this.f4338b = gVar;
        this.f4339c = pVar;
        List list = tVar.f644w;
        ab.u uVar = ab.u.H2_PRIOR_KNOWLEDGE;
        this.f4341e = list.contains(uVar) ? uVar : ab.u.HTTP_2;
    }

    @Override // fb.e
    public final void a() {
        x xVar = this.f4340d;
        q7.k.b(xVar);
        xVar.f().close();
    }

    @Override // fb.e
    public final void b() {
        this.f4339c.flush();
    }

    @Override // fb.e
    public final i0 c(ab.w wVar, long j2) {
        q7.k.e(wVar, "request");
        x xVar = this.f4340d;
        q7.k.b(xVar);
        return xVar.f();
    }

    @Override // fb.e
    public final void cancel() {
        this.f4342f = true;
        x xVar = this.f4340d;
        if (xVar != null) {
            xVar.e(9);
        }
    }

    @Override // fb.e
    public final k0 d(ab.z zVar) {
        x xVar = this.f4340d;
        q7.k.b(xVar);
        return xVar.f4372i;
    }

    @Override // fb.e
    public final ab.y e(boolean z4) throws NumberFormatException, IOException {
        ab.n nVar;
        x xVar = this.f4340d;
        if (xVar == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (xVar) {
            xVar.f4374k.i();
            while (xVar.f4370g.isEmpty() && xVar.f4376m == 0) {
                try {
                    try {
                        xVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    xVar.f4374k.l();
                    throw th;
                }
            }
            xVar.f4374k.l();
            if (xVar.f4370g.isEmpty()) {
                IOException iOException = xVar.f4377n;
                if (iOException != null) {
                    throw iOException;
                }
                int i2 = xVar.f4376m;
                m.x.s(i2);
                throw new c0(i2);
            }
            Object objRemoveFirst = xVar.f4370g.removeFirst();
            q7.k.d(objRemoveFirst, "headersQueue.removeFirst()");
            nVar = (ab.n) objRemoveFirst;
        }
        ab.u uVar = this.f4341e;
        q7.k.e(uVar, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = nVar.size();
        ab.x xVarA0 = null;
        for (int i10 = 0; i10 < size; i10++) {
            String strF = nVar.f(i10);
            String strI = nVar.i(i10);
            if (q7.k.a(strF, ":status")) {
                xVarA0 = a.a.a0("HTTP/1.1 " + strI);
            } else if (!f4336h.contains(strF)) {
                q7.k.e(strF, "name");
                q7.k.e(strI, "value");
                arrayList.add(strF);
                arrayList.add(ga.k.N0(strI).toString());
            }
        }
        if (xVarA0 == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ab.y yVar = new ab.y();
        yVar.f672b = uVar;
        yVar.f673c = xVarA0.f668b;
        yVar.f674d = (String) xVarA0.f670d;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ab.m mVar = new ab.m();
        ArrayList arrayList2 = mVar.f577f;
        q7.k.e(arrayList2, "<this>");
        q7.k.e(strArr, "elements");
        arrayList2.addAll(d7.n.S(strArr));
        yVar.f676f = mVar;
        if (z4 && yVar.f673c == 100) {
            return null;
        }
        return yVar;
    }

    @Override // fb.e
    public final void f(ab.w wVar) throws IOException {
        int i2;
        x xVar;
        boolean z4;
        q7.k.e(wVar, "request");
        if (this.f4340d != null) {
            return;
        }
        boolean z10 = wVar.f664d != null;
        ab.n nVar = wVar.f663c;
        ArrayList arrayList = new ArrayList(nVar.size() + 4);
        arrayList.add(new b(b.f4258f, wVar.f662b));
        ob.k kVar = b.f4259g;
        ab.p pVar = wVar.f661a;
        q7.k.e(pVar, "url");
        String strB = pVar.b();
        String strD = pVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new b(kVar, strB));
        String strA = wVar.f663c.a("Host");
        if (strA != null) {
            arrayList.add(new b(b.f4261i, strA));
        }
        arrayList.add(new b(b.f4260h, pVar.f588a));
        int size = nVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strF = nVar.f(i10);
            Locale locale = Locale.US;
            q7.k.d(locale, "US");
            String lowerCase = strF.toLowerCase(locale);
            q7.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!f4335g.contains(lowerCase) || (lowerCase.equals("te") && q7.k.a(nVar.i(i10), "trailers"))) {
                arrayList.add(new b(lowerCase, nVar.i(i10)));
            }
        }
        p pVar2 = this.f4339c;
        pVar2.getClass();
        boolean z11 = !z10;
        synchronized (pVar2.C) {
            synchronized (pVar2) {
                try {
                    if (pVar2.f4318j > 1073741823) {
                        pVar2.e(8);
                    }
                    if (pVar2.f4319k) {
                        throw new a();
                    }
                    i2 = pVar2.f4318j;
                    pVar2.f4318j = i2 + 2;
                    xVar = new x(i2, pVar2, z11, false, null);
                    z4 = !z10 || pVar2.f4334z >= pVar2.A || xVar.f4368e >= xVar.f4369f;
                    if (xVar.h()) {
                        pVar2.f4315g.put(Integer.valueOf(i2), xVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            pVar2.C.g(z11, i2, arrayList);
        }
        if (z4) {
            pVar2.C.flush();
        }
        this.f4340d = xVar;
        if (this.f4342f) {
            x xVar2 = this.f4340d;
            q7.k.b(xVar2);
            xVar2.e(9);
            throw new IOException("Canceled");
        }
        x xVar3 = this.f4340d;
        q7.k.b(xVar3);
        w wVar2 = xVar3.f4374k;
        long j2 = this.f4338b.f3655g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        wVar2.g(j2, timeUnit);
        x xVar4 = this.f4340d;
        q7.k.b(xVar4);
        xVar4.f4375l.g(this.f4338b.f3656h, timeUnit);
    }

    @Override // fb.e
    public final eb.m g() {
        return this.f4337a;
    }

    @Override // fb.e
    public final long h(ab.z zVar) {
        if (fb.f.a(zVar)) {
            return bb.b.k(zVar);
        }
        return 0L;
    }
}
