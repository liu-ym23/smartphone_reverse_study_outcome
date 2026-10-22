package io.ktor.http;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/ktor/http/URLProtocol;", "", "isWebsocket", "(Lio/ktor/http/URLProtocol;)Z", "isSecure", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class URLProtocolKt {
    public static final boolean isSecure(URLProtocol uRLProtocol) {
        kotlin.jvm.internal.p.i(uRLProtocol, "<this>");
        return kotlin.jvm.internal.p.d(uRLProtocol.getName(), "https") || kotlin.jvm.internal.p.d(uRLProtocol.getName(), "wss");
    }

    public static final boolean isWebsocket(URLProtocol uRLProtocol) {
        kotlin.jvm.internal.p.i(uRLProtocol, "<this>");
        return kotlin.jvm.internal.p.d(uRLProtocol.getName(), "ws") || kotlin.jvm.internal.p.d(uRLProtocol.getName(), "wss");
    }
}
