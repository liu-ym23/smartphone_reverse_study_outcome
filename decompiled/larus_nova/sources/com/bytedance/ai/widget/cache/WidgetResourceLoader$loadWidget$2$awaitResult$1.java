package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/Widget;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadWidget$2$awaitResult$1", f = "WidgetResourceLoader.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetResourceLoader$loadWidget$2$awaitResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Widget>, Object> {
    final /* synthetic */ CompletableDeferred<Widget> $it;
    int label;

    public WidgetResourceLoader$loadWidget$2$awaitResult$1(CompletableDeferred<Widget> r100, Continuation<? super WidgetResourceLoader$loadWidget$2$awaitResult$1> r101) {
        this.$it = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WidgetResourceLoader$loadWidget$2$awaitResult$1(this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Widget> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Widget> r101) {
        return ((WidgetResourceLoader$loadWidget$2$awaitResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CompletableDeferred<Widget> r103 = this.$it;
        this.label = 1;
        r100 = r103.await(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
