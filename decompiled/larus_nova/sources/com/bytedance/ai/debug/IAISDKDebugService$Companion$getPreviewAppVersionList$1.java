package com.bytedance.ai.debug;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debug.IAISDKDebugService$Companion", f = "IAISDKDebugService.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT}, m = "getPreviewAppVersionList", n = {com.heytap.mcssdk.constant.b.f276376z}, s = {"L$0"})
public final class IAISDKDebugService$Companion$getPreviewAppVersionList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAISDKDebugService.Companion this$0;

    public IAISDKDebugService$Companion$getPreviewAppVersionList$1(IAISDKDebugService.Companion r100, Continuation<? super IAISDKDebugService$Companion$getPreviewAppVersionList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(0, null, null, null, null, 0, this);
    }
}
