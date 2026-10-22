package com.bytedance.ai.bridge.remote;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService", f = "UserAuthService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_REQUEST_LOG}, m = "fetchDomainPolicy-gIAlu-s", n = {}, s = {})
public final class UserAuthService$fetchDomainPolicy$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserAuthService this$0;

    public UserAuthService$fetchDomainPolicy$1(UserAuthService r100, Continuation<? super UserAuthService$fetchDomainPolicy$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.g(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
