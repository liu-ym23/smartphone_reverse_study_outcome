package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlAppLauncher", f = "ZyqlAppLauncher.kt", l = {63}, m = "launch-gIAlu-s", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlAppLauncher$launch$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZyqlAppLauncher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlAppLauncher$launch$1(ZyqlAppLauncher zyqlAppLauncher, H7.c<? super ZyqlAppLauncher$launch$1> cVar) {
        super(cVar);
        this.this$0 = zyqlAppLauncher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo7350launchgIAlus = this.this$0.mo7350launchgIAlus(null, this);
        return objMo7350launchgIAlus == CoroutineSingletons.f4909a ? objMo7350launchgIAlus : new Result(objMo7350launchgIAlus);
    }
}
