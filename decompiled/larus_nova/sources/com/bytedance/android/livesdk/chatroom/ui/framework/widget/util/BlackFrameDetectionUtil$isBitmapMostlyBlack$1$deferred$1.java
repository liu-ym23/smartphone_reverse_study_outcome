package com.bytedance.android.livesdk.chatroom.ui.framework.widget.util;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1", f = "BlackFrameDetectionUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $i;
    final /* synthetic */ int $j;
    final /* synthetic */ int $partHeight;
    final /* synthetic */ int $partWidth;
    final /* synthetic */ Ref.IntRef $sample;
    int label;
    final /* synthetic */ BlackFrameDetectionUtil$isBitmapMostlyBlack$1 this$0;

    public BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1(BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r100, int r101, int r102, int r103, int r104, Ref.IntRef r105, Continuation r106) {
        this.this$0 = r100;
        this.$i = r101;
        this.$partWidth = r102;
        this.$j = r103;
        this.$partHeight = r104;
        this.$sample = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "completion");
        return new BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1(this.this$0, this.$i, this.$partWidth, this.$j, this.$partHeight, this.$sample, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        int r101 = this.$i;
        int r102 = this.$partWidth;
        int r103 = r101 * r102;
        int r104 = (r101 + 1) * r102;
        int r105 = this.$j;
        int r106 = this.$partHeight;
        int r107 = r105 * r106;
        int r108 = (r105 + 1) * r106;
        if (this.this$0.$bitmap.getPixel(r103, r107) != 0) goto L7;
        int r109 = 0;
    L8:
        if (r103 >= r104) goto L17;
    L9:
        if (r107 >= r108) goto L15;
        if (this.this$0.$bitmap.getPixel(r103, r107) != r109) goto L13;
        r107 = r107 + this.$sample.element;
        goto L9
    L13:
        return Boxing.boxBoolean(false);
    L15:
        r103 = r103 + this.$sample.element;
        goto L8
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r109 = -16777216;
        goto L8
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
