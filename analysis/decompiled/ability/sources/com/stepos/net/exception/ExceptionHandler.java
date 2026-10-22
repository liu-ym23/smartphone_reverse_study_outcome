package com.stepos.net.exception;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import j9.m;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/net/exception/ExceptionHandler;", "", AppAgent.CONSTRUCT, "()V", "handle", "Lcom/stepos/net/exception/ApiException;", "throwable", "", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExceptionHandler {
    public static final ExceptionHandler INSTANCE = new ExceptionHandler();

    private ExceptionHandler() {
    }

    public final ApiException handle(Throwable throwable) {
        k.f(throwable, "throwable");
        if (throwable instanceof ApiException) {
            return (ApiException) throwable;
        }
        if (throwable instanceof CancellationException) {
            return new ApiException(ApiErrorCode.CANCELED, "Request canceled", throwable, null, 8, null);
        }
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            int i = httpException.f5969a;
            String strH = httpException.b;
            if (m.s0(strH)) {
                strH = a.h(httpException.f5969a, "HTTP ");
            }
            String str = strH;
            k.e(str, "ifBlank(...)");
            return new ApiException(i, str, throwable, null, 8, null);
        }
        if (throwable instanceof SocketTimeoutException) {
            return new ApiException(ApiErrorCode.TIMEOUT, "Request timed out, please try again", throwable, null, 8, null);
        }
        if ((throwable instanceof UnknownHostException) || (throwable instanceof ConnectException)) {
            return new ApiException(-1000, "Network is unavailable, please check your connection", throwable, null, 8, null);
        }
        if ((throwable instanceof SSLHandshakeException) || (throwable instanceof SSLException)) {
            return new ApiException(ApiErrorCode.SSL_ERROR, "Secure connection failed", throwable, null, 8, null);
        }
        if ((throwable instanceof JsonSyntaxException) || (throwable instanceof JsonParseException) || (throwable instanceof JsonIOException)) {
            return new ApiException(ApiErrorCode.PARSE_ERROR, "Failed to parse server response", throwable, null, 8, null);
        }
        if (throwable instanceof IOException) {
            String message = throwable.getMessage();
            if (message == null) {
                message = "Network I/O error";
            }
            return new ApiException(-1000, message, throwable, null, 8, null);
        }
        String message2 = throwable.getMessage();
        if (message2 == null) {
            message2 = "Unknown error";
        }
        return new ApiException(-1, message2, throwable, null, 8, null);
    }
}
