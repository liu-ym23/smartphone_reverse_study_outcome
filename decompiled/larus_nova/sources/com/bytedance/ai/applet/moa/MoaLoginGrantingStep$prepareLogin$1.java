package com.bytedance.ai.applet.moa;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep", f = "MoaLoginGrantingStep.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, 372, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS}, m = "prepareLogin", n = {}, s = {})
final class MoaLoginGrantingStep$prepareLogin$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$prepareLogin$1(MoaLoginGrantingStep r100, Continuation<? super MoaLoginGrantingStep$prepareLogin$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MoaLoginGrantingStep.j(this.this$0, this);
    }
}
