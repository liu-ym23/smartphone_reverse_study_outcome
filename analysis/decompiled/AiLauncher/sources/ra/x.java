package ra;

import E9.InterfaceC0803h;
import E9.O;
import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ka.C4835o;
import kotlin.Pair;
import p9.InterfaceC5074l;
import ya.S;

/* loaded from: classes5.dex */
public final class x extends AbstractC5228a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f38916d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f38917b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5238k f38918c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final InterfaceC5238k a(String message, Collection<? extends S> types) {
            kotlin.jvm.internal.p.i(message, "message");
            kotlin.jvm.internal.p.i(types, "types");
            Collection<? extends S> collection = types;
            ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((S) it.next()).m());
            }
            Ia.j<InterfaceC5238k> jVarB = Ha.a.b(arrayList);
            InterfaceC5238k interfaceC5238kB = C5229b.f38851d.b(message, jVarB);
            return jVarB.size() <= 1 ? interfaceC5238kB : new x(message, interfaceC5238kB, null);
        }

        public a() {
        }
    }

    public /* synthetic */ x(String str, InterfaceC5238k interfaceC5238k, kotlin.jvm.internal.i iVar) {
        this(str, interfaceC5238k);
    }

    public static final InterfaceC5238k l(String str, Collection<? extends S> collection) {
        return f38916d.a(str, collection);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.a m(kotlin.reflect.jvm.internal.impl.descriptors.a selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.p.i(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.a n(kotlin.reflect.jvm.internal.impl.descriptors.g selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.p.i(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.a o(O selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.p.i(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    @Override // ra.AbstractC5228a, ra.InterfaceC5238k
    public Collection<O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return C4835o.b(super.a(name, location), v.f38914a);
    }

    @Override // ra.AbstractC5228a, ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return C4835o.b(super.c(name, location), u.f38913a);
    }

    @Override // ra.AbstractC5228a, ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        Collection<InterfaceC0803h> collectionE = super.e(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionE) {
            if (((InterfaceC0803h) obj) instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.a();
        List list2 = (List) pair.b();
        kotlin.jvm.internal.p.g(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return F.S0(C4835o.b(list, w.f38915a), list2);
    }

    @Override // ra.AbstractC5228a
    public InterfaceC5238k h() {
        return this.f38918c;
    }

    public x(String str, InterfaceC5238k interfaceC5238k) {
        this.f38917b = str;
        this.f38918c = interfaceC5238k;
    }
}
