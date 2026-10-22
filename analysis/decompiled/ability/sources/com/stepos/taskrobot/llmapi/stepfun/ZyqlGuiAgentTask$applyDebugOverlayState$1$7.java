package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import g6.C1463c;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$applyDebugOverlayState$1$7", f = "ZyqlGuiAgentTask.kt", l = {1889}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$applyDebugOverlayState$1$7 extends SuspendLambda implements S7.n {
    final /* synthetic */ C1463c $toRelease;
    int label;
    final /* synthetic */ ZyqlGuiAgentTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$applyDebugOverlayState$1$7(ZyqlGuiAgentTask zyqlGuiAgentTask, C1463c c1463c, H7.c<? super ZyqlGuiAgentTask$applyDebugOverlayState$1$7> cVar) {
        super(2, cVar);
        this.this$0 = zyqlGuiAgentTask;
        this.$toRelease = c1463c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlGuiAgentTask$applyDebugOverlayState$1$7(this.this$0, this.$toRelease, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            this.label = 1;
            if (kotlinx.coroutines.a.f(150L, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        com.stepos.statsrpk.service.c.p("[", this.this$0.getTaskId(), "] ON→OFF: delayed compositor.release() now", "DebugOverlayFlow", true);
        this.$toRelease.c();
        com.stepos.statsrpk.service.c.p("[", this.this$0.getTaskId(), "] ON→OFF: compositor released", "DebugOverlayFlow", true);
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ZyqlGuiAgentTask$applyDebugOverlayState$1$7) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
