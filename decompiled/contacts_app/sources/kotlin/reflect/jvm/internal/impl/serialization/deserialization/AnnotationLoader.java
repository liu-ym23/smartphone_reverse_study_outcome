package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: compiled from: AnnotationLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface AnnotationLoader<A> {
    List<A> loadCallableAnnotations(ProtoContainer r1, MessageLite r2, AnnotatedCallableKind r3);

    List<A> loadClassAnnotations(ProtoContainer.Class r1);

    List<A> loadEnumEntryAnnotations(ProtoContainer r1, ProtoBuf.EnumEntry r2);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r1, MessageLite r2, AnnotatedCallableKind r3);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r1, ProtoBuf.Property r2);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r1, ProtoBuf.Property r2);

    List<A> loadTypeAnnotations(ProtoBuf.Type r1, NameResolver r2);

    List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r1, NameResolver r2);

    List<A> loadValueParameterAnnotations(ProtoContainer r1, MessageLite r2, AnnotatedCallableKind r3, int r4, ProtoBuf.ValueParameter r5);
}
