package t8;

import W8.f;
import W8.g;
import W8.i;
import h8.InterfaceC1497E;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.InitializedLazyImpl;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import n8.r;
import u8.p;

/* renamed from: t8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2027d implements InterfaceC1497E {

    /* renamed from: a, reason: collision with root package name */
    public final K1.a f6681a;
    public final W8.e b;

    public C2027d(C2024a c2024a) {
        this.f6681a = new K1.a(c2024a, C2025b.b, new InitializedLazyImpl(null));
        i iVar = (i) c2024a.f6670a;
        iVar.getClass();
        this.b = new W8.e(iVar, new ConcurrentHashMap(3, 1.0f, 2), new f(), 0);
    }

    @Override // h8.InterfaceC1497E
    public final void a(G8.c fqName, ArrayList arrayList) {
        k.f(fqName, "fqName");
        arrayList.add(c(fqName));
    }

    @Override // h8.InterfaceC1497E
    public final boolean b(G8.c fqName) {
        k.f(fqName, "fqName");
        ((C2024a) this.f6681a.f903a).b.getClass();
        return false;
    }

    public final p c(G8.c fqName) throws Throwable {
        ((C2024a) this.f6681a.f903a).b.getClass();
        k.f(fqName, "fqName");
        J4.e eVar = new J4.e(19, this, new r(fqName));
        W8.e eVar2 = this.b;
        eVar2.getClass();
        Object objInvoke = eVar2.invoke(new g(fqName, eVar));
        if (objInvoke != null) {
            return (p) objInvoke;
        }
        W8.e.a(3);
        throw null;
    }

    @Override // h8.InterfaceC1497E
    public final Collection f(G8.c fqName, S7.k kVar) {
        k.f(fqName, "fqName");
        Collection collection = (List) c(fqName).k.invoke();
        if (collection == null) {
            collection = EmptyList.f4893a;
        }
        return collection;
    }

    public final String toString() {
        return "LazyJavaPackageFragmentProvider of module " + ((C2024a) this.f6681a.f903a).o;
    }
}
