package io.ktor.client.engine.cio;

import Z8.C1173v;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "", "requiresDedicatedConnection", "(Lio/ktor/client/request/HttpRequestData;)Z", "containsCustomTimeouts", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EngineTasksKt {
    private static final boolean containsCustomTimeouts(HttpRequestData httpRequestData) {
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) httpRequestData.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig != null) {
            return (httpTimeoutConfig.get_connectTimeoutMillis() == null && httpTimeoutConfig.get_socketTimeoutMillis() == null) ? false : true;
        }
        return false;
    }

    public static final boolean requiresDedicatedConnection(HttpRequestData httpRequestData) {
        HttpMethod.Companion companion;
        p.i(httpRequestData, "<this>");
        List<Headers> listP = C1173v.p(httpRequestData.getHeaders(), httpRequestData.getBody().getHeaders());
        if (!(listP instanceof Collection) || !listP.isEmpty()) {
            for (Headers headers : listP) {
                HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
                if (p.d(headers.get(httpHeaders.getConnection()), "close") || headers.contains(httpHeaders.getUpgrade())) {
                    break;
                }
            }
            companion = HttpMethod.INSTANCE;
            if (C1173v.p(companion.getGet(), companion.getHead()).contains(httpRequestData.getMethod()) || containsCustomTimeouts(httpRequestData) || HttpRequestKt.isSseRequest(httpRequestData)) {
                break;
            }
            return false;
        }
        companion = HttpMethod.INSTANCE;
        if (C1173v.p(companion.getGet(), companion.getHead()).contains(httpRequestData.getMethod())) {
        }
        return true;
    }
}
