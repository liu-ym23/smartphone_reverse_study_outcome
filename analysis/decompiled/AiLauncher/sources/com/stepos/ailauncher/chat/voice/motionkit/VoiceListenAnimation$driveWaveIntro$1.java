package com.stepos.ailauncher.chat.voice.motionkit;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation", f = "VoiceListenAnimation.kt", l = {707}, m = "driveWaveIntro", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation$driveWaveIntro$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceListenAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$driveWaveIntro$1(VoiceListenAnimation voiceListenAnimation, InterfaceC4014c<? super VoiceListenAnimation$driveWaveIntro$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = voiceListenAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g0(this);
    }
}
