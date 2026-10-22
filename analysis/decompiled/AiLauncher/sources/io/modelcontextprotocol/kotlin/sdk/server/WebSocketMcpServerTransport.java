package io.modelcontextprotocol.kotlin.sdk.server;

import e9.InterfaceC4014c;
import io.ktor.http.HttpHeaders;
import io.ktor.server.websocket.WebSocketServerSession;
import io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransportKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0094@¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/WebSocketMcpTransport;", "Lio/ktor/server/websocket/WebSocketServerSession;", "session", "<init>", "(Lio/ktor/server/websocket/WebSocketServerSession;)V", "LY8/t;", "initializeSession", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/websocket/WebSocketServerSession;", "getSession", "()Lio/ktor/server/websocket/WebSocketServerSession;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketMcpServerTransport extends WebSocketMcpTransport {
    private final WebSocketServerSession session;

    public WebSocketMcpServerTransport(WebSocketServerSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        this.session = session;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport
    public Object initializeSession(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        String str = getSession().getCall().getRequest().getHeaders().get(HttpHeaders.INSTANCE.getSecWebSocketProtocol());
        if (kotlin.jvm.internal.p.d(str, WebSocketMcpTransportKt.MCP_SUBPROTOCOL)) {
            return Y8.t.f7040a;
        }
        throw new IllegalStateException(("Invalid subprotocol: " + str + ", expected mcp").toString());
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport
    public WebSocketServerSession getSession() {
        return this.session;
    }
}
