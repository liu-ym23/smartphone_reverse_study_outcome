package h0;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5036c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5037f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5038g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(s0.c cVar, w.t tVar) {
        super(2);
        this.f5036c = 8;
        this.f5037f = cVar;
        this.f5038g = tVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        int i = this.f5036c;
        k0.y0 y0Var = k0.m.f6974a;
        jb.v vVar = jb.v.f6774a;
        Object obj3 = this.f5038g;
        Object obj4 = this.f5037f;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar.B()) {
                    sVar.j(AndroidCompositionLocals_androidKt.f981a);
                    String string = ((Context) sVar.j(AndroidCompositionLocals_androidKt.f982b)).getResources().getString(R.string.m3c_dialog);
                    float f5 = m.f5059a;
                    w0.m mVarG = androidx.compose.foundation.layout.c.g((w0.m) obj3);
                    boolean zF = sVar.f(string);
                    Object objM = sVar.M();
                    Object obj5 = objM;
                    if (zF || objM == y0Var) {
                        a2.n nVar = new a2.n(string, true ? 1 : 0);
                        sVar.i0(nVar);
                        obj5 = nVar;
                    }
                    w0.m mVarD = mVarG.d(a2.l.a(w0.j.f15113c, false, (xb.l) obj5));
                    s0.c cVar = (s0.c) obj4;
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
                    cVar.invoke(sVar, 0);
                    sVar.q(true);
                    break;
                } else {
                    sVar.S();
                    break;
                }
                break;
            case 1:
                k0.s sVar2 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar2.B()) {
                    w0.m mVarE = androidx.compose.foundation.layout.b.e(androidx.compose.foundation.layout.c.a(p.f5099b, p.f5100c), (w.l0) obj3);
                    s0.c cVar2 = (s0.c) obj4;
                    w.r0 r0VarA = w.p0.a(w.k.f14993d, w0.b.f15098o, sVar2, 54);
                    int iR = k0.z.r(sVar2);
                    s0.g gVarL2 = sVar2.l();
                    w0.m mVarM2 = t.o.m(sVar2, mVarE);
                    u1.j.f13840e.getClass();
                    u1.z zVar2 = u1.i.f13833b;
                    sVar2.b0();
                    if (sVar2.S) {
                        sVar2.k(zVar2);
                    } else {
                        sVar2.l0();
                    }
                    k0.z.B(r0VarA, sVar2, u1.i.f13836e);
                    k0.z.B(gVarL2, sVar2, u1.i.f13835d);
                    u1.h hVar2 = u1.i.f13837f;
                    if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iR))) {
                        k0.a.y(iR, sVar2, iR, hVar2);
                    }
                    k0.z.B(mVarM2, sVar2, u1.i.f13834c);
                    cVar2.invoke(w.s0.f15044a, sVar2, 6);
                    sVar2.q(true);
                    break;
                } else {
                    sVar2.S();
                    break;
                }
                break;
            case 2:
                k0.s sVar3 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar3.B()) {
                    t1.a(((v1) obj3).f5220j, (s0.c) obj4, sVar3, 0);
                    break;
                } else {
                    sVar3.S();
                    break;
                }
                break;
            case 3:
                ((Number) obj2).intValue();
                t1.a((d2.l0) obj3, (s0.c) obj4, (k0.s) obj, k0.z.D(1));
                break;
            case 4:
                k0.s sVar4 = (k0.s) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!sVar4.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar4.S();
                    break;
                } else {
                    Boolean bool = (Boolean) ((s1.u) obj3).f11304f.getValue();
                    boolean zBooleanValue = bool.booleanValue();
                    xb.p pVar = (xb.p) obj4;
                    sVar4.a0(bool);
                    boolean zG = sVar4.g(zBooleanValue);
                    if (zBooleanValue) {
                        pVar.invoke(sVar4, 0);
                    } else {
                        sVar4.n(zG);
                    }
                    sVar4.t();
                    break;
                }
            case 5:
                long j10 = ((c1.b) obj2).f2165a;
                id.c.d((b8.p) obj3, (o1.s) obj);
                mc.e eVar = ((u.t0) obj4).f13590y;
                if (eVar != null) {
                    u.n nVar2 = new u.n();
                    nVar2.f13530a = j10;
                    VarHandle.storeStoreFence();
                    mc.l.a(eVar.h(nVar2));
                    break;
                }
                break;
            case 6:
                d1.o oVar = (d1.o) obj;
                g1.b bVar = (g1.b) obj2;
                u1.g1 g1Var = (u1.g1) obj3;
                u1.g0 g0Var = g1Var.f13810s;
                if (!g0Var.H()) {
                    g1Var.L = true;
                    break;
                } else {
                    g1Var.I = oVar;
                    g1Var.H = bVar;
                    u1.p1 snapshotObserver = ((v1.t) u1.j0.a(g0Var)).getSnapshotObserver();
                    d1.g0 g0Var2 = u1.g1.N;
                    snapshotObserver.a(g1Var, u1.e.f13755h, (u1.d1) obj4);
                    g1Var.L = false;
                    break;
                }
            case 7:
                ((Number) obj2).intValue();
                AndroidCompositionLocals_androidKt.a((v1.t) obj3, (xb.p) obj4, (k0.s) obj, k0.z.D(1));
                break;
            case 8:
                k0.s sVar5 = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !sVar5.B()) {
                    ((s0.c) obj4).invoke((w.t) obj3, sVar5, 0);
                    break;
                } else {
                    sVar5.S();
                    break;
                }
                break;
            case 9:
                s1.z0 z0Var = (s1.z0) obj;
                long j11 = ((o2.a) obj2).f9108a;
                w.t tVar = new w.t();
                tVar.f15045a = z0Var;
                tVar.f15046b = j11;
                tVar.f15047c = androidx.compose.foundation.layout.a.f901a;
                VarHandle.storeStoreFence();
                break;
            case 10:
                k0.s sVar6 = (k0.s) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                y.u uVar = (y.u) obj3;
                y.t tVar2 = (y.t) obj4;
                Object obj6 = tVar2.f15820a;
                if ((iIntValue2 & 3) != 2 || !sVar6.B()) {
                    x.h hVar3 = (x.h) uVar.f15826b.invoke();
                    int iB = tVar2.f15822c;
                    if ((iB >= hVar3.c() || !hVar3.d(iB).equals(obj6)) && (iB = hVar3.f15415d.b(obj6)) != -1) {
                        tVar2.f15822c = iB;
                    }
                    int i3 = iB;
                    boolean z10 = i3 != -1;
                    sVar6.a0(Boolean.valueOf(z10));
                    boolean zG2 = sVar6.g(z10);
                    sVar6.X(-869707859);
                    if (z10) {
                        sVar6.X(-2120167269);
                        t.n.c(hVar3, uVar.f15825a, i3, obj6, sVar6, 0);
                        sVar6.q(false);
                    } else {
                        sVar6.n(zG2);
                    }
                    sVar6.q(false);
                    sVar6.t();
                    boolean zH = sVar6.h(tVar2);
                    Object objM2 = sVar6.M();
                    Object obj7 = objM2;
                    if (zH || objM2 == y0Var) {
                        a2.m mVar = new a2.m(tVar2, 29);
                        sVar6.i0(mVar);
                        obj7 = mVar;
                    }
                    k0.z.d(obj6, (xb.l) obj7, sVar6);
                    break;
                } else {
                    sVar6.S();
                    break;
                }
                break;
            case 11:
                long j12 = ((o2.a) obj2).f9108a;
                y.u uVar2 = (y.u) obj3;
                y.x xVar = new y.x();
                xVar.f15833c = uVar2;
                xVar.f15834f = (s1.z0) obj;
                xVar.f15835g = (x.h) uVar2.f15826b.invoke();
                xVar.f15836h = new HashMap();
                VarHandle.storeStoreFence();
                break;
            case 12:
                k0.s sVar7 = (k0.s) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                y.l0 l0Var = (y.l0) obj3;
                if ((iIntValue3 & 3) != 2 || !sVar7.B()) {
                    sVar7.X(1967008021);
                    Object[] objArr = new Object[0];
                    p5.u uVar3 = t0.e.i;
                    Object objM3 = sVar7.M();
                    if (objM3 == y0Var) {
                        objM3 = new androidx.room.c(18);
                        sVar7.i0(objM3);
                    }
                    t0.e eVar2 = (t0.e) t0.a.j(Arrays.copyOf(objArr, 0), uVar3, (xb.a) objM3, sVar7, 3456, 0);
                    eVar2.f13115g = (t0.g) sVar7.j(t0.i.f13120a);
                    sVar7.q(false);
                    l0Var.f15786f.setValue(eVar2);
                    ((s0.c) obj4).invoke(l0Var, sVar7, 0);
                    break;
                } else {
                    sVar7.S();
                    break;
                }
                break;
            default:
                int iIntValue4 = ((Number) obj).intValue();
                a2.p pVar2 = (a2.p) obj2;
                y0.d dVar = (y0.d) obj4;
                if (!((v1.o1) obj3).f14520b.b(pVar2.f91g)) {
                    dVar.l(iIntValue4, pVar2);
                    dVar.f15860l.h(vVar);
                    break;
                }
                break;
        }
        return vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(Object obj, xb.p pVar, int i, int i3) {
        super(2);
        this.f5036c = i3;
        this.f5038g = obj;
        this.f5037f = pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i, Object obj, Object obj2) {
        super(2);
        this.f5036c = i;
        this.f5038g = obj;
        this.f5037f = obj2;
    }
}
