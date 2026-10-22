package I4;

import C4.A;
import C4.B;
import C4.D;
import C4.F;
import C4.v;
import C4.x;
import L4.w;
import L4.y;
import L4.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class g implements G4.c {

    /* renamed from: g, reason: collision with root package name */
    private static final List<String> f3091g = D4.e.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f3092h = D4.e.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final x.a f3093a;

    /* renamed from: b, reason: collision with root package name */
    private final F4.e f3094b;

    /* renamed from: c, reason: collision with root package name */
    private final f f3095c;

    /* renamed from: d, reason: collision with root package name */
    private volatile i f3096d;

    /* renamed from: e, reason: collision with root package name */
    private final B f3097e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f3098f;

    public g(A a6, F4.e eVar, x.a aVar, f fVar) {
        this.f3094b = eVar;
        this.f3093a = aVar;
        this.f3095c = fVar;
        List<B> listZ = a6.z();
        B b6 = B.H2_PRIOR_KNOWLEDGE;
        this.f3097e = listZ.contains(b6) ? b6 : B.HTTP_2;
    }

    public static List<c> i(D d6) {
        v vVarD = d6.d();
        ArrayList arrayList = new ArrayList(vVarD.h() + 4);
        arrayList.add(new c(c.f2990f, d6.f()));
        arrayList.add(new c(c.f2991g, G4.i.c(d6.i())));
        String strC = d6.c("Host");
        if (strC != null) {
            arrayList.add(new c(c.f2993i, strC));
        }
        arrayList.add(new c(c.f2992h, d6.i().D()));
        int iH = vVarD.h();
        for (int i5 = 0; i5 < iH; i5++) {
            String lowerCase = vVarD.e(i5).toLowerCase(Locale.US);
            if (!f3091g.contains(lowerCase) || (lowerCase.equals("te") && vVarD.i(i5).equals("trailers"))) {
                arrayList.add(new c(lowerCase, vVarD.i(i5)));
            }
        }
        return arrayList;
    }

    public static F.a j(v vVar, B b6) throws ProtocolException, NumberFormatException {
        v.a aVar = new v.a();
        int iH = vVar.h();
        G4.k kVarA = null;
        for (int i5 = 0; i5 < iH; i5++) {
            String strE = vVar.e(i5);
            String strI = vVar.i(i5);
            if (strE.equals(":status")) {
                kVarA = G4.k.a("HTTP/1.1 " + strI);
            } else if (!f3092h.contains(strE)) {
                D4.a.f1202a.b(aVar, strE, strI);
            }
        }
        if (kVarA != null) {
            return new F.a().o(b6).g(kVarA.f1937b).l(kVarA.f1938c).j(aVar.e());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // G4.c
    public void a() {
        this.f3096d.h().close();
    }

    @Override // G4.c
    public F.a b(boolean z5) throws ProtocolException, NumberFormatException {
        F.a aVarJ = j(this.f3096d.p(), this.f3097e);
        if (z5 && D4.a.f1202a.d(aVarJ) == 100) {
            return null;
        }
        return aVarJ;
    }

    @Override // G4.c
    public F4.e c() {
        return this.f3094b;
    }

    @Override // G4.c
    public void cancel() {
        this.f3098f = true;
        if (this.f3096d != null) {
            this.f3096d.f(b.CANCEL);
        }
    }

    @Override // G4.c
    public y d(F f5) {
        return this.f3096d.i();
    }

    @Override // G4.c
    public w e(D d6, long j5) {
        return this.f3096d.h();
    }

    @Override // G4.c
    public void f() {
        this.f3095c.flush();
    }

    @Override // G4.c
    public void g(D d6) throws IOException {
        if (this.f3096d != null) {
            return;
        }
        this.f3096d = this.f3095c.N(i(d6), d6.a() != null);
        if (this.f3098f) {
            this.f3096d.f(b.CANCEL);
            throw new IOException("Canceled");
        }
        z zVarL = this.f3096d.l();
        long jC = this.f3093a.c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVarL.g(jC, timeUnit);
        this.f3096d.r().g(this.f3093a.d(), timeUnit);
    }

    @Override // G4.c
    public long h(F f5) {
        return G4.e.b(f5);
    }
}
