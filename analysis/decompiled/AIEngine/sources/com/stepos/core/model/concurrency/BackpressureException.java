package com.stepos.core.model.concurrency;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BackpressureException extends RuntimeException {
    private final long retryAfterMs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackpressureException(String message, long j10) {
        super(message);
        g.f(message, "message");
        this.retryAfterMs = j10;
    }

    public final long getRetryAfterMs() {
        return this.retryAfterMs;
    }
}
