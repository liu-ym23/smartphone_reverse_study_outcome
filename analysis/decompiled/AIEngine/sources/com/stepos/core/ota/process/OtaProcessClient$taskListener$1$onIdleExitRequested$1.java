package com.stepos.core.ota.process;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ota.process.OtaProcessClient$taskListener$1$onIdleExitRequested$1", f = "OtaProcessClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OtaProcessClient$taskListener$1$onIdleExitRequested$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ Context $ctx;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtaProcessClient$taskListener$1$onIdleExitRequested$1(Context context, qb.b<? super OtaProcessClient$taskListener$1$onIdleExitRequested$1> bVar) {
        super(2, bVar);
        this.$ctx = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        OtaProcessClient$taskListener$1$onIdleExitRequested$1 otaProcessClient$taskListener$1$onIdleExitRequested$1 = new OtaProcessClient$taskListener$1$onIdleExitRequested$1(this.$ctx, bVar);
        otaProcessClient$taskListener$1$onIdleExitRequested$1.L$0 = obj;
        return otaProcessClient$taskListener$1$onIdleExitRequested$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        try {
            this.$ctx.unbindService(OtaProcessClient.connection);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        OtaProcessClient.bindState.invalidate();
        OtaProcessClient.controlRef.set(null);
        synchronized (OtaProcessClient.INSTANCE) {
            try {
                CompletableDeferred completableDeferred = OtaProcessClient.pendingConnect;
                if (completableDeferred != null) {
                    Job.DefaultImpls.cancel$default(completableDeferred, null, 1, null);
                }
                OtaProcessClient.pendingConnect = null;
                n nVar2 = n.f10413a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        AIEngineLogger.i(LogModule.OTA, "OtaProcessClient", "idle exit: unbound from OtaProcessService");
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((OtaProcessClient$taskListener$1$onIdleExitRequested$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
