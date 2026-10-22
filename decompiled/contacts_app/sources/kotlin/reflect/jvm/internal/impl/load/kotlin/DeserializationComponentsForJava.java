package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializationComponentsForJava {
    public static final Companion Companion = null;
    private final DeserializationComponents components;

    /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
        public static final class ModuleData {
            private final DeserializationComponentsForJava deserializationComponentsForJava;
            private final DeserializedDescriptorResolver deserializedDescriptorResolver;

            public ModuleData(DeserializationComponentsForJava r2, DeserializedDescriptorResolver r3) {
                Intrinsics.checkNotNullParameter(r2, "deserializationComponentsForJava");
                Intrinsics.checkNotNullParameter(r3, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = r2;
                this.deserializedDescriptorResolver = r3;
            }

            public final DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ModuleData createModuleData(KotlinClassFinder r28, KotlinClassFinder r29, JavaClassFinder r30, String r31, ErrorReporter r32, JavaSourceElementFactory r33) {
            Intrinsics.checkNotNullParameter(r28, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(r29, "jvmBuiltInsKotlinClassFinder");
            Intrinsics.checkNotNullParameter(r30, "javaClassFinder");
            Intrinsics.checkNotNullParameter(r31, "moduleName");
            Intrinsics.checkNotNullParameter(r32, "errorReporter");
            Intrinsics.checkNotNullParameter(r33, "javaSourceElementFactory");
            LockBasedStorageManager r1 = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns r12 = new JvmBuiltIns(r1, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name r0 = Name.special("<" + r31 + '>');
            Intrinsics.checkNotNullExpressionValue(r0, "special(\"<$moduleName>\")");
            ModuleDescriptorImpl r11 = new ModuleDescriptorImpl(r0, r1, r12, null, null, null, 56, null);
            r12.setBuiltInsModule(r11);
            ModuleDescriptorImpl r2 = r11;
            r12.initialize(r2, true);
            DeserializedDescriptorResolver r8 = new DeserializedDescriptorResolver();
            SingleModuleClassResolver r7 = new SingleModuleClassResolver();
            NotFoundClasses r6 = new NotFoundClasses(r1, r2);
            LazyJavaPackageFragmentProvider r9 = DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider$default(r30, r2, r1, r6, r28, r8, r32, r33, r7, null, 512, null);
            DeserializationComponentsForJava r13 = DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(r2, r1, r6, r9, r28, r8, r32);
            r8.setComponents(r13);
            JavaResolverCache r3 = JavaResolverCache.EMPTY;
            Intrinsics.checkNotNullExpressionValue(r3, "EMPTY");
            JavaDescriptorResolver r14 = new JavaDescriptorResolver(r9, r3);
            r7.setResolver(r14);
            JvmBuiltInsPackageFragmentProvider r17 = new JvmBuiltInsPackageFragmentProvider(r1, r29, r2, r6, r12.getCustomizer(), r12.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(r1, CollectionsKt.emptyList()));
            r11.setDependencies(new ModuleDescriptorImpl[]{r11});
            r11.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf(new PackageFragmentProviderOptimized[]{r14.getPackageFragmentProvider(), r17}), "CompositeProvider@RuntimeModuleData for " + r11));
            return new ModuleData(r13, r8);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DeserializationComponentsForJava(StorageManager r30, ModuleDescriptor r31, DeserializationConfiguration r32, JavaClassDataFinder r33, BinaryClassAnnotationAndConstantLoaderImpl r34, LazyJavaPackageFragmentProvider r35, NotFoundClasses r36, ErrorReporter r37, LookupTracker r38, ContractDeserializer r39, NewKotlinTypeChecker r40, TypeAttributeTranslators r41) {
        Intrinsics.checkNotNullParameter(r30, "storageManager");
        Intrinsics.checkNotNullParameter(r31, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r32, "configuration");
        Intrinsics.checkNotNullParameter(r33, "classDataFinder");
        Intrinsics.checkNotNullParameter(r34, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(r35, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r36, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r37, "errorReporter");
        Intrinsics.checkNotNullParameter(r38, "lookupTracker");
        Intrinsics.checkNotNullParameter(r39, "contractDeserializer");
        Intrinsics.checkNotNullParameter(r40, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r41, "typeAttributeTranslators");
        KotlinBuiltIns r4 = r31.getBuiltIns();
        if ((r4 instanceof JvmBuiltIns) == false) goto L5;
        JvmBuiltIns r5 = (JvmBuiltIns) r4;
    L6:
        JavaClassDataFinder r10 = r33;
        BinaryClassAnnotationAndConstantLoaderImpl r11 = r34;
        LazyJavaPackageFragmentProvider r17 = r35;
        LocalClassifierTypeSettings.Default r23 = LocalClassifierTypeSettings.Default.INSTANCE;
        JavaFlexibleTypeDeserializer r24 = JavaFlexibleTypeDeserializer.INSTANCE;
        List r25 = CollectionsKt.emptyList();
        if (r5 == null) goto L11;
        AdditionalClassPartsProvider r0 = r5.getCustomizer();
        if (r0 == null) goto L11;
    L12:
        AdditionalClassPartsProvider r1 = r0;
        if (r5 == null) goto L17;
        PlatformDependentDeclarationFilter r2 = r5.getCustomizer();
        if (r2 == null) goto L17;
    L18:
        this.components = new DeserializationComponents(r30, r31, r32, r10, r11, r17, r23, r37, r38, r24, r25, r36, r39, r1, r2, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), r40, new SamConversionResolverImpl(r30, CollectionsKt.emptyList()), null, r41.getTranslators(), 262144, null);
        return;
    L17:
        r2 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
    L11:
        r0 = AdditionalClassPartsProvider.None.INSTANCE;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }
}
