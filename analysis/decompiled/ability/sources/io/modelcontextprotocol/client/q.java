package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class q implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4645a;
    public final /* synthetic */ McpAsyncClient b;

    public /* synthetic */ q(McpAsyncClient mcpAsyncClient, int i) {
        this.f4645a = i;
        this.b = mcpAsyncClient;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4645a;
        McpAsyncClient mcpAsyncClient = this.b;
        switch (i) {
            case 0:
                return mcpAsyncClient.lambda$new$17((LifecycleInitializer.Initialization) obj);
            case 1:
                return mcpAsyncClient.lambda$listPrompts$59((McpSchema.ListPromptsResult) obj);
            case 2:
                return mcpAsyncClient.lambda$listTools$29((McpSchema.ListToolsResult) obj);
            case 3:
                return mcpAsyncClient.lambda$listResourceTemplates$45((McpSchema.ListResourceTemplatesResult) obj);
            default:
                return mcpAsyncClient.lambda$listResources$40((McpSchema.ListResourcesResult) obj);
        }
    }
}
