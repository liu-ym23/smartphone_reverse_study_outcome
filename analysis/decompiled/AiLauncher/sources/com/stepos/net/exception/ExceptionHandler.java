package com.stepos.net.exception;

import La.H;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/net/exception/ExceptionHandler;", "", "<init>", "()V", "handle", "Lcom/stepos/net/exception/ApiException;", "throwable", "", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExceptionHandler {
    public static final ExceptionHandler INSTANCE = new ExceptionHandler();

    private ExceptionHandler() {
    }

    public final ApiException handle(Throwable throwable) {
        p.i(throwable, "throwable");
        if (throwable instanceof ApiException) {
            return (ApiException) throwable;
        }
        if (throwable instanceof CancellationException) {
            return new ApiException(ApiErrorCode.CANCELED, "Request canceled", throwable, null, 8, null);
        }
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            int iA = httpException.a();
            String strC = httpException.c();
            if (H.x0(strC)) {
                strC = "HTTP " + httpException.a();
            }
            String str = strC;
            p.h(str, "ifBlank(...)");
            return new ApiException(iA, str, throwable, null, 8, null);
        }
        if (throwable instanceof SocketTimeoutException) {
            return new ApiException(-1001, "Request timed out, please try again", throwable, null, 8, null);
        }
        if ((throwable instanceof UnknownHostException) || (throwable instanceof ConnectException)) {
            return new ApiException(ApiErrorCode.NETWORK_UNAVAILABLE, "Network is unavailable, please check your connection", throwable, null, 8, null);
        }
        if ((throwable instanceof SSLHandshakeException) || (throwable instanceof SSLException)) {
            return new ApiException(-1002, "Secure connection failed", throwable, null, 8, null);
        }
        if ((throwable instanceof JsonSyntaxException) || (throwable instanceof JsonParseException) || (throwable instanceof JsonIOException)) {
            return new ApiException(ApiErrorCode.PARSE_ERROR, "Failed to parse server response", throwable, null, 8, null);
        }
        if (throwable instanceof IOException) {
            String message = throwable.getMessage();
            if (message == null) {
                message = "Network I/O error";
            }
            return new ApiException(ApiErrorCode.NETWORK_UNAVAILABLE, message, throwable, null, 8, null);
        }
        String message2 = throwable.getMessage();
        if (message2 == null) {
            message2 = "Unknown error";
        }
        return new ApiException(-1, message2, throwable, null, 8, null);
    }
}
