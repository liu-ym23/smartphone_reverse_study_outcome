package io.ktor.http;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"Lio/ktor/http/Url;", "", "getAuthority", "(Lio/ktor/http/Url;)Ljava/lang/String;", "authority", "getProtocolWithAuthority", "protocolWithAuthority", "getEncodedUserAndPassword", "encodedUserAndPassword", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UrlKt {
    public static final String getAuthority(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        return getEncodedUserAndPassword(url) + URLUtilsKt.getHostWithPortIfSpecified(url);
    }

    public static final String getEncodedUserAndPassword(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        StringBuilder sb2 = new StringBuilder();
        URLUtilsKt.appendUserAndPassword(sb2, url.getEncodedUser(), url.getEncodedPassword());
        return sb2.toString();
    }

    public static final String getProtocolWithAuthority(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(url.getProtocol().getName());
        sb2.append("://");
        sb2.append(getEncodedUserAndPassword(url));
        if (url.getSpecifiedPort() == 0 || url.getSpecifiedPort() == url.getProtocol().getDefaultPort()) {
            sb2.append(url.getHost());
        } else {
            sb2.append(URLUtilsKt.getHostWithPort(url));
        }
        return sb2.toString();
    }
}
