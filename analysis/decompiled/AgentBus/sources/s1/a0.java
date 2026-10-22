package s1;

import fi.iki.elonen.NanoHTTPD;

/* loaded from: classes.dex */
public final class a0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public final c2.o f9210a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9211b;

    /* renamed from: c, reason: collision with root package name */
    public final v1.k f9212c;

    /* renamed from: d, reason: collision with root package name */
    public final v1.i f9213d;

    /* renamed from: e, reason: collision with root package name */
    public final v1.j f9214e;

    /* renamed from: f, reason: collision with root package name */
    public final v1.p f9215f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9216g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9217h;

    /* renamed from: i, reason: collision with root package name */
    public final c2.a f9218i;

    /* renamed from: j, reason: collision with root package name */
    public final c2.p f9219j;

    /* renamed from: k, reason: collision with root package name */
    public final y1.b f9220k;

    /* renamed from: l, reason: collision with root package name */
    public final long f9221l;

    /* renamed from: m, reason: collision with root package name */
    public final c2.l f9222m;

    /* renamed from: n, reason: collision with root package name */
    public final u0.b0 f9223n;

    /* renamed from: o, reason: collision with root package name */
    public final w0.c f9224o;

    public a0(long j2, long j4, v1.k kVar, v1.i iVar, v1.j jVar, v1.p pVar, String str, long j10, c2.a aVar, c2.p pVar2, y1.b bVar, long j11, c2.l lVar, u0.b0 b0Var) {
        this(j2 != 16 ? new c2.c(j2) : c2.n.f1879a, j4, kVar, iVar, jVar, pVar, str, j10, aVar, pVar2, bVar, j11, lVar, b0Var, (w0.c) null);
    }

    public final boolean a(a0 a0Var) {
        if (this == a0Var) {
            return true;
        }
        return d2.n.a(this.f9211b, a0Var.f9211b) && q7.k.a(this.f9212c, a0Var.f9212c) && q7.k.a(this.f9213d, a0Var.f9213d) && q7.k.a(this.f9214e, a0Var.f9214e) && q7.k.a(this.f9215f, a0Var.f9215f) && q7.k.a(this.f9216g, a0Var.f9216g) && d2.n.a(this.f9217h, a0Var.f9217h) && q7.k.a(this.f9218i, a0Var.f9218i) && q7.k.a(this.f9219j, a0Var.f9219j) && q7.k.a(this.f9220k, a0Var.f9220k) && u0.m.c(this.f9221l, a0Var.f9221l);
    }

    public final boolean b(a0 a0Var) {
        return q7.k.a(this.f9210a, a0Var.f9210a) && q7.k.a(this.f9222m, a0Var.f9222m) && q7.k.a(this.f9223n, a0Var.f9223n) && q7.k.a(this.f9224o, a0Var.f9224o);
    }

    public final a0 c(a0 a0Var) {
        if (a0Var == null) {
            return this;
        }
        c2.o oVar = a0Var.f9210a;
        return b0.a(this, oVar.a(), oVar.b(), oVar.c(), a0Var.f9211b, a0Var.f9212c, a0Var.f9213d, a0Var.f9214e, a0Var.f9215f, a0Var.f9216g, a0Var.f9217h, a0Var.f9218i, a0Var.f9219j, a0Var.f9220k, a0Var.f9221l, a0Var.f9222m, a0Var.f9223n, a0Var.f9224o);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return a(a0Var) && b(a0Var);
    }

    public final int hashCode() {
        c2.o oVar = this.f9210a;
        long jA = oVar.a();
        int i2 = u0.m.f9917g;
        int iHashCode = Long.hashCode(jA) * 31;
        u0.z zVarB = oVar.b();
        int iHashCode2 = (Float.hashCode(oVar.c()) + ((iHashCode + (zVarB != null ? zVarB.hashCode() : 0)) * 31)) * 31;
        d2.o[] oVarArr = d2.n.f2797b;
        int iF = m.x.f(this.f9211b, iHashCode2, 31);
        v1.k kVar = this.f9212c;
        int i10 = (iF + (kVar != null ? kVar.f10363f : 0)) * 31;
        v1.i iVar = this.f9213d;
        int iHashCode3 = (i10 + (iVar != null ? Integer.hashCode(iVar.f10355a) : 0)) * 31;
        v1.j jVar = this.f9214e;
        int iHashCode4 = (iHashCode3 + (jVar != null ? Integer.hashCode(jVar.f10356a) : 0)) * 31;
        v1.p pVar = this.f9215f;
        int iHashCode5 = (iHashCode4 + (pVar != null ? pVar.hashCode() : 0)) * 31;
        String str = this.f9216g;
        int iF2 = m.x.f(this.f9217h, (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31, 31);
        c2.a aVar = this.f9218i;
        int iHashCode6 = (iF2 + (aVar != null ? Float.hashCode(aVar.f1857a) : 0)) * 31;
        c2.p pVar2 = this.f9219j;
        int iHashCode7 = (iHashCode6 + (pVar2 != null ? pVar2.hashCode() : 0)) * 31;
        y1.b bVar = this.f9220k;
        int iF3 = m.x.f(this.f9221l, (iHashCode7 + (bVar != null ? bVar.f11543f.hashCode() : 0)) * 31, 31);
        c2.l lVar = this.f9222m;
        int i11 = (iF3 + (lVar != null ? lVar.f1877a : 0)) * 31;
        u0.b0 b0Var = this.f9223n;
        int iHashCode8 = (i11 + (b0Var != null ? b0Var.hashCode() : 0)) * 961;
        w0.c cVar = this.f9224o;
        return iHashCode8 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SpanStyle(color=");
        c2.o oVar = this.f9210a;
        sb2.append((Object) u0.m.i(oVar.a()));
        sb2.append(", brush=");
        sb2.append(oVar.b());
        sb2.append(", alpha=");
        sb2.append(oVar.c());
        sb2.append(", fontSize=");
        sb2.append((Object) d2.n.d(this.f9211b));
        sb2.append(", fontWeight=");
        sb2.append(this.f9212c);
        sb2.append(", fontStyle=");
        sb2.append(this.f9213d);
        sb2.append(", fontSynthesis=");
        sb2.append(this.f9214e);
        sb2.append(", fontFamily=");
        sb2.append(this.f9215f);
        sb2.append(", fontFeatureSettings=");
        sb2.append(this.f9216g);
        sb2.append(", letterSpacing=");
        sb2.append((Object) d2.n.d(this.f9217h));
        sb2.append(", baselineShift=");
        sb2.append(this.f9218i);
        sb2.append(", textGeometricTransform=");
        sb2.append(this.f9219j);
        sb2.append(", localeList=");
        sb2.append(this.f9220k);
        sb2.append(", background=");
        m.x.u(this.f9221l, sb2, ", textDecoration=");
        sb2.append(this.f9222m);
        sb2.append(", shadow=");
        sb2.append(this.f9223n);
        sb2.append(", platformStyle=null, drawStyle=");
        sb2.append(this.f9224o);
        sb2.append(')');
        return sb2.toString();
    }

    public a0(c2.o oVar, long j2, v1.k kVar, v1.i iVar, v1.j jVar, v1.p pVar, String str, long j4, c2.a aVar, c2.p pVar2, y1.b bVar, long j10, c2.l lVar, u0.b0 b0Var, w0.c cVar) {
        this.f9210a = oVar;
        this.f9211b = j2;
        this.f9212c = kVar;
        this.f9213d = iVar;
        this.f9214e = jVar;
        this.f9215f = pVar;
        this.f9216g = str;
        this.f9217h = j4;
        this.f9218i = aVar;
        this.f9219j = pVar2;
        this.f9220k = bVar;
        this.f9221l = j10;
        this.f9222m = lVar;
        this.f9223n = b0Var;
        this.f9224o = cVar;
    }

    public a0(long j2, long j4, v1.k kVar, v1.i iVar, v1.j jVar, v1.p pVar, String str, long j10, c2.a aVar, c2.p pVar2, y1.b bVar, long j11, c2.l lVar, u0.b0 b0Var, int i2) {
        this((i2 & 1) != 0 ? u0.m.f9916f : j2, (i2 & 2) != 0 ? d2.n.f2798c : j4, (i2 & 4) != 0 ? null : kVar, (i2 & 8) != 0 ? null : iVar, (i2 & 16) != 0 ? null : jVar, (i2 & 32) != 0 ? null : pVar, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? d2.n.f2798c : j10, (i2 & 256) != 0 ? null : aVar, (i2 & 512) != 0 ? null : pVar2, (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? null : bVar, (i2 & 2048) != 0 ? u0.m.f9916f : j11, (i2 & 4096) != 0 ? null : lVar, (i2 & NanoHTTPD.HTTPSession.BUFSIZE) != 0 ? null : b0Var);
    }
}
