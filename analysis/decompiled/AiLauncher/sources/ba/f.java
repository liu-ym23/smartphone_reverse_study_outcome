package ba;

import E9.D;
import E9.InterfaceC0819y;
import G9.a;
import G9.c;
import H9.C0833l;
import H9.F;
import Z8.C1173v;
import ba.v;
import ea.C4019c;
import fa.C4071h;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import pa.C5079c;
import qa.C5167b;
import ua.C5627m;
import ua.C5639y;
import ua.InterfaceC5591A;
import ua.InterfaceC5626l;
import ua.InterfaceC5628n;
import ua.InterfaceC5636v;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15328b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final C5627m f15329a;

    public static final class a {

        /* renamed from: ba.f$a$a, reason: collision with other inner class name */
        public static final class C0190a {

            /* renamed from: a, reason: collision with root package name */
            public final f f15330a;

            /* renamed from: b, reason: collision with root package name */
            public final kotlin.reflect.jvm.internal.impl.load.kotlin.e f15331b;

            public C0190a(f deserializationComponentsForJava, kotlin.reflect.jvm.internal.impl.load.kotlin.e deserializedDescriptorResolver) {
                kotlin.jvm.internal.p.i(deserializationComponentsForJava, "deserializationComponentsForJava");
                kotlin.jvm.internal.p.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
                this.f15330a = deserializationComponentsForJava;
                this.f15331b = deserializedDescriptorResolver;
            }

            public final f a() {
                return this.f15330a;
            }

            public final kotlin.reflect.jvm.internal.impl.load.kotlin.e b() {
                return this.f15331b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C0190a a(p kotlinClassFinder, p jvmBuiltInsKotlinClassFinder, S9.r javaClassFinder, String moduleName, InterfaceC5636v errorReporter, Y9.b javaSourceElementFactory) {
            kotlin.jvm.internal.p.i(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.p.i(jvmBuiltInsKotlinClassFinder, "jvmBuiltInsKotlinClassFinder");
            kotlin.jvm.internal.p.i(javaClassFinder, "javaClassFinder");
            kotlin.jvm.internal.p.i(moduleName, "moduleName");
            kotlin.jvm.internal.p.i(errorReporter, "errorReporter");
            kotlin.jvm.internal.p.i(javaSourceElementFactory, "javaSourceElementFactory");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            ga.e eVarM = ga.e.m('<' + moduleName + '>');
            kotlin.jvm.internal.p.h(eVarM, "special(...)");
            F f10 = new F(eVarM, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.F0(f10);
            jvmBuiltIns.N0(f10, true);
            kotlin.reflect.jvm.internal.impl.load.kotlin.e eVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.e();
            V9.o oVar = new V9.o();
            D d10 = new D(lockBasedStorageManager, f10);
            V9.j jVarB = g.b(javaClassFinder, f10, lockBasedStorageManager, d10, kotlinClassFinder, eVar, errorReporter, javaSourceElementFactory, oVar, (512 & 512) != 0 ? v.a.f15366a : null);
            f fVarA = g.a(f10, lockBasedStorageManager, d10, jVarB, kotlinClassFinder, eVar, errorReporter, C4019c.f32404i);
            eVar.o(fVarA);
            T9.j EMPTY = T9.j.f5904a;
            kotlin.jvm.internal.p.h(EMPTY, "EMPTY");
            C5079c c5079c = new C5079c(jVarB, EMPTY);
            oVar.c(c5079c);
            D9.r rVar = new D9.r(lockBasedStorageManager, jvmBuiltInsKotlinClassFinder, f10, d10, jvmBuiltIns.M0(), jvmBuiltIns.M0(), InterfaceC5628n.a.f42632a, kotlin.reflect.jvm.internal.impl.types.checker.e.f36100b.a(), new C5167b(lockBasedStorageManager, C1173v.m()));
            f10.Q0(f10);
            f10.I0(new C0833l(C1173v.p(c5079c.a(), rVar), "CompositeProvider@RuntimeModuleData for " + f10));
            return new C0190a(fVarA, eVar);
        }

        public a() {
        }
    }

    public f(InterfaceC5869l storageManager, InterfaceC0819y moduleDescriptor, InterfaceC5628n configuration, i classDataFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.d annotationAndConstantLoader, V9.j packageFragmentProvider, D notFoundClasses, InterfaceC5636v errorReporter, M9.c lookupTracker, InterfaceC5626l contractDeserializer, kotlin.reflect.jvm.internal.impl.types.checker.e kotlinTypeChecker, Ba.a typeAttributeTranslators) {
        G9.c cVarM0;
        G9.a aVarM0;
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.p.i(configuration, "configuration");
        kotlin.jvm.internal.p.i(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.p.i(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.p.i(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.p.i(errorReporter, "errorReporter");
        kotlin.jvm.internal.p.i(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.p.i(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.p.i(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.p.i(typeAttributeTranslators, "typeAttributeTranslators");
        C9.j jVarG = moduleDescriptor.g();
        JvmBuiltIns jvmBuiltIns = jVarG instanceof JvmBuiltIns ? (JvmBuiltIns) jVarG : null;
        this.f15329a = new C5627m(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, InterfaceC5591A.a.f42514a, errorReporter, lookupTracker, j.f15335a, C1173v.m(), notFoundClasses, contractDeserializer, (jvmBuiltIns == null || (aVarM0 = jvmBuiltIns.M0()) == null) ? a.C0039a.f2867a : aVarM0, (jvmBuiltIns == null || (cVarM0 = jvmBuiltIns.M0()) == null) ? c.b.f2869a : cVarM0, C4071h.f32594a.a(), kotlinTypeChecker, new C5167b(storageManager, C1173v.m()), typeAttributeTranslators.a(), C5639y.f42660a);
    }

    public final C5627m a() {
        return this.f15329a;
    }
}
