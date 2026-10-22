package t9;

import d7.z;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import z8.d1;
import z8.f0;
import z8.p0;
import z8.r0;
import z8.x;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9822g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f9823h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(n nVar, int i2) {
        super(1);
        this.f9822g = i2;
        this.f9823h = nVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Collection<x> collectionV0;
        Collection<f0> collectionV02;
        p0 p0VarA;
        p0 p0VarA2;
        switch (this.f9822g) {
            case 0:
                e9.f fVar = (e9.f) obj;
                q7.k.e(fVar, "it");
                n nVar = this.f9823h;
                LinkedHashMap linkedHashMap = nVar.f9825a;
                c9.a aVar = x.A;
                q7.k.d(aVar, "PARSER");
                o oVar = nVar.f9833i;
                byte[] bArr = (byte[]) linkedHashMap.get(fVar);
                if (bArr != null) {
                    eb.k kVar = new eb.k(aVar, new ByteArrayInputStream(bArr), oVar, 6);
                    collectionV0 = fa.l.v0(new fa.a(new fa.i(kVar, new a5.a(10, kVar))));
                } else {
                    collectionV0 = z.f2978f;
                }
                ArrayList arrayList = new ArrayList(collectionV0.size());
                for (x xVar : collectionV0) {
                    r9.r rVar = (r9.r) oVar.f9835b.f9078n;
                    q7.k.d(xVar, "it");
                    r rVarE = rVar.e(xVar);
                    if (!oVar.r(rVarE)) {
                        rVarE = null;
                    }
                    if (rVarE != null) {
                        arrayList.add(rVarE);
                    }
                }
                oVar.j(fVar, arrayList);
                return ea.k.d(arrayList);
            case 1:
                e9.f fVar2 = (e9.f) obj;
                q7.k.e(fVar2, "it");
                n nVar2 = this.f9823h;
                LinkedHashMap linkedHashMap2 = nVar2.f9826b;
                c9.a aVar2 = f0.A;
                q7.k.d(aVar2, "PARSER");
                o oVar2 = nVar2.f9833i;
                byte[] bArr2 = (byte[]) linkedHashMap2.get(fVar2);
                if (bArr2 != null) {
                    eb.k kVar2 = new eb.k(aVar2, new ByteArrayInputStream(bArr2), oVar2, 6);
                    collectionV02 = fa.l.v0(new fa.a(new fa.i(kVar2, new a5.a(10, kVar2))));
                } else {
                    collectionV02 = z.f2978f;
                }
                ArrayList arrayList2 = new ArrayList(collectionV02.size());
                for (f0 f0Var : collectionV02) {
                    r9.r rVar2 = (r9.r) oVar2.f9835b.f9078n;
                    q7.k.d(f0Var, "it");
                    arrayList2.add(rVar2.f(f0Var));
                }
                oVar2.k(fVar2, arrayList2);
                return ea.k.d(arrayList2);
            default:
                e9.f fVar3 = (e9.f) obj;
                q7.k.e(fVar3, "it");
                n nVar3 = this.f9823h;
                r9.k kVar3 = nVar3.f9833i.f9835b;
                byte[] bArr3 = (byte[]) nVar3.f9827c.get(fVar3);
                if (bArr3 != null) {
                    r0 r0Var = (r0) r0.f12341u.b(new ByteArrayInputStream(bArr3), ((r9.i) kVar3.f9070f).f9062p);
                    if (r0Var != null) {
                        r9.r rVar3 = (r9.r) kVar3.f9078n;
                        r9.k kVar4 = rVar3.f9100a;
                        b9.f fVar4 = (b9.f) kVar4.f9071g;
                        b9.g gVar = (b9.g) kVar4.f9073i;
                        List<z8.f> list = r0Var.f12351p;
                        q7.k.d(list, "proto.annotationList");
                        ArrayList arrayList3 = new ArrayList(d7.t.A0(list, 10));
                        for (z8.f fVar5 : list) {
                            nb.f fVar6 = rVar3.f9101b;
                            q7.k.d(fVar5, "it");
                            arrayList3.add(fVar6.t(fVar5, fVar4));
                        }
                        s sVar = new s(((r9.i) kVar4.f9070f).f9047a, (f8.j) kVar4.f9072h, arrayList3.isEmpty() ? g8.h.f3888a : new g8.k(0, arrayList3), nb.i.y(fVar4, r0Var.f12345j), n7.a.h((d1) b9.e.f1561d.e(r0Var.f12344i)), r0Var, (b9.f) kVar4.f9071g, gVar, (b9.h) kVar4.f9074j, (j) kVar4.f9076l);
                        List list2 = r0Var.f12346k;
                        q7.k.d(list2, "proto.typeParameterList");
                        a7.g gVar2 = (a7.g) kVar4.b(sVar, list2, (b9.f) kVar4.f9071g, (b9.g) kVar4.f9073i, (b9.h) kVar4.f9074j, (b9.a) kVar4.f9075k).f9077m;
                        List listN = gVar2.n();
                        int i2 = r0Var.f12343h;
                        if ((i2 & 4) == 4) {
                            p0VarA = r0Var.f12347l;
                            q7.k.d(p0VarA, "underlyingType");
                        } else {
                            if ((i2 & 8) != 8) {
                                throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
                            }
                            p0VarA = gVar.a(r0Var.f12348m);
                        }
                        v9.z zVarU = gVar2.u(p0VarA, false);
                        int i10 = r0Var.f12343h;
                        if ((i10 & 16) == 16) {
                            p0VarA2 = r0Var.f12349n;
                            q7.k.d(p0VarA2, "expandedType");
                        } else {
                            if ((i10 & 32) != 32) {
                                throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
                            }
                            p0VarA2 = gVar.a(r0Var.f12350o);
                        }
                        sVar.J0(listN, zVarU, gVar2.u(p0VarA2, false));
                        return sVar;
                    }
                }
                return null;
        }
    }
}
