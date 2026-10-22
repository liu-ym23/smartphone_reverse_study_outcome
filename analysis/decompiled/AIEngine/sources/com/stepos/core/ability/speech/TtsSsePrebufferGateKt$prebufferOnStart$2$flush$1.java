package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.TtsSsePrebufferGateKt;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2", f = "TtsSsePrebufferGate.kt", l = {98, ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH}, m = "invokeSuspend$flush")
/* loaded from: classes.dex */
public final class TtsSsePrebufferGateKt$prebufferOnStart$2$flush$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    public TtsSsePrebufferGateKt$prebufferOnStart$2$flush$1(qb.b<? super TtsSsePrebufferGateKt$prebufferOnStart$2$flush$1> bVar) {
        super(bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TtsSsePrebufferGateKt.AnonymousClass2.invokeSuspend$flush(null, null, null, null, null, 0L, 0L, this);
    }
}
