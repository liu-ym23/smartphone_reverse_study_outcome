package stepai.aios.guiexecutor.input;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.a;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2$1$timeoutJob$1", f = "UserInputManager.kt", l = {160}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
public final class UserInputManager$requestUserInput$2$1$timeoutJob$1 extends SuspendLambda implements n {
    final /* synthetic */ UserInputRequest $request;
    final /* synthetic */ long $timeout;
    int label;
    final /* synthetic */ UserInputManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInputManager$requestUserInput$2$1$timeoutJob$1(long j5, UserInputManager userInputManager, UserInputRequest userInputRequest, H7.c<? super UserInputManager$requestUserInput$2$1$timeoutJob$1> cVar) {
        super(2, cVar);
        this.$timeout = j5;
        this.this$0 = userInputManager;
        this.$request = userInputRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new UserInputManager$requestUserInput$2$1$timeoutJob$1(this.$timeout, this.this$0, this.$request, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            long j5 = this.$timeout;
            this.label = 1;
            if (a.f(j5, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        this.this$0.handleTimeout(this.$request);
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((UserInputManager$requestUserInput$2$1$timeoutJob$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
