package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import reactor.core.publisher.Mono;

/* loaded from: classes2.dex */
public final /* synthetic */ class t implements McpClientSession.RequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4647a;
    public final /* synthetic */ McpAsyncClient b;

    public /* synthetic */ t(McpAsyncClient mcpAsyncClient, int i) {
        this.f4647a = i;
        this.b = mcpAsyncClient;
    }

    @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
    public final Mono handle(Object obj) {
        int i = this.f4647a;
        McpAsyncClient mcpAsyncClient = this.b;
        switch (i) {
            case 0:
                return mcpAsyncClient.lambda$elicitationCreateHandler$26(obj);
            case 1:
                return mcpAsyncClient.lambda$rootsListRequestHandler$24(obj);
            default:
                return mcpAsyncClient.lambda$samplingCreateMessageHandler$25(obj);
        }
    }
}
