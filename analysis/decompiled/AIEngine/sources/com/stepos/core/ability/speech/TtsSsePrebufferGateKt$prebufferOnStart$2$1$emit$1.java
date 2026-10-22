package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.TtsSsePrebufferGateKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2$1", f = "TtsSsePrebufferGate.kt", l = {98, 64, 75}, m = "emit")
/* loaded from: classes.dex */
public final class TtsSsePrebufferGateKt$prebufferOnStart$2$1$emit$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TtsSsePrebufferGateKt.AnonymousClass2.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TtsSsePrebufferGateKt$prebufferOnStart$2$1$emit$1(TtsSsePrebufferGateKt.AnonymousClass2.AnonymousClass1<? super T> anonymousClass1, qb.b<? super TtsSsePrebufferGateKt$prebufferOnStart$2$1$emit$1> bVar) {
        super(bVar);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((byte[]) null, (qb.b<? super lb.n>) this);
    }
}
