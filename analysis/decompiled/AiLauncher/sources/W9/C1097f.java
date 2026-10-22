package W9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import E9.InterfaceC0816v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import p9.InterfaceC5074l;
import ra.C5231d;
import ra.C5240m;
import ra.InterfaceC5238k;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;

/* renamed from: W9.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1097f implements InterfaceC5238k {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f6728f = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C1097f.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* renamed from: b, reason: collision with root package name */
    public final V9.k f6729b;

    /* renamed from: c, reason: collision with root package name */
    public final C f6730c;

    /* renamed from: d, reason: collision with root package name */
    public final F f6731d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5865h f6732e;

    public C1097f(V9.k c10, Z9.u jPackage, C packageFragment) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(jPackage, "jPackage");
        kotlin.jvm.internal.p.i(packageFragment, "packageFragment");
        this.f6729b = c10;
        this.f6730c = packageFragment;
        this.f6731d = new F(c10, jPackage, packageFragment);
        this.f6732e = c10.e().i(new C1096e(this));
    }

    public static final InterfaceC5238k[] j(C1097f c1097f) {
        Collection<kotlin.reflect.jvm.internal.impl.load.kotlin.f> collectionValues = c1097f.f6730c.I0().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            InterfaceC5238k interfaceC5238kC = c1097f.f6729b.a().b().c(c1097f.f6730c, (kotlin.reflect.jvm.internal.impl.load.kotlin.f) it.next());
            if (interfaceC5238kC != null) {
                arrayList.add(interfaceC5238kC);
            }
        }
        return (InterfaceC5238k[]) Ha.a.b(arrayList).toArray(new InterfaceC5238k[0]);
    }

    @Override // ra.InterfaceC5238k
    public Collection<E9.O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        k(name, location);
        F f10 = this.f6731d;
        InterfaceC5238k[] interfaceC5238kArrI = i();
        Collection<? extends E9.O> collectionA = f10.a(name, location);
        int length = interfaceC5238kArrI.length;
        int i10 = 0;
        Collection collection = collectionA;
        while (i10 < length) {
            Collection collectionA2 = Ha.a.a(collection, interfaceC5238kArrI[i10].a(name, location));
            i10++;
            collection = collectionA2;
        }
        return collection == null ? Z8.Y.e() : collection;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> b() {
        InterfaceC5238k[] interfaceC5238kArrI = i();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArrI) {
            Z8.A.E(linkedHashSet, interfaceC5238k.b());
        }
        linkedHashSet.addAll(this.f6731d.b());
        return linkedHashSet;
    }

    @Override // ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        k(name, location);
        F f10 = this.f6731d;
        InterfaceC5238k[] interfaceC5238kArrI = i();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collectionC = f10.c(name, location);
        int length = interfaceC5238kArrI.length;
        int i10 = 0;
        Collection collection = collectionC;
        while (i10 < length) {
            Collection collectionA = Ha.a.a(collection, interfaceC5238kArrI[i10].c(name, location));
            i10++;
            collection = collectionA;
        }
        return collection == null ? Z8.Y.e() : collection;
    }

    @Override // ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        k(name, location);
        InterfaceC0797b interfaceC0797bD = this.f6731d.d(name, location);
        if (interfaceC0797bD != null) {
            return interfaceC0797bD;
        }
        InterfaceC0799d interfaceC0799d = null;
        for (InterfaceC5238k interfaceC5238k : i()) {
            InterfaceC0799d interfaceC0799dD = interfaceC5238k.d(name, location);
            if (interfaceC0799dD != null) {
                if (!(interfaceC0799dD instanceof InterfaceC0800e) || !((InterfaceC0816v) interfaceC0799dD).e0()) {
                    return interfaceC0799dD;
                }
                if (interfaceC0799d == null) {
                    interfaceC0799d = interfaceC0799dD;
                }
            }
        }
        return interfaceC0799d;
    }

    @Override // ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        F f10 = this.f6731d;
        InterfaceC5238k[] interfaceC5238kArrI = i();
        Collection<InterfaceC0803h> collectionE = f10.e(kindFilter, nameFilter);
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArrI) {
            collectionE = Ha.a.a(collectionE, interfaceC5238k.e(kindFilter, nameFilter));
        }
        return collectionE == null ? Z8.Y.e() : collectionE;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> f() {
        Set<ga.e> setA = C5240m.a(Z8.r.L(i()));
        if (setA == null) {
            return null;
        }
        setA.addAll(this.f6731d.f());
        return setA;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        InterfaceC5238k[] interfaceC5238kArrI = i();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArrI) {
            Z8.A.E(linkedHashSet, interfaceC5238k.getVariableNames());
        }
        linkedHashSet.addAll(this.f6731d.getVariableNames());
        return linkedHashSet;
    }

    public final F h() {
        return this.f6731d;
    }

    public final InterfaceC5238k[] i() {
        return (InterfaceC5238k[]) C5868k.a(this.f6732e, this, f6728f[0]);
    }

    public void k(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        L9.a.b(this.f6729b.a().l(), location, this.f6730c, name);
    }

    public String toString() {
        return "scope for " + this.f6730c;
    }
}
