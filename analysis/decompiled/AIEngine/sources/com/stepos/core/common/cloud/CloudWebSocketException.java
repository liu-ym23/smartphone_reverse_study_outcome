package com.stepos.core.common.cloud;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudWebSocketException extends Exception {
    private final Integer httpCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudWebSocketException(Integer num, Throwable cause) {
        super("Cloud WebSocket error: httpCode=" + num, cause);
        kotlin.jvm.internal.g.f(cause, "cause");
        this.httpCode = num;
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }
}
