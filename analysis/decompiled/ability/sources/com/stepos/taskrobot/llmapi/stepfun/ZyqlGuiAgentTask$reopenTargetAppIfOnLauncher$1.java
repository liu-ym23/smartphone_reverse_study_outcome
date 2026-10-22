package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {2213}, m = "reopenTargetAppIfOnLauncher$stepfun_release", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$reopenTargetAppIfOnLauncher$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZyqlGuiAgentTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$reopenTargetAppIfOnLauncher$1(ZyqlGuiAgentTask zyqlGuiAgentTask, H7.c<? super ZyqlGuiAgentTask$reopenTargetAppIfOnLauncher$1> cVar) {
        super(cVar);
        this.this$0 = zyqlGuiAgentTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reopenTargetAppIfOnLauncher$stepfun_release(this);
    }
}
