package com.bytedance.applet.view;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment$floatingSpeakerController$1", f = "AppletFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT}, m = "clearContext", n = {}, s = {})
public final class AppletFragment$floatingSpeakerController$1$clearContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletFragment$floatingSpeakerController$1 this$0;

    public AppletFragment$floatingSpeakerController$1$clearContext$1(AppletFragment$floatingSpeakerController$1 r100, Continuation<? super AppletFragment$floatingSpeakerController$1$clearContext$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
