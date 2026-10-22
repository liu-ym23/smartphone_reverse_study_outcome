package io.modelcontextprotocol.client;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpNotificationHandler;
import io.modelcontextprotocol.server.McpRequestHandler;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import java.time.Duration;
import java.util.HashMap;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6141a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6142b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6143c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f6144d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f6145e;

    public /* synthetic */ r(int i) {
        this.f6141a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6141a) {
            case 0:
                return McpAsyncClient.lambda$new$19((Duration) this.f6142b, (McpClientTransport) this.f6143c, (HashMap) this.f6144d, (HashMap) this.f6145e, (ContextView) obj);
            case 1:
                return ((McpClientSession) this.f6142b).lambda$sendRequest$11((String) this.f6143c, (String) this.f6144d, this.f6145e, (ContextView) obj);
            case 2:
                return ((McpServerSession) this.f6142b).lambda$handleIncomingNotification$11((McpNotificationHandler) this.f6143c, (McpTransportContext) this.f6144d, (McpSchema.JSONRPCNotification) this.f6145e, (McpAsyncServerExchange) obj);
            default:
                return ((McpServerSession) this.f6142b).lambda$handleIncomingRequest$7((McpRequestHandler) this.f6143c, (McpTransportContext) this.f6144d, (McpSchema.JSONRPCRequest) this.f6145e, (McpAsyncServerExchange) obj);
        }
    }
}
