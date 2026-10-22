package com.stepos.ailauncher.speech.asr;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine", f = "AIEngineAsrEngine.kt", l = {1920}, m = "adoptOrStartCapture", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine$adoptOrStartCapture$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIEngineAsrEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineAsrEngine$adoptOrStartCapture$1(AIEngineAsrEngine aIEngineAsrEngine, InterfaceC4014c<? super AIEngineAsrEngine$adoptOrStartCapture$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = aIEngineAsrEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A(this);
    }
}
