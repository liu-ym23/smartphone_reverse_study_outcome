package h0;

import androidx.compose.material3.MinimumInteractiveModifier;
import k0.s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p1 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0.m f5102c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d1.j0 f5103f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f5104g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f5105h;
    public final /* synthetic */ v.k i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f5106j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ xb.a f5107k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ float f5108l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ s0.c f5109m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(w0.m mVar, d1.j0 j0Var, long j10, float f5, td.h hVar, v.k kVar, boolean z10, xb.a aVar, float f10, s0.c cVar) {
        super(2);
        this.f5102c = mVar;
        this.f5103f = j0Var;
        this.f5104g = j10;
        this.f5105h = f5;
        this.i = kVar;
        this.f5106j = z10;
        this.f5107k = aVar;
        this.f5108l = f10;
        this.f5109m = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.s sVar = (k0.s) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            s2 s2Var = p0.f5101a;
            w0.m mVarD = androidx.compose.foundation.a.d(q1.c(this.f5102c.d(MinimumInteractiveModifier.f943c), this.f5103f, q1.d(this.f5104g, this.f5105h, sVar), null, ((o2.c) sVar.j(v1.a1.f14363h)).X(this.f5108l)), this.i, c1.a(sVar), this.f5106j, null, this.f5107k, 24);
            s1.f0 f0VarE = w.p.e(w0.b.f15089c, true);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarD);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(f0VarE, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            this.f5109m.invoke(sVar, 0);
            sVar.q(true);
        }
        return jb.v.f6774a;
    }
}
