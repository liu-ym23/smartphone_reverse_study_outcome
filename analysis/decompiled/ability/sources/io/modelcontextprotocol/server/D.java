package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class D implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4698a;
    public final /* synthetic */ McpTransportContext b;
    public final /* synthetic */ McpSchema.ReadResourceRequest c;

    public /* synthetic */ D(McpTransportContext mcpTransportContext, McpSchema.ReadResourceRequest readResourceRequest, int i) {
        this.f4698a = i;
        this.b = mcpTransportContext;
        this.c = readResourceRequest;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4698a) {
            case 0:
                return McpStatelessAsyncServer.lambda$resourcesReadRequestHandler$17(this.b, this.c, (McpStatelessServerFeatures.AsyncResourceSpecification) obj);
            default:
                return McpStatelessAsyncServer.lambda$resourcesReadRequestHandler$18(this.b, this.c, (McpStatelessServerFeatures.AsyncResourceTemplateSpecification) obj);
        }
    }
}
