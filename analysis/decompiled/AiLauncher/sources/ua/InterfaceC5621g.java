package ua;

import ea.InterfaceC4020d;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import ua.AbstractC5604N;

/* renamed from: ua.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5621g<A> {
    List<A> a(AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind);

    List<A> b(AbstractC5604N abstractC5604N, ProtoBuf$Property protoBuf$Property);

    List<A> c(ProtoBuf$TypeParameter protoBuf$TypeParameter, InterfaceC4020d interfaceC4020d);

    List<A> d(AbstractC5604N abstractC5604N, ProtoBuf$Property protoBuf$Property);

    List<A> e(AbstractC5604N.a aVar);

    A f(ProtoBuf$Annotation protoBuf$Annotation, InterfaceC4020d interfaceC4020d);

    List<A> h(ProtoBuf$Type protoBuf$Type, InterfaceC4020d interfaceC4020d);

    List<A> j(AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter);

    List<A> k(AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter);

    List<A> l(AbstractC5604N abstractC5604N, ProtoBuf$EnumEntry protoBuf$EnumEntry);

    List<A> m(AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind);
}
