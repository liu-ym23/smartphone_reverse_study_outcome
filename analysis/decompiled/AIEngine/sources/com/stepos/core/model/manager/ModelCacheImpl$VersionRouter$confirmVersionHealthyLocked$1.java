package com.stepos.core.model.manager;

import android.util.Log;
import com.stepos.core.model.manager.ModelCacheImpl;
import java.io.File;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1", f = "ModelCacheImpl.kt", l = {1916}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ int $expectVer;
    final /* synthetic */ String $modelId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ModelCacheImpl.VersionRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1(ModelCacheImpl.VersionRouter versionRouter, String str, int i10, qb.b<? super ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1> bVar) {
        super(2, bVar);
        this.this$0 = versionRouter;
        this.$modelId = str;
        this.$expectVer = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1(this.this$0, this.$modelId, this.$expectVer, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        ModelCacheImpl.VersionRouter versionRouter;
        String modelId;
        int i10;
        int iIntValue;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.c.b(obj);
            Mutex mutex2 = this.this$0.routerLock;
            ModelCacheImpl.VersionRouter versionRouter2 = this.this$0;
            String str = this.$modelId;
            int i12 = this.$expectVer;
            this.L$0 = mutex2;
            this.L$1 = versionRouter2;
            this.L$2 = str;
            this.I$0 = i12;
            this.label = 1;
            if (mutex2.lock(null, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            mutex = mutex2;
            versionRouter = versionRouter2;
            modelId = str;
            i10 = i12;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = this.I$0;
            modelId = (String) this.L$2;
            versionRouter = (ModelCacheImpl.VersionRouter) this.L$1;
            mutex = (Mutex) this.L$0;
            kotlin.c.b(obj);
        }
        try {
            Integer num = (Integer) versionRouter.currentVersion.get(modelId);
            if (num != null && (iIntValue = num.intValue()) == i10) {
                lb.d dVar = g7.a.f9073a;
                kotlin.jvm.internal.g.f(modelId, "modelId");
                String str2 = "";
                String strH = g7.a.a().h("prev_path_".concat(modelId), "");
                if (strH != null) {
                    str2 = strH;
                }
                if (!gc.q.t0(str2)) {
                    File file = new File(str2);
                    File parentFile = file.getParentFile();
                    if (kotlin.jvm.internal.g.b(parentFile != null ? parentFile.getName() : null, ".backup") && file.isDirectory()) {
                        boolean zT = wb.d.T(file);
                        Log.i("ModelCache", "confirmHealthy: " + modelId + " v" + iIntValue + " ran OK, drop backup " + file.getName() + ", deleted=" + zT);
                    } else {
                        Log.w("ModelCache", "confirmHealthy: backup path not under .backup, skip delete: ".concat(str2));
                    }
                    g7.a.a().p("prev_".concat(modelId));
                    g7.a.a().p("prev_path_".concat(modelId));
                }
            }
            lb.n nVar = lb.n.f10413a;
            mutex.unlock(null);
            return lb.n.f10413a;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
