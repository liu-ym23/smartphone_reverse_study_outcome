package com.stepos.aiengine;

import android.util.Log;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import java.util.Set;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import mb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.aiengine.AIEngineApplication$registerAicMemoryCallback$1$handler$11", f = "AIEngineApplication.kt", l = {678}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class AIEngineApplication$registerAicMemoryCallback$1$handler$11 extends SuspendLambda implements p<Long, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f5756a;

    /* renamed from: b, reason: collision with root package name */
    public int f5757b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ long f5758c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        AIEngineApplication$registerAicMemoryCallback$1$handler$11 aIEngineApplication$registerAicMemoryCallback$1$handler$11 = new AIEngineApplication$registerAicMemoryCallback$1$handler$11(2, bVar);
        aIEngineApplication$registerAicMemoryCallback$1$handler$11.f5758c = ((Number) obj).longValue();
        return aIEngineApplication$registerAicMemoryCallback$1$handler$11;
    }

    @Override // zb.p
    public final Object invoke(Long l10, qb.b<? super n> bVar) {
        return ((AIEngineApplication$registerAicMemoryCallback$1$handler$11) create(Long.valueOf(l10.longValue()), bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Set<? extends PoolType> setS0;
        int iCancelPools;
        long j10;
        int i10;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i11 = this.f5757b;
        if (i11 == 0) {
            kotlin.c.b(obj);
            long j11 = this.f5758c;
            ThreadPoolManagerImpl threadPoolManagerImplLatestInstanceOrNull = ThreadPoolManagerImpl.Companion.latestInstanceOrNull();
            if (threadPoolManagerImplLatestInstanceOrNull != null && (iCancelPools = threadPoolManagerImplLatestInstanceOrNull.cancelPools((setS0 = l.s0(new PoolType[]{PoolType.f6217e, PoolType.h})), "pressure:ULTRA_LOW")) > 0) {
                this.f5758c = j11;
                this.f5756a = iCancelPools;
                this.f5757b = 1;
                obj = threadPoolManagerImplLatestInstanceOrNull.awaitPoolsIdle(setS0, j11, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                j10 = j11;
                i10 = iCancelPools;
            }
            return n.f10413a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i10 = this.f5756a;
        j10 = this.f5758c;
        kotlin.c.b(obj);
        if (!((Boolean) obj).booleanValue()) {
            StringBuilder sbR = ai.onnxruntime.a.r(j10, "bgCancelRunner: pools not idle after ", "ms (cancelled=", i10);
            sbR.append("), in-flight 模型本轮由 isInUse 护栏跳过");
            Log.w("AIEngineApplication", sbR.toString());
        }
        return n.f10413a;
    }
}
