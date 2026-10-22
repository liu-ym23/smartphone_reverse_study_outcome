package com.stepos.core.ability.speech;

import com.stepos.core.common.cloud.CloudApiException;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.error.AIEngineError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseErrorMapper {
    public static final AsrSseErrorMapper INSTANCE = new AsrSseErrorMapper();

    private AsrSseErrorMapper() {
    }

    public final boolean isWorthRetry(int i10) {
        return (!AIEngineError.INSTANCE.isCloudRetryable(i10) || i10 == 270001 || i10 == 270009) ? false : true;
    }

    public final int toErrorCode(Throwable e10) {
        kotlin.jvm.internal.g.f(e10, "e");
        return e10 instanceof CloudApiException ? CloudHttpErrorMapper.INSTANCE.toErrorCode(Integer.valueOf(((CloudApiException) e10).getHttpCode())) : ((e10 instanceof UnknownHostException) || (e10 instanceof ConnectException) || (e10 instanceof NoRouteToHostException) || (e10 instanceof PortUnreachableException) || (e10 instanceof SSLException)) ? AIEngineError.CLOUD_NETWORK_ERROR : e10 instanceof InterruptedIOException ? AIEngineError.CLOUD_REQUEST_TIMEOUT : e10 instanceof IOException ? AIEngineError.CLOUD_STREAM_TRUNCATED : AIEngineError.CLOUD_SERVER_ERROR;
    }
}
