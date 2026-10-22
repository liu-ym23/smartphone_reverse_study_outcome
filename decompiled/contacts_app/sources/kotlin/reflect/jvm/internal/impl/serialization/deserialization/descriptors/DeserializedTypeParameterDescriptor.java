package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final DeserializedAnnotations annotations;
    private final DeserializationContext c;
    private final ProtoBuf.TypeParameter proto;

    public static final /* synthetic */ DeserializationContext access$getC$p(DeserializedTypeParameterDescriptor r0) {
        return r0.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public /* bridge */ /* synthetic */ Annotations getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo2086reportSupertypeLoopError(KotlinType r1) {
        reportSupertypeLoopError(r1);
    }

    public final ProtoBuf.TypeParameter getProto() {
        return this.proto;
    }

    public DeserializedTypeParameterDescriptor(DeserializationContext r12, ProtoBuf.TypeParameter r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "proto");
        StorageManager r2 = r12.getStorageManager();
        DeclarationDescriptor r3 = r12.getContainingDeclaration();
        Annotations r4 = Annotations.Companion.getEMPTY();
        Name r5 = NameResolverUtilKt.getName(r12.getNameResolver(), r13.getName());
        ProtoEnumFlags r0 = ProtoEnumFlags.INSTANCE;
        ProtoBuf.TypeParameter.Variance r1 = r13.getVariance();
        Intrinsics.checkNotNullExpressionValue(r1, "proto.variance");
        super(r2, r3, r4, r5, r0.variance(r1), r13.getReified(), r14, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        this.c = r12;
        this.proto = r13;
        this.annotations = new DeserializedAnnotations(r12.getStorageManager(), new DeserializedTypeParameterDescriptor$annotations$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        List<ProtoBuf.Type> r0 = ProtoTypeTableUtilKt.upperBounds(this.proto, this.c.getTypeTable());
        if (r0.isEmpty() == true) goto L5;
        List<ProtoBuf.Type> r1 = r0;
        TypeDeserializer r3 = this.c.getTypeDeserializer();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        r2.add(r3.type((ProtoBuf.Type) r4.next()));
        goto L8
    L11:
        return r2;
    L5:
        return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
    }

    protected Void reportSupertypeLoopError(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
