package com.stepos.core.ability.speech;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class TtsStreamCallbackQueue$drainLoop$1$1 extends FunctionReferenceImpl implements zb.a<lb.n> {
    public TtsStreamCallbackQueue$drainLoop$1$1(Object obj) {
        super(0, obj, TtsStreamCallbackQueue.class, "drainLoop", "drainLoop()V", 0);
    }

    @Override // zb.a
    public /* bridge */ /* synthetic */ lb.n invoke() {
        invoke2();
        return lb.n.f10413a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TtsStreamCallbackQueue) this.receiver).drainLoop();
    }
}
