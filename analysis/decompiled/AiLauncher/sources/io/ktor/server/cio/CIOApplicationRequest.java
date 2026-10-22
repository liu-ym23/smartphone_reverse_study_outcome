package io.ktor.server.cio;

import La.H;
import Y8.h;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.QueryKt;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.http.cio.CIOHeaders;
import io.ktor.http.cio.Request;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.engine.BaseApplicationRequest;
import io.ktor.server.request.PipelineRequestKt;
import io.ktor.server.request.RequestCookies;
import io.ktor.utils.io.ByteReadChannel;
import java.net.SocketAddress;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\b8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010'R\u001a\u0010-\u001a\u00020,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lio/ktor/server/cio/CIOApplicationRequest;", "Lio/ktor/server/engine/BaseApplicationRequest;", "Lio/ktor/server/application/PipelineCall;", "call", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "remoteAddress", "localAddress", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/http/cio/Request;", "request", "<init>", "(Lio/ktor/server/application/PipelineCall;Ljava/net/SocketAddress;Ljava/net/SocketAddress;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/Request;)V", "LY8/t;", "release$ktor_server_cio", "()V", "release", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/cio/Request;", "Lio/ktor/server/request/RequestCookies;", "cookies$delegate", "LY8/h;", "getCookies", "()Lio/ktor/server/request/RequestCookies;", "cookies", "engineReceiveChannel", "getEngineReceiveChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/Headers;", "engineHeaders", "Lio/ktor/http/Headers;", "getEngineHeaders", "()Lio/ktor/http/Headers;", "setEngineHeaders", "(Lio/ktor/http/Headers;)V", "Lio/ktor/http/Parameters;", "queryParameters$delegate", "getQueryParameters", "()Lio/ktor/http/Parameters;", "queryParameters", "rawQueryParameters$delegate", "getRawQueryParameters", "rawQueryParameters", "Lio/ktor/http/RequestConnectionPoint;", "local", "Lio/ktor/http/RequestConnectionPoint;", "getLocal", "()Lio/ktor/http/RequestConnectionPoint;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOApplicationRequest extends BaseApplicationRequest {

    /* renamed from: cookies$delegate, reason: from kotlin metadata */
    private final h cookies;
    private Headers engineHeaders;
    private final ByteReadChannel engineReceiveChannel;
    private final ByteReadChannel input;
    private final RequestConnectionPoint local;

    /* renamed from: queryParameters$delegate, reason: from kotlin metadata */
    private final h queryParameters;

    /* renamed from: rawQueryParameters$delegate, reason: from kotlin metadata */
    private final h rawQueryParameters;
    private final Request request;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOApplicationRequest(PipelineCall call, SocketAddress socketAddress, SocketAddress socketAddress2, ByteReadChannel input, Request request) {
        super(call);
        p.i(call, "call");
        p.i(input, "input");
        p.i(request, "request");
        this.input = input;
        this.request = request;
        this.cookies = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.cio.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CIOApplicationRequest.cookies_delegate$lambda$0(this.f33348a);
            }
        });
        this.engineReceiveChannel = input;
        this.engineHeaders = new CIOHeaders(request.getHeaders());
        this.queryParameters = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.cio.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CIOApplicationRequest.queryParameters_delegate$lambda$1(this.f33358a);
            }
        });
        this.rawQueryParameters = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.cio.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CIOApplicationRequest.rawQueryParameters_delegate$lambda$3(this.f33359a);
            }
        });
        String string = request.getVersion().toString();
        String string2 = request.getUri().toString();
        CharSequence charSequence = request.getHeaders().get(HttpHeaders.INSTANCE.getHost());
        this.local = new CIOConnectionPoint(socketAddress, socketAddress2, string, string2, charSequence != null ? charSequence.toString() : null, HttpMethod.INSTANCE.parse(request.getMethod().getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestCookies cookies_delegate$lambda$0(CIOApplicationRequest cIOApplicationRequest) {
        return new RequestCookies(cIOApplicationRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Parameters queryParameters_delegate$lambda$1(CIOApplicationRequest cIOApplicationRequest) {
        return CIOApplicationRequestKt.toQueryParameters(PipelineRequestKt.encodeParameters(cIOApplicationRequest, cIOApplicationRequest.getRawQueryParameters()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Parameters rawQueryParameters_delegate$lambda$3(CIOApplicationRequest cIOApplicationRequest) {
        String string = cIOApplicationRequest.request.getUri().toString();
        Integer numValueOf = Integer.valueOf(H.t0(string, '?', 0, false, 6, null));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        return numValueOf != null ? QueryKt.parseQueryString$default(string, numValueOf.intValue() + 1, 0, false, 4, null) : Parameters.INSTANCE.getEmpty();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RequestCookies getCookies() {
        return (RequestCookies) this.cookies.getValue();
    }

    @Override // io.ktor.server.engine.BaseApplicationRequest
    public Headers getEngineHeaders() {
        return this.engineHeaders;
    }

    @Override // io.ktor.server.engine.BaseApplicationRequest
    public ByteReadChannel getEngineReceiveChannel() {
        return this.engineReceiveChannel;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RequestConnectionPoint getLocal() {
        return this.local;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Parameters getQueryParameters() {
        return (Parameters) this.queryParameters.getValue();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Parameters getRawQueryParameters() {
        return (Parameters) this.rawQueryParameters.getValue();
    }

    public final void release$ktor_server_cio() {
        this.request.release();
    }

    public void setEngineHeaders(Headers headers) {
        p.i(headers, "<set-?>");
        this.engineHeaders = headers;
    }
}
