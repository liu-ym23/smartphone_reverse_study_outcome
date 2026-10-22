package s8;

import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h1 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11641c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f11642f;

    public /* synthetic */ h1(int i) {
        this.f11641c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f11641c;
        jb.v vVar = jb.v.f6774a;
        w0.j jVar = w0.j.f15113c;
        int i3 = this.f11642f;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                    break;
                } else {
                    w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 12, 10);
                    w.r0 r0VarA = w.p0.a(w.k.f14993d, w0.b.f15098o, sVar, 54);
                    int iHashCode = Long.hashCode(sVar.T);
                    s0.g gVarL = sVar.l();
                    w0.m mVarM = t.o.m(sVar, mVarG);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar.b0();
                    if (sVar.S) {
                        sVar.k(zVar);
                    } else {
                        sVar.l0();
                    }
                    k0.z.B(r0VarA, sVar, u1.i.f13836e);
                    k0.z.B(gVarL, sVar, u1.i.f13835d);
                    u1.h hVar = u1.i.f13837f;
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar, iHashCode, hVar);
                    }
                    k0.z.B(mVarM, sVar, u1.i.f13834c);
                    String strP = t2.a.p(R.string.home_contact_expand_remaining, new Object[]{Integer.valueOf(i3)}, sVar);
                    long j10 = l1.f11759b;
                    h0.t1.b(strP, null, j10, com.stepos.statsrpk.h.t(14), g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, null, sVar, 200064, 0, 131026);
                    h0.o0.b(h5.t.z(), androidx.compose.foundation.layout.c.f(jVar, 18), j10, sVar, 3504);
                    sVar.q(true);
                    break;
                }
            default:
                k0.s sVar2 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (!sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    sVar2.S();
                    break;
                } else {
                    w0.m mVarG2 = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 12, 10);
                    w.r0 r0VarA2 = w.p0.a(w.k.f14993d, w0.b.f15098o, sVar2, 54);
                    int iHashCode2 = Long.hashCode(sVar2.T);
                    s0.g gVarL2 = sVar2.l();
                    w0.m mVarM2 = t.o.m(sVar2, mVarG2);
                    u1.j.f13840e.getClass();
                    u1.z zVar2 = u1.i.f13833b;
                    sVar2.b0();
                    if (sVar2.S) {
                        sVar2.k(zVar2);
                    } else {
                        sVar2.l0();
                    }
                    k0.z.B(r0VarA2, sVar2, u1.i.f13836e);
                    k0.z.B(gVarL2, sVar2, u1.i.f13835d);
                    u1.h hVar2 = u1.i.f13837f;
                    if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                        k0.a.y(iHashCode2, sVar2, iHashCode2, hVar2);
                    }
                    k0.z.B(mVarM2, sVar2, u1.i.f13834c);
                    String strP2 = t2.a.p(R.string.home_note_expand_remaining, new Object[]{Integer.valueOf(i3)}, sVar2);
                    long j11 = i2.f11663b;
                    h0.t1.b(strP2, null, j11, com.stepos.statsrpk.h.t(14), g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, null, sVar2, 200064, 0, 131026);
                    h0.o0.b(h5.t.z(), androidx.compose.foundation.layout.c.f(jVar, 18), j11, sVar2, 3504);
                    sVar2.q(true);
                    break;
                }
                break;
        }
        return vVar;
    }
}
