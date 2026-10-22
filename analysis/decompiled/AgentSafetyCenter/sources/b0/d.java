package b0;

import java.util.List;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final jb.g f1720a;

    static {
        kb.s sVar = kb.s.f7404c;
        f1720a = new jb.g(sVar, sVar);
    }

    public static final void a(d2.g gVar, List list, k0.s sVar, int i) {
        sVar.Z(-1794596951);
        int i3 = (i & 6) == 0 ? (sVar.f(gVar) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= sVar.h(list) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && sVar.B()) {
            sVar.S();
        } else {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                d2.e eVar = (d2.e) list.get(i10);
                xb.q qVar = (xb.q) eVar.f3077a;
                int i11 = eVar.f3078b;
                int i12 = eVar.f3079c;
                b bVar = b.f1713b;
                int iHashCode = Long.hashCode(sVar.T);
                s0.g gVarL = sVar.l();
                w0.m mVarM = t.o.m(sVar, w0.j.f15113c);
                u1.j.f13840e.getClass();
                u1.z zVar = u1.i.f13833b;
                sVar.b0();
                if (sVar.S) {
                    sVar.k(zVar);
                } else {
                    sVar.l0();
                }
                k0.z.B(bVar, sVar, u1.i.f13836e);
                k0.z.B(gVarL, sVar, u1.i.f13835d);
                u1.h hVar = u1.i.f13837f;
                if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                    k0.a.y(iHashCode, sVar, iHashCode, hVar);
                }
                k0.z.B(mVarM, sVar, u1.i.f13834c);
                qVar.invoke(gVar.subSequence(i11, i12).f3101f, sVar, 0);
                sVar.q(true);
            }
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new c(gVar, i, 0, list);
        }
    }
}
