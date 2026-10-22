package H9;

import E9.C0814t;
import E9.C0818x;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0819y;
import H9.I;
import Z8.C1173v;
import Z8.C1174w;
import ha.C4150a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import p9.InterfaceC5074l;
import xa.InterfaceC5863f;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class F extends AbstractC0834m implements InterfaceC0819y {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5869l f3000c;

    /* renamed from: d, reason: collision with root package name */
    public final C9.j f3001d;

    /* renamed from: e, reason: collision with root package name */
    public final ga.e f3002e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<C0818x<?>, Object> f3003f;

    /* renamed from: g, reason: collision with root package name */
    public final I f3004g;

    /* renamed from: h, reason: collision with root package name */
    public B f3005h;

    /* renamed from: i, reason: collision with root package name */
    public E9.F f3006i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3007j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC5863f<ga.c, E9.L> f3008k;

    /* renamed from: l, reason: collision with root package name */
    public final Y8.h f3009l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public F(ga.e moduleName, InterfaceC5869l storageManager, C9.j builtIns, C4150a c4150a) {
        this(moduleName, storageManager, builtIns, c4150a, null, null, 48, null);
        kotlin.jvm.internal.p.i(moduleName, "moduleName");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
    }

    private final boolean J0() {
        return this.f3006i != null;
    }

    public static final C0833l L0(F f10) {
        B b10 = f10.f3005h;
        if (b10 == null) {
            throw new AssertionError("Dependencies of module " + f10.F0() + " were not set before querying module content");
        }
        List<F> listA = b10.a();
        f10.E0();
        listA.contains(f10);
        List<F> list = listA;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((F) it.next()).J0();
        }
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            E9.F f11 = ((F) it2.next()).f3006i;
            kotlin.jvm.internal.p.f(f11);
            arrayList.add(f11);
        }
        return new C0833l(arrayList, "CompositeProvider@ModuleDescriptor for " + f10.getName());
    }

    public static final E9.L M0(F f10, ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return f10.f3004g.a(f10, fqName, f10.f3000c);
    }

    public void E0() {
        if (K0()) {
            return;
        }
        C0814t.a(this);
    }

    public final String F0() {
        String string = getName().toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final E9.F G0() {
        E0();
        return H0();
    }

    public final C0833l H0() {
        return (C0833l) this.f3009l.getValue();
    }

    public final void I0(E9.F providerForModuleContent) {
        kotlin.jvm.internal.p.i(providerForModuleContent, "providerForModuleContent");
        J0();
        this.f3006i = providerForModuleContent;
    }

    public boolean K0() {
        return this.f3007j;
    }

    public final void N0(B dependencies) {
        kotlin.jvm.internal.p.i(dependencies, "dependencies");
        this.f3005h = dependencies;
    }

    public final void O0(List<F> descriptors) {
        kotlin.jvm.internal.p.i(descriptors, "descriptors");
        P0(descriptors, Z8.Y.e());
    }

    public final void P0(List<F> descriptors, Set<F> friends) {
        kotlin.jvm.internal.p.i(descriptors, "descriptors");
        kotlin.jvm.internal.p.i(friends, "friends");
        N0(new C(descriptors, friends, C1173v.m(), Z8.Y.e()));
    }

    public final void Q0(F... descriptors) {
        kotlin.jvm.internal.p.i(descriptors, "descriptors");
        O0(Z8.r.T0(descriptors));
    }

    @Override // E9.InterfaceC0803h
    public /* bridge */ InterfaceC0803h b() {
        return InterfaceC0819y.a.b(this);
    }

    @Override // E9.InterfaceC0819y
    public E9.L f0(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        E0();
        return this.f3008k.invoke(fqName);
    }

    @Override // E9.InterfaceC0819y
    public C9.j g() {
        return this.f3001d;
    }

    @Override // E9.InterfaceC0819y
    public Collection<ga.c> k(ga.c fqName, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        E0();
        return G0().k(fqName, nameFilter);
    }

    @Override // E9.InterfaceC0819y
    public <T> T q0(C0818x<T> capability) {
        kotlin.jvm.internal.p.i(capability, "capability");
        T t10 = (T) this.f3003f.get(capability);
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    @Override // H9.AbstractC0834m
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        if (!K0()) {
            sb2.append(" !isValid");
        }
        sb2.append(" packageFragmentProvider: ");
        E9.F f10 = this.f3006i;
        sb2.append(f10 != null ? f10.getClass().getSimpleName() : null);
        return sb2.toString();
    }

    @Override // E9.InterfaceC0819y
    public boolean u(InterfaceC0819y targetModule) {
        kotlin.jvm.internal.p.i(targetModule, "targetModule");
        if (kotlin.jvm.internal.p.d(this, targetModule)) {
            return true;
        }
        B b10 = this.f3005h;
        kotlin.jvm.internal.p.f(b10);
        return Z8.F.f0(b10.c(), targetModule) || u0().contains(targetModule) || targetModule.u0().contains(this);
    }

    @Override // E9.InterfaceC0819y
    public List<InterfaceC0819y> u0() {
        B b10 = this.f3005h;
        if (b10 != null) {
            return b10.b();
        }
        throw new AssertionError("Dependencies of module " + F0() + " were not set");
    }

    @Override // E9.InterfaceC0803h
    public /* bridge */ <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return (R) InterfaceC0819y.a.a(this, interfaceC0805j, d10);
    }

    public /* synthetic */ F(ga.e eVar, InterfaceC5869l interfaceC5869l, C9.j jVar, C4150a c4150a, Map map, ga.e eVar2, int i10, kotlin.jvm.internal.i iVar) {
        this(eVar, interfaceC5869l, jVar, (i10 & 8) != 0 ? null : c4150a, (i10 & 16) != 0 ? kotlin.collections.a.i() : map, (i10 & 32) != 0 ? null : eVar2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(ga.e moduleName, InterfaceC5869l storageManager, C9.j builtIns, C4150a c4150a, Map<C0818x<?>, ? extends Object> capabilities, ga.e eVar) {
        super(F9.g.f2609m0.b(), moduleName);
        kotlin.jvm.internal.p.i(moduleName, "moduleName");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        this.f3000c = storageManager;
        this.f3001d = builtIns;
        this.f3002e = eVar;
        if (moduleName.k()) {
            this.f3003f = capabilities;
            I i10 = (I) q0(I.f3020a.a());
            this.f3004g = i10 == null ? I.b.f3023b : i10;
            this.f3007j = true;
            this.f3008k = storageManager.c(new D(this));
            this.f3009l = C4848b.b(new E(this));
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + moduleName);
    }
}
