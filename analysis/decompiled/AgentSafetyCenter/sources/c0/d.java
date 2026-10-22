package c0;

import ad.y;
import d2.h0;
import d2.i0;
import d2.l0;
import d2.o;
import java.util.List;
import kb.s;
import o2.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public d2.g f2105a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f2106b;

    /* renamed from: c, reason: collision with root package name */
    public g2.d f2107c;

    /* renamed from: d, reason: collision with root package name */
    public int f2108d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2109e;

    /* renamed from: f, reason: collision with root package name */
    public int f2110f;

    /* renamed from: g, reason: collision with root package name */
    public int f2111g;

    /* renamed from: h, reason: collision with root package name */
    public List f2112h;
    public b i;

    /* renamed from: j, reason: collision with root package name */
    public long f2113j = a.f2093a;

    /* renamed from: k, reason: collision with root package name */
    public o2.c f2114k;

    /* renamed from: l, reason: collision with root package name */
    public y f2115l;

    /* renamed from: m, reason: collision with root package name */
    public l f2116m;

    /* renamed from: n, reason: collision with root package name */
    public i0 f2117n;

    public d(d2.g gVar, l0 l0Var, g2.d dVar, int i, boolean z10, int i3, int i10, List list) {
        this.f2105a = gVar;
        this.f2106b = l0Var;
        this.f2107c = dVar;
        this.f2108d = i;
        this.f2109e = z10;
        this.f2110f = i3;
        this.f2111g = i10;
        this.f2112h = list;
    }

    public final void a(o2.c cVar) {
        long jA;
        o2.c cVar2 = this.f2114k;
        if (cVar != null) {
            int i = a.f2094b;
            jA = a.a(cVar.a(), cVar.T());
        } else {
            jA = a.f2093a;
        }
        if (cVar2 == null) {
            this.f2114k = cVar;
            this.f2113j = jA;
        } else if (cVar == null || this.f2113j != jA) {
            this.f2114k = cVar;
            this.f2113j = jA;
            this.f2115l = null;
            this.f2117n = null;
        }
    }

    public final i0 b(l lVar, long j10, o oVar) {
        float fMin = Math.min(oVar.f3149a.b(), oVar.f3152d);
        d2.g gVar = this.f2105a;
        l0 l0Var = this.f2106b;
        List list = this.f2112h;
        if (list == null) {
            list = s.f7404c;
        }
        int i = this.f2110f;
        boolean z10 = this.f2109e;
        int i3 = this.f2108d;
        o2.c cVar = this.f2114k;
        cVar.getClass();
        return new i0(new h0(gVar, l0Var, list, i, z10, i3, cVar, lVar, this.f2107c, j10), oVar, o2.b.d(j10, ac.a.b(com.stepos.statsrpk.h.e(fMin), com.stepos.statsrpk.h.e(oVar.f3153e))));
    }
}
