package com.stepos.aicgroup;

import com.stepos.aicgroup.internal.ailimit.SystemStateStrategy;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.aicgroup.AiDispatchersManager$signalChanged$1", f = "AiDispatchersManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AiDispatchersManager$signalChanged$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SystemStateStrategy f5633a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiDispatchersManager$signalChanged$1(SystemStateStrategy systemStateStrategy, qb.b<? super AiDispatchersManager$signalChanged$1> bVar) {
        super(2, bVar);
        this.f5633a = systemStateStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new AiDispatchersManager$signalChanged$1(this.f5633a, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        AiDispatchersManager.access$reconcile(AiDispatchersManager.INSTANCE, this.f5633a.getName() + "恶化");
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((AiDispatchersManager$signalChanged$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
