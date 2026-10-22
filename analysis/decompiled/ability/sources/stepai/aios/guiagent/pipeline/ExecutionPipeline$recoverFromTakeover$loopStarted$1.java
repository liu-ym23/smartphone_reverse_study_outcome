package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$recoverFromTakeover$loopStarted$1", f = "ExecutionPipeline.kt", l = {1690}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$recoverFromTakeover$loopStarted$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6083a;
    public final /* synthetic */ C1724q b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$recoverFromTakeover$loopStarted$1(C1724q c1724q, H7.c cVar) {
        super(2, cVar);
        this.b = c1724q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$recoverFromTakeover$loopStarted$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$recoverFromTakeover$loopStarted$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6083a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        this.f6083a = 1;
        Object objZ = this.b.z(this);
        return objZ == coroutineSingletons ? coroutineSingletons : objZ;
    }
}
