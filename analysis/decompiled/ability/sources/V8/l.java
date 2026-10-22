package V8;

import D7.w;
import T8.C0252d;
import X8.A;
import i8.C1560f;
import i8.C1562h;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;

/* loaded from: classes4.dex */
public final class l implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1397a;
    public final o b;

    public /* synthetic */ l(o oVar, int i) {
        this.f1397a = i;
        this.b = oVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        List listO0;
        List listO02;
        ProtoBuf$Type protoBuf$TypeB;
        ProtoBuf$Type protoBuf$TypeB2;
        G8.f it = (G8.f) obj;
        switch (this.f1397a) {
            case 0:
                kotlin.jvm.internal.k.f(it, "it");
                o oVar = this.b;
                LinkedHashMap linkedHashMap = oVar.f1401a;
                B8.a PARSER = ProtoBuf$Function.f5047v;
                kotlin.jvm.internal.k.e(PARSER, "PARSER");
                p pVar = oVar.i;
                byte[] bArr = (byte[]) linkedHashMap.get(it);
                Collection<ProtoBuf$Function> collection = (bArr == null || (listO0 = kotlin.sequences.a.o0(kotlin.sequences.a.j0(new n(PARSER, new ByteArrayInputStream(bArr), pVar, 0)))) == null) ? EmptyList.f4893a : listO0;
                ArrayList arrayList = new ArrayList(collection.size());
                for (ProtoBuf$Function protoBuf$Function : collection) {
                    T8.v vVar = pVar.b.i;
                    kotlin.jvm.internal.k.c(protoBuf$Function);
                    s sVarE = vVar.e(protoBuf$Function);
                    if (!pVar.q(sVarE)) {
                        sVarE = null;
                    }
                    if (sVarE != null) {
                        arrayList.add(sVarE);
                    }
                }
                pVar.i(it, arrayList);
                return g9.l.e(arrayList);
            case 1:
                kotlin.jvm.internal.k.f(it, "it");
                o oVar2 = this.b;
                LinkedHashMap linkedHashMap2 = oVar2.b;
                B8.a PARSER2 = ProtoBuf$Property.f5057v;
                kotlin.jvm.internal.k.e(PARSER2, "PARSER");
                p pVar2 = oVar2.i;
                byte[] bArr2 = (byte[]) linkedHashMap2.get(it);
                Collection<ProtoBuf$Property> collection2 = (bArr2 == null || (listO02 = kotlin.sequences.a.o0(kotlin.sequences.a.j0(new n(PARSER2, new ByteArrayInputStream(bArr2), pVar2, 0)))) == null) ? EmptyList.f4893a : listO02;
                ArrayList arrayList2 = new ArrayList(collection2.size());
                for (ProtoBuf$Property protoBuf$Property : collection2) {
                    T8.v vVar2 = pVar2.b.i;
                    kotlin.jvm.internal.k.c(protoBuf$Property);
                    arrayList2.add(vVar2.f(protoBuf$Property));
                }
                pVar2.j(it, arrayList2);
                return g9.l.e(arrayList2);
            default:
                kotlin.jvm.internal.k.f(it, "it");
                o oVar3 = this.b;
                T8.m mVar = oVar3.i.b;
                byte[] bArr3 = (byte[]) oVar3.c.get(it);
                if (bArr3 != null) {
                    ProtoBuf$TypeAlias protoBuf$TypeAlias = (ProtoBuf$TypeAlias) ProtoBuf$TypeAlias.p.b(new ByteArrayInputStream(bArr3), mVar.f1228a.p);
                    if (protoBuf$TypeAlias != null) {
                        T8.v vVar3 = mVar.i;
                        T8.m mVar2 = vVar3.f1235a;
                        D8.f fVar = mVar2.b;
                        D8.j jVar = mVar2.d;
                        List list = protoBuf$TypeAlias.k;
                        kotlin.jvm.internal.k.e(list, "getAnnotationList(...)");
                        List<ProtoBuf$Annotation> list2 = list;
                        ArrayList arrayList3 = new ArrayList(w.c0(list2, 10));
                        for (ProtoBuf$Annotation protoBuf$Annotation : list2) {
                            C0252d c0252d = vVar3.b;
                            kotlin.jvm.internal.k.c(protoBuf$Annotation);
                            arrayList3.add(c0252d.a(protoBuf$Annotation, fVar));
                        }
                        t tVar = new t(mVar2.f1228a.f1222a, mVar2.c, arrayList3.isEmpty() ? C1560f.f4611a : new C1562h(arrayList3, 0), N9.j.x(fVar, protoBuf$TypeAlias.e), S0.b.O0((ProtoBuf$Visibility) D8.e.d.c(protoBuf$TypeAlias.d)), protoBuf$TypeAlias, mVar2.b, jVar, mVar2.e, mVar2.g);
                        List list3 = protoBuf$TypeAlias.f;
                        kotlin.jvm.internal.k.e(list3, "getTypeParameterList(...)");
                        kotlin.reflect.jvm.internal.impl.serialization.deserialization.a aVar = mVar2.a(tVar, list3, mVar2.b, mVar2.d, mVar2.e, mVar2.f).h;
                        List listB = aVar.b();
                        int i = protoBuf$TypeAlias.c;
                        if ((i & 4) == 4) {
                            protoBuf$TypeB = protoBuf$TypeAlias.g;
                            kotlin.jvm.internal.k.e(protoBuf$TypeB, "getUnderlyingType(...)");
                        } else {
                            if ((i & 8) != 8) {
                                throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
                            }
                            protoBuf$TypeB = jVar.b(protoBuf$TypeAlias.h);
                        }
                        A aD = aVar.d(protoBuf$TypeB, false);
                        int i6 = protoBuf$TypeAlias.c;
                        if ((i6 & 16) == 16) {
                            protoBuf$TypeB2 = protoBuf$TypeAlias.i;
                            kotlin.jvm.internal.k.e(protoBuf$TypeB2, "getExpandedType(...)");
                        } else {
                            if ((i6 & 32) != 32) {
                                throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
                            }
                            protoBuf$TypeB2 = jVar.b(protoBuf$TypeAlias.f5074j);
                        }
                        tVar.U0(listB, aD, aVar.d(protoBuf$TypeB2, false));
                        return tVar;
                    }
                }
                return null;
        }
    }
}
