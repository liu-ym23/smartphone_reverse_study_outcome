package j9;

import android.content.Context;
import com.stepos.agentsafetycenter.R;
import d1.e0;
import d1.f0;
import h0.b1;
import h0.t1;
import i9.d0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k0.c1;
import k0.y0;
import w.p0;
import w.r0;
import w.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ c1 f6677c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ xb.a f6678f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Context f6679g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ c1 f6680h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13, types: [e9.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r9v1, types: [k0.s] */
    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        w0.j jVar;
        boolean z10;
        c1 c1Var;
        c1 c1Var2 = this.f6677c;
        xb.a aVar = this.f6678f;
        Context context = this.f6679g;
        c1 c1Var3 = this.f6680h;
        ?? r92 = (k0.s) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((x.b) obj).getClass();
        if (r92.P(iIntValue & 1, (iIntValue & 17) != 16)) {
            b0.e(t2.a.o(R.string.screen_perception_section_blacklist, r92), null, r92, 0);
            boolean zIsEmpty = ((d0) c1Var2.getValue()).f5853d.isEmpty();
            e0 e0Var = f0.f2972a;
            w0.j jVar2 = w0.j.f15113c;
            if (zIsEmpty) {
                r92.X(2027039923);
                float f5 = 16;
                w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), a0.e.a(12)), b0.f6634b, e0Var), f5, 28);
                w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15101r, r92, 48);
                int iHashCode = Long.hashCode(r92.T);
                s0.g gVarL = r92.l();
                w0.m mVarM = t.o.m(r92, mVarG);
                u1.j.f13840e.getClass();
                u1.z zVar = u1.i.f13833b;
                r92.b0();
                if (r92.S) {
                    r92.k(zVar);
                } else {
                    r92.l0();
                }
                k0.z.B(vVarA, r92, u1.i.f13836e);
                k0.z.B(gVarL, r92, u1.i.f13835d);
                u1.h hVar = u1.i.f13837f;
                if (r92.S || !yb.k.a(r92.M(), Integer.valueOf(iHashCode))) {
                    k0.a.y(iHashCode, r92, iHashCode, hVar);
                }
                k0.z.B(mVarM, r92, u1.i.f13834c);
                t1.b(t2.a.o(R.string.screen_perception_blacklist_empty, r92), null, b0.f6636d, com.stepos.statsrpk.h.t(15), null, 0L, n2.k.a(3), 0L, 0, false, 0, 0, null, r92, 3456, 0, 130546);
                t0.a.b(r92, androidx.compose.foundation.layout.c.c(jVar2, f5));
                b0.a(t2.a.o(R.string.screen_perception_add_apps, r92), aVar, null, r92, 0);
                r92.q(true);
                r92.q(false);
            } else {
                r92.X(2028295113);
                float f10 = 12;
                w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), a0.e.a(f10)), b0.f6634b, e0Var);
                w.v vVarA2 = w.u.a(w.k.f14992c, w0.b.f15100q, r92, 0);
                int iHashCode2 = Long.hashCode(r92.T);
                s0.g gVarL2 = r92.l();
                w0.m mVarM2 = t.o.m(r92, mVarB);
                u1.j.f13840e.getClass();
                u1.z zVar2 = u1.i.f13833b;
                r92.b0();
                if (r92.S) {
                    r92.k(zVar2);
                } else {
                    r92.l0();
                }
                u1.h hVar2 = u1.i.f13836e;
                k0.z.B(vVarA2, r92, hVar2);
                u1.h hVar3 = u1.i.f13835d;
                k0.z.B(gVarL2, r92, hVar3);
                u1.h hVar4 = u1.i.f13837f;
                if (r92.S || !yb.k.a(r92.M(), Integer.valueOf(iHashCode2))) {
                    k0.a.y(iHashCode2, r92, iHashCode2, hVar4);
                }
                u1.h hVar5 = u1.i.f13834c;
                k0.z.B(mVarM2, r92, hVar5);
                float f11 = 16;
                w0.m mVarI = androidx.compose.foundation.layout.b.i(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), f11, 14, f10, 8);
                r0 r0VarA = p0.a(w.k.f14990a, w0.b.f15098o, r92, 48);
                int iHashCode3 = Long.hashCode(r92.T);
                s0.g gVarL3 = r92.l();
                w0.m mVarM3 = t.o.m(r92, mVarI);
                r92.b0();
                if (r92.S) {
                    r92.k(zVar2);
                } else {
                    r92.l0();
                }
                k0.z.B(r0VarA, r92, hVar2);
                k0.z.B(gVarL3, r92, hVar3);
                if (r92.S || !yb.k.a(r92.M(), Integer.valueOf(iHashCode3))) {
                    k0.a.y(iHashCode3, r92, iHashCode3, hVar4);
                }
                k0.z.B(mVarM3, r92, hVar5);
                c1 c1Var4 = c1Var3;
                w0.j jVar3 = jVar2;
                t1.b(t2.a.p(R.string.screen_perception_blacklist_count, new Object[]{Integer.valueOf(((d0) c1Var2.getValue()).f5853d.size())}, r92), s0.a(), b0.f6636d, com.stepos.statsrpk.h.t(14), null, 0L, null, 0L, 0, false, 0, 0, null, r92, 3456, 0, 131056);
                b0.a(t2.a.o(R.string.screen_perception_add_apps, r92), aVar, null, r92, 0);
                r92.q(true);
                boolean zF = r92.f(((d0) c1Var2.getValue()).f5853d);
                Object objM = r92.M();
                y0 y0Var = k0.m.f6974a;
                Object obj4 = objM;
                if (zF || objM == y0Var) {
                    Set<String> set = ((d0) c1Var2.getValue()).f5853d;
                    ArrayList arrayList = new ArrayList(kb.m.m0(set, 10));
                    for (String str : set) {
                        arrayList.add(new jb.g(str, (String) td.h.F(context, str).f6759c));
                    }
                    i9.e eVar = new i9.e(2, i9.a.f5826a, i9.a.class, "compareLabels", "compareLabels(Ljava/lang/String;Ljava/lang/String;)I", 0, 0, 2);
                    a2.y yVar = new a2.y(3);
                    yVar.f149f = eVar;
                    VarHandle.storeStoreFence();
                    a2.a0 a0Var = new a2.a0(3);
                    a0Var.f32f = yVar;
                    VarHandle.storeStoreFence();
                    List listI0 = kb.l.I0(arrayList, a0Var);
                    ArrayList arrayList2 = new ArrayList(kb.m.m0(listI0, 10));
                    Iterator it = listI0.iterator();
                    while (it.hasNext()) {
                        arrayList2.add((String) ((jb.g) it.next()).f6759c);
                    }
                    r92.i0(arrayList2);
                    obj4 = arrayList2;
                }
                r92.X(-1326750523);
                int i = 0;
                for (Object obj5 : (List) obj4) {
                    int i3 = i + 1;
                    if (i < 0) {
                        ac.a.a0();
                        throw null;
                    }
                    String str2 = (String) obj5;
                    if (i > 0) {
                        r92.X(1478085845);
                        jVar = jVar3;
                        b1.d(androidx.compose.foundation.layout.b.h(jVar, f11, 0.0f, 2), 0.0f, f0.c(4281084974L), r92, 390, 2);
                        z10 = false;
                    } else {
                        jVar = jVar3;
                        z10 = false;
                        r92.X(1465838117);
                    }
                    r92.q(z10);
                    boolean zF2 = r92.f(str2);
                    ?? M = r92.M();
                    if (zF2 || M == y0Var) {
                        M = new e9.j(3);
                        M.f3667g = str2;
                        c1Var = c1Var4;
                        M.f3666f = c1Var;
                        VarHandle.storeStoreFence();
                        r92.i0(M);
                    } else {
                        c1Var = c1Var4;
                    }
                    a.a(str2, (xb.a) M, r92, 0);
                    c1Var4 = c1Var;
                    i = i3;
                    jVar3 = jVar;
                }
                r92.q(false);
                t0.a.b(r92, androidx.compose.foundation.layout.c.c(jVar3, 4));
                r92.q(true);
                r92.q(false);
            }
        } else {
            r92.S();
        }
        return jb.v.f6774a;
    }
}
