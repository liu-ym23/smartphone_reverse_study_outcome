package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ExperienceManager", f = "ExperienceManager.kt", l = {593}, m = "deleteExperience-gIAlu-s", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExperienceManager$deleteExperience$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExperienceManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceManager$deleteExperience$1(ExperienceManager experienceManager, H7.c<? super ExperienceManager$deleteExperience$1> cVar) {
        super(cVar);
        this.this$0 = experienceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7347deleteExperiencegIAlus = this.this$0.m7347deleteExperiencegIAlus(null, this);
        return objM7347deleteExperiencegIAlus == CoroutineSingletons.f4909a ? objM7347deleteExperiencegIAlus : new Result(objM7347deleteExperiencegIAlus);
    }
}
