package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.CountDownCoroutinesKt$countDownCoroutines$5", f = "countDownCoroutines.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class CountDownCoroutinesKt$countDownCoroutines$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTimeMillis;
    final /* synthetic */ Function0 $onFinish;
    final /* synthetic */ Function0 $onStart;
    int label;

    public CountDownCoroutinesKt$countDownCoroutines$5(Function0 r100, long r101, Function0 r102, Continuation r103) {
        this.$onStart = r100;
        this.$delayTimeMillis = r101;
        this.$onFinish = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new CountDownCoroutinesKt$countDownCoroutines$5(this.$onStart, this.$delayTimeMillis, this.$onFinish, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CountDownCoroutinesKt$countDownCoroutines$5) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        Function0 r103 = this.$onFinish;
        if (r103 == null) goto L18;
        Unit r104 = (Unit) r103.invoke();
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function0 r105 = this.$onStart;
        if (r105 == null) goto L11;
        Unit r106 = (Unit) r105.invoke();
    L11:
        long r107 = this.$delayTimeMillis;
        this.label = 1;
        if (DelayKt.delay(r107, this) != r101) goto L14;
        return r101;
    }
}
