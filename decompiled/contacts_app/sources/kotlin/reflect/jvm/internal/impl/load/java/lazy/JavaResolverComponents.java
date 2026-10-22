package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaResolverComponents {
    private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final ErrorReporter errorReporter;
    private final JavaClassFinder finder;
    private final JavaClassesTracker javaClassesTracker;
    private final JavaModuleAnnotationsProvider javaModuleResolver;
    private final JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
    private final JavaResolverCache javaResolverCache;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final KotlinClassFinder kotlinClassFinder;
    private final NewKotlinTypeChecker kotlinTypeChecker;
    private final LookupTracker lookupTracker;
    private final ModuleDescriptor module;
    private final ModuleClassResolver moduleClassResolver;
    private final PackagePartProvider packagePartProvider;
    private final ReflectionTypes reflectionTypes;
    private final SamConversionResolver samConversionResolver;
    private final JavaResolverSettings settings;
    private final SignatureEnhancement signatureEnhancement;
    private final SignaturePropagator signaturePropagator;
    private final JavaSourceElementFactory sourceElementFactory;
    private final StorageManager storageManager;
    private final SupertypeLoopChecker supertypeLoopChecker;
    private final SyntheticJavaPartsProvider syntheticPartsProvider;

    public JavaResolverComponents(StorageManager r17, JavaClassFinder r18, KotlinClassFinder r19, DeserializedDescriptorResolver r20, SignaturePropagator r21, ErrorReporter r22, JavaResolverCache r23, JavaPropertyInitializerEvaluator r24, SamConversionResolver r25, JavaSourceElementFactory r26, ModuleClassResolver r27, PackagePartProvider r28, SupertypeLoopChecker r29, LookupTracker r30, ModuleDescriptor r31, ReflectionTypes r32, AnnotationTypeQualifierResolver r33, SignatureEnhancement r34, JavaClassesTracker r35, JavaResolverSettings r36, NewKotlinTypeChecker r37, JavaTypeEnhancementState r38, JavaModuleAnnotationsProvider r39, SyntheticJavaPartsProvider r40) {
        Intrinsics.checkNotNullParameter(r17, "storageManager");
        Intrinsics.checkNotNullParameter(r18, "finder");
        Intrinsics.checkNotNullParameter(r19, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r20, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(r21, "signaturePropagator");
        Intrinsics.checkNotNullParameter(r22, "errorReporter");
        Intrinsics.checkNotNullParameter(r23, "javaResolverCache");
        Intrinsics.checkNotNullParameter(r24, "javaPropertyInitializerEvaluator");
        Intrinsics.checkNotNullParameter(r25, "samConversionResolver");
        Intrinsics.checkNotNullParameter(r26, "sourceElementFactory");
        Intrinsics.checkNotNullParameter(r27, "moduleClassResolver");
        Intrinsics.checkNotNullParameter(r28, "packagePartProvider");
        Intrinsics.checkNotNullParameter(r29, "supertypeLoopChecker");
        Intrinsics.checkNotNullParameter(r30, "lookupTracker");
        Intrinsics.checkNotNullParameter(r31, "module");
        Intrinsics.checkNotNullParameter(r32, "reflectionTypes");
        Intrinsics.checkNotNullParameter(r33, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(r34, "signatureEnhancement");
        Intrinsics.checkNotNullParameter(r35, "javaClassesTracker");
        Intrinsics.checkNotNullParameter(r36, "settings");
        Intrinsics.checkNotNullParameter(r37, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r38, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(r39, "javaModuleResolver");
        Intrinsics.checkNotNullParameter(r40, "syntheticPartsProvider");
        this.storageManager = r17;
        this.finder = r18;
        this.kotlinClassFinder = r19;
        this.deserializedDescriptorResolver = r20;
        this.signaturePropagator = r21;
        this.errorReporter = r22;
        this.javaResolverCache = r23;
        this.javaPropertyInitializerEvaluator = r24;
        this.samConversionResolver = r25;
        this.sourceElementFactory = r26;
        this.moduleClassResolver = r27;
        this.packagePartProvider = r28;
        this.supertypeLoopChecker = r29;
        this.lookupTracker = r30;
        this.module = r31;
        this.reflectionTypes = r32;
        this.annotationTypeQualifierResolver = r33;
        this.signatureEnhancement = r34;
        this.javaClassesTracker = r35;
        this.settings = r36;
        this.kotlinTypeChecker = r37;
        this.javaTypeEnhancementState = r38;
        this.javaModuleResolver = r39;
        this.syntheticPartsProvider = r40;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final JavaClassFinder getFinder() {
        return this.finder;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.deserializedDescriptorResolver;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.signaturePropagator;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.javaResolverCache;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.javaPropertyInitializerEvaluator;
    }

    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.sourceElementFactory;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.moduleClassResolver;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.packagePartProvider;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.supertypeLoopChecker;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final ModuleDescriptor getModule() {
        return this.module;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.reflectionTypes;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.annotationTypeQualifierResolver;
    }

    public final SignatureEnhancement getSignatureEnhancement() {
        return this.signatureEnhancement;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.javaClassesTracker;
    }

    public final JavaResolverSettings getSettings() {
        return this.settings;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.javaTypeEnhancementState;
    }

    public final JavaModuleAnnotationsProvider getJavaModuleResolver() {
        return this.javaModuleResolver;
    }

    public /* synthetic */ JavaResolverComponents(StorageManager r27, JavaClassFinder r28, KotlinClassFinder r29, DeserializedDescriptorResolver r30, SignaturePropagator r31, ErrorReporter r32, JavaResolverCache r33, JavaPropertyInitializerEvaluator r34, SamConversionResolver r35, JavaSourceElementFactory r36, ModuleClassResolver r37, PackagePartProvider r38, SupertypeLoopChecker r39, LookupTracker r40, ModuleDescriptor r41, ReflectionTypes r42, AnnotationTypeQualifierResolver r43, SignatureEnhancement r44, JavaClassesTracker r45, JavaResolverSettings r46, NewKotlinTypeChecker r47, JavaTypeEnhancementState r48, JavaModuleAnnotationsProvider r49, SyntheticJavaPartsProvider r50, int r51, DefaultConstructorMarker r52) {
        if ((r51 & 8388608) == 0) goto L5;
        SyntheticJavaPartsProvider r25 = SyntheticJavaPartsProvider.Companion.getEMPTY();
    L6:
        this(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r25);
        return;
    L5:
        r25 = r50;
        goto L6
    }

    public final SyntheticJavaPartsProvider getSyntheticPartsProvider() {
        return this.syntheticPartsProvider;
    }

    public final JavaResolverComponents replace(JavaResolverCache r30) {
        Intrinsics.checkNotNullParameter(r30, "javaResolverCache");
        return new JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, r30, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker, this.javaTypeEnhancementState, this.javaModuleResolver, null, 8388608, null);
    }
}
