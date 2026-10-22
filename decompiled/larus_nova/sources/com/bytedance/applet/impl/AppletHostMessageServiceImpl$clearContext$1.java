package com.bytedance.applet.impl;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletHostMessageServiceImpl", f = "AppletHostMessageServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA}, m = "clearContext", n = {}, s = {})
public final class AppletHostMessageServiceImpl$clearContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletHostMessageServiceImpl this$0;

    public AppletHostMessageServiceImpl$clearContext$1(AppletHostMessageServiceImpl r100, Continuation<? super AppletHostMessageServiceImpl$clearContext$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
