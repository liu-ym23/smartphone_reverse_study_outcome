package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import android.os.Build;
import ca.AbstractC0897f;
import com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SearchExperienceResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$Companion$create$6$expResult$1", f = "ZyqlGuiAgentTask.kt", l = {364}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$Companion$create$6$expResult$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $openAppName;
    final /* synthetic */ String $taskName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$Companion$create$6$expResult$1(Context context, String str, String str2, H7.c<? super ZyqlGuiAgentTask$Companion$create$6$expResult$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$openAppName = str;
        this.$taskName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlGuiAgentTask$Companion$create$6$expResult$1(this.$context, this.$openAppName, this.$taskName, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        Object objM7349searchExperiencegIAlus;
        String strValueOf;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            ExperienceManager experienceManager = ExperienceManager.INSTANCE;
            try {
                String strY = N9.j.y(this.$context);
                if (strY == null) {
                    strY = "";
                }
                str = strY;
            } catch (Exception unused) {
                str = "";
            }
            String str2 = this.$openAppName;
            String str3 = str2 == null ? "" : str2;
            String str4 = (str2 == null || (strValueOf = String.valueOf(AbstractC0897f.E(this.$context, str2))) == null) ? "" : strValueOf;
            String str5 = Build.MODEL;
            if (str5 == null) {
                str5 = "Unknown";
            }
            String str6 = str5;
            Context context = this.$context;
            kotlin.jvm.internal.k.f(context, "context");
            ExperienceRequest experienceRequest = new ExperienceRequest(str, str3, str4, str6, String.valueOf(context.getResources().getConfiguration().fontScale), AbstractC0897f.C(this.$context), AbstractC0897f.B(this.$context), this.$taskName, null, 256, null);
            this.label = 1;
            objM7349searchExperiencegIAlus = experienceManager.m7349searchExperiencegIAlus(experienceRequest, this);
            if (objM7349searchExperiencegIAlus == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            objM7349searchExperiencegIAlus = ((Result) obj).f4887a;
        }
        return new Result(objM7349searchExperiencegIAlus);
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<SearchExperienceResult>> cVar) {
        return ((ZyqlGuiAgentTask$Companion$create$6$expResult$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
