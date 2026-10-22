package com.stepos.backend.qnn;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.backend.qnn.QnnNative$acquireInferPermitWithTimeout$2$gotLock$1", f = "QnnNative.kt", l = {450}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class QnnNative$acquireInferPermitWithTimeout$2$gotLock$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Boolean>, Object> {
    final /* synthetic */ String $modelId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnNative$acquireInferPermitWithTimeout$2$gotLock$1(String str, qb.b<? super QnnNative$acquireInferPermitWithTimeout$2$gotLock$1> bVar) {
        super(2, bVar);
        this.$modelId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new QnnNative$acquireInferPermitWithTimeout$2$gotLock$1(this.$modelId, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objPutIfAbsent;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            ConcurrentHashMap concurrentHashMap = QnnNative.modelLocks;
            String str = this.$modelId;
            Object objMutex$default = concurrentHashMap.get(str);
            if (objMutex$default == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str, (objMutex$default = MutexKt.Mutex$default(false, 1, null)))) != null) {
                objMutex$default = objPutIfAbsent;
            }
            this.label = 1;
            if (Mutex.DefaultImpls.lock$default((Mutex) objMutex$default, null, this, 1, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return Boolean.TRUE;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
        return ((QnnNative$acquireInferPermitWithTimeout$2$gotLock$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
