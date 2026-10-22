package o8;

import d1.f0;
import java.lang.invoke.VarHandle;
import jb.v;
import k0.s;
import t.o;
import u1.z;
import w.c1;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9289c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ i f9290f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ xb.a f9291g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ xb.a f9292h;

    public /* synthetic */ a(int i) {
        this.f9289c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f9289c;
        v vVar = v.f6774a;
        switch (i) {
            case 0:
                i iVar = this.f9290f;
                xb.a aVar = this.f9291g;
                xb.a aVar2 = this.f9292h;
                s sVar = (s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                    break;
                } else {
                    w0.m mVarB = androidx.compose.foundation.a.b(androidx.compose.foundation.layout.c.f904c, iVar instanceof h ? d1.p.f3023f : e.f9307a, f0.f2972a);
                    c1 c1Var = new c1(3, 1);
                    w0.h hVar = new w0.h();
                    hVar.f15111f = c1Var;
                    VarHandle.storeStoreFence();
                    w0.m mVarL = t2.a.l(mVarB.d(hVar));
                    s1.f0 f0VarE = w.p.e(w0.b.f15089c, false);
                    int iHashCode = Long.hashCode(sVar.T);
                    s0.g gVarL = sVar.l();
                    w0.m mVarM = o.m(sVar, mVarL);
                    u1.j.f13840e.getClass();
                    z zVar = u1.i.f13833b;
                    sVar.b0();
                    if (sVar.S) {
                        sVar.k(zVar);
                    } else {
                        sVar.l0();
                    }
                    k0.z.B(f0VarE, sVar, u1.i.f13836e);
                    k0.z.B(gVarL, sVar, u1.i.f13835d);
                    u1.h hVar2 = u1.i.f13837f;
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar, iHashCode, hVar2);
                    }
                    k0.z.B(mVarM, sVar, u1.i.f13834c);
                    if (!yb.k.a(iVar, h.f9314a)) {
                        if (!(iVar instanceof f)) {
                            if (!yb.k.a(iVar, g.f9313a)) {
                                sVar.X(-1941770098);
                                sVar.q(false);
                                g5.f.a();
                                break;
                            } else {
                                sVar.X(-1941759882);
                                e.b(aVar2, aVar, sVar, 0);
                                sVar.q(false);
                            }
                        } else {
                            sVar.X(-1941766427);
                            e.a(((f) iVar).f9312a, aVar, sVar, 0);
                            sVar.q(false);
                        }
                    } else {
                        sVar.X(-1941768565);
                        sVar.q(false);
                    }
                    sVar.q(true);
                    break;
                }
                break;
            default:
                ((Integer) obj2).getClass();
                e.c(this.f9290f, this.f9291g, this.f9292h, (s) obj, k0.z.D(1));
                break;
        }
        return vVar;
    }
}
