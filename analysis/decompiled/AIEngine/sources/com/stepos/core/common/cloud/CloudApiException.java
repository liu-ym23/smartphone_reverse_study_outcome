package com.stepos.core.common.cloud;

import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudApiException extends IOException {
    private final int httpCode;
    private final String responseBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudApiException(int i10, String responseBody) {
        super("Cloud API error: HTTP " + i10);
        kotlin.jvm.internal.g.f(responseBody, "responseBody");
        this.httpCode = i10;
        this.responseBody = responseBody;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    public final String getResponseBody() {
        return this.responseBody;
    }
}
