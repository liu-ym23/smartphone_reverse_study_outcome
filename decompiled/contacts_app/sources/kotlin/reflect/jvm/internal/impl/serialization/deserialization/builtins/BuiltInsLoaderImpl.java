package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    private final BuiltInsResourceLoader resourceLoader;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl$createPackageFragmentProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
    /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<String, InputStream> {
        AnonymousClass1(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadResource";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(BuiltInsResourceLoader.class);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final InputStream invoke2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return ((BuiltInsResourceLoader) this.receiver).loadResource(r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InputStream invoke(String r1) {
            return invoke2(r1);
        }
    }

    public BuiltInsLoaderImpl() {
        this.resourceLoader = new BuiltInsResourceLoader();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    public PackageFragmentProvider createPackageFragmentProvider(StorageManager r11, ModuleDescriptor r12, Iterable<? extends ClassDescriptorFactory> r13, PlatformDependentDeclarationFilter r14, AdditionalClassPartsProvider r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "builtInsModule");
        Intrinsics.checkNotNullParameter(r13, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(r14, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r15, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(r11, r12, StandardNames.BUILT_INS_PACKAGE_FQ_NAMES, r13, r14, r15, r16, new AnonymousClass1(this.resourceLoader));
    }

    public static /* synthetic */ PackageFragmentProvider createBuiltInPackageFragmentProvider$default(BuiltInsLoaderImpl r10, StorageManager r11, ModuleDescriptor r12, Set r13, Iterable r14, PlatformDependentDeclarationFilter r15, AdditionalClassPartsProvider r16, boolean r17, Function1 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        AdditionalClassPartsProvider r7 = AdditionalClassPartsProvider.None.INSTANCE;
    L7:
        return r10.createBuiltInPackageFragmentProvider(r11, r12, r13, r14, r15, r7, r17, r18);
    L5:
        r7 = r16;
        goto L7
    }

    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(StorageManager r27, ModuleDescriptor r28, Set<FqName> r29, Iterable<? extends ClassDescriptorFactory> r30, PlatformDependentDeclarationFilter r31, AdditionalClassPartsProvider r32, boolean r33, Function1<? super String, ? extends InputStream> r34) {
        Intrinsics.checkNotNullParameter(r27, "storageManager");
        Intrinsics.checkNotNullParameter(r28, "module");
        Intrinsics.checkNotNullParameter(r29, "packageFqNames");
        Intrinsics.checkNotNullParameter(r30, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(r31, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r32, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(r34, "loadResource");
        Set<FqName> r0 = r29;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r8 = r0.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        FqName r1 = (FqName) r8.next();
        String r2 = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r1);
        InputStream r4 = r34.invoke(r2);
        if (r4 == null) goto L9;
        r7.add(BuiltInsPackageFragmentImpl.Companion.create(r1, r27, r28, r4, r33));
        goto L4
    L9:
        throw new IllegalStateException("Resource not found in classpath: " + r2);
    L10:
        ArrayList r23 = r7;
        PackageFragmentProviderImpl r3 = new PackageFragmentProviderImpl(r23);
        NotFoundClasses r5 = new NotFoundClasses(r27, r28);
        DeserializationConfiguration.Default r6 = DeserializationConfiguration.Default.INSTANCE;
        PackageFragmentProviderImpl r9 = r3;
        DeserializedClassDataFinder r10 = new DeserializedClassDataFinder(r9);
        AnnotationAndConstantLoaderImpl r11 = new AnnotationAndConstantLoaderImpl(r28, r5, BuiltInSerializerProtocol.INSTANCE);
        LocalClassifierTypeSettings.Default r12 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter r13 = ErrorReporter.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(r13, "DO_NOTHING");
        DeserializationComponents r14 = new DeserializationComponents(r27, r28, r6, r10, r11, r9, r12, r13, LookupTracker.DO_NOTHING.INSTANCE, FlexibleTypeDeserializer.ThrowException.INSTANCE, r30, r5, ContractDeserializer.Companion.getDEFAULT(), r32, r31, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry(), null, new SamConversionResolverImpl(r27, CollectionsKt.emptyList()), null, null, 851968, null);
        Iterator r15 = r23.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        ((BuiltInsPackageFragmentImpl) r15.next()).initialize(r14);
        goto L12
    L14:
        return r9;
    }
}
