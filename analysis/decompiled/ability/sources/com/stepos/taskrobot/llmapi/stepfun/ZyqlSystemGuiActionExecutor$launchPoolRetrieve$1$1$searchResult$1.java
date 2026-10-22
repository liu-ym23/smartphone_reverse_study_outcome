package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceSearchRequest;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SearchExperienceResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1$1$searchResult$1", f = "ZyqlSystemGuiActionExecutor.kt", l = {597}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1$1$searchResult$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ ExperienceSearchRequest $req;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1$1$searchResult$1(ExperienceSearchRequest experienceSearchRequest, H7.c<? super ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1$1$searchResult$1> cVar) {
        super(2, cVar);
        this.$req = experienceSearchRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1$1$searchResult$1(this.$req, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objC;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            com.stepos.taskrobot.taskmanager.experiencelib.client.a aVarK = F1.a.k();
            ExperienceSearchRequest experienceSearchRequest = this.$req;
            this.label = 1;
            objC = aVarK.c(experienceSearchRequest, this);
            if (objC == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            objC = ((Result) obj).f4887a;
        }
        return new Result(objC);
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<SearchExperienceResult>> cVar) {
        return ((ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1$1$searchResult$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
