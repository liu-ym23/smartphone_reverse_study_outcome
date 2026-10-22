package d2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f3139d = new l0(0, 0, null, 0, 0, 16777215);

    /* renamed from: a, reason: collision with root package name */
    public final e0 f3140a;

    /* renamed from: b, reason: collision with root package name */
    public final t f3141b;

    /* renamed from: c, reason: collision with root package name */
    public final w f3142c;

    public l0(long j10, long j11, g2.k kVar, long j12, long j13, int i) {
        this(new e0((i & 1) != 0 ? d1.p.f3024g : j10, (i & 2) != 0 ? o2.n.f9128c : j11, (i & 4) != 0 ? null : kVar, null, null, (i & 32) != 0 ? null : g2.q.f4259a, null, (i & 128) != 0 ? o2.n.f9128c : j12, null, null, null, d1.p.f3024g, null, null), new t(Integer.MIN_VALUE, Integer.MIN_VALUE, (i & 131072) != 0 ? o2.n.f9128c : j13, null, null, null, 0, Integer.MIN_VALUE, null), null);
    }

    public static l0 a(l0 l0Var, long j10, long j11, g2.k kVar, g2.q qVar, long j12, long j13, n2.i iVar, int i) {
        n2.a aVar;
        n2.p pVar;
        long j14;
        n2.o oVar;
        w wVar = i0.a.f5592a;
        long jA = (i & 1) != 0 ? l0Var.f3140a.f3081a.a() : j10;
        long j15 = (i & 2) != 0 ? l0Var.f3140a.f3082b : j11;
        g2.k kVar2 = (i & 4) != 0 ? l0Var.f3140a.f3083c : kVar;
        e0 e0Var = l0Var.f3140a;
        g2.i iVar2 = e0Var.f3084d;
        g2.j jVar = e0Var.f3085e;
        g2.q qVar2 = (i & 32) != 0 ? e0Var.f3086f : qVar;
        String str = e0Var.f3087g;
        long j16 = (i & 128) != 0 ? e0Var.f3088h : j12;
        n2.a aVar2 = e0Var.i;
        n2.p pVar2 = e0Var.f3089j;
        j2.b bVar = e0Var.f3090k;
        long j17 = e0Var.f3091l;
        n2.l lVar = e0Var.f3092m;
        d1.i0 i0Var = e0Var.f3093n;
        td.h hVar = e0Var.f3094o;
        t tVar = l0Var.f3141b;
        int i3 = tVar.f3169a;
        int i10 = tVar.f3170b;
        if ((i & 131072) != 0) {
            aVar = aVar2;
            pVar = pVar2;
            j14 = tVar.f3171c;
        } else {
            aVar = aVar2;
            pVar = pVar2;
            j14 = j13;
        }
        n2.q qVar3 = tVar.f3172d;
        w wVar2 = (i & 524288) != 0 ? l0Var.f3142c : wVar;
        n2.i iVar3 = (i & 1048576) != 0 ? tVar.f3174f : iVar;
        int i11 = tVar.f3175g;
        int i12 = tVar.f3176h;
        n2.s sVar = tVar.i;
        if (d1.p.d(jA, e0Var.f3081a.a())) {
            oVar = e0Var.f3081a;
        } else if (jA != 16) {
            n2.c cVar = new n2.c();
            cVar.f8647a = jA;
            if (jA == 16) {
                i2.a.a("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
            }
            VarHandle.storeStoreFence();
            oVar = cVar;
        } else {
            oVar = n2.n.f8667a;
        }
        return new l0(new e0(oVar, j15, kVar2, iVar2, jVar, qVar2, str, j16, aVar, pVar, bVar, j17, lVar, i0Var, hVar), new t(i3, i10, j14, qVar3, wVar2 != null ? wVar2.f3180a : null, iVar3, i11, i12, sVar), wVar2);
    }

    public static l0 d(l0 l0Var, long j10, long j11, g2.k kVar, long j12, int i, long j13, int i3) {
        long j14 = (i3 & 2) != 0 ? o2.n.f9128c : j11;
        g2.k kVar2 = (i3 & 4) != 0 ? null : kVar;
        long j15 = (i3 & 128) != 0 ? o2.n.f9128c : j12;
        long j16 = d1.p.f3024g;
        int i10 = (32768 & i3) != 0 ? Integer.MIN_VALUE : i;
        long j17 = (i3 & 131072) != 0 ? o2.n.f9128c : j13;
        e0 e0VarA = f0.a(l0Var.f3140a, j10, null, Float.NaN, j14, kVar2, null, null, null, null, j15, null, null, null, j16, null, null, null);
        t tVarA = u.a(l0Var.f3141b, i10, Integer.MIN_VALUE, j17, null, null, null, 0, Integer.MIN_VALUE, null);
        return (l0Var.f3140a == e0VarA && l0Var.f3141b == tVarA) ? l0Var : new l0(e0VarA, tVarA);
    }

    public final long b() {
        return this.f3140a.f3081a.a();
    }

    public final l0 c(l0 l0Var) {
        return (l0Var == null || l0Var.equals(f3139d)) ? this : new l0(this.f3140a.c(l0Var.f3140a), this.f3141b.a(l0Var.f3141b));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return yb.k.a(this.f3140a, l0Var.f3140a) && yb.k.a(this.f3141b, l0Var.f3141b) && yb.k.a(this.f3142c, l0Var.f3142c);
    }

    public final int hashCode() {
        int iHashCode = (this.f3141b.hashCode() + (this.f3140a.hashCode() * 31)) * 31;
        w wVar = this.f3142c;
        return iHashCode + (wVar != null ? wVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TextStyle(color=");
        sb2.append((Object) d1.p.j(b()));
        sb2.append(", brush=");
        e0 e0Var = this.f3140a;
        sb2.append(e0Var.f3081a.b());
        sb2.append(", alpha=");
        sb2.append(e0Var.f3081a.c());
        sb2.append(", fontSize=");
        sb2.append((Object) o2.n.e(e0Var.f3082b));
        sb2.append(", fontWeight=");
        sb2.append(e0Var.f3083c);
        sb2.append(", fontStyle=");
        sb2.append(e0Var.f3084d);
        sb2.append(", fontSynthesis=");
        sb2.append(e0Var.f3085e);
        sb2.append(", fontFamily=");
        sb2.append(e0Var.f3086f);
        sb2.append(", fontFeatureSettings=");
        sb2.append(e0Var.f3087g);
        sb2.append(", letterSpacing=");
        sb2.append((Object) o2.n.e(e0Var.f3088h));
        sb2.append(", baselineShift=");
        sb2.append(e0Var.i);
        sb2.append(", textGeometricTransform=");
        sb2.append(e0Var.f3089j);
        sb2.append(", localeList=");
        sb2.append(e0Var.f3090k);
        sb2.append(", background=");
        k0.a.z(e0Var.f3091l, sb2, ", textDecoration=");
        sb2.append(e0Var.f3092m);
        sb2.append(", shadow=");
        sb2.append(e0Var.f3093n);
        sb2.append(", drawStyle=");
        sb2.append(e0Var.f3094o);
        sb2.append(", textAlign=");
        t tVar = this.f3141b;
        sb2.append((Object) n2.k.b(tVar.f3169a));
        sb2.append(", textDirection=");
        sb2.append((Object) n2.m.a(tVar.f3170b));
        sb2.append(", lineHeight=");
        sb2.append((Object) o2.n.e(tVar.f3171c));
        sb2.append(", textIndent=");
        sb2.append(tVar.f3172d);
        sb2.append(", platformStyle=");
        sb2.append(this.f3142c);
        sb2.append(", lineHeightStyle=");
        sb2.append(tVar.f3174f);
        sb2.append(", lineBreak=");
        sb2.append((Object) n2.e.a(tVar.f3175g));
        sb2.append(", hyphens=");
        sb2.append((Object) n2.d.a(tVar.f3176h));
        sb2.append(", textMotion=");
        sb2.append(tVar.i);
        sb2.append(')');
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l0(e0 e0Var, t tVar) {
        e0Var.getClass();
        v vVar = tVar.f3173e;
        this(e0Var, tVar, vVar == null ? null : new w(vVar));
    }

    public l0(e0 e0Var, t tVar, w wVar) {
        this.f3140a = e0Var;
        this.f3141b = tVar;
        this.f3142c = wVar;
    }
}
