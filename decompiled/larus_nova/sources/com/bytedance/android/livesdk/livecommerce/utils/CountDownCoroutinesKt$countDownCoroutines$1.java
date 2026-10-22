package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.CountDownCoroutinesKt$countDownCoroutines$1", f = "countDownCoroutines.kt", i = {0, 0, 1, 1}, l = {30, 31}, m = "invokeSuspend", n = {"$this$flow", RXScreenCaptureService.KEY_INDEX, "$this$flow", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0", "L$0", "I$0"})
final class CountDownCoroutinesKt$countDownCoroutines$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $delayTime;
    final /* synthetic */ long $timeMillis;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public CountDownCoroutinesKt$countDownCoroutines$1(int r100, long r101, Continuation r102) {
        this.$delayTime = r100;
        this.$timeMillis = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        CountDownCoroutinesKt$countDownCoroutines$1 r102 = new CountDownCoroutinesKt$countDownCoroutines$1(this.$delayTime, this.$timeMillis, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Integer> r100, Continuation<? super Unit> r101) {
        return ((CountDownCoroutinesKt$countDownCoroutines$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0063 -> B:19:0x0066). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        int r102 = this.I$1;
        int r103 = this.I$0;
        FlowCollector r104 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);
        FlowCollector r111 = r104;
        CountDownCoroutinesKt$countDownCoroutines$1 r105 = this;
    L19:
        int r106 = r103 - 1;
        int r107 = r102;
        int r108 = r106;
    L11:
        if (r108 < r107) goto L21;
        Integer r109 = Boxing.boxInt(r108);
        r105.L$0 = r111;
        r105.I$0 = r108;
        r105.I$1 = r107;
        r105.label = 1;
        if (r111.emit(r109, r105) != r100) goto L15;
        return r100;
    L15:
        int r112 = r107;
        r103 = r108;
        r102 = r112;
    L16:
        long r113 = r105.$timeMillis;
        r105.L$0 = r111;
        r105.I$0 = r103;
        r105.I$1 = r102;
        r105.label = 2;
        if (DelayKt.delay(r113, r105) != r100) goto L19;
        return r100;
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r102 = this.I$1;
        r103 = this.I$0;
        FlowCollector r114 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);
        r111 = r114;
        r105 = this;
        goto L16
    L10:
        ResultKt.throwOnFailure(r110);
        r111 = (FlowCollector) this.L$0;
        r108 = this.$delayTime;
        r107 = 0;
        r105 = this;
        goto L11
    }
}
