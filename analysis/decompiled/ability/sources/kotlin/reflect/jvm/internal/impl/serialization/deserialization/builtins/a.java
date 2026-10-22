package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import D7.w;
import T8.C0250b;
import U8.b;
import U8.c;
import W8.i;
import com.stepos.ability.task.executor.e;
import e8.InterfaceC1427c;
import e8.o;
import h8.C1496D;
import h8.InterfaceC1540w;
import j8.InterfaceC1603b;
import j8.InterfaceC1605d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import u1.d;
import v0.C2054a;

/* loaded from: classes4.dex */
public final class a implements InterfaceC1427c {
    public final c b = new c();

    public final C1496D a(i iVar, InterfaceC1540w builtInsModule, Iterable classDescriptorFactories, InterfaceC1605d platformDependentDeclarationFilter, InterfaceC1603b additionalClassPartsProvider, boolean z10) {
        k.f(builtInsModule, "builtInsModule");
        k.f(classDescriptorFactories, "classDescriptorFactories");
        k.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        k.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        Set packageFqNames = o.f4428q;
        BuiltInsLoaderImpl$createPackageFragmentProvider$1 builtInsLoaderImpl$createPackageFragmentProvider$1 = new BuiltInsLoaderImpl$createPackageFragmentProvider$1(1, this.b);
        k.f(packageFqNames, "packageFqNames");
        Set<G8.c> set = packageFqNames;
        ArrayList arrayList = new ArrayList(w.c0(set, 10));
        for (G8.c cVar : set) {
            U8.a.m.getClass();
            String strA = U8.a.a(cVar);
            InputStream inputStream = (InputStream) builtInsLoaderImpl$createPackageFragmentProvider$1.invoke(strA);
            if (inputStream == null) {
                throw new IllegalStateException(B7.a.k("Resource not found in classpath: ", strA));
            }
            arrayList.add(e.w(cVar, iVar, builtInsModule, inputStream));
        }
        C1496D c1496d = new C1496D(arrayList);
        d dVar = new d(iVar, builtInsModule);
        A8.d dVar2 = new A8.d(c1496d, 3);
        U8.a aVar = U8.a.m;
        T8.k kVar = new T8.k(iVar, builtInsModule, dVar2, new C0250b(builtInsModule, dVar, aVar), c1496d, classDescriptorFactories, dVar, additionalClassPartsProvider, platformDependentDeclarationFilter, aVar.f1179a, null, new C2054a(iVar, EmptyList.f4893a), 851968);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).S0(kVar);
        }
        return c1496d;
    }
}
