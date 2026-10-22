package com.bytedance.applet.event;

import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener$onUIAction$1", f = "BaseAppActionListener.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND}, m = "invokeSuspend", n = {}, s = {})
final class BaseAppActionListener$onUIAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiName;
    final /* synthetic */ String $appId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Long $createTime;
    final /* synthetic */ Map<String, String> $featureMap;
    final /* synthetic */ Job $job;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $param;
    final /* synthetic */ String $questionId;
    final /* synthetic */ Function1<String, Boolean> $responseCallback;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseAppActionListener$onUIAction$1(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105, String r106, String r107, Long r108, Job r110, Function1<? super String, Boolean> r111, Continuation<? super BaseAppActionListener$onUIAction$1> r112) {
        this.$botId = r100;
        this.$conversationId = r101;
        this.$appId = r102;
        this.$apiName = r103;
        this.$param = r104;
        this.$featureMap = r105;
        this.$msgId = r106;
        this.$questionId = r107;
        this.$createTime = r108;
        this.$job = r110;
        this.$responseCallback = r111;
        super(2, r112);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new BaseAppActionListener$onUIAction$1(this.$botId, this.$conversationId, this.$appId, this.$apiName, this.$param, this.$featureMap, this.$msgId, this.$questionId, this.$createTime, this.$job, this.$responseCallback, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BaseAppActionListener$onUIAction$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.applet.event.g] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        e r102 = e.f191812a;
        String r111 = this.$botId;
        String r103 = this.$conversationId;
        String r104 = this.$appId;
        final String r105 = this.$apiName;
        String r106 = this.$param;
        Map<String, String> r107 = this.$featureMap;
        String r108 = this.$msgId;
        final String r109 = this.$questionId;
        Long r112 = this.$createTime;
        final Job r113 = this.$job;
        final Function1<String, Boolean> r114 = this.$responseCallback;
        ?? r115 = new g(r113, r109, r105, r114);
        this.label = 1;
        if (e.d(r102, r111, r103, r104, r105, r106, r107, r108, r109, r112, r115, this) != r100) goto L12;
        return r100;
    }
}
