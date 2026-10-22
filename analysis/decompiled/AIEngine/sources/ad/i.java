package ad;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class i {
    public static final b Companion = new b();
    public static final i NONE = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends i {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        i b(okhttp3.internal.connection.d dVar);
    }

    public void cacheConditionalHit(ad.b call, Response cachedResponse) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(cachedResponse, "cachedResponse");
    }

    public void cacheHit(ad.b call, Response response) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(response, "response");
    }

    public void cacheMiss(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void callEnd(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void callFailed(ad.b call, IOException ioe) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(ioe, "ioe");
    }

    public void callStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void canceled(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void connectEnd(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
    }

    public void connectFailed(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
        kotlin.jvm.internal.g.f(ioe, "ioe");
    }

    public void connectStart(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
    }

    public void connectionAcquired(ad.b call, d connection) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(connection, "connection");
    }

    public void connectionReleased(ad.b call, d connection) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(connection, "connection");
    }

    public void dnsEnd(ad.b call, String domainName, List<InetAddress> inetAddressList) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(domainName, "domainName");
        kotlin.jvm.internal.g.f(inetAddressList, "inetAddressList");
    }

    public void dnsStart(ad.b call, String domainName) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(domainName, "domainName");
    }

    public void proxySelectEnd(ad.b call, okhttp3.g url, List<Proxy> proxies) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(proxies, "proxies");
    }

    public void proxySelectStart(ad.b call, okhttp3.g url) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(url, "url");
    }

    public void requestBodyEnd(ad.b call, long j10) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void requestBodyStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void requestFailed(ad.b call, IOException ioe) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(ioe, "ioe");
    }

    public void requestHeadersEnd(ad.b call, okhttp3.h request) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(request, "request");
    }

    public void requestHeadersStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void responseBodyEnd(ad.b call, long j10) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void responseBodyStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void responseFailed(ad.b call, IOException ioe) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(ioe, "ioe");
    }

    public void responseHeadersEnd(ad.b call, Response response) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(response, "response");
    }

    public void responseHeadersStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void satisfactionFailure(ad.b call, Response response) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(response, "response");
    }

    public void secureConnectEnd(ad.b call, Handshake handshake) {
        kotlin.jvm.internal.g.f(call, "call");
    }

    public void secureConnectStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
    }
}
