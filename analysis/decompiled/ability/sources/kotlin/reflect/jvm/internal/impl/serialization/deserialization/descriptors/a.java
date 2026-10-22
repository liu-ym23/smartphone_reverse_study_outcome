package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import D7.v;
import D7.w;
import D8.f;
import D8.j;
import T8.m;
import X8.A;
import a9.InterfaceC0311c;
import h8.C1537t;
import h8.C1541x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.C1640i;
import k8.Q;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* loaded from: classes4.dex */
public final class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final b f5129a;

    public a(b bVar) {
        this.f5129a = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.ArrayList] */
    @Override // S7.a
    public final Object invoke() {
        Object c1537t;
        InterfaceC0311c interfaceC0311c;
        ?? arrayList;
        b bVar = this.f5129a;
        m mVar = bVar.l;
        if (bVar.isInline() || bVar.j()) {
            ProtoBuf$Class protoBuf$Class = bVar.e;
            f nameResolver = mVar.b;
            j jVar = mVar.d;
            DeserializedClassDescriptor$computeValueClassRepresentation$1 deserializedClassDescriptor$computeValueClassRepresentation$1 = new DeserializedClassDescriptor$computeValueClassRepresentation$1(1, mVar.h);
            DeserializedClassDescriptor$computeValueClassRepresentation$2 deserializedClassDescriptor$computeValueClassRepresentation$2 = new DeserializedClassDescriptor$computeValueClassRepresentation$2(1, bVar);
            k.f(protoBuf$Class, "<this>");
            k.f(nameResolver, "nameResolver");
            if (protoBuf$Class.f5036z.size() > 0) {
                List list = protoBuf$Class.f5036z;
                k.e(list, "getMultiFieldValueClassUnderlyingNameList(...)");
                List<Integer> list2 = list;
                ArrayList arrayList2 = new ArrayList(w.c0(list2, 10));
                for (Integer num : list2) {
                    k.c(num);
                    arrayList2.add(N9.j.x(nameResolver, num.intValue()));
                }
                Pair pair = new Pair(Integer.valueOf(protoBuf$Class.f5022C.size()), Integer.valueOf(protoBuf$Class.f5021B.size()));
                if (pair.equals(new Pair(Integer.valueOf(arrayList2.size()), 0))) {
                    List list3 = protoBuf$Class.f5022C;
                    k.e(list3, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
                    List<Integer> list4 = list3;
                    arrayList = new ArrayList(w.c0(list4, 10));
                    for (Integer num2 : list4) {
                        k.c(num2);
                        arrayList.add(jVar.b(num2.intValue()));
                    }
                } else {
                    if (!pair.equals(new Pair(0, Integer.valueOf(arrayList2.size())))) {
                        throw new IllegalStateException(("class " + N9.j.x(nameResolver, protoBuf$Class.e) + " has illegal multi-field value class representation").toString());
                    }
                    arrayList = protoBuf$Class.f5021B;
                }
                k.c(arrayList);
                Iterable iterable = (Iterable) arrayList;
                ArrayList arrayList3 = new ArrayList(w.c0(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList3.add(deserializedClassDescriptor$computeValueClassRepresentation$1.invoke(it.next()));
                }
                c1537t = new C1541x(v.m1(arrayList2, arrayList3));
            } else if ((protoBuf$Class.c & 8) == 8) {
                G8.f fVarX = N9.j.x(nameResolver, protoBuf$Class.f5034w);
                int i = protoBuf$Class.c;
                ProtoBuf$Type protoBuf$TypeB = (i & 16) == 16 ? protoBuf$Class.f5035x : (i & 32) == 32 ? jVar.b(protoBuf$Class.y) : null;
                if ((protoBuf$TypeB == null || (interfaceC0311c = (InterfaceC0311c) deserializedClassDescriptor$computeValueClassRepresentation$1.invoke(protoBuf$TypeB)) == null) && (interfaceC0311c = (InterfaceC0311c) deserializedClassDescriptor$computeValueClassRepresentation$2.invoke(fVarX)) == null) {
                    throw new IllegalStateException(("cannot determine underlying type for value class " + N9.j.x(nameResolver, protoBuf$Class.e) + " with property " + fVarX).toString());
                }
                c1537t = new C1537t(fVarX, interfaceC0311c);
            } else {
                c1537t = null;
            }
            if (c1537t != null) {
                return c1537t;
            }
            if (!bVar.f.a(1, 5, 1)) {
                C1640i c1640iU = bVar.u();
                if (c1640iU == null) {
                    throw new IllegalStateException(("Inline class has no primary constructor: " + bVar).toString());
                }
                List listX = c1640iU.x();
                k.e(listX, "getValueParameters(...)");
                G8.f name = ((Q) v.A0(listX)).getName();
                k.e(name, "getName(...)");
                A aM = bVar.M(name);
                if (aM != null) {
                    return new C1537t(name, aM);
                }
                throw new IllegalStateException(("Value class has no underlying property: " + bVar).toString());
            }
        }
        return null;
    }
}
