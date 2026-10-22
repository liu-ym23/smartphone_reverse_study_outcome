package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import C9.b;
import C9.o;
import E9.D;
import E9.F;
import E9.I;
import E9.InterfaceC0819y;
import G9.c;
import M9.c;
import Z8.C1173v;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import qa.C5167b;
import ua.C5619e;
import ua.C5627m;
import ua.C5630p;
import ua.InterfaceC5591A;
import ua.InterfaceC5626l;
import ua.InterfaceC5628n;
import ua.InterfaceC5636v;
import ua.InterfaceC5637w;
import va.C5686a;
import va.C5687b;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class BuiltInsLoaderImpl implements b {

    /* renamed from: b, reason: collision with root package name */
    public final C5687b f36014b = new C5687b();

    @Override // C9.b
    public F a(InterfaceC5869l storageManager, InterfaceC0819y builtInsModule, Iterable<? extends G9.b> classDescriptorFactories, c platformDependentDeclarationFilter, G9.a additionalClassPartsProvider, boolean z10) {
        p.i(storageManager, "storageManager");
        p.i(builtInsModule, "builtInsModule");
        p.i(classDescriptorFactories, "classDescriptorFactories");
        p.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        p.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        return b(storageManager, builtInsModule, o.f1819K, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z10, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.f36014b));
    }

    public final F b(InterfaceC5869l interfaceC5869l, InterfaceC0819y interfaceC0819y, Set<ga.c> packageFqNames, Iterable<? extends G9.b> classDescriptorFactories, c platformDependentDeclarationFilter, G9.a additionalClassPartsProvider, boolean z10, InterfaceC5074l<? super String, ? extends InputStream> loadResource) throws IOException {
        a aVarA;
        InterfaceC5869l storageManager = interfaceC5869l;
        InterfaceC0819y module = interfaceC0819y;
        p.i(storageManager, "storageManager");
        p.i(module, "module");
        p.i(packageFqNames, "packageFqNames");
        p.i(classDescriptorFactories, "classDescriptorFactories");
        p.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        p.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        p.i(loadResource, "loadResource");
        ArrayList arrayList = new ArrayList();
        for (ga.c cVar : packageFqNames) {
            InputStream inputStreamInvoke = loadResource.invoke(C5686a.f42871r.r(cVar));
            if (inputStreamInvoke != null) {
                InterfaceC0819y interfaceC0819y2 = module;
                aVarA = a.f36015o.a(cVar, interfaceC5869l, interfaceC0819y2, inputStreamInvoke, z10);
                storageManager = interfaceC5869l;
                module = interfaceC0819y2;
            } else {
                aVarA = null;
            }
            if (aVarA != null) {
                arrayList.add(aVarA);
            }
        }
        I i10 = new I(arrayList);
        D d10 = new D(storageManager, module);
        InterfaceC5628n.a aVar = InterfaceC5628n.a.f42632a;
        C5630p c5630p = new C5630p(i10);
        C5686a c5686a = C5686a.f42871r;
        C5619e c5619e = new C5619e(module, d10, c5686a);
        InterfaceC5591A.a aVar2 = InterfaceC5591A.a.f42514a;
        InterfaceC5636v DO_NOTHING = InterfaceC5636v.f42653a;
        p.h(DO_NOTHING, "DO_NOTHING");
        C5627m c5627m = new C5627m(storageManager, interfaceC0819y, aVar, c5630p, c5619e, i10, aVar2, DO_NOTHING, c.a.f4661a, InterfaceC5637w.a.f42654a, classDescriptorFactories, d10, InterfaceC5626l.f42608a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, c5686a.e(), null, new C5167b(storageManager, C1173v.m()), null, null, 851968, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).F0(c5627m);
        }
        return i10;
    }
}
