package stepai.aios.guiexecutor.core;

import C7.r;
import J7.c;
import S7.n;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiResource;
import stepai.aios.guiexecutor.api.GuiResult;
import w9.e;

@c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor$execute$executionJob$1", f = "DefaultGuiExecutor.kt", l = {301, 70}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiexecutor/api/GuiResult;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiexecutor/api/GuiResult;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
public final class DefaultGuiExecutor$execute$executionJob$1 extends SuspendLambda implements n {
    final /* synthetic */ GuiCommand $command;
    final /* synthetic */ int $displayId;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DefaultGuiExecutor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGuiExecutor$execute$executionJob$1(DefaultGuiExecutor defaultGuiExecutor, int i, GuiCommand guiCommand, H7.c<? super DefaultGuiExecutor$execute$executionJob$1> cVar) {
        super(2, cVar);
        this.this$0 = defaultGuiExecutor;
        this.$displayId = i;
        this.$command = guiCommand;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new DefaultGuiExecutor$execute$executionJob$1(this.this$0, this.$displayId, this.$command, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        DefaultGuiExecutor defaultGuiExecutor;
        GuiCommand guiCommand;
        int i;
        int i6;
        Throwable th;
        Object obj3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i10 = this.label;
        try {
            if (i10 == 0) {
                b.b(obj);
                obj2 = this.this$0.concurrencySemaphore;
                defaultGuiExecutor = this.this$0;
                int i11 = this.$displayId;
                guiCommand = this.$command;
                this.L$0 = obj2;
                this.L$1 = defaultGuiExecutor;
                this.L$2 = guiCommand;
                this.I$0 = i11;
                this.I$1 = 0;
                this.label = 1;
                if (((kotlinx.coroutines.sync.b) obj2).a(this) != coroutineSingletons) {
                    i = i11;
                    i6 = 0;
                }
                return coroutineSingletons;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj3 = (e) this.L$0;
                try {
                    b.b(obj);
                    GuiResult guiResult = (GuiResult) obj;
                    ((kotlinx.coroutines.sync.b) obj3).c();
                    return guiResult;
                } catch (Throwable th2) {
                    th = th2;
                    ((kotlinx.coroutines.sync.b) obj3).c();
                    throw th;
                }
            }
            i6 = this.I$1;
            i = this.I$0;
            guiCommand = (GuiCommand) this.L$2;
            defaultGuiExecutor = (DefaultGuiExecutor) this.L$1;
            e eVar = (e) this.L$0;
            b.b(obj);
            obj2 = eVar;
            GuiResourceScheduler guiResourceScheduler = defaultGuiExecutor.resourceScheduler;
            Set<GuiResource> resources = guiCommand.getOptions().getResources();
            DefaultGuiExecutor$execute$executionJob$1$1$1 defaultGuiExecutor$execute$executionJob$1$1$1 = new DefaultGuiExecutor$execute$executionJob$1$1$1(defaultGuiExecutor, guiCommand, null);
            this.L$0 = obj2;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = i6;
            this.I$1 = 0;
            this.label = 2;
            Object objWithResources = guiResourceScheduler.withResources(i, resources, defaultGuiExecutor$execute$executionJob$1$1$1, this);
            if (objWithResources != coroutineSingletons) {
                Object obj4 = obj2;
                obj = objWithResources;
                obj3 = obj4;
                GuiResult guiResult2 = (GuiResult) obj;
                ((kotlinx.coroutines.sync.b) obj3).c();
                return guiResult2;
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            Object obj5 = obj2;
            th = th3;
            obj3 = obj5;
            ((kotlinx.coroutines.sync.b) obj3).c();
            throw th;
        }
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super GuiResult> cVar) {
        return ((DefaultGuiExecutor$execute$executionJob$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
