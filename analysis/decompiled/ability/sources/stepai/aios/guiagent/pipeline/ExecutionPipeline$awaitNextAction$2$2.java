package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1687E;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitNextAction$2$2", f = "ExecutionPipeline.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lstepai/aios/guiagent/pipeline/ExecutionPipeline$ControlEvent;", NotificationCompat.CATEGORY_EVENT, "LAa/a;", "<anonymous>", "(Lstepai/aios/guiagent/pipeline/ExecutionPipeline$ControlEvent;)LAa/a;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitNextAction$2$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6041a;
    public final /* synthetic */ C1687E b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitNextAction$2$2(C1687E c1687e, H7.c cVar) {
        super(2, cVar);
        this.b = c1687e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        ExecutionPipeline$awaitNextAction$2$2 executionPipeline$awaitNextAction$2$2 = new ExecutionPipeline$awaitNextAction$2$2(this.b, cVar);
        executionPipeline$awaitNextAction$2$2.f6041a = obj;
        return executionPipeline$awaitNextAction$2$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitNextAction$2$2) create((ExecutionPipeline$ControlEvent) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ExecutionPipeline$ControlEvent executionPipeline$ControlEvent = (ExecutionPipeline$ControlEvent) this.f6041a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        this.b.cancel(null);
        return new Aa.a(null, null, "LLM wait interrupted by control event: " + executionPipeline$ControlEvent, 27);
    }
}
