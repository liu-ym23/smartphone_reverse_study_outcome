package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class DeserializedClassDescriptor$memberScopeHolder$1 extends FunctionReferenceImpl implements InterfaceC5074l<c, DeserializedClassDescriptor.a> {
    public DeserializedClassDescriptor$memberScopeHolder$1(Object obj) {
        super(1, obj, DeserializedClassDescriptor.a.class, "<init>", "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final DeserializedClassDescriptor.a invoke(c p02) {
        p.i(p02, "p0");
        return new DeserializedClassDescriptor.a((DeserializedClassDescriptor) this.receiver, p02);
    }
}
