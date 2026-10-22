package io.modelcontextprotocol.server;

import java.util.List;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements McpNotificationHandler {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ List f6288a;

    @Override // io.modelcontextprotocol.server.McpNotificationHandler
    public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$10(this.f6288a, mcpAsyncServerExchange, obj);
    }
}
