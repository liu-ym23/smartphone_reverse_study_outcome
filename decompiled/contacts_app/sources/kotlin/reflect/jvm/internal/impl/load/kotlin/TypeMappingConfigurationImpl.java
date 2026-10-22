package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE = null;

    static {
        INSTANCE = new TypeMappingConfigurationImpl();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedInternalNameForClass(ClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    /* JADX INFO: renamed from: getPredefinedTypeForClass, reason: avoid collision after fix types in other method */
    public JvmType getPredefinedTypeForClass2(ClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(KotlinType r1, ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r1, "kotlinType");
        Intrinsics.checkNotNullParameter(r2, "descriptor");
    }

    private TypeMappingConfigurationImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedFullInternalNameForClass(ClassDescriptor r1) {
        return TypeMappingConfiguration.DefaultImpls.getPredefinedFullInternalNameForClass(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public /* bridge */ /* synthetic */ JvmType getPredefinedTypeForClass(ClassDescriptor r1) {
        return getPredefinedTypeForClass2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType preprocessType(KotlinType r1) {
        return TypeMappingConfiguration.DefaultImpls.preprocessType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType commonSupertype(Collection<? extends KotlinType> r12) {
        Intrinsics.checkNotNullParameter(r12, GloableSearchConfig.KEY_CONFIGS);
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + CollectionsKt.joinToString$default(r12, null, null, null, 0, null, null, 63, null));
    }
}
