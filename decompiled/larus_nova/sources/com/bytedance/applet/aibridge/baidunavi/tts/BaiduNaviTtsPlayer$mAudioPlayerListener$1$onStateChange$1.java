package com.bytedance.applet.aibridge.baidunavi.tts;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.baidunavi.tts.BaiduNaviTtsPlayer$mAudioPlayerListener$1$onStateChange$1", f = "BaiduNaviTtsPlayer.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class BaiduNaviTtsPlayer$mAudioPlayerListener$1$onStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaiduNaviTtsPlayer.a $data;
    int label;
    final /* synthetic */ BaiduNaviTtsPlayer this$0;

    public BaiduNaviTtsPlayer$mAudioPlayerListener$1$onStateChange$1(BaiduNaviTtsPlayer r100, BaiduNaviTtsPlayer.a r101, Continuation<? super BaiduNaviTtsPlayer$mAudioPlayerListener$1$onStateChange$1> r102) {
        this.this$0 = r100;
        this.$data = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BaiduNaviTtsPlayer$mAudioPlayerListener$1$onStateChange$1(this.this$0, this.$data, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BaiduNaviTtsPlayer$mAudioPlayerListener$1$onStateChange$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        BaiduNaviTtsPlayer r103 = this.this$0;
        BaiduNaviTtsPlayer.a r104 = r103.f190977c;
        if (r104 == null) goto L17;
        if (Intrinsics.areEqual(this.$data, r104) == false) goto L17;
        r103.f190977c = null;
        FLogger.f375446a.i("BaiduNaviTtsPlayer", "auto playing next tts");
        r103.b(r104, false);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r101) goto L11;
        return r101;
    }
}
