package w5;

import b0.t1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r.g0;
import r.i0;
import y.k0;

/* loaded from: classes.dex */
public final class y implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f10776f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List f10777g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f10778h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f10779i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f10780j;

    public y(String str, List list, boolean z4, boolean z10, e eVar) {
        this.f10776f = str;
        this.f10777g = list;
        this.f10778h = z4;
        this.f10779i = z10;
        this.f10780j = eVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        float f10;
        n0.d dVar;
        boolean z4;
        boolean z10;
        n0.j jVar;
        Object next;
        boolean z11;
        Object next2;
        Map map;
        Object obj3;
        b0.p pVar = (b0.p) obj;
        int iIntValue = ((Number) obj2).intValue();
        n0.d dVar2 = n0.b.f6782p;
        if ((iIntValue & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            float f11 = 16;
            n0.m mVarD = androidx.compose.foundation.layout.a.d(androidx.compose.foundation.layout.a.f744a, f11);
            r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6784r, pVar, 0);
            int iK = b0.b.k(pVar);
            t1 t1VarL = pVar.l();
            n0.m mVarV = a.a.V(pVar, mVarD);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, rVarA, i1.g.f4477e);
            b0.b.q(pVar, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
                a1.a.r(iK, pVar, iK, fVar);
            }
            b0.b.q(pVar, mVarV, i1.g.f4475c);
            pVar.S(737293842);
            String str = this.f10776f;
            int length = str.length();
            n0.j jVar2 = n0.j.f6796a;
            if (length > 0) {
                Iterator it = this.f10777g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    if (q7.k.a(((a) next2).f10660a, "TOKEN_ACCOUNT")) {
                        break;
                    }
                }
                a aVar = (a) next2;
                String string = (aVar == null || (map = aVar.f10664e) == null || (obj3 = map.get("user_id")) == null) ? null : obj3.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("诊断时间: ".concat(str));
                if (string != null && string.length() != 0) {
                    sb2.append("  UID: ".concat(string));
                }
                dVar = dVar2;
                f10 = f11;
                k0.a(sb2.toString(), null, a0.f10675j, s7.a.z(12), null, v1.p.f10370c, 0L, 0L, 0, false, 0, 0, null, pVar, 3456, 0, 130994);
                pVar = pVar;
                jVar2 = jVar2;
                n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar2, 8));
                z4 = false;
            } else {
                f10 = f11;
                dVar = dVar2;
                z4 = false;
            }
            pVar.q(z4);
            if (this.f10778h) {
                boolean z12 = z4;
                n0.d dVar3 = dVar;
                float f12 = f10;
                if (this.f10779i) {
                    pVar.S(1382346526);
                    i0 i0VarA = g0.a(r.i.f8866a, dVar3, pVar, 48);
                    int iK2 = b0.b.k(pVar);
                    t1 t1VarL2 = pVar.l();
                    n0.m mVarV2 = a.a.V(pVar, jVar2);
                    i1.h.f4488c.getClass();
                    i1.y yVar2 = i1.g.f4474b;
                    pVar.U();
                    if (pVar.P) {
                        pVar.k(yVar2);
                    } else {
                        pVar.e0();
                    }
                    b0.b.q(pVar, i0VarA, i1.g.f4477e);
                    b0.b.q(pVar, t1VarL2, i1.g.f4476d);
                    i1.f fVar2 = i1.g.f4478f;
                    if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK2))) {
                        a1.a.r(iK2, pVar, iK2, fVar2);
                    }
                    b0.b.q(pVar, mVarV2, i1.g.f4475c);
                    y.y.a(androidx.compose.foundation.layout.a.g(jVar2, f12), a0.f10670e, 2, 0L, 0, pVar, 438);
                    n7.m.b(pVar, androidx.compose.foundation.layout.a.h(10));
                    b0.p pVar2 = pVar;
                    k0.a("正在运行诊断检测…", null, a0.f10675j, s7.a.z(13), null, null, 0L, 0L, 0, false, 0, 0, null, pVar2, 3462, 0, 131058);
                    pVar = pVar2;
                    pVar.q(true);
                    pVar.q(false);
                    z10 = true;
                } else {
                    e eVar = this.f10780j;
                    if (eVar != null) {
                        List list = eVar.f10693d;
                        pVar.S(1382815463);
                        c7.j jVar3 = list.isEmpty() ? new c7.j(new u0.m(a0.f10666a), "正常") : eVar.f10691b >= 0.7f ? new c7.j(new u0.m(a0.f10668c), "异常") : new c7.j(new u0.m(a0.f10667b), "警告");
                        long j2 = ((u0.m) jVar3.f1973f).f9918a;
                        String str2 = (String) jVar3.f1974g;
                        i0 i0VarA2 = g0.a(r.i.f8866a, dVar3, pVar, 48);
                        int iK3 = b0.b.k(pVar);
                        t1 t1VarL3 = pVar.l();
                        n0.m mVarV3 = a.a.V(pVar, jVar2);
                        i1.h.f4488c.getClass();
                        i1.y yVar3 = i1.g.f4474b;
                        pVar.U();
                        if (pVar.P) {
                            pVar.k(yVar3);
                        } else {
                            pVar.e0();
                        }
                        b0.b.q(pVar, i0VarA2, i1.g.f4477e);
                        b0.b.q(pVar, t1VarL3, i1.g.f4476d);
                        i1.f fVar3 = i1.g.f4478f;
                        if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK3))) {
                            a1.a.r(iK3, pVar, iK3, fVar3);
                        }
                        b0.b.q(pVar, mVarV3, i1.g.f4475c);
                        float f13 = 10;
                        r.l.a(androidx.compose.foundation.a.a(androidx.compose.foundation.layout.a.g(jVar2, f13), j2, t.e.f9649a), pVar, z12 ? 1 : 0);
                        n7.m.b(pVar, androidx.compose.foundation.layout.a.h(f13));
                        b0.p pVar3 = pVar;
                        n0.j jVar4 = jVar2;
                        k0.a(str2, null, j2, s7.a.z(14), v1.k.f10360j, null, 0L, 0L, 0, false, 0, 0, null, pVar3, 199680, 0, 131026);
                        float f14 = 8;
                        n7.m.b(pVar3, androidx.compose.foundation.layout.a.h(f14));
                        e eVar2 = eVar;
                        k0.a(eVar.f10692c, null, a0.f10674i, s7.a.z(13), null, null, 0L, 0L, 0, false, 0, 0, null, pVar3, 3456, 0, 131058);
                        pVar = pVar3;
                        boolean z13 = true;
                        pVar.q(true);
                        pVar.S(737367761);
                        int i2 = 4;
                        if (list.isEmpty()) {
                            jVar = jVar4;
                        } else {
                            n0.j jVar5 = jVar4;
                            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar5, f14));
                            y.a0.b(null, 0.0f, u0.z.c(4293256682L), pVar, 384, 3);
                            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar5, f14));
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                b0.p pVar4 = pVar;
                                k0.a(a1.a.w("· ", (String) it2.next()), androidx.compose.foundation.layout.a.f(jVar5, i2, 0.0f, 0.0f, 2, 6), a0.f10675j, s7.a.z(12), null, null, 0L, 0L, 0, false, 0, 0, null, pVar4, 3504, 0, 131056);
                                pVar = pVar4;
                                jVar5 = jVar5;
                                z13 = true;
                                i2 = 4;
                            }
                            jVar = jVar5;
                        }
                        pVar.q(false);
                        Iterator it3 = e0.f10700g.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it3.next();
                            e eVar3 = eVar2;
                            if (((f0) next).f10707a == eVar3.f10690a) {
                                break;
                            }
                            eVar2 = eVar3;
                        }
                        f0 f0Var = (f0) next;
                        String str3 = f0Var != null ? f0Var.f10709c : null;
                        if (str3 == null || str3.length() == 0) {
                            z11 = false;
                            pVar.q(z11);
                        } else if (ga.r.g0(str3, "联系", false)) {
                            n0.j jVar6 = jVar;
                            n7.m.b(pVar, androidx.compose.foundation.layout.a.b(jVar6, 6));
                            b0.p pVar5 = pVar;
                            k0.a("→ ".concat(str3), androidx.compose.foundation.layout.a.f(jVar6, 4, 0.0f, 0.0f, 0.0f, 14), u0.z.c(4278221567L), s7.a.z(12), null, null, 0L, 0L, 0, false, 0, 0, null, pVar5, 3504, 0, 131056);
                            pVar = pVar5;
                            z11 = false;
                            pVar.q(z11);
                        } else {
                            z11 = false;
                            pVar.q(z11);
                        }
                    } else {
                        pVar.S(1384786908);
                        pVar.q(z12);
                    }
                    z10 = true;
                }
            } else {
                pVar.S(1381934939);
                i0 i0VarA3 = g0.a(r.i.f8866a, dVar, pVar, 48);
                int iK4 = b0.b.k(pVar);
                t1 t1VarL4 = pVar.l();
                n0.m mVarV4 = a.a.V(pVar, jVar2);
                i1.h.f4488c.getClass();
                i1.y yVar4 = i1.g.f4474b;
                pVar.U();
                if (pVar.P) {
                    pVar.k(yVar4);
                } else {
                    pVar.e0();
                }
                b0.b.q(pVar, i0VarA3, i1.g.f4477e);
                b0.b.q(pVar, t1VarL4, i1.g.f4476d);
                i1.f fVar4 = i1.g.f4478f;
                if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK4))) {
                    a1.a.r(iK4, pVar, iK4, fVar4);
                }
                b0.b.q(pVar, mVarV4, i1.g.f4475c);
                y.y.a(androidx.compose.foundation.layout.a.g(jVar2, f10), a0.f10670e, 2, 0L, 0, pVar, 438);
                n7.m.b(pVar, androidx.compose.foundation.layout.a.h(10));
                b0.p pVar6 = pVar;
                k0.a("Service 启动中…", null, a0.f10675j, s7.a.z(13), null, null, 0L, 0L, 0, false, 0, 0, null, pVar6, 3462, 0, 131058);
                pVar = pVar6;
                pVar.q(true);
                pVar.q(false);
                z10 = true;
            }
            pVar.q(z10);
        }
        return c7.r.f1986a;
    }
}
