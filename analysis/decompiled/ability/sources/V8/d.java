package V8;

import D7.w;
import h8.AbstractC1532o;
import h8.AbstractC1538u;
import h8.C1531n;
import h8.InterfaceC1494B;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import i8.C1560f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;

/* loaded from: classes4.dex */
public final class d implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1393a;
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b b;

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar, int i) {
        this.f1393a = i;
        this.b = bVar;
    }

    @Override // S7.a
    public final Object invoke() {
        Object next;
        C1531n c1531n;
        int i = this.f1393a;
        int i6 = 1;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = this.b;
        switch (i) {
            case 0:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar2 = this.b;
                ClassKind classKind = bVar2.k;
                if (!classKind.a()) {
                    List list = bVar2.e.p;
                    kotlin.jvm.internal.k.e(list, "getConstructorList(...)");
                    Iterator it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (!D8.e.n.c(((ProtoBuf$Constructor) next).d).booleanValue()) {
                            }
                        } else {
                            next = null;
                        }
                    }
                    ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) next;
                    if (protoBuf$Constructor != null) {
                        return bVar2.l.i.d(protoBuf$Constructor, true);
                    }
                    return null;
                }
                J8.d dVar = new J8.d(bVar2, null, C1560f.f4611a, true, CallableMemberDescriptor$Kind.f4950a, InterfaceC1503K.f4577I);
                List list2 = Collections.EMPTY_LIST;
                int i10 = J8.e.f883a;
                if (classKind == ClassKind.c || classKind.a()) {
                    c1531n = AbstractC1532o.f4583a;
                    if (c1531n == null) {
                        J8.e.a(49);
                        throw null;
                    }
                } else if (J8.e.q(bVar2)) {
                    c1531n = AbstractC1532o.f4583a;
                    if (c1531n == null) {
                        J8.e.a(51);
                        throw null;
                    }
                } else if (J8.e.k(bVar2)) {
                    c1531n = AbstractC1532o.l;
                    if (c1531n == null) {
                        J8.e.a(52);
                        throw null;
                    }
                } else {
                    c1531n = AbstractC1532o.e;
                    if (c1531n == null) {
                        J8.e.a(53);
                        throw null;
                    }
                }
                dVar.f1(list2, c1531n);
                dVar.g = bVar2.g();
                return dVar;
            case 1:
                T8.m mVar = bVar.l;
                List list3 = bVar.e.p;
                kotlin.jvm.internal.k.e(list3, "getConstructorList(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : list3) {
                    if (D8.e.n.c(((ProtoBuf$Constructor) obj).d).booleanValue()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ProtoBuf$Constructor protoBuf$Constructor2 = (ProtoBuf$Constructor) it2.next();
                    T8.v vVar = mVar.i;
                    kotlin.jvm.internal.k.c(protoBuf$Constructor2);
                    arrayList2.add(vVar.d(protoBuf$Constructor2, false));
                }
                return D7.v.Q0(mVar.f1228a.n.d(bVar), D7.v.Q0(H4.o.O(bVar.u()), arrayList2));
            case 2:
                ProtoBuf$Class protoBuf$Class = bVar.e;
                if ((protoBuf$Class.c & 4) != 4) {
                    return null;
                }
                InterfaceC1524g interfaceC1524gB = bVar.L().b(N9.j.x(bVar.l.b, protoBuf$Class.f), NoLookupLocation.g);
                if (interfaceC1524gB instanceof InterfaceC1522e) {
                    return (InterfaceC1522e) interfaceC1524gB;
                }
                return null;
            case 3:
                Modality modality = bVar.i;
                Modality modality2 = Modality.c;
                if (modality != modality2) {
                    return EmptyList.f4893a;
                }
                List<Integer> list4 = bVar.e.u;
                kotlin.jvm.internal.k.c(list4);
                if (list4.isEmpty()) {
                    if (modality != modality2) {
                        return EmptyList.f4893a;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    InterfaceC1527j interfaceC1527j = bVar.f5131q;
                    if (interfaceC1527j instanceof InterfaceC1494B) {
                        J8.m.c(bVar, linkedHashSet, ((InterfaceC1494B) interfaceC1527j).w(), false);
                    }
                    J8.m.c(bVar, linkedHashSet, bVar.O(), true);
                    return D7.v.Z0(linkedHashSet, new J8.h(i6));
                }
                ArrayList arrayList3 = new ArrayList();
                for (Integer num : list4) {
                    T8.m mVar2 = bVar.l;
                    T8.k kVar = mVar2.f1228a;
                    D8.f fVar = mVar2.b;
                    kotlin.jvm.internal.k.c(num);
                    InterfaceC1522e interfaceC1522eB = kVar.b(N9.j.s(fVar, num.intValue()));
                    if (interfaceC1522eB != null) {
                        arrayList3.add(interfaceC1522eB);
                    }
                }
                return arrayList3;
            case 4:
                return D7.v.f1(bVar.l.f1228a.e.A(bVar.f5135v));
            default:
                return AbstractC1538u.c(bVar);
        }
    }
}
