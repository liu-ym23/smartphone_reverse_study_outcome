package com.android.ttcjpaysdk.base.framework.container;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\b\u001a\u00020\u0006\"\u0018\b\u0000\u0010\u0003*\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u008a@"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/StdBasePresenter;", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdModel;", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdView;", "P", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdBaseLogger;", "L", "", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.android.ttcjpaysdk.base.framework.container.CJPayStdPageView$postUntilVisible$1$isVisible$1", f = "CJPayStdPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CJPayStdPageView$postUntilVisible$1$isVisible$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    int label;

    public CJPayStdPageView$postUntilVisible$1$isVisible$1(Continuation<? super CJPayStdPageView$postUntilVisible$1$isVisible$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CJPayStdPageView$postUntilVisible$1$isVisible$1 r102 = new CJPayStdPageView$postUntilVisible$1$isVisible$1(r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Boolean> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Boolean> r101) {
        return ((CJPayStdPageView$postUntilVisible$1$isVisible$1) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return Boxing.boxBoolean(this.Z$0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
