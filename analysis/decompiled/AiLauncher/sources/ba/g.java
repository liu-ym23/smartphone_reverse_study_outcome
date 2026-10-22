package ba;

import E9.D;
import E9.InterfaceC0819y;
import E9.Z;
import M9.c;
import S9.C1004c;
import S9.s;
import T9.i;
import V9.e;
import Z8.C1172u;
import Z8.C1173v;
import Z9.InterfaceC1178a;
import aa.C1260h;
import aa.l0;
import ea.C4019c;
import java.util.List;
import qa.C5167b;
import ua.InterfaceC5626l;
import ua.InterfaceC5628n;
import ua.InterfaceC5636v;
import xa.InterfaceC5869l;
import ya.C6016w;

/* loaded from: classes5.dex */
public final class g {

    public static final class a implements S9.w {
        @Override // S9.w
        public List<InterfaceC1178a> a(ga.b classId) {
            kotlin.jvm.internal.p.i(classId, "classId");
            return null;
        }
    }

    public static final f a(InterfaceC0819y module, InterfaceC5869l storageManager, D notFoundClasses, V9.j lazyJavaPackageFragmentProvider, p reflectKotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.e deserializedDescriptorResolver, InterfaceC5636v errorReporter, C4019c metadataVersion) {
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.p.i(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        kotlin.jvm.internal.p.i(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.p.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.p.i(errorReporter, "errorReporter");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        return new f(storageManager, module, InterfaceC5628n.a.f42632a, new i(reflectKotlinClassFinder, deserializedDescriptorResolver), d.a(module, notFoundClasses, storageManager, reflectKotlinClassFinder, metadataVersion), lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter, c.a.f4661a, InterfaceC5626l.f42608a.a(), kotlin.reflect.jvm.internal.impl.types.checker.e.f36100b.a(), new Ba.a(C1172u.e(C6016w.f44130a)));
    }

    public static final V9.j b(S9.r javaClassFinder, InterfaceC0819y module, InterfaceC5869l storageManager, D notFoundClasses, p reflectKotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.e deserializedDescriptorResolver, InterfaceC5636v errorReporter, Y9.b javaSourceElementFactory, V9.n singleModuleClassResolver, v packagePartProvider) {
        kotlin.jvm.internal.p.i(javaClassFinder, "javaClassFinder");
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.p.i(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.p.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.p.i(errorReporter, "errorReporter");
        kotlin.jvm.internal.p.i(javaSourceElementFactory, "javaSourceElementFactory");
        kotlin.jvm.internal.p.i(singleModuleClassResolver, "singleModuleClassResolver");
        kotlin.jvm.internal.p.i(packagePartProvider, "packagePartProvider");
        S9.A aB = S9.A.f5667d.b(new Y8.f(1, 9));
        T9.o DO_NOTHING = T9.o.f5911a;
        kotlin.jvm.internal.p.h(DO_NOTHING, "DO_NOTHING");
        T9.j EMPTY = T9.j.f5904a;
        kotlin.jvm.internal.p.h(EMPTY, "EMPTY");
        i.a aVar = i.a.f5903a;
        C5167b c5167b = new C5167b(storageManager, C1173v.m());
        Z.a aVar2 = Z.a.f2446a;
        c.a aVar3 = c.a.f4661a;
        C9.n nVar = new C9.n(module, notFoundClasses);
        C1004c c1004c = new C1004c(aB);
        e.a aVar4 = e.a.f6530a;
        return new V9.j(new V9.d(storageManager, javaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, errorReporter, EMPTY, aVar, c5167b, javaSourceElementFactory, singleModuleClassResolver, packagePartProvider, aVar2, aVar3, module, nVar, c1004c, new l0(new C1260h(aVar4)), s.a.f5766a, aVar4, kotlin.reflect.jvm.internal.impl.types.checker.e.f36100b.a(), aB, new a(), null, 8388608, null));
    }
}
