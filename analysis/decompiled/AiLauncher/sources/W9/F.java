package W9;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import S9.r;
import W9.InterfaceC1094c;
import Z8.C1173v;
import ba.p;
import ea.C4019c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import p9.InterfaceC5074l;
import ra.C5231d;
import xa.InterfaceC5864g;
import xa.InterfaceC5866i;

/* loaded from: classes5.dex */
public final class F extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b {

    /* renamed from: n, reason: collision with root package name */
    public final Z9.u f6682n;

    /* renamed from: o, reason: collision with root package name */
    public final C f6683o;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceC5866i<Set<String>> f6684p;

    /* renamed from: q, reason: collision with root package name */
    public final InterfaceC5864g<a, InterfaceC0797b> f6685q;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ga.e f6686a;

        /* renamed from: b, reason: collision with root package name */
        public final Z9.g f6687b;

        public a(ga.e name, Z9.g gVar) {
            kotlin.jvm.internal.p.i(name, "name");
            this.f6686a = name;
            this.f6687b = gVar;
        }

        public final Z9.g a() {
            return this.f6687b;
        }

        public final ga.e b() {
            return this.f6686a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.p.d(this.f6686a, ((a) obj).f6686a);
        }

        public int hashCode() {
            return this.f6686a.hashCode();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public final InterfaceC0797b f6688a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC0797b descriptor) {
                super(null);
                kotlin.jvm.internal.p.i(descriptor, "descriptor");
                this.f6688a = descriptor;
            }

            public final InterfaceC0797b a() {
                return this.f6688a;
            }
        }

        /* renamed from: W9.F$b$b, reason: collision with other inner class name */
        public static final class C0117b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C0117b f6689a = new C0117b();

            public C0117b() {
                super(null);
            }
        }

        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f6690a = new c();

            public c() {
                super(null);
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(V9.k c10, Z9.u jPackage, C ownerDescriptor) {
        super(c10);
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(jPackage, "jPackage");
        kotlin.jvm.internal.p.i(ownerDescriptor, "ownerDescriptor");
        this.f6682n = jPackage;
        this.f6683o = ownerDescriptor;
        this.f6684p = c10.e().h(new D(c10, this));
        this.f6685q = c10.e().f(new E(this, c10));
    }

    public static final InterfaceC0797b h0(F f10, V9.k kVar, a request) {
        kotlin.jvm.internal.p.i(request, "request");
        ga.b bVar = new ga.b(f10.Q().f(), request.b());
        p.a aVarC = request.a() != null ? kVar.a().j().c(request.a(), f10.l0()) : kVar.a().j().a(bVar, f10.l0());
        kotlin.reflect.jvm.internal.impl.load.kotlin.f fVarA = aVarC != null ? aVarC.a() : null;
        ga.b bVarJ = fVarA != null ? fVarA.j() : null;
        if (bVarJ != null && (bVarJ.j() || bVarJ.i())) {
            return null;
        }
        b bVarO0 = f10.o0(fVarA);
        if (bVarO0 instanceof b.a) {
            return ((b.a) bVarO0).a();
        }
        if (bVarO0 instanceof b.c) {
            return null;
        }
        if (!(bVarO0 instanceof b.C0117b)) {
            throw new NoWhenBranchMatchedException();
        }
        Z9.g gVarA = request.a();
        if (gVarA == null) {
            S9.r rVarD = kVar.a().d();
            p.a.C0191a c0191a = aVarC instanceof p.a.C0191a ? (p.a.C0191a) aVarC : null;
            gVarA = rVarD.c(new r.a(bVar, c0191a != null ? c0191a.b() : null, null, 4, null));
        }
        Z9.g gVar = gVarA;
        if ((gVar != null ? gVar.G() : null) != LightClassOriginKind.BINARY) {
            ga.c cVarF = gVar != null ? gVar.f() : null;
            if (cVarF == null || cVarF.c() || !kotlin.jvm.internal.p.d(cVarF.d(), f10.Q().f())) {
                return null;
            }
            C1105n c1105n = new C1105n(kVar, f10.Q(), gVar, null, 8, null);
            kVar.a().e().a(c1105n);
            return c1105n;
        }
        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + ba.q.a(kVar.a().j(), gVar, f10.l0()) + "\nfindKotlinClass(ClassId) = " + ba.q.b(kVar.a().j(), bVar, f10.l0()) + '\n');
    }

    public static final Set n0(V9.k kVar, F f10) {
        return kVar.a().d().b(f10.Q().f());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void A(Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> result, ga.e name) {
        kotlin.jvm.internal.p.i(result, "result");
        kotlin.jvm.internal.p.i(name, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> C(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        return Z8.Y.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a, ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<E9.O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return C1173v.m();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a, ra.AbstractC5239l, ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        C5231d.a aVar = C5231d.f38857c;
        if (!kindFilter.a(aVar.e() | aVar.c())) {
            return C1173v.m();
        }
        Collection<InterfaceC0803h> collectionInvoke = J().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            InterfaceC0803h interfaceC0803h = (InterfaceC0803h) obj;
            if (interfaceC0803h instanceof InterfaceC0797b) {
                ga.e name = ((InterfaceC0797b) interfaceC0803h).getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                if (nameFilter.invoke(name).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    public final InterfaceC0797b i0(ga.e eVar, Z9.g gVar) {
        if (!ga.g.f32741a.a(eVar)) {
            return null;
        }
        Set<String> setInvoke = this.f6684p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(eVar.b())) {
            return this.f6685q.invoke(new a(eVar, gVar));
        }
        return null;
    }

    public final InterfaceC0797b j0(Z9.g javaClass) {
        kotlin.jvm.internal.p.i(javaClass, "javaClass");
        return i0(javaClass.getName(), javaClass);
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0797b d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return i0(name, null);
    }

    public final C4019c l0() {
        return K().a().b().f().g().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C Q() {
        return this.f6683o;
    }

    public final b o0(kotlin.reflect.jvm.internal.impl.load.kotlin.f fVar) {
        if (fVar == null) {
            return b.C0117b.f6689a;
        }
        if (fVar.b().c() != KotlinClassHeader.Kind.CLASS) {
            return b.c.f6690a;
        }
        InterfaceC0797b interfaceC0797bN = K().a().b().n(fVar);
        return interfaceC0797bN != null ? new b.a(interfaceC0797bN) : b.C0117b.f6689a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> u(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        if (!kindFilter.a(C5231d.f38857c.e())) {
            return Z8.Y.e();
        }
        Set<String> setInvoke = this.f6684p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(ga.e.j((String) it.next()));
            }
            return hashSet;
        }
        Z9.u uVar = this.f6682n;
        if (interfaceC5074l == null) {
            interfaceC5074l = Ia.i.k();
        }
        Collection<Z9.g> collectionH = uVar.H(interfaceC5074l);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Z9.g gVar : collectionH) {
            ga.e name = gVar.G() == LightClassOriginKind.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> w(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        return Z8.Y.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public InterfaceC1094c y() {
        return InterfaceC1094c.a.f6726a;
    }
}
