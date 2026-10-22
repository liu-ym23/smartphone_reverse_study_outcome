package ra;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.O;
import Z8.A;
import Z8.C1173v;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ka.AbstractC4831k;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import p9.InterfaceC5074l;
import ra.InterfaceC5241n;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.S;

/* renamed from: ra.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5233f extends AbstractC5239l {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f38886d = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(AbstractC5233f.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0797b f38887b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5865h f38888c;

    /* renamed from: ra.f$a */
    public static final class a extends AbstractC4831k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList<InterfaceC0803h> f38889a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC5233f f38890b;

        public a(ArrayList<InterfaceC0803h> arrayList, AbstractC5233f abstractC5233f) {
            this.f38889a = arrayList;
            this.f38890b = abstractC5233f;
        }

        @Override // ka.AbstractC4832l
        public void a(CallableMemberDescriptor fakeOverride) {
            kotlin.jvm.internal.p.i(fakeOverride, "fakeOverride");
            OverridingUtil.K(fakeOverride, null);
            this.f38889a.add(fakeOverride);
        }

        @Override // ka.AbstractC4831k
        public void e(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
            kotlin.jvm.internal.p.i(fromSuper, "fromSuper");
            kotlin.jvm.internal.p.i(fromCurrent, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f38890b.l() + ": " + fromSuper + " vs " + fromCurrent).toString());
        }
    }

    public AbstractC5233f(InterfaceC5869l storageManager, InterfaceC0797b containingClass) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(containingClass, "containingClass");
        this.f38887b = containingClass;
        this.f38888c = storageManager.i(new C5232e(this));
    }

    public static final List h(AbstractC5233f abstractC5233f) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.e> listI = abstractC5233f.i();
        return F.S0(listI, abstractC5233f.j(listI));
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<O> a(ga.e name, M9.b location) {
        List listM;
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        List<InterfaceC0803h> listK = k();
        if (listK.isEmpty()) {
            listM = C1173v.m();
        } else {
            Ia.j jVar = new Ia.j();
            for (Object obj : listK) {
                if ((obj instanceof O) && kotlin.jvm.internal.p.d(((O) obj).getName(), name)) {
                    jVar.add(obj);
                }
            }
            listM = jVar;
        }
        return listM;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        List listM;
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        List<InterfaceC0803h> listK = k();
        if (listK.isEmpty()) {
            listM = C1173v.m();
        } else {
            Ia.j jVar = new Ia.j();
            for (Object obj : listK) {
                if ((obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) && kotlin.jvm.internal.p.d(((kotlin.reflect.jvm.internal.impl.descriptors.g) obj).getName(), name)) {
                    jVar.add(obj);
                }
            }
            listM = jVar;
        }
        return listM;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return !kindFilter.a(C5231d.f38870p.m()) ? C1173v.m() : k();
    }

    public abstract List<kotlin.reflect.jvm.internal.impl.descriptors.e> i();

    /* JADX WARN: Multi-variable type inference failed */
    public final List<InterfaceC0803h> j(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> list) {
        Collection<? extends CallableMemberDescriptor> collectionM;
        ArrayList arrayList = new ArrayList(3);
        Collection<S> collectionE = this.f38887b.j().e();
        kotlin.jvm.internal.p.h(collectionE, "getSupertypes(...)");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = collectionE.iterator();
        while (it.hasNext()) {
            A.E(arrayList2, InterfaceC5241n.a.a(((S) it.next()).m(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            ga.e name = ((CallableMemberDescriptor) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            kotlin.jvm.internal.p.h(key, "component1(...)");
            ga.e eVar = (ga.e) key;
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((CallableMemberDescriptor) obj3) instanceof kotlin.reflect.jvm.internal.impl.descriptors.e);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.f35978f;
                List list4 = list3;
                if (zBooleanValue) {
                    collectionM = new ArrayList<>();
                    for (Object obj4 : list) {
                        if (kotlin.jvm.internal.p.d(((kotlin.reflect.jvm.internal.impl.descriptors.e) obj4).getName(), eVar)) {
                            collectionM.add(obj4);
                        }
                    }
                } else {
                    collectionM = C1173v.m();
                }
                overridingUtil.v(eVar, list4, collectionM, this.f38887b, new a(arrayList, this));
            }
        }
        return Ia.a.c(arrayList);
    }

    public final List<InterfaceC0803h> k() {
        return (List) C5868k.a(this.f38888c, this, f38886d[0]);
    }

    public final InterfaceC0797b l() {
        return this.f38887b;
    }
}
