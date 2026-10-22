package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import S7.k;
import Z7.f;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class DeserializedClassDescriptor$computeValueClassRepresentation$2 extends FunctionReference implements k {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "getValueClassPropertyType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        G8.f p02 = (G8.f) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return ((b) this.receiver).M(p02);
    }
}
