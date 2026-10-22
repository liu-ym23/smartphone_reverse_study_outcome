package com.bytedance.applet.event;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.LocalPluginService", f = "LocalPluginService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME}, m = "sendPayload", n = {}, s = {})
public final class LocalPluginService$sendPayload$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalPluginService this$0;

    public LocalPluginService$sendPayload$1(LocalPluginService r100, Continuation<? super LocalPluginService$sendPayload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LocalPluginService r101 = this.this$0;
        LocalPluginService r102 = LocalPluginService.f191791a;
        return r101.f(null, this);
    }
}
