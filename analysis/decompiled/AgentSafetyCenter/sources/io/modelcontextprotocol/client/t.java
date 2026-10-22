package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements McpClientSession.RequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6146a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncClient f6147b;

    public /* synthetic */ t(int i) {
        this.f6146a = i;
    }

    @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
    public final Mono handle(Object obj) {
        int i = this.f6146a;
        McpAsyncClient mcpAsyncClient = this.f6147b;
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
