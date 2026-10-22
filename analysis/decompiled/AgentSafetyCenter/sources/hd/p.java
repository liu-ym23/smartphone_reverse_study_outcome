package hd;

import ad.c0;
import ad.d0;
import ad.e0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import od.g0;
import od.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements fd.d {

    /* renamed from: g, reason: collision with root package name */
    public static final List f5539g = bd.b.k("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h, reason: collision with root package name */
    public static final List f5540h = bd.b.k("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public ed.m f5541a;

    /* renamed from: b, reason: collision with root package name */
    public fd.f f5542b;

    /* renamed from: c, reason: collision with root package name */
    public o f5543c;

    /* renamed from: d, reason: collision with root package name */
    public volatile v f5544d;

    /* renamed from: e, reason: collision with root package name */
    public ad.x f5545e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f5546f;

    @Override // fd.d
    public final void a() {
        v vVar = this.f5544d;
        vVar.getClass();
        vVar.f().close();
    }

    @Override // fd.d
    public final d0 b(boolean z10) throws NumberFormatException, IOException {
        ad.n nVar;
        v vVar = this.f5544d;
        if (vVar == null) {
            od.f.l("stream wasn't created");
            return null;
        }
        synchronized (vVar) {
            vVar.f5575k.h();
            while (vVar.f5572g.isEmpty() && vVar.f5577m == 0) {
                try {
                    try {
                        vVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    vVar.f5575k.k();
                    throw th;
                }
            }
            vVar.f5575k.k();
            if (vVar.f5572g.isEmpty()) {
                IOException iOException = vVar.f5578n;
                if (iOException != null) {
                    throw iOException;
                }
                int i = vVar.f5577m;
                if (i != 0) {
                    throw new a0(i);
                }
                throw null;
            }
            Object objRemoveFirst = vVar.f5572g.removeFirst();
            objRemoveFirst.getClass();
            nVar = (ad.n) objRemoveFirst;
        }
        ad.x xVar = this.f5545e;
        xVar.getClass();
        ArrayList arrayList = new ArrayList(20);
        int size = nVar.size();
        b2.a aVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            String strB = nVar.b(i3);
            String strD = nVar.d(i3);
            if (yb.k.a(strB, ":status")) {
                aVarA = id.c.A("HTTP/1.1 " + strD);
            } else if (!f5540h.contains(strB)) {
                strB.getClass();
                strD.getClass();
                arrayList.add(strB);
                arrayList.add(hc.h.w0(strD).toString());
            }
        }
        if (aVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        d0 d0Var = new d0();
        d0Var.f454b = xVar;
        d0Var.f455c = aVarA.f1860b;
        d0Var.f456d = (String) aVarA.f1862d;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ne.b bVar = new ne.b();
        ArrayList arrayList2 = bVar.f8958c;
        arrayList2.getClass();
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        arrayList2.addAll(listAsList);
        d0Var.f458f = bVar;
        if (z10 && d0Var.f455c == 100) {
            return null;
        }
        return d0Var;
    }

    @Override // fd.d
    public final void c(ad.z zVar) throws IOException {
        int i;
        v vVar;
        boolean z10;
        zVar.getClass();
        if (this.f5544d != null) {
            return;
        }
        boolean z11 = ((c0) zVar.f640e) != null;
        ad.n nVar = (ad.n) zVar.f639d;
        ArrayList arrayList = new ArrayList(nVar.size() + 4);
        arrayList.add(new b(b.f5470f, (String) zVar.f638c));
        od.l lVar = b.f5471g;
        ad.q qVar = (ad.q) zVar.f637b;
        qVar.getClass();
        String strB = qVar.b();
        String strD = qVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new b(lVar, strB));
        String strA = nVar.a("Host");
        if (strA != null) {
            arrayList.add(new b(b.i, strA));
        }
        arrayList.add(new b(b.f5472h, qVar.f559a));
        int size = nVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            String strB2 = nVar.b(i3);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strB2.toLowerCase(locale);
            lowerCase.getClass();
            if (!f5539g.contains(lowerCase) || (lowerCase.equals("te") && yb.k.a(nVar.d(i3), "trailers"))) {
                arrayList.add(new b(lowerCase, nVar.d(i3)));
            }
        }
        o oVar = this.f5543c;
        oVar.getClass();
        boolean z12 = !z11;
        synchronized (oVar.A) {
            synchronized (oVar) {
                try {
                    if (oVar.i > 1073741823) {
                        oVar.i(8);
                    }
                    if (oVar.f5522j) {
                        throw new a();
                    }
                    i = oVar.i;
                    oVar.i = i + 2;
                    vVar = new v(i, oVar, z12, false, null);
                    z10 = !z11 || oVar.f5536x >= oVar.f5537y || vVar.f5570e >= vVar.f5571f;
                    if (vVar.h()) {
                        oVar.f5519f.put(Integer.valueOf(i), vVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            oVar.A.n(z12, i, arrayList);
        }
        if (z10) {
            oVar.A.flush();
        }
        this.f5544d = vVar;
        boolean z13 = this.f5546f;
        v vVar2 = this.f5544d;
        if (z13) {
            vVar2.getClass();
            vVar2.e(9);
            od.f.l("Canceled");
        } else {
            vVar2.getClass();
            vVar2.f5575k.g(this.f5542b.f4068g);
            v vVar3 = this.f5544d;
            vVar3.getClass();
            vVar3.f5576l.g(this.f5542b.f4069h);
        }
    }

    @Override // fd.d
    public final void cancel() {
        this.f5546f = true;
        v vVar = this.f5544d;
        if (vVar != null) {
            vVar.e(9);
        }
    }

    @Override // fd.d
    public final ed.m d() {
        return this.f5541a;
    }

    @Override // fd.d
    public final i0 e(e0 e0Var) {
        v vVar = this.f5544d;
        vVar.getClass();
        return vVar.i;
    }

    @Override // fd.d
    public final g0 f(ad.z zVar, long j10) {
        zVar.getClass();
        v vVar = this.f5544d;
        vVar.getClass();
        return vVar.f();
    }

    @Override // fd.d
    public final void g() {
        this.f5543c.flush();
    }

    @Override // fd.d
    public final long h(e0 e0Var) {
        if (fd.e.a(e0Var)) {
            return bd.b.j(e0Var);
        }
        return 0L;
    }
}
