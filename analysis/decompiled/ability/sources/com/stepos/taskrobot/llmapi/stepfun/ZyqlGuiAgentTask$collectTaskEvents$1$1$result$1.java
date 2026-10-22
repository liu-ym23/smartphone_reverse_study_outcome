package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$1$1$result$1", f = "ZyqlGuiAgentTask.kt", l = {998}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$collectTaskEvents$1$1$result$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ GuiTaskRecord $record;
    int label;
    final /* synthetic */ ZyqlGuiAgentTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$collectTaskEvents$1$1$result$1(ZyqlGuiAgentTask zyqlGuiAgentTask, GuiTaskRecord guiTaskRecord, H7.c<? super ZyqlGuiAgentTask$collectTaskEvents$1$1$result$1> cVar) {
        super(2, cVar);
        this.this$0 = zyqlGuiAgentTask;
        this.$record = guiTaskRecord;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlGuiAgentTask$collectTaskEvents$1$1$result$1(this.this$0, this.$record, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7348injectExperience0E7RQCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            ExperienceManager experienceManager = ExperienceManager.INSTANCE;
            Context context = this.this$0.getContext();
            GuiTaskRecord guiTaskRecord = this.$record;
            kotlin.jvm.internal.k.c(guiTaskRecord);
            this.label = 1;
            objM7348injectExperience0E7RQCE = experienceManager.m7348injectExperience0E7RQCE(context, guiTaskRecord, this);
            if (objM7348injectExperience0E7RQCE == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            objM7348injectExperience0E7RQCE = ((Result) obj).f4887a;
        }
        return new Result(objM7348injectExperience0E7RQCE);
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<String>> cVar) {
        return ((ZyqlGuiAgentTask$collectTaskEvents$1$1$result$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
