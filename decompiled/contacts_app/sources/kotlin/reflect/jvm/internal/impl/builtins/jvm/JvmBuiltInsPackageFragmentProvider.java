package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JvmBuiltInsPackageFragmentProvider(StorageManager r26, KotlinClassFinder r27, ModuleDescriptor r28, NotFoundClasses r29, AdditionalClassPartsProvider r30, PlatformDependentDeclarationFilter r31, DeserializationConfiguration r32, NewKotlinTypeChecker r33, SamConversionResolver r34) {
        Intrinsics.checkNotNullParameter(r26, "storageManager");
        Intrinsics.checkNotNullParameter(r27, "finder");
        Intrinsics.checkNotNullParameter(r28, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r29, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r30, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(r31, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r32, "deserializationConfiguration");
        Intrinsics.checkNotNullParameter(r33, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r34, "samConversionResolver");
        super(r26, r27, r28);
        JvmBuiltInsPackageFragmentProvider r8 = this;
        DeserializedClassDataFinder r5 = new DeserializedClassDataFinder(r8);
        AnnotationAndConstantLoaderImpl r6 = new AnnotationAndConstantLoaderImpl(r28, r29, BuiltInSerializerProtocol.INSTANCE);
        LocalClassifierTypeSettings.Default r9 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter r10 = ErrorReporter.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(r10, "DO_NOTHING");
        setComponents(new DeserializationComponents(r26, r28, r32, r5, r6, r8, r9, r10, LookupTracker.DO_NOTHING.INSTANCE, FlexibleTypeDeserializer.ThrowException.INSTANCE, CollectionsKt.listOf(new ClassDescriptorFactory[]{new BuiltInFictitiousFunctionClassFactory(r26, r28), new JvmBuiltInClassDescriptorFactory(r26, r28, null, 4, null)}), r29, ContractDeserializer.Companion.getDEFAULT(), r30, r31, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry(), r33, r34, null, null, 786432, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider
    protected DeserializedPackageFragment findPackage(FqName r8) {
        Intrinsics.checkNotNullParameter(r8, "fqName");
        InputStream r5 = getFinder().findBuiltInsData(r8);
        if (r5 == null) goto L5;
        BuiltInsPackageFragmentImpl r7 = BuiltInsPackageFragmentImpl.Companion.create(r8, getStorageManager(), getModuleDescriptor(), r5, false);
    L7:
        return r7;
    L5:
        r7 = null;
        goto L7
    }
}
