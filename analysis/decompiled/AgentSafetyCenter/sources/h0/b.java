package h0;

import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4917c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.p f4918f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, xb.p pVar) {
        super(2);
        this.f4917c = i;
        this.f4918f = pVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f4917c;
        jb.v vVar = jb.v.f6774a;
        xb.p pVar = this.f4918f;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
                    sVar.S();
                } else {
                    w0.m mVarE = androidx.compose.foundation.layout.b.e(w0.j.f15113c, m.f5064f);
                    w0.c cVar = w0.b.f15100q;
                    HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement();
                    horizontalAlignElement.f878c = cVar;
                    VarHandle.storeStoreFence();
                    w0.m mVarD = mVarE.d(horizontalAlignElement);
                    s1.f0 f0VarE = w.p.e(w0.b.f15089c, false);
                    int iR = k0.z.r(sVar);
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
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iR))) {
                        k0.a.y(iR, sVar, iR, hVar);
                    }
                    k0.z.B(mVarM, sVar, u1.i.f13834c);
                    pVar.invoke(sVar, 0);
                    sVar.q(true);
                }
                return vVar;
            case 1:
                k0.s sVar2 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar2.B()) {
                    sVar2.S();
                    return vVar;
                }
                if (1.0f <= 0.0d) {
                    g5.f.s("invalid weight 1.0; must be greater than zero");
                    return null;
                }
                w0.m mVarE2 = androidx.compose.foundation.layout.b.e(new LayoutWeightElement(1.0f, false), m.f5065g);
                w0.c cVar2 = w0.b.f15100q;
                HorizontalAlignElement horizontalAlignElement2 = new HorizontalAlignElement();
                horizontalAlignElement2.f878c = cVar2;
                VarHandle.storeStoreFence();
                w0.m mVarD2 = mVarE2.d(horizontalAlignElement2);
                s1.f0 f0VarE2 = w.p.e(w0.b.f15089c, false);
                int iR2 = k0.z.r(sVar2);
                s0.g gVarL2 = sVar2.l();
                w0.m mVarM2 = t.o.m(sVar2, mVarD2);
                u1.j.f13840e.getClass();
                u1.z zVar2 = u1.i.f13833b;
                sVar2.b0();
                if (sVar2.S) {
                    sVar2.k(zVar2);
                } else {
                    sVar2.l0();
                }
                k0.z.B(f0VarE2, sVar2, u1.i.f13836e);
                k0.z.B(gVarL2, sVar2, u1.i.f13835d);
                u1.h hVar2 = u1.i.f13837f;
                if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iR2))) {
                    k0.a.y(iR2, sVar2, iR2, hVar2);
                }
                k0.z.B(mVarM2, sVar2, u1.i.f13834c);
                pVar.invoke(sVar2, 0);
                sVar2.q(true);
                return vVar;
            default:
                k0.s sVar3 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar3.B()) {
                    sVar3.S();
                } else {
                    pVar.invoke(sVar3, 0);
                }
                return vVar;
        }
    }
}
