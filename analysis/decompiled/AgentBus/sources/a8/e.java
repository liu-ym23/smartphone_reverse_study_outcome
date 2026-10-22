package a8;

import android.view.KeyEvent;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import i1.a1;
import i1.d0;
import i1.d1;
import i1.f0;
import i1.g0;
import i1.i0;
import i1.n0;
import i1.r0;
import i1.s1;
import i1.u1;
import i8.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.c0;
import v9.v0;
import v9.z0;
import z7.e0;
import z7.l1;
import z7.m1;
import z7.v1;
import z8.p0;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f444g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f445h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f446i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        super(0);
        this.f444g = i2;
        this.f445h = obj;
        this.f446i = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v62, types: [p7.a, q7.m] */
    /* JADX WARN: Type inference failed for: r1v52, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v46, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v49, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v7, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r3v82 */
    /* JADX WARN: Type inference failed for: r3v83 */
    /* JADX WARN: Type inference failed for: r3v84 */
    /* JADX WARN: Type inference failed for: r3v85 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [d7.z] */
    /* JADX WARN: Type inference failed for: r4v81, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v82, types: [java.util.ArrayList] */
    @Override // p7.a
    public final Object c() {
        p1.n nVar;
        f0 f0Var;
        w7.x xVar;
        int i2 = this.f444g;
        ?? arrayList = d7.z.f2978f;
        int i10 = 0;
        c7.r rVar = c7.r.f1986a;
        Object obj = this.f445h;
        Object obj2 = this.f446i;
        switch (i2) {
            case 0:
                StringBuilder sb2 = new StringBuilder();
                sb2.append('@');
                sb2.append(((Class) obj).getCanonicalName());
                d7.r.T0(((Map) obj2).entrySet(), sb2, ", ", "(", ")", d.f443g, 48);
                String string = sb2.toString();
                q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            case 1:
                ((c1.b) obj).d((n0.l) obj2);
                return rVar;
            case 2:
                e8.g gVar = (e8.g) obj;
                p7.k kVar = gVar.f3146b;
                i8.a0 a0Var = gVar.f3145a;
                u9.k kVar2 = (u9.k) obj2;
                i8.k kVar3 = new i8.k((f8.j) kVar.invoke(a0Var), e8.g.f3143g, 4, 2, a.a.S(a0Var.f4739i.e()), kVar2);
                kVar3.C0(new e8.a(kVar2, kVar3), d7.b0.f2947f, null);
                return kVar3;
            case 3:
                e8.i iVar = (e8.i) obj;
                i8.a0 a0VarK = iVar.k();
                q7.k.d(a0VarK, "builtInsModule");
                return new e8.o(a0VarK, (u9.k) obj2, new c(4, iVar));
            case 4:
                e8.o oVar = (e8.o) obj;
                i8.a0 a0Var2 = oVar.g().f3148a;
                e8.g.f3140d.getClass();
                return f8.v.f(a0Var2, e8.g.f3144h, new i5.f((u9.k) obj2, oVar.g().f3148a)).k();
            case 5:
                s8.j jVar = (s8.j) obj;
                a3.b bVar = jVar.f9562o;
                r8.a aVar = (r8.a) bVar.f162f;
                a3.b bVar2 = new a3.b(new r8.a(aVar.f9002a, aVar.f9003b, aVar.f9004c, aVar.f9005d, aVar.f9006e, aVar.f9007f, aVar.f9009h, aVar.f9010i, aVar.f9011j, aVar.f9012k, aVar.f9013l, aVar.f9014m, aVar.f9015n, aVar.f9016o, aVar.f9017p, aVar.f9018q, aVar.f9019r, aVar.f9020s, aVar.f9021t, aVar.f9022u, aVar.f9023v, aVar.f9024w), (r8.f) bVar.f163g, bVar.f164h);
                f8.j jVarP = jVar.p();
                q7.k.d(jVarP, "containingDeclaration");
                return new s8.j(bVar2, jVarP, jVar.f9560m, (f8.e) obj2);
            case 6:
                a1 a1Var = ((f0) obj).H;
                q7.v vVar = (q7.v) obj2;
                if ((((n0.l) a1Var.f4404j).f6800i & 8) != 0) {
                    for (n0.l lVar = (u1) a1Var.f4403i; lVar != null; lVar = lVar.f6801j) {
                        if ((lVar.f6799h & 8) != 0) {
                            i1.k kVarE = lVar;
                            ?? eVar = 0;
                            while (kVarE != 0) {
                                if (kVarE instanceof s1) {
                                    s1 s1Var = (s1) kVarE;
                                    if (s1Var.N()) {
                                        p1.i iVar2 = new p1.i();
                                        vVar.f8820f = iVar2;
                                        iVar2.f8307i = true;
                                    }
                                    if (s1Var.Q()) {
                                        ((p1.i) vVar.f8820f).f8306h = true;
                                    }
                                    s1Var.u((p1.i) vVar.f8820f);
                                } else if ((kVarE.f6799h & 8) != 0 && (kVarE instanceof i1.k)) {
                                    n0.l lVar2 = kVarE.f4514u;
                                    int i11 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar2 != null) {
                                        if ((lVar2.f6799h & 8) != 0) {
                                            i11++;
                                            eVar = eVar;
                                            if (i11 == 1) {
                                                kVarE = lVar2;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new d0.e(new n0.l[16]);
                                                }
                                                if (kVarE != 0) {
                                                    eVar.b(kVarE);
                                                    kVarE = 0;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                        lVar2 = lVar2.f6802k;
                                        kVarE = kVarE;
                                        eVar = eVar;
                                    }
                                    if (i11 == 1) {
                                    }
                                }
                                kVarE = i1.l.e(eVar);
                            }
                        }
                    }
                }
                return rVar;
            case 7:
                r0 r0Var = (r0) obj;
                i0 i0Var = r0Var.f4567k;
                i0Var.f4499g = 0;
                d0.e eVarS = i0Var.f4493a.s();
                Object[] objArr = eVarS.f2749f;
                int i12 = eVarS.f2751h;
                for (int i13 = 0; i13 < i12; i13++) {
                    r0 r0Var2 = ((f0) objArr[i13]).I.f4508p;
                    q7.k.b(r0Var2);
                    r0Var2.f4569m = r0Var2.f4570n;
                    r0Var2.f4570n = Integer.MAX_VALUE;
                    if (r0Var2.f4571o == d0.f4434g) {
                        r0Var2.f4571o = d0.f4435h;
                    }
                }
                f0 f0Var2 = i0Var.f4493a;
                f0 f0Var3 = i0Var.f4493a;
                d0.e eVarS2 = f0Var2.s();
                Object[] objArr2 = eVarS2.f2749f;
                int i14 = eVarS2.f2751h;
                for (int i15 = 0; i15 < i14; i15++) {
                    r0 r0Var3 = ((f0) objArr2[i15]).I.f4508p;
                    q7.k.b(r0Var3);
                    r0Var3.f4578v.getClass();
                }
                i1.q qVar = r0Var.l().T;
                if (qVar != null) {
                    boolean z4 = qVar.f4532p;
                    d0.b bVar3 = (d0.b) f0Var3.i();
                    int i16 = bVar3.f2743f.f2751h;
                    for (int i17 = 0; i17 < i16; i17++) {
                        n0 n0VarX0 = ((d1) ((f0) bVar3.get(i17)).H.f4402h).x0();
                        if (n0VarX0 != null) {
                            n0VarX0.f4532p = z4;
                        }
                    }
                }
                ((n0) obj2).e0().e();
                if (r0Var.l().T != null) {
                    d0.b bVar4 = (d0.b) f0Var3.i();
                    int i18 = bVar4.f2743f.f2751h;
                    for (int i19 = 0; i19 < i18; i19++) {
                        n0 n0VarX02 = ((d1) ((f0) bVar4.get(i19)).H.f4402h).x0();
                        if (n0VarX02 != null) {
                            n0VarX02.f4532p = false;
                        }
                    }
                }
                d0.e eVarS3 = f0Var3.s();
                Object[] objArr3 = eVarS3.f2749f;
                int i20 = eVarS3.f2751h;
                for (int i21 = 0; i21 < i20; i21++) {
                    r0 r0Var4 = ((f0) objArr3[i21]).I.f4508p;
                    q7.k.b(r0Var4);
                    int i22 = r0Var4.f4569m;
                    int i23 = r0Var4.f4570n;
                    if (i22 != i23 && i23 == Integer.MAX_VALUE) {
                        r0Var4.Q(true);
                    }
                }
                d0.e eVarS4 = f0Var3.s();
                Object[] objArr4 = eVarS4.f2749f;
                int i24 = eVarS4.f2751h;
                for (int i25 = 0; i25 < i24; i25++) {
                    r0 r0Var5 = ((f0) objArr4[i25]).I.f4508p;
                    q7.k.b(r0Var5);
                    g0 g0Var = r0Var5.f4578v;
                    g0Var.getClass();
                    g0Var.f4481c = false;
                }
                return rVar;
            case 8:
                o0 o0Var = (o0) obj;
                u9.n nVar2 = o0Var.I;
                t9.s sVar = o0Var.J;
                i8.i iVar3 = (i8.i) obj2;
                g8.j annotations = iVar3.getAnnotations();
                i8.i iVar4 = (i8.i) obj2;
                int kind = iVar4.getKind();
                m.x.y(kind, "underlyingConstructorDescriptor.kind");
                t9.s sVar2 = o0Var.J;
                f8.n0 n0VarQ = sVar2.q();
                q7.k.d(n0VarQ, "typeAliasDescriptor.source");
                o0 o0Var2 = new o0(nVar2, sVar, iVar3, o0Var, annotations, kind, n0VarQ);
                o0.L.getClass();
                v0 v0VarD = sVar2.G0() == null ? null : v0.d(sVar2.H0());
                if (v0VarD == null) {
                    return null;
                }
                i8.v vVar2 = iVar4.f4878o;
                i8.v vVarD = vVar2 != null ? vVar2.d(v0VarD) : null;
                List listS = iVar4.S();
                q7.k.d(listS, "underlyingConstructorDes…contextReceiverParameters");
                ArrayList arrayList2 = new ArrayList(d7.t.A0(listS, 10));
                Iterator it = listS.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((i8.v) it.next()).d(v0VarD));
                }
                List listS2 = sVar2.s();
                List listX0 = o0Var.x0();
                v9.v vVar3 = o0Var.f4875l;
                q7.k.b(vVar3);
                o0Var2.L0(null, vVarD, arrayList2, listS2, listX0, vVar3, 1, sVar2.f9842j);
                return o0Var2;
            case 9:
                return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchKeyEvent((KeyEvent) obj2));
            case 10:
                j1.f0 f0Var4 = (j1.f0) obj2;
                j1.s1 s1Var2 = (j1.s1) obj;
                p1.g gVar2 = s1Var2.f5328j;
                p1.g gVar3 = s1Var2.f5329k;
                Float f10 = s1Var2.f5326h;
                Float f11 = s1Var2.f5327i;
                float fFloatValue = (gVar2 == null || f10 == null) ? 0.0f : ((Number) gVar2.f8276a.c()).floatValue() - f10.floatValue();
                float fFloatValue2 = (gVar3 == null || f11 == null) ? 0.0f : ((Number) gVar3.f8276a.c()).floatValue() - f11.floatValue();
                if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                    int iS = f0Var4.s(s1Var2.f5324f);
                    p1.o oVar2 = (p1.o) f0Var4.l().b(f0Var4.f5148n);
                    if (oVar2 != null) {
                        try {
                            p2.h hVar = f0Var4.f5150p;
                            if (hVar != null) {
                                hVar.f8393a.setBoundsInScreen(f0Var4.c(oVar2));
                            }
                        } catch (IllegalStateException unused) {
                        }
                    }
                    p1.o oVar3 = (p1.o) f0Var4.l().b(f0Var4.f5149o);
                    if (oVar3 != null) {
                        try {
                            p2.h hVar2 = f0Var4.f5151q;
                            if (hVar2 != null) {
                                hVar2.f8393a.setBoundsInScreen(f0Var4.c(oVar3));
                            }
                        } catch (IllegalStateException unused2) {
                        }
                    }
                    f0Var4.f5138d.invalidate();
                    p1.o oVar4 = (p1.o) f0Var4.l().b(iS);
                    if (oVar4 != null && (nVar = oVar4.f8319a) != null && (f0Var = nVar.f8314c) != null) {
                        if (gVar2 != null) {
                            f0Var4.f5153s.g(iS, gVar2);
                        }
                        if (gVar3 != null) {
                            f0Var4.f5154t.g(iS, gVar3);
                        }
                        f0Var4.o(f0Var);
                    }
                }
                if (gVar2 != null) {
                    s1Var2.f5326h = (Float) gVar2.f8276a.c();
                }
                if (gVar3 != null) {
                    s1Var2.f5327i = (Float) gVar3.f8276a.c();
                }
                return rVar;
            case 11:
                ((q7.v) obj).f8820f = i1.l.h((c0) obj2, g1.q.f3754a);
                return rVar;
            case 12:
                v9.z zVarK = ((r8.a) ((a3.b) obj).f162f).f9016o.n().i(((p8.b) obj2).f8504a).k();
                q7.k.d(zVarK, "c.module.builtIns.getBui…qName(fqName).defaultType");
                return zVarK;
            case 13:
                ((r0.b) obj).f8959v.invoke((r0.c) obj2);
                return rVar;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                a3.b bVar5 = (a3.b) obj;
                g8.j annotations2 = ((f8.f) obj2).getAnnotations();
                q7.k.e(bVar5, "<this>");
                q7.k.e(annotations2, "additionalAnnotations");
                return ((r8.a) bVar5.f162f).f9018q.b((o8.u) bVar5.f165i.getValue(), annotations2);
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                a3.b bVar6 = (a3.b) obj;
                g8.j jVar2 = (g8.j) obj2;
                q7.k.e(bVar6, "<this>");
                q7.k.e(jVar2, "additionalAnnotations");
                return ((r8.a) bVar6.f162f).f9018q.b((o8.u) bVar6.f165i.getValue(), jVar2);
            case 16:
                return new s8.r(((r8.e) obj).f9034a, (l8.y) obj2);
            case 17:
                r9.k kVar4 = (r9.k) ((a7.g) obj).f418g;
                return ((r9.i) kVar4.f9070f).f9051e.o((p0) obj2, (b9.f) kVar4.f9071g);
            case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                ((q7.v) obj).f8820f = ((s0.q) obj2).m0();
                return rVar;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                k8.b bVar7 = ((r8.a) ((a3.b) obj).f162f).f9003b;
                e9.c cVar = ((s8.w) obj2).f9611o.f4758j;
                bVar7.getClass();
                q7.k.e(cVar, "packageFqName");
                return null;
            case 20:
                t9.i iVar5 = (t9.i) obj;
                return d7.r.m1(((r9.i) iVar5.f9809q.f9070f).f9051e.m(iVar5.A, (z8.s) obj2));
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                y9.h hVar3 = (y9.h) ((v9.x) obj2).f10602h.c();
                ((w9.g) obj).getClass();
                q7.k.e(hVar3, "type");
                return (v9.v) hVar3;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                List list = (List) ((w9.j) obj).f10945e.getValue();
                List list2 = arrayList;
                if (list != null) {
                    list2 = list;
                }
                w9.g gVar4 = (w9.g) obj2;
                ArrayList arrayList3 = new ArrayList(d7.t.A0(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((z0) it2.next()).G0(gVar4));
                }
                return arrayList3;
            case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                z7.g0 g0Var2 = (z7.g0) obj;
                e0 e0Var = g0Var2.f11867j;
                String str = (String) obj2;
                String str2 = g0Var2.f11868k;
                e0Var.getClass();
                q7.k.e(str2, "signature");
                Collection collectionM1 = str.equals("<init>") ? d7.r.m1(e0Var.x()) : e0Var.y(e9.f.e(str));
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : collectionM1) {
                    if (q7.k.a(v1.c((f8.t) obj3).f(), str2)) {
                        arrayList4.add(obj3);
                    }
                }
                if (arrayList4.size() == 1) {
                    return (f8.t) d7.r.f1(arrayList4);
                }
                String strU0 = d7.r.U0(collectionM1, "\n", null, null, z7.b.f11842o, 30);
                StringBuilder sbP = a1.a.p("Function '", str, "' (JVM signature: ", str2, ") not resolved in ");
                sbP.append(e0Var);
                sbP.append(':');
                sbP.append(strU0.length() == 0 ? " no members found" : "\n".concat(strU0));
                throw new c7.i(sbP.toString(), 3);
            default:
                m1 m1Var = (m1) obj;
                List listC0 = m1Var.f11908f.C0();
                if (!listC0.isEmpty()) {
                    c7.f fVarG = s7.a.G(c7.h.f1970f, new l1(m1Var, i10));
                    p7.a aVar2 = (p7.a) obj2;
                    arrayList = new ArrayList(d7.t.A0(listC0, 10));
                    for (Object obj4 : listC0) {
                        int i26 = i10 + 1;
                        if (i10 < 0) {
                            d7.s.z0();
                            throw null;
                        }
                        v9.p0 p0Var = (v9.p0) obj4;
                        if (p0Var.c()) {
                            xVar = w7.x.f10874c;
                        } else {
                            v9.v vVarB = p0Var.b();
                            q7.k.d(vVarB, "typeProjection.type");
                            m1 m1Var2 = new m1(vVarB, aVar2 == null ? null : new r9.o(m1Var, i10, fVarG));
                            int iD = n.f.d(p0Var.a());
                            if (iD == 0) {
                                w7.x xVar2 = w7.x.f10874c;
                                xVar = new w7.x(w7.y.f10877f, m1Var2);
                            } else if (iD == 1) {
                                xVar = new w7.x(w7.y.f10878g, m1Var2);
                            } else {
                                if (iD != 2) {
                                    throw new a4.u();
                                }
                                xVar = new w7.x(w7.y.f10879h, m1Var2);
                            }
                        }
                        arrayList.add(xVar);
                        i10 = i26;
                    }
                }
                return arrayList;
        }
    }
}
