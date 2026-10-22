package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedSimpleFunctionDescriptor extends SimpleFunctionDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final DeserializedContainerSource containerSource;
    private final NameResolver nameResolver;
    private final ProtoBuf.Function proto;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public /* synthetic */ DeserializedSimpleFunctionDescriptor(DeclarationDescriptor r14, SimpleFunctionDescriptor r15, Annotations r16, Name r17, CallableMemberDescriptor.Kind r18, ProtoBuf.Function r19, NameResolver r20, TypeTable r21, VersionRequirementTable r22, DeserializedContainerSource r23, SourceElement r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 1024) == 0) goto L5;
        SourceElement r12 = null;
    L6:
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r12);
        return;
    L5:
        r12 = r24;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public ProtoBuf.Function getProto() {
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

    public DeserializedSimpleFunctionDescriptor(DeclarationDescriptor r13, SimpleFunctionDescriptor r14, Annotations r15, Name r16, CallableMemberDescriptor.Kind r17, ProtoBuf.Function r18, NameResolver r19, TypeTable r20, VersionRequirementTable r21, DeserializedContainerSource r22, SourceElement r23) {
        Intrinsics.checkNotNullParameter(r13, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r15, "annotations");
        Intrinsics.checkNotNullParameter(r16, "name");
        Intrinsics.checkNotNullParameter(r17, "kind");
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "typeTable");
        Intrinsics.checkNotNullParameter(r21, "versionRequirementTable");
        if (r23 != null) goto L5;
        SourceElement r6 = SourceElement.NO_SOURCE;
    L6:
        super(r13, r14, r15, r16, r17, r6);
        this.proto = r18;
        this.nameResolver = r19;
        this.typeTable = r20;
        this.versionRequirementTable = r21;
        this.containerSource = r22;
        return;
    L5:
        r6 = r23;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r14, FunctionDescriptor r15, CallableMemberDescriptor.Kind r16, Name r17, Annotations r18, SourceElement r19) {
        Intrinsics.checkNotNullParameter(r14, "newOwner");
        Intrinsics.checkNotNullParameter(r16, "kind");
        Intrinsics.checkNotNullParameter(r18, "annotations");
        Intrinsics.checkNotNullParameter(r19, "source");
        SimpleFunctionDescriptor r3 = (SimpleFunctionDescriptor) r15;
        if (r17 != null) goto L5;
        Name r1 = getName();
        Intrinsics.checkNotNullExpressionValue(r1, "name");
        Name r5 = r1;
    L6:
        DeserializedSimpleFunctionDescriptor r0 = new DeserializedSimpleFunctionDescriptor(r14, r3, r18, r5, r16, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), r19);
        r0.setHasStableParameterNames(hasStableParameterNames());
        return r0;
    L5:
        r5 = r17;
        goto L6
    }
}
