package com.stepos.net.exception;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/net/exception/ApiErrorCode;", "", "<init>", "()V", "UNKNOWN", "", "NETWORK_UNAVAILABLE", "TIMEOUT", "SSL_ERROR", "PARSE_ERROR", "CANCELED", "HTTP_ERROR", "BUSINESS_ERROR", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ApiErrorCode {
    public static final int BUSINESS_ERROR = -3000;
    public static final int CANCELED = -1004;
    public static final int HTTP_ERROR = -2000;
    public static final ApiErrorCode INSTANCE = new ApiErrorCode();
    public static final int NETWORK_UNAVAILABLE = -1000;
    public static final int PARSE_ERROR = -1003;
    public static final int SSL_ERROR = -1002;
    public static final int TIMEOUT = -1001;
    public static final int UNKNOWN = -1;

    private ApiErrorCode() {
    }
}
