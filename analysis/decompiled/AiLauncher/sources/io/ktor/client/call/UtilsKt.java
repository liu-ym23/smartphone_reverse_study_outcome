package io.ktor.client.call;

import io.ktor.http.HttpMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "contentLength", "bodySize", "Lio/ktor/http/HttpMethod;", "method", "LY8/t;", "checkContentLength", "(Ljava/lang/Long;JLio/ktor/http/HttpMethod;)V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final void checkContentLength(Long l10, long j10, HttpMethod method) {
        p.i(method, "method");
        if (l10 == null || l10.longValue() < 0 || p.d(method, HttpMethod.INSTANCE.getHead()) || l10.longValue() == j10) {
            return;
        }
        throw new IllegalStateException(("Content-Length mismatch: expected " + l10 + " bytes, but received " + j10 + " bytes").toString());
    }
}
