package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4708a;
    public final /* synthetic */ McpAsyncServerExchange b;
    public final /* synthetic */ McpSchema.ReadResourceRequest c;

    public /* synthetic */ h(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest, int i) {
        this.f4708a = i;
        this.b = mcpAsyncServerExchange;
        this.c = readResourceRequest;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4708a) {
            case 0:
                return McpAsyncServer.lambda$resourcesReadRequestHandler$25(this.b, this.c, (McpServerFeatures.AsyncResourceSpecification) obj);
            default:
                return McpAsyncServer.lambda$resourcesReadRequestHandler$26(this.b, this.c, (McpServerFeatures.AsyncResourceTemplateSpecification) obj);
        }
    }
}
