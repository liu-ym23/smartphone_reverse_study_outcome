package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.CountDownCoroutinesKt$countDownCoroutines$4", f = "countDownCoroutines.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CountDownCoroutinesKt$countDownCoroutines$4 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $onTick;
    private /* synthetic */ int I$0;
    int label;

    public CountDownCoroutinesKt$countDownCoroutines$4(Function1 r100, Continuation r101) {
        this.$onTick = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        CountDownCoroutinesKt$countDownCoroutines$4 r102 = new CountDownCoroutinesKt$countDownCoroutines$4(this.$onTick, r101);
        Number r103 = (Number) r100;
        r103.intValue();
        r102.I$0 = r103.intValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return ((CountDownCoroutinesKt$countDownCoroutines$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        int r101 = this.I$0;
        Function1 r102 = this.$onTick;
        if (r102 == null) goto L8;
        Unit r103 = (Unit) r102.invoke(Boxing.boxInt(r101));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
