package io.ktor.server.cio;

import Ua.InterfaceC1083u;
import Ua.M;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentType;
import io.ktor.http.cio.Request;
import io.ktor.server.application.Application;
import io.ktor.server.engine.BaseApplicationCall;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u0012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0015\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lio/ktor/server/cio/CIOApplicationCall;", "Lio/ktor/server/engine/BaseApplicationCall;", "LUa/M;", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lio/ktor/http/cio/Request;", "_request", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lkotlin/coroutines/d;", "engineDispatcher", "appDispatcher", "LUa/u;", "", "upgraded", "Ljava/net/SocketAddress;", "Lio/ktor/util/network/NetworkAddress;", "remoteAddress", "localAddress", "coroutineContext", "<init>", "(Lio/ktor/server/application/Application;Lio/ktor/http/cio/Request;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;Lkotlin/coroutines/d;LUa/u;Ljava/net/SocketAddress;Ljava/net/SocketAddress;Lkotlin/coroutines/d;)V", "LY8/t;", "release$ktor_server_cio", "()V", "release", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lio/ktor/server/cio/CIOApplicationRequest;", "request", "Lio/ktor/server/cio/CIOApplicationRequest;", "getRequest", "()Lio/ktor/server/cio/CIOApplicationRequest;", "Lio/ktor/server/cio/CIOApplicationResponse;", UxipConstants.f30685x, "Lio/ktor/server/cio/CIOApplicationResponse;", "getResponse", "()Lio/ktor/server/cio/CIOApplicationResponse;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOApplicationCall extends BaseApplicationCall implements M {
    private final kotlin.coroutines.d coroutineContext;
    private final CIOApplicationRequest request;
    private final CIOApplicationResponse response;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOApplicationCall(Application application, Request _request, ByteReadChannel input, ByteWriteChannel output, kotlin.coroutines.d engineDispatcher, kotlin.coroutines.d appDispatcher, InterfaceC1083u<Boolean> interfaceC1083u, SocketAddress socketAddress, SocketAddress socketAddress2, kotlin.coroutines.d coroutineContext) {
        super(application);
        p.i(application, "application");
        p.i(_request, "_request");
        p.i(input, "input");
        p.i(output, "output");
        p.i(engineDispatcher, "engineDispatcher");
        p.i(appDispatcher, "appDispatcher");
        p.i(coroutineContext, "coroutineContext");
        this.coroutineContext = coroutineContext;
        this.request = new CIOApplicationRequest(this, socketAddress, socketAddress2, input, _request);
        this.response = new CIOApplicationResponse(this, output, input, engineDispatcher, appDispatcher, interfaceC1083u);
        BaseApplicationCall.putResponseAttribute$default(this, null, 1, null);
    }

    @Override // io.ktor.server.engine.BaseApplicationCall, io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    public final void release$ktor_server_cio() {
        getRequest().release$ktor_server_cio();
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall
    public CIOApplicationRequest getRequest() {
        return this.request;
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall
    public CIOApplicationResponse getResponse() {
        return this.response;
    }
}
