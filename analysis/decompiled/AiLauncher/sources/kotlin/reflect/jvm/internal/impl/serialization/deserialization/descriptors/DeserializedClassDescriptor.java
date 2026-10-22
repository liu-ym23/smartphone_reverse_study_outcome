package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import E9.AbstractC0811p;
import E9.C0813s;
import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import E9.V;
import E9.W;
import E9.Z;
import E9.b0;
import E9.f0;
import E9.g0;
import E9.i0;
import F9.g;
import H9.AbstractC0822a;
import H9.AbstractC0839s;
import H9.C0830i;
import H9.C0838q;
import H9.N;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import ea.AbstractC4017a;
import ea.C4018b;
import ea.InterfaceC4020d;
import ea.h;
import ea.j;
import ga.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ka.AbstractC4831k;
import ka.C4821a;
import ka.C4827g;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import p9.InterfaceC5074l;
import ra.AbstractC5239l;
import ra.C5231d;
import ra.C5244q;
import ra.InterfaceC5238k;
import ra.InterfaceC5241n;
import sa.C5455b;
import ua.AbstractC5604N;
import ua.C5601K;
import ua.C5602L;
import ua.C5605O;
import ua.C5606P;
import ua.C5614Y;
import ua.C5627m;
import ua.C5629o;
import ua.InterfaceC5636v;
import v9.C5685n;
import wa.C5775Q;
import wa.C5777a;
import wa.C5780d;
import wa.C5781e;
import wa.C5782f;
import wa.C5783g;
import wa.C5784h;
import wa.C5785i;
import wa.C5786j;
import wa.C5787k;
import wa.C5788l;
import wa.C5789m;
import wa.C5790n;
import wa.C5791o;
import wa.C5792p;
import wa.u;
import xa.InterfaceC5864g;
import xa.InterfaceC5865h;
import xa.InterfaceC5866i;
import ya.AbstractC5985b;
import ya.AbstractC5990d0;
import ya.S;
import ya.v0;

/* loaded from: classes5.dex */
public final class DeserializedClassDescriptor extends AbstractC0822a implements InterfaceC0803h {

    /* renamed from: f, reason: collision with root package name */
    public final ProtoBuf$Class f36017f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC4017a f36018g;

    /* renamed from: h, reason: collision with root package name */
    public final W f36019h;

    /* renamed from: i, reason: collision with root package name */
    public final ga.b f36020i;

    /* renamed from: j, reason: collision with root package name */
    public final Modality f36021j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC0811p f36022k;

    /* renamed from: l, reason: collision with root package name */
    public final ClassKind f36023l;

    /* renamed from: m, reason: collision with root package name */
    public final C5629o f36024m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f36025n;

    /* renamed from: o, reason: collision with root package name */
    public final AbstractC5239l f36026o;

    /* renamed from: p, reason: collision with root package name */
    public final b f36027p;

    /* renamed from: q, reason: collision with root package name */
    public final V<a> f36028q;

    /* renamed from: r, reason: collision with root package name */
    public final c f36029r;

    /* renamed from: s, reason: collision with root package name */
    public final InterfaceC0803h f36030s;

    /* renamed from: t, reason: collision with root package name */
    public final InterfaceC5866i<kotlin.reflect.jvm.internal.impl.descriptors.b> f36031t;

    /* renamed from: u, reason: collision with root package name */
    public final InterfaceC5865h<Collection<kotlin.reflect.jvm.internal.impl.descriptors.b>> f36032u;

    /* renamed from: v, reason: collision with root package name */
    public final InterfaceC5866i<InterfaceC0797b> f36033v;

    /* renamed from: w, reason: collision with root package name */
    public final InterfaceC5865h<Collection<InterfaceC0797b>> f36034w;

    /* renamed from: x, reason: collision with root package name */
    public final InterfaceC5866i<g0<AbstractC5990d0>> f36035x;

    /* renamed from: y, reason: collision with root package name */
    public final AbstractC5604N.a f36036y;

    /* renamed from: z, reason: collision with root package name */
    public final g f36037z;

    public final class a extends u {

        /* renamed from: g, reason: collision with root package name */
        public final kotlin.reflect.jvm.internal.impl.types.checker.c f36038g;

        /* renamed from: h, reason: collision with root package name */
        public final InterfaceC5865h<Collection<InterfaceC0803h>> f36039h;

        /* renamed from: i, reason: collision with root package name */
        public final InterfaceC5865h<Collection<S>> f36040i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ DeserializedClassDescriptor f36041j;

        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$a$a, reason: collision with other inner class name */
        public static final class C0457a extends AbstractC4831k {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List<D> f36042a;

            public C0457a(List<D> list) {
                this.f36042a = list;
            }

            @Override // ka.AbstractC4832l
            public void a(CallableMemberDescriptor fakeOverride) {
                p.i(fakeOverride, "fakeOverride");
                OverridingUtil.K(fakeOverride, null);
                this.f36042a.add(fakeOverride);
            }

            @Override // ka.AbstractC4831k
            public void e(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
                p.i(fromSuper, "fromSuper");
                p.i(fromCurrent, "fromCurrent");
                if (fromCurrent instanceof AbstractC0839s) {
                    ((AbstractC0839s) fromCurrent).O0(d.f35010a, fromSuper);
                }
            }
        }

        public a(DeserializedClassDescriptor deserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f36041j = deserializedClassDescriptor;
            C5629o c5629oX0 = deserializedClassDescriptor.X0();
            List<ProtoBuf$Function> listK0 = deserializedClassDescriptor.Y0().K0();
            p.h(listK0, "getFunctionList(...)");
            List<ProtoBuf$Property> listR0 = deserializedClassDescriptor.Y0().R0();
            p.h(listR0, "getPropertyList(...)");
            List<ProtoBuf$TypeAlias> listZ0 = deserializedClassDescriptor.Y0().Z0();
            p.h(listZ0, "getTypeAliasList(...)");
            List<Integer> listO0 = deserializedClassDescriptor.Y0().O0();
            p.h(listO0, "getNestedClassNameList(...)");
            List<Integer> list = listO0;
            InterfaceC4020d interfaceC4020dG = deserializedClassDescriptor.X0().g();
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(C5602L.b(interfaceC4020dG, ((Number) it.next()).intValue()));
            }
            super(c5629oX0, listK0, listR0, listZ0, new C5786j(arrayList));
            this.f36038g = kotlinTypeRefiner;
            this.f36039h = r().h().i(new C5787k(this));
            this.f36040i = r().h().i(new C5788l(this));
        }

        public static final List A(List list) {
            return list;
        }

        public static final Collection E(a aVar) {
            return aVar.l(C5231d.f38869o, InterfaceC5238k.f38895a.c(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        }

        public static final Collection I(a aVar) {
            return aVar.f36038g.g(aVar.G());
        }

        public final <D extends CallableMemberDescriptor> void F(e eVar, Collection<? extends D> collection, List<D> list) {
            r().c().n().a().v(eVar, collection, new ArrayList(list), G(), new C0457a(list));
        }

        public final DeserializedClassDescriptor G() {
            return this.f36041j;
        }

        public void H(e name, M9.b location) {
            p.i(name, "name");
            p.i(location, "location");
            L9.a.a(r().c().p(), location, G(), name);
        }

        @Override // wa.u, ra.AbstractC5239l, ra.InterfaceC5238k
        public Collection<O> a(e name, M9.b location) {
            p.i(name, "name");
            p.i(location, "location");
            H(name, location);
            return super.a(name, location);
        }

        @Override // wa.u, ra.AbstractC5239l, ra.InterfaceC5238k
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(e name, M9.b location) {
            p.i(name, "name");
            p.i(location, "location");
            H(name, location);
            return super.c(name, location);
        }

        @Override // wa.u, ra.AbstractC5239l, ra.InterfaceC5241n
        public InterfaceC0799d d(e name, M9.b location) {
            InterfaceC0797b interfaceC0797bI;
            p.i(name, "name");
            p.i(location, "location");
            H(name, location);
            c cVar = G().f36029r;
            return (cVar == null || (interfaceC0797bI = cVar.i(name)) == null) ? super.d(name, location) : interfaceC0797bI;
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5241n
        public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super e, Boolean> nameFilter) {
            p.i(kindFilter, "kindFilter");
            p.i(nameFilter, "nameFilter");
            return this.f36039h.invoke();
        }

        @Override // wa.u
        public void i(Collection<InterfaceC0803h> result, InterfaceC5074l<? super e, Boolean> nameFilter) {
            p.i(result, "result");
            p.i(nameFilter, "nameFilter");
            c cVar = G().f36029r;
            List listD = cVar != null ? cVar.d() : null;
            if (listD == null) {
                listD = C1173v.m();
            }
            result.addAll(listD);
        }

        @Override // wa.u
        public void m(e name, List<kotlin.reflect.jvm.internal.impl.descriptors.g> functions) {
            p.i(name, "name");
            p.i(functions, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator<S> it = this.f36040i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().m().c(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            functions.addAll(r().c().c().c(name, this.f36041j));
            F(name, arrayList, functions);
        }

        @Override // wa.u
        public void n(e name, List<O> descriptors) {
            p.i(name, "name");
            p.i(descriptors, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator<S> it = this.f36040i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().m().a(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            F(name, arrayList, descriptors);
        }

        @Override // wa.u
        public ga.b o(e name) {
            p.i(name, "name");
            return this.f36041j.f36020i.d(name);
        }

        @Override // wa.u
        public Set<e> u() {
            List<S> listE = G().f36027p.e();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listE.iterator();
            while (it.hasNext()) {
                Set<e> setF = ((S) it.next()).m().f();
                if (setF == null) {
                    return null;
                }
                A.E(linkedHashSet, setF);
            }
            return linkedHashSet;
        }

        @Override // wa.u
        public Set<e> v() {
            List<S> listE = G().f36027p.e();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listE.iterator();
            while (it.hasNext()) {
                A.E(linkedHashSet, ((S) it.next()).m().b());
            }
            linkedHashSet.addAll(r().c().c().d(this.f36041j));
            return linkedHashSet;
        }

        @Override // wa.u
        public Set<e> w() {
            List<S> listE = G().f36027p.e();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listE.iterator();
            while (it.hasNext()) {
                A.E(linkedHashSet, ((S) it.next()).m().getVariableNames());
            }
            return linkedHashSet;
        }

        @Override // wa.u
        public boolean z(kotlin.reflect.jvm.internal.impl.descriptors.g function) {
            p.i(function, "function");
            return r().c().t().b(this.f36041j, function);
        }
    }

    public final class b extends AbstractC5985b {

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC5865h<List<b0>> f36043d;

        public b() {
            super(DeserializedClassDescriptor.this.X0().h());
            this.f36043d = DeserializedClassDescriptor.this.X0().h().i(new C5789m(DeserializedClassDescriptor.this));
        }

        public static final List M(DeserializedClassDescriptor deserializedClassDescriptor) {
            return f0.g(deserializedClassDescriptor);
        }

        @Override // ya.AbstractC6014u, ya.v0
        /* renamed from: L, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public DeserializedClassDescriptor d() {
            return DeserializedClassDescriptor.this;
        }

        @Override // ya.v0
        public boolean f() {
            return true;
        }

        @Override // ya.v0
        public List<b0> getParameters() {
            return this.f36043d.invoke();
        }

        @Override // ya.AbstractC6009o
        public Collection<S> s() {
            String strB;
            ga.c cVarA;
            List<ProtoBuf$Type> listP = ea.g.p(DeserializedClassDescriptor.this.Y0(), DeserializedClassDescriptor.this.X0().j());
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
            Iterator<T> it = listP.iterator();
            while (it.hasNext()) {
                arrayList.add(deserializedClassDescriptor.X0().i().u((ProtoBuf$Type) it.next()));
            }
            List listS0 = F.S0(arrayList, DeserializedClassDescriptor.this.X0().c().c().a(DeserializedClassDescriptor.this));
            ArrayList<D.b> arrayList2 = new ArrayList();
            Iterator it2 = listS0.iterator();
            while (it2.hasNext()) {
                InterfaceC0799d interfaceC0799dD = ((S) it2.next()).H0().d();
                D.b bVar = interfaceC0799dD instanceof D.b ? (D.b) interfaceC0799dD : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                InterfaceC5636v interfaceC5636vJ = DeserializedClassDescriptor.this.X0().c().j();
                DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
                ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
                for (D.b bVar2 : arrayList2) {
                    ga.b bVarN = DescriptorUtilsKt.n(bVar2);
                    if (bVarN == null || (cVarA = bVarN.a()) == null || (strB = cVarA.a()) == null) {
                        strB = bVar2.getName().b();
                        p.h(strB, "asString(...)");
                    }
                    arrayList3.add(strB);
                }
                interfaceC5636vJ.b(deserializedClassDescriptor2, arrayList3);
            }
            return F.m1(listS0);
        }

        public String toString() {
            String string = DeserializedClassDescriptor.this.getName().toString();
            p.h(string, "toString(...)");
            return string;
        }

        @Override // ya.AbstractC6009o
        public Z w() {
            return Z.a.f2446a;
        }
    }

    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Map<e, ProtoBuf$EnumEntry> f36045a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC5864g<e, InterfaceC0797b> f36046b;

        /* renamed from: c, reason: collision with root package name */
        public final InterfaceC5865h<Set<e>> f36047c;

        public c() {
            List<ProtoBuf$EnumEntry> listF0 = DeserializedClassDescriptor.this.Y0().F0();
            p.h(listF0, "getEnumEntryList(...)");
            List<ProtoBuf$EnumEntry> list = listF0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(C5602L.b(DeserializedClassDescriptor.this.X0().g(), ((ProtoBuf$EnumEntry) obj).K()), obj);
            }
            this.f36045a = linkedHashMap;
            this.f36046b = DeserializedClassDescriptor.this.X0().h().f(new C5790n(this, DeserializedClassDescriptor.this));
            this.f36047c = DeserializedClassDescriptor.this.X0().h().i(new C5791o(this));
        }

        public static final InterfaceC0797b f(c cVar, DeserializedClassDescriptor deserializedClassDescriptor, e name) {
            p.i(name, "name");
            ProtoBuf$EnumEntry protoBuf$EnumEntry = cVar.f36045a.get(name);
            if (protoBuf$EnumEntry != null) {
                return C0838q.F0(deserializedClassDescriptor.X0().h(), deserializedClassDescriptor, name, cVar.f36047c, new C5777a(deserializedClassDescriptor.X0().h(), new C5792p(deserializedClassDescriptor, protoBuf$EnumEntry)), W.f2444a);
            }
            return null;
        }

        public static final List g(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
            return F.m1(deserializedClassDescriptor.X0().c().d().l(deserializedClassDescriptor.c1(), protoBuf$EnumEntry));
        }

        public static final Set h(c cVar) {
            return cVar.e();
        }

        public final Collection<InterfaceC0797b> d() {
            Set<e> setKeySet = this.f36045a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                InterfaceC0797b interfaceC0797bI = i((e) it.next());
                if (interfaceC0797bI != null) {
                    arrayList.add(interfaceC0797bI);
                }
            }
            return arrayList;
        }

        public final Set<e> e() {
            HashSet hashSet = new HashSet();
            Iterator<S> it = DeserializedClassDescriptor.this.j().e().iterator();
            while (it.hasNext()) {
                for (InterfaceC0803h interfaceC0803h : InterfaceC5241n.a.a(it.next().m(), null, null, 3, null)) {
                    if ((interfaceC0803h instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) || (interfaceC0803h instanceof O)) {
                        hashSet.add(((CallableMemberDescriptor) interfaceC0803h).getName());
                    }
                }
            }
            List<ProtoBuf$Function> listK0 = DeserializedClassDescriptor.this.Y0().K0();
            p.h(listK0, "getFunctionList(...)");
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            Iterator<T> it2 = listK0.iterator();
            while (it2.hasNext()) {
                hashSet.add(C5602L.b(deserializedClassDescriptor.X0().g(), ((ProtoBuf$Function) it2.next()).w0()));
            }
            List<ProtoBuf$Property> listR0 = DeserializedClassDescriptor.this.Y0().R0();
            p.h(listR0, "getPropertyList(...)");
            DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
            Iterator<T> it3 = listR0.iterator();
            while (it3.hasNext()) {
                hashSet.add(C5602L.b(deserializedClassDescriptor2.X0().g(), ((ProtoBuf$Property) it3.next()).M0()));
            }
            return Z8.Z.o(hashSet, hashSet);
        }

        public final InterfaceC0797b i(e name) {
            p.i(name, "name");
            return this.f36046b.invoke(name);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(C5629o outerContext, ProtoBuf$Class classProto, InterfaceC4020d nameResolver, AbstractC4017a metadataVersion, W sourceElement) {
        AbstractC5239l c5244q;
        super(outerContext.h(), C5602L.a(nameResolver, classProto.H0()).h());
        p.i(outerContext, "outerContext");
        p.i(classProto, "classProto");
        p.i(nameResolver, "nameResolver");
        p.i(metadataVersion, "metadataVersion");
        p.i(sourceElement, "sourceElement");
        this.f36017f = classProto;
        this.f36018g = metadataVersion;
        this.f36019h = sourceElement;
        this.f36020i = C5602L.a(nameResolver, classProto.H0());
        C5605O c5605o = C5605O.f42564a;
        this.f36021j = c5605o.b(C4018b.f32378e.d(classProto.G0()));
        this.f36022k = C5606P.a(c5605o, C4018b.f32377d.d(classProto.G0()));
        ClassKind classKindA = c5605o.a(C4018b.f32379f.d(classProto.G0()));
        this.f36023l = classKindA;
        List<ProtoBuf$TypeParameter> listC1 = classProto.c1();
        p.h(listC1, "getTypeParameterList(...)");
        ProtoBuf$TypeTable protoBuf$TypeTableD1 = classProto.d1();
        p.h(protoBuf$TypeTableD1, "getTypeTable(...)");
        h hVar = new h(protoBuf$TypeTableD1);
        j.a aVar = j.f32424b;
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTableF1 = classProto.f1();
        p.h(protoBuf$VersionRequirementTableF1, "getVersionRequirementTable(...)");
        C5629o c5629oA = outerContext.a(this, listC1, nameResolver, hVar, aVar.a(protoBuf$VersionRequirementTableF1), metadataVersion);
        this.f36024m = c5629oA;
        Boolean boolD = C4018b.f32386m.d(classProto.G0());
        p.h(boolD, "get(...)");
        boolean zBooleanValue = boolD.booleanValue();
        this.f36025n = zBooleanValue;
        ClassKind classKind = ClassKind.ENUM_CLASS;
        if (classKindA == classKind) {
            c5244q = new C5244q(c5629oA.h(), this, zBooleanValue || p.d(c5629oA.c().i().a(), Boolean.TRUE));
        } else {
            c5244q = InterfaceC5238k.b.f38898b;
        }
        this.f36026o = c5244q;
        this.f36027p = new b();
        this.f36028q = V.f2438e.a(this, c5629oA.h(), c5629oA.c().n().d(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        this.f36029r = classKindA == classKind ? new c() : null;
        InterfaceC0803h interfaceC0803hE = outerContext.e();
        this.f36030s = interfaceC0803hE;
        this.f36031t = c5629oA.h().h(new C5780d(this));
        this.f36032u = c5629oA.h().i(new C5781e(this));
        this.f36033v = c5629oA.h().h(new C5782f(this));
        this.f36034w = c5629oA.h().i(new C5783g(this));
        this.f36035x = c5629oA.h().h(new C5784h(this));
        InterfaceC4020d interfaceC4020dG = c5629oA.g();
        h hVarJ = c5629oA.j();
        DeserializedClassDescriptor deserializedClassDescriptor = interfaceC0803hE instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) interfaceC0803hE : null;
        this.f36036y = new AbstractC5604N.a(classProto, interfaceC4020dG, hVarJ, sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.f36036y : null);
        this.f36037z = !C4018b.f32376c.d(classProto.G0()).booleanValue() ? g.f2609m0.b() : new C5775Q(c5629oA.h(), new C5785i(this));
    }

    public static final List O0(DeserializedClassDescriptor deserializedClassDescriptor) {
        return F.m1(deserializedClassDescriptor.f36024m.c().d().e(deserializedClassDescriptor.f36036y));
    }

    public static final InterfaceC0797b P0(DeserializedClassDescriptor deserializedClassDescriptor) {
        return deserializedClassDescriptor.Q0();
    }

    public static final Collection W0(DeserializedClassDescriptor deserializedClassDescriptor) {
        return deserializedClassDescriptor.R0();
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.b f1(DeserializedClassDescriptor deserializedClassDescriptor) {
        return deserializedClassDescriptor.S0();
    }

    public static final Collection g1(DeserializedClassDescriptor deserializedClassDescriptor) {
        return deserializedClassDescriptor.U0();
    }

    public static final g0 h1(DeserializedClassDescriptor deserializedClassDescriptor) {
        return deserializedClassDescriptor.V0();
    }

    @Override // E9.InterfaceC0797b
    public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return this.f36031t.invoke();
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        Boolean boolD = C4018b.f32381h.d(this.f36017f.G0());
        p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // E9.InterfaceC0797b
    public g0<AbstractC5990d0> P() {
        return this.f36035x.invoke();
    }

    public final InterfaceC0797b Q0() {
        if (!this.f36017f.g1()) {
            return null;
        }
        InterfaceC0799d interfaceC0799dD = Z0().d(C5602L.b(this.f36024m.g(), this.f36017f.r0()), NoLookupLocation.FROM_DESERIALIZATION);
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> R0() {
        return F.S0(F.S0(T0(), C1173v.q(B())), this.f36024m.c().c().e(this));
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.b S0() {
        Object next;
        if (this.f36023l.isSingleton()) {
            C0830i c0830iL = C4827g.l(this, W.f2444a);
            c0830iL.a1(n());
            return c0830iL;
        }
        List<ProtoBuf$Constructor> listW0 = this.f36017f.w0();
        p.h(listW0, "getConstructorList(...)");
        Iterator<T> it = listW0.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!C4018b.f32387n.d(((ProtoBuf$Constructor) next).S()).booleanValue()) {
                break;
            }
        }
        ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) next;
        if (protoBuf$Constructor != null) {
            return this.f36024m.f().u(protoBuf$Constructor, true);
        }
        return null;
    }

    public final List<kotlin.reflect.jvm.internal.impl.descriptors.b> T0() {
        List<ProtoBuf$Constructor> listW0 = this.f36017f.w0();
        p.h(listW0, "getConstructorList(...)");
        ArrayList<ProtoBuf$Constructor> arrayList = new ArrayList();
        for (Object obj : listW0) {
            Boolean boolD = C4018b.f32387n.d(((ProtoBuf$Constructor) obj).S());
            p.h(boolD, "get(...)");
            if (boolD.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (ProtoBuf$Constructor protoBuf$Constructor : arrayList) {
            C5601K c5601kF = this.f36024m.f();
            p.f(protoBuf$Constructor);
            arrayList2.add(c5601kF.u(protoBuf$Constructor, false));
        }
        return arrayList2;
    }

    public final Collection<InterfaceC0797b> U0() {
        if (this.f36021j != Modality.SEALED) {
            return C1173v.m();
        }
        List<Integer> listS0 = this.f36017f.S0();
        p.f(listS0);
        if (listS0.isEmpty()) {
            return C4821a.f34643a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : listS0) {
            C5627m c5627mC = this.f36024m.c();
            InterfaceC4020d interfaceC4020dG = this.f36024m.g();
            p.f(num);
            InterfaceC0797b interfaceC0797bB = c5627mC.b(C5602L.a(interfaceC4020dG, num.intValue()));
            if (interfaceC0797bB != null) {
                arrayList.add(interfaceC0797bB);
            }
        }
        return arrayList;
    }

    @Override // H9.AbstractC0822a, E9.InterfaceC0797b
    public List<E9.S> V() {
        List<ProtoBuf$Type> listB = ea.g.b(this.f36017f, this.f36024m.j());
        ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(new N(D0(), new C5455b(this, this.f36024m.i().u((ProtoBuf$Type) it.next()), null, null), g.f2609m0.b()));
        }
        return arrayList;
    }

    public final g0<AbstractC5990d0> V0() {
        if (!isInline() && !q()) {
            return null;
        }
        boolean zC = this.f36018g.c(1, 5, 1);
        g0<AbstractC5990d0> g0VarA = C5614Y.a(this.f36017f, zC, this.f36024m.g(), this.f36024m.j(), new DeserializedClassDescriptor$computeValueClassRepresentation$1(this.f36024m.i()), new DeserializedClassDescriptor$computeValueClassRepresentation$2(this));
        if (g0VarA != null) {
            return g0VarA;
        }
        if (zC) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarB = B();
        if (bVarB == null) {
            throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
        }
        List<i0> listI = bVarB.i();
        p.h(listI, "getValueParameters(...)");
        e name = ((i0) F.q0(listI)).getName();
        p.h(name, "getName(...)");
        AbstractC5990d0 abstractC5990d0D1 = d1(name);
        if (abstractC5990d0D1 != null) {
            return new C0813s(name, abstractC5990d0D1);
        }
        throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
    }

    @Override // E9.InterfaceC0797b
    public boolean W() {
        return C4018b.f32379f.d(this.f36017f.G0()) == ProtoBuf$Class.Kind.COMPANION_OBJECT;
    }

    public final C5629o X0() {
        return this.f36024m;
    }

    public final ProtoBuf$Class Y0() {
        return this.f36017f;
    }

    @Override // E9.InterfaceC0797b
    public boolean Z() {
        Boolean boolD = C4018b.f32385l.d(this.f36017f.G0());
        p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }

    public final a Z0() {
        return (a) this.f36028q.c(this.f36024m.c().n().d());
    }

    public final AbstractC4017a a1() {
        return this.f36018g;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0804i, E9.InterfaceC0803h
    public InterfaceC0803h b() {
        return this.f36030s;
    }

    @Override // E9.InterfaceC0797b
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public AbstractC5239l g0() {
        return this.f36026o;
    }

    @Override // H9.z
    public InterfaceC5238k c0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f36028q.c(kotlinTypeRefiner);
    }

    public final AbstractC5604N.a c1() {
        return this.f36036y;
    }

    public final AbstractC5990d0 d1(e eVar) {
        Iterator<T> it = Z0().a(eVar, NoLookupLocation.FROM_DESERIALIZATION).iterator();
        boolean z10 = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z10) {
                    break;
                }
            } else {
                Object next = it.next();
                if (((O) next).K() == null) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj = next;
                }
            }
        }
        obj = null;
        O o10 = (O) obj;
        return (AbstractC5990d0) (o10 != null ? o10.getType() : null);
    }

    @Override // E9.InterfaceC0806k
    public W e() {
        return this.f36019h;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        Boolean boolD = C4018b.f32383j.d(this.f36017f.G0());
        p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }

    public final boolean e1(e name) {
        p.i(name, "name");
        return Z0().s().contains(name);
    }

    @Override // F9.a
    public g getAnnotations() {
        return this.f36037z;
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        return this.f36023l;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        return this.f36022k;
    }

    @Override // E9.InterfaceC0797b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        return this.f36032u.invoke();
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC0797b h0() {
        return this.f36033v.invoke();
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        Boolean boolD = C4018b.f32382i.d(this.f36017f.G0());
        p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // E9.InterfaceC0797b
    public boolean isInline() {
        return C4018b.f32384k.d(this.f36017f.G0()).booleanValue() && this.f36018g.e(1, 4, 1);
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        return this.f36027p;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        return this.f36024m.i().m();
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        return this.f36021j;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return C4018b.f32384k.d(this.f36017f.G0()).booleanValue() && this.f36018g.c(1, 4, 2);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deserialized ");
        sb2.append(e0() ? "expect " : "");
        sb2.append("class ");
        sb2.append(getName());
        return sb2.toString();
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        Boolean boolD = C4018b.f32380g.d(this.f36017f.G0());
        p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }
}
