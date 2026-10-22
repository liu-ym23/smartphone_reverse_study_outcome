package stepai.aios.guiagent.tracer.remote;

import J7.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager", f = "GuiAgentTraceManager.kt", l = {58}, m = "postExecution-yxL6bBk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiAgentTraceManager$postExecution$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuiAgentTraceManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiAgentTraceManager$postExecution$1(GuiAgentTraceManager guiAgentTraceManager, H7.c<? super GuiAgentTraceManager$postExecution$1> cVar) {
        super(cVar);
        this.this$0 = guiAgentTraceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7366postExecutionyxL6bBk = this.this$0.m7366postExecutionyxL6bBk(null, null, null, null, this);
        return objM7366postExecutionyxL6bBk == CoroutineSingletons.f4909a ? objM7366postExecutionyxL6bBk : new Result(objM7366postExecutionyxL6bBk);
    }
}
