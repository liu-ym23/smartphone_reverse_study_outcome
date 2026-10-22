package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$Companion$create$6", f = "ZyqlGuiAgentTask.kt", l = {363}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$Companion$create$6 extends SuspendLambda implements S7.n {
    final /* synthetic */ Context $context;
    final /* synthetic */ ZyqlGuiAgentTask $guiTask;
    final /* synthetic */ String $openAppName;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $taskName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$Companion$create$6(ZyqlGuiAgentTask zyqlGuiAgentTask, String str, Context context, String str2, String str3, H7.c<? super ZyqlGuiAgentTask$Companion$create$6> cVar) {
        super(2, cVar);
        this.$guiTask = zyqlGuiAgentTask;
        this.$taskId = str;
        this.$context = context;
        this.$openAppName = str2;
        this.$taskName = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlGuiAgentTask$Companion$create$6(this.$guiTask, this.$taskId, this.$context, this.$openAppName, this.$taskName, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            ZyqlGuiAgentTask$Companion$create$6$expResult$1 zyqlGuiAgentTask$Companion$create$6$expResult$1 = new ZyqlGuiAgentTask$Companion$create$6$expResult$1(this.$context, this.$openAppName, this.$taskName, null);
            this.label = 1;
            obj = kotlinx.coroutines.a.p(3000L, zyqlGuiAgentTask$Companion$create$6$expResult$1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        Result result = (Result) obj;
        ZyqlGuiAgentTask zyqlGuiAgentTask = this.$guiTask;
        if (result != null) {
            Object obj2 = result.f4887a;
            searchExperienceResult = obj2 instanceof Result.Failure ? null : obj2;
        }
        zyqlGuiAgentTask.setExperienceResult(searchExperienceResult);
        AbstractC1436a.d("ZyqlGuiAgentTask", "[" + this.$taskId + "] handover: experience search done, result=" + (this.$guiTask.getExperienceResult() != null), true);
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ZyqlGuiAgentTask$Companion$create$6) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
