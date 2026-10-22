package e9;

import androidx.compose.foundation.layout.FillElement;
import h0.t1;
import h0.v1;
import h0.w1;
import s8.o3;
import s8.x2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3636c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f3637f;

    public /* synthetic */ d0(int i) {
        this.f3636c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3636c) {
            case 0:
                String str = this.f3637f;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    t1.b(str, androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.b(w0.j.f15113c, 1.0f), 0.0f, 12, 1), j9.b0.f6638f, com.stepos.statsrpk.h.t(17), g2.k.f4253h, 0L, n2.k.a(3), 0L, 0, false, 0, 0, null, sVar, 200112, 0, 130512);
                } else {
                    sVar.S();
                }
                break;
            case 1:
                String str2 = this.f3637f;
                k0.s sVar2 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    t1.b(str2, androidx.compose.foundation.layout.b.g(w0.j.f15113c, 16, 6), d1.p.f3020c, com.stepos.statsrpk.h.t(14), g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, null, sVar2, 200112, 0, 131024);
                } else {
                    sVar2.S();
                }
                break;
            case 2:
                String str3 = this.f3637f;
                k0.s sVar3 = (k0.s) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                if (sVar3.P(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
                    s1.f0 f0VarE = w.p.e(w0.b.i, false);
                    int iHashCode = Long.hashCode(sVar3.T);
                    s0.g gVarL = sVar3.l();
                    w0.m mVarM = t.o.m(sVar3, fillElement);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar3.b0();
                    if (sVar3.S) {
                        sVar3.k(zVar);
                    } else {
                        sVar3.l0();
                    }
                    k0.z.B(f0VarE, sVar3, u1.i.f13836e);
                    k0.z.B(gVarL, sVar3, u1.i.f13835d);
                    u1.h hVar = u1.i.f13837f;
                    if (sVar3.S || !yb.k.a(sVar3.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar3, iHashCode, hVar);
                    }
                    k0.z.B(mVarM, sVar3, u1.i.f13834c);
                    t1.b(str3, null, d1.p.f3020c, com.stepos.statsrpk.h.t(26), g2.k.f4254j, 0L, n2.k.a(3), com.stepos.statsrpk.h.t(26), 0, false, 1, 0, null, sVar3, 200064, 3078, 121298);
                    sVar3.q(true);
                } else {
                    sVar3.S();
                }
                break;
            case 3:
                String str4 = this.f3637f;
                k0.s sVar4 = (k0.s) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                if (sVar4.P(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    t1.b(str4, androidx.compose.foundation.layout.b.g(w0.j.f15113c, 10, 5), x2.f12104e, 0L, null, 0L, null, 0L, 2, false, 1, 0, ((v1) sVar4.j(w1.f5235a)).f5224n, sVar4, 432, 3120, 55288);
                } else {
                    sVar4.S();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                o3.a(this.f3637f, (k0.s) obj, k0.z.D(1));
                break;
        }
        return jb.v.f6774a;
    }
}
