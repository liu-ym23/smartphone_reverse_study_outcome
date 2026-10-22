package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedTypeAliasDescriptor extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    private Collection<? extends TypeAliasConstructorDescriptor> constructors;
    private final DeserializedContainerSource containerSource;
    private SimpleType defaultTypeImpl;
    private SimpleType expandedType;
    private final NameResolver nameResolver;
    private final ProtoBuf.TypeAlias proto;
    private final StorageManager storageManager;
    private List<? extends TypeParameterDescriptor> typeConstructorParameters;
    private final TypeTable typeTable;
    private SimpleType underlyingType;
    private final VersionRequirementTable versionRequirementTable;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    protected StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public ProtoBuf.TypeAlias getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public DeserializedTypeAliasDescriptor(StorageManager r13, DeclarationDescriptor r14, Annotations r15, Name r16, DescriptorVisibility r17, ProtoBuf.TypeAlias r18, NameResolver r19, TypeTable r20, VersionRequirementTable r21, DeserializedContainerSource r22) {
        Intrinsics.checkNotNullParameter(r13, "storageManager");
        Intrinsics.checkNotNullParameter(r14, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r15, "annotations");
        Intrinsics.checkNotNullParameter(r16, "name");
        Intrinsics.checkNotNullParameter(r17, "visibility");
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "typeTable");
        Intrinsics.checkNotNullParameter(r21, "versionRequirementTable");
        SourceElement r4 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r4, "NO_SOURCE");
        super(r14, r15, r16, r4, r17);
        this.storageManager = r13;
        this.proto = r18;
        this.nameResolver = r19;
        this.typeTable = r20;
        this.versionRequirementTable = r21;
        this.containerSource = r22;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public SimpleType getUnderlyingType() {
        SimpleType r0 = this.underlyingType;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public SimpleType getExpandedType() {
        SimpleType r0 = this.expandedType;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        return null;
    }

    public final void initialize(List<? extends TypeParameterDescriptor> r2, SimpleType r3, SimpleType r4) {
        Intrinsics.checkNotNullParameter(r2, "declaredTypeParameters");
        Intrinsics.checkNotNullParameter(r3, "underlyingType");
        Intrinsics.checkNotNullParameter(r4, "expandedType");
        initialize(r2);
        this.underlyingType = r3;
        this.expandedType = r4;
        this.typeConstructorParameters = TypeParameterUtilsKt.computeConstructorTypeParameters(this);
        this.defaultTypeImpl = computeDefaultType();
        this.constructors = getTypeAliasConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public ClassDescriptor getClassDescriptor() {
        if (KotlinTypeKt.isError(getExpandedType()) == true) goto L10;
        ClassifierDescriptor r2 = getExpandedType().getConstructor().mo2083getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == true) goto L8;
        return null;
    L8:
        return (ClassDescriptor) r2;
    L10:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType r0 = this.defaultTypeImpl;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
        return null;
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public TypeAliasDescriptor substitute(TypeSubstitutor r13) {
        Intrinsics.checkNotNullParameter(r13, "substitutor");
        if (r13.isEmpty() == true) goto L5;
        StorageManager r1 = getStorageManager();
        DeclarationDescriptor r2 = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r2, "containingDeclaration");
        Annotations r3 = getAnnotations();
        Intrinsics.checkNotNullExpressionValue(r3, "annotations");
        Name r4 = getName();
        Intrinsics.checkNotNullExpressionValue(r4, "name");
        DeserializedTypeAliasDescriptor r11 = new DeserializedTypeAliasDescriptor(r1, r2, r3, r4, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> r0 = getDeclaredTypeParameters();
        KotlinType r5 = r13.safeSubstitute(getUnderlyingType(), Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(r5, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        SimpleType r6 = TypeSubstitutionKt.asSimpleType(r5);
        KotlinType r12 = r13.safeSubstitute(getExpandedType(), Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(r12, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        r11.initialize(r0, r6, TypeSubstitutionKt.asSimpleType(r12));
        return r11;
    L5:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    protected List<TypeParameterDescriptor> getTypeConstructorTypeParameters() {
        List r0 = this.typeConstructorParameters;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
        return null;
    L6:
        return r0;
    }
}
