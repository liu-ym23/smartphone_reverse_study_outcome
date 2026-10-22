package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import S7.k;
import Z7.f;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* loaded from: classes4.dex */
final /* synthetic */ class DeserializedClassDescriptor$computeValueClassRepresentation$1 extends FunctionReference implements k {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "simpleType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(j.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "computeValueClassRepresentation$simpleType(Lorg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)Lorg/jetbrains/kotlin/types/SimpleType;";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        ProtoBuf$Type p02 = (ProtoBuf$Type) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a) this.receiver).d(p02, true);
    }
}
