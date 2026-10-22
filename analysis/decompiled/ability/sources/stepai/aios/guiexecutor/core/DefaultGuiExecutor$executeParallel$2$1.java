package stepai.aios.guiexecutor.core;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiResult;

@c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeParallel$2$1", f = "DefaultGuiExecutor.kt", l = {161}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiexecutor/api/GuiResult;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiexecutor/api/GuiResult;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
public final class DefaultGuiExecutor$executeParallel$2$1 extends SuspendLambda implements n {
    final /* synthetic */ GuiCommand $command;
    int label;
    final /* synthetic */ DefaultGuiExecutor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGuiExecutor$executeParallel$2$1(DefaultGuiExecutor defaultGuiExecutor, GuiCommand guiCommand, H7.c<? super DefaultGuiExecutor$executeParallel$2$1> cVar) {
        super(2, cVar);
        this.this$0 = defaultGuiExecutor;
        this.$command = guiCommand;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new DefaultGuiExecutor$executeParallel$2$1(this.this$0, this.$command, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
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
        Object objExecute = defaultGuiExecutor.execute(guiCommand, this);
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super GuiResult> cVar) {
        return ((DefaultGuiExecutor$executeParallel$2$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
