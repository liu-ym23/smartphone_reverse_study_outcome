package com.stepos.taskrobot.llmapi.stepfun.trace;

import J7.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2", f = "GuiAgentTraceManagerV2.kt", l = {225}, m = "postTaskStart-bMdYcbs", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiAgentTraceManagerV2$postTaskStart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuiAgentTraceManagerV2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiAgentTraceManagerV2$postTaskStart$1(GuiAgentTraceManagerV2 guiAgentTraceManagerV2, H7.c<? super GuiAgentTraceManagerV2$postTaskStart$1> cVar) {
        super(cVar);
        this.this$0 = guiAgentTraceManagerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7355postTaskStartbMdYcbs = this.this$0.m7355postTaskStartbMdYcbs(null, null, null, null, null, null, this);
        return objM7355postTaskStartbMdYcbs == CoroutineSingletons.f4909a ? objM7355postTaskStartbMdYcbs : new Result(objM7355postTaskStartbMdYcbs);
    }
}
