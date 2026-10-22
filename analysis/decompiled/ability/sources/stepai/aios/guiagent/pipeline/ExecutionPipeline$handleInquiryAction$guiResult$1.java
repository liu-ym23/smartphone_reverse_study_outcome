package stepai.aios.guiagent.pipeline;

import Aa.e;
import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.core.DefaultGuiExecutor;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$handleInquiryAction$guiResult$1", f = "ExecutionPipeline.kt", l = {664}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lstepai/aios/guiexecutor/api/GuiResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$handleInquiryAction$guiResult$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6066a;
    public final /* synthetic */ e b;
    public final /* synthetic */ GuiCommand c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$handleInquiryAction$guiResult$1(e eVar, GuiCommand guiCommand, H7.c cVar) {
        super(1, cVar);
        this.b = eVar;
        this.c = guiCommand;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new ExecutionPipeline$handleInquiryAction$guiResult$1(this.b, this.c, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((ExecutionPipeline$handleInquiryAction$guiResult$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6066a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        DefaultGuiExecutor defaultGuiExecutor = this.b.b;
        this.f6066a = 1;
        Object objExecute = defaultGuiExecutor.execute(this.c, this);
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
