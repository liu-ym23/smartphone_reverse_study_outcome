package com.bytedance.ai.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.utils.CoroutineDebouncer$debounce$2", f = "CoroutineDebouncer.kt", i = {}, l = {33, 34}, m = "invokeSuspend", n = {}, s = {})
final class CoroutineDebouncer$debounce$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ Object $param;
    int label;
    final /* synthetic */ d this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineDebouncer$debounce$2(d r100, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r101, Object r102, Continuation<? super CoroutineDebouncer$debounce$2> r103) {
        this.this$0 = r100;
        this.$action = r101;
        this.$param = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CoroutineDebouncer$debounce$2(this.this$0, this.$action, this.$param, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CoroutineDebouncer$debounce$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        Function2<Object, Continuation<? super Unit>, Object> r103 = this.$action;
        Object r104 = this.$param;
        this.label = 2;
        if (r103.invoke(r104, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        long r105 = this.this$0.f37633a;
        this.label = 1;
        if (DelayKt.delay(r105, this) != r101) goto L13;
        return r101;
    }
}
