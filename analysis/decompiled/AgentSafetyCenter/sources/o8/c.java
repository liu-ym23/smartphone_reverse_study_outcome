package o8;

import androidx.compose.foundation.layout.FillElement;
import h0.t1;
import h0.v1;
import h0.w1;
import jb.v;
import k0.s;
import s1.f0;
import s8.i3;
import t.o;
import u1.z;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9300c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f9301f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long f9302g;

    public /* synthetic */ c(int i) {
        this.f9300c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f9300c) {
            case 0:
                String str = this.f9301f;
                long j10 = this.f9302g;
                s sVar = (s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
                    f0 f0VarE = w.p.e(w0.b.i, false);
                    int iHashCode = Long.hashCode(sVar.T);
                    s0.g gVarL = sVar.l();
                    w0.m mVarM = o.m(sVar, fillElement);
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
                    u1.h hVar = u1.i.f13837f;
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar, iHashCode, hVar);
                    }
                    k0.z.B(mVarM, sVar, u1.i.f13834c);
                    t1.b(str, null, j10, 0L, g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, ((v1) sVar.j(w1.f5235a)).f5220j, sVar, 196608, 0, 65498);
                    sVar.q(true);
                } else {
                    sVar.S();
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                i3.a(this.f9301f, this.f9302g, (s) obj, k0.z.D(49));
                break;
            default:
                String str2 = this.f9301f;
                long j11 = this.f9302g;
                s sVar2 = (s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    t1.b(str2, androidx.compose.foundation.layout.b.g(w0.j.f15113c, 8, 4), j11, 0L, g2.k.f4253h, 0L, null, 0L, 2, false, 1, 0, ((v1) sVar2.j(w1.f5235a)).f5225o, sVar2, 196656, 3120, 55256);
                } else {
                    sVar2.S();
                }
                break;
        }
        return v.f6774a;
    }
}
