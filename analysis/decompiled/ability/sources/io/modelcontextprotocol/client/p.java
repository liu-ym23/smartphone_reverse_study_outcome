package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import reactor.core.publisher.Mono;

/* loaded from: classes2.dex */
public final /* synthetic */ class p implements McpClientSession.RequestHandler {
    @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
    public final Mono handle(Object obj) {
        return McpAsyncClient.lambda$new$0(obj);
    }
}
