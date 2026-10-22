package com.bytedance.ai.model.widgets;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage$changeTo$1", f = "LynxViewFloatingPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LynxViewFloatingPage$changeTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $errorLogBlock;
    final /* synthetic */ Lifecycle.Event $event;
    final /* synthetic */ LifecycleRegistry $this_changeTo;
    int label;

    public LynxViewFloatingPage$changeTo$1(LifecycleRegistry r100, Lifecycle.Event r101, Function0<Unit> r102, Continuation<? super LynxViewFloatingPage$changeTo$1> r103) {
        this.$this_changeTo = r100;
        this.$event = r101;
        this.$errorLogBlock = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LynxViewFloatingPage$changeTo$1(this.$this_changeTo, this.$event, this.$errorLogBlock, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LynxViewFloatingPage$changeTo$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        LifecycleRegistry r101 = this.$this_changeTo;
        Lifecycle.Event r102 = this.$event;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        r101.handleLifecycleEvent(r102);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L13;
        this.$errorLogBlock.invoke();
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
