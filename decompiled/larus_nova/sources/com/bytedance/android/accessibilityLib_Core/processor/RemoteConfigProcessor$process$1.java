package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.step.ApplyStep;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.RemoteConfigProcessor$process$1", f = "RemoteConfigProcessor.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"start$iv"}, s = {"J$0"})
public final class RemoteConfigProcessor$process$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $update;
    long J$0;
    int label;

    public RemoteConfigProcessor$process$1(boolean r100, Continuation r101) {
        this.$update = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RemoteConfigProcessor$process$1(this.$update, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteConfigProcessor$process$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        long r103 = this.J$0;
        ResultKt.throwOnFailure(r100);
    L13:
        if (("remoteConfig apply end, cost time = " + (System.currentTimeMillis() - r103)) == null) goto L16;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r105 = System.currentTimeMillis();
        ApplyStep r106 = (ApplyStep) RemoteConfigProcessor.f38285c.getValue();
        Boolean r107 = Boxing.boxBoolean(this.$update);
        this.J$0 = r105;
        this.label = 1;
        if (r106.a(r107, this) != r101) goto L11;
        return r101;
    L11:
        r103 = r105;
        goto L13
    }
}
