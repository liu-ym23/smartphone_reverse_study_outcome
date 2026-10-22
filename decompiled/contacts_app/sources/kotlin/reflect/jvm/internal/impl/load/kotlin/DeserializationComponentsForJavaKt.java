package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializationComponentsForJavaKt {
    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider$default(JavaClassFinder r11, ModuleDescriptor r12, StorageManager r13, NotFoundClasses r14, KotlinClassFinder r15, DeserializedDescriptorResolver r16, ErrorReporter r17, JavaSourceElementFactory r18, ModuleClassResolver r19, PackagePartProvider r20, int r21, Object r22) {
        if ((r21 & 512) == 0) goto L5;
        PackagePartProvider r10 = PackagePartProvider.Empty.INSTANCE;
    L7:
        return makeLazyJavaPackageFragmentProvider(r11, r12, r13, r14, r15, r16, r17, r18, r19, r10);
    L5:
        r10 = r20;
        goto L7
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider(JavaClassFinder r30, ModuleDescriptor r31, StorageManager r32, NotFoundClasses r33, KotlinClassFinder r34, DeserializedDescriptorResolver r35, ErrorReporter r36, JavaSourceElementFactory r37, ModuleClassResolver r38, PackagePartProvider r39) {
        Intrinsics.checkNotNullParameter(r30, "javaClassFinder");
        Intrinsics.checkNotNullParameter(r31, "module");
        Intrinsics.checkNotNullParameter(r32, "storageManager");
        Intrinsics.checkNotNullParameter(r33, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r34, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(r35, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(r36, "errorReporter");
        Intrinsics.checkNotNullParameter(r37, "javaSourceElementFactory");
        Intrinsics.checkNotNullParameter(r38, "singleModuleClassResolver");
        Intrinsics.checkNotNullParameter(r39, "packagePartProvider");
        SignaturePropagator r7 = SignaturePropagator.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(r7, "DO_NOTHING");
        JavaResolverCache r8 = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(r8, "EMPTY");
        return new LazyJavaPackageFragmentProvider(new JavaResolverComponents(r32, r30, r34, r35, r7, r36, r8, JavaPropertyInitializerEvaluator.DoNothing.INSTANCE, new SamConversionResolverImpl(r32, CollectionsKt.emptyList()), r37, r38, r39, SupertypeLoopChecker.EMPTY.INSTANCE, LookupTracker.DO_NOTHING.INSTANCE, r31, new ReflectionTypes(r31, r33), new AnnotationTypeQualifierResolver(JavaTypeEnhancementState.Companion.getDEFAULT()), new SignatureEnhancement(new JavaTypeEnhancement(JavaResolverSettings.Default.INSTANCE)), JavaClassesTracker.Default.INSTANCE, JavaResolverSettings.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), JavaTypeEnhancementState.Companion.getDEFAULT(), new DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1(), null, 8388608, null));
    }

    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor r14, StorageManager r15, NotFoundClasses r16, LazyJavaPackageFragmentProvider r17, KotlinClassFinder r18, DeserializedDescriptorResolver r19, ErrorReporter r20) {
        Intrinsics.checkNotNullParameter(r14, "module");
        Intrinsics.checkNotNullParameter(r15, "storageManager");
        Intrinsics.checkNotNullParameter(r16, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r17, "lazyJavaPackageFragmentProvider");
        Intrinsics.checkNotNullParameter(r18, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(r19, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(r20, "errorReporter");
        JavaClassDataFinder r4 = new JavaClassDataFinder(r18, r19);
        BinaryClassAnnotationAndConstantLoaderImpl r5 = new BinaryClassAnnotationAndConstantLoaderImpl(r14, r16, r15, r18);
        return new DeserializationComponentsForJava(r15, r14, DeserializationConfiguration.Default.INSTANCE, r4, r5, r17, r16, r20, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault(), new TypeAttributeTranslators(CollectionsKt.listOf(DefaultTypeAttributeTranslator.INSTANCE)));
    }
}
