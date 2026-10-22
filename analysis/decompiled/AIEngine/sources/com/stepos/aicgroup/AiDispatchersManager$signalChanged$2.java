package com.stepos.aicgroup;

import com.stepos.aicgroup.internal.ailimit.SystemStateStrategy;
import com.stepos.core.common.cloud.FileStorageUploader;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.aicgroup.AiDispatchersManager$signalChanged$2", f = "AiDispatchersManager.kt", l = {189}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AiDispatchersManager$signalChanged$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f5634a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SystemStateStrategy f5635b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiDispatchersManager$signalChanged$2(SystemStateStrategy systemStateStrategy, qb.b<? super AiDispatchersManager$signalChanged$2> bVar) {
        super(2, bVar);
        this.f5635b = systemStateStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new AiDispatchersManager$signalChanged$2(this.f5635b, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f5634a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            this.f5634a = 1;
            if (DelayKt.delay(FileStorageUploader.LOG_HEARTBEAT_MS, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        AiDispatchersManager.access$reconcile(AiDispatchersManager.INSTANCE, this.f5635b.getName() + "好转");
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((AiDispatchersManager$signalChanged$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
