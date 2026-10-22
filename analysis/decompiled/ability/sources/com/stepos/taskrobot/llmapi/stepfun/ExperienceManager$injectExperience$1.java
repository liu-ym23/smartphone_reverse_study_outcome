package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ExperienceManager", f = "ExperienceManager.kt", l = {529, 550}, m = "injectExperience-0E7RQCE", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExperienceManager$injectExperience$1 extends ContinuationImpl {
    int I$0;
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
    final /* synthetic */ ExperienceManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceManager$injectExperience$1(ExperienceManager experienceManager, H7.c<? super ExperienceManager$injectExperience$1> cVar) {
        super(cVar);
        this.this$0 = experienceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7348injectExperience0E7RQCE = this.this$0.m7348injectExperience0E7RQCE(null, null, this);
        return objM7348injectExperience0E7RQCE == CoroutineSingletons.f4909a ? objM7348injectExperience0E7RQCE : new Result(objM7348injectExperience0E7RQCE);
    }
}
