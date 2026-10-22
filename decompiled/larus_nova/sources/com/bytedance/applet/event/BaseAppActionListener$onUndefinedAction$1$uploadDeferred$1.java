package com.bytedance.applet.event;

import com.bytedance.ai.applet.services.AppletSnapshotManagerService;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/applet/services/SnapshotUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1", f = "BaseAppActionListener.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
public final class BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends com.bytedance.ai.applet.services.e>>, Object> {
    final /* synthetic */ String $key;
    private /* synthetic */ Object L$0;
    int label;

    public BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1(String r100, Continuation<? super BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1> r101) {
        this.$key = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1 r102 = new BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1(this.$key, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends com.bytedance.ai.applet.services.e>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<com.bytedance.ai.applet.services.e>> r101) {
        return ((BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
        Object r103 = ((Result) r100).m9458unboximpl();     // Catch: Throwable -> L15
    L13:
        Object r104 = Result.m9449constructorimpl(Result.m9448boximpl(r103));     // Catch: Throwable -> L15
    L17:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L21;
        return r104;
    L21:
        return Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r105)));
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        String r107 = this.$key;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L15
        AppletSnapshotManagerService r109 = AppletSnapshotManagerService.f35190a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r103 = r109.i(r107, this);     // Catch: Throwable -> L15
        if (r103 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
