package stepai.aios.guiexecutor.core;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiResult;

@c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor$execute$executionJob$1$1$1", f = "DefaultGuiExecutor.kt", l = {71}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lstepai/aios/guiexecutor/api/GuiResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultGuiExecutor$execute$executionJob$1$1$1 extends SuspendLambda implements k {
    final /* synthetic */ GuiCommand $command;
    int label;
    final /* synthetic */ DefaultGuiExecutor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGuiExecutor$execute$executionJob$1$1$1(DefaultGuiExecutor defaultGuiExecutor, GuiCommand guiCommand, H7.c<? super DefaultGuiExecutor$execute$executionJob$1$1$1> cVar) {
        super(1, cVar);
        this.this$0 = defaultGuiExecutor;
        this.$command = guiCommand;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(H7.c<?> cVar) {
        return new DefaultGuiExecutor$execute$executionJob$1$1$1(this.this$0, this.$command, cVar);
    }

    @Override // S7.k
    public final Object invoke(H7.c<? super GuiResult> cVar) {
        return ((DefaultGuiExecutor$execute$executionJob$1$1$1) create(cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        b.b(obj);
        DefaultGuiExecutor defaultGuiExecutor = this.this$0;
        GuiCommand guiCommand = this.$command;
        this.label = 1;
        Object objExecuteWithTimeout = defaultGuiExecutor.executeWithTimeout(guiCommand, this);
        return objExecuteWithTimeout == coroutineSingletons ? coroutineSingletons : objExecuteWithTimeout;
    }
}
