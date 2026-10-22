package com.stepos.backend.llama;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.backend.llama.ScpRiskModel$doClose$2$1", f = "ScpRiskModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScpRiskModel$doClose$2$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ long $handle;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScpRiskModel$doClose$2$1(long j10, qb.b<? super ScpRiskModel$doClose$2$1> bVar) {
        super(2, bVar);
        this.$handle = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new ScpRiskModel$doClose$2$1(this.$handle, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        ScpRiskJni.nativeRelease(this.$handle);
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((ScpRiskModel$doClose$2$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
