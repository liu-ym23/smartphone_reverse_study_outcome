package com.bytedance.ai.applet.db;

import kotlin.Metadata;
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
@DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper$insertAsync$1", f = "WidgetContextHelper.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetContextHelper$insertAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $cardId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    int label;

    public WidgetContextHelper$insertAsync$1(String r100, String r101, String r102, String r103, Continuation<? super WidgetContextHelper$insertAsync$1> r104) {
        this.$cardId = r100;
        this.$messageId = r101;
        this.$conversationId = r102;
        this.$botId = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WidgetContextHelper$insertAsync$1(this.$cardId, this.$messageId, this.$conversationId, this.$botId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WidgetContextHelper$insertAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        WidgetContextHelper r103 = WidgetContextHelper.f34570a;
        String r104 = this.$cardId;
        String r105 = this.$messageId;
        String r106 = this.$conversationId;
        String r107 = this.$botId;
        this.label = 1;
        if (r103.insert(r104, r105, r106, r107, this) != r101) goto L12;
        return r101;
    }
}
