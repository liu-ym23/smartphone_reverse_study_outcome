package wa;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.a0;
import Z8.C1173v;
import Z8.C1174w;
import Z8.C1177z;
import Z8.Z;
import ia.InterfaceC4188h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ka.C4830j;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ra.AbstractC5239l;
import ra.C5231d;
import ua.C5601K;
import ua.C5602L;
import ua.C5629o;
import v9.C5685n;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5863f;
import xa.InterfaceC5864g;
import xa.InterfaceC5865h;
import xa.InterfaceC5866i;

/* loaded from: classes5.dex */
public abstract class u extends AbstractC5239l {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f43202f = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(u.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(u.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};

    /* renamed from: b, reason: collision with root package name */
    public final C5629o f43203b;

    /* renamed from: c, reason: collision with root package name */
    public final a f43204c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h f43205d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5866i f43206e;

    public interface a {
        Collection<E9.O> a(ga.e eVar, M9.b bVar);

        Set<ga.e> b();

        Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e eVar, M9.b bVar);

        Set<ga.e> d();

        void e(Collection<InterfaceC0803h> collection, C5231d c5231d, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l, M9.b bVar);

        a0 f(ga.e eVar);

        Set<ga.e> getVariableNames();
    }

    public final class b implements a {

        /* renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f43207o = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* renamed from: a, reason: collision with root package name */
        public final List<ProtoBuf$Function> f43208a;

        /* renamed from: b, reason: collision with root package name */
        public final List<ProtoBuf$Property> f43209b;

        /* renamed from: c, reason: collision with root package name */
        public final List<ProtoBuf$TypeAlias> f43210c;

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC5865h f43211d;

        /* renamed from: e, reason: collision with root package name */
        public final InterfaceC5865h f43212e;

        /* renamed from: f, reason: collision with root package name */
        public final InterfaceC5865h f43213f;

        /* renamed from: g, reason: collision with root package name */
        public final InterfaceC5865h f43214g;

        /* renamed from: h, reason: collision with root package name */
        public final InterfaceC5865h f43215h;

        /* renamed from: i, reason: collision with root package name */
        public final InterfaceC5865h f43216i;

        /* renamed from: j, reason: collision with root package name */
        public final InterfaceC5865h f43217j;

        /* renamed from: k, reason: collision with root package name */
        public final InterfaceC5865h f43218k;

        /* renamed from: l, reason: collision with root package name */
        public final InterfaceC5865h f43219l;

        /* renamed from: m, reason: collision with root package name */
        public final InterfaceC5865h f43220m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ u f43221n;

        public b(u uVar, List<ProtoBuf$Function> functionList, List<ProtoBuf$Property> propertyList, List<ProtoBuf$TypeAlias> typeAliasList) {
            kotlin.jvm.internal.p.i(functionList, "functionList");
            kotlin.jvm.internal.p.i(propertyList, "propertyList");
            kotlin.jvm.internal.p.i(typeAliasList, "typeAliasList");
            this.f43221n = uVar;
            this.f43208a = functionList;
            this.f43209b = propertyList;
            this.f43210c = uVar.r().c().g().c() ? typeAliasList : C1173v.m();
            this.f43211d = uVar.r().h().i(new v(this));
            this.f43212e = uVar.r().h().i(new w(this));
            this.f43213f = uVar.r().h().i(new x(this));
            this.f43214g = uVar.r().h().i(new y(this));
            this.f43215h = uVar.r().h().i(new z(this));
            this.f43216i = uVar.r().h().i(new C5759A(this));
            this.f43217j = uVar.r().h().i(new C5760B(this));
            this.f43218k = uVar.r().h().i(new C5761C(this));
            this.f43219l = uVar.r().h().i(new C5762D(this, uVar));
            this.f43220m = uVar.r().h().i(new C5763E(this, uVar));
        }

        public static final List A(b bVar) {
            return bVar.v();
        }

        public static final List B(b bVar) {
            return bVar.y();
        }

        public static final Set C(b bVar, u uVar) {
            List<ProtoBuf$Function> list = bVar.f43208a;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            u uVar2 = bVar.f43221n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(C5602L.b(uVar2.r().g(), ((ProtoBuf$Function) ((kotlin.reflect.jvm.internal.impl.protobuf.h) it.next())).w0()));
            }
            return Z.o(linkedHashSet, uVar.v());
        }

        public static final Map D(b bVar) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.g> listE = bVar.E();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listE) {
                ga.e name = ((kotlin.reflect.jvm.internal.impl.descriptors.g) obj).getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return linkedHashMap;
        }

        public static final Map M(b bVar) {
            List<E9.O> listF = bVar.F();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listF) {
                ga.e name = ((E9.O) obj).getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return linkedHashMap;
        }

        public static final Map N(b bVar) {
            List<a0> listG = bVar.G();
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(listG, 10)), 16));
            for (Object obj : listG) {
                ga.e name = ((a0) obj).getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                linkedHashMap.put(name, obj);
            }
            return linkedHashMap;
        }

        public static final Set O(b bVar, u uVar) {
            List<ProtoBuf$Property> list = bVar.f43209b;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            u uVar2 = bVar.f43221n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(C5602L.b(uVar2.r().g(), ((ProtoBuf$Property) ((kotlin.reflect.jvm.internal.impl.protobuf.h) it.next())).M0()));
            }
            return Z.o(linkedHashSet, uVar.w());
        }

        public static final List q(b bVar) {
            return Z8.F.S0(bVar.H(), bVar.t());
        }

        public static final List r(b bVar) {
            return Z8.F.S0(bVar.I(), bVar.u());
        }

        public static final List s(b bVar) {
            return bVar.z();
        }

        public final List<kotlin.reflect.jvm.internal.impl.descriptors.g> E() {
            return (List) C5868k.a(this.f43214g, this, f43207o[3]);
        }

        public final List<E9.O> F() {
            return (List) C5868k.a(this.f43215h, this, f43207o[4]);
        }

        public final List<a0> G() {
            return (List) C5868k.a(this.f43213f, this, f43207o[2]);
        }

        public final List<kotlin.reflect.jvm.internal.impl.descriptors.g> H() {
            return (List) C5868k.a(this.f43211d, this, f43207o[0]);
        }

        public final List<E9.O> I() {
            return (List) C5868k.a(this.f43212e, this, f43207o[1]);
        }

        public final Map<ga.e, Collection<kotlin.reflect.jvm.internal.impl.descriptors.g>> J() {
            return (Map) C5868k.a(this.f43217j, this, f43207o[6]);
        }

        public final Map<ga.e, Collection<E9.O>> K() {
            return (Map) C5868k.a(this.f43218k, this, f43207o[7]);
        }

        public final Map<ga.e, a0> L() {
            return (Map) C5868k.a(this.f43216i, this, f43207o[5]);
        }

        @Override // wa.u.a
        public Collection<E9.O> a(ga.e name, M9.b location) {
            Collection<E9.O> collection;
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(location, "location");
            return (getVariableNames().contains(name) && (collection = K().get(name)) != null) ? collection : C1173v.m();
        }

        @Override // wa.u.a
        public Set<ga.e> b() {
            return (Set) C5868k.a(this.f43219l, this, f43207o[8]);
        }

        @Override // wa.u.a
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collection;
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(location, "location");
            return (b().contains(name) && (collection = J().get(name)) != null) ? collection : C1173v.m();
        }

        @Override // wa.u.a
        public Set<ga.e> d() {
            List<ProtoBuf$TypeAlias> list = this.f43210c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            u uVar = this.f43221n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(C5602L.b(uVar.r().g(), ((ProtoBuf$TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.h) it.next())).a0()));
            }
            return linkedHashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wa.u.a
        public void e(Collection<InterfaceC0803h> result, C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter, M9.b location) {
            kotlin.jvm.internal.p.i(result, "result");
            kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
            kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
            kotlin.jvm.internal.p.i(location, "location");
            if (kindFilter.a(C5231d.f38857c.i())) {
                for (Object obj : F()) {
                    ga.e name = ((E9.O) obj).getName();
                    kotlin.jvm.internal.p.h(name, "getName(...)");
                    if (nameFilter.invoke(name).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.a(C5231d.f38857c.d())) {
                for (Object obj2 : E()) {
                    ga.e name2 = ((kotlin.reflect.jvm.internal.impl.descriptors.g) obj2).getName();
                    kotlin.jvm.internal.p.h(name2, "getName(...)");
                    if (nameFilter.invoke(name2).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }

        @Override // wa.u.a
        public a0 f(ga.e name) {
            kotlin.jvm.internal.p.i(name, "name");
            return L().get(name);
        }

        @Override // wa.u.a
        public Set<ga.e> getVariableNames() {
            return (Set) C5868k.a(this.f43220m, this, f43207o[9]);
        }

        public final List<kotlin.reflect.jvm.internal.impl.descriptors.g> t() {
            Set<ga.e> setV = this.f43221n.v();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setV.iterator();
            while (it.hasNext()) {
                Z8.A.E(arrayList, w((ga.e) it.next()));
            }
            return arrayList;
        }

        public final List<E9.O> u() {
            Set<ga.e> setW = this.f43221n.w();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setW.iterator();
            while (it.hasNext()) {
                Z8.A.E(arrayList, x((ga.e) it.next()));
            }
            return arrayList;
        }

        public final List<kotlin.reflect.jvm.internal.impl.descriptors.g> v() {
            List<ProtoBuf$Function> list = this.f43208a;
            u uVar = this.f43221n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.g gVarV = uVar.r().f().v((ProtoBuf$Function) ((kotlin.reflect.jvm.internal.impl.protobuf.h) it.next()));
                if (!uVar.z(gVarV)) {
                    gVarV = null;
                }
                if (gVarV != null) {
                    arrayList.add(gVarV);
                }
            }
            return arrayList;
        }

        public final List<kotlin.reflect.jvm.internal.impl.descriptors.g> w(ga.e eVar) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.g> listH = H();
            u uVar = this.f43221n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listH) {
                if (kotlin.jvm.internal.p.d(((InterfaceC0803h) obj).getName(), eVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            uVar.m(eVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List<E9.O> x(ga.e eVar) {
            List<E9.O> listI = I();
            u uVar = this.f43221n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                if (kotlin.jvm.internal.p.d(((InterfaceC0803h) obj).getName(), eVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            uVar.n(eVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List<E9.O> y() {
            List<ProtoBuf$Property> list = this.f43209b;
            u uVar = this.f43221n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                E9.O oY = C5601K.y(uVar.r().f(), (ProtoBuf$Property) ((kotlin.reflect.jvm.internal.impl.protobuf.h) it.next()), false, 2, null);
                if (oY != null) {
                    arrayList.add(oY);
                }
            }
            return arrayList;
        }

        public final List<a0> z() {
            List<ProtoBuf$TypeAlias> list = this.f43210c;
            u uVar = this.f43221n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a0 a0VarD = uVar.r().f().D((ProtoBuf$TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.h) it.next()));
                if (a0VarD != null) {
                    arrayList.add(a0VarD);
                }
            }
            return arrayList;
        }
    }

    public final class c implements a {

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f43222j = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(c.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(c.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* renamed from: a, reason: collision with root package name */
        public final Map<ga.e, byte[]> f43223a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<ga.e, byte[]> f43224b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<ga.e, byte[]> f43225c;

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC5863f<ga.e, Collection<kotlin.reflect.jvm.internal.impl.descriptors.g>> f43226d;

        /* renamed from: e, reason: collision with root package name */
        public final InterfaceC5863f<ga.e, Collection<E9.O>> f43227e;

        /* renamed from: f, reason: collision with root package name */
        public final InterfaceC5864g<ga.e, a0> f43228f;

        /* renamed from: g, reason: collision with root package name */
        public final InterfaceC5865h f43229g;

        /* renamed from: h, reason: collision with root package name */
        public final InterfaceC5865h f43230h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ u f43231i;

        public static final class a implements InterfaceC5063a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC4188h f43232a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteArrayInputStream f43233b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ u f43234c;

            public a(InterfaceC4188h interfaceC4188h, ByteArrayInputStream byteArrayInputStream, u uVar) {
                this.f43232a = interfaceC4188h;
                this.f43233b = byteArrayInputStream;
                this.f43234c = uVar;
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.protobuf.h invoke() {
                return (kotlin.reflect.jvm.internal.impl.protobuf.h) this.f43232a.d(this.f43233b, this.f43234c.r().c().k());
            }
        }

        public c(u uVar, List<ProtoBuf$Function> functionList, List<ProtoBuf$Property> propertyList, List<ProtoBuf$TypeAlias> typeAliasList) throws IOException {
            Map<ga.e, byte[]> mapI;
            kotlin.jvm.internal.p.i(functionList, "functionList");
            kotlin.jvm.internal.p.i(propertyList, "propertyList");
            kotlin.jvm.internal.p.i(typeAliasList, "typeAliasList");
            this.f43231i = uVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                ga.e eVarB = C5602L.b(uVar.r().g(), ((ProtoBuf$Function) ((kotlin.reflect.jvm.internal.impl.protobuf.h) obj)).w0());
                Object arrayList = linkedHashMap.get(eVarB);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(eVarB, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f43223a = q(linkedHashMap);
            u uVar2 = this.f43231i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : propertyList) {
                ga.e eVarB2 = C5602L.b(uVar2.r().g(), ((ProtoBuf$Property) ((kotlin.reflect.jvm.internal.impl.protobuf.h) obj2)).M0());
                Object arrayList2 = linkedHashMap2.get(eVarB2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(eVarB2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f43224b = q(linkedHashMap2);
            if (this.f43231i.r().c().g().c()) {
                u uVar3 = this.f43231i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : typeAliasList) {
                    ga.e eVarB3 = C5602L.b(uVar3.r().g(), ((ProtoBuf$TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.h) obj3)).a0());
                    Object arrayList3 = linkedHashMap3.get(eVarB3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(eVarB3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapI = q(linkedHashMap3);
            } else {
                mapI = kotlin.collections.a.i();
            }
            this.f43225c = mapI;
            this.f43226d = this.f43231i.r().h().c(new C5764F(this));
            this.f43227e = this.f43231i.r().h().c(new C5765G(this));
            this.f43228f = this.f43231i.r().h().f(new C5766H(this));
            this.f43229g = this.f43231i.r().h().i(new C5767I(this, this.f43231i));
            this.f43230h = this.f43231i.r().h().i(new C5768J(this, this.f43231i));
        }

        public static final Set o(c cVar, u uVar) {
            return Z.o(cVar.f43223a.keySet(), uVar.v());
        }

        public static final Collection p(c cVar, ga.e it) {
            kotlin.jvm.internal.p.i(it, "it");
            return cVar.l(it);
        }

        public static final Collection r(c cVar, ga.e it) {
            kotlin.jvm.internal.p.i(it, "it");
            return cVar.m(it);
        }

        public static final a0 s(c cVar, ga.e it) {
            kotlin.jvm.internal.p.i(it, "it");
            return cVar.n(it);
        }

        public static final Set t(c cVar, u uVar) {
            return Z.o(cVar.f43224b.keySet(), uVar.w());
        }

        @Override // wa.u.a
        public Collection<E9.O> a(ga.e name, M9.b location) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(location, "location");
            return !getVariableNames().contains(name) ? C1173v.m() : this.f43227e.invoke(name);
        }

        @Override // wa.u.a
        public Set<ga.e> b() {
            return (Set) C5868k.a(this.f43229g, this, f43222j[0]);
        }

        @Override // wa.u.a
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(location, "location");
            return !b().contains(name) ? C1173v.m() : this.f43226d.invoke(name);
        }

        @Override // wa.u.a
        public Set<ga.e> d() {
            return this.f43225c.keySet();
        }

        @Override // wa.u.a
        public void e(Collection<InterfaceC0803h> result, C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter, M9.b location) {
            kotlin.jvm.internal.p.i(result, "result");
            kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
            kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
            kotlin.jvm.internal.p.i(location, "location");
            if (kindFilter.a(C5231d.f38857c.i())) {
                Set<ga.e> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (ga.e eVar : variableNames) {
                    if (nameFilter.invoke(eVar).booleanValue()) {
                        arrayList.addAll(a(eVar, location));
                    }
                }
                C4830j INSTANCE = C4830j.f34656a;
                kotlin.jvm.internal.p.h(INSTANCE, "INSTANCE");
                C1177z.C(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.a(C5231d.f38857c.d())) {
                Set<ga.e> setB = b();
                ArrayList arrayList2 = new ArrayList();
                for (ga.e eVar2 : setB) {
                    if (nameFilter.invoke(eVar2).booleanValue()) {
                        arrayList2.addAll(c(eVar2, location));
                    }
                }
                C4830j INSTANCE2 = C4830j.f34656a;
                kotlin.jvm.internal.p.h(INSTANCE2, "INSTANCE");
                C1177z.C(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }

        @Override // wa.u.a
        public a0 f(ga.e name) {
            kotlin.jvm.internal.p.i(name, "name");
            return this.f43228f.invoke(name);
        }

        @Override // wa.u.a
        public Set<ga.e> getVariableNames() {
            return (Set) C5868k.a(this.f43230h, this, f43222j[1]);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> l(ga.e r5) {
            /*
                r4 = this;
                java.util.Map<ga.e, byte[]> r0 = r4.f43223a
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.f35425A
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.p.h(r1, r2)
                wa.u r2 = r4.f43231i
                java.lang.Object r0 = r0.get(r5)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2c
                wa.u r4 = r4.f43231i
                java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
                r3.<init>(r0)
                wa.u$c$a r0 = new wa.u$c$a
                r0.<init>(r1, r3, r4)
                Ka.j r4 = Ka.t.r(r0)
                java.util.List r4 = kotlin.sequences.SequencesKt___SequencesKt.d0(r4)
                if (r4 == 0) goto L2c
                java.util.Collection r4 = (java.util.Collection) r4
                goto L32
            L2c:
                java.util.List r4 = Z8.C1173v.m()
                java.util.Collection r4 = (java.util.Collection) r4
            L32:
                r0 = r4
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = r4.size()
                r1.<init>(r4)
                java.util.Iterator r4 = r0.iterator()
            L42:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L6b
                java.lang.Object r0 = r4.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r0
                ua.o r3 = r2.r()
                ua.K r3 = r3.f()
                kotlin.jvm.internal.p.f(r0)
                kotlin.reflect.jvm.internal.impl.descriptors.g r0 = r3.v(r0)
                boolean r3 = r2.z(r0)
                if (r3 == 0) goto L64
                goto L65
            L64:
                r0 = 0
            L65:
                if (r0 == 0) goto L42
                r1.add(r0)
                goto L42
            L6b:
                r2.m(r5, r1)
                java.util.List r4 = Ia.a.c(r1)
                java.util.Collection r4 = (java.util.Collection) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: wa.u.c.l(ga.e):java.util.Collection");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Collection<E9.O> m(ga.e r8) {
            /*
                r7 = this;
                java.util.Map<ga.e, byte[]> r0 = r7.f43224b
                ia.h<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.f35502E
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.p.h(r1, r2)
                wa.u r2 = r7.f43231i
                java.lang.Object r0 = r0.get(r8)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2c
                wa.u r7 = r7.f43231i
                java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
                r3.<init>(r0)
                wa.u$c$a r0 = new wa.u$c$a
                r0.<init>(r1, r3, r7)
                Ka.j r7 = Ka.t.r(r0)
                java.util.List r7 = kotlin.sequences.SequencesKt___SequencesKt.d0(r7)
                if (r7 == 0) goto L2c
                java.util.Collection r7 = (java.util.Collection) r7
                goto L32
            L2c:
                java.util.List r7 = Z8.C1173v.m()
                java.util.Collection r7 = (java.util.Collection) r7
            L32:
                r0 = r7
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                int r7 = r7.size()
                r1.<init>(r7)
                java.util.Iterator r7 = r0.iterator()
            L42:
                boolean r0 = r7.hasNext()
                if (r0 == 0) goto L66
                java.lang.Object r0 = r7.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r0
                ua.o r3 = r2.r()
                ua.K r3 = r3.f()
                kotlin.jvm.internal.p.f(r0)
                r4 = 2
                r5 = 0
                r6 = 0
                E9.O r0 = ua.C5601K.y(r3, r0, r6, r4, r5)
                if (r0 == 0) goto L42
                r1.add(r0)
                goto L42
            L66:
                r2.n(r8, r1)
                java.util.List r7 = Ia.a.c(r1)
                java.util.Collection r7 = (java.util.Collection) r7
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: wa.u.c.m(ga.e):java.util.Collection");
        }

        public final a0 n(ga.e eVar) {
            ProtoBuf$TypeAlias protoBuf$TypeAliasR0;
            byte[] bArr = this.f43225c.get(eVar);
            if (bArr == null || (protoBuf$TypeAliasR0 = ProtoBuf$TypeAlias.r0(new ByteArrayInputStream(bArr), this.f43231i.r().c().k())) == null) {
                return null;
            }
            return this.f43231i.r().f().D(protoBuf$TypeAliasR0);
        }

        public final Map<ga.e, byte[]> q(Map<ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.a) it2.next()).c(byteArrayOutputStream);
                    arrayList.add(Y8.t.f7040a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    public u(C5629o c10, List<ProtoBuf$Function> functionList, List<ProtoBuf$Property> propertyList, List<ProtoBuf$TypeAlias> typeAliasList, InterfaceC5063a<? extends Collection<ga.e>> classNames) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(functionList, "functionList");
        kotlin.jvm.internal.p.i(propertyList, "propertyList");
        kotlin.jvm.internal.p.i(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.p.i(classNames, "classNames");
        this.f43203b = c10;
        this.f43204c = p(functionList, propertyList, typeAliasList);
        this.f43205d = c10.h().i(new C5795s(classNames));
        this.f43206e = c10.h().h(new C5796t(this));
    }

    public static final Set j(InterfaceC5063a interfaceC5063a) {
        return Z8.F.r1((Iterable) interfaceC5063a.invoke());
    }

    public static final Set k(u uVar) {
        Set<ga.e> setU = uVar.u();
        if (setU == null) {
            return null;
        }
        return Z.o(Z.o(uVar.s(), uVar.f43204c.d()), setU);
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<E9.O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return this.f43204c.a(name, location);
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> b() {
        return this.f43204c.b();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return this.f43204c.c(name, location);
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        if (y(name)) {
            return q(name);
        }
        if (this.f43204c.d().contains(name)) {
            return x(name);
        }
        return null;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> f() {
        return t();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        return this.f43204c.getVariableNames();
    }

    public abstract void i(Collection<InterfaceC0803h> collection, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l);

    public final Collection<InterfaceC0803h> l(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter, M9.b location) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        kotlin.jvm.internal.p.i(location, "location");
        ArrayList arrayList = new ArrayList(0);
        C5231d.a aVar = C5231d.f38857c;
        if (kindFilter.a(aVar.g())) {
            i(arrayList, nameFilter);
        }
        this.f43204c.e(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.a(aVar.c())) {
            for (ga.e eVar : s()) {
                if (nameFilter.invoke(eVar).booleanValue()) {
                    Ia.a.a(arrayList, q(eVar));
                }
            }
        }
        if (kindFilter.a(C5231d.f38857c.h())) {
            for (ga.e eVar2 : this.f43204c.d()) {
                if (nameFilter.invoke(eVar2).booleanValue()) {
                    Ia.a.a(arrayList, this.f43204c.f(eVar2));
                }
            }
        }
        return Ia.a.c(arrayList);
    }

    public void m(ga.e name, List<kotlin.reflect.jvm.internal.impl.descriptors.g> functions) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(functions, "functions");
    }

    public void n(ga.e name, List<E9.O> descriptors) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(descriptors, "descriptors");
    }

    public abstract ga.b o(ga.e eVar);

    public final a p(List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
        return this.f43203b.c().g().a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    public final InterfaceC0797b q(ga.e eVar) {
        return this.f43203b.c().b(o(eVar));
    }

    public final C5629o r() {
        return this.f43203b;
    }

    public final Set<ga.e> s() {
        return (Set) C5868k.a(this.f43205d, this, f43202f[0]);
    }

    public final Set<ga.e> t() {
        return (Set) C5868k.b(this.f43206e, this, f43202f[1]);
    }

    public abstract Set<ga.e> u();

    public abstract Set<ga.e> v();

    public abstract Set<ga.e> w();

    public final a0 x(ga.e eVar) {
        return this.f43204c.f(eVar);
    }

    public boolean y(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return s().contains(name);
    }

    public boolean z(kotlin.reflect.jvm.internal.impl.descriptors.g function) {
        kotlin.jvm.internal.p.i(function, "function");
        return true;
    }
}
