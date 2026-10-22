package com.android.ttcjpaysdk.kmp.common.view.lynx;

import android.view.View;
import androidx.compose.runtime.MutableState;
import com.android.ttcjpaysdk.kmp.common.lynx.CJLynxService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.android.ttcjpaysdk.kmp.common.view.lynx.CJLynxCardView_androidKt$CJLynxCardView$1$1", f = "CJLynxCardView.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CJLynxCardView_androidKt$CJLynxCardView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callbackId;
    final /* synthetic */ IKmpCJLynxCardService $cardService;
    final /* synthetic */ CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1 $eventCallback;
    final /* synthetic */ MutableState<String> $selfContainerIdState;
    final /* synthetic */ View $view;
    int label;

    public CJLynxCardView_androidKt$CJLynxCardView$1$1(MutableState<String> r100, IKmpCJLynxCardService r101, View r102, String r103, CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1 r104, Continuation<? super CJLynxCardView_androidKt$CJLynxCardView$1$1> r105) {
        this.$selfContainerIdState = r100;
        this.$cardService = r101;
        this.$view = r102;
        this.$callbackId = r103;
        this.$eventCallback = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CJLynxCardView_androidKt$CJLynxCardView$1$1(this.$selfContainerIdState, this.$cardService, this.$view, this.$callbackId, this.$eventCallback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CJLynxCardView_androidKt$CJLynxCardView$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        MutableState<String> r101 = this.$selfContainerIdState;
        IKmpCJLynxCardService r102 = this.$cardService;
        if (r102 == null) goto L7;
        String r103 = r102.getLynxCardContainerId(this.$view);
    L8:
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r101.setValue(r103);
        CJLynxService.INSTANCE.subscribe("cjpay_lynxcard_common_event", this.$callbackId + "cjpay_lynxcard_common_event", this.$eventCallback);
        return Unit.INSTANCE;
    L7:
        r103 = null;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
