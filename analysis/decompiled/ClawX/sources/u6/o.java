package u6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o implements s6.f {

    /* renamed from: g, reason: collision with root package name */
    public static final List f5736g = o6.f.k(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* renamed from: h, reason: collision with root package name */
    public static final List f5737h = o6.f.k(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: a, reason: collision with root package name */
    public final r6.p f5738a;

    /* renamed from: b, reason: collision with root package name */
    public final s6.h f5739b;

    /* renamed from: c, reason: collision with root package name */
    public final n f5740c;
    public volatile v d;

    /* renamed from: e, reason: collision with root package name */
    public final n6.r f5741e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f5742f;

    public o(n6.q qVar, r6.p pVar, s6.h hVar, n http2Connection) {
        kotlin.jvm.internal.p.e(http2Connection, "http2Connection");
        this.f5738a = pVar;
        this.f5739b = hVar;
        this.f5740c = http2Connection;
        List list = qVar.f4112r;
        n6.r rVar = n6.r.f4123g;
        this.f5741e = list.contains(rVar) ? rVar : n6.r.f4122f;
    }

    @Override // s6.f
    public final void a() {
        v vVar = this.d;
        kotlin.jvm.internal.p.b(vVar);
        vVar.f5767i.close();
    }

    @Override // s6.f
    public final void b(n6.s sVar) throws IOException {
        int i8;
        v vVar;
        if (this.d != null) {
            return;
        }
        n6.k kVar = sVar.f4130c;
        ArrayList arrayList = new ArrayList(kVar.size() + 4);
        arrayList.add(new d(d.f5680f, sVar.f4129b));
        c7.i iVar = d.f5681g;
        n6.m url = sVar.f4128a;
        kotlin.jvm.internal.p.e(url, "url");
        String strB = url.b();
        String strD = url.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new d(iVar, strB));
        String strF = sVar.f4130c.f("Host");
        if (strF != null) {
            arrayList.add(new d(d.f5683i, strF));
        }
        arrayList.add(new d(d.f5682h, url.f4063a));
        int size = kVar.size();
        for (int i9 = 0; i9 < size; i9++) {
            String strG = kVar.g(i9);
            Locale US = Locale.US;
            kotlin.jvm.internal.p.d(US, "US");
            String lowerCase = strG.toLowerCase(US);
            kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
            if (!f5736g.contains(lowerCase) || (lowerCase.equals("te") && kVar.i(i9).equals("trailers"))) {
                arrayList.add(new d(lowerCase, kVar.i(i9)));
            }
        }
        n nVar = this.f5740c;
        nVar.getClass();
        synchronized (nVar.y) {
            synchronized (nVar) {
                try {
                    if (nVar.f5717e > 1073741823) {
                        nVar.g(b.f5674g);
                    }
                    if (nVar.f5718f) {
                        throw new a();
                    }
                    i8 = nVar.f5717e;
                    nVar.f5717e = i8 + 2;
                    vVar = new v(i8, nVar, true, false, null);
                    if (vVar.j()) {
                        nVar.f5715b.put(Integer.valueOf(i8), vVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            nVar.y.j(true, i8, arrayList);
        }
        nVar.y.flush();
        this.d = vVar;
        if (this.f5742f) {
            v vVar2 = this.d;
            kotlin.jvm.internal.p.b(vVar2);
            vVar2.g(b.f5675h);
            throw new IOException("Canceled");
        }
        v vVar3 = this.d;
        kotlin.jvm.internal.p.b(vVar3);
        u uVar = vVar3.f5768j;
        long j4 = this.f5739b.f5250g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        uVar.g(j4, timeUnit);
        v vVar4 = this.d;
        kotlin.jvm.internal.p.b(vVar4);
        vVar4.f5769k.g(this.f5739b.f5251h, timeUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    @Override // s6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r4 = this;
            u6.v r4 = r4.d
            r0 = 0
            if (r4 == 0) goto L21
            monitor-enter(r4)
            u6.t r1 = r4.f5766h     // Catch: java.lang.Throwable -> L17
            boolean r2 = r1.f5755b     // Catch: java.lang.Throwable -> L17
            r3 = 1
            if (r2 == 0) goto L19
            c7.f r1 = r1.d     // Catch: java.lang.Throwable -> L17
            boolean r1 = r1.q()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L19
            r1 = r3
            goto L1a
        L17:
            r0 = move-exception
            goto L1f
        L19:
            r1 = r0
        L1a:
            monitor-exit(r4)
            if (r1 != r3) goto L1e
            return r3
        L1e:
            return r0
        L1f:
            monitor-exit(r4)
            throw r0
        L21:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.o.c():boolean");
    }

    @Override // s6.f
    public final void cancel() {
        this.f5742f = true;
        v vVar = this.d;
        if (vVar != null) {
            vVar.g(b.f5675h);
        }
    }

    @Override // s6.f
    public final c7.u d() {
        v vVar = this.d;
        kotlin.jvm.internal.p.b(vVar);
        return vVar;
    }

    @Override // s6.f
    public final s6.e e() {
        return this.f5738a;
    }

    @Override // s6.f
    public final long f(n6.u uVar) {
        if (s6.g.a(uVar)) {
            return o6.f.e(uVar);
        }
        return 0L;
    }

    @Override // s6.f
    public final n6.t g() throws IOException {
        int i8;
        n6.k kVar;
        v vVar = this.d;
        if (vVar == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (vVar) {
            while (true) {
                if (!vVar.f5764f.isEmpty() || vVar.h() != null) {
                    break;
                }
                vVar.f5761b.getClass();
                s sVar = vVar.f5767i;
                i8 = (sVar.f5753c || sVar.f5751a) ? 1 : 0;
                if (i8 != 0) {
                    vVar.f5768j.i();
                }
                try {
                    try {
                        vVar.wait();
                        if (i8 != 0) {
                            vVar.f5768j.m();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    if (i8 != 0) {
                        vVar.f5768j.m();
                    }
                    throw th;
                }
            }
            if (vVar.f5764f.isEmpty()) {
                IOException iOException = vVar.f5771m;
                if (iOException != null) {
                    throw iOException;
                }
                b bVarH = vVar.h();
                kotlin.jvm.internal.p.b(bVarH);
                throw new a0(bVarH);
            }
            Object objRemoveFirst = vVar.f5764f.removeFirst();
            kotlin.jvm.internal.p.d(objRemoveFirst, "removeFirst(...)");
            kVar = (n6.k) objRemoveFirst;
        }
        n6.r protocol = this.f5741e;
        kotlin.jvm.internal.p.e(protocol, "protocol");
        androidx.fragment.app.l lVar = new androidx.fragment.app.l(1);
        int size = kVar.size();
        d8.m mVarB = null;
        while (i8 < size) {
            String strG = kVar.g(i8);
            String strI = kVar.i(i8);
            if (strG.equals(":status")) {
                mVarB = k4.z.B("HTTP/1.1 ".concat(strI));
            } else if (!f5737h.contains(strG)) {
                k4.v.p(lVar, strG, strI);
            }
            i8++;
        }
        if (mVarB == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        n6.t tVar = new n6.t();
        tVar.f4133b = protocol;
        tVar.f4134c = mVarB.f2076b;
        tVar.d = (String) mVarB.d;
        tVar.f4136f = lVar.a().h();
        return tVar;
    }

    @Override // s6.f
    public final c7.v h(n6.u uVar) {
        v vVar = this.d;
        kotlin.jvm.internal.p.b(vVar);
        return vVar.f5766h;
    }
}
