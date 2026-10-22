package ra;

import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import E9.InterfaceC0816v;
import E9.O;
import Z8.A;
import Z8.C1173v;
import Z8.Y;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;

/* renamed from: ra.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5229b implements InterfaceC5238k {

    /* renamed from: d, reason: collision with root package name */
    public static final a f38851d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f38852b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5238k[] f38853c;

    /* renamed from: ra.b$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final InterfaceC5238k a(String debugName, Iterable<? extends InterfaceC5238k> scopes) {
            kotlin.jvm.internal.p.i(debugName, "debugName");
            kotlin.jvm.internal.p.i(scopes, "scopes");
            Ia.j jVar = new Ia.j();
            for (InterfaceC5238k interfaceC5238k : scopes) {
                if (interfaceC5238k != InterfaceC5238k.b.f38898b) {
                    if (interfaceC5238k instanceof C5229b) {
                        A.F(jVar, ((C5229b) interfaceC5238k).f38853c);
                    } else {
                        jVar.add(interfaceC5238k);
                    }
                }
            }
            return b(debugName, jVar);
        }

        public final InterfaceC5238k b(String debugName, List<? extends InterfaceC5238k> scopes) {
            kotlin.jvm.internal.p.i(debugName, "debugName");
            kotlin.jvm.internal.p.i(scopes, "scopes");
            int size = scopes.size();
            return size != 0 ? size != 1 ? new C5229b(debugName, (InterfaceC5238k[]) scopes.toArray(new InterfaceC5238k[0]), null) : scopes.get(0) : InterfaceC5238k.b.f38898b;
        }

        public a() {
        }
    }

    public /* synthetic */ C5229b(String str, InterfaceC5238k[] interfaceC5238kArr, kotlin.jvm.internal.i iVar) {
        this(str, interfaceC5238kArr);
    }

    @Override // ra.InterfaceC5238k
    public Collection<O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        InterfaceC5238k[] interfaceC5238kArr = this.f38853c;
        int length = interfaceC5238kArr.length;
        if (length == 0) {
            return C1173v.m();
        }
        if (length == 1) {
            return interfaceC5238kArr[0].a(name, location);
        }
        Collection<O> collectionA = null;
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArr) {
            collectionA = Ha.a.a(collectionA, interfaceC5238k.a(name, location));
        }
        return collectionA == null ? Y.e() : collectionA;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> b() {
        InterfaceC5238k[] interfaceC5238kArr = this.f38853c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArr) {
            A.E(linkedHashSet, interfaceC5238k.b());
        }
        return linkedHashSet;
    }

    @Override // ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        InterfaceC5238k[] interfaceC5238kArr = this.f38853c;
        int length = interfaceC5238kArr.length;
        if (length == 0) {
            return C1173v.m();
        }
        if (length == 1) {
            return interfaceC5238kArr[0].c(name, location);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collectionA = null;
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArr) {
            collectionA = Ha.a.a(collectionA, interfaceC5238k.c(name, location));
        }
        return collectionA == null ? Y.e() : collectionA;
    }

    @Override // ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        InterfaceC0799d interfaceC0799d = null;
        for (InterfaceC5238k interfaceC5238k : this.f38853c) {
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
        InterfaceC5238k[] interfaceC5238kArr = this.f38853c;
        int length = interfaceC5238kArr.length;
        if (length == 0) {
            return C1173v.m();
        }
        if (length == 1) {
            return interfaceC5238kArr[0].e(kindFilter, nameFilter);
        }
        Collection<InterfaceC0803h> collectionA = null;
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArr) {
            collectionA = Ha.a.a(collectionA, interfaceC5238k.e(kindFilter, nameFilter));
        }
        return collectionA == null ? Y.e() : collectionA;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> f() {
        return C5240m.a(Z8.r.L(this.f38853c));
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        InterfaceC5238k[] interfaceC5238kArr = this.f38853c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC5238k interfaceC5238k : interfaceC5238kArr) {
            A.E(linkedHashSet, interfaceC5238k.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.f38852b;
    }

    public C5229b(String str, InterfaceC5238k[] interfaceC5238kArr) {
        this.f38852b = str;
        this.f38853c = interfaceC5238kArr;
    }
}
