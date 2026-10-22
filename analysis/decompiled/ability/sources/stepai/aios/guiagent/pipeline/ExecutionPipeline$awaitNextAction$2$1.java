package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitNextAction$2$1", f = "ExecutionPipeline.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LAa/a;", "it", "<anonymous>", "(LAa/a;)LAa/a;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitNextAction$2$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6040a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        ExecutionPipeline$awaitNextAction$2$1 executionPipeline$awaitNextAction$2$1 = new ExecutionPipeline$awaitNextAction$2$1(2, cVar);
        executionPipeline$awaitNextAction$2$1.f6040a = obj;
        return executionPipeline$awaitNextAction$2$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitNextAction$2$1) create((Aa.a) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Aa.a aVar = (Aa.a) this.f6040a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        return aVar;
    }
}
