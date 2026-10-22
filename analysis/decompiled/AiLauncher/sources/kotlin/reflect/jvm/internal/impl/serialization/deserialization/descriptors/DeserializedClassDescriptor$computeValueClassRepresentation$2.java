package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import ga.e;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final /* synthetic */ class DeserializedClassDescriptor$computeValueClassRepresentation$2 extends FunctionReferenceImpl implements InterfaceC5074l<e, AbstractC5990d0> {
    public DeserializedClassDescriptor$computeValueClassRepresentation$2(Object obj) {
        super(1, obj, DeserializedClassDescriptor.class, "getValueClassPropertyType", "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final AbstractC5990d0 invoke(e p02) {
        p.i(p02, "p0");
        return ((DeserializedClassDescriptor) this.receiver).d1(p02);
    }
}
