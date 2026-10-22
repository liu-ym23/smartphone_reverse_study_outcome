package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    /* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[AnnotatedCallableKind.values().length];
            r0[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadAnnotationDefaultValue, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadAnnotationDefaultValue2(ProtoContainer r1, ProtoBuf.Property r2, KotlinType r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "expectedType");
        return null;
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor r2, NotFoundClasses r3, SerializerExtensionProtocol r4) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r4, "protocol");
        this.protocol = r4;
        this.deserializer = new AnnotationDeserializer(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadAnnotationDefaultValue(ProtoContainer r1, ProtoBuf.Property r2, KotlinType r3) {
        return loadAnnotationDefaultValue2(r1, r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadPropertyConstant(ProtoContainer r1, ProtoBuf.Property r2, KotlinType r3) {
        return loadPropertyConstant2(r1, r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class r6) {
        Intrinsics.checkNotNullParameter(r6, "container");
        List r0 = (List) r6.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        ProtoBuf.Annotation r4 = (ProtoBuf.Annotation) r3.next();
        r2.add(this.deserializer.deserializeAnnotation(r4, r6.getNameResolver()));
        goto L7
    L10:
        return r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer r4, MessageLite r5, AnnotatedCallableKind r6) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r6, "kind");
        if ((r5 instanceof ProtoBuf.Constructor) == false) goto L6;
        List r7 = (List) ((ProtoBuf.Constructor) r5).getExtension(this.protocol.getConstructorAnnotation());
    L21:
        if (r7 != null) goto L23;
        r7 = CollectionsKt.emptyList();
    L23:
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L25:
        if (r10.hasNext() == false) goto L28;
        r9.add(this.deserializer.deserializeAnnotation((ProtoBuf.Annotation) r10.next(), r4.getNameResolver()));
        goto L25
    L28:
        return r9;
    L6:
        if ((r5 instanceof ProtoBuf.Function) == false) goto L9;
        r7 = (List) ((ProtoBuf.Function) r5).getExtension(this.protocol.getFunctionAnnotation());
        goto L21
    L9:
        if ((r5 instanceof ProtoBuf.Property) == false) goto L30;
        int r11 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r11 != 1) goto L13;
        r7 = (List) ((ProtoBuf.Property) r5).getExtension(this.protocol.getPropertyAnnotation());
        goto L21
    L13:
        if (r11 != 2) goto L15;
        r7 = (List) ((ProtoBuf.Property) r5).getExtension(this.protocol.getPropertyGetterAnnotation());
        goto L21
    L15:
        if (r11 != 3) goto L18;
        r7 = (List) ((ProtoBuf.Property) r5).getExtension(this.protocol.getPropertySetterAnnotation());
        goto L21
    L18:
        throw new IllegalStateException("Unsupported callable kind with property proto".toString());
    L30:
        throw new IllegalStateException(("Unknown message: " + r5).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer r1, ProtoBuf.Property r2) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "proto");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer r1, ProtoBuf.Property r2) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "proto");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer r5, ProtoBuf.EnumEntry r6) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r6, "proto");
        List r7 = (List) r6.getExtension(this.protocol.getEnumEntryAnnotation());
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        List r8 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L10;
        ProtoBuf.Annotation r1 = (ProtoBuf.Annotation) r9.next();
        r0.add(this.deserializer.deserializeAnnotation(r1, r5.getNameResolver()));
        goto L7
    L10:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer r2, MessageLite r3, AnnotatedCallableKind r4, int r5, ProtoBuf.ValueParameter r6) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "callableProto");
        Intrinsics.checkNotNullParameter(r4, "kind");
        Intrinsics.checkNotNullParameter(r6, "proto");
        List r7 = (List) r6.getExtension(this.protocol.getParameterAnnotation());
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L10;
        ProtoBuf.Annotation r11 = (ProtoBuf.Annotation) r10.next();
        r9.add(this.deserializer.deserializeAnnotation(r11, r2.getNameResolver()));
        goto L7
    L10:
        return r9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer r1, MessageLite r2, AnnotatedCallableKind r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "kind");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type r4, NameResolver r5) {
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        List r6 = (List) r4.getExtension(this.protocol.getTypeAnnotation());
        if (r6 != null) goto L5;
        r6 = CollectionsKt.emptyList();
    L5:
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L10;
        ProtoBuf.Annotation r1 = (ProtoBuf.Annotation) r8.next();
        r0.add(this.deserializer.deserializeAnnotation(r1, r5));
        goto L7
    L10:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r4, NameResolver r5) {
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        List r6 = (List) r4.getExtension(this.protocol.getTypeParameterAnnotation());
        if (r6 != null) goto L5;
        r6 = CollectionsKt.emptyList();
    L5:
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L10;
        ProtoBuf.Annotation r1 = (ProtoBuf.Annotation) r8.next();
        r0.add(this.deserializer.deserializeAnnotation(r1, r5));
        goto L7
    L10:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadPropertyConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadPropertyConstant2(ProtoContainer r2, ProtoBuf.Property r3, KotlinType r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "expectedType");
        ProtoBuf.Annotation.Argument.Value r5 = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(r3, this.protocol.getCompileTimeValue());
        if (r5 != null) goto L7;
        return null;
    L7:
        return this.deserializer.resolveValue(r4, r5, r2.getNameResolver());
    }
}
