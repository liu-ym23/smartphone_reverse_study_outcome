package ce;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ge.h;
import ge.k;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import zd.i;
import zd.l;
import zd.m;
import zd.o;
import zd.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2263a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ f f2264b;

    public /* synthetic */ b(f fVar, int i) {
        this.f2263a = i;
        this.f2264b = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ce.g
    public final zd.g a() {
        yd.a aVar;
        int i = 3;
        int i3 = 13;
        int i10 = 8;
        int i11 = 7;
        int i12 = 17;
        int i13 = 4;
        boolean z10 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        int i14 = 1;
        char c9 = 1;
        char c10 = 1;
        char c11 = 1;
        char c12 = 1;
        char c13 = 1;
        char c14 = 1;
        char c15 = 1;
        char c16 = 1;
        char c17 = 1;
        char c18 = 1;
        switch (this.f2263a) {
            case 0:
                f fVar = this.f2264b;
                fVar.f2278d.g(fVar.f2275a.k().f4744a);
                return new b(fVar, c9 == true ? 1 : 0).a();
            case 1:
                f fVar2 = this.f2264b;
                fe.b bVar = fVar2.f2275a;
                ne.b bVar2 = fVar2.f2278d;
                ne.b bVar3 = fVar2.f2277c;
                fe.b bVar4 = fVar2.f2275a;
                if (bVar.c(22)) {
                    fVar2.f2279e = new b(fVar2, c10 == true ? 1 : 0);
                    return f.b(fVar2, (ge.e) bVar4.k());
                }
                if (bVar4.c(15)) {
                    k kVarK = bVar4.k();
                    int i15 = 2;
                    if (bVar4.d(15, 20, 3)) {
                        fVar2.f2279e = new b(fVar2, i15);
                        return f.a(fVar2, kVarK.f4745b);
                    }
                    bVar3.g(new b(fVar2, i15));
                    return fVar2.c(true, true);
                }
                if (bVar4.c(3)) {
                    k kVarK2 = bVar4.k();
                    i iVar = new i(kVarK2.f4744a, kVarK2.f4745b);
                    fVar2.f2279e = (g) bVar3.f();
                    bVar2.f();
                    return iVar;
                }
                k kVarM = bVar4.m();
                throw new a("while parsing a block mapping", (yd.a) bVar2.f(), "expected <block end>, but found '" + androidx.activity.b.A(kVarM.a()) + "'", kVarM.f4744a);
            case 2:
                f fVar3 = this.f2264b;
                fe.b bVar5 = fVar3.f2275a;
                ne.b bVar6 = fVar3.f2277c;
                boolean zC = bVar5.c(20);
                fe.b bVar7 = fVar3.f2275a;
                if (!zC) {
                    if (bVar7.c(16)) {
                        bVar6.g(new b(fVar3, c12 == true ? 1 : 0));
                        return fVar3.c(true, true);
                    }
                    fVar3.f2279e = new b(fVar3, c11 == true ? 1 : 0);
                    return f.a(fVar3, bVar7.m().f4744a);
                }
                k kVarK3 = bVar7.k();
                if (!bVar7.c(22)) {
                    if (bVar7.d(15, 20, 3)) {
                        fVar3.f2279e = new b(fVar3, c13 == true ? 1 : 0);
                        return f.a(fVar3, kVarK3.f4745b);
                    }
                    bVar6.g(new b(fVar3, c14 == true ? 1 : 0));
                    return fVar3.c(true, true);
                }
                c cVar = new c(objArr == true ? 1 : 0);
                cVar.f2267c = fVar3;
                cVar.f2266b = new LinkedList();
                VarHandle.storeStoreFence();
                fVar3.f2279e = cVar;
                return cVar.a();
            case 3:
                f fVar4 = this.f2264b;
                HashMap map = f.f2274g;
                return fVar4.c(true, false);
            case 4:
                f fVar5 = this.f2264b;
                fe.b bVar8 = fVar5.f2275a;
                ne.b bVar9 = fVar5.f2278d;
                ne.b bVar10 = fVar5.f2277c;
                fe.b bVar11 = fVar5.f2275a;
                if (bVar8.c(22)) {
                    fVar5.f2279e = new b(fVar5, i13);
                    return f.b(fVar5, (ge.e) bVar11.k());
                }
                if (bVar11.c(4)) {
                    ge.d dVar = (ge.d) bVar11.k();
                    if (bVar11.c(22)) {
                        fVar5.f2279e = new d(fVar5, dVar, objArr2 == true ? 1 : 0);
                        return f.b(fVar5, (ge.e) bVar11.k());
                    }
                    if (bVar11.d(4, 3)) {
                        fVar5.f2279e = new b(fVar5, i13);
                        return f.a(fVar5, dVar.f4745b);
                    }
                    bVar10.g(new b(fVar5, i13));
                    HashMap map2 = f.f2274g;
                    return fVar5.c(true, false);
                }
                if (bVar11.c(3)) {
                    k kVarK4 = bVar11.k();
                    m mVar = new m(kVarK4.f4744a, kVarK4.f4745b);
                    fVar5.f2279e = (g) bVar10.f();
                    bVar9.f();
                    return mVar;
                }
                k kVarM2 = bVar11.m();
                throw new a("while parsing a block collection", (yd.a) bVar9.f(), "expected <block end>, but found '" + androidx.activity.b.A(kVarM2.a()) + "'", kVarM2.f4744a);
            case 5:
                f fVar6 = this.f2264b;
                fVar6.f2278d.g(fVar6.f2275a.k().f4744a);
                return new b(fVar6, i13).a();
            case 6:
                f fVar7 = this.f2264b;
                fe.b bVar12 = fVar7.f2275a;
                if (bVar12.c(22)) {
                    fVar7.f2279e = new b(fVar7, 6);
                    return f.b(fVar7, (ge.e) bVar12.k());
                }
                if (!bVar12.d(7, 9, 8, 17)) {
                    HashMap map3 = f.f2274g;
                    return fVar7.c(true, false);
                }
                l lVarA = f.a(fVar7, bVar12.m().f4744a);
                fVar7.f2279e = (g) fVar7.f2277c.f();
                return lVarA;
            case 7:
                f fVar8 = this.f2264b;
                fe.b bVar13 = fVar8.f2275a;
                yd.a aVar2 = bVar13.m().f4744a;
                if (bVar13.c(8)) {
                    aVar = bVar13.k().f4745b;
                    z10 = true;
                } else {
                    aVar = aVar2;
                }
                zd.e eVar = new zd.e(aVar2, aVar, z10);
                fVar8.f2279e = new b(fVar8, i10);
                return eVar;
            case 8:
                f fVar9 = this.f2264b;
                ne.b bVar14 = fVar9.f2278d;
                ne.b bVar15 = fVar9.f2277c;
                fe.b bVar16 = fVar9.f2275a;
                while (bVar16.c(8)) {
                    bVar16.k();
                }
                if (!bVar16.c(17)) {
                    bVar16.f4082a.f3328g = 0;
                    yd.a aVar3 = bVar16.m().f4744a;
                    HashMap map4 = new HashMap((HashMap) fVar9.f2280f.f9723g);
                    HashMap map5 = f.f2274g;
                    Iterator it = map5.keySet().iterator();
                    while (it.hasNext()) {
                        map4.remove((String) it.next());
                    }
                    fVar9.f2280f = new p5.e((vd.c) null, map4);
                    while (bVar16.c(i11)) {
                        ge.f fVar10 = (ge.f) bVar16.k();
                        String str = fVar10.f4738c;
                        ArrayList arrayList = fVar10.f4739d;
                        yd.a aVar4 = fVar10.f4744a;
                        if (str.equals(YAMLFactory.FORMAT_NAME_YAML)) {
                            if (((vd.c) fVar9.f2280f.f9722f) != null) {
                                throw new a(null, null, "found duplicate YAML directive", aVar4);
                            }
                            if (((Integer) arrayList.get(0)).intValue() != 1) {
                                throw new a(null, null, "found incompatible YAML document (version 1.* is required)", aVar4);
                            }
                            if (((Integer) arrayList.get(1)).intValue() == 0) {
                                fVar9.f2280f = new p5.e(vd.c.V1_0, map4);
                            } else {
                                fVar9.f2280f = new p5.e(vd.c.V1_1, map4);
                            }
                        } else if (fVar10.f4738c.equals("TAG")) {
                            String str2 = (String) arrayList.get(0);
                            String str3 = (String) arrayList.get(1);
                            if (map4.containsKey(str2)) {
                                throw new a(null, null, w2.c.b("duplicate tag handle ", str2), aVar4);
                            }
                            map4.put(str2, str3);
                        } else {
                            continue;
                        }
                        i11 = 7;
                    }
                    HashMap map6 = new HashMap();
                    if (!map4.isEmpty()) {
                        map6 = new HashMap(map4);
                    }
                    HashMap map7 = map6;
                    for (String str4 : map5.keySet()) {
                        if (!map4.containsKey(str4)) {
                            map4.put(str4, (String) map5.get(str4));
                        }
                    }
                    vd.c cVar2 = (vd.c) fVar9.f2280f.f9722f;
                    while (bVar16.c(22)) {
                        bVar16.k();
                    }
                    if (!bVar16.c(17)) {
                        if (bVar16.c(9)) {
                            zd.f fVar11 = new zd.f(aVar3, bVar16.k().f4745b, true, cVar2, map7);
                            bVar15.g(new b(fVar9, 7));
                            fVar9.f2279e = new b(fVar9, 6);
                            return fVar11;
                        }
                        throw new a(null, null, "expected '<document start>', but found '" + androidx.activity.b.A(bVar16.m().a()) + "'", bVar16.m().f4744a);
                    }
                }
                h hVar = (h) bVar16.k();
                o oVar = new o(hVar.f4744a, hVar.f4745b);
                if (!bVar15.f8958c.isEmpty()) {
                    throw new yd.c("Unexpected end of stream. States left: " + bVar15);
                }
                if (bVar14.f8958c.isEmpty()) {
                    fVar9.f2279e = null;
                    return oVar;
                }
                throw new yd.c("Unexpected end of stream. Marks left: " + bVar14);
            case 9:
                f fVar12 = this.f2264b;
                fe.b bVar17 = fVar12.f2275a;
                zd.d dVarB = f.b(fVar12, (ge.e) bVar17.k());
                if (!bVar17.c(22)) {
                    fVar12.f2279e = (g) fVar12.f2277c.f();
                }
                return dVarB;
            case 10:
                f fVar13 = this.f2264b;
                fVar13.f2279e = new e(fVar13, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                return f.a(fVar13, fVar13.f2275a.m().f4744a);
            case 11:
                f fVar14 = this.f2264b;
                fVar14.f2278d.g(fVar14.f2275a.k().f4744a);
                return new e(fVar14, c15 == true ? 1 : 0, objArr5 == true ? 1 : 0).a();
            case 12:
                f fVar15 = this.f2264b;
                fe.b bVar18 = fVar15.f2275a;
                if (!bVar18.c(20)) {
                    fVar15.f2279e = new e(fVar15, objArr7 == true ? 1 : 0, objArr6 == true ? 1 : 0);
                    return f.a(fVar15, bVar18.m().f4744a);
                }
                k kVarK5 = bVar18.k();
                if (bVar18.d(10, 11)) {
                    fVar15.f2279e = new e(fVar15, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
                    return f.a(fVar15, kVarK5.f4745b);
                }
                fVar15.f2277c.g(new e(fVar15, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0));
                return fVar15.c(false, false);
            case 13:
                f fVar16 = this.f2264b;
                fVar16.f2279e = new e(fVar16, objArr12 == true ? 1 : 0, c16 == true ? 1 : 0);
                k kVarM3 = fVar16.f2275a.m();
                return new i(kVarM3.f4744a, kVarM3.f4745b);
            case 14:
                f fVar17 = this.f2264b;
                fe.b bVar19 = fVar17.f2275a;
                k kVarK6 = bVar19.k();
                if (bVar19.d(20, 10, 13)) {
                    fVar17.f2279e = new b(fVar17, 15);
                    return f.a(fVar17, kVarK6.f4745b);
                }
                fVar17.f2277c.g(new b(fVar17, 15));
                return fVar17.c(false, false);
            case 15:
                f fVar18 = this.f2264b;
                fe.b bVar20 = fVar18.f2275a;
                if (!bVar20.c(20)) {
                    fVar18.f2279e = new b(fVar18, i3);
                    return f.a(fVar18, bVar20.m().f4744a);
                }
                k kVarK7 = bVar20.k();
                if (bVar20.d(10, 13)) {
                    fVar18.f2279e = new b(fVar18, i3);
                    return f.a(fVar18, kVarK7.f4745b);
                }
                fVar18.f2277c.g(new b(fVar18, i3));
                return fVar18.c(false, false);
            case 16:
                f fVar19 = this.f2264b;
                fVar19.f2278d.g(fVar19.f2275a.k().f4744a);
                return new e(fVar19, c18 == true ? 1 : 0, c17 == true ? 1 : 0).a();
            case 17:
                f fVar20 = this.f2264b;
                fe.b bVar21 = fVar20.f2275a;
                if (bVar21.c(22)) {
                    fVar20.f2279e = new b(fVar20, i12);
                    return f.b(fVar20, (ge.e) bVar21.k());
                }
                if (bVar21.d(7, 9, 17)) {
                    return new b(fVar20, i10).a();
                }
                yd.a aVar5 = bVar21.m().f4744a;
                zd.f fVar21 = new zd.f(aVar5, aVar5, false, null, null);
                fVar20.f2277c.g(new b(fVar20, i11));
                b bVar22 = new b(i);
                bVar22.f2264b = fVar20;
                VarHandle.storeStoreFence();
                fVar20.f2279e = bVar22;
                return fVar21;
            case 18:
                f fVar22 = this.f2264b;
                fe.b bVar23 = fVar22.f2275a;
                fe.b bVar24 = fVar22.f2275a;
                if (bVar23.c(22)) {
                    fVar22.f2279e = new b(fVar22, 18);
                    return f.b(fVar22, (ge.e) bVar24.k());
                }
                if (bVar24.c(4)) {
                    return new d(fVar22, (ge.d) bVar24.k(), i14).a();
                }
                k kVarM4 = bVar24.m();
                m mVar2 = new m(kVarM4.f4744a, kVarM4.f4745b);
                fVar22.f2279e = (g) fVar22.f2277c.f();
                return mVar2;
            default:
                f fVar23 = this.f2264b;
                ge.i iVar2 = (ge.i) fVar23.f2275a.k();
                p pVar = new p(iVar2.f4744a, iVar2.f4745b);
                fVar23.f2279e = new b(fVar23, i12);
                return pVar;
        }
    }

    public /* synthetic */ b(int i) {
        this.f2263a = i;
    }
}
