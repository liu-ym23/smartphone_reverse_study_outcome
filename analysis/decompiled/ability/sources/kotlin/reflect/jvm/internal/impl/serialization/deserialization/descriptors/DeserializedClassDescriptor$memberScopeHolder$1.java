package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import S7.k;
import V8.h;
import Z7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class DeserializedClassDescriptor$memberScopeHolder$1 extends FunctionReference implements k {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return AppAgent.CONSTRUCT;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(h.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Y8.f p02 = (Y8.f) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return new h((b) this.receiver, p02);
    }
}
