package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {160}, m = "openApp-yxL6bBk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlSystemGuiActionExecutor$openApp$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZyqlSystemGuiActionExecutor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlSystemGuiActionExecutor$openApp$1(ZyqlSystemGuiActionExecutor zyqlSystemGuiActionExecutor, H7.c<? super ZyqlSystemGuiActionExecutor$openApp$1> cVar) {
        super(cVar);
        this.this$0 = zyqlSystemGuiActionExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo7351openAppyxL6bBk = this.this$0.mo7351openAppyxL6bBk(null, null, 0, null, this);
        return objMo7351openAppyxL6bBk == CoroutineSingletons.f4909a ? objMo7351openAppyxL6bBk : new Result(objMo7351openAppyxL6bBk);
    }
}
