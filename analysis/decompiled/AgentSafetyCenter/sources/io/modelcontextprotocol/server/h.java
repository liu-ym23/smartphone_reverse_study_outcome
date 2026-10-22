package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements McpInitRequestHandler, McpStreamableServerSession.InitRequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6270a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncServer f6271b;

    public /* synthetic */ h(int i) {
        this.f6270a = i;
    }

    @Override // io.modelcontextprotocol.server.McpInitRequestHandler, io.modelcontextprotocol.spec.McpStreamableServerSession.InitRequestHandler
    public final Mono handle(McpSchema.InitializeRequest initializeRequest) {
        int i = this.f6270a;
        McpAsyncServer mcpAsyncServer = this.f6271b;
        switch (i) {
        }
        return mcpAsyncServer.asyncInitializeRequestHandler(initializeRequest);
    }
}
