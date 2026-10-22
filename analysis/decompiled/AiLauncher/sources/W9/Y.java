package W9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import Ia.b;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ka.C4827g;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import ra.C5231d;
import ra.InterfaceC5238k;

/* loaded from: classes5.dex */
public final class Y extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b {

    /* renamed from: n, reason: collision with root package name */
    public final Z9.g f6712n;

    /* renamed from: o, reason: collision with root package name */
    public final U9.c f6713o;

    public static final class a extends b.AbstractC0058b<InterfaceC0797b, Y8.t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0797b f6714a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set<R> f6715b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<InterfaceC5238k, Collection<R>> f6716c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC0797b interfaceC0797b, Set<R> set, InterfaceC5074l<? super InterfaceC5238k, ? extends Collection<? extends R>> interfaceC5074l) {
            this.f6714a = interfaceC0797b;
            this.f6715b = set;
            this.f6716c = interfaceC5074l;
        }

        @Override // Ia.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return Y8.t.f7040a;
        }

        @Override // Ia.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC0797b current) {
            kotlin.jvm.internal.p.i(current, "current");
            if (current == this.f6714a) {
                return true;
            }
            InterfaceC5238k interfaceC5238kG0 = current.g0();
            kotlin.jvm.internal.p.h(interfaceC5238kG0, "getStaticScope(...)");
            if (!(interfaceC5238kG0 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b)) {
                return true;
            }
            this.f6715b.addAll((Collection) this.f6716c.invoke(interfaceC5238kG0));
            return false;
        }

        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(V9.k c10, Z9.g jClass, U9.c ownerDescriptor) {
        super(c10);
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(jClass, "jClass");
        kotlin.jvm.internal.p.i(ownerDescriptor, "ownerDescriptor");
        this.f6712n = jClass;
        this.f6713o = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l0(Z9.q it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.isStatic();
    }

    public static final Collection m0(ga.e eVar, InterfaceC5238k it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.a(eVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }

    public static final Collection n0(InterfaceC5238k it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getVariableNames();
    }

    public static final Iterable p0(InterfaceC0797b interfaceC0797b) {
        Collection<ya.S> collectionE = interfaceC0797b.j().e();
        kotlin.jvm.internal.p.h(collectionE, "getSupertypes(...)");
        return SequencesKt___SequencesKt.z(SequencesKt___SequencesKt.S(Z8.F.d0(collectionE), X.f6711a));
    }

    public static final InterfaceC0797b q0(ya.S s10) {
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void A(Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> result, ga.e name) {
        kotlin.jvm.internal.p.i(result, "result");
        kotlin.jvm.internal.p.i(name, "name");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collectionE = T9.a.e(name, t0(name, Q()), result, Q(), K().a().c(), K().a().k().a());
        kotlin.jvm.internal.p.h(collectionE, "resolveOverridesForStaticMembers(...)");
        result.addAll(collectionE);
        if (this.f6712n.v()) {
            if (kotlin.jvm.internal.p.d(name, C9.o.f1825f)) {
                kotlin.reflect.jvm.internal.impl.descriptors.g gVarG = C4827g.g(Q());
                kotlin.jvm.internal.p.h(gVarG, "createEnumValueOfMethod(...)");
                result.add(gVarG);
            } else if (kotlin.jvm.internal.p.d(name, C9.o.f1823d)) {
                kotlin.reflect.jvm.internal.impl.descriptors.g gVarH = C4827g.h(Q());
                kotlin.jvm.internal.p.h(gVarH, "createEnumValuesMethod(...)");
                result.add(gVarH);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void B(ga.e name, Collection<E9.O> result) {
        ga.e eVar;
        Collection<E9.O> collection;
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(result, "result");
        Set setO0 = o0(Q(), new LinkedHashSet(), new V(name));
        if (result.isEmpty()) {
            eVar = name;
            collection = result;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : setO0) {
                E9.O oS0 = s0((E9.O) obj);
                Object arrayList = linkedHashMap.get(oS0);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(oS0, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collectionE = T9.a.e(eVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, Q(), K().a().c(), K().a().k().a());
                kotlin.jvm.internal.p.h(collectionE, "resolveOverridesForStaticMembers(...)");
                Z8.A.E(arrayList2, collectionE);
            }
            collection.addAll(arrayList2);
        } else {
            eVar = name;
            collection = result;
            Collection<? extends E9.O> collectionE2 = T9.a.e(eVar, setO0, collection, Q(), K().a().c(), K().a().k().a());
            kotlin.jvm.internal.p.h(collectionE2, "resolveOverridesForStaticMembers(...)");
            collection.addAll(collectionE2);
        }
        if (this.f6712n.v() && kotlin.jvm.internal.p.d(eVar, C9.o.f1824e)) {
            Ia.a.a(collection, C4827g.f(Q()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> C(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        Set<ga.e> setQ1 = Z8.F.q1(M().invoke().d());
        o0(Q(), setQ1, U.f6708a);
        if (this.f6712n.v()) {
            setQ1.add(C9.o.f1824e);
        }
        return setQ1;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C1093b y() {
        return new C1093b(this.f6712n, T.f6707a);
    }

    public final <R> Set<R> o0(InterfaceC0797b interfaceC0797b, Set<R> set, InterfaceC5074l<? super InterfaceC5238k, ? extends Collection<? extends R>> interfaceC5074l) {
        Ia.b.b(C1172u.e(interfaceC0797b), W.f6710a, new a(interfaceC0797b, set, interfaceC5074l));
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public U9.c Q() {
        return this.f6713o;
    }

    public final E9.O s0(E9.O o10) {
        if (o10.getKind().isReal()) {
            return o10;
        }
        Collection<? extends E9.O> collectionD = o10.d();
        kotlin.jvm.internal.p.h(collectionD, "getOverriddenDescriptors(...)");
        Collection<? extends E9.O> collection = collectionD;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        for (E9.O o11 : collection) {
            kotlin.jvm.internal.p.f(o11);
            arrayList.add(s0(o11));
        }
        return (E9.O) Z8.F.X0(Z8.F.g0(arrayList));
    }

    public final Set<kotlin.reflect.jvm.internal.impl.descriptors.g> t0(ga.e eVar, InterfaceC0797b interfaceC0797b) {
        Y yB = U9.g.b(interfaceC0797b);
        return yB == null ? Z8.Y.e() : Z8.F.r1(yB.c(eVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> u(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        return Z8.Y.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> w(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        Set<ga.e> setQ1 = Z8.F.q1(M().invoke().b());
        Y yB = U9.g.b(Q());
        Set<ga.e> setB = yB != null ? yB.b() : null;
        if (setB == null) {
            setB = Z8.Y.e();
        }
        setQ1.addAll(setB);
        if (this.f6712n.v()) {
            setQ1.addAll(C1173v.p(C9.o.f1825f, C9.o.f1823d));
        }
        setQ1.addAll(K().a().w().g(Q(), K()));
        return setQ1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void x(Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> result, ga.e name) {
        kotlin.jvm.internal.p.i(result, "result");
        kotlin.jvm.internal.p.i(name, "name");
        K().a().w().d(Q(), name, result, K());
    }
}
