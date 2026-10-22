package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RuntimeModuleData {
    public static final Companion Companion = null;
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    /* JADX INFO: compiled from: RuntimeModuleData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final RuntimeModuleData create(ClassLoader r8) {
            Intrinsics.checkNotNullParameter(r8, "classLoader");
            ReflectKotlinClassFinder r7 = new ReflectKotlinClassFinder(r8);
            ClassLoader r3 = Unit.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(r3, "Unit::class.java.classLoader");
            DeserializationComponentsForJava.Companion.ModuleData r9 = DeserializationComponentsForJava.Companion.createModuleData(r7, new ReflectKotlinClassFinder(r3), new ReflectJavaClassFinder(r8), "runtime module for " + r8, RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(r9.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(r9.getDeserializedDescriptorResolver(), r7), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents r1, PackagePartScopeCache r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private RuntimeModuleData(DeserializationComponents r1, PackagePartScopeCache r2) {
        this.deserialization = r1;
        this.packagePartScopeCache = r2;
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }
}
