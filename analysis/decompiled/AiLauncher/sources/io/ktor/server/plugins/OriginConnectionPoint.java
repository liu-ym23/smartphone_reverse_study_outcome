package io.ktor.server.plugins;

import La.C;
import La.H;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001c\u0010\u000bR\u0014\u0010 \u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000bR\u0014\u0010\"\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u0014\u0010$\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000bR\u0014\u0010&\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000bR\u0014\u0010.\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0014R\u0014\u00100\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000b¨\u00061"}, d2 = {"Lio/ktor/server/plugins/OriginConnectionPoint;", "Lio/ktor/http/RequestConnectionPoint;", "local", "", "hostHeaderValue", "<init>", "(Lio/ktor/http/RequestConnectionPoint;Ljava/lang/String;)V", "Lio/ktor/server/application/ApplicationCall;", "call", "(Lio/ktor/server/application/ApplicationCall;)V", "toString", "()Ljava/lang/String;", "Lio/ktor/http/RequestConnectionPoint;", "Ljava/lang/String;", "getScheme", "scheme", "getVersion", "version", "", "getPort", "()I", "getPort$annotations", "()V", "port", "getLocalPort", "localPort", "getServerPort", "serverPort", "getHost", "getHost$annotations", "host", "getLocalHost", "localHost", "getServerHost", "serverHost", "getLocalAddress", "localAddress", "getUri", "uri", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "method", "getRemoteHost", "remoteHost", "getRemotePort", "remotePort", "getRemoteAddress", "remoteAddress", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OriginConnectionPoint implements RequestConnectionPoint {
    private final String hostHeaderValue;
    private final RequestConnectionPoint local;

    public OriginConnectionPoint(RequestConnectionPoint local, String str) {
        p.i(local, "local");
        this.local = local;
        this.hostHeaderValue = str;
    }

    public static /* synthetic */ void getHost$annotations() {
    }

    public static /* synthetic */ void getPort$annotations() {
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getHost() {
        String strX1;
        String str = this.hostHeaderValue;
        return (str == null || (strX1 = H.x1(str, ServerSentEventKt.COLON, null, 2, null)) == null) ? this.local.getHost() : strX1;
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getLocalAddress() {
        return this.local.getLocalAddress();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getLocalHost() {
        return this.local.getLocalHost();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getLocalPort() {
        return this.local.getLocalPort();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public HttpMethod getMethod() {
        return this.local.getMethod();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getPort() {
        String strN1;
        Integer numW;
        String str = this.hostHeaderValue;
        return (str == null || (strN1 = H.n1(str, ServerSentEventKt.COLON, "80")) == null || (numW = C.w(strN1)) == null) ? this.local.getPort() : numW.intValue();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getRemoteAddress() {
        return this.local.getRemoteAddress();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getRemoteHost() {
        return this.local.getRemoteHost();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getRemotePort() {
        return this.local.getRemotePort();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getScheme() {
        return this.local.getScheme();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getServerHost() {
        return this.local.getServerHost();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public int getServerPort() {
        return this.local.getServerPort();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getUri() {
        return this.local.getUri();
    }

    @Override // io.ktor.http.RequestConnectionPoint
    public String getVersion() {
        return this.local.getVersion();
    }

    public String toString() {
        return "OriginConnectionPoint(uri=" + getUri() + ", method=" + getMethod() + ", version=" + getVersion() + ", localAddress=" + getLocalAddress() + ", localPort=" + getLocalPort() + ", remoteAddress=" + getRemoteAddress() + ", remotePort=" + getRemotePort() + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginConnectionPoint(ApplicationCall call) {
        this(call.getRequest().getLocal(), ApplicationRequestPropertiesKt.header(call.getRequest(), HttpHeaders.INSTANCE.getHost()));
        p.i(call, "call");
    }
}
