package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.Typography;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializationContext {
    private final DeserializationComponents components;
    private final DeserializedContainerSource containerSource;
    private final DeclarationDescriptor containingDeclaration;
    private final MemberDeserializer memberDeserializer;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final TypeDeserializer typeDeserializer;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializationContext(DeserializationComponents r2, NameResolver r3, DeclarationDescriptor r4, TypeTable r5, VersionRequirementTable r6, BinaryVersion r7, DeserializedContainerSource r8, TypeDeserializer r9, List<ProtoBuf.TypeParameter> r10) {
        Intrinsics.checkNotNullParameter(r2, "components");
        Intrinsics.checkNotNullParameter(r3, "nameResolver");
        Intrinsics.checkNotNullParameter(r4, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r5, "typeTable");
        Intrinsics.checkNotNullParameter(r6, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r7, "metadataVersion");
        Intrinsics.checkNotNullParameter(r10, "typeParameters");
        this.components = r2;
        this.nameResolver = r3;
        this.containingDeclaration = r4;
        this.typeTable = r5;
        this.versionRequirementTable = r6;
        this.metadataVersion = r7;
        this.containerSource = r8;
        String r11 = "Deserializer for \"" + r4.getName() + Typography.quote;
        if (r8 == null) goto L6;
        String r12 = r8.getPresentableString();
        if (r12 == null) goto L6;
    L7:
        this.typeDeserializer = new TypeDeserializer(this, r9, r10, r11, r12);
        this.memberDeserializer = new MemberDeserializer(this);
        return;
    L6:
        r12 = "[container not found]";
        goto L7
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public final DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext r7, DeclarationDescriptor r8, List r9, NameResolver r10, TypeTable r11, VersionRequirementTable r12, BinaryVersion r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = r7.nameResolver;
    L5:
        NameResolver r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r11 = r7.typeTable;
    L8:
        TypeTable r4 = r11;
        if ((r14 & 16) == 0) goto L11;
        r12 = r7.versionRequirementTable;
    L11:
        VersionRequirementTable r5 = r12;
        if ((r14 & 32) == 0) goto L15;
        r13 = r7.metadataVersion;
    L15:
        return r7.childContext(r8, r9, r3, r4, r5, r13);
    }

    public final DeserializationContext childContext(DeclarationDescriptor r13, List<ProtoBuf.TypeParameter> r14, NameResolver r15, TypeTable r16, VersionRequirementTable r17, BinaryVersion r18) {
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r14, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r15, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "typeTable");
        VersionRequirementTable r2 = r17;
        Intrinsics.checkNotNullParameter(r2, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        DeserializationComponents r3 = this.components;
        if (VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(r18) == true) goto L7;
        r2 = this.versionRequirementTable;
    L7:
        return new DeserializationContext(r3, r15, r13, r16, r2, r18, this.containerSource, this.typeDeserializer, r14);
    }
}
