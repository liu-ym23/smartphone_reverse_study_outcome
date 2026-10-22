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
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService", f = "UserAuthService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME}, m = "getUserAppsPermissionDetail-BWLJW6A", n = {}, s = {})
public final class UserAuthService$getUserAppsPermissionDetail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserAuthService this$0;

    public UserAuthService$getUserAppsPermissionDetail$1(UserAuthService r100, Continuation<? super UserAuthService$getUserAppsPermissionDetail$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.o(null, null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
