package com.bytedance.ai.applet.domain;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager", f = "AppletDomainPolicyManager.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL}, m = "fetchPolicyFromServer-0E7RQCE", n = {com.heytap.mcssdk.constant.b.f276376z, "source"}, s = {"L$0", "L$1"})
final class AppletDomainPolicyManager$fetchPolicyFromServer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDomainPolicyManager this$0;

    public AppletDomainPolicyManager$fetchPolicyFromServer$1(AppletDomainPolicyManager r100, Continuation<? super AppletDomainPolicyManager$fetchPolicyFromServer$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = AppletDomainPolicyManager.a(this.this$0, null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
