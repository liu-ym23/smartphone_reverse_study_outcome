package com.bytedance.ai.applet.douyinAuth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper", f = "DouyinGeneralAuthHelper.kt", i = {0, 0}, l = {339}, m = "fetchDouyinGeneralAuthPrepareResult", n = {"appId", "timeoutFailure"}, s = {"L$0", "I$0"})
public final class DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinGeneralAuthHelper this$0;

    public DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1(DouyinGeneralAuthHelper r100, Continuation<? super DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DouyinGeneralAuthHelper r101 = this.this$0;
        DouyinGeneralAuthHelper r102 = DouyinGeneralAuthHelper.f34616a;
        return r101.b(null, this);
    }
}
