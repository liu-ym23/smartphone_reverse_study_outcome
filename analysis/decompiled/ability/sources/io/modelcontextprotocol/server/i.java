package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements McpInitRequestHandler, McpStreamableServerSession.InitRequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4709a;
    public final /* synthetic */ McpAsyncServer b;

    public /* synthetic */ i(McpAsyncServer mcpAsyncServer, int i) {
        this.f4709a = i;
        this.b = mcpAsyncServer;
    }

    @Override // io.modelcontextprotocol.server.McpInitRequestHandler, io.modelcontextprotocol.spec.McpStreamableServerSession.InitRequestHandler
    public final Mono handle(McpSchema.InitializeRequest initializeRequest) {
        int i = this.f4709a;
        McpAsyncServer mcpAsyncServer = this.b;
        switch (i) {
        }
        return mcpAsyncServer.asyncInitializeRequestHandler(initializeRequest);
    }
}
