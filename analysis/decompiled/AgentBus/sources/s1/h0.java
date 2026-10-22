package s1;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: d, reason: collision with root package name */
    public static final h0 f9271d;

    /* renamed from: a, reason: collision with root package name */
    public final a0 f9272a;

    /* renamed from: b, reason: collision with root package name */
    public final p f9273b;

    /* renamed from: c, reason: collision with root package name */
    public final s f9274c;

    static {
        long j2 = u0.m.f9916f;
        long j4 = d2.n.f2798c;
        f9271d = new h0(new a0(j2, j4, null, null, null, null, null, j4, null, null, null, j2, null, null), new p(Integer.MIN_VALUE, Integer.MIN_VALUE, j4, null, null, null, 0, Integer.MIN_VALUE, null), null);
    }

    public h0(a0 a0Var, p pVar, s sVar) {
        this.f9272a = a0Var;
        this.f9273b = pVar;
        this.f9274c = sVar;
    }

    public static h0 a(h0 h0Var, long j2, v1.k kVar, v1.p pVar, long j4, long j10, c2.i iVar, int i2) {
        long jA = h0Var.f9272a.f9210a.a();
        long j11 = (i2 & 2) != 0 ? h0Var.f9272a.f9211b : j2;
        v1.k kVar2 = (i2 & 4) != 0 ? h0Var.f9272a.f9212c : kVar;
        a0 a0Var = h0Var.f9272a;
        v1.i iVar2 = a0Var.f9213d;
        v1.j jVar = a0Var.f9214e;
        v1.p pVar2 = (i2 & 32) != 0 ? a0Var.f9215f : pVar;
        String str = a0Var.f9216g;
        long j12 = (i2 & 128) != 0 ? a0Var.f9217h : j4;
        c2.a aVar = a0Var.f9218i;
        c2.p pVar3 = a0Var.f9219j;
        y1.b bVar = a0Var.f9220k;
        long j13 = a0Var.f9221l;
        c2.l lVar = a0Var.f9222m;
        u0.b0 b0Var = a0Var.f9223n;
        w0.c cVar = a0Var.f9224o;
        p pVar4 = h0Var.f9273b;
        int i10 = pVar4.f9293a;
        int i11 = pVar4.f9294b;
        long j14 = (i2 & 131072) != 0 ? pVar4.f9295c : j10;
        c2.q qVar = pVar4.f9296d;
        s sVar = (i2 & 524288) != 0 ? h0Var.f9274c : z.a.f11750a;
        return new h0(new a0(u0.m.c(jA, a0Var.f9210a.a()) ? a0Var.f9210a : jA != 16 ? new c2.c(jA) : c2.n.f1879a, j11, kVar2, iVar2, jVar, pVar2, str, j12, aVar, pVar3, bVar, j13, lVar, b0Var, cVar), new p(i10, i11, j14, qVar, sVar != null ? sVar.f9305a : null, (i2 & 1048576) != 0 ? pVar4.f9298f : iVar, pVar4.f9299g, pVar4.f9300h, pVar4.f9301i), sVar);
    }

    public static h0 c(h0 h0Var, long j2, long j4, v1.k kVar, v1.p pVar, long j10, int i2, long j11, int i10) {
        long j12 = (i10 & 2) != 0 ? d2.n.f2798c : j4;
        v1.k kVar2 = (i10 & 4) != 0 ? null : kVar;
        v1.p pVar2 = (i10 & 32) != 0 ? null : pVar;
        long j13 = (i10 & 128) != 0 ? d2.n.f2798c : j10;
        long j14 = u0.m.f9916f;
        int i11 = (32768 & i10) != 0 ? Integer.MIN_VALUE : i2;
        long j15 = (i10 & 131072) != 0 ? d2.n.f2798c : j11;
        a0 a0VarA = b0.a(h0Var.f9272a, j2, null, Float.NaN, j12, kVar2, null, null, pVar2, null, j13, null, null, null, j14, null, null, null);
        p pVarA = q.a(h0Var.f9273b, i11, Integer.MIN_VALUE, j15, null, null, null, 0, Integer.MIN_VALUE, null);
        return (h0Var.f9272a == a0VarA && h0Var.f9273b == pVarA) ? h0Var : new h0(a0VarA, pVarA);
    }

    public final long b() {
        return this.f9272a.f9210a.a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return q7.k.a(this.f9272a, h0Var.f9272a) && q7.k.a(this.f9273b, h0Var.f9273b) && q7.k.a(this.f9274c, h0Var.f9274c);
    }

    public final int hashCode() {
        int iHashCode = (this.f9273b.hashCode() + (this.f9272a.hashCode() * 31)) * 31;
        s sVar = this.f9274c;
        return iHashCode + (sVar != null ? sVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TextStyle(color=");
        sb2.append((Object) u0.m.i(b()));
        sb2.append(", brush=");
        a0 a0Var = this.f9272a;
        sb2.append(a0Var.f9210a.b());
        sb2.append(", alpha=");
        sb2.append(a0Var.f9210a.c());
        sb2.append(", fontSize=");
        sb2.append((Object) d2.n.d(a0Var.f9211b));
        sb2.append(", fontWeight=");
        sb2.append(a0Var.f9212c);
        sb2.append(", fontStyle=");
        sb2.append(a0Var.f9213d);
        sb2.append(", fontSynthesis=");
        sb2.append(a0Var.f9214e);
        sb2.append(", fontFamily=");
        sb2.append(a0Var.f9215f);
        sb2.append(", fontFeatureSettings=");
        sb2.append(a0Var.f9216g);
        sb2.append(", letterSpacing=");
        sb2.append((Object) d2.n.d(a0Var.f9217h));
        sb2.append(", baselineShift=");
        sb2.append(a0Var.f9218i);
        sb2.append(", textGeometricTransform=");
        sb2.append(a0Var.f9219j);
        sb2.append(", localeList=");
        sb2.append(a0Var.f9220k);
        sb2.append(", background=");
        m.x.u(a0Var.f9221l, sb2, ", textDecoration=");
        sb2.append(a0Var.f9222m);
        sb2.append(", shadow=");
        sb2.append(a0Var.f9223n);
        sb2.append(", drawStyle=");
        sb2.append(a0Var.f9224o);
        sb2.append(", textAlign=");
        p pVar = this.f9273b;
        sb2.append((Object) c2.k.a(pVar.f9293a));
        sb2.append(", textDirection=");
        sb2.append((Object) c2.m.a(pVar.f9294b));
        sb2.append(", lineHeight=");
        sb2.append((Object) d2.n.d(pVar.f9295c));
        sb2.append(", textIndent=");
        sb2.append(pVar.f9296d);
        sb2.append(", platformStyle=");
        sb2.append(this.f9274c);
        sb2.append(", lineHeightStyle=");
        sb2.append(pVar.f9298f);
        sb2.append(", lineBreak=");
        sb2.append((Object) c2.e.a(pVar.f9299g));
        sb2.append(", hyphens=");
        sb2.append((Object) c2.d.a(pVar.f9300h));
        sb2.append(", textMotion=");
        sb2.append(pVar.f9301i);
        sb2.append(')');
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h0(a0 a0Var, p pVar) {
        a0Var.getClass();
        r rVar = pVar.f9297e;
        this(a0Var, pVar, rVar == null ? null : new s(rVar));
    }
}
