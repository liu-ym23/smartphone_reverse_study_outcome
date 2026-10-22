package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final /* synthetic */ class DeserializedClassDescriptor$computeValueClassRepresentation$1 extends AdaptedFunctionReference implements InterfaceC5074l<ProtoBuf$Type, AbstractC5990d0> {
    public DeserializedClassDescriptor$computeValueClassRepresentation$1(Object obj) {
        super(1, obj, TypeDeserializer.class, "simpleType", "simpleType(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;Z)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AbstractC5990d0 invoke(ProtoBuf$Type p02) {
        p.i(p02, "p0");
        return TypeDeserializer.q((TypeDeserializer) this.receiver, p02, false, 2, null);
    }
}
