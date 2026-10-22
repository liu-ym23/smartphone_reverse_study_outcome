package com.stepos.core.model.task;

import gc.q;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AITaskSupervisorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBenignFlowAbortAfterFirstElement(Throwable th) {
        String message;
        return th != null && (th instanceof CancellationException) && (message = th.getMessage()) != null && q.l0(message, "Flow was aborted", false) && q.l0(message, "no more elements needed", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCircuitBreakerNeutralCancellation(Throwable th) {
        return (th == null || !(th instanceof CancellationException) || (th instanceof TimeoutCancellationException)) ? false : true;
    }
}
