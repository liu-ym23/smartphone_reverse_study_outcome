package com.stepos.core.model.manager;

import android.util.Log;
import com.stepos.core.model.manager.ModelCacheImpl;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$deactivate$1", f = "ModelCacheImpl.kt", l = {1916}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCacheImpl$VersionRouter$deactivate$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Integer>, Object> {
    final /* synthetic */ String $modelId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ModelCacheImpl.VersionRouter this$0;
    final /* synthetic */ ModelCacheImpl this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCacheImpl$VersionRouter$deactivate$1(ModelCacheImpl.VersionRouter versionRouter, String str, ModelCacheImpl modelCacheImpl, qb.b<? super ModelCacheImpl$VersionRouter$deactivate$1> bVar) {
        super(2, bVar);
        this.this$0 = versionRouter;
        this.$modelId = str;
        this.this$1 = modelCacheImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        ModelCacheImpl$VersionRouter$deactivate$1 modelCacheImpl$VersionRouter$deactivate$1 = new ModelCacheImpl$VersionRouter$deactivate$1(this.this$0, this.$modelId, this.this$1, bVar);
        modelCacheImpl$VersionRouter$deactivate$1.L$0 = obj;
        return modelCacheImpl$VersionRouter$deactivate$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        ModelCacheImpl.VersionRouter versionRouter;
        String str;
        ModelCacheImpl modelCacheImpl;
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            mutex = this.this$0.routerLock;
            versionRouter = this.this$0;
            str = this.$modelId;
            ModelCacheImpl modelCacheImpl2 = this.this$1;
            this.L$0 = coroutineScope;
            this.L$1 = mutex;
            this.L$2 = versionRouter;
            this.L$3 = str;
            this.L$4 = modelCacheImpl2;
            this.label = 1;
            if (mutex.lock(null, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            modelCacheImpl = modelCacheImpl2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            modelCacheImpl = (ModelCacheImpl) this.L$4;
            str = (String) this.L$3;
            versionRouter = (ModelCacheImpl.VersionRouter) this.L$2;
            mutex = (Mutex) this.L$1;
            kotlin.c.b(obj);
        }
        try {
            Integer num = (Integer) versionRouter.currentVersion.remove(str);
            if (num == null || num.intValue() <= 0) {
                Integer num2 = new Integer(g7.a.b(str));
                num = num2.intValue() > 0 ? num2 : null;
            }
            int iIntValue = num != null ? num.intValue() : 0;
            if (modelCacheImpl.modelCache.containsKey(str)) {
                if (iIntValue <= 0 || modelCacheImpl.refManager.count(str) <= 0) {
                    modelCacheImpl.remove(str);
                } else {
                    versionRouter.detachToDraining(str, iIntValue);
                }
            }
            Set setKeySet = versionRouter.drainingInstances.keySet();
            kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : setKeySet) {
                if (kotlin.jvm.internal.g.b(((Pair) obj2).f9985a, str)) {
                    arrayList.add(obj2);
                }
            }
            for (Pair pair : kotlin.collections.a.O0(arrayList)) {
                ModelCacheImpl.VersionRouter.DrainEntry drainEntry = (ModelCacheImpl.VersionRouter.DrainEntry) versionRouter.drainingInstances.remove(pair);
                if (drainEntry != null) {
                    try {
                        objA = new Result(((Result) BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1(drainEntry, null), 1, null)).f9987a);
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        Log.w("ModelCache", "deactivate: close draining " + pair.f9985a + " v" + pair.f9986b + ": " + thB.getMessage(), thB);
                    }
                }
            }
            Integer num3 = new Integer(Log.i("ModelCache", "deactivate: " + str + " (lastVer=" + iIntValue + ")"));
            mutex.unlock(null);
            return num3;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Integer> bVar) {
        return ((ModelCacheImpl$VersionRouter$deactivate$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
