package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedPropertyDescriptor extends PropertyDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final DeserializedContainerSource containerSource;
    private final NameResolver nameResolver;
    private final ProtoBuf.Property proto;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public ProtoBuf.Property getProto() {
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

    public DeserializedPropertyDescriptor(DeclarationDescriptor r18, PropertyDescriptor r19, Annotations r20, Modality r21, DescriptorVisibility r22, boolean r23, Name r24, CallableMemberDescriptor.Kind r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, ProtoBuf.Property r31, NameResolver r32, TypeTable r33, VersionRequirementTable r34, DeserializedContainerSource r35) {
        Intrinsics.checkNotNullParameter(r18, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r20, "annotations");
        Intrinsics.checkNotNullParameter(r21, "modality");
        Intrinsics.checkNotNullParameter(r22, "visibility");
        Intrinsics.checkNotNullParameter(r24, "name");
        Intrinsics.checkNotNullParameter(r25, "kind");
        Intrinsics.checkNotNullParameter(r31, "proto");
        Intrinsics.checkNotNullParameter(r32, "nameResolver");
        Intrinsics.checkNotNullParameter(r33, "typeTable");
        Intrinsics.checkNotNullParameter(r34, "versionRequirementTable");
        super(r18, r19, r20, r21, r22, r23, r24, r25, SourceElement.NO_SOURCE, r26, r27, r30, false, r28, r29);
        this.proto = r31;
        this.nameResolver = r32;
        this.typeTable = r33;
        this.versionRequirementTable = r34;
        this.containerSource = r35;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    protected PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r21, Modality r22, DescriptorVisibility r23, PropertyDescriptor r24, CallableMemberDescriptor.Kind r25, Name r26, SourceElement r27) {
        Intrinsics.checkNotNullParameter(r21, "newOwner");
        Intrinsics.checkNotNullParameter(r22, "newModality");
        Intrinsics.checkNotNullParameter(r23, "newVisibility");
        Intrinsics.checkNotNullParameter(r25, "kind");
        Intrinsics.checkNotNullParameter(r26, "newName");
        Intrinsics.checkNotNullParameter(r27, "source");
        return new DeserializedPropertyDescriptor(r21, r24, getAnnotations(), r22, r23, isVar(), r26, r25, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean r1 = Flags.IS_EXTERNAL_PROPERTY.get(getProto().getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return r1.booleanValue();
    }
}
