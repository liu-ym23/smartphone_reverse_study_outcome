package com.stepos.ailauncher.speech.tts;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine", f = "AIEngineTtsEngine.kt", l = {1250}, m = "waitForStreamAudioQuiet", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$waitForStreamAudioQuiet$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$waitForStreamAudioQuiet$1(AIEngineTtsEngine aIEngineTtsEngine, InterfaceC4014c<? super AIEngineTtsEngine$waitForStreamAudioQuiet$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = aIEngineTtsEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.X0(0, this);
    }
}
