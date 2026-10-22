package h0;

import androidx.compose.foundation.layout.HorizontalAlignElement;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ xb.p f4922c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.p f4923f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f4924g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f4925h;
    public final /* synthetic */ long i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ s0.c f4926j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(xb.p pVar, xb.p pVar2, long j10, long j11, long j12, long j13, s0.c cVar) {
        super(2);
        this.f4922c = pVar;
        this.f4923f = pVar2;
        this.f4924g = j11;
        this.f4925h = j12;
        this.i = j13;
        this.f4926j = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.s sVar = (k0.s) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            w0.m mVarE = androidx.compose.foundation.layout.b.e(w0.j.f15113c, m.f5063e);
            int i = 0;
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar, 0);
            int iR = k0.z.r(sVar);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarE);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(vVarA, sVar, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iR))) {
                k0.a.y(iR, sVar, iR, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar, hVar4);
            sVar.X(-1924971291);
            sVar.q(false);
            sVar.X(-1924961479);
            xb.p pVar = this.f4922c;
            if (pVar != null) {
                p5.f.c(this.f4924g, w1.a(j0.c.f6423c, sVar), s0.h.d(434448772, new b(i, pVar), sVar), sVar, 384);
            }
            sVar.q(false);
            sVar.X(-1924936431);
            int i3 = 1;
            xb.p pVar2 = this.f4923f;
            if (pVar2 != null) {
                p5.f.c(this.f4925h, w1.a(j0.c.f6425e, sVar), s0.h.d(-796843771, new b(i3, pVar2), sVar), sVar, 384);
            }
            sVar.q(false);
            w0.c cVar = w0.b.f15102s;
            HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement();
            horizontalAlignElement.f878c = cVar;
            VarHandle.storeStoreFence();
            s1.f0 f0VarE = w.p.e(w0.b.f15089c, false);
            int iR2 = k0.z.r(sVar);
            s0.g gVarL2 = sVar.l();
            w0.m mVarM2 = t.o.m(sVar, horizontalAlignElement);
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(f0VarE, sVar, hVar);
            k0.z.B(gVarL2, sVar, hVar2);
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iR2))) {
                k0.a.y(iR2, sVar, iR2, hVar3);
            }
            k0.z.B(mVarM2, sVar, hVar4);
            int i10 = j0.c.f6421a;
            p5.f.c(this.i, w1.a(10, sVar), this.f4926j, sVar, 0);
            sVar.q(true);
            sVar.q(true);
        }
        return jb.v.f6774a;
    }
}
