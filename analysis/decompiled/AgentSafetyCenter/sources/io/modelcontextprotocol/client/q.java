package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6139a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncClient f6140b;

    public /* synthetic */ q(int i) {
        this.f6139a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6139a;
        McpAsyncClient mcpAsyncClient = this.f6140b;
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
