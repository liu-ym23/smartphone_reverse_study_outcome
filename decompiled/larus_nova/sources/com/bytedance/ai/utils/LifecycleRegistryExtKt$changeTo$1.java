package com.bytedance.ai.utils;

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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.utils.LifecycleRegistryExtKt$changeTo$1", f = "LifecycleRegistryExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LifecycleRegistryExtKt$changeTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.Event $event;
    final /* synthetic */ LifecycleRegistry $this_changeTo;
    int label;

    public LifecycleRegistryExtKt$changeTo$1(Lifecycle.Event r100, LifecycleRegistry r101, Continuation<? super LifecycleRegistryExtKt$changeTo$1> r102) {
        this.$event = r100;
        this.$this_changeTo = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LifecycleRegistryExtKt$changeTo$1(this.$event, this.$this_changeTo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LifecycleRegistryExtKt$changeTo$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r100);
        g r101 = g.f37637a;
        r101.d("LifecycleRegistry", "LifecycleRegistry changeTo " + this.$event);
        if (this.$event != Lifecycle.Event.ON_DESTROY) goto L7;
    L9:
        LifecycleRegistry r102 = this.$this_changeTo;
        Lifecycle.Event r103 = this.$event;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        r102.handleLifecycleEvent(r103);     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        Lifecycle.Event r107 = this.$event;
        g r108 = g.f37637a;
        StringBuilder r109 = new StringBuilder("Unable to handleLifecycleEvent ");
        r109.append(r107);
        r109.append(' ');
        r106.printStackTrace();
        r109.append(Unit.INSTANCE);
        r108.e("LifecycleRegistry", r109.toString());
    L18:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L7:
        if (this.$this_changeTo.getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
        r101.e("LifecycleRegistry", "Unable to " + this.$event + " current state is " + this.$this_changeTo.getCurrentState());
        goto L18
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
