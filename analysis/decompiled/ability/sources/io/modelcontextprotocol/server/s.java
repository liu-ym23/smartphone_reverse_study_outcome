package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class s implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4717a;
    public final /* synthetic */ McpSchema.CallToolRequest b;

    public /* synthetic */ s(McpSchema.CallToolRequest callToolRequest, int i) {
        this.f4717a = i;
        this.b = callToolRequest;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f4717a;
        McpSchema.CallToolRequest callToolRequest = this.b;
        switch (i) {
            case 0:
                return McpAsyncServer.lambda$toolsCallRequestHandler$17(callToolRequest, (McpServerFeatures.AsyncToolSpecification) obj);
            default:
                return McpStatelessAsyncServer.lambda$toolsCallRequestHandler$9(callToolRequest, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
        }
    }
}
