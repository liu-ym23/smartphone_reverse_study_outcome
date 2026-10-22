package d2;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public final n2.o f3081a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3082b;

    /* renamed from: c, reason: collision with root package name */
    public final g2.k f3083c;

    /* renamed from: d, reason: collision with root package name */
    public final g2.i f3084d;

    /* renamed from: e, reason: collision with root package name */
    public final g2.j f3085e;

    /* renamed from: f, reason: collision with root package name */
    public final g2.q f3086f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3087g;

    /* renamed from: h, reason: collision with root package name */
    public final long f3088h;
    public final n2.a i;

    /* renamed from: j, reason: collision with root package name */
    public final n2.p f3089j;

    /* renamed from: k, reason: collision with root package name */
    public final j2.b f3090k;

    /* renamed from: l, reason: collision with root package name */
    public final long f3091l;

    /* renamed from: m, reason: collision with root package name */
    public final n2.l f3092m;

    /* renamed from: n, reason: collision with root package name */
    public final d1.i0 f3093n;

    /* renamed from: o, reason: collision with root package name */
    public final td.h f3094o;

    public e0(long j10, long j11, g2.k kVar, g2.i iVar, g2.j jVar, g2.q qVar, String str, long j12, n2.a aVar, n2.p pVar, j2.b bVar, long j13, n2.l lVar, d1.i0 i0Var, int i) {
        this((i & 1) != 0 ? d1.p.f3024g : j10, (i & 2) != 0 ? o2.n.f9128c : j11, (i & 4) != 0 ? null : kVar, (i & 8) != 0 ? null : iVar, (i & 16) != 0 ? null : jVar, (i & 32) != 0 ? null : qVar, (i & 64) != 0 ? null : str, (i & 128) != 0 ? o2.n.f9128c : j12, (i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? null : aVar, (i & 512) != 0 ? null : pVar, (i & 1024) != 0 ? null : bVar, (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? d1.p.f3024g : j13, (i & 4096) != 0 ? null : lVar, (i & 8192) != 0 ? null : i0Var);
    }

    public final boolean a(e0 e0Var) {
        if (this == e0Var) {
            return true;
        }
        return o2.n.b(this.f3082b, e0Var.f3082b) && yb.k.a(this.f3083c, e0Var.f3083c) && yb.k.a(this.f3084d, e0Var.f3084d) && yb.k.a(this.f3085e, e0Var.f3085e) && yb.k.a(this.f3086f, e0Var.f3086f) && yb.k.a(this.f3087g, e0Var.f3087g) && o2.n.b(this.f3088h, e0Var.f3088h) && yb.k.a(this.i, e0Var.i) && yb.k.a(this.f3089j, e0Var.f3089j) && yb.k.a(this.f3090k, e0Var.f3090k) && d1.p.d(this.f3091l, e0Var.f3091l);
    }

    public final boolean b(e0 e0Var) {
        return yb.k.a(this.f3081a, e0Var.f3081a) && yb.k.a(this.f3092m, e0Var.f3092m) && yb.k.a(this.f3093n, e0Var.f3093n) && yb.k.a(this.f3094o, e0Var.f3094o);
    }

    public final e0 c(e0 e0Var) {
        if (e0Var == null) {
            return this;
        }
        n2.o oVar = e0Var.f3081a;
        return f0.a(this, oVar.a(), oVar.b(), oVar.c(), e0Var.f3082b, e0Var.f3083c, e0Var.f3084d, e0Var.f3085e, e0Var.f3086f, e0Var.f3087g, e0Var.f3088h, e0Var.i, e0Var.f3089j, e0Var.f3090k, e0Var.f3091l, e0Var.f3092m, e0Var.f3093n, e0Var.f3094o);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return a(e0Var) && b(e0Var);
    }

    public final int hashCode() {
        n2.o oVar = this.f3081a;
        long jA = oVar.a();
        int i = d1.p.f3025h;
        int iHashCode = Long.hashCode(jA) * 31;
        d1.f0 f0VarB = oVar.b();
        int iHashCode2 = (Float.hashCode(oVar.c()) + ((iHashCode + (f0VarB != null ? f0VarB.hashCode() : 0)) * 31)) * 31;
        o2.o[] oVarArr = o2.n.f9127b;
        int i3 = k0.a.i(this.f3082b, iHashCode2, 31);
        g2.k kVar = this.f3083c;
        int i10 = (i3 + (kVar != null ? kVar.f4256c : 0)) * 31;
        g2.i iVar = this.f3084d;
        int iHashCode3 = (i10 + (iVar != null ? Integer.hashCode(iVar.f4249a) : 0)) * 31;
        g2.j jVar = this.f3085e;
        int iHashCode4 = (iHashCode3 + (jVar != null ? Integer.hashCode(jVar.f4250a) : 0)) * 31;
        g2.q qVar = this.f3086f;
        int iHashCode5 = (iHashCode4 + (qVar != null ? qVar.hashCode() : 0)) * 31;
        String str = this.f3087g;
        int i11 = k0.a.i(this.f3088h, (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31, 31);
        n2.a aVar = this.i;
        int iHashCode6 = (i11 + (aVar != null ? Float.hashCode(aVar.f8644a) : 0)) * 31;
        n2.p pVar = this.f3089j;
        int iHashCode7 = (iHashCode6 + (pVar != null ? pVar.hashCode() : 0)) * 31;
        j2.b bVar = this.f3090k;
        int i12 = k0.a.i(this.f3091l, (iHashCode7 + (bVar != null ? bVar.f6545c.hashCode() : 0)) * 31, 31);
        n2.l lVar = this.f3092m;
        int i13 = (i12 + (lVar != null ? lVar.f8665a : 0)) * 31;
        d1.i0 i0Var = this.f3093n;
        int iHashCode8 = (i13 + (i0Var != null ? i0Var.hashCode() : 0)) * 961;
        td.h hVar = this.f3094o;
        return iHashCode8 + (hVar != null ? hVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SpanStyle(color=");
        n2.o oVar = this.f3081a;
        sb2.append((Object) d1.p.j(oVar.a()));
        sb2.append(", brush=");
        sb2.append(oVar.b());
        sb2.append(", alpha=");
        sb2.append(oVar.c());
        sb2.append(", fontSize=");
        sb2.append((Object) o2.n.e(this.f3082b));
        sb2.append(", fontWeight=");
        sb2.append(this.f3083c);
        sb2.append(", fontStyle=");
        sb2.append(this.f3084d);
        sb2.append(", fontSynthesis=");
        sb2.append(this.f3085e);
        sb2.append(", fontFamily=");
        sb2.append(this.f3086f);
        sb2.append(", fontFeatureSettings=");
        sb2.append(this.f3087g);
        sb2.append(", letterSpacing=");
        sb2.append((Object) o2.n.e(this.f3088h));
        sb2.append(", baselineShift=");
        sb2.append(this.i);
        sb2.append(", textGeometricTransform=");
        sb2.append(this.f3089j);
        sb2.append(", localeList=");
        sb2.append(this.f3090k);
        sb2.append(", background=");
        k0.a.z(this.f3091l, sb2, ", textDecoration=");
        sb2.append(this.f3092m);
        sb2.append(", shadow=");
        sb2.append(this.f3093n);
        sb2.append(", platformStyle=null, drawStyle=");
        sb2.append(this.f3094o);
        sb2.append(')');
        return sb2.toString();
    }

    public e0(n2.o oVar, long j10, g2.k kVar, g2.i iVar, g2.j jVar, g2.q qVar, String str, long j11, n2.a aVar, n2.p pVar, j2.b bVar, long j12, n2.l lVar, d1.i0 i0Var, td.h hVar) {
        this.f3081a = oVar;
        this.f3082b = j10;
        this.f3083c = kVar;
        this.f3084d = iVar;
        this.f3085e = jVar;
        this.f3086f = qVar;
        this.f3087g = str;
        this.f3088h = j11;
        this.i = aVar;
        this.f3089j = pVar;
        this.f3090k = bVar;
        this.f3091l = j12;
        this.f3092m = lVar;
        this.f3093n = i0Var;
        this.f3094o = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(long j10, long j11, g2.k kVar, g2.i iVar, g2.j jVar, g2.q qVar, String str, long j12, n2.a aVar, n2.p pVar, j2.b bVar, long j13, n2.l lVar, d1.i0 i0Var) {
        n2.n nVar;
        if (j10 != 16) {
            n2.c cVar = new n2.c();
            cVar.f8647a = j10;
            if (j10 == 16) {
                i2.a.a("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
            }
            VarHandle.storeStoreFence();
            nVar = cVar;
        } else {
            nVar = n2.n.f8667a;
        }
        this(nVar, j11, kVar, iVar, jVar, qVar, str, j12, aVar, pVar, bVar, j13, lVar, i0Var, (td.h) null);
    }
}
