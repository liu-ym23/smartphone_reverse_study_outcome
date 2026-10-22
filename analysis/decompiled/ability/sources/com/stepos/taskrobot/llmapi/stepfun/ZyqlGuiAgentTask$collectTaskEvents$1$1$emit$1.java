package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import Ca.G;
import com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$1$1", f = "ZyqlGuiAgentTask.kt", l = {964, 997, 1043, 1053, 1083, 1089, 1105, 1111}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$collectTaskEvents$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZyqlGuiAgentTask.AnonymousClass1.C01651<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZyqlGuiAgentTask$collectTaskEvents$1$1$emit$1(ZyqlGuiAgentTask.AnonymousClass1.C01651<? super T> c01651, H7.c<? super ZyqlGuiAgentTask$collectTaskEvents$1$1$emit$1> cVar) {
        super(cVar);
        this.this$0 = c01651;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((G) null, (H7.c<? super r>) this);
    }
}
