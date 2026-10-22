package s8;

import androidx.compose.foundation.layout.FillElement;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ List f11781c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f11782f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f11783g;

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        List list = this.f11781c;
        int i = this.f11782f;
        boolean z10 = this.f11783g;
        k0.s sVar = (k0.s) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
            w0.e eVar = w0.b.i;
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            s1.f0 f0VarE = w.p.e(eVar, false);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, fillElement);
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
            String str = (String) list.get(i);
            d2.l0 l0Var = ((h0.v1) sVar.j(h0.w1.f5235a)).f5223m;
            h0.t1.b(str, null, z10 ? d1.p.f3020c : s.f11934d, 0L, z10 ? g2.k.i : g2.k.f4252g, 0L, n2.k.a(3), 0L, 0, false, 1, 0, l0Var, sVar, 0, 3072, 56794);
            sVar.q(true);
        } else {
            sVar.S();
        }
        return jb.v.f6774a;
    }
}
