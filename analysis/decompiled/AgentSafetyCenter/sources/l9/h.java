package l9;

import androidx.compose.foundation.layout.FillElement;
import java.lang.invoke.VarHandle;
import jb.v;
import k0.h1;
import k0.s;
import s1.f0;
import t.o;
import u1.z;
import w.l0;
import w.p;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements q {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ s0.c f7784c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ o2.l f7785f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ float f7786g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String f7787h;
    public /* synthetic */ xb.a i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ boolean f7788j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ h1 f7789k;

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        s0.c cVar = this.f7784c;
        o2.l lVar = this.f7785f;
        float f5 = this.f7786g;
        String str = this.f7787h;
        xb.a aVar = this.i;
        boolean z10 = this.f7788j;
        h1 h1Var = this.f7789k;
        l0 l0Var = (l0) obj;
        s sVar = (s) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        l0Var.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= sVar.f(l0Var) ? 4 : 2;
        }
        if (sVar.P(iIntValue & 1, (iIntValue & 19) != 18)) {
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            f0 f0VarE = p.e(w0.b.f15089c, false);
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
            o2.l lVar2 = o2.l.f9123c;
            cVar.invoke(new l0(lVar == lVar2 ? l0Var.b(lVar) : l0Var.c(lVar), f5, lVar == lVar2 ? l0Var.c(lVar) : l0Var.b(lVar), l0Var.a()), sVar, 0);
            w0.m mVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.a.f901a.a(w0.j.f15113c, w0.b.f15090f), 1.0f);
            Object objM = sVar.M();
            Object obj4 = objM;
            if (objM == k0.m.f6974a) {
                j jVar = new j(0);
                jVar.f7800f = h1Var;
                VarHandle.storeStoreFence();
                sVar.i0(jVar);
                obj4 = jVar;
            }
            a.f(str, aVar, mVarB, z10, (xb.l) obj4, sVar, 24576);
            sVar.q(true);
        } else {
            sVar.S();
        }
        return v.f6774a;
    }
}
