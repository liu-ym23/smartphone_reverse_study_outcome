package stepai.aios.guiagent.pipeline;

import Aa.d;
import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import za.e;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$recoverTaskLoop$3", f = "ExecutionPipeline.kt", l = {1504}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lza/d;", "<anonymous>", "(Lm9/z;)Lza/d;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$recoverTaskLoop$3 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6086a;
    public final /* synthetic */ b b;
    public final /* synthetic */ e c;
    public final /* synthetic */ Aa.e d;
    public final /* synthetic */ d e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$recoverTaskLoop$3(b bVar, e eVar, Aa.e eVar2, d dVar, int i, H7.c cVar) {
        super(2, cVar);
        this.b = bVar;
        this.c = eVar;
        this.d = eVar2;
        this.e = dVar;
        this.f = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$recoverTaskLoop$3(this.b, this.c, this.d, this.e, this.f, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$recoverTaskLoop$3) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6086a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        ExecutionPipeline$LoopContext executionPipeline$LoopContext = ExecutionPipeline$LoopContext.f6036j;
        this.f6086a = 1;
        Object objH = this.b.H(this.c, this.d, this.e, this.f, executionPipeline$LoopContext, this);
        return objH == coroutineSingletons ? coroutineSingletons : objH;
    }
}
