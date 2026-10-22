package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ExperienceManager", f = "ExperienceManager.kt", l = {576}, m = "searchExperience-gIAlu-s", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExperienceManager$searchExperience$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExperienceManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceManager$searchExperience$1(ExperienceManager experienceManager, H7.c<? super ExperienceManager$searchExperience$1> cVar) {
        super(cVar);
        this.this$0 = experienceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7349searchExperiencegIAlus = this.this$0.m7349searchExperiencegIAlus(null, this);
        return objM7349searchExperiencegIAlus == CoroutineSingletons.f4909a ? objM7349searchExperiencegIAlus : new Result(objM7349searchExperiencegIAlus);
    }
}
