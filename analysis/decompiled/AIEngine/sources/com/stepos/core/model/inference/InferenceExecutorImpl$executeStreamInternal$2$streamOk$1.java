package com.stepos.core.model.inference;

import b7.k;
import b7.n;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.model.inference.InferenceExecutorImpl;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import x6.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl$executeStreamInternal$2$streamOk$1", f = "InferenceExecutorImpl.kt", l = {613}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class InferenceExecutorImpl$executeStreamInternal$2$streamOk$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Boolean>, Object> {
    final /* synthetic */ b.c $callback;
    final /* synthetic */ k $config;
    final /* synthetic */ InferenceExecutorImpl.StreamContext $context;
    final /* synthetic */ n $handle;
    final /* synthetic */ Object $processedInput;
    final /* synthetic */ String $taskId;
    final /* synthetic */ PowerPerfTracker $tracker;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InferenceExecutorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InferenceExecutorImpl$executeStreamInternal$2$streamOk$1(PowerPerfTracker powerPerfTracker, InferenceExecutorImpl inferenceExecutorImpl, String str, n nVar, Object obj, k kVar, InferenceExecutorImpl.StreamContext streamContext, b.c cVar, qb.b<? super InferenceExecutorImpl$executeStreamInternal$2$streamOk$1> bVar) {
        super(2, bVar);
        this.$tracker = powerPerfTracker;
        this.this$0 = inferenceExecutorImpl;
        this.$taskId = str;
        this.$handle = nVar;
        this.$processedInput = obj;
        this.$config = kVar;
        this.$context = streamContext;
        this.$callback = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n invokeSuspend$lambda$1(CoroutineScope coroutineScope, PowerPerfTracker powerPerfTracker) {
        if (powerPerfTracker != null) {
            try {
                powerPerfTracker.recordFirstToken();
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
        return lb.n.f10413a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        InferenceExecutorImpl$executeStreamInternal$2$streamOk$1 inferenceExecutorImpl$executeStreamInternal$2$streamOk$1 = new InferenceExecutorImpl$executeStreamInternal$2$streamOk$1(this.$tracker, this.this$0, this.$taskId, this.$handle, this.$processedInput, this.$config, this.$context, this.$callback, bVar);
        inferenceExecutorImpl$executeStreamInternal$2$streamOk$1.L$0 = obj;
        return inferenceExecutorImpl$executeStreamInternal$2$streamOk$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        PowerPerfTracker powerPerfTracker = this.$tracker;
        if (powerPerfTracker != null) {
            powerPerfTracker.markStage(FailStage.INFERENCE);
        }
        InferenceExecutorImpl inferenceExecutorImpl = this.this$0;
        String str = this.$taskId;
        n nVar = this.$handle;
        Object obj2 = this.$processedInput;
        k kVar = this.$config;
        InferenceExecutorImpl.StreamContext streamContext = this.$context;
        b.c cVar = this.$callback;
        final PowerPerfTracker powerPerfTracker2 = this.$tracker;
        zb.a aVar = new zb.a() { // from class: com.stepos.core.model.inference.f
            @Override // zb.a
            public final Object invoke() {
                return InferenceExecutorImpl$executeStreamInternal$2$streamOk$1.invokeSuspend$lambda$1(coroutineScope, powerPerfTracker2);
            }
        };
        this.label = 1;
        Object objPerformStreaming = inferenceExecutorImpl.performStreaming(str, nVar, obj2, kVar, streamContext, cVar, powerPerfTracker2, aVar, this);
        return objPerformStreaming == coroutineSingletons ? coroutineSingletons : objPerformStreaming;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
        return ((InferenceExecutorImpl$executeStreamInternal$2$streamOk$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
