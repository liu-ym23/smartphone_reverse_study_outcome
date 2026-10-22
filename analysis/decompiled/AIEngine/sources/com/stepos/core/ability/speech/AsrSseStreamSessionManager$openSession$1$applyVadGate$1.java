package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrSseStreamSessionManager;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1", f = "AsrSseStreamSessionManager.kt", l = {279, 280, 288}, m = "invokeSuspend$applyVadGate")
/* loaded from: classes.dex */
public final class AsrSseStreamSessionManager$openSession$1$applyVadGate$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public AsrSseStreamSessionManager$openSession$1$applyVadGate$1(qb.b<? super AsrSseStreamSessionManager$openSession$1$applyVadGate$1> bVar) {
        super(bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AsrSseStreamSessionManager.C03341.invokeSuspend$applyVadGate(null, null, null, null, null, null, null, null, null, 0L, false, null, this);
    }
}
